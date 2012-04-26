package org.eclipse.xtext.xbase.tests.lib.internal;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.internal.ToStringHelper;
import org.eclipse.xtext.xbase.tests.lib.internal.MyEntity;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ToStringHelperTest {
  @Test
  public void testToString() {
    ToStringHelper _toStringHelper = new ToStringHelper();
    final ToStringHelper helper = _toStringHelper;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MyEntity [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolProp = true");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("intProp = 42");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("myList = ArrayList (");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"foo\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"bar\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"baz\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(")");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("friend = true");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("42");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("[foo, bar, baz]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("null");
    _builder.newLine();
    _builder.append("]");
    String _string = _builder.toString();
    MyEntity _myEntity = new MyEntity();
    MyEntity _myEntity_1 = new MyEntity(_myEntity);
    String _string_1 = helper.toString(_myEntity_1);
    Assert.assertEquals(_string, _string_1);
  }
}
