package com.example.monappli.children;

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

@Controller
@RequestMapping("/children")
public class ChildController {
	
	@Autowired
	private ChildService childService;
	
	
	@GetMapping
    public String index(Model model) {
        model.addAttribute("childs", childService.findAll());
        return "children/indexC";
    }
    
    @GetMapping("new")
    public String newChild() {
        return "children/newC";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("child", childService.findOne(id));
        return "children/editC";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("child", childService.findOne(id));
        return "children/showC";
    }

    @PostMapping
    public String create(@ModelAttribute Child child) {
    	childService.save(child);
        return "redirect:/children";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Child child) {
    	child.setId(id);
        childService.update(child);
        return "redirect:/children";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
    	childService.delete(id);
        return "redirect:/children";
    }

}