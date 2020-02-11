/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FeatureScopeSessionWithNestedTypes extends AbstractNestedFeatureScopeSession {

	private final List<JvmDeclaredType> enclosingTypes;
	private final List<JvmDeclaredType> nestedTypeDeclarators;

	public FeatureScopeSessionWithNestedTypes(AbstractFeatureScopeSession parent, JvmDeclaredType type) {
		super(parent);
		this.enclosingTypes = Lists.newLinkedList();
		enclosingTypes.add(type);
		enclosingTypes.addAll(parent.getEnclosingTypes());
		this.nestedTypeDeclarators = Lists.newLinkedList();
		nestedTypeDeclarators.add(type);
		nestedTypeDeclarators.addAll(parent.getNestedTypeDeclarators());
	}
	
	@Override
	public List<JvmDeclaredType> getNestedTypeDeclarators() {
		return Collections.unmodifiableList(nestedTypeDeclarators);
	}

	@Override
	public List<JvmDeclaredType> getEnclosingTypes() {
		return Collections.unmodifiableList(enclosingTypes);
	}

}
