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
 * A template definition for a file, used by the new file wizard. Defines the UI (label, description, icon, variables) on how to present the
 * template to the user. The {@link TemplateVariable}'s can be used.
 * 
 * Instances of this class are generated from classes annotated with {@link FileTemplate}.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
@Beta
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
	
	void setTemplateInfo(TemplateFileInfo info) {
		this.info = info;
	}

}
