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
import org.eclipse.xtext.ui.util.ProjectFactory;
import org.eclipse.xtext.ui.util.TextFileContributor;
import org.eclipse.xtext.ui.wizard.IExtendedProjectInfo;

/**
 * A template definition for a project, used by the new project wizard. Defines the UI (label, description, icon, variables) on how to
 * present the template to the user. The {@link ProjectVariable}'s can be used to configure the {@link ProjectFactory}'s added inside
 * {@link AbstractProjectTemplate#generateProjects(IProjectGenerator)}.
 * 
 * Instances of this class are generated from classes annotated with {@link ProjectTemplate}.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public abstract class AbstractProjectTemplate {

	private static final Logger logger = Logger.getLogger(AbstractProjectTemplate.class);

	protected List<ProjectVariable> variables = new ArrayList<>();

	private IExtendedProjectInfo projectInfo;

	/**
	 * Create a new text variable with associated text field and add it to the "variables" list.
	 */
	protected StringProjectVariable text(String name, String defaultValue) {
		StringProjectVariable variable = new StringProjectVariable(name, defaultValue, null, null);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new text variable with associated text field and add it to the "variables" list.
	 */
	protected StringProjectVariable text(String name, String defaultValue, ContainerProjectVariable container) {
		StringProjectVariable variable = new StringProjectVariable(name, defaultValue, null, container);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new text variable with associated text field and add it to the "variables" list.
	 */
	protected StringProjectVariable text(String name, String defaultValue, String description) {
		StringProjectVariable variable = new StringProjectVariable(name, defaultValue, description, null);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new text variable with associated text field and add it to the "variables" list.
	 */
	protected StringProjectVariable text(String name, String defaultValue, String description, ContainerProjectVariable container) {
		StringProjectVariable variable = new StringProjectVariable(name, defaultValue, description, container);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new boolean variable with associated check box and add it to the "variables" list.
	 */
	protected BooleanProjectVariable check(String name, boolean defaultValue) {
		BooleanProjectVariable variable = new BooleanProjectVariable(name, defaultValue, null, null);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new boolean variable with associated check box and add it to the "variables" list.
	 */
	protected BooleanProjectVariable check(String name, boolean defaultValue, ContainerProjectVariable container) {
		BooleanProjectVariable variable = new BooleanProjectVariable(name, defaultValue, null, container);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new boolean variable with associated check box and add it to the "variables" list.
	 */
	protected BooleanProjectVariable check(String name, boolean defaultValue, String description) {
		BooleanProjectVariable variable = new BooleanProjectVariable(name, defaultValue, description, null);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new boolean variable with associated check box and add it to the "variables" list.
	 */
	protected BooleanProjectVariable check(String name, boolean defaultValue, String description, ContainerProjectVariable container) {
		BooleanProjectVariable variable = new BooleanProjectVariable(name, defaultValue, description, container);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new text variable with associated combo box and add it to the "variables" list.
	 */
	protected StringSelectionProjectVariable combo(String name, String[] possibleValues) {
		StringSelectionProjectVariable variable = new StringSelectionProjectVariable(name, possibleValues, null, null);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new text variable with associated combo box and add it to the "variables" list.
	 */
	protected StringSelectionProjectVariable combo(String name, String[] possibleValues, ContainerProjectVariable container) {
		StringSelectionProjectVariable variable = new StringSelectionProjectVariable(name, possibleValues, null, container);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new text variable with associated combo box and add it to the "variables" list.
	 */
	protected StringSelectionProjectVariable combo(String name, String[] possibleValues, String description) {
		StringSelectionProjectVariable variable = new StringSelectionProjectVariable(name, possibleValues, description, null);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new text variable with associated combo box and add it to the "variables" list.
	 */
	protected StringSelectionProjectVariable combo(String name, String[] possibleValues, String description,
			ContainerProjectVariable container) {
		StringSelectionProjectVariable variable = new StringSelectionProjectVariable(name, possibleValues, description, container);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new group to group other values with a label.
	 */
	protected GroupProjectVariable group(String name) {
		GroupProjectVariable variable = new GroupProjectVariable(name, null, null);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new group to group other values with a label.
	 */
	protected GroupProjectVariable group(String name, ContainerProjectVariable container) {
		GroupProjectVariable variable = new GroupProjectVariable(name, null, container);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new group to group other values with a label.
	 */
	protected GroupProjectVariable group(String name, String description) {
		GroupProjectVariable variable = new GroupProjectVariable(name, description, null);
		variables.add(variable);
		return variable;
	}

	/**
	 * Create a new group to group other values with a label.
	 */
	protected GroupProjectVariable group(String name, String description, ContainerProjectVariable container) {
		GroupProjectVariable variable = new GroupProjectVariable(name, description, container);
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
	public final List<ProjectVariable> getVariables() {
		return Collections.unmodifiableList(variables);
	}

	/**
	 * Subclasses have to override. Generate all the projects to be created when the wizard is finished.
	 * 
	 * @param generator
	 *            The generator to supply {@link org.eclipse.xtext.ui.util.ProjectFactory}'s to create projects from.
	 */
	public abstract void generateProjects(IProjectGenerator generator);

	protected ProjectFactory addFile(ProjectFactory project, CharSequence fileName, CharSequence contents) {
		project.addContributor(new TextFileContributor(fileName, contents));
		return project;
	}

	protected IExtendedProjectInfo getProjectInfo() {
		return projectInfo;
	}

	void setProjectInfo(IExtendedProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
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
	 * enable/disable variables (calling {@link ProjectVariable#setEnabled(boolean)}) in the UI or change values further in reaction to a
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
