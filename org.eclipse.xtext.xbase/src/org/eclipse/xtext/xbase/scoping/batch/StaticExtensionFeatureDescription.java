/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StaticExtensionFeatureDescription extends BucketedEObjectDescription {

	private final XExpression argument;
	private final LightweightTypeReference argumentType;

	protected StaticExtensionFeatureDescription(
			QualifiedName qualifiedName, 
			JvmFeature feature,
			XExpression syntacticReceiver,
			LightweightTypeReference syntacticReceiverType,
			int bucketId,
			boolean visible) {
		super(qualifiedName, feature, bucketId, visible);
		if (!feature.isStatic()) {
			throw new IllegalArgumentException(String.valueOf(feature));
		}
		this.argument = syntacticReceiver;
		this.argumentType = syntacticReceiverType;
	}
	
	@Override
	/* @Nullable */
	public XExpression getSyntacticReceiver() {
		return argument;
	}
	
	@Override
	/* @Nullable */
	public LightweightTypeReference getSyntacticReceiverType() {
		return argumentType;
	}
	
	@Override
	public int getSyntacticReceiverConformanceFlags() {
		return ConformanceFlags.NONE;
	}
	
	@Override
	public boolean isExtension() {
		return true;
	}
	
	@Override
	public boolean isStatic() {
		return true;
	}

}
