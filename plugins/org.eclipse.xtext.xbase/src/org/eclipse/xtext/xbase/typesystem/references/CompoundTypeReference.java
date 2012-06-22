/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class CompoundTypeReference extends LightweightTypeReference {

	private boolean synonym;
	private List<LightweightTypeReference> components;
	private boolean resolved;

	protected CompoundTypeReference(TypeReferenceOwner owner, boolean synonym) {
		super(owner);
		this.synonym = synonym;
		this.resolved = true;
	}
	
	@Override
	public JvmTypeReference toTypeReference() {
		JvmCompoundTypeReference result = synonym ? getTypesFactory().createJvmSynonymTypeReference() : getTypesFactory().createJvmMultiTypeReference();
		if (components != null) {
			for(LightweightTypeReference component: components) {
				result.getReferences().add(component.toTypeReference());
			}
		}
		return result;
	}
	
	public List<LightweightTypeReference> getComponents() {
		return expose(components);
	}

	@Override
	protected LightweightTypeReference doCopyInto(TypeReferenceOwner owner) {
		CompoundTypeReference result = new CompoundTypeReference(owner, synonym);
		if (components != null && !components.isEmpty()) {
			for(LightweightTypeReference typeArgument: components) {
				result.addComponent(typeArgument.copyInto(owner));
			}
		}
		return result;
	}

	@Override
	public boolean isResolved() {
		return resolved;
	}
	
	public boolean isSynonym() {
		return synonym;
	}

	protected void addComponent(LightweightTypeReference component) {
		if (component == null) {
			throw new NullPointerException("component may not be null");
		}
		if (!component.isOwnedBy(getOwner())) {
			throw new NullPointerException("component is not valid in current context");
		}
		if (components == null)
			components = Lists.newArrayListWithCapacity(2);
		components.add(component);
		resolved &= component.isResolved();
	}
	
	@Override
	public String toString() {
		return Joiner.on(synonym ? " | " : " & ").join(components);
	}
	
	@Override
	public void accept(TypeReferenceVisitor visitor) {
		if (isSynonym())
			visitor.doVisitSynonymTypeReference(this);
		else
			visitor.doVisitMultiTypeReference(this);
	}
	
	@Override
	public <Param> void accept(TypeReferenceVisitorWithParameter<Param> visitor, Param param) {
		if (isSynonym())
			visitor.doVisitSynonymTypeReference(this, param);
		else
			visitor.doVisitMultiTypeReference(this, param);
	}
	
	@Override
	@Nullable
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		if (isSynonym())
			return visitor.doVisitSynonymTypeReference(this);
		else
			return visitor.doVisitMultiTypeReference(this);
	}
	
	@Override
	@Nullable
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndResult<Param, Result> visitor, Param param) {
		if (isSynonym())
			return visitor.doVisitSynonymTypeReference(this, param);
		else
			return visitor.doVisitMultiTypeReference(this, param);
	}
}
