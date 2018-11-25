package tmy.demo.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tmy.demo.common.uitl.annotation.CheckToken;
import tmy.demo.user.model.User;
import tmy.demo.user.service.UserService;
import org.springframework.validation.support.BindingAwareModelMap;

import java.util.List;

@Controller
@RequestMapping("/thyme")
public class ThymeleafAction {
    @Autowired
    UserService userService;

    @RequestMapping("/thyme")
    @CheckToken(auth = "1xx")
    public String tt(BindingAwareModelMap model,User user,String s){
       model.addAttribute("f","th:thymeleaflll这样吧世博会");
        List<User> list = userService.findList();
        model.addAttribute("users",list);
        return "index";
    }
}
