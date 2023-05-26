package lehieunghia.springboot.buoi2.Utils;

import lehieunghia.springboot.buoi2.model.CustomUserDetail;
import lehieunghia.springboot.buoi2.model.User;
import lehieunghia.springboot.buoi2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetail(user, userRepository);
    }
}
