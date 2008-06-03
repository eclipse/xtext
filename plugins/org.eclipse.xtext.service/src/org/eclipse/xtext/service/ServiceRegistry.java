package org.eclipse.xtext.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.LogFactory;

public class ServiceRegistry {

    private static List<ILanguageServiceFactory> factories = new ArrayList<ILanguageServiceFactory>();

    public static <T extends ILanguageService> T getService(ILanguageDescriptor languageDescriptor, Class<T> serviceInterface) {
        Map<Class<?>, ILanguageService> cachedServices = new HashMap<Class<?>, ILanguageService>();
        return internalGetService(languageDescriptor, serviceInterface, cachedServices);
    }
    
    @SuppressWarnings("unchecked")
    private static <T extends ILanguageService> T internalGetService(ILanguageDescriptor languageDescriptor, Class<T> serviceInterface, Map<Class<?>, ILanguageService> cachedServices) {
        try {
            if (languageDescriptor != null && serviceInterface != null) {
                for (ILanguageServiceFactory factory : factories) {
                    if (factory.isFactoryFor(languageDescriptor, serviceInterface)) {
                        T languageService = (T) factory.createLanguageService(languageDescriptor, serviceInterface);
                        cachedServices.put(serviceInterface, languageService);
                        injectDependencies(languageDescriptor, languageService, cachedServices);
                        return languageService;
                    }
                }
            }
        } catch (Exception exc) {
            LogFactory.getLog(ServiceRegistry.class).error(
                    "Error getting service " + serviceInterface.getSimpleName() + " for " + languageDescriptor, exc);
        }
        return null;
    }
        
    public static ILanguageServiceFactory getFactory(ILanguageDescriptor languageDescriptor,
            Class<? extends ILanguageService> serviceInterface) {
        if (languageDescriptor != null && serviceInterface != null) {
            for (ILanguageServiceFactory factory : factories) {
                if (factory.isFactoryFor(languageDescriptor, serviceInterface)) {
                    return factory;
                }
            }
        }
        return null;
    }

    public static <T extends ILanguageService> void registerFactory(ILanguageServiceFactory factory) {
        factories.add(factory);
    }

    public static <T extends ILanguageService> void deregisterFactory(ILanguageServiceFactory factory) {
        factories.remove(factory);
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
        Method[] methods = serviceClass.getDeclaredMethods();
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
            injectedService = ServiceRegistry.internalGetService(languageDescriptor, (Class<? extends ILanguageService>) type, cachedServices);
            if (injectedService == null) {
                throw new IllegalStateException("Could not inject service " + type.getSimpleName());
            }
        }
        setter.invoke(service, injectedService);
    }

    protected static void resetInternal() {
        factories.clear();
    }

}
