package org.eclipse.xtext.ui.core.editor.model;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Path;
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
import org.eclipse.xtext.ui.core.editor.XtextProblemMarkerCreator;
import org.eclipse.xtext.ui.core.util.JdtClasspathUriResolver;
import org.eclipse.xtext.util.StringInputStream;

public class XtextDocument extends Document implements IXtextDocument {

	private XtextResourceSet resourceSet = null;
	private XtextResource resource = null;
	private IEditorInput editorInput;

	public void setInput(IEditorInput editorInput) {
		IFile file = ResourceUtil.getFile(editorInput);
		Assert.isTrue(file != null && this.editorInput == null || this.editorInput.equals(editorInput));
		if (this.editorInput != null)
			return;
		this.editorInput = editorInput;
		resourceSet = new XtextResourceSet();

		IJavaProject javaProject = getIJavaProject(file);
		if (javaProject != null) {
			resourceSet.setClasspathURIContext(new JdtClasspathUriResolver());
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

	private IJavaProject getIJavaProject(IFile file) {
		IJavaProject create = JavaCore.create(file.getProject());
		if (create.exists() && create.isOpen())
			return create;
		return null;
	}

	private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	private Lock readLock = rwLock.readLock();
	private Lock writeLock = rwLock.writeLock();

	public <T> T readOnly(UnitOfWork<T> work) {
		readLock.lock();
		try {
			return work.exec(resource);
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
			checkAndUpdateMarkers(resource);
			notifyDocumentListeners(resource);
			// TODO track modifications and serialize back to the text buffer
			return exec;
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new WrappedException(e);
		} finally {
			writeLock.unlock();
		}
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
	
	private void notifyDocumentListeners(XtextResource res) {
		Object[] listeners = modelListeners.getListeners();
		for (int i = 0; i < listeners.length; i++) {
			((IXtextModelListener) listeners[i]).modelChanged(res);
		}
	}

	private void checkAndUpdateMarkers(XtextResource res) {
		IFile file = getAdapter(IFile.class);
		if (file == null)
			throw new IllegalStateException("Couldn't find IFile for Document");
		XtextProblemMarkerCreator.checkAndUpdateMarkers(res, file);
	}

	@SuppressWarnings("unchecked")
	public <T> T getAdapter(Class<T> adapterType) {
		URI uri = resource.getURI();
		if ((adapterType == IFile.class || adapterType == IResource.class) && uri.isPlatformResource()) {
			return (T) ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
		} else {
			return null;
		}
	}

}
