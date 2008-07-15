package org.eclipse.xtext.service.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.service.Activator;
import org.eclipse.xtext.service.IServiceRegistrationFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.service.IServiceRegistrationFactory.IServiceRegistration;

public class ExtensionPointActivator {

	private static Log log = LogFactory.getLog(ExtensionPointActivator.class);

	private static final String SCOPE = "scope";
	private static final String ID = "id";
	private static final String PARENT_SCOPE = "parentScope";

	private static final String SERVICE_FACTORY_EP = "serviceFactory";
	private static final String SCOPE_ID = "scope";
	private static final String PRIORITY = "priority";

	private static final String SERVICE_REG_FACTORY_EP = "serviceRegistrationFactory";
	private static final String CLASS = "class";

	public static void activateServices() {
		registerScopes();
		registerServiceFactories();
		registerServiceRegistrations();
	}

	private static void registerServiceFactories() {
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(
				Activator.getDefault().getBundle().getSymbolicName(), SERVICE_FACTORY_EP);
		Assert.isNotNull(extensionPoint, "Extension point " + SERVICE_FACTORY_EP + " not defined!");

		IConfigurationElement[] elements = extensionPoint.getConfigurationElements();
		if (elements != null) {
			for (IConfigurationElement ele : elements) {
				String scopeId = ele.getAttribute(SCOPE_ID);
				String prio = ele.getAttribute(PRIORITY);
				IServiceScope serviceScope = ServiceScopeFactory.get(scopeId);
				if (serviceScope == null) {
					log.warn("The scope " + scopeId + " is not defined.");
				} else {
					Integer p = 0;
					if (prio != null)
						p = Integer.valueOf(prio);
					ServiceRegistry.registerFactory(serviceScope, new LazyExtensionPointServiceFactory(serviceScope,
							ele), p);
				}
			}
		}
	}

	private static void registerServiceRegistrations() {
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(
				Activator.getDefault().getBundle().getSymbolicName(), SERVICE_REG_FACTORY_EP);
		Assert.isNotNull(extensionPoint, "Extension point " + SERVICE_REG_FACTORY_EP + " not defined!");

		IConfigurationElement[] elements = extensionPoint.getConfigurationElements();
		if (elements != null) {
			for (IConfigurationElement ele : elements) {
				IServiceRegistrationFactory srf;
				try {
					srf = (IServiceRegistrationFactory) ele.createExecutableExtension(CLASS);
					Set<IServiceRegistration> registrations = srf.registrations();
					for (IServiceRegistration r : registrations) {
						IServiceScope serviceScope = ServiceScopeFactory.get(r.scopeId());
						if (serviceScope == null) {
							log.warn("The scope " + r.scopeId() + " is not defined.");
						} else {
							ServiceRegistry.registerFactory(serviceScope, r.serviceFactory(), r.priority());
						}
					}
				} catch (CoreException e) {
					log.error(e);
				}
			}
		}
	}

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
					ServiceScopeFactory.createScope(scopeDesc.id, parentScope);
				} catch (Exception e) {
					log.error(e);
				}
			}
		}
	}

}
