/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.tools.ant.filters.StringInputStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParseError;
import org.eclipse.xtext.parser.IParseErrorHandler;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.core.internal.Activator;

/**
 * @author Peter Friese - Initial contribution and API
 * 
 */
public class XtextEditorModel {

	// TODO remove custom implementation when default one works properly
	private IParseErrorHandler parseErrorHandler = new IParseErrorHandler() {

		public void handleParserError(IParseError error) {
			parseErrors.add(error);
		}
	};
	List<IParseError> parseErrors = new ArrayList<IParseError>();

	public List<IParseError> getErrors() {
		return parseErrors;
	}

	public boolean hasErrors() {
		return parseErrors.size() > 0;
	}

	private final IDocument document;
	private IParser parser;
	private AbstractNode parseTreeRootNode;
	private IDocumentListener dirtyListener;
	private boolean shouldReconcile = true;
	private EObject astRoot;
	private final ILanguageDescriptor languageDescriptor;

	public XtextEditorModel(IDocument document, ILanguageDescriptor languageDescriptor) {
		this.document = document;
		this.languageDescriptor = languageDescriptor;
		this.parser = ServiceRegistry.getService(languageDescriptor, IParser.class);
	}

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

	public void reconcile() {
		synchronized (dirtyLock) {
			if (!shouldReconcile || !dirty) {
				return;
			}
			else {
				dirty = false;
			}
		}
		synchronized (getLockObject()) {
			if (document == null) {
				parseTreeRootNode = null;
			}
			else {
				parseDocument(document);
			}
		}
	}

	private void parseDocument(IDocument document) {
		String content;
		try {
			content = document.get(0, document.getLength());
			if (Activator.DEBUG_PARSING)
				System.out.print("Parsing...");
			long start = System.currentTimeMillis();

			// TODO: dependency injection for default element factory in parser
			IElementFactory elementFactory = ServiceRegistry.getService(languageDescriptor, IElementFactory.class);
			astRoot = parser.parse(new StringInputStream(content), elementFactory, parseErrorHandler)
					.getRootASTElement();
			if (Activator.DEBUG_PARSING)
				System.out.println("...took " + (System.currentTimeMillis() - start) + "ms.");
			if (astRoot != null) {
				NodeAdapter nodeAdapter = (NodeAdapter) astRoot.eAdapters().get(0);
				parseTreeRootNode = nodeAdapter.getParserNode();
				notifyModelListeners(new XtextEditorModelChangeEvent(this));
			}
		}
		catch (BadLocationException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AbstractNode getParseTreeRootNode() {
		return getParseTreeRootNode(true);
	}

	public AbstractNode getParseTreeRootNode(boolean doReconcile) {
		if (doReconcile) {
			synchronized (getLockObject()) {
				reconcile();
			}
		}
		return parseTreeRootNode;
	}

	public EObject getAstRoot() {
		return getAstRoot(true);
	}

	public EObject getAstRoot(boolean doReconcile) {
		if (doReconcile) {
			synchronized (getLockObject()) {
				reconcile();
			}
		}
		return astRoot;
	}

	protected boolean dirty = true;
	protected Object dirtyLock = new Object();

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

	private List<IXtextEditorModelListener> xtextModelListeners = new ArrayList<IXtextEditorModelListener>();

	public void addModelListener(IXtextEditorModelListener listener) {
		synchronized (xtextModelListeners) {
			xtextModelListeners.add(listener);
		}
	}

	public void removeModelListener(IXtextEditorModelListener listener) {
		synchronized (xtextModelListeners) {
			xtextModelListeners.remove(listener);
		}
	}

	public void notifyModelListeners(XtextEditorModelChangeEvent event) {
		Iterator<IXtextEditorModelListener> iterator;
		synchronized (xtextModelListeners) {
			iterator = xtextModelListeners.iterator();
		}
		for (; iterator.hasNext();) {
			IXtextEditorModelListener listener = iterator.next();
			listener.modelChanged(event);
		}
	}

}
