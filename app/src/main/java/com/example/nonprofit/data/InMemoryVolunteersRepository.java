package com.example.nonprofit.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryVolunteersRepository implements VolunteersRepository {

    private final List<Volunteer> volunteers;

    public InMemoryVolunteersRepository() {
        List<Volunteer> seeded = new ArrayList<>();
        seeded.add(new Volunteer("Alex Johnson", "Active", 18,
                "Pantry Support", "Sat 9:00 AM", "All forms complete"));
        seeded.add(new Volunteer("Briana Lee", "Active", 11,
                "Front Desk", "Fri 1:00 PM", "Background check pending"));
        seeded.add(new Volunteer("Carlos Gomez", "On Leave", 6,
                "Distribution", "No shift scheduled", "All forms complete"));
        seeded.add(new Volunteer("Diana Patel", "Active", 23,
                "Community Service Supervision", "Thu 3:30 PM", "Orientation due"));
        seeded.add(new Volunteer("Evan Kim", "Active", 14,
                "Warehouse Intake", "Sat 11:00 AM", "All forms complete"));
        seeded.add(new Volunteer("Fatima Noor", "Active", 9,
                "Meal Packing", "Wed 10:00 AM", "Photo consent pending"));
        volunteers = Collections.unmodifiableList(seeded);
    }

    @Override
    public List<Volunteer> getVolunteers() {
        return volunteers;
    }
}
