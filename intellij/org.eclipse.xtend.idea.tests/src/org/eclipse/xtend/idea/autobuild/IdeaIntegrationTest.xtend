/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.autobuild

import com.google.common.io.CharStreams
import java.io.InputStreamReader
import org.eclipse.xtend.idea.LightXtendTest
import org.junit.ComparisonFailure
import com.intellij.openapi.application.ApplicationManager

/**
 */
class IdeaIntegrationTest extends LightXtendTest {
	
	def void testManualDeletionOfGeneratedSourcesTriggersRebuild() {
		myFixture.addFileToProject('otherPackage/Foo.xtend', '''
			package otherPackage
			class Foo {
			}
		''')
		val file = myFixture.findFileInTempDir('xtend-gen/otherPackage/Foo.java')
		assertTrue(file.exists)
		ApplicationManager.application.runWriteAction [
			file.delete(null)
		]
		// should be regenerated immediately
		val regenerated = myFixture.findFileInTempDir('xtend-gen/otherPackage/Foo.java')
		assertTrue(regenerated.exists)
	}
	
	def void testJavaDeletionTriggersError() {
		val xtendFile = myFixture.addFileToProject('otherPackage/Foo.xtend', '''
			package otherPackage
			
			import mypackage.Bar
			
			class Foo {
			
				def void callToBar(Bar bar) {
					bar.doStuff()
				}
			
			}
		''')
		myFixture.addFileToProject('myPackage/Bar.java', '''
			package mypackage;
			
			public class Bar {
			
				public void doStuff() {
				}
			
			}
		''')
		myFixture.testHighlighting(true, true, true, xtendFile.virtualFile)
		ApplicationManager.application.runWriteAction[
			val javaFile = myFixture.findFileInTempDir('myPackage/Bar.java')
			javaFile.delete(null)
		]
		try {
			myFixture.testHighlighting(true, true, true, xtendFile.virtualFile)
			fail("expecting errors")
		} catch (ComparisonFailure e) {
			// expected		
		}
	}
	
	def void testJavaChangeTriggersError() {
		val xtendFile = myFixture.addFileToProject('otherPackage/Foo.xtend', '''
			package otherPackage
			
			import mypackage.Bar
			
			class Foo {
			
				def void callToBar(Bar bar) {
					bar.doStuff()
				}
			
			}
		''')
		try {
			myFixture.testHighlighting(true, true, true, xtendFile.virtualFile)
			fail("expecting errors")
		} catch (ComparisonFailure e) {
			// expected		
		}
		myFixture.addFileToProject('myPackage/Bar.java', '''
			package mypackage;
			
			public class Bar {
			
				public void doStuff() {
				}
			
			}
		''')
		myFixture.testHighlighting(true, true, true, xtendFile.virtualFile)
	}
	
	def void testCyclicResolution() {
		myFixture.addClass('''
			package mypackage;
			
			public class Bar {
			
				public void callToFoo(Foo foo) {
					foo.callToBar(this);
				}
			
			}
		''')
		val xtendFile = myFixture.addFileToProject('mypackage/Foo.xtend', '''
			package mypackage
			
			class Foo {
			
				def void callToBar(Bar bar) {
					bar.callToFoo(this)
				}
			
			}
		''')
		myFixture.testHighlighting(true, true, true, xtendFile.virtualFile)
	}

	def void testCyclicResolution2() {
		myFixture.addClass('''
			package mypackage;
			
			public class Bar extends Foo {
			
				public void someMethod() {
				}
			
			}
		''')
		val xtendFile = myFixture.addFileToProject('mypackage/Foo.xtend', '''
			package mypackage
			
			class Foo {
			
				def void callToBar(Bar bar) {
					bar.someMethod
				}
			
			}
		''')
		myFixture.testHighlighting(true, true, true, xtendFile.virtualFile)
	}

	def void testCyclicResolution3() {
		myFixture.addClass('''
			package mypackage;
			
			public class Bar extends Foo<? extends Bar> {
			
				public void someMethod() {
				}
			
			}
		''')
		val xtendFile = myFixture.addFileToProject('mypackage/Foo.xtend', '''
			package mypackage
			
			class Foo<T extends Bar> {
			
				def void callToBar(T bar) {
					bar.someMethod
				}
			
			}
		''')
		myFixture.testHighlighting(true, true, true, xtendFile.virtualFile)
	}
	
	def void testCyclicResolution4() {
		myFixture.addClass('''
			package mypackage;
			
			public class Bar extends Foo<Bar> {
			
				public void someMethod(Bar b) {
				}
			
			}
		''')
		val xtendFile = myFixture.addFileToProject('mypackage/Foo.xtend', '''
			package mypackage
			
			class Foo<T extends Bar> {
			
				def void callToBar(T bar) {
					bar.someMethod(bar)
				}
			
			}
		''')
		myFixture.testHighlighting(true, true, true, xtendFile.virtualFile)
	}
	
	def void testAffectedUpdated() {
		myFixture.addFileToProject('otherPackage/Foo.xtend', '''
			package otherPackage
			
			import java.util.List
			
			class Foo {
				val list = OtherClass.getIt("foo")
			}
		''')
		assertFileContents("xtend-gen/otherPackage/Foo.java",'''
			package otherPackage;
			
			@SuppressWarnings("all")
			public class Foo {
			  private final Object list /* Skipped initializer because of errors */;
			}
		''')
		// add a fixing java file
		myFixture.addFileToProject('otherPackage/OtherClass.java', '''
			package otherPackage;
			
			class OtherClass {
				public static java.util.List<String> getIt(CharSequence value) {
					return null
				}
			}
		''')
		assertFileContents("xtend-gen/otherPackage/Foo.java",'''
			package otherPackage;
			
			import java.util.List;
			import otherPackage.OtherClass;
			
			@SuppressWarnings("all")
			public class Foo {
			  private final List<String> list = OtherClass.getIt("foo");
			}
		''')
		// add an overload
		
		myFixture.saveText(myFixture.findFileInTempDir("otherPackage/OtherClass.java"), '''
			package otherPackage;
			
			class OtherClass {
				public static java.util.List<String> getIt(CharSequence value) {
					return null
				}
				public static String[] getIt(String value) {
					return null
				}
			}
		''')
		assertFileContents("xtend-gen/otherPackage/Foo.java",'''
			package otherPackage;
			
			import otherPackage.OtherClass;

			@SuppressWarnings("all")
			public class Foo {
			  private final String[] list = OtherClass.getIt("foo");
			}
		''')
	}
	
	def void testActiveAnnotation() {
		myFixture.addFileToProject('otherPackage/Foo.xtend', '''
			package otherPackage
			
			import mypackage.Bar
			import org.eclipse.xtend.lib.macro.Data
			
			@Data class Foo {
			
				String myField
			
			}
		''')
		assertFileContents("xtend-gen/otherPackage/Foo.java",'''
			package otherPackage;
			
			import org.eclipse.xtend.lib.Data;
			import org.eclipse.xtext.xbase.lib.Pure;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Foo {
			  private final String _myField;
			  
			  public Foo(final String myField) {
			    super();
			    this._myField = myField;
			  }
			  
			  @Override
			  @Pure
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((this._myField== null) ? 0 : this._myField.hashCode());
			    return result;
			  }
			  
			  @Override
			  @Pure
			  public boolean equals(final Object obj) {
			    if (this == obj)
			      return true;
			    if (obj == null)
			      return false;
			    if (getClass() != obj.getClass())
			      return false;
			    Foo other = (Foo) obj;
			    if (this._myField == null) {
			      if (other._myField != null)
			        return false;
			    } else if (!this._myField.equals(other._myField))
			      return false;
			    return true;
			  }
			  
			  @Override
			  @Pure
			  public String toString() {
			    String result = new ToStringHelper().toString(this);
			    return result;
			  }
			  
			  @Pure
			  public String getMyField() {
			    return this._myField;
			  }
			}
		''')
	}
	
	def void assertFileContents(String path, CharSequence sequence) {
		val file = myFixture.findFileInTempDir(path)
		assertEquals(sequence.toString, CharStreams.toString(new InputStreamReader(file.inputStream, file.charset)))
	}	
}