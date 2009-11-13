/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Document;
import org.eclipse.ui.IEditorInput;
import org.eclipse.xtext.resource.EObjectHandleImpl;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.IDirtyResource;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocumentContentObserver.Processor;
import org.eclipse.xtext.util.concurrent.IEObjectHandle;
import org.eclipse.xtext.util.concurrent.IStateAccess;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtextDocument extends Document implements IXtextDocument {

	private XtextResource resource = null;
	
	private IDirtyResource dirtyResource = new IDirtyResource() {
		
		public URI getURI() {
			return resource.getURI();
		}
		
		public Iterable<String> getImportedNames() {
			// TODO: UnitOfWork?
			return resource.getImportedNamesProvider().getImportedNames(resource);
		}
		
		public Iterable<IEObjectDescription> getExportedObjects() {
			// TODO: UnitOfWork?
			return resource.getExportedEObjectsProvider().getExportedObjects(resource);
		}
		
		public String getContents() {
			return get();
		}
	};

	private final ListenerList modelListeners = new ListenerList(ListenerList.IDENTITY);

	private final ListenerList xtextDocumentObservers = new ListenerList(ListenerList.IDENTITY);

	@Inject
	private IResourceForEditorInputFactory resourceForEditorInputFactory;

	public void setInput(IEditorInput editorInput) {
		setInput((XtextResource) resourceForEditorInputFactory.createResource(editorInput));
	}

	public void setInput(XtextResource resource) {
		this.resource = resource;
		try {
			this.resource.load(null);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	private final XtextDocumentLocker stateAccess = new XtextDocumentLocker();

	public <T> T readOnly(IUnitOfWork<T, XtextResource> work) {
		return stateAccess.readOnly(work);
	}

	public <T> T modify(IUnitOfWork<T, XtextResource> work) {
		try {
			validationJob.cancel();
			return stateAccess.modify(work);
		} finally {
			checkAndUpdateAnnotations();
		}
	}

	private void ensureThatStateIsNotReturned(Object exec, IUnitOfWork<?, XtextResource> uow) {
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
		modelListeners.add(listener);
	}

	public void removeModelListener(IXtextModelListener listener) {
		Assert.isNotNull(listener);
		modelListeners.remove(listener);
	}

	private void notifyModelListeners(XtextResource res) {
		Object[] listeners = modelListeners.getListeners();
		for (int i = 0; i < listeners.length; i++) {
			((IXtextModelListener) listeners[i]).modelChanged(res);
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

	private <T> void updateContentBeforeRead() {
		Object[] listeners = xtextDocumentObservers.getListeners();
		for (int i = 0; i < listeners.length; i++) {
			((IXtextDocumentContentObserver) listeners[i]).performNecessaryUpdates(stateAccess);
		}
	}

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 * 
	 */
	private final class XtextDocumentLocker extends IStateAccess.AbstractImpl<XtextResource> implements Processor {
		@Override
		protected XtextResource getState() {
			return resource;
		}

		@Override
		protected void beforeReadOnly(XtextResource res, IUnitOfWork<?, XtextResource> work) {
			if (log.isDebugEnabled())
				log.debug("read - " + Thread.currentThread().getName());
			updateContentBeforeRead();
		}

		@Override
		protected void beforeModify(XtextResource state, IUnitOfWork<?, XtextResource> work) {
			if (log.isDebugEnabled())
				log.debug("write - " + Thread.currentThread().getName());
		}

		@Override
		protected void afterReadOnly(XtextResource res, Object result, IUnitOfWork<?, XtextResource> work) {
			ensureThatStateIsNotReturned(result, work);
		}

		@Override
		protected void afterModify(XtextResource res, Object result, IUnitOfWork<?, XtextResource> work) {
			ensureThatStateIsNotReturned(result, work);
			notifyModelListeners(resource);
		}

		@Override
		public <T> T modify(IUnitOfWork<T, XtextResource> work) {
			try {
				return super.modify(work);
			} catch (RuntimeException e) {
				try {
					getState().reparse(get());
				} catch (IOException ioe) {
				}
				throw e;
			}
		}

		public <T> T process(IUnitOfWork<T, XtextResource> transaction) {
			if (transaction != null) {
				readLock.unlock();
				writeLock.lock();
				try {
					if (log.isDebugEnabled())
						log.debug("process - " + Thread.currentThread().getName());
					return modify(transaction);
				} finally {
					readLock.lock();
					writeLock.unlock();
				}
			}
			return null;
		}
	}

	private static final Logger log = Logger.getLogger(XtextDocument.class);

	private transient Job validationJob;

	public void setValidationJob(Job validationJob) {
		this.validationJob = validationJob;
	}

	private void checkAndUpdateAnnotations() {
		validationJob.cancel();
		validationJob.schedule();
	}

	@SuppressWarnings("unchecked")
	public <T> T getAdapter(Class<T> adapterType) {
		URI uri = resource.getURI();
		if ((adapterType == IFile.class || adapterType == IResource.class) && uri.isPlatformResource()) {
			return (T) ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
		}
		if (adapterType == IDirtyResource.class) {
			return adapterType.cast(getDirtyResource());
		}
		return null;
	}

	public IDirtyResource getDirtyResource() {
		return dirtyResource;
	}

	public <T extends EObject> IEObjectHandle<T> createHandle(T obj) {
		return new EObjectHandleImpl<T>(obj, this);
	}

}
