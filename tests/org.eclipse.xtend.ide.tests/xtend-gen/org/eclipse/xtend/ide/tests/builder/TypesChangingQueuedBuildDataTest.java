/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtend.ide.tests.builder.AbstractQueuedBuildDataTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class TypesChangingQueuedBuildDataTest extends AbstractQueuedBuildDataTest {
  @Test
  public void createPrimaryType() {
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        TypesChangingQueuedBuildDataTest.this.create("Bar.java", "public class Bar {}");
      }
    };
    this.assertThereAreDeltas(_function, "Bar");
  }
  
  @Test
  public void createPrimaryType2() {
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package mypackage;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class Bar {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        TypesChangingQueuedBuildDataTest.this.create("/mypackage/Bar.java", _builder.toString());
      }
    };
    this.assertThereAreDeltas(_function, "mypackage.Bar");
  }
  
  @Test
  public void createPrimaryAndSecondaryType() {
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("public class Bar {}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("class Foo {}");
        _builder.newLine();
        TypesChangingQueuedBuildDataTest.this.create("Bar.java", _builder.toString());
      }
    };
    this.assertThereAreDeltas(_function, "Foo", "Bar");
  }
  
  @Test
  public void createPrimaryAndSecondaryType2() {
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package mypackage;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class Bar {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("class Foo {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        TypesChangingQueuedBuildDataTest.this.create("/mypackage/Bar.java", _builder.toString());
      }
    };
    this.assertThereAreDeltas(_function, "mypackage.Foo", "mypackage.Bar");
  }
  
  @Test
  public void createPrimaryAndNestedTypes() {
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("public class Bar {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public class Foo {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("public class Foo3 {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static class Foo2 {}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        TypesChangingQueuedBuildDataTest.this.create("Bar.java", _builder.toString());
      }
    };
    this.assertThereAreDeltas(_function, "Bar$Foo$Foo3", "Bar$Foo", "Bar$Foo2", "Bar");
  }
  
  @Test
  public void createPrimaryAndNestedTypes2() {
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package mypackage;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class Bar {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public class Foo {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("public class Foo3 {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static class Foo2 {}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        TypesChangingQueuedBuildDataTest.this.create("/mypackage/Bar.java", _builder.toString());
      }
    };
    this.assertThereAreDeltas(_function, "mypackage.Bar$Foo$Foo3", "mypackage.Bar$Foo", "mypackage.Bar$Foo2", "mypackage.Bar");
  }
  
  @Test
  public void deletePrimaryType() {
    this.create("Bar.java", "public class Bar {}");
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        TypesChangingQueuedBuildDataTest.this.delete("Bar.java");
      }
    };
    this.assertThereAreDeltas(_function, "Bar");
  }
  
  @Test
  public void deletePrimaryType2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Bar {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.create("/mypackage/Bar.java", _builder.toString());
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        TypesChangingQueuedBuildDataTest.this.delete("/mypackage/Bar.java");
      }
    };
    this.assertThereAreDeltas(_function, "mypackage.Bar");
  }
  
  @Test
  public void deletePrimaryAndSecondaryType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Bar {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {}");
    _builder.newLine();
    this.create("Bar.java", _builder.toString());
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        TypesChangingQueuedBuildDataTest.this.delete("Bar.java");
      }
    };
    this.assertThereAreDeltas(_function, "Bar", "Foo");
  }
  
  @Test
  public void deletePrimaryAndSecondaryType2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Bar {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.create("/mypackage/Bar.java", _builder.toString());
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        TypesChangingQueuedBuildDataTest.this.delete("/mypackage/Bar.java");
      }
    };
    this.assertThereAreDeltas(_function, "mypackage.Bar", "mypackage.Foo");
  }
  
  @Test
  public void deletePrimaryAndNestedTypes() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Bar {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public class Foo3 {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static class Foo2 {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.create("Bar.java", _builder.toString());
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        TypesChangingQueuedBuildDataTest.this.delete("Bar.java");
      }
    };
    this.assertThereAreDeltas(_function, "Bar", "Bar$Foo2", "Bar$Foo", "Bar$Foo$Foo3");
  }
  
  @Test
  public void deletePrimaryAndNestedTypes2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Bar {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public class Foo3 {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static class Foo2 {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.create("/mypackage/Bar.java", _builder.toString());
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        TypesChangingQueuedBuildDataTest.this.delete("/mypackage/Bar.java");
      }
    };
    this.assertThereAreDeltas(_function, "mypackage.Bar", "mypackage.Bar$Foo$Foo3", "mypackage.Bar$Foo2", "mypackage.Bar$Foo");
  }
  
  public String create(final String fileName, final String content) {
    String _xblockexpression = null;
    {
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          try {
            TypesChangingQueuedBuildDataTest.this.testHelper.createFile(fileName, content);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      this._javaEditorExtension.waitForPostChangeEvent(_function);
      _xblockexpression = (fileName);
    }
    return _xblockexpression;
  }
  
  public String delete(final String fileName) {
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        try {
          IFile _file = TypesChangingQueuedBuildDataTest.this.testHelper.getFile(fileName);
          NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
          _file.delete(true, _nullProgressMonitor);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    return this._javaEditorExtension.waitForPostChangeEvent(_function);
  }
}
