package org.eclipse.xtext.ui.core.editor.model;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.core.editor.XtextProblemMarkerCreator;
import org.eclipse.xtext.ui.core.util.JdtClasspathUriResolver;
import org.eclipse.xtext.util.StringInputStream;

public class XtextDocument extends AbstractDocumentDelegation implements IXtextDocument {

	private XtextResourceSet resourceSet = null;
	XtextResource resource = null;
	private IURIEditorInput editorInput;

	public XtextDocument(IDocument doc) {
		super(doc);
	}

	public void setURI(IURIEditorInput editorInput) {
		Assert.isTrue(this.editorInput==null || this.editorInput.equals(editorInput));
		if (editorInput != null)
			return;
		this.editorInput = editorInput;
		resourceSet = new XtextResourceSet();

		if (getIJavaProject() != null) {
			resourceSet.setClasspathURIContext(new JdtClasspathUriResolver());
			resourceSet.setClasspathURIContext(getIJavaProject());
		}

		String pathName = editorInput.getURI().toString();
		Resource aResource = resourceSet.createResource(URI.createPlatformResourceURI(pathName, true));
		if (!(aResource instanceof XtextResource))
			throw new IllegalStateException("The resource factory registered for " + pathName
					+ " is not an XtextResourceFactory. Make sure the right resource factory has been registered.");
		resource = (XtextResource) aResource;
		if (!resource.isLoaded()) {
			try {
				resource.load(new StringInputStream(get()), null);
			} catch (IOException e) {
				throw new WrappedException(e);
			}
		}
	}

	private IJavaProject getIJavaProject() {
		return null;
	}

	private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	Lock readLock = rwLock.readLock();
	Lock writeLock = rwLock.writeLock();

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
