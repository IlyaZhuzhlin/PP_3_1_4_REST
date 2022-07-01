package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();

   public void saveUser(User user);

  public User getUser(int id);

  public void deleteUser(int id);
  public void updateUser(User user, int id);

  public User findByUsername(String username);
}
