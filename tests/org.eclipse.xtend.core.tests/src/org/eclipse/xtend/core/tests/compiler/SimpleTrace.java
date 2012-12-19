package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.jdt.annotation.NonNull;
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
	@NonNull
	public IProject getLocalProject() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public IStorage getLocalStorage() {
		throw new UnsupportedOperationException();
	}

}