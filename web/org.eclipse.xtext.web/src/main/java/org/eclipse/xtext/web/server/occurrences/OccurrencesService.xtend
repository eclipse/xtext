/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.occurrences

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.findReferences.IReferenceFinder
import org.eclipse.xtext.findReferences.TargetURIs
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.resource.IReferenceDescription
import org.eclipse.xtext.util.ITextRegionWithLineInformation
import org.eclipse.xtext.util.TextRegion
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess
import org.eclipse.xtext.web.server.util.CancelIndicatorProgressMonitor
import org.eclipse.xtext.web.server.util.ElementAtOffsetUtil

import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * Service class for finding occurrences.
 */
@Singleton
class OccurrencesService {
	
	@Inject extension ElementAtOffsetUtil  
	@Inject extension ILocationInFileProvider
	@Inject Provider<TargetURIs> targetURIsProvider
	@Inject extension IReferenceFinder 
	
	/**
	 * Find occurrences of the element at the given offset.
	 */
	def OccurrencesResult findOccurrences(XtextWebDocumentAccess document, int offset) {
		document.readOnly[ it, cancelIndicator |
			val element = resource.getElementAt(offset)
			val occurrencesResult = new OccurrencesResult(stateId)
			if (element !== null && filter(element)) {
				val elementURI = element.platformResourceOrNormalizedURI
				val targetURIs = targetURIsProvider.get()
				targetURIs.addURI(elementURI)
				val acceptor = new IReferenceFinder.Acceptor() {
					override accept(EObject source, URI sourceURI, EReference eReference, int index, EObject targetOrProxy, URI targetURI) {
						val region = source.getSignificantTextRegion(eReference, index)
						occurrencesResult.readRegions += new TextRegion(region.offset, region.length)
					}
					
					override accept(IReferenceDescription description) {
					}
				}
				findReferences(targetURIs, resource, acceptor, new CancelIndicatorProgressMonitor(cancelIndicator))
				if (element.eResource == resource) {
					val definitionRegion = element.significantTextRegion
					if (definitionRegion !== null && definitionRegion !== ITextRegionWithLineInformation.EMPTY_REGION)
						occurrencesResult.writeRegions += new TextRegion(definitionRegion.offset, definitionRegion.length)
				}
			}
			return occurrencesResult
		]
	}
	
	protected def boolean filter(EObject element) {
		// Don't proceed if the found element is the AST root
		element.eContainer !== null
	}
	
}