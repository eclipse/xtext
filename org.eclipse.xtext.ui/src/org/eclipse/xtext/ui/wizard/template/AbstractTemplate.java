/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * A template definition used by the new wizards. Defines the UI (label, description, icon, variables) on how to present the template to the
 * user.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public abstract class AbstractTemplate {

	private static final Logger logger = Logger.getLogger(AbstractTemplate.class);

	protected List<TemplateVariable> variables = new ArrayList<>();

	/**
	 * Create a new text variable with associated text field and add it to the "variables" list.
	 */
	protected StringTemplateVariable text(String name, String defaultValue) {
		StringTemplateVariable variable = new StringTemplateVariable(name, defaultValue, null, null);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new text variable with associated text field and add it to the "variables" list.
	 */
	protected StringTemplateVariable text(String name, String defaultValue, ContainerTemplateVariable container) {
		StringTemplateVariable variable = new StringTemplateVariable(name, defaultValue, null, container);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new text variable with associated text field and add it to the "variables" list.
	 */
	protected StringTemplateVariable text(String name, String defaultValue, String description) {
		StringTemplateVariable variable = new StringTemplateVariable(name, defaultValue, description, null);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new text variable with associated text field and add it to the "variables" list.
	 */
	protected StringTemplateVariable text(String name, String defaultValue, String description, ContainerTemplateVariable container) {
		StringTemplateVariable variable = new StringTemplateVariable(name, defaultValue, description, container);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new boolean variable with associated check box and add it to the "variables" list.
	 */
	protected BooleanTemplateVariable check(String name, boolean defaultValue) {
		BooleanTemplateVariable variable = new BooleanTemplateVariable(name, defaultValue, null, null);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new boolean variable with associated check box and add it to the "variables" list.
	 */
	protected BooleanTemplateVariable check(String name, boolean defaultValue, ContainerTemplateVariable container) {
		BooleanTemplateVariable variable = new BooleanTemplateVariable(name, defaultValue, null, container);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new boolean variable with associated check box and add it to the "variables" list.
	 */
	protected BooleanTemplateVariable check(String name, boolean defaultValue, String description) {
		BooleanTemplateVariable variable = new BooleanTemplateVariable(name, defaultValue, description, null);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new boolean variable with associated check box and add it to the "variables" list.
	 */
	protected BooleanTemplateVariable check(String name, boolean defaultValue, String description, ContainerTemplateVariable container) {
		BooleanTemplateVariable variable = new BooleanTemplateVariable(name, defaultValue, description, container);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new text variable with associated combo box and add it to the "variables" list.
	 */
	protected StringSelectionTemplateVariable combo(String name, String[] possibleValues) {
		StringSelectionTemplateVariable variable = new StringSelectionTemplateVariable(name, possibleValues, null, null);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new text variable with associated combo box and add it to the "variables" list.
	 */
	protected StringSelectionTemplateVariable combo(String name, String[] possibleValues, ContainerTemplateVariable container) {
		StringSelectionTemplateVariable variable = new StringSelectionTemplateVariable(name, possibleValues, null, container);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new text variable with associated combo box and add it to the "variables" list.
	 */
	protected StringSelectionTemplateVariable combo(String name, String[] possibleValues, String description) {
		StringSelectionTemplateVariable variable = new StringSelectionTemplateVariable(name, possibleValues, description, null);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new text variable with associated combo box and add it to the "variables" list.
	 */
	protected StringSelectionTemplateVariable combo(String name, String[] possibleValues, String description,
			ContainerTemplateVariable container) {
		StringSelectionTemplateVariable variable = new StringSelectionTemplateVariable(name, possibleValues, description, container);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new group to group other values with a label.
	 */
	protected GroupTemplateVariable group(String name) {
		GroupTemplateVariable variable = new GroupTemplateVariable(name, null, null);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new group to group other values with a label.
	 */
	protected GroupTemplateVariable group(String name, ContainerTemplateVariable container) {
		GroupTemplateVariable variable = new GroupTemplateVariable(name, null, container);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new group to group other values with a label.
	 */
	protected GroupTemplateVariable group(String name, String description) {
		GroupTemplateVariable variable = new GroupTemplateVariable(name, description, null);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new group to group other values with a label.
	 */
	protected GroupTemplateVariable group(String name, String description, ContainerTemplateVariable container) {
		GroupTemplateVariable variable = new GroupTemplateVariable(name, description, container);
		variables.add(variable);
		return variable;
	}

	/**
	 * @return The label read from the {@link ProjectTemplate} annotation.
	 */
	public final String getLabel() {
		return getLocalizedValue("Label"); //$NON-NLS-1$
	}

	/**
	 * @return The icon read from the {@link ProjectTemplate} annotation.
	 */
	public final String getIcon() {
		return getProjectTemplateAnnotation().icon();
	}

	/**
	 * @return The description read from the {@link ProjectTemplate} annotation.
	 */
	public final String getDescription() {
		return getLocalizedValue("Description"); //$NON-NLS-1$
	}

	private String getLocalizedValue(String fieldName) {
		try {
			return (String) getClass().getClassLoader().loadClass(getClass().getPackage().getName() + ".Messages") //$NON-NLS-1$
					.getField(getClass().getSimpleName() + "_" + fieldName).get(null); //$NON-NLS-1$
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException | ClassNotFoundException e) {
			logger.error("Can not determine '" + fieldName + "'", e); //$NON-NLS-1$ //$NON-NLS-2$
			return "NOT AVAILABLE"; //$NON-NLS-1$
		}
	}

	/**
	 * @return The variables read reflectively from this class.
	 */
	public final List<TemplateVariable> getVariables() {
		return Collections.unmodifiableList(variables);
	}

	/**
	 * Subclasses should override to validate the variables. If everything is ok {@link Status#OK_STATUS} should be returned. Otherwise an
	 * ERROR or WARNING Status might be returned whereas the message is displayed to the user.
	 */
	protected IStatus validate() {
		return Status.OK_STATUS;
	}

	/**
	 * Subclasses should override. The method is called after each change of a variable value through the user. It can be used to
	 * enable/disable variables (calling {@link TemplateVariable#setEnabled(boolean)}) in the UI or change values further in reaction to a
	 * user change. Does nothing by default.
	 */
	protected void updateVariables() {
	}

	private ProjectTemplate getProjectTemplateAnnotation() {
		Class<? extends Object> projectTemplateClass = getClass();
		ProjectTemplate projectTemplateAnnotation = projectTemplateClass.getAnnotation(ProjectTemplate.class);
		if (projectTemplateAnnotation == null)
			throw new RuntimeException("Template class '" + projectTemplateClass.getName() + "' does not declare a '" //$NON-NLS-1$ //$NON-NLS-2$
					+ ProjectTemplate.class.getName() + "' annotation"); //$NON-NLS-1$
		return projectTemplateAnnotation;
	}

}
