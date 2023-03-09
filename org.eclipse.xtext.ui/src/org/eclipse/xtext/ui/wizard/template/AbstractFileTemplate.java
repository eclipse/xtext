/*******************************************************************************
 * Copyright (c) 2017, 2021 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

/**
 * A template definition for a file, used by the new file wizard. Defines the UI (label, description, icon, variables) on how to present the
 * template to the user. The {@link TemplateVariable}'s can be used.
 * 
 * Instances of this class are generated from classes annotated with {@link FileTemplate}.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public abstract class AbstractFileTemplate extends AbstractTemplate {

	private TemplateFileInfo info;

	abstract public void generateFiles(IFileGenerator generator);

	protected TemplateFileInfo getTemplateInfo() {
		return info;
	}

	protected String getFolder() {
		return info.getFolder();
	}

	protected String getName() {
		return info.getName();
	}

	/**
	 * @since 2.25
	 */
	protected void setTemplateInfo(TemplateFileInfo info) {
		this.info = info;
	}

}
