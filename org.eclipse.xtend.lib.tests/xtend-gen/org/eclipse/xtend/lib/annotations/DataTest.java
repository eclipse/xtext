/**
 * Copyright (c) 2016, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.lib.annotations;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class DataTest {
  @Data
  public static class MyDataClass {
    private final String arg;

    private final boolean foo = false;

    public MyDataClass(final String arg) {
      super();
      this.arg = arg;
    }

    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.arg== null) ? 0 : this.arg.hashCode());
      return prime * result + (this.foo ? 1231 : 1237);
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
      DataTest.MyDataClass other = (DataTest.MyDataClass) obj;
      if (this.arg == null) {
        if (other.arg != null)
          return false;
      } else if (!this.arg.equals(other.arg))
        return false;
      if (other.foo != this.foo)
        return false;
      return true;
    }

    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("arg", this.arg);
      b.add("foo", this.foo);
      return b.toString();
    }

    @Pure
    public String getArg() {
      return this.arg;
    }

    @Pure
    public boolean isFoo() {
      return this.foo;
    }
  }

  @Test
  public void testData() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MyDataClass [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("arg = \"foo\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("foo = false");
    _builder.newLine();
    _builder.append("]");
    Assert.assertEquals(DataTest.toUnix(_builder.toString()), new DataTest.MyDataClass("foo").toString());
  }

  public static String toUnix(final String s) {
    StringConcatenation result = new StringConcatenation("\n");
    result.append(s);
    return result.toString();
  }
}
