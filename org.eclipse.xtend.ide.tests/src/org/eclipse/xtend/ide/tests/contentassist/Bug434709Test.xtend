/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Bug434709Test extends AbstractXtendContentAssistBugTest {
	
	@Test def void test_01() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  def static void main(String[] args) {
			    val out = new OutputStream {
							
				  override write(int b) throws IOException {
				    System.out.write(b)
				  }
				   
				  <|>
							
				  override flush() throws IOException {
				    System.out.flush
				  }
				}
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
}