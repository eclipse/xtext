package org.eclipse.xtext.ui.shared.internal;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.jdt.core.JavaCore;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

public class Activator extends Plugin {

	private static Logger log = Logger.getLogger(Activator.class);

	private static Activator plugin;

	public static final String PLUGIN_ID = "org.eclipse.xtext.ui.shared"; //$NON-NLS-1$

	public static Activator getDefault() {
		return plugin;
	}

	private Injector injector;

	@Inject
	private ComposedResourceChangeListener resourceChangeListener;
	
	@Inject
	private IWorkspace workspace;

	public Injector getInjector() {
		return injector;
	}
	
	protected void initializeInjector() {
		IExtensionPoint point = Platform.getExtensionRegistry().getExtensionPoint(PLUGIN_ID+".overridingGuiceModule");
		IExtension[] extensions = point.getExtensions();
		Module module = new SharedModule();
		if (isJavaEnabled()) {
			module = Modules.override(module).with(
					new SharedModuleWithJdt());
		}
		if (extensions.length==0) {
			int numberOfMixedInModules=0;
			for (IExtension iExtension : extensions) {
				IConfigurationElement[] elements = iExtension.getConfigurationElements();
				for (IConfigurationElement e : elements) {
					try {
						Module m = (Module) e.createExecutableExtension("class");
						module = Modules.override(module).with(m);
						numberOfMixedInModules++;
						if (numberOfMixedInModules==2) {
							log.warn("Multiple overriding guice modules. Will use them in unspecified order.");
						}
					} catch (CoreException e1) {
						log.error(e);
					}
				}
			}
		}
			
		injector = Guice.createInjector(module);
		injector.injectMembers(this);
	}

	protected boolean isJavaEnabled() {
		try {
			JavaCore.initializeAfterLoad(new NullProgressMonitor());
			return true;
		} catch (Throwable e) {
			log.warn("Disabling JDT use.", e);
		}
		return false;
	}

	public void start(BundleContext context) throws Exception {
		try {
			super.start(context);
			plugin = this;
			initializeInjector();
			registerListeners();
		} catch (Exception e) {
			log.error("Error initializing " + PLUGIN_ID + ":" + e.getMessage(),
					e);
		}
	}

	protected void registerListeners() {
		workspace.addResourceChangeListener(resourceChangeListener);
	}
	protected void unregisterListeners() {
		workspace.removeResourceChangeListener(resourceChangeListener);
	}

	public void stop(BundleContext context) throws Exception {
		unregisterListeners();
		plugin = null;
		injector = null;
		super.stop(context);
	}


}
