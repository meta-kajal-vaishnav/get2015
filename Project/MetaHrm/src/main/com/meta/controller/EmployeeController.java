/**
 * 
 */
package main.com.meta.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import main.com.meta.bean.AttendenceBean;
import main.com.meta.bean.EmployeeBean;
import main.com.meta.model.Attendence;
import main.com.meta.model.Employee;
import main.com.meta.model.EmployeeRole;
import main.com.meta.service.AttendenceService;
import main.com.meta.service.EmployeeService;
import main.com.meta.util.UserRoles;

/**
 * @author Kajal
 *
 */
@Controller
@SessionAttributes("objOfEmployee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private AttendenceService attendenceService;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security + Hibernate Example");
		model.addObject("message", "This is default page!");
		model.setViewName("hello");
		return model;
	}

	@RequestMapping(value = "/UserHomePage", method = RequestMethod.GET)
	public ModelAndView welcome(HttpServletRequest request,
			@ModelAttribute("attendenceBean") AttendenceBean attendenceBean) {
		ModelAndView modelAndView = new ModelAndView();
		Employee employeeModel = employeeService.findByUserName(getPrincipal());
		EmployeeBean sessionEmployeeBean = prepareEmployeeBeanFromModel(employeeModel);
		modelAndView.addObject("objOfEmployee", sessionEmployeeBean);
		Iterator<EmployeeRole> i = sessionEmployeeBean.getUserRole().iterator();
		while(i.hasNext())
		{
			String r = ((EmployeeRole) i.next()).getRole();
			System.out.println("Role: "+r);
			if(r.equals("ROLE_ADMIN")){
				modelAndView.setViewName("AdminHomePage");
				System.out.println("yes");
				return modelAndView;
			}
		}
		System.out.println("no");
		modelAndView.setViewName("UserHomePage");
		return modelAndView;
	}
	
	@RequestMapping(value = "/addSubordinates", method = RequestMethod.GET)
	public ModelAndView addSubordinates(HttpServletRequest request, ModelMap model,
			@ModelAttribute("employeeBean") EmployeeBean employeeBean,
			@ModelAttribute("objOfEmployee") EmployeeBean sessionEmployeeBean) {
		ModelAndView modelAndView = new ModelAndView();
		List<EmployeeBean> employeeBeanList = prepareEmployeeBeanListFromModel(employeeService.getAllEmployeesList());
		model.addAttribute("listOfAllEmployeeBeans", employeeBeanList);
		modelAndView.addObject("objOfEmployee", sessionEmployeeBean);
		model.addAttribute("userTypeEnum", UserRoles.values());
		modelAndView.addAllObjects(model);
		modelAndView.setViewName("AddSubordinates");
		return modelAndView;
	}
	
	@RequestMapping(value = "/viewSubordinates", method = RequestMethod.GET)
	public ModelAndView viewSubordinates(HttpServletRequest request, ModelMap model,
			@ModelAttribute("employeeBean") EmployeeBean employeeBean,
			@ModelAttribute("objOfEmployee") EmployeeBean sessionEmployeeBean) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("objOfEmployee", sessionEmployeeBean);
		List<EmployeeBean> employeeBeanList = prepareEmployeeBeanListFromModel(employeeService.getAllEmployeesList());
		model.addAttribute("listOfAllEmployeeBeans", employeeBeanList);
		modelAndView.addAllObjects(model);
		modelAndView.setViewName("ViewSubordinates");
		return modelAndView;
	}
	
	@RequestMapping(value = "/viewAttendence", method = RequestMethod.GET)
	public ModelAndView viewAttendence(ModelMap model,
			@ModelAttribute("attendenceBean") AttendenceBean attendenceBean,
			@ModelAttribute("objOfEmployee") EmployeeBean sessionEmployeeBean) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("objOfEmployee", sessionEmployeeBean);
		//List<AttendenceBean> attendenceBeanList = prepareAttendenceBeanListFromModel(attendenceService.getAttendenceList(employeeId));
		//model.addAttribute("listOfAttendence", attendenceBeanList);
		modelAndView.addAllObjects(model);
		modelAndView.setViewName("ViewAttendence");
		return modelAndView;
	}

	@RequestMapping(value = "/addAttendence", method = RequestMethod.POST)
	public @ResponseBody String addAttendence(@ModelAttribute("objOfEmployee") EmployeeBean sessionEmployeeBean,
			@ModelAttribute("attendenceBean") AttendenceBean attendenceBean,
			HttpServletRequest request) {
		System.out.println("Hello");
		//sessionEmployeeBean = (EmployeeBean) request.getSession(false).getAttribute("objOfEmployee");
		Employee employeeModel = prepareEmployeeModelFromBean(sessionEmployeeBean);
		System.out.println("date : "+attendenceBean.getAttendenceDate());
		Attendence attendenceModel = prepareAttendenceModelFromBean(attendenceBean);
		attendenceModel.setStatus("P");
		attendenceModel.setEmployee(employeeModel);
		employeeModel.getAttendenceList().add(attendenceModel);
		employeeService.addEmployee(employeeModel);
		Date inDate = attendenceService.getLatestAttendence(employeeModel);
		System.out.println("after date "+inDate.toString());
		return inDate.toString();
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@ModelAttribute("employee") Employee employee,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		if (error != null) {
			modelAndView.addObject("error",
					getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}
		if (logout != null) {
			modelAndView.addObject("msg",
					"You've been logged out successfully.");
		}
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView admin(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView();
		Employee employeeModel = employeeService.findByUserName(getPrincipal());
		EmployeeBean sessionEmployeeBean = prepareEmployeeBeanFromModel(employeeModel);
		modelAndView.addObject("objOfEmployee", sessionEmployeeBean);
		modelAndView.setViewName("AdminHomePage");
		return modelAndView;
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)//List<EmployeeBean>
	public @ResponseBody String addEmployee(HttpServletRequest request, 
			@ModelAttribute("employeeBean") EmployeeBean employeeBean) {
		String userName = request.getParameter("subordinates");
		System.out.println("userName  kk "+userName);
		Employee manager = employeeService.findByUserName(userName);
		employeeBean.setPassword("abcd");
		employeeBean.setEnabled(true);
		employeeBean.getManagers().add(manager);
		EmployeeRole employeeRole = new EmployeeRole();
		Employee employeeModel = prepareEmployeeModelFromBean(employeeBean);
		employeeRole.setRole("ROLE_"+request.getParameter("employeeType"));
		employeeRole.setEmployee(employeeModel);
		employeeBean.getUserRole().add(employeeRole);
		employeeService.addEmployee(employeeModel);
		
		Gson gson = new Gson();
	    String json = gson.toJson(prepareEmployeeBeanListFromModel(employeeService.getAllEmployeesList()));
		return json;
		
		
//		List<EmployeeBean> employeeBeanList = prepareEmployeeBeanListFromModel(employeeService.getAllEmployeesListNew());
//		for(EmployeeBean e : employeeBeanList)
//	    	System.out.println("List ka : "+e.getEmployeeName());
//		return null;
		
//		List<EmployeeBean> employeeBeanList = prepareEmployeeBeanListFromModel(employeeService.getAllEmployeesList());
//		// create a new Gson instance
//		Gson gson = new Gson();
//		// Convert the object to a JSON string
//		String jsonAllEmployeeBeanList = gson.toJson(employeeBeanList);
//		// print your generated json string
//		System.out.println("jsonAllEmployeeBeanList: " + jsonAllEmployeeBeanList);
//		// Now convert the JSON string back to your java object
//		Type type = new TypeToken<List<EmployeeBean>>() {
//		}.getType();
//		List<EmployeeBean> jsonEmployeeModelList = new Gson().fromJson(
//				jsonAllEmployeeBeanList, type);
//		return jsonEmployeeModelList;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		// check if user is login
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
			model.addObject("username", userDetail.getUsername());
		}
		model.setViewName("403");
		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(@ModelAttribute("objOfEmployee") EmployeeBean sessionEmployeeBean,
			HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		HttpSession session = request.getSession(false);
		// invalidates the session if the user is logged in
		if (session != null) {
			session.removeAttribute("objOfEmployee");
			session.invalidate();
		}
		return "redirect:/login.html?logout";
	}

	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession()
				.getAttribute(key);
		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}
		return error;
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	private EmployeeBean prepareEmployeeBeanFromModel(Employee employeeModel) {
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEnabled(employeeModel.isEnabled());
		employeeBean.setEmployeeId(employeeModel.getEmployeeId());
		employeeBean.setEmployeeName(employeeModel.getEmployeeName());
		employeeBean.setUsername(employeeModel.getUsername());
		employeeBean.setPassword(employeeModel.getPassword());
		employeeBean.setUserRole(employeeModel.getUserRole());
		employeeBean.setAttendenceList(employeeModel.getAttendenceList());
		employeeBean.setManagers(employeeModel.getManagers());
		employeeBean.setSubordinates(employeeModel.getSubordinates());
		return employeeBean;
	}

	private Employee prepareEmployeeModelFromBean(EmployeeBean employeeBean) {
		Employee employeeModel = new Employee();
		employeeModel.setEnabled(employeeBean.isEnabled());
		employeeModel.setEmployeeId(employeeBean.getEmployeeId());
		employeeModel.setEmployeeName(employeeBean.getEmployeeName());
		employeeModel.setUsername(employeeBean.getUsername());
		employeeModel.setPassword(employeeBean.getPassword());
		employeeModel.setUserRole(employeeBean.getUserRole());
		employeeModel.setAttendenceList(employeeBean.getAttendenceList());
		employeeModel.setManagers(employeeBean.getManagers());
		employeeModel.setSubordinates(employeeBean.getSubordinates());
		return employeeModel;
	}

	private Attendence prepareAttendenceModelFromBean(
			AttendenceBean attendenceBean){
		Attendence attendenceModel = new Attendence();
		attendenceModel.setId(attendenceBean.getId());
		attendenceModel.setStatus(attendenceBean.getStatus());
		attendenceModel.setAttendenceDate(attendenceBean.getAttendenceDate());
		attendenceModel.setEmployee(attendenceBean.getEmployee());
		return attendenceModel;
	}
	
	private List<AttendenceBean> prepareAttendenceBeanListFromModel(List<Attendence> attendenceModelList) {
		List<AttendenceBean> attendenceBeanList = new ArrayList<AttendenceBean>();
		for(Attendence attendenceModel : attendenceModelList)
		{
			AttendenceBean attendenceBean = new AttendenceBean();
			attendenceBean.setId(attendenceModel.getId());
			attendenceBean.setStatus(attendenceModel.getStatus());
			attendenceBean.setAttendenceDate(attendenceModel.getAttendenceDate());
			attendenceBean.setEmployee(attendenceModel.getEmployee());
			attendenceBeanList.add(attendenceBean);
		}
		return attendenceBeanList;
	}
	 
	private List<EmployeeBean> prepareEmployeeBeanListFromModel(List<Employee> employeeModelList) {
		List<EmployeeBean> employeeBeanList = new ArrayList<EmployeeBean>();
		for(Employee employeeModel : employeeModelList)
		{
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEnabled(employeeModel.isEnabled());
			employeeBean.setEmployeeId(employeeModel.getEmployeeId());
			employeeBean.setEmployeeName(employeeModel.getEmployeeName());
			employeeBean.setUsername(employeeModel.getUsername());
			employeeBean.setPassword(employeeModel.getPassword());
			employeeBean.setUserRole(employeeModel.getUserRole());
			employeeBean.setAttendenceList(employeeModel.getAttendenceList());
			employeeBean.setManagers(employeeModel.getManagers());
			employeeBean.setSubordinates(employeeModel.getSubordinates());
			employeeBeanList.add(employeeBean);
		}
		return employeeBeanList;
	}
}
