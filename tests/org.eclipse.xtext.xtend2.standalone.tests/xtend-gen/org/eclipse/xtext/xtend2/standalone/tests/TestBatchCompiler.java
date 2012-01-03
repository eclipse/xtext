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
        Xtend2BatchCompiler _batchCompiler = this.batchCompiler;
        String _XTEND_SRC_DIRECTORY = TestBatchCompiler.XTEND_SRC_DIRECTORY;
        _batchCompiler.setSourcePath(_XTEND_SRC_DIRECTORY);
        Xtend2BatchCompiler _batchCompiler_1 = this.batchCompiler;
        String _OUTPUT_DIRECTORY = TestBatchCompiler.OUTPUT_DIRECTORY;
        _batchCompiler_1.setOutputPath(_OUTPUT_DIRECTORY);
        Xtend2BatchCompiler _batchCompiler_2 = this.batchCompiler;
        _batchCompiler_2.setDeleteTempDirectory(true);
        String _OUTPUT_DIRECTORY_1 = TestBatchCompiler.OUTPUT_DIRECTORY;
        File _file = new File(_OUTPUT_DIRECTORY_1);
        _file.mkdir();
        String _OUTPUT_DIRECTORY_2 = TestBatchCompiler.OUTPUT_DIRECTORY;
        File _file_1 = new File(_OUTPUT_DIRECTORY_2);
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
        String _OUTPUT_DIRECTORY = TestBatchCompiler.OUTPUT_DIRECTORY;
        File _file = new File(_OUTPUT_DIRECTORY);
        Files.cleanFolder(_file, null, true, true);
        String _TEMP_DIRECTORY = TestBatchCompiler.TEMP_DIRECTORY;
        File _file_1 = new File(_TEMP_DIRECTORY);
        boolean _exists = _file_1.exists();
        if (_exists) {
          String _TEMP_DIRECTORY_1 = TestBatchCompiler.TEMP_DIRECTORY;
          File _file_2 = new File(_TEMP_DIRECTORY_1);
          Files.cleanFolder(_file_2, null, true, true);
        }
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCompileTestData() {
      Xtend2BatchCompiler _batchCompiler = this.batchCompiler;
      _batchCompiler.compile();
      String _OUTPUT_DIRECTORY = TestBatchCompiler.OUTPUT_DIRECTORY;
      String _operator_plus = StringExtensions.operator_plus(_OUTPUT_DIRECTORY, "/test");
      File _file = new File(_operator_plus);
      String[] _list = _file.list();
      int _size = ((List<String>)Conversions.doWrapArray(_list)).size();
      Assert.assertEquals(2, _size);
  }
  
  @Test
  public void tempDirectory() {
      Xtend2BatchCompiler _batchCompiler = this.batchCompiler;
      _batchCompiler.setDeleteTempDirectory(false);
      Xtend2BatchCompiler _batchCompiler_1 = this.batchCompiler;
      String _TEMP_DIRECTORY = TestBatchCompiler.TEMP_DIRECTORY;
      _batchCompiler_1.setTempDirectory(_TEMP_DIRECTORY);
      Xtend2BatchCompiler _batchCompiler_2 = this.batchCompiler;
      boolean _compile = _batchCompiler_2.compile();
      Assert.assertTrue(_compile);
      Xtend2BatchCompiler _batchCompiler_3 = this.batchCompiler;
      String _tempDirectory = _batchCompiler_3.getTempDirectory();
      File _file = new File(_tempDirectory);
      String[] _list = _file.list();
      int _size = ((List<String>)Conversions.doWrapArray(_list)).size();
      Assert.assertEquals(2, _size);
      Xtend2BatchCompiler _batchCompiler_4 = this.batchCompiler;
      boolean _compile_1 = _batchCompiler_4.compile();
      Assert.assertTrue(_compile_1);
      Xtend2BatchCompiler _batchCompiler_5 = this.batchCompiler;
      String _tempDirectory_1 = _batchCompiler_5.getTempDirectory();
      File _file_1 = new File(_tempDirectory_1);
      String[] _list_1 = _file_1.list();
      int _size_1 = ((List<String>)Conversions.doWrapArray(_list_1)).size();
      Assert.assertEquals(4, _size_1);
  }
  
  @Test
  public void deleteTempDirectory() {
      Xtend2BatchCompiler _batchCompiler = this.batchCompiler;
      _batchCompiler.setDeleteTempDirectory(true);
      Xtend2BatchCompiler _batchCompiler_1 = this.batchCompiler;
      String _TEMP_DIRECTORY = TestBatchCompiler.TEMP_DIRECTORY;
      _batchCompiler_1.setTempDirectory(_TEMP_DIRECTORY);
      Xtend2BatchCompiler _batchCompiler_2 = this.batchCompiler;
      boolean _compile = _batchCompiler_2.compile();
      Assert.assertTrue(_compile);
      String _TEMP_DIRECTORY_1 = TestBatchCompiler.TEMP_DIRECTORY;
      File _file = new File(_TEMP_DIRECTORY_1);
      String[] _list = _file.list();
      int _size = ((List<String>)Conversions.doWrapArray(_list)).size();
      Assert.assertEquals(0, _size);
  }
}
