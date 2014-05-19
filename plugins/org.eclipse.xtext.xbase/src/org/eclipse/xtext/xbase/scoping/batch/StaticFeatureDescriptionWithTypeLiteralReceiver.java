/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StaticFeatureDescriptionWithTypeLiteralReceiver extends StaticFeatureDescriptionWithSyntacticReceiver {

	public StaticFeatureDescriptionWithTypeLiteralReceiver(QualifiedName qualifiedName, JvmFeature feature, XExpression receiver,
			LightweightTypeReference receiverType, int bucketId, boolean visible) {
		super(qualifiedName, feature, receiver, receiverType, bucketId, visible);
	}

	@Override
	protected void computeShadowingKey(JvmIdentifiableElement identifiable, StringBuilder result) {
		super.computeShadowingKey(identifiable, result);
		result.append("receiverIsTypeLiteral");
	}

	@Override
	public boolean isSyntacticReceiverPossibleArgument() {
		return false;
	}
	
	@Override
	public boolean isValidStaticState() {
		return true;
	}
}
