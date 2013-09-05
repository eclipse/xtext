package org.xpect.ui.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.junit.model.ITestCaseElement;
import org.eclipse.jdt.junit.model.ITestElement;
import org.eclipse.jdt.junit.model.ITestSuiteElement;

/**
 * 
 * @author Moritz Eysholdt
 */
public class TestDataUIUtil {
	public static class TestElementInfo {
		private String clazz;
		private IFile file;
		private String filename;
		private IJavaProject javaProject;
		private String title;
		private URI uri;

		protected IFile findFile() {
			IResource resource = javaProject.getProject().findMember(filename);
			if (resource == null || !resource.exists())
				throw new IllegalStateException("File " + filename + " does not exist.");
			if (!(resource instanceof IFile))
				throw new IllegalStateException(resource + " is not a file, but a " + resource.getClass().getSimpleName());
			return (IFile) resource;
		}

		public String getClazz() {
			return clazz;
		}

		public IFile getFile() {
			if (file == null)
				file = findFile();
			return file;
		}

		public IJavaProject getJavaProject() {
			return javaProject;
		}

		public String getMethod() {
			if (title == null)
				return null;
			int i = 0;
			while (i < title.length() && Character.isJavaIdentifierPart(title.charAt(i)))
				i++;
			return title.substring(0, i);
		}

		public String getTitle() {
			return title;
		}

		public URI getURI() {
			return uri;
		}
	}

	public static TestElementInfo parse(ITestElement element) {
		TestElementInfo result = new TestElementInfo();
		result.javaProject = element.getTestRunSession().getLaunchedProject();
		String project = result.javaProject.getProject().getName();
		if (element instanceof ITestCaseElement) {
			ITestCaseElement tce = (ITestCaseElement) element;
			result.clazz = tce.getTestClassName();
			String methodName = tce.getTestMethodName();
			if (methodName.contains("~")) {
				int colon = methodName.indexOf(':');
				String description;
				URI uri;
				if (colon >= 0) {
					description = methodName.substring(colon + 1).trim();
					uri = URI.createURI(methodName.substring(0, colon).trim());
				} else {
					description = null;
					uri = URI.createURI(methodName);
				}
				URI base = URI.createPlatformResourceURI(project + "/", true);
				result.uri = uri.resolve(base);
				result.filename = uri.trimFragment().toString();
				String name = uri.fragment();
				int tilde = name.indexOf('~');
				if (tilde >= 0)
					name = name.substring(0, tilde);
				if (description != null)
					result.title = name + ": " + description;
				else
					result.title = name;
			} else if (methodName.contains(":")) {
				int colon = methodName.indexOf(':');
				String filename = methodName.substring(0, colon).trim();
				String path = methodName.substring(colon + 1).trim();
				result.uri = URI.createPlatformResourceURI(project + "/" + path + "/" + filename, true);
				result.filename = path + "/" + filename;
				result.title = tce.getTestMethodName();
			} else {
				result.title = tce.getTestMethodName();
			}
		} else if (element instanceof ITestSuiteElement) {
			ITestSuiteElement tse = (ITestSuiteElement) element;
			String name = tse.getSuiteTypeName();
			result.title = tse.getSuiteTypeName();
			if (name.contains(":")) {
				int colon = name.indexOf(':');
				String filename = name.substring(0, colon).trim();
				String path = name.substring(colon + 1).trim();
				result.uri = URI.createPlatformResourceURI(project + "/" + path + "/" + filename, true);
				result.filename = path + "/" + filename;
			} else {
				result.clazz = name;
			}
		}
		return result;
	}
}
