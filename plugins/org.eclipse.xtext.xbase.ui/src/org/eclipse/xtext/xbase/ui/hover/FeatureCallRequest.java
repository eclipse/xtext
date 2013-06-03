/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.impl.FeatureCallToJavaMapping;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.typing.XbaseTypeArgumentContextProvider;

import com.google.common.collect.Lists;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
@SuppressWarnings("deprecation")
public class FeatureCallRequest extends XbaseTypeArgumentContextProvider.AbstractFeatureCallRequest {
	
	@Inject
	private ILogicalContainerProvider contextProvider;
	@Inject
	private ITypeProvider typeProvider;
	@Inject
	private FeatureCallToJavaMapping featureCallToJavaMapping;
	
	private XAbstractFeatureCall featureCall = null;
	
	public void setFeatureCall(XAbstractFeatureCall featureCall) {
		this.featureCall = featureCall;
	}

	@Override
	public JvmFeature getFeature() {
		JvmIdentifiableElement feature = featureCall.getFeature();
		return (feature instanceof JvmExecutable) ? (JvmExecutable) feature : null;
	}

	@Override
	public JvmTypeParameterDeclarator getNearestDeclarator() {
		EObject context = featureCall;
		JvmTypeParameterDeclarator result = null;
		while (context != null && result == null) {
			if (context instanceof JvmTypeParameterDeclarator) {
				result = (JvmTypeParameterDeclarator) context;
			} else {
				JvmIdentifiableElement logicalContainer = contextProvider
						.getLogicalContainer(context);
				if (logicalContainer != null) {
					context = logicalContainer;
				} else {
					context = context.eContainer();
				}
			}
		}
		return result;
	}
	
	@Override
	public JvmTypeReference getDeclaredType() {
		JvmIdentifiableElement feature = featureCall.getFeature();
		if (feature instanceof JvmOperation)
			return ((JvmOperation) feature).getReturnType();
		return null;
	}

	@Override
	public JvmTypeReference getReceiverType() {
		if(featureCall instanceof XMemberFeatureCall){
			 return typeProvider.getType(((XMemberFeatureCall) featureCall).getMemberCallTarget());
		} 
		XExpression actualReceiver = featureCallToJavaMapping.getActualReceiver(featureCall);
		final JvmTypeReference receiverType = typeProvider.getType(actualReceiver);
		return receiverType;
	}

	@Override
	public JvmTypeReference getExpectedType() {
		return typeProvider.getExpectedType(featureCall);
	}

	@Override
	public List<JvmTypeReference> getArgumentTypes() {
		final List<JvmTypeReference> argumentTypes = Lists.newArrayList();
		for (XExpression argument : featureCallToJavaMapping.getActualArguments(featureCall)) {
			argumentTypes.add(typeProvider.getType(argument));
		}
		return argumentTypes;
	}
	
	@Override
	public XAbstractFeatureCall getFeatureCall() {
		return featureCall;
	}
	
	@ImplementedBy(FeatureCallRequestProvider.class)
	public interface IFeatureCallRequestProvider {

		FeatureCallRequest get(XAbstractFeatureCall featureCall);
		
	}
}
