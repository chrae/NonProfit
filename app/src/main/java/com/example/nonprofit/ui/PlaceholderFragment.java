package com.example.nonprofit.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nonprofit.R;

public class PlaceholderFragment extends Fragment {

    private static final String ARG_TITLE = "arg_title";
    private static final String ARG_PURPOSE = "arg_purpose";

    public static PlaceholderFragment newInstance(String title, String purpose) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_PURPOSE, purpose);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        String title = args != null ? args.getString(ARG_TITLE, "Module") : "Module";
        String purpose = args != null ? args.getString(ARG_PURPOSE, "Planned module") : "Planned module";

        ((TextView) view.findViewById(R.id.placeholder_title)).setText(title);
        ((TextView) view.findViewById(R.id.placeholder_purpose)).setText(purpose);
    }
}
