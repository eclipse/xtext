/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.preferences;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.xtext.ui.codetemplates.ui.partialEditing.HighlightingHelper;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TemplatesLanguageConfiguration {

	@Inject 
	private IDialogSettings dialogSettings;
	
	@Inject
	private EmbeddedEditorFactory editorFactory;
	
	@Inject
	private HighlightingHelper highlightingHelper;
	
	public IDialogSettings getDialogSettings() {
		return dialogSettings;
	}

	public void setDialogSettings(IDialogSettings dialogSettings) {
		this.dialogSettings = dialogSettings;
	}

	public EmbeddedEditorFactory getEmbeddedEditorFactory() {
		return editorFactory;
	}

	public void setEmbeddedEditorFactory(EmbeddedEditorFactory factory) {
		this.editorFactory = factory;
	}

	public HighlightingHelper getHighlightingHelper() {
		return highlightingHelper;
	}

	public void setHighlightingHelper(HighlightingHelper highlightingHelper) {
		this.highlightingHelper = highlightingHelper;
	}

}
