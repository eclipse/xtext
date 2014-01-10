package org.eclipse.xtend.ide.tests.compiler;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.internal.StopwatchRule;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

@SuppressWarnings("all")
public class RebuildAffectedResourcesTest extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper workbenchTestHelper;
  
  @Rule
  public StopwatchRule rule = new StopwatchRule(true);
  
  @After
  public void tearDown() {
    try {
      IProject _project = this.workbenchTestHelper.getProject();
      _project.delete(true, null);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRemoveReferencedType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Type1 {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile type1 = this.workbenchTestHelper.createFile("Type1.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Type2 {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Type1 myRef");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile type2 = this.workbenchTestHelper.createFile("Type2.xtend", _builder_1.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Type3 {");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      StringInputStream _stringInputStream = new StringInputStream(_builder_2.toString());
      type1.setContents(_stringInputStream, true, true, null);
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertHasErrors(type2, "Type1");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAddReferencedType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Type3 {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile type1 = this.workbenchTestHelper.createFile("Type1.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Type2 {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Type1 myRef");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile type2 = this.workbenchTestHelper.createFile("Type2.xtend", _builder_1.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertHasErrors(type2, "Type1");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Type1 {");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      StringInputStream _stringInputStream = new StringInputStream(_builder_2.toString());
      type1.setContents(_stringInputStream, true, true, null);
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAddMethod() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Type3 {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile type3 = this.workbenchTestHelper.createFile("Type3.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Type1 {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def Type3 foo() { return new Type3()}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Type1.xtend", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Type2 {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def void doStuff() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("new Type1().foo().bar()");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final IFile type2 = this.workbenchTestHelper.createFile("Type2.xtend", _builder_2.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertHasErrors(type2, "bar");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("class Type3 {");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def void bar() {}");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      StringInputStream _stringInputStream = new StringInputStream(_builder_3.toString());
      type3.setContents(_stringInputStream, true, true, null);
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testExtendedClassChanges() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Type3 {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile type3 = this.workbenchTestHelper.createFile("Type3.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Type1 extends Type3 {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Type1.xtend", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Type2 {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def void doStuff(Type1 foo) {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("foo.bar");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final IFile type2 = this.workbenchTestHelper.createFile("Type2.xtend", _builder_2.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertHasErrors(type2, "bar");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("class Type3 {");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def void bar() {}");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      StringInputStream _stringInputStream = new StringInputStream(_builder_3.toString());
      type3.setContents(_stringInputStream, true, true, null);
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("class Type3 {");
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("def void baz() {}");
      _builder_4.newLine();
      _builder_4.append("}");
      _builder_4.newLine();
      StringInputStream _stringInputStream_1 = new StringInputStream(_builder_4.toString());
      type3.setContents(_stringInputStream_1, true, true, null);
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertHasErrors(type2, "bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=388828
   */
  @Test
  public void testBug388828() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("abstract class A {}");
      _builder.newLine();
      final IFile typeA = this.workbenchTestHelper.createFile("A.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class B extends A {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile typeB = this.workbenchTestHelper.createFile("B.xtend", _builder_1.toString());
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("abst ract class A {");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      StringInputStream _stringInputStream = new StringInputStream(_builder_2.toString());
      typeA.setContents(_stringInputStream, true, true, null);
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertHasErrors(typeA, "abst");
      this.assertHasErrors(typeB, "A");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("abstract class A {}");
      _builder_3.newLine();
      StringInputStream _stringInputStream_1 = new StringInputStream(_builder_3.toString());
      typeA.setContents(_stringInputStream_1, true, true, null);
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
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
  
  public void assertNumberOfBuilds(final int numberOfBuild) {
    IResourcesSetupUtil.waitForAutoBuild();
    Map<String,Stopwatches.NumbersForTask> _allNumbers = Stopwatches.allNumbers();
    Set<Map.Entry<String,Stopwatches.NumbersForTask>> _entrySet = _allNumbers.entrySet();
    final Function1<Map.Entry<String,Stopwatches.NumbersForTask>,Boolean> _function = new Function1<Map.Entry<String,Stopwatches.NumbersForTask>,Boolean>() {
      public Boolean apply(final Map.Entry<String,Stopwatches.NumbersForTask> it) {
        String _key = it.getKey();
        return Boolean.valueOf(Objects.equal(_key, "XtextBuilder.build"));
      }
    };
    Iterable<Map.Entry<String,Stopwatches.NumbersForTask>> _filter = IterableExtensions.<Map.Entry<String,Stopwatches.NumbersForTask>>filter(_entrySet, _function);
    final Map.Entry<String,Stopwatches.NumbersForTask> builderEntry = IterableExtensions.<Map.Entry<String,Stopwatches.NumbersForTask>>head(_filter);
    boolean _equals = Objects.equal(builderEntry, null);
    if (_equals) {
      Assert.assertEquals(numberOfBuild, 0);
    } else {
      Stopwatches.NumbersForTask _value = builderEntry.getValue();
      final int actualMeasurements = _value.getNumberOfMeasurements();
      Assert.assertEquals(numberOfBuild, actualMeasurements);
    }
  }
  
  public void assertHasErrors(final IFile file, final String msgPart) {
    try {
      final IMarker[] findMarkers = file.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      for (final IMarker iMarker : findMarkers) {
        boolean _and = false;
        int _severity = MarkerUtilities.getSeverity(iMarker);
        boolean _equals = (_severity == IMarker.SEVERITY_ERROR);
        if (!_equals) {
          _and = false;
        } else {
          String _message = MarkerUtilities.getMessage(iMarker);
          boolean _contains = _message.contains(msgPart);
          _and = _contains;
        }
        if (_and) {
          return;
        }
      }
      IPath _fullPath = file.getFullPath();
      String _plus = ((("Expected an error marker containing \'" + msgPart) + "\' on ") + _fullPath);
      String _plus_1 = (_plus + " but found ");
      final Function1<IMarker,String> _function = new Function1<IMarker,String>() {
        public String apply(final IMarker it) {
          return MarkerUtilities.getMessage(it);
        }
      };
      List<String> _map = ListExtensions.<IMarker, String>map(((List<IMarker>)Conversions.doWrapArray(findMarkers)), _function);
      String _join = IterableExtensions.join(_map, ",");
      String _plus_2 = (_plus_1 + _join);
      Assert.fail(_plus_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
