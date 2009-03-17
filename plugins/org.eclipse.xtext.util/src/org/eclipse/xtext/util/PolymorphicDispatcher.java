/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class PolymorphicDispatcher<RT> {

	private static Logger log = Logger.getLogger(PolymorphicDispatcher.class);
	private final List<? extends Object> targets;
	private final Function<Method, Boolean> methodFilter;
	private final Comparator<MethodDesc> comparator;

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 * 
	 */
	private final class DefaultComparator implements Comparator<MethodDesc> {
		/**
		 * 
		 */
		private final List<? extends Object> targets;

		/**
		 * @param targets
		 */
		private DefaultComparator(List<? extends Object> targets) {
			this.targets = targets;
		}

		public int compare(MethodDesc o1, MethodDesc o2) {
			List<Class<?>> paramTypes1 = Arrays.asList(o1.getParameterTypes());
			List<Class<?>> paramTypes2 = Arrays.asList(o2.getParameterTypes());

			// sort by number of parameters
			if (paramTypes1.size() > paramTypes2.size())
				return 1;
			if (paramTypes2.size() > paramTypes1.size())
				return -1;

			// sort by parameter types from left to right
			for (int i = 0; i < paramTypes1.size(); i++) {
				Class<?> class1 = paramTypes1.get(i);
				Class<?> class2 = paramTypes2.get(i);

				if (class1.isAssignableFrom(class2))
					return 1;
				if (class2.isAssignableFrom(class1))
					return -1;
			}

			// sort by declaring class (more specific comes first).
			if (!o1.getDeclaringClass().equals(o2.getDeclaringClass())) {
				if (o1.getDeclaringClass().isAssignableFrom(o2.getDeclaringClass()))
					return 1;
				if (o2.getDeclaringClass().isAssignableFrom(o1.getDeclaringClass()))
					return -1;
			}

			// sort by target
			return ((Integer) targets.indexOf(o1.target)).compareTo(targets.indexOf(o2.target));
		}
	}

	public static interface ErrorHandler<P> {
		P handle(Exception e);
	}

	private ErrorHandler<RT> handler = new ErrorHandler<RT>() {

		public RT handle(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	};

	public PolymorphicDispatcher(final String methodName, final Object... targets) {
		this(methodName, Arrays.asList(targets));
	}

	public PolymorphicDispatcher(final String methodName, final List<? extends Object> targets) {
		this(methodName, 1, 1, targets);
	}

	public PolymorphicDispatcher(final String methodName, final int minParams, final int maxParams,
			final List<? extends Object> targets) {
		this.methodFilter = new Function<Method, Boolean>() {
			public Boolean exec(Method param) {
				return param.getName().equals(methodName) && param.getParameterTypes().length >= minParams
						&& param.getParameterTypes().length <= maxParams;
			}
		};
		this.targets = targets;
		this.comparator = new DefaultComparator(targets);
	}

	public PolymorphicDispatcher(List<? extends Object> targets, Function<Method, Boolean> methodFilter,
			Comparator<MethodDesc> comparator, ErrorHandler<RT> handler) {
		super();
		this.targets = targets;
		this.methodFilter = methodFilter;
		this.comparator = comparator;
		this.handler = handler;
	}

	static class MethodDesc {
		private Object target;
		private Method method;

		private MethodDesc(Object target, Method method) {
			super();
			this.target = target;
			this.method = method;
		}

		public Class<?> getDeclaringClass() {
			return method.getDeclaringClass();
		}

		public Class<?>[] getParameterTypes() {
			return method.getParameterTypes();
		}

		public Method getMethod() {
			return method;
		}

		public Object getTarget() {
			return target;
		}

		/**
		 * @param param
		 * @return
		 */
		public boolean isInvokeable(Object[] param) {
			if (getParameterTypes().length != param.length)
				return false;
			for (int i = 0; i < param.length; i++) {
				if (!getParameterTypes()[i].isInstance(param[i]))
					return false;
			}
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	public RT invoke(Object... params) {
		List<MethodDesc> list = getDeclaredMethodsOrderedBySpecificParameterType();
		Iterator<MethodDesc> iterator = list.iterator();
		while (iterator.hasNext()) {
			MethodDesc methodDesc = iterator.next();
			if (methodDesc.isInvokeable(params)) {
				// check if ambiguous
				if (iterator.hasNext()) {
					MethodDesc next = iterator.next();
					if (comparator.compare(methodDesc, next) == 0 && next.isInvokeable(params)) {
						throw new IllegalStateException("Ambiguous methods " + methodDesc.method + " and "
								+ next.method + " for params " + Arrays.toString(params));
					}
				}
				try {
					return (RT) methodDesc.method.invoke(methodDesc.target, params);
				} catch (IllegalArgumentException e) {
					return handler.handle(e);
				} catch (IllegalAccessException e) {
					return handler.handle(e);
				} catch (InvocationTargetException e) {
					return handler.handle(e);
				} catch (RuntimeException e) {
					return handler.handle(e);
				}
			}
		}
		return handler.handle(new NoSuchMethodException("Couldn't find appropriate method for objects "
				+ Arrays.toString(params)));
	}

	private List<MethodDesc> cachedDescriptors;

	private List<MethodDesc> getDeclaredMethodsOrderedBySpecificParameterType() {
		if (cachedDescriptors != null)
			return cachedDescriptors;
		cachedDescriptors = new ArrayList<MethodDesc>();
		for (Object target : targets) {
			Class<?> current = target.getClass();
			while (current != Object.class) {
				Method[] methods = current.getDeclaredMethods();
				for (Method method : methods) {
					if (methodFilter.exec(method)) {
						cachedDescriptors.add(new MethodDesc(target, method));
					}
				}
				current = current.getSuperclass();
			}
		}
		Collections.sort(cachedDescriptors, comparator);
		return cachedDescriptors;
	}
}
