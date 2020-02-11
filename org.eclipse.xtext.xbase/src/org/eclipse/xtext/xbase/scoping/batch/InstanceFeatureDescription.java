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

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InstanceFeatureDescription extends BucketedEObjectDescription {

	private final XExpression receiver;
	private final LightweightTypeReference receiverType;
	private final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping;
	private final int receiverConformanceFlags;

	protected InstanceFeatureDescription(
			QualifiedName qualifiedName, 
			JvmFeature feature,
			XExpression receiver,
			LightweightTypeReference receiverType,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping,
			int receiverConformanceFlags,
			int bucketId,
			boolean visible) {
		super(qualifiedName, feature, bucketId, visible);
		if (feature.isStatic()) {
			throw new IllegalArgumentException(String.valueOf(feature));
		}
		if (receiverConformanceFlags == ConformanceFlags.NONE) {
			throw new IllegalArgumentException(String.valueOf(receiverConformanceFlags));
		}
		this.receiver = receiver;
		this.receiverType = receiverType;
		this.receiverTypeParameterMapping = receiverTypeParameterMapping;
		this.receiverConformanceFlags = receiverConformanceFlags;
	}
	
	@Override
	/* @Nullable */
	public XExpression getSyntacticReceiver() {
		return receiver;
	}
	
	@Override
	/* @Nullable */
	public LightweightTypeReference getSyntacticReceiverType() {
		return receiverType;
	}
	
	@Override
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getSyntacticReceiverTypeParameterMapping() {
		return receiverTypeParameterMapping;
	}
	
	@Override
	public int getSyntacticReceiverConformanceFlags() {
		return receiverConformanceFlags;
	}
	
	@Override
	public boolean isStatic() {
		return false;
	}
	
	@Override
	public boolean isExtension() {
		return false;
	}

}
