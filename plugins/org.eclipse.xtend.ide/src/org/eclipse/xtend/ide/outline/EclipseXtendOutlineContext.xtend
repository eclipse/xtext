/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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