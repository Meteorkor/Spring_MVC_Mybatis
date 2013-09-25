package com.meteor.dao;

import java.util.List;




import org.apache.ibatis.session.SqlSession;

import com.meteor.model.User;

public class UserDAO {

	private SqlSession sqlSession;    
    
    public void setSqlSession(SqlSession sqlSession)
    {
        this.sqlSession = sqlSession;
    }
  
  public List<User> SelectAllUser() 
 {  
	  
     return sqlSession.selectList("User.selectUser_all");
  } 
  public User SelectUser(int id) 
  {  
 	  
      return sqlSession.selectOne("User.selectUser",id);
   } 
	/**/
  public void InsertUser(User user) 
  {  
 	  
      sqlSession.insert("User.insertUser", user);
      
   } 
  public void UpdateUser(User user) 
  {  
 	  
      sqlSession.insert("User.updateUser", user);
      
   }
  
  
}
