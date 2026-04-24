package com.example.nonprofit.data;

public class Volunteer {
    private final String name;
    private final String status;
    private final int hoursThisMonth;
    private final String program;
    private final String nextShift;
    private final String formsState;

    public Volunteer(String name, String status, int hoursThisMonth, String program,
                     String nextShift, String formsState) {
        this.name = name;
        this.status = status;
        this.hoursThisMonth = hoursThisMonth;
        this.program = program;
        this.nextShift = nextShift;
        this.formsState = formsState;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public int getHoursThisMonth() {
        return hoursThisMonth;
    }

    public String getProgram() {
        return program;
    }

    public String getNextShift() {
        return nextShift;
    }

    public String getFormsState() {
        return formsState;
    }

    public boolean isActive() {
        return "Active".equals(status);
    }

    public boolean hasPendingForms() {
        return !"All forms complete".equals(formsState);
    }

    public String toListLabel() {
        return name + " • " + program;
    }
}
