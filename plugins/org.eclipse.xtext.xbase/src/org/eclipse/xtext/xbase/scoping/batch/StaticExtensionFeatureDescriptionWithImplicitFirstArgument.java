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
public class StaticExtensionFeatureDescriptionWithImplicitFirstArgument extends StaticExtensionFeatureDescription {

	protected StaticExtensionFeatureDescriptionWithImplicitFirstArgument(
			QualifiedName qualifiedName,
			JvmFeature feature, 
			XExpression firstArgument,
			LightweightTypeReference firstArgumentType,
			int bucketId, boolean visible) {
		super(qualifiedName, feature, firstArgument, firstArgumentType, bucketId, visible);
	}

	@Override
	/* @Nullable */
	public XExpression getSyntacticReceiver() {
		return null;
	}
	
	@Override
	/* @Nullable */
	public LightweightTypeReference getSyntacticReceiverType() {
		return null;
	}
	
	@Override
	public EnumSet<ConformanceHint> getSyntacticReceiverConformanceHints() {
		return EnumSet.noneOf(ConformanceHint.class);
	}
	
	@Override
	/* @Nullable */
	public XExpression getImplicitFirstArgument() {
		return super.getSyntacticReceiver();
	}
	
	@Override
	/* @Nullable */
	public LightweightTypeReference getImplicitFirstArgumentType() {
		return super.getSyntacticReceiverType();
	}
	
}
