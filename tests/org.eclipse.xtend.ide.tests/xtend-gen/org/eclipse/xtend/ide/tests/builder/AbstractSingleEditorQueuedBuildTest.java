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
  public void renameTopLevelType() {
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
  public void renameTopLevelType2() {
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
          AbstractSingleEditorQueuedBuildTest.this.save("/mypackage/Bar.java", "Bar", "Bar2");
        }
      };
      this.assertThereAreDeltas(_function, "mypackage.Bar", "mypackage.Bar2");
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
          final Function1<ITextEditor,ITextEditor> _function = new Function1<ITextEditor,ITextEditor>() {
            public ITextEditor apply(final ITextEditor it) {
              ITextEditor _changeContent = AbstractSingleEditorQueuedBuildTest.this._javaEditorExtension.changeContent(it, "public void bar() {}", "");
              ITextEditor _changeContent_1 = AbstractSingleEditorQueuedBuildTest.this._javaEditorExtension.changeContent(_changeContent, "private void bar2() {}", "");
              return _changeContent_1;
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
    final Function1<ITextEditor,ITextEditor> _function = new Function1<ITextEditor,ITextEditor>() {
      public ITextEditor apply(final ITextEditor it) {
        ITextEditor _changeContent = AbstractSingleEditorQueuedBuildTest.this._javaEditorExtension.changeContent(it, oldText, newText);
        return _changeContent;
      }
    };
    ITextEditor _doSave = this.doSave(_openJavaEditor, _function);
    return _doSave;
  }
  
  public ITextEditor save(final String fileName, final Function1<? super ITextEditor,? extends ITextEditor> consumer) {
    ITextEditor _openJavaEditor = this._javaEditorExtension.openJavaEditor(fileName);
    ITextEditor _doSave = this.doSave(_openJavaEditor, consumer);
    return _doSave;
  }
  
  public ITextEditor close(final String fileName, final String oldText, final String newText) {
    ITextEditor _openJavaEditor = this._javaEditorExtension.openJavaEditor(fileName);
    final Function1<ITextEditor,ITextEditor> _function = new Function1<ITextEditor,ITextEditor>() {
      public ITextEditor apply(final ITextEditor it) {
        ITextEditor _changeContent = AbstractSingleEditorQueuedBuildTest.this._javaEditorExtension.changeContent(it, oldText, newText);
        return _changeContent;
      }
    };
    ITextEditor _doClose = this.doClose(_openJavaEditor, _function);
    return _doClose;
  }
  
  public ITextEditor close(final String fileName, final Function1<? super ITextEditor,? extends ITextEditor> consumer) {
    ITextEditor _openJavaEditor = this._javaEditorExtension.openJavaEditor(fileName);
    ITextEditor _doClose = this.doClose(_openJavaEditor, consumer);
    return _doClose;
  }
  
  public abstract ITextEditor doSave(final ITextEditor editor, final Function1<? super ITextEditor,? extends ITextEditor> consumer);
  
  public abstract ITextEditor doClose(final ITextEditor editor, final Function1<? super ITextEditor,? extends ITextEditor> consumer);
}
