package org.eclipse.xtext.xbase.tests.lib.internal;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.eclipse.xtext.xbase.tests.lib.internal.DataClass;
import org.eclipse.xtext.xbase.tests.lib.internal.MyEntity;
import org.eclipse.xtext.xbase.tests.lib.internal.OtherClass;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ToStringHelperTest {
  @Test
  public void testToString() {
    final ToStringHelper helper = new ToStringHelper();
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
    _builder.append("  ");
    _builder.append("CLASS");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("policy = CLASS");
    _builder.newLine();
    _builder.append("]");
    String _string = _builder.toString();
    MyEntity _myEntity = new MyEntity();
    MyEntity _myEntity_1 = new MyEntity(_myEntity);
    String _string_1 = helper.toString(_myEntity_1);
    Assert.assertEquals(_string, _string_1);
  }
  
  @Test
  public void recursionHandling() {
    final ToStringHelper helper = new ToStringHelper();
    final OtherClass obj = new OtherClass();
    obj.name = "foo";
    obj.other = obj;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("OtherClass [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("other = ");
    String _string = obj.toString();
    _builder.append(_string, "  ");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("name = \"foo\"");
    _builder.newLine();
    _builder.append("]");
    String _string_1 = _builder.toString();
    String _string_2 = helper.toString(obj);
    Assert.assertEquals(_string_1, _string_2);
  }
  
  @Test
  public void recursionHandling_02() {
    final ToStringHelper helper = new ToStringHelper();
    final Wrapper<DataClass> ref = new Wrapper<DataClass>();
    final DataClass obj = new DataClass(ref, "test");
    ref.set(obj);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("DataClass [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("_other = Wrapper of (DataClass@");
    int _identityHashCode = System.identityHashCode(obj);
    _builder.append(_identityHashCode, "  ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("_name = \"test\"");
    _builder.newLine();
    _builder.append("]");
    String _string = _builder.toString();
    String _string_1 = helper.toString(obj);
    Assert.assertEquals(_string, _string_1);
  }
}
