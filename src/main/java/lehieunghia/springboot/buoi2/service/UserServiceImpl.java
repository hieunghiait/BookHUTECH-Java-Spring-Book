package lehieunghia.springboot.buoi2.service;

import lehieunghia.springboot.buoi2.model.User;
import lehieunghia.springboot.buoi2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserRepository userRepository;
    public void save(User user){
        userRepository.save(user);
    }
}
