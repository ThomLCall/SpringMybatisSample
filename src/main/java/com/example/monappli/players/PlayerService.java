package com.example.monappli.players;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void save(Player player) {
    	playersRepository.save(player);
    }

    @Transactional
    public void update(Player player) {
    	playersRepository.update(player);
    }

    @Transactional
    public void delete(Long id) {
    	playersRepository.delete(id);
    }
}
