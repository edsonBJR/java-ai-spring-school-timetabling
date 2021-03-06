package br.com.cpqd.schooltimetabling.controller;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cpqd.schooltimetabling.domain.TimeTable;

@RestController
@RequestMapping("/timeTable")
public class TimeTableController {

	@Autowired
	private SolverManager<TimeTable, UUID> solverManager;
	
	@PostMapping("/solve")
	public TimeTable solve(@RequestBody TimeTable problem) {
		UUID problemId = UUID.randomUUID();
		
		// Submit the problem to start solving
		SolverJob<TimeTable, UUID> solverJob = solverManager.solve(problemId, problem);
		TimeTable solution;
		try {
			// Wait until the solving ends
			solution = solverJob.getFinalBestSolution();
		} catch (InterruptedException | ExecutionException e) {
			throw new IllegalStateException("Solving failed.", e);
		}
		return solution;
	}
}
