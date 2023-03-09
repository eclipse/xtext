/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StaticFeatureDescriptionWithSyntacticReceiver extends StaticFeatureDescription {

	private XExpression receiver;
	private LightweightTypeReference receiverType;

	public StaticFeatureDescriptionWithSyntacticReceiver(QualifiedName qualifiedName, JvmFeature feature, 
			XExpression receiver, LightweightTypeReference receiverType,
			int bucketId, boolean visible) {
		super(qualifiedName, feature, bucketId, visible);
		this.receiver = receiver;
		this.receiverType = receiverType;
	}
	
	@Override
	public XExpression getSyntacticReceiver() {
		return receiver;
	}
	
	@Override
	public LightweightTypeReference getSyntacticReceiverType() {
		return receiverType;
	}
	
	@Override
	public boolean isValidStaticState() {
		return receiverType == null;
	}

}
