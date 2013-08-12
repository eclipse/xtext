package org.eclipse.xtend.ide.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.ui.texteditor.MarkerUtilities
import org.junit.Before
import org.junit.After

class CircularDepsBetweenJavaAndXtendTest extends AbstractXtendUITestCase {

	@Inject 
	private WorkbenchTestHelper workbenchTestHelper;
	
	@Before @After def void cleanUp() {
		workbenchTestHelper.tearDown
	}
	
	@Test def void testBug388575() {
		workbenchTestHelper.createFile('JavaInterface.java', '''
			public interface JavaInterface {
			    Moon getit();
			}
		''')
		workbenchTestHelper.createFile('Moon.xtend', '''
			class Moon {
			}
		''')
		workbenchTestHelper.createFile('XtendClass.xtend', '''
			class XtendClass implements JavaInterface {
				override getit() {
					return new Moon
				}
			}
		''')
		waitForAutoBuild()
		assertNoErrorsInWorkspace
	}
	
	@Test def void testJavaReferencesXtendWithTypeParam() {
		workbenchTestHelper.createFile('JavaClass.java', '''
			public class JavaClass extends XtendClass<JavaClass> {
			}
		''')
		workbenchTestHelper.createFile('XtendClass.xtend', '''
			class XtendClass<T extends JavaClass> {
				def JavaClass getIt() {
					new JavaClass()
				}
			}
		''')
		waitForAutoBuild()
		assertNoErrorsInWorkspace
	}
	
	@Test def void testJavaSignatureDependsOnXtend() {
		workbenchTestHelper.createFile('test/FooProvider.java', '''
			package test;

			public interface FooProvider {
				public Foo get();
			}
		''')
		workbenchTestHelper.createFile('test/Foo.xtend', '''
			package test
			
			@Data class Foo {
			}
		''')
		val file = workbenchTestHelper.createFile('test/FooUser.xtend', '''
			package test
			
			import test.FooProvider
			
			@SuppressWarnings("all")
			class FooUser {
				
				def void doStuff(FooProvider provider) {
					val foo = provider.get
					foo.toString
				}
			}
		''')
		waitForAutoBuild
		assertEquals(0,file.findMarkers(IMarker::PROBLEM, true, IResource::DEPTH_INFINITE).length)
	}
	
	def void assertNoErrorsInWorkspace() {
		val findMarkers = ResourcesPlugin::workspace.root.findMarkers(IMarker::PROBLEM, true, IResource::DEPTH_INFINITE)
		for (iMarker : findMarkers) {
			assertFalse(MarkerUtilities::getMessage(iMarker), MarkerUtilities::getSeverity(iMarker) == IMarker::SEVERITY_ERROR)
		}
	}
	
}