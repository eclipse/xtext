/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class ConstructorLinkingCandidate implements IConstructorLinkingCandidate, ObservableTypeExpectation.Observer {

	private final XConstructorCall constructorCall;
	private final JvmConstructor constructor;
	private final AbstractTypeComputationState state;
	private final Map<JvmTypeParameter, JvmTypeReference> typeParameterMapping;
	
	public ConstructorLinkingCandidate(XConstructorCall constructorCall, JvmConstructor constructor, AbstractTypeComputationState state) {
		this.constructorCall = constructorCall;
		this.constructor = constructor;
		this.state = state;
		this.typeParameterMapping = Maps.newHashMap();
	}
	
	public JvmIdentifiableElement getFeature() {
		return getConstructor();
	}

	public List<XExpression> getArguments() {
		return constructorCall.getArguments();
	}

	public XConstructorCall getConstructorCall() {
		return constructorCall;
	}

	public JvmConstructor getConstructor() {
		return constructor;
	}
	
	public void accept(ObservableTypeExpectation expectation, JvmTypeReference actual, ConformanceHint conformanceHint) {
//		Map<JvmTypeParameter, JvmTypeReference> actualMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(actual);
		// TODO traverse the expectation and read the actual parameter data from the actual mapping by means of a type parameter substitutor
		JvmTypeReference expectedType = expectation.getExpectedType();
		if (expectedType == null) {
			return;
		}
		if (expectedType.getType() instanceof JvmTypeParameter) {
			typeParameterMapping.put((JvmTypeParameter) expectedType.getType(), actual);
		}
	}
	
	protected void computeArgumentTypes() {
		int declaredParameterCount = constructor.getParameters().size();
		int fixedArityParameterCount = constructor.isVarArgs() ? declaredParameterCount - 1 : declaredParameterCount;
		List<XExpression> arguments = getArguments();
		int fixedArityArgumentCount = Math.min(fixedArityParameterCount, arguments.size());
		List<StackedResolvedTypes> stackedResolvedTypes = Lists.newArrayListWithCapacity(arguments.size());
		for(int i = 0; i < fixedArityArgumentCount; i++) {
			JvmFormalParameter parameter = constructor.getParameters().get(i);
			XExpression argument = arguments.get(i);
			// TODO explicit type arguments given - don't use the parameter type but the bound value
			// TODO retry those that depend on the expectation if the expectation changes due to other computation results 
			AbstractTypeComputationState argumentState = new ObservableTypeComputationStateWithExpectation(
					state.getResolvedTypes(), state.getFeatureScopeSession(), state.getResolver(), state, parameter.getParameterType(), this);
			stackedResolvedTypes.add(argumentState.computeTypesWithoutMerge(argument));
		}
		if (constructor.isVarArgs()) {
			int lastParamIndex = declaredParameterCount - 1;
			JvmTypeReference lastParameterType = constructor.getParameters().get(lastParamIndex).getParameterType();
			if (!(lastParameterType instanceof JvmGenericArrayTypeReference))
				throw new IllegalStateException("Unexpected var arg type: " + lastParameterType);
			JvmTypeReference componentType = ((JvmGenericArrayTypeReference) lastParameterType).getComponentType();
			AbstractTypeComputationState argumentState = null;
			if (arguments.size() == declaredParameterCount) {
//				XExpression lastArgument = arguments.get(lastParamIndex);
				// TODO expect Array and componentType
				argumentState = state.fork().withExpectation(componentType);
			} else {
				argumentState = state.fork().withExpectation(componentType);
			}
			for(int i = fixedArityArgumentCount; i < arguments.size(); i++) {
				XExpression argument = arguments.get(i);
				stackedResolvedTypes.add(argumentState.computeTypesWithoutMerge(argument));
			}
		} else {
			for(int i = fixedArityArgumentCount; i < arguments.size(); i++) {
				XExpression argument = arguments.get(i);
				AbstractTypeComputationState argumentState = state.fork().withNonVoidExpectation();
				stackedResolvedTypes.add(argumentState.computeTypesWithoutMerge(argument));
			}
		}
		for(StackedResolvedTypes pending: stackedResolvedTypes) {
			pending.mergeIntoParent();
		}
	}
	
	public void apply() {
		computeArgumentTypes();
		// TODO implement argument type resolution
		state.getResolvedTypes().setLinkingInformation(constructorCall, this);
		List<ITypeExpectation> expectations = state.getImmediateExpectations();
		// TODO implement bounds / type parameter resolution
		JvmTypeReference type = getActualType();
		// TODO consider expectation when substituting the type parameters
		TypeParameterSubstitutor substitutor = new TypeParameterSubstitutor(typeParameterMapping, state.getServices());
		type = substitutor.substitute(type);
		for(ITypeExpectation expectation: expectations) {
			expectation.acceptActualType(type, ConformanceHint.UNCHECKED);
		}
	}
	
	protected JvmTypeReference[] getBoundTypeArguments() {
		List<JvmTypeReference> arguments = constructorCall.getTypeArguments();
		if (!arguments.isEmpty()) {
			return arguments.toArray(new JvmTypeReference[arguments.size()]);
		}
		// TODO use computed type references for the inferred type arguments if approriate
		return null;
	}

	protected JvmTypeReference getActualType() {
		JvmTypeReference[] typeArguments = getBoundTypeArguments();
		return state.getTypeReferences().createTypeRef(constructor.getDeclaringType(), typeArguments);
	}

}
