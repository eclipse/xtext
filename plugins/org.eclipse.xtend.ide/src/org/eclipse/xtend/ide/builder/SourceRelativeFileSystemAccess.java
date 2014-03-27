/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.builder;

import java.util.Collection;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.builder.JDTAwareEclipseResourceFileSystemAccess2;
import org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.util.RuntimeIOException;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Holger Schill
 */
public class SourceRelativeFileSystemAccess extends JDTAwareEclipseResourceFileSystemAccess2 {
	
	private IPreferenceStoreAccess preferenceStoreAccess;
	
	@Inject
	public void setPreferenceStoreAccess(IPreferenceStoreAccess preferenceStoreAccess) {
		this.preferenceStoreAccess = preferenceStoreAccess;
	}
	
	@Override
	protected boolean ensureOutputConfigurationDirectoryExists(OutputConfiguration outputConfig) {
		try {
			super.ensureOutputConfigurationDirectoryExists(outputConfig);
			IContainer container = getContainer(outputConfig);
			addToSourceFolders(container);
			ignoreInOutputSettings(outputConfig, container);
			return true;
		} catch (CoreException e) {
			throw new RuntimeIOException(e);
		}
	}

	protected void ignoreInOutputSettings(OutputConfiguration outputConfig, IContainer container) {
		String newSourceFolder = container.getProjectRelativePath().toString();
		IPreferenceStore prefs = preferenceStoreAccess.getWritablePreferenceStore(container.getProject());
		prefs.setValue(BuilderPreferenceAccess.getIgnoreSourceFolderKey(outputConfig, newSourceFolder), true);
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

	/**
	 * Since sourceTraces are relative the URI has to be computed with the currentSource as context
	 */
	//TODO this fixes relative URIs for Xtend only, but what about all other languages?
	@Override
	public void flushSourceTraces(String generatorName) throws CoreException {
		Multimap<URI, IPath> sourceTraces = getSourceTraces();
		if (sourceTraces != null) {
			Set<URI> keys = sourceTraces.keySet();
			for (URI uri : keys) {
				if (uri != null && getCurrentSource() != null) {
					Collection<IPath> paths = sourceTraces.get(uri);
					IFile sourceFile = getProject().getFolder(getCurrentSource()).getFile(new Path(uri.toFileString()));
					if (sourceFile.exists()) {
						IPath[] tracePathArray = paths.toArray(new IPath[paths.size()]);
						getTraceMarkers().installMarker(sourceFile, generatorName, tracePathArray);
					}
				}
			}
		}
		resetSourceTraces();
	}
}
