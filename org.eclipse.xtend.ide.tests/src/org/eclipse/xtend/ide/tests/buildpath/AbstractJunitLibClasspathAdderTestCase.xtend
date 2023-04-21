/*******************************************************************************
 * Copyright (c) 2019, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.buildpath

import com.google.inject.Inject
import java.io.InputStream
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.jdt.core.IClasspathEntry
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtend.ide.buildpath.XtendClasspathContainer
import org.eclipse.xtend.ide.buildpath.XtendLibClasspathAdder
import org.eclipse.xtend.ide.tests.AbstractXtendTestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil
import org.eclipse.xtext.ui.testing.util.TargetPlatformUtil
import org.eclipse.xtext.util.MergeableManifest2
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass

import static org.junit.Assert.assertTrue

/**
 * @author vivienjovet - Initial contribution and API
 */
abstract class AbstractJunitLibClasspathAdderTestCase {
    
    @Inject protected extension WorkbenchTestHelper workbenchHelper

    @Inject extension XtendLibClasspathAdder xtendLibAdder
    
    
    @BeforeClass
    def static void setUp() throws Exception {
        TargetPlatformUtil.setTargetPlatform(AbstractXtendTestCase)
    }

    @Before
    def void setUpProject() throws Exception {
        IResourcesSetupUtil.cleanWorkspace
        WorkbenchTestHelper.createPluginProject(WorkbenchTestHelper.TESTPROJECT_NAME,
            XtendClasspathContainer.BUNDLE_IDS_TO_INCLUDE)
    }

    @AfterClass
    def static void tearDownProject() throws Exception {
        IResourcesSetupUtil.cleanWorkspace();
    }
    
    def protected removePluginNature() {
        val project = project
        val description = project.description
        description.natureIds = description.natureIds.filter[it != 'org.eclipse.pde.PluginNature']
        project.setDescription(description, new NullProgressMonitor)
        JavaCore.create(project).addLibsToClasspath(new NullProgressMonitor)
    }
    
    def protected assertClasspath(String message, IPath entryPath) {
        assertTrue(
            message, 
            JavaCore.create(project).rawClasspath.exists[path == entryPath && entryKind == IClasspathEntry.CPE_CONTAINER]
        )
    }

    def protected assertRequireBundles(String[] expectedBundleIds) {
    	try (val InputStream contents = project.getFile(new Path('META-INF/MANIFEST.MF')).contents) {
	        val manifest = new MergeableManifest2(contents)
	        val requireBunbles = manifest.mainAttributes.get(MergeableManifest2.REQUIRE_BUNDLE)
	        for (bundleId : expectedBundleIds)
	            assertTrue('''require bundle entry «bundleId» is present''', requireBunbles.contains(bundleId))
	    }
    }
    
    def protected assertImportPackages(String[] expectedImports) {
    	try (val InputStream contents = project.getFile(new Path('META-INF/MANIFEST.MF')).contents) {
	        val manifest = new MergeableManifest2(contents)
	        val importedPackages = manifest.mainAttributes.get(MergeableManifest2.IMPORT_PACKAGE)
	        for (p : expectedImports)
	            assertTrue('''require import package «p» is present''', importedPackages.contains(p))
	    }
    }
    
}