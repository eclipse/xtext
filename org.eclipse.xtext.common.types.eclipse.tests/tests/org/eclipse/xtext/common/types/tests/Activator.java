package org.eclipse.xtext.common.types.tests;

import org.eclipse.xtext.common.types.access.jdt.MockJavaProjectProvider;
import org.eclipse.xtext.common.types.eclipse.tests.internal.TestsActivator;
import org.osgi.framework.BundleContext;

public class Activator extends TestsActivator {

	@Override
	public void stop(BundleContext context) throws Exception {
		MockJavaProjectProvider.tearDown();
		super.stop(context);
	}

}
