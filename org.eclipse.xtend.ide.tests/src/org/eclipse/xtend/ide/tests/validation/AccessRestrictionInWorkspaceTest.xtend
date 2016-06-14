/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.validation

import com.google.inject.Inject
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import org.eclipse.core.resources.IFile
import org.eclipse.emf.common.util.URI
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.util.MergeableManifest
import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtend.ide.tests.WorkbenchTestHelper.*
import static org.eclipse.xtext.common.types.TypesPackage$Literals.*
import static org.eclipse.xtext.xbase.validation.IssueCodes.*

import static extension org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AccessRestrictionInWorkspaceTest extends AbstractXtendUITestCase {
	@Inject
	extension ValidationTestHelper
	@Inject
	extension IResourceSetProvider
	
	@Test
	def void testForbiddenReferenceInOtherProject() {
		val xtendFile = 'secondProject/src/Dummy.xtend'.createFile('class D { restricted.A a }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertError(JVM_TYPE_REFERENCE, FORBIDDEN_REFERENCE, 'Access restriction: The type A is not accessible', 'on required project firstProject')
	}
	
	@Test
	def void testDiscouragedReferenceInOtherProject() {
		val xtendFile = 'secondProject/src/Dummy.xtend'.createFile('class D { discouraged.B b }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertWarning(JVM_TYPE_REFERENCE, DISCOURAGED_REFERENCE, 'Discouraged access: The type B is not accessible', 'on required project firstProject')
	}
	
	@Test
	def void testForbiddenReferenceInSameProject() {
		val xtendFile = 'firstProject/src/Dummy.xtend'.createFile('class D { restricted.A a }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertNoError(DISCOURAGED_REFERENCE)
		c.assertNoError(FORBIDDEN_REFERENCE)
	}
	
	@Test
	def void testDiscouragedReferenceInSameProject() {
		val xtendFile = 'firstProject/src/Dummy.xtend'.createFile('class D { discouraged.B b }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertNoError(DISCOURAGED_REFERENCE)
		c.assertNoError(FORBIDDEN_REFERENCE)
	}
	
	@Test
	def void testExportedByOtherProject() {
		val xtendFile = 'secondProject/src/Dummy.xtend'.createFile('class D { allowed.C c }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertNoError(DISCOURAGED_REFERENCE)
		c.assertNoError(FORBIDDEN_REFERENCE)
	}
	
	@Test
	def void testForbiddenReferenceInReexportedProject() {
		val xtendFile = 'thirdProject/src/Dummy.xtend'.createFile('class D { restricted.A a }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertError(JVM_TYPE_REFERENCE, FORBIDDEN_REFERENCE, 'Access restriction: The type A is not accessible', 'on required project firstProject')
	}
	
	@Test
	def void testDiscouragedReferenceInReexportedProject() {
		val xtendFile = 'thirdProject/src/Dummy.xtend'.createFile('class D { discouraged.B b }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertWarning(JVM_TYPE_REFERENCE, DISCOURAGED_REFERENCE, 'Discouraged access: The type B is not accessible', 'on required project firstProject')
	}
	
	@Test
	def void testReexported() {
		val xtendFile = 'thirdProject/src/Dummy.xtend'.createFile('class D { allowed.C c }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertNoError(DISCOURAGED_REFERENCE)
		c.assertNoError(FORBIDDEN_REFERENCE)
	}
	
	@Test
	def void testForbiddenReferenceInImplicitLambdaParameter() {
		val xtendFile = 'secondProject/src/Dummy.xtend'.createFile('class D { new () { new discouraged.B().accept[] } }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertError(JVM_TYPE_REFERENCE, FORBIDDEN_REFERENCE, 'Access restriction: The type A is not accessible', 'on required project firstProject')
	}
	
	def parse(IFile file) {
		val resourceSet = get(file.project)
		val uri = URI::createPlatformResourceURI(file.fullPath.toString, true)
		val resource =  resourceSet.getResource(uri, true)
		return resource.contents.head as XtendFile
	}
	
	@Before override setUp() throws Exception {
		super.setUp()
		JavaCore::create(createPluginProject("firstProject")).configureExportedPackages
		'firstProject/src/restricted/A.java'.createFile('''package restricted; public class A {}''')
		'firstProject/src/discouraged/B.java'.createFile('''
			package discouraged;
			public class B {
				public interface I {
					void accept(Iterable<restricted.A> a);
				}
				public void accept(I i) {}
			}
		''')
		'firstProject/src/allowed/C.java'.createFile('''package allowed; public class C {}''')
		
		JavaCore::create(createPluginProject("secondProject", "firstProject;visibility:=reexport"))
		JavaCore::create(createPluginProject("thirdProject", "secondProject"))
		waitForBuild
	}
	
	@After override tearDown() throws Exception {
		cleanWorkspace();
	}
	
	private def configureExportedPackages(IJavaProject pluginProject) {
		val manifestFile = pluginProject.project.getFile("META-INF/MANIFEST.MF")
		val contents = manifestFile.contents
		val manifest = try {
			new MergeableManifest(contents)	
		} finally {
			contents.close
		}
		manifest.addExportedPackages(#{'allowed', 'discouraged;x-internal:=true'})
		val out = new ByteArrayOutputStream()
		manifest.write(out)
		val in = new ByteArrayInputStream(out.toByteArray)
		manifestFile.setContents(in, true, true, null)
		return pluginProject
	}
	
}