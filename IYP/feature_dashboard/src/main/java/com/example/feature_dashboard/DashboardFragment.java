package com.example.feature_dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.feature_dashboard.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

	private FragmentDashboardBinding binding;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// Inflate the layout using ViewBinding
		binding = FragmentDashboardBinding.inflate(inflater, container, false);
		return binding.getRoot();
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		// Set up navigation for dashboard cards
		setupNavigationListeners();
	}

	private void setupNavigationListeners() {
		if (binding == null) return;

		// Productivity
		binding.cardTaskManager.setOnClickListener(v ->
				NavHostFragment.findNavController(this).navigate(R.id.action_dashboard_to_tasks));

		binding.cardNotes.setOnClickListener(v ->
				NavHostFragment.findNavController(this).navigate(R.id.action_dashboard_to_notes));

		binding.cardHabitTracker.setOnClickListener(v ->
				NavHostFragment.findNavController(this).navigate(R.id.action_dashboard_to_habits));

		binding.cardExpenseTracker.setOnClickListener(v ->
				NavHostFragment.findNavController(this).navigate(R.id.action_dashboard_to_expenses));

		// Social
		binding.cardCalendar.setOnClickListener(v ->
				NavHostFragment.findNavController(this).navigate(R.id.action_dashboard_to_calendar));

		binding.cardWhiteboard.setOnClickListener(v ->
				NavHostFragment.findNavController(this).navigate(R.id.action_dashboard_to_whiteboard));

		// Wellness
		binding.cardMoodJournal.setOnClickListener(v ->
				NavHostFragment.findNavController(this).navigate(R.id.action_dashboard_to_mood));

		binding.cardRelaxation.setOnClickListener(v ->
				NavHostFragment.findNavController(this).navigate(R.id.action_dashboard_to_relaxation));
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		// Avoid memory leaks
		binding = null;
	}
}
