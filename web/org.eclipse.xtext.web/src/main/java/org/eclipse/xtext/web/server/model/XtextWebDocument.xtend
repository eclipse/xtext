/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model

import java.util.concurrent.locks.ReentrantLock
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import com.google.inject.Singleton
import org.eclipse.xtext.web.server.InvalidRequestException

import static org.eclipse.xtext.web.server.InvalidRequestException.Type.*

class XtextWebDocument {
	
	@Accessors(PUBLIC_GETTER)
	val String resourceId
	
	val XtextResource resource
	
	String text
	
	// TODO generate on server?
	String stateId
	
	boolean dirty
	
	val lock = new ReentrantLock
	
	val readOnlyAccess = new ReadAccess(this)
	
	val modifyAccess = new ModifyAccess(this)
	
	new(XtextResource resource, String resourceId) {
		this.resource = resource
		this.resourceId = resourceId
		refresh()
	}
	
	protected def refresh() {
		text = resource.parseResult?.rootNode?.text ?: ''
	}
	
	def <T> T readOnly(IUnitOfWork<T, ReadAccess> work) {
		lock.lock()
		try {
			work.exec(readOnlyAccess)
		} finally {
			lock.unlock()
		}
	}
	
	def <T> T modify(IUnitOfWork<T, ModifyAccess> work) {
		lock.lock()
		try {
			work.exec(modifyAccess)
		} finally {
			lock.unlock()
		}
	}
	
	static class ReadAccess {
		protected val XtextWebDocument document
		
		private new(XtextWebDocument document) {
			this.document = document
		}
		
		def getDocument() {
			document
		}
		
		def getResource() {
			document.resource
		}
		
		def getText() {
			document.text
		}
		
		def getStateId() {
			document.stateId
		}
		
		def checkStateId(String requiredStateId) throws InvalidRequestException {
			if (requiredStateId !== null && requiredStateId != document.stateId) {
				throw new InvalidRequestException(INVALID_DOCUMENT_STATE, 'The given state id does not match the current state.')
			}
		}
		
		def isDirty() {
			document.dirty
		}
	}
	
	static class ModifyAccess extends ReadAccess {
		
		private new(XtextWebDocument document) {
			super(document)
		}
		
		def setText(String text) {
			document.resource.reparse(text)
			document.refresh()
		}
		
		def updateText(String text, int offset, int replaceLength) {
			document.resource.update(offset, replaceLength, text)
			document.refresh()
		}
		
		def setStateId(String stateId) {
			document.stateId = stateId
		}
		
		def setDirty(boolean dirty) {
			document.dirty = dirty
		}
	}
	
	@Singleton
	static class CreationLock {}
	
}