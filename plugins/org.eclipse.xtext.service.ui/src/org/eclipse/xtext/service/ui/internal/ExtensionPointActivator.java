package org.eclipse.xtext.service.ui.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.service.IServiceRegistrationFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.service.IServiceRegistrationFactory.IServiceRegistration;
import org.eclipse.xtext.service.ui.Activator;

public class ExtensionPointActivator {

	private static final Logger log = Logger.getLogger(ExtensionPointActivator.class);

	private static final String SCOPE = "scope";
	private static final String ID = "id";
	private static final String PARENT_SCOPE = "parentScope";

	private static final String SERVICE_REG_FACTORY_EP = "serviceRegistrationFactory";
	private static final String CLASS = "class";

	public static void activateServices() {
		try {
			registerScopes();
			registerServiceRegistrations();
		}
		catch (Exception e) {
			log.error("Error during initialization of services", e);
		}
	}

	private static void registerServiceRegistrations() {
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(
				Activator.getDefault().getBundle().getSymbolicName(), SERVICE_REG_FACTORY_EP);
		Assert.isNotNull(extensionPoint, "Extension point " + SERVICE_REG_FACTORY_EP + " not defined!");

		IConfigurationElement[] elements = extensionPoint.getConfigurationElements();
		if (elements != null) {
			for (IConfigurationElement ele : elements) {
				log.debug(ele.getContributor());
				IServiceRegistrationFactory srf;
				try {
					srf = (IServiceRegistrationFactory) ele.createExecutableExtension(CLASS);
					Set<IServiceRegistration> registrations = srf.registrations();
					for (IServiceRegistration r : registrations) {
						IServiceScope serviceScope = r.scope();
						if (serviceScope == null) {
							log.warn("Can't register "
									+ (r.serviceFactory() == null ? "service" : "'"
											+ r.serviceFactory().getServiceInterface() + "'")
									+ " , scope is undefined. In " + ele.getContributor());
						}
						else {
							ServiceRegistry.registerFactory(serviceScope, r.serviceFactory(), r.priority());
						}
					}
				}
				catch (Throwable e) {
					log.error(e);
				}
			}
		}
	}

	/**
	 * TODO: This seems to be obsolete now as scopes are created explicitly (not
	 * by means of an ExtensionPoint). If so, delete it, the tests referring to
	 * it and the ScopeUtil.
	 */
	private static void registerScopes() {
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(
				Activator.getDefault().getBundle().getSymbolicName(), SCOPE);
		Assert.isNotNull(extensionPoint, "Extension point " + SCOPE + " not defined!");
		IConfigurationElement[] elements = extensionPoint.getConfigurationElements();
		if (elements != null) {
			List<ScopeDescriptor> scopes = new ArrayList<ScopeDescriptor>();
			for (IConfigurationElement element : elements) {
				ScopeDescriptor scopeDD = new ScopeDescriptor();
				scopeDD.id = element.getAttribute(ID);
				scopeDD.parentScope = element.getAttribute(PARENT_SCOPE);
				scopes.add(scopeDD);
			}
			ScopeUtil.validateAndCleanUpDescriptors(scopes);
			scopes = ScopeUtil.sortScopeDescriptors(scopes);
			for (ScopeDescriptor scopeDesc : scopes) {
				try {
					IServiceScope parentScope = ServiceScopeFactory.get(scopeDesc.parentScope);
					// ServiceScopeFactory.createScope(scopeDesc.id,
					// parentScope);
				}
				catch (Exception e) {
					log.error(e);
				}
			}
		}
	}

}
