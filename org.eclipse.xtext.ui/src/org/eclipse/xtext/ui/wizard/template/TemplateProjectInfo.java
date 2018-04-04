/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.xtext.ui.wizard.DefaultProjectInfo;

/**
 * IProjectInfo extended with a ProjectTemplate to be used by IProjectCreator to create a concreate project.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public class TemplateProjectInfo extends DefaultProjectInfo {
	private final AbstractProjectTemplate projectTemplate;

	public TemplateProjectInfo(AbstractProjectTemplate projectTemplate) {
		this.projectTemplate = projectTemplate;
	}

	public AbstractProjectTemplate getProjectTemplate() {
		return projectTemplate;
	}
}
