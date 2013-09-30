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

	@Test def void addPrimaryTopLevelType() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				// primary top level type
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("// primary top level type", "public class Bar {}")
			], "mypackage.Bar")
	}

	@Test def void removePrimaryTopLevelType() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("public class Bar {}", "")
			], "mypackage.Bar")
	}

	@Test def void renamePrimaryTopLevelType() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("Bar", "Bar2")
			], "mypackage.Bar", "mypackage.Bar2")
	}

	@Test def void addPrimaryTopLevelTypeWithinDefaultPackage() {
		createFile('Bar.java',
			'''
				// primary top level type
			''')
		assertThereAreDeltas(
			[ |
				'/Bar.java'.save("// primary top level type", "public class Bar {}")
			], "Bar")
	}

	@Test def void removePrimaryTopLevelTypeWithinDefaultPackage() {
		createFile('Bar.java',
			'''
				public class Bar {}
			''')
		assertThereAreDeltas(
			[ |
				'Bar.java'.save("public class Bar {}", "")
			], "Bar")
	}

	@Test def void renamePrimaryTopLevelTypeWithinDefaultPackage() {
		createFile('Bar.java',
			'''
				public class Bar {}
			''')
		assertThereAreDeltas(
			[ |
				'Bar.java'.save("Bar", "Bar2")
			], "Bar", "Bar2")
	}

	@Test def public void addSecondaryTopLevelType() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				}
				
				// secondary top level type
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("// secondary top level type", "class Foo {}")
			], "mypackage.Foo")
	}

	@Test def public void removeSecondaryTopLevelType() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				}
				
				class Foo {}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("class Foo {}", "")
			], "mypackage.Foo")
	}

	@Test def void renameSecondaryTopLevelType() {
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

	@Test def public void addSecondaryTopLevelTypeWithinDefaultPackage() {
		createFile('Bar.java',
			'''
				public class Bar {
				}
				
				// secondary top level type
			''')
		assertThereAreDeltas(
			[ |
				'Bar.java'.save("// secondary top level type", "class Foo {}")
			], "Foo")
	}

	@Test def public void removeSecondaryTopLevelTypeWithinDefaultPackage() {
		createFile('Bar.java',
			'''
				public class Bar {
				}
				
				class Foo {}
			''')
		assertThereAreDeltas(
			[ |
				'Bar.java'.save("class Foo {}", "")
			], "Foo")
	}

	@Test def void renameSecondaryTopLevelTypeWithinDefaultPackage() {
		createFile('Bar.java',
			'''
				public class Bar {
				}
				
				class Bar2 {
				}
			''')
		assertThereAreDeltas(
			[ |
				'Bar.java'.save("Bar2", "Bar3")
			], "Bar2", "Bar3")
	}

	@Test def public void addNestedTypes() {
		createFile('/mypackage/Bar.java',
			'''
				public class Bar {
				
					// nested types
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save("// nested types",
					'''
						public class Foo {
						
							public class Foo3 {}
						
						}
						
						public static class Foo2 {}
					''')
			], "mypackage.Bar", "mypackage.Bar$Foo", "mypackage.Bar$Foo2", "mypackage.Bar$Foo$Foo3")
	}

	@Test def public void removeNestedTypes() {
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				
					public class Foo { public class Foo3 {} }
				
					public static class Foo2 {}
				
				}
			''')

		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save [
					changeContent("public class Foo { public class Foo3 {} }", "")
					changeContent("public static class Foo2 {}", "")
				]
			], "mypackage.Bar", "mypackage.Bar$Foo", "mypackage.Bar$Foo2", "mypackage.Bar$Foo$Foo3")
	}

	@Test def void renameNestedTypes() {
		createFile('/mypackage/Bar.java',
			'''
				public class Bar {
				
					public class Foo {
				
						public class Foo3 {}
				
					}
				
					public static class Foo2 {}
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.save [
					changeContent(" Foo ", " NewFoo ")
					changeContent(" Foo2 ", " NewFoo2 ")
					changeContent(" Foo3 ", " NewFoo3 ")
				]
			], "mypackage.Bar", "mypackage.Bar$Foo", "mypackage.Bar$Foo2", "mypackage.Bar$NewFoo",
			"mypackage.Bar$NewFoo2", "mypackage.Bar$NewFoo$NewFoo3", "mypackage.Bar$Foo$Foo3")
	}

	@Test def public void addNestedTypesWithinDefaultPackage() {
		createFile('Bar.java',
			'''
				public class Bar {
				
					// nested types
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'Bar.java'.save("// nested types",
					'''
						public class Foo {

							public class Foo3 {
							}

						}
						
						public static class Foo2 {}
					''')
			], "Bar", "Bar$Foo", "Bar$Foo2", "Bar$Foo$Foo3")
	}

	@Test def public void addNestedTypesWithinDefaultPackage2() {
		createFile('Bar.java',
			'''
				public class Bar {
				
					public class Foo {

						// nested types

					}
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'Bar.java'.save("// nested types", '''public class Foo3 {}''')
			], "Bar$Foo", "Bar$Foo$Foo3")
	}

	@Test def public void removeNestedTypesWithinDefaultPackage() {
		createFile('Bar.java',
			'''
				public class Bar {
				
					public class Foo { public class Foo3 {} }
				
					public static class Foo2 {}
				
				}
			''')

		assertThereAreDeltas(
			[ |
				'Bar.java'.save [
					changeContent("public class Foo { public class Foo3 {} }", "")
					changeContent("public static class Foo2 {}", "")
				]
			], "Bar", "Bar$Foo", "Bar$Foo2", "Bar$Foo$Foo3")
	}

	@Test def void renameNestedTypesWithinDefaultPackage() {
		createFile('Bar.java',
			'''
				public class Bar {
				
					public class Foo { public class Foo3 {} }
				
					public static class Foo2 {}
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'Bar.java'.save [
					changeContent(" Foo ", " NewFoo ")
					changeContent(" Foo2 ", " NewFoo2 ")
					changeContent(" Foo3 ", " NewFoo3 ")
				]
			], "Bar", "Bar$Foo", "Bar$Foo2", "Bar$NewFoo", "Bar$NewFoo2", "Bar$NewFoo$NewFoo3", "Bar$Foo$Foo3")
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
