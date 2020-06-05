/**
 * Copyright (c) 2017, 2020 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.swt.widgets.Composite;

public abstract class ContainerTemplateVariable extends TemplateVariable {
	public ContainerTemplateVariable(String label, String description, ContainerTemplateVariable container) {
		super(label, description, container);
	}

	@Override
	public abstract Composite getWidget();
}
