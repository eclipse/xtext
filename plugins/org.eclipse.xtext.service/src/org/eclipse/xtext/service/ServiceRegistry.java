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
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * 
 * @author Jan Köhnlein
 * @author Dennis Hübner
 * 
 */
public class ServiceRegistry {

	private static final Logger logger = Logger.getLogger(ServiceRegistry.class);
	public static final int PRIORITY_MIN = Integer.MIN_VALUE;
	public static final int PRIORITY_NORMAL = 0;
	public static final int PRIORITY_MAX = Integer.MAX_VALUE;

	private static volatile boolean isFrozen = false;

	public static class Entry implements Comparable<Entry> {
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

		public int getPriority() {
			return priority;
		}

		public Class<?> getServiceInterface() {
			return factory.getServiceInterface();
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
		} catch (VirtualMachineError e) {
			// TODO : should be checked in advance or while resolving
			// dependencies
			if (e instanceof StackOverflowError || e instanceof OutOfMemoryError)
				throw new IllegalStateException(e.getMessage()
						+ " - might be caused by cyclic dependencies of stateful services.");
			else
				throw e;
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
						if (currentScope == realLanguageDescriptor && isServiceStateless(service)) {
							e.cachedService = service;
						} else {
							addEntry(realLanguageDescriptor, e, service);
						}
						injectServices(realLanguageDescriptor, service);
					}
				} else {
					if (e.priority == currPriority) {
						logger.error("Multiple service factories for type " + serviceInterface.getName() + " in scope "
								+ realLanguageDescriptor.getId());
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
		if (isServiceStateless(service))
			newe.cachedService = service;
		List<Entry> entryList = getEntryList(realLanguageDescriptor);
		entryList.add(newe);
		Collections.sort(entryList);
	}

	private static boolean isServiceStateless(Object service) {
		return !service.getClass().isAnnotationPresent(StatefulService.class);
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
		Collections.sort(entries, new Comparator<Entry>(){

			public int compare(Entry o1, Entry o2) {
				if (o1.factory.getServiceInterface().equals(o2.factory.getServiceInterface())) {
					return ((Integer)o1.priority).compareTo(o2.priority);
				}
				if (o1.factory.getServiceInterface().isAssignableFrom(o2.factory.getServiceInterface())) {
					return 1;
				} else {
					return -1;
				}
			}});
		return entries;
	}

	public static List<Entry> getRegisteredServices(IServiceScope languageDescriptor) {
		return new ArrayList<Entry>(getEntryList(languageDescriptor));
	}

	public static List<IServiceScope> getRegisteredScopes() {
		return new ArrayList<IServiceScope>(entryMap.keySet());
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

	abstract class ServiceDependency {

		private final Inject annotation;

		private void inject(Object patient, Object dependency) throws IllegalAccessException, InvocationTargetException {
			if (getServiceType().isInstance(dependency)) {
				injectInternal(patient, dependency);
			}
		}

		public ServiceDependency(Inject annotation) {
			if (annotation == null) {
				throw new IllegalArgumentException("Injection annotation cann't be null");
			}
			this.annotation = annotation;
		}

		protected abstract void injectInternal(Object patient, Object dependency) throws IllegalAccessException,
				InvocationTargetException;

		public boolean isOptional() {
			return annotation.optional();
		}

		public abstract Class<?> getServiceType();

		abstract public String getName();
	}

	class FieldServiceDependency extends ServiceDependency {
		private final Field field;

		public FieldServiceDependency(Field field) {
			super(field.getAnnotation(Inject.class));
			this.field = field;
		}

		@Override
		protected void injectInternal(Object patient, Object dependency) throws IllegalArgumentException,
				IllegalAccessException {
			field.set(patient, dependency);
		}

		@Override
		public String getName() {
			return field.getName();
		}

		@Override
		public Class<?> getServiceType() {
			return field.getType();
		}

	}

	class MethodServiceDependency extends ServiceDependency {
		private final Method method;

		public MethodServiceDependency(Method method) {
			super(method.getAnnotation(Inject.class));
			this.method = method;
		}

		@Override
		protected void injectInternal(Object patient, Object dependency) throws IllegalAccessException,
				InvocationTargetException {
			method.invoke(patient, dependency);
		}

		@Override
		public String getName() {
			return method.getName();
		}

		@Override
		public Class<?> getServiceType() {
			return method.getParameterTypes()[0];
		}

	}

	private static void injectServicesForClass(IServiceScope languageDescriptor, Object patient, Class<?> inspectedClass)
			throws IllegalAccessException, InvocationTargetException {
		List<ServiceDependency> dependencies = gatherDependencies(inspectedClass);
		for (ServiceDependency serviceDependency : dependencies) {
			if (IServiceScope.class.equals(serviceDependency.getServiceType())) {
				serviceDependency.inject(patient, languageDescriptor);
			} else {
				Object alreadyRegisteredService = internalGetService(languageDescriptor, serviceDependency
						.getServiceType());
				if (alreadyRegisteredService == null && !serviceDependency.isOptional())
					throw new IllegalStateException("No component found for non-optional dependency "
							+ serviceDependency.getName() + ".");
				serviceDependency.inject(patient, alreadyRegisteredService);
			}
		}

	}

	/**
	 * Gather all fields and methods that are annotated with an
	 * <code>@Inject</code>. <br>
	 * Makes them accessible if necessary
	 * 
	 * @param inspectedClass
	 * @return all fields and methods that are annotated with an
	 *         <code>@Inject</code>
	 */
	private static List<ServiceDependency> gatherDependencies(Class<?> inspectedClass) {
		List<ServiceDependency> dependencies = new ArrayList<ServiceDependency>();
		// lookup Fields
		Field[] fields = inspectedClass.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Inject.class)) {
				field.setAccessible(true);
				dependencies.add(new ServiceRegistry().new FieldServiceDependency(field));
			}
		}
		// lookup Methods
		Method[] methods = inspectedClass.getDeclaredMethods();
		for (Method method : methods) {
			Class<?>[] parameterTypes = method.getParameterTypes();
			if (parameterTypes.length != 1 && method.isAnnotationPresent(Inject.class)) {
				throw new IllegalArgumentException("Annotated method " + method.toGenericString()
						+ " must have exactly one parameter");
			}
			if (parameterTypes.length == 1 && method.isAnnotationPresent(Inject.class)) {
				method.setAccessible(true);
				dependencies.add(new ServiceRegistry().new MethodServiceDependency(method));
			}
		}
		return dependencies;
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
