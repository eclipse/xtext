package org.eclipse.jdt.junit.runners;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMemberValuePair;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.TypeNameMatch;
import org.eclipse.jdt.core.search.TypeNameMatchRequestor;
import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jdt.junit.model.ITestCaseElement;
import org.eclipse.jdt.junit.model.ITestElement;
import org.eclipse.jdt.junit.model.ITestSuiteElement;
import org.junit.runner.RunWith;

@SuppressWarnings("restriction")
public class TypeUtil {

	private static String getFQN(ICompilationUnit cu, String name) {
		if (name.contains("."))
			return name;
		try {
			String dotname = "." + name;
			for (IImportDeclaration imp : cu.getImports()) {
				String fqn = imp.getElementName();
				if (fqn.endsWith(dotname))
					return fqn;
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public static String findRunner(IType testClass) {
		IAnnotation annotation = testClass.getAnnotation(RunWith.class.getSimpleName());
		if (annotation == null || !annotation.exists())
			annotation = testClass.getAnnotation(RunWith.class.getName());
		if (annotation != null && annotation.exists()) {
			try {
				for (IMemberValuePair pair : annotation.getMemberValuePairs())
					if ("value".equals(pair.getMemberName()) && pair.getValue() instanceof String)
						return getFQN(testClass.getCompilationUnit(), (String) pair.getValue());
			} catch (JavaModelException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public static IType findType(ITestElement element) {
		String className = null;
		if (element instanceof ITestCaseElement)
			className = ((ITestCaseElement) element).getTestClassName();
		else if (element instanceof ITestSuiteElement)
			className = ((ITestSuiteElement) element).getSuiteTypeName();
		IType type = null;
		if (className != null)
			type = findType(element.getTestRunSession().getLaunchedProject(), className);
		if (type == null && element.getParentContainer() instanceof ITestElement)
			return findType((ITestElement) element.getParentContainer());
		return type;
	}

	// copied from
	// org.eclipse.jdt.internal.junit.ui.OpenEditorAction.findType(IJavaProject,
	// String)
	public static IType findType(final IJavaProject project, String className) {

		final IType[] result = { null };
		final String dottedName = className.replace('$', '.'); // for nested
																// classes...
		try {
			// PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new
			// IRunnableWithProgress() {
			// public void run(IProgressMonitor monitor) throws
			// InvocationTargetException, InterruptedException {
			// try {
			if (project != null) {
				result[0] = internalFindType(project, dottedName, new HashSet<IJavaProject>(), new NullProgressMonitor());
			}
			if (result[0] == null) {
				int lastDot = dottedName.lastIndexOf('.');
				TypeNameMatchRequestor nameMatchRequestor = new TypeNameMatchRequestor() {
					@Override
					public void acceptTypeNameMatch(TypeNameMatch match) {
						result[0] = match.getType();
					}
				};
				new SearchEngine().searchAllTypeNames(lastDot >= 0 ? dottedName.substring(0, lastDot).toCharArray() : null,
						SearchPattern.R_EXACT_MATCH | SearchPattern.R_CASE_SENSITIVE, (lastDot >= 0 ? dottedName.substring(lastDot + 1)
								: dottedName).toCharArray(), SearchPattern.R_EXACT_MATCH | SearchPattern.R_CASE_SENSITIVE,
						IJavaSearchConstants.TYPE, SearchEngine.createWorkspaceScope(), nameMatchRequestor,
						IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, new NullProgressMonitor());
			}
			// } catch (JavaModelException e) {
			// throw new InvocationTargetException(e);
			// }
			// }
			// });
			// } catch (InvocationTargetException e) {
			// JUnitPlugin.log(e);
			// } catch (InterruptedException e) {
			// user cancelled
		} catch (JavaModelException e) {
			JUnitPlugin.log(e);
		}
		return result[0];
	}

	// copied from
	// org.eclipse.jdt.internal.junit.ui.OpenEditorAction.internalFindType(IJavaProject,
	// String, Set<IJavaProject>, IProgressMonitor)
	private static IType internalFindType(IJavaProject project, String className, Set<IJavaProject> visitedProjects,
			IProgressMonitor monitor) throws JavaModelException {
		try {
			if (visitedProjects.contains(project))
				return null;
			monitor.beginTask("", 2); //$NON-NLS-1$
			IType type = project.findType(className, new SubProgressMonitor(monitor, 1));
			if (type != null)
				return type;
			// fix for bug 87492: visit required projects explicitly to also
			// find not exported types
			visitedProjects.add(project);
			IJavaModel javaModel = project.getJavaModel();
			String[] requiredProjectNames = project.getRequiredProjectNames();
			IProgressMonitor reqMonitor = new SubProgressMonitor(monitor, 1);
			reqMonitor.beginTask("", requiredProjectNames.length); //$NON-NLS-1$
			for (String requiredProjectName : requiredProjectNames) {
				IJavaProject requiredProject = javaModel.getJavaProject(requiredProjectName);
				if (requiredProject.exists()) {
					type = internalFindType(requiredProject, className, visitedProjects, new SubProgressMonitor(reqMonitor, 1));
					if (type != null)
						return type;
				}
			}
			return null;
		} finally {
			monitor.done();
		}
	}

}
