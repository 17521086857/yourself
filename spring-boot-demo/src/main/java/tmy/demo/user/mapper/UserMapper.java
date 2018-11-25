package tmy.demo.user.mapper;


import org.springframework.stereotype.Repository;
import tmy.demo.user.model.User;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import tmy.demo.common.uitl.MllMapper;
@Repository
public interface UserMapper extends MllMapper<User> {

	List<User> findPage(Map<String, Object> map);
	@Select("call selStu")
	List<Map<String, Object>> testPro();

}