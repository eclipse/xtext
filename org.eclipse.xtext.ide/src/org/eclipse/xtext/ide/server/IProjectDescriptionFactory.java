/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server;

import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.workspace.IProjectConfig;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.11
 */
public interface IProjectDescriptionFactory {
	/**
	 * Create the description for the given project.
	 *
	 * @param project
	 *            the project configuration
	 * @return the description for the project.
	 */
	ProjectDescription getProjectDescription(IProjectConfig project);
}
