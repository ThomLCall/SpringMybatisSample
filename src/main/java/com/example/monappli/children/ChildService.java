package com.example.monappli.children;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.monappli.players.Player;

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
    	//correction to have the Id of child because this id is null in the object 
    	/*Long idchild = childRepository.maxid();
    	childRepository.saveF(child.getIdplayer(), idchild);*/
    	childRepository.saveF(child.getIdplayer(), child.getId());
    }

    @Transactional
    public void update(Child child) {
    	childRepository.update(child);    	
    	//childRepository.updateF(child);
    }

    @Transactional
    public void delete(Long id) {
    	childRepository.delete(id);
    	childRepository.deleteF(id);
    }
    
    @Transactional
    public List<Child> findAllPlayerChild(Long id) {
    	return childRepository.findAllPlayerChild(id);
    }
    
    @Transactional
    List<Player> findAllChildsPlayer(Long id){
    	return childRepository.findAllChildsPlayer(id);
    }

}
