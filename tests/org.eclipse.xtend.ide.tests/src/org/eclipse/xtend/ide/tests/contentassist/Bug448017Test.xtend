/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Bug448017Test extends AbstractXtendContentAssistBugTest {
	
	/*
	 * we have two pairs of very similar test cases here because the results were dependent on the hashCode
	 */
	
	@Test def void test_01a() throws Exception {
		newBuilder.append('''
			class MyBean {
				String myField2
			
				def String getMyField2() {
					return myField2
				}	
				def void m() {
					this.<|>
				}
			}
		''')
			.assertProposalDisplayedAtCursor('getMyField2 : String - MyBean.getMyField2()')
	}
	
	@Test def void test_01b() throws Exception {
		newBuilder.append('''
			class MyBean {
				String myField
			
				def String getMyField() {
					return myField
				}	
				def void m() {
					this.<|>
				}
			}
		''')
			.assertProposalDisplayedAtCursor('getMyField : String - MyBean.getMyField()')
	}
	
	@Test def void test_02a() throws Exception {
		newBuilder.append('''
			class MyBean {
				String myField2
			
				def String getMyField2() {
					return myField
				}	
				def void m() {
					this.<|>
				}
			}
		''')
			.assertProposalDisplayedAtCursor('myField2 : String - MyBean')
	}
	
	@Test def void test_02b() throws Exception {
		newBuilder.append('''
			class MyBean {
				String myField
			
				def String getMyField() {
					return myField
				}	
				def void m() {
					this.<|>
				}
			}
		''')
			.assertProposalDisplayedAtCursor('myField : String - MyBean')
	}
	
}