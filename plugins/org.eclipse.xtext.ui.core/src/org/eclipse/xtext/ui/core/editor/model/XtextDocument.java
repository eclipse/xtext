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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.text.Document;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.core.editor.XtextResourceChecker;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocumentContentObserver.Processor;
import org.eclipse.xtext.ui.core.util.JdtClasspathUriResolver;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validator.CheckMode;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class XtextDocument extends Document implements IXtextDocument {

	private XtextResourceSet resourceSet = null;
	private XtextResource resource = null;
	private IEditorInput editorInput;
	private IFile file;

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	public void setInput(IEditorInput editorInput) {
		file = ResourceUtil.getFile(editorInput);
		Assert.isTrue(file != null && this.editorInput == null || this.editorInput.equals(editorInput));
		if (this.editorInput != null)
			return;
		this.editorInput = editorInput;
		resourceSet = resourceSetProvider.get();

		IJavaProject javaProject = getIJavaProject(file);
		if (javaProject != null) {
			resourceSet.setClasspathUriResolver(new JdtClasspathUriResolver());
			resourceSet.setClasspathURIContext(javaProject);
		}

		IPath path = file.getFullPath();
		Resource aResource = resourceSet.createResource(URI.createPlatformResourceURI(path.toString(), true));
		if (!(aResource instanceof XtextResource))
			throw new IllegalStateException("The resource factory registered for " + path
					+ " is not an XtextResourceFactory. Make sure the right resource factory has been registered.");
		resource = (XtextResource) aResource;
		if (!resource.isLoaded()) {
			try {
				String string = get();
				resource.load(new StringInputStream(string), null);
			} catch (IOException e) {
				throw new WrappedException(e);
			}
		}
	}

	public boolean isReferenced(IResource anIResource) {
		if (!(anIResource instanceof IFile))
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

	private IJavaProject getIJavaProject(IFile file) {
		IJavaProject create = JavaCore.create(file.getProject());
		if (create.exists())
			return create;
		return null;
	}

	private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	private final Lock writeLock = rwLock.writeLock();
	private final Lock readLock = rwLock.readLock();

	public <T> T readOnly(UnitOfWork<T> work) {
		readLock.lock();
		try {
			updateContentBeforeRead();
			T exec = work.exec(resource);
			ensureThatStateIsNotReturned(exec, work);
			return exec;
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new WrappedException(e);
		} finally {
			readLock.unlock();
		}
	}

	public <T> T modify(UnitOfWork<T> work) {
		writeLock.lock();
		try {
			T exec = work.exec(resource);
			ensureThatStateIsNotReturned(exec, work);
			notifyModelListeners(resource);
			// TODO track modifications and serialize back to the text buffer
			return exec;
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new WrappedException(e);
		} finally {
			writeLock.unlock();
			checkAndUpdateMarkers();
		}
	}
	
	private void ensureThatStateIsNotReturned(Object exec, UnitOfWork<?> uow) {
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

	ListenerList modelListeners = new ListenerList(ListenerList.IDENTITY);

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

	private final ListenerList xtextDocumentObservers = new ListenerList(ListenerList.IDENTITY);

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
		Processor processor = new LockAwareProcessor();
		for (int i = 0; i < listeners.length; i++) {
			((IXtextDocumentContentObserver) listeners[i]).performNecessaryUpdates(processor);
		}
	}

	private final class UpdateMarkerJob extends Job {

		private UpdateMarkerJob(String name) {
			super(name);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			final List<Map<String, Object>> issues = readOnly(new UnitOfWork<List<Map<String, Object>>>() {
				public List<Map<String, Object>> exec(XtextResource resource) throws Exception {
					return XtextResourceChecker.check(resource,Collections.singletonMap(CheckMode.KEY, CheckMode.FAST_ONLY));
				}
			});

			if (file == null)
				throw new IllegalStateException("Couldn't find IFile for Document");

			// cleanup
			XtextResourceChecker.addMarkers(file, issues, true, monitor);

			return Status.OK_STATUS;
		}

	}
	

	class LockAwareProcessor implements Processor {

		public <T> T process(UnitOfWork<T> transaction) {
			if (transaction != null) {
				readLock.unlock();
				writeLock.lock();
				try {
					return modify(transaction);
				} finally {
					readLock.lock();
					writeLock.unlock();
				}
			}
			return null;
		}

	}

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(XtextDocument.class);
	private final UpdateMarkerJob updateMarkerJob = new UpdateMarkerJob("updateMarkers");

	private void checkAndUpdateMarkers() {
		updateMarkerJob.schedule();
	}

	@SuppressWarnings("unchecked")
	public <T> T getAdapter(Class<T> adapterType) {
		URI uri = resource.getURI();
		if ((adapterType == IFile.class || adapterType == IResource.class) && uri.isPlatformResource()) {
			return (T) ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
		}
		return null;
	}
	
}
