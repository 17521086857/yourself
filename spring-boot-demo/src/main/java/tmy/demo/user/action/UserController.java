package tmy.demo.user.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import tmy.demo.common.uitl.annotation.CheckToken;
import tmy.demo.user.model.User;
import tmy.demo.user.service.UserService;
@Api(value = "用户API")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "获得用户列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/list")
    @CheckToken
    List<User> getAllUsers() {
        return userService.findList();
    }

    @ApiOperation(value = "获得用户用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    User getUser(@ApiParam("用户ID,必选") @RequestParam(value = "id", required = true) @PathParam("id") String id) {
        return userService.findById(id);
    }

    @PostMapping("/save")
    List<User> add(@RequestBody User user) {
        userService.save(user);
        return userService.findList();
    }
    
    @GetMapping("/page")
    PageInfo<User> findPage(String name, String nickName,
    		@RequestParam(value="pageSizee",defaultValue="10") Integer pageSize,
    		@RequestParam(value="pageIndexx",defaultValue="0") Integer pageIndex){
    	Map<String,Object> map = new HashMap<String, Object>();
    	System.out.println("name:"+name);
    	map.put("name", name);
    	map.put("nickName", nickName);
    	//map.put("pageSize", pageSize);
    	//map.put("pageIndex", pageIndex*pageSize);
    	return userService.findPage(map,pageIndex*pageSize,pageSize);
    }
}