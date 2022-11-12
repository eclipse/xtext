/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import static org.eclipse.xtext.xbase.formatting.BasicFormatterPreferenceKeys.*;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.MarginPainter;
import org.eclipse.jface.text.Region;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.formatting2.ContentFormatter;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;

import com.google.inject.Inject;
import com.google.inject.Provider;

@SuppressWarnings({ "restriction", "deprecation" })
public class XtendFormatterPreview implements Observer {

	@Inject
	private IPreferenceStoreAccess preferenceStoreAccess;

	@Inject
	private Provider<ContentFormatter> formatterProvider;

	private EmbeddedEditor editorHandle;
	private String previewContent;
	private EmbeddedEditorModelAccess modelAccess;
	private MarginPainter marginPainter;

	public XtendFormatterPreview forEmbeddedEditor(EmbeddedEditor editorHandle) {
		if (this.editorHandle != null) {
			throw new IllegalStateException("This formatter preview is already binded to an embedet editor");
		}
		this.editorHandle = editorHandle;
		this.modelAccess = editorHandle.createPartialEditor();
		this.marginPainter = new MarginPainter(editorHandle.getViewer());
		final RGB rgb = PreferenceConverter.getColor(preferenceStoreAccess.getPreferenceStore(),
				AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN_COLOR);
		marginPainter.setMarginRulerColor(EditorUtils.colorFromRGB(rgb));
		editorHandle.getViewer().addPainter(marginPainter);
		return this;
	}

	public XtendFormatterPreview withPreviewContent(String previewContent) {
		this.previewContent = previewContent;
		return this;
	}

	public XtextSourceViewer getEditorViewer() {
		checkEditorHandleIsSet();
		return editorHandle.getViewer();
	}

	private void checkEditorHandleIsSet() {
		if (editorHandle == null) {
			throw new IllegalStateException(
					"This preview should be bind to an EmbeddedEditor, call XtendFormatterPreview#forEmbeddedEditor(EmbeddedEditor) first");
		}
	}

	public Observer getObserver() {
		return this;
	}

	@Override
	public void update(Observable o, Object arg) {
		final ProfileManager manager = (ProfileManager) o;
		final int value = ((Integer) arg).intValue();
		switch (value) {
			case ProfileManager.PROFILE_CREATED_EVENT:
			case ProfileManager.PROFILE_DELETED_EVENT:
			case ProfileManager.SELECTION_CHANGED_EVENT:
			case ProfileManager.SETTINGS_CHANGED_EVENT: {
				doUpdate(manager.getSelected().getSettings());
			}
		}
	}

	public void doUpdate(final Map<String, String> map) {
		checkEditorHandleIsSet();
		final MapBasedPreferenceValues values = new MapBasedPreferenceValues(map);
		String maxLineWidthValue = values.getPreference(maxLineWidth);
		if (maxLineWidthValue != null) {
			moveMarginToColumn(maxLineWidthValue);
		}

		StyledText widget = null;
		try {
			widget = (StyledText) editorHandle.getViewer().getControl();
			widget.setRedraw(false); // disable redraw, otherwise this would causes funny animation effects during formating.
			this.modelAccess.updateModel("", previewContent, "");
			XtextDocument document = editorHandle.getDocument();
			ContentFormatter formatter = formatterProvider.get();
			formatter.setPreferencesProvider(values);
			formatter.format(document, new Region(0, document.getLength()));
			editorHandle.getViewer().setSelection(null); // reset selection, otherwise the whole new content will be selected
		} finally {
			if (widget != null)
				widget.setRedraw(true);
		}
	}

	public void moveMarginToColumn(String string) {
		checkEditorHandleIsSet();
		int parsedColumn = 99999;
		try {
			parsedColumn = Integer.parseInt(string);
		} catch (NumberFormatException nfe) {
		}
		marginPainter.setMarginRulerColumn(parsedColumn);
	}
}