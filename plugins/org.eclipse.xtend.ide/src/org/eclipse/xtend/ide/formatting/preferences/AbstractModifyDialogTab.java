/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.preferences.formatter.IModifyDialogTabPage;
import org.eclipse.jdt.internal.ui.preferences.formatter.JavaPreview;
import org.eclipse.jdt.internal.ui.preferences.formatter.ModifyDialogTabPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtend.core.formatting.NewLineConfig;
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

		public IModifyDialogTabPage createIndentationTab(IModificationListener modifyListener,
				Map<String, String> workingValues) {
			return injectMembers(new IndentationTab(modifyListener, workingValues));
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

	//	protected final void createPref(FormatterSetting formatterSetting, Composite composite, int numColumns) {
	//		switch (formatterSetting.getType()) {
	//			case NUMBER_FIELD:
	//				createNumberPref(composite, numColumns, formatterSetting.getLabel(), formatterSetting.getName());
	//				break;
	//			case MIN_MAX_FIELDS:
	//				createMinMaxPref(composite, numColumns, formatterSetting.getLabel(), formatterSetting.getName());
	//				break;
	//			case COMBO_BOX:
	//				createComboPref(composite, numColumns, formatterSetting.getLabel(), formatterSetting.getName(),
	//						asStringArray(formatterSetting.getPosibleValues()),
	//						asStringArray(formatterSetting.getPosibleValuesLabels()));
	//				break;
	//			default:
	//				break;
	//		}
	//	}
	//	
	//	private static String[] asStringArray(List<String> strings) {
	//		return strings.toArray(new String[] {});
	//	}

	protected Preference createMinMaxPref(Composite composite, int numColumns, String label, String name) {
		final MinMaxPreference pref = new MinMaxPreference(composite, numColumns, fWorkingValues, name, label);
		fDefaultFocusManager.add(pref);
		pref.addObserver(fUpdater);
		return pref;
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

	protected class MinMaxPreference extends Preference {

		private static final int MAX_VALUE = 9999;
		private NewLineConfig minMaxRange;
		private NewLineConfig oldMinMaxRange;

		private final Text minText;
		private final Text maxText;
		private final Label label;
		private final Composite minMaxContainer;

		@SuppressWarnings("rawtypes")
		public MinMaxPreference(Composite composite, int numColumns, Map preferences, String key, String txt) {
			super(preferences, key);
			label = createLabel(numColumns - 1, composite, txt, GridData.FILL_HORIZONTAL);
			minMaxContainer = new Composite(composite, SWT.NONE);
			minMaxContainer.setFont(composite.getFont());
			minMaxContainer.setLayout(new GridLayout(2, true));
			minMaxContainer.setLayoutData(createGridData(1, GridData.FILL, SWT.DEFAULT));

			minText = createText(minMaxContainer);
			maxText = createText(minMaxContainer);
			updateWidget();
			addListeners(minText, false);
			addListeners(maxText, true);
		}

		private Text createText(Composite composite) {
			final Text text = new Text(composite, SWT.SINGLE | SWT.BORDER | SWT.RIGHT);
			text.setFont(composite.getFont());

			final int length = Integer.toString(MAX_VALUE).length() + 3;
			text.setLayoutData(createGridData(1, GridData.HORIZONTAL_ALIGN_END,
					fPixelConverter.convertWidthInCharsToPixels(length)));
			return text;
		}

		private void addListeners(final Text text, final boolean isMax) {
			text.addFocusListener(new FocusListener() {
				public void focusGained(FocusEvent e) {
					MinMaxPreference.this.focusGained(text);
				}

				public void focusLost(FocusEvent e) {
					MinMaxPreference.this.focusLost(text, isMax);
				}
			});

			text.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					fieldModified(text, isMax);
				}
			});
		}

		protected void focusGained(Text text) {
			oldMinMaxRange = minMaxRange;
			text.setSelection(0, text.getCharCount());
		}

		protected void focusLost(Text text, final boolean isMax) {
			updateStatus(null);
			final String input = text.getText();
			if (!validInput(input, isMax)) {
				minMaxRange = oldMinMaxRange;
			} else {
				if (isMax) {
					minMaxRange = new NewLineConfig(minMaxRange.getMinNewLines(), Integer.parseInt(input));
				} else {
					minMaxRange = new NewLineConfig(Integer.parseInt(input), minMaxRange.getMaxNewLines());
				}
			}
			if (!minMaxRange.equals(oldMinMaxRange)) {
				saveSelected(minMaxRange);
				int valToSet = 0;
				if (isMax)
					valToSet = minMaxRange.getMaxNewLines();
				else
					valToSet = minMaxRange.getMinNewLines();
				text.setText(Integer.toString(valToSet));
			}
		}

		private boolean validInput(String input, boolean isMax) {
			int number;
			boolean valid = true;
			try {
				number = Integer.parseInt(input);
				if (number < 0)
					valid = false;
				if (number > MAX_VALUE)
					valid = false;

				//Check range
				if (valid) {
					if (isMax) {
						valid = number >= minMaxRange.getMinNewLines();
					} else {
						valid = number <= minMaxRange.getMaxNewLines();
					}
				}
			} catch (NumberFormatException x) {
				valid = false;
			}

			return valid;

		}

		protected void fieldModified(Text text, boolean isMax) {
			final String trimInput = text.getText().trim();
			final boolean valid = validInput(trimInput, isMax);

			updateStatus(valid ? null : createErrorStatus());
			if (valid) {
				final int number = Integer.parseInt(trimInput);
				boolean changed = false;
				if (isMax) {
					if (minMaxRange.getMaxNewLines() != number) {
						minMaxRange = new NewLineConfig(minMaxRange.getMinNewLines(), number);
						changed = true;
					}
				} else {
					if (minMaxRange.getMinNewLines() != number) {
						minMaxRange = new NewLineConfig(number, minMaxRange.getMaxNewLines());
						changed = true;
					}
				}
				if (changed)
					saveSelected(minMaxRange);
			}
		}

		private IStatus createErrorStatus() {
			return new Status(IStatus.ERROR, JavaPlugin.getPluginId(), 0, "Invalid input", null);
		}

		private void saveSelected(NewLineConfig range) {
			getPreferences().put(getKey(), range.toString());
			setChanged();
			notifyObservers();
		}

		@Override
		public Control getControl() {
			return minMaxContainer;
		}

		@Override
		protected void updateWidget() {

			final boolean hasKey = getKey() != null;

			boolean enabled = hasKey && getEnabled();
			label.setEnabled(enabled);
			minText.setEnabled(enabled);
			maxText.setEnabled(enabled);

			minMaxRange = new NewLineConfig("0,0");
			if (hasKey) {
				try {
					String s = (String) getPreferences().get(getKey());
					minMaxRange = new NewLineConfig(s);
				} catch (NumberFormatException e) {
					//TODO log an error
				}
			}
			fillFields(minMaxRange);

		}

		private void fillFields(NewLineConfig minMaxRange) {
			minText.setText(Integer.toString(minMaxRange.getMinNewLines())); //$NON-NLS-1$
			maxText.setText(Integer.toString(minMaxRange.getMaxNewLines())); //$NON-NLS-1$
		}

	}
}
