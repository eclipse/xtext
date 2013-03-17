/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.editor

import org.junit.Ignore
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Bug403554Test extends AbstractXbaseContentAssistBugTest {

	@Test
	def void testProposalOnIt() throws Exception {
		newBuilder.append('newArrayList("") => [ it.')
			.assertProposal('subList()')
			.withDisplayString('subList(int fromIndex, int toIndex) : List<E> - AbstractList')
	}

	@Ignore
	@Test
	def void testProposalOnItWithExplicitParameters() throws Exception {
		newBuilder.append('newArrayList("") => [ it | it.')
			.assertProposal('subList()')
			.withDisplayString('subList(int fromIndex, int toIndex) : List<E> - AbstractList')
	}

	@Ignore
	@Test
	def void testProposalOnImplicitWithExplicitParameters() throws Exception {
		newBuilder.append('newArrayList("") => [ it | ')
			.assertProposal('subList()')
			.withDisplayString('subList(int fromIndex, int toIndex) : List<E> - AbstractList')
	}

	@Ignore
	@Test
	def void testProposalOnImplicit() throws Exception {
		newBuilder.append('newArrayList("") => [ ')
			.assertProposal('subList()')
			.withDisplayString('subList(int fromIndex, int toIndex) : List<E> - AbstractList')
	}

	@Test
	def void testProposalOnList() throws Exception {
		newBuilder.append('newArrayList("").')
			.assertProposal('subList()')
			.withDisplayString('subList(int fromIndex, int toIndex) : List<E> - AbstractList')
	}
	
}