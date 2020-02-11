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
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * A description that has a receiver expression which resolves to a type. The feature is considered to be a static
 * member of that type thus it is the dot-notation variant of expressions with a static qualifier, e.g.
 * {@code String::CASE_INSENSITIVE_COMPARATOR} and {@code String.CASE_INSENSITIVE_COMPARATOR} are equivalent.
 * The latter member feature call is described by a {@link StaticFeatureDescriptionWithTypeLiteralReceiver}.
 * 
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
