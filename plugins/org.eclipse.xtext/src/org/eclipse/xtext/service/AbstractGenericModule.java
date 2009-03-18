/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;
import com.google.inject.binder.AnnotatedBindingBuilder;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Sven Efftinge
 */
public abstract class AbstractGenericModule implements Module {

	private static Logger LOG = Logger.getLogger(AbstractGenericModule.class);

	@SuppressWarnings("unchecked")
	public void configure(Binder binder) {
		Set<Binding> bindings = getBindings();
		for (Binding binding : bindings) {
			if (binding.toType != null && binding.toType!= Void.TYPE) {
				AnnotatedBindingBuilder<Object> bind = binder.bind((Class<Object>) binding.from);
				if (!binding.from.equals(binding.toType)) {
					bind.to(binding.toType);
				}
				if (binding.eager) {
					bind.asEagerSingleton();
				} else if (binding.singleton) {
					bind.in(Scopes.SINGLETON);
				}
			} else {
				if (binding.toInstance != null)
					binder.bind((Class<Object>) binding.from).toInstance(binding.toInstance);
			}
		}
	}

	public final Set<Binding> getBindings() {
		Set<Binding> result = new HashSet<Binding>();
		Method[] methods = this.getClass().getMethods();
		for (Method method : methods) {
			try {
				if (method.getName().startsWith("bind")) {
					if (method.getReturnType().equals(Class.class)) {
						Type returnType = method.getGenericReturnType();
						if (returnType instanceof ParameterizedType) {
							Type[] arguments = ((ParameterizedType) returnType).getActualTypeArguments();
							Class<?> key = getClassType(arguments[0]);
							if (key != null) {
								if (!method.isAccessible())
									method.setAccessible(true);
								Class<?> invoke = (Class<?>) method.invoke(this, (Object[]) null);
								if (LOG.isTraceEnabled())
									LOG.trace("Adding binding from " + key.getName() + " to " + invoke.getName()
											+ ". Declaring Method was '" + method.toGenericString() + "' in Module "
											+ this.getClass().getName());

								result.add(new Binding(key, invoke!=null?invoke:Void.TYPE, isSingleton(method), isEager(method)));
							}
						}
					} else {
						boolean wasAccessible = method.isAccessible();
						try {
							method.setAccessible(true);
							Object object = method.invoke(this, (Object[]) null);
							result.add(new Binding(method.getReturnType(), object, isSingleton(method), isEager(method)));
						} finally {
							if (!wasAccessible)
								method.setAccessible(false);
						}
					}
				}
			} catch (Exception e) {
				LOG.warn("Trying to use method " + method.toGenericString() + " for configuration failed", e);
			}
		}
		return result;
	}

	/**
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Class<?> getClassType(Type type) {
		if (type instanceof WildcardType) {
			return (Class<Object>) ((WildcardType) type).getUpperBounds()[0];
		} else if (type instanceof Class)
			return (Class<?>) type;
		return null;
	}

	/**
	 * @param method
	 * @return
	 */
	private boolean isEager(Method method) {
		SingletonBinding binding = method.getAnnotation(SingletonBinding.class);
		if (binding != null) {
			return binding.eager();
		}
		return false;
	}

	/**
	 * @param method
	 * @return
	 */
	private boolean isSingleton(Method method) {
		return method.getAnnotation(SingletonBinding.class) != null;
	}

	public static class Binding {
		public boolean singleton = false;
		public boolean eager = false;

		public final Class<?> from;
		public Class<?> toType = null;
		public Object toInstance = null;

		public Binding(Class<?> from, Class<?> toType, boolean singleton, boolean eagerSingleton) {
			super();
			this.from = from;
			this.toType = toType;
			this.singleton = singleton;
			this.eager = eagerSingleton;
		}

		public Binding(Class<?> from, Object toInstance, boolean singleton, boolean eagerSingleton) {
			super();
			this.from = from;
			this.toInstance = toInstance;
			this.singleton = singleton;
			this.eager = eagerSingleton;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Binding))
				return false;
			Binding that = (Binding) obj;
			return (this.from == that.from) && this.toType == that.toType && this.toInstance == that.toInstance;
		}

		@Override
		public int hashCode() {
			return from.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + " from " + from.getSimpleName() + " to "
					+ (toInstance != null ? toInstance : toType.getSimpleName());
		}
	}
}
