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
class Bug435184Test extends AbstractXtendContentAssistBugTest {
	
	@Test def void test_01() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  def static void main(String[] args) {
			    val in = new InputStream {
			      val bytes = new ByteArrayInputStream("".bytes)
			      override read() throws IOException {
			        bytes.rea|
			      }
			    }
			  }
			}
		''')
			.assertTextAtCursorPosition('|', 'read', "read()", "read()")
	}
	
	@Test def void test_02() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  def static void main(String[] args) {
			    val in = new InputStream {
			      val bytes = new ByteArrayInputStream("".bytes)
			      override read() throws IOException {
			        byte|s.toString
			      }
			    }
			  }
			}
		''')
			.assertTextAtCursorPosition('|', 'bytes')
	}
	
	@Test def void test_03() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  def static void main(String[] args) {
			    val in = new InputStream {
			      val bytes = new ByteArrayInputStream("".bytes)
			      override read() throws IOException {
			        ar|gs.toString
			      }
			    }
			  }
			}
		''')
			.assertTextAtCursorPosition('|', 'args')
	}
	
}