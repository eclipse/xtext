/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import static com.google.common.collect.Lists.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.xtext.resource.ISynchronizable;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.DirtyStateEditorSupport;
import org.eclipse.xtext.ui.editor.model.IXtextDocumentContentObserver.Processor;
import org.eclipse.xtext.ui.editor.model.edit.ITextEditComposer;
import org.eclipse.xtext.ui.editor.model.edit.ReconcilingUnitOfWork;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 * @author Jan Koehnlein
 */
public class XtextDocument extends Document implements IXtextDocument {

	private DocumentTokenSource tokenSource;

	private ITextEditComposer composer;

	@Inject
	public XtextDocument(DocumentTokenSource tokenSource, ITextEditComposer composer) {
		this.tokenSource = tokenSource;
		tokenSource.computeDamageRegion(new DocumentEvent(this, 0, getLength(), this.get()));
		this.composer = composer;
	}

	private XtextResource resource = null;
	private final List<IXtextModelListener> modelListeners = new ArrayList<IXtextModelListener>();
	private final ListenerList xtextDocumentObservers = new ListenerList(ListenerList.IDENTITY);

	public void setInput(XtextResource resource) {
		Assert.isNotNull(resource);
		this.resource = resource;
	}

	public void disposeInput() {
		if (validationJob != null) {
			validationJob.cancel();
		}
		internalModify(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				resource = null;
			}
		});
	}

	private final XtextDocumentLocker stateAccess = createDocumentLocker();

	protected XtextDocumentLocker createDocumentLocker() {
		return new XtextDocumentLocker();
	}

	public <T> T readOnly(IUnitOfWork<T, XtextResource> work) {
		return stateAccess.readOnly(work);
	}
	
	private final static IUnitOfWork.Void<XtextResource> noWork = new IUnitOfWork.Void<XtextResource>() {
		@Override
		public void process(XtextResource state) throws Exception {}
	};

	public <T> T modify(IUnitOfWork<T, XtextResource> work) {
		// do a dummy read only, to make sure any scheduled changes get applied.
		readOnly(noWork);
		IUnitOfWork<T, XtextResource> reconcilingUnitOfWork = new ReconcilingUnitOfWork<T>(work, this, composer);
		return internalModify(reconcilingUnitOfWork);
	}

	/**
	 * Modifies the document's semantic model without reconciling the text nor the node model. For internal use only.
	 */
	public <T> T internalModify(IUnitOfWork<T, XtextResource> work) {
		return stateAccess.modify(work);
	}

	protected void ensureThatStateIsNotReturned(Object exec, IUnitOfWork<?, XtextResource> uow) {
		// TODO activate
		// if (exec instanceof EObject) {
		// if (((EObject) exec).eResource() == resource
		// || ((exec instanceof AbstractNode) &&
		// NodeUtil.getNearestSemanticObject((AbstractNode) exec)
		// .eResource() == resource))
		// throw new IllegalStateException(
		// "The unit of work returned state from the resource. This is causing race condition problems and therefore not allowed! "+uow.getClass().getName());
		// }
	}

	public void addModelListener(IXtextModelListener listener) {
		Assert.isNotNull(listener);
		synchronized (modelListeners) {
			if (modelListeners.contains(listener))
				return;
			if (listener instanceof DirtyStateEditorSupport) {
				modelListeners.add(0,listener);
			} else {
				modelListeners.add(listener);
			}
		}
	}

	public void removeModelListener(IXtextModelListener listener) {
		Assert.isNotNull(listener);
		synchronized (modelListeners) {
			modelListeners.remove(listener);
		}
	}

	protected void notifyModelListeners(XtextResource res) {
		if (res == null || res != this.resource)
			return;
		List<IXtextModelListener> modelListenersCopy;
		synchronized (modelListeners) {
			modelListenersCopy = newArrayList(modelListeners);
		}
		for (IXtextModelListener listener : modelListenersCopy){
			try {
				if (res != this.resource) {
					return;
				}
				listener.modelChanged(res);
			} catch(Exception exc) {
				log.error("Error in IXtextModelListener", exc);
			}
		}
	}

	public void addXtextDocumentContentObserver(IXtextDocumentContentObserver observer) {
		addDocumentListener(observer);
		xtextDocumentObservers.add(observer);
	}

	public void removeXtextDocumentContentObserver(IXtextDocumentContentObserver observer) {
		xtextDocumentObservers.remove(observer);
		removeDocumentListener(observer);
	}

	/**
	 * @since 2.7
	 */
	protected boolean updateContentBeforeRead() {
		Object[] listeners = xtextDocumentObservers.getListeners();
		boolean hadUpdates = false;
		for (int i = 0; i < listeners.length; i++) {
			hadUpdates |= ((IXtextDocumentContentObserver) listeners[i]).performNecessaryUpdates(stateAccess);
		}
		return hadUpdates;
	}
	
	/**
	 * @since 2.7
	 */
	protected boolean hasPendingUpdates() {
		Object[] listeners = xtextDocumentObservers.getListeners();
		for (int i = 0; i < listeners.length; i++) {
			if(((IXtextDocumentContentObserver) listeners[i]).hasPendingUpdates())
				return true;
		}
		return false;
	}
	
	private static class ReaderMonitor implements CancelIndicator {

		private boolean isCanceled = false;

		public void setCanceled(boolean isCanceled) {
			this.isCanceled = isCanceled;
		}
		
		public boolean isCanceled() {
			return isCanceled;
		}
	}

	private volatile ReaderMonitor readerMonitor = new ReaderMonitor();
	
	/**
	 * @author Sven Efftinge - Initial contribution and API
	 * 
	 */
	protected class XtextDocumentLocker implements Processor {
		
		private volatile int potentialUpdaterCount = 0;
		
		private volatile boolean hadUpdates;
		
		private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

		private final Lock writeLock = rwLock.writeLock();

		private final Lock readLock = rwLock.readLock();

		private ThreadLocal<Integer> readLockCount = new ThreadLocal<Integer>() {
			@Override
			protected Integer initialValue() {
				return 0;
			}
		};
		
		/**
		 * Upgrades a read transaction to a write transaction, executes the work then downgrades to a read transaction
		 * again.
		 * 
		 * @noreference
		 * @since 2.7
		 */
		public <T> T process(IUnitOfWork<T,XtextResource> transaction) {
			releaseReadLock();
			// lock upgrade followed by downgrade as described in
			// java.util.concurrent.locks.ReentrantReadWriteLock
			// 
			// caveat: other readers/writers could potentially kick in here
			acquireWriteLock();
			try {
				if (log.isTraceEnabled())
					log.trace("process - " + Thread.currentThread().getName());
				return this.modify(transaction);
			} finally {
				if (log.isTraceEnabled())
					log.trace("Downgrading from write lock to read lock...");
				acquireReadLock();
				releaseWriteLock();
			}
		}

		/**
		 * Queries the number of reentrant write holds on this lock by the current thread. Delegates to
		 * {@link ReentrantReadWriteLock#getWriteHoldCount()}.
		 * 
		 * @return the number of holds on the write lock by the current thread, or zero if the write lock is not held by the
		 *         current thread
		 * @since 2.7
		 * @noreference
		 */
		protected int getWriteHoldCount() {
			return rwLock.getWriteHoldCount();
		}

		/**
		 * Queries the number of reentrant read holds on this lock by the current thread. A reader thread has a hold on a
		 * lock for each lock action that is not matched by an unlock action.
		 * 
		 * That functionality is implemented in {@link ReentrantReadWriteLock} as well, but not before version 1.6. This is
		 * why we have to find our own way to work around it.
		 * 
		 * @return the number of holds on the read lock by the current thread, or zero if the read lock is not held by the
		 *         current thread
		 * @since 2.7
		 * @noreference
		 */
		protected int getReadHoldCount() {
			return readLockCount.get();
		}

		private void acquireReadLock() {
			if (log.isTraceEnabled())
				log.trace("Trying to acquire read lock...");
			readLock.lock();
			readLockCount.set(readLockCount.get() + 1);
			if (log.isTraceEnabled())
				log.trace("...read lock acquired.");
		}

		private void releaseReadLock() {
			readLock.unlock();
			readLockCount.set(readLockCount.get() - 1);
			if (log.isTraceEnabled())
				log.trace("Read lock released.");
		}

		private void acquireWriteLock() {
			if (validationJob!=null) {
				validationJob.cancel();
			}
			readerMonitor.setCanceled(true);
			if (log.isTraceEnabled())
				log.trace("Trying to acquire write lock...");
			writeLock.lock();
			if (log.isTraceEnabled())
				log.trace("...write lock acquired.");
			// next reader will get a fresh monitor instance
			readerMonitor = new ReaderMonitor();
		}

		private void releaseWriteLock() {
			writeLock.unlock();
			if (log.isTraceEnabled())
				log.trace("Write lock released.");
		}
		
		protected XtextResource getState() {
			return resource;
		}

		public <T> T modify(IUnitOfWork<T, XtextResource> work) {
			try {
				XtextResource state = getState();
				try {
					synchronized (getResourceLock()) {
						acquireWriteLock();
						T exec = null;
						try {
							potentialUpdaterCount++;
							state = getState();
							if (log.isDebugEnabled())
								log.debug("write - " + Thread.currentThread().getName());
							exec = work.exec(state);
							return exec;
						} catch (RuntimeException e) {
							throw e;
						} catch (Exception e) {
							throw new WrappedException(e);
						} finally {
							try {
								// downgrade lock to read lock 
								acquireReadLock();
								releaseWriteLock();
								ensureThatStateIsNotReturned(exec, work);
								--potentialUpdaterCount;
								if(potentialUpdaterCount == 0 && !(work instanceof ReconcilingUnitOfWork))
									notifyModelListeners(state);
							} finally {
								releaseReadLock();
							}
						}
					}
				} catch (RuntimeException e) {
					try {
						if (state != null)
							state.reparse(get());
					} catch (IOException ioe) {
					}
					throw e;
				}
			} finally {
				if(!(work instanceof ReconcilingUnitOfWork))
					checkAndUpdateAnnotations();
			}
		}
		
		/**
		 * @since 2.4
		 */
		public <T> T readOnly(IUnitOfWork<T, XtextResource> work) {
			if(hasPendingUpdates()) 
				readerMonitor.setCanceled(true);
			XtextResource state = getState();
			synchronized (getResourceLock()) {
				acquireReadLock();
				try {
					potentialUpdaterCount++;
					if (log.isDebugEnabled())
						log.debug("read - " + Thread.currentThread().getName());
					// Don't updateContent on write lock request. Reentrant read doesn't matter as 
					// updateContentBeforeRead() is cheap when the pending event queue is swept
					if (getReadHoldCount() == 1 && getWriteHoldCount() == 0) {
						hadUpdates |= updateContentBeforeRead();
					}
					if(work instanceof CancelableUnitOfWork) 
						((CancelableUnitOfWork<?, XtextResource>) work).setCancelIndicator(readerMonitor);
					T exec = work.exec(state);
					ensureThatStateIsNotReturned(exec, work);
					return  exec;
				} catch (RuntimeException e) {
					throw e;
				} catch (Exception e) {
					throw new WrappedException(e);
				} finally {
					--potentialUpdaterCount;
					if(potentialUpdaterCount == 0 && hadUpdates) { 
						hadUpdates = false;	
						notifyModelListeners(resource);
					}
					releaseReadLock();
				}
			}
		}
	}
	
	/**
	 * Introduced in 2.7 to allow read-only transactions to be cancelable. The default implementation disabled
	 * concurrent reads on the model. To re-enable concurrent reads, return a new {@link Object} on each call.
	 * 
	 * Caveat: Concurrent read is problematic in EMF because proxy resolution and resource un-/loading are considered
	 * read-only but actually change the model. This yields serious race conditions. Consider using 
	 * {@link CancelableUnitOfWork}s instead.
	 * 
	 * @since 2.7
	 */
	protected Object getResourceLock() {
		if (resource != null) {
			return (resource instanceof ISynchronizable<?>) 
					? ((ISynchronizable<?>) resource).getLock() 
							: resource;
		} else {
			return this;
		}
	}
	
	private static final Logger log = Logger.getLogger(XtextDocument.class);

	private transient Job validationJob;

	public void setValidationJob(Job validationJob) {
		this.validationJob = validationJob;
	}

	public Job getValidationJob() {
		return validationJob;
	}

	public void checkAndUpdateAnnotations() {
		if (validationJob!=null) {
			validationJob.cancel();
			if (resource != null) {
				validationJob.schedule();
			}
		}
	}
	
	/**
	 * Returns the {@link URI uri} of the associated {@link org.eclipse.emf.ecore.resource.Resource emf resource}.
	 * May be null if no resource is available or its uri is <code>null</code>.
	 * @return the resource uri if available.
	 * @since 2.1
	 */
	public URI getResourceURI() {
		XtextResource resource = this.resource;
		if (resource != null)
			return resource.getURI();
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> T getAdapter(Class<T> adapterType) {
		XtextResource resource = this.resource;
		if (resource == null)
			return null;
		URI uri = resource.getURI();
		if ((adapterType == IFile.class || adapterType == IResource.class) && uri.isPlatformResource()) {
			return (T) ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
		}
		return null;
	}

	/*
	 * fix for https://bugs.eclipse.org/bugs/show_bug.cgi?id=297946
	 */
	private ReadWriteLock positionsLock = new ReentrantReadWriteLock();
	private Lock positionsReadLock = positionsLock.readLock();
	private Lock positionsWriteLock = positionsLock.writeLock();

	@Override
	public Position[] getPositions(String category, int offset, int length, boolean canStartBefore, boolean canEndAfter)
			throws BadPositionCategoryException {
		positionsReadLock.lock();
		try {
			return super.getPositions(category, offset, length, canStartBefore, canEndAfter);
		} finally {
			positionsReadLock.unlock();
		}
	}

	@Override
	public Position[] getPositions(String category) throws BadPositionCategoryException {
		positionsReadLock.lock();
		try {
			return super.getPositions(category);
		} finally {
			positionsReadLock.unlock();
		}
	}

	@Override
	public void addPosition(Position position) throws BadLocationException {
		positionsWriteLock.lock();
		try {
			super.addPosition(position);
		} finally {
			positionsWriteLock.unlock();
		}
	}

	@Override
	public void addPosition(String category, Position position) throws BadLocationException,
			BadPositionCategoryException {
		positionsWriteLock.lock();
		try {
			super.addPosition(category, position);
		} finally {
			positionsWriteLock.unlock();
		}
	}

	@Override
	public void removePosition(Position position) {
		positionsWriteLock.lock();
		try {
			super.removePosition(position);
		} finally {
			positionsWriteLock.unlock();
		}
	}

	@Override
	public void removePosition(String category, Position position) throws BadPositionCategoryException {
		positionsWriteLock.lock();
		try {
			super.removePosition(category, position);
		} finally {
			positionsWriteLock.unlock();
		}
	}

	@Override
	protected void fireDocumentChanged(DocumentEvent event) {
		tokenSource.updateStructure(event);
		super.fireDocumentChanged(event);
	}

	public IRegion getLastDamage() {
		return tokenSource.getLastDamagedRegion();
	}

	public Iterable<ILexerTokenRegion> getTokens() {
		return tokenSource.getTokenInfos();
	}
}
