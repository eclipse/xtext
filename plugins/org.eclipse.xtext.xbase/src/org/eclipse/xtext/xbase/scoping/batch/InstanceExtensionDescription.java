/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.EnumSet;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InstanceExtensionDescription extends InstanceFeatureDescription {

	private final XExpression firstArgument;
	private final LightweightTypeReference firstArgumentType;
	private final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> firstArgumentTypeParameterMapping;
	private final EnumSet<ConformanceHint> firstArgumentConformanceHints;

	protected InstanceExtensionDescription(
			QualifiedName qualifiedName, 
			JvmFeature feature,
			XExpression receiver,
			LightweightTypeReference receiverType,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping,
			EnumSet<ConformanceHint> receiverConformanceHints,
			XExpression firstArgument,
			LightweightTypeReference firstArgumentType,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> firstArgumentTypeParameterMapping,
			EnumSet<ConformanceHint> firstArgumentConformanceHints,
			int bucketId,
			boolean visible) {
		super(qualifiedName, feature, EcoreUtil.copy(receiver), receiverType, typeParameterMapping, receiverConformanceHints, bucketId, visible);
		this.firstArgument = firstArgument;
		this.firstArgumentType = firstArgumentType;
		this.firstArgumentTypeParameterMapping = firstArgumentTypeParameterMapping;
		this.firstArgumentConformanceHints = firstArgumentConformanceHints;
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
	public EnumSet<ConformanceHint> getImplicitReceiverConformanceHints() {
		return super.getSyntacticReceiverConformanceHints();
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
	public EnumSet<ConformanceHint> getSyntacticReceiverConformanceHints() {
		return firstArgumentConformanceHints;
	}

}
