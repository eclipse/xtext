/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.launcher;

import static org.eclipse.xtext.xtext.launcher.SelectionUtil.*;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class MWELaunchUtils {

	private static final Logger logger = Logger.getLogger(MWELaunchUtils.class);

	public static IResource workflowFileFor(ExecutionEvent event) {
		IFile file = getSelectedFile(event);
		return workflowFileFor(file);
	}

	public static boolean workflowFileAvailableFor(IEditorPart activeEditor) {
		return (workflowFileFor(activeEditor) != null);
	}

	public static IResource workflowFileFor(IEditorPart editor) {
		IFile file = getSelectedFile(editor);
		return workflowFileFor(file);
	}

	public static IResource workflowFileFor(ISelection selection) {
		IFile file = getSelectedFile(selection);
		return workflowFileFor(file);
	}

	public static boolean workflowFileAvailableForGrammarFile(IResource resource) {
		return (workflowFileFor(resource) != null);
	}

	public static IResource workflowFileFor(IResource resource) {
		IContainer parent = resource.getParent();
		IPath location = parent.getProjectRelativePath().append("Generate" + resource.getName()).removeFileExtension()
				.addFileExtension("mwe");
		IResource workflowFile = resource.getProject().findMember(location);
		return workflowFile;
	}

	/**
	 * Find the MWE launch shortcut in the extension registry. Using this introspective approach to avoid an explicit
	 * dependency to the <code>org.eclipse.emf.mwe.ui</code> bundle.
	 */
	private static ILaunchShortcut findMWELaunchShortcut() throws CoreException {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
				"org.eclipse.debug.ui.launchShortcuts");
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

	public static void invokeGenerator(IResource workflowFile, String mode) {
		try {
			ILaunchShortcut launchShortcut = findMWELaunchShortcut();
			ISelection selection = new StructuredSelection(workflowFile);
			launchShortcut.launch(selection, mode);
		} catch (CoreException e) {
			logger.error("Could not delegate to MWE launch shortcut.", e);
			e.printStackTrace();
		}
	}

}
