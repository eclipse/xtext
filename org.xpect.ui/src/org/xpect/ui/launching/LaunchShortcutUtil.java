/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.launching;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.internal.junit.launcher.AssertionVMArg;
import org.eclipse.jdt.internal.junit.launcher.JUnitLaunchConfigurationConstants;
import org.eclipse.jdt.internal.junit.launcher.JUnitMigrationDelegate;
import org.eclipse.jdt.internal.junit.launcher.TestKindRegistry;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class LaunchShortcutUtil {

	public static ILaunchConfigurationWorkingCopy createXpectLaunchConfiguration(JUnitJavaElementDelegate element, String launchConfigurationTypeId) throws CoreException {
		IJavaElement javaElement = element.getJavaElement();
		Preconditions.checkArgument(javaElement.getElementType() == IJavaElement.TYPE);

		String mainTypeQualifiedName = ((IType) javaElement).getFullyQualifiedName('.'); // don't replace, fix for binary inner types
		String containerHandleId = "";

		String testName = getLaunchConfigTitle(element);

		String testKindId = TestKindRegistry.JUNIT4_TEST_KIND_ID;

		ILaunchConfigurationType configType = getLaunchManager().getLaunchConfigurationType(launchConfigurationTypeId);
		ILaunchConfigurationWorkingCopy wc = configType.newInstance(null, getLaunchManager().generateLaunchConfigurationName(testName));

		wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME, mainTypeQualifiedName);
		wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME, javaElement.getJavaProject().getElementName());
		wc.setAttribute(JUnitLaunchConfigurationConstants.ATTR_KEEPRUNNING, false);
		wc.setAttribute(JUnitLaunchConfigurationConstants.ATTR_TEST_CONTAINER, containerHandleId);
		wc.setAttribute(JUnitLaunchConfigurationConstants.ATTR_TEST_RUNNER_KIND, testKindId);
		JUnitMigrationDelegate.mapResources(wc);
		AssertionVMArg.setArgDefault(wc);

		String methodName = element.getDescription().getMethodName();
		if (!Strings.isEmpty(methodName))
			wc.setAttribute(JUnitLaunchConfigurationConstants.ATTR_TEST_METHOD_NAME, methodName);
		else
			wc.setAttribute(JUnitLaunchConfigurationConstants.ATTR_TEST_METHOD_NAME, element.getDescription().getClassName());
		String fileInProject = element.getResource().getFullPath().removeFirstSegments(1).toString();
		ensureContains(wc, IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS, "-DxpectFiles=", fileInProject);
		return wc;
	}

	private static void ensureContains(ILaunchConfigurationWorkingCopy wc, String attributeName, final String key, String value) throws CoreException {
		List<String> vmArgs = Lists.newArrayList(wc.getAttribute(attributeName, "").split("\\s+"));
		for (int i = 0; i < vmArgs.size(); i++) {
			if (vmArgs.get(i).startsWith(key)) {
				vmArgs.set(i, key + value);
				value = null;
			}
		}
		if (value != null)
			vmArgs.add(key + value);
		wc.setAttribute(attributeName, Joiner.on(" ").join(vmArgs));
	}

	private static String getLaunchConfigTitle(JUnitJavaElementDelegate element) {
		String fileName = element.getResource().getName();
		if (!Strings.isEmpty(element.getName()))
			return fileName + "#" + element.getName();
		return fileName;
	}

	public static ILaunchManager getLaunchManager() {
		return DebugPlugin.getDefault().getLaunchManager();
	}

	public static IStructuredSelection replaceWithJavaElementDelegates(IStructuredSelection sel) {
		Object[] selection = sel.toArray();
		Object[] result = new Object[selection.length];
		for (int i = 0; i < selection.length; i++) {
			Object s = selection[i];
			if (s == null || s instanceof IJavaElement || s instanceof JUnitJavaElementDelegate || !(s instanceof IAdaptable))
				result[i] = s;
			else {
				IAdaptable adaptable = (IAdaptable) s;
				JUnitJavaElementDelegate delegate = (JUnitJavaElementDelegate) adaptable.getAdapter(JUnitJavaElementDelegate.class);
				result[i] = delegate != null ? delegate : s;
			}
		}
		StructuredSelection newSelection = new StructuredSelection(result);
		return newSelection;
	}

}
