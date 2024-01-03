package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ScheduleTest {

    Employee employee;
    Manager manager;
    Schedule schedule;

    @BeforeEach
    public void setup() {
        // Mock setup for employee and manager
        employee = new Employee("John", "Doe", "1234567890", "1234567890123", 15);
        manager = new Manager("Jane", "Doe", "0987654321", "9876543210987", 20, 0);
        schedule = new Schedule(LocalDate.now(), LocalTime.of(9, 0), LocalTime.of(17, 0), employee, manager);
    }

    @Test
    public void testScheduleCreation() {
        assertEquals(LocalDate.now(), schedule.getDate());
        assertEquals(LocalTime.of(9, 0), schedule.getStartTime());
        assertEquals(LocalTime.of(17, 0), schedule.getEndTime());
        assertEquals(employee, schedule.getAssignedEmployee());
        assertEquals(manager, schedule.getCreator());
        assertFalse(schedule.isPresent());
    }

    @Test
    public void testGetEmployeeSchedules() {
        ArrayList<Schedule> employeeSchedules = Schedule.getEmployeeSchedules(employee);
        assertTrue(employeeSchedules.contains(schedule));
    }

    @Test
    public void testGetTodaysEmployeeSchedule() {
        ArrayList<Schedule> todaysSchedules = Schedule.getTodaysEmployeeSchedule(employee);
        assertTrue(todaysSchedules.contains(schedule));
    }

    @Test
    public void testGetEmployeeScheduleByDate() {
        ArrayList<Schedule> schedulesByDate = Schedule.getEmployeeScheduleByDate(employee, LocalDate.now());
        assertTrue(schedulesByDate.contains(schedule));
    }
}
