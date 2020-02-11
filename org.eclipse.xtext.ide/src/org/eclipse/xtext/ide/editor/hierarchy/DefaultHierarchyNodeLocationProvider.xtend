/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.hierarchy

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.util.ITextRegionWithLineInformation
import org.eclipse.xtext.util.TextRegionWithLineInformation

import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.*

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Singleton
class DefaultHierarchyNodeLocationProvider implements IHierarchyNodeLocationProvider {

	@Inject
	protected ILocationInFileProvider locationInFileProvider

	override getTextRegion(EObject obj) {
		if(obj === null) return ITextRegionWithLineInformation.EMPTY_REGION

		val textRegion = locationInFileProvider.getSignificantTextRegion(obj)
		return obj.toTextRegionWithLineInformation(textRegion)
	}

	override getTextRegion(EObject owner, EStructuralFeature feature, int indexInList) {
		if(owner === null) return ITextRegionWithLineInformation.EMPTY_REGION

		val textRegion = locationInFileProvider.getSignificantTextRegion(owner, feature, indexInList)
		return owner.toTextRegionWithLineInformation(textRegion)
	}

	protected def toTextRegionWithLineInformation(EObject obj, ITextRegion textRegion) {
		if (textRegion === null)
			return ITextRegionWithLineInformation.EMPTY_REGION

		if (textRegion instanceof ITextRegionWithLineInformation)
			return textRegion

		val node = obj.node
		if (node === null) {
			return new TextRegionWithLineInformation(textRegion.offset, textRegion.length, 0, 0)
		}
		val startLine = node.getLineAndColumn(textRegion.offset).line - 1
		val endLine = node.getLineAndColumn(textRegion.offset + textRegion.length).line - 1
		return new TextRegionWithLineInformation(textRegion.offset, textRegion.length, startLine, endLine)
	}

}
