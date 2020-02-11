/*******************************************************************************
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.hover

import com.google.common.annotations.Beta
import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.EObject
import org.eclipse.lsp4j.Hover
import org.eclipse.lsp4j.MarkupContent
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextDocumentPositionParams
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.DocumentExtensions
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.ITextRegion

import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.*

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
@Beta
class HoverService implements IHoverService {

	@Inject
	extension DocumentExtensions

	@Inject
	extension EObjectAtOffsetHelper

	@Inject
	extension ILocationInFileProvider

	@Inject
	extension IEObjectDocumentationProvider
	
	override Hover hover(
		Document document, 
		XtextResource resource, 
		TextDocumentPositionParams params,
		CancelIndicator cancelIndicator
	) {
		val offset = document.getOffSet(params.position)
		val context = createContext(document, resource, offset)
		return context.hover
	}

	protected def HoverContext createContext(Document document, XtextResource resource, int offset) {
		val crossLinkedEObject = resource.resolveCrossReferencedElementAt(offset)
		if (crossLinkedEObject !== null) {
			if(crossLinkedEObject.eIsProxy) return null

			val parseResult = resource.parseResult
			if(parseResult === null) return null

			var leafNode = parseResult.rootNode.findLeafNodeAtOffset(offset)
			if (leafNode !== null && leafNode.hidden && leafNode.offset == offset) {
				leafNode = parseResult.rootNode.findLeafNodeAtOffset(offset - 1)
			}
			if(leafNode === null) return null

			val leafRegion = leafNode.textRegion
			return new HoverContext(document, resource, offset, leafRegion, crossLinkedEObject)
		}
		val element = resource.resolveElementAt(offset);
		if(element === null) return null

		val region = element.significantTextRegion
		return new HoverContext(document, resource, offset, region, element)
	}

	protected def Hover hover(HoverContext context) {
		if (context === null) return EMPTY_HOVER
		
		val contents = context.markupContent
		if(contents === null) return EMPTY_HOVER

		val range = context.range
		if(range === null) return EMPTY_HOVER

		return new Hover(contents, range)
	}

	protected def Range getRange(HoverContext it) {
		if(!region.contains(offset)) return null

		return resource.newRange(region)
	}

	protected def MarkupContent getMarkupContent(HoverContext it) {
		return toMarkupContent(kind, element.contents)
	}

	protected def String getKind(HoverContext it) {
		return "markdown"
	}

	protected def MarkupContent toMarkupContent(String kind, String value) {
		return new MarkupContent(kind, value)
	}

	def String getContents(EObject element) {
		if(element === null) return ""

		val documentation = element.documentation
		if(documentation === null) return ""

		return documentation
	}

}

@Accessors
@FinalFieldsConstructor
class HoverContext {
	val Document document
	val XtextResource resource
	val int offset
	val ITextRegion region
	val EObject element
}
