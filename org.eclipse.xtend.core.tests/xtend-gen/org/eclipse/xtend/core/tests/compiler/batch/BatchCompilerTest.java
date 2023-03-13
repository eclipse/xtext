/**
 * Copyright (c) 2012, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.compiler.batch;

import com.google.common.base.Charsets;
import com.google.inject.Inject;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.apache.log4j.Level;
import org.eclipse.xtend.core.compiler.batch.XtendBatchCompiler;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.logging.LoggingTester;
import org.eclipse.xtext.testing.smoketest.IgnoredBySmokeTest;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.FileSourceFolder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Batch compiler tests.
 * @see XtendBatchCompiler
 */
@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@IgnoredBySmokeTest
@SuppressWarnings("all")
public class BatchCompilerTest {
  @Inject
  private XtendBatchCompiler batchCompiler;

  private static String OUTPUT_DIRECTORY_WITH_SPACES = "./test result";

  private static String OUTPUT_DIRECTORY = "./test-result";

  private static String XTEND_SRC_DIRECTORY = "./batch-compiler-data/test data";

  private static String BUG396747_SRC_DIRECTORY = "./batch-compiler-data/bug396747";

  private static String BUG410594_SRC_DIRECTORY = "./batch-compiler-data/bug410594";

  private static String BUG416262_SRC_DIRECTORY = "./batch-compiler-data/bug416262";

  private static String BUG417177_SRC_DIRECTORY_1 = "./batch-compiler-data/bug417177/dir1/src1/";

  private static String BUG417177_SRC_DIRECTORY_2 = "./batch-compiler-data/bug417177/dir2/dir2a/src2";

  private static String BUG417177_OUTPUT_DIRECTORY = "./batch-compiler-data/bug417177/dir3/bin";

  private static String TEMP_DIRECTORY = "./test-temp-dir";

  private static String TEMP_DIRECTORY_WITH_SPACES = "./test temp dir";

  private static final Set<File> abfalleimer = CollectionLiterals.<File>newHashSet();

  @Before
  public void onSetup() {
    try {
      this.batchCompiler.setSourcePath(BatchCompilerTest.XTEND_SRC_DIRECTORY);
      this.batchCompiler.setOutputPath(BatchCompilerTest.OUTPUT_DIRECTORY);
      this.batchCompiler.setDeleteTempDirectory(true);
      this.batchCompiler.setUseCurrentClassLoaderAsParent(true);
      this.batchCompiler.setCurrentClassLoader(this.getClass().getClassLoader());
      new File(BatchCompilerTest.OUTPUT_DIRECTORY).mkdir();
      File _file = new File(BatchCompilerTest.OUTPUT_DIRECTORY);
      Files.cleanFolder(_file, null, true, false);
      new File(BatchCompilerTest.OUTPUT_DIRECTORY_WITH_SPACES).mkdir();
      File _file_1 = new File(BatchCompilerTest.OUTPUT_DIRECTORY_WITH_SPACES);
      Files.cleanFolder(_file_1, null, true, false);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @After
  public void onTearDown() {
    try {
      File _file = new File(BatchCompilerTest.OUTPUT_DIRECTORY);
      Files.cleanFolder(_file, null, true, true);
      File _file_1 = new File(BatchCompilerTest.OUTPUT_DIRECTORY_WITH_SPACES);
      Files.cleanFolder(_file_1, null, true, true);
      boolean _exists = new File(BatchCompilerTest.TEMP_DIRECTORY).exists();
      if (_exists) {
        File _file_2 = new File(BatchCompilerTest.TEMP_DIRECTORY);
        Files.cleanFolder(_file_2, null, true, true);
      }
      boolean _exists_1 = new File(BatchCompilerTest.TEMP_DIRECTORY_WITH_SPACES).exists();
      if (_exists_1) {
        File _file_3 = new File(BatchCompilerTest.TEMP_DIRECTORY_WITH_SPACES);
        Files.cleanFolder(_file_3, null, true, true);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @AfterClass
  public static void afterClass() {
    try {
      final Consumer<File> _function = (File it) -> {
        boolean _exists = it.exists();
        if (_exists) {
          it.delete();
        }
      };
      BatchCompilerTest.abfalleimer.forEach(_function);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      BatchCompilerTest.abfalleimer.clear();
    }
  }

  @Test
  public void testInvalidConfiguration() {
    final Runnable _function = () -> {
      this.batchCompiler.setSourcePath(BatchCompilerTest.XTEND_SRC_DIRECTORY);
      this.batchCompiler.setOutputPath((BatchCompilerTest.XTEND_SRC_DIRECTORY + "/xtend-gen"));
      this.batchCompiler.compile();
    };
    final LoggingTester.LogCapture log = LoggingTester.captureLogging(Level.ERROR, XtendBatchCompiler.class, _function);
    log.assertLogEntry("xtend", "cannot be a child");
  }

  @Test
  public void testInvalidConfiguration_2() {
    boolean _startsWith = System.getProperty("os.name").startsWith("Windows");
    if (_startsWith) {
      final Runnable _function = () -> {
        this.batchCompiler.setSourcePath(BatchCompilerTest.XTEND_SRC_DIRECTORY);
        String _upperCase = BatchCompilerTest.XTEND_SRC_DIRECTORY.toUpperCase();
        String _plus = (_upperCase + "/xtend-gen");
        this.batchCompiler.setOutputPath(_plus);
        this.batchCompiler.compile();
      };
      final LoggingTester.LogCapture log = LoggingTester.captureLogging(Level.ERROR, XtendBatchCompiler.class, _function);
      log.assertLogEntry("xtend", "cannot be a child");
    }
  }

  @Test
  public void testBug462723() {
    this.batchCompiler.setSourcePath(BatchCompilerTest.XTEND_SRC_DIRECTORY);
    this.batchCompiler.setOutputPath((BatchCompilerTest.XTEND_SRC_DIRECTORY + "-gen"));
    Assert.assertTrue(this.batchCompiler.compile());
  }

  @Test
  public void testProjectConfig() {
    try {
      this.batchCompiler.compile();
      final FileProjectConfig project = this.batchCompiler.getProjectConfig();
      final String projectPath = new File(".").getCanonicalFile().getName();
      Assert.assertEquals(projectPath, project.getName());
      final OutputConfiguration output = this.batchCompiler.getOutputConfiguration();
      final String src = IterableExtensions.<FileSourceFolder>head(project.getSourceFolders()).getName();
      Assert.assertEquals("batch-compiler-data/test data", src.toString());
      final String target = output.getOutputDirectory(src);
      Assert.assertEquals("test-result", target.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testProjectConfigMultipleSourceDirs1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ws/prj1/src");
    _builder.append(File.pathSeparator);
    _builder.append("ws/prj1/src-gen");
    this.batchCompiler.setSourcePath(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("ws/prj1/bin");
    this.batchCompiler.setOutputPath(_builder_1.toString());
    this.batchCompiler.compile();
    final FileProjectConfig project = this.batchCompiler.getProjectConfig();
    Assert.assertEquals("prj1", project.getName());
    final OutputConfiguration output = this.batchCompiler.getOutputConfiguration();
    Assert.assertEquals(2, project.getSourceFolders().size());
    final Function1<FileSourceFolder, String> _function = (FileSourceFolder it) -> {
      return it.getName();
    };
    final List<String> keyPaths = IterableExtensions.<String>sort(IterableExtensions.<FileSourceFolder, String>map(project.getSourceFolders(), _function));
    String _get = keyPaths.get(0);
    final Procedure1<String> _function_1 = (String it) -> {
      Assert.assertEquals("src", it);
      Assert.assertEquals("bin", output.getOutputDirectory(it).toString());
    };
    ObjectExtensions.<String>operator_doubleArrow(_get, _function_1);
    String _get_1 = keyPaths.get(1);
    final Procedure1<String> _function_2 = (String it) -> {
      Assert.assertEquals("src-gen", it);
      Assert.assertEquals("bin", output.getOutputDirectory(it).toString());
    };
    ObjectExtensions.<String>operator_doubleArrow(_get_1, _function_2);
  }

  @Test
  public void testProjectConfigMultipleSourceDirs2AbsPaths() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/tmp/ws/prj1/src");
    _builder.append(File.pathSeparator);
    _builder.append("/tmp/ws/prj1/src-gen");
    this.batchCompiler.setSourcePath(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/tmp/ws/prj1/bin");
    this.batchCompiler.setOutputPath(_builder_1.toString());
    this.batchCompiler.compile();
    final FileProjectConfig project = this.batchCompiler.getProjectConfig();
    Assert.assertEquals("prj1", project.getName());
    final OutputConfiguration output = this.batchCompiler.getOutputConfiguration();
    Assert.assertEquals(2, project.getSourceFolders().size());
    final Function1<FileSourceFolder, String> _function = (FileSourceFolder it) -> {
      return it.getName();
    };
    final List<String> keyPaths = IterableExtensions.<String>sort(IterableExtensions.<FileSourceFolder, String>map(project.getSourceFolders(), _function));
    String _get = keyPaths.get(0);
    final Procedure1<String> _function_1 = (String it) -> {
      Assert.assertEquals("src", it);
      Assert.assertEquals("bin", output.getOutputDirectory(it));
    };
    ObjectExtensions.<String>operator_doubleArrow(_get, _function_1);
    String _get_1 = keyPaths.get(1);
    final Procedure1<String> _function_2 = (String it) -> {
      Assert.assertEquals("src-gen", it);
      Assert.assertEquals("bin", output.getOutputDirectory(it));
    };
    ObjectExtensions.<String>operator_doubleArrow(_get_1, _function_2);
  }

  @Test
  public void testProjectConfigMultipleSourceDirs3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ws/prj1/dir1/src");
    _builder.append(File.pathSeparator);
    _builder.append("ws/prj1/src-gen");
    this.batchCompiler.setSourcePath(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("ws/prj1/dir2/bin");
    this.batchCompiler.setOutputPath(_builder_1.toString());
    this.batchCompiler.compile();
    final FileProjectConfig project = this.batchCompiler.getProjectConfig();
    Assert.assertEquals("prj1", project.getName());
    final OutputConfiguration output = this.batchCompiler.getOutputConfiguration();
    Assert.assertEquals(2, project.getSourceFolders().size());
    final Function1<FileSourceFolder, String> _function = (FileSourceFolder it) -> {
      return it.getName();
    };
    final List<String> keyPaths = IterableExtensions.<String>sort(IterableExtensions.<FileSourceFolder, String>map(project.getSourceFolders(), _function));
    String _get = keyPaths.get(0);
    final Procedure1<String> _function_1 = (String it) -> {
      Assert.assertEquals("dir1/src", it);
      Assert.assertEquals("dir2/bin", output.getOutputDirectory(it));
    };
    ObjectExtensions.<String>operator_doubleArrow(_get, _function_1);
    String _get_1 = keyPaths.get(1);
    final Procedure1<String> _function_2 = (String it) -> {
      Assert.assertEquals("src-gen", it);
      Assert.assertEquals("dir2/bin", output.getOutputDirectory(it));
    };
    ObjectExtensions.<String>operator_doubleArrow(_get_1, _function_2);
  }

  @Test
  public void testProjectConfigMultipleSourceDirs4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ws/prj1/src");
    _builder.append(File.pathSeparator);
    _builder.append("ws/prj1/dir1/src-gen");
    this.batchCompiler.setSourcePath(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("ws/prj1/bin");
    this.batchCompiler.setOutputPath(_builder_1.toString());
    this.batchCompiler.compile();
    final FileProjectConfig project = this.batchCompiler.getProjectConfig();
    Assert.assertEquals("prj1", project.getName());
    final OutputConfiguration output = this.batchCompiler.getOutputConfiguration();
    Assert.assertEquals(2, project.getSourceFolders().size());
    final Function1<FileSourceFolder, String> _function = (FileSourceFolder it) -> {
      return it.getName();
    };
    final List<String> keyPaths = IterableExtensions.<String>sort(IterableExtensions.<FileSourceFolder, String>map(project.getSourceFolders(), _function));
    String _get = keyPaths.get(0);
    final Procedure1<String> _function_1 = (String it) -> {
      Assert.assertEquals("dir1/src-gen", it);
      Assert.assertEquals("bin", output.getOutputDirectory(it));
    };
    ObjectExtensions.<String>operator_doubleArrow(_get, _function_1);
    String _get_1 = keyPaths.get(1);
    final Procedure1<String> _function_2 = (String it) -> {
      Assert.assertEquals("src", it);
      Assert.assertEquals("bin", output.getOutputDirectory(it));
    };
    ObjectExtensions.<String>operator_doubleArrow(_get_1, _function_2);
  }

  @Test
  public void testProjectConfigMultipleSourceDirs5() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ws/prj1/dir1/dir1a/src");
    _builder.append(File.pathSeparator);
    _builder.append("ws/prj1/dir3/dir3a/src-gen");
    this.batchCompiler.setSourcePath(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("ws/prj1/dir2/dir2a/bin");
    this.batchCompiler.setOutputPath(_builder_1.toString());
    this.batchCompiler.compile();
    final FileProjectConfig project = this.batchCompiler.getProjectConfig();
    Assert.assertEquals("prj1", project.getName());
    final OutputConfiguration output = this.batchCompiler.getOutputConfiguration();
    Assert.assertEquals(2, project.getSourceFolders().size());
    final Function1<FileSourceFolder, String> _function = (FileSourceFolder it) -> {
      return it.getName();
    };
    final List<String> keyPaths = IterableExtensions.<String>sort(IterableExtensions.<FileSourceFolder, String>map(project.getSourceFolders(), _function));
    String _get = keyPaths.get(0);
    final Procedure1<String> _function_1 = (String it) -> {
      Assert.assertEquals("dir1/dir1a/src", it);
      Assert.assertEquals("dir2/dir2a/bin", output.getOutputDirectory(it));
    };
    ObjectExtensions.<String>operator_doubleArrow(_get, _function_1);
    String _get_1 = keyPaths.get(1);
    final Procedure1<String> _function_2 = (String it) -> {
      Assert.assertEquals("dir3/dir3a/src-gen", it);
      Assert.assertEquals("dir2/dir2a/bin", output.getOutputDirectory(it));
    };
    ObjectExtensions.<String>operator_doubleArrow(_get_1, _function_2);
  }

  @Test
  public void testProjectConfigMultipleSourceDirs6() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("dir1/ws/prj1/dir2/dir3/dir4/src1");
    _builder.append(File.pathSeparator);
    _builder.append("dir1/ws/prj1/dir2/dir3/src2");
    _builder.append(File.pathSeparator);
    _builder.append("dir1/ws/prj1/dir2/src3");
    _builder.append(File.pathSeparator);
    _builder.append("dir1/ws/prj1/src4");
    this.batchCompiler.setSourcePath(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("dir1/ws/prj1/dir2/dir3/dir4/dir5/bin");
    this.batchCompiler.setOutputPath(_builder_1.toString());
    this.batchCompiler.compile();
    final FileProjectConfig project = this.batchCompiler.getProjectConfig();
    Assert.assertEquals("prj1", project.getName());
    final OutputConfiguration output = this.batchCompiler.getOutputConfiguration();
    Assert.assertEquals(4, project.getSourceFolders().size());
    final Function1<FileSourceFolder, String> _function = (FileSourceFolder it) -> {
      return it.getName();
    };
    final List<String> keyPaths = IterableExtensions.<String>sort(IterableExtensions.<FileSourceFolder, String>map(project.getSourceFolders(), _function));
    String _get = keyPaths.get(0);
    final Procedure1<String> _function_1 = (String it) -> {
      Assert.assertEquals("dir2/dir3/dir4/src1", it);
      Assert.assertEquals("dir2/dir3/dir4/dir5/bin", output.getOutputDirectory(it));
    };
    ObjectExtensions.<String>operator_doubleArrow(_get, _function_1);
    String _get_1 = keyPaths.get(1);
    final Procedure1<String> _function_2 = (String it) -> {
      Assert.assertEquals("dir2/dir3/src2", it);
      Assert.assertEquals("dir2/dir3/dir4/dir5/bin", output.getOutputDirectory(it));
    };
    ObjectExtensions.<String>operator_doubleArrow(_get_1, _function_2);
    String _get_2 = keyPaths.get(2);
    final Procedure1<String> _function_3 = (String it) -> {
      Assert.assertEquals("dir2/src3", it);
      Assert.assertEquals("dir2/dir3/dir4/dir5/bin", output.getOutputDirectory(it));
    };
    ObjectExtensions.<String>operator_doubleArrow(_get_2, _function_3);
    String _get_3 = keyPaths.get(3);
    final Procedure1<String> _function_4 = (String it) -> {
      Assert.assertEquals("src4", it);
      Assert.assertEquals("dir2/dir3/dir4/dir5/bin", output.getOutputDirectory(it));
    };
    ObjectExtensions.<String>operator_doubleArrow(_get_3, _function_4);
  }

  @Test
  public void testProjectConfigSameDir() {
    this.batchCompiler.setSourcePath("ws/prj1");
    this.batchCompiler.setOutputPath("ws/prj1");
    Assert.assertFalse(this.batchCompiler.compile());
    Assert.assertNull(this.batchCompiler.getProjectConfig());
  }

  @Test
  public void testProjectConfigWithoutCommonProjectDir() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/tmp/ws/prj1/src");
    this.batchCompiler.setSourcePath(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/usr/local/tmp/ws/prj1/bin");
    this.batchCompiler.setOutputPath(_builder_1.toString());
    this.batchCompiler.compile();
    Assert.assertNull(this.batchCompiler.getProjectConfig());
    Assert.assertNull(this.batchCompiler.getOutputConfiguration());
  }

  @Test
  public void testProjectConfigWithoutCommonWorkspaceDir() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/some_non_existing_folder/src");
    this.batchCompiler.setSourcePath(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/some_non_existing_folder/bin");
    this.batchCompiler.setOutputPath(_builder_1.toString());
    this.batchCompiler.compile();
    Assert.assertNull(this.batchCompiler.getProjectConfig());
    Assert.assertNull(this.batchCompiler.getOutputConfiguration());
  }

  @Test
  public void testProjectConfigWithTopLevelCommonWorkspaceDir() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/tmp/prj/src");
    this.batchCompiler.setSourcePath(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/tmp/prj/bin");
    this.batchCompiler.setOutputPath(_builder_1.toString());
    this.batchCompiler.compile();
    Assert.assertNotNull(this.batchCompiler.getProjectConfig());
    Assert.assertNotNull(this.batchCompiler.getOutputConfiguration());
  }

  @Test
  public void bug368551() {
    this.batchCompiler.setTempDirectory(BatchCompilerTest.TEMP_DIRECTORY_WITH_SPACES);
    this.batchCompiler.setSourcePath(BatchCompilerTest.XTEND_SRC_DIRECTORY);
    this.batchCompiler.setOutputPath(BatchCompilerTest.OUTPUT_DIRECTORY_WITH_SPACES);
    this.batchCompiler.compile();
    Assert.assertEquals(14, ((List<String>)Conversions.doWrapArray(new File((BatchCompilerTest.OUTPUT_DIRECTORY_WITH_SPACES + "/test")).list())).size());
  }

  @Test
  public void bug387829() {
    this.batchCompiler.setTempDirectory(BatchCompilerTest.TEMP_DIRECTORY_WITH_SPACES);
    this.batchCompiler.setSourcePath(BatchCompilerTest.XTEND_SRC_DIRECTORY);
    this.batchCompiler.setOutputPath(BatchCompilerTest.OUTPUT_DIRECTORY_WITH_SPACES);
    this.batchCompiler.setClassPath(BatchCompilerTest.XTEND_SRC_DIRECTORY);
    this.batchCompiler.compile();
    final File compilerOutputDir = new File((BatchCompilerTest.OUTPUT_DIRECTORY_WITH_SPACES + "/test"));
    Assert.assertTrue("Compiler output exists", compilerOutputDir.exists());
    Assert.assertEquals(14, ((List<String>)Conversions.doWrapArray(compilerOutputDir.list())).size());
  }

  @Test
  public void bug396747() {
    this.batchCompiler.setSourcePath(BatchCompilerTest.BUG396747_SRC_DIRECTORY);
    Assert.assertTrue("Compiling empty file pass", this.batchCompiler.compile());
  }

  @Test
  public void bug410594() {
    this.batchCompiler.setSourcePath(BatchCompilerTest.BUG410594_SRC_DIRECTORY);
    Assert.assertTrue("Compiling empty file pass", this.batchCompiler.compile());
  }

  @Test
  @Ignore
  public void bug416262() {
    this.batchCompiler.setSourcePath(BatchCompilerTest.BUG416262_SRC_DIRECTORY);
    Assert.assertTrue("Compiling funny file pass", this.batchCompiler.compile());
  }

  @Test
  public void bug417177() {
    final File outputDir = new File(BatchCompilerTest.BUG417177_OUTPUT_DIRECTORY);
    outputDir.mkdirs();
    new File(outputDir, "mypackage/Bug417177_1.java").delete();
    new File(outputDir, "mypackage/Bug417177_2.java").delete();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(BatchCompilerTest.BUG417177_SRC_DIRECTORY_1);
    _builder.append(File.pathSeparator);
    _builder.append(BatchCompilerTest.BUG417177_SRC_DIRECTORY_2);
    this.batchCompiler.setSourcePath(_builder.toString());
    this.batchCompiler.setOutputPath(BatchCompilerTest.BUG417177_OUTPUT_DIRECTORY);
    Assert.assertTrue("Compiling files from multiple source directories", this.batchCompiler.compile());
    Assert.assertTrue(new File(outputDir, "mypackage/Bug417177_1.java").exists());
    Assert.assertTrue(new File(outputDir, "mypackage/Bug417177_2.java").exists());
  }

  @Test
  public void testActiveAnnotatons1() {
    this.batchCompiler.setSourcePath("./batch-compiler-data/activeAnnotations1");
    final Runnable _function = () -> {
      Assert.assertFalse(this.batchCompiler.compile());
    };
    final LoggingTester.LogCapture logs = LoggingTester.captureLogging(Level.ERROR, XtendBatchCompiler.class, _function);
    logs.assertNumberOfLogEntries(1);
  }

  @Test
  public void testActiveAnnotatons2() {
    this.batchCompiler.setSourcePath("./batch-compiler-data/activeAnnotations2");
    Assert.assertTrue(this.batchCompiler.compile());
    final FilenameFilter _function = (File dir, String name) -> {
      return name.endsWith(".java");
    };
    final String javaFiles = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(new File((BatchCompilerTest.OUTPUT_DIRECTORY + "/mypackage")).list(_function))), ",");
    Assert.assertEquals("Client.java", javaFiles);
    final File txtFile = new File((BatchCompilerTest.OUTPUT_DIRECTORY + "/Test.txt"));
    Assert.assertTrue(txtFile.exists());
  }

  @Test
  public void testBug443800() {
    this.batchCompiler.setSourcePath("./batch-compiler-data/bug443800");
    Assert.assertTrue(this.batchCompiler.compile());
    final FilenameFilter _function = (File dir, String name) -> {
      return name.endsWith(".java");
    };
    final String javaFiles = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(new File((BatchCompilerTest.OUTPUT_DIRECTORY + "/")).list(_function))), ",");
    Assert.assertEquals("Bug443800.java", javaFiles);
  }

  @Test
  public void testClassPath() {
    this.batchCompiler.setSourcePath("./batch-compiler-data/classpathTest/src");
    this.batchCompiler.setClassPath("./batch-compiler-data/classpathTest/dependency");
    Assert.assertTrue("Compiling with correct dependency resolution", this.batchCompiler.compile());
  }

  @Test
  public void testCompileTestDataWithTrace() {
    this.batchCompiler.setWriteTraceFiles(true);
    this.batchCompiler.compile();
    final FilenameFilter _function = (File dir, String name) -> {
      return name.endsWith(".java");
    };
    Assert.assertEquals(7, ((List<String>)Conversions.doWrapArray(new File((BatchCompilerTest.OUTPUT_DIRECTORY + "/test")).list(_function))).size());
    final FilenameFilter _function_1 = (File dir, String name) -> {
      return name.endsWith("._trace");
    };
    Assert.assertEquals(7, ((List<String>)Conversions.doWrapArray(new File((BatchCompilerTest.OUTPUT_DIRECTORY + "/test")).list(_function_1))).size());
  }

  @Test
  public void testCompileTestDataWithoutTrace() {
    this.batchCompiler.setWriteTraceFiles(false);
    this.batchCompiler.compile();
    final FilenameFilter _function = (File dir, String name) -> {
      return name.endsWith(".java");
    };
    Assert.assertEquals(7, ((List<String>)Conversions.doWrapArray(new File((BatchCompilerTest.OUTPUT_DIRECTORY + "/test")).list(_function))).size());
    final FilenameFilter _function_1 = (File dir, String name) -> {
      return name.endsWith("._trace");
    };
    Assert.assertEquals(0, ((List<String>)Conversions.doWrapArray(new File((BatchCompilerTest.OUTPUT_DIRECTORY + "/test")).list(_function_1))).size());
  }

  @Test
  public void testCompileTestDataWithStorage() {
    this.batchCompiler.setWriteStorageFiles(true);
    this.batchCompiler.compile();
    final FilenameFilter _function = (File dir, String name) -> {
      return name.endsWith(".java");
    };
    Assert.assertEquals(7, ((List<String>)Conversions.doWrapArray(new File((BatchCompilerTest.OUTPUT_DIRECTORY + "/test")).list(_function))).size());
    final FilenameFilter _function_1 = (File dir, String name) -> {
      return name.endsWith(".xtendbin");
    };
    Assert.assertEquals(5, ((List<String>)Conversions.doWrapArray(new File((BatchCompilerTest.OUTPUT_DIRECTORY + "/test")).list(_function_1))).size());
  }

  @Test
  public void testCompileTestDataWithoutStorage() {
    this.batchCompiler.setWriteStorageFiles(false);
    this.batchCompiler.compile();
    final FilenameFilter _function = (File dir, String name) -> {
      return name.endsWith(".java");
    };
    Assert.assertEquals(7, ((List<String>)Conversions.doWrapArray(new File((BatchCompilerTest.OUTPUT_DIRECTORY + "/test")).list(_function))).size());
    final FilenameFilter _function_1 = (File dir, String name) -> {
      return name.endsWith(".xtendbin");
    };
    Assert.assertEquals(0, ((List<String>)Conversions.doWrapArray(new File((BatchCompilerTest.OUTPUT_DIRECTORY + "/test")).list(_function_1))).size());
  }

  @Test
  public void testCompileSymlinkedResource() {
    final String tstResources = new File("./batch-compiler-data/test-resources/").toURI().normalize().getPath();
    final File wsRootFile = new File(tstResources, "symlink-test-ws/");
    final String wsRootPath = wsRootFile.getPath();
    final String linkToCreate = (wsRootPath + "/plain-folder/linked-src");
    boolean _createSymLink = this.createSymLink((tstResources + "/linked-folder/linked-src/"), linkToCreate);
    boolean _not = (!_createSymLink);
    if (_not) {
      System.err.println(
        "Symlink creation is not possible - skip test. org.eclipse.xtend.core.tests.compiler.batch.TestBatchCompiler.testCompileSymlinkedResource()");
      return;
    }
    File _file = new File(wsRootFile, "plain-folder/linked-src/");
    Assert.assertTrue("plain-folder/linked-src/ is a symlink", this.isSymlink(_file));
    File _file_1 = new File(wsRootFile, "plain-folder/src/");
    boolean _isSymlink = this.isSymlink(_file_1);
    boolean _not_1 = (!_isSymlink);
    Assert.assertTrue("plain-folder/src/ is not a symlink", _not_1);
    this.batchCompiler.setWriteTraceFiles(true);
    this.batchCompiler.setSourcePath(((((wsRootPath + "/plain-folder/src") + File.pathSeparator) + wsRootPath) + 
      "/plain-folder/linked-src"));
    final String customOutput = (wsRootPath + "/plain-folder/target");
    this.batchCompiler.setOutputPath(customOutput);
    Assert.assertTrue(this.batchCompiler.compile());
    Assert.assertTrue(new File((wsRootPath + "/plain-folder/target/Test.txt")).exists());
    final FilenameFilter _function = (File dir, String name) -> {
      return name.endsWith(".java");
    };
    Assert.assertEquals(2, ((List<String>)Conversions.doWrapArray(new File(customOutput).list(_function))).size());
    final FilenameFilter _function_1 = (File dir, String name) -> {
      return name.endsWith("._trace");
    };
    Assert.assertEquals(2, ((List<String>)Conversions.doWrapArray(new File(customOutput).list(_function_1))).size());
  }

  private boolean createSymLink(final String linkTarget, final String link) {
    try {
      File linkFile = new File(link);
      BatchCompilerTest.abfalleimer.add(linkFile);
      if ((linkFile.exists() && this.isSymlink(linkFile))) {
        return true;
      }
      String[] cmd = { "ln", "-s", linkTarget, link };
      try {
        final String[] _converted_cmd = (String[])cmd;
        String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_converted_cmd)), " ");
        String _plus = ("Exec: " + _join);
        InputOutput.<String>println(_plus);
        final Process proc = Runtime.getRuntime().exec(cmd);
        int _waitFor = proc.waitFor();
        return (_waitFor == 0);
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          return false;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  private boolean isSymlink(final File file) {
    try {
      File canon = null;
      String _parent = file.getParent();
      boolean _tripleEquals = (_parent == null);
      if (_tripleEquals) {
        canon = file;
      } else {
        File canonDir = file.getParentFile().getCanonicalFile();
        String _name = file.getName();
        File _file = new File(canonDir, _name);
        canon = _file;
      }
      boolean _equals = canon.getCanonicalFile().equals(canon.getAbsoluteFile());
      return (!_equals);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  private String getContents(final String fileName) {
    try {
      File _file = new File(fileName);
      return com.google.common.io.Files.asCharSource(_file, Charsets.UTF_8).read();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void tempDirectory() {
    this.batchCompiler.setDeleteTempDirectory(false);
    this.batchCompiler.setTempDirectory(BatchCompilerTest.TEMP_DIRECTORY);
    Assert.assertTrue(this.batchCompiler.compile());
    String _tempDirectory = this.batchCompiler.getTempDirectory();
    Assert.assertEquals(2, ((List<String>)Conversions.doWrapArray(new File(_tempDirectory).list())).size());
    Assert.assertTrue(this.batchCompiler.compile());
    String _tempDirectory_1 = this.batchCompiler.getTempDirectory();
    Assert.assertEquals(4, ((List<String>)Conversions.doWrapArray(new File(_tempDirectory_1).list())).size());
  }

  @Test
  public void deleteTempDirectory() {
    this.batchCompiler.setDeleteTempDirectory(true);
    this.batchCompiler.setTempDirectory(BatchCompilerTest.TEMP_DIRECTORY);
    Assert.assertTrue(this.batchCompiler.compile());
    Assert.assertEquals(0, ((List<String>)Conversions.doWrapArray(new File(BatchCompilerTest.TEMP_DIRECTORY).list())).size());
  }

  @Test
  public void testNoSuppressWarningsAnnotations() {
    this.batchCompiler.setGenerateSyntheticSuppressWarnings(false);
    this.batchCompiler.setSourcePath("./batch-compiler-data/xtendClass");
    Assert.assertTrue(this.batchCompiler.compile());
    Assert.assertFalse(this.getContents((BatchCompilerTest.OUTPUT_DIRECTORY + "/XtendA.java")).contains("@SuppressWarnings"));
  }

  @Test
  public void testJavaVersion5() {
    this.batchCompiler.setJavaSourceVersion("1.5");
    this.batchCompiler.setSourcePath("./batch-compiler-data/javaVersion");
    Assert.assertTrue(this.batchCompiler.compile());
    final String generated = this.getContents((BatchCompilerTest.OUTPUT_DIRECTORY + "/XtendA.java"));
    Assert.assertFalse(generated.contains("@Override"));
    Assert.assertTrue(generated.contains("new Function1<Integer, String>"));
  }

  @Test
  public void testJavaVersion6() {
    this.batchCompiler.setJavaSourceVersion("1.6");
    this.batchCompiler.setSourcePath("./batch-compiler-data/javaVersion");
    Assert.assertTrue(this.batchCompiler.compile());
    final String generated = this.getContents((BatchCompilerTest.OUTPUT_DIRECTORY + "/XtendA.java"));
    Assert.assertTrue(generated.contains("@Override"));
    Assert.assertTrue(generated.contains("new Function1<Integer, String>"));
  }

  @Test
  public void testJavaVersion7() {
    this.batchCompiler.setJavaSourceVersion("1.7");
    this.batchCompiler.setSourcePath("./batch-compiler-data/javaVersion");
    Assert.assertTrue(this.batchCompiler.compile());
    final String generated = this.getContents((BatchCompilerTest.OUTPUT_DIRECTORY + "/XtendA.java"));
    Assert.assertTrue(generated.contains("@Override"));
    Assert.assertTrue(generated.contains("new Function1<Integer, String>"));
  }

  @Test
  public void testJavaVersion8() {
    this.batchCompiler.setJavaSourceVersion("1.8");
    this.batchCompiler.setSourcePath("./batch-compiler-data/javaVersion");
    Assert.assertTrue(this.batchCompiler.compile());
    final String generated = this.getContents((BatchCompilerTest.OUTPUT_DIRECTORY + "/XtendA.java"));
    Assert.assertTrue(generated.contains("@Override"));
    Assert.assertTrue(generated.contains("(Integer it) ->"));
  }

  @Test
  public void testIssue750() {
    this.batchCompiler.setJavaSourceVersion("1.8");
    this.batchCompiler.setSourcePath("./batch-compiler-data/issue750/src");
    this.batchCompiler.setClassPath("./batch-compiler-data/issue750/lib/mydependency.jar");
    Assert.assertTrue(this.batchCompiler.compile());
  }
}
