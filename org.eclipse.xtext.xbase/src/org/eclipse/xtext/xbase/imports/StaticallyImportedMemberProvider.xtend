/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.common.types.JvmFeature
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedFeatures
import org.eclipse.xtext.xbase.typesystem.util.ContextualVisibilityHelper
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper
import org.eclipse.xtext.xtype.XImportDeclaration
import org.eclipse.xtext.common.types.JvmDeclaredType

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class StaticallyImportedMemberProvider {

	@Inject
	extension IImportsConfiguration
	
	@Inject
	extension IResolvedFeatures.Provider

	@Inject
	IVisibilityHelper visibilityHelper

	def findAllFeatures(XImportDeclaration it) {
		val importedType = importedType
		if (!static || importedType === null) {
			return <JvmFeature>emptyList
		}
		val visibilityHelper = eResource.visibilityHelper
		val resolvedFeatures = importedType.resolvedFeatures
		resolvedFeatures.allFeatures.filter [ feature |
			feature.static && visibilityHelper.isVisible(feature) &&
			(memberName === null || feature.simpleName.startsWith(memberName))
		]
	}

	def getAllFeatures(XImportDeclaration it) {
		eResource.getAllFeatures(importedType, static, extension, memberName)
	}

	def getAllFeatures(Resource resource, JvmDeclaredType importedType, boolean ^static, boolean ^extension, String memberName) {
		if (!static || importedType === null) {
			return <JvmFeature>emptyList
		}
		val visibilityHelper = resource.visibilityHelper
		val resolvedFeatures = importedType.resolvedFeatures
		resolvedFeatures.getAllFeatures(memberName).filter [ feature |
			feature.static && visibilityHelper.isVisible(feature) 
		]
	}

	def getVisibilityHelper(Resource resource) {
		switch resource {
			XtextResource: {
				val packageName = resource.packageName
				if (packageName === null) {
					visibilityHelper
				} else {
					new ContextualVisibilityHelper(visibilityHelper, packageName)
				}
			}
			default:
				visibilityHelper
		}
	}

}
