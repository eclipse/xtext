/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.common.util.URI
import org.eclipse.lsp4j.DocumentFormattingParams
import org.eclipse.lsp4j.FormattingOptions
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.formatting.FormattingService
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.StringInputStream
import org.junit.Assert
import org.junit.Test

/**
 * Tests for {@link FormattingService}
 * 
 * @author Christian Dietrich - Initial contribution and API
 */
class FormattingTest extends AbstractTestLangLanguageServerTest {
	
	@Test def void testFormattingService() {
		testFormatting [
			model = '''type Foo{int bar} type Bar{Foo foo}'''
			expectedText = '''
			type Foo{
				int bar
			}
			type Bar{
				Foo foo
			}
			'''
		]
	}
	
	@Test def void testFormattingService_02() {
		testFormatting([
			options = new FormattingOptions(4, true)
		]) [
			model = '''type Foo{int bar} type Bar{Foo foo}'''
			expectedText = '''
			type Foo{
			    int bar
			}
			type Bar{
			    Foo foo
			}
			'''
		]
	}
	
	@Test def void testFormattingClosedFile() {
		testFormatting [
		    it.filesInScope = #{
		        'foo.testlang' -> '''type Foo{int bar} type Bar{Foo foo}'''
		    }
			expectedText = '''
			type Foo{
				int bar
			}
			type Bar{
				Foo foo
			}
			'''
		]
	}
	
	@Test def void testRangeFormattingService() {
		testRangeFormatting [
			model = '''type Foo{int bar} type Bar{Foo foo}'''
			range = new Range => [
				start = new Position(0,0)
				end = new Position(0,17)
			]
			expectedText = '''
			type Foo{
				int bar
			} type Bar{Foo foo}'''
		]
	}
	
	@Test def void testRangeFormattingService_02() {
		testRangeFormatting([
			options = new FormattingOptions(4, true)
		]) [
			model = '''type Foo{int bar} type Bar{Foo foo}'''
			range = new Range => [
				start = new Position(0,0)
				end = new Position(0,17)
			]
			expectedText = '''
			type Foo{
			    int bar
			} type Bar{Foo foo}'''
		]
	}
	
	@Inject
	Provider<XtextResourceSet> rsp
	
	@Inject
	Provider<FormattingService2> fs2p
	
	@Test def void testAPIMaintenance_01() {
		val FormattingService2 fs2 = fs2p.get
		doTestAPIMaintenanceLayer(fs2)
	}
	
	@Inject
	Provider<FormattingService3> fs3p
	
	@Test def void testAPIMaintenance_02() {
		val FormattingService3 fs3 = fs3p.get
		doTestAPIMaintenanceLayer(fs3)
	}
	
	private def doTestAPIMaintenanceLayer(FormattingService fs) {
		val model = '''type Foo{int bar} type Bar{Foo foo}'''
		val rs = rsp.get
		val r = rs.createResource(URI.createURI("dummy.testlang")) as XtextResource
		r.load(new StringInputStream(model), null)
		try {
			fs.format(new Document(1,model), r, new DocumentFormattingParams, CancelIndicator.NullImpl)
			Assert.fail("IllegalStateException expected")
		} catch (IllegalStateException e) {
			if (e.message != "api maintenance layer broken") {
				throw e
			}
		}
	}
	
	static class FormattingService2 extends FormattingService {
		
		override format(XtextResource resource, Document document, int offset, int length) {
			throw new IllegalStateException("api maintenance layer broken")
		}
		
	}
	
	static abstract class AbstractCustomFormattingService extends FormattingService {
		
		override format(XtextResource resource, Document document, int offset, int length) {
			throw new IllegalStateException("api maintenance layer broken")
		}
		
	}
	
	static class FormattingService3 extends AbstractCustomFormattingService {
		
	}
	
}