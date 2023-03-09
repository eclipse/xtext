/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InstanceExtensionDescription extends InstanceFeatureDescription {

	private final XExpression firstArgument;
	private final LightweightTypeReference firstArgumentType;
	private final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> firstArgumentTypeParameterMapping;
	private final int firstArgumentConformanceFlags;
	private final boolean validStaticState;

	protected InstanceExtensionDescription(
			QualifiedName qualifiedName, 
			JvmFeature feature,
			XExpression receiver,
			LightweightTypeReference receiverType,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping,
			int receiverConformanceFlags,
			XExpression firstArgument,
			LightweightTypeReference firstArgumentType,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> firstArgumentTypeParameterMapping,
			int firstArgumentConformanceFlags,
			int bucketId,
			boolean visible,
			boolean validStaticState) {
		super(qualifiedName, feature, EcoreUtil.copy(receiver), receiverType, typeParameterMapping, receiverConformanceFlags, bucketId, visible);
		this.firstArgument = firstArgument;
		this.firstArgumentType = firstArgumentType;
		this.firstArgumentTypeParameterMapping = firstArgumentTypeParameterMapping;
		this.firstArgumentConformanceFlags = firstArgumentConformanceFlags;
		this.validStaticState = validStaticState;
	}
	
	@Override
	public boolean isExtension() {
		return true;
	}
	
	@Override
	/* @Nullable */
	public XExpression getImplicitReceiver() {
		return super.getSyntacticReceiver();
	}
	
	@Override
	/* @Nullable */
	public LightweightTypeReference getImplicitReceiverType() {
		return super.getSyntacticReceiverType();
	}

	@Override
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitReceiverTypeParameterMapping() {
		return super.getSyntacticReceiverTypeParameterMapping();
	}
	
	@Override
	public int getImplicitReceiverConformanceFlags() {
		return super.getSyntacticReceiverConformanceFlags();
	}
	
	@Override
	/* @Nullable */
	public XExpression getSyntacticReceiver() {
		return firstArgument;
	}
	
	@Override
	/* @Nullable */
	public LightweightTypeReference getSyntacticReceiverType() {
		return firstArgumentType;
	}
	
	@Override
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getSyntacticReceiverTypeParameterMapping() {
		return firstArgumentTypeParameterMapping;
	}
	
	@Override
	public int getSyntacticReceiverConformanceFlags() {
		return firstArgumentConformanceFlags;
	}

	@Override
	public boolean isValidStaticState() {
		return validStaticState;
	}
}
