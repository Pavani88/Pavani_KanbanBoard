package com.pavani.kanban;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class KanbanService 
{
	@Autowired
	private KanbanRepository repository;

	public List<KanbanBoard> getAllTasks()
	{
		List<KanbanBoard> kanban = new ArrayList<>();

		repository.findAll().forEach(kanban::add);
		return kanban;
	}
	
	public void save(KanbanBoard kanban)
	{
		repository.save(kanban);
	}
	
	public void delete(KanbanBoard kanban)
	{
		repository.delete(kanban);
	}
}
