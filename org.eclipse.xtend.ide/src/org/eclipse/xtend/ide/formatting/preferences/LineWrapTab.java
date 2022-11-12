/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import static org.eclipse.xtend.core.formatting2.XtendFormatterPreferenceKeys.*;

import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings({"restriction", "deprecation"})
public class LineWrapTab extends AbstractModifyDialogTab {
	private Map<String, String> fPreviewPreferences;
	private static final String DEFAULT_PREVIEW_LINE_WRAP = "40";
	private Integer previewLineWidth = Integer.valueOf(DEFAULT_PREVIEW_LINE_WRAP);
	@Inject
	private IDialogSettings fDialogSettings;

	public static final String PREF_PREVIEW_LINE_WIDTH = "preview.line.width";

	public LineWrapTab(IModificationListener modifyListener, Map<String, String> workingValues) {
		super(modifyListener, workingValues);
	}

	public void initPrefs() {
		String previewLineWidth = fDialogSettings.get(PREF_PREVIEW_LINE_WIDTH);

		fPreviewPreferences = Maps.newHashMap();
		fPreviewPreferences.put(PREF_PREVIEW_LINE_WIDTH, previewLineWidth != null
				&& previewLineWidth.trim().length() > 0 ? previewLineWidth.toString() : DEFAULT_PREVIEW_LINE_WRAP);
	}

	@Override
	protected String previewText() {
		return PreviewCode.lineWrappingPreviewText();
	}

	@Override
	protected void doCreatePreferences(Composite composite, int numColumns) {
		Group generalGroup = createGroup(numColumns, composite, GENERAL_SETTINGS);
		createNumberPref(generalGroup, numColumns, "Maximum line width:", maxLineWidth);
	}

	@Override
	protected void doUpdatePreview() {
		String maxLineWidthKey = maxLineWidth.getId();
		final Object normalSetting = fWorkingValues.get(maxLineWidthKey);
		String previewLineWidth = fPreviewPreferences.get(PREF_PREVIEW_LINE_WIDTH);
		formatterPreview.moveMarginToColumn(previewLineWidth);
		fWorkingValues.put(maxLineWidthKey, previewLineWidth);
		super.doUpdatePreview();
		fWorkingValues.put(maxLineWidthKey, normalSetting!=null?normalSetting.toString():"");
	}

	@Override
	protected Composite doCreatePreviewPane(Composite composite, int numColumns) {
		super.doCreatePreviewPane(composite, numColumns);
		formatterPreview.moveMarginToColumn(previewLineWidth.toString());
		final NumberPreference previewLineWidth = new NumberPreference(composite, numColumns / 2, fPreviewPreferences,
				PREF_PREVIEW_LINE_WIDTH, 0, 999, "Line width for preview");
		fDefaultFocusManager.add(previewLineWidth);
		previewLineWidth.addObserver(fUpdater);
		previewLineWidth.addObserver(new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				if (fDialogSettings != null)
					fDialogSettings.put(PREF_PREVIEW_LINE_WIDTH, fPreviewPreferences.get(PREF_PREVIEW_LINE_WIDTH));
			}
		});
		return composite;
	}

	
}
