/*******************************************************************************
 * Copyright (c) 2009, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard;

import org.eclipse.core.runtime.IPath;

/**
 * @author Peter Friese - Initial contribution and API
 * 
 * @author Lorenzo Bettini - https://bugs.eclipse.org/bugs/show_bug.cgi?id=338419
 * @since 2.10
 */
public class DefaultProjectInfo implements IExtendedProjectInfo {

	private String projectName;

	private IPath locationPath;

	@Override
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @since 2.10
	 */
	@Override
	public IPath getLocationPath() {
		return locationPath;
	}

	/**
	 * @since 2.10
	 */
	@Override
	public void setLocationPath(IPath locationPath) {
		this.locationPath = locationPath;
	}
}