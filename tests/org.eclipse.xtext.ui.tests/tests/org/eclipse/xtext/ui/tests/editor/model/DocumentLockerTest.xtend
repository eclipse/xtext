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
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.ui.editor.model.XtextDocument
import org.eclipse.xtext.ui.editor.model.edit.ITextEditComposer
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
class DocumentLockerTest extends AbstractXtextDocumentTest {
	
	@Test def void testNoUpdateContentProcessOnReentrant(){
		val s = newArrayList
		val document = new XtextDocument(createTokenSource, createTextEditComposer) {
			override protected boolean updateContentBeforeRead() {
				s += 'x'
			}
		}
		document.input = new XtextResource
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

	@Test def void testModifyCancelsReaders() {
		val document = new XtextDocument(createTokenSource, createTextEditComposer)
		document.input = new XtextResource
		val cancelIndicators = newArrayList
		document.addReaderCancelationListener(cancelIndicators)
		assertTrue(cancelIndicators.empty)
		document.internalModify[
			assertTrue(cancelIndicators.empty)
			null
		]
		assertEquals(1, cancelIndicators.size)
		assertFalse(cancelIndicators.head.isCanceled)
		document.internalModify[
			assertEquals(1, cancelIndicators.size)
			assertTrue(cancelIndicators.head.isCanceled)
			null
		]
		assertEquals(2, cancelIndicators.size)
		assertTrue(cancelIndicators.head.isCanceled)
		assertFalse(cancelIndicators.last.isCanceled)
	}
	
	@Test def void testPriorityReadOnlyCancelsReaders() {
		val document = new XtextDocument(createTokenSource(), null)
		document.input = new XtextResource
		val cancelIndicators = newArrayList
		document.addReaderCancelationListener(cancelIndicators)
		assertTrue(cancelIndicators.empty)
		document.priorityReadOnly[
			assertTrue(cancelIndicators.empty)
			null
		]
		assertEquals(1, cancelIndicators.size)
		assertFalse(cancelIndicators.head.isCanceled)
		document.priorityReadOnly[
			assertEquals(1, cancelIndicators.size)
			assertTrue(cancelIndicators.head.isCanceled)
			null	
		]
		assertEquals(2, cancelIndicators.size)
		assertTrue(cancelIndicators.head.isCanceled)
		assertFalse(cancelIndicators.last.isCanceled)
	}
	
	@Test def void testReadOnlyDoesntCancelReaders() {
		val document = new XtextDocument(createTokenSource(), null)
		document.input = new XtextResource
		val cancelIndicators = newArrayList
		document.addReaderCancelationListener(cancelIndicators)
		assertTrue(cancelIndicators.empty)
		document.readOnly[]
		assertTrue(cancelIndicators.empty)
		document.readOnly[]
		assertTrue(cancelIndicators.empty)
	}
	
	@Test def void testReadOnlyCancelsReadersIfChangesArePending() {
		val documentWithPermanentlyPendingChanges = new XtextDocument(createTokenSource(), null) {
			XtextDocumentLocker locker
	
			override protected updateContentBeforeRead() {
				locker.process[true] // shortcut for what the reconciler usually does
			}
			
			override protected hasPendingUpdates() {
				true
			}
			
			override protected createDocumentLocker() {
				locker = super.createDocumentLocker()
				locker
			}
		}
		documentWithPermanentlyPendingChanges.input = new XtextResource
		val cancelIndicators = newArrayList
		documentWithPermanentlyPendingChanges.addReaderCancelationListener(cancelIndicators)
		documentWithPermanentlyPendingChanges.readOnly [
			assertTrue(cancelIndicators.empty)
			null
		]
		assertEquals(1, cancelIndicators.size)
		assertFalse(cancelIndicators.head.isCanceled)
		documentWithPermanentlyPendingChanges.readOnly [
			assertEquals(1, cancelIndicators.size)
			assertTrue(cancelIndicators.head.isCanceled)
			null
		]
		assertEquals(2, cancelIndicators.size)
		assertTrue(cancelIndicators.head.isCanceled)
		assertFalse(cancelIndicators.last.isCanceled)
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