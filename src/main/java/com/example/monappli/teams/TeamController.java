package com.example.monappli.teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.monappli.exceptions.NullIDException;

@Controller
@RequestMapping("/teams")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
    @GetMapping
    public String index(Model model) {
        model.addAttribute("teams", teamService.findAll());
        return "teams/index";
    }
    
    @GetMapping("new")
    public String newTeam() {
        return "teams/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("team", teamService.findOne(id));
        return "teams/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("team", teamService.findOne(id));
        return "teams/show";
    }

    @PostMapping
    public String create(@ModelAttribute Team team) {
    	teamService.save(team);
        return "redirect:/teams";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Team team) {
        team.setId(id);
        teamService.update(team);
        return "redirect:/teams";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {    	
    	try {
    		teamService.delete(id);
		} catch (NullIDException e) {
			System.out.println(e.getMessage());
		}    	
        return "redirect:/teams";
    }

}
