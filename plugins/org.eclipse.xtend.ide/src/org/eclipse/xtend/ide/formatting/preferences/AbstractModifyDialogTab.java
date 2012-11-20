/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import java.util.Map;

import org.eclipse.jdt.internal.ui.preferences.formatter.IModifyDialogTabPage;
import org.eclipse.jdt.internal.ui.preferences.formatter.JavaPreview;
import org.eclipse.jdt.internal.ui.preferences.formatter.ModifyDialogTabPage;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.xtext.xbase.configuration.BooleanKey;
import org.eclipse.xtext.xbase.configuration.IntegerKey;
import org.eclipse.xtext.xbase.formatting.IFormatterConfigurationProvider;

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

		public IModifyDialogTabPage createIndentationTab(IModificationListener modifyListener,
				Map<String, String> workingValues) {
			return injectMembers(new IndentationTab(modifyListener, workingValues));
		}

		public IModifyDialogTabPage createBracesTab(IModificationListener modifyListener,
				Map<String, String> workingValues) {
			return injectMembers(new BracesTab(modifyListener, workingValues));
		}

		public IModifyDialogTabPage createWhiteSpaceTab(IModificationListener modifyListener,
				Map<String, String> workingValues) {
			return injectMembers(new WhiteSpaceTab(modifyListener, workingValues));
		}

		public IModifyDialogTabPage createBlankLinesTab(IModificationListener modifyListener,
				Map<String, String> workingValues) {
			return injectMembers(new BlankLinesTab(modifyListener, workingValues));
		}

		public IModifyDialogTabPage createNewLineTab(IModificationListener modifyListener,
				Map<String, String> workingValues) {
			return injectMembers(new NewLineTab(modifyListener, workingValues));
		}

		public IModifyDialogTabPage createLineWrapTab(IModificationListener modifyListener,
				Map<String, String> workingValues) {
			return injectMembers(new LineWrapTab(modifyListener, workingValues));
		}

		private <T extends AbstractModifyDialogTab> T injectMembers(T tab) {
			injector.injectMembers(tab);
			return tab;
		}
	}

	protected static final String GENERAL_SETTINGS = "General settings";

	@Inject
	private XtendPreviewFactory previewFactory;
	@Inject
	private IFormatterConfigurationProvider xtendConfigProvider;

	protected XtendFormatterPreview formatterPreview;

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
		doUpdatePreview();
		Control control = formatterPreview.getEditorViewer().getControl();

		fDefaultFocusManager.add(control);

		final GridData gd = createGridData(numColumns, GridData.FILL_BOTH, 0);
		gd.widthHint = 0;
		gd.heightHint = 0;
		control.setLayoutData(gd);
		return composite;
	}

	protected abstract String previewText();

	@Override
	protected void doUpdatePreview() {
		formatterPreview.doUpdate(fWorkingValues);
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
	 * Min value is set to 0 and max value to 999.
	 */
	protected NumberPreference createNumberPref(Composite composite, int numColumns, String name,
			IntegerKey integerEntry) {
		return createNumberPref(composite, numColumns, name, integerEntry.getName());
	}

	protected NumberPreference createNumberPref(Composite composite, int numColumns, String name, String key) {
		return super.createNumberPref(composite, numColumns, name, key, 0, 999);
	}

	protected void createCheckboxPref(Group annotationGroup, int numColumns, String label, BooleanKey nlKey) {
		createCheckboxPref(annotationGroup, numColumns, label, nlKey.getName(), new String[] {
				Boolean.FALSE.toString(), Boolean.TRUE.toString() });
	}

}
