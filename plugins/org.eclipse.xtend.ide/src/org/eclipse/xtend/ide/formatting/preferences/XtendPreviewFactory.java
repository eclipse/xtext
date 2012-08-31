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

import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager;
import org.eclipse.jface.text.Region;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtend.core.formatting.RendererConfiguration;
import org.eclipse.xtend.ide.formatting.FormatterPreferenceInfra;
import org.eclipse.xtend.ide.formatting.IRendererConfigurationProvider;
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
	static class XtendFormatterPreview {
		private final PreviewManager previewManager;
		private final EmbeddedEditor editorHandle;

		public XtendFormatterPreview(PreviewManager previewManager, EmbeddedEditor editorHandle, String previewContent) {
			super();
			this.previewManager = previewManager;
			this.editorHandle = editorHandle;
			this.editorHandle.createPartialEditor().updateModel("", previewContent, "");
		}

		public EmbeddedEditor getEditor() {
			return editorHandle;
		}

		public void doFormat(Map<String, String> settings) {
			previewManager.doFormat(settings);
		}

		public Observer getObserver() {
			return previewManager;
		}
	}

	static class PreviewManager implements Observer {
		private EmbeddedEditor handle;
		private XtendFormatterFactory xtendFormatterFactory;

		public PreviewManager(EmbeddedEditor handle, XtendFormatterFactory xtendFormatterFactory) {
			this.handle = handle;
			this.xtendFormatterFactory = xtendFormatterFactory;
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

		public void doFormat(final Map<String, String> map) {
			xtendFormatterFactory.setConfigurationProvider(new IRendererConfigurationProvider() {
				public RendererConfiguration rendererConfiguration() {
					return FormatterPreferenceInfra.createRendererConfiguration(map);
				}
			});
			xtendFormatterFactory.createConfiguredFormatter(null, null).format(handle.getDocument(),
					new Region(0, handle.getDocument().getLength()));
			handle.getViewer().refresh();
		}

	}

	@Inject
	private EmbeddedEditorFactory editorFactory;
	@Inject
	private IEditedResourceProvider resourceProvider;
	@Inject
	protected XtendFormatterFactory xtendFormatterFactory;

	public XtendFormatterPreview createNewPreview(Composite composite, String previewContent) {
		EmbeddedEditor embeddedEditor = editorFactory.newEditor(resourceProvider)
				.withResourceValidator(IResourceValidator.NULL).readOnly().withParent(composite);
		XtendPreviewFactory.PreviewManager updater = new XtendPreviewFactory.PreviewManager(embeddedEditor,
				xtendFormatterFactory);
		return new XtendFormatterPreview(updater, embeddedEditor, previewContent);
	}
}
