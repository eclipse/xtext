package org.eclipse.xtext.example.domainmodel;

import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit.util.JavaProjectSetupUtil.*;
import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.ui.XtextProjectHelper;

public class IntegrationTest extends TestCase {

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		cleanWorkspace();
	}

	public void testValidSimpleModel() throws Exception {
		createJavaProjectWithRootSrc("foo");
		IFile file = createFile("foo/src/foo.dmodel", "entity Foo {}");
		waitForAutoBuild();
		assertEquals(0, file.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE).length);
	}

	private IJavaProject createJavaProjectWithRootSrc(String string) throws CoreException {
		IJavaProject project = createJavaProject(string);
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		addSourceFolder(project, "src");
		return project;
	}

	public void testSimpleModelWithSyntaxError() throws Exception {
		createJavaProjectWithRootSrc("foo");
		IFile file = createFile("foo/src/foo.dmodel", "entitie Foo {}");
		waitForAutoBuild();
		assertEquals(1, file.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE).length);
	}

	public void testTwoFilesInSameProject() throws Exception {
		createJavaProjectWithRootSrc("foo");
		createFile("foo/src/foo.dmodel", "entity Foo {}");
		IFile file = createFile("foo/src/bar.dmodel", "entity Bar { ref stuff : Foo }");
		waitForAutoBuild();
		IMarker[] findMarkers = file.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE);
		assertEquals(printMarkers(findMarkers), 0, findMarkers.length);
	}

	private String printMarkers(IMarker[] findMarkers) throws CoreException {
		StringBuffer buff = new StringBuffer();
		for (IMarker iMarker : findMarkers) {
			buff.append("\n");
			buff.append(iMarker.getAttribute(IMarker.MESSAGE));
		}
		return buff.toString();
	}

	public void testTwoFilesInSameProjectWithLinkingError() throws Exception {
		createJavaProjectWithRootSrc("foo");
		createFile("foo/src/foo.dmodel", "entity Foo {}");
		IFile file = createFile("foo/src/bar.dmodel", "entity Bar { ref stuff : Fuu }");
		waitForAutoBuild();
		assertEquals(1, file.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE).length);
	}

	public void testTwoFilesInTwoReferencedProjects() throws Exception {
		IJavaProject foo = createJavaProjectWithRootSrc("foo");
		IJavaProject bar = createJavaProjectWithRootSrc("bar");
		IFile file1 = createFile("foo/src/foo.dmodel", "entity Foo {}");
		IFile file2 = createFile("bar/src/bar.dmodel", "entity Bar { ref stuff : Foo }");
		addProjectReference(bar, foo);
		IClasspathEntry[] classpathEntries = bar.getResolvedClasspath(true);
		for (IClasspathEntry entry : classpathEntries) {
			if (entry.getEntryKind() == IClasspathEntry.CPE_PROJECT) {
				System.out.println(entry.getPath());
			}
		}
		waitForAutoBuild();
		assertEquals(0, file1.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE).length);
		assertEquals(0, file2.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE).length);
	}

	public void testTwoFilesInTwoInversedReferencedProjects() throws Exception {
		IJavaProject foo = createJavaProjectWithRootSrc("foo");
		IJavaProject bar = createJavaProjectWithRootSrc("bar");
		IFile file1 = createFile("foo/src/foo.dmodel", "entity Foo {}");
		IFile file2 = createFile("bar/src/bar.dmodel", "entity Bar { ref stuff : Foo }");
		addProjectReference(foo,bar);
		waitForAutoBuild();
		assertEquals(0, file1.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE).length);
		assertEquals(1, file2.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE).length);
	}

	public void testTwoFilesInTwoNonReferencedProjects() throws Exception {
		createJavaProjectWithRootSrc("foo");
		createJavaProjectWithRootSrc("bar");
		IFile file1 = createFile("foo/src/foo.dmodel", "entity Foo {}");
		IFile file2 = createFile("bar/src/bar.dmodel", "entity Bar { ref stuff : Foo }");
		waitForAutoBuild();
		assertEquals(0, file1.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE).length);
		assertEquals(1, file2.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE).length);
	}

	public void testChangeReferenceOfProjects() throws Exception {
		IJavaProject foo = createJavaProjectWithRootSrc("foo");
		IJavaProject bar = createJavaProjectWithRootSrc("bar");
		IFile file1 = createFile("foo/src/foo.dmodel", "entity Foo {}");
		IFile file2 = createFile("bar/src/bar.dmodel", "entity Bar { ref stuff : Foo }");
		
		addProjectReference(bar, foo);
		waitForAutoBuild();
		assertEquals(0, file1.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE).length);
		assertEquals(0, file2.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE).length);

		// remove dependency
		removeProjectReference(bar,foo);
		waitForAutoBuild();
		assertEquals(0, file1.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE).length);
		assertEquals(1, file2.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE).length);

		addProjectReference(bar, foo);
		waitForAutoBuild();
		assertEquals(0, file1.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE).length);
		assertEquals(0, file2.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE).length);
	}

	

}
