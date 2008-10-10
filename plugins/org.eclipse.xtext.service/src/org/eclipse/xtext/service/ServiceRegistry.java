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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * 
 * @author Jan Köhnlein
 * 
 */
public class ServiceRegistry {

	private static final Logger logger = Logger.getLogger(ServiceRegistry.class);
	public static final int PRIORITY_MIN = Integer.MIN_VALUE;
	public static final int PRIORITY_NORMAL = 0;
	public static final int PRIORITY_MAX = Integer.MAX_VALUE;

	private static volatile boolean isFrozen = false;

	private static class Entry implements Comparable<Entry> {
		int priority;
		IServiceFactory factory;
		Object cachedService;

		@Override
		public int hashCode() {
			return priority * 100 + factory.getServiceInterface().hashCode();
		}

		@Override
		public boolean equals(Object arg0) {
			if (arg0 instanceof Entry) {
				Entry e = (Entry) arg0;
				return e.priority == priority && e.factory.getServiceInterface().equals(factory.getServiceInterface());
			}
			return super.equals(arg0);
		}

		public int compareTo(Entry arg0) {
			return ((Integer) priority).compareTo(arg0.priority);
		}
	}

	private static Map<IServiceScope, List<Entry>> entryMap = new HashMap<IServiceScope, List<Entry>>();

	public static <T> T getService(IServiceScope serviceScope, Class<T> serviceInterface) {
		isFrozen = true;
		return (T) internalGetService(serviceScope, serviceInterface);
	}

	public static void injectServices(IServiceScope languageDescriptor, Object patient) {
		isFrozen = true;
		try {
			injectDependencies(languageDescriptor, patient);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public static void registerFactory(IServiceScope languageDescriptor, IServiceFactory factory, int priority) {
		Class<? extends Object> serviceInterface = factory.getServiceInterface();
		if (serviceInterface == null) {
			throw new IllegalArgumentException("getServiceClass() must not be null");
		}
		registerFactory(languageDescriptor, serviceInterface, factory, priority);
	}

	/**
	 * Registers a factory for the given <code>serviceClass</code> to the
	 * <code>languageDescriptor</code> <code>serviceInterface</code>. The given
	 * class must be public. If it is a nested class, it also has to be static.
	 * Anonymous classes won't work.
	 * 
	 * @param languageDescriptor
	 * @param serviceInterface
	 * @param serviceClass
	 * @return
	 */
	public static void registerService(IServiceScope languageDescriptor, Class<?> serviceInterface,
			Class<?> serviceClass) {
		registerFactory(languageDescriptor, new GenericServiceFactory(serviceInterface, serviceClass));
	}

	/**
	 * Registers a factory for the given <code>serviceClass</code> to the
	 * <code>languageDescriptor</code> <code>serviceInterface</code>. The given
	 * class must be public. If it is a nested class, it also has to be static.
	 * Anonymous classes won't work.
	 * 
	 * @param languageDescriptor
	 * @param serviceInterface
	 * @param serviceClass
	 * @param priority
	 * @return
	 */
	public static void registerService(IServiceScope languageDescriptor, Class<?> serviceInterface,
			Class<?> serviceClass, int priority) {
		registerFactory(languageDescriptor, new GenericServiceFactory(serviceInterface, serviceClass), priority);
	}

	public static void registerFactory(IServiceScope languageDescriptor, IServiceFactory factory) {
		registerFactory(languageDescriptor, factory, PRIORITY_NORMAL);
	}

	private static <T extends Object> T internalGetService(IServiceScope currentScope, Class<T> serviceInterface) {
		return internalGetService(currentScope, currentScope, serviceInterface);
	}

	@SuppressWarnings("unchecked")
	private static <T extends Object> T internalGetService(IServiceScope currentScope,
			IServiceScope realLanguageDescriptor, Class<T> serviceInterface) {
		if (currentScope == null || serviceInterface == null) {
			throw new IllegalArgumentException("Neither languageDescriptor nor serviceInterface can be null");
		}
		if (!Object.class.isAssignableFrom(serviceInterface)) {
			throw new IllegalArgumentException("Annotated member's type must extend Object. Member type class: "
					+ serviceInterface + ", but should be " + Object.class + ".");
		}
		List<Entry> entries = new ArrayList<Entry>(getEntryList(currentScope));
		Collections.reverse(entries);
		Integer currPriority = null;
		T service = null;
		for (Entry e : entries) {
			if (serviceInterface.isAssignableFrom(e.factory.getServiceInterface())) {
				if (currPriority == null) {
					currPriority = e.priority;
					if (currentScope == realLanguageDescriptor && e.cachedService != null) {
						service = (T) e.cachedService;
					} else {
						service = (T) e.factory.createService();
						if (service == null)
							return null;
						if (currentScope == realLanguageDescriptor) {
							e.cachedService = service;
						} else {
							addEntry(realLanguageDescriptor, e, service);
						}
						injectServices(realLanguageDescriptor, service);
					}
				} else {
					if (e.priority == currPriority) {
						logger.error("Mutliple service factories for type " + serviceInterface.getName()
								+ " in scope " + realLanguageDescriptor.getId());
					}
					return service;
				}
			}
		}
		if (service != null)
			return service;
		if (currentScope.getParentScope() == null)
			return null;
		return internalGetService(currentScope.getParentScope(), realLanguageDescriptor, serviceInterface);

	}

	private static void addEntry(IServiceScope realLanguageDescriptor, Entry e, Object service) {
		Entry newe = new Entry();
		newe.priority = e.priority;
		newe.factory = e.factory;
		newe.cachedService = service;
		List<Entry> entryList = getEntryList(realLanguageDescriptor);
		entryList.add(newe);
		Collections.sort(entryList);
	}

	private static IServiceFactory registerFactory(IServiceScope languageDescriptor,
			Class<? extends Object> serviceInterface, IServiceFactory serviceFactory, int priority) {
		if (isFrozen) {
			throw new IllegalStateException(
					"No more service registrations allowed after first service has been looked up");
		}
		if (languageDescriptor == null || serviceFactory == null) {
			throw new IllegalArgumentException("Neither languageDescriptor nor service can be null");
		}
		List<Entry> entries = getEntryList(languageDescriptor);
		synchronized (entryMap) {
			Entry newEntry = new Entry();
			newEntry.priority = priority;
			newEntry.factory = serviceFactory;
			if (entries.contains(newEntry)) {
				throw new IllegalStateException("A service factory for '"
						+ serviceFactory.getServiceInterface().getName() + " with priority " + priority
						+ " has already been registered!");
			}
			entries.add(newEntry);
			Collections.sort(entries);
		}
		return null;
	}

	private static List<Entry> getEntryList(IServiceScope languageDescriptor) {
		List<Entry> entries = entryMap.get(languageDescriptor);
		if (entries == null) {
			entries = new ArrayList<Entry>();
			entryMap.put(languageDescriptor, entries);
		}
		return entries;
	}

	private static void injectDependencies(IServiceScope languageDescriptor, Object patient)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException,
			NoSuchMethodException {
		Class<?> patientsClass = patient.getClass();
		do {
			injectServicesForClass(languageDescriptor, patient, patientsClass);
			patientsClass = patientsClass.getSuperclass();
		} while (patientsClass != null);
		Class<?>[] interfaces = patient.getClass().getInterfaces();
		for (Class<?> implementedInterface : interfaces) {
			injectServicesForClass(languageDescriptor, patient, implementedInterface);
		}
	}

	private static void injectServicesForClass(IServiceScope languageDescriptor, Object patient, Class<?> inspectedClass)
			throws IllegalAccessException, InvocationTargetException {
		Field[] fields = inspectedClass.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Inject.class)) {
				field.setAccessible(true);
				if (IServiceScope.class.equals(field.getType())) {
					field.set(patient, languageDescriptor);
				} else {
					Object injectedService = internalGetService(languageDescriptor, field.getType());
					if (injectedService == null && !field.getAnnotation(Inject.class).optional())
						throw new IllegalStateException("No component found for non-optional dependency "
								+ field + ".");
					field.set(patient, injectedService);
				}
			}
		}

		Method[] methods = inspectedClass.getDeclaredMethods();
		for (Method method : methods) {
			Class<?>[] parameterTypes = method.getParameterTypes();
			if (parameterTypes.length != 1 && method.isAnnotationPresent(Inject.class)) {
				throw new IllegalArgumentException("Annotated method " + method.toGenericString()
						+ " must have exactly one parameter");
			}
			if (parameterTypes.length == 1 && method.isAnnotationPresent(Inject.class)) {
				method.setAccessible(true);
				if (IServiceScope.class.equals(parameterTypes[0])) {
					method.invoke(patient, languageDescriptor);
				} else {
					Object injectedService = internalGetService(languageDescriptor, parameterTypes[0]);
					if (injectedService == null && !method.getAnnotation(Inject.class).optional())
						throw new IllegalStateException("No component found for non-optional dependency " + method
								+ ".");
					method.invoke(patient, injectedService);
				}
			}
		}
	}

	/**
	 * For test purposes only.
	 */
	public static void resetInternal() {
		synchronized (entryMap) {
			entryMap.clear();
			isFrozen = false;
		}
	}

	// public static void dump() {
	// Set<ServiceKey> keySet = entryMap.keySet();
	// for (ServiceKey pair : keySet) {
	// logger.debug(pair.getFirstElement() + " " +
	// pair.getSecondElement().getSimpleName());
	// }
	// }

}
