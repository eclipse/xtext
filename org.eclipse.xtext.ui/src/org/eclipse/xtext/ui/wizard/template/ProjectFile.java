/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

/**
 * Part of a ProjectTemplate to define files the new project wizard is creating when a specific template is selected. Instantiated inside
 * methods from classes annotated with {@link ProjectTemplate}.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public final class ProjectFile {

	/**
	 * source folder relative path to create the file in (e.g. 'model/mydsl')
	 */
	private String path;
	/**
	 * The content of the file to be created at the specified path. Might contain references to variables defined in the
	 * {@link ProjectTemplate}. These will be replaced by the wizard as soon as the file is created.
	 */
	private String content;

	public ProjectFile(String path, String content) {
		this.path = path;
		this.content = content;
	}

	public String getPath() {
		return path;
	}

	public String getContent() {
		return content;
	}

}
