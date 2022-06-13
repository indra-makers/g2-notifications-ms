package com.co.indra.coinmarketcap.notifications.services;
import com.co.indra.coinmarketcap.notifications.config.ErrorCodes;
import com.co.indra.coinmarketcap.notifications.exceptions.BusinessException;
import com.co.indra.coinmarketcap.notifications.model.entities.Users;
import com.co.indra.coinmarketcap.notifications.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_PHONE_NUMBER_REGEX = Pattern.compile("\\+(9[976]\\d|8[987530]\\d|6[987]\\d|5[90]\\d|42\\d|3[875]\\d|\n" +
            "2[98654321]\\d|9[8543210]|8[6421]|6[6543210]|5[87654321]|\n" +
            "4[987654310]|3[9643210]|2[70]|7|1)\\d{1,14}$");
    private static boolean validateEmail(String x){
        Matcher match = VALID_EMAIL_ADDRESS_REGEX.matcher(x);
        return match.find();
    }
    private static boolean validatePhoneNumber(String x){
        Matcher match = VALID_PHONE_NUMBER_REGEX.matcher(x);
        return match.find();
    }

    public void registerUser(Users user) {
        if(user.getUserId().isEmpty() || user.getUserId().isBlank()){
            throw new BusinessException(ErrorCodes.USER_ADDITION_ID_EMPTY);
        }else{
            if(this.getUserById(user.getUserId()).size()!=0){
                throw new BusinessException(ErrorCodes.USER_ADDITION_EXISTS);
            }else {
                if (!validateEmail(user.getMailUser())) {
                    throw new BusinessException(ErrorCodes.USER_ADDRESS_PHONE_INVALID_INPUT);
                }
                if (!validatePhoneNumber(user.getPhoneNumber())) {
                    throw new BusinessException(ErrorCodes.USER_ADDRESS_PHONE_INVALID_INPUT);
                }
                usersRepository.addUser(user);
            }
        }
    }

    public List<Users> getUserById(String userId) {
        return usersRepository.listUserById(userId);
    }

    public List<Users> getAllUsers(){
        return usersRepository.listAllUsers();
    }

    public void saveNotificacionUser(Users users){
        usersRepository.addUser(users);
    }
}
