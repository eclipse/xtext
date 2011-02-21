/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import static com.google.common.collect.Sets.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XExpression;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractTypeProvider implements ITypeProvider {

	private static final Logger logger = Logger.getLogger(AbstractTypeProvider.class);
	
	private final PolymorphicDispatcher<JvmTypeReference> typeDispatcher = PolymorphicDispatcher.createForSingleTarget(
			"_type", 2, 2, this);

	protected JvmTypeReference _type(XExpression expression, boolean rawType) {
		throw new IllegalArgumentException("Type computation is not implemented for " + expression);
	}

	protected CyclicHandlingSupport<XExpression> getType = new CyclicHandlingSupport<XExpression>() {

		@Override
		protected JvmTypeReference doComputation(XExpression t, boolean rawType) {
			return typeDispatcher.invoke(t, rawType);
		}

		@Override
		protected JvmTypeReference doHandleCyclicCall(XExpression t, boolean rawType) {
			return handleCyclicGetType(t, rawType);
		}
	};

	protected String getDebugIndentation(boolean rawType) {
		int size = getType.getOngoingComputationsSize(rawType) + getExpectedType.getOngoingComputationsSize(rawType) + getTypeForIdentifiable.getOngoingComputationsSize(rawType);
		char[] chars = new char[size];
		Arrays.fill(chars, ' ');
		return String.valueOf(chars);
	}
	
	protected <T extends EObject> JvmTypeReference doGetType(String key, T object, boolean rawType, CyclicHandlingSupport<T> typeComputer) {
		String debugIndentation = null;
		if (logger.isDebugEnabled()) {
			debugIndentation = getDebugIndentation(rawType);
			if (debugIndentation.length() == 0) {
				StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
				for(StackTraceElement element: stackTrace) {
					if (!element.isNativeMethod() && !AbstractTypeProvider.class.getName().equals(element.getClassName())) {
						logger.debug(debugIndentation + key + "(" + (rawType ? "raw" : "parameterized") + ") : " + element);
						break;
					}
				}
			}
			logger.debug(debugIndentation + key + ": " + object);
		}
		JvmTypeReference result = typeComputer.getType(object, rawType);
		if (logger.isDebugEnabled()) {
			logger.debug(debugIndentation + "result: " + result + " " + key + "(" + (rawType ? "raw" : "parameterized") + ") : " + object);
		}
		return result;
	}
	
	public JvmTypeReference getType(final XExpression expression) {
		return getType(expression, false);
	}
	
	public JvmTypeReference getType(final XExpression expression, boolean rawType) {
		return doGetType("getType", expression, rawType, getType);
	}

	protected JvmTypeReference handleCyclicGetType(final XExpression expression, boolean rawType) {
		return null;
	}

	private final PolymorphicDispatcher<JvmTypeReference> expectedTypeDispatcher = PolymorphicDispatcher
			.createForSingleTarget("_expectedType", 4, 4, this);

	protected JvmTypeReference _expectedType(EObject container, EReference reference, int index, boolean rawType) {
		return null;
	}

	protected CyclicHandlingSupport<XExpression> getExpectedType = new CyclicHandlingSupport<XExpression>() {

		@Override
		protected JvmTypeReference doComputation(XExpression t, boolean rawType) {
			Triple<EObject, EReference, Integer> triple = getContainingInfo(t);
			if (triple == null)
				return null;
			return expectedTypeDispatcher.invoke(triple.getFirst(), triple.getSecond(), triple.getThird(), rawType);
		}

		@Override
		protected JvmTypeReference doHandleCyclicCall(XExpression t, boolean rawType) {
			return handleCycleGetExpectedType(t, rawType);
		}
	};
	
	public JvmTypeReference getExpectedType(final XExpression expression) {
		return getExpectedType(expression, false);
	}
	
	public JvmTypeReference getExpectedType(final XExpression expression, boolean rawType) {
		return doGetType("getExpectedType", expression, rawType, getExpectedType);
	}

	protected JvmTypeReference handleCycleGetExpectedType(XExpression expression, boolean rawType) {
		return null;
	}

	protected Triple<EObject, EReference, Integer> getContainingInfo(XExpression obj) {
		if (obj == null)
			return null;
		if (obj.eIsProxy())
			return null;
		EReference containmentReference = obj.eContainmentFeature();
		if (containmentReference == null)
			return null;
		EObject container = obj.eContainer();
		int index = (containmentReference.isMany()) ? ((List<?>) container.eGet(containmentReference)).indexOf(obj)
				: -1;
		Triple<EObject, EReference, Integer> triple = Tuples.create(container, containmentReference, index);
		return triple;
	}

	private final PolymorphicDispatcher<JvmTypeReference> typeForIdentifiableDispatcher = PolymorphicDispatcher
			.createForSingleTarget("_typeForIdentifiable", 2, 2, this);

	protected JvmTypeReference _typeForIdentifiable(JvmIdentifiableElement identifiable, boolean rawType) {
		throw new IllegalArgumentException("Type computation is not implemented for " + identifiable);
	}

	protected CyclicHandlingSupport<JvmIdentifiableElement> getTypeForIdentifiable = new CyclicHandlingSupport<JvmIdentifiableElement>() {

		@Override
		protected JvmTypeReference doComputation(JvmIdentifiableElement t, boolean rawType) {
			return typeForIdentifiableDispatcher.invoke(t, rawType);
		}

		@Override
		protected JvmTypeReference doHandleCyclicCall(JvmIdentifiableElement t, boolean rawType) {
			return handleCycleGetTypeForIdentifiable(t, rawType);
		}
	};

	public JvmTypeReference getTypeForIdentifiable(JvmIdentifiableElement identifiableElement) {
		return getTypeForIdentifiable(identifiableElement, false);
	}
	
	public JvmTypeReference getTypeForIdentifiable(JvmIdentifiableElement identifiableElement, boolean rawType) {
		return doGetType("getTypeForIdentifiable", identifiableElement, rawType, getTypeForIdentifiable);
	}

	protected JvmTypeReference handleCycleGetTypeForIdentifiable(JvmIdentifiableElement identifiableElement, boolean rawType) {
		return null;
	}

	abstract static class CyclicHandlingSupport<T extends EObject> {

		private final ThreadLocal<Set<T>> ongoingComputations = new ThreadLocal<Set<T>>();
		private final ThreadLocal<Set<T>> ongoingRawTypeComputations = new ThreadLocal<Set<T>>();

		protected Set<T> getTypeComputations(boolean rawType) {
			ThreadLocal<Set<T>> computations = rawType ? ongoingRawTypeComputations : ongoingComputations;
			Set<T> set = computations.get();
			if (set == null) {
				set = newHashSet();
				computations.set(set);
			}
			return set;
		}

		public JvmTypeReference getType(final T t, boolean rawType) {
			if (t == null)
				return null;
			if (t.eIsProxy())
				return null;
			Set<T> computations = getTypeComputations(rawType);
			if (computations.add(t)) {
				try {
					return doComputation(t, rawType);
				} finally {
					computations.remove(t);
				}
			} else {
				return doHandleCyclicCall(t, rawType);
			}
		}
		
		protected int getOngoingComputationsSize(boolean rawType) {
			return getTypeComputations(rawType).size();
		}

		protected abstract JvmTypeReference doComputation(T t, boolean rawType);

		protected abstract JvmTypeReference doHandleCyclicCall(T t, boolean rawType);
	}

}
