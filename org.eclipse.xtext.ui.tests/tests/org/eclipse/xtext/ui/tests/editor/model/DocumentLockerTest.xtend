/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.model

import com.google.inject.Provider
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.parser.antlr.Lexer
import org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.ui.editor.model.XtextDocument
import org.eclipse.xtext.ui.editor.model.edit.ITextEditComposer
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork
import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
class DocumentLockerTest extends AbstractXtextDocumentTest {
	
	@Test def void testNoUpdateContentProcessOnReentrant(){
		val s = newArrayList
		val document = new XtextDocument(createTokenSource, createTextEditComposer, outdatedStateManager, operationCanceledManager) {
			override protected boolean updateContentBeforeRead() {
				s += 'x'
			}
		}
		document.input = new XtextResource => [
			new XtextResourceSet().resources += it
		]
		assertEquals(0, s.size)
		document.readOnly [
			assertEquals(1, s.size)
			document.readOnly [
				assertEquals(1, s.size)
				document.readOnly [
					assertEquals(1, s.size)
					return null
				]
				return null
			]
			return null
		]
		assertEquals(1, s.size)
	}

	@Test def void testModifySetsOutdatedFalse() {
		val document = new XtextDocument(createTokenSource, createTextEditComposer, outdatedStateManager, operationCanceledManager)
		val resource = new XtextResource => [
			new XtextResourceSet().resources += it
		]
		document.input = resource
		document.internalModify [
			assertFalse(document.cancelIndicator.isCanceled())
			null
		]
		val indicator = document.cancelIndicator
		assertFalse(indicator.isCanceled())
		document.set("fupp");
		assertTrue(indicator.isCanceled())
		document.internalModify [
			assertFalse(document.cancelIndicator.isCanceled())
			null
		]
	}
	
	@Test def void testPriorityReadOnlyCancelsReaders() {
		val document = new XtextDocument(createTokenSource(), null, outdatedStateManager, operationCanceledManager)
		document.input = new XtextResource => [
			new XtextResourceSet().resources += it
		]
		val boolean[] check = newBooleanArrayOfSize(1) 
		val thread = new Thread([
			document.readOnly(new CancelableUnitOfWork<Object, XtextResource>() {
				override Object exec(XtextResource state, CancelIndicator cancelIndicator) throws Exception {
					check.set(0,true)
					val wait = 4000;
					var i = 0;
					while (!cancelIndicator.isCanceled) {
						Thread.sleep(10l)
						if (i > wait)
							throw new InterruptedException();
						i = i + 1;
					}
					return null;
				}
				
			})
		])
		thread.start
		while (!check.get(0)) {
			Thread.sleep(1)
		}
		document.priorityReadOnly[
			null
		]
		assertFalse(thread.interrupted)
	}
	
	@Test def void testReadOnlyDoesntCancelReaders() {
		val document = new XtextDocument(createTokenSource(), null, outdatedStateManager, operationCanceledManager)
		document.input = new XtextResource => [
			new XtextResourceSet().resources += it
		]
		val cancelIndicators = newArrayList
		document.addReaderCancelationListener(cancelIndicators)
		assertTrue(cancelIndicators.empty)
		document.readOnly[]
		assertTrue(cancelIndicators.empty)
		document.readOnly[]
		assertTrue(cancelIndicators.empty)
	}
	
	private def DocumentTokenSource createTokenSource() {
		val tokenSource = new DocumentTokenSource
		tokenSource.lexer = new Provider<Lexer>() {
			override get() {
				new InternalXtextLexer()
			}
		}
		tokenSource
	}
	
	private def createTextEditComposer() {
		new ITextEditComposer() {
			override beginRecording(Resource resource) {
			}
			
			override endRecording() {
				null
			}
			
			override getTextEdit() {
				null
			}
		}
	}
	
	private def addReaderCancelationListener(IXtextDocument document, List<CancelIndicator> cancelIndicators) {
		document.addModelListener [
			val CancelableUnitOfWork<Boolean, XtextResource> work = [
				state, cancelIndicator | 
				assertFalse(cancelIndicator.isCanceled)
				cancelIndicators += cancelIndicator
			]
			document.readOnly(work)
		]
	} 
}