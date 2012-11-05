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

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.xtend.core.formatting.XtendFormatterConfig;

import com.google.common.collect.Maps;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class LineWrapTab extends AbstractModifyDialogTab {
	protected static final String PREF_PREVIEW_LINE_WIDTH = "preview.line.width";
	private Map<String, String> fPreviewPreferences;
	private static final String DEFAULT_PREVIEW_LINE_WRAP = "40";
	private Integer previewLineWidth = Integer.valueOf(DEFAULT_PREVIEW_LINE_WRAP);

	public LineWrapTab(IModificationListener modifyListener, Map<String, String> workingValues) {
		super(modifyListener, workingValues);
		fPreviewPreferences = Maps.newHashMap();
		fPreviewPreferences.put(PREF_PREVIEW_LINE_WIDTH, previewLineWidth != null ? previewLineWidth.toString()
				: DEFAULT_PREVIEW_LINE_WRAP);

	}

	@Override
	protected String previewText() {
		return PreviewCode.lineWrappingPreviewText();
	}

	@Override
	protected void doCreatePreferences(Composite composite, int numColumns) {
		Group generalGroup = createGroup(numColumns, composite, GENERAL_SETTINGS);
		createNumberPref(generalGroup, numColumns, "Maximum line width:", new XtendFormatterConfig().getMaxLineWidth());
	}

	@Override
	protected Composite doCreatePreviewPane(Composite composite, int numColumns) {
		super.doCreatePreviewPane(composite, numColumns);

		final NumberPreference previewLineWidth = new NumberPreference(composite, numColumns / 2, fPreviewPreferences,
				PREF_PREVIEW_LINE_WIDTH, 0, 9999, "Line width for preview");
		fDefaultFocusManager.add(previewLineWidth);
		previewLineWidth.addObserver(fUpdater);
		previewLineWidth.addObserver(new Observer() {
			public void update(Observable o, Object arg) {
				//TODO store in dialog settings
				//fDialogSettings.put(PREF_PREVIEW_LINE_WIDTH, (String) fPreviewPreferences.get(LINE_SPLIT));
			}
		});
		return composite;
	}
}
