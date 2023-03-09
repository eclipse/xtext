/*******************************************************************************
 * Copyright (c) 2018, 2021 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
