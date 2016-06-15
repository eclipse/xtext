package org.eclipse.xtext.common.types.tests;

import org.eclipse.xtext.common.types.access.jdt.MockJavaProjectProvider;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractActivator {

	@Override
	public void stop(BundleContext context) throws Exception {
		MockJavaProjectProvider.tearDown();
		super.stop(context);
	}

}
