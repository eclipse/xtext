/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.ui.util.ProjectFactory;

/**
 * Generate {@link IProject}'s by providing {@link ProjectFactory} instances.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public interface IProjectGenerator {

	/**
	 * Generate a new {@link IProject} using the provided {@link ProjectFactory}.
	 * 
	 * @param project
	 *            The project factory to create a project from. The generator might choose to modify the factory further to suite his needs.
	 */
	void generate(ProjectFactory project);

}
