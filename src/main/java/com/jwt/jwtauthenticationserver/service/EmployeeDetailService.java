package com.jwt.jwtauthenticationserver.service;

import com.jwt.jwtauthenticationserver.entity.Employee;
import com.jwt.jwtauthenticationserver.model.MyUserDetails;
import com.jwt.jwtauthenticationserver.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeDetailService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            Optional<Employee> employee = employeeRepository.findEmployeeByName(username);
            employee.orElseThrow(()-> new UsernameNotFoundException("Username "+ username+ "not found"));
            MyUserDetails userDetails = employee.map(MyUserDetails::new).get();
            return userDetails;
//            SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority(entity.getRole());
//            Collection<GrantedAuthority> authorities = new ArrayList<>();
//            authorities.add(adminAuthority);
//            return new User(entity.getName(), entity.getPassword(), authorities);

    }

}
