package org.eclipse.xtext.testlanguages.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class TreeTestLanguageActivator extends AbstractUIPlugin {

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		org.eclipse.xtext.testlanguages.TreeTestLanguageUiSetup.doSetup();
	}
	
}
 