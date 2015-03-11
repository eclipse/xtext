package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.List;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.compiler.AbstractStringBuilderBasedAppendable;

@SuppressWarnings("all")
public class TestAppender extends AbstractStringBuilderBasedAppendable {
  public TestAppender(final boolean isJava) {
    super("\t", "\n", isJava);
  }
  
  @Override
  protected void appendType(final JvmType type, final StringBuilder builder) {
    String _identifier = type.getIdentifier();
    builder.append(_identifier);
  }
  
  @Override
  protected void appendType(final Class<?> type, final StringBuilder builder) {
    String _name = type.getName();
    builder.append(_name);
  }
  
  @Override
  public List<String> getImports() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
