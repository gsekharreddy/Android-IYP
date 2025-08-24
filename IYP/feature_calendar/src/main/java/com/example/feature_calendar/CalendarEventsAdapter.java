package com.example.feature_calendar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
// You would create this Event class in your :core module
// import com.yourcompany.iyp.core.models.Event;

public class CalendarEventsAdapter extends RecyclerView.Adapter<CalendarEventsAdapter.EventViewHolder> {

	// This list will hold the data to be displayed.
	// You would pass this list in from your CalendarFragment.
	private List<Object> eventList; // Replace 'Object' with your actual Event model class

	public CalendarEventsAdapter(List<Object> eventList) {
		this.eventList = eventList;
	}

	/**
	 * This method is called when the RecyclerView needs a new ViewHolder.
	 * It inflates the item_calendar_event.xml layout.
	 */
	@NonNull
	@Override
	public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.item_calendar_event, parent, false);
		return new EventViewHolder(view);
	}

	/**
	 * This method is called to display the data at a specific position.
	 * It gets an event from the list and binds its data to the views in the ViewHolder.
	 */
	@Override
	public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
		// Get the event object for the current position
		// Event event = eventList.get(position); // Uncomment when you have your Event model

		// TODO: Bind the data from your 'event' object to the holder's views
		// For example:
		// holder.eventTitleTextView.setText(event.getTitle());
		// holder.eventTimeTextView.setText(event.getTimeRange());
		// holder.eventColorIndicator.setBackgroundColor(event.getColor());

		// For now, we'll use placeholder text
		holder.eventTitleTextView.setText("Sample Event Title");
		holder.eventTimeTextView.setText("12:00 PM - 1:00 PM");
	}

	/**
	 * Returns the total number of items in the list.
	 */
	@Override
	public int getItemCount() {
		return eventList == null ? 0 : eventList.size();
	}

	/**
	 * The ViewHolder class holds the views for a single item in the list.
	 * This is where you declare the UI components from your item_calendar_event.xml layout.
	 */
	public static class EventViewHolder extends RecyclerView.ViewHolder {
		View eventColorIndicator;
		TextView eventTitleTextView;
		TextView eventTimeTextView;

		public EventViewHolder(@NonNull View itemView) {
			super(itemView);
			eventColorIndicator = itemView.findViewById(R.id.eventColorIndicator);
			eventTitleTextView = itemView.findViewById(R.id.eventTitleTextView);
			eventTimeTextView = itemView.findViewById(R.id.eventTimeTextView);

			// TODO: You can set an OnClickListener for the whole item here
			itemView.setOnClickListener(v -> {
				// Handle item click logic, e.g., open event details
			});
		}
	}
}
