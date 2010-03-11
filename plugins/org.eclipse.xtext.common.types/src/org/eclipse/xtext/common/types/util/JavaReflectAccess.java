/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.access.impl.Primitives;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JavaReflectAccess {

	private final static Logger log = Logger.getLogger(JavaReflectAccess.class);

	private ClassLoader classLoader = getClass().getClassLoader();

	@Inject(optional=true)
	public void setClassLoader(ClassLoader classlaoder) {
		this.classLoader = classlaoder;
	}

	/**
	 * @return the {@link java.lang.reflect.Field} corresponding to the given {@link JvmField}
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
	 * @return the {@link Method} corresponding to the given {@link JvmExecutable}
	 */
	public Method getMethod(JvmExecutable exe) {
		Class<?> class1 = getRawType(exe.getDeclaringType());
		if (class1 == null)
			return null;
		if (exe instanceof JvmOperation) {
			Class<?>[] paramTypes = getParamTypes(exe);
			try {
				return class1.getDeclaredMethod(exe.getSimpleName(), paramTypes);
			} catch (Exception e) {
				if (log.isDebugEnabled())
					log.debug(e.getMessage(), e);
			}
		} else {
			throw new UnsupportedOperationException();
		}
		return null;
	}
	
	/**
	 * @return the {@link Class} corresponding to the given {@link JvmType}
	 */
	public Class<?> getRawType(JvmType type) {
		if (type.eIsProxy()) {
			throw new IllegalStateException("Cannot resolve proxy: " + EcoreUtil.getURI(type));
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
			if (type instanceof JvmPrimitiveType)
				return Primitives.forName(type.getCanonicalName());
			return classLoader.loadClass(type.getCanonicalName());
		} catch (ClassNotFoundException e) {
			if (log.isDebugEnabled())
				log.debug(e.getMessage(), e);
		}
		return null;
	}

	private Class<?>[] getParamTypes(JvmExecutable exe) {
		EList<JvmFormalParameter> parameters = ((JvmOperation) exe).getParameters();
		List<Class<?>> result = Lists.newArrayList();
		for (JvmFormalParameter p : parameters) {
			result.add(getRawType(p.getParameterType()));
		}
		return result.toArray(new Class<?>[result.size()]);
	}

	private Class<?> getRawType(JvmTypeReference ref) {
		return getRawType(ref.getType());
	}

}
