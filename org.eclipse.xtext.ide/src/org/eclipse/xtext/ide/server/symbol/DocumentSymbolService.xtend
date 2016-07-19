/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.symbol

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import io.typefox.lsapi.Location
import io.typefox.lsapi.SymbolInformation
import io.typefox.lsapi.SymbolInformationImpl
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.findReferences.IReferenceFinder
import org.eclipse.xtext.findReferences.IReferenceFinder.IResourceAccess
import org.eclipse.xtext.findReferences.ReferenceAcceptor
import org.eclipse.xtext.findReferences.TargetURICollector
import org.eclipse.xtext.findReferences.TargetURIs
import org.eclipse.xtext.ide.server.DocumentExtensions
import org.eclipse.xtext.ide.util.CancelIndicatorProgressMonitor
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import io.typefox.lsapi.SymbolKind

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
class DocumentSymbolService {

	@Inject
	extension DocumentExtensions

	@Inject
	extension EObjectAtOffsetHelper

	@Inject
	extension IQualifiedNameProvider

	@Inject
	IReferenceFinder referenceFinder

	@Inject
	TargetURICollector targetURICollector

	@Inject
	Provider<TargetURIs> targetURIProvider

	@Inject
	OperationCanceledManager operationCanceledManager

	@Inject
	IResourceServiceProvider.Registry resourceServiceProviderRegistry

	def List<? extends Location> getDefinitions(
		XtextResource resource,
		int offset,
		IResourceAccess resourceAccess,
		CancelIndicator cancelIndicator
	) {
		val element = resource.resolveElementAt(offset)
		if (element === null)
			return emptyList

		val locations = newArrayList
		val targetURIs = element.collectTargetURIs
		for (targetURI : targetURIs) {
			operationCanceledManager.checkCanceled(cancelIndicator)

			resourceAccess.doRead(targetURI) [ obj |
				locations += obj.newLocation
			]
		}
		return locations
	}

	def List<? extends Location> getReferences(
		XtextResource resource,
		int offset,
		IResourceAccess resourceAccess,
		IResourceDescriptions indexData,
		CancelIndicator cancelIndicator
	) {
		val element = resource.resolveElementAt(offset)
		if (element === null)
			return emptyList

		val locations = newArrayList
		val targetURIs = element.collectTargetURIs
		referenceFinder.findAllReferences(
			targetURIs,
			resourceAccess,
			indexData,
			new ReferenceAcceptor(resourceServiceProviderRegistry) [ reference |
				resourceAccess.doRead(reference.sourceEObjectUri) [ obj |
					locations += obj.newLocation(reference.EReference, reference.indexInList)
				]
			],
			new CancelIndicatorProgressMonitor(cancelIndicator)
		)
		return locations
	}

	protected def TargetURIs collectTargetURIs(EObject targetObject) {
		val targetURIs = targetURIProvider.get
		targetURICollector.add(targetObject, targetURIs)
		return targetURIs
	}

	def List<? extends SymbolInformation> getSymbols(XtextResource resource, CancelIndicator cancelIndicator) {
		val symbols = newLinkedHashMap
		val contents = resource.getAllProperContents(true)
		while (contents.hasNext) {
			operationCanceledManager.checkCanceled(cancelIndicator)

			val obj = contents.next as EObject
			val symbol = obj.createSymbol
			if (symbol !== null) {
				symbols.put(obj, symbol)

				val container = obj.container
				val containerSymbol = symbols.get(container)
				symbol.container = containerSymbol?.name
			}
		}
		return symbols.values.toList
	}

	protected def EObject getContainer(EObject obj) {
		return obj.eContainer
	}

	protected def SymbolInformationImpl createSymbol(EObject object) {
		val symbolName = object.symbolName
		if(symbolName === null) return null

		val symbol = new SymbolInformationImpl
		symbol.name = symbolName
		symbol.kind = object.symbolKind
		symbol.location = object.newLocation
		return symbol
	}

	protected def String getSymbolName(EObject object) {
		return object.fullyQualifiedName.symbolName
	}

	protected def SymbolKind getSymbolKind(EObject object) {
		return object.eClass.symbolKind
	}

	def List<? extends SymbolInformation> getSymbols(
		IResourceDescription resourceDescription,
		String query,
		IResourceAccess resourceAccess,
		CancelIndicator cancelIndicator
	) {
		val symbols = newLinkedList
		for (description : resourceDescription.exportedObjects) {
			operationCanceledManager.checkCanceled(cancelIndicator)
			if (description.filter(query)) {
				val symbol = description.createSymbol
				if (symbol !== null) {
					symbols += symbol
					resourceAccess.doRead(description.EObjectURI) [ obj |
						symbol.location = obj.newLocation
					]
				}
			}
		}
		return symbols
	}

	protected def boolean filter(IEObjectDescription description, String query) {
		return description.qualifiedName.toLowerCase.toString.contains(query.toLowerCase)
	}

	protected def SymbolInformationImpl createSymbol(IEObjectDescription description) {
		val symbolName = description.symbolName
		if(symbolName === null) return null

		val symbol = new SymbolInformationImpl
		symbol.name = symbolName
		symbol.kind = description.symbolKind
		return symbol
	}

	protected def String getSymbolName(IEObjectDescription description) {
		return description.qualifiedName.symbolName
	}

	protected def SymbolKind getSymbolKind(IEObjectDescription description) {
		return description.EClass.symbolKind
	}

	protected def String getSymbolName(QualifiedName qualifiedName) {
		return qualifiedName?.toString
	}

	protected def SymbolKind getSymbolKind(EClass type) {
		//TODO implement meaningful
		return SymbolKind.Property
	}

	protected def void doRead(IResourceAccess resourceAccess, URI objectURI, (EObject)=>void acceptor) {
		resourceAccess.readOnly(objectURI) [ resourceSet |
			val object = resourceSet.getEObject(objectURI, true)
			if (object !== null) {
				acceptor.apply(object)
			}
			return null
		]
	}

}
