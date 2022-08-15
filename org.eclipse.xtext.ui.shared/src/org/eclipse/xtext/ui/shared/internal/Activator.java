/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.osgi.util.ManifestElement;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.XtextRuntimeModule;
import org.eclipse.xtext.common.types.ui.notification.TypeResourceUnloader;
import org.eclipse.xtext.ide.DefaultIdeModule;
import org.eclipse.xtext.ui.DefaultUiModule;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.Version;

import com.google.common.collect.Lists;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

public class Activator extends Plugin {
	private static final String PLUGIN_ID_JDT_UI = "org.eclipse.jdt.ui";
	private static final String PLUGIN_ID_XTEXT_RT = "org.eclipse.xtext";
	private static final String PLUGIN_ID_XTEXT_UI = "org.eclipse.xtext.ui";
	private static final String PLUGIN_ID_XTEND_RT = "org.eclipse.xtend";

	private static final Logger log = Logger.getLogger(Activator.class);

	private static Activator plugin;

	public static final String PLUGIN_ID = "org.eclipse.xtext.ui.shared"; //$NON-NLS-1$

	public static Activator getDefault() {
		return plugin;
	}

	private Injector injector;

	@Inject
	private EagerContributionInitializer initializer;

	public Injector getInjector() {
		return injector;
	}

	protected void initializeInjector(BundleContext context) throws CoreException {
		IExtensionPoint point = Platform.getExtensionRegistry().getExtensionPoint(PLUGIN_ID + ".overridingGuiceModule");
		IExtension[] extensions = point.getExtensions();
		Module module = new SharedModule(context);
		if (extensions.length != 0) {
			int numberOfMixedInModules = 0;
			StringBuilder sb = new StringBuilder("Multiple contributions to extension point '"+ PLUGIN_ID + ".overridingGuiceModule'."
					+ " Will use them in unspecified order.");
			for (IExtension iExtension : extensions) {
				IConfigurationElement[] elements = iExtension.getConfigurationElements();
				for (IConfigurationElement e : elements) {
					try {
						Module m = (Module) e.createExecutableExtension("class");
						module = Modules.override(module).with(m);
						numberOfMixedInModules++;
						sb.append("\n\tcontributor: ").append(e.getContributor().getName());
					} catch (CoreException e1) {
						log.error(e1.getMessage(), e1);
					}
				}
			}
			if (numberOfMixedInModules >= 2) {
				log.warn(sb.toString());
			}
		}

		try {
			injector = Guice.createInjector(module);
			injector.createChildInjector(new Module() {
				@Override
				public void configure(Binder binder) {
					binder.bind(EagerContributionInitializer.class);
				}
			}).injectMembers(this);
		} catch (Throwable t) {
			handleGuiceInitializationError(t);
		}
	}

	/**
	 * Analyze the occured error during Guice initialization and give hints to check the configuration error.
	 * @throws CoreException Will be thrown in any case
	 * @since 2.13
	 */
	protected void handleGuiceInitializationError(Throwable t) throws CoreException {
		Bundle bundleXtextRuntime = FrameworkUtil.getBundle(XtextRuntimeModule.class);
		Bundle bundleXtextIde = FrameworkUtil.getBundle(DefaultIdeModule.class);
		Bundle bundleXtextUi = FrameworkUtil.getBundle(DefaultUiModule.class);
		Bundle bundleXtextUiShared = FrameworkUtil.getBundle(SharedModule.class);

		StringBuilder msg = new StringBuilder();
		msg.append("Xtext configuration error!\n");
		msg.append("This error might indicate missing version constraints of installed Xtext based bundles.\n");
		
		msg.append("The following bundles were detected that require Xtext UI:\n");
		
		getBundlesRequiringXtextUi()
			.forEach((bundle) -> msg.append("- "+getBundleInfo(bundle) +"\n"));
		
		msg.append("The installed Xtext bundle versions are:\n");
		Lists.newArrayList(bundleXtextRuntime, bundleXtextIde, bundleXtextUi, bundleXtextUiShared)
			.forEach(
				(bundle) -> msg.append("- "+getBundleInfo(bundle) + "\n")
			);

		if (compareVersionIgnoringQualifier(bundleXtextRuntime.getVersion(), bundleXtextUiShared.getVersion()) > 0) {
			msg.append("Runtime bundle is NEWER than UI bundles! Please make sure that both bundles are installed with the same version!\n");
		}
		throw new CoreException(new Status(IStatus.ERROR, getBundle().getSymbolicName(), msg.toString(), t));
	}

	private int compareVersionIgnoringQualifier(Version v1, Version v2) {
		return new Version(v1.getMajor(), v1.getMinor(), v1.getMicro()).compareTo(new Version(v2.getMajor(), v2.getMinor(), v2.getMicro()));
	}

	private String getBundleInfo (Bundle bundle) {
		String state = null;
		switch (bundle.getState()) {
			case Bundle.UNINSTALLED: state = "UNINSTALLED"; break;
			case Bundle.INSTALLED: state = "INSTALLED"; break;
			case Bundle.RESOLVED: state = "RESOLVED"; break;
			case Bundle.STARTING: state = "STARTING"; break;
			case Bundle.STOPPING: state = "STOPPING"; break;
			case Bundle.ACTIVE: state = "ACTIVE"; break;
		}
		return bundle.getSymbolicName() + " " + bundle.getVersion() + " ["+state+"]";
	}

	/**
	 * Retrieves all bundles that declare a RequireBundle dependency on org.eclipse.xtext.ui, excluding bundles from Xtext itself.
	 * @since 2.13
	 */
	public List<Bundle> getBundlesRequiringXtextUi() {
		return Arrays.asList(getBundle().getBundleContext().getBundles()).stream()
			.filter((bundle)-> // exclude Xtext's own bundles
				!Arrays.stream(new String[] {PLUGIN_ID_XTEXT_RT,PLUGIN_ID_XTEND_RT}).anyMatch((s)->bundle.getSymbolicName().startsWith(s))
			)
			.filter(
				(bundle) -> {
				try {
					ManifestElement[] requireBundle = ManifestElement.parseHeader(Constants.REQUIRE_BUNDLE, bundle.getHeaders().get(Constants.REQUIRE_BUNDLE));
					if (requireBundle == null)
						return false;
					Stream<ManifestElement> requireElements = Arrays.stream(requireBundle);
					return requireElements
						.map((e)->e.getValueComponents())
						.flatMap((e)->Arrays.stream(e))
						.anyMatch((bundleName) -> {
							return PLUGIN_ID_XTEXT_UI.equals(bundleName);
						})
						;
				} catch (BundleException e) {}
				return false;
			}
		).collect(Collectors.toList());
	}
	

	public static boolean isJavaEnabled() {
		try {
			JavaCore.class.getName();
			TypeResourceUnloader.class.getName();
			// Activating JavaUI needs the Display Thread, which is not available on early start ups.
			// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=342711
			if (Display.getCurrent() == null) {
				Bundle[] bundles = plugin.getBundle().getBundleContext().getBundles();
				for (Bundle bundle :bundles) {
					if (PLUGIN_ID_JDT_UI.equals(bundle.getSymbolicName())) {
						return true;
					}
				}
				return false;
			} else {
				JavaUI.class.getName();
			}
			return true;
		} catch (Throwable e) {
			log.info("Disabling JDT use. : " + e.getMessage());
			log.debug(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		try {
			super.start(context);
			plugin = this;
			initializeInjector(context);
			initializer.initialize();
		} catch (CoreException e) {
			throw e;
		} catch (Exception e) {
			log.error("Error initializing " + PLUGIN_ID + ":" + e.getMessage(), e);
		}
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		injector = null;
		if (initializer != null) {
			initializer.discard();
			initializer = null;
		}
		super.stop(context);
	}

}
