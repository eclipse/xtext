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

	protected void addComponent(LightweightTypeReference component) {
		if (component == null) {
			throw new NullPointerException("component may not be null");
		}
		if (!component.isValidInContext(getOwner())) {
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
}
