/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.legacy;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
class FeatureCallTypeArgumentContext implements ITypeArgumentContext {

	private XAbstractFeatureCall featureCall;
	private LightweightTypeReference receiver;
	private IBatchTypeResolver typeResolver;

	public FeatureCallTypeArgumentContext(XAbstractFeatureCall featureCall, LightweightTypeReference receiver, IBatchTypeResolver typeResolver) {
		this.featureCall = featureCall;
		this.receiver = receiver;
		this.typeResolver = typeResolver;
	}
	
	public JvmTypeReference getBoundArgument(JvmTypeParameter parameter) {
		JvmIdentifiableElement feature = featureCall.getFeature();
		if (parameter.eContainer() == feature) {
			IResolvedTypes resolveTypes = typeResolver.resolveTypes(featureCall);
			List<LightweightTypeReference> typeArguments = resolveTypes.getActualTypeArguments(featureCall);
			JvmTypeParameterDeclarator declarator = (JvmTypeParameterDeclarator) feature;
			int idx = declarator.getTypeParameters().indexOf(parameter);
			if (idx < typeArguments.size()) {
				LightweightTypeReference bound = typeArguments.get(idx);
				JvmTypeReference result = bound.toTypeReference();
				return result;
			}
		}
		if (receiver != null) {
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(receiver);
			ITypeReferenceOwner owner = receiver.getOwner();
			StandardTypeParameterSubstitutor substitutor = new StandardTypeParameterSubstitutor(mapping, owner);
			ParameterizedTypeReference original = new ParameterizedTypeReference(owner, parameter);
			JvmTypeReference result = substitutor.substitute(original).toTypeReference();
			return result;
		}
		return null;
	}

	public JvmTypeReference getLowerBound(JvmTypeReference reference) {
		throw new UnsupportedOperationException();
	}

	public JvmTypeReference getUpperBound(JvmTypeReference element, Notifier context) {
		throw new UnsupportedOperationException();
	}

	public JvmTypeReference resolve(JvmTypeReference reference) {
		throw new UnsupportedOperationException();
	}

	public boolean isRawTypeContext() {
		throw new UnsupportedOperationException();
	}

}
