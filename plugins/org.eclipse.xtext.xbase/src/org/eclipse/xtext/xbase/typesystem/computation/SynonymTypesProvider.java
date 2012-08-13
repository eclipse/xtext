/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SynonymTypesProvider {
	
	@Inject
	private TypeReferences typeReferences;
	
	public static abstract class Acceptor {
		protected void accept(LightweightTypeReference synonym, ConformanceHint hint) {
			accept(synonym, EnumSet.of(hint));
		}
		protected abstract void accept(LightweightTypeReference synonym, Set<ConformanceHint> hints);
	}
	
	public void collectSynonymTypes(LightweightTypeReference type, Acceptor acceptor) {
		if (type == null || type.isPrimitiveVoid() || type.isType(Void.class)) {
			return;
		}
		if (type.isWrapper()) {
			acceptor.accept(type.getPrimitiveIfWrapperType(), ConformanceHint.UNBOXING);
		} else if (type.isPrimitive()) {
			acceptor.accept(type.getWrapperTypeIfPrimitive(), ConformanceHint.BOXING);
		}
		addArrayAndListSynonyms(type, acceptor);
	}

	protected void addArrayAndListSynonyms(LightweightTypeReference type, Acceptor acceptor) {
		if (type.isArray()) {
			LightweightTypeReference componentType = type.getComponentType();
			if (componentType != null) {
				LightweightTypeReference wrapper = componentType.getWrapperTypeIfPrimitive();
				JvmType listType = typeReferences.findDeclaredType(List.class, type.getOwner().getContextResourceSet());
				ParameterizedTypeReference listReference = new ParameterizedTypeReference(type.getOwner(), listType);
				listReference.addTypeArgument(wrapper);
				if (wrapper != componentType)
					acceptor.accept(listReference, EnumSet.of(ConformanceHint.DEMAND_CONVERSION, ConformanceHint.BOXING));
				else
					acceptor.accept(listReference, ConformanceHint.DEMAND_CONVERSION);
			}
		} else if (type.isAssignableFrom(Iterable.class)) {
			DeclaratorTypeArgumentCollector collector = new DeclaratorTypeArgumentCollector();
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> parameterMapping = collector.getTypeParameterMapping(type);
			JvmType iterableType = typeReferences.findDeclaredType(Iterable.class, type.getOwner().getContextResourceSet());
			if (iterableType instanceof JvmTypeParameterDeclarator) {
				JvmTypeParameter typeParameter = ((JvmTypeParameterDeclarator) iterableType).getTypeParameters().get(0);
				StandardTypeParameterSubstitutor substitutor = new StandardTypeParameterSubstitutor(parameterMapping, type.getOwner()) {
					@NonNullByDefault
					@Override
					protected LightweightTypeReference doVisitUnboundTypeReference(UnboundTypeReference reference,
							Object param) {
						return reference;
					}
				};
				ParameterizedTypeReference unboundTypeParameter = new ParameterizedTypeReference(type.getOwner(), typeParameter);
				LightweightTypeReference componentType = substitutor.substitute(unboundTypeParameter).getUpperBoundSubstitute();
				if (componentType.isWrapper()) {
					LightweightTypeReference primitiveComponentType = componentType.getPrimitiveIfWrapperType();
					ArrayTypeReference primitiveArray = new ArrayTypeReference(type.getOwner(), primitiveComponentType);
					acceptor.accept(primitiveArray, EnumSet.of(ConformanceHint.DEMAND_CONVERSION, ConformanceHint.UNBOXING));
				}
				ArrayTypeReference array = new ArrayTypeReference(type.getOwner(), componentType);
				acceptor.accept(array, ConformanceHint.DEMAND_CONVERSION);
			}
		}
	}
	
}
