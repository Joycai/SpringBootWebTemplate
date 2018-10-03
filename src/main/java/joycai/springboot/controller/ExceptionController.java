package joycai.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理
 */
@ControllerAdvice
public class ExceptionController {
    static Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    /**
     * 该方法捕获所有exception类型异常，并返回自定义结果，可以按照需要修改捕获的类型来分类处理各类异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity exceptionHandler(Exception e){

        return new ResponseEntity(e.getMessage(), HttpStatus.OK);
    }
}
