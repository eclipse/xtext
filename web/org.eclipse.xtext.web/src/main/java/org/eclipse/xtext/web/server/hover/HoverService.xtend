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
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.ide.labels.AlternativeImageDescription
import org.eclipse.xtext.ide.labels.DecoratedImageDescription
import org.eclipse.xtext.ide.labels.IImageDescription
import org.eclipse.xtext.ide.labels.IImageDescriptionProvider
import org.eclipse.xtext.ide.labels.INameLabelProvider
import org.eclipse.xtext.ide.labels.SimpleImageDescription
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess
import org.eclipse.xtext.web.server.util.ElementAtOffsetUtil

/**
 * Service class for mouse hover information.
 */
@Singleton
class HoverService {

	@Inject extension ElementAtOffsetUtil
	@Inject extension IEObjectDocumentationProvider
	@Inject extension IImageDescriptionProvider
	@Inject extension INameLabelProvider
	@Inject extension OperationCanceledManager

	/**
	 * Compute a hover result at the given offset in the document.
	 */
	def HoverResult getHover(XtextWebDocumentAccess document, int offset) {
		document.readOnly [ it, cancelIndicator |
			val element = resource.getElementAt(offset)
			val nameLabel = element?.nameLabel?.surroundWithDiv('element-name')
			if (nameLabel != null) {
				cancelIndicator.checkCanceled
				val titleHtml = element.imageDescription.addIconDivs(nameLabel).surroundWithDiv('xtext-hover')
				cancelIndicator.checkCanceled
				val bodyHtml = (element.documentation ?: '').surroundWithDiv('xtext-hover')
				return new HoverResult(stateId, titleHtml, bodyHtml)
			} else {
				return new HoverResult(stateId)
			}
		]
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
		<div class="«divClasses.map[it].join(' ')»">
			«html»
		</div>
	'''
	
}