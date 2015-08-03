package org.eclipse.xtend.core.tests.compiler;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.internal.AbstractTrace;
import org.eclipse.xtext.workspace.IProjectConfig;

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
	public IProjectConfig getLocalProjectConfig() {
		throw new UnsupportedOperationException();
	}

	@Override
	public AbsoluteURI getLocalURI() {
		return null;
	}


	@Override
	protected InputStream getContents(SourceRelativeURI uri, IProjectConfig project) throws IOException {
		throw new UnsupportedOperationException();
	}

	@Override
	protected Reader getContentsAsText(SourceRelativeURI uri, IProjectConfig project)  {
		return null;
	}

	@Override
	protected Reader getLocalContentsAsText(IProjectConfig projectConfig) throws IOException {
		return null;
	}

}