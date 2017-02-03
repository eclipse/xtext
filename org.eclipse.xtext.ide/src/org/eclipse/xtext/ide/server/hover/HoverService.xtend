/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.hover

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.lsp4j.Hover
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.ide.server.DocumentExtensions
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.parser.IParseResult
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.util.Pair
import org.eclipse.xtext.util.Tuples

import static java.util.Collections.*
import org.eclipse.lsp4j.jsonrpc.messages.Either

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
class HoverService {

	@Inject
	extension DocumentExtensions

	@Inject
	extension EObjectAtOffsetHelper

	@Inject
	extension ILocationInFileProvider

	@Inject
	extension IEObjectDocumentationProvider

	def Hover hover(XtextResource resource, int offset) {
		val pair = resource.getXtextElementAt(offset)
		if (pair === null || pair.first === null || pair.second === null) {
			return new Hover(Either.forRight(emptyList), null)
		}
		val element = pair.first
		
		val contents = getContents(element)
		if (contents === null)
			return new Hover(Either.forRight(emptyList), null)

		val ITextRegion textRegion = pair.second

		if (!textRegion.contains(offset))
			return new Hover(Either.forRight(emptyList), null)

		val range = resource.newRange(textRegion)
		return new Hover() => [ b |
    		b.range = range
		    b.contents = contents.map[Either.forLeft(it)]
		]
	}
	
	protected def List<? extends String> getContents(EObject element) {
	    val documentation = element.documentation
        if (documentation === null)
            return emptyList
        else
            #[documentation]
	}

	protected def Pair<EObject, ITextRegion> getXtextElementAt(XtextResource resource, int offset) {
		// check for cross reference
		val EObject crossLinkedEObject = resolveCrossReferencedElementAt(resource, offset);
		if (crossLinkedEObject !== null) {
			if (!crossLinkedEObject.eIsProxy()) {
				val IParseResult parseResult = resource.getParseResult();
				if (parseResult !== null) {
					var ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
					if(leafNode !== null && leafNode.isHidden() && leafNode.getOffset() == offset) {
						leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset - 1);
					}
					if (leafNode !== null) {
						val ITextRegion leafRegion = leafNode.getTextRegion();
						return Tuples.create(crossLinkedEObject, leafRegion);
					}
				}
			}
		} else {
			val EObject o = resource.resolveElementAt(offset);
			if (o !== null) {
				val ITextRegion region = o.getSignificantTextRegion();
				return Tuples.create(o, region);
			}
		}
		return null;
	}

}
