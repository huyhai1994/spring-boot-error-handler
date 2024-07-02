package com.codegym.demo2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HandlerController implements ErrorController {
    /*TODO: Bước 2: Xây dựng HandlerController xử lý Exception*/
    /*TODO: @RequestMapping("/error") thực hiện xử lý cho uri /error
        (tức là thực hiện xử lý lỗi), ta có thể dựa vào request
        để check status code (404, 500…) hoặc lấy các parameter
        để trả về trang lỗi thích hợp, ở đây ta mặc định trả về trang error.html.*/
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        /*TODO:  Ở đây ta dựa theo HTTP status code trong request
            để trả về trang lỗi thích hợp, ví dụ với status code = 404 thì ta sẽ trả về trang error_404.html*/
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error_404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error_500";
            }
        }
        return "error";
    }

}
