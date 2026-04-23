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

public class CommunityServiceFragment extends Fragment {

    private static final String[] CASE_QUEUE = new String[]{
            "Jordan R. • 4 hours pending verification",
            "Morgan T. • Intake interview due",
            "Sam K. • 8 hours scheduled this week",
            "Taylor A. • Completion packet required"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_community_service, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ListView listView = view.findViewById(R.id.community_service_queue);
        TextView detailBody = view.findViewById(R.id.community_service_detail_body);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_list_item_activated_1, CASE_QUEUE);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setItemChecked(0, true);
        updateDetail(detailBody, CASE_QUEUE[0]);

        listView.setOnItemClickListener((parent, itemView, position, id) ->
                updateDetail(detailBody, CASE_QUEUE[position]));
    }

    private void updateDetail(TextView detailBody, String selectedCase) {
        detailBody.setText(selectedCase + "\n\n"
                + "Next actions:\n"
                + "• Confirm supervisor signature\n"
                + "• Validate hours against work log\n"
                + "• Generate completion letter\n"
                + "• Notify referring agency");
    }
}
