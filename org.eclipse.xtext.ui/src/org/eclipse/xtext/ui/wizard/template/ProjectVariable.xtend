/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.swt.SWT
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.widgets.Text
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Part of a project template the variable defines the UI for the user to configure the generated files.
 * A variable will be associated with a widget to represent it inside the UI.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public abstract class ProjectVariable {

	@Accessors(PUBLIC_GETTER) private final String label
	@Accessors(PUBLIC_GETTER) private final String description
	@Accessors private var boolean enabled

	package new(String label, String description) {
		this.label = label
		this.description = description
		this.enabled = true
	}
	
	/**
	 * Subclasses should override and create a widget representing the variable in UI. A reference to the widget should
	 * be maintained.
	 */
	def void createWidget(IParameterPage parameterPage);

	/**
	 * Subclasses should override to refresh the UI widget with data set to the variable in the meantime.
	 */
	def void refresh();

}

public class BooleanProjectVariable extends ProjectVariable {

	@Accessors(PUBLIC_SETTER) boolean value
	Button checkbox

	new(String label, boolean defaultValue, String description) {
		super(label, description)
		value = defaultValue
	}

	def getValue() { value }

	override void createWidget(IParameterPage parameterPage) {
		checkbox = new Button(parameterPage.control, SWT.CHECK)
		checkbox.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false))
		checkbox.setSelection(getValue())
		checkbox.setToolTipText(description)
		checkbox.addSelectionListener(new SelectionAdapter() {
			override widgetSelected(SelectionEvent e) {
				setValue(checkbox.getSelection())
				parameterPage.update()
			}
		})
	}

	override refresh() {
		if (checkbox.isEnabled() != enabled)
			checkbox.setEnabled(enabled)
		if (checkbox.getSelection() != getValue())
			checkbox.setSelection(getValue())
	}

	override String toString() { value.toString }

}

public class StringProjectVariable extends ProjectVariable {

	@Accessors String value
	Text text

	new(String label, String defaultValue, String description) {
		super(label, description)
		value = defaultValue
	}
	
	override createWidget(IParameterPage parameterPage) {
		text = new Text(parameterPage.control, SWT.SINGLE.bitwiseOr(SWT.BORDER))
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false))
		text.setText(getValue())
		text.setToolTipText(description)
		text.addModifyListener([
			setValue(text.getText())
			parameterPage.update()
		])
	}

	override refresh() {
		if (text.isEnabled() != enabled)
			text.setEnabled(enabled)
		if (!text.getText().equals(getValue()))
			text.setText(getValue())
	}

	override String toString() { value }

}

public class StringSelectionProjectVariable extends ProjectVariable {

	@Accessors(PUBLIC_GETTER) String[] possibleValues
	@Accessors String value
	Combo combo

	new(String label, String[] possibleValues, String description) {
		super(label, description)
		this.possibleValues = possibleValues
		this.value = possibleValues.get(0)
	}

	def String[] getPossibleValues() { possibleValues }

	override createWidget(IParameterPage parameterPage) {
		combo = new Combo(parameterPage.control, SWT.READ_ONLY)
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false))
		combo.setItems(getPossibleValues())
		combo.setText(getValue())
		combo.setToolTipText(description)
		combo.addSelectionListener(new SelectionAdapter() {
			override widgetSelected(SelectionEvent e) {
				setValue(combo.getText())
				parameterPage.update()
			}
		})
	}

	override refresh() {
		if (combo.isEnabled() != enabled)
			combo.setEnabled(enabled)
		if (!combo.getText().equals(getValue()))
			combo.setText(getValue())
	}

	override String toString() { value }

}
