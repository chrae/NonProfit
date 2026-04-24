package com.example.nonprofit.ui.volunteers;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nonprofit.data.InMemoryVolunteersRepository;
import com.example.nonprofit.data.Volunteer;
import com.example.nonprofit.data.VolunteersRepository;

import java.util.List;

public class VolunteersViewModel extends ViewModel {

    private final VolunteersRepository repository;
    private final MutableLiveData<VolunteersUiState> uiState = new MutableLiveData<>();

    public VolunteersViewModel() {
        this(new InMemoryVolunteersRepository());
    }

    VolunteersViewModel(VolunteersRepository repository) {
        this.repository = repository;
        List<Volunteer> volunteers = repository.getVolunteers();
        uiState.setValue(buildState(volunteers, 0));
    }

    public LiveData<VolunteersUiState> getUiState() {
        return uiState;
    }

    public void onVolunteerSelected(int index) {
        VolunteersUiState currentState = uiState.getValue();
        List<Volunteer> volunteers = currentState != null
                ? currentState.getVolunteers()
                : repository.getVolunteers();
        uiState.setValue(buildState(volunteers, index));
    }

    private VolunteersUiState buildState(List<Volunteer> volunteers, int selectedIndex) {
        int active = 0;
        int totalHours = 0;
        int formsPending = 0;

        for (Volunteer volunteer : volunteers) {
            if (volunteer.isActive()) {
                active++;
            }
            totalHours += volunteer.getHoursThisMonth();
            if (volunteer.hasPendingForms()) {
                formsPending++;
            }
        }

        int safeSelected = volunteers.isEmpty() ? -1 : Math.max(0, Math.min(selectedIndex, volunteers.size() - 1));
        return new VolunteersUiState(volunteers, safeSelected, active, totalHours, formsPending);
    }
}
