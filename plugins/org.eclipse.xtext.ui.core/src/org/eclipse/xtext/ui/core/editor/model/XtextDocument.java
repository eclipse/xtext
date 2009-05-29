/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.text.Document;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.xtext.concurrent.IEObjectHandle;
import org.eclipse.xtext.concurrent.IStateAccess;
import org.eclipse.xtext.concurrent.IUnitOfWork;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.core.editor.XtextReadonlyEditorInput;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocumentContentObserver.Processor;
import org.eclipse.xtext.ui.core.editor.utils.ValidationJob;
import org.eclipse.xtext.ui.core.util.JdtClasspathUriResolver;
import org.eclipse.xtext.validation.CheckMode;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class XtextDocument extends Document implements IXtextDocument {

	private XtextResourceSet resourceSet = null;

	private XtextResource resource = null;

	private IFile file;

	private final ListenerList modelListeners = new ListenerList(ListenerList.IDENTITY);

	private final ListenerList xtextDocumentObservers = new ListenerList(ListenerList.IDENTITY);

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	private ValidationJob.Factory validationJobFactory;
	
	public void setInput(IEditorInput editorInput) {
		file = ResourceUtil.getFile(editorInput);

		resourceSet = resourceSetProvider.get();
		if (file != null) {
			// TODO find a way to identify a project for an IStorageEditorInput
			IJavaProject javaProject = getIJavaProject(file);
			if (javaProject != null) {
				resourceSet.setClasspathUriResolver(new JdtClasspathUriResolver());
				resourceSet.setClasspathURIContext(javaProject);
			}
		}

		IPath path = null;
		Resource aResource = null;
		URI uri = null;
		if (file != null) {
			path = file.getFullPath();
			uri = URI.createPlatformResourceURI(path.toString(), true);
		} else if (editorInput instanceof XtextReadonlyEditorInput) {
			uri = ((XtextReadonlyEditorInput) editorInput).getURI();
		} else {
			IStorageEditorInput storageInput = (IStorageEditorInput) editorInput;
			try {
				// TODO get the FQN of the resource
				path = storageInput.getStorage().getFullPath();
				uri = URI.createPlatformResourceURI(path.toString(), true);
			} catch (CoreException e) {
				throw new WrappedException(e);
			}
		}

		aResource = resourceSet.createResource(uri);
		if (!(aResource instanceof XtextResource))
			throw new IllegalStateException("The resource factory registered for " + path
					+ " is not an XtextResourceFactory. Make sure the right resource factory has been registered.");
		resource = (XtextResource) aResource;
		resource.setValidationDisabled(file == null);
	}

	// XXX why is this one not called inside an readOnly action???
	public boolean isReferenced(IResource anIResource) {
		if (!(anIResource instanceof IFile) || resource == null || resource.getResourceSet() == null)
			return false;
		EList<Resource> resources = resource.getResourceSet().getResources();
		final Map<String, Resource> uriToRes = new HashMap<String, Resource>();
		for (Resource res : resources) {
			if (res != resource) {
				URI uri = res.getURI();
				uriToRes.put(uri.lastSegment(), res);
			}
		}

		return uriToRes.containsKey(anIResource.getFullPath().lastSegment());
	}

	private IJavaProject getIJavaProject(IResource resource) {
		IJavaProject create = JavaCore.create(resource.getProject());
		if (create.exists())
			return create;
		return null;
	}

	private final XtextDocumentLocker stateAccess = new XtextDocumentLocker();

	public <T> T readOnly(IUnitOfWork<T, XtextResource> work) {
		return stateAccess.readOnly(work);
	}

	public <T> T modify(IUnitOfWork<T, XtextResource> work) {
		try {
			return stateAccess.modify(work);
		} finally {
			checkAndUpdateMarkers();
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
		protected void beforeReadOnly(XtextResource res, org.eclipse.xtext.concurrent.IUnitOfWork<?, XtextResource> work) {
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
		protected void afterReadOnly(XtextResource res, Object result, org.eclipse.xtext.concurrent.IUnitOfWork<?, XtextResource> work) {
			ensureThatStateIsNotReturned(result, work);
		}

		@Override
		protected void afterModify(XtextResource res, Object result, org.eclipse.xtext.concurrent.IUnitOfWork<?, XtextResource> work) {
			ensureThatStateIsNotReturned(result, work);
			notifyModelListeners(resource);
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

	private final Object validationLock = new Object();
	private Job validationJob;

	private void checkAndUpdateMarkers() {
		synchronized (validationLock) {
			if (validationJob != null)
				validationJob.cancel();
			validationJob = validationJobFactory.create(this, file, CheckMode.FAST_ONLY, true);
			validationJob.schedule(250);
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T getAdapter(Class<T> adapterType) {
		URI uri = resource.getURI();
		if ((adapterType == IFile.class || adapterType == IResource.class) && uri.isPlatformResource()) {
			return (T) ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
		}
		return null;
	}

	public <T extends EObject> IEObjectHandle<T> createHandle(T obj) {
		return new IEObjectHandle.DefaultImpl<T>(obj, this);
	}

}
