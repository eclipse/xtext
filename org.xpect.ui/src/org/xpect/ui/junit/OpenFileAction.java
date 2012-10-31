package org.xpect.ui.junit;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;

/**
 * @see org.eclipse.ui.actions.OpenFileAction
 */
public class OpenFileAction extends Action {

	private IURIEditorOpener editorOpener;

	private URI uri;

	public OpenFileAction(IURIEditorOpener editorOpener, URI uri, String text, String toolTipText) {
		super();
		this.uri = uri;
		this.editorOpener = editorOpener;
		setText(text);
		setToolTipText(toolTipText);
	}

	public IURIEditorOpener getEditorOpener() {
		return editorOpener;
	}

	public URI getUri() {
		return uri;
	}

	@Override
	public void run() {
		if (uri.isFile()) {
			java.net.URI javaURI = java.net.URI.create(uri.trimFragment().toString());
			IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(javaURI);
			if (files.length == 0)
				MessageDialog.openError(null, "File not found", "Could not find this file inside workspace:\n" + javaURI);
			IFile file = files[0];
			uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true).appendFragment(uri.fragment());
		}
		editorOpener.open(uri, true);
	}

}
