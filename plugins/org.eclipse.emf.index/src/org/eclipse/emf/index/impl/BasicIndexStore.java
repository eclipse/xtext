package org.eclipse.emf.index.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.EReferenceDescriptor;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EPackageDescriptor;
import org.eclipse.emf.index.event.IndexChangeEvent;
import org.eclipse.emf.index.event.IndexChangeListener;

import com.google.inject.Inject;

public abstract class BasicIndexStore implements IndexStore {

	protected EClassDescriptor.DAO eClassDAO;

	protected ResourceDescriptor.DAO resourceDAO;

	protected EObjectDescriptor.DAO eObjectDAO;

	protected EReferenceDescriptor.DAO eReferenceDAO;

	protected EPackageDescriptor.DAO ePackageDAO;

	private List<IndexChangeEvent> firedEvents = new ArrayList<IndexChangeEvent>();

	private boolean isInTransaction = false;

	private List<IndexChangeListener> indexChangeListeners = new ArrayList<IndexChangeListener>();

	@Inject
	public BasicIndexStore(EClassDescriptor.DAO eClassDao, ResourceDescriptor.DAO resourceDao,
			EObjectDescriptor.DAO eObjectDao, EReferenceDescriptor.DAO eReferenceDao, EPackageDescriptor.DAO ePackageDao) {
		eClassDAO = eClassDao;
		resourceDAO = resourceDao;
		eObjectDAO = eObjectDao;
		eReferenceDAO = eReferenceDao;
		ePackageDAO = ePackageDao;
		initializeDAOs();
	}

	public EClassDescriptor.DAO eClassDAO() {
		return eClassDAO;
	}

	public ResourceDescriptor.DAO resourceDAO() {
		return resourceDAO;
	}

	public EObjectDescriptor.DAO eObjectDAO() {
		return eObjectDAO;
	}

	public EReferenceDescriptor.DAO eReferenceDAO() {
		return eReferenceDAO;
	}

	public EPackageDescriptor.DAO ePackageDAO() {
		return ePackageDAO;
	}

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
	
	protected void initializeDAOs() {
		ePackageDAO.initialize(this);
		eClassDAO.initialize(this);
		resourceDAO.initialize(this);
		eObjectDAO.initialize(this);
		eReferenceDAO.initialize(this);
	}


}
