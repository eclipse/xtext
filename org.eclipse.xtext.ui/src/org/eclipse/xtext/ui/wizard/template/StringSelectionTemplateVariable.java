/**
 * Copyright (c) 2017, 2020 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class StringSelectionTemplateVariable extends TemplateVariable {
	private String[] possibleValues;

	private String value;

	private Combo combo;

	public StringSelectionTemplateVariable(String label, String[] possibleValues, String description, ContainerTemplateVariable container) {
		super(label, description, container);
		this.possibleValues = possibleValues;
		this.value = possibleValues[0];
	}

	public String[] getPossibleValues() {
		return possibleValues;
	}

	@Override
	public void createWidget(ParameterComposite parameterComposite, Composite parent) {
		combo = new Combo(parent, SWT.READ_ONLY);
		combo.setItems(getPossibleValues());
		combo.setText(getValue());
		combo.setToolTipText(getDescription());
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setValue(combo.getText());
				parameterComposite.update();
			}
		});
	}

	@Override
	public void refresh() {
		if (combo.isEnabled() != isEnabled()) {
			combo.setEnabled(isEnabled());
		}
		if (!combo.getText().equals(getValue())) {
			combo.setText(getValue());
		}
	}

	@Override
	public Control getWidget() {
		return combo;
	}

	@Override
	public String toString() {
		return value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
