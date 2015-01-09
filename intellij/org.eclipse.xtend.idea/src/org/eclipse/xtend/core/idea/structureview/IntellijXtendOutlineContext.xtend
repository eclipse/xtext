/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.structureview

import org.eclipse.xtend.ide.common.outline.DefaultXtendOutlineContext
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.structureview.ModifiableStructureViewTreeElement
import org.eclipse.xtext.psi.impl.BaseXtextFile

/**
 * @author kosyakov - Initial contribution and API
 */
@Accessors
class IntellijXtendOutlineContext extends DefaultXtendOutlineContext {
	
	BaseXtextFile xtextFile
	
	ModifiableStructureViewTreeElement structureViewTreeElement
	
	def withStructureViewTreeElement(ModifiableStructureViewTreeElement structureViewTreeElement) {
		this.structureViewTreeElement.addChild(structureViewTreeElement)
		cloneContext => [ context |
			context.structureViewTreeElement = structureViewTreeElement
		]
	}
	
	override protected IntellijXtendOutlineContext cloneContext() {
		cloneContext(new IntellijXtendOutlineContext)
	}
	
	def protected cloneContext(IntellijXtendOutlineContext clonedContext) {
		super.cloneContext(clonedContext)
		clonedContext.xtextFile = xtextFile
		clonedContext.structureViewTreeElement = structureViewTreeElement
		clonedContext
	}
	
}