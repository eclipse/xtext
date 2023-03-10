/*******************************************************************************
 * Copyright (c) 2017, 2021 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
