/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.SyntaxError;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.internal.CoreLog;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Peter Friese - Initial contribution and API
 * 
 */
public class XtextEditorModel implements IEditorModel {

	private final IDocument document;
	private IDocumentListener dirtyListener;
	private boolean shouldReconcile = true;
	private final ILanguageDescriptor languageDescriptor;
	private XtextResource resource;

	public XtextEditorModel(XtextResource resource, IDocument document, ILanguageDescriptor languageDescriptor) {
		this.document = document;
		this.resource = resource;
		if (resource.getParseResult() == null) {
			try {
				resource.load(new StringInputStream(document.get()), null);
			} catch (IOException e) {
				CoreLog.logError(e);
			}
		}
		this.languageDescriptor = languageDescriptor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.editor.model.IEditorModel#getLanguageDescriptor
	 * ()
	 */
	public ILanguageDescriptor getLanguageDescriptor() {
		return languageDescriptor;
	}

	private Object getLockObject() {
		if (document instanceof ISynchronizable) {
			Object lock = ((ISynchronizable) document).getLockObject();
			if (lock != null) {
				return lock;
			}
		}
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.editor.model.IEditorModel#reconcile()
	 */
	public void reconcile(IRegion region) {
		synchronized (dirtyLock) {
			if (!shouldReconcile || !dirty) {
				return;
			} else {
				dirty = false;
			}
		}
		synchronized (getLockObject()) {
			internalReconcile(region);
		}
	}

	private void internalReconcile(IRegion region) {
		try {
			if (Activator.DEBUG_PARSING)
				System.out.print("EditorModel Parsing...");
			long start = System.currentTimeMillis();
			resource.update(region.getOffset(), region.getLength(), document
					.get(region.getOffset(), region.getLength()));

			if (Activator.DEBUG_PARSING)
				System.out.println("...took " + (System.currentTimeMillis() - start) + "ms.");

			notifyModelListeners(new XtextEditorModelChangeEvent(this));
		} catch (Exception e) {
			if (Activator.DEBUG_PARSING)
				System.out.println("fail!");
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.editor.model.IEditorModel#getParseTreeRootNode
	 * ()
	 */
	public AbstractNode getParseTreeRootNode() {
		return resource.getParseResult().getRootNode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.editor.model.IEditorModel#getAstRoot()
	 */
	public EObject getAstRoot() {
		return resource.getParseResult().getRootASTElement();
	}

	protected boolean dirty = true;
	protected Object dirtyLock = new Object();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.editor.model.IEditorModel#install()
	 */
	public void install() {
		dirtyListener = new IDocumentListener() {

			public void documentAboutToBeChanged(DocumentEvent event) {
				synchronized (dirtyLock) {
					dirty = true;
				}
			}

			public void documentChanged(DocumentEvent event) {
			}
		};
		document.addDocumentListener(dirtyListener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.editor.model.IEditorModel#uninstall()
	 */
	public void uninstall() {
		document.removeDocumentListener(dirtyListener);
	}

	private List<IXtextEditorModelListener> xtextModelListeners = new ArrayList<IXtextEditorModelListener>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.editor.model.IEditorModel#addModelListener(
	 * org.eclipse.xtext.ui.editor.model.IXtextEditorModelListener)
	 */
	public void addModelListener(IXtextEditorModelListener listener) {
		synchronized (xtextModelListeners) {
			xtextModelListeners.add(listener);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.editor.model.IEditorModel#removeModelListener
	 * (org.eclipse.xtext.ui.editor.model.IXtextEditorModelListener)
	 */
	public void removeModelListener(IXtextEditorModelListener listener) {
		synchronized (xtextModelListeners) {
			xtextModelListeners.remove(listener);
		}
	}

	private void notifyModelListeners(XtextEditorModelChangeEvent event) {
		Iterator<IXtextEditorModelListener> iterator;
		synchronized (xtextModelListeners) {
			iterator = xtextModelListeners.iterator();
		}
		for (; iterator.hasNext();) {
			IXtextEditorModelListener listener = iterator.next();
			listener.modelChanged(event);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.editor.model.IEditorModel#getErrors()
	 */
	public List<SyntaxError> getSyntaxErrors() {
		return resource.getParseResult().getParseErrors();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.editor.model.IEditorModel#hasErrors()
	 */
	public boolean hasErrors() {
		return getSyntaxErrors() != null && !getSyntaxErrors().isEmpty();
	}

}
