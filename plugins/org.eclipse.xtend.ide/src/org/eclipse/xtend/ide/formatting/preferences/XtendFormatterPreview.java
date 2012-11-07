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
import org.eclipse.jface.text.MarginPainter;
import org.eclipse.jface.text.Region;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.xtend.core.formatting.IConfigurationValues;
import org.eclipse.xtend.core.formatting.IFormatterConfigurationProvider;
import org.eclipse.xtend.core.formatting.MapBasedConfigurationValues;
import org.eclipse.xtend.core.formatting.XtendFormatterConfigKeys;
import org.eclipse.xtend.ide.formatting.XtendFormatterFactory;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;

public class XtendFormatterPreview implements Observer {
	private final EmbeddedEditor editorHandle;
	private final XtendFormatterFactory xtendFormatterFactory;
	private String previewContent;
	private EmbeddedEditorModelAccess modelAccess;
	private MarginPainter marginPainter;
	public static final String PREF_PREVIEW_LINE_WIDTH = "preview.line.width";

	public XtendFormatterPreview(EmbeddedEditor editorHandle, String previewContent,
			XtendFormatterFactory xtendFormatterFactory) {
		this.editorHandle = editorHandle;
		this.previewContent = previewContent;
		this.modelAccess = editorHandle.createPartialEditor();
		this.xtendFormatterFactory = xtendFormatterFactory;
		marginPainter = new MarginPainter(editorHandle.getViewer());
		marginPainter.setMarginRulerColor(editorHandle.getViewer().getControl().getForeground());
		editorHandle.getViewer().addPainter(marginPainter);
	}

	public XtextSourceViewer getEditorViewer() {
		return editorHandle.getViewer();
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
				doUpdate(manager.getSelected().getSettings());
			}
		}
	}

	public MarginPainter getMarginPainter() {
		return marginPainter;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doUpdate(final Map map) {
		marginPainter.setMarginRulerColumn(intValue(map.get(PREF_PREVIEW_LINE_WIDTH)));
		xtendFormatterFactory.setConfigurationProvider(new IFormatterConfigurationProvider() {
			public IConfigurationValues<XtendFormatterConfigKeys> getFormatterConfiguration(Resource resource) {
				return new MapBasedConfigurationValues<XtendFormatterConfigKeys>(new XtendFormatterConfigKeys(), map);
			}
		});
		StyledText widget = null;
		try {
			widget = (StyledText) editorHandle.getViewer().getControl();
			widget.setRedraw(false); // disable redraw, otherwise this would causes funny animation effects during formating.
			this.modelAccess.updateModel("", previewContent, "");
			xtendFormatterFactory.createConfiguredFormatter(null, null).format(editorHandle.getDocument(),
					new Region(0, editorHandle.getDocument().getLength()));
			editorHandle.getViewer().setSelection(null); // reset selection, otherwise the whole new content will be selected
		} finally {
			if (widget != null)
				widget.setRedraw(true);
		}
	}

	private int intValue(Object object) {
		if (object != null) {
			try {
				return Integer.parseInt(object.toString());
			} catch (NumberFormatException nfe) {
			}
		}
		return 99999;
	}
}