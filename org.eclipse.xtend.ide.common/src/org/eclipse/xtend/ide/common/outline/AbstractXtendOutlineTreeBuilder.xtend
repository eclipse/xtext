/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.common.outline

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmFeature
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions
import org.eclipse.xtext.xbase.typesystem.^override.ResolvedFeatures
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author kosyakov - Initial contribution and API
 */
abstract class AbstractXtendOutlineTreeBuilder implements IXtendOutlineTreeBuilder {

	@Inject
	extension JvmTypeExtensions

	@Inject
	CommonTypeComputationServices services

	@Inject
	protected extension IXtendJvmAssociations

	@Accessors(PUBLIC_SETTER)
	protected extension IXtendOutlineNodeBuilder xtendOutlineNodeBuilder

	def dispatch build(Void modelElement, IXtendOutlineContext context) {
	}

	def dispatch build(EObject modelElement, IXtendOutlineContext context) {
		modelElement.eContents.forEach[buildEObjectNode(context)]
	}

	protected def void buildPackageAndImportSection(XtendFile xtendFile, IXtendOutlineContext context) {
		if (xtendFile.package !== null) {
			xtendFile.buildPackageNode(context)
		}
		if (xtendFile.importSection !== null && !xtendFile.importSection.importDeclarations.empty) {
			xtendFile.buildImportSectionNode(context)
		}
	}

	protected def void buildInheritedMembers(JvmDeclaredType inferredType, IXtendOutlineContext context) {
		val owner = new StandardTypeReferenceOwner(services, inferredType.eResource.resourceSet)
		val typeReference = owner.toLightweightTypeReference(inferredType)
		val superTypes = typeReference.allSuperTypes
		var superTypeContext = context
		for (superTypeRef : superTypes) {
			superTypeContext = superTypeContext.increaseInheritanceDepth
			val resolvedFeatures = new ResolvedFeatures(superTypeRef)
			for (jvmField : resolvedFeatures.declaredFields) {
				if (!jvmField.declaration.skipFeature) {
					inferredType.buildResolvedFeatureNode(jvmField, superTypeContext)
				}
			}
			for (constructor : resolvedFeatures.declaredConstructors) {
				if (!constructor.declaration.skipFeature) {
					inferredType.buildResolvedFeatureNode(constructor, superTypeContext)
				}
			}
			for (operation : resolvedFeatures.declaredOperations) {
				if (!operation.declaration.skipFeature && !superTypeContext.isProcessed(operation.declaration)) {
					inferredType.buildResolvedFeatureNode(operation, superTypeContext)
				}
			}
			val declaredType = superTypeRef.type
			if (declaredType instanceof JvmDeclaredType) {
				val nestedTypeContext = superTypeContext.hideInherited
				declaredType.members.filter(JvmDeclaredType).forEach[buildJvmType(nestedTypeContext)]
			}
		}
	}

	protected def skipFeature(JvmFeature feature) {
		if (feature instanceof JvmConstructor)
			feature.declaringType.local || feature.singleSyntheticDefaultConstructor
	}

	protected def buildJvmType(JvmDeclaredType typeElement, IXtendOutlineContext context) {
		val jvmTypeContext = typeElement.buildXtendNode(context)
		if (!jvmTypeContext.isProcessed(typeElement)) {
			jvmTypeContext.markAsProcessed(typeElement)
			typeElement.buildMembers(typeElement, jvmTypeContext)
		}
	}

	protected def void buildMembers(
		JvmDeclaredType inferredType,
		JvmDeclaredType baseType,
		extension IXtendOutlineContext context
	) {
		for (member : inferredType.members) {
			if (!member.processed) {
				if (member instanceof JvmDeclaredType) {
					if (isShowInherited) {
						val typeContext = context.newContext
						val sourceElement = member.primarySourceElement
						if (sourceElement instanceof XtendTypeDeclaration) {
							sourceElement.buildType(typeContext)
						} else {
							member.buildJvmType(typeContext)
						}
					} else {
						member.buildJvmType(context)
					}
				} else if (member instanceof JvmFeature) {
					if (!member.skipFeature) {
						val featureContext = baseType.buildFeature(member, member, context)
						member.localClasses.forEach[buildJvmType(featureContext.newContext)]
					}
				}
				member.markAsProcessed
			}
		}
		if (context.isShowInherited) {
			buildInheritedMembers(inferredType, context)
		}
	}
	
	protected def buildFeature(JvmDeclaredType inferredType, JvmFeature jvmFeature, EObject semanticFeature, IXtendOutlineContext context) {
		// disabled org.eclipse.xtend.core.idea.structureview.SyntheticMemberFilter in XtendFileTreeModel
		if (!jvmFeature.synthetic) {
			inferredType.buildFeatureNode(semanticFeature, context)
		}
	}

	abstract protected def void buildType(EObject someType, IXtendOutlineContext context)

}