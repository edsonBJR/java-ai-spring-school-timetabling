package br.com.cpqd.schooltimetabling.domain;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Timeslot {
	
	private DayOfWeek dayOfWeek;
	private LocalTime startTime;
	private LocalTime endTime;

	private Timeslot() {}
	
	@Override
	public String toString() {
		return dayOfWeek + " " + startTime.toString();
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}
	
	
	
}
