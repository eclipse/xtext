package org.eclipse.xtext.ui.integration.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class TestLanguageActivator extends AbstractUIPlugin {

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		org.eclipse.xtext.ui.integration.TestLanguageUiSetup.doSetup();
	}
	
}
 