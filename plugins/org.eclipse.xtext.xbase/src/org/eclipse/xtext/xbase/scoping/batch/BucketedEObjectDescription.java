/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
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
@NonNullByDefault
public abstract class BucketedEObjectDescription extends EObjectDescription implements IIdentifiableElementDescription {

	private final int bucketId;
	private final boolean visible;

	protected BucketedEObjectDescription(QualifiedName qualifiedName, JvmIdentifiableElement feature, int bucketId,
			boolean visible) {
		super(qualifiedName, feature, null);
		this.bucketId = bucketId;
		this.visible = visible;
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

	@Nullable
	public LightweightTypeReference getImplicitReceiverType() {
		return null;
	}

	/**
	 * Returns the actual receiver of this (potential) feature call. It may be <code>null</code>
	 * even though there is a syntactic receiver available (in case of static features).
	 */
	@Nullable
	public XExpression getImplicitReceiver() {
		return null;
	}
	
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitReceiverTypeParameterMapping() {
		return Collections.emptyMap();
	}
	
	@Nullable
	public LightweightTypeReference getSyntacticReceiverType() {
		return null;
	}
	
	@Nullable
	public XExpression getSyntacticReceiver() {
		return null;
	}
	
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getSyntacticReceiverTypeParameterMapping() {
		return Collections.emptyMap();
	}
	
	public boolean isVisible() {
		return visible;
	}

	public boolean isStatic() {
		JvmIdentifiableElement identifiable = getElementOrProxy();
		if (identifiable instanceof JvmField)
			return ((JvmField) identifiable).isStatic();
		if (identifiable instanceof JvmOperation)
			return ((JvmOperation) identifiable).isStatic();
		return false;
	}
	
	@Override
	public String toString() {
		return getElementOrProxy().getIdentifier();
	}

	public JvmIdentifiableElement getElementOrProxy() {
		return (JvmIdentifiableElement) getEObjectOrProxy();
	}

	@Nullable
	public XExpression getImplicitFirstArgument() {
		return null;
	}

	@Nullable
	public LightweightTypeReference getImplicitFirstArgumentType() {
		return null;
	}

	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitFirstArgumentTypeParameterMapping() {
		return Collections.emptyMap();
	}

	public boolean isExtension() {
		return false;
	}

}
