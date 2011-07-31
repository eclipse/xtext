package org.eclipse.xtext.xtend2.ui.tests.contentassist;

import static org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil.*;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.junit.util.ResourceLoadHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.junit.editor.contentassist.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractXtendContentAssistBugTest extends AbstractXtend2UITestCase implements IJavaProjectProvider, ResourceLoadHelper {

	private IProject demandCreateProject;
	
	@Inject
	private WorkbenchTestHelper testHelper;
	
	@Override
	protected void tearDown() throws Exception {
		if (demandCreateProject != null)
			deleteProject(demandCreateProject);
		super.tearDown();
	}
	
	public IJavaProject getJavaProject(ResourceSet resourceSet) {
		String projectName = getProjectName();
		IJavaProject javaProject = findJavaProject(projectName);
		if (javaProject == null || !javaProject.exists()) {
			try {
				demandCreateProject = WorkbenchTestHelper.createPluginProject(projectName);
				javaProject = findJavaProject(projectName);
			} catch (CoreException e) {
				fail("cannot create java project due to: " + e.getMessage() + " / " + e);
			}
		}
		return javaProject;
	}

	protected String getProjectName() {
		return getClass().getSimpleName() + "Project";
	}
	
	public XtextResource getResourceFor(InputStream stream) {
		try {
			XtextResourceSet set = get(XtextResourceSet.class);
			XtextResource result = (XtextResource) set.createResource(URI.createURI("Test." + testHelper.getFileExtension()));
			result.load(stream, null);
			initializeTypeProvider(result);
			return result;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected void initializeTypeProvider(XtextResource result) {
		XtextResourceSet resourceSet = (XtextResourceSet) result.getResourceSet();
		IJvmTypeProvider.Factory typeProviderFactory = new JdtTypeProviderFactory(this);
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		resourceSet.setClasspathURIContext(getJavaProject(resourceSet));
	}
	
	protected String[] expect(String[]... arrays) {
		List<String> expectation = Lists.newArrayList();
		for(String[] array: arrays) {
			expectation.addAll(Arrays.asList(array));
		}
		return expectation.toArray(new String[expectation.size()]);
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		return new ContentAssistProcessorTestBuilder(getInjector(), this);
	}
	
	public static Test createSuite(final Class<? extends AbstractXtendContentAssistBugTest> clazz) {
		return new TestSetup(new TestSuite(clazz)) {
			private IProject project;

			@Override
			protected void setUp() throws Exception {
				super.setUp();
				project = WorkbenchTestHelper.createPluginProject(clazz.getSimpleName() + "Project");
			}
			
			@Override
			protected void tearDown() throws Exception {
				deleteProject(project);
				super.tearDown();
			}
		};
	}
	
}
