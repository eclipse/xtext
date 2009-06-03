package org.eclipse.xtext.ui.common.editor.hyperlinking;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.concurrent.IUnitOfWork;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.ILocationInFileProvider;
import org.eclipse.xtext.ui.core.editor.ReadonlyArchiveStorage;
import org.eclipse.xtext.ui.core.editor.ReadonlyFileStorage;
import org.eclipse.xtext.ui.core.editor.XtextEditor;
import org.eclipse.xtext.ui.core.editor.XtextReadonlyEditorInput;

/**
 * This action opens a <code>XtextEditor</code> on a selected <code>CrossReference</code> element.
 *
 * @author Michael Clay - Initial contribution and API
 * @author Peter Friese
 *
 * @see org.eclipse.jface.action.Action
 */
public class OpenDeclarationAction extends Action {

	// logger available to subclasses
	private static final Logger logger = Logger.getLogger(OpenDeclarationAction.class);

	private final URI uri;

	private final ILocationInFileProvider locationProvider;

	public OpenDeclarationAction(URI uri, ILocationInFileProvider locationProvider) {
		super();
		this.uri = uri;
		this.locationProvider = locationProvider;
	}

	@Override
	public void run() {
		doOpen(uri);
	}

	public URI getURI() {
		return uri;
	}

	public void doOpen(final URI uri) {
		IFile file = getContainingResourceSetFile(uri);
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart openEditor = null;
		try {
			if (file != null) {
				openEditor = IDE.openEditor(page, file);
			} else if (uri.isArchive()) {
				// TODO don't fall back to java.io
				IEditorInput input = new XtextReadonlyEditorInput(new ReadonlyArchiveStorage(uri));
				openEditor = IDE.openEditor(page, input, PlatformUI.getWorkbench().getEditorRegistry()
						.getDefaultEditor(uri.lastSegment()).getId());
			} else {
				// fall back: URI is bundle resource uri and has to converted, or http uri
				URL url = FileLocator.toFileURL(new URL(uri.scheme()+ ":" +uri.devicePath()));
				URI urlAsUri = URI.createURI(url.toString());
				String path = urlAsUri.toFileString();
				if (path != null) {
					File ioFile = new File(path);
					// TODO don't fall back to java.io
					IEditorInput input = new XtextReadonlyEditorInput(new ReadonlyFileStorage(ioFile, uri));
					openEditor = IDE.openEditor(page, input, PlatformUI.getWorkbench().getEditorRegistry()
							.getDefaultEditor(uri.lastSegment()).getId());
				}
			}
		} catch (PartInitException partInitException) {
			logger.error("Error while opening editor part for EMF URI '" + uri + "'",
					partInitException);
		} catch (IOException e) {
			logger.error("Error while opening editor part for EMF URI '" + uri + "'", e);
		}
		if (openEditor != null && openEditor instanceof XtextEditor) {
			final XtextEditor edit = (XtextEditor) openEditor;
			if (uri.fragment()!=null) {
				edit.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>(){
				public void process(XtextResource resource) throws Exception {
					EObject object = resource.getEObject(uri.fragment());
					Region region = locationProvider.getLocation(object);
					edit.selectAndReveal(region.getOffset(),region.getLength());
				}});
			}
		}
		else if (openEditor instanceof EcoreEditor) {
			EcoreEditor ecoreEditor = (EcoreEditor)openEditor;
			// set selection
		    EditingDomain editingDomain = ecoreEditor.getEditingDomain();
		    EObject editObject = editingDomain.getResourceSet().getEObject(uri, true);
		    if (editObject != null) {
		        ecoreEditor.setSelectionToViewer(Collections.singleton(editObject));
		    }
		}
		else if (openEditor instanceof ISelectionProvider) {
			//TODO: use ISelectionProvider instead of ITextEditor
		}
	}

	private IFile getContainingResourceSetFile(URI uri) {
		String path = null;
		if (uri.isPlatformResource()) {
			path = uri.toPlatformString(true);
		} else if (uri.isPlatformPlugin()) {
			path = uri.toPlatformString(true);
		} else if (uri.isFile()) {
			path = uri.toFileString();
		} else if (uri.isArchive()) {
			URI archiveUri = URI.createURI(uri.authority());
			String archive = null;
			if (archiveUri.isFile()) {
				archive = archiveUri.toFileString();
			} else if (archiveUri.isPlatformResource()) {
				archive = archiveUri.toPlatformString(true);
			} else {
				archive = archiveUri.toString();
			}
			path = uri.scheme() + ":" + archive + uri.path();
		} else {
			path = uri.toString();
		}
		IFile result = null;
		if (uri.isPlatformResource()) {
			result = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
		} else {
			result = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(path));
			if (result == null) {
				IResource res = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
				if (res != null && (res instanceof IFile))
					result = (IFile) res;
			}
		}
		return result;
	}
}
