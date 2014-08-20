package org.eclipse.jdt.junit.runners;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.jdt.core.IAnnotation;
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
import org.eclipse.jdt.internal.junit.model.TestRunSession;
import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jdt.junit.model.ITestCaseElement;
import org.eclipse.jdt.junit.model.ITestElement;
import org.eclipse.jdt.junit.model.ITestSuiteElement;
import org.junit.runner.RunWith;

@SuppressWarnings("restriction")
public class TypeUtil {

	private static IType resolveToType(IType baseType, String refTypeName) throws JavaModelException {
		if (baseType == null)
			return null;
		String[][] resolvedNames = baseType.resolveType(refTypeName);
		IJavaProject javaProject = baseType.getJavaProject();
		if (resolvedNames != null && resolvedNames.length > 0) {
			return javaProject.findType(resolvedNames[0][0], resolvedNames[0][1].replace('$', '.'), (IProgressMonitor) null);
		} else if (baseType.isBinary()) {
			IType type = javaProject.findType(refTypeName, (IProgressMonitor) null);
			if (type == null) {
				type = javaProject.findType(baseType.getPackageFragment().getElementName() + '.' + refTypeName, (IProgressMonitor) null);
			}
			return type;
		} else {
			return null;
		}
	}

	private static String resolveToQName(IType baseType, String refTypeName) throws JavaModelException {
		String[][] resolvedNames = baseType.resolveType(refTypeName);
		if (resolvedNames != null && resolvedNames.length > 0) {
			return resolvedNames[0][0] + "." + resolvedNames[0][1].replace('$', '.');
		} else {
			return null;
		}
	}

	public static String findRunner(IType type) {
		try {
			for (IAnnotation candidate : type.getAnnotations()) {
				String elementName = candidate.getElementName();
				if (!elementName.endsWith(RunWith.class.getSimpleName()))
					continue;
				if (!RunWith.class.getName().equals(resolveToQName(type, elementName)))
					continue;
				for (IMemberValuePair pair : candidate.getMemberValuePairs())
					if ("value".equals(pair.getMemberName()) && pair.getValue() instanceof String)
						return resolveToQName(type, (String) pair.getValue());
			}
			IType superClass = resolveToType(type, type.getSuperclassName());
			if (superClass != null)
				return findRunner(superClass);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static IType findType(ITestElement element) {
		String className = null;
		if (element instanceof ITestCaseElement)
			className = ((ITestCaseElement) element).getTestClassName();
		else if (element instanceof ITestSuiteElement)
			className = ((ITestSuiteElement) element).getSuiteTypeName();
		else if (element instanceof TestRunSession) {
			ILaunch launch = ((TestRunSession) element).getLaunch();
			try {
				className = launch.getLaunchConfiguration().getAttribute("org.eclipse.jdt.launching.MAIN_TYPE", (String) null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
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
