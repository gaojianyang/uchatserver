package com.xiri.uchatserver.config;


import com.xiri.uchatserver.utils.RedisUtils;
import com.xiri.uchatserver.utils.TokenUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TokenInterceptor类（拦截器）
 *
 * <p>
 * <b>History:</b>
 * <table border="1">
 * <tr>
 * <th>Date</th>
 * <th>Operator</th>
 * <th>Memo</th>
 * </tr>
 * <tr>
 * <td>2021/8/30 16:25</td>
 * <td>zrc</td>
 * <td>Create</td>
 * </tr>
 * </table>
 *
 * @author zrc
 * @version 1.0.0
 * @since 1.0.0
 */

@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisUtils redisUtils;

    //    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        //跨域请求会首先发一个option请求，直接返回正常状态并通过拦截器
//        if(request.getMethod().equals("OPTIONS")){
//            response.setStatus(HttpServletResponse.SC_OK);
//            return true;
//        }
//        response.setCharacterEncoding("utf-8");
//        String token = request.getHeader("token");
//        if (token!=null){
//            boolean result= TokenUtils.verify(token);
//            if (result){
//                System.out.println("通过拦截器");
//                return true;
//            }
//        }
//        response.setContentType("application/json; charset=utf-8");
//        try {
//            JSONObject json=new JSONObject();
//            json.put("msg","token verify fail");
//            json.put("code","500");
//            response.getWriter().append(json.toString());
//            System.out.println("认证失败，未通过拦截器");
//        } catch (Exception e) {
//            return false;
//        }
//        /**
//         * 还可以在此处检验用户存不存在等操作
//         */
//        return false;
//    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //跨域请求会首先发一个option请求，直接返回正常状态并通过拦截器
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("Authorization");
        if (token != null) {
//            boolean result= TokenUtils.verify(token);
//            if (result){
//                System.out.println("通过拦截器");
//                return true;
//            }
            //改造
            System.out.println("想要的token" + token);
            if (TokenUtils.verify(token)) {
                System.out.println("通过拦截器");
                return true;
            } else {
                System.out.println("已存在一个token,未通过拦截器");
                throw new BaseException(BaseErrorEnum.USER_INVALID);
            }
        }
        response.setContentType("application/json; charset=utf-8");
        try {
            JSONObject json = new JSONObject();
            json.put("message", "token效验失败");
            json.put("code", "500");
            response.getWriter().append(json.toString());
            System.out.println("认证失败，未通过拦截器");
        } catch (Exception e) {
            return false;
        }
        /**
         * 还可以在此处检验用户存不存在等操作
         */
        return false;
    }
}
