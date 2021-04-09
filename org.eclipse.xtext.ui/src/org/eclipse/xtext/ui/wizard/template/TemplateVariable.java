/**
 * Copyright (c) 2017, 2021 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Part of a template the variable defines the UI for the user to configure the generated files. A variable will be associated with a widget
 * to represent it inside the UI.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public abstract class TemplateVariable {
	private final String label;

	private final String description;

	private boolean enabled;

	private ContainerTemplateVariable container;

	TemplateVariable(String label, String description, ContainerTemplateVariable container) {
		this.label = label;
		this.description = description;
		this.enabled = true;
		this.container = container;
	}

	/**
	 * Subclasses should override and create a widget representing the variable in UI. A reference to the widget should be maintained.
	 */
	public abstract void createWidget(final ParameterComposite parameterComposite, final Composite parent);

	/**
	 * Subclasses should override to refresh the UI widget with data set to the variable in the meantime.
	 */
	public abstract void refresh();

	public abstract Control getWidget();

	public boolean isLabeled() {
		return true;
	}

	public String getLabel() {
		return label;
	}

	public String getDescription() {
		return description;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public ContainerTemplateVariable getContainer() {
		return container;
	}
}
