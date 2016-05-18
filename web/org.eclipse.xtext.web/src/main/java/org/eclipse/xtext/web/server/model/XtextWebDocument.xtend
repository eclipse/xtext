/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model

import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.web.server.IServiceResult

/**
 * Container for an {@link XtextResource}.
 */
@Log
@FinalFieldsConstructor
class XtextWebDocument implements IXtextWebDocument {
	
	@Accessors(PUBLIC_GETTER)
	val String resourceId
	
	@Accessors(PACKAGE_GETTER)
    val DocumentSynchronizer synchronizer
	
	@Accessors(PUBLIC_GETTER)
	XtextResource resource
	
	@Accessors(PUBLIC_GETTER)
	String text
	
	@Accessors
	boolean dirty
    
    val Map<Class<?>, IServiceResult> cachedServiceResults = newHashMap
    
    /**
     * Clear any cached result of {@link AbstractCachedService}. This method is called whenever the text
     * content of the resource is modified, but it may be necessary to clear the cached services in other
     * cases, too.
     */
	def clearCachedServiceResults() {
		cachedServiceResults.clear
	}
	
	def <T extends IServiceResult> T getCachedServiceResult(AbstractCachedService<T> service,
			CancelIndicator cancelIndicator, boolean logCacheMiss) {
		cachedServiceResults.get(service.class) as T ?: {
			if (logCacheMiss)
				LOG.trace("Cache miss for " + service.class.simpleName)
			val result = service.compute(this, cancelIndicator)
			cachedServiceResults.put(service.class, result)
			result
		}
	}
    
	override toString() {
		if (resourceId !== null) {
			return class.simpleName + '(' + resourceId + ')'
		}
		super.toString()
	}
	
	def setInput(XtextResource resource) {
		clearCachedServiceResults()
		this.resource = resource
		refreshText()
	}
	
	protected def refreshText() {
		text = resource.parseResult?.rootNode?.text ?: ''
	}
	
	override getStateId() {
		return Long.toString(resource.modificationStamp, 16)
	}
	
	/**
	 * Replace the text contents of the contained resource with the given text.
	 */
	override setText(String text) {
		clearCachedServiceResults()
		resource.reparse(text)
		refreshText()
	}
	
	/**
	 * Update a part of the text.
	 */
	override updateText(String text, int offset, int replaceLength) {
		clearCachedServiceResults()
		resource.update(offset, replaceLength, text)
		refreshText()
	}
	
	/**
	 * A new state id should be created whenever the text content is changed. The client must know
	 * the correct state id in order to send proper requests. If a request with an outdated state id
	 * is received by the server, the request is rejected.
	 */
	override createNewStateId() {
		val newStateId = resource.modificationStamp + 1
		resource.modificationStamp = newStateId
	}
	
}