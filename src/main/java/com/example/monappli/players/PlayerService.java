package com.example.monappli.players;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.monappli.exceptions.NullIDException;

@Service
public class PlayerService {
    
    @Autowired
    private PlayersRepository playersRepository;

    @Transactional
    public List<Player> findAll() {
        return playersRepository.findAll();
    }

    @Transactional
    public Player findOne(Long id) {
        return playersRepository.findOne(id);
    }

    @Transactional
    public int save(Player player) {
    	return playersRepository.save(player);
    }

    @Transactional
    public int update(Player player) {
    	return playersRepository.update(player);
    }

    @Transactional
    public int delete(Long id) throws NullIDException{
    	if (id == null) 
			throw new NullIDException("ID null non valide");		
    	return playersRepository.delete(id);
    }
}
