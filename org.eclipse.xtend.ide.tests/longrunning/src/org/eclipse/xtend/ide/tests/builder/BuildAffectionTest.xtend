/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.builder

import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Path
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtend.ide.internal.XtendActivator
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.builder.debug.IBuildLogger
import org.eclipse.xtext.builder.debug.XtextBuildConsole
import org.eclipse.xtext.builder.impl.QueuedBuildData
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil
import org.eclipse.xtext.util.StringInputStream
import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import static org.junit.Assert.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class BuildAffectionTest {
	
	@Inject IBuildLogger logger
	
	@Inject extension WorkbenchTestHelper workbenchTestHelper
	
	@Inject QueuedBuildData queuedBuildData
	
	IProject clientProject
	
	static boolean wasAutoBuilding
	 
	@BeforeClass 
	def static void setUpProject() throws Exception {
		cleanWorkspace();
		// disable auto build
		val workspace = ResourcesPlugin.workspace
		val description = workspace.description
		wasAutoBuilding = description.autoBuilding
		description.autoBuilding = false
		workspace.description = description
		WorkbenchTestHelper.createPluginProject(WorkbenchTestHelper.TESTPROJECT_NAME);
	}
	
	@AfterClass
	def static void tearDownProject() throws Exception {
		cleanWorkspace
		val workspace = ResourcesPlugin.workspace
		val description = workspace.description
		description.autoBuilding = wasAutoBuilding
		workspace.description = description
	}
	
	@Before
	def void setUp() {
		val injector = XtendActivator.instance.getInjector("org.eclipse.xtend.core.Xtend")
		injector.injectMembers(this);
		queuedBuildData.reset
	}
	 
	@After
	def tearDown() {
		if(clientProject != null) 
			WorkbenchTestHelper.deleteProject(clientProject)
		workbenchTestHelper.tearDown
		autoBuild
	}
	
	@Test
	def void testSingleFile() {
		createFile('Foo', '''
			class Foo {}
		''')
		assertBuildLogs('''
			Building test.project
			indexing platform:/resource/test.project/src/Foo.xtend
			Build test.project in \d+ ms
			Building test.project
			Build test.project in \d+ ms
		''')
	}
	
	@Test
	def void testUnaffected_noReferences() {
		val foo = createFile('Foo', '''
			class Foo {}
		''')
		createFile('Bar', '''
			class Bar {}
		''')
		autoBuild
		foo.changeContent('''
			class NewFoo {}
		''')
		assertBuildLogs('''
			Building test.project
			indexing platform:/resource/test.project/src/Foo.xtend
			Build test.project in \d+ ms
			Building test.project
			Build test.project in \d+ ms
		''')
	}
	
	@Test
	def void testUnaffected_noReferences_Java() {
		val foo = createFile('Foo.java', '''
			public class Foo {}
		''')
		createFile('Bar', '''
			class Bar {}
		''')
		autoBuild
		foo.changeContent('''
			public class NewFoo {}
		''')
		assertBuildLogs('''
			Building test.project
			Build test.project in \d+ ms
		''')
	}
	
	@Test
	def void testUnaffected_commentAdded() {
		val foo = createFile('Foo', '''
			class Foo {}
		''')
		createFile('Bar', '''
			class Bar extends Foo {}
		''')
		autoBuild
		foo.changeContent('''
			// just a comment
			class Foo {}
		''')
		assertBuildLogs('''
			Building test.project
			indexing platform:/resource/test.project/src/Foo.xtend
			Build test.project in \d+ ms
			Building test.project
			Build test.project in \d+ ms
		''')
	}
	
	@Test
	def void testUnaffected_commentAdded_Java() {
		val foo = createFile('Foo.java', '''
			public class Foo {}
		''')
		createFile('Bar', '''
			class Bar extends Foo {}
		''')
		autoBuild
		foo.changeContent('''
			// just a comment
			public class Foo {}
		''')
		assertBuildLogs('''
			Building test.project
			Build test.project in \d+ ms
			Building test.project
			Build test.project in \d+ ms
		''')
	}
	
	@Test
	def void testUnaffected_methodBodyChanged() {
		val foo = createFile('Foo', '''
			class Foo {
				def foo() { new Object }
			}
		''')
		createFile('Bar', '''
			class Bar extends Foo {}
		''')
		autoBuild
		foo.changeContent('''
			class Foo {
				def foo() { null }
			}
		''')
		assertBuildLogs('''
			Building test.project
			indexing platform:/resource/test.project/src/Foo.xtend
			Build test.project in \d+ ms
			Building test.project
			Build test.project in \d+ ms
		''')
	}
	
	@Test
	def void testUnaffected_methodBodyChanged_Java() {
		val foo = createFile('Foo.java', '''
			public class Foo {
				public Object foo() { return new Object(); }
			}
		''')
		createFile('Bar', '''
			class Bar extends Foo {}
		''')
		autoBuild
		foo.changeContent('''
			public class Foo {
				public Object foo() { return null; }
			}
		''')
		assertBuildLogs('''
			Building test.project
			Build test.project in \d+ ms
			Building test.project
			Build test.project in \d+ ms
		''')
	}
	
	
	@Test
	def void testAffected_nameAddedAndDeleted() {
		val foo = createFile('Foo', '''
			class Foo {}
		''')
		createFile('Bar', '''
			class Bar extends Foo {}
		''')
		autoBuild
		foo.changeContent('''
			class Baz {}
		''')
		assertBuildLogs('''
			Building test.project
			indexing platform:/resource/test.project/src/Foo.xtend
			indexing platform:/resource/test.project/src/Bar.xtend
			Build test.project in \d+ ms
			Building test.project
			indexing platform:/resource/test.project/src/Bar.xtend
			Build test.project in \d+ ms
			Building test.project
			Build test.project in \d+ ms
		''')
	}
	
	@Test
	def void testAffected_nameAddedAndDeleted_Java() {
		val foo = createFile('Foo.java', '''
			public class Foo {}
		''')
		createFile('Bar', '''
			class Bar extends Foo {}
		''')
		autoBuild
		foo.changeContent('''
			public class Baz {}
		''')
		assertBuildLogs('''
			Building test.project
			indexing platform:/resource/test.project/src/Bar.xtend
			Build test.project in \d+ ms
			Building test.project
			Build test.project in \d+ ms
		''')
	}
	
	@Test
	def void testAffected_fieldAdded() {
		val foo = createFile('Foo', '''
			class Foo {}
		''')
		createFile('Bar', '''
			class Bar extends Foo {}
		''')
		autoBuild
		foo.changeContent('''
			class Foo {
				int foo
			}
		''')
		assertBuildLogs('''
			Building test.project
			indexing platform:/resource/test.project/src/Foo.xtend
			indexing platform:/resource/test.project/src/Bar.xtend
			Build test.project in \d+ ms
			Building test.project
			Build test.project in \d+ ms
		''')
	}
	
	@Test
	def void testAffected_fieldAdded_Java() {
		val foo = createFile('Foo.java', '''
			public class Foo {}
		''')
		createFile('Bar', '''
			class Bar extends Foo {
				boolean foo
			}
		''')
		autoBuild
		foo.changeContent('''
			public class Foo {
				int foo;
			}
		''')
		assertBuildLogs('''
			Building test.project
			Build test.project in \d+ ms
			Building test.project
			indexing platform:/resource/test.project/src/Bar.xtend
			Build test.project in \d+ ms
			Building test.project
			Build test.project in \d+ ms
		''')
	}
	
	@Test
	def void testAffected_fieldTypeChanged() {
		val foo = createFile('Foo', '''
			class Foo {
				boolean foo
			}
		''')
		createFile('Bar', '''
			class Bar extends Foo {}
		''')
		autoBuild
		foo.changeContent('''
			class Foo {
				int foo
			}
		''')
		assertBuildLogs('''
			Building test.project
			indexing platform:/resource/test.project/src/Foo.xtend
			indexing platform:/resource/test.project/src/Bar.xtend
			Build test.project in \d+ ms
			Building test.project
			Build test.project in \d+ ms
		''')
	}
	
	@Test
	def void testAffected_fieldTypeChanges_Java() {
		val foo = createFile('Foo.java', '''
			public class Foo {
				boolean foo;
			}
		''')
		createFile('Bar', '''
			class Bar extends Foo {}
		''')
		autoBuild
		foo.changeContent('''
			public class Foo {
				int foo;
			}
		''')
		assertBuildLogs('''
			Building test.project
			Build test.project in \d+ ms
			Building test.project
			indexing platform:/resource/test.project/src/Bar.xtend
			Build test.project in \d+ ms
			Building test.project
			Build test.project in \d+ ms
		''')
	}
	
	@Test
	def void testAffected_exportedNameAdded() {
		val foo = createFile('Foo', '''
			class Foo {}
		''')
		createFile('Bar', '''
			class Bar extends Foo {}
		''')
		autoBuild
		foo.changeContent('''
			class Foo {}
			class Baz {}
		''')
		assertBuildLogs('''
			Building test.project
			indexing platform:/resource/test.project/src/Foo.xtend
			indexing platform:/resource/test.project/src/Bar.xtend
			Build test.project in \d+ ms
			Building test.project
			Build test.project in \d+ ms
		''')
	}
	
	@Test
	def void testUnaffected_exportedNameAdded_Java() {
		val foo = createFile('Foo.java', '''
			public class Foo {}
		''')
		createFile('Bar', '''
			class Bar extends Foo {}
		''')
		autoBuild
		foo.changeContent('''
			public class Foo {}
			class Baz {}
		''')
		assertBuildLogs('''
			Building test.project
			Build test.project in \d+ ms
			Building test.project
			Build test.project in \d+ ms
		''')
	}
	
	@Test
	def void testAffected_typeChanged() {
		val foo = createFile('Foo', '''
			class Foo {}
		''')
		createFile('Bar', '''
			class Bar extends Foo {}
		''')
		autoBuild
		foo.changeContent('''
			enum Foo {}
		''')
		assertBuildLogs('''
			Building test.project
			indexing platform:/resource/test.project/src/Foo.xtend
			indexing platform:/resource/test.project/src/Bar.xtend
			Build test.project in \d+ ms
			Building test.project
			Build test.project in \d+ ms
		''')
	}
	
	@Test
	def void testAffected_typeChanged_Java() {
		val foo = createFile('Foo.java', '''
			public class Foo {}
		''')
		createFile('Bar', '''
			class Bar extends Foo {}
		''')
		autoBuild
		foo.changeContent('''
			public enum Foo {}
		''')
		assertBuildLogs('''
			Building test.project
			Build test.project in \d+ ms
			Building test.project
			indexing platform:/resource/test.project/src/Bar.xtend
			Build test.project in \d+ ms
			Building test.project
			Build test.project in \d+ ms
		''')
	}
	
	@Test
	def void testAffected_dependentProject() {
		val foo = createFile('Foo', '''
			class Foo {}
		''')
		createClientProjectFile('Client', '''
			class Client extends Foo {}
		''')
		autoBuild
		foo.changeContent('''
			class Foo {
				int foo;
			}
		''')
		assertBuildLogs('''
			Building test.project
			indexing platform:/resource/test.project/src/Foo.xtend
			Build test.project in \d+ ms
			Building test.client
			indexing platform:/resource/test.client/src/Client.xtend
			Build test.client in \d+ ms
			Building test.project
			Build test.project in \d+ ms
			Building test.client
			Build test.client in \d+ ms
		''')
	}
	
	@Test
	def void testAffected_dependentProject_Java() {
		val foo = createFile('Foo.java', '''
			public class Foo {}
		''')
		createClientProjectFile('Client', '''
			class Client extends Foo {}
		''')
		autoBuild
		foo.changeContent('''
			public class Foo {
				protected int foo;
			}
		''')
		assertBuildLogs('''
			Building test.project
			Build test.project in \d+ ms
			Building test.client
			Build test.client in \d+ ms
			Building test.project
			Build test.project in \d+ ms
			Building test.client
			indexing platform:/resource/test.client/src/Client.xtend
			Build test.client in \d+ ms
			Building test.client
			Build test.client in \d+ ms
		''')
	}
	
	@Test
	def void testAffected_dependentProject_Java_WithExpression() {
		val foo = createFile('Foo.java', '''
			public class Foo {}
		''')
		createClientProjectFile('Client', '''
			class Client extends Foo {
				def void m(String s) {
					s.length
				}
			}
		''')
		autoBuild
		foo.changeContent('''
			public class Foo {
				protected int foo;
			}
		''')
		assertBuildLogs('''
			Building test.project
			Build test.project in \d+ ms
			Building test.client
			Build test.client in \d+ ms
			Building test.project
			Build test.project in \d+ ms
			Building test.client
			indexing platform:/resource/test.client/src/Client.xtend
			Build test.client in \d+ ms
			Building test.client
			Build test.client in \d+ ms
		''')
	}
	
	@Test
	def void testAffected_annotationProcessorChanged_singleFile() {
		val foo = createFile('Foo', '''
			import org.eclipse.xtend.lib.macro.AbstractClassProcessor
			import org.eclipse.xtend.lib.macro.Active

			@Active(Bar)
			annotation Foo {}
			
			class Bar extends AbstractClassProcessor {}
		''')
		createClientProjectFile('Client', '''
			@Foo 
			class Client {}
		''')
		autoBuild
		foo.changeContent('''
			import org.eclipse.xtend.lib.macro.AbstractClassProcessor
			import org.eclipse.xtend.lib.macro.Active
			import org.eclipse.xtend.lib.macro.TransformationContext
			import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
			
			@Active(Bar)
			annotation Foo {
			}
			
			class Bar extends AbstractClassProcessor {
				override doTransform(MutableClassDeclaration it, extension TransformationContext context) {
					addField('foo', [
						type = int.newTypeReference
					])
				}
			}
		''')
		assertBuildLogs('''
			Building test.project
			indexing platform:/resource/test.project/src/Foo.xtend
			Build test.project in \d+ ms
			Building test.client
			indexing platform:/resource/test.client/src/Client.xtend
			Build test.client in \d+ ms
			Building test.project
			Build test.project in \d+ ms
			Building test.client
			Build test.client in \d+ ms
		''')
	}
	
	@Test
	def void testAffected_annotationProcessorChanged_separateFiles() {
		createFile('Foo', '''
			import org.eclipse.xtend.lib.macro.Active

			@Active(Bar)
			annotation Foo {}
		''')
		val bar = createFile('Bar', '''
			import org.eclipse.xtend.lib.macro.AbstractClassProcessor

			class Bar extends AbstractClassProcessor {}
		''')
		createClientProjectFile('Client', '''
			@Foo 
			class Client {}
		''')
		autoBuild
		bar.changeContent('''
			import org.eclipse.xtend.lib.macro.AbstractClassProcessor
			import org.eclipse.xtend.lib.macro.TransformationContext
			import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
			
			class Bar extends AbstractClassProcessor {
				override doTransform(MutableClassDeclaration it, extension TransformationContext context) {
					addField('foo', [
						type = int.newTypeReference
					])
				}
			}
		''')
		assertBuildLogs('''
			Building test.project
			indexing platform:/resource/test.project/src/Bar.xtend
			indexing platform:/resource/test.project/src/Foo.xtend
			Build test.project in \d+ ms
			Building test.client
			indexing platform:/resource/test.client/src/Client.xtend
			Build test.client in \d+ ms
			Building test.project
			Build test.project in \d+ ms
			Building test.client
			Build test.client in \d+ ms
		''')
	}
	
	private def assertBuildLogs(CharSequence expected) {
		val logs = new StringBuilder;
		(logger as XtextBuildConsole.Logger).registerDelegate[
			logs.append(toString.trim + '\n')
		]
		autoBuild
		assertTrue(logs.toString.trim, logs.toString.trim.matches(expected.toString.trim))
	}
	
	private def autoBuild() {
		IResourcesSetupUtil.waitForBuild
	}
	
	private def changeContent(IFile file, CharSequence sequence) {
		file.setContents(new StringInputStream(sequence.toString), IResource.FORCE, null)
	}
	
	private def createClientProjectFile(String name, CharSequence content) {
		clientProject = WorkbenchTestHelper.createPluginProject('test.client')
		JavaProjectSetupUtil.addProjectReference(JavaCore.create(clientProject), JavaCore.create(project))
		createFile(new Path('test.client/src/' + name + '.xtend'), content.toString)
	}
	
}