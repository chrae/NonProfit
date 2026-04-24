package com.example.nonprofit.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.nonprofit.R;
import com.example.nonprofit.data.Volunteer;
import com.example.nonprofit.ui.volunteers.VolunteersUiState;
import com.example.nonprofit.ui.volunteers.VolunteersViewModel;

import java.util.ArrayList;
import java.util.List;

public class VolunteersFragment extends Fragment {

    private VolunteersViewModel viewModel;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private TextView summaryActive;
    private TextView summaryHours;
    private TextView summaryMissingForms;
    private TextView detailTitle;
    private TextView detailBody;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_volunteers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(VolunteersViewModel.class);

        summaryActive = view.findViewById(R.id.volunteer_summary_active_value);
        summaryHours = view.findViewById(R.id.volunteer_summary_hours_value);
        summaryMissingForms = view.findViewById(R.id.volunteer_summary_forms_value);

        listView = view.findViewById(R.id.volunteer_list);
        detailTitle = view.findViewById(R.id.volunteer_detail_title);
        detailBody = view.findViewById(R.id.volunteer_detail_body);

        adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_list_item_activated_1, new ArrayList<>());
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setOnItemClickListener((parent, itemView, position, id) ->
                viewModel.onVolunteerSelected(position));

        view.findViewById(R.id.button_volunteer_check_in)
                .setOnClickListener(v -> Toast.makeText(requireContext(),
                        getString(R.string.volunteer_action_check_in), Toast.LENGTH_SHORT).show());

        view.findViewById(R.id.button_volunteer_log_hours)
                .setOnClickListener(v -> Toast.makeText(requireContext(),
                        getString(R.string.volunteer_action_log_hours), Toast.LENGTH_SHORT).show());

        viewModel.getUiState().observe(getViewLifecycleOwner(), this::renderState);
    }

    private void renderState(VolunteersUiState state) {
        summaryActive.setText(String.valueOf(state.getActiveCount()));
        summaryHours.setText(String.valueOf(state.getTotalHours()));
        summaryMissingForms.setText(String.valueOf(state.getFormsPendingCount()));

        bindList(state.getVolunteers());

        int selectedIndex = state.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < adapter.getCount()) {
            listView.setItemChecked(selectedIndex, true);
        }

        Volunteer selectedVolunteer = state.getSelectedVolunteer();
        if (selectedVolunteer != null) {
            detailTitle.setText(selectedVolunteer.getName());
            detailBody.setText(getString(
                    R.string.volunteer_detail_template,
                    selectedVolunteer.getStatus(),
                    selectedVolunteer.getHoursThisMonth(),
                    selectedVolunteer.getProgram(),
                    selectedVolunteer.getNextShift(),
                    selectedVolunteer.getFormsState()
            ));
        }
    }

    private void bindList(List<Volunteer> volunteers) {
        List<String> labels = new ArrayList<>();
        for (Volunteer volunteer : volunteers) {
            labels.add(volunteer.toListLabel());
        }

        adapter.clear();
        adapter.addAll(labels);
        adapter.notifyDataSetChanged();
    }
}
