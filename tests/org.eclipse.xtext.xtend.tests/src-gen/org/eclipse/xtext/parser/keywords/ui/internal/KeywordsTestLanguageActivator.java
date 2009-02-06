package org.eclipse.xtext.parser.keywords.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class KeywordsTestLanguageActivator extends AbstractUIPlugin {

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		org.eclipse.xtext.parser.keywords.KeywordsTestLanguageUiSetup.doSetup();
	}
	
}
 