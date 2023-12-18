package com.tanphuong.milktea.authorization.data;

import android.util.Patterns;

public final class AuthorizationValidator {
    public static boolean checkPhoneValid(String phoneNumber) {
        return Patterns.PHONE.matcher(phoneNumber).matches();
    }

    public static boolean checkEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
