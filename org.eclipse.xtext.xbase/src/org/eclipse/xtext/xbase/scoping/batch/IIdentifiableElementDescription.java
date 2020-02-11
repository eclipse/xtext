/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.EnumSet;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
public interface IIdentifiableElementDescription extends IEObjectDescription {

	JvmIdentifiableElement getElementOrProxy();
	
	String getShadowingKey();
	
	int getBucketId();
	
	/* @Nullable */
	LightweightTypeReference getImplicitReceiverType();

	/* @Nullable */
	XExpression getImplicitReceiver();
	
	Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitReceiverTypeParameterMapping();
	
	EnumSet<ConformanceHint> getImplicitReceiverConformanceHints();
	
	int getImplicitReceiverConformanceFlags();
	
	/* @Nullable */
	LightweightTypeReference getSyntacticReceiverType();
	
	/* @Nullable */
	XExpression getSyntacticReceiver();
	
	boolean isSyntacticReceiverPossibleArgument();
	
	Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getSyntacticReceiverTypeParameterMapping();
	
	EnumSet<ConformanceHint> getSyntacticReceiverConformanceHints();
	
	int getSyntacticReceiverConformanceFlags();
	
	/* @Nullable */
	XExpression getImplicitFirstArgument();
	
	/* @Nullable */
	LightweightTypeReference getImplicitFirstArgumentType();
	
	boolean isVisible();

	boolean isStatic();
	
	boolean isValidStaticState();
	
	boolean isTypeLiteral();
	
	boolean isAnonymousClassConstructorCall();
	
	boolean isExtension();

	int getNumberOfIrrelevantParameters();
	
	int getNumberOfParameters();
	
}
