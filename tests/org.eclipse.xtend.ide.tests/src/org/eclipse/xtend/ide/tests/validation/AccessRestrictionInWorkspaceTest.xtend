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
		val xtendFile = 'secondProject/src/Dummy.xtend'.createFile('class C { restricted.A a }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertError(JVM_TYPE_REFERENCE, FORBIDDEN_REFERENCE, 'Access restriction: The type A is not accessible', 'on required project firstProject')
	}
	
	@Test
	def void testDiscouragedReferenceInOtherProject() {
		val xtendFile = 'secondProject/src/Dummy.xtend'.createFile('class C { discouraged.B b }').parse
		val c = xtendFile.xtendTypes.head as XtendClass
		c.assertWarning(JVM_TYPE_REFERENCE, DISCOURAGED_REFERENCE, 'Discouraged access: The type B is not accessible', 'on required project firstProject')
	}
	
	def parse(IFile file) {
		val resourceSet = get(file.project)
		val uri = URI::createPlatformResourceURI(file.fullPath.toString, true)
		val resource =  resourceSet.getResource(uri, true)
		return resource.contents.head as XtendFile
	}
	
	@Before def setUp() throws Exception {
		super.setUp()
		JavaCore::create(createPluginProject("firstProject")).configure
		'firstProject/src/restricted/A.java'.createFile('package restricted; public class A {}')
		'firstProject/src/discouraged/B.java'.createFile('package discouraged; public class B {}')
		
		JavaCore::create(createPluginProject("secondProject", "firstProject"))
		waitForAutoBuild
	}
	
	@After def tearDown() throws Exception {
		cleanWorkspace();
	}
	
	private def configure(IJavaProject pluginProject) {
		val manifestFile = pluginProject.project.getFile("META-INF/MANIFEST.MF")
		val manifest = new MergeableManifest(manifestFile.contents)
		manifest.addExportedPackages(#{'discouraged;x-internal:=true'})
		val out = new ByteArrayOutputStream()
		manifest.write(out)
		val in = new ByteArrayInputStream(out.toByteArray)
		manifestFile.setContents(in, true, true, null)
		return pluginProject
	}
}