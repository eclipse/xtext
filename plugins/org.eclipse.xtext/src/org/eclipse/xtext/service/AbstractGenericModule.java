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

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Sven Efftinge
 */
public abstract class AbstractGenericModule implements Module {

	protected Logger LOG = Logger.getLogger(AbstractGenericModule.class);

	@SuppressWarnings("unchecked")
	public void configure(Binder binder) {
		Set<Binding> bindings = getBindings();
		for (Binding binding : bindings) {
			if (binding.toType != null) {
				binder.bind((Class<Object>) binding.from).to(binding.toType);
			} else {
				binder.bind((Class<Object>) binding.from).toInstance(binding.toInstance);
			}
		}
	}

	@SuppressWarnings("unchecked")
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
							if (arguments[0] instanceof WildcardType) {
								WildcardType wct = (WildcardType) arguments[0];
								Class<?> key = (Class<Object>) wct.getUpperBounds()[0];
								Class<?> invoke = (Class<?>) method.invoke(this, (Object[]) null);
								if (LOG.isDebugEnabled())
									LOG.debug("Adding binding from " + key.getName() + " to " + invoke.getName() + ". Declaring Method was '"+method.toGenericString()+"' in Module "+this.getClass().getName());
								result.add(new Binding(key, invoke));
							}
						}
					} else {
						Object object = method.invoke(this, (Object[]) null);
						result.add(new Binding(method.getReturnType(), object));
					}
				}
			} catch (Exception e) {
				LOG.warn("Trying to use method " + method.toGenericString() + " for configuration failed", e);
			}
		}
		return result;
	}

	static class Binding {
		public final Class<?> from;
		public Class<?> toType = null;
		public Object toInstance = null;

		Binding(Class<?> from, Class<?> toType) {
			super();
			this.from = from;
			this.toType = toType;
		}

		Binding(Class<?> from, Object toInstance) {
			super();
			this.from = from;
			this.toInstance = toInstance;
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
	}
}
