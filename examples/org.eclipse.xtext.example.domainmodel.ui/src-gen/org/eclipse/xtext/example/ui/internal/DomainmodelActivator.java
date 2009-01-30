package org.eclipse.xtext.example.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class DomainmodelActivator extends AbstractUIPlugin {

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		org.eclipse.xtext.example.DomainmodelUiSetup.doSetup();
	}
	
}
 