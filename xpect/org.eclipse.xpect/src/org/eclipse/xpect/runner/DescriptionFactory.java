package org.eclipse.xpect.runner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xpect.XpectFile;
import org.eclipse.xpect.XpectInvocation;
import org.junit.runner.Description;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;

public class DescriptionFactory {

	public static Description createFileDescription(Class<?> clazz, IXpectURIProvider uriProvider, URI uri) {
		URI deresolved = uriProvider.deresolveToProject(uri);
		Description result = createFileDescription(deresolved.trimSegments(1).toString(), deresolved.lastSegment());
		return result;
	}

	public static Description createFileDescription(XpectFile file) {
		URI uri = file.eResource().getURI();
		Preconditions.checkArgument(uri.isPlatform());
		String pathInProject = Joiner.on('/').join(uri.segmentsList().subList(2, uri.segmentCount() - 1));
		return createFileDescription(pathInProject, uri.lastSegment());
	}

	public static Description createFileDescription(String pathInProject, String fileName) {
		String name = fileName + ": " + pathInProject;
		Description result = Description.createSuiteDescription(name);
		return result;
	}

	public static Description createFileDescriptionForError(Class<?> clazz, IXpectURIProvider uriProvider, URI uri) {
		URI deresolved = uriProvider.deresolveToProject(uri);
		String name = deresolved.lastSegment() + ": " + deresolved.trimSegments(1).toString();
		Description result = Description.createTestDescription(clazz, name);
		return result;
	}

	public static Description createTestDescription(Class<?> javaClass, IXpectURIProvider uriProvider, XpectInvocation invocation) {
		URI uri = uriProvider.deresolveToProject(EcoreUtil.getURI(invocation));
		TestTitleRegion titleRegion = invocation.getRelatedRegion(TestTitleRegion.class);
		if (titleRegion != null && titleRegion.getTitle() != null)
			return Description.createTestDescription(javaClass, uri.toString() + ": " + titleRegion.getTitle());
		else
			return Description.createTestDescription(javaClass, uri.toString());
	}

	public static Description createTestDescription(XpectInvocation invocation) {
		URI uri = EcoreUtil.getURI(invocation);
		Preconditions.checkArgument(uri.isPlatform());
		String className = invocation.getFile().getJavaModel().getTestOrSuite().getJvmClass().getQualifiedName();
		String text = Joiner.on('/').join(uri.segmentsList().subList(2, uri.segmentCount())) + "#" + uri.fragment();
		TestTitleRegion titleRegion = invocation.getRelatedRegion(TestTitleRegion.class);
		if (titleRegion != null && titleRegion.getTitle() != null)
			return Description.createTestDescription(className, text + ": " + titleRegion.getTitle());
		else
			return Description.createTestDescription(className, text);
	}
}
