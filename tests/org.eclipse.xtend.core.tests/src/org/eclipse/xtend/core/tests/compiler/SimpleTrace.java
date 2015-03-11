package org.eclipse.xtend.core.tests.compiler;

import java.io.InputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.trace.AbstractTrace;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;

public class SimpleTrace extends AbstractTrace {

	private final AbstractTraceRegion root;

	public SimpleTrace(AbstractTraceRegion root) {
		this.root = root;
	}

	@Override
	protected AbstractTraceRegion doGetRootTraceRegion() {
		return root;
	}

	@Override
	/* @NonNull */
	public IProject getLocalProject() {
		throw new UnsupportedOperationException();
	}

	@Override
	public URI getLocalURI() {
		return null;
	}

	@Override
	protected IStorage findStorage(URI uri, IProject project) {
		return null;
	}

	@Override
	protected InputStream getContents(URI uri, IProject project) throws CoreException {
		return null;
	}

}