package com.example.feature_focustimer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.feature_focustimer.databinding.FragmentFocusTimerBinding;

public class FocusTimerFragment extends Fragment {

	private FragmentFocusTimerBinding binding;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {
		binding = FragmentFocusTimerBinding.inflate(inflater, container, false);
		return binding.getRoot();
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		// Dummy setup: Start/Stop timer buttons
		binding.btnStart.setOnClickListener(v -> binding.tvTimer.setText("Focus started... ⏳"));

		binding.btnStop.setOnClickListener(v -> binding.tvTimer.setText("Focus stopped. ✅"));
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}
}
