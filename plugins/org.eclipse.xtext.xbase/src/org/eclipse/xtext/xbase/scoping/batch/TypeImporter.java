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
import java.util.Set;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.typesystem.util.Maps2;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeImporter implements ITypeImporter {

	private Map<JvmType, Set<String>> namedStaticImports = Maps.newHashMap();
	private Map<JvmType, Set<String>> namedStaticExtensionImports = Maps.newHashMap();
	private Map<JvmType, Set<String>> bogusNamedStaticExtensionImports = Maps.newHashMap();

	private List<JvmType> staticImports = Lists.newArrayListWithCapacity(3);
	private List<JvmType> staticExtensionImports = Lists.newArrayListWithCapacity(3);
	private List<JvmType> bogusStaticImports = Lists.newArrayListWithCapacity(3);
	
	protected IFeatureScopeSession process(AbstractFeatureScopeSession parent, ITypeImporter.Client client) {
		client.doAddImports(this);
		AbstractFeatureScopeSession result = parent;
		if (!bogusStaticImports.isEmpty()) {
			// import all static extensions also as static plain imports
			 result = new FeatureScopeSessionWithStaticTypes(
					 result,
						bogusStaticImports,
						Collections.<JvmType>emptyList(),
						result.getResolvedFeaturesProvider());
		}
		if (!bogusNamedStaticExtensionImports.isEmpty()) {
			result = new FeatureScopeSessionWithNamedStaticTypes(
					result,
					bogusNamedStaticExtensionImports,
					Collections.<JvmType, Set<String>>emptyMap(),
					result.getResolvedFeaturesProvider());
		}
		if (!staticImports.isEmpty() || !staticExtensionImports.isEmpty()) {
			result = new FeatureScopeSessionWithStaticTypes(
					result,
					staticImports,
					staticExtensionImports,
					result.getResolvedFeaturesProvider());
		}
		if (!namedStaticImports.isEmpty() || !namedStaticExtensionImports.isEmpty()) {
			result = new FeatureScopeSessionWithNamedStaticTypes(
					result,
					namedStaticImports,
					namedStaticExtensionImports,
					result.getResolvedFeaturesProvider());
		}
		return result;
	}

	public void importStatic(JvmDeclaredType type) {
		staticImports.add(type);
	}

	public void importStatic(JvmDeclaredType type, String memberName) {
		Maps2.putIntoSetMap(type, memberName, namedStaticImports);
	}

	public void importStaticExtension(JvmDeclaredType type, boolean strict) {
		staticExtensionImports.add(type);
		if (!strict) {
			bogusStaticImports.add(type);
		}
	}

	public void importStaticExtension(JvmDeclaredType type, String memberName, boolean strict) {
		Maps2.putIntoSetMap(type, memberName, namedStaticExtensionImports);
		if (!strict) {
			Maps2.putIntoSetMap(type, memberName, bogusNamedStaticExtensionImports);
		}
	}
	
}
