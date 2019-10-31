/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
