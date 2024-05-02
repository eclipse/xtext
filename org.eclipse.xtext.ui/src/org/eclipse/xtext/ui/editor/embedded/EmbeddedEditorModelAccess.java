/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.embedded;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.LazyStringInputStream;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * The model access allows to obtain or manipulate the edited text.
 * 
 * @since 2.2
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EmbeddedEditorModelAccess {

	private final SourceViewer viewer;

	private final boolean insertLineBreaks;

	private final IEditedResourceProvider resourceProvider;
	
	/**
	 * @since 2.19
	 */
	private XtextDocumentUtil xtextDocumentUtil = new XtextDocumentUtil();

	public EmbeddedEditorModelAccess(SourceViewer viewer, IEditedResourceProvider resourceProvider,
			boolean insertLineBreaks) {
		this.viewer = viewer;
		this.resourceProvider = resourceProvider;
		this.insertLineBreaks = insertLineBreaks;
	}

	protected void setModel(XtextDocument document, String prefix, String editablePart, String suffix) {
		if (this.insertLineBreaks) {
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
			Object lock = ((ISynchronizable) document).getLockObject();
			if (lock == null) {
				lock = new Object();
				((ISynchronizable) document).setLockObject(lock);
			}
			((ISynchronizable) annotationModel).setLockObject(lock);
		}
		this.viewer.setDocument(document, annotationModel, prefix.length(), editablePart.length());
	}

	protected XtextResource createResource(String content) {
		XtextResource result = this.resourceProvider.createResource();
		try {
			result.load(new LazyStringInputStream(content, result.getEncoding()), Collections.emptyMap());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	public void updateModel(String model) {
		IDocument document = this.viewer.getDocument();
		this.viewer.setRedraw(false);
		this.viewer.getUndoManager().disconnect();
		document.set(model);
		this.viewer.resetVisibleRegion();
		this.viewer.getUndoManager().connect(this.viewer);
		this.viewer.setRedraw(true);
	}

	public void updateModel(String prefix, String editablePart, String suffix) {
		IDocument document = this.viewer.getDocument();
		if (this.insertLineBreaks) {
			String delimiter = document.getLegalLineDelimiters()[0];
			if (document instanceof IDocumentExtension4) {
				delimiter = ((IDocumentExtension4) document).getDefaultLineDelimiter();
			}
			prefix = prefix + delimiter;
			suffix = delimiter + suffix;
		}
		String model = prefix + editablePart + suffix;
		this.viewer.setRedraw(false);
		this.viewer.getUndoManager().disconnect();
		document.set(model);
		this.viewer.setVisibleRegion(prefix.length(), editablePart.length());
		this.viewer.getUndoManager().connect(this.viewer);
		this.viewer.setRedraw(true);
	}
	
	public void updateModel(final String model, final String editablePartUriFragment) {
		updateModel(model, new IUnitOfWork<ITextRegion, XtextResource>() {
			@Override
			public ITextRegion exec(XtextResource state) throws Exception {
				EObject editablePart = state.getEObject(editablePartUriFragment);
				ICompositeNode node = NodeModelUtils.findActualNodeFor(editablePart);
				if (node != null)
					return new TextRegion(node.getOffset(), node.getLength());
				return null;
			}
		});
	}
	
	public void updateModel(String model, final IUnitOfWork<ITextRegion, XtextResource> editablePartSelector) {
		IXtextDocument document = xtextDocumentUtil.getXtextDocument(this.viewer);
		this.viewer.setRedraw(false);
		this.viewer.getUndoManager().disconnect();
		document.set(model);
		
		ITextRegion textRegion = document.readOnly(editablePartSelector);
		if (textRegion == null) {
			this.viewer.resetVisibleRegion();
		} else {
			this.viewer.setVisibleRegion(textRegion.getOffset(), textRegion.getLength());
		}
		this.viewer.getUndoManager().connect(this.viewer);
		this.viewer.setRedraw(true);
	}

	public void updatePrefix(String prefix) {
		try {
			IDocument document = this.viewer.getDocument();
			IRegion visibleRegion = this.viewer.getVisibleRegion();
			String editablePart = document.get(visibleRegion.getOffset(), visibleRegion.getLength());
			int suffixOffset = visibleRegion.getOffset() + visibleRegion.getLength();
			String suffix = "";
			if (document.getLength() - suffixOffset > 0) {
				suffix = document.get(suffixOffset, document.getLength() - suffixOffset);
				if (this.insertLineBreaks) {
					String delimiter = document.getLegalLineDelimiters()[0];
					if (document instanceof IDocumentExtension4) {
						delimiter = ((IDocumentExtension4) document).getDefaultLineDelimiter();
					}
					suffix = suffix.substring(delimiter.length());
				}
			}
			updateModel(prefix, editablePart, suffix);
		} catch (BadLocationException e) {
			throw new RuntimeException(e);
		}
	}

	public String getEditablePart() {
		IDocument doc = this.viewer.getDocument();
		IRegion visible = this.viewer.getVisibleRegion();
		try {
			return doc.get(visible.getOffset(), visible.getLength());
		} catch (BadLocationException e) {
			return ""; //$NON-NLS-1$
		}
	}

	public String getSerializedModel() {
		return this.viewer.getDocument().get();
	}

	/**
	 * @since 2.19
	 */
	protected void setXtextDocumentUtil(XtextDocumentUtil xtextDocumentUtil) {
		this.xtextDocumentUtil = xtextDocumentUtil;
	}
}
