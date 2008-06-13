/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.service.internal.GenericLanguageServiceFactory;
import org.eclipse.xtext.util.Pair;

/**
 * 
 * @author Jan Köhnlein
 * 
 */
public class ServiceRegistry {

    public static final int PRIORITY_MIN = Integer.MIN_VALUE;
    public static final int PRIORITY_NORMAL = 0;
    public static final int PRIORITY_MAX = Integer.MAX_VALUE;

    private static volatile boolean isFrozen = false;

    private static class ServiceKey extends Pair<ILanguageDescriptor, Class<? extends ILanguageService>> {
        public ServiceKey(ILanguageDescriptor firstElement, Class<? extends ILanguageService> secondElement) {
            super(firstElement, secondElement);
        }
    }

    private static class Entry {
        int priority;
        ILanguageServiceFactory factory;
        ILanguageService cachedService;
    }

    private static Map<ServiceKey, Entry> entryMap = new HashMap<ServiceKey, Entry>();

    @SuppressWarnings("unchecked")
    public static <T extends ILanguageService> T getService(ILanguageDescriptor languageDescriptor, Class<T> serviceInterface) {
        Map<Class<?>, ILanguageService> initializedServices = new HashMap<Class<?>, ILanguageService>();
        ILanguageService service = findAndInitializeService(languageDescriptor, serviceInterface, initializedServices);
        return (T) service;
    }

    public static <T extends ILanguageService> ILanguageServiceFactory registerFactory(ILanguageDescriptor languageDescriptor,
            ILanguageServiceFactory factory, int priority) {
        Class<? extends ILanguageService> serviceInterface = factory.getServiceInterface();
        if (serviceInterface == null) {
            throw new IllegalArgumentException("getServiceClass() must not be null");
        }
        return registerFactory(languageDescriptor, serviceInterface, factory, priority);
    }

    /**
     * Registers a factory for the given <code>serviceClass</code> to the
     * <code>languageDescriptor</code> <code>serviceInterface</code>. The given
     * class must be public. If it is a nested class, it also has to be static.
     * Anonymous classes won't work.
     * 
     * @param <
     *      T> the serviceInterface
     * @param languageDescriptor
     * @param serviceInterface
     * @param serviceClass
     * @return
     */
    public static <T extends ILanguageService> Object registerService(ILanguageDescriptor languageDescriptor, Class<T> serviceInterface,
            Class<? extends ILanguageService> serviceClass) {
        return registerFactory(languageDescriptor, new GenericLanguageServiceFactory(serviceInterface, serviceClass));
    }

    /**
     * Registers a factory for the given <code>serviceClass</code> to the
     * <code>languageDescriptor</code> <code>serviceInterface</code>. The given
     * class must be public. If it is a nested class, it also has to be static.
     * Anonymous classes won't work.
     * 
     * @param <
     *      T> the serviceInterface
     * @param languageDescriptor
     * @param serviceInterface
     * @param serviceClass
     * @param priority
     * @return
     */
    public static <T extends ILanguageService> Object registerService(ILanguageDescriptor languageDescriptor, Class<T> serviceInterface,
            Class<? extends ILanguageService> serviceClass, int priority) {
        return registerFactory(languageDescriptor, new GenericLanguageServiceFactory(serviceInterface, serviceClass), priority);
    }

    public static <T extends ILanguageService> Object registerFactory(ILanguageDescriptor languageDescriptor,
            ILanguageServiceFactory factory) {
        return registerFactory(languageDescriptor, factory, PRIORITY_NORMAL);
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
            service = ServiceRegistry.internalGetService(tempDesc, languageDescriptor, (Class<? extends ILanguageService>) serviceInterface,
                    initializedServices);
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
    private static <T extends ILanguageService> T internalGetService(ILanguageDescriptor currentLanguageDescriptor,
            ILanguageDescriptor realLangugeDescriptor, Class<T> serviceInterface, Map<Class<?>, ILanguageService> initializedServices) {
        if (currentLanguageDescriptor == null || serviceInterface == null) {
            throw new IllegalArgumentException("Neither languageDescriptor nor serviceInterface can be null");
        }
        try {
            ServiceKey key = createKey(currentLanguageDescriptor, serviceInterface);
            Entry entry = entryMap.get(key);
            if (entry == null) {
                return null;
            }
            T languageService;
            if (entry.cachedService != null) {
                languageService = (T) entry.cachedService;
            } else {
                languageService = (T) entry.factory.createLanguageService();
                if(currentLanguageDescriptor != realLangugeDescriptor) {
                    Entry newEntry = new Entry();
                    newEntry.cachedService = languageService;
                    newEntry.factory = entry.factory;
                    newEntry.priority = entry.priority;
                    ServiceKey newServiceKey = new ServiceKey(realLangugeDescriptor, serviceInterface);
                    entryMap.put(newServiceKey, newEntry);
                } else {
                    entry.cachedService = languageService;
                }
            }
            initializedServices.put(serviceInterface, languageService);
            return languageService;
        } catch (Exception exc) {
            LogFactory.getLog(ServiceRegistry.class).error(
                    "Error getting service " + serviceInterface.getSimpleName() + " for " + currentLanguageDescriptor, exc);
        }
        return null;
    }

    private static ILanguageServiceFactory registerFactory(ILanguageDescriptor languageDescriptor,
            Class<? extends ILanguageService> serviceInterface, ILanguageServiceFactory serviceFactory, int priority) {
        if (isFrozen) {
            throw new IllegalStateException("No more service registrations allowed after first service has been looked up");
        }
        if (languageDescriptor == null || serviceFactory == null) {
            throw new IllegalArgumentException("Neither languageDescriptor nor service can be null");
        }
        synchronized (entryMap) {
            ServiceKey serviceKey = new ServiceKey(languageDescriptor, serviceInterface);
            Entry entry = entryMap.get(serviceKey);
            if (entry == null || entry.priority <= priority) {
                ILanguageServiceFactory oldFactory = (entry != null) ? entry.factory : null;
                Entry newEntry = new Entry();
                newEntry.priority = priority;
                newEntry.factory = serviceFactory;
                entryMap.put(serviceKey, newEntry);
                return oldFactory;
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
    	Field[] fields = inspectedClass.getDeclaredFields();
    	for (Field field : fields) {
			if (field.isAnnotationPresent(Inject.class)) {
			    field.setAccessible(true);
				if (ILanguageDescriptor.class.equals(field.getType())) {
                    field.set(patient, languageDescriptor);
                } else {
                    ILanguageService injectedService = findAndInitializeService(languageDescriptor, field.getType(), cachedServices);
                    field.set(patient, injectedService);
                }
			}
		}
    	
        Method[] methods = inspectedClass.getDeclaredMethods();
        for (Method method : methods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length != 1 && method.isAnnotationPresent(Inject.class)) {
                throw new IllegalArgumentException("Annotated method must have exactly one parameter");
            }
            if (parameterTypes.length == 1
                    && method.isAnnotationPresent(Inject.class)) {
            	method.setAccessible(true);
                if (ILanguageDescriptor.class.equals(parameterTypes[0])) {
                    method.invoke(patient, languageDescriptor);
                } else {
                    ILanguageService injectedService = findAndInitializeService(languageDescriptor, parameterTypes[0], cachedServices);
                    method.invoke(patient, injectedService);
                }
            }
        }
    }

    public static void freeze() {
        isFrozen = true;
    }

    public static void resetInternal() {
        synchronized (entryMap) {
            entryMap.clear();
            isFrozen = false;
        }
    }

    public static void dump() {
        Set<ServiceKey> keySet = entryMap.keySet();
        for (ServiceKey pair : keySet) {
            System.out.println(pair.getFirstElement() + " " + pair.getSecondElement().getSimpleName());
        }
    }

    public static void injectServices(ILanguageDescriptor languageDescriptor, Object patient) {
        Map<Class<?>, ILanguageService> initializedServices = new HashMap<Class<?>, ILanguageService>();
        try {
            injectDependencies(languageDescriptor, patient, initializedServices);
        } catch (Exception e) {
            throw new WrappedException("Error injecting dependencies into "
                    + (patient != null ? patient.getClass().getSimpleName() : "null") + " for " + languageDescriptor, e);

        }
    }

}
