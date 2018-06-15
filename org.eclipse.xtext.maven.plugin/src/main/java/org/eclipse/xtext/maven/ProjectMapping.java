/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtext.maven;

import java.io.File;

/**
 * 
 * @author Christian Dietrich - Initial contribution and API
 *
 */
public class ProjectMapping {

	/**
	 * @property
	 * @required
	 */
	private String projectName;

	/**
	 * @property
	 * @required
	 */
	private File path;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public File getPath() {
		return path;
	}

	public void setPath(File path) {
		this.path = path;
	}

}
