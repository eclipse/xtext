/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.editor

import org.junit.Test

/**
 * TODO resolve type parameters in display strings
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Bug402716Test extends AbstractXbaseContentAssistBugTest {

	@Test
	def void testFilterType() throws Exception {
		newBuilder.append('#[].filter')
			.assertProposal('filter()')
			.withDisplayString('filter(Class<T> type) : Iterable<T> - IterableExtensions')
	}
	
	@Test
	def void testFilterLambda() throws Exception {
		newBuilder.append('#[].filter')
			.assertProposal('filter[]')
			.withDisplayString('filter((T)=>Boolean predicate) : Iterable<T> - IterableExtensions')
	}

	@Test
	def void testMapIterable() throws Exception {
		newBuilder.append('(#[] as Iterable<String>).map')
			.assertProposal('map[]')
			.withDisplayString('map((T)=>R transformation) : Iterable<R> - IterableExtensions')
	}

	@Test
	def void testMapListLiteral() throws Exception {
		newBuilder.append('#[].map')
			.assertProposal('map[]')
			.withDisplayString('map((T)=>R transformation) : List<R> - ListExtensions')
	}

	@Test
	def void testMapNewArrayList() throws Exception {
		newBuilder.append('newArrayList.map')
			.assertProposal('map[]')
			.withDisplayString('map((T)=>R transformation) : List<R> - ListExtensions')
	}

}