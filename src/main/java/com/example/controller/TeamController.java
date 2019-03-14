package com.example.controller;

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

import com.example.domain.Team;
import com.example.service.TeamService;

@Controller
@RequestMapping("/teams")
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	@GetMapping
    public String index(Model model) {
        model.addAttribute("team", teamService.findAllTeam());
        return "teams/index";
    }

    @GetMapping("newteam")
    public String newTeam() {
        return "teams/newteam";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("team", teamService.findOneTeam(id));
        return "teams/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("team", teamService.findOneTeam(id));
        return "teams/show";
    }

    @PostMapping
    public String create(@ModelAttribute Team team) {
    	teamService.saveTeam(team);
        return "redirect:/teams";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Team team) {
        team.setId(id);
        teamService.updateTeam(team);
        return "redirect:/teams";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
    	teamService.deleteTeam(id);
        return "redirect:/teams";
    }
	

}
