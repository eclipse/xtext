/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

// TODO would we benefit from injection?
/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class TypeConformanceStrategySelector extends AbstractConformanceVisitor<LightweightTypeReference> {

	private final TypeConformanceComputer conformanceComputer;

	private final TypeConformanceStrategy<AnyTypeReference> anyTypeDispatcher;
	private final TypeConformanceStrategy<ArrayTypeReference> arrayTypeDispatcher;
	private final TypeConformanceStrategy<CompoundTypeReference> multiTypeDispatcher;
	private final TypeConformanceStrategy<CompoundTypeReference> synonymTypeDispatcher;
	private final TypeConformanceStrategy<ParameterizedTypeReference> parameterizedTypeDispatcher;
	private final TypeConformanceStrategy<FunctionTypeReference> functionTypeDispatcher;
	private final TypeConformanceStrategy<UnboundTypeReference> unknownTypeDispatcher;
	private final TypeConformanceStrategy<WildcardTypeReference> wildcardTypeDispatcher;

	public TypeConformanceStrategySelector(TypeConformanceComputer conformanceComputer) {
		this.conformanceComputer = conformanceComputer;
		
		anyTypeDispatcher = createAnyTypeDispatcher();
		arrayTypeDispatcher = createArrayTypeDispatcher();
		functionTypeDispatcher = createFunctionTypeDispatcher();
		multiTypeDispatcher = createMultiTypeDispatcher();
		synonymTypeDispatcher = createSynonymTypeDispatcher();
		parameterizedTypeDispatcher = createParameterizedTypeDispatcher();
		unknownTypeDispatcher = createUnboundTypeDispatcher();
		wildcardTypeDispatcher = createWildcardTypeDispatcher();
	}

	protected <T extends LightweightTypeReference> TypeConformanceComputationArgument.Internal<T> copyArgument(T t, TypeConformanceComputationArgument.Internal<LightweightTypeReference> param) {
		return TypeConformanceComputationArgument.Internal.create(t, param.rawType, param.asTypeArgument, param.allowPrimitiveConversion, param.allowPrimitiveWidening, param.unboundComputationAddsHints);
	}
	
	@Override
	protected TypeConformanceResult doVisitAnyTypeReference(AnyTypeReference reference,
			TypeConformanceComputationArgument.Internal<LightweightTypeReference> param) {
		return param.reference.accept(anyTypeDispatcher, copyArgument(reference, param));
	}

	@Override
	protected TypeConformanceResult doVisitArrayTypeReference(ArrayTypeReference reference,
			TypeConformanceComputationArgument.Internal<LightweightTypeReference> param) {
		return param.reference.accept(arrayTypeDispatcher, copyArgument(reference, param));
	}

	@Override
	protected TypeConformanceResult doVisitMultiTypeReference(CompoundTypeReference reference,
			TypeConformanceComputationArgument.Internal<LightweightTypeReference> param) {
		return param.reference.accept(multiTypeDispatcher, copyArgument(reference, param));
	}
	
	@Override
	protected TypeConformanceResult doVisitFunctionTypeReference(FunctionTypeReference reference,
			TypeConformanceComputationArgument.Internal<LightweightTypeReference> param) {
		return param.reference.accept(functionTypeDispatcher, copyArgument(reference, param));
	}

	@Override
	protected TypeConformanceResult doVisitParameterizedTypeReference(ParameterizedTypeReference reference,
			TypeConformanceComputationArgument.Internal<LightweightTypeReference> param) {
		return param.reference.accept(parameterizedTypeDispatcher, copyArgument(reference, param));
	}

	@Override
	protected TypeConformanceResult doVisitSynonymTypeReference(CompoundTypeReference reference,
			TypeConformanceComputationArgument.Internal<LightweightTypeReference> param) {
		return param.reference.accept(synonymTypeDispatcher, copyArgument(reference, param));
	}

	@Override
	protected TypeConformanceResult doVisitUnboundTypeReference(UnboundTypeReference reference,
			TypeConformanceComputationArgument.Internal<LightweightTypeReference> param) {
		return param.reference.accept(unknownTypeDispatcher, copyArgument(reference, param));
	}

	@Override
	protected TypeConformanceResult doVisitWildcardTypeReference(WildcardTypeReference reference,
			TypeConformanceComputationArgument.Internal<LightweightTypeReference> param) {
		return param.reference.accept(wildcardTypeDispatcher, copyArgument(reference, param));
	}

	protected TypeConformanceStrategy<AnyTypeReference> createAnyTypeDispatcher() {
		return new AnyTypeConformanceStrategy(conformanceComputer);
	}

	protected TypeConformanceStrategy<ArrayTypeReference> createArrayTypeDispatcher() {
		return new ArrayConformanceStrategy(conformanceComputer);
	}

	protected TypeConformanceStrategy<CompoundTypeReference> createMultiTypeDispatcher() {
		return new MultiTypeConformanceStrategy(conformanceComputer);
	}

	protected TypeConformanceStrategy<ParameterizedTypeReference> createParameterizedTypeDispatcher() {
		return new ParameterizedTypeConformanceStrategy<ParameterizedTypeReference>(conformanceComputer);
	}
	
	protected TypeConformanceStrategy<FunctionTypeReference> createFunctionTypeDispatcher() {
		return new FunctionTypeConformanceStrategy(conformanceComputer);
	}

	protected TypeConformanceStrategy<CompoundTypeReference> createSynonymTypeDispatcher() {
		return new SynonymConformanceStrategy(conformanceComputer);
	}

	protected TypeConformanceStrategy<UnboundTypeReference> createUnboundTypeDispatcher() {
		return new UnboundConformanceStrategy(conformanceComputer);
	}

	protected TypeConformanceStrategy<WildcardTypeReference> createWildcardTypeDispatcher() {
		return new WildcardConformanceStrategy(conformanceComputer);
	}
}