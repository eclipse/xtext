/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.editor

import java.util.ArrayList
import org.junit.Test
import org.junit.Ignore

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Bug403554Test extends AbstractXbaseContentAssistBugTest {

	String declarator 

	override setUp() throws Exception {
		super.setUp()
		val project = getJavaProject(null)
		var type = project.findType(ArrayList.name)
		var method = type.getMethod('subList', #['I', 'I'])
		while(!method.exists) {
			var superclassName = type.superclassName
			val idx = superclassName.indexOf('<')
			if (idx != -1) {
				superclassName = superclassName.substring(0, idx)
			}
			type = project.findType(superclassName)
			method = type.getMethod('subList', #['I', 'I'])
		}
		declarator = type.elementName
	}

	@Test
	def void testProposalOnIt() throws Exception {
		newBuilder.append('newArrayList("") => [ it.')
			.assertProposal('subList()')
			.withDisplayString('subList(int fromIndex, int toIndex) : List<E> - ' + declarator)
	}

	@Ignore
	@Test
	def void testProposalOnItWithExplicitParameters() throws Exception {
		newBuilder.append('newArrayList("") => [ it | it.')
			.assertProposal('subList()')
			.withDisplayString('subList(int fromIndex, int toIndex) : List<E> - ' + declarator)
	}

	@Ignore
	@Test
	def void testProposalOnImplicitWithExplicitParameters() throws Exception {
		newBuilder.append('newArrayList("") => [ it | ')
			.assertProposal('subList()')
			.withDisplayString('subList(int fromIndex, int toIndex) : List<E> - ' + declarator)
	}

	@Ignore
	@Test
	def void testProposalOnImplicit() throws Exception {
		newBuilder.append('newArrayList("") => [ ')
			.assertProposal('subList()')
			.withDisplayString('subList(int fromIndex, int toIndex) : List<E> - ' + declarator)
	}

	@Test
	def void testProposalOnList() throws Exception {
		newBuilder.append('newArrayList("").')
			.assertProposal('subList()')
			.withDisplayString('subList(int fromIndex, int toIndex) : List<E> - ' + declarator)
	}
	
}