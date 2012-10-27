package org.eclipse.xpect.ui;

import org.eclipse.xpect.registry.DelegatingLanguageRegistry;
import org.eclipse.xpect.registry.ILanguageInfo;
import org.eclipse.xpect.ui.internal.XpectActivator;
import org.eclipse.xpect.ui.registry.ExtensionRegistryReader;
import org.eclipse.xpect.ui.registry.UILanugageRegistry;
import org.osgi.framework.BundleContext;

public class XpectPluginActivator extends XpectActivator {

	public final static String XPECT_EDITOR_ID = XpectPluginActivator.ORG_ECLIPSE_XPECT_XPECT;
	public final static String XT_EDITOR_ID = "org.eclipse.xpect.Xt";

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		UILanugageRegistry lanugageRegistry = new UILanugageRegistry();
		((DelegatingLanguageRegistry) ILanguageInfo.Registry.INSTANCE).setDelegate(lanugageRegistry);
		new ExtensionRegistryReader(lanugageRegistry).readRegistry();
	}

}
