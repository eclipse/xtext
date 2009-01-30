package org.eclipse.xtext.reference.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class ReferenceGrammarActivator extends AbstractUIPlugin {

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		org.eclipse.xtext.reference.ReferenceGrammarUiSetup.doSetup();
	}
	
}
 