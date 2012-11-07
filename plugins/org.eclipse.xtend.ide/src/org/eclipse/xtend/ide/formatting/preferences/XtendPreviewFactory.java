/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtend.ide.formatting.XtendFormatterFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Inject;

/**
 * TODO revisit when Formatter API is clear
 * 
 * @author Dennis Huebner - Initial contribution and API
 */
public class XtendPreviewFactory {
	@Inject
	private EmbeddedEditorFactory editorFactory;
	@Inject
	private IEditedResourceProvider resourceProvider;
	@Inject
	protected XtendFormatterFactory xtendFormatterFactory;

	public XtendFormatterPreview createNewPreview(Composite composite, String previewContent) {
		EmbeddedEditor embeddedEditor = editorFactory.newEditor(resourceProvider)
				.withResourceValidator(IResourceValidator.NULL).readOnly().withParent(composite);
		return new XtendFormatterPreview(embeddedEditor, previewContent, xtendFormatterFactory);
	}

}
