package com.example.nonprofit.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nonprofit.R;

public class VolunteersFragment extends Fragment {

    private static final String[] VOLUNTEERS = new String[]{
            "Alex Johnson", "Briana Lee", "Carlos Gomez", "Diana Patel", "Evan Kim", "Fatima Noor"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_volunteers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ListView listView = view.findViewById(R.id.volunteer_list);
        TextView detailTitle = view.findViewById(R.id.volunteer_detail_title);
        TextView detailBody = view.findViewById(R.id.volunteer_detail_body);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_list_item_activated_1, VOLUNTEERS);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setItemChecked(0, true);
        updateDetail(detailTitle, detailBody, VOLUNTEERS[0]);

        listView.setOnItemClickListener((parent, itemView, position, id) ->
                updateDetail(detailTitle, detailBody, VOLUNTEERS[position]));
    }

    private void updateDetail(TextView title, TextView body, String volunteer) {
        title.setText(volunteer);
        body.setText("Status: Active\nHours this month: 18\nProgram: Pantry Support\n\n"
                + "Planned detail modules:\n"
                + "• Contact and emergency profile\n"
                + "• Availability and skill tags\n"
                + "• Attendance and hour ledger\n"
                + "• Required form completion state");
    }
}
