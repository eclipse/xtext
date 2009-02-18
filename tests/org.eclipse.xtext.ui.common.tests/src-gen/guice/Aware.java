
package guice;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

/**
 * Generated from GuiceInjector.xpt
 */
public class Aware implements IExecutableExtensionFactory, IExecutableExtension {

	private Logger log = Logger.getLogger(Aware.class);
	private String clazzName;

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
		throws CoreException {
		if (data instanceof String) {
			clazzName = (String) data;
		}
		else {
			throw new IllegalArgumentException("couldn't handle passed data : "+data);
		}
	}
	
	public Object create() throws CoreException {
		Bundle bundle = org.eclipse.xtext.parser.keywords.Activator.getInstance().getBundle();
		try {
			Class<?> class1 = bundle.loadClass(clazzName);
			return org.eclipse.xtext.parser.keywords.Activator.getInstance().getInjector().getInstance(class1);
		}
		catch (Exception e) {
			log.error(e);
			throw new CoreException(new Status(Status.ERROR, bundle.getSymbolicName(), e.getMessage(),e));
		}
	}
}
