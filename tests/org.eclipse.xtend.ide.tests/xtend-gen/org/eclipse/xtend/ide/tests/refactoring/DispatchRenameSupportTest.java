package org.eclipse.xtend.ide.tests.refactoring;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.refactoring.DispatchRenameSupport;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class DispatchRenameSupportTest extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper testHelper;
  
  @Inject
  private DispatchRenameSupport dispatchRenameSupport;
  
  public void tearDown() throws Exception {
    this.testHelper.tearDown();
    super.tearDown();
  }
  
  @Test
  public void testSimple() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(String x) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Integer x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile fooFile = this.testHelper.xtendFile("Foo", _builder.toString());
      XtendFunction _firstMethod = this.firstMethod(fooFile);
      this.checkDispatchOperations(_firstMethod, 
        "Foo._foo(String)", "Foo._foo(Integer)", "Foo.foo(Object)");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSubClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(String x) {}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final XtendFile subFile = this.testHelper.xtendFile("Sub", _builder_1.toString());
      XtendFunction _firstMethod = this.firstMethod(subFile);
      this.checkDispatchOperations(_firstMethod, 
        "Super.foo(Double)", "Super._foo(Double)", 
        "Sub._foo(String)", "Sub._foo(Integer)", "Sub.foo(Object)");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSuperClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile superFile = this.testHelper.xtendFile("Super", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(String x) {}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("Sub", _builder_1.toString());
      XtendFunction _firstMethod = this.firstMethod(superFile);
      this.checkDispatchOperations(_firstMethod, 
        "Super.foo(Double)", "Super._foo(Double)", 
        "Sub._foo(String)", "Sub._foo(Integer)", "Sub.foo(Object)");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSubClassOverride() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(String x) {}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("override dispatch foo(Double x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final XtendFile subFile = this.testHelper.xtendFile("Sub", _builder_1.toString());
      XtendFunction _firstMethod = this.firstMethod(subFile);
      this.checkDispatchOperations(_firstMethod, 
        "Super.foo(Double)", "Super._foo(Double)", 
        "Sub._foo(String)", "Sub._foo(Double)", "Sub.foo(Object)");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSuperClassOverride() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile superFile = this.testHelper.xtendFile("Super", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(String x) {}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("override dispatch foo(Double x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("Sub", _builder_1.toString());
      XtendFunction _firstMethod = this.firstMethod(superFile);
      this.checkDispatchOperations(_firstMethod, 
        "Super.foo(Double)", "Super._foo(Double)", 
        "Sub._foo(String)", "Sub._foo(Double)", "Sub.foo(Object)");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSubSubClass_0() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("Sub", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class SubSub extends Sub {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final XtendFile subSubFile = this.testHelper.xtendFile("SubSub", _builder_2.toString());
      XtendFunction _firstMethod = this.firstMethod(subSubFile);
      this.checkDispatchOperations(_firstMethod, 
        "Super.foo(Double)", "Super._foo(Double)", 
        "Sub._foo(Integer)", "Sub.foo(Object)", 
        "SubSub._foo(String)", "SubSub.foo(Object)");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSubSubClass_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final XtendFile subFile = this.testHelper.xtendFile("Sub", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class SubSub extends Sub {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.testHelper.createFile("SubSub", _builder_2.toString());
      XtendFunction _firstMethod = this.firstMethod(subFile);
      this.checkDispatchOperations(_firstMethod, 
        "Super.foo(Double)", "Super._foo(Double)", 
        "Sub._foo(Integer)", "Sub.foo(Object)", 
        "SubSub._foo(String)", "SubSub.foo(Object)");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSubSubClass_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile superFile = this.testHelper.xtendFile("Super.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("Sub", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class SubSub extends Sub {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.testHelper.createFile("SubSub", _builder_2.toString());
      XtendFunction _firstMethod = this.firstMethod(superFile);
      this.checkDispatchOperations(_firstMethod, 
        "Super.foo(Double)", "Super._foo(Double)", 
        "Sub._foo(Integer)", "Sub.foo(Object)", 
        "SubSub._foo(String)", "SubSub.foo(Object)");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConnectedSubclasses_0() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile superFile = this.testHelper.xtendFile("Super.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub0 extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("Sub0", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Sub1 extends Super {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.testHelper.createFile("Sub1", _builder_2.toString());
      XtendFunction _firstMethod = this.firstMethod(superFile);
      this.checkDispatchOperations(_firstMethod, 
        "Super.foo(Double)", "Super._foo(Double)", 
        "Sub0._foo(Integer)", "Sub0.foo(Object)", 
        "Sub1._foo(String)", "Sub1.foo(Object)");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConnectedSubclasses_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub0 extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final XtendFile sub0File = this.testHelper.xtendFile("Sub0", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Sub1 extends Super {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.testHelper.createFile("Sub1", _builder_2.toString());
      XtendFunction _firstMethod = this.firstMethod(sub0File);
      this.checkDispatchOperations(_firstMethod, 
        "Super.foo(Double)", "Super._foo(Double)", 
        "Sub0._foo(Integer)", "Sub0.foo(Object)", 
        "Sub1._foo(String)", "Sub1.foo(Object)");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnconnectedSubclasses_0() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub0 extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final XtendFile sub0File = this.testHelper.xtendFile("Sub0", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Sub1 extends Super {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.testHelper.createFile("Sub1", _builder_2.toString());
      XtendFunction _firstMethod = this.firstMethod(sub0File);
      this.checkDispatchOperations(_firstMethod, 
        "Sub0._foo(Integer)", "Sub0.foo(Integer)");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnconnectedSubclasses_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub0 extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("Sub0", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Sub1 extends Super {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final XtendFile sub1File = this.testHelper.xtendFile("Sub1", _builder_2.toString());
      XtendFunction _firstMethod = this.firstMethod(sub1File);
      this.checkDispatchOperations(_firstMethod, 
        "Sub1._foo(String)", "Sub1.foo(String)");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public XtendFunction firstMethod(final XtendFile file) {
    XtendFunction _xblockexpression = null;
    {
      EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
      XtendTypeDeclaration _get = _xtendTypes.get(0);
      final XtendClass xtendClass = ((XtendClass) _get);
      EList<XtendMember> _members = xtendClass.getMembers();
      XtendMember _get_1 = _members.get(0);
      _xblockexpression = (((XtendFunction) _get_1));
    }
    return _xblockexpression;
  }
  
  public void checkDispatchOperations(final XtendFunction targetMethod, final String... signatures) {
    IResourcesSetupUtil.waitForAutoBuild();
    Iterable<JvmOperation> _allDispatchOperations = this.dispatchRenameSupport.getAllDispatchOperations(targetMethod);
    final Function1<JvmOperation,String> _function = new Function1<JvmOperation,String>() {
        public String apply(final JvmOperation it) {
          String _signature = DispatchRenameSupportTest.this.signature(it);
          return _signature;
        }
      };
    final Iterable<String> dispatchOperations = IterableExtensions.<JvmOperation, String>map(_allDispatchOperations, _function);
    int _size = ((List<String>)Conversions.doWrapArray(signatures)).size();
    int _size_1 = Iterables.size(dispatchOperations);
    Assert.assertEquals(_size, _size_1);
    for (final String signature : signatures) {
      String _plus = (signature + " not found. Only got");
      String _join = IterableExtensions.join(dispatchOperations, "\n");
      String _plus_1 = (_plus + _join);
      boolean _contains = Iterables.contains(dispatchOperations, signature);
      Assert.assertTrue(_plus_1, _contains);
    }
  }
  
  public String signature(final JvmOperation it) {
    StringConcatenation _builder = new StringConcatenation();
    String _qualifiedName = it.getQualifiedName();
    _builder.append(_qualifiedName, "");
    _builder.append("(");
    {
      EList<JvmFormalParameter> _parameters = it.getParameters();
      boolean _hasElements = false;
      for(final JvmFormalParameter p : _parameters) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        JvmTypeReference _parameterType = p.getParameterType();
        JvmType _type = _parameterType.getType();
        String _simpleName = _type.getSimpleName();
        _builder.append(_simpleName, "");
      }
    }
    _builder.append(")");
    String _string = _builder.toString();
    return _string;
  }
}
