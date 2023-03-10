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
 * Information about the file to create.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
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
