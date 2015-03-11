/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.parser

import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import org.eclipse.xtext.idea.lang.CreateElementType

import static org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder.*

class CompositeMarker {

	val int lookAhead

	val IElementType elementType

	val PsiBuilder.Marker marker

	new(PsiBuilder.Marker marker, int lookAhead, IElementType elementType) {
		this.marker = marker
		this.lookAhead = lookAhead
		this.elementType = elementType
	}

	def precede(IElementType elementType) {
		new CompositeMarker(marker.precede, lookAhead, elementType)
	}

	def void done() {
		marker.done(elementType.withUserData)
	}

	protected def withUserData(IElementType elementType) {
		new CreateElementType(elementType) [
			putUserData(LOOK_AHEAD_KEY, lookAhead)
		]
	}

}