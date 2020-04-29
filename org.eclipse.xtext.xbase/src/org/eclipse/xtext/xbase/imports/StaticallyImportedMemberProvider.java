/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.imports;

import java.util.Collections;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.util.ContextualVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;
import org.eclipse.xtext.xtype.XImportDeclaration;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public class StaticallyImportedMemberProvider {
	@Inject
	private IImportsConfiguration importsConfiguration;

	@Inject
	private IResolvedFeatures.Provider resolvedFeaturesProvider;

	@Inject
	private IVisibilityHelper visibilityHelper;

	public Iterable<JvmFeature> findAllFeatures(XImportDeclaration it) {
		JvmDeclaredType importedType = it.getImportedType();
		if (!it.isStatic() || importedType == null) {
			return Collections.emptyList();
		}
		IVisibilityHelper visibilityHelper = getVisibilityHelper(it.eResource());
		IResolvedFeatures resolvedFeatures = resolvedFeaturesProvider.getResolvedFeatures(importedType);
		return Iterables.filter(resolvedFeatures.getAllFeatures(), (JvmFeature feature) -> {
			return feature.isStatic() && visibilityHelper.isVisible(feature)
					&& (it.getMemberName() == null || feature.getSimpleName().startsWith(it.getMemberName()));
		});
	}

	public Iterable<JvmFeature> getAllFeatures(XImportDeclaration it) {
		return getAllFeatures(it.eResource(), it.getImportedType(), it.isStatic(), it.isExtension(),
				it.getMemberName());
	}

	public Iterable<JvmFeature> getAllFeatures(Resource resource, JvmDeclaredType importedType, boolean isStatic,
			boolean extension, String memberName) {
		if (!isStatic || importedType == null) {
			return Collections.emptyList();
		}
		IVisibilityHelper visibilityHelper = getVisibilityHelper(resource);
		IResolvedFeatures resolvedFeatures = resolvedFeaturesProvider.getResolvedFeatures(importedType);
		return Iterables.filter(resolvedFeatures.getAllFeatures(memberName),
				feature -> feature.isStatic() && visibilityHelper.isVisible(feature));
	}

	public IVisibilityHelper getVisibilityHelper(Resource resource) {
		if (resource instanceof XtextResource) {
			String packageName = importsConfiguration.getPackageName(((XtextResource) resource));
			if (packageName != null) {
				return new ContextualVisibilityHelper(visibilityHelper, packageName);
			}
		}
		return visibilityHelper;
	}
}
