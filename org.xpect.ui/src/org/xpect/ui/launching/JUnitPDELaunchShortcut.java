/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.pde.core.plugin.TargetPlatform;
import org.eclipse.pde.internal.core.TargetPlatformHelper;
import org.eclipse.pde.internal.launching.IPDEConstants;
import org.eclipse.pde.internal.launching.launcher.LaunchArgumentsHelper;
import org.eclipse.pde.internal.launching.launcher.LauncherUtils;
import org.eclipse.pde.launching.IPDELauncherConstants;
import org.eclipse.pde.launching.PDESourcePathProvider;
import org.eclipse.ui.IEditorPart;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JUnitPDELaunchShortcut extends org.eclipse.pde.ui.launcher.JUnitWorkbenchLaunchShortcut {

	private JUnitJavaElementDelegate delegate;

	// copy of org.eclipse.pde.ui.launcher.JUnitWorkbenchLaunchShortcut.createLaunchConfiguration(IJavaElement)
	protected void initPDEAttributes(ILaunchConfigurationWorkingCopy configuration, IJavaElement element) throws CoreException {
		String configName = configuration.getName();

		if (TargetPlatformHelper.usesNewApplicationModel())
			configuration.setAttribute(IPDEConstants.LAUNCHER_PDE_VERSION, "3.3"); //$NON-NLS-1$ 
		else if (TargetPlatformHelper.getTargetVersion() >= 3.2)
			configuration.setAttribute(IPDEConstants.LAUNCHER_PDE_VERSION, "3.2a"); //$NON-NLS-1$
		configuration.setAttribute(IPDELauncherConstants.LOCATION, LaunchArgumentsHelper.getDefaultWorkspaceLocation(configName, true));
		configuration.setAttribute(IPDELauncherConstants.DOCLEAR, true);
		configuration.setAttribute(IPDELauncherConstants.ASKCLEAR, false);
		configuration.setAttribute(IPDEConstants.APPEND_ARGS_EXPLICITLY, true);

		// Program to launch
		if (LauncherUtils.requiresUI(configuration)) {
			String product = TargetPlatform.getDefaultProduct();
			if (product != null) {
				configuration.setAttribute(IPDELauncherConstants.USE_PRODUCT, true);
				configuration.setAttribute(IPDELauncherConstants.PRODUCT, product);
			}
		} else {
			configuration.setAttribute(IPDELauncherConstants.APPLICATION, IPDEConstants.CORE_TEST_APPLICATION);
		}

		// Plug-ins to launch
		configuration.setAttribute(IPDELauncherConstants.USE_DEFAULT, true);

		// Program arguments
		String programArgs = LaunchArgumentsHelper.getInitialProgramArguments();
		if (programArgs.length() > 0)
			configuration.setAttribute(IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS, programArgs);

		// VM arguments
		String vmArgs = LaunchArgumentsHelper.getInitialVMArguments();
		if (vmArgs.length() > 0)
			configuration.setAttribute(IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS, vmArgs);

		// configuration attributes
		configuration.setAttribute(IPDELauncherConstants.CONFIG_GENERATE_DEFAULT, true);
		boolean useDefaultArea = LaunchArgumentsHelper.getDefaultJUnitWorkspaceIsContainer();
		configuration.setAttribute(IPDELauncherConstants.CONFIG_USE_DEFAULT_AREA, useDefaultArea);
		if (!useDefaultArea) {
			configuration.setAttribute(IPDELauncherConstants.CONFIG_LOCATION, LaunchArgumentsHelper.getDefaultJUnitConfigurationLocation());
		}
		configuration.setAttribute(IPDELauncherConstants.CONFIG_CLEAR_AREA, true);

		// tracing option
		configuration.setAttribute(IPDELauncherConstants.TRACING_CHECKED, IPDELauncherConstants.TRACING_NONE);

		// source path provider
		configuration.setAttribute(IJavaLaunchConfigurationConstants.ATTR_SOURCE_PATH_PROVIDER, PDESourcePathProvider.ID);
	}

	@Override
	protected ILaunchConfigurationWorkingCopy createLaunchConfiguration(IJavaElement element) throws CoreException {
		ILaunchConfigurationWorkingCopy wc;
		if (delegate != null && element.getElementType() == IJavaElement.TYPE) {
			wc = LaunchShortcutUtil.createXpectLaunchConfiguration(delegate, getLaunchConfigurationTypeId());
			initPDEAttributes(wc, element);
		} else
			wc = super.createLaunchConfiguration(element);
		return wc;
	}

	@Override
	public void launch(IEditorPart editor, String mode) {
		try {
			delegate = new JunitJavaElementDelegateAdapterFactory().create(editor);
			if (delegate != null)
				super.launch(new StructuredSelection(delegate), mode);
			else
				super.launch(editor, mode);
		} finally {
			delegate = null;
		}
	}

	@Override
	public void launch(ISelection selection, String mode) {
		if (selection instanceof IStructuredSelection) {
			try {
				IStructuredSelection newSelection = LaunchShortcutUtil.replaceWithJavaElementDelegates((IStructuredSelection) selection);
				Object element = newSelection.getFirstElement();
				if (element instanceof JUnitJavaElementDelegate)
					delegate = (JUnitJavaElementDelegate) element;
				super.launch(newSelection, mode);
			} finally {
				delegate = null;
			}
		}
	}
}
