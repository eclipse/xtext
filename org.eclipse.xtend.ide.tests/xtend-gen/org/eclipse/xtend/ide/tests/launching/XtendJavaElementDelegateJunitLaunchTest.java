/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.launching;

import com.google.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.xtend.ide.launching.XtendJavaElementDelegateJunitLaunch;
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.testing.AbstractEditorTest;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.ui.launching.JavaElementDelegateJunitLaunch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 * 
 * Test cases for the {@link XtendJavaElementDelegateJunitLaunch} class.
 */
@RunWith(XtextRunner.class)
@InjectWith(XtendIDEInjectorProvider.class)
@SuppressWarnings("all")
public class XtendJavaElementDelegateJunitLaunchTest extends AbstractEditorTest {
  private final String c = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<|>");
      return _builder.toString();
    }
  }.apply();

  @Inject
  @Extension
  private FileExtensionProvider _fileExtensionProvider;

  @Inject
  private JavaElementDelegateJunitLaunch launcher;

  @Before
  public void setup() {
    try {
      JavaProjectSetupUtil.createJavaProject(this.getProjectName());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_class_is_recognized_if_cursor_is_located_before_the_class() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(this.c);
    _builder.append("package foo");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.junit.Test");
    _builder.newLine();
    _builder.append("import static org.junit.Assert.assertTrue");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class FooTest {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Test def a() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("assertTrue(true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Test def b() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("assertTrue(false)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.junitTestClassIsRecognized(_builder);
  }

  @Test
  public void test_class_is_recognized_if_cursor_is_located_in_the_class() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.junit.Test");
    _builder.newLine();
    _builder.append("import static org.junit.Assert.assertTrue");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class FooTest {");
    _builder.newLine();
    _builder.append(this.c);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@Test def a() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("assertTrue(true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Test def b() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("assertTrue(false)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.junitTestClassIsRecognized(_builder);
  }

  @Test
  public void test_class_is_recognized_if_cursor_is_located_after_the_class() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.junit.Test");
    _builder.newLine();
    _builder.append("import static org.junit.Assert.assertTrue");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class FooTest {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Test def a() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("assertTrue(true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Test def b() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("assertTrue(false)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.append(this.c);
    _builder.newLineIfNotEmpty();
    this.junitTestClassIsRecognized(_builder);
  }

  @Test
  public void test_class_is_recognized_if_cursor_is_located_in_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.junit.Test");
    _builder.newLine();
    _builder.append("import static org.junit.Assert.assertTrue");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/** xx");
    _builder.append(this.c);
    _builder.append("x */");
    _builder.newLineIfNotEmpty();
    _builder.append("@ExtendWith(InjectionExtension)");
    _builder.newLine();
    _builder.append("@InjectWith(MyDslInjectorProvider)");
    _builder.newLine();
    _builder.append("class FooTest {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Test def a() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("assertTrue(true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Test def b() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("assertTrue(false)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.junitTestClassIsRecognized(_builder);
  }

  @Test
  public void no_test_class_is_recognized_if_two_classes_are_defined001() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("class First {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("@Test def void m() { }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append(this.c);
    _builder.newLineIfNotEmpty();
    _builder.append("class Second {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("@Test def void m() { }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.noJunitTestClassIsRecognized(_builder);
  }

  @Test
  public void no_test_class_is_recognized_if_two_classes_are_defined002() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("class Utils {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("// not tests in that class");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append(this.c);
    _builder.newLineIfNotEmpty();
    _builder.append("class Second {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("@Test def void m() { }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.noJunitTestClassIsRecognized(_builder);
  }

  private void junitTestClassIsRecognized(final CharSequence text) {
    this.junitTestClassIsRecognized(text, "FooTest");
  }

  private void noJunitTestClassIsRecognized(final CharSequence text) {
    this.junitTestClassIsRecognized(text, null);
  }

  private void junitTestClassIsRecognized(final CharSequence it, final String expected) {
    this.junitTestClassIsRecognized(this.openEditor(this.dslFile(it), this.getCursorPosition(it)), expected);
  }

  private IFile dslFile(final CharSequence text) {
    try {
      IFile _xblockexpression = null;
      {
        final IFile file = IResourcesSetupUtil.createFile(this.getProjectName(), "src/foo/FooTest", this._fileExtensionProvider.getPrimaryFileExtension(), this.getContent(text));
        final IProject project = file.getProject();
        boolean _hasNature = project.hasNature(XtextProjectHelper.NATURE_ID);
        boolean _not = (!_hasNature);
        if (_not) {
          IResourcesSetupUtil.addNature(project, XtextProjectHelper.NATURE_ID);
        }
        IResourcesSetupUtil.fullBuild();
        _xblockexpression = file;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  private XtextEditor openEditor(final IFile it, final int cursorPosition) {
    try {
      XtextEditor _xblockexpression = null;
      {
        final XtextEditor xtextEditor = this.openEditor(it);
        xtextEditor.getInternalSourceViewer().setSelectedRange(cursorPosition, 0);
        _xblockexpression = xtextEditor;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  private void junitTestClassIsRecognized(final XtextEditor xtextEditor, final String expectedJavaElementName) {
    this.launcher.initializeWith(xtextEditor);
    final IJavaElement javaElement = this.launcher.<IJavaElement>getAdapter(IJavaElement.class);
    if ((expectedJavaElementName == null)) {
      Assert.assertNull(javaElement);
    } else {
      Assert.assertNotNull(javaElement);
      Assert.assertEquals(expectedJavaElementName, javaElement.getElementName());
    }
  }

  private String getProjectName() {
    return "XtendJavaElementDelegateJunitLaunchTest";
  }

  private String getContent(final CharSequence text) {
    return text.toString().replace(this.c, "");
  }

  private int getCursorPosition(final CharSequence text) {
    int _xblockexpression = (int) 0;
    {
      final int cursorPosition = text.toString().indexOf(this.c);
      if ((cursorPosition == (-1))) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("The input text");
        _builder.newLine();
        _builder.append(text);
        _builder.newLineIfNotEmpty();
        _builder.append("must contain the \'");
        _builder.append(this.c);
        _builder.append("\' special symbol indicating the current cursor position!");
        _builder.newLineIfNotEmpty();
        Assert.fail(_builder.toString());
      }
      _xblockexpression = cursorPosition;
    }
    return _xblockexpression;
  }
}
