/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

import com.google.inject.Binder;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.Scopes;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

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
			if (!binding.provider) {
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
			} else {
				if (binding.toType != null && binding.toType!= Void.TYPE) {
					AnnotatedBindingBuilder<Object> bind = binder.bind((Class<Object>) binding.from);
					if (!binding.from.equals(binding.toType)) {
						Class<? extends Provider<?>> providerClass = (Class<? extends Provider<?>>) binding.toType;
						bind.toProvider(providerClass);
					}
					if (binding.eager) {
						bind.asEagerSingleton();
					} else if (binding.singleton) {
						bind.in(Scopes.SINGLETON);
					}
				} else {
					if (binding.toInstance != null)
						binder.bind((Class<Object>) binding.from).toProvider((Provider<? extends Object>) binding.toInstance);
				}
			}
		}
		
		addNamedBindings(binder);
	}

	protected void addNamedBindings(Binder binder) {
		Method[] methods = this.getClass().getMethods();
		for (Method method : methods) {
			if (method.getReturnType().equals(String.class) && method.isAccessible() && method.getParameterTypes().length==0) {
				Named named = Names.named(method.getName());
				try {
					Object invoke;
					invoke = method.invoke(this);
					binder.bind(Key.get(String.class,named)).toInstance((String) invoke);
				}
				catch (Exception e) {
					LOG.error(e.getMessage(),e);
				}
			}
		}
	}

	public final Set<Binding> getBindings() {
		Set<Binding> result = new HashSet<Binding>();
		Method[] methods = this.getClass().getMethods();
		for (Method method : methods) {
			try {
				if (method.getName().startsWith("bind")) {
					Class<?> key = getReturnTypeGenericParam(Class.class, method);
					if (key != null) {
						method.setAccessible(true);
						Class<?> invoke = (Class<?>) method.invoke(this, (Object[]) null);
						if (LOG.isTraceEnabled())
							LOG.trace("Adding binding from " + key.getName() + " to " + invoke.getName()
									+ ". Declaring Method was '" + method.toGenericString() + "' in Module "
									+ this.getClass().getName());

						result.add(new Binding(key, invoke!=null?invoke:Void.TYPE, isSingleton(method), isEager(method), false));
					} else {
						method.setAccessible(true);
						Object object = method.invoke(this, (Object[]) null);
						result.add(new Binding(method.getReturnType(), object, isSingleton(method), isEager(method), false));
					}
				} else if (method.getName().startsWith("provide")) {
					Type providerType = getReturnTypeGenericParamAsType(Class.class, method);
					if (providerType != null) {
						Class<?> key = getReturnTypeGenericParam(Provider.class, providerType);
						if (key != null) {
							method.setAccessible(true);
							Class<?> invoke = (Class<?>) method.invoke(this, (Object[]) null);
							if (LOG.isTraceEnabled())
								LOG.trace("Adding binding from " + key.getName() + " to " + invoke.getName()
										+ ". Declaring Method was '" + method.toGenericString() + "' in Module "
										+ this.getClass().getName());
	
							result.add(new Binding(key, invoke!=null?invoke:Void.TYPE, isSingleton(method), isEager(method), true));
						}
					} else {
						Class<?> key = getReturnTypeGenericParam(Provider.class, method);
						if (key != null) {
							method.setAccessible(true);
							Object object = method.invoke(this, (Object[]) null);
							if (object instanceof Provider<?>)
								result.add(new Binding(key, object, isSingleton(method), isEager(method), true));
						}
					}
				}
			} catch (Exception e) {
				LOG.warn("Trying to use method " + method.toGenericString() + " for configuration failed", e);
			}
		}
		return result;
	}

	public final Class<?> getReturnTypeGenericParam(Class<?> expectedRawType, Method method) {
		Type type = getReturnTypeGenericParamAsType(expectedRawType, method);
		if (type != null)
			return getClassType(type);
		return null;
	}
	
	public final Class<?> getReturnTypeGenericParam(Class<?> expectedRawType, Type type) {
		Class<?> providerClass = getClassType(type);
		if (expectedRawType.isAssignableFrom(providerClass)) {
			Type actualType = null;
			if (type instanceof WildcardType) {
				Type upperBound = ((WildcardType) type).getUpperBounds()[0];
				if (upperBound instanceof ParameterizedType) {
					Type[] typeArguments = ((ParameterizedType) upperBound).getActualTypeArguments();
					actualType = typeArguments[0];
				} else {
 					actualType = upperBound;
				}
			} else {
				Type[] typeArguments = ((ParameterizedType) type).getActualTypeArguments();
				actualType = typeArguments[0];
			}
			Class<?> key = getClassType(actualType);
			return key;
		}
		return null;
	}
	
	public final Type getReturnTypeGenericParamAsType(Class<?> expectedRawType, Method method) {
		if (method.getReturnType().equals(expectedRawType)) {
			Type returnType = method.getGenericReturnType();
			if (returnType instanceof ParameterizedType) {
				Type[] arguments = ((ParameterizedType) returnType).getActualTypeArguments();
				return arguments[0];
			}
			return null;
		}
		return null;
	}

	private Class<?> getClassType(Type type) {
		if (type instanceof WildcardType) {
			Type upperBound = ((WildcardType) type).getUpperBounds()[0];
			if (upperBound instanceof Class<?>)
				return (Class<?>) upperBound;
			if (upperBound instanceof ParameterizedType) {
				Type rawType = ((ParameterizedType) upperBound).getRawType();
				if (rawType instanceof Class<?>)
					return (Class<?>) rawType;
			}
		} else if (type instanceof Class<?>)
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
	
	protected void bindProperties(Binder binder, String propertyFilePath) {
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream(
					propertyFilePath);
			if (in != null) {
				Properties properties = new Properties();
				properties.load(in);
				Names.bindProperties(binder, properties);
			}
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static class Binding {
		public boolean singleton = false;
		public boolean eager = false;
		public boolean provider;
		
		public final Class<?> from;
		public Class<?> toType = null;
		public Object toInstance = null;

		public Binding(Class<?> from, Class<?> toType, boolean singleton, boolean eagerSingleton, boolean provider) {
			super();
			this.from = from;
			this.toType = toType;
			this.singleton = singleton;
			this.eager = eagerSingleton;
			this.provider = provider;
		}

		public Binding(Class<?> from, Object toInstance, boolean singleton, boolean eagerSingleton, boolean provider) {
			super();
			this.from = from;
			this.toInstance = toInstance;
			this.singleton = singleton;
			this.eager = eagerSingleton;
			this.provider = provider;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Binding))
				return false;
			Binding that = (Binding) obj;
			return (this.from == that.from) && this.toType == that.toType && this.toInstance == that.toInstance && this.provider == that.provider;
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
