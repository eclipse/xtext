/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.psi.stubs

import com.intellij.lang.Language
import com.intellij.psi.stubs.IndexSink
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import com.intellij.psi.tree.IStubFileElementType
import java.io.IOException
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.idea.lang.IXtextLanguage

class XtextFileElementType<T extends XtextFileStub<?>> extends IStubFileElementType<T> {

	new(Language language) {
		super(language)
		if (language instanceof IXtextLanguage) {
			language.injectMembers(this)
		}
	}

	override getExternalId() {
		'''«language.ID».FILE'''
	}

	override serialize(T stub, StubOutputStream it) throws IOException {
		writeURI(stub.uri)
	}
	
	protected def writeURI(StubOutputStream it, URI uri) {
		writeUTF(uri.toString)
	} 
	

	override deserialize(StubInputStream it, StubElement parentStub) throws IOException {
		val stub = new XtextFileStub(null, this)
		stub.uri = readURI
		stub as T
	}
	
	protected def readURI(StubInputStream it) {
		URI.createURI(readUTF)	
	}
	
	override indexStub(T stub, IndexSink sink) {
	}
	
}
