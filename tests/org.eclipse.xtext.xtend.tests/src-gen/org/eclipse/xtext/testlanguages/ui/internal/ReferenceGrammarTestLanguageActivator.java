package org.eclipse.xtext.testlanguages.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class ReferenceGrammarTestLanguageActivator extends AbstractUIPlugin {

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageUiSetup.doSetup();
	}
	
}
 