package br.com.cpqd.schooltimetabling.domain;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class TimeTable {
	
	// Field with all time slots
	@ValueRangeProvider(id = "timeslotRange")
	@ProblemFactCollectionProperty
	private List<Timeslot> timeslotList;
	
	// Field with all rooms
	@ValueRangeProvider(id = "roomRange")
	@ProblemFactCollectionProperty
	private List<Room> roomList;
	
	// Field with all lessons
	@PlanningEntityCollectionProperty
	private List<Lesson> lessonList;
	
	@PlanningScore
	private HardSoftScore score;
	
	private TimeTable() {
	}

	public TimeTable(List<Timeslot> timeslotList, List<Room> roomList, List<Lesson> lessonList) {
		this.timeslotList = timeslotList;
		this.roomList = roomList;
		this.lessonList = lessonList;
	}

	public List<Timeslot> getTimeslotList() {
		return timeslotList;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public List<Lesson> getLessonList() {
		return lessonList;
	}

	public HardSoftScore getScore() {
		return score;
	}
	
}
