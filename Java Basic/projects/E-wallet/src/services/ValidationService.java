package services;

import models.Account;
import models.ValidationResponseEnum;

public interface ValidationService {
    ValidationResponseEnum usernameAndPasswordValidate(String username);
    ValidationResponseEnum ageValidate(int age);
    ValidationResponseEnum phoneValidate(String PhoneNumber);
}
