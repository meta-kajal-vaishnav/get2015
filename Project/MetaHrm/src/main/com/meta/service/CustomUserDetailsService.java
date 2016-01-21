//package main.com.meta.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import main.com.meta.model.Employee;
//import main.com.meta.service.EmployeeService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
////import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//@Service("customUserDetailsService")
//public class CustomUserDetailsService implements UserDetailsService {
// 
//    @Autowired
//    private EmployeeService employeeService;
//     
//    @Transactional(readOnly=true)
//    public UserDetails loadUserByUsername(String userName)
//            throws UsernameNotFoundException {
//    	System.out.println("userName : "+userName);
//
//        Employee employee = employeeService.getEmployeeByUserName(userName);
//        System.out.println("Employee : "+employee);
//        if(employee==null){
//            System.out.println("Employee not found");
//            throw new UsernameNotFoundException("Username not found");
//        }
//            return new org.springframework.security.core.userdetails.User(employee.getUserName(), 
//            		employee.getPassword(), true, true, true, true, getGrantedAuthorities(employee));
//    }
// 
//    // Returns the authorities granted to the user. Cannot return null 
//    private List<GrantedAuthority> getGrantedAuthorities(Employee employee){
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        // SimpleGrantedAuthority : Stores a String representation of an authority granted to the Authentication object.
//        authorities.add(new SimpleGrantedAuthority("ROLE_"+employee.getEmployeeType())); 
////        for(UserProfile userProfile : user.getUserProfiles()){
////            System.out.println("UserProfile : "+userProfile);
////            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
////        }
//        System.out.print("authorities :"+authorities);
//        return authorities;
//    }
//     
//}

package main.com.meta.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.com.meta.dao.EmployeeDao;
import main.com.meta.dao.daoImpl.EmployeeDaoImpl;
import main.com.meta.model.Employee;
import main.com.meta.model.EmployeeRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
 
    @Autowired
    private EmployeeDao employeeDao;

	@Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public UserDetails loadUserByUsername(String username) 
               throws UsernameNotFoundException {
    	System.out.println("UserName  " +username);
		Employee employee = employeeDao.findByUserName(username);
		if (employee != null) {
			List<GrantedAuthority> authorities = buildUserAuthority(employee.getUserRole());
			System.out.println("kkk");
			return buildUserForAuthentication(employee, authorities);
		} else {
		    throw new UsernameNotFoundException("User not found");
		}
	}
 
	// Converts our Employee employee to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(Employee employee, 
		List<GrantedAuthority> authorities) {
		return new User(employee.getUsername(), 
				employee.getPassword(), employee.isEnabled(), 
                        true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<EmployeeRole> employeeRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (EmployeeRole employeeRole : employeeRoles) {
			setAuths.add(new SimpleGrantedAuthority(employeeRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return Result;
	}
     
}
