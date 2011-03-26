package org.eclipse.xtext.ui.codetemplates.ui.partialEditing;

import java.util.Collections;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.StringInputStream;

public class PartialModelEditor {

	private final SourceViewer viewer;
	private final boolean insertLineBreaks;
	private final ISyntheticResourceProvider resourceProvider;

	public PartialModelEditor(SourceViewer viewer, ISyntheticResourceProvider resourceProvider, boolean insertLineBreaks) {
		this.viewer = viewer;
		this.resourceProvider = resourceProvider;
		this.insertLineBreaks = insertLineBreaks;
	}
	
	public void setModel(XtextDocument document, String prefix, String editablePart, String suffix) {
		if (insertLineBreaks) {
			String delimiter = document.getDefaultLineDelimiter();
			prefix = prefix + delimiter;
			suffix = delimiter + suffix;
		}
		String model = prefix + editablePart + suffix;
		document.set(model);
		XtextResource resource = createResource(model);
		document.setInput(resource);
		AnnotationModel annotationModel = new AnnotationModel();
		if (document instanceof ISynchronizable) {
			Object lock= ((ISynchronizable)document).getLockObject();
			if (lock == null) {
				lock= new Object();
				((ISynchronizable)document).setLockObject(lock);
			}
			((ISynchronizable) annotationModel).setLockObject(lock);
		}
		viewer.setDocument(document, annotationModel, prefix.length(), editablePart.length());
		viewer.getUndoManager().reset();
	}
	
	protected XtextResource createResource(String content) {
		XtextResource result = resourceProvider.createResource();
		try {
			result.load(new StringInputStream(content, result.getEncoding()), Collections.emptyMap());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
	public void updateModel(String prefix, String editablePart, String suffix) {
		IDocument document= viewer.getDocument();
		if (insertLineBreaks) {
			String delimiter = document.getLegalLineDelimiters()[0];
			if (document instanceof IDocumentExtension4) {
				delimiter = ((IDocumentExtension4) document).getDefaultLineDelimiter();
			}
			prefix = prefix + delimiter;
			suffix = delimiter + suffix;
		}
		String model = prefix + editablePart + suffix;
		viewer.setRedraw(false);
		viewer.getUndoManager().disconnect();
		document.set(model);
		viewer.setVisibleRegion(prefix.length(), editablePart.length());
		viewer.getUndoManager().connect(viewer);
		viewer.setRedraw(true);
	}
	
	public void updatePrefix(String prefix) {
		try {
			IDocument document= viewer.getDocument();
			IRegion visibleRegion = viewer.getVisibleRegion();
			String editablePart = document.get(visibleRegion.getOffset(), visibleRegion.getLength());
			int suffixOffset = visibleRegion.getOffset() + visibleRegion.getLength();
			String suffix = "";
			if (document.getLength() - suffixOffset > 0) {
				suffix = document.get(suffixOffset, document.getLength() - suffixOffset);	
				if (insertLineBreaks) {
					String delimiter = document.getLegalLineDelimiters()[0];
					if (document instanceof IDocumentExtension4) {
						delimiter = ((IDocumentExtension4) document).getDefaultLineDelimiter();
					}
					suffix = suffix.substring(delimiter.length());
				}
			}
			updateModel(prefix, editablePart, suffix);
		} catch(BadLocationException e) {
			throw new RuntimeException(e);
		}
	}

	public String getEditablePart() {
		IDocument doc= viewer.getDocument();
		IRegion visible= viewer.getVisibleRegion();
		try {
			return doc.get(visible.getOffset(), visible.getLength());
		} catch (BadLocationException e) {
			return ""; //$NON-NLS-1$
		}
	}
	
	public String getSerializedModel() {
		return viewer.getDocument().get();
	}
	
}
