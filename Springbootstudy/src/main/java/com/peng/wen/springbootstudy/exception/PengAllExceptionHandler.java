package com.peng.wen.springbootstudy.exception;

import com.peng.wen.springbootstudy.pojo.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Web跳转异常、Ajax异常都可以捕获
 * @author liwpb
 */
@ControllerAdvice
public class PengAllExceptionHandler {

    public static final String ERROR_VIEW = "/error";

    /**
     * 判断是Ajax请求还是普通的，如果是Ajax错误，进行Ajax处理，如果是普通的异常，进行页面跳转处理
     * @param request 请求
     * @param response 回应
     * @param e 异常
     * @return Object
     * @throws Exception 异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object errorHandler(HttpServletRequest request,
                               HttpServletResponse response, Exception e)throws Exception{
        e.printStackTrace();
        if (isAjax(request)){
            return JsonResult.errorException(e.getMessage());
        }else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url",request.getRequestURL());
            mav.setViewName(ERROR_VIEW);

            return mav;
        }
    }

    /**
     * 判断是否是Ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request){
        return (request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }
}
