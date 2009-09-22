package org.eclipse.xtext.common.types.tests;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.xtext.common.types.access.jdt.MockJavaProjectProvider;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		MockJavaProjectProvider.setUp();
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		MockJavaProjectProvider.tearDown();
		super.stop(context);
	}

}
