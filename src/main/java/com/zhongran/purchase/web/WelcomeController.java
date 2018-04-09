package com.zhongran.purchase.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhongran.purchase.entity.GroupBasic;

@Controller
public class WelcomeController {
	 // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";
    @Value("${service.telephone}")
    private String serviceTelephone = "啊啊啊啊";
    @Value("${service.QQ}")
    private String serviceQQ;
    @Value("${service.WX}")
    private String serviceWX;
    @Value("${service.PhoneNumb}")
    private String servicePhoneNumb; 
    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        model.put("serviceTelephone", this.serviceTelephone);
        model.put("serviceQQ", this.serviceQQ);
        model.put("serviceWX", this.serviceWX);
        model.put("servicePhoneNumb", this.servicePhoneNumb);
        return "welcome";
    }
    @RequestMapping("/admin")
    public String admin(Map<String, Object> model) {
        model.put("message", this.message);
        return "admin";
    }
}
