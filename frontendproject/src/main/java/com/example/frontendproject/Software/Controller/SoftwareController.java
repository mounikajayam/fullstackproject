package com.example.frontendproject.Software.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.frontendproject.SoftwareInterfaceforDef.SoftwareIntforDef;
import com.example.frontendproject.Model.Administration;
import com.example.frontendproject.Model.Software;

@Controller
public class SoftwareController {
	public SoftwareIntforDef service;

	public SoftwareController(SoftwareIntforDef service) {
		this.service = service;
	}
	@GetMapping("/viewAllSoftwares")
	public String listOfsoftwares(Model model) {
	model.addAttribute("softwareList",service.fetchAllRecords());
	return "software";  
	}

	@GetMapping("software/createNewSoftware")
	public String createSoftware(Model model) {
		Software emptyObj=new Software();
		model.addAttribute("softobj", emptyObj);
		return "createSoftware";
	}
	@PostMapping("/insertSoftwares")	
	public String InsertIntoDataBase(@ModelAttribute("softobj") Software obj) {
		service.saveSoftware(obj);
		return "redirect:/viewAllSoftwares";
	}
	@GetMapping("/delete/{id}")
	public String deleteSoftware(@PathVariable int id) {
		service.deleteSoftwarebyId(id);
		return "redirect:/viewAllSoftwares";
	}
	@GetMapping("/update/{id}")
	public String updateSoftwareRecr(@PathVariable int id, Model model) {
		model.addAttribute("updateSoftware", service.getSoftwareById(id));
		return "update_software";
	}
	@PostMapping("/updateAndSave/{id}")
	public String updateNewValIntoDb(@PathVariable int id,
			@ModelAttribute("updateSoftware") Software newVal) {
	Software existingSof = service.getSoftwareById(id);
existingSof.setSoftwarename(newVal.getSoftwarename());
existingSof.setCompanyname(newVal.getCompanyname());
existingSof.setDescription(newVal.getDescription());
existingSof.setStock(newVal.getStock());
existingSof.setPrice(newVal.getPrice());

	service.saveSoftware(existingSof);
	return "redirect:/viewAllSoftwares";
	}
	
	@GetMapping("/logout")
	public String logoutFrompage() {
		return "logout";
	}
	@GetMapping("/contact")
	public String contactpage() {
		return "contact";
	}
	@GetMapping("/home")
	public String homepage() {
		return "home";
	}
	@GetMapping("/success")
	public String successpage() {
		return "success";
	}
	@GetMapping("/login")
	public String loginpage(Model model) {
		Administration admin= new Administration();
		model.addAttribute("adminObj",admin);
		return"login";
	}

	
	@GetMapping("/validationData")
	public String validateLogin(@ModelAttribute("adminObj")Administration adminDetails) {
		if(adminDetails.getUsername().equals("administrationlogin")&&adminDetails.getPassword().equals("Mouni")) {
			return "redirect:/viewAllSoftwares";
		}
		else {
			return"redirect:/login";
		}
	}

}
	


