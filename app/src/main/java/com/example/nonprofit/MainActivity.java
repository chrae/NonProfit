package com.example.nonprofit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.nonprofit.ui.CommunityServiceFragment;
import com.example.nonprofit.ui.DashboardFragment;
import com.example.nonprofit.ui.InventoryFragment;
import com.example.nonprofit.ui.PlaceholderFragment;
import com.example.nonprofit.ui.VolunteersFragment;
import com.google.android.material.navigationrail.NavigationRailView;

public class MainActivity extends AppCompatActivity {

    private NavigationRailView navigationRail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationRail = findViewById(R.id.navigation_rail);
        navigationRail.setOnItemSelectedListener(item -> {
            navigateTo(item.getItemId());
            return true;
        });

        if (savedInstanceState == null) {
            navigationRail.setSelectedItemId(R.id.nav_dashboard);
        }
    }

    private void navigateTo(int itemId) {
        Fragment fragment;
        if (itemId == R.id.nav_dashboard) {
            fragment = new DashboardFragment();
        } else if (itemId == R.id.nav_volunteers) {
            fragment = new VolunteersFragment();
        } else if (itemId == R.id.nav_community_service) {
            fragment = new CommunityServiceFragment();
        } else if (itemId == R.id.nav_inventory) {
            fragment = new InventoryFragment();
        } else if (itemId == R.id.nav_donations) {
            fragment = PlaceholderFragment.newInstance(
                    "Donations",
                    "Track gift pipelines, acknowledgement letters, and donor follow-up tasks.");
        } else if (itemId == R.id.nav_events) {
            fragment = PlaceholderFragment.newInstance(
                    "Events / Scheduling",
                    "Coordinate schedules, shifts, and event planning across volunteers and staff.");
        } else if (itemId == R.id.nav_tasks) {
            fragment = PlaceholderFragment.newInstance(
                    "Tasks",
                    "Capture operational work items, ownership, and completion status.");
        } else if (itemId == R.id.nav_documents) {
            fragment = PlaceholderFragment.newInstance(
                    "Documents / Forms",
                    "Manage forms, packet templates, and printable compliance paperwork.");
        } else if (itemId == R.id.nav_organizations) {
            fragment = PlaceholderFragment.newInstance(
                    "Organizations / Partners",
                    "Track partner agencies, incoming referrals, and inter-agency cooperation.");
        } else if (itemId == R.id.nav_reports) {
            fragment = PlaceholderFragment.newInstance(
                    "Reports",
                    "Build program, operational, and compliance reporting views.");
        } else {
            fragment = PlaceholderFragment.newInstance(
                    "Settings / Admin",
                    "Configure permissions, templates, and organization-wide defaults.");
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_container, fragment)
                .commit();
    }
}
