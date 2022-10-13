package web.Lesson312.security;

import web.Lesson312.dao.UserDao;
import web.Lesson312.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service()
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    UserDao userDao;

    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.getUserByLogin(s);
        if(user == null){
            throw new UsernameNotFoundException("user not found");
        }
        return user;
    }
}