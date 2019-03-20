package com.example.monappli.children;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChildService {
	
	@Autowired
    private ChildRepository childRepository;
	
    @Transactional
    public List<Child> findAll() {
        return childRepository.findAll();
    }

    @Transactional
    public Child findOne(Long id) {
        return childRepository.findOne(id);
    }

    @Transactional
    public void save(Child child) {
    	childRepository.save(child);
    }

    @Transactional
    public void update(Child child) {
    	childRepository.update(child);
    }

    @Transactional
    public void delete(Long id) {
    	childRepository.delete(id);
    }
    
    @Transactional
    public List<String> findAllPlayerChild(Long id) {
    	return childRepository.findAllPlayerChild(id);
    }
	

}
