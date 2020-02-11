/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList
import org.eclipse.xtext.formatting2.internal.tests.FormatterTestLanguageInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.util.Wrapper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(FormatterTestLanguageInjectorProvider)
class FormattingConflictTest {
	@Inject extension GenericFormatterTester

	// @Inject extension FormatterTestLanguageGrammarAccess
	@Test def void enableDebugTracingTrue() {
		val wrapper = new Wrapper<Throwable>
		val execution = new Wrapper<Integer>(0)
		assertFormatted[
			toBeFormatted = '''
				idlist a
			'''
			formatter = [ IDList model, extension regions, extension document |
				execution.set(execution.get + 1)
				model.regionFor.keyword("idlist").append[space = " "]
				model.regionFor.keyword("idlist").append[space = "\t"]
			]
			request.enableDebugTracing = true
			request.exceptionHandler = [ e |
				wrapper.set(e)
			]
		]
		val exception = wrapper.get as ConflictingRegionsException
		Assert.assertEquals(1, execution.get)
		Assert.assertEquals(2, exception.traces.size)
	}

	@Test def void enableDebugTracingFalse() {
		val wrapper = new Wrapper<Throwable>
		val execution = new Wrapper<Integer>(0)
		assertFormatted[
			toBeFormatted = '''
				idlist a
			'''
			formatter = [ IDList model, extension regions, extension document |
				execution.set(execution.get + 1)
				model.regionFor.keyword("idlist").append[space = " "]
				model.regionFor.keyword("idlist").append[space = "\t"]
			]
			request.enableDebugTracing = false
			request.exceptionHandler = [ e |
				wrapper.set(e)
			]
		]
		val exception = wrapper.get as ConflictingRegionsException
		Assert.assertEquals(2, execution.get)
		Assert.assertEquals(2, exception.traces.size)
	}

}
