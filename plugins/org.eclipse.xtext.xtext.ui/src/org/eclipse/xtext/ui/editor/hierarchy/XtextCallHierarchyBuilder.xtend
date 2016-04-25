/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hierarchy

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.XtextPackage
import org.eclipse.xtext.ide.editor.hierarchy.DefaultCallHierarchyBuilder
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.IReferenceDescription

import static extension org.eclipse.xtext.EcoreUtil2.*
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode

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

	override protected findDeclaration(URI objectURI) {
		val description = objectURI.description
		if (description?.EClass.rule)
			return description

		return readOnly(objectURI) [ object |
			object.getContainerOfType(AbstractRule).description
		]
	}

	override protected filterReference(IReferenceDescription reference) {
		reference !== null && reference.EReference.EType.rule
	}
	
	override protected findSourceDeclaration(IReferenceDescription reference) {
		reference.containerEObjectURI.description
	}

	protected def boolean isRule(EClassifier type) {
		XtextPackage.Literals.ABSTRACT_RULE.isAssignable(type)
	}

	override protected createRoot(IEObjectDescription declaration) {
		val node = new XtextCallHierarchyNode
		node.element = declaration
		node.grammarDescription = declaration.grammarDescription
		node.mayHaveChildren = true
		return node
	}

	override protected createChild(IEObjectDescription declaration, IHierarchyNode parent) {
		val node = new XtextCallHierarchyNode
		node.parent = parent
		node.element = declaration
		node.grammarDescription = declaration.grammarDescription
		node.mayHaveChildren = declaration.EClass.rule && !node.recursive
		return node
	}

	protected def IEObjectDescription getGrammarDescription(IEObjectDescription description) {
		val resourceURI = description.getEObjectURI.trimFragment
		indexData.getResourceDescription(resourceURI).getExportedObjectsByType(XtextPackage.Literals.GRAMMAR).head
	}

}
