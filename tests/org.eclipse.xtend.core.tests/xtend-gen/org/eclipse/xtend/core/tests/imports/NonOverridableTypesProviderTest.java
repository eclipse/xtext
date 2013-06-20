package org.eclipse.xtend.core.tests.imports;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.imports.NonOverridableTypesProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;

/**
 * TODO: Write more of these tests as soon as Xtend provides inner classes
 */
@SuppressWarnings("all")
public class NonOverridableTypesProviderTest extends AbstractXtendTestCase {
  @Inject
  private NonOverridableTypesProvider typesFromHierarchy;
  
  @Inject
  private IXtendJvmAssociations associations;
  
  @Test
  public void testInheritOuter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import types.OuterClass");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo extends OuterClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendClass xtendClass = this.clazz(_builder.toString());
      final JvmGenericType inferredType = this.associations.getInferredType(xtendClass);
      this.assertTypeInScope("Foo", inferredType);
      this.assertTypeInScope("MiddleClass", inferredType);
      this.assertNotInScope("MiddleClass.InnerMostClass", inferredType);
      this.assertNotInScope("OuterClass", inferredType);
      this.assertNotInScope("PrivateMiddleClass", inferredType);
      EList<XtendMember> _members = xtendClass.getMembers();
      final XtendMember method = _members.get(0);
      final JvmOperation operation = this.associations.getDirectlyInferredOperation(((XtendFunction) method));
      this.assertTypeInScope("Foo", operation);
      this.assertTypeInScope("MiddleClass", operation);
      this.assertNotInScope("MiddleClass.InnerMostClass", operation);
      this.assertNotInScope("OuterClass", inferredType);
      this.assertNotInScope("PrivateMiddleClass", inferredType);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInheritMiddle_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import types.OuterClass");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo extends OuterClass$MiddleClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendClass xtendClass = this.clazz(_builder.toString());
      final JvmGenericType inferredType = this.associations.getInferredType(xtendClass);
      this.assertTypeInScope("Foo", inferredType);
      this.assertTypeInScope("InnerMostClass", inferredType);
      this.assertNotInScope("OuterClass.MiddleClass", inferredType);
      this.assertNotInScope("MiddleClass", inferredType);
      this.assertNotInScope("OuterClass", inferredType);
      this.assertNotInScope("PrivateMiddleClass", inferredType);
      EList<XtendMember> _members = xtendClass.getMembers();
      final XtendMember method = _members.get(0);
      final JvmOperation operation = this.associations.getDirectlyInferredOperation(((XtendFunction) method));
      this.assertTypeInScope("Foo", operation);
      this.assertTypeInScope("InnerMostClass", operation);
      this.assertNotInScope("OuterClass.MiddleClass", operation);
      this.assertNotInScope("MiddleClass", operation);
      this.assertNotInScope("OuterClass", operation);
      this.assertNotInScope("PrivateMiddleClass", inferredType);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInheritMiddle_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import types.OuterClass");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo extends OuterClass.MiddleClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendClass xtendClass = this.clazz(_builder.toString());
      final JvmGenericType inferredType = this.associations.getInferredType(xtendClass);
      this.assertTypeInScope("Foo", inferredType);
      this.assertTypeInScope("InnerMostClass", inferredType);
      this.assertNotInScope("OuterClass.MiddleClass", inferredType);
      this.assertNotInScope("MiddleClass", inferredType);
      this.assertNotInScope("OuterClass", inferredType);
      this.assertNotInScope("PrivateMiddleClass", inferredType);
      EList<XtendMember> _members = xtendClass.getMembers();
      final XtendMember method = _members.get(0);
      final JvmOperation operation = this.associations.getDirectlyInferredOperation(((XtendFunction) method));
      this.assertTypeInScope("Foo", operation);
      this.assertTypeInScope("InnerMostClass", operation);
      this.assertNotInScope("OuterClass.MiddleClass", operation);
      this.assertNotInScope("MiddleClass", operation);
      this.assertNotInScope("OuterClass", operation);
      this.assertNotInScope("PrivateMiddleClass", inferredType);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInheritOuterTypeParam() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import types.OuterClass");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo<MiddleClass, T> extends OuterClass<String> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <MiddleClass> foo() ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendClass xtendClass = this.clazz(_builder.toString());
      final JvmGenericType inferredType = this.associations.getInferredType(xtendClass);
      this.assertTypeInScope("Foo", inferredType);
      this.assertTypeInScope("MiddleClass", inferredType);
      this.assertNotInScope("MiddleClass.InnerMostClass", inferredType);
      this.assertTypeParameterInScope("T", inferredType);
      this.assertNotInScope("OuterClass", inferredType);
      EList<XtendMember> _members = xtendClass.getMembers();
      final XtendMember method = _members.get(0);
      final JvmOperation operation = this.associations.getDirectlyInferredOperation(((XtendFunction) method));
      this.assertTypeInScope("Foo", operation);
      this.assertTypeParameterInScope("MiddleClass", operation);
      this.assertTypeParameterInScope("T", operation);
      this.assertNotInScope("MiddleClass.InnerMostClass", operation);
      this.assertNotInScope("OuterClass", operation);
      EList<XtendMember> _members_1 = xtendClass.getMembers();
      final XtendMember method2 = _members_1.get(0);
      final JvmOperation operation2 = this.associations.getDirectlyInferredOperation(((XtendFunction) method2));
      this.assertTypeInScope("Foo", operation2);
      this.assertTypeParameterInScope("MiddleClass", operation2);
      this.assertTypeParameterInScope("T", operation2);
      this.assertNotInScope("MiddleClass.InnerMostClass", operation2);
      this.assertNotInScope("OuterClass", operation2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInheritMiddleParam_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import types.OuterClass");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo<InnerMostClass, T> extends OuterClass$MiddleClass<String> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <InnerMostClass> foo() ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendClass xtendClass = this.clazz(_builder.toString());
      final JvmGenericType inferredType = this.associations.getInferredType(xtendClass);
      this.assertTypeInScope("Foo", inferredType);
      this.assertTypeInScope("InnerMostClass", inferredType);
      this.assertTypeParameterInScope("T", inferredType);
      this.assertNotInScope("OuterClass.MiddleClass", inferredType);
      this.assertNotInScope("MiddleClass", inferredType);
      this.assertNotInScope("OuterClass", inferredType);
      EList<XtendMember> _members = xtendClass.getMembers();
      final XtendMember method = _members.get(0);
      final JvmOperation operation = this.associations.getDirectlyInferredOperation(((XtendFunction) method));
      this.assertTypeInScope("Foo", operation);
      this.assertTypeParameterInScope("InnerMostClass", operation);
      this.assertTypeParameterInScope("T", operation);
      this.assertNotInScope("OuterClass.MiddleClass", operation);
      this.assertNotInScope("MiddleClass", operation);
      this.assertNotInScope("OuterClass", operation);
      EList<XtendMember> _members_1 = xtendClass.getMembers();
      final XtendMember method2 = _members_1.get(0);
      final JvmOperation operation2 = this.associations.getDirectlyInferredOperation(((XtendFunction) method2));
      this.assertTypeInScope("Foo", operation2);
      this.assertTypeInScope("InnerMostClass", operation2);
      this.assertTypeParameterInScope("T", operation2);
      this.assertNotInScope("OuterClass.MiddleClass", operation2);
      this.assertNotInScope("MiddleClass", operation2);
      this.assertNotInScope("OuterClass", operation2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInheritMiddleParam_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import types.OuterClass");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo<InnerMostClass, T> extends OuterClass.MiddleClass<String> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <InnerMostClass> foo() ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendClass xtendClass = this.clazz(_builder.toString());
      final JvmGenericType inferredType = this.associations.getInferredType(xtendClass);
      this.assertTypeInScope("Foo", inferredType);
      this.assertTypeInScope("InnerMostClass", inferredType);
      this.assertTypeParameterInScope("T", inferredType);
      this.assertNotInScope("OuterClass.MiddleClass", inferredType);
      this.assertNotInScope("MiddleClass", inferredType);
      this.assertNotInScope("OuterClass", inferredType);
      EList<XtendMember> _members = xtendClass.getMembers();
      final XtendMember method = _members.get(0);
      final JvmOperation operation = this.associations.getDirectlyInferredOperation(((XtendFunction) method));
      this.assertTypeInScope("Foo", operation);
      this.assertTypeParameterInScope("InnerMostClass", operation);
      this.assertTypeParameterInScope("T", operation);
      this.assertNotInScope("OuterClass.MiddleClass", operation);
      this.assertNotInScope("MiddleClass", operation);
      this.assertNotInScope("OuterClass", operation);
      EList<XtendMember> _members_1 = xtendClass.getMembers();
      final XtendMember method2 = _members_1.get(0);
      final JvmOperation operation2 = this.associations.getDirectlyInferredOperation(((XtendFunction) method2));
      this.assertTypeInScope("Foo", operation2);
      this.assertTypeInScope("InnerMostClass", operation2);
      this.assertTypeParameterInScope("T", operation2);
      this.assertNotInScope("OuterClass.MiddleClass", operation2);
      this.assertNotInScope("MiddleClass", operation2);
      this.assertNotInScope("OuterClass", operation2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void assertTypeInScope(final String typeName, final JvmMember context) {
    final JvmIdentifiableElement visibleType = this.typesFromHierarchy.getVisibleType(context, typeName);
    Assert.assertNotNull(visibleType);
    Assert.assertTrue((visibleType instanceof JvmType));
  }
  
  protected void assertTypeParameterInScope(final String typeName, final JvmMember context) {
    final JvmIdentifiableElement visibleType = this.typesFromHierarchy.getVisibleType(context, typeName);
    Assert.assertNotNull(visibleType);
    Assert.assertTrue((visibleType instanceof JvmTypeParameter));
  }
  
  protected void assertNotInScope(final String typeName, final JvmMember context) {
    final JvmIdentifiableElement visibleType = this.typesFromHierarchy.getVisibleType(context, typeName);
    Assert.assertNull(visibleType);
  }
}
