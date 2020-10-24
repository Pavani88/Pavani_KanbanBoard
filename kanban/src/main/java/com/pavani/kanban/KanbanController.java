package com.pavani.kanban;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class KanbanController 
{
	@Autowired
	private KanbanService kanbanService;
	
	@RequestMapping("/")
	public ModelAndView index () {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("Login");
	    return modelAndView;
	}
	
	@PostMapping("/Login")
	public ModelAndView validLogin () {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("kanban");
	    return modelAndView;
	}

	@RequestMapping("/task")
	public List<KanbanBoard> getAllTasks()
	{
		return kanbanService.getAllTasks();
	}

	@PostMapping("/create")
	public List<KanbanBoard> create(@RequestBody KanbanBoard kanban)
	{
		kanbanService.save(kanban);
		return kanbanService.getAllTasks();
	}

	@PostMapping("/update")
	public List<KanbanBoard> update(@RequestBody KanbanBoard kanban)
	{
		kanbanService.save(kanban);
		return kanbanService.getAllTasks();
	}

	@PostMapping("/delete")
	public List<KanbanBoard> delete(@RequestBody KanbanBoard kanban)
	{
		kanbanService.delete(kanban);
		return kanbanService.getAllTasks();
	}
}
