/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class QualifiedThisOrSuperDescription extends BucketedEObjectDescription {

	private XExpression receiver;
	private LightweightTypeReference typeReference;

	public QualifiedThisOrSuperDescription(QualifiedName qualifiedName, LightweightTypeReference typeReference, int bucketId, boolean visible, XExpression receiver) {
		super(qualifiedName, typeReference.getType(), bucketId, visible);
		this.typeReference = typeReference;
		this.receiver = receiver;
	}

	@Override
	public boolean isStatic() {
		return false;
	}

	@Override
	public boolean isExtension() {
		return false;
	}
	
	@Override
	protected void computeShadowingKey(JvmIdentifiableElement identifiable, StringBuilder result) {
		super.computeShadowingKey(identifiable, result);
		result.append("qualifiedThis");
	}
	
	@Override
	public boolean isSyntacticReceiverPossibleArgument() {
		return false;
	}
	
	@Override
	/* @Nullable */
	public LightweightTypeReference getSyntacticReceiverType() {
		return typeReference;
	}
	
	@Override
	public XExpression getSyntacticReceiver() {
		return receiver;
	}
	
	@Override
	public boolean isValidStaticState() {
		return true;
	}
}
