package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import web.exception.CustomException;

@Controller
@RequestMapping("/home")
public class IndexController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    /**
    *
    */
    @RequestMapping("/index")
    public String index(){
        logger.info("index 运行中");
        return "index";
    }

    /**
     * 测试异常类
     * */
    @RequestMapping("/testError")
    public String testError(ModelMap modelMap ) {
        throw new CustomException(400L, "系统发生500异常！" + modelMap.get("attribute"));
    }
}
