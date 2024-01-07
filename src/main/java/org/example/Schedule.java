package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Schedule {
    private static ArrayList<Schedule> schedules = new ArrayList<Schedule>();
    private static int scheduleIdCounter = 1;

    private int scheduleId;

    // Properties
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean isPresent;

    // Associations
    private Employee assignedEmployee;
    private Manager creator;

    // Constructor
    public Schedule(LocalDate date, LocalTime startTime, LocalTime endTime, Employee assignedEmployee, Manager creator) {
        this.scheduleId = scheduleIdCounter++;
        schedules.add(this);

        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isPresent = false;
        this.assignedEmployee = assignedEmployee;
        this.creator = creator;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean isPresent) {
        this.isPresent = isPresent;
    }

    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public Manager getCreator() {
        return creator;
    }

    public static ArrayList<Schedule> getEmployeeSchedules(Employee employee) {
        List<Schedule> filteredSchedules = schedules.stream()
                .filter(schedule -> schedule.getAssignedEmployee().equals(employee))
                .sorted((s1, s2) -> s1.getDate().compareTo(s2.getDate()))
                .toList();

        return new ArrayList<>(filteredSchedules);
    }

    public static ArrayList<Schedule> getTodaysEmployeeSchedule(Employee employee) {
        LocalDate today = LocalDate.now();

        List<Schedule> todaysSchedules = schedules.stream()
                .filter(schedule -> schedule.getAssignedEmployee().equals(employee))
                .filter(schedule -> schedule.getDate().equals(today))
                .toList();

        return new ArrayList<>(todaysSchedules);
    }

    public static ArrayList<Schedule> getEmployeeScheduleByDate(Employee employee, LocalDate date) {
        List<Schedule> schedulesByDate = schedules.stream()
                .filter(schedule -> schedule.getAssignedEmployee().equals(employee))
                .filter(schedule -> schedule.getDate().equals(date))
                .toList();

        return new ArrayList<>(schedulesByDate);
    }
}

