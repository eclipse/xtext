/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.List;

import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CompoundTypeReference extends LightweightTypeReference {

	private boolean synonym;
	private List<LightweightTypeReference> components;
	private boolean resolved;

	protected CompoundTypeReference(ResolvedTypes types, boolean synonym) {
		super(types);
		this.synonym = synonym;
		this.resolved = true;
	}

	@Override
	protected LightweightTypeReference doCopyInto(ResolvedTypes types) {
		CompoundTypeReference result = new CompoundTypeReference(types, synonym);
		if (components != null && !components.isEmpty()) {
			for(LightweightTypeReference typeArgument: components) {
				result.addComponent(typeArgument.copyInto(types));
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
		if (!component.isValidInContext(getContext())) {
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
