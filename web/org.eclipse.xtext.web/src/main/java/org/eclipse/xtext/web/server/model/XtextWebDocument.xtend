/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.XtextResource

class XtextWebDocument implements IXtextWebDocument {
	
	@Accessors(PUBLIC_GETTER)
	val String resourceId
	
	@Accessors(PUBLIC_GETTER)
	val XtextResource resource
	
	@Accessors(PUBLIC_GETTER)
	String text
	
	@Accessors
	boolean dirty
	
	new(XtextResource resource, String resourceId) {
		this.resource = resource
		this.resourceId = resourceId
		refresh()
	}
	
	protected def refresh() {
		text = resource.parseResult?.rootNode?.text ?: ''
		val stateId = computeStateId(text)
		resource.modificationStamp = stateId
	}
	
	override getStateId() {
		return Long.toString(resource.modificationStamp, 16)
	}
	
    protected def computeStateId(String text) {
    	var hash = 0l
        for (var i = 0; i < text.length; i++) {
            hash = 31 * hash + text.charAt(i)
        }
        return hash
    }
		
	override setText(String text) {
		resource.reparse(text)
		refresh()
	}
	
	override updateText(String text, int offset, int replaceLength) {
		resource.update(offset, replaceLength, text)
		refresh()
	}
	
}