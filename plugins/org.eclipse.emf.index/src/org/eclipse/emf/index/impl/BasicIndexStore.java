package org.eclipse.emf.index.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.event.IndexChangeEvent;
import org.eclipse.emf.index.event.IndexChangeListener;

public abstract class BasicIndexStore implements IIndexStore {

	private List<IndexChangeEvent> firedEvents = new ArrayList<IndexChangeEvent>();

	private boolean isInTransaction = false;

	private List<IndexChangeListener> indexChangeListeners = new ArrayList<IndexChangeListener>();

	public void addIndexChangeListener(IndexChangeListener listener) {
		synchronized (indexChangeListeners) {
			indexChangeListeners.add(listener);
		}
	}

	public void removeIndexChangeListener(IndexChangeListener listener) {
		synchronized (indexChangeListeners) {
			indexChangeListeners.remove(listener);
		}
	}

	public void beginTransaction() {
		firedEvents.clear();
		if (isInTransaction)
			throw new IllegalStateException("Transaction already open");
		isInTransaction = true;
	}

	public void endTransaction() {
		if (!isInTransaction)
			throw new IllegalStateException("Transaction not open");
		synchronized (indexChangeListeners) {
			for (IndexChangeEvent event : firedEvents)
				fireEventNow(event);
		}
		isInTransaction = false;
	}

	private void fireEventNow(IndexChangeEvent event) {
		for (IndexChangeListener indexChangeListener : indexChangeListeners) {
			indexChangeListener.indexChanged(event);
		}
	}

	/**
	 * Should be called by DAOs only.
	 * 
	 * @param event
	 */
	public void fireIndexChangedEvent(IndexChangeEvent event) {
		if (isInTransaction)
			firedEvents.add(event);
		else
			fireEventNow(event);
	}

}
