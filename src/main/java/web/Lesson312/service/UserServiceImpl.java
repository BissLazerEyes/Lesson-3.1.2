package web.Lesson312.service;

import web.Lesson312.dao.UserDao;
import web.Lesson312.model.Role;
import web.Lesson312.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDAO, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userDao = userDAO;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        addDefaultUser();
    }

    @Override
    public User passwordCoder(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(passwordCoder(user));
    }

    @Override
    public void removeUser(long id) {
        userDao.removeUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(passwordCoder(user));
    }

    @Override
    public User getUserByLogin(String username) {
       return userDao.getUserByLogin(username);
    }

    @Override
    public void addDefaultUser() {
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(roleService.findById(1L));
            Set<Role> roleSet2 = new HashSet<>();
            roleSet2.add(roleService.findById(1L));
            roleSet2.add(roleService.findById(2L));
            User user = new User("Marie", "Smith", (byte) 14, "user@mail.ru", "user", "12345", roleSet);
            User admin = new User("Edvard", "Blair", (byte) 37, "admin@mail.ru", "admin", "admin", roleSet2);
            addUser(user);
            addUser(admin);
    }
}