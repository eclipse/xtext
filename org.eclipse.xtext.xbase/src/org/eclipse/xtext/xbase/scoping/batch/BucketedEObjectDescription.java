/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
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
public abstract class BucketedEObjectDescription extends EObjectDescription implements IIdentifiableElementDescription {

	private final int bucketId;
	private final boolean visible;

	protected BucketedEObjectDescription(QualifiedName qualifiedName, JvmIdentifiableElement feature, int bucketId,
			boolean visible) {
		super(qualifiedName, feature, null);
		this.bucketId = bucketId;
		this.visible = visible;
	}

	@Override
	public String getShadowingKey() {
		EObject object = getEObjectOrProxy();
		if (object instanceof JvmIdentifiableElement) {
			JvmIdentifiableElement identifiable = (JvmIdentifiableElement) object;
			StringBuilder builder = new StringBuilder(identifiable.getSimpleName());
			computeShadowingKey(identifiable, builder);
			return builder.toString();
		}
		return getName().toString() + (isVisible() ? '+' : '-');
	}

	protected void computeShadowingKey(JvmIdentifiableElement identifiable, StringBuilder result) {
		if (identifiable instanceof JvmExecutable) {
			JvmExecutable executable = (JvmExecutable) identifiable;
			result.append('(');
			boolean first = true;
			for(JvmFormalParameter parameter: executable.getParameters()) {
				if (!first) {
					result.append(',');
				} else {
					first = false;
				}
				if (parameter.getParameterType() != null && parameter.getParameterType().getType() != null)
					result.append(parameter.getParameterType().getType().getIdentifier());
				else
					result.append("null");
			}
			result.append(')');
		}
		if (getImplicitFirstArgument() != null) {
			result.append(":implicitFirstArgument");
		}
		if (getImplicitReceiver() != null) {
			result.append(":implicitReceiver");
		}
		if (isTypeLiteral()) {
			result.append(":typeLiteral");
		}
		if (isVisible()) {
			result.append('+');
		} else {
			result.append('-');
		}
	}
	
	@Override
	public int getBucketId() {
		return bucketId;
	}

	/* @Nullable */
	@Override
	public LightweightTypeReference getImplicitReceiverType() {
		return null;
	}

	/**
	 * Returns the actual receiver of this (potential) feature call. It may be <code>null</code>
	 * even though there is a syntactic receiver available (in case of static features).
	 */
	/* @Nullable */
	@Override
	public XExpression getImplicitReceiver() {
		return null;
	}
	
	@Override
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitReceiverTypeParameterMapping() {
		return Collections.emptyMap();
	}
	
	@Override
	public EnumSet<ConformanceHint> getImplicitReceiverConformanceHints() {
		return ConformanceHint.fromFlags(getImplicitReceiverConformanceFlags());
	}
	
	@Override
	public int getImplicitReceiverConformanceFlags() {
		return ConformanceFlags.NONE;
	}
	
	/* @Nullable */
	@Override
	public LightweightTypeReference getSyntacticReceiverType() {
		return null;
	}
	
	/* @Nullable */
	@Override
	public XExpression getSyntacticReceiver() {
		return null;
	}
	
	@Override
	public boolean isSyntacticReceiverPossibleArgument() {
		return true;
	}
	
	@Override
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getSyntacticReceiverTypeParameterMapping() {
		return Collections.emptyMap();
	}
	
	@Override
	public EnumSet<ConformanceHint> getSyntacticReceiverConformanceHints() {
		return ConformanceHint.fromFlags(getSyntacticReceiverConformanceFlags());
	}
	
	@Override
	public int getSyntacticReceiverConformanceFlags() {
		return ConformanceFlags.NONE;
	}
	
	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public String toString() {
		return String.format("%s:%s [key: %s]", getName(), getElementOrProxy().getIdentifier(), getShadowingKey());
	}

	@Override
	public JvmIdentifiableElement getElementOrProxy() {
		return (JvmIdentifiableElement) getEObjectOrProxy();
	}

	/* @Nullable */
	@Override
	public XExpression getImplicitFirstArgument() {
		return null;
	}

	/* @Nullable */
	@Override
	public LightweightTypeReference getImplicitFirstArgumentType() {
		return null;
	}
	
	@Override
	public boolean isTypeLiteral() {
		return false;
	}
	
	@Override
	public boolean isAnonymousClassConstructorCall() {
		return false;
	}
	
	@Override
	public int getNumberOfIrrelevantParameters() {
		if (isExtension())
			return 1;
		if (getImplicitFirstArgument() != null)
			return 1;
		return 0;
	}
	
	@Override
	public int getNumberOfParameters() {
		JvmIdentifiableElement elementOrProxy = getElementOrProxy();
		if (elementOrProxy instanceof JvmExecutable) {
			int parameters = ((JvmExecutable) elementOrProxy).getParameters().size() - getNumberOfIrrelevantParameters();
			return parameters;
		}
		return 0;
	}
	
	@Override
	public boolean isValidStaticState() {
		return true;
	}
	
}