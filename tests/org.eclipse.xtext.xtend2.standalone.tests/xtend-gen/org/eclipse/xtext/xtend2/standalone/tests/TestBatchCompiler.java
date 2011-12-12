package org.eclipse.xtext.xtend2.standalone.tests;

import com.google.inject.Inject;
import java.io.File;
import java.util.List;
import junit.framework.Assert;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.compiler.batch.Xtend2BatchCompiler;
import org.eclipse.xtext.xtend2.standalone.tests.XtendInjectorProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(XtendInjectorProvider.class)
public class TestBatchCompiler {
  @Inject
  private Xtend2BatchCompiler batchCompiler;
  
  private static String OUTPUT_DIRECTORY = "./test-result";
  
  private static String TEMP_DIRECTORY = "./test-temp-dir";
  
  private static String XTEND_SRC_DIRECTORY = "./testdata";
  
  @Before
  public void onSetup() {
    try {
      {
        this.batchCompiler.setSourcePath(TestBatchCompiler.XTEND_SRC_DIRECTORY);
        this.batchCompiler.setOutputPath(TestBatchCompiler.OUTPUT_DIRECTORY);
        this.batchCompiler.setDeleteTempDirectory(true);
        File _file = new File(TestBatchCompiler.OUTPUT_DIRECTORY);
        _file.mkdir();
        File _file_1 = new File(TestBatchCompiler.OUTPUT_DIRECTORY);
        Files.cleanFolder(_file_1, null, true, false);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @After
  public void onTearDown() {
    try {
      {
        File _file = new File(TestBatchCompiler.OUTPUT_DIRECTORY);
        Files.cleanFolder(_file, null, true, true);
        File _file_1 = new File(TestBatchCompiler.TEMP_DIRECTORY);
        boolean _exists = _file_1.exists();
        if (_exists) {
          File _file_2 = new File(TestBatchCompiler.TEMP_DIRECTORY);
          Files.cleanFolder(_file_2, null, true, true);
        }
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCompileTestData() {
      this.batchCompiler.compile();
      String _operator_plus = StringExtensions.operator_plus(TestBatchCompiler.OUTPUT_DIRECTORY, "/test");
      File _file = new File(_operator_plus);
      String[] _list = _file.list();
      int _size = ((List<String>)Conversions.doWrapArray(_list)).size();
      Assert.assertEquals(2, _size);
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
}
