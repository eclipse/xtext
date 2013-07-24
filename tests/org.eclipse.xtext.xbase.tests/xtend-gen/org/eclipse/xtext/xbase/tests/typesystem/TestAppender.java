package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.xbase.compiler.SourceAppenderBase;

@SuppressWarnings("all")
public class TestAppender extends SourceAppenderBase {
  private JvmDeclaredType dummy;
  
  protected JvmDeclaredType getImportedType(final String simpleName) {
    return this.dummy;
  }
  
  public TestAppender(final int baseIndentationLevel, final String indentation, final String lineSeparator, final boolean isJava, final JvmDeclaredType dummy) {
    super(baseIndentationLevel, indentation, lineSeparator, isJava);
    this.dummy = dummy;
  }
}
