package org.eclipse.xtend.ide.tests.document

import com.google.inject.Inject
import java.io.File
import java.io.Serializable
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.parser.antlr.XtendAntlrTokenFileProvider
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer
import org.eclipse.xtend.ide.editor.model.XtendDocumentTokenSource
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider
import org.eclipse.xtext.parser.antlr.Lexer
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.model.XtextDocument
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.eclipse.xtext.xbase.ui.document.DocumentRewriter
import org.eclipse.xtext.xbase.ui.imports.ReplaceConverter
import org.junit.Test
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtend.core.parser.antlr.internal.FlexerFactory

class DocumentRewriterTest extends AbstractXtendUITestCase {

	@Inject extension WorkbenchTestHelper

	@Inject DocumentRewriter.Factory factory
	
	@Inject extension ReplaceConverter 

	@Inject extension CommonTypeComputationServices services
	
	@Inject extension TypesFactory
	
	@Inject FlexerFactory flexerFactory
	
	@Test
	def void testSectionOverlap() {
		'''
			//***********
		'''.rewrite [ DocumentRewriter it, XtextResource r |
			newSection(3, 1).append("one")
			newSection(4, 2).append("two")
			newSection(6, 1).append("three")
			assertFails [newSection(4, 2)]
			assertFails [newSection(5, 0)]
			assertFails [newSection(5, 1)]
			assertFails [newSection(5, 2)]
			assertFails [newSection(6, 0)]
			assertFails [newSection(6, 1)]
			assertFails [newSection(6, 2)]
		]
		.andExpect('''
			//*onetwothree******
		''')
	}

	@Test
	def void testSectionOrderIrrelevant() {
		'''
			//***********
		'''.rewrite [ DocumentRewriter it, XtextResource r |
			newSection(6, 1).append("one")
			newSection(4, 2).append("two")
			newSection(3, 1).append("three")
			assertFails [newSection(4, 2)]
			assertFails [newSection(5, 0)]
			assertFails [newSection(5, 1)]
			assertFails [newSection(5, 2)]
			assertFails [newSection(6, 0)]
			assertFails [newSection(6, 1)]
			assertFails [newSection(6, 2)]
		]
		.andExpect('''
			//*threetwoone******
		''')
	}

	@Test
	def void testInsertText() {
		val model = '''
			class Foo {
				
				def foo() {}
				
				def bar() {}
			}
		'''
		model
			.rewrite [ DocumentRewriter it, XtextResource r |
				newSection(model.indexOf('class'), 0).append("abstract ")
				newSection(model.indexOf('foo'), 0).append("static ")
				newSection(model.indexOf('bar'), 0).append("private int ")
				newSection(model.lastIndexOf('{}'), 2).append("{ 42 }")
			]
			.andExpect('''
				abstract class Foo {
					
					def static foo() {}
					
					def private int bar() { 42 }
				}
			''')
	}

	@Test
	def void testInsertExistingType() {
		val model = '''
			import java.io.Serializable
			
			class Foo implements Serializable {
				
				def foo() {}
			}
		'''
		model
			.rewrite [ DocumentRewriter it, XtextResource r |
				val beforeFoo = newSection(model.indexOf('foo'), 0)
				beforeFoo.append(typeReferences.findDeclaredType(Serializable, r))
				beforeFoo.append(' ') 

			]
			.andExpect('''
				import java.io.Serializable
				
				class Foo implements Serializable {
					
					def Serializable foo() {}
				}
			''')
	}

	@Test
	def void testInsertTypesImportsSorted() {
		val model = '''
			import java.io.Serializable
			
			class Foo implements Serializable {
				
				def foo() {}
				
				def bar() {}
			}
		'''
		model
			.rewrite [ DocumentRewriter it, XtextResource r |
				val beforeFoo = newSection(model.indexOf('foo'), 0)
				val beforeBar = newSection(model.indexOf('bar'), 0)
				val owner = new StandardTypeReferenceOwner(services, r)
				val converter = new OwnedConverter(owner)
				val list = typeReferences.getTypeForName(List, r, createJvmWildcardTypeReference)
				beforeFoo.append(converter.apply(list))
				beforeBar.append(converter.apply(typeReferences.getTypeForName(File, r)))
				beforeFoo.append(' ') 
				beforeBar.append(' ')

			]
			.andExpect('''
				import java.io.File
				import java.io.Serializable
				import java.util.List
				
				class Foo implements Serializable {
					
					def List<?> foo() {}
					
					def File bar() {}
				}
			''')
	}

	@Test
	def void testInsertTypesWithOverlappingImports() {
		val model = '''
			class Foo {
				
				def foo() {}
				
				def bar() {}
			}
		'''
		model
			.rewrite [ DocumentRewriter it, XtextResource r |
				val beforeFoo = newSection(model.indexOf('foo'), 0)
				val beforeBar = newSection(model.indexOf('bar'), 0)
				val owner = new StandardTypeReferenceOwner(services, r)
				val converter = new OwnedConverter(owner)
				beforeFoo.append(converter.apply(typeReferences.getTypeForName(List, r, typeReferences.getTypeForName(String, r))))
				beforeBar.append(converter.apply(typeReferences.getTypeForName(List, r, typeReferences.getTypeForName(File, r))))
				beforeFoo.append(' ') 
				beforeBar.append(' ')
			]
			.andExpect('''
				import java.io.File
				import java.util.List
				
				class Foo {
					
					def List<String> foo() {}
					
					def List<File> bar() {}
				}
			''')
	}

	@Test 
	def void testEmptyLinesAround() {
		val model = '''
			class Foo {
				def foo() {}
				def bar() {}
			}
		'''
		model
			.rewrite [ DocumentRewriter it, XtextResource r |
				val beforeDefBar = newSection(model.indexOf('def bar'), 0, true)
				beforeDefBar.append('val x = 42')
			]
			.andExpect('''
				class Foo {
					def foo() {}
					
					val x = 42
					
					def bar() {}
				}
			''')
	}

	@Test 
	def void testWhitespaces() {
		val model = '''
			class Foo {
				def foo() {}
				def bar() {
				}
			}
		'''
		model
			.rewrite [ DocumentRewriter it, XtextResource r |
				newSection(model.indexOf('{}') + 3, 0, true).append('val x = 42')
				newSection(model.lastIndexOf('{\n') + 1, 0, 2, true).append('val y = 43')
				newSection(model.indexOf('\t}') + 2, 0, true).append('val z = 44')
			]
			.andExpect('''
				class Foo {
					def foo() {}
				
					val x = 42
					
					def bar() {
						
						val y = 43
						
					}
					
					val z = 44
					
				}
			''')
	}

	protected def rewrite(CharSequence model, (DocumentRewriter, XtextResource)=>void test) {
		val document = createDocument(model.toString)
		document.readOnly [
			val rewriter = factory.create(document, it)
			test.apply(rewriter, it)
			rewriter.changes.convertToTextEdit
		].apply(document)
		document.get
	}

	protected def andExpect(String model, CharSequence expectation) {
		assertEquals(expectation.toString, model)
	}

	protected def assertFails(DocumentRewriter it, (DocumentRewriter)=>void procedure) {
		try {
			procedure.apply(it)
			fail
		} catch (Exception exc) {
			// expected
		}
	}

	protected def XtextDocument createDocument(String content) throws Exception {
		val file = createFile("Foo", content)
		val resource = resourceSet.getResource(URI.createPlatformResourceURI(file.fullPath.toString, true), true)
		val source = new XtendDocumentTokenSource => [
			tokenDefProvider = new AntlrTokenDefProvider => [
				antlrTokenFileProvider = new XtendAntlrTokenFileProvider
			]
			lexer = [|new InternalXtendLexer() as Lexer]
			it.flexerFactory = this.flexerFactory 
		]
		val document = new XtextDocument(source, null)
		document.set(content)
		document.setInput(resource as XtextResource)
		document
	}
}
