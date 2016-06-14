/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.hover

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor
import org.eclipse.xtext.ide.labels.AlternativeImageDescription
import org.eclipse.xtext.ide.labels.DecoratedImageDescription
import org.eclipse.xtext.ide.labels.IImageDescription
import org.eclipse.xtext.ide.labels.IImageDescriptionProvider
import org.eclipse.xtext.ide.labels.INameLabelProvider
import org.eclipse.xtext.ide.labels.SimpleImageDescription
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.util.Wrapper
import org.eclipse.xtext.web.server.InvalidRequestException
import org.eclipse.xtext.web.server.contentassist.ContentAssistService
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess
import org.eclipse.xtext.web.server.util.ElementAtOffsetUtil
import org.eclipse.xtext.resource.IEObjectDescription

/**
 * Service class for mouse hover information. Such information can be created for an already
 * existing model element or for an element proposed through content assist.
 */
@Singleton
class HoverService {

	@Inject extension ElementAtOffsetUtil
	@Inject extension IEObjectDocumentationProvider
	@Inject extension IImageDescriptionProvider
	@Inject extension INameLabelProvider
	@Inject extension OperationCanceledManager
	@Inject ContentAssistService contentAssistService

	/**
	 * Compute a hover result at the given offset in the document.
	 */
	def HoverResult getHover(XtextWebDocumentAccess document, int offset) throws InvalidRequestException {
		document.readOnly[ it, cancelIndicator |
			val element = resource.getElementAt(offset)
			createHover(element, stateId, cancelIndicator)
		]
	}

	/**
	 * Compute a hover result for a content assist proposal at the given offset.
	 */
	def HoverResult getHover(XtextWebDocumentAccess document, String proposal, ITextRegion selection,
			int offset) throws InvalidRequestException {
		document.readOnly[ it, cancelIndicator |
			val contexts = contentAssistService.getContexts(it, selection, offset)
			val proposedElement = new Wrapper<Object>
			contentAssistService.proposalProvider.createProposals(contexts, new IIdeContentProposalAcceptor {
				override accept(ContentAssistEntry entry, int priority) {
					cancelIndicator.checkCanceled
					if (entry !== null && entry.source !== null && entry.proposal == proposal)
						proposedElement.set(entry.source)
				}
				override canAcceptMoreProposals() {
					proposedElement.get === null
				}
			})
			createHover(proposedElement.get, stateId, cancelIndicator)
		]
	}
	
	protected def HoverResult createHover(Object element, String stateId, CancelIndicator cancelIndicator) {
		val nameLabel = element?.nameLabel?.surroundWithDiv('element-name')
		if (nameLabel !== null) {
			cancelIndicator.checkCanceled
			val titleHtml = element.imageDescription.addIconDivs(nameLabel).surroundWithDiv('xtext-hover')
			cancelIndicator.checkCanceled
			val eobject = switch element {
				EObject: element
				IEObjectDescription: element.EObjectOrProxy
			}
			var String bodyHtml = ''
			if (eobject !== null && !eobject.eIsProxy) {
				val documentation = eobject.documentation
				if (documentation !== null)
					bodyHtml = documentation.surroundWithDiv('xtext-hover')
			}
			return new HoverResult(stateId, titleHtml, bodyHtml)
		}
		return new HoverResult(stateId)
	}

	protected def String addIconDivs(IImageDescription it, String nameHtml) {
		switch it {
			SimpleImageDescription:
				nameHtml.surroundWithDiv(imageID + '-icon')
			AlternativeImageDescription:
				nameHtml.surroundWithDiv(imageIDs.map[it + '-icon'])
			DecoratedImageDescription:
				(decorators + #[baseImage]).fold(nameHtml, [$1.addIconDivs($0)])
		}
	}

	protected def String surroundWithDiv(String html, String... divClasses) '''
		<div«IF divClasses.length > 0» class="«divClasses.join(' ')»"«ENDIF»>
			«html»
		</div>
	'''
	
}