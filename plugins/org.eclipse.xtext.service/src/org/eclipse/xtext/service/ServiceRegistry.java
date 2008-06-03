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

import org.apache.commons.logging.LogFactory;
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

    public static <T extends ILanguageService> T getService(ILanguageDescriptor languageDescriptor, Class<T> serviceInterface) {
        Map<Class<?>, ILanguageService> cachedServices = new HashMap<Class<?>, ILanguageService>();
        return internalGetService(languageDescriptor, serviceInterface, cachedServices);
    }

    @SuppressWarnings("unchecked")
    private static <T extends ILanguageService> T internalGetService(ILanguageDescriptor languageDescriptor, Class<T> serviceInterface,
            Map<Class<?>, ILanguageService> cachedServices) {
        if (languageDescriptor == null || serviceInterface == null) {
            throw new IllegalArgumentException("Neither languageDescriptor nor serviceInterface can be null");
        }
        try {
            Pair<ILanguageDescriptor, Class<? extends ILanguageService>> key = createKey(languageDescriptor, serviceInterface);
            Map<Integer, ILanguageServiceFactory> priorityMap = factoryMap.get(key);
            if (priorityMap == null) {
                return null;
            }
            Integer maxPriority = Collections.max(priorityMap.keySet());
            ILanguageServiceFactory languageServiceFactory = priorityMap.get(maxPriority);
            T languageService = (T) languageServiceFactory.createLanguageService();
            cachedServices.put(serviceInterface, languageService);
            injectDependencies(languageDescriptor, languageService, cachedServices);
            return languageService;
        } catch (Exception exc) {
            LogFactory.getLog(ServiceRegistry.class).error(
                    "Error getting service " + serviceInterface.getSimpleName() + " for " + languageDescriptor, exc);
        }
        return null;
    }

    /**
     * @param <
     *      T>
     * @param languageDescriptor
     * @param factory
     * @param priority
     * @return true if the factory has top priority.
     */
    public static <T extends ILanguageService> boolean registerFactory(ILanguageDescriptor languageDescriptor,
            ILanguageServiceFactory factory, int priority) {
        if (languageDescriptor == null || factory == null) {
            throw new IllegalArgumentException("Neither languageDescriptor nor factory can be null");
        }
        if (factory.getServiceClass() == null) {
            throw new IllegalArgumentException("getServiceClass() must not be null");
        }
        Pair<ILanguageDescriptor, Class<? extends ILanguageService>> key = createKey(languageDescriptor, factory.getServiceClass());
        Map<Integer, ILanguageServiceFactory> priorityMap = factoryMap.get(key);
        if (priorityMap == null) {
            priorityMap = new HashMap<Integer, ILanguageServiceFactory>();
            factoryMap.put(key, priorityMap);
        }
        ILanguageServiceFactory currentFactory = priorityMap.get(priority);
        if (currentFactory != null) {
            throw new IllegalStateException("ServiceRegistry already contains a factory with same priority");
        }
        priorityMap.put(priority, factory);
        return priority == Collections.max(priorityMap.keySet());
    }

    public static <T extends ILanguageService> boolean registerFactory(ILanguageDescriptor languageDescriptor,
            ILanguageServiceFactory factory) {
        return registerFactory(languageDescriptor, factory, PRIORITY_NORMAL);
    }

    private static Pair<ILanguageDescriptor, Class<? extends ILanguageService>> createKey(ILanguageDescriptor languageDescriptor,
            Class<? extends ILanguageService> serviceClass) {
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

    private static void injectServicesForClass(ILanguageDescriptor languageDescriptor, ILanguageService service, Class<?> serviceClass,
            Map<Class<?>, ILanguageService> cachedServices) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = serviceClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(InjectedService.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 1) {
                    throw new IllegalArgumentException("Annotated method must have exctly one parameter");
                }
                findAndInjectService(languageDescriptor, service, parameterTypes[0], method, cachedServices);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void findAndInjectService(ILanguageDescriptor languageDescriptor, ILanguageService service, Class<?> type,
            Method setter, Map<Class<?>, ILanguageService> cachedServices) throws IllegalAccessException, InvocationTargetException {
        if (ILanguageDescriptor.class.equals(type)) {
            setter.invoke(service, languageDescriptor);
            return;
        }
        if (!ILanguageService.class.isAssignableFrom(type)) {
            throw new IllegalArgumentException("Annotated member's type must extend ILanguageService. Member type class: " + type
                    + ", but should be " + ILanguageService.class + ".");
        }
        ILanguageService injectedService = cachedServices.get(type);
        if (injectedService == null) {
            injectedService = ServiceRegistry.internalGetService(languageDescriptor, (Class<? extends ILanguageService>) type,
                    cachedServices);
            if (injectedService == null) {
                throw new IllegalStateException("Could not inject service " + type.getSimpleName());
            }
        }
        setter.invoke(service, injectedService);
    }

    public static void resetInternal() {
        factoryMap.clear();
    }

}
