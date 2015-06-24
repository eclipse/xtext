package org.eclipse.xtext.web.server.occurrences

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.findReferences.IReferenceFinder
import org.eclipse.xtext.findReferences.TargetURIs
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.resource.IReferenceDescription
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess
import org.eclipse.xtext.web.server.util.CancelIndicatorProgressMonitor
import org.eclipse.xtext.web.server.util.ElementAtOffsetUtil

import static extension org.eclipse.xtext.EcoreUtil2.*

@Log class OccurrencesService {
	
	@Inject extension ElementAtOffsetUtil  
	@Inject extension ILocationInFileProvider
	@Inject Provider<TargetURIs> targetURIsProvider
	@Inject extension IReferenceFinder 
	
	def OccurrencesResult findOccurrences(XtextWebDocumentAccess document, int offset) {
		document.readOnly[ it, cancelIndicator |
			val element = resource.getElementAt(offset)
			if(element != null) {
				val elementURI = element.platformResourceOrNormalizedURI
				val targetURIs = targetURIsProvider.get()
				targetURIs.addURI(elementURI)
				val readRegions = <ITextRegion>newArrayList
				val acceptor = new IReferenceFinder.Acceptor() {
					override accept(EObject source, URI sourceURI, EReference eReference, int index, EObject targetOrProxy, URI targetURI) {
						readRegions += source.getSignificantTextRegion(eReference, index)
					}
					
					override accept(IReferenceDescription description) {
					}
				}
				findReferences(targetURIs, resource, acceptor, new CancelIndicatorProgressMonitor(cancelIndicator))
				val definitionRegion = element.significantTextRegion
				val writeRegions = if(definitionRegion == null) emptyList else #[definitionRegion]
				val occurrencesResult = new OccurrencesResult(readRegions, writeRegions)
				LOG.trace(occurrencesResult.toString)
				return occurrencesResult
			}
			return null
		]
	}	
	
	
}