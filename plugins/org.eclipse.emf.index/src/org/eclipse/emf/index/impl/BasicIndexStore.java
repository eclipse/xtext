/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.EReferenceDescriptor;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EPackageDescriptor;
import org.eclipse.emf.index.event.IndexChangeEvent;
import org.eclipse.emf.index.event.IndexChangeListener;

import com.google.inject.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class BasicIndexStore implements IndexStore {

	protected EClassDescriptor.DAO eClassDAO;

	protected ResourceDescriptor.DAO resourceDAO;

	protected EObjectDescriptor.DAO eObjectDAO;

	protected EReferenceDescriptor.DAO eReferenceDAO;

	protected EPackageDescriptor.DAO ePackageDAO;

	private List<IndexChangeEvent> firedEvents = new ArrayList<IndexChangeEvent>();

	private boolean isInTransaction = false;

	protected ReadWriteLock readWriteLock;

	private List<IndexChangeListener> indexChangeListeners = new ArrayList<IndexChangeListener>();

	@Inject
	public BasicIndexStore(EClassDescriptor.DAO eClassDao, ResourceDescriptor.DAO resourceDao,
			EObjectDescriptor.DAO eObjectDao, EReferenceDescriptor.DAO eReferenceDao, EPackageDescriptor.DAO ePackageDao) {
		readWriteLock = new ReentrantReadWriteLock();
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

	public void beginWrite() {
		readWriteLock.writeLock().lock();
		if (isInTransaction)
			throw new IllegalStateException("Transaction already open");
		isInTransaction = true;
	}

	public void endWrite() {
		if (!isInTransaction)
			throw new IllegalStateException("Transaction not open");
		synchronized (indexChangeListeners) {
			for (IndexChangeEvent event : firedEvents)
				fireEventNow(event);
			firedEvents.clear();
		}
		isInTransaction = false;
		readWriteLock.writeLock().unlock();
	}

	public void beginRead() {
		readWriteLock.readLock().lock();
	}

	public void endRead() {
		readWriteLock.readLock().unlock();
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
