package com.example.monappli.children;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.monappli.exceptions.NullIDException;
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
    public int save(Child child) {
    	return childRepository.save(child) + childRepository.saveF(child.getIdplayer(), child.getId());
    }

    @Transactional
    public int update(Child child) {
    	return childRepository.update(child);    	
    	//childRepository.updateF(child);
    }

    @Transactional
    public int delete(Long id) throws NullIDException {
    	if (id == null) 
			throw new NullIDException("ID null non valide");
    	return childRepository.delete(id) + childRepository.deleteF(id);
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
