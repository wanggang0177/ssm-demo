package ssm.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import ssm.demo.dao.UserMapper;
import ssm.demo.model.User;

@Service
public class ServiceImpl implements IService 
{

	@Autowired
	private UserMapper userMapper;

	public String getData(){
		List<User> jsonList=new ArrayList<User>();
		User user = userMapper.selectByPrimaryKey(1);
		if(user != null)
		{
			jsonList.add(user);
		}
		return JSON.toJSONString(jsonList, SerializerFeature.WriteMapNullValue);
	}
	
	public int insert(User record) {
		return userMapper.insert(record);
	}

	public int deleteByPrimaryKey(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}

	public User selectByPrimaryKey(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	
	

}
