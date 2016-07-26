/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import io.typefox.lsapi.builders.RangeBuilder
import org.eclipse.xtext.ide.server.formatting.FormattingService
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
	
	@Test def void testRangeFormattingService() {
		testRangeFormatting [
			model = '''type Foo{int bar} type Bar{Foo foo}'''
			range = new RangeBuilder[
				start(0,0)
				end(0,17)
			].build
			expectedText = '''
			type Foo{
				int bar
			} type Bar{Foo foo}'''
		]
	}
	
}