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
import io.typefox.lsapi.Hover
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.ide.server.DocumentExtensions
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.resource.XtextResource

import static io.typefox.lsapi.util.LsapiFactories.*

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
		val element = resource.resolveElementAt(offset)
		if (element === null)
			return emptyHover

		val documentation = element.documentation
		if (documentation === null)
			return emptyHover

		val contents = #[newMarkedString(documentation, null)]
		
		val containedElement = resource.resolveContainedElementAt(offset)
		val textRegion = containedElement.significantTextRegion
		if (textRegion === null)
			return newHover(contents, null)

		if (!textRegion.contains(offset))
			return emptyHover

		val range = resource.newRange(textRegion)
		return newHover(contents, range)
	}

}
