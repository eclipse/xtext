/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.junit.Before
import org.junit.Ignore
import org.junit.Test

import static org.eclipse.xtext.util.JavaVersion.*

/**
 * This test class is disabled due to https://bugs.eclipse.org/bugs/show_bug.cgi?id=463547
 * ({@link AbstractXtendUITestCase#setJavaVersion(JavaVersion)} uses {@link org.junit.Assume})
 * 
 * @author Miro Spoenemann - Initial contribution and API
 */
@Ignore
class Bug460093Test extends AbstractXtendContentAssistBugTest {
	
	@Before
	def prepareJavaVersion() {
		javaVersion = JAVA8
	}

	@Test def void testMethodOverrides1() {
		newBuilder.append('''
			import java.util.List
			
			interface I extends List<String> {

				str''')
			.assertText("\n\toverride stream() {\n\t\tList.super.stream()\n\t}")
			.applyProposal
			.expectContent('''
			import java.util.List
			
			interface I extends List<String> {

				override stream() {
					List.super.stream()
				}''')
	}

	@Test def void testMethodOverrides2() {
		newBuilder.append('''
			import java.util.Comparator
			
			interface I extends Comparator<String> {

				r''')
			.assertText("\n\toverride reversed() {\n\t\tComparator.super.reversed()\n\t}")
			.applyProposal
			.expectContent('''
			import java.util.Comparator
			
			interface I extends Comparator<String> {

				override reversed() {
					Comparator.super.reversed()
				}''')
	}

}
