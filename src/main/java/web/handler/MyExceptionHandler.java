package web.handler;


import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import web.exception.CustomException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice()
public class MyExceptionHandler {

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     *
     * @param binder
     */
    @InitBinder
    public void initWebBinder(WebDataBinder binder) {

    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     *
     * @param model
     */
    @ModelAttribute
    public void addAttribute(Model model) {
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model");
        model.addAttribute("attribute", "测试值");
    }

    /**
     * 捕获CustomException
     *
     * @param e
     * @return json格式类型
     */
    @ResponseBody
    @ExceptionHandler({CustomException.class}) //指定拦截异常的类型
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //自定义浏览器返回状态码
    public String customExceptionHandler(CustomException e) {
        String errorStr = "code = " + e.getCode() + "message = " +e.getMsg();
        System.out.println("============" + errorStr);
        return errorStr;
    }
}
