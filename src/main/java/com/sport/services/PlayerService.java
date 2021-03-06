package com.sport.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sport.dtos.PlayerDto;
import com.sport.entities.PlayerEntity;
import com.sport.entities.TeamEntity;
import com.sport.repositories.PlayerRepository;
import com.sport.repositories.TeamRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private TeamRepository teamRepository;

	public void createPlayer(Long teamId, PlayerDto dto) throws Exception {
		TeamEntity team = teamRepository.getById(teamId);

		if (team == null) {
			throw new Exception("Team doesnt exist : " + teamId);
		} else {
			PlayerEntity p = convert(dto);
			p.setTeam(team);
			if (p != null) {
				playerRepository.save(p);
			}
		}

	}

	private PlayerEntity convert(PlayerDto dto) {
		PlayerEntity p = null;
		if (dto != null) {
			p = new PlayerEntity();
			p.setName(dto.getName());
			p.setPosition(dto.getPosition());
			p.setAge(dto.getAge());
		}
		return p;
	}

}