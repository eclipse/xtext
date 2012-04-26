/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.ITypeResolution;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.XtypeFactory;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class TypeResolution implements ITypeResolution {

	protected Map<JvmIdentifiableElement, JvmTypeReference> types;
	protected Map<JvmIdentifiableElement, JvmTypeReference> reassignedTypes;
	protected Multimap<XExpression, TypeData> expressionTypes;
	protected Map<XExpression, ILinkingCandidate> featureLinking;
	private final DefaultReentrantTypeResolver resolver;
	
	protected TypeResolution(DefaultReentrantTypeResolver resolver) {
		this.resolver = resolver;
	}

	protected TypeConformanceComputer getTypeConformanceComputer() {
		return resolver.getConformanceComputer();
	}
	
	protected XtypeFactory getXtypeFactory() {
		return resolver.getXtypeFactory();
	}
	
	public List<Diagnostic> getQueuedDiagnostics() {
		throw new UnsupportedOperationException("TODO implement me");
	}
	
	protected TypeData getTypeData(XExpression expression, boolean returnType) {
		Collection<TypeData> values = ensureExpressionTypesMapExists().get(expression);
		if (values.isEmpty()) {
			return null;
		}
		TypeData result = mergeTypeData(expression, values, returnType);
		return result;
	}

	protected TypeData mergeTypeData(final XExpression expression, Collection<TypeData> allValues, final boolean returnType) {
		List<TypeData> values = Lists.newArrayListWithCapacity(allValues.size());
		for(TypeData value: values) {
			if (returnType == value.isReturnType()) {
				values.add(value);
			}
		}
		if (values.size() == 1) {
			TypeData typeData = values.iterator().next();
			return typeData;
		}
		final XComputedTypeReference mergedType = getXtypeFactory().createXComputedTypeReference();
		mergedType.setTypeProvider(new AbstractReentrantTypeReferenceProvider() {
			@Override
			protected JvmTypeReference doGetTypeReference() {
				Collection<TypeData> freshlyObtainedValues = ensureExpressionTypesMapExists().get(expression);
				List<JvmTypeReference> references = Lists.newArrayList();
				for(TypeData value: freshlyObtainedValues) {
					JvmTypeReference reference = value.getActualType();
					if (returnType == value.isReturnType() && isValidForMergedResult(reference, mergedType)) {
						references.add(reference);
					}
				}
				return getCommonType(references);
			}
		});
		TypeData result = new TypeData(expression, null, mergedType, ConformanceHint.MERGED, returnType);
		return result;
	}
	
	protected boolean isValidForMergedResult(JvmTypeReference reference, JvmTypeReference mayNotBe) {
		if (reference == mayNotBe || reference == null)
			return false;
		if (reference instanceof JvmDelegateTypeReference) {
			return isValidForMergedResult(((JvmDelegateTypeReference) reference).getDelegate(), mayNotBe);
		}
		if (reference instanceof JvmCompoundTypeReference) {
			List<JvmTypeReference> components = ((JvmCompoundTypeReference) reference).getReferences();
			if (components.isEmpty())
				return false;
			for(JvmTypeReference component: components) {
				if (!isValidForMergedResult(component, mayNotBe)) {
					return false;
				}
			}
		}
		if (reference instanceof JvmSpecializedTypeReference) {
			// filter reentrant, recursive type deps
			return isValidForMergedResult(((JvmSpecializedTypeReference) reference).getEquivalent(), mayNotBe);
		}
		return true;
	}

	protected JvmTypeReference getCommonType(List<JvmTypeReference> types) {
		if (types.isEmpty()) {
			return null;
		}
		if (types.size() == 1) {
			JvmTypeReference result = types.get(0);
			return result;
		}
		JvmTypeReference result = getTypeConformanceComputer().getCommonSuperType(types);
		if (result != null || types.isEmpty()) {
			return result;
		}
		// common type of JvmAnyType and JvmVoid may be null ... use JvmAnyType in that case
		for (JvmTypeReference type: types) {
			if (!resolver.getTypeReferences().is(type, Void.TYPE)) {
				return type;
			}
		}
		return types.get(0);
	}

	public JvmTypeReference getActualType(XExpression expression) {
		TypeData typeData = getTypeData(expression, false);
		if (typeData != null)
			return typeData.getActualType();
		return null;
	}

	public JvmTypeReference getExpectedType(XExpression expression) {
		TypeData typeData = getTypeData(expression, false);
		if (typeData != null)
			return typeData.getExpectation().getExpectedType();
		return null;
	}
	
	public List<JvmTypeReference> getActualTypeArguments(XExpression expression) {
		throw new UnsupportedOperationException("TODO implement me");
	}
	
	public void setType(JvmIdentifiableElement identifiable, JvmTypeReference reference) {
		ensureTypesMapExists().put(identifiable, reference);
	}
	
	public void reassignType(JvmIdentifiableElement identifiable, JvmTypeReference reference) {
		if (reference != null) {
			JvmTypeReference actualType = getActualType(identifiable);
			if (!getTypeConformanceComputer().isConformant(reference, actualType)) {
				if (getTypeConformanceComputer().isConformant(actualType, reference)) {
					ensureReassignedTypesMapExists().put(identifiable, reference);
				} else {
					JvmMultiTypeReference multiTypeReference = TypesFactory.eINSTANCE.createJvmMultiTypeReference();
					multiTypeReference.getReferences().add(EcoreUtil2.cloneIfContained(actualType));
					multiTypeReference.getReferences().add(EcoreUtil2.cloneIfContained(reference));
					ensureReassignedTypesMapExists().put(identifiable, multiTypeReference);
				}
			}
		} else {
			ensureReassignedTypesMapExists().remove(identifiable);
		}
	}
	
	public void acceptType(XExpression expression, AbstractTypeExpectation expectation, JvmTypeReference type, ConformanceHint conformanceHint, boolean returnType) {
		ensureExpressionTypesMapExists().put(expression, new TypeData(expression, expectation, type, conformanceHint, returnType));
	}

	protected Map<JvmIdentifiableElement, JvmTypeReference> ensureTypesMapExists() {
		if (types == null) {
			types = Maps.newHashMap();
		}
		return types;
	}
	
	protected Map<JvmIdentifiableElement, JvmTypeReference> ensureReassignedTypesMapExists() {
		if (reassignedTypes == null) {
			reassignedTypes = Maps.newHashMap();
		}
		return reassignedTypes;
	}
	
	protected Multimap<XExpression, TypeData> ensureExpressionTypesMapExists() {
		if (expressionTypes == null) {
			expressionTypes = HashMultimap.create(2, 2);
		}
		return expressionTypes;
	}
	
	protected Map<XExpression, ILinkingCandidate> ensureLinkingMapExists() {
		if (featureLinking == null) {
			featureLinking = Maps.newHashMap();
		}
		return featureLinking;
	}
	
	public JvmTypeReference getActualType(JvmIdentifiableElement identifiable) {
		if (reassignedTypes != null) {
			JvmTypeReference result = reassignedTypes.get(identifiable);
			if (result != null) {
				return result;
			}
		}
		if (types == null)
			return null;
		return ensureTypesMapExists().get(identifiable);
	}
	
	public IFeatureLinkingCandidate getFeature(XAbstractFeatureCall featureCall) {
		return (IFeatureLinkingCandidate) ensureLinkingMapExists().get(featureCall);
	}
	
	public IConstructorLinkingCandidate getConstructor(XConstructorCall constructorCall) {
		return (IConstructorLinkingCandidate) ensureLinkingMapExists().get(constructorCall);
	}

	public void setLinkingInformation(XExpression expression, ILinkingCandidate linkingCandidate) {
		ensureLinkingMapExists().put(expression, linkingCandidate);
	}

	protected DefaultReentrantTypeResolver getResolver() {
		return resolver;
	}
	
}
