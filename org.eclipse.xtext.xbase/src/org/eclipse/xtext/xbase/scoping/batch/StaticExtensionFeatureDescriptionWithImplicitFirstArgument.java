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
public class StaticExtensionFeatureDescriptionWithImplicitFirstArgument extends StaticExtensionFeatureDescription {

	/**
	 * @since 2.17
	 */
	public StaticExtensionFeatureDescriptionWithImplicitFirstArgument(
			QualifiedName qualifiedName,
			JvmFeature feature, 
			XExpression firstArgument,
			LightweightTypeReference firstArgumentType,
			int bucketId,
			boolean visible) {
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
	public int getSyntacticReceiverConformanceFlags() {
		return ConformanceFlags.NONE;
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
