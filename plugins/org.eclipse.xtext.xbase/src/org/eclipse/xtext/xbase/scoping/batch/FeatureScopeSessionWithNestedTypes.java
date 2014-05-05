/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.jvmmodel.NestedTypeCollector;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FeatureScopeSessionWithNestedTypes extends AbstractNestedFeatureScopeSession {

	private final List<JvmDeclaredType> enclosingTypes;
	private final Map<QualifiedName, JvmDeclaredType> nestedTypes;

	public FeatureScopeSessionWithNestedTypes(AbstractFeatureScopeSession parent, JvmDeclaredType type) {
		super(parent);
		this.enclosingTypes = Lists.newLinkedList();
		enclosingTypes.add(type);
		enclosingTypes.addAll(parent.getEnclosingTypes());
		
		NestedTypeCollector collector = new NestedTypeCollector();
		Map<QualifiedName, JvmDeclaredType> myNestedTypes = collector.collectNestedTypes(type);
		this.nestedTypes = collector.mergeEnclosingNestedTypes(myNestedTypes, parent.getNestedTypes());
	}

	@Override
	public Map<QualifiedName, JvmDeclaredType> getNestedTypes() {
		return Collections.unmodifiableMap(nestedTypes);
	}
	
	@Override
	public List<JvmDeclaredType> getEnclosingTypes() {
		return Collections.unmodifiableList(enclosingTypes);
	}

}
