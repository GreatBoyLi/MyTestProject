package com.peng.wen.springbootstudy.exception;

import com.peng.wen.springbootstudy.pojo.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Ajax访问异常捕获
 * @author liwpb
 */
//@RestControllerAdvice
public class PengAjaxExceptionHandler {

    /**
     * Ajax访问异常捕获
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
   // @ExceptionHandler(value = Exception.class)
    public JsonResult defaultErrorHandler(HttpServletRequest request,
                                          Exception e)throws Exception{
        e.printStackTrace();
        return JsonResult.errorException(e.getMessage());
    }
}
