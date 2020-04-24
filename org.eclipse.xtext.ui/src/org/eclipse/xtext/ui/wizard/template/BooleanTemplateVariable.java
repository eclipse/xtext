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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class BooleanTemplateVariable extends TemplateVariable {
	private boolean value;

	private Button checkbox;

	public BooleanTemplateVariable(String label, boolean defaultValue, String description, ContainerTemplateVariable container) {
		super(label, description, container);
		this.value = defaultValue;
	}

	public boolean getValue() {
		return this.value;
	}

	@Override
	public void createWidget(ParameterComposite parameterComposite, Composite parent) {
		checkbox = new Button(parent, SWT.CHECK);
		checkbox.setText(getLabel());
		checkbox.setSelection(getValue());
		checkbox.setToolTipText(getDescription());
		checkbox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setValue(checkbox.getSelection());
				parameterComposite.update();
			}
		});
	}

	@Override
	public void refresh() {
		if (checkbox.isEnabled() != isEnabled()) {
			checkbox.setEnabled(isEnabled());
		}
		if (checkbox.getSelection() != getValue()) {
			checkbox.setSelection(getValue());
		}
	}

	@Override
	public boolean isLabeled() {
		return false;
	}

	@Override
	public Control getWidget() {
		return checkbox;
	}

	@Override
	public String toString() {
		return Boolean.valueOf(value).toString();
	}

	public void setValue(boolean value) {
		this.value = value;
	}
}
