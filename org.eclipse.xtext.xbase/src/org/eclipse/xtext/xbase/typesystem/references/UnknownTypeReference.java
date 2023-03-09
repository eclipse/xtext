/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.typesystem.conformance.SuperTypeAcceptor;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;

/**
 * Represents a JvmType that could not be resolved, e.g. a proxy or null.
 * 
 * Generally speaking, unknown type references define features on demand,
 * thus they do not produce conformance problems or follow up linking errors.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnknownTypeReference extends LightweightTypeReference {

	private String name;

	public UnknownTypeReference(ITypeReferenceOwner owner, /* @Nullable */ String name) {
		super(owner);
		this.name = Strings.isEmpty(name) ? "Object" : name;
	}
	
	public UnknownTypeReference(ITypeReferenceOwner owner) {
		this(owner, null);
	}
	
	/**
	 * Subclasses <em>must</em> override this method.
	 */
	@Override
	public int getKind() {
		return KIND_UNKNOWN_TYPE_REFERENCE;
	}
	
	@Override
	public boolean isUnknown() {
		return true;
	}
	
	@Override
	public boolean isVisible(IVisibilityHelper visibilityHelper) {
		return true;
	}

	@Override
	public JvmTypeReference toTypeReference() {
		JvmUnknownTypeReference result = getTypesFactory().createJvmUnknownTypeReference();
		if (name != null)
			result.setQualifiedName(name);
		return result;
	}

	@Override
	public JvmTypeReference toJavaCompliantTypeReference(IVisibilityHelper visibilityHelper) {
		return toTypeReference();
	}

	@Override
	/* @Nullable */
	public JvmType getType() {
		return null;
	}
	
	@Override
	protected List<LightweightTypeReference> getSuperTypes(TypeParameterSubstitutor<?> substitutor) {
		return Collections.emptyList();
	}

	@Override
	protected LightweightTypeReference doCopyInto(ITypeReferenceOwner owner) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getSimpleName() {
		return name;
	}

	@Override
	public String getIdentifier() {
		return getSimpleName();
	}
	
	@Override
	public String getUniqueIdentifier() {
		return getSimpleName();
	}

	@Override
	public String getJavaIdentifier() {
		return name;
	}

	@Override
	public boolean isType(Class<?> clazz) {
		return false;
	}
	
	@Override
	public void collectSuperTypes(SuperTypeAcceptor acceptor) {
		// noop
	}
	
	@Override
	public void accept(TypeReferenceVisitor visitor) {
		visitor.doVisitUnknownTypeReference(this);
	}
	
	@Override
	public <Param> void accept(TypeReferenceVisitorWithParameter<Param> visitor, Param param) {
		visitor.doVisitUnknownTypeReference(this, param);
	}
	
	@Override
	/* @Nullable */
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		return visitor.doVisitUnknownTypeReference(this);
	}
	
	@Override
	/* @Nullable */
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndResult<Param, Result> visitor, Param param) {
		return visitor.doVisitUnknownTypeReference(this, param);
	}

}
