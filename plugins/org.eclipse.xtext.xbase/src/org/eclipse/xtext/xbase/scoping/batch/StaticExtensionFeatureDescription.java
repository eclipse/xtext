/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.EnumSet;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
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
	public EnumSet<ConformanceHint> getSyntacticReceiverConformanceHints() {
		return EnumSet.of(ConformanceHint.UNCHECKED);
	}
	
	public boolean isExtension() {
		return true;
	}
	
	public boolean isStatic() {
		return true;
	}

}
