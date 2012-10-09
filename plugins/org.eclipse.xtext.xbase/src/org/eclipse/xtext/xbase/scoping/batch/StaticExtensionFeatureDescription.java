/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class StaticExtensionFeatureDescription extends BucketedEObjectDescription {

	private XExpression receiverOrArgument;
	private LightweightTypeReference receiverOrArgumentType;

	protected StaticExtensionFeatureDescription(
			QualifiedName qualifiedName, 
			JvmIdentifiableElement element,
			XExpression syntacticReceiver,
			LightweightTypeReference syntacticReceiverType,
			int bucketId,
			boolean visible) {
		super(qualifiedName, element, bucketId, visible);
		this.receiverOrArgument = syntacticReceiver;
		this.receiverOrArgumentType = syntacticReceiverType;
	}
	
	@Override
	@Nullable
	public XExpression getSyntacticReceiver() {
		return receiverOrArgument;
	}
	
	@Override
	@Nullable
	public LightweightTypeReference getSyntacticReceiverType() {
		return receiverOrArgumentType;
	}
	
	@Override
	public boolean isExtension() {
		return true;
	}

}
