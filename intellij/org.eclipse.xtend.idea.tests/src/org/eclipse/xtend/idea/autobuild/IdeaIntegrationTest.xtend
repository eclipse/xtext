/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.autobuild

import com.google.common.io.CharStreams
import com.google.common.io.Files
import com.intellij.facet.Facet
import com.intellij.facet.FacetManager
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.newvfs.events.VFileDeleteEvent
import com.intellij.openapi.vfs.newvfs.persistent.PersistentFS
import com.intellij.psi.PsiDocumentManager
import java.io.File
import java.io.InputStreamReader
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.idea.facet.XtendFacetType
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtend.idea.LightXtendTest
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponent
import org.junit.ComparisonFailure

import static extension org.eclipse.xtext.idea.resource.VirtualFileURIUtil.*

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

	def void testNoChangeDoesntTouch() {
		val xtendFile = myFixture.addFileToProject('otherPackage/Foo.xtend', '''
			package otherPackage
			class Foo {
			}
		''')
		val file = myFixture.findFileInTempDir('xtend-gen/otherPackage/Foo.java')
		assertTrue(file.exists)
		val stamp = file.modificationStamp
		val document = PsiDocumentManager.getInstance(project).getDocument(xtendFile)
		ApplicationManager.application.runWriteAction [
			document.text = '''
				package otherPackage
				class Foo {
					// doesn't go into target
				}
			'''
		]
		// should be regenerated immediately
		val regenerated = myFixture.findFileInTempDir('xtend-gen/otherPackage/Foo.java')
		assertEquals(stamp, regenerated.modificationStamp)
	}

	def void testRemoveAndAddFacet() {
		val source = myFixture.addFileToProject('otherPackage/Foo.xtend', '''
			package otherPackage
			class Foo {
			}
		''')
		var file = myFixture.findFileInTempDir('xtend-gen/otherPackage/Foo.java')
		assertTrue(file.exists)
		ApplicationManager.application.runWriteAction [|
			val mnr = FacetManager.getInstance(myModule)
			val model = mnr.createModifiableModel
			val facet = mnr.allFacets.findFirst[Facet<?> it|it.typeId == XtendFacetType.TYPEID]
			model.removeFacet(facet)
			model.commit
			return;
		]
		val autoBuilder = project.getComponent(XtextAutoBuilderComponent)
		assertTrue(autoBuilder.getGeneratedSources(source.virtualFile.URI).empty)
		assertTrue(autoBuilder.indexState.allResourceDescriptions.empty)
		file = myFixture.findFileInTempDir('xtend-gen/otherPackage/Foo.java')
		assertNull(file)

		// add facet again
		addFacetToModule(myModule, XtendLanguage.INSTANCE.ID)

		assertEquals(source.virtualFile.URI, autoBuilder.indexState.allResourceDescriptions.head.URI)
		assertTrue(autoBuilder.getGeneratedSources(source.virtualFile.URI).exists [
			toString.endsWith("xtend-gen/otherPackage/Foo.java")
		])
		file = myFixture.findFileInTempDir('xtend-gen/otherPackage/Foo.java')
		assertTrue(file.exists)
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
		ApplicationManager.application.runWriteAction [
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

	def void testDeleteGeneratedFolder() {
		myFixture.addFileToProject('otherPackage/Foo.xtend', '''
			package otherPackage
			
			class Foo {
				val list = OtherClass.getIt("foo")
			}
		''')
		myFixture.addFileToProject('otherPackage/Bar.xtend', '''
			package otherPackage
			
			import java.util.List
			
			class OtherClass {
				def static List<String> getIt(String x) {
					return #[x]
				}
			}
		''')
		assertFileContents("xtend-gen/otherPackage/Foo.java", '''
			package otherPackage;
			
			import java.util.List;
			import otherPackage.OtherClass;
			
			@SuppressWarnings("all")
			public class Foo {
			  private final List<String> list = OtherClass.getIt("foo");
			}
		''')
		val dir = myFixture.findFileInTempDir("xtend-gen")
		ApplicationManager.application.runWriteAction [
			dir.delete(null)
		]
		// the auto builder immediately recreates the deleted content
		assertFileContents("xtend-gen/otherPackage/Foo.java", '''
			package otherPackage;
			
			import java.util.List;
			import otherPackage.OtherClass;
			
			@SuppressWarnings("all")
			public class Foo {
			  private final List<String> list = OtherClass.getIt("foo");
			}
		''')
	}

	/* https://bugs.eclipse.org/bugs/show_bug.cgi?id=476412 */
	def void testDeleteNonProjectFolderFromDisk() {
		myFixture.addFileToProject('otherPackage/Foo.xtend', '''
			package otherPackage
			class Foo {
			}
		''')
		val tmpDir = Files.createTempDir
		val File f = new File(tmpDir, "dirToDelete")
		f.mkdirs
		val vFile = VfsUtil.findFileByIoFile(f, false)
		ApplicationManager.application.runWriteAction [
			PersistentFS.getInstance().processEvents(#[new VFileDeleteEvent(this, vFile.parent, true)])
			assertTrue(f.parentFile.delete)
			return
		]
		assertFalse(vFile.exists)
	}

	def void testAffectedUpdated() {
		myFixture.addFileToProject('otherPackage/Foo.xtend', '''
			package otherPackage
			
			import java.util.List
			
			class Foo {
				val list = OtherClass.getIt("foo")
			}
		''')
		assertFileContents("xtend-gen/otherPackage/Foo.java", '''
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
		assertFileContents("xtend-gen/otherPackage/Foo.java", '''
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
		assertFileContents("xtend-gen/otherPackage/Foo.java", '''
			package otherPackage;
			
			import otherPackage.OtherClass;
			
			@SuppressWarnings("all")
			public class Foo {
			  private final String[] list = OtherClass.getIt("foo");
			}
		''')
	}

	def void testTraceFilesGeneratedAndDeleted() {
		myFixture.addFileToProject('otherPackage/Foo.xtend', '''
			package otherPackage
			class Foo {
			}
		''')
		assertTrue(myFixture.findFileInTempDir("xtend-gen/otherPackage/Foo.java").exists)
		assertTrue(myFixture.findFileInTempDir("xtend-gen/otherPackage/.Foo.java._trace").exists)
		myFixture.saveText(myFixture.findFileInTempDir("otherPackage/Foo.xtend"), '''
			package otherPackage;
			class OtherClass {
			}
		''')
		assertNull(myFixture.findFileInTempDir("xtend-gen/otherPackage/Foo.java"))
		assertNull(myFixture.findFileInTempDir("xtend-gen/otherPackage/.Foo.java._trace"))
		assertTrue(myFixture.findFileInTempDir("xtend-gen/otherPackage/OtherClass.java").exists)
		assertTrue(myFixture.findFileInTempDir("xtend-gen/otherPackage/.OtherClass.java._trace").exists)
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
		assertFileContents("xtend-gen/otherPackage/Foo.java", '''
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

	def void testMoveFile() {
		val xtendFile = myFixture.addFileToProject('otherPackage/Foo.xtend', '''
			package otherPackage
			
			import mypackage.Bar
			
			class Foo {
			
				def void callToBar(Bar bar) {
					bar.doStuff()
				}
			
			}
		''')

		val vf = xtendFile.virtualFile
		val before = URI.createURI("temp:///src/otherPackage/Foo.xtend")
		val after = URI.createURI("temp:///src/Foo.xtend")
		assertNull(index.getResourceDescription(after))
		assertNotNull(index.getResourceDescription(before))

		builder.runOperation [
			ApplicationManager.application.runWriteAction [
				vf.move(null, vf.parent.parent)
			]
		]
		assertNotNull(index.getResourceDescription(after))
		assertNull(index.getResourceDescription(before))
	}

	def void testRenameFile() {
		val xtendFile = myFixture.addFileToProject('mypackage/Foo.xtend', '''
			package mypackage
			
			class Foo {
				
			}
		''')

		val before = URI.createURI("temp:///src/mypackage/Foo.xtend")
		val after = URI.createURI("temp:///src/mypackage/Bar.xtend")
		assertNull(index.getResourceDescription(after))
		assertNotNull(index.getResourceDescription(before))

		builder.runOperation [
			myFixture.renameElement(xtendFile, 'Bar.xtend')
		]
		assertNotNull(index.getResourceDescription(after))
		assertNull(index.getResourceDescription(before))
	}

	def void testRenameReference() {
		myFixture.addFileToProject('mypackage/Foo.xtend', '''
			package mypackage
			
			class Foo {}
		''')

		val model = '''
			package mypackage
			
			class Bar extends Foo {}
		'''
		val xtendFile = myFixture.addFileToProject('mypackage/Bar.xtend', model)
		myFixture.testHighlighting(true, true, true, xtendFile.virtualFile)

		val referenceOffset = model.indexOf('Foo')
		myFixture.openFileInEditor(xtendFile.virtualFile)
		myFixture.editor.caretModel.moveToOffset(referenceOffset)
		builder.runOperation [
			myFixture.renameElementAtCaret('Zonk')
		]
		myFixture.testHighlighting(true, true, true, xtendFile.virtualFile)
	}

	def void assertFileContents(String path, CharSequence sequence) {
		val file = myFixture.findFileInTempDir(path)
		assertEquals(sequence.toString, CharStreams.toString(new InputStreamReader(file.inputStream, file.charset)))
	}
}