/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class SimpleIdentifiableElementDescription implements IIdentifiableElementDescription {

	private IEObjectDescription delegate;

	public SimpleIdentifiableElementDescription(IEObjectDescription delegate) {
		this.delegate = delegate;
	}
	
	public QualifiedName getName() {
		return delegate.getName();
	}

	public QualifiedName getQualifiedName() {
		return delegate.getQualifiedName();
	}

	public EObject getEObjectOrProxy() {
		return delegate.getEObjectOrProxy();
	}

	public URI getEObjectURI() {
		return delegate.getEObjectURI();
	}

	public EClass getEClass() {
		return delegate.getEClass();
	}

	public String getUserData(@Nullable String key) {
		return delegate.getUserData(key);
	}

	public String[] getUserDataKeys() {
		return delegate.getUserDataKeys();
	}

	public JvmIdentifiableElement getElementOrProxy() {
		return (JvmIdentifiableElement) delegate.getEObjectOrProxy();
	}

	public String getShadowingKey() {
		return getName().toString();
	}

	public int getBucketId() {
		return 0;
	}

	@Override
	public String toString() {
		return String.format("%s[%s]", getClass().getSimpleName(), delegate);
	}
	
	@Nullable
	public LightweightTypeReference getImplicitReceiverType() {
		return null;
	}

	@Nullable
	public XExpression getImplicitReceiver() {
		return null;
	}

	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitReceiverTypeParameterMapping() {
		return Collections.emptyMap();
	}
	
	public EnumSet<ConformanceHint> getImplicitReceiverConformanceHints() {
		return EnumSet.noneOf(ConformanceHint.class);
	}

	@Nullable
	public LightweightTypeReference getSyntacticReceiverType() {
		return null;
	}

	@Nullable
	public XExpression getSyntacticReceiver() {
		return null;
	}
	
	public boolean isSyntacticReceiverPossibleArgument() {
		return false;
	}

	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getSyntacticReceiverTypeParameterMapping() {
		return Collections.emptyMap();
	}
	
	public EnumSet<ConformanceHint> getSyntacticReceiverConformanceHints() {
		return EnumSet.noneOf(ConformanceHint.class);
	}

	@Nullable
	public XExpression getImplicitFirstArgument() {
		return null;
	}

	@Nullable
	public LightweightTypeReference getImplicitFirstArgumentType() {
		return null;
	}

	public boolean isVisible() {
		return true;
	}

	public boolean isStatic() {
		return false;
	}

	public boolean isExtension() {
		return false;
	}

	public boolean isTypeLiteral() {
		return false;
	}
	
	public int getNumberOfIrrelevantParameters() {
		return 0;
	}
	
	public int getNumberOfParameters() {
		return 0;
	}
	
	public boolean isValidStaticState() {
		return true;
	}
}
