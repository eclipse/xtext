/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.preferences;

import org.eclipse.jface.dialogs.IDialogSettings;
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
}
