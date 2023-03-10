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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class GroupTemplateVariable extends ContainerTemplateVariable {
	private Group group;

	public GroupTemplateVariable(String label, String description, ContainerTemplateVariable container) {
		super(label, description, container);
	}

	@Override
	public void createWidget(ParameterComposite parameterComposite, Composite parent) {
		group = new Group(parent, SWT.READ_ONLY);
		group.setLayout(new GridLayout(2, false));
		group.setText(getLabel());
		group.setToolTipText(getDescription());
	}

	@Override
	public void refresh() {
	}

	@Override
	public Composite getWidget() {
		return group;
	}

	@Override
	public boolean isLabeled() {
		return false;
	}

	@Override
	public String toString() {
		return getLabel();
	}
}
