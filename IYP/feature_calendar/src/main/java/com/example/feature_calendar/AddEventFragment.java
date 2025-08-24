package com.example.feature_calendar;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.google.android.material.textfield.TextInputEditText;


public class AddEventFragment extends Fragment {


	private TextInputEditText titleInput, descInput;
	private EditText startTimeInput, endTimeInput;
	private Button saveButton;


	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_add_event, container, false);
	}


	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);


		titleInput = view.findViewById(R.id.inputTitle);
		descInput = view.findViewById(R.id.inputDesc);
		startTimeInput = view.findViewById(R.id.inputStartTime);
		endTimeInput = view.findViewById(R.id.inputEndTime);
		saveButton = view.findViewById(R.id.btnSave);


		saveButton.setOnClickListener(v -> {
			String title = titleInput.getText().toString().trim();
			String desc = descInput.getText().toString().trim();
			String start = startTimeInput.getText().toString().trim();
			String end = endTimeInput.getText().toString().trim();


			if (title.isEmpty() || start.isEmpty() || end.isEmpty()) {
				Toast.makeText(getContext(), "Please fill all required fields", Toast.LENGTH_SHORT).show();
				return;
			}


// TODO: Save new Event (later integrate with DB or shared ViewModel)
			Toast.makeText(getContext(), "Event saved: " + title, Toast.LENGTH_SHORT).show();


// Pop back to CalendarFragment
			requireActivity().getSupportFragmentManager().popBackStack();
		});
	}
}