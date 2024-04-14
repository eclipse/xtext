/**
 * Copyright (c) 2019, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.buildpath;

import com.google.inject.Inject;
import java.io.InputStream;
import java.util.Objects;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.ide.buildpath.XtendClasspathContainer;
import org.eclipse.xtend.ide.buildpath.XtendLibClasspathAdder;
import org.eclipse.xtend.ide.tests.AbstractXtendTestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.TargetPlatformUtil;
import org.eclipse.xtext.util.MergeableManifest2;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * @author vivienjovet - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractJunitLibClasspathAdderTestCase {
  @Inject
  @Extension
  protected WorkbenchTestHelper workbenchHelper;

  @Inject
  @Extension
  private XtendLibClasspathAdder xtendLibAdder;

  @BeforeClass
  public static void setUp() throws Exception {
    TargetPlatformUtil.setTargetPlatform(AbstractXtendTestCase.class);
  }

  @Before
  public void setUpProject() throws Exception {
    IResourcesSetupUtil.cleanWorkspace();
    WorkbenchTestHelper.createPluginProject(WorkbenchTestHelper.TESTPROJECT_NAME, 
      XtendClasspathContainer.BUNDLE_IDS_TO_INCLUDE);
  }

  @AfterClass
  public static void tearDownProject() throws Exception {
    IResourcesSetupUtil.cleanWorkspace();
  }

  protected void removePluginNature() {
    try {
      final IProject project = this.workbenchHelper.getProject();
      final IProjectDescription description = project.getDescription();
      final Function1<String, Boolean> _function = (String it) -> {
        return Boolean.valueOf((!Objects.equals(it, "org.eclipse.pde.PluginNature")));
      };
      description.setNatureIds(((String[])Conversions.unwrapArray(IterableExtensions.<String>filter(((Iterable<String>)Conversions.doWrapArray(description.getNatureIds())), _function), String.class)));
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      project.setDescription(description, _nullProgressMonitor);
      IJavaProject _create = JavaCore.create(project);
      NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
      this.xtendLibAdder.addLibsToClasspath(_create, _nullProgressMonitor_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected void assertClasspath(final String message, final IPath entryPath) {
    try {
      final Function1<IClasspathEntry, Boolean> _function = (IClasspathEntry it) -> {
        return Boolean.valueOf((Objects.equals(it.getPath(), entryPath) && (it.getEntryKind() == IClasspathEntry.CPE_CONTAINER)));
      };
      Assert.assertTrue(message, 
        IterableExtensions.<IClasspathEntry>exists(((Iterable<IClasspathEntry>)Conversions.doWrapArray(JavaCore.create(this.workbenchHelper.getProject()).getRawClasspath())), _function));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected void assertRequireBundles(final String[] expectedBundleIds) {
    try {
      try (final InputStream contents = new Function0<InputStream>() {
        @Override
        public InputStream apply() {
          try {
            IProject _project = AbstractJunitLibClasspathAdderTestCase.this.workbenchHelper.getProject();
            Path _path = new Path("META-INF/MANIFEST.MF");
            return _project.getFile(_path).getContents();
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      }.apply()) {
        final MergeableManifest2 manifest = new MergeableManifest2(contents);
        final String requireBunbles = manifest.getMainAttributes().get(MergeableManifest2.REQUIRE_BUNDLE);
        for (final String bundleId : expectedBundleIds) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("require bundle entry ");
          _builder.append(bundleId);
          _builder.append(" is present");
          Assert.assertTrue(_builder.toString(), requireBunbles.contains(bundleId));
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected void assertImportPackages(final String[] expectedImports) {
    try {
      try (final InputStream contents = new Function0<InputStream>() {
        @Override
        public InputStream apply() {
          try {
            IProject _project = AbstractJunitLibClasspathAdderTestCase.this.workbenchHelper.getProject();
            Path _path = new Path("META-INF/MANIFEST.MF");
            return _project.getFile(_path).getContents();
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      }.apply()) {
        final MergeableManifest2 manifest = new MergeableManifest2(contents);
        final String importedPackages = manifest.getMainAttributes().get(MergeableManifest2.IMPORT_PACKAGE);
        for (final String p : expectedImports) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("require import package ");
          _builder.append(p);
          _builder.append(" is present");
          Assert.assertTrue(_builder.toString(), importedPackages.contains(p));
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
