/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.builder;

import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtend.ide.tests.builder.AbstractQueuedBuildDataTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractSingleEditorQueuedBuildTest extends AbstractQueuedBuildDataTest {
  @Test
  public void addTypeParameter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "Bar", "Bar<T>");
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void addAnnotation() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("@javax.annotation.Resource");
          _builder.newLine();
          _builder.append("public class Bar {");
          _builder.newLine();
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "public class Bar {", _builder.toString());
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void addPrimaryTopLevelType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("// primary top level type");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "// primary top level type", "public class Bar {}");
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void removePrimaryTopLevelType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "public class Bar {}", "");
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renamePrimaryTopLevelType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "Bar", "Bar2");
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar", "mypackage.Bar2");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void addPrimaryTopLevelTypeWithinDefaultPackage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("// primary top level type");
      _builder.newLine();
      this.testHelper.createFile("Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/Bar.java", "// primary top level type", "public class Bar {}");
        }
      };
      this.assertThereAreDeltas(_function, "Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void removePrimaryTopLevelTypeWithinDefaultPackage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Bar {}");
      _builder.newLine();
      this.testHelper.createFile("Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("Bar.java", "public class Bar {}", "");
        }
      };
      this.assertThereAreDeltas(_function, "Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renamePrimaryTopLevelTypeWithinDefaultPackage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Bar {}");
      _builder.newLine();
      this.testHelper.createFile("Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("Bar.java", "Bar", "Bar2");
        }
      };
      this.assertThereAreDeltas(_function, "Bar", "Bar2");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void addSecondaryTopLevelType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("// secondary top level type");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "// secondary top level type", "class Foo {}");
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Foo");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void removeSecondaryTopLevelType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "class Foo {}", "");
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Foo");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameSecondaryTopLevelType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar2 {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "Bar2", "Bar3");
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar2", "mypackage.Bar3");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void addSecondaryTopLevelTypeWithinDefaultPackage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("// secondary top level type");
      _builder.newLine();
      this.testHelper.createFile("Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("Bar.java", "// secondary top level type", "class Foo {}");
        }
      };
      this.assertThereAreDeltas(_function, "Foo");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void removeSecondaryTopLevelTypeWithinDefaultPackage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {}");
      _builder.newLine();
      this.testHelper.createFile("Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("Bar.java", "class Foo {}", "");
        }
      };
      this.assertThereAreDeltas(_function, "Foo");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameSecondaryTopLevelTypeWithinDefaultPackage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar2 {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("Bar.java", "Bar2", "Bar3");
        }
      };
      this.assertThereAreDeltas(_function, "Bar2", "Bar3");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void addNestedTypes() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// nested types");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("public class Foo {");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public class Foo3 {}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("public static class Foo2 {}");
          _builder.newLine();
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "// nested types", _builder.toString());
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar", "mypackage.Bar$Foo", "mypackage.Bar$Foo2", "mypackage.Bar$Foo$Foo3");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void removeNestedTypes() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public class Foo { public class Foo3 {} }");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static class Foo2 {}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          final Function1<ITextEditor, ITextEditor> _function = new Function1<ITextEditor, ITextEditor>() {
            public ITextEditor apply(final ITextEditor it) {
              ITextEditor _xblockexpression = null;
              {
                AbstractSingleEditorQueuedBuildTest.this._javaEditorExtension.changeContent(it, "public class Foo { public class Foo3 {} }", "");
                _xblockexpression = AbstractSingleEditorQueuedBuildTest.this._javaEditorExtension.changeContent(it, "public static class Foo2 {}", "");
              }
              return _xblockexpression;
            }
          };
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", _function);
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar", "mypackage.Bar$Foo", "mypackage.Bar$Foo2", "mypackage.Bar$Foo$Foo3");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameNestedTypes() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public class Foo3 {}");
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
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          final Function1<ITextEditor, ITextEditor> _function = new Function1<ITextEditor, ITextEditor>() {
            public ITextEditor apply(final ITextEditor it) {
              ITextEditor _xblockexpression = null;
              {
                AbstractSingleEditorQueuedBuildTest.this._javaEditorExtension.changeContent(it, " Foo ", " NewFoo ");
                AbstractSingleEditorQueuedBuildTest.this._javaEditorExtension.changeContent(it, " Foo2 ", " NewFoo2 ");
                _xblockexpression = AbstractSingleEditorQueuedBuildTest.this._javaEditorExtension.changeContent(it, " Foo3 ", " NewFoo3 ");
              }
              return _xblockexpression;
            }
          };
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", _function);
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar", "mypackage.Bar$Foo", "mypackage.Bar$Foo2", "mypackage.Bar$NewFoo", 
        "mypackage.Bar$NewFoo2", "mypackage.Bar$NewFoo$NewFoo3", "mypackage.Bar$Foo$Foo3");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void addNestedTypesWithinDefaultPackage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// nested types");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("public class Foo {");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public class Foo3 {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("public static class Foo2 {}");
          _builder.newLine();
          AbstractSingleEditorQueuedBuildTest.this.save("Bar.java", "// nested types", _builder.toString());
        }
      };
      this.assertThereAreDeltas(_function, "Bar", "Bar$Foo", "Bar$Foo2", "Bar$Foo$Foo3");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void addNestedTypesWithinDefaultPackage2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// nested types");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("public class Foo3 {}");
          AbstractSingleEditorQueuedBuildTest.this.save("Bar.java", "// nested types", _builder.toString());
        }
      };
      this.assertThereAreDeltas(_function, "Bar$Foo", "Bar$Foo$Foo3");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void removeNestedTypesWithinDefaultPackage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public class Foo { public class Foo3 {} }");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static class Foo2 {}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          final Function1<ITextEditor, ITextEditor> _function = new Function1<ITextEditor, ITextEditor>() {
            public ITextEditor apply(final ITextEditor it) {
              ITextEditor _xblockexpression = null;
              {
                AbstractSingleEditorQueuedBuildTest.this._javaEditorExtension.changeContent(it, "public class Foo { public class Foo3 {} }", "");
                _xblockexpression = AbstractSingleEditorQueuedBuildTest.this._javaEditorExtension.changeContent(it, "public static class Foo2 {}", "");
              }
              return _xblockexpression;
            }
          };
          AbstractSingleEditorQueuedBuildTest.this.save("Bar.java", _function);
        }
      };
      this.assertThereAreDeltas(_function, "Bar", "Bar$Foo", "Bar$Foo2", "Bar$Foo$Foo3");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameNestedTypesWithinDefaultPackage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public class Foo { public class Foo3 {} }");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static class Foo2 {}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          final Function1<ITextEditor, ITextEditor> _function = new Function1<ITextEditor, ITextEditor>() {
            public ITextEditor apply(final ITextEditor it) {
              ITextEditor _xblockexpression = null;
              {
                AbstractSingleEditorQueuedBuildTest.this._javaEditorExtension.changeContent(it, " Foo ", " NewFoo ");
                AbstractSingleEditorQueuedBuildTest.this._javaEditorExtension.changeContent(it, " Foo2 ", " NewFoo2 ");
                _xblockexpression = AbstractSingleEditorQueuedBuildTest.this._javaEditorExtension.changeContent(it, " Foo3 ", " NewFoo3 ");
              }
              return _xblockexpression;
            }
          };
          AbstractSingleEditorQueuedBuildTest.this.save("Bar.java", _function);
        }
      };
      this.assertThereAreDeltas(_function, "Bar", "Bar$Foo", "Bar$Foo2", "Bar$NewFoo", "Bar$NewFoo2", "Bar$NewFoo$NewFoo3", "Bar$Foo$Foo3");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void changePackageDeclaration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "package mypackage;", "package mypackage2;");
        }
      };
      this.assertThereAreNotDeltas(_function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void makeFieldPrivate() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public String bar;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "public String bar;", "private String bar;");
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void makeFieldPublic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private String bar;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "private String bar;", "public String bar;");
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void makePrivateFieldStatic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private String bar;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "private String bar;", "private static String bar;");
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void changeImports() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public List<String> bar;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "import java.util.List;", "");
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void changeImports2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public List<String> bar;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "import java.util.List;", "import java.awt.List;");
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void changeImports3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar2 {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "import java.util.List;", "import java.awt.List;");
        }
      };
      this.assertThereAreNotDeltas(_function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void changeImports4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static class Bar2 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "import java.util.List;", "import java.awt.List;");
        }
      };
      this.assertThereAreNotDeltas(_function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void changeImports5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public List<String> bar;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar2 {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public List<String> bar2;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "import java.util.List;", "import java.awt.List;");
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar", "mypackage.Bar2");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameLocalVariable() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("int x = 3;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "x", "y");
        }
      };
      this.assertThereAreNotDeltas(_function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameMethod() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("System.out.println(\"Hello world!\");");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "bar()", "bar2()");
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRenameMethodWithoutSaving() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void bar() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mypackage;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("public class Bar2 {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public void bar() {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("/mypackage/Bar2.java", _builder_1.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.close("/mypackage/Bar.java", "bar()", "bar2()");
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar2.java", "bar()", "bar2()");
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar2");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void changeMethodBody() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("System.out.println(\"Hello world!\");");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "Hello world!", "Hello!");
        }
      };
      this.assertThereAreNotDeltas(_function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void addPublicMethod() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("public class Bar {");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void bar2() {}");
          _builder.newLine();
          _builder.newLine();
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "public class Bar {", _builder.toString());
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void removePublicMethod() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("System.out.println(\"Hello world!\");");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("public void bar() {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("System.out.println(\"Hello world!\");");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", _builder.toString(), "");
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void removePrivateMethod() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private void bar() {}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "private void bar() {}", "");
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void removePublicAndPrivateMethods() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Bar {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void bar() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private void bar2() {}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder.toString());
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          final Function1<ITextEditor, ITextEditor> _function = new Function1<ITextEditor, ITextEditor>() {
            public ITextEditor apply(final ITextEditor it) {
              ITextEditor _changeContent = AbstractSingleEditorQueuedBuildTest.this._javaEditorExtension.changeContent(it, "public void bar() {}", "");
              return AbstractSingleEditorQueuedBuildTest.this._javaEditorExtension.changeContent(_changeContent, "private void bar2() {}", "");
            }
          };
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", _function);
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ITextEditor save(final String fileName, final String oldText, final String newText) {
    ITextEditor _openJavaEditor = this._javaEditorExtension.openJavaEditor(fileName);
    final Function1<ITextEditor, ITextEditor> _function = new Function1<ITextEditor, ITextEditor>() {
      public ITextEditor apply(final ITextEditor it) {
        return AbstractSingleEditorQueuedBuildTest.this._javaEditorExtension.changeContent(it, oldText, newText);
      }
    };
    return this.doSave(_openJavaEditor, _function);
  }
  
  public ITextEditor save(final String fileName, final Function1<? super ITextEditor, ? extends ITextEditor> consumer) {
    ITextEditor _openJavaEditor = this._javaEditorExtension.openJavaEditor(fileName);
    return this.doSave(_openJavaEditor, consumer);
  }
  
  public ITextEditor close(final String fileName, final String oldText, final String newText) {
    ITextEditor _openJavaEditor = this._javaEditorExtension.openJavaEditor(fileName);
    final Function1<ITextEditor, ITextEditor> _function = new Function1<ITextEditor, ITextEditor>() {
      public ITextEditor apply(final ITextEditor it) {
        return AbstractSingleEditorQueuedBuildTest.this._javaEditorExtension.changeContent(it, oldText, newText);
      }
    };
    return this.doClose(_openJavaEditor, _function);
  }
  
  public ITextEditor close(final String fileName, final Function1<? super ITextEditor, ? extends ITextEditor> consumer) {
    ITextEditor _openJavaEditor = this._javaEditorExtension.openJavaEditor(fileName);
    return this.doClose(_openJavaEditor, consumer);
  }
  
  public abstract ITextEditor doSave(final ITextEditor editor, final Function1<? super ITextEditor, ? extends ITextEditor> consumer);
  
  public abstract ITextEditor doClose(final ITextEditor editor, final Function1<? super ITextEditor, ? extends ITextEditor> consumer);
}
