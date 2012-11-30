/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class InstanceExtensionDescription extends InstanceFeatureDescription {

	private final XExpression firstArgument;
	private final LightweightTypeReference firstArgumentType;
	private final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> argumentTypeParameterMapping;

	protected InstanceExtensionDescription(QualifiedName qualifiedName, JvmIdentifiableElement feature,
			XExpression receiver, LightweightTypeReference receiverType,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping,
			XExpression firstArgument, LightweightTypeReference firstArgumentType,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> argumentTypeParameterMapping, 
			int bucketId,
			boolean visible) {
		super(qualifiedName, feature, EcoreUtil2.clone(receiver), receiverType, typeParameterMapping, bucketId, visible);
		this.firstArgument = firstArgument;
		this.firstArgumentType = firstArgumentType;
		this.argumentTypeParameterMapping = argumentTypeParameterMapping;
	}
	
	@Override
	public boolean isExtension() {
		return true;
	}
	
	@Override
	@Nullable
	public XExpression getImplicitReceiver() {
		return super.getSyntacticReceiver();
	}
	
	@Override
	@Nullable
	public LightweightTypeReference getImplicitReceiverType() {
		return super.getSyntacticReceiverType();
	}

	@Override
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitReceiverTypeParameterMapping() {
		return super.getSyntacticReceiverTypeParameterMapping();
	}
	
	@Override
	@Nullable
	public XExpression getSyntacticReceiver() {
		return firstArgument;
	}
	
	@Override
	@Nullable
	public LightweightTypeReference getSyntacticReceiverType() {
		return firstArgumentType;
	}
	
	@Override
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getSyntacticReceiverTypeParameterMapping() {
		return argumentTypeParameterMapping;
	}

}
