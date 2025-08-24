package com.example.feature_calendar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CalendarFragment extends Fragment {

	private CalendarView calendarView;
	private RecyclerView eventsRecyclerView;
	private FloatingActionButton fabAddEvent;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_calendar, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		// Initialize your views
		calendarView = view.findViewById(R.id.calendarView);
		eventsRecyclerView = view.findViewById(R.id.eventsRecyclerView);
		fabAddEvent = view.findViewById(R.id.fabAddEvent);

		// Set up listeners and logic
		setupListeners();
	}

	private void setupListeners() {
		// Listener for when the user selects a new date on the calendar
		calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
			@Override
			public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
				// The month is 0-based, so add 1 for display
				String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
				Toast.makeText(getContext(), "Selected date: " + selectedDate, Toast.LENGTH_SHORT).show();

				// TODO: Add logic here to fetch and display events for the selected date
			}
		});

		// Listener for the "Add Event" floating action button
		fabAddEvent.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO: Use Navigation Component instead of manual transaction
				Toast.makeText(getContext(), "Add new event clicked!", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
