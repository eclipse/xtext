/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hierarchy

import com.google.inject.Inject
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtext.XtextPackage
import org.eclipse.xtext.ide.editor.hierarchy.DefaultCallHierarchyBuilder
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyNode
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.IReferenceDescription

import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
class XtextCallHierarchyBuilder extends DefaultCallHierarchyBuilder {

	@Inject
	XtextCallHierarchyNodeLocationProvider callHierarchyNodeLocationProvider

	override protected getHierarchyNodeLocationProvider() {
		callHierarchyNodeLocationProvider
	}

	override protected getRootDeclaration(IEObjectDescription declaration) {
		if (declaration?.getEClass.rule)
			return declaration
	}

	override protected getDeclaration(IReferenceDescription reference) {
		switch type : reference?.getEReference?.getEType {
			EClass case type.rule:
				return super.getDeclaration(reference)
		}
	}

	protected def boolean isRule(EClass type) {
		XtextPackage.Literals.ABSTRACT_RULE.isAssignableFrom(type)
	}

	override protected createRoot(IEObjectDescription declaration) {
		val node = new XtextCallHierarchyNode
		node.element = declaration
		node.grammarDescription = declaration.grammarDescription
		node.mayHaveChildren = true
		return node
	}

	override protected createChild(IEObjectDescription declaration, HierarchyNode parent) {
		val node = new XtextCallHierarchyNode
		node.parent = parent
		node.element = declaration
		node.grammarDescription = declaration.grammarDescription
		node.mayHaveChildren = !node.recursive
		return node
	}

	protected def IEObjectDescription getGrammarDescription(IEObjectDescription description) {
		val resourceURI = description.getEObjectURI.trimFragment
		indexData.getResourceDescription(resourceURI).getExportedObjectsByType(XtextPackage.Literals.GRAMMAR).head
	}

}
