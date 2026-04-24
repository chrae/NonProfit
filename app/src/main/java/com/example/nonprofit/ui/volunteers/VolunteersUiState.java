package com.example.nonprofit.ui.volunteers;

import com.example.nonprofit.data.Volunteer;

import java.util.List;

public class VolunteersUiState {
    private final List<Volunteer> volunteers;
    private final int selectedIndex;
    private final int activeCount;
    private final int totalHours;
    private final int formsPendingCount;

    public VolunteersUiState(List<Volunteer> volunteers, int selectedIndex,
                             int activeCount, int totalHours, int formsPendingCount) {
        this.volunteers = volunteers;
        this.selectedIndex = selectedIndex;
        this.activeCount = activeCount;
        this.totalHours = totalHours;
        this.formsPendingCount = formsPendingCount;
    }

    public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public Volunteer getSelectedVolunteer() {
        if (volunteers.isEmpty()) {
            return null;
        }
        int safeIndex = Math.max(0, Math.min(selectedIndex, volunteers.size() - 1));
        return volunteers.get(safeIndex);
    }

    public int getActiveCount() {
        return activeCount;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public int getFormsPendingCount() {
        return formsPendingCount;
    }
}
