package org.eclipse.xtend.ide.tests.macros

import java.io.BufferedInputStream
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.jar.Manifest
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IWorkspaceRunnable
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.jdt.core.Flags
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin
import org.eclipse.ui.texteditor.MarkerUtilities
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtext.util.StringInputStream
import org.junit.Test

import static org.eclipse.xtend.ide.tests.WorkbenchTestHelper.*
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import org.eclipse.core.resources.IWorkspace
import org.junit.Rule
import org.eclipse.xtext.junit4.internal.StopWatchRule

class MacroProcessingTest extends AbstractXtendUITestCase {

	override setUp() throws Exception {
		super.setUp()
		modifyWorkspace [
			macroProject  = JavaCore::create(createPluginProject("macroProject"))
			userProject  = JavaCore::create(createPluginProject("userProject", "com.google.inject",
					"org.eclipse.xtend.lib", 
					"org.eclipse.xtext.xbase.lib",
					"org.eclipse.xtend.ide.tests.data",
					"org.junit4", "macroProject"))
		]
	}
	
	IJavaProject macroProject
	IJavaProject userProject
	
	@Rule public static StopWatchRule stopWatch = new StopWatchRule(true);
	
	override tearDown() throws Exception {
		super.tearDown()
		modifyWorkspace [
			cleanWorkspace();
		]
	}
	
	def IFile newSource(IJavaProject it, String fileName, String contents) {
		val result = it.project.getFile("src/"+fileName)
		var parent = result.parent
		while (!parent.exists) {
			(parent as IFolder).create(true,false,null)
		}
		result.create(new StringInputStream(contents), true, null)
		return result
	}
	
	def void addExportedPackage(IJavaProject pluginProject, String ... exportedPackages) {
		val manifestFile = pluginProject.project.getFile("META-INF/MANIFEST.MF")
		val manifest = new Manifest(manifestFile.contents)
		val attrs = manifest.getMainAttributes()
		if (attrs.containsKey("Export-Package")) {
			attrs.putValue("Export-Package", attrs.get("Export-Package")+","+exportedPackages.join(","))
		} else {
			attrs.putValue("Export-Package", exportedPackages.join(","))
		}
		val out = new ByteArrayOutputStream()
		manifest.write(out)
		val in = new ByteArrayInputStream(out.toByteArray)
		manifestFile.setContents(new BufferedInputStream(in), true, true, null)
	}
	
	def void modifyWorkspace(IWorkspaceRunnable runnable) {
		IDEWorkbenchPlugin::getPluginWorkspace().run( runnable, ResourcesPlugin::workspace.root, IWorkspace::AVOID_UPDATE, null)
	}
	
	@Test def void testAbstractAnnotation() {
		modifyWorkspace [
			macroProject.newSource('myannotation/AbstractAnnotation.xtend',
				'''
					package myannotation
					
					import java.util.List
					import org.eclipse.xtend.lib.macro.Active
					import org.eclipse.xtend.lib.macro.ModifyContext
					import org.eclipse.xtend.lib.macro.ModifyProcessor
					import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

					@Active(typeof(AbstractProcessor))
					annotation Abstract { }
					class AbstractProcessor implements ModifyProcessor<MutableClassDeclaration> {
						
						extension ModifyContext ctx
						
						override modify(List<? extends MutableClassDeclaration> annotatedSourceClasses, ModifyContext context) {
							ctx = context
							annotatedSourceClasses.forEach [
								^abstract = true
							]
						}
						
					}
				''')
			macroProject.addExportedPackage("myannotation")
		]
		waitForAutoBuild()
		modifyWorkspace [
			userProject.newSource('myusercode/UserCode.xtend', '''
					package myusercode
					
					@myannotation.Abstract
					class MyClass {
						
					}
			''')
		]
		waitForAutoBuild()
		assertNoErrorsInWorkspace
		val type = userProject.findType("myusercode.MyClass")
		assertTrue("The class should be abstract.", Flags::isAbstract(type.flags))
	}

	def void assertNoErrorsInWorkspace() {
		val findMarkers = ResourcesPlugin::workspace.root.findMarkers(IMarker::PROBLEM, true, IResource::DEPTH_INFINITE)
		for (iMarker : findMarkers) {
			assertFalse(MarkerUtilities::getMessage(iMarker),
				MarkerUtilities::getSeverity(iMarker) == IMarker::SEVERITY_ERROR)
		}
	}
}
