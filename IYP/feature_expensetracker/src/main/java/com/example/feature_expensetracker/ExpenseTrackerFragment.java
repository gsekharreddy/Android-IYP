package com.example.feature_expensetracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Transaction;

import com.example.feature_expensetracker.databinding.FragmentExpenseTrackerBinding;
import java.util.ArrayList;
import java.util.List;

public class ExpenseTrackerFragment extends Fragment {

	private FragmentExpenseTrackerBinding binding;
	private TransactionAdapter adapter;
	private List<com.example.iyp.core.models.Transaction> transactionList = new ArrayList<>();

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		binding = FragmentExpenseTrackerBinding.inflate(inflater, container, false);
		return binding.getRoot();
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		setupRecyclerView();
		loadSampleData();
		updateSummary();

		binding.fabAddTransaction.setOnClickListener(v -> {
			Toast.makeText(getContext(), "Add new transaction clicked!", Toast.LENGTH_SHORT).show();
			// Navigate to an "Add Transaction" screen
		});
	}

	private void setupRecyclerView() {
		adapter = new TransactionAdapter(transactionList);
		binding.transactionsRecyclerView.setAdapter(adapter);
	}

	private void loadSampleData() {
		// In a real app, this data would come from a database
		transactionList.add(new com.example.iyp.core.models.Transaction("Groceries", "Shopping", -55.20));
		transactionList.add(new Transaction("Monthly Salary", "Income", 2000.00));
		transactionList.add(new Transaction("Lunch at Cafe", "Food", -15.50));
		transactionList.add(new Transaction("Gas Bill", "Utilities", -75.00));
		adapter.notifyDataSetChanged();
	}

	private void updateSummary() {
		double totalExpenses = transactionList.stream()
				.filter(t -> t.getAmount() < 0)
				.mapToDouble(Transaction::getAmount)
				.sum();

		double totalIncome = transactionList.stream()
				.filter(t -> t.getAmount() > 0)
				.mapToDouble(Transaction::getAmount)
				.sum();

		double balance = totalIncome + totalExpenses; // totalExpenses is already negative

		binding.balanceTextView.setText(String.format("$%,.2f", balance));
		binding.expensesTextView.setText(String.format("$%,.2f", totalExpenses * -1)); // Display as positive number
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}
}
