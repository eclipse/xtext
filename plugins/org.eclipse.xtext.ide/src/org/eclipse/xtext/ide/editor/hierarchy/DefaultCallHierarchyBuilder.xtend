/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.hierarchy

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.findReferences.ReferenceAcceptor
import org.eclipse.xtext.findReferences.TargetURIs
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.IReferenceDescription
import org.eclipse.xtext.util.ITextRegionWithLineInformation

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.*

/**
 * <p>
 * Default implementation of a call hierarchy builder.
 * </p>
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
class DefaultCallHierarchyBuilder extends AbstractHierarchyBuilder {

	override buildRoots(URI rootURI, IProgressMonitor progressMonitor) {
		val rootDeclaration = rootURI.rootDeclaration
		if(rootDeclaration === null) return emptyList
		return #[rootDeclaration.createRoot]
	}

	override buildChildren(HierarchyNode parent, IProgressMonitor progressMonitor) {
		if (!parent.mayHaveChildren)
			return emptyList

		val children = newLinkedHashMap
		parent.element.EObjectURI.findDeclarations(progressMonitor) [ declaration, reference |
			var childNode = children.get(declaration.EObjectURI)
			if (childNode === null) {
				childNode = createChild(declaration, parent)
				children.put(declaration.EObjectURI, childNode)
			}
			childNode.locations += reference.createLocation
		]
		return children.values
	}

	protected def void findDeclarations(
		URI targetURI,
		IProgressMonitor progressMonitor,
		(IEObjectDescription, IReferenceDescription)=>void acceptor
	) {
		val targetURIs = targetURI.collectTargetURIs

		referenceFinder.findAllReferences(
			targetURIs,
			resourceAccess,
			indexData,
			new ReferenceAcceptor(resourceServiceProviderRegistry) [ reference |
				val declaration = reference.declaration
				if (declaration !== null)
					acceptor.apply(declaration, reference)
			],
			progressMonitor
		)
	}

	protected def TargetURIs collectTargetURIs(URI targetURI) {
		val targetURIs = targetURIProvider.get
		if(targetURI === null) return targetURIs

		return resourceAccess.readOnly(targetURI) [ resourceSet |
			val targetObject = resourceSet.getEObject(targetURI, true)
			if(targetObject === null) return targetURIs

			targetURICollector.add(targetObject, targetURIs)
			return targetURIs
		]
	}

	protected def IEObjectDescription getRootDeclaration(URI rootURI) {
		return rootURI.declaration.rootDeclaration
	}

	/**
	 * @returns a declaration representing a root hierarchy node for the given element; can return <code>null<code> if the hierarchy does not support such kind of declarations 
	 */
	protected def IEObjectDescription getRootDeclaration(IEObjectDescription declaration) {
		return declaration
	}

	/**
	 * @returns a declaration representing a child node that can be reached with the given reference; can return <code>null</code> if the hierarchy does not support such kind of references
	 */
	protected def IEObjectDescription getDeclaration(IReferenceDescription reference) {
		if(reference === null) return null

		val declarationURI = reference.containerEObjectURI ?: reference.sourceEObjectUri
		return declarationURI.declaration
	}

	protected def IEObjectDescription getDeclaration(URI declarationURI) {
		val resourceDescription = indexData.getResourceDescription(declarationURI.trimFragment)
		if(resourceDescription === null) return null

		return resourceDescription.exportedObjects.findFirst[EObjectURI == declarationURI]
	}

	/**
	 * @returns a root hierarchy node for the given declaration; cannot be <code>null</code>
	 */
	protected def HierarchyNode createRoot(IEObjectDescription declaration) {
		val node = new DefaultHierarchyNode
		node.element = declaration
		node.mayHaveChildren = true
		return node
	}

	/**
	 * @returns a child node for the given declaration and the parent node; cannot be <code>null</code> 
	 */
	protected def HierarchyNode createChild(IEObjectDescription declaration, HierarchyNode parent) {
		val node = new DefaultHierarchyNode
		node.parent = parent
		node.element = declaration
		node.mayHaveChildren = !node.recursive
		return node
	}

	/**
	 * @returns a location for the given reference; cannot be <code>null</code>
	 */
	protected def HierarchyNodeLocation createLocation(IReferenceDescription reference) {
		return resourceAccess.readOnly(reference.sourceEObjectUri) [ resourceSet |
			val obj = resourceSet.getEObject(reference.sourceEObjectUri, true)
			val textRegion = obj.getTextRegion(reference)
			val text = obj.getText(textRegion)
			return new DefaultHierarchyNodeLocation(text, textRegion, reference)
		]
	}

	protected def ITextRegionWithLineInformation getTextRegion(EObject obj, IReferenceDescription reference) {
		return hierarchyNodeLocationProvider.getTextRegion(obj, reference.EReference, reference.indexInList)
	}

	protected def String getText(EObject obj, ITextRegionWithLineInformation textRegion) {
		if (obj === null || textRegion === ITextRegionWithLineInformation.EMPTY_REGION)
			return ''

		val node = obj.rootContainer.node
		if (node === null)
			return ''

		val endOffset = textRegion.offset + textRegion.length
		return node.rootNode.text.substring(textRegion.offset, endOffset)
	}

}
