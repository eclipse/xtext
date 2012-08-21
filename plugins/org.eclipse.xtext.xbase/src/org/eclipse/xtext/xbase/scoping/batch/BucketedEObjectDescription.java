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
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * A description that contains some more information, e.g. on the bound
 * type parameters, the receiver or its type.
 * 
 * The bucket concept allows to properly identify ambiguous descriptions, 
 * e.g. if two descriptions from the very same bucket are matching with equal
 * confidence, the link is ambiguous and should be indicated as such.
 * 
 * A possible scenario is a conflict in the static imports where
 * two imported types have the very same static method signature, e.g.
 * {@code main(String[])}.
 * If the client tries to invoke that method without an explicitly declared receiver,
 * it should be flagged as ambiguous.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BucketedEObjectDescription extends EObjectDescription {

	private final int bucketId;
	private final LightweightTypeReference receiverType;
	private final XExpression receiver;
	private final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping;
	private final boolean visible;

	public BucketedEObjectDescription(
			QualifiedName qualifiedName, EObject element, 
			XExpression receiver, LightweightTypeReference receiverType, 
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping,
			int bucketId, boolean visible) {
		super(qualifiedName, element, null);
		this.receiver = receiver;
		this.receiverType = receiverType;
		this.receiverTypeParameterMapping = receiverTypeParameterMapping;
		this.bucketId = bucketId;
		this.visible = visible;
	}
	
	public BucketedEObjectDescription(QualifiedName qualifiedName, EObject element, XExpression receiver,
			LightweightTypeReference receiverType, int bucketId, boolean visible) {
		this(qualifiedName, element, receiver, receiverType, null, bucketId, visible);
	}
	
	public BucketedEObjectDescription(QualifiedName qualifiedName, EObject element, int bucketId, boolean visible) {
		this(qualifiedName, element, null, null, null, bucketId, visible);
	}

	public String getShadowingKey() {
		EObject object = getEObjectOrProxy();
		if (object instanceof JvmExecutable) {
			JvmExecutable executable = (JvmExecutable) object;
			StringBuilder builder = new StringBuilder(executable.getSimpleName());
			builder.append('(');
			boolean first = true;
			for(JvmFormalParameter parameter: executable.getParameters()) {
				if (!first) {
					builder.append(',');
				} else {
					first = false;
				}
				if (parameter.getParameterType() != null && parameter.getParameterType().getType() != null)
					builder.append(parameter.getParameterType().getType().getIdentifier());
				else
					builder.append("null");
			}
			builder.append(')');
			return builder.toString();
		}
		if (object instanceof JvmIdentifiableElement) {
			return ((JvmIdentifiableElement) object).getSimpleName();
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
	
	public boolean isVisible() {
		return visible;
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
	
	@Override
	public String toString() {
		EObject element = getEObjectOrProxy();
		if (element instanceof JvmIdentifiableElement) {
			return ((JvmIdentifiableElement) element).getIdentifier();
		}
		return String.valueOf(element);
	}

}
