package org.xpect.ui.registry;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.xpect.registry.ITestSuiteInfo;
import org.xpect.registry.TestSuiteInfoRegistry;

public class UITestSuiteInfoRegistry implements ITestSuiteInfo.Registry {

	private ITestSuiteInfo.Registry runtimeRegistry = new TestSuiteInfoRegistry();
	private ITestSuiteInfo.Registry workspaceRegistry = new WorkspaceTestSuiteInfoRegistry();

	public ITestSuiteInfo getTestSuite(Resource resource) {
		XtextResourceSet rs = (XtextResourceSet) resource.getResourceSet();
		Object context = rs.getClasspathURIContext();
		if (context instanceof IJavaProject)
			return workspaceRegistry.getTestSuite(resource);
		else
			return runtimeRegistry.getTestSuite(resource);
	}
}
