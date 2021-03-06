package com.sport.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.dtos.TeamDto;
import com.sport.entities.TeamEntity;
import com.sport.repositories.TeamRepository;


@Service
public class TeamService {
	@Autowired
	private TeamRepository teamRepository;

	public TeamDto createTeam(TeamDto dto) {
		
		TeamEntity team = new TeamEntity();
		team.setName(dto.getName());
		team.setCountry(dto.getCountry());
		team.setManager(dto.getMngr());
		team.setCreatedAt(new Date());
		team.setUpdatedAt(new Date());
		
		return convert(teamRepository.save(team));
		
	}
	
	public List<TeamDto> getAllTeam(){
		List<TeamEntity> teams = teamRepository.getAll();
		
		List<TeamDto> returnList = new ArrayList<TeamDto>();		
		for(TeamEntity t : teams) {
			TeamDto d = convert(t);
			returnList.add(d);
		}		
		return returnList;
		
	}
	
	private TeamDto convert(TeamEntity te) {
		TeamDto dto = null;
		if(te != null) {
			dto = new TeamDto();
			dto.setId(te.getId());
			dto.setName(te.getName());
			dto.setLogo(te.getLog());
			dto.setMngr(te.getManager());
			dto.setCountry(te.getCountry());
		}
		
		return dto;
	}

}
