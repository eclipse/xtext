package org.eclipse.xtend.ide.tests.macros

import com.google.inject.Inject
import com.google.inject.Provider
import java.io.BufferedInputStream
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.jar.Manifest
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.emf.common.util.URI
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.internal.StopwatchRule
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.xbase.lib.Pair
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtend.ide.tests.WorkbenchTestHelper.*
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import org.eclipse.xtend.core.tests.macro.AbstractReusableActiveAnnotationTests

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XtendIDEInjectorProvider))
class ActiveAnnotationsProcessingInIDETest extends AbstractReusableActiveAnnotationTests {
	
	// dummy override, to make launch config available
	@Test override testSimpleModification() {
		super.testSimpleModification()
	}
	
	@Inject XtextResourceSetProvider resourceSetProvider
	@Inject Provider<CompilationUnitImpl> compilationUnitProvider 

	@Rule public StopwatchRule stopwatch = new StopwatchRule(true);
	
	@After def tearDown() throws Exception {
		macroProject = null
		userProject = null
		sourceFile = null
		cleanWorkspace();
	}
	
	IJavaProject macroProject
	IJavaProject userProject
	IFile sourceFile
	
	override assertProcessing(Pair<String,String> macroFile, Pair<String,String> clientFile, (CompilationUnitImpl)=>void expectations) {
		macroProject  = JavaCore::create(createPluginProject("macroProject"))
		macroProject.newSource(macroFile.key, macroFile.value.toString)
		val lidx = macroFile.key.lastIndexOf('/')
		if (lidx != -1) {
			val packageName = macroFile.key.substring(0, lidx).replace('/','.')
			macroProject.addExportedPackage(packageName)
		}
		userProject  = JavaCore::create(createPluginProject("userProject", "com.google.inject",
				"org.eclipse.xtend.lib", 
				"org.eclipse.xtext.xbase.lib",
				"org.eclipse.xtend.ide.tests.data",
				"org.junit4", "macroProject"))
		sourceFile = userProject.newSource(clientFile.key, clientFile.value.toString)
		waitForAutoBuild()
		
		val resourceSet = resourceSetProvider.get(userProject.project)
		val resource = resourceSet.getResource(URI::createPlatformResourceURI(sourceFile.fullPath.toString, true), true)
		val unit  = compilationUnitProvider.get
		unit.xtendFile = resource.contents.filter(typeof(XtendFile)).head
		expectations.apply(unit)
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
	
}
