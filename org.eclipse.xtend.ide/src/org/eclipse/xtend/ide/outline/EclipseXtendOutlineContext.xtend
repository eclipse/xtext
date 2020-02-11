/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.outline

import org.eclipse.xtend.ide.common.outline.DefaultXtendOutlineContext
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ui.editor.outline.IOutlineNode

/**
 * @author kosyakov - Initial contribution and API
 */
@Accessors
class EclipseXtendOutlineContext extends DefaultXtendOutlineContext {

	IOutlineNode parentNode

	def withParentNode(IOutlineNode parentNode) {
		cloneContext => [ context |
			context.parentNode = parentNode
		]
	}

	override protected EclipseXtendOutlineContext cloneContext() {
		cloneContext(new EclipseXtendOutlineContext)
	}

	protected def cloneContext(EclipseXtendOutlineContext clonedContext) {
		super.cloneContext(clonedContext)
		clonedContext.parentNode = parentNode
		clonedContext
	}

}