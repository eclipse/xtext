package org.eclipse.xtext.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class XtextGrammarTestLanguageActivator extends AbstractUIPlugin {

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		org.eclipse.xtext.XtextGrammarTestLanguageUiSetup.doSetup();
	}
	
}
 