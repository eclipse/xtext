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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.util.Pair;

/**
 * 
 * @author Jan Köhnlein
 * 
 */
public class ServiceRegistry {

    private static volatile boolean isFrozen = false;

    private static class ServiceKey extends Pair<ILanguageDescriptor, Class<? extends ILanguageService>> {
        public ServiceKey(ILanguageDescriptor firstElement, Class<? extends ILanguageService> secondElement) {
            super(firstElement, secondElement);
        }
    };

    private static class RegistryElement extends Pair<Integer, Object> {
        public RegistryElement(Integer firstElement, Object secondElement) {
            super(firstElement, secondElement);
        }
    }

    private static Map<ServiceKey, RegistryElement> factoryMap = new HashMap<ServiceKey, RegistryElement>();

    public static final int PRIORITY_MIN = Integer.MIN_VALUE;
    public static final int PRIORITY_NORMAL = 0;
    public static final int PRIORITY_MAX = Integer.MAX_VALUE;

    @SuppressWarnings("unchecked")
    public static <T extends ILanguageService> T getService(ILanguageDescriptor languageDescriptor, Class<T> serviceInterface) {
        isFrozen = true;
        Map<Class<?>, ILanguageService> initializedServices = new HashMap<Class<?>, ILanguageService>();
        ILanguageService service = findAndInitializeService(languageDescriptor, serviceInterface, initializedServices);
        return (T) service;
    }

    public static <T extends ILanguageService> Object registerFactory(ILanguageDescriptor languageDescriptor,
            ILanguageServiceFactory factory, int priority) {
        Class<? extends ILanguageService> serviceInterface = factory.getServiceInterface();
        if (serviceInterface == null) {
            throw new IllegalArgumentException("getServiceClass() must not be null");
        }
        return registerServiceOrFactory(languageDescriptor, serviceInterface, factory, priority);
    }

    public static <T extends ILanguageService> Object registerFactory(ILanguageDescriptor languageDescriptor,
            ILanguageServiceFactory factory) {
        return registerFactory(languageDescriptor, factory, PRIORITY_NORMAL);
    }

    public static <T extends ILanguageService> Object registerService(ILanguageDescriptor languageDescriptor, ILanguageService service,
            Class<? extends ILanguageService> serviceInterface) {
        return registerService(languageDescriptor, service, serviceInterface, PRIORITY_NORMAL);
    }

    public static <T extends ILanguageService> Object registerService(ILanguageDescriptor languageDescriptor, ILanguageService service,
            Class<? extends ILanguageService> serviceInterface, int priority) {
        return registerServiceOrFactory(languageDescriptor, serviceInterface, service, priority);
    }

    @SuppressWarnings("unchecked")
    private static ILanguageService findAndInitializeService(ILanguageDescriptor languageDescriptor, Class<?> serviceInterface,
            Map<Class<?>, ILanguageService> initializedServices) {

        if (!ILanguageService.class.isAssignableFrom(serviceInterface)) {
            throw new IllegalArgumentException("Annotated member's type must extend ILanguageService. Member type class: "
                    + serviceInterface + ", but should be " + ILanguageService.class + ".");
        }
        ILanguageService service = initializedServices.get(serviceInterface);
        ILanguageDescriptor tempDesc = languageDescriptor;
        while (service == null && tempDesc != null) {
            service = ServiceRegistry.internalGetService(tempDesc, (Class<? extends ILanguageService>) serviceInterface, initializedServices);
            if (service == null) {
                tempDesc = tempDesc.getSuperLanguage();
            } else {
                try {
                    injectDependencies(languageDescriptor, service, initializedServices);
                } catch (Exception exc) {
                    throw new WrappedException("Error injecting dependencies into "
                            + (service != null ? service.getClass().getSimpleName() : "null") + " for " + languageDescriptor, exc);
                }
            }
        }
        if (service == null) {
            throw new IllegalStateException("Could not find service " + serviceInterface.getSimpleName() + " for language "
                    + languageDescriptor.getId());
        }
        return service;
    }

    @SuppressWarnings("unchecked")
    private static <T extends ILanguageService> T internalGetService(ILanguageDescriptor languageDescriptor, Class<T> serviceInterface,
            Map<Class<?>, ILanguageService> initializedServices) {
        if (languageDescriptor == null || serviceInterface == null) {
            throw new IllegalArgumentException("Neither languageDescriptor nor serviceInterface can be null");
        }
        try {
            ServiceKey key = createKey(languageDescriptor, serviceInterface);
            RegistryElement registeredElement = factoryMap.get(key);
            if (registeredElement == null) {
                return null;
            }
            Object registered = registeredElement.getSecondElement();
            T languageService;
            if (registered instanceof ILanguageServiceFactory) {
                ILanguageServiceFactory languageServiceFactory = (ILanguageServiceFactory) registered;
                languageService = (T) languageServiceFactory.createLanguageService();
                registeredElement.setSecondElement(languageService);
            } else {
                languageService = (T) registered;
            }
            initializedServices.put(serviceInterface, languageService);
            return languageService;
        } catch (Exception exc) {
            LogFactory.getLog(ServiceRegistry.class).error(
                    "Error getting service " + serviceInterface.getSimpleName() + " for " + languageDescriptor, exc);
        }
        return null;
    }

    private static Object registerServiceOrFactory(ILanguageDescriptor languageDescriptor,
            Class<? extends ILanguageService> serviceInterface, Object serviceOrFactory, int priority) {
        if (isFrozen) {
            throw new IllegalStateException("No more service registrations allowed after first service has been looked up");
        }
        if (languageDescriptor == null || serviceOrFactory == null) {
            throw new IllegalArgumentException("Neither languageDescriptor nor service can be null");
        }
        synchronized (factoryMap) {
            ServiceKey serviceKey = new ServiceKey(languageDescriptor, serviceInterface);
            RegistryElement registryElement = factoryMap.get(serviceKey);
            if (registryElement == null || registryElement.getFirstElement() <= priority) {
                Object returnValue = (registryElement != null) ? registryElement.getSecondElement() : null;
                RegistryElement newRegistryElement = new RegistryElement(priority, serviceOrFactory);
                factoryMap.put(serviceKey, newRegistryElement);
                return returnValue;
            }
        }
        return null;
    }

    private static ServiceKey createKey(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        ServiceKey key = new ServiceKey(languageDescriptor, serviceClass);
        return key;
    }

    private static void injectDependencies(ILanguageDescriptor languageDescriptor, Object patient,
            Map<Class<?>, ILanguageService> cachedServices) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, SecurityException, NoSuchMethodException {
        Class<?> patientsClass = patient.getClass();
        do {
            injectServicesForClass(languageDescriptor, patient, patientsClass, cachedServices);
            patientsClass = patientsClass.getSuperclass();
        } while (patientsClass != null);
        Class<?>[] interfaces = patient.getClass().getInterfaces();
        for (Class<?> implementedInterface : interfaces) {
            injectServicesForClass(languageDescriptor, patient, implementedInterface, cachedServices);
        }
    }

    private static void injectServicesForClass(ILanguageDescriptor languageDescriptor, Object patient, Class<?> inspectedClass,
            Map<Class<?>, ILanguageService> cachedServices) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = inspectedClass.getMethods();
        for (Method method : methods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length != 1 && method.isAnnotationPresent(InjectedService.class)) {
                throw new IllegalArgumentException("Annotated method must have excatly one parameter");
            }
            if (parameterTypes.length == 1
                    && (method.isAnnotationPresent(InjectedService.class) || ILanguageDescriptor.class.equals(parameterTypes[0]))) {
                if (ILanguageDescriptor.class.equals(parameterTypes[0])) {
                    method.invoke(patient, languageDescriptor);
                } else {
                    ILanguageService injectedService = findAndInitializeService(languageDescriptor, parameterTypes[0], cachedServices);
                    method.invoke(patient, injectedService);
                }
            }
        }
    }

    public static void resetInternal() {
        synchronized (factoryMap) {
            factoryMap.clear();
            isFrozen = false;
        }
    }

    public static void dump() {
        Set<ServiceKey> keySet = factoryMap.keySet();
        for (ServiceKey pair : keySet) {
            System.out.println(pair.getFirstElement() + " " + pair.getSecondElement().getSimpleName());
        }
    }

    public static void injectServices(ILanguageDescriptor languageDescriptor, Object patient) {
        Map<Class<?>, ILanguageService> initializedServices = new HashMap<Class<?>, ILanguageService>();
        try {
            injectDependencies(languageDescriptor, patient, initializedServices);
        }
        catch (Exception e) {
            throw new WrappedException("Error injecting dependencies into "
                    + (patient != null ? patient.getClass().getSimpleName() : "null") + " for " + languageDescriptor,
                    e);

        }
    }

}
