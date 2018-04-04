/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

/**
 * Information about the file to create.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public class TemplateFileInfo {
	private final String location;
	private final String name;
	private final AbstractFileTemplate template;

	public TemplateFileInfo(String location, String name, AbstractFileTemplate template) {
		this.location = location;
		this.name = name;
		this.template = template;
	}

	public String getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public AbstractFileTemplate getFileTemplate() {
		return template;
	}

}
