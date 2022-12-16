package service.serviceImpl;

import model.Book;
import model.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;


public class UserServiceImpl implements UserService {
    List<User> userList = new ArrayList<>();
    @Override
    public String createUser(List<User> users) {
        userList.addAll(users);
        return "Uspeshno:";
    }

    @Override
    public List<User> findAllUsers() {
        return userList;
    }

    @Override
    public User findUserById(Long id) {
        return null;
    }

    @Override
    public String removeUserByName(String name) {
        return null;
    }

    @Override
    public void updateUser(Long id) {

    }

    @Override
    public void groupUsersByGender() {

    }

    @Override
    public String buyBooks(String name, List<Book> books) {
        return null;
    }
}
