/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.testcollector.popup.actions;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.testcollector.TestCollectorPlugin;

/**
 * An action to automatically generate test suites.
 *  
 * @author Jan Köhnlein - Initial contribution and API
 */
public class CreateTestSuiteAction implements IObjectActionDelegate {

	private static final String TEST_SUITE_NAME = "AutoTestSuite";
	private Shell shell;
	private IPackageFragmentRoot packageFragmentRoot;

	public CreateTestSuiteAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		try {
			
			List<String> testClassNames = new ArrayList<String>();
			
			for (IJavaElement child : packageFragmentRoot.getChildren()) {
				if (child instanceof IPackageFragment) {
					IPackageFragment packageFragment = (IPackageFragment) child;
					ICompilationUnit[] compilationUnits = packageFragment.getCompilationUnits();
					for (ICompilationUnit compilationUnit : compilationUnits) {
						for (IType type : compilationUnit.getAllTypes()) {
							if (!Flags.isAbstract(type.getFlags())) {
								if (type.getElementName().endsWith("Test") || type.getSuperclassName() != null
										&& type.getSuperclassName().contains("TestCase")) {
									testClassNames.add(type.getFullyQualifiedName());
									System.out.println(packageFragment.getElementName() + "." + type.getElementName());
									break;
								}
							}
						}
					}
				}
			}
			Collections.sort(testClassNames);
			final IPackageFragment suitePackage = getSuitePackageFragment();
			final String classBody = getTestSuiteCode(testClassNames, suitePackage);
			JavaCore.run(new IWorkspaceRunnable() {
				public void run(IProgressMonitor monitor) throws CoreException {
					IFolder suitePackageFolder = (IFolder) suitePackage.getResource();
					if(!suitePackageFolder.exists()) {
						suitePackageFolder.create(true, false, monitor);
					}
					IFile file = suitePackageFolder.getFile(TEST_SUITE_NAME + ".java");
					if(file.exists()) {
						file.delete(true, monitor);
					}
					file.create(new ByteArrayInputStream(classBody.getBytes()), true, monitor);
				}
			}, new NullProgressMonitor());
		}
		catch (Exception exc) {
			MessageDialog.openError(shell, "Error creating test suite", exc.getMessage());
			TestCollectorPlugin.getDefault().getLog().log(
					new Status(IStatus.ERROR, TestCollectorPlugin.PLUGIN_ID, exc.getMessage(), exc));
		}
	}

	private String getTestSuiteCode(List<String> testClassNames, IPackageFragment javaPackage) {
		final IJavaProject javaProject = packageFragmentRoot.getJavaProject();
		StringBuffer buffer = new StringBuffer();
		buffer.append("package " + javaPackage.getElementName() + ";\n");
		buffer.append("\n");
		buffer.append("import junit.framework.Test;\n");
		buffer.append("import junit.framework.TestSuite;\n");
		buffer.append("\n");
		buffer.append("/**\n");
		buffer.append(" * DO NOT MODIFY MANUALLY! This class has been automatically generated. \n");
		buffer.append(" * Install org.eclipse.xtext.testcollector and use the Xtext Tools/Create Test Suite\n");
		buffer.append(" * action on the source folder to regenerate this.\n");
		buffer.append(" */\n");
		buffer.append("public class " + TEST_SUITE_NAME + " {" + "\n");
		buffer.append("\n");
		buffer.append("\tpublic static Test suite() {" + "\n");
		buffer.append("\t\tTestSuite suite = new TestSuite(\"" + javaProject.getElementName() + "\");\n");
		for(String testClassName: testClassNames) {
			buffer.append("\t\tsuite.addTestSuite(" + testClassName
					+ ".class);\n");
		}
		buffer.append("\t\treturn suite;\n");
		buffer.append("\t}\n");
		buffer.append("}\n");
		final String classBody = buffer.toString();
		return classBody;
	}

	private IPackageFragment getSuitePackageFragment() throws JavaModelException {
		String projectName = packageFragmentRoot.getJavaProject().getElementName();
		IPackageFragment projectNamePackageFragment = packageFragmentRoot.getPackageFragment(projectName);
		if(projectNamePackageFragment.exists()) {
			return projectNamePackageFragment;
		} 
		if(projectName.endsWith(".tests") || projectName.endsWith(".test")) {
			String testedProjectName = projectName.substring(0, projectName.lastIndexOf("."));
			IPackageFragment testedProjectNamePackageFragment = packageFragmentRoot.getPackageFragment(testedProjectName);
			return testedProjectNamePackageFragment;
		}
		return projectNamePackageFragment;
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (!structuredSelection.isEmpty()) {
				Object selectedElement = structuredSelection.getFirstElement();
				if (selectedElement instanceof IPackageFragmentRoot) {
					packageFragmentRoot = (IPackageFragmentRoot) selectedElement;
					action.setEnabled(true);
					return;
				}
			}
		}
		action.setEnabled(false);
	}

}
