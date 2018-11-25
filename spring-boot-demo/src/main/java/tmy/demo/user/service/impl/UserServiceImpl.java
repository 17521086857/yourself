package tmy.demo.user.service.impl;

import tmy.demo.user.mapper.UserMapper;
import tmy.demo.user.model.User;
import tmy.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaihui
 * @date 2018/1/29
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findList() {
        return userMapper.selectAll();
    }

    @Override
    public User findById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int save(User user) {
        if (user.getId() != null) {
            return userMapper.updateByPrimaryKey(user);
        } else {
            return userMapper.insert(user);
        }
    }

    @Override
    public User findOne(User user) {
        return userMapper.selectOne(user);
    }

	@Override
	public PageInfo<User> findPage(Map<String, Object> map , Integer pageIndex, Integer pageSize) {
		 PageHelper.startPage(pageIndex, pageSize);
		List<User> users = userMapper.findPage(map);
		PageInfo<User> pageInfo = new PageInfo<User>(users);
	
		return pageInfo;
	}

	/*@Override
	public  PageInfo<Map<String, Object>> testPro(Integer pageIndex, Integer pageSize) {
		 PageHelper.startPage(pageIndex, pageSize);
		List<Map<String, Object>> testPro = userMapper.testPro();
		 PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(testPro);
		return pageInfo;
	}*/
}
