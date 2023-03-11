/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.builder;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.xtext.builder.JDTAwareEclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.util.RuntimeIOException;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Holger Schill
 */
public class SourceRelativeFileSystemAccess extends JDTAwareEclipseResourceFileSystemAccess2 {
	
	@Override
	protected boolean ensureOutputConfigurationDirectoryExists(OutputConfiguration outputConfig) {
		try {
			if (super.ensureOutputConfigurationDirectoryExists(outputConfig)) {
				IContainer container = getContainer(outputConfig);
				addToSourceFolders(container);
				return true;
			}
			return false;
		} catch (CoreException e) {
			throw new RuntimeIOException(e);
		}
	}

	@Override
	protected IContainer getContainer(OutputConfiguration outputConfig) {
		if (!outputConfig.isUseOutputPerSourceFolder() && getCurrentSource() != null) {
			String path = getCurrentSource() + "/../" + outputConfig.getOutputDirectory();
			IPath workspaceRelativePath = getProject().getFullPath().append(new Path(path));
			return getProject().getParent().getFolder(workspaceRelativePath);
		} else {
			return super.getContainer(outputConfig);
		}
	}
}
