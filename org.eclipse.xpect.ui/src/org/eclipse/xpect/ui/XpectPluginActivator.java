package org.eclipse.xpect.ui;

import org.eclipse.xpect.registry.DelegatingLanguageRegistry;
import org.eclipse.xpect.registry.ILanguageInfo;
import org.eclipse.xpect.ui.editor.XtextWithXpectEditorInstaller;
import org.eclipse.xpect.ui.internal.XpectActivator;
import org.eclipse.xpect.ui.registry.ExtensionRegistryReader;
import org.eclipse.xpect.ui.registry.UILanugageRegistry;
import org.osgi.framework.BundleContext;

public class XpectPluginActivator extends XpectActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		UILanugageRegistry lanugageRegistry = new UILanugageRegistry();
		((DelegatingLanguageRegistry) ILanguageInfo.Registry.INSTANCE).setDelegate(lanugageRegistry);
		new ExtensionRegistryReader(lanugageRegistry).readRegistry();
		new XtextWithXpectEditorInstaller().earlyStartup();
	}

}
