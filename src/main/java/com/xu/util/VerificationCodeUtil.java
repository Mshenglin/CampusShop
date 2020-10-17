package com.xu.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Dell
 */
public class VerificationCodeUtil {
    /**
     * 验证码对比
     * @param request
     * @return
     */
    public static boolean verificationCodeComparison(HttpServletRequest request){
        //动态生成的验证码
        String verifcationCodeSession = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        //获取前台的验证码
        String verifyCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual");
        if (verifyCodeActual==null|| !verifyCodeActual.equalsIgnoreCase(verifcationCodeSession)){
            return false;
        }
        return true;
    }
}