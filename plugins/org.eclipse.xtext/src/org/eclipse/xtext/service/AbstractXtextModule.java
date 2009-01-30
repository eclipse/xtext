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
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Sven Efftinge
 */
public abstract class AbstractXtextModule implements Module {

	protected Logger LOG = Logger.getLogger(AbstractXtextModule.class);

	@SuppressWarnings("unchecked")
	public void configure(Binder binder) {
		Set<Pair<Class<?>,Class<?>>> bindings = getBindings();
		for (Pair<Class<?>, Class<?>> pair : bindings) {
			binder.bind((Class<Object>) pair.getFirst()).to(pair.getSecond());
		}
	}

	@SuppressWarnings("unchecked")
	public final Set<Pair<Class<?>,Class<?>>> getBindings() {
		Set<Pair<Class<?>,Class<?>>> result = new HashSet<Pair<Class<?>,Class<?>>>();
		Method[] methods = this.getClass().getMethods();
		for (Method method : methods) {
			try {
				if (method.getName().startsWith("bind") && method.getReturnType().equals(Class.class)) {
					Type returnType = method.getGenericReturnType();
					if (returnType instanceof ParameterizedType) {
						Type[] arguments = ((ParameterizedType) returnType).getActualTypeArguments();
						if (arguments[0] instanceof WildcardType) {
							WildcardType wct = (WildcardType) arguments[0];
							Class<?> key = (Class<Object>) wct.getUpperBounds()[0];
							Class<?> invoke = (Class<?>) method.invoke(this, (Object[]) null);
							if (LOG.isDebugEnabled())
								LOG.debug("Adding binding from "+key.getName()+" to "+invoke.getName()+".");
							Pair<?, ?> create = Tuples.create(key, invoke);
							result.add((Pair<Class<?>,Class<?>>)create);
						}
					}
				}
			} catch (Exception e) {
				LOG.warn("Trying to use method "+method.toGenericString()+" for configuration failed", e);
			}
		}
		return result;
	}
}
