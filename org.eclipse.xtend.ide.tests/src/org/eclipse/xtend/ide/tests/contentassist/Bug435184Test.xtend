/*******************************************************************************
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
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
class Bug435184Test extends AbstractXtendContentAssistBugTest {
	
	@Test def void test_01() throws Exception {
		val b = newBuilder.append('''
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
		b.assertTextAtCursorPosition('|', 'read', "read()", "read()", "readAllBytes", "readNBytes()", "readNBytes()")
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