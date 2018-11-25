package tmy.demo.user.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import tmy.demo.user.model.User;

/**
 * @author zhaihui
 * @date 2018/1/29
 */
public interface UserService {

    List<User> findList();

    User findById(String id);

    int save(User user);


    User findOne(User user);

    PageInfo<User> findPage(Map<String, Object> map, Integer pageIndex, Integer pageSize);
    
   
}
