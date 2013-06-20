package org.eclipse.xtend.maven;

import org.apache.maven.project.MavenProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.DefaultTraceURIConverter;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class MavenTraceURIConverter extends DefaultTraceURIConverter {

	@Override
	public URI getURIForTrace(XtextResource context) {
		MavenProject project = MavenProjectAdapter.get(context.getResourceSet());
		URI uri = context.getURI();
		URI result = deresolve(project, uri);
		return result;
	}

	protected URI deresolve(MavenProject project, URI uri) {
		Iterable<String> roots = Iterables.concat(project.getCompileSourceRoots(), project.getTestCompileSourceRoots());
		for (String rootString : roots) {
			if (!rootString.endsWith("/"))
				rootString += "/";
			URI root = URI.createFileURI(rootString);
			if (isPrefix(root, uri))
				return uri.deresolve(root);
		}
		throw new RuntimeException("Could not find source folder for '" + uri + "'. Folders:"
				+ Lists.newArrayList(roots));
	}
}
