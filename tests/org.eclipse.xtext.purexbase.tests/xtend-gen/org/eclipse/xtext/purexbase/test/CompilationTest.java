package org.eclipse.xtext.purexbase.test;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.purexbase.PureXbaseInjectorProvider;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = PureXbaseInjectorProvider.class)
@SuppressWarnings("all")
public class CompilationTest {
  @Inject
  private CompilationTestHelper _compilationTestHelper;
  
  @Test
  public void simpleCompile() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\'foo\'.length()");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
  }
}
