package org.eclipse.xtext.ui.core.editor;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.ILocationInFileProvider;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;

/**
 * This action opens a <code>XtextEditor</code> on a selected <code>CrossReference</code> element.
 * 
 * @author Michael Clay - Initial contribution and API
 * 
 * @see org.eclipse.jface.action.Action
 */
public class OpenDeclarationAction extends Action {

	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(getClass());

	private URI uri;

	private ILocationInFileProvider locationProvider;
	

	public OpenDeclarationAction(URI uri, ILocationInFileProvider locationProvider) {
		super();
		this.uri = uri;
		this.locationProvider = locationProvider;
	}

	@Override
	public void run() {
		doOpen(uri);
	}
	
	public void doOpen(final URI uri) {
		IFile file = getContainingResourceSetFile(uri);
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		try {
			IEditorPart openEditor = IDE.openEditor(page, file);
			if (openEditor instanceof XtextEditor) {
				final XtextEditor edit = (XtextEditor) openEditor;
				if (uri.fragment()!=null) {
				edit.getDocument().readOnly(new UnitOfWork<Object>(){

					public Object exec(XtextResource resource) throws Exception {
						EObject object = resource.getEObject(uri.fragment());
						Region region = locationProvider.getLocation(object);
						edit.selectAndReveal(region.getOffset(),region.getLength());
						return null;
					}});
				}
			} else if (openEditor instanceof ISelectionProvider) {
				//TODO: use ISelectionProvider instead of ITextEditor
			}
		}
		catch (PartInitException partInitException) {
			logger.error("Error while opening editor part for EMF URI '" + uri + "'",
					partInitException);
		}
	}
	
	private IFile getContainingResourceSetFile(URI uri) {
		IFile targetFile = uri.isPlatformResource() ? 
				ResourcesPlugin.getWorkspace().getRoot().getFile(
						new Path(uri.toPlatformString(true)))
				: ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(
						new Path(uri.toFileString()));
		return targetFile;
	}
}
