/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.workspace;

import java.util.Set;

import org.eclipse.emf.common.util.URI;

public interface IWorkspaceConfig {

	/**
	 * @return the set of projects belonging to the current workspace. Note that these are usually only populated in the
	 *         context of an IDE.
	 */
	Set<? extends IProjectConfig> getProjects();

	/**
	 * @return the project whose source folders physically contain this member or null if none was found
	 */
	IProjectConfig findProjectContaining(URI member);

	/**
	 * @return the project with the given name or null if none was found
	 */
	IProjectConfig findProjectByName(String name);
}
