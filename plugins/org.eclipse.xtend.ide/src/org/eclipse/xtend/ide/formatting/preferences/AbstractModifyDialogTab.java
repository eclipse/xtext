/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.ui.preferences.formatter.IModifyDialogTabPage;
import org.eclipse.jdt.internal.ui.preferences.formatter.JavaPreview;
import org.eclipse.jdt.internal.ui.preferences.formatter.ModifyDialogTabPage;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xtend.ide.formatting.FormatterSetting;
import org.eclipse.xtend.ide.formatting.SettingsData.Category;
import org.eclipse.xtend.ide.formatting.preferences.XtendPreviewFactory.XtendFormatterPreview;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * Abstract super class for all Xtend {@link FormatterModifyDialog} tab pages.
 * 
 * @author Dennis Huebner - Initial contribution and API
 */
public abstract class AbstractModifyDialogTab extends ModifyDialogTabPage {
	public static class Factory {

		@Inject
		MembersInjector<AbstractModifyDialogTab> injector;

		public IModifyDialogTabPage createGenericTab(IModificationListener modifyListener,
				Map<String, String> workingValues, Category category) {
			GenericTab tab = new GenericTab(modifyListener, workingValues, category);
			injector.injectMembers(tab);
			return tab;
		}
	}

	protected static final String GENERAL_SETTINGS = "General settings";

	@Inject
	private XtendPreviewFactory previewFactory;

	private XtendFormatterPreview formatterPreview;

	/**
	 * Abstract super class for all Xtend {@link FormatterModifyDialog} tab pages.
	 */
	public AbstractModifyDialogTab(IModificationListener modifyListener, Map<String, String> workingValues) {
		super(modifyListener, workingValues);
	}

	@Override
	protected void initializePage() {
		//Nothing to do, beacause we have an another formatterPreview live cycle
	}

	@Override
	protected Composite doCreatePreviewPane(Composite composite, int numColumns) {
		createLabel(numColumns, composite, "Xtend formatterPreview");
		formatterPreview = previewFactory.createNewPreview(composite, previewText());
		formatterPreview.doFormat(fWorkingValues);
		Control control = formatterPreview.getEditor().getViewer().getControl();

		fDefaultFocusManager.add(control);

		final GridData gd = createGridData(numColumns, GridData.FILL_BOTH, 0);
		gd.widthHint = 0;
		gd.heightHint = 0;
		control.setLayoutData(gd);
		return composite;
	}

	protected final Preference createPref(FormatterSetting formatterSetting, Composite composite, int numColumns) {
		Preference result = null;
		switch (formatterSetting.getType()) {
			case NUMBER_FIELD:
				result = createNumberPref(composite, numColumns, formatterSetting.getLabel(),
						formatterSetting.getName());
				break;
			case COMBO_BOX:
				result = createComboPref(composite, numColumns, formatterSetting.getLabel(),
						formatterSetting.getName(), asStringArray(formatterSetting.getPosibleValues()),
						asStringArray(formatterSetting.getPosibleValuesLabels()));
				break;

			default:
				break;
		}
		return result;
	}

	private static String[] asStringArray(List<String> strings) {
		return strings.toArray(new String[] {});
	}

	protected abstract String previewText();

	@Override
	protected void doUpdatePreview() {
		formatterPreview.doFormat(fWorkingValues);
	}

	/**
	 * Does nothing, not a java formatterPreview.<br>
	 * See {@link #doCreatePreviewPane(Composite, int)} for information about Xtend formatterPreview.
	 * 
	 * @returns <code>null</code> not a Java Dialog
	 */
	@Override
	protected JavaPreview doCreateJavaPreview(Composite parent) {
		return null;
	}

	/**
	 * Convenience method to create a NumberPreference. The widget is registered as a potential focus holder, and the
	 * default updater is added.<br>
	 * Min value is set to 0 and max value to 9999.
	 */
	protected NumberPreference createNumberPref(Composite composite, int numColumns, String name, String key) {
		return super.createNumberPref(composite, numColumns, name, key, 0, 9999);
	}
}
