package org.eclipse.xtext.grammarinheritance.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class AbstractTestLanguageActivator extends AbstractUIPlugin {

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		org.eclipse.xtext.grammarinheritance.AbstractTestLanguageUiSetup.doSetup();
	}
	
}
 