package org.eclipse.xtext.ui.tests.core.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.junit4.ui.util.PluginUtil;
import org.eclipse.xtext.resource.IClasspathUriResolver;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.util.JdtClasspathUriResolver;
import org.junit.Before;
import org.junit.Test;

public class JdtClasspathUriResolverTest extends AbstractClasspathUriResolverTest {

	private IJavaProject _javaProject;
	private IClasspathUriResolver _resolver;

	@Before
	public void setUp() throws Exception {
		_resolver = new JdtClasspathUriResolver();
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		if (_javaProject != null && _javaProject.exists()) {
			_javaProject.getJavaProject().getProject().delete(true, null);
		}
	}

	@Test public void testClasspathUriForFileInWorkspace() throws Exception {
		_javaProject = JavaProjectSetupUtil.createJavaProject(TEST_PROJECT_NAME);
		_project = _javaProject.getProject();
		PluginUtil.copyFileToWorkspace(Activator.getInstance(), "/testfiles/" + MODEL_FILE, _project, "src/"
				+ MODEL_FILE);
		URI classpathUri = URI.createURI("classpath:/" + MODEL_FILE);
		String expectedUri = "platform:/resource/" + TEST_PROJECT_NAME + "/src/" + MODEL_FILE;
		URI normalizedUri = _resolver.resolve(_javaProject, classpathUri);
		assertResourceLoadable(classpathUri, normalizedUri, expectedUri);
	}

	@Test public void testClasspathUriForFileInWorkspaceWithFragment() throws Exception {
		_javaProject = JavaProjectSetupUtil.createJavaProject(TEST_PROJECT_NAME);
		_project = _javaProject.getProject();
		PluginUtil.copyFileToWorkspace(Activator.getInstance(), "/testfiles/" + MODEL_FILE, _project, "src/"
				+ MODEL_FILE);
		URI classpathUri = URI.createURI("classpath:/" + MODEL_FILE + "#/");
		String expectedUri = "platform:/resource/" + TEST_PROJECT_NAME + "/src/" + MODEL_FILE + "#/";
		URI normalizedUri = _resolver.resolve(_javaProject, classpathUri);
		assertResourceLoadable(classpathUri, normalizedUri, expectedUri);
	}

	@Test public void testClasspathUriForFileInJarInWorkspace() throws Exception {
		_javaProject = JavaProjectSetupUtil.createJavaProject(TEST_PROJECT_NAME);
		_project = _javaProject.getProject();
		IFile jarFile = PluginUtil.copyFileToWorkspace(Activator.getInstance(), "/testfiles/" + JAR_FILE, _project, "/"
				+ JAR_FILE);
		JavaProjectSetupUtil.addJarToClasspath(_javaProject, jarFile);
		URI classpathUri = URI.createURI("classpath:/model/" + MODEL_FILE);
		String expectedUri = "archive:platform:/resource/" + TEST_PROJECT_NAME + "/" + JAR_FILE + "!/model/" + MODEL_FILE;
		URI normalizedUri = _resolver.resolve(_javaProject, classpathUri);
		assertResourceLoadable(classpathUri, normalizedUri, expectedUri);
	}

	@Test public void testClasspathUriForFileInJarInWorkspaceWithFragment() throws Exception {
		_javaProject = JavaProjectSetupUtil.createJavaProject(TEST_PROJECT_NAME);
		_project = _javaProject.getProject();
		IFile jarFile = PluginUtil.copyFileToWorkspace(Activator.getInstance(), "/testfiles/" + JAR_FILE, _project, "/"
				+ JAR_FILE);
		JavaProjectSetupUtil.addJarToClasspath(_javaProject, jarFile);
		URI classpathUri = URI.createURI("classpath:/model/" + MODEL_FILE + "#/");
		String expectedUri = "archive:platform:/resource/" + TEST_PROJECT_NAME + "/" + JAR_FILE + "!/model/" + MODEL_FILE + "#/";
		URI normalizedUri = _resolver.resolve(_javaProject, classpathUri);
		assertResourceLoadable(classpathUri, normalizedUri, expectedUri);
	}
	
//	@Test public void testGetZipEntryUri_Windows() {
//		String osDependent = "c:\\eclipse\\archive.jar";
//		String projectDependent = "/org/foo/bar.suffix";
//		URI uri = JdtClasspathUriResolver.getZipEntryUri(projectDependent, osDependent);
//		assertEquals("jar:file:///c:/eclipse/archive.jar!org/foo/bar.suffix", uri);
//	}
//
//	@Test public void testGetUpEntryUri_Mac() {
//		String osDependent = "/Applications/eclipse/archive.jar";
//		String projectDependent = "/org/foo/bar.suffix";
//		URI uri = JdtClasspathUriResolver.getZipEntryUri(projectDependent, osDependent);
//		assertEquals("jar:file:/Applications/eclipse/archive.jar!/org/foo/bar.suffix", uri.toString());
//	}

}
