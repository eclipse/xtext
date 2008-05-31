package org.eclipse.xtext.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.LogFactory;

public class ServiceRegistry {

    private static List<ILanguageServiceFactory> factories = new ArrayList<ILanguageServiceFactory>();

    @SuppressWarnings("unchecked")
    public static <T extends ILanguageService> T getService(ILanguageDescriptor languageDescriptor, Class<T> serviceInterface) {
        try {
            if (languageDescriptor != null && serviceInterface != null) {
                for (ILanguageServiceFactory factory : factories) {
                    if (factory.isFactoryFor(languageDescriptor, serviceInterface)) {
                        T languageService = (T) factory.createLanguageService(languageDescriptor, serviceInterface);
                        injectDependencies(languageDescriptor, languageService);
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

    private static void injectDependencies(ILanguageDescriptor languageDescriptor, ILanguageService service)
            throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException {
        Class<? extends ILanguageService> serviceClass = service.getClass();
        Method[] methods = serviceClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(InjectedService.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 1) {
                    throw new IllegalArgumentException("Annotated method must have exctly one parameter");
                }
                findAndInjectService(languageDescriptor, service, parameterTypes[0], method);
            }
        }
        Field[] fields = serviceClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectedService.class)) {
                Class<?> type = field.getType();
                Method setter = serviceClass.getMethod(getSetterName(field), type);
                findAndInjectService(languageDescriptor, service, type, setter);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void findAndInjectService(ILanguageDescriptor languageDescriptor, ILanguageService service, Class<?> type, Method setter)
            throws IllegalAccessException, InvocationTargetException {
        if (ILanguageDescriptor.class.equals(type)) {
            setter.invoke(service, languageDescriptor);
            return;
        }
        if (!ILanguageService.class.isAssignableFrom(type)) {
            throw new IllegalArgumentException(
                    "Annotated member's type must extend ILanguageService. Member type class: " + type
                            + ", but should be " + ILanguageService.class + ".");
        }
        ILanguageService injectedService = ServiceRegistry.getService(languageDescriptor, (Class<? extends ILanguageService>) type);
        if (injectedService == null) {
            throw new IllegalStateException("Could not inject service " + type.getSimpleName());
        }
        setter.invoke(service, injectedService);
    }

    private static String getSetterName(Field field) {
        String name = field.getName();
        return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    protected static void resetInternal() {
        factories.clear();
    }

}
