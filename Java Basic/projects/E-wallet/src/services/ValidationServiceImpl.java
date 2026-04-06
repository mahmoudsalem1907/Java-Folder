package services;

import models.Account;
import models.ValidationResponseEnum;

public class ValidationServiceImpl implements ValidationService {
    @Override
    public ValidationResponseEnum phoneValidate(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return ValidationResponseEnum.FAILED;
        }

        // check numeric
        if (!phoneNumber.matches("\\d+")) {
            return ValidationResponseEnum.NON_NUMERIC;
        }

        // check length
        if (phoneNumber.length() != 11) {
            return ValidationResponseEnum.LENGTH_LESS_THAN_11;
        }

        // egypt phone validation
        if (!phoneNumber.matches("^01[0125][0-9]{8}$")) {
            return ValidationResponseEnum.INVALID_EGYPT_PHONE;
        }

        return ValidationResponseEnum.SUCCESS;
    }

    @Override
    public ValidationResponseEnum ageValidate(int age) {

        if (age < 18) {
            return ValidationResponseEnum.AGE_LESS_THAN_18;
        }
        return ValidationResponseEnum.SUCCESS;
    }

    @Override
    public ValidationResponseEnum usernameAndPasswordValidate(String username) {
        if (username.length() < 3) {

            return ValidationResponseEnum.LENGTH_LESS_THAN_3;
        }

        if(!Character.isUpperCase(username.charAt(0))){
            return ValidationResponseEnum.USERNAME_FIRST_CHAR_NOT_UPPERCASE;
        }
        return ValidationResponseEnum.SUCCESS;

    }

}
