package org.eclipse.xtend.core.tests.macro;

import java.lang.reflect.Constructor;
import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend.core.tests.macro.AbstractActiveAnnotationTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class ImmutableAnnotationTest extends AbstractActiveAnnotationTest {
  @Ignore("We need to suppress the initialization check.")
  @Test
  public void defSimpleTest() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.core.tests.macro.Immutable");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Immutable class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<XtendCompilerTester.CompilationResult> _function = new IAcceptor<XtendCompilerTester.CompilationResult>() {
      public void accept(final XtendCompilerTester.CompilationResult it) {
        final Class<? extends Object> clazz = it.getCompiledClass();
        final Constructor<? extends Object>[] constr = clazz.getDeclaredConstructors();
        int _length = constr.length;
        Assert.assertEquals(1, _length);
        Constructor<? extends Object> _head = IterableExtensions.<Constructor<? extends Object>>head(((Iterable<Constructor<? extends Object>>)Conversions.doWrapArray(constr)));
        Class<? extends Object>[] _parameterTypes = _head.getParameterTypes();
        int _length_1 = _parameterTypes.length;
        Assert.assertEquals(1, _length_1);
      }
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }
}
