package sg.edu.iss.sa50.t8.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.sa50.t8.model.BlockedLeaves;
import sg.edu.iss.sa50.t8.service.ParsingService;

@Controller
@RequestMapping("/api")
public class ApiController {
	
	
	private static final String JSON_URL = "https://holidayapi.com/v1/holidays/?country=SG&year=2019&key=e81bb02b-d2dd-48b4-b3d0-6ba4a6e6e8dd";
	
	@Autowired
	private ParsingService jsonParsingService;
	
	@GetMapping("/admin-setblockleave")
	public String setBlockedLeaves(Model model) {
		List<BlockedLeaves> blockedLeaves = new ArrayList<>();
		try {
			blockedLeaves = jsonParsingService.parse(JSON_URL);
		
			model.addAttribute("bLList", blockedLeaves);
		
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "admin-setblockleave";
	}
}
