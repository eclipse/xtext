/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.psi.tree

import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.IndexSink
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import java.io.IOException
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.psi.PsiEObject
import org.eclipse.xtext.psi.stubs.PsiEObjectStub
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.AbstractRule

class IGrammarAwareElementType extends IStubElementType<PsiEObjectStub, PsiEObject> {

	@Accessors
	val EObject grammarElement
	
	@Accessors
	val boolean inFragmentRule

	new(String debugName, Language language, EObject grammarElement) {
		super(debugName, language)
		this.grammarElement = grammarElement
		this.inFragmentRule = GrammarUtil.isEObjectFragmentRule(GrammarUtil.containingRule(grammarElement))
	}
	
	def AbstractRule getRule() {
		return GrammarUtil.containingRule(grammarElement)
	}
	
	override createPsi(PsiEObjectStub stub) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override createStub(PsiEObject psi, StubElement parentStub) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override deserialize(StubInputStream dataStream, StubElement parentStub) throws IOException {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getExternalId() {
		language + '.' + toString
	}
	
	override indexStub(PsiEObjectStub stub, IndexSink sink) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override serialize(PsiEObjectStub stub, StubOutputStream dataStream) throws IOException {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override shouldCreateStub(ASTNode node) {
		false
	}

}
