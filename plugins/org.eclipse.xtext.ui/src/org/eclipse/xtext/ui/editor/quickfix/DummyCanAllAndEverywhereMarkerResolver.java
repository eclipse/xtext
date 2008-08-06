package org.eclipse.xtext.ui.editor.quickfix;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMarkerResolution2;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.MarkerUtilities;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
final class DummyCanAllAndEverywhereMarkerResolver implements IMarkerResolution2 {
	private final IMarker marker;
	private IDocumentProvider documentProvider;

	DummyCanAllAndEverywhereMarkerResolver(IMarker marker, IDocumentProvider documentProvider) {
		this.marker = marker;
		this.documentProvider = documentProvider;
	}

	public String getDescription() {
		return "Xtext Marker Resolution for: " + MarkerUtilities.getMessage(marker) + " problems";
	}

	public Image getImage() {
		return JFaceResources.getImage(Dialog.DLG_IMG_HELP);
	}

	public String getLabel() {
		return "Can Fix all problems, particularly the " + MarkerUtilities.getMessage(marker);
	}

	public void run(IMarker marker) {
		IResource res = marker.getResource();
		if (res instanceof IFile && res.isAccessible()) {
			IFile iFile = (IFile) res;
			FileEditorInput input = new FileEditorInput(iFile);
			if (documentProvider == null)
				documentProvider = new FileDocumentProvider();
			// Is even accessible/runable without an editor
			try {
				documentProvider.connect(input);
				IDocument document = documentProvider.getDocument(input);
				documentProvider.getAnnotationModel(input).connect(document);
				int offset = MarkerUtilities.getCharStart(marker);
				int length = MarkerUtilities.getCharEnd(marker) - offset;
				document.replace(offset, length, "");
				// needs in resource mode only
				if (documentProvider.canSaveDocument(input)) {
					documentProvider.saveDocument(new NullProgressMonitor(), input, document, true);
					marker.delete();
				}
				documentProvider.getAnnotationModel(input).disconnect(document);
				documentProvider.disconnect(input);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}