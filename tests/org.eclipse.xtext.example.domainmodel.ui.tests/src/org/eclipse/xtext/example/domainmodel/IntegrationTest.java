package org.eclipse.xtext.example.domainmodel;

import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit.util.JavaProjectSetupUtil.*;

import java.lang.reflect.InvocationTargetException;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

public class IntegrationTest extends TestCase {

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		cleanWorkspace();
	}

	public void testValidSimpleModel() throws Exception {
		createJavaProjectWithRootSrc("foo");
		IFile file = createFile("foo/foo.dmodel", "entity Foo {}");
		waitForAutoBuild();
		assertEquals(0, file.findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);
	}

	private void createJavaProjectWithRootSrc(String string) throws CoreException {
		IJavaProject project = createJavaProject(string);
		deleteClasspathEntry(project, new Path("/foo/src"));
		addSourceFolder(project, "/foo");
	}

	public void testSimpleModelWithSyntaxError() throws Exception {
		IFile file = createFile("foo/foo.dmodel", "entitie Foo {}");
		waitForAutoBuild();
		assertEquals(1, file.findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);
	}

	public void testTwoFilesInSameProject() throws Exception {
		createFile("foo/foo.dmodel", "entity Foo {}");
		IFile file = createFile("foo/bar.dmodel",
				"entity Bar { ref stuff : Foo }");
		waitForAutoBuild();
		assertEquals(0, file.findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);
	}

	public void testTwoFilesInSameProjectWithLinkingError() throws Exception {
		createFile("foo/foo.dmodel", "entity Foo {}");
		IFile file = createFile("foo/bar.dmodel",
				"entity Bar { ref stuff : Fuu }");
		waitForAutoBuild();
		assertEquals(1, file.findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);
	}

	public void testTwoFilesInTwoReferencedProjects() throws Exception {
		final String barModel = "bar/bar.dmodel";
		new WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor monitor)
					throws CoreException, InvocationTargetException,
					InterruptedException {
				IFile file1 = createFile("foo/foo.dmodel", "entity Foo {}");
				IFile file2 = createFile(barModel,
						"entity Bar { ref stuff : Foo }");
				setReference(file2.getProject(), file1.getProject());
			}
		}.run(monitor());
		waitForAutoBuild();
		assertEquals(0, file(barModel).findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);
	}

	public void testTwoFilesInTwoInversedReferencedProjects() throws Exception {
		final String barModel = "bar/bar.dmodel";
		new WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor monitor)
					throws CoreException, InvocationTargetException,
					InterruptedException {
				IFile file1 = createFile("foo/foo.dmodel", "entity Foo {}");
				IFile file2 = createFile(barModel,
						"entity Bar { ref stuff : Foo }");
				setReference(file1.getProject(), file2.getProject());
			}
		}.run(monitor());
		waitForAutoBuild();
		assertEquals(1, file(barModel).findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);
	}

	public void testTwoFilesInTwoNonReferencedProjects() throws Exception {
		final String barModel = "bar/bar.dmodel";
		new WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor monitor)
					throws CoreException, InvocationTargetException,
					InterruptedException {
				createFile("foo/foo.dmodel", "entity Foo {}");
				createFile(barModel, "entity Bar { ref stuff : Foo }");
				// No reference between projects!
			}
		}.run(monitor());
		waitForAutoBuild();
		assertEquals(1, file(barModel).findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);
	}

	public void testChangeReferenceOfProjects() throws Exception {
		final String fooModel = "foo/foo.dmodel";
		final String barModel = "bar/bar.dmodel";
		new WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor monitor)
					throws CoreException, InvocationTargetException,
					InterruptedException {
				IFile file1 = createFile(fooModel, "entity Foo {}");
				IFile file2 = createFile(barModel,
						"entity Bar { ref stuff : Foo }");
				setReference(file2.getProject(), file1.getProject());
			}
		}.run(monitor());
		waitForAutoBuild();
		assertEquals(0, file(barModel).findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);

		// remove dependency
		removeReference(file(barModel).getProject(), file(fooModel)
				.getProject());

		waitForAutoBuild();
		assertEquals(1, file(barModel).findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);

	}

	public void testOpenAndCloseReferencedProjects() throws Exception {
		final String fooModel = "foo/foo.dmodel";
		final String barModel = "bar/bar.dmodel";
		new WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor monitor)
					throws CoreException, InvocationTargetException,
					InterruptedException {
				IFile file1 = createFile(fooModel, "entity Foo {}");
				IFile file2 = createFile(barModel,
						"entity Bar { ref stuff : Foo }");
				setReference(file2.getProject(), file1.getProject());
			}
		}.run(monitor());
		waitForAutoBuild();
		assertEquals(0, file(barModel).findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);

		// close project
		final IProject project = file(fooModel).getProject();
		project.close(monitor());
		waitForAutoBuild();
		assertEquals(1, file(barModel).findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);
		project.open(monitor());
		waitForAutoBuild();
		assertEquals(0, file(barModel).findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);
	}
	
	public void testChangeReferencedFile() throws Exception {
		final String fooModel = "foo/foo.dmodel";
		final String barModel = "foo/bar.dmodel";
		new WorkspaceModifyOperation() {
			
			@Override
			protected void execute(IProgressMonitor monitor)
			throws CoreException, InvocationTargetException,
			InterruptedException {
				IFile file1 = createFile(fooModel, "entity Foo {}");
				IFile file2 = createFile(barModel,
				"entity Bar { ref stuff : Foo }");
				setReference(file2.getProject(), file1.getProject());
			}
		}.run(monitor());
		waitForAutoBuild();
		assertEquals(0, file(barModel).findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);
		// change referenced file
		createFile(fooModel, "entity Baz {}");
		waitForAutoBuild();
		assertEquals(1, file(barModel).findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);
		System.out.println("changing "+fooModel);
		createFile(fooModel, "entity Foo {}");
		waitForAutoBuild();
		assertEquals(0, file(barModel).findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);
	}
	
	public void testDeleteReferencedFile() throws Exception {
		final String fooModel = "foo/foo.dmodel";
		final String barModel = "foo/bar.dmodel";
		new WorkspaceModifyOperation() {
			
			@Override
			protected void execute(IProgressMonitor monitor)
			throws CoreException, InvocationTargetException,
			InterruptedException {
				IFile file1 = createFile(fooModel, "entity Foo {}");
				IFile file2 = createFile(barModel,
				"entity Bar { ref stuff : Foo }");
				setReference(file2.getProject(), file1.getProject());
			}
		}.run(monitor());
		waitForAutoBuild();
		assertEquals(0, file(barModel).findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);
		// change referenced file
		file(fooModel).delete(true, new NullProgressMonitor());
		waitForAutoBuild();
		assertEquals(1, file(barModel).findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);
	}

}
