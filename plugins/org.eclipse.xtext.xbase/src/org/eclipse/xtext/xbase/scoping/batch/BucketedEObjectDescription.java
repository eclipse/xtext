/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BucketedEObjectDescription extends EObjectDescription {

	private final int bucketId;
	private final LightweightTypeReference receiverType;
	private final XExpression receiver;
	private final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping;

	public BucketedEObjectDescription(QualifiedName qualifiedName, EObject element, XExpression receiver,
			LightweightTypeReference receiverType, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping,
			int bucketId) {
		super(qualifiedName, element, null);
		this.receiver = receiver;
		this.receiverType = receiverType;
		this.receiverTypeParameterMapping = receiverTypeParameterMapping;
		this.bucketId = bucketId;
	}
	
	public BucketedEObjectDescription(QualifiedName qualifiedName, EObject element, XExpression receiver,
			LightweightTypeReference receiverType, int bucketId) {
		this(qualifiedName, element, receiver, receiverType, null, bucketId);
	}
	
	public BucketedEObjectDescription(QualifiedName qualifiedName, EObject element, int bucketId) {
		this(qualifiedName, element, null, null, null, bucketId);
	}

	public String getShadowingKey() {
		EObject object = getEObjectOrProxy();
		if (object instanceof JvmIdentifiableElement) {
			return ((JvmIdentifiableElement) object).getIdentifier();
		}
		return getName().toString();
	}
	
	public int getBucketId() {
		return bucketId;
	}

	public LightweightTypeReference getReceiverType() {
		return receiverType;
	}

	public XExpression getReceiver() {
		return receiver;
	}

	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getReceiverTypeParameterMapping() {
		return receiverTypeParameterMapping;
	}

	public boolean isExtensionDescription() {
		return receiverType != null && receiverTypeParameterMapping == null;
	}
	
	public boolean isStaticDescription() {
		return receiverType == null;
	}

}
