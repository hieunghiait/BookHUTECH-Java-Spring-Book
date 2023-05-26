package lehieunghia.springboot.buoi2.service;

import lehieunghia.springboot.buoi2.model.User;
import lehieunghia.springboot.buoi2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {
    void save(User user);
}
