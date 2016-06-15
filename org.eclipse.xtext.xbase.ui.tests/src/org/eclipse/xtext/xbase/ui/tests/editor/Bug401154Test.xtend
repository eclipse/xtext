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
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Bug401154Test extends AbstractXbaseContentAssistBugTest {

	@Test
	def void testImplicitReceiver() throws Exception {
		newBuilder.append('''
			switch it: new Object {
				CharSequence: 
		''')
			.assertProposal('length')
			.withDisplayString('length : int - CharSequence.length()')
	}
	
	@Test
	def void testLocalSwitchVariable() throws Exception {
		newBuilder.append('''
			switch it: new Object {
				CharSequence: 
		''')
			.assertProposal('it')
			.withDisplayString('it')
	}
	
	@Test
	def void testLocalSwitchVariableInDefault() throws Exception {
		newBuilder.append('''
			switch it: new Object {
				default: 
		''')
			.assertProposal('it')
			.withDisplayString('it')
	}
	
	@Test
	def void testImplicitReceiverInEmptyBlock() throws Exception {
		newBuilder.append('''
			switch it: new Object {
				CharSequence: {
		''')
			.assertProposal('length')
			.withDisplayString('length : int - CharSequence.length()')
	}
	
	@Test
	def void testImplicitReceiverInBlock() throws Exception {
		newBuilder.append('''
			switch it: new Object {
				CharSequence: { length 
		''')
			.assertProposal('length')
			.withDisplayString('length : int - CharSequence.length()')
	}
	
	@Test
	def void testNestedSwitchWithImplicitReceiverInBlock_01() throws Exception {
		newBuilder.append('''
			switch it: new Object {
				CharSequence: switch it {
					Appendable: { appe
		''')
			.assertProposal('append()')
	}
	
	@Test
	def void testNestedSwitchWithImplicitReceiverInBlock_02() throws Exception {
		newBuilder.append('''
			switch it: new Object {
				CharSequence: switch it {
					Appendable: { 
		''')
			.assertProposal('length')
			.withDisplayString('length : int - CharSequence.length()')
	}

	@Test
	def void testExplicitReceiver() throws Exception {
		newBuilder.append('''
			switch it: new Object {
				CharSequence: it.
		''')
			.assertProposal('length')
			.withDisplayString('length : int - CharSequence.length()')
	}

	@Test
	def void testKnownTypeIsSupertype() throws Exception {
		newBuilder.append('''
			switch it: new StringBuilder {
				CharSequence: 
		''')
			.assertProposal('charAt()')
			.withDisplayString('charAt(int index) : char - AbstractStringBuilder')
	}
	
	@Test
	def void testKnownTypeIsSupertype_02() throws Exception {
		newBuilder.append('''
			switch it: new StringBuilder {
				CharSequence: it.
		''')
			.assertProposal('charAt()')
			.withDisplayString('charAt(int index) : char - AbstractStringBuilder')
	}
}