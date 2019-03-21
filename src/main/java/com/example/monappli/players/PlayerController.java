package com.example.monappli.players;

import java.util.HashMap;
import java.util.List;

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

import com.example.monappli.children.ChildService;
import com.example.monappli.teams.Team;
import com.example.monappli.teams.TeamService;

@Controller
@RequestMapping("/players")
public class PlayerController {
	@Autowired
	private PlayerService playerService;

	@Autowired
	private TeamService teamService;
	
	@Autowired
	private ChildService childService;
	
	// HashMap used to simplify the call to Team name with team id from PlayerController
	HashMap<Long , String> hash = new HashMap<>();	

	@GetMapping
	public String index(Model model) {
		List<Player> allPlayers = playerService.findAll();
		model.addAttribute("players", allPlayers);
		
		List<Team> Lt =  teamService.findAll();	
		
		for(Team t:Lt) { 
			Long id = t.getId();
			String name = teamService.findOne(id).getName();			
			hash.put(id ,name);			
		}
		
		/*Mask soluce "team2"
		for(Player p : allPlayers) {
			p.setTeam(teamService.findOne(p.getId_team()).getName());
		}*/
		
		for (Player p : allPlayers) {
			p.setLc(childService.findAllPlayerChild(p.getId()));
		}
		
		model.addAttribute("team", hash);
		return "players/index";
	}

	@GetMapping("new")
	public String newPlayer(Model model) {
		model.addAttribute("teams", teamService.findAll());
		model.addAttribute("player", new Player());
		return "players/new";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("teams", teamService.findAll());
		model.addAttribute("player", playerService.findOne(id));
		return "players/edit";
	}

	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("player", playerService.findOne(id));
		
		hash.put(id, teamService.findOne(id).getName());
		model.addAttribute("team", hash);
		
		return "players/show";
	}

	@PostMapping
	public String create(@ModelAttribute Player player) {
		playerService.save(player);
		return "redirect:/players";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Player player) {
		player.setId(id);
		playerService.update(player);
		return "redirect:/players";
	}

	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		playerService.delete(id);
		return "redirect:/players";
	}
}
