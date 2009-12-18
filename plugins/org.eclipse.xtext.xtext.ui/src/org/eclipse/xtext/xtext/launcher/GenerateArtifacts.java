/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtext.xtext.launcher;

import static org.eclipse.xtext.xtext.launcher.SelectionUtil.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.xtext.Constants;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class GenerateArtifacts extends AbstractHandler {

	private static final Logger logger = Logger.getLogger(GenerateArtifacts.class);

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IResource workflowFile = getWorkflowFile(event);
		if (workflowFile != null) {
			try {
				invokeGenerator(workflowFile);
			} catch (CoreException e) {
				logger.error("Could not execute workflow", e);
				e.printStackTrace();
			}
		}
		return null;
	}

	private void invokeGenerator(IResource workflowFile) throws CoreException {
		ILaunchShortcut launchShortcut = findMWELaunchShortcut();
		ISelection selection = new StructuredSelection(workflowFile);
		launchShortcut.launch(selection, "run");

		IProject project = workflowFile.getProject();
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	}

	private IResource getWorkflowFile(ExecutionEvent event) {
		IFile file = getSelectedFile(event);
		
		IResource workflowFile = getWorkflowFileFromProperties(file);
		if (workflowFile == null) {
			IContainer parent = file.getParent();
			IPath location = parent.getProjectRelativePath().append("Generate" + file.getName()).removeFileExtension()
				.addFileExtension("mwe");
			workflowFile = file.getProject().findMember(location);
		}
		return workflowFile;
	}
	
	private IResource getWorkflowFileFromProperties(IFile grammarFile) {
		IPath propertyFilePath = grammarFile.getLocation().removeFileExtension().addFileExtension("properties");
		Properties properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(propertyFilePath.toFile());
			properties.load(in);
			String workflowFileName = properties.getProperty(Constants.WORKFLOW_FILE);
			return grammarFile.getParent().findMember(workflowFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private ILaunchShortcut findMWELaunchShortcut() throws CoreException {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.debug.ui.launchShortcuts");
		for (IConfigurationElement configurationElement : config) {
			String id = configurationElement.getAttribute("id");
			if (id.equals("org.eclipse.emf.mwe.ui.debug.launching.shortcut")) {
				Object executableExtension = configurationElement.createExecutableExtension("class");
				if (executableExtension instanceof ILaunchShortcut) {
					ILaunchShortcut launchShortcut = (ILaunchShortcut) executableExtension;
					return launchShortcut;
				}
			}
		}
		return null;
	}
}
