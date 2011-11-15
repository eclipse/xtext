/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.scoping;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.scoping.featurecalls.AbstractStaticMethodsFeatureForTypeProvider;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendImport;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StaticallyImportedFeaturesProvider extends AbstractStaticMethodsFeatureForTypeProvider {

	@Override
	protected Map<JvmTypeReference, Collection<String>> getVisibleTypesContainingStaticMethods(Iterable<JvmTypeReference> hierarchy) {
		boolean extension = isExtensionProvider();
		if (hierarchy == null || Iterables.isEmpty(hierarchy)) {
			extension = false;
		}
		List<XtendImport> imports = getImports();
		Collection<String> result = Lists.newArrayList();
		for(XtendImport imported: imports) {
			if (imported.isStatic() && (!extension || imported.isExtension()) && imported.isWildcard()) {
				String typeName = imported.getImportedTypeName();
				if (!Strings.isEmpty(typeName))
					result.add(typeName);
			}
		}
		if (result.isEmpty())
			return Collections.emptyMap();
		if (!extension || hierarchy == null /* to trick jdt 3.6 npe analysis */ ) {
			return Collections.singletonMap(null, result);
		}
		Map<JvmTypeReference, Collection<String>> map = Maps.newHashMap();
		for(JvmTypeReference reference: hierarchy) {
			map.put(reference, result);
		}
		return map;
	}
	
	@Override
	protected void collectFeatures(String name, Iterable<JvmTypeReference> hierarchy, Collection<JvmFeature> result) {
		final Map<JvmTypeReference, Collection<JvmTypeReference>> staticTypeNames = getVisibleJvmTypesContainingStaticMethods(hierarchy);
		for (final Entry<JvmTypeReference, Collection<JvmTypeReference>> e : staticTypeNames.entrySet()) {
			// optimization - we know that the list is the same for all types
			for(final JvmTypeReference staticType: e.getValue()) {
				List<JvmType> rawTypes = getRawTypeHelper().getAllRawTypes(staticType, context);
				for(JvmType rawType: rawTypes) {
					if (rawType instanceof JvmDeclaredType) {
						Iterable<JvmFeature> features = name != null ? ((JvmDeclaredType) rawType).findAllFeaturesByName(name) : ((JvmDeclaredType) rawType).getAllFeatures();
						for(JvmFeature feature: features) {
							if (feature instanceof JvmOperation) {
								// optimization is here
								if (e.getKey() == null) {
									if (isMatchingExtension(e.getKey(), (JvmOperation) feature)) {
										result.add(feature);
									}
								} else {
									for(JvmTypeReference key: hierarchy) {
										// and here
										if (isMatchingExtension(key, (JvmOperation) feature)) {
											result.add(feature);
											break;
										}
									}
								}
							} else if (feature instanceof JvmField) {
								result.add(feature);
							}
						}
					}
				}
			}
			return;
		}
	}

	protected List<XtendImport> getImports() {
		Resource resource = getContext();
		if (resource.getContents().isEmpty() || !(resource.getContents().get(0) instanceof XtendFile))
			return Collections.emptyList();
		XtendFile file = (XtendFile) resource.getContents().get(0);
		return file.getImports();
	}
	
}
