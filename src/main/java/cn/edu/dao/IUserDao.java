package cn.edu.dao;

import cn.edu.bean.User;

import java.util.List;

/**
 * @author LZDWTL
 * @date 2021-06-07 19:57
 */
public interface IUserDao {
    List<User> viewUser();
    void deleteUser(int id);
    void updateUser(User user);
    void addUser(User user);
    List<User> selectUser(String username);
}
