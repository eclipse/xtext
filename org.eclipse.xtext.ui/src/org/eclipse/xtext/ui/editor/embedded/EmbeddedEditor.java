/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.embedded;

import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;

/**
 * Handle for an embedded Xtext editor. It allows to initialize the edited model
 * and provides accessors for the {@link #getDocument() document}, 
 * the {@link #getConfiguration() source viewer configuration}, and the {@link #getViewer() viewer}.
 * 
 * @since 2.2
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class EmbeddedEditor {
	private final XtextSourceViewer viewer;

	private final IEditedResourceProvider resourceProvider;

	private final XtextDocument document;

	private final XtextSourceViewerConfiguration configuration;

	private final Runnable afterSetDocument;
	
	/**
	 * @since 2.19
	 */
	private XtextDocumentUtil xtextDocumentUtil = new XtextDocumentUtil();
	
	public EmbeddedEditor(XtextDocument document, XtextSourceViewer viewer, XtextSourceViewerConfiguration configuration, IEditedResourceProvider resourceProvider, Runnable afterSetDocumet) {
		this.document = document;
		this.viewer = viewer;
		this.configuration = configuration;
		this.resourceProvider = resourceProvider;
		this.afterSetDocument = afterSetDocumet;
	}

	public XtextSourceViewer getViewer() {
		return this.viewer;
	}

	public XtextDocument getDocument() {
		return this.document;
	}

	public XtextSourceViewerConfiguration getConfiguration() {
		return this.configuration;
	}
	
	/**
	 * @since 2.19
	 */
	public void setXtextDocumentUtil(XtextDocumentUtil xtextDocumentUtil) {
		this.xtextDocumentUtil = xtextDocumentUtil;
	}
	
	/**
	 * @since 2.19
	 */
	public XtextDocumentUtil getXtextDocumentUtil() {
		return xtextDocumentUtil;
	}
	
	/**
	 * Obtain the {@link EmbeddedEditorModelAccess model access} for this editor instance. 
 	 * It can be used to query the currently edited text or update it externally.
 	 * The prefix and the suffix will not be visible in the editor. It is possible to 
 	 * insert artificial line-breaks between the three parts (prefix, editablePart, suffix). 
 	 * @return the model access. Never <code>null</code>.
	 */
	public EmbeddedEditorModelAccess createPartialEditor(String prefix, String editablePart, String suffix, boolean insertLineBreaks) {
		EmbeddedEditorModelAccess result = new EmbeddedEditorModelAccess(this.viewer, this.resourceProvider, insertLineBreaks);
		result.setXtextDocumentUtil(xtextDocumentUtil);
		result.setModel(getDocument(), prefix, editablePart, suffix);
		afterSetDocument.run();
		return result;
	}

	/**
	 * Obtain the {@link EmbeddedEditorModelAccess model access} for this editor instance. 
 	 * It can be used to query the currently edited text or update it externally.
 	 * This is a shortcut for 
 	 * {@link #createPartialEditor(String, String, String, boolean) createPartialEditor("", "", "", insertLinebreaks)}.
 	 * @return the model access. Never <code>null</code>.
	 */
	public EmbeddedEditorModelAccess createPartialEditor(boolean insertLinebreaks) {
		return createPartialEditor("", "", "", insertLinebreaks);
	}
	
	/**
	 * Obtain the {@link EmbeddedEditorModelAccess model access} for this editor instance. 
 	 * It can be used to query the currently edited text or update it externally.
 	 * This is a shortcut for 
 	 * {@link #createPartialEditor(String, String, String, boolean) createPartialEditor("", "", "", false)}.
 	 * @return the model access. Never <code>null</code>.
	 */
	public EmbeddedEditorModelAccess createPartialEditor() {
		return createPartialEditor("", "", "", false);
	}
}