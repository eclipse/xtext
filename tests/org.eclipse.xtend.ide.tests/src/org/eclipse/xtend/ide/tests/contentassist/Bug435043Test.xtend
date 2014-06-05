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
class Bug435043Test extends AbstractXtendContentAssistBugTest {
	
	@Test def void test_01() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  def static void main(String[] args) {
			    val in = new InputStream {
				  val bytes = "FooBar".bytes.iterator
				
				  <|>
				
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
				}
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_02() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  def static void main(String[] args) {
			    val in = new InputStream {
				  val bytes = "FooBar".bytes.iterator
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
				  <|>
				}
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_03() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  static class C2 extends InputStream {
				  val bytes = "FooBar".bytes.iterator
				
				  <|>
				
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_04() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  static class C2 extends InputStream {
				  val bytes = "FooBar".bytes.iterator
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
				  <|>
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}

	@Test def void test_05() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  def static void main(String[] args) {
			    val in = new InputStream {
				  val bytes = "FooBar".bytes.iterator
				
				  toS<|>
				
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
				}
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_06() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  def static void main(String[] args) {
			    val in = new InputStream {
				  val bytes = "FooBar".bytes.iterator
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
				  toS<|>
				}
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_07() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  static class C2 extends InputStream {
				  val bytes = "FooBar".bytes.iterator
				
				  toS<|>
				
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_08() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  static class C2 extends InputStream {
				  val bytes = "FooBar".bytes.iterator
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
				  toS<|>
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}

	@Test def void test_09() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  def static void main(String[] args) {
			    val in = new InputStream {
				  val bytes = "FooBar".bytes.iterator
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
				  <|>
				  val bytes2 = "FooBar".bytes.iterator
				}
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_10() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  def static void main(String[] args) {
			    val in = new InputStream {
				  val bytes = "FooBar".bytes.iterator
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
				  <|>
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
				}
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_11() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  static class C2 extends InputStream {
				  val bytes = "FooBar".bytes.iterator
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
				  <|>
				  val bytes2 = "FooBar".bytes.iterator
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_12() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  static class C2 extends InputStream {
				  val bytes = "FooBar".bytes.iterator
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
				  <|>
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_13() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  def static void main(String[] args) {
			    val in = new InputStream {
				  val bytes = "FooBar".bytes.iterator
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
				  toS<|>
				  val bytes = "FooBar".bytes.iterator
				}
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_14() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  def static void main(String[] args) {
			    val in = new InputStream {
				  val bytes = "FooBar".bytes.iterator
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
				  toS<|>
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
				}
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_17() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  static class C2 extends InputStream {
				  val bytes = "FooBar".bytes.iterator
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
				  toS<|>
				  val bytes = "FooBar".bytes.iterator
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_18() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  static class C2 extends InputStream {
				  val bytes = "FooBar".bytes.iterator
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
				  toS<|>
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_19() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  static class C2 extends InputStream {
				  val bytes = new Object() {}
				  <|>
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_20() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  static class C2 extends InputStream {
				  val bytes = new Object() {}
				  toS<|>
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}

	@Test def void test_21() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  static class C2 extends InputStream {
				  new() {}
				  <|>
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_22() throws Exception {
		newBuilder.append('''
			import java.io.*
			
			class C {
			  static class C2 extends InputStream {
				  new() {}
				  toS<|>
				  override read() throws IOException {
				    if(bytes.hasNext) bytes.next else -1
				  }
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_23() throws Exception {
		newBuilder.append('''
			class C {
			  def static m() {
			  	new Object {
				  val foo = ""
				  <|>
				  override toString() {
				    ""
				  }
				  
				  val bar = ""
				  
				}
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('equals(Object) - Override method from Object')
	}
	
	@Test def void test_24() throws Exception {
		newBuilder.append('''
			class C {
			  def static m() {
			  	new Object {
				  val foo = ""
				  
				  override toString() {
				    ""
				  }
				  <|>			
				  val bar = ""
				}
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('equals(Object) - Override method from Object')
	}
	
	@Test def void test_25() throws Exception {
		newBuilder.append('''
			class C {
			  def static m() {
			  	new Object {
				  val foo = ""
				  
				  override toString() {
				    ""
				  }
				  
				  val bar = ""
				  <|>
				}
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('equals(Object) - Override method from Object')
	}
	
	@Test def void test_26() throws Exception {
		newBuilder.append('''
			class C {
			  def static m() {
			  	val x = ''
			  	val y = new Object() {
			  		val z = <|>
			  	}
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('x')
	}
	
	@Test def void test_27() throws Exception {
		newBuilder.append('''
			class C {
			  static class D {
				  val foo = ""
				  <|>
				  override toString() {
				    ""
				  }
				  
				  val bar = ""
				  
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('equals(Object) - Override method from Object')
	}
	
	@Test def void test_28() throws Exception {
		newBuilder.append('''
			class C {
			  static class D {
				  val foo = ""
				  
				  override toString() {
				    ""
				  }
				  <|>			
				  val bar = ""
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('equals(Object) - Override method from Object')
	}
	
	@Test def void test_29() throws Exception {
		newBuilder.append('''
			class C {
			  static class D {
				  val foo = ""
				  
				  override toString() {
				    ""
				  }
				  
				  val bar = ""
				  <|>
			  }
			}
		''')
			.assertProposalDisplayedAtCursor('equals(Object) - Override method from Object')
	}
}