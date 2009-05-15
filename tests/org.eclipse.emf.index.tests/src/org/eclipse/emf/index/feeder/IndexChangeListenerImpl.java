package org.eclipse.emf.index.feeder;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.index.event.IndexChangeEvent;
import org.eclipse.emf.index.event.IndexChangeListener;

public class IndexChangeListenerImpl implements IndexChangeListener {

	List<IndexChangeEvent> events = new ArrayList<IndexChangeEvent>();
	
	public void indexChanged(IndexChangeEvent event) {
		events.add(event);
	}

	public List<IndexChangeEvent> getEvents() {
		return events;
	}
	
	public void clearEvents() {
		events.clear();
	}
}
