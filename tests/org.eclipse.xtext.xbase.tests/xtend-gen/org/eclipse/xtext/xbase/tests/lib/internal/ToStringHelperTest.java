package org.eclipse.xtext.xbase.tests.lib.internal;

import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.internal.LineDelimiters;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ToStringHelperTest {
  public static class OtherClass {
    public ToStringHelperTest.OtherClass other;
    
    public String name;
  }
  
  @Data
  public static class DataClass {
    public final Wrapper<ToStringHelperTest.DataClass> _other;
    
    public final String _name;
    
    public DataClass(final Wrapper<ToStringHelperTest.DataClass> other, final String name) {
      super();
      this._other = other;
      this._name = name;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this._other== null) ? 0 : this._other.hashCode());
      result = prime * result + ((this._name== null) ? 0 : this._name.hashCode());
      return result;
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      ToStringHelperTest.DataClass other = (ToStringHelperTest.DataClass) obj;
      if (this._other == null) {
        if (other._other != null)
          return false;
      } else if (!this._other.equals(other._other))
        return false;
      if (this._name == null) {
        if (other._name != null)
          return false;
      } else if (!this._name.equals(other._name))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      String result = new ToStringHelper().toString(this);
      return result;
    }
    
    @Pure
    public Wrapper<ToStringHelperTest.DataClass> getOther() {
      return this._other;
    }
    
    @Pure
    public String getName() {
      return this._name;
    }
  }
  
  public static class MyEntity {
    private final boolean boolProp = true;
    
    private final int intProp = 42;
    
    private final ArrayList<String> myList = CollectionLiterals.<String>newArrayList("foo", "bar", "baz");
    
    private final ToStringHelperTest.MyEntity friend;
    
    private final RetentionPolicy policy = RetentionPolicy.CLASS;
    
    public MyEntity() {
      this.friend = null;
    }
    
    public MyEntity(final ToStringHelperTest.MyEntity friend) {
      this.friend = friend;
    }
    
    public String toString() {
      String _plus = (Boolean.valueOf(this.boolProp) + "\n");
      String _plus_1 = (_plus + Integer.valueOf(this.intProp));
      String _plus_2 = (_plus_1 + "\n");
      String _plus_3 = (_plus_2 + this.myList);
      String _plus_4 = (_plus_3 + "\n");
      String _plus_5 = (_plus_4 + this.friend);
      String _plus_6 = (_plus_5 + "\n");
      return (_plus_6 + this.policy);
    }
  }
  
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
    String _unix = LineDelimiters.toUnix(_builder.toString());
    ToStringHelperTest.MyEntity _myEntity = new ToStringHelperTest.MyEntity();
    ToStringHelperTest.MyEntity _myEntity_1 = new ToStringHelperTest.MyEntity(_myEntity);
    String _string = helper.toString(_myEntity_1);
    Assert.assertEquals(_unix, _string);
  }
  
  @Test
  public void testSingleLine() {
    ToStringHelperTest.MyEntity _myEntity = new ToStringHelperTest.MyEntity();
    ToStringBuilder _toStringBuilder = new ToStringBuilder(_myEntity);
    ToStringBuilder _singleLine = _toStringBuilder.singleLine();
    final ToStringBuilder helper = _singleLine.addAllFields();
    String _string = helper.toString();
    Assert.assertEquals("MyEntity [boolProp = true, intProp = 42, myList = ArrayList (\"foo\",\"bar\",\"baz\"), friend = null, policy = CLASS]", _string);
  }
  
  @Test
  public void testHideFieldNames() {
    ToStringHelperTest.MyEntity _myEntity = new ToStringHelperTest.MyEntity();
    ToStringBuilder _toStringBuilder = new ToStringBuilder(_myEntity);
    ToStringBuilder _singleLine = _toStringBuilder.singleLine();
    ToStringBuilder _hideFieldNames = _singleLine.hideFieldNames();
    final ToStringBuilder helper = _hideFieldNames.addAllFields();
    String _string = helper.toString();
    Assert.assertEquals("MyEntity [true, 42, ArrayList (\"foo\",\"bar\",\"baz\"), null, CLASS]", _string);
  }
  
  @Test
  public void testSkipNulls() {
    ToStringHelperTest.MyEntity _myEntity = new ToStringHelperTest.MyEntity();
    ToStringBuilder _toStringBuilder = new ToStringBuilder(_myEntity);
    ToStringBuilder _skipNulls = _toStringBuilder.skipNulls();
    final ToStringBuilder helper = _skipNulls.addAllFields();
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
    _builder.append("policy = CLASS");
    _builder.newLine();
    _builder.append("]");
    String _unix = LineDelimiters.toUnix(_builder.toString());
    String _string = helper.toString();
    Assert.assertEquals(_unix, _string);
  }
  
  @Test
  public void testExplicitFieldListing() {
    ToStringHelperTest.MyEntity _myEntity = new ToStringHelperTest.MyEntity();
    ToStringBuilder _toStringBuilder = new ToStringBuilder(_myEntity);
    ToStringBuilder _add = _toStringBuilder.add("boolProp", Boolean.valueOf(false));
    final ToStringBuilder helper = _add.addField("intProp");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MyEntity [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("boolProp = false");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("intProp = 42");
    _builder.newLine();
    _builder.append("]");
    String _unix = LineDelimiters.toUnix(_builder.toString());
    String _string = helper.toString();
    Assert.assertEquals(_unix, _string);
  }
  
  @Test
  public void recursionHandling() {
    final ToStringHelper helper = new ToStringHelper();
    final ToStringHelperTest.OtherClass obj = new ToStringHelperTest.OtherClass();
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
    String _unix = LineDelimiters.toUnix(_builder.toString());
    String _string_1 = helper.toString(obj);
    Assert.assertEquals(_unix, _string_1);
  }
  
  @Test
  public void recursionHandling_02() {
    final ToStringHelper helper = new ToStringHelper();
    final Wrapper<ToStringHelperTest.DataClass> ref = new Wrapper<ToStringHelperTest.DataClass>();
    final ToStringHelperTest.DataClass obj = new ToStringHelperTest.DataClass(ref, "test");
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
    String _unix = LineDelimiters.toUnix(_builder.toString());
    String _string = helper.toString(obj);
    Assert.assertEquals(_unix, _string);
  }
}
