package org.eclipse.emf.index.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.eclipse.emf.index.ui.internal.EmfIndexUIPlugin;

import com.google.inject.Injector;

public class GuiceExecutableExtensionFactory implements IExecutableExtensionFactory, IExecutableExtension {

	private String clazzName;

	@SuppressWarnings("unchecked")
	public Object create() throws CoreException {
		EmfIndexUIPlugin plugin = EmfIndexUIPlugin.getDefault();
		if (plugin != null) {
			try {
				Injector injector = plugin.getInjector();
				synchronized (injector) {
					Class clazz = plugin.getBundle().loadClass(clazzName);
					return injector.getInstance(clazz);
				}
			}
			catch (Exception e) {
				EmfIndexUIPlugin.logError("Could not instantiate extension " + clazzName, e);
			}
		}
		return null;
	}

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		if (data instanceof String) {
			clazzName = (String) data;
		}
		else {
			throw new IllegalArgumentException("couldn't handle passed data : " + data);
		}
	}

}
