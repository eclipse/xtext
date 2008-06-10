/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.service.internal.GenericSingletonLanguageServiceFactory;
import org.eclipse.xtext.util.Pair;

/**
 * 
 * @author Jan Köhnlein
 * 
 */
public class ServiceRegistry {

	private static Map<Pair<ILanguageDescriptor, Class<? extends ILanguageService>>, Map<Integer, ILanguageServiceFactory>> factoryMap = new HashMap<Pair<ILanguageDescriptor, Class<? extends ILanguageService>>, Map<Integer, ILanguageServiceFactory>>();

	public static final int PRIORITY_MIN = Integer.MIN_VALUE;
	public static final int PRIORITY_NORMAL = 0;
	public static final int PRIORITY_MAX = Integer.MAX_VALUE;

	@SuppressWarnings("unchecked")
	public static <T extends ILanguageService> T getService(ILanguageDescriptor languageDescriptor,
			Class<T> serviceInterface) {
		Map<Class<?>, ILanguageService> cachedServices = new HashMap<Class<?>, ILanguageService>();
		ILanguageService service = findAndInitializeService(languageDescriptor, serviceInterface, cachedServices);
        return (T) service;
	}

	@SuppressWarnings("unchecked")
	private static <T extends ILanguageService> T internalGetService(ILanguageDescriptor languageDescriptor,
			Class<T> serviceInterface, Map<Class<?>, ILanguageService> cachedServices) {
		if (languageDescriptor == null || serviceInterface == null) {
			throw new IllegalArgumentException("Neither languageDescriptor nor serviceInterface can be null");
		}
		try {
			Pair<ILanguageDescriptor, Class<? extends ILanguageService>> key = createKey(languageDescriptor,
					serviceInterface);
			Map<Integer, ILanguageServiceFactory> priorityMap = factoryMap.get(key);
			if (priorityMap == null) {
				return null;
			}
			Integer maxPriority = Collections.max(priorityMap.keySet());
			ILanguageServiceFactory languageServiceFactory = priorityMap.get(maxPriority);
			T languageService = (T) languageServiceFactory.createLanguageService();
			cachedServices.put(serviceInterface, languageService);
			return languageService;
		} catch (Exception exc) {
			LogFactory.getLog(ServiceRegistry.class).error(
					"Error getting service " + serviceInterface.getSimpleName() + " for " + languageDescriptor, exc);
		}
		return null;
	}

	public static <T extends ILanguageService> ILanguageServiceFactory registerService(
			ILanguageDescriptor languageDescriptor, ILanguageService service,
			Class<? extends ILanguageService> serviceInterface) {
		return registerFactory(languageDescriptor, new GenericSingletonLanguageServiceFactory(service, serviceInterface),
				PRIORITY_NORMAL);
	}

	public static <T extends ILanguageService> ILanguageServiceFactory registerService(
			ILanguageDescriptor languageDescriptor, ILanguageService service,
			Class<? extends ILanguageService> serviceInterface, int priority) {
		return registerFactory(languageDescriptor, new GenericSingletonLanguageServiceFactory(service, serviceInterface),
				priority);
	}

	public static <T extends ILanguageService> ILanguageServiceFactory registerFactory(
			ILanguageDescriptor languageDescriptor, ILanguageServiceFactory factory, int priority) {
		if (languageDescriptor == null || factory == null) {
			throw new IllegalArgumentException("Neither languageDescriptor nor factory can be null");
		}
		if (factory.getServiceInterface() == null) {
			throw new IllegalArgumentException("getServiceClass() must not be null");
		}
		synchronized (factoryMap) {
			Pair<ILanguageDescriptor, Class<? extends ILanguageService>> key = createKey(languageDescriptor, factory
					.getServiceInterface());
			Map<Integer, ILanguageServiceFactory> priorityMap = factoryMap.get(key);
			if (priorityMap == null) {
				priorityMap = new HashMap<Integer, ILanguageServiceFactory>();
				factoryMap.put(key, priorityMap);
			}
			ILanguageServiceFactory currentFactory = priorityMap.get(priority);
			priorityMap.put(priority, factory);
			return currentFactory;
		}
	}

	public static <T extends ILanguageService> ILanguageServiceFactory registerFactory(
			ILanguageDescriptor languageDescriptor, ILanguageServiceFactory factory) {
		return registerFactory(languageDescriptor, factory, PRIORITY_NORMAL);
	}

	private static Pair<ILanguageDescriptor, Class<? extends ILanguageService>> createKey(
			ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
		Pair<ILanguageDescriptor, Class<? extends ILanguageService>> key = new Pair<ILanguageDescriptor, Class<? extends ILanguageService>>(
				languageDescriptor, serviceClass);
		return key;
	}

	private static void injectDependencies(ILanguageDescriptor languageDescriptor, ILanguageService service,
			Map<Class<?>, ILanguageService> cachedServices) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SecurityException, NoSuchMethodException {
		Class<?> serviceClass = service.getClass();
		do {
			injectServicesForClass(languageDescriptor, service, serviceClass, cachedServices);
			serviceClass = serviceClass.getSuperclass();
		} while (serviceClass != null);
		Class<?>[] interfaces = service.getClass().getInterfaces();
		for (Class<?> implementedInterface : interfaces) {
			injectServicesForClass(languageDescriptor, service, implementedInterface, cachedServices);
		}
	}

	private static void injectServicesForClass(ILanguageDescriptor languageDescriptor, Object service,
			Class<?> serviceClass, Map<Class<?>, ILanguageService> cachedServices) throws IllegalAccessException,
			InvocationTargetException {
		Method[] methods = serviceClass.getMethods();
		for (Method method : methods) {
			Class<?>[] parameterTypes = method.getParameterTypes();
			if (parameterTypes.length != 1 && method.isAnnotationPresent(InjectedService.class)) {
				throw new IllegalArgumentException("Annotated method must have excatly one parameter");
			}
			if (parameterTypes.length == 1
					&& (method.isAnnotationPresent(InjectedService.class) || ILanguageDescriptor.class
							.equals(parameterTypes[0]))) {
				if (ILanguageDescriptor.class.equals(parameterTypes[0])) {
					method.invoke(service, languageDescriptor);
				} else {
					ILanguageService injectedService = findAndInitializeService(languageDescriptor, parameterTypes[0],
							cachedServices);
					method.invoke(service, injectedService);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static ILanguageService findAndInitializeService(ILanguageDescriptor languageDescriptor, Class<?> serviceInterface,
			Map<Class<?>, ILanguageService> cachedServices) {

		if (!ILanguageService.class.isAssignableFrom(serviceInterface)) {
			throw new IllegalArgumentException(
					"Annotated member's type must extend ILanguageService. Member type class: " + serviceInterface
							+ ", but should be " + ILanguageService.class + ".");
		}
		ILanguageService service = cachedServices.get(serviceInterface);
		ILanguageDescriptor tempDesc = languageDescriptor;
		while (service == null && tempDesc != null) {
			service = ServiceRegistry.internalGetService(tempDesc, (Class<? extends ILanguageService>) serviceInterface,
					cachedServices);
			if (service == null) {
				tempDesc = tempDesc.getSuperLanguage();
			} else {
				try {
					injectDependencies(languageDescriptor, service, cachedServices);
				} catch (Exception exc) {
					throw new WrappedException("Error injecting dependencies into "
							+ (service != null ? service.getClass().getSimpleName() : "null") + " for "
							+ languageDescriptor, exc);
				}
			}
		}
		if (service == null) {
			throw new IllegalStateException("Could not find service " + serviceInterface.getSimpleName() + " for language "
					+ languageDescriptor.getId());
		}
		return service;
	}

	public static void resetInternal() {
		synchronized (factoryMap) {
			factoryMap.clear();
		}
	}
	
	public static void dump() {
	    Set<Pair<ILanguageDescriptor, Class<? extends ILanguageService>>> keySet = factoryMap.keySet();
	    for (Pair<ILanguageDescriptor, Class<? extends ILanguageService>> pair : keySet) {
            System.out.println(pair.getFirstElement() + " " + pair.getSecondElement().getSimpleName());
        }
	}
	
    public static void initializeInstance(ILanguageDescriptor languageDescriptor, Object instance) {
        Map<Class<?>, ILanguageService> cachedServices = new HashMap<Class<?>, ILanguageService>();
        try {
            injectServicesForClass(languageDescriptor, instance, instance.getClass(), cachedServices);
        }
        catch (Exception e) {
            throw new WrappedException("Error injecting dependencies into "
                    + (instance != null ? instance.getClass().getSimpleName() : "null") + " for " + languageDescriptor,
                    e);

        }
    }

}
