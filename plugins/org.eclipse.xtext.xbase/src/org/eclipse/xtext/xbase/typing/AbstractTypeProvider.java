/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import static com.google.common.collect.Sets.*;

import java.util.List;
import java.util.Set;

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

	private final PolymorphicDispatcher<JvmTypeReference> typeDispatcher = PolymorphicDispatcher.createForSingleTarget(
			"_type", this);

	protected JvmTypeReference _type(XExpression stNode) {
		throw new IllegalArgumentException("Type computation is not implemented for " + stNode);
	}

	protected CyclicHandlingSupport<XExpression> getType = new CyclicHandlingSupport<XExpression>() {

		@Override
		protected JvmTypeReference doComputation(XExpression t) {
			return typeDispatcher.invoke(t);
		}

		@Override
		protected JvmTypeReference doHandleCyclicCall(XExpression t) {
			return handleCyclicGetType(t);
		}
	};

	public JvmTypeReference getType(final XExpression expression) {
		return getType.getType(expression);
	}

	protected JvmTypeReference handleCyclicGetType(final XExpression expression) {
		return null;
	}

	private final PolymorphicDispatcher<JvmTypeReference> expectedTypeDispatcher = PolymorphicDispatcher
			.createForSingleTarget("_expectedType", 3, 3, this);

	protected JvmTypeReference _expectedType(EObject container, EReference reference, int index) {
		return null;
	}

	protected CyclicHandlingSupport<XExpression> getExpectedType = new CyclicHandlingSupport<XExpression>() {

		@Override
		protected JvmTypeReference doComputation(XExpression t) {
			Triple<EObject, EReference, Integer> triple = getContainingInfo(t);
			if (triple == null)
				return null;
			return expectedTypeDispatcher.invoke(triple.getFirst(), triple.getSecond(), triple.getThird());
		}

		@Override
		protected JvmTypeReference doHandleCyclicCall(XExpression t) {
			return handleCycleGetExpectedType(t);
		}
	};

	public JvmTypeReference getExpectedType(final XExpression expression) {
		return getExpectedType.getType(expression);
	}

	protected JvmTypeReference handleCycleGetExpectedType(XExpression expression) {
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
			.createForSingleTarget("_typeForIdentifiable", this);

	protected JvmTypeReference _typeForIdentifiable(JvmIdentifiableElement stNode) {
		throw new IllegalArgumentException("Type computation is not implemented for " + stNode);
	}

	protected CyclicHandlingSupport<JvmIdentifiableElement> getTypeForIdentifiable = new CyclicHandlingSupport<JvmIdentifiableElement>() {

		@Override
		protected JvmTypeReference doComputation(JvmIdentifiableElement t) {
			return typeForIdentifiableDispatcher.invoke(t);
		}

		@Override
		protected JvmTypeReference doHandleCyclicCall(JvmIdentifiableElement t) {
			return handleCycleGetTypeForIdentifiable(t);
		}
	};

	public JvmTypeReference getTypeForIdentifiable(JvmIdentifiableElement identifiableElement) {
		return getTypeForIdentifiable.getType(identifiableElement);
	}

	protected JvmTypeReference handleCycleGetTypeForIdentifiable(JvmIdentifiableElement identifiableElement) {
		return null;
	}

	abstract static class CyclicHandlingSupport<T extends EObject> {

		private final ThreadLocal<Set<T>> ongoingComputations = new ThreadLocal<Set<T>>();

		protected Set<T> getTypeComputations() {
			Set<T> set = ongoingComputations.get();
			if (set == null) {
				set = newHashSet();
				ongoingComputations.set(set);
			}
			return set;
		}

		public JvmTypeReference getType(final T t) {
			if (t == null)
				return null;
			if (t.eIsProxy())
				return null;
			Set<T> computations = getTypeComputations();
			if (computations.add(t)) {
				try {
					return doComputation(t);
				} finally {
					computations.remove(t);
				}
			} else {
				return doHandleCyclicCall(t);
			}
		}

		protected abstract JvmTypeReference doComputation(T t);

		protected abstract JvmTypeReference doHandleCyclicCall(T t);
	}

}
