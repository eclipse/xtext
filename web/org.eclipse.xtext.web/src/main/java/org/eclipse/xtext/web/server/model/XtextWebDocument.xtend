/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.validation.Issue

class XtextWebDocument implements IXtextWebDocument {
	
	@Accessors(PUBLIC_GETTER)
	val List<Issue> issues = newArrayList

	@Accessors(PUBLIC_GETTER)
	String resourceId
	
	@Accessors(PUBLIC_GETTER)
	XtextResource resource
	
	@Accessors(PUBLIC_GETTER)
	String text
	
	@Accessors
	boolean dirty
	
	@Accessors
	boolean processingCompleted
	
	@Accessors(PACKAGE_GETTER)
    @Inject DocumentSynchronizer synchronizer
    
	override toString() {
		if (resourceId !== null) {
			return class.simpleName + '(' + resourceId + ')'
		}
		super.toString()
	}
	
	def setInput(XtextResource resource, String resourceId) {
		this.resource = resource
		this.resourceId = resourceId
		refresh()
	}
	
	protected def refresh() {
		issues.clear()
		text = resource.parseResult?.rootNode?.text ?: ''
	}
	
	override getStateId() {
		return Long.toString(resource.modificationStamp, 16)
	}
		
	override setText(String text) {
		resource.reparse(text)
		refresh()
	}
	
	override updateText(String text, int offset, int replaceLength) {
		resource.update(offset, replaceLength, text)
		refresh()
	}
	
	override createNewStateId() {
		val newStateId = resource.modificationStamp + 1
		resource.modificationStamp = newStateId
	}
	
}