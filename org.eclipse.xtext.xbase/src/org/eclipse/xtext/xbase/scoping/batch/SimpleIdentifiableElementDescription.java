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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SimpleIdentifiableElementDescription implements IIdentifiableElementDescription {

	private IEObjectDescription delegate;

	public SimpleIdentifiableElementDescription(IEObjectDescription delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public QualifiedName getName() {
		return delegate.getName();
	}

	@Override
	public QualifiedName getQualifiedName() {
		return delegate.getQualifiedName();
	}

	@Override
	public EObject getEObjectOrProxy() {
		return delegate.getEObjectOrProxy();
	}

	@Override
	public URI getEObjectURI() {
		return delegate.getEObjectURI();
	}

	@Override
	public EClass getEClass() {
		return delegate.getEClass();
	}

	@Override
	public String getUserData(/* @Nullable */ String key) {
		return delegate.getUserData(key);
	}

	@Override
	public String[] getUserDataKeys() {
		return delegate.getUserDataKeys();
	}

	@Override
	public JvmIdentifiableElement getElementOrProxy() {
		return (JvmIdentifiableElement) delegate.getEObjectOrProxy();
	}

	@Override
	public String getShadowingKey() {
		return getName().toString();
	}

	@Override
	public int getBucketId() {
		return 0;
	}

	@Override
	public String toString() {
		return String.format("%s[%s]", getClass().getSimpleName(), delegate);
	}
	
	/* @Nullable */
	@Override
	public LightweightTypeReference getImplicitReceiverType() {
		return null;
	}

	/* @Nullable */
	@Override
	public XExpression getImplicitReceiver() {
		return null;
	}

	@Override
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitReceiverTypeParameterMapping() {
		return Collections.emptyMap();
	}
	
	/* @NonNull */
	@Override
	public EnumSet<ConformanceHint> getImplicitReceiverConformanceHints() {
		return EnumSet.noneOf(ConformanceHint.class);
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
		return false;
	}

	@Override
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getSyntacticReceiverTypeParameterMapping() {
		return Collections.emptyMap();
	}
	
	/* @NonNull */
	@Override
	public EnumSet<ConformanceHint> getSyntacticReceiverConformanceHints() {
		return EnumSet.noneOf(ConformanceHint.class);
	}
	
	@Override
	public int getSyntacticReceiverConformanceFlags() {
		return ConformanceFlags.NONE;
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
	public boolean isVisible() {
		return true;
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
	public boolean isTypeLiteral() {
		return false;
	}
	
	@Override
	public boolean isAnonymousClassConstructorCall() {
		return false;
	}
	
	@Override
	public int getNumberOfIrrelevantParameters() {
		return 0;
	}
	
	@Override
	public int getNumberOfParameters() {
		return 0;
	}
	
	@Override
	public boolean isValidStaticState() {
		return true;
	}
}
