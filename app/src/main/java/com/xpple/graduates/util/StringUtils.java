package com.xpple.graduates.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    /**
     * 判断电话号码是否有效
     *
     * @return true 有效 / false 无效
     */
    public static boolean isPhoneNumberValid(String phoneNumber) {

        boolean isValid = false;

        String expression = "((^(13|14|15|17|18)[0-9]{9}$)|(^0[1,2]\\d-?\\d{8}$)|(^0[3-9] \\d{2}-?\\d{7,8}$)|(^0[1,2]\\d-?\\d{8}-(\\d{1,4})$)|(^0[3-9]\\d{2}-? \\d{7,8}-(\\d{1,4})$))";

        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
}
