/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.structureview

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.newStructureView.TreeActionsOwner
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtend.ide.common.outline.IXtendOutlineContext
import org.eclipse.xtend.ide.common.outline.IXtendOutlineNodeBuilder
import org.eclipse.xtend.ide.common.outline.IXtendOutlineTreeBuilder
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmFeature
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.idea.structureview.DefaultStructureViewTreeElementProvider
import org.eclipse.xtext.idea.structureview.XtextFileTreeElement
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

	protected def isShowInherited() {
		if (treeActionsOwner == null) {
			return false
		}
		treeActionsOwner.isActionActive(XtendShowInheritedNodeProvider.ID)
	}

	override buildEObjectNode(EObject modelElement, IXtendOutlineContext context) {
		val intellijContext = context as IntellijXtendOutlineContext
		val structureViewTreeElement = modelElement.createEObjectTreeElement(intellijContext.xtextFile)
		intellijContext.withStructureViewTreeElement(structureViewTreeElement)
	}

	override buildXtendNode(EObject modelElement, IXtendOutlineContext context) {
		val intellijContext = context as IntellijXtendOutlineContext
		val structureViewTreeElement = modelElement.createEObjectTreeElement(intellijContext.xtextFile)
		intellijContext.withStructureViewTreeElement(structureViewTreeElement)
	}

	override buildFeatureNode(
		JvmDeclaredType inferredType,
		JvmFeature jvmFeature,
		EObject modelElement,
		IXtendOutlineContext context
	) {
		val intellijContext = context as IntellijXtendOutlineContext
		val structureViewTreeElement = jvmFeature.createEObjectTreeElement(intellijContext.xtextFile, true,
			jvmFeature.itemPresentation)
		intellijContext.withStructureViewTreeElement(structureViewTreeElement)
	}

	override buildDispatcherNode(JvmDeclaredType baseType, JvmFeature dispatcher, List<JvmOperation> dispatchCases,
		IXtendOutlineContext context) {
		baseType.buildFeatureNode(dispatcher, dispatcher, context)
	}

	override buildPackageNode(XtendFile xtendFile, IXtendOutlineContext context) {
		val intellijContext = context as IntellijXtendOutlineContext
		val structureViewTreeElement = xtendFile.createEStructuralFeatureTreeElement(
			XTEND_FILE__PACKAGE,
			intellijContext.xtextFile,
			true,
			new PresentationData => [
				icon = AllIcons.Nodes.Package
				presentableText = xtendFile.package
			]
		)
		intellijContext.withStructureViewTreeElement(structureViewTreeElement)
	}

	override buildImportSectionNode(XtendFile xtendFile, IXtendOutlineContext context) {
		val intellijContext = context as IntellijXtendOutlineContext
		val structureViewTreeElement = xtendFile.importSection.createEStructuralFeatureTreeElement(
			XIMPORT_SECTION__IMPORT_DECLARATIONS,
			intellijContext.xtextFile,
			false,
			xtendFile.importSection.itemPresentation
		)
		intellijContext.withStructureViewTreeElement(structureViewTreeElement)
	}

	override buildResolvedFeatureNode(JvmDeclaredType inferredType, IResolvedFeature resolvedFeature,
		IXtendOutlineContext context) {
		val intellijContext = context as IntellijXtendOutlineContext
		val structureViewTreeElement = resolvedFeature.declaration.createEObjectTreeElement(intellijContext.xtextFile)
		intellijContext.withStructureViewTreeElement(structureViewTreeElement)
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