/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.access.impl.ClassFinder;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JavaReflectAccess {

	private final static Logger log = Logger.getLogger(JavaReflectAccess.class);

	private ClassLoader classLoader = getClass().getClassLoader();

	private ClassFinder classFinder;

	@Inject(optional = true)
	public void setClassLoader(ClassLoader classLoader) {
		if (classLoader != this.classLoader) {
			this.classLoader = classLoader;
			classFinder = null;
		}
	}

	/**
	 * @return the {@link java.lang.reflect.Field} corresponding to the given {@link JvmField} or <code>null</code>.
	 */
	public Field getField(JvmField field) {
		Class<?> class1 = getRawType(field.getDeclaringType());
		if (class1 == null)
			return null;
		try {
			return class1.getDeclaredField(field.getSimpleName());
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * @return the {@link Method} corresponding to the given {@link JvmOperation} or <code>null</code>.
	 */
	public Method getMethod(JvmOperation operation) {
		Class<?> declaringType = getRawType(operation.getDeclaringType());
		if (declaringType == null)
			return null;
		Class<?>[] paramTypes = getParamTypes(operation);
		try {
			return declaringType.getDeclaredMethod(operation.getSimpleName(), paramTypes);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * @return the {@link Constructor} corresponding to the given {@link JvmConstructor} or <code>null</code>.
	 */
	public Constructor<?> getConstructor(JvmConstructor constructor) {
		Class<?> declaringType = getRawType(constructor.getDeclaringType());
		if (declaringType == null)
			return null;
		Class<?>[] paramTypes = getParamTypes(constructor);
		try {
			return declaringType.getDeclaredConstructor(paramTypes);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * @return the {@link Class} corresponding to the given {@link JvmType} or <code>null</code>.
	 */
	public Class<?> getRawType(JvmType type) {
		if (type.eIsProxy()) {
			throw new IllegalStateException("Cannot resolve proxy: " + EcoreUtil.getURI(type));
		}
		if (type instanceof JvmArrayType) {
			JvmType componentType = ((JvmArrayType) type).getComponentType();
			Class<?> componentClass = getRawType(componentType);
			try {
				return getClassFinder().forName(componentClass.getName() + "[]");
			} catch (ClassNotFoundException e) {
				if (log.isDebugEnabled())
					log.debug(e.getMessage(), e);
				return null;
			}
		}
		if (type instanceof JvmTypeParameter) {
			JvmTypeParameter tp = (JvmTypeParameter) type;
			EList<JvmTypeConstraint> constraints = tp.getConstraints();
			for (JvmTypeConstraint jvmTypeConstraint : constraints) {
				if (jvmTypeConstraint instanceof JvmUpperBound) {
					return getRawType(jvmTypeConstraint.getTypeReference());
				}
			}
			return Object.class;
		}
		try {
			return getClassFinder().forName(type.getIdentifier());
		} catch (ClassNotFoundException e) {
			if (log.isDebugEnabled())
				log.debug(e.getMessage(), e);
		}
		return null;
	}

	protected Class<?>[] getParamTypes(JvmExecutable exe) {
		List<JvmFormalParameter> parameters = exe.getParameters();
		List<Class<?>> result = Lists.newArrayList();
		for (JvmFormalParameter p : parameters) {
			result.add(getRawType(p.getParameterType()));
		}
		return result.toArray(new Class<?>[result.size()]);
	}

	private Class<?> getRawType(JvmTypeReference ref) {
		Class<?> result = getRawType(ref.getType());
		return result;
	}

	public ClassFinder getClassFinder() {
		if (classFinder == null)
			classFinder = new ClassFinder(classLoader);
		return classFinder;
	}

}
