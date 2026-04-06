package models;

public enum ValidationResponseEnum {
    SUCCESS,
    LENGTH_LESS_THAN_11,
    INVALID_EGYPT_PHONE,
    LENGTH_LESS_THAN_3,
    USERNAME_FIRST_CHAR_NOT_UPPERCASE,
    AGE_LESS_THAN_18,
    FAILED,
    NON_NUMERIC
}
