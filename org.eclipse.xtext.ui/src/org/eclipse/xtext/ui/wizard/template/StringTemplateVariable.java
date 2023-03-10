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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

public class StringTemplateVariable extends TemplateVariable {
	private String value;

	private Text text;

	public StringTemplateVariable(String label, String defaultValue, String description, ContainerTemplateVariable container) {
		super(label, description, container);
		this.value = defaultValue;
	}

	@Override
	public void createWidget(ParameterComposite parameterComposite, Composite parent) {
		text = new Text(parent, (SWT.SINGLE | SWT.BORDER));
		text.setText(getValue());
		text.setToolTipText(getDescription());
		text.addModifyListener((ModifyEvent it) -> {
			setValue(text.getText());
			parameterComposite.update();
		});
	}

	@Override
	public void refresh() {
		if (text.isEnabled() != isEnabled()) {
			text.setEnabled(isEnabled());
		}
		if (!text.getText().equals(getValue())) {
			text.setText(getValue());
		}
	}

	@Override
	public Control getWidget() {
		return text;
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
