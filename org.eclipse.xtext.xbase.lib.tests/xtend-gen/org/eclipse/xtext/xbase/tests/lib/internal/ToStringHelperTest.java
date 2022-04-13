/**
 * Copyright (c) 2018, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.lib.internal;

import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.junit.Assert;
import org.junit.Test;

@Deprecated
@SuppressWarnings("all")
public class ToStringHelperTest {
  public static class OtherClass {
    public ToStringHelperTest.OtherClass other;

    public String name;
  }

  @Accessors
  @ToString
  public static class DataClass {
    public ToStringHelperTest.DataClass other;

    public String name;

    @Pure
    public ToStringHelperTest.DataClass getOther() {
      return this.other;
    }

    public void setOther(final ToStringHelperTest.DataClass other) {
      this.other = other;
    }

    @Pure
    public String getName() {
      return this.name;
    }

    public void setName(final String name) {
      this.name = name;
    }

    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("other", this.other);
      b.add("name", this.name);
      return b.toString();
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

    @Override
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
    ToStringHelperTest.MyEntity _myEntity = new ToStringHelperTest.MyEntity();
    ToStringHelperTest.MyEntity _myEntity_1 = new ToStringHelperTest.MyEntity(_myEntity);
    Assert.assertEquals(
      ToStringHelperTest.toUnix(_builder.toString()), helper.toString(_myEntity_1));
  }

  @Test
  public void testSingleLine() {
    ToStringHelperTest.MyEntity _myEntity = new ToStringHelperTest.MyEntity();
    final ToStringBuilder helper = new ToStringBuilder(_myEntity).singleLine().addAllFields();
    Assert.assertEquals(
      "MyEntity [boolProp = true, intProp = 42, myList = ArrayList (\"foo\",\"bar\",\"baz\"), friend = null, policy = CLASS]", 
      helper.toString());
  }

  @Test
  public void testHideFieldNames() {
    ToStringHelperTest.MyEntity _myEntity = new ToStringHelperTest.MyEntity();
    final ToStringBuilder helper = new ToStringBuilder(_myEntity).singleLine().hideFieldNames().addAllFields();
    Assert.assertEquals("MyEntity [true, 42, ArrayList (\"foo\",\"bar\",\"baz\"), null, CLASS]", helper.toString());
  }

  @Test
  public void testSkipNulls() {
    ToStringHelperTest.MyEntity _myEntity = new ToStringHelperTest.MyEntity();
    final ToStringBuilder helper = new ToStringBuilder(_myEntity).skipNulls().addAllFields();
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
    Assert.assertEquals(
      ToStringHelperTest.toUnix(_builder.toString()), helper.toString());
  }

  @Test
  public void testExplicitFieldListing() {
    ToStringHelperTest.MyEntity _myEntity = new ToStringHelperTest.MyEntity();
    final ToStringBuilder helper = new ToStringBuilder(_myEntity).add("boolProp", Boolean.valueOf(false)).addField("intProp");
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
    Assert.assertEquals(
      ToStringHelperTest.toUnix(_builder.toString()), helper.toString());
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
    Assert.assertEquals(
      ToStringHelperTest.toUnix(_builder.toString()), helper.toString(obj));
  }

  @Test
  public void recursionHandling_02() {
    final ToStringHelper helper = new ToStringHelper();
    final ToStringHelperTest.DataClass obj = new ToStringHelperTest.DataClass();
    obj.other = obj;
    obj.name = "test";
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("DataClass [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("other = DataClass@");
    int _identityHashCode = System.identityHashCode(obj);
    _builder.append(_identityHashCode, "  ");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("name = \"test\"");
    _builder.newLine();
    _builder.append("]");
    Assert.assertEquals(
      ToStringHelperTest.toUnix(_builder.toString()), helper.toString(obj));
  }

  public static String toUnix(final String s) {
    StringConcatenation result = new StringConcatenation("\n");
    result.append(s);
    return result.toString();
  }
}
