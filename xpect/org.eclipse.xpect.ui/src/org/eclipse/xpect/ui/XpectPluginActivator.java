/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xpect.ui;

import org.eclipse.xpect.registry.DelegatingExtensionInfoRegistry;
import org.eclipse.xpect.registry.DelegatingLanguageRegistry;
import org.eclipse.xpect.registry.IExtensionInfo;
import org.eclipse.xpect.registry.ILanguageInfo;
import org.eclipse.xpect.registry.ITestSuiteInfo;
import org.eclipse.xpect.registry.TestSuiteInfoRegistry;
import org.eclipse.xpect.ui.internal.XpectActivator;
import org.eclipse.xpect.ui.registry.UIExtensionInfoRegistry;
import org.eclipse.xpect.ui.registry.UILanugageRegistry;
import org.eclipse.xpect.ui.registry.UITestSuiteInfoRegistry;
import org.eclipse.xpect.ui.util.UIBundleInfoRegistry;
import org.eclipse.xpect.ui.util.UIJavaReflectAccess;
import org.eclipse.xpect.ui.util.UIXtInjectorProvider;
import org.eclipse.xpect.util.IBundleInfo;
import org.eclipse.xpect.util.IJavaReflectAccess;
import org.eclipse.xpect.util.IXtInjectorProvider;
import org.osgi.framework.BundleContext;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectPluginActivator extends XpectActivator {

	public final static String XPECT_EDITOR_ID = XpectPluginActivator.ORG_ECLIPSE_XPECT_XPECT;
	public final static String XT_EDITOR_ID = "org.xpect.Xt";

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);

		((DelegatingExtensionInfoRegistry) IExtensionInfo.Registry.INSTANCE).setDelegate(new UIExtensionInfoRegistry());
		((DelegatingLanguageRegistry) ILanguageInfo.Registry.INSTANCE).setDelegate(new UILanugageRegistry());
		((IXtInjectorProvider.Delegate) IXtInjectorProvider.INSTANCE).setDelegate(new UIXtInjectorProvider());
		((IJavaReflectAccess.Delegate) IJavaReflectAccess.INSTANCE).setDelegate(new UIJavaReflectAccess());
		((IBundleInfo.Delegate) IBundleInfo.Registry.INSTANCE).setDelegate(new UIBundleInfoRegistry());
		((TestSuiteInfoRegistry.Delegate) ITestSuiteInfo.Registry.INSTANCE).setDelegate(new UITestSuiteInfoRegistry());
	}

}
