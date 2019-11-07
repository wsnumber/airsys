package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import entity.Account;
import service.protptype.IAccountService;

@Controller
public class AccountController {
	@Autowired
	private IAccountService accountService;
	@RequestMapping("/user/{id}")
	@ResponseBody
	public String getUser(@PathVariable("id") int id) {
		Account u = accountService.searchAccount(id);
		return JSON.toJSONString(u);
	}
	
	@RequestMapping("users")
	public ModelAndView getUsers1() {
		ModelAndView mv = new ModelAndView("list");
		List<Account>acts = accountService.listPaged(1,10);
		mv.addObject("acts",acts);
		return mv;
	}
	@RequestMapping("/deleteuser/{id}")
	@ResponseBody
	public String delete(@PathVariable("id") int id) {
		return "success";
	}
}
