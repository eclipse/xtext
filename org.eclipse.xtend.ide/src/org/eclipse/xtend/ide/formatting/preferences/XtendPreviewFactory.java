/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XtendPreviewFactory {
	@Inject
	private EmbeddedEditorFactory editorFactory;
	@Inject
	private IEditedResourceProvider resourceProvider;
	@Inject
	private MembersInjector<XtendFormatterPreview> memberInjector;

	public XtendFormatterPreview createNewPreview(Composite composite, String previewContent) {
		XtendFormatterPreview formatterPreview = new XtendFormatterPreview();
		memberInjector.injectMembers(formatterPreview);
		EmbeddedEditor embeddedEditor = editorFactory.newEditor(resourceProvider)
				.withResourceValidator(IResourceValidator.NULL).readOnly().withParent(composite);
		return formatterPreview.forEmbeddedEditor(embeddedEditor).withPreviewContent(previewContent);
	}

}
