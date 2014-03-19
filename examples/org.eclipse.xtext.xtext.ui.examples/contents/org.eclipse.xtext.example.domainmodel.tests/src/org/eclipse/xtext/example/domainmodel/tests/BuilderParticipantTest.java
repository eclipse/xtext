package org.eclipse.xtext.example.domainmodel.tests;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.addNature;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.cleanBuild;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.waitForAutoBuild;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.builder.trace.TraceMarkers;
import org.eclipse.xtext.example.domainmodel.ui.internal.DomainmodelActivator;
import org.eclipse.xtext.junit4.internal.Files;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class BuilderParticipantTest {
	private static Injector injector = DomainmodelActivator
			.getInstance()
			.getInjector(
					DomainmodelActivator.ORG_ECLIPSE_XTEXT_EXAMPLE_DOMAINMODEL_DOMAINMODEL);

	@Inject
	private TraceMarkers traceMarkers;

	private IProject project;

	private IJavaProject javaProject;

	@Before
	public void setUp() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
		javaProject = JavaProjectSetupUtil.createJavaProject("foo");
		project = javaProject.getProject();
		addNature(project, XtextProjectHelper.NATURE_ID);
		getInjector().injectMembers(this);
	}

	@After
	public void tearDown() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
	}

	@Test
	public void testJavaAndTraceGenerated() throws CoreException, IOException {
		IFile sourceFile = project.getFile("src/Foo.dmodel");
		sourceFile.create(new StringInputStream("entity Foo {}"), true, null);
		assertTrue(sourceFile.exists());
		waitForAutoBuild();

		IFile targetFile = project.getFile("/src-gen/Foo.java");
		assertTrue(targetFile.exists());
		assertFalse(Files.isEmpty(targetFile));

		IFile traceFile = project.getFile("/src-gen/.Foo.java._trace");
		assertTrue(traceFile.exists());
		assertFalse(Files.isEmpty(traceFile));

		sourceFile.delete(true, null);
		waitForAutoBuild();
		cleanBuild();
		assertTrue(targetFile.getParent().exists());
		assertFalse(targetFile.exists());
		assertFalse(traceFile.exists());
	}

	/*
	 * TODO No trace markers are installed. This is because the
	 * JavaProjectAwareTraceContribution makes trace URIs relative to the source
	 * folder. But the EclipseResourceFileSystemAccess2 can only handle platform
	 * resources. This is fixed for Xtend and currently trace markers are only
	 * used by Xtend (in the generated source view). But this should work for
	 * all languages. This will be fixed as part of the output-per-source folder
	 * feature.
	 */
	@Ignore
	@Test
	public void testTraceMarkersInstalled() throws CoreException {
		IFile sourceFile = project.getFile("src/Foo.dmodel");
		sourceFile.create(new StringInputStream("entity Foo {}"), true, null);
		assertTrue(sourceFile.exists());
		waitForAutoBuild();

		IFile traceFile = project.getFile("/src-gen/.Foo.java._trace");
		List<IPath> traceFiles = traceMarkers.findTraceFiles(sourceFile);

		assertTrue(traceFiles.contains(traceFile.getFullPath()));
	}

	public Injector getInjector() {
		return injector;
	}

	public <T> T get(Class<T> clazz) {
		return getInjector().getInstance(clazz);
	}
}
