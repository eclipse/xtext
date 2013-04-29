/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * Translates semantic changes to a document's EMF resource to text edits on 
 * the document. As the document's text and the model are being synced again 
 * later on by the XtextReconciler, a {@link ReconcilingUnitOfWork} is not 
 * directly causing model listeners to be notified.
 * 
 * Modify the model (semantically) and the document (textually) within the 
 * same {@link ReconcilingUnitOfWork} will roll back the changes and throw
 * an exception.
 * 
 * @author Knut Wannheden - Initial contribution and API
 * @author Jan Koehnlein
 */
public class ReconcilingUnitOfWork<T> implements IUnitOfWork<T, XtextResource> {

	private final IUnitOfWork<T, XtextResource> work;
	private final IXtextDocument document;
	private final ITextEditComposer composer;

	public ReconcilingUnitOfWork(IUnitOfWork<T, XtextResource> work, IXtextDocument document, ITextEditComposer composer) {
		this.work = work;
		this.document = document;
		this.composer = composer;
	}

	public T exec(XtextResource state) throws Exception {
		String original = document.get();
		DocumentChangeListener documentChangeListener = new DocumentChangeListener();
		T result;
		try {
			document.addDocumentListener(documentChangeListener);
			// lazy linking URIs might change, so resolve everything before applying any changes
			EcoreUtil2.resolveAll(state, CancelIndicator.NullImpl);
			composer.beginRecording(state);
			result = work.exec(state);
			final TextEdit edit = composer.endRecording();
			if (edit != null) {
				if(documentChangeListener.hasDocumentChanged()) 
					throw new IllegalStateException("Cannot modify document textually and semantically within the same unit of work");
				edit.apply(document);
			}
		} catch (RuntimeException e) {
			document.set(original);
			throw e;
		} catch (Exception e) {
			document.set(original);
			throw new RuntimeException(e);
		} finally {
			document.removeDocumentListener(documentChangeListener);
		}
		return result;
	}
	
	/**
	 * @since 2.4
	 */
	protected static class DocumentChangeListener implements IDocumentListener {

		private boolean documentChanged = false;

		public void documentAboutToBeChanged(DocumentEvent event) {
			// ignore
		}

		public void documentChanged(DocumentEvent event) {
			documentChanged = true;
		}
		
		public boolean hasDocumentChanged() {
			return documentChanged;
		}
	}
}