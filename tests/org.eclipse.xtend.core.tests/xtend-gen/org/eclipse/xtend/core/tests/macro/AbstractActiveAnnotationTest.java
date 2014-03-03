package org.eclipse.xtend.core.tests.macro;

import com.google.inject.Inject;
import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public abstract class AbstractActiveAnnotationTest extends AbstractXtendTestCase {
  @Extension
  protected XtendCompilerTester _xtendCompilerTester;
  
  @Inject
  public XtendCompilerTester doInject(final XtendCompilerTester compilerTester, final ProcessorInstanceForJvmTypeProvider processorProvider) {
    XtendCompilerTester _xblockexpression = null;
    {
      Class<? extends AbstractActiveAnnotationTest> _class = this.getClass();
      ClassLoader _classLoader = _class.getClassLoader();
      processorProvider.setClassLoader(_classLoader);
      _xblockexpression = (this._xtendCompilerTester = compilerTester);
    }
    return _xblockexpression;
  }
}
