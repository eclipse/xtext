/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.lsp4j.Location
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.ITextRegion

import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.*

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
class DocumentExtensions {

	@Inject
	extension UriExtensions

	@Inject
	ILocationInFileProvider locationInFileProvider

	def Position newPosition(Resource resource, int offset) {
		if (resource instanceof XtextResource) {
			val rootNode = resource.parseResult.rootNode
			val lineAndColumn = rootNode.getLineAndColumn(offset)
			return new Position(lineAndColumn.line - 1, lineAndColumn.column - 1)
		}
		return null
	}

	def Range newRange(Resource resource, int startOffset, int endOffset) {
		val startPosition = resource.newPosition(startOffset)
		if (startPosition === null) {
			return null
		}
		val endPosition = resource.newPosition(endOffset)
		if (endPosition === null) {
			return null
		}
		return new Range(startPosition, endPosition)
	}

	def Range newRange(Resource resource, ITextRegion region) {
		if (region === null) return null
		return resource.newRange(region.offset, region.offset + region.length)
	}

	def Location newLocation(Resource resource, ITextRegion textRegion) {
		val range = resource.newRange(textRegion)
		if (range === null) {
			return null
		}
		val uri = resource.URI.toUriString
		return new Location(uri, range)
	}

	def Location newLocation(EObject object) {
		val resource = object.eResource
		val textRegion = locationInFileProvider.getSignificantTextRegion(object)
		return resource.newLocation(textRegion)
	}

	def Location newLocation(EObject owner, EStructuralFeature feature, int indexInList) {
		val resource = owner.eResource
		val textRegion = locationInFileProvider.getSignificantTextRegion(owner, feature, indexInList)
		return resource.newLocation(textRegion)
	}

}
