package com.example.hello.hellocontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class hellohuman {
	 @RequestMapping("/")
	    public String index(@RequestParam(value="name", required= false) String nameadded) {
		 if (nameadded==null) {
			 return "hello human";
		 }else {
			 return "Hello " + nameadded; 
		 }
	 }
	        

}
