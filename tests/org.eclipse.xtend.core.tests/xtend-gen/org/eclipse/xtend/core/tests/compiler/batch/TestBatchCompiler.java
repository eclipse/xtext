/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler.batch;

import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Level;
import org.eclipse.xtend.core.compiler.batch.XtendBatchCompiler;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.logging.LoggingTester;
import org.eclipse.xtext.junit4.smoketest.IgnoredBySmokeTest;
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
public class TestBatchCompiler {
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
  
  private final static Set<File> abfalleimer = CollectionLiterals.<File>newHashSet();
  
  @Before
  public void onSetup() {
    try {
      this.batchCompiler.setSourcePath(TestBatchCompiler.XTEND_SRC_DIRECTORY);
      this.batchCompiler.setOutputPath(TestBatchCompiler.OUTPUT_DIRECTORY);
      this.batchCompiler.setDeleteTempDirectory(true);
      this.batchCompiler.setUseCurrentClassLoaderAsParent(true);
      Class<? extends TestBatchCompiler> _class = this.getClass();
      ClassLoader _classLoader = _class.getClassLoader();
      this.batchCompiler.setCurrentClassLoader(_classLoader);
      File _file = new File(TestBatchCompiler.OUTPUT_DIRECTORY);
      _file.mkdir();
      File _file_1 = new File(TestBatchCompiler.OUTPUT_DIRECTORY);
      Files.cleanFolder(_file_1, null, true, false);
      File _file_2 = new File(TestBatchCompiler.OUTPUT_DIRECTORY_WITH_SPACES);
      _file_2.mkdir();
      File _file_3 = new File(TestBatchCompiler.OUTPUT_DIRECTORY_WITH_SPACES);
      Files.cleanFolder(_file_3, null, true, false);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @After
  public void onTearDown() {
    try {
      File _file = new File(TestBatchCompiler.OUTPUT_DIRECTORY);
      Files.cleanFolder(_file, null, true, true);
      File _file_1 = new File(TestBatchCompiler.OUTPUT_DIRECTORY_WITH_SPACES);
      Files.cleanFolder(_file_1, null, true, true);
      File _file_2 = new File(TestBatchCompiler.TEMP_DIRECTORY);
      boolean _exists = _file_2.exists();
      if (_exists) {
        File _file_3 = new File(TestBatchCompiler.TEMP_DIRECTORY);
        Files.cleanFolder(_file_3, null, true, true);
      }
      File _file_4 = new File(TestBatchCompiler.TEMP_DIRECTORY_WITH_SPACES);
      boolean _exists_1 = _file_4.exists();
      if (_exists_1) {
        File _file_5 = new File(TestBatchCompiler.TEMP_DIRECTORY_WITH_SPACES);
        Files.cleanFolder(_file_5, null, true, true);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @AfterClass
  public static void afterClass() {
    try {
      final Procedure1<File> _function = new Procedure1<File>() {
        @Override
        public void apply(final File it) {
          boolean _exists = it.exists();
          if (_exists) {
            it.delete();
          }
        }
      };
      IterableExtensions.<File>forEach(TestBatchCompiler.abfalleimer, _function);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      TestBatchCompiler.abfalleimer.clear();
    }
  }
  
  @Test
  public void testInvalidConfiguration() {
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        TestBatchCompiler.this.batchCompiler.setSourcePath(TestBatchCompiler.XTEND_SRC_DIRECTORY);
        TestBatchCompiler.this.batchCompiler.setOutputPath((TestBatchCompiler.XTEND_SRC_DIRECTORY + "/xtend-gen"));
        TestBatchCompiler.this.batchCompiler.compile();
      }
    };
    final LoggingTester.LogCapture log = LoggingTester.captureLogging(Level.ERROR, XtendBatchCompiler.class, _function);
    log.assertLogEntry("xtend", "cannot be a child");
  }
  
  @Test
  public void testInvalidConfiguration_2() {
    String _property = System.getProperty("os.name");
    boolean _startsWith = _property.startsWith("Windows");
    if (_startsWith) {
      final Runnable _function = new Runnable() {
        @Override
        public void run() {
          TestBatchCompiler.this.batchCompiler.setSourcePath(TestBatchCompiler.XTEND_SRC_DIRECTORY);
          String _upperCase = TestBatchCompiler.XTEND_SRC_DIRECTORY.toUpperCase();
          String _plus = (_upperCase + "/xtend-gen");
          TestBatchCompiler.this.batchCompiler.setOutputPath(_plus);
          TestBatchCompiler.this.batchCompiler.compile();
        }
      };
      final LoggingTester.LogCapture log = LoggingTester.captureLogging(Level.ERROR, XtendBatchCompiler.class, _function);
      log.assertLogEntry("xtend", "cannot be a child");
    }
  }
  
  @Test
  public void testBug462723() {
    this.batchCompiler.setSourcePath(TestBatchCompiler.XTEND_SRC_DIRECTORY);
    this.batchCompiler.setOutputPath((TestBatchCompiler.XTEND_SRC_DIRECTORY + "-gen"));
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue(_compile);
  }
  
  @Test
  public void testProjectConfig() {
    try {
      this.batchCompiler.compile();
      final FileProjectConfig project = this.batchCompiler.getProjectConfig();
      File _file = new File(".");
      File _canonicalFile = _file.getCanonicalFile();
      final String projectPath = _canonicalFile.getName();
      String _name = project.getName();
      Assert.assertEquals(projectPath, _name);
      final OutputConfiguration output = this.batchCompiler.getOutputConfiguration();
      Set<FileSourceFolder> _sourceFolders = project.getSourceFolders();
      FileSourceFolder _head = IterableExtensions.<FileSourceFolder>head(_sourceFolders);
      final String src = _head.getName();
      String _string = src.toString();
      Assert.assertEquals("batch-compiler-data/test data", _string);
      final String target = output.getOutputDirectory(src);
      String _string_1 = target.toString();
      Assert.assertEquals("test-result", _string_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testprojectConfigMultipleSourceDirs1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ws/prj1/src");
    _builder.append(File.pathSeparator, "");
    _builder.append("ws/prj1/src-gen");
    this.batchCompiler.setSourcePath(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("ws/prj1/bin");
    this.batchCompiler.setOutputPath(_builder_1.toString());
    this.batchCompiler.compile();
    final FileProjectConfig project = this.batchCompiler.getProjectConfig();
    String _name = project.getName();
    Assert.assertEquals("prj1", _name);
    final OutputConfiguration output = this.batchCompiler.getOutputConfiguration();
    Set<FileSourceFolder> _sourceFolders = project.getSourceFolders();
    int _size = _sourceFolders.size();
    Assert.assertEquals(2, _size);
    Set<FileSourceFolder> _sourceFolders_1 = project.getSourceFolders();
    final Function1<FileSourceFolder, String> _function = new Function1<FileSourceFolder, String>() {
      @Override
      public String apply(final FileSourceFolder it) {
        return it.getName();
      }
    };
    Iterable<String> _map = IterableExtensions.<FileSourceFolder, String>map(_sourceFolders_1, _function);
    final List<String> keyPaths = IterableExtensions.<String>sort(_map);
    String _get = keyPaths.get(0);
    final Procedure1<String> _function_1 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        Assert.assertEquals("src", it);
        String _outputDirectory = output.getOutputDirectory(it);
        String _string = _outputDirectory.toString();
        Assert.assertEquals("bin", _string);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(_get, _function_1);
    String _get_1 = keyPaths.get(1);
    final Procedure1<String> _function_2 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        Assert.assertEquals("src-gen", it);
        String _outputDirectory = output.getOutputDirectory(it);
        String _string = _outputDirectory.toString();
        Assert.assertEquals("bin", _string);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(_get_1, _function_2);
  }
  
  @Test
  public void testprojectConfigMultipleSourceDirs2AbsPaths() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/tmp/ws/prj1/src");
    _builder.append(File.pathSeparator, "");
    _builder.append("/tmp/ws/prj1/src-gen");
    this.batchCompiler.setSourcePath(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/tmp/ws/prj1/bin");
    this.batchCompiler.setOutputPath(_builder_1.toString());
    this.batchCompiler.compile();
    final FileProjectConfig project = this.batchCompiler.getProjectConfig();
    String _name = project.getName();
    Assert.assertEquals("prj1", _name);
    final OutputConfiguration output = this.batchCompiler.getOutputConfiguration();
    Set<FileSourceFolder> _sourceFolders = project.getSourceFolders();
    int _size = _sourceFolders.size();
    Assert.assertEquals(2, _size);
    Set<FileSourceFolder> _sourceFolders_1 = project.getSourceFolders();
    final Function1<FileSourceFolder, String> _function = new Function1<FileSourceFolder, String>() {
      @Override
      public String apply(final FileSourceFolder it) {
        return it.getName();
      }
    };
    Iterable<String> _map = IterableExtensions.<FileSourceFolder, String>map(_sourceFolders_1, _function);
    final List<String> keyPaths = IterableExtensions.<String>sort(_map);
    String _get = keyPaths.get(0);
    final Procedure1<String> _function_1 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        Assert.assertEquals("src", it);
        String _outputDirectory = output.getOutputDirectory(it);
        Assert.assertEquals("bin", _outputDirectory);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(_get, _function_1);
    String _get_1 = keyPaths.get(1);
    final Procedure1<String> _function_2 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        Assert.assertEquals("src-gen", it);
        String _outputDirectory = output.getOutputDirectory(it);
        Assert.assertEquals("bin", _outputDirectory);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(_get_1, _function_2);
  }
  
  @Test
  public void testprojectConfigMultipleSourceDirs3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ws/prj1/dir1/src");
    _builder.append(File.pathSeparator, "");
    _builder.append("ws/prj1/src-gen");
    this.batchCompiler.setSourcePath(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("ws/prj1/dir2/bin");
    this.batchCompiler.setOutputPath(_builder_1.toString());
    this.batchCompiler.compile();
    final FileProjectConfig project = this.batchCompiler.getProjectConfig();
    String _name = project.getName();
    Assert.assertEquals("prj1", _name);
    final OutputConfiguration output = this.batchCompiler.getOutputConfiguration();
    Set<FileSourceFolder> _sourceFolders = project.getSourceFolders();
    int _size = _sourceFolders.size();
    Assert.assertEquals(2, _size);
    Set<FileSourceFolder> _sourceFolders_1 = project.getSourceFolders();
    final Function1<FileSourceFolder, String> _function = new Function1<FileSourceFolder, String>() {
      @Override
      public String apply(final FileSourceFolder it) {
        return it.getName();
      }
    };
    Iterable<String> _map = IterableExtensions.<FileSourceFolder, String>map(_sourceFolders_1, _function);
    final List<String> keyPaths = IterableExtensions.<String>sort(_map);
    String _get = keyPaths.get(0);
    final Procedure1<String> _function_1 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        Assert.assertEquals("dir1/src", it);
        String _outputDirectory = output.getOutputDirectory(it);
        Assert.assertEquals("dir2/bin", _outputDirectory);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(_get, _function_1);
    String _get_1 = keyPaths.get(1);
    final Procedure1<String> _function_2 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        Assert.assertEquals("src-gen", it);
        String _outputDirectory = output.getOutputDirectory(it);
        Assert.assertEquals("dir2/bin", _outputDirectory);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(_get_1, _function_2);
  }
  
  @Test
  public void testprojectConfigMultipleSourceDirs4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ws/prj1/src");
    _builder.append(File.pathSeparator, "");
    _builder.append("ws/prj1/dir1/src-gen");
    this.batchCompiler.setSourcePath(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("ws/prj1/bin");
    this.batchCompiler.setOutputPath(_builder_1.toString());
    this.batchCompiler.compile();
    final FileProjectConfig project = this.batchCompiler.getProjectConfig();
    String _name = project.getName();
    Assert.assertEquals("prj1", _name);
    final OutputConfiguration output = this.batchCompiler.getOutputConfiguration();
    Set<FileSourceFolder> _sourceFolders = project.getSourceFolders();
    int _size = _sourceFolders.size();
    Assert.assertEquals(2, _size);
    Set<FileSourceFolder> _sourceFolders_1 = project.getSourceFolders();
    final Function1<FileSourceFolder, String> _function = new Function1<FileSourceFolder, String>() {
      @Override
      public String apply(final FileSourceFolder it) {
        return it.getName();
      }
    };
    Iterable<String> _map = IterableExtensions.<FileSourceFolder, String>map(_sourceFolders_1, _function);
    final List<String> keyPaths = IterableExtensions.<String>sort(_map);
    String _get = keyPaths.get(0);
    final Procedure1<String> _function_1 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        Assert.assertEquals("dir1/src-gen", it);
        String _outputDirectory = output.getOutputDirectory(it);
        Assert.assertEquals("bin", _outputDirectory);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(_get, _function_1);
    String _get_1 = keyPaths.get(1);
    final Procedure1<String> _function_2 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        Assert.assertEquals("src", it);
        String _outputDirectory = output.getOutputDirectory(it);
        Assert.assertEquals("bin", _outputDirectory);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(_get_1, _function_2);
  }
  
  @Test
  public void testprojectConfigMultipleSourceDirs5() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ws/prj1/dir1/dir1a/src");
    _builder.append(File.pathSeparator, "");
    _builder.append("ws/prj1/dir3/dir3a/src-gen");
    this.batchCompiler.setSourcePath(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("ws/prj1/dir2/dir2a/bin");
    this.batchCompiler.setOutputPath(_builder_1.toString());
    this.batchCompiler.compile();
    final FileProjectConfig project = this.batchCompiler.getProjectConfig();
    String _name = project.getName();
    Assert.assertEquals("prj1", _name);
    final OutputConfiguration output = this.batchCompiler.getOutputConfiguration();
    Set<FileSourceFolder> _sourceFolders = project.getSourceFolders();
    int _size = _sourceFolders.size();
    Assert.assertEquals(2, _size);
    Set<FileSourceFolder> _sourceFolders_1 = project.getSourceFolders();
    final Function1<FileSourceFolder, String> _function = new Function1<FileSourceFolder, String>() {
      @Override
      public String apply(final FileSourceFolder it) {
        return it.getName();
      }
    };
    Iterable<String> _map = IterableExtensions.<FileSourceFolder, String>map(_sourceFolders_1, _function);
    final List<String> keyPaths = IterableExtensions.<String>sort(_map);
    String _get = keyPaths.get(0);
    final Procedure1<String> _function_1 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        Assert.assertEquals("dir1/dir1a/src", it);
        String _outputDirectory = output.getOutputDirectory(it);
        Assert.assertEquals("dir2/dir2a/bin", _outputDirectory);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(_get, _function_1);
    String _get_1 = keyPaths.get(1);
    final Procedure1<String> _function_2 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        Assert.assertEquals("dir3/dir3a/src-gen", it);
        String _outputDirectory = output.getOutputDirectory(it);
        Assert.assertEquals("dir2/dir2a/bin", _outputDirectory);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(_get_1, _function_2);
  }
  
  @Test
  public void testprojectConfigMultipleSourceDirs6() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("dir1/ws/prj1/dir2/dir3/dir4/src1");
    _builder.append(File.pathSeparator, "");
    _builder.append("dir1/ws/prj1/dir2/dir3/src2");
    _builder.append(File.pathSeparator, "");
    _builder.append("dir1/ws/prj1/dir2/src3");
    _builder.append(File.pathSeparator, "");
    _builder.append("dir1/ws/prj1/src4");
    this.batchCompiler.setSourcePath(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("dir1/ws/prj1/dir2/dir3/dir4/dir5/bin");
    this.batchCompiler.setOutputPath(_builder_1.toString());
    this.batchCompiler.compile();
    final FileProjectConfig project = this.batchCompiler.getProjectConfig();
    String _name = project.getName();
    Assert.assertEquals("prj1", _name);
    final OutputConfiguration output = this.batchCompiler.getOutputConfiguration();
    Set<FileSourceFolder> _sourceFolders = project.getSourceFolders();
    int _size = _sourceFolders.size();
    Assert.assertEquals(4, _size);
    Set<FileSourceFolder> _sourceFolders_1 = project.getSourceFolders();
    final Function1<FileSourceFolder, String> _function = new Function1<FileSourceFolder, String>() {
      @Override
      public String apply(final FileSourceFolder it) {
        return it.getName();
      }
    };
    Iterable<String> _map = IterableExtensions.<FileSourceFolder, String>map(_sourceFolders_1, _function);
    final List<String> keyPaths = IterableExtensions.<String>sort(_map);
    String _get = keyPaths.get(0);
    final Procedure1<String> _function_1 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        Assert.assertEquals("dir2/dir3/dir4/src1", it);
        String _outputDirectory = output.getOutputDirectory(it);
        Assert.assertEquals("dir2/dir3/dir4/dir5/bin", _outputDirectory);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(_get, _function_1);
    String _get_1 = keyPaths.get(1);
    final Procedure1<String> _function_2 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        Assert.assertEquals("dir2/dir3/src2", it);
        String _outputDirectory = output.getOutputDirectory(it);
        Assert.assertEquals("dir2/dir3/dir4/dir5/bin", _outputDirectory);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(_get_1, _function_2);
    String _get_2 = keyPaths.get(2);
    final Procedure1<String> _function_3 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        Assert.assertEquals("dir2/src3", it);
        String _outputDirectory = output.getOutputDirectory(it);
        Assert.assertEquals("dir2/dir3/dir4/dir5/bin", _outputDirectory);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(_get_2, _function_3);
    String _get_3 = keyPaths.get(3);
    final Procedure1<String> _function_4 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        Assert.assertEquals("src4", it);
        String _outputDirectory = output.getOutputDirectory(it);
        Assert.assertEquals("dir2/dir3/dir4/dir5/bin", _outputDirectory);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(_get_3, _function_4);
  }
  
  @Test
  public void testprojectConfigSameDir() {
    this.batchCompiler.setSourcePath("ws/prj1");
    this.batchCompiler.setOutputPath("ws/prj1");
    boolean _compile = this.batchCompiler.compile();
    Assert.assertFalse(_compile);
    FileProjectConfig _projectConfig = this.batchCompiler.getProjectConfig();
    Assert.assertNull(_projectConfig);
  }
  
  @Test
  public void testprojectConfigWithoutCommonProjectDir() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/tmp/ws/prj1/src");
    this.batchCompiler.setSourcePath(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/usr/local/tmp/ws/prj1/bin");
    this.batchCompiler.setOutputPath(_builder_1.toString());
    this.batchCompiler.compile();
    FileProjectConfig _projectConfig = this.batchCompiler.getProjectConfig();
    Assert.assertNull(_projectConfig);
    OutputConfiguration _outputConfiguration = this.batchCompiler.getOutputConfiguration();
    Assert.assertNull(_outputConfiguration);
  }
  
  @Test
  public void testprojectConfigWithoutCommonWorkspaceDir() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/some_non_existing_folder/src");
    this.batchCompiler.setSourcePath(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/some_non_existing_folder/bin");
    this.batchCompiler.setOutputPath(_builder_1.toString());
    this.batchCompiler.compile();
    FileProjectConfig _projectConfig = this.batchCompiler.getProjectConfig();
    Assert.assertNull(_projectConfig);
    OutputConfiguration _outputConfiguration = this.batchCompiler.getOutputConfiguration();
    Assert.assertNull(_outputConfiguration);
  }
  
  @Test
  public void testprojectConfigWithTopLevelCommonWorkspaceDir() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/tmp/prj/src");
    this.batchCompiler.setSourcePath(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/tmp/prj/bin");
    this.batchCompiler.setOutputPath(_builder_1.toString());
    this.batchCompiler.compile();
    FileProjectConfig _projectConfig = this.batchCompiler.getProjectConfig();
    Assert.assertNotNull(_projectConfig);
    OutputConfiguration _outputConfiguration = this.batchCompiler.getOutputConfiguration();
    Assert.assertNotNull(_outputConfiguration);
  }
  
  @Test
  public void bug368551() {
    this.batchCompiler.setTempDirectory(TestBatchCompiler.TEMP_DIRECTORY_WITH_SPACES);
    this.batchCompiler.setSourcePath(TestBatchCompiler.XTEND_SRC_DIRECTORY);
    this.batchCompiler.setOutputPath(TestBatchCompiler.OUTPUT_DIRECTORY_WITH_SPACES);
    this.batchCompiler.compile();
    File _file = new File((TestBatchCompiler.OUTPUT_DIRECTORY_WITH_SPACES + "/test"));
    String[] _list = _file.list();
    int _size = ((List<String>)Conversions.doWrapArray(_list)).size();
    Assert.assertEquals(14, _size);
  }
  
  @Test
  public void bug387829() {
    this.batchCompiler.setTempDirectory(TestBatchCompiler.TEMP_DIRECTORY_WITH_SPACES);
    this.batchCompiler.setSourcePath(TestBatchCompiler.XTEND_SRC_DIRECTORY);
    this.batchCompiler.setOutputPath(TestBatchCompiler.OUTPUT_DIRECTORY_WITH_SPACES);
    this.batchCompiler.setClassPath(TestBatchCompiler.XTEND_SRC_DIRECTORY);
    this.batchCompiler.compile();
    final File compilerOutputDir = new File((TestBatchCompiler.OUTPUT_DIRECTORY_WITH_SPACES + "/test"));
    boolean _exists = compilerOutputDir.exists();
    Assert.assertTrue("Compiler output exists", _exists);
    String[] _list = compilerOutputDir.list();
    int _size = ((List<String>)Conversions.doWrapArray(_list)).size();
    Assert.assertEquals(14, _size);
  }
  
  @Test
  public void bug396747() {
    this.batchCompiler.setSourcePath(TestBatchCompiler.BUG396747_SRC_DIRECTORY);
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue("Compiling empty file pass", _compile);
  }
  
  @Test
  public void bug410594() {
    this.batchCompiler.setSourcePath(TestBatchCompiler.BUG410594_SRC_DIRECTORY);
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue("Compiling empty file pass", _compile);
  }
  
  @Test
  @Ignore
  public void bug416262() {
    this.batchCompiler.setSourcePath(TestBatchCompiler.BUG416262_SRC_DIRECTORY);
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue("Compiling funny file pass", _compile);
  }
  
  @Test
  public void bug417177() {
    final File outputDir = new File(TestBatchCompiler.BUG417177_OUTPUT_DIRECTORY);
    outputDir.mkdirs();
    File _file = new File(outputDir, "mypackage/Bug417177_1.java");
    _file.delete();
    File _file_1 = new File(outputDir, "mypackage/Bug417177_2.java");
    _file_1.delete();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(TestBatchCompiler.BUG417177_SRC_DIRECTORY_1, "");
    _builder.append(File.pathSeparator, "");
    _builder.append(TestBatchCompiler.BUG417177_SRC_DIRECTORY_2, "");
    this.batchCompiler.setSourcePath(_builder.toString());
    this.batchCompiler.setOutputPath(TestBatchCompiler.BUG417177_OUTPUT_DIRECTORY);
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue("Compiling files from multiple source directories", _compile);
    File _file_2 = new File(outputDir, "mypackage/Bug417177_1.java");
    boolean _exists = _file_2.exists();
    Assert.assertTrue(_exists);
    File _file_3 = new File(outputDir, "mypackage/Bug417177_2.java");
    boolean _exists_1 = _file_3.exists();
    Assert.assertTrue(_exists_1);
  }
  
  @Test
  public void testActiveAnnotatons1() {
    this.batchCompiler.setSourcePath("./batch-compiler-data/activeAnnotations1");
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        boolean _compile = TestBatchCompiler.this.batchCompiler.compile();
        Assert.assertFalse(_compile);
      }
    };
    final LoggingTester.LogCapture logs = LoggingTester.captureLogging(Level.ERROR, XtendBatchCompiler.class, _function);
    logs.assertNumberOfLogEntries(1);
  }
  
  @Test
  public void testActiveAnnotatons2() {
    this.batchCompiler.setSourcePath("./batch-compiler-data/activeAnnotations2");
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue(_compile);
    File _file = new File((TestBatchCompiler.OUTPUT_DIRECTORY + "/mypackage"));
    final FilenameFilter _function = new FilenameFilter() {
      @Override
      public boolean accept(final File dir, final String name) {
        return name.endsWith(".java");
      }
    };
    String[] _list = _file.list(_function);
    final String javaFiles = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_list)), ",");
    Assert.assertEquals("Client.java", javaFiles);
    final File txtFile = new File((TestBatchCompiler.OUTPUT_DIRECTORY + "/Test.txt"));
    boolean _exists = txtFile.exists();
    Assert.assertTrue(_exists);
  }
  
  @Test
  public void testBug443800() {
    this.batchCompiler.setSourcePath("./batch-compiler-data/bug443800");
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue(_compile);
    File _file = new File((TestBatchCompiler.OUTPUT_DIRECTORY + "/"));
    final FilenameFilter _function = new FilenameFilter() {
      @Override
      public boolean accept(final File dir, final String name) {
        return name.endsWith(".java");
      }
    };
    String[] _list = _file.list(_function);
    final String javaFiles = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_list)), ",");
    Assert.assertEquals("Bug443800.java", javaFiles);
  }
  
  @Test
  public void testClassPath() {
    this.batchCompiler.setSourcePath("./batch-compiler-data/classpathTest/src");
    this.batchCompiler.setClassPath("./batch-compiler-data/classpathTest/dependency");
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue("Compiling with correct dependency resolution", _compile);
  }
  
  @Test
  public void testCompileTestDataWithTrace() {
    this.batchCompiler.setWriteTraceFiles(true);
    this.batchCompiler.compile();
    File _file = new File((TestBatchCompiler.OUTPUT_DIRECTORY + "/test"));
    final FilenameFilter _function = new FilenameFilter() {
      @Override
      public boolean accept(final File dir, final String name) {
        return name.endsWith(".java");
      }
    };
    String[] _list = _file.list(_function);
    int _size = ((List<String>)Conversions.doWrapArray(_list)).size();
    Assert.assertEquals(7, _size);
    File _file_1 = new File((TestBatchCompiler.OUTPUT_DIRECTORY + "/test"));
    final FilenameFilter _function_1 = new FilenameFilter() {
      @Override
      public boolean accept(final File dir, final String name) {
        return name.endsWith("._trace");
      }
    };
    String[] _list_1 = _file_1.list(_function_1);
    int _size_1 = ((List<String>)Conversions.doWrapArray(_list_1)).size();
    Assert.assertEquals(7, _size_1);
  }
  
  @Test
  public void testCompileTestDataWithoutTrace() {
    this.batchCompiler.setWriteTraceFiles(false);
    this.batchCompiler.compile();
    File _file = new File((TestBatchCompiler.OUTPUT_DIRECTORY + "/test"));
    final FilenameFilter _function = new FilenameFilter() {
      @Override
      public boolean accept(final File dir, final String name) {
        return name.endsWith(".java");
      }
    };
    String[] _list = _file.list(_function);
    int _size = ((List<String>)Conversions.doWrapArray(_list)).size();
    Assert.assertEquals(7, _size);
    File _file_1 = new File((TestBatchCompiler.OUTPUT_DIRECTORY + "/test"));
    final FilenameFilter _function_1 = new FilenameFilter() {
      @Override
      public boolean accept(final File dir, final String name) {
        return name.endsWith("._trace");
      }
    };
    String[] _list_1 = _file_1.list(_function_1);
    int _size_1 = ((List<String>)Conversions.doWrapArray(_list_1)).size();
    Assert.assertEquals(0, _size_1);
  }
  
  @Test
  public void testCompileTestDataWithStorage() {
    this.batchCompiler.setWriteStorageFiles(true);
    this.batchCompiler.compile();
    File _file = new File((TestBatchCompiler.OUTPUT_DIRECTORY + "/test"));
    final FilenameFilter _function = new FilenameFilter() {
      @Override
      public boolean accept(final File dir, final String name) {
        return name.endsWith(".java");
      }
    };
    String[] _list = _file.list(_function);
    int _size = ((List<String>)Conversions.doWrapArray(_list)).size();
    Assert.assertEquals(7, _size);
    File _file_1 = new File((TestBatchCompiler.OUTPUT_DIRECTORY + "/test"));
    final FilenameFilter _function_1 = new FilenameFilter() {
      @Override
      public boolean accept(final File dir, final String name) {
        return name.endsWith(".xtendbin");
      }
    };
    String[] _list_1 = _file_1.list(_function_1);
    int _size_1 = ((List<String>)Conversions.doWrapArray(_list_1)).size();
    Assert.assertEquals(5, _size_1);
  }
  
  @Test
  public void testCompileTestDataWithoutStorage() {
    this.batchCompiler.setWriteStorageFiles(false);
    this.batchCompiler.compile();
    File _file = new File((TestBatchCompiler.OUTPUT_DIRECTORY + "/test"));
    final FilenameFilter _function = new FilenameFilter() {
      @Override
      public boolean accept(final File dir, final String name) {
        return name.endsWith(".java");
      }
    };
    String[] _list = _file.list(_function);
    int _size = ((List<String>)Conversions.doWrapArray(_list)).size();
    Assert.assertEquals(7, _size);
    File _file_1 = new File((TestBatchCompiler.OUTPUT_DIRECTORY + "/test"));
    final FilenameFilter _function_1 = new FilenameFilter() {
      @Override
      public boolean accept(final File dir, final String name) {
        return name.endsWith(".xtendbin");
      }
    };
    String[] _list_1 = _file_1.list(_function_1);
    int _size_1 = ((List<String>)Conversions.doWrapArray(_list_1)).size();
    Assert.assertEquals(0, _size_1);
  }
  
  @Test
  public void testCompileSymlinkedResource() {
    File _file = new File("./batch-compiler-data/test-resources/");
    URI _uRI = _file.toURI();
    URI _normalize = _uRI.normalize();
    final String tstResources = _normalize.getPath();
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
    File _file_1 = new File(wsRootFile, "plain-folder/linked-src/");
    boolean _isSymlink = this.isSymlink(_file_1);
    Assert.assertTrue("plain-folder/linked-src/ is a symlink", _isSymlink);
    File _file_2 = new File(wsRootFile, "plain-folder/src/");
    boolean _isSymlink_1 = this.isSymlink(_file_2);
    boolean _not_1 = (!_isSymlink_1);
    Assert.assertTrue("plain-folder/src/ is not a symlink", _not_1);
    this.batchCompiler.setWriteTraceFiles(true);
    this.batchCompiler.setSourcePath(((((wsRootPath + "/plain-folder/src") + File.pathSeparator) + wsRootPath) + 
      "/plain-folder/linked-src"));
    final String customOutput = (wsRootPath + "/plain-folder/target");
    this.batchCompiler.setOutputPath(customOutput);
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue(_compile);
    File _file_3 = new File((wsRootPath + "/plain-folder/target/Test.txt"));
    boolean _exists = _file_3.exists();
    Assert.assertTrue(_exists);
    File _file_4 = new File(customOutput);
    final FilenameFilter _function = new FilenameFilter() {
      @Override
      public boolean accept(final File dir, final String name) {
        return name.endsWith(".java");
      }
    };
    String[] _list = _file_4.list(_function);
    int _size = ((List<String>)Conversions.doWrapArray(_list)).size();
    Assert.assertEquals(2, _size);
    File _file_5 = new File(customOutput);
    final FilenameFilter _function_1 = new FilenameFilter() {
      @Override
      public boolean accept(final File dir, final String name) {
        return name.endsWith("._trace");
      }
    };
    String[] _list_1 = _file_5.list(_function_1);
    int _size_1 = ((List<String>)Conversions.doWrapArray(_list_1)).size();
    Assert.assertEquals(2, _size_1);
  }
  
  private boolean createSymLink(final String linkTarget, final String link) {
    try {
      File linkFile = new File(link);
      TestBatchCompiler.abfalleimer.add(linkFile);
      boolean _and = false;
      boolean _exists = linkFile.exists();
      if (!_exists) {
        _and = false;
      } else {
        boolean _isSymlink = this.isSymlink(linkFile);
        _and = _isSymlink;
      }
      if (_and) {
        return true;
      }
      String[] cmd = { "ln", "-s", linkTarget, link };
      try {
        final String[] _converted_cmd = (String[])cmd;
        String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_converted_cmd)), " ");
        String _plus = ("Exec: " + _join);
        InputOutput.<String>println(_plus);
        Runtime _runtime = Runtime.getRuntime();
        final Process proc = _runtime.exec(cmd);
        int _waitFor = proc.waitFor();
        return (_waitFor == 0);
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          final IOException ioe = (IOException)_t;
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
      boolean _equals = Objects.equal(_parent, null);
      if (_equals) {
        canon = file;
      } else {
        File _parentFile = file.getParentFile();
        File canonDir = _parentFile.getCanonicalFile();
        String _name = file.getName();
        File _file = new File(canonDir, _name);
        canon = _file;
      }
      File _canonicalFile = canon.getCanonicalFile();
      File _absoluteFile = canon.getAbsoluteFile();
      boolean _equals_1 = _canonicalFile.equals(_absoluteFile);
      return (!_equals_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private String getContents(final String fileName) {
    try {
      File _file = new File(fileName);
      return com.google.common.io.Files.toString(_file, Charsets.UTF_8);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void tempDirectory() {
    this.batchCompiler.setDeleteTempDirectory(false);
    this.batchCompiler.setTempDirectory(TestBatchCompiler.TEMP_DIRECTORY);
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue(_compile);
    String _tempDirectory = this.batchCompiler.getTempDirectory();
    File _file = new File(_tempDirectory);
    String[] _list = _file.list();
    int _size = ((List<String>)Conversions.doWrapArray(_list)).size();
    Assert.assertEquals(2, _size);
    boolean _compile_1 = this.batchCompiler.compile();
    Assert.assertTrue(_compile_1);
    String _tempDirectory_1 = this.batchCompiler.getTempDirectory();
    File _file_1 = new File(_tempDirectory_1);
    String[] _list_1 = _file_1.list();
    int _size_1 = ((List<String>)Conversions.doWrapArray(_list_1)).size();
    Assert.assertEquals(4, _size_1);
  }
  
  @Test
  public void deleteTempDirectory() {
    this.batchCompiler.setDeleteTempDirectory(true);
    this.batchCompiler.setTempDirectory(TestBatchCompiler.TEMP_DIRECTORY);
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue(_compile);
    File _file = new File(TestBatchCompiler.TEMP_DIRECTORY);
    String[] _list = _file.list();
    int _size = ((List<String>)Conversions.doWrapArray(_list)).size();
    Assert.assertEquals(0, _size);
  }
  
  @Test
  public void testNoSuppressWarningsAnnotations() {
    this.batchCompiler.setGenerateSyntheticSuppressWarnings(false);
    this.batchCompiler.setSourcePath("./batch-compiler-data/xtendClass");
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue(_compile);
    String _contents = this.getContents((TestBatchCompiler.OUTPUT_DIRECTORY + "/XtendA.java"));
    boolean _contains = _contents.contains("@SuppressWarnings");
    Assert.assertFalse(_contains);
  }
  
  @Test
  public void testGeneratedAnnotation() {
    this.batchCompiler.setGenerateGeneratedAnnotation(true);
    this.batchCompiler.setSourcePath("./batch-compiler-data/xtendClass");
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue(_compile);
    String _contents = this.getContents((TestBatchCompiler.OUTPUT_DIRECTORY + "/XtendA.java"));
    boolean _contains = _contents.contains("@Generated");
    Assert.assertTrue(_contains);
  }
  
  @Test
  public void testGeneratedAnnotationComment() {
    this.batchCompiler.setGenerateGeneratedAnnotation(true);
    this.batchCompiler.setGeneratedAnnotationComment("FooComment");
    this.batchCompiler.setSourcePath("./batch-compiler-data/xtendClass");
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue(_compile);
    final String generated = this.getContents((TestBatchCompiler.OUTPUT_DIRECTORY + "/XtendA.java"));
    boolean _contains = generated.contains("@Generated");
    Assert.assertTrue(_contains);
    boolean _contains_1 = generated.contains("FooComment");
    Assert.assertTrue(_contains_1);
  }
  
  @Test
  public void testGeneratedAnnotationDate1() {
    this.batchCompiler.setGenerateGeneratedAnnotation(true);
    this.batchCompiler.setIncludeDateInGeneratedAnnotation(true);
    this.batchCompiler.setSourcePath("./batch-compiler-data/xtendClass");
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue(_compile);
    final String generated = this.getContents((TestBatchCompiler.OUTPUT_DIRECTORY + "/XtendA.java"));
    boolean _contains = generated.contains("@Generated");
    Assert.assertTrue(_contains);
    boolean _contains_1 = generated.contains("date =");
    Assert.assertTrue(_contains_1);
  }
  
  @Test
  public void testJavaVersion5() {
    this.batchCompiler.setJavaSourceVersion("1.5");
    this.batchCompiler.setSourcePath("./batch-compiler-data/javaVersion");
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue(_compile);
    final String generated = this.getContents((TestBatchCompiler.OUTPUT_DIRECTORY + "/XtendA.java"));
    boolean _contains = generated.contains("@Override");
    Assert.assertFalse(_contains);
    boolean _contains_1 = generated.contains("new Function1<Integer, String>");
    Assert.assertTrue(_contains_1);
  }
  
  @Test
  public void testJavaVersion6() {
    this.batchCompiler.setJavaSourceVersion("1.6");
    this.batchCompiler.setSourcePath("./batch-compiler-data/javaVersion");
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue(_compile);
    final String generated = this.getContents((TestBatchCompiler.OUTPUT_DIRECTORY + "/XtendA.java"));
    boolean _contains = generated.contains("@Override");
    Assert.assertTrue(_contains);
    boolean _contains_1 = generated.contains("new Function1<Integer, String>");
    Assert.assertTrue(_contains_1);
  }
  
  @Test
  public void testJavaVersion7() {
    this.batchCompiler.setJavaSourceVersion("1.7");
    this.batchCompiler.setSourcePath("./batch-compiler-data/javaVersion");
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue(_compile);
    final String generated = this.getContents((TestBatchCompiler.OUTPUT_DIRECTORY + "/XtendA.java"));
    boolean _contains = generated.contains("@Override");
    Assert.assertTrue(_contains);
    boolean _contains_1 = generated.contains("new Function1<Integer, String>");
    Assert.assertTrue(_contains_1);
  }
  
  @Test
  public void testJavaVersion8() {
    this.batchCompiler.setJavaSourceVersion("1.8");
    this.batchCompiler.setSourcePath("./batch-compiler-data/javaVersion");
    boolean _compile = this.batchCompiler.compile();
    Assert.assertTrue(_compile);
    final String generated = this.getContents((TestBatchCompiler.OUTPUT_DIRECTORY + "/XtendA.java"));
    boolean _contains = generated.contains("@Override");
    Assert.assertTrue(_contains);
    boolean _contains_1 = generated.contains("(Integer it) ->");
    Assert.assertTrue(_contains_1);
  }
}
