package org.eclipse.xtend.maven;

import java.io.File;

import org.apache.maven.project.MavenProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.DefaultTraceURIConverter;
import org.eclipse.xtext.generator.trace.TraceURIHelper;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class MavenTraceURIConverter extends DefaultTraceURIConverter {

	@Inject
	private TraceURIHelper traceURIHelper;

	@Override
	public URI getURIForTrace(XtextResource context) {
		MavenProject project = MavenProjectAdapter.get(context.getResourceSet());
		URI uri = context.getResourceSet().getURIConverter().normalize(context.getURI());
		URI result = deresolve(project, uri);
		return result;
	}

	protected URI deresolve(MavenProject project, URI uri) {
		Iterable<String> roots = Iterables.concat(project.getCompileSourceRoots(), project.getTestCompileSourceRoots());
		for (String rootString : roots) {
			String absolutePath = new File(new File(rootString).getAbsoluteFile().toURI().normalize())
					.getAbsolutePath();
			absolutePath += "/";
			URI root = URI.createFileURI(absolutePath);
			if (traceURIHelper.isPrefix(root, uri))
				return uri.deresolve(root);
		}
		throw new RuntimeException("Could not find source folder for '" + uri + "'. Folders:"
				+ Lists.newArrayList(roots));
	}
}
