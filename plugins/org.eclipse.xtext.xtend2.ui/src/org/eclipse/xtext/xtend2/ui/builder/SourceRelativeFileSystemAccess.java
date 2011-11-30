/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.builder;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.builder.JDTAwareEclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.OutputConfiguration;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SourceRelativeFileSystemAccess extends JDTAwareEclipseResourceFileSystemAccess2 {
	
	private IFolder currentSource = null;
	
	public void setCurrentSource(IFolder currentSource) {
		this.currentSource = currentSource;
	}
	
	@Override
	protected IFolder getFolder(OutputConfiguration outputConfig) {
		if (currentSource != null) {
			String directory = outputConfig.getOutputDirectory();
			IPath path = currentSource.getFullPath().append("../"+directory);
			IFolder folder = currentSource.getWorkspace().getRoot().getFolder(path);
			return folder;
		}
		return super.getFolder(outputConfig);
	}

}
