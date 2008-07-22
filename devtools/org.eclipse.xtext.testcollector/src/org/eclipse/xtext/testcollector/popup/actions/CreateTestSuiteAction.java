package org.eclipse.xtext.testcollector.popup.actions;

import java.io.ByteArrayInputStream;

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

public class CreateTestSuiteAction implements IObjectActionDelegate {

	/**
	 * 
	 */
	private static final String TEST_SUITE_NAME = "AutoTestSuite";
	private Shell shell;
	private IPackageFragmentRoot packageFragmentRoot;

	/**
	 * Constructor for Action1.
	 */
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
			final IJavaElement firstPackage = getFirstPackage();
			final IJavaProject javaProject = packageFragmentRoot.getJavaProject();
			StringBuffer buffer = new StringBuffer();
			buffer.append("package " + firstPackage.getElementName() + ";\n");
			buffer.append("\n");
			buffer.append("import junit.framework.Test;\n");
			buffer.append("import junit.framework.TestSuite;\n");
			buffer.append("\n");
			buffer.append("public class " + TEST_SUITE_NAME + " {" + "\n");
			buffer.append("\n");
			buffer.append("\tpublic static Test suite() {" + "\n");
			buffer.append("\t\tTestSuite suite = new TestSuite(\"" + javaProject.getElementName() + "\");\n");

			for (IJavaElement child : packageFragmentRoot.getChildren()) {
				if (child instanceof IPackageFragment) {
					IPackageFragment packageFragment = (IPackageFragment) child;
					ICompilationUnit[] compilationUnits = packageFragment.getCompilationUnits();
					for (ICompilationUnit compilationUnit : compilationUnits) {
						for (IType type : compilationUnit.getAllTypes()) {
							if (!Flags.isAbstract(type.getFlags())) {
								if (type.getElementName().endsWith("Test") || type.getSuperclassName() != null
										&& type.getSuperclassName().contains("TestCase")) {
									buffer.append("\t\tsuite.addTestSuite(" + type.getFullyQualifiedName()
											+ ".class);\n");
									System.out.println(packageFragment.getElementName() + "." + type.getElementName());
									break;
								}
							}
						}
					}
				}
			}
			buffer.append("\t\treturn suite;\n");
			buffer.append("\t}\n");
			buffer.append("}\n");
			final String classBody = buffer.toString();
			JavaCore.run(new IWorkspaceRunnable() {
				public void run(IProgressMonitor monitor) throws CoreException {
					IFolder firstPackageFolder = (IFolder) firstPackage.getResource();
					IFile file = firstPackageFolder.getFile(TEST_SUITE_NAME + ".java");
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

	private IJavaElement getFirstPackage() throws JavaModelException {
		String projectName = packageFragmentRoot.getJavaProject().getElementName();
		if(projectName.endsWith(".tests") || projectName.endsWith(".test")) {
			projectName = projectName.substring(0, projectName.lastIndexOf("."));
		}
		IPackageFragment projectNamePackageFragment = packageFragmentRoot.getPackageFragment(projectName);
		if(projectNamePackageFragment.exists()) {
			return projectNamePackageFragment;
		}
		IJavaElement[] packageFragments = packageFragmentRoot.getChildren();
		for (IJavaElement packageFragment : packageFragments) {
			if(packageFragment.getElementName() != "") {
				return packageFragment;
			}
		}
		throw new IllegalArgumentException("Cannot find a sensible package fragment");
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
