/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.builder

import org.eclipse.ui.texteditor.ITextEditor
import org.junit.Test

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
abstract class AbstractSingleEditorQueuedBuildTest extends AbstractQueuedBuildDataTest {

	@Test def void addTypeParameter() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("Bar", "Bar<T>")
			], "mypackage.Bar")
	}

	@Test def void addAnnotation() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("public class Bar {",
					'''
						@javax.annotation.Resource
						public class Bar {
					''')
			], "mypackage.Bar")
	}

	@Test def void renameTopLevelType() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				}
				
				class Bar2 {
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("Bar2", "Bar3")
			], "mypackage.Bar2", "mypackage.Bar3")
	}

	@Test def void renameTopLevelType2() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				
					public void bar() {
						System.out.println("Hello world!");
					}
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("Bar", "Bar2")
			], "mypackage.Bar", "mypackage.Bar2")
	}

	@Test def void changePackageDeclaration() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				
				}
			''')
		assertThereAreNotDeltas [ |
			'/mypackage/Bar.java'.save("package mypackage;", "package mypackage2;")
		]
	}

	@Test def void makeFieldPrivate() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				
					public String bar;
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("public String bar;", "private String bar;")
			], "mypackage.Bar")
	}

	@Test def void makeFieldPublic() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				
					private String bar;
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("private String bar;", "public String bar;")
			], "mypackage.Bar")
	}

	@Test
	def void makePrivateFieldStatic() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				
					private String bar;
				
				}
			''')

		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("private String bar;", "private static String bar;")
			], "mypackage.Bar")
	}

	@Test def void changeImports() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				import java.util.List;
				
				public class Bar {
				
					public List<String> bar;
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("import java.util.List;", "")
			], "mypackage.Bar")
	}

	@Test def void changeImports2() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				import java.util.List;
				
				public class Bar {
				
					public List<String> bar;
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("import java.util.List;", "import java.awt.List;")
			], "mypackage.Bar")
	}

	@Test def void changeImports3() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				import java.util.List;
				
				public class Bar {
				
				}
				
				class Bar2 {
				
				}
			''')
		assertThereAreNotDeltas [ |
			'/mypackage/Bar.java'.save("import java.util.List;", "import java.awt.List;")
		]
	}

	@Test def void changeImports4() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				import java.util.List;
				
				public class Bar {
				
					public static class Bar2 {
					}
				
				}
			''')
		assertThereAreNotDeltas [ |
			'/mypackage/Bar.java'.save("import java.util.List;", "import java.awt.List;")
		]
	}

	@Test def void changeImports5() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				import java.util.List;
				
				public class Bar {
				
					public List<String> bar;
				
				}
				
				class Bar2 {
				
					public List<String> bar2;
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("import java.util.List;", "import java.awt.List;")
			], "mypackage.Bar", "mypackage.Bar2")
	}

	@Test def void renameLocalVariable() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				
					private void bar() {
						int x = 3;
					}
				
				}
			''')
		assertThereAreNotDeltas [ |
			'/mypackage/Bar.java'.save("x", "y")
		]
	}

	@Test def void renameMethod() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				
					public void bar() {
						System.out.println("Hello world!");
					}
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("bar()", "bar2()")
			], "mypackage.Bar")
	}

	@Test
	def void testRenameMethodWithoutSaving() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				
					public void bar() {
					}
				
				}
			''')
		createFile('/mypackage/Bar2.java',
			'''
				package mypackage;
				
				public class Bar2 {
				
					public void bar() {
					}
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.close("bar()", "bar2()")
				'/mypackage/Bar2.java'.save("bar()", "bar2()")
			], "mypackage.Bar2")
	}

	@Test def void changeMethodBody() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				
					public void bar() {
						System.out.println("Hello world!");
					}
				
				}
			''')
		assertThereAreNotDeltas [ |
			'/mypackage/Bar.java'.save("Hello world!", "Hello!")
		]
	}

	@Test def void addPublicMethod() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("public class Bar {",
					'''
						public class Bar {
						
							public void bar2() {}
						
					''')
			], "mypackage.Bar")
	}

	@Test def void removePublicMethod() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				
					public void bar() {
						System.out.println("Hello world!");
					}
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save(
					'''
						public void bar() {
								System.out.println("Hello world!");
							}
					''', "")
			], "mypackage.Bar")
	}

	@Test def void removePrivateMethod() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				
					private void bar() {}
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("private void bar() {}", "")
			], "mypackage.Bar")
	}

	@Test def void removePublicAndPrivateMethods() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				
					public void bar() {}
					
					private void bar2() {}
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save [
					changeContent("public void bar() {}", "").changeContent("private void bar2() {}", "")
				]
			], "mypackage.Bar")
	}

	def save(String fileName, String oldText, String newText) {
		fileName.openJavaEditor.doSave [
			changeContent(oldText, newText)
		]
	}

	def save(String fileName, (ITextEditor)=>ITextEditor consumer) {
		fileName.openJavaEditor.doSave(consumer)
	}

	def close(String fileName, String oldText, String newText) {
		fileName.openJavaEditor.doClose [
			changeContent(oldText, newText)
		]
	}

	def close(String fileName, (ITextEditor)=>ITextEditor consumer) {
		fileName.openJavaEditor.doClose(consumer)
	}

	abstract def ITextEditor doSave(ITextEditor editor, (ITextEditor)=>ITextEditor consumer)

	abstract def ITextEditor doClose(ITextEditor editor, (ITextEditor)=>ITextEditor consumer)

}
