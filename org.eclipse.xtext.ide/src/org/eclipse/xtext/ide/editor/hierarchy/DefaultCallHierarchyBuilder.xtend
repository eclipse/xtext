/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.hierarchy

import java.util.Map
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtend.lib.annotations.Accessors
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
class DefaultCallHierarchyBuilder extends AbstractHierarchyBuilder implements ICallHierarchyBuilder {

	@Accessors
	CallHierarchyType hierarchyType = CallHierarchyType.CALLER

	override buildRoots(URI rootURI, IProgressMonitor monitor) {
		val rootDeclaration = rootURI.findDeclaration
		if(rootDeclaration === null) return emptyList
		return #[rootDeclaration.createRoot]
	}

	override buildChildren(IHierarchyNode parent, IProgressMonitor monitor) {
		if (!parent.mayHaveChildren)
			return emptyList

		val children = newLinkedHashMap
		findDeclarations(parent, monitor) [ declaration, reference |
			val childNode = children.createChild(declaration, parent)
			if (childNode !== null) {
				val nodeReference = reference.createNodeReference
				if (nodeReference !== null)
					childNode.references += nodeReference
			}
		]
		return children.values
	}

	protected def void findDeclarations(
		IHierarchyNode parent,
		IProgressMonitor monitor,
		(IEObjectDescription, IReferenceDescription)=>void acceptor
	) {
		switch hierarchyType {
			case CALLEE:
				findTargetDeclarations(parent.element.EObjectURI, monitor, acceptor)
			default:
				findSourceDeclarations(parent.element.EObjectURI, monitor, acceptor)
		}
	}

	protected def void findTargetDeclarations(
		URI sourceDeclarationURI,
		IProgressMonitor monitor,
		(IEObjectDescription, IReferenceDescription)=>void acceptor
	) {
		readOnly(sourceDeclarationURI) [ sourceDeclaration |
			referenceFinder.findAllReferences(
				sourceDeclaration,
				new ReferenceAcceptor(resourceServiceProviderRegistry) [ reference |
					if (reference.filterReference) {
						val targetDeclaration = reference?.findTargetDeclaration
						acceptor.apply(targetDeclaration, reference)
					}
				],
				monitor
			)
			null
		]
	}

	protected def void findSourceDeclarations(
		URI targetDeclarationURI,
		IProgressMonitor monitor,
		(IEObjectDescription, IReferenceDescription)=>void acceptor
	) {
		val targetURIs = targetDeclarationURI.collectTargetURIs
		referenceFinder.findAllReferences(
			targetURIs,
			resourceAccess,
			indexData,
			new ReferenceAcceptor(resourceServiceProviderRegistry) [ reference |
				if (reference.filterReference) {
					val sourceDeclaration = reference?.findSourceDeclaration
					acceptor.apply(sourceDeclaration, reference)	
				}
			],
			monitor
		)
	}

	protected def TargetURIs collectTargetURIs(URI targetURI) {
		val targetURIs = targetURIProvider.get
		if(targetURI === null) return targetURIs

		readOnly(targetURI) [ targetObject |
			if(targetObject !== null) {
				targetURICollector.add(targetObject, targetURIs)
			}
			return null
		]
		return targetURIs
	}

	protected def boolean filterReference(IReferenceDescription reference) {
		reference !== null
	}

	protected def IEObjectDescription findDeclaration(URI objectURI) {
		return objectURI.description
	}

	protected def IEObjectDescription findTargetDeclaration(IReferenceDescription reference) {
		return reference.targetEObjectUri.findDeclaration
	}

	protected def IEObjectDescription findSourceDeclaration(IReferenceDescription reference) {
		return reference.containerEObjectURI.findDeclaration
	}

	/**
	 * @return a root hierarchy node for the given declaration; cannot be <code>null</code>
	 */
	protected def IHierarchyNode createRoot(IEObjectDescription declaration) {
		val node = new DefaultHierarchyNode
		node.element = declaration
		node.mayHaveChildren = true
		return node
	}

	/**
	 * @return a child node for the given declaration and the parent node; cannot be <code>null</code> 
	 */
	protected def IHierarchyNode createChild(IEObjectDescription declaration, IHierarchyNode parent) {
		val node = new DefaultHierarchyNode
		node.parent = parent
		node.element = declaration
		node.mayHaveChildren = !node.recursive
		return node
	}

	protected def IHierarchyNode createChild(
		Map<URI, IHierarchyNode> children,
		IEObjectDescription declaration,
		IHierarchyNode parent
	) {
		if(declaration === null) return null;

		var childNode = children.get(declaration.EObjectURI)
		if (childNode === null) {
			childNode = createChild(declaration, parent)
			children.put(declaration.EObjectURI, childNode)
		}
		return childNode
	}

	/**
	 * @return a hierarchy node reference for the given reference; cannot be <code>null</code>
	 */
	protected def IHierarchyNodeReference createNodeReference(IReferenceDescription reference) {
		return readOnly(reference.sourceEObjectUri) [ sourceObject |
			val textRegion = sourceObject.getTextRegion(reference.EReference, reference.indexInList)
			val text = sourceObject.getText(textRegion)
			return new DefaultHierarchyNodeReference(text, textRegion, reference)
		]
	}

	protected def ITextRegionWithLineInformation getTextRegion(EObject obj, EReference reference, int indexInList) {
		return hierarchyNodeLocationProvider.getTextRegion(obj, reference, indexInList)
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
