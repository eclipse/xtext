/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.MergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameter;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameters;
import org.eclipse.xtext.xtype.XComputedTypeReference;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class StackedResolvedTypes extends ResolvedTypes {

	class StackedUnboundArgumentSubstituter extends UnboundTypeParameterPreservingSubstitutor {
		
		public StackedUnboundArgumentSubstituter(CommonTypeComputationServices services) {
			super(Collections.<JvmTypeParameter, MergedBoundTypeArgument>emptyMap(), services);
		}

		@Override
		public JvmTypeReference doVisitComputedTypeReference(XComputedTypeReference reference,
				Set<JvmTypeParameter> param) {
			if (UnboundTypeParameters.isUnboundTypeParameter(reference)) {
				XComputedTypeReference result = getServices().getXtypeFactory().createXComputedTypeReference();
				UnboundTypeParameter original = (UnboundTypeParameter) reference.getTypeProvider();
				result.setTypeProvider(getUnboundTypeParameter(original.getHandle()));
				return result;
			}
			return super.doVisitComputedTypeReference(reference, param);
		}
		
		@Override
		public JvmTypeReference substitute(JvmTypeReference original) {
			JvmTypeReference result = visit(original, Sets.<JvmTypeParameter>newHashSet());
			return result;
		}
	}
	
	private Function<JvmTypeReference, JvmTypeReference> referenceReplacer = new Function<JvmTypeReference, JvmTypeReference>() {
		public JvmTypeReference apply(JvmTypeReference original) {
			StackedUnboundArgumentSubstituter substituter = new StackedUnboundArgumentSubstituter(getResolver().getServices());
			JvmTypeReference result = substituter.substitute(original);
			return result;
		}
	};
	
	private Function<ITypeExpectation, ITypeExpectation> expectationReplacer = new Function<ITypeExpectation, ITypeExpectation>() {
		public ITypeExpectation apply(ITypeExpectation original) {
			return original;
		}
	};
	
	private final ResolvedTypes parent;
	private final Map<Object, StackedUnboundParameter> stackedUnboundParameters;

	protected StackedResolvedTypes(ResolvedTypes parent) {
		super(parent.getResolver());
		this.parent = parent;
		this.stackedUnboundParameters = Maps.newHashMap();
	}
	
	protected ResolvedTypes getParent() {
		return parent;
	}
	
	protected void mergeIntoParent() {
		for(StackedUnboundParameter unboundParameter: stackedUnboundParameters.values()) {
			unboundParameter.mergeIntoParent();
		}
		ResolvedTypes parent = getParent();
		mergeInto(parent);
	}
	

	protected void mergeInto(ResolvedTypes parent) {
		parent.ensureExpressionTypesMapExists().putAll(ensureExpressionTypesMapExists());
		parent.ensureTypesMapExists().putAll(ensureTypesMapExists());
		parent.ensureLinkingMapExists().putAll(ensureLinkingMapExists());
		mergeTypeParametersIntoParent(parent);
	}

	protected void mergeTypeParametersIntoParent(ResolvedTypes parent) {
		Map<Object, BaseUnboundTypeParameter> parentMap = parent.ensureTypeParameterMapExists();
		for(BaseUnboundTypeParameter unbound: ensureTypeParameterMapExists().values()) {
			unbound.setResolvedTypes(parent);
			if (parentMap.put(unbound.getHandle(), unbound) != null) {
				throw new IllegalStateException("Parent had already a type parameter with key: " + unbound.getHandle());
			}
		}
	}

	@Override
	protected Collection<TypeData> doGetTypeData(XExpression expression) {
		Collection<TypeData> result = super.doGetTypeData(expression);
		if (result == null) {
			result = parent.doGetTypeData(expression);
			if (result != null)
				result = replaceUnboundParameters(result);
		}
		return result;
	}
	
	protected Collection<TypeData> replaceUnboundParameters(Collection<TypeData> original) {
		return Collections2.transform(original, new Function<TypeData, TypeData>() {
			public TypeData apply(TypeData original) {
				return new TypeData(
						original.getExpression(), 
						expectationReplacer.apply(original.getExpectation()), 
						referenceReplacer.apply(original.getActualType()), 
						original.getConformanceHint(), 
						original.isReturnType());
			}
		});
	}
	
	@Override
	public JvmTypeReference getActualType(JvmIdentifiableElement identifiable) {
		JvmTypeReference result = super.getActualType(identifiable);
		if (result == null) {
			result = parent.getActualType(identifiable);
		}
		return result;
	}
	
	@Override
	public List<JvmTypeReference> getActualTypeArguments(XExpression expression) {
		List<JvmTypeReference> result = super.getActualTypeArguments(expression);
		if (result == null) {
			result = parent.getActualTypeArguments(expression);
		}
		return result;
	}
	
	@Override
	public IFeatureLinkingCandidate getFeature(XAbstractFeatureCall featureCall) {
		IFeatureLinkingCandidate result = super.getFeature(featureCall);
		if (result == null) {
			result = parent.getFeature(featureCall);
		}
		return result;
	}
	
	@Override
	public IConstructorLinkingCandidate getConstructor(XConstructorCall constructorCall) {
		IConstructorLinkingCandidate result = super.getConstructor(constructorCall);
		if (result == null) {
			result = parent.getConstructor(constructorCall);
		}
		return result;
	}
	
	@Override
	public void reassignType(JvmIdentifiableElement identifiable, JvmTypeReference reference) {
		super.reassignType(identifiable, reference);
		if (reference == null) {
			getParent().reassignType(identifiable, reference);
		}
	}
	
	@Override
	public List<Diagnostic> getQueuedDiagnostics() {
		List<Diagnostic> result = Lists.newArrayList(super.getQueuedDiagnostics());
		result.addAll(parent.getQueuedDiagnostics());
		return result;
	}
	
	@Override
	@NonNull
	protected BaseUnboundTypeParameter getUnboundTypeParameter(@NonNull Object handle) {
		BaseUnboundTypeParameter result = super.ensureTypeParameterMapExists().get(handle);
		if (result == null) {
			result = stackedUnboundParameters.get(handle);
			if (result == null) {
				result = parent.getUnboundTypeParameter(handle);
				StackedUnboundParameter stackedResult = new StackedUnboundParameter(result, this);
				stackedUnboundParameters.put(result.getHandle(), stackedResult);
				result = stackedResult;
			}
		}
		return result;
	}

}
