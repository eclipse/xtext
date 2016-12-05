/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.structureview

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.newStructureView.TreeActionsOwner
import com.intellij.navigation.ItemPresentation
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtend.ide.common.outline.IXtendOutlineContext
import org.eclipse.xtend.ide.common.outline.IXtendOutlineNodeBuilder
import org.eclipse.xtend.ide.common.outline.IXtendOutlineTreeBuilder
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmFeature
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.idea.structureview.DefaultStructureViewTreeElementProvider
import org.eclipse.xtext.idea.structureview.EObjectTreeElement
import org.eclipse.xtext.idea.structureview.XtextFileTreeElement
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedFeature

import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*
import static org.eclipse.xtext.xtype.XtypePackage.Literals.*

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendStructureViewTreeElementProvider extends DefaultStructureViewTreeElementProvider implements IXtendOutlineNodeBuilder {

	@Accessors
	TreeActionsOwner treeActionsOwner

	@Accessors
	IXtendOutlineTreeBuilder xtendOutlineTreeBuilder

	@Inject
	extension JvmTypeExtensions jvmTypeExtensions

	@Inject
	Provider<XtendEObjectTreeElement> xtendEObjectTreeElementProvider

	@Inject
	Provider<XtendFeatureTreeElement> xtendFeatureTreeElementProvider

	override dispatch void buildChildren(XtextFileTreeElement xtextFileTreeElement) {
		xtendOutlineTreeBuilder.build(
			xtextFileTreeElement.element.resource.contents.head,
			new IntellijXtendOutlineContext => [
				showInherited = this.showInherited
				xtextFile = xtextFileTreeElement.element
				structureViewTreeElement = xtextFileTreeElement
			]
		)
	}

	override dispatch void buildChildren(EObjectTreeElement objectTreeElement) {
		xtendOutlineTreeBuilder.build(
			objectTreeElement.object,
			new IntellijXtendOutlineContext => [
				showInherited = this.showInherited
				xtextFile = objectTreeElement.xtextFile
				structureViewTreeElement = objectTreeElement
			]
		)
	}

	protected def isShowInherited() {
		if (treeActionsOwner === null) {
			return false
		}
		treeActionsOwner.isActionActive(XtendShowInheritedNodeProvider.ID)
	}

	override buildEObjectNode(EObject modelElement, IXtendOutlineContext context) {
		val intellijContext = context as IntellijXtendOutlineContext
		intellijContext.withStructureViewTreeElement(
			modelElement.createEObjectTreeElement(intellijContext.xtextFile)
		)
	}

	override buildXtendNode(EObject modelElement, IXtendOutlineContext context) {
		val intellijContext = context as IntellijXtendOutlineContext
		intellijContext.withStructureViewTreeElement(
			modelElement.createEObjectTreeElement(intellijContext.xtextFile)
		)
	}

	override buildFeatureNode(
		JvmDeclaredType inferredType,
		EObject semanticFeature,
		IXtendOutlineContext context
	) {
		val intellijContext = context as IntellijXtendOutlineContext
		intellijContext.withStructureViewTreeElement(
			semanticFeature.createXtendFeatureTreeElement(
				true,
				semanticFeature.itemPresentation,
				intellijContext
			)
		)
	}

	override buildDispatcherNode(JvmDeclaredType baseType, JvmFeature dispatcher, List<JvmOperation> dispatchCases,
		IXtendOutlineContext context) {
		val intellijContext = context as IntellijXtendOutlineContext
		intellijContext.withStructureViewTreeElement(
			dispatcher.createXtendFeatureTreeElement(
				true,
				dispatcher.itemPresentation,
				intellijContext
			) => [
				dispatch = true
			]
		)
	}

	override buildPackageNode(XtendFile xtendFile, IXtendOutlineContext context) {
		val intellijContext = context as IntellijXtendOutlineContext
		intellijContext.withStructureViewTreeElement(
			xtendFile.createEStructuralFeatureTreeElement(
				XTEND_FILE__PACKAGE,
				intellijContext.xtextFile,
				true,
				new PresentationData => [
					icon = AllIcons.Nodes.Package
					presentableText = xtendFile.package
				]
			)
		)
	}

	override buildImportSectionNode(XtendFile xtendFile, IXtendOutlineContext context) {
		val intellijContext = context as IntellijXtendOutlineContext
		intellijContext.withStructureViewTreeElement(
			xtendFile.importSection.createEStructuralFeatureTreeElement(
				XIMPORT_SECTION__IMPORT_DECLARATIONS,
				intellijContext.xtextFile,
				false,
				xtendFile.importSection.itemPresentation
			)
		)
	}

	override buildResolvedFeatureNode(JvmDeclaredType inferredType, IResolvedFeature resolvedFeature,
		IXtendOutlineContext context) {
		val intellijContext = context as IntellijXtendOutlineContext
		intellijContext.withStructureViewTreeElement(
			resolvedFeature.declaration.createXtendFeatureTreeElement(
				true,
				resolvedFeature.itemPresentation,
				intellijContext
			)
		)
	}

	protected def createXtendFeatureTreeElement(EObject modelElement, boolean leaf, ItemPresentation presentation,
		IntellijXtendOutlineContext context) {
		configureTreeElement(xtendFeatureTreeElementProvider.get, modelElement, leaf, presentation, context) => [
			synthetic = modelElement.synthetic
		]
	}

	protected def createXtendEObjectTreeElement(EObject modelElement, boolean leaf, ItemPresentation presentation,
		IntellijXtendOutlineContext context) {
		configureTreeElement(xtendEObjectTreeElementProvider.get, modelElement, leaf, presentation, context)
	}

	protected def <T extends XtendEObjectTreeElement> T configureTreeElement(T objectTreeElement, EObject modelElement,
		boolean leaf, ItemPresentation presentation, IntellijXtendOutlineContext context) {
		objectTreeElement.object = modelElement
		objectTreeElement.xtextFile = context.xtextFile
		objectTreeElement.leaf = leaf
		objectTreeElement.itemPresentation = presentation
		objectTreeElement.structureViewTreeElementProvider = this
		objectTreeElement.static = modelElement.static
		objectTreeElement.inheritanceDepth = context.inheritanceDepth
		objectTreeElement
	}

	protected def isSynthetic(EObject modelElement) {
		if (modelElement instanceof JvmIdentifiableElement) {
			jvmTypeExtensions.isSynthetic(modelElement)
		}
	}

	protected def isStatic(EObject modelElement) {
		switch modelElement {
			JvmFeature: modelElement.static
			JvmDeclaredType: modelElement.static
			XtendMember: modelElement.static
			default: false
		}
	}

	override protected isLeaf(EObject modelElement) {
		switch modelElement {
			JvmDeclaredType:
				modelElement.members.empty
			XtendTypeDeclaration:
				modelElement.members.empty
			default:
				super.isLeaf(modelElement)
		}
	}

}