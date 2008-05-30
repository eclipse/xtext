package org.eclipse.xtext.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.LogFactory;

public class ServiceRegistry {

    private static Map<ILanguageDescriptor, Map<Class<?>, ILanguageServiceFactory<?>>> descriptor2FactoryMap = new HashMap<ILanguageDescriptor, Map<Class<?>, ILanguageServiceFactory<?>>>();

    @SuppressWarnings("unchecked")
    public static <T extends ILanguageService> T getService(ILanguageDescriptor languageDescriptor, Class<T> serviceClass) {
        try {
            if (languageDescriptor != null) {
                Map<Class<?>, ILanguageServiceFactory<?>> factoryMap = descriptor2FactoryMap.get(languageDescriptor);
                if (factoryMap != null) {
                    ILanguageServiceFactory<T> languageServiceFactory = (ILanguageServiceFactory<T>) factoryMap.get(serviceClass);
                    if (languageServiceFactory != null) {
                        T languageService = languageServiceFactory.createLanguageService();
                        languageService.setLanguageDescriptor(languageDescriptor);
                        injectDependencies(languageDescriptor, languageService);
                        return languageService;
                    }
                }
            }
        } catch (Exception exc) {
            LogFactory.getLog(ServiceRegistry.class).error(
                    "Error getting service " + serviceClass.getSimpleName() + " for " + languageDescriptor, exc);
        }
        return null;
    }

    public static <T extends ILanguageService> void registerFactory(ILanguageDescriptor languageDescriptor,
            ILanguageServiceFactory<T> factory) {
        Map<Class<?>, ILanguageServiceFactory<?>> factories = descriptor2FactoryMap.get(languageDescriptor);
        if (factories == null) {
            factories = new HashMap<Class<?>, ILanguageServiceFactory<?>>();
            descriptor2FactoryMap.put(languageDescriptor, factories);
        }
        factories.put(factory.getServiceClass(), factory);
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
        if (!ILanguageService.class.isAssignableFrom(type)) {
            throw new IllegalArgumentException("Annotated member's type must extend ILanguageService");
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

    protected static void reset() {
        descriptor2FactoryMap.clear();
    }

}
