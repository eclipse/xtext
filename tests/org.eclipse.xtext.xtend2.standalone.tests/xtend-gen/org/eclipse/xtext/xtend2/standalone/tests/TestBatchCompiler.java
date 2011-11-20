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
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(XtendInjectorProvider.class)
public class TestBatchCompiler {
  @Inject
  private Xtend2BatchCompiler batchCompiler;
  
  @Test
  public void testCompileTestData() {
    try {
      {
        final String out = "./test-result";
        final String src = "./testdata";
        this.batchCompiler.setSourcePath(src);
        this.batchCompiler.setOutputPath(out);
        File _file = new File(out);
        _file.mkdir();
        File _file_1 = new File(out);
        Files.cleanFolder(_file_1, null, true, false);
        this.batchCompiler.compile();
        String _operator_plus = StringExtensions.operator_plus(out, "/test");
        File _file_2 = new File(_operator_plus);
        String[] _list = _file_2.list();
        int _size = ((List<String>)Conversions.doWrapArray(_list)).size();
        Assert.assertEquals(2, _size);
        File _file_3 = new File(out);
        Files.cleanFolder(_file_3, null, true, true);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
