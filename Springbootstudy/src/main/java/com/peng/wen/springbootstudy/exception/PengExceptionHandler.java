package com.peng.wen.springbootstudy.exception;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SpringBoot 配置全局的异常捕获
 * @author liwpb
 */
//@ControllerAdvice
public class PengExceptionHandler {

    public static final String ERROR_VIEW = "/error";

    /**
     * 获取全局异常
     * @param request 请求
     * @param response 回应
     * @param e 异常
     * @return 返回错误界面
     * @throws Exception 异常
     */
    //@ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request,
                               HttpServletResponse response, Exception e) throws  Exception{
        e.printStackTrace();

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url",request.getRequestURL());
        mav.setViewName(ERROR_VIEW);
        return mav;
    }
}
