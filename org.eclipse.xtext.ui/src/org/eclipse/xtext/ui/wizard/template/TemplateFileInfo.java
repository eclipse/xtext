/*******************************************************************************
 * Copyright (c) 2017, 2018 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import com.google.common.annotations.Beta;

/**
 * Information about the file to create.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
@Beta
public class TemplateFileInfo {
	private final String folder;
	private final String name;
	private final AbstractFileTemplate template;

	public TemplateFileInfo(String folder, String name, AbstractFileTemplate template) {
		this.folder = folder;
		this.name = name;
		this.template = template;
	}

	public String getFolder() {
		return folder;
	}

	public String getName() {
		return name;
	}

	public AbstractFileTemplate getFileTemplate() {
		return template;
	}

}
