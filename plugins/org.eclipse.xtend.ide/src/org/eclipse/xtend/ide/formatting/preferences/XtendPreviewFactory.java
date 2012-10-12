/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager;
import org.eclipse.jface.text.Region;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtend.core.formatting.IFormatterConfigurationProvider;
import org.eclipse.xtend.core.formatting.XtendFormatterConfig;
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
		embeddedEditor.createPartialEditor().updateModel("", previewContent, "");
		return new XtendFormatterPreview(embeddedEditor, xtendFormatterFactory);
	}

	static class XtendFormatterPreview implements Observer {
		private final EmbeddedEditor editorHandle;
		private final XtendFormatterFactory xtendFormatterFactory;

		public XtendFormatterPreview(EmbeddedEditor editorHandle, XtendFormatterFactory xtendFormatterFactory) {
			this.editorHandle = editorHandle;
			this.xtendFormatterFactory = xtendFormatterFactory;
		}

		public EmbeddedEditor getEditor() {
			return editorHandle;
		}

		public Observer getObserver() {
			return this;
		}

		public void update(Observable o, Object arg) {
			final ProfileManager manager = (ProfileManager) o;
			final int value = ((Integer) arg).intValue();
			switch (value) {
				case ProfileManager.PROFILE_CREATED_EVENT:
				case ProfileManager.PROFILE_DELETED_EVENT:
				case ProfileManager.SELECTION_CHANGED_EVENT:
				case ProfileManager.SETTINGS_CHANGED_EVENT: {
					doFormat(manager.getSelected().getSettings());
				}
			}
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		public void doFormat(final Map map) {
			xtendFormatterFactory.setConfigurationProvider(new IFormatterConfigurationProvider() {
				public XtendFormatterConfig getFormatterConfiguration(Resource resource) {
					return new XtendFormatterConfig(map);
				}
			});
			xtendFormatterFactory.createConfiguredFormatter(null, null).format(editorHandle.getDocument(),
					new Region(0, editorHandle.getDocument().getLength()));
//			editorHandle.getViewer().refresh();
		}

	}

}
