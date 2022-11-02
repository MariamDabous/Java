package com.axsos.java.date;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class DisplaydateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplaydateApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index() {
	    return "dashboard.jsp";
	}
	
	@RequestMapping("/date")
	public String time(Model model) {
		Date date= new Date();
		SimpleDateFormat newdate= new SimpleDateFormat("EEEE, 'the 'dd' of' MMMM ,yyyy");
		String formateddate= newdate.format(date);
		model.addAttribute("formateddate", formateddate);
		
	    return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String date(Model model) {
		Date date= new Date();
		SimpleDateFormat newtime= new SimpleDateFormat("h:mm a");
		String formatedtime= newtime.format(date);
		model.addAttribute("formatedtime", formatedtime);
	    return "time.jsp";
	}
	
	

}
