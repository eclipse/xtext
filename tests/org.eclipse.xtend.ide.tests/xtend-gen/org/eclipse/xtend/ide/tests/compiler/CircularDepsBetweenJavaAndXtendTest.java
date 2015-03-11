package org.eclipse.xtend.ide.tests.compiler;

import com.google.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class CircularDepsBetweenJavaAndXtendTest extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper workbenchTestHelper;
  
  @Before
  @After
  public void cleanUp() {
    try {
      this.workbenchTestHelper.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * https://bugs.eclipse.org/bugs/show_bug.cgi?id=400191
   */
  @Test
  public void testBug400191() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public interface JavaInterface<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("T berechneWert();");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.workbenchTestHelper.createFile("JavaInterface.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class XtendImpl<T> implements JavaInterface<T> {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("override T berechneWert() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("return null");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("XtendImpl.xtend", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("public class JavaImpl<T> extends XtendImpl<T> {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("public static final JavaImpl<String> XYZ = new JavaImpl<String>();");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("public static <T> void aendert(JavaInterface<T> arg) {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.workbenchTestHelper.createFile("JavaImpl.java", _builder_2.toString());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("class XtendClient {");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def void doit() {");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("JavaImpl.XYZ.berechneWert()");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("JavaImpl.aendert(JavaImpl.XYZ)");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      this.workbenchTestHelper.createFile("XtendClient.xtend", _builder_3.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug388575() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public interface JavaInterface {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("Moon getit();");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.workbenchTestHelper.createFile("JavaInterface.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Moon {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Moon.xtend", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class XtendClass implements JavaInterface {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("override getit() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("return new Moon");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.workbenchTestHelper.createFile("XtendClass.xtend", _builder_2.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJavaReferencesXtendWithTypeParam() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class JavaClass extends XtendClass<JavaClass> {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.workbenchTestHelper.createFile("JavaClass.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class XtendClass<T extends JavaClass> {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def JavaClass getIt() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("new JavaClass()");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("XtendClass.xtend", _builder_1.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJavaSignatureDependsOnXtend() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public interface FooProvider {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public Foo get();");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.workbenchTestHelper.createFile("test/FooProvider.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package test");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@Data class Foo {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("test/Foo.xtend", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package test");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import test.FooProvider");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("@SuppressWarnings(\"all\")");
      _builder_2.newLine();
      _builder_2.append("class FooUser {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def void doStuff(FooProvider provider) {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("val foo = provider.get");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("println(foo.toString)");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final IFile file = this.workbenchTestHelper.createFile("test/FooUser.xtend", _builder_2.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      IMarker[] _findMarkers = file.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      int _length = _findMarkers.length;
      Assert.assertEquals(0, _length);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertNoErrorsInWorkspace() {
    try {
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRoot _root = _workspace.getRoot();
      final IMarker[] findMarkers = _root.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      for (final IMarker iMarker : findMarkers) {
        String _message = MarkerUtilities.getMessage(iMarker);
        int _severity = MarkerUtilities.getSeverity(iMarker);
        boolean _equals = (_severity == IMarker.SEVERITY_ERROR);
        Assert.assertFalse(_message, _equals);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
