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

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
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
@NonNullByDefault
public class InstanceFeatureDescription extends BucketedEObjectDescription {

	private final XExpression receiver;
	private final LightweightTypeReference receiverType;
	private final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;
	private EnumSet<ConformanceHint> receiverConformanceHints;

	protected InstanceFeatureDescription(
			QualifiedName qualifiedName, JvmFeature feature,
			XExpression receiver, LightweightTypeReference receiverType, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping, 
			int bucketId, boolean visible, @Nullable EnumSet<ConformanceHint> receiverConformanceHints) {
		super(qualifiedName, feature, bucketId, visible);
		this.receiver = receiver;
		this.receiverType = receiverType;
		this.typeParameterMapping = typeParameterMapping;
		this.receiverConformanceHints = receiverConformanceHints;
	}
	
	@Override
	@Nullable
	public XExpression getSyntacticReceiver() {
		return receiver;
	}
	
	@Override
	@Nullable
	public LightweightTypeReference getSyntacticReceiverType() {
		return receiverType;
	}
	
	@Override
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getSyntacticReceiverTypeParameterMapping() {
		return typeParameterMapping;
	}
	
	@Override
	public boolean isStatic() {
		return ((JvmFeature) getElementOrProxy()).isStatic();
	}

	@Override
	public EnumSet<ConformanceHint> getReceiverConformanceHints() {
		if (receiverConformanceHints == null)
			return super.getReceiverConformanceHints();
		return receiverConformanceHints;
	}
}
