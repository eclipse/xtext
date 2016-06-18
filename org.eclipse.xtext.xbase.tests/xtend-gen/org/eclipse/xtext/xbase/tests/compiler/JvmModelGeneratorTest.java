/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.compiler;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import foo.TestAnnotation;
import foo.TestAnnotation2;
import foo.TestAnnotations;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.AbstractList;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.TemporaryFolder;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler2;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelCompleter;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseWithLogicalContainerInjectorProvider;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(XbaseWithLogicalContainerInjectorProvider.class)
@SuppressWarnings("all")
public class JvmModelGeneratorTest extends AbstractXbaseTestCase {
  @Rule
  @Inject
  public TemporaryFolder temporaryFolder;
  
  @Inject
  @Extension
  private JvmTypesBuilder builder;
  
  @Inject
  private TypeReferences references;
  
  @Inject
  private ValidationTestHelper helper;
  
  @Inject
  private JvmModelGenerator generator;
  
  @Inject
  private OnTheFlyJavaCompiler2 javaCompiler;
  
  @Inject
  private TypesFactory typesFactory;
  
  @Inject
  private JvmModelCompleter completer;
  
  @Test
  public void bug390290InnerClassMemberImport() {
    try {
      final XExpression expression = this.expression("null");
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        final JvmGenericType innerClass = this.builder.toClass(it, "InnerClass");
        final JvmGenericType innerClassString = this.builder.toClass(it, "String");
        EList<JvmMember> _members = it.getMembers();
        this.builder.<JvmGenericType>operator_add(_members, innerClass);
        EList<JvmMember> _members_1 = it.getMembers();
        this.builder.<JvmGenericType>operator_add(_members_1, innerClassString);
        EList<JvmMember> _members_2 = it.getMembers();
        JvmTypeReference _typeForName = this.references.getTypeForName(String.class, expression);
        final Procedure1<JvmOperation> _function_1 = (JvmOperation fooMethod) -> {
          EList<JvmFormalParameter> _parameters = fooMethod.getParameters();
          JvmParameterizedTypeReference _createTypeRef = this.references.createTypeRef(innerClass);
          JvmFormalParameter _parameter = this.builder.toParameter(it, "p1", _createTypeRef);
          this.builder.<JvmFormalParameter>operator_add(_parameters, _parameter);
          EList<JvmFormalParameter> _parameters_1 = fooMethod.getParameters();
          JvmParameterizedTypeReference _createTypeRef_1 = this.references.createTypeRef(innerClassString);
          JvmFormalParameter _parameter_1 = this.builder.toParameter(it, "p2", _createTypeRef_1);
          this.builder.<JvmFormalParameter>operator_add(_parameters_1, _parameter_1);
          this.builder.setBody(fooMethod, expression);
        };
        JvmOperation _method = this.builder.toMethod(it, "foo", _typeForName, _function_1);
        this.builder.<JvmOperation>operator_add(_members_2, _method);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Outer", _function);
      Resource _eResource = expression.eResource();
      _eResource.eSetDeliver(false);
      Resource _eResource_1 = expression.eResource();
      EList<EObject> _contents = _eResource_1.getContents();
      this.builder.<JvmGenericType>operator_add(_contents, clazz);
      Resource _eResource_2 = expression.eResource();
      _eResource_2.eSetDeliver(true);
      final InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
      Resource _eResource_3 = expression.eResource();
      this.generator.doGenerate(_eResource_3, fsa);
      Map<String, CharSequence> _files = fsa.getFiles();
      String _identifier = clazz.getIdentifier();
      String _replace = _identifier.replace(".", "/");
      String _plus = (IFileSystemAccess.DEFAULT_OUTPUT + _replace);
      String _plus_1 = (_plus + ".java");
      CharSequence _get = _files.get(_plus_1);
      final String code = _get.toString();
      boolean _contains = code.contains("import");
      Assert.assertFalse(_contains);
      boolean _contains_1 = code.contains("java.lang.String foo");
      Assert.assertTrue(code, _contains_1);
      String _identifier_1 = clazz.getIdentifier();
      final Class<?> compiledClass = this.javaCompiler.compileToClass(_identifier_1, code);
      Resource _eResource_4 = expression.eResource();
      EList<EObject> _contents_1 = _eResource_4.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents_1);
      this.helper.assertNoErrors(_head);
      Class<?>[] _declaredClasses = compiledClass.getDeclaredClasses();
      int _size = ((List<Class<?>>)Conversions.doWrapArray(_declaredClasses)).size();
      Assert.assertEquals(2, _size);
      Class<?>[] _declaredClasses_1 = compiledClass.getDeclaredClasses();
      Class<?> _head_1 = IterableExtensions.<Class<?>>head(((Iterable<Class<?>>)Conversions.doWrapArray(_declaredClasses_1)));
      Class<?>[] _declaredClasses_2 = compiledClass.getDeclaredClasses();
      Class<?> _last = IterableExtensions.<Class<?>>last(((Iterable<Class<?>>)Conversions.doWrapArray(_declaredClasses_2)));
      Method _method = compiledClass.getMethod("foo", _head_1, _last);
      Assert.assertNotNull(_method);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSimple() {
    try {
      final XExpression expression = this.expression("return s.toUpperCase", false);
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        JvmTypeReference _typeForName = this.references.getTypeForName(String.class, expression);
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          JvmTypeReference _typeForName_1 = this.references.getTypeForName(String.class, expression);
          JvmFormalParameter _parameter = this.builder.toParameter(expression, "s", _typeForName_1);
          this.builder.<JvmFormalParameter>operator_add(_parameters, _parameter);
          this.builder.setBody(it_1, expression);
        };
        JvmOperation _method = this.builder.toMethod(expression, "doStuff", _typeForName, _function_1);
        this.builder.<JvmOperation>operator_add(_members, _method);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiledClass = this.compile(_eResource, clazz);
      final Object instance = compiledClass.newInstance();
      Method _method = compiledClass.getMethod("doStuff", String.class);
      Object _invoke = _method.invoke(instance, "foo");
      Assert.assertEquals("FOO", _invoke);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAnnotation_1() {
    try {
      final XExpression expression = this.expression("42", false);
      final Procedure1<JvmAnnotationType> _function = (JvmAnnotationType it) -> {
        EList<JvmMember> _members = it.getMembers();
        JvmTypeReference _typeForName = this.references.getTypeForName(int.class, expression);
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          this.builder.setBody(it_1, expression);
        };
        JvmOperation _method = this.builder.toMethod(expression, "theTruth", _typeForName, _function_1);
        this.builder.<JvmOperation>operator_add(_members, _method);
      };
      final JvmAnnotationType clazz = this.builder.toAnnotationType(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiledClass = this.compile(_eResource, clazz);
      boolean _isAnnotation = compiledClass.isAnnotation();
      Assert.assertTrue(_isAnnotation);
      Method[] _methods = compiledClass.getMethods();
      final Method method = IterableExtensions.<Method>head(((Iterable<Method>)Conversions.doWrapArray(_methods)));
      String _name = method.getName();
      Assert.assertEquals("theTruth", _name);
      Object _defaultValue = method.getDefaultValue();
      Assert.assertEquals(Integer.valueOf(42), _defaultValue);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAnnotation_2() {
    try {
      final XExpression expression = this.expression("typeof(String)", false);
      final Procedure1<JvmAnnotationType> _function = (JvmAnnotationType it) -> {
        EList<JvmMember> _members = it.getMembers();
        JvmWildcardTypeReference _wildCard = this.references.wildCard();
        JvmTypeReference _typeForName = this.references.getTypeForName(Class.class, expression, _wildCard);
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          this.builder.setBody(it_1, expression);
        };
        JvmOperation _method = this.builder.toMethod(expression, "value", _typeForName, _function_1);
        this.builder.<JvmOperation>operator_add(_members, _method);
        EList<JvmMember> _members_1 = it.getMembers();
        JvmTypeReference _typeForName_1 = this.references.getTypeForName(int.class, expression);
        final Procedure1<JvmOperation> _function_2 = (JvmOperation it_1) -> {
        };
        JvmOperation _method_1 = this.builder.toMethod(expression, "otherValue", _typeForName_1, _function_2);
        this.builder.<JvmOperation>operator_add(_members_1, _method_1);
      };
      final JvmAnnotationType clazz = this.builder.toAnnotationType(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiledClass = this.compile(_eResource, clazz);
      boolean _isAnnotation = compiledClass.isAnnotation();
      Assert.assertTrue(_isAnnotation);
      Method[] _methods = compiledClass.getMethods();
      final Function1<Method, Boolean> _function_1 = (Method it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, "value"));
      };
      Method _findFirst = IterableExtensions.<Method>findFirst(((Iterable<Method>)Conversions.doWrapArray(_methods)), _function_1);
      Object _defaultValue = _findFirst.getDefaultValue();
      Assert.assertEquals(String.class, _defaultValue);
      Method[] _methods_1 = compiledClass.getMethods();
      final Function1<Method, Boolean> _function_2 = (Method it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, "otherValue"));
      };
      Method _findFirst_1 = IterableExtensions.<Method>findFirst(((Iterable<Method>)Conversions.doWrapArray(_methods_1)), _function_2);
      Object _defaultValue_1 = _findFirst_1.getDefaultValue();
      Assert.assertNull(_defaultValue_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testImplements() {
    try {
      final XExpression expression = this.expression("null", false);
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        it.setAbstract(true);
        EList<JvmTypeReference> _superTypes = it.getSuperTypes();
        JvmTypeReference _typeRef = this.typeRef(expression, Iterable.class, String.class);
        this.builder.<JvmTypeReference>operator_add(_superTypes, _typeRef);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiled = this.compile(_eResource, clazz);
      boolean _isAssignableFrom = Iterable.class.isAssignableFrom(compiled);
      Assert.assertTrue(_isAssignableFrom);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testExtends() {
    try {
      final XExpression expression = this.expression("null", false);
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        it.setAbstract(true);
        EList<JvmTypeReference> _superTypes = it.getSuperTypes();
        JvmTypeReference _typeRef = this.typeRef(expression, AbstractList.class, String.class);
        this.builder.<JvmTypeReference>operator_add(_superTypes, _typeRef);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiled = this.compile(_eResource, clazz);
      boolean _isAssignableFrom = Iterable.class.isAssignableFrom(compiled);
      Assert.assertTrue(_isAssignableFrom);
      boolean _isAssignableFrom_1 = AbstractList.class.isAssignableFrom(compiled);
      Assert.assertTrue(_isAssignableFrom_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCompilationStrategy() {
    try {
      final XExpression expression = this.expression("null", false);
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        JvmTypeReference _typeRef = this.typeRef(expression, String.class);
        JvmField _field = this.builder.toField(expression, "x", _typeRef);
        this.builder.<JvmField>operator_add(_members, _field);
        EList<JvmMember> _members_1 = it.getMembers();
        JvmTypeReference _typeRef_1 = this.typeRef(expression, String.class);
        JvmOperation _getter = this.builder.toGetter(expression, "x", _typeRef_1);
        this.builder.<JvmOperation>operator_add(_members_1, _getter);
        EList<JvmMember> _members_2 = it.getMembers();
        JvmTypeReference _typeRef_2 = this.typeRef(expression, String.class);
        JvmOperation _setter = this.builder.toSetter(expression, "x", _typeRef_2);
        this.builder.<JvmOperation>operator_add(_members_2, _setter);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiled = this.compile(_eResource, clazz);
      final Object inst = compiled.newInstance();
      final Method getter = compiled.getMethod("getX");
      final Method setter = compiled.getMethod("setX", String.class);
      setter.invoke(inst, "FOO");
      Object _invoke = getter.invoke(inst);
      Assert.assertEquals("FOO", _invoke);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnumeration() {
    try {
      final XExpression expression = this.expression("null", false);
      final Procedure1<JvmEnumerationType> _function = (JvmEnumerationType it) -> {
        EList<JvmMember> _members = it.getMembers();
        final Procedure1<JvmEnumerationLiteral> _function_1 = (JvmEnumerationLiteral literal) -> {
          JvmParameterizedTypeReference _createTypeRef = this.references.createTypeRef(it);
          literal.setType(_createTypeRef);
        };
        JvmEnumerationLiteral _enumerationLiteral = this.builder.toEnumerationLiteral(expression, "BAR", _function_1);
        this.builder.<JvmEnumerationLiteral>operator_add(_members, _enumerationLiteral);
        EList<JvmMember> _members_1 = it.getMembers();
        final Procedure1<JvmEnumerationLiteral> _function_2 = (JvmEnumerationLiteral literal) -> {
          JvmParameterizedTypeReference _createTypeRef = this.references.createTypeRef(it);
          literal.setType(_createTypeRef);
        };
        JvmEnumerationLiteral _enumerationLiteral_1 = this.builder.toEnumerationLiteral(expression, "BAZ", _function_2);
        this.builder.<JvmEnumerationLiteral>operator_add(_members_1, _enumerationLiteral_1);
      };
      final JvmEnumerationType enumeration = this.builder.toEnumerationType(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiled = this.compile(_eResource, enumeration);
      final Method valuesMethod = compiled.getMethod("values");
      Object _invoke = valuesMethod.invoke(null);
      final Object[] values = ((Object[]) _invoke);
      Object _get = values[0];
      String _string = _get.toString();
      Assert.assertEquals("BAR", _string);
      Object _get_1 = values[1];
      String _string_1 = _get_1.toString();
      Assert.assertEquals("BAZ", _string_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnumeration2() {
    try {
      final XExpression expression = this.expression("null", false);
      JvmEnumerationType _enumerationType = this.builder.toEnumerationType(expression, "my.test.Foo");
      final Procedure1<JvmEnumerationType> _function = (JvmEnumerationType it) -> {
        EList<JvmMember> _members = it.getMembers();
        final Procedure1<JvmEnumerationLiteral> _function_1 = (JvmEnumerationLiteral literal) -> {
          JvmParameterizedTypeReference _createTypeRef = this.references.createTypeRef(it);
          literal.setType(_createTypeRef);
        };
        JvmEnumerationLiteral _enumerationLiteral = this.builder.toEnumerationLiteral(expression, "BAR", _function_1);
        this.builder.<JvmEnumerationLiteral>operator_add(_members, _enumerationLiteral);
        EList<JvmMember> _members_1 = it.getMembers();
        final Procedure1<JvmEnumerationLiteral> _function_2 = (JvmEnumerationLiteral literal) -> {
          JvmParameterizedTypeReference _createTypeRef = this.references.createTypeRef(it);
          literal.setType(_createTypeRef);
        };
        JvmEnumerationLiteral _enumerationLiteral_1 = this.builder.toEnumerationLiteral(expression, "BAZ", _function_2);
        this.builder.<JvmEnumerationLiteral>operator_add(_members_1, _enumerationLiteral_1);
      };
      final JvmEnumerationType enumeration = ObjectExtensions.<JvmEnumerationType>operator_doubleArrow(_enumerationType, _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiled = this.compile(_eResource, enumeration);
      final Method valuesMethod = compiled.getMethod("values");
      Object _invoke = valuesMethod.invoke(null);
      final Object[] values = ((Object[]) _invoke);
      Object _get = values[0];
      String _string = _get.toString();
      Assert.assertEquals("BAR", _string);
      Object _get_1 = values[1];
      String _string_1 = _get_1.toString();
      Assert.assertEquals("BAZ", _string_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnumerationWithCompleter() {
    try {
      final XExpression expression = this.expression("null", false);
      final Procedure1<JvmEnumerationType> _function = (JvmEnumerationType it) -> {
        EList<JvmMember> _members = it.getMembers();
        JvmEnumerationLiteral _enumerationLiteral = this.builder.toEnumerationLiteral(expression, "BAR");
        this.builder.<JvmEnumerationLiteral>operator_add(_members, _enumerationLiteral);
        EList<JvmMember> _members_1 = it.getMembers();
        JvmEnumerationLiteral _enumerationLiteral_1 = this.builder.toEnumerationLiteral(expression, "BAZ");
        this.builder.<JvmEnumerationLiteral>operator_add(_members_1, _enumerationLiteral_1);
      };
      final JvmEnumerationType enumeration = this.builder.toEnumerationType(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      EList<EObject> _contents = _eResource.getContents();
      _contents.add(enumeration);
      this.completer.complete(enumeration);
      Resource _eResource_1 = expression.eResource();
      final Class<?> compiled = this.compile(_eResource_1, enumeration);
      final Method valuesMethod = compiled.getMethod("values");
      Object _invoke = valuesMethod.invoke(null);
      final Object[] values = ((Object[]) _invoke);
      Object _get = values[0];
      String _string = _get.toString();
      Assert.assertEquals("BAR", _string);
      Object _get_1 = values[1];
      String _string_1 = _get_1.toString();
      Assert.assertEquals("BAZ", _string_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug377925No_Nullpointer() {
    try {
      final XExpression expression = this.expression("[Object o| null]");
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        JvmTypeReference _typeForName = this.references.getTypeForName("java.lang.Object", expression);
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          this.builder.setBody(it_1, expression);
        };
        JvmOperation _method = this.builder.toMethod(expression, "doStuff", _typeForName, _function_1);
        this.builder.<JvmOperation>operator_add(_members, _method);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      this.compile(_eResource, clazz);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug380754() {
    try {
      final XExpression expression = this.expression("null");
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        JvmTypeReference _typeForName = this.references.getTypeForName("java.lang.Object", expression);
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          this.builder.setBody(it_1, expression);
          final JvmAnnotationReference annotation = this.builder.toAnnotation(expression, TestAnnotations.class);
          final JvmAnnotationAnnotationValue annotationAnnotationValue = this.typesFactory.createJvmAnnotationAnnotationValue();
          EList<JvmAnnotationReference> _values = annotationAnnotationValue.getValues();
          JvmAnnotationReference _annotation = this.builder.toAnnotation(expression, TestAnnotation.class);
          this.builder.<JvmAnnotationReference>operator_add(_values, _annotation);
          EList<JvmAnnotationReference> _values_1 = annotationAnnotationValue.getValues();
          JvmAnnotationReference _annotation_1 = this.builder.toAnnotation(expression, TestAnnotation.class);
          this.builder.<JvmAnnotationReference>operator_add(_values_1, _annotation_1);
          EList<JvmAnnotationReference> _values_2 = annotationAnnotationValue.getValues();
          JvmAnnotationReference _annotation_2 = this.builder.toAnnotation(expression, TestAnnotation.class);
          this.builder.<JvmAnnotationReference>operator_add(_values_2, _annotation_2);
          EList<JvmAnnotationValue> _explicitValues = annotation.getExplicitValues();
          this.builder.<JvmAnnotationAnnotationValue>operator_add(_explicitValues, annotationAnnotationValue);
          EList<JvmAnnotationReference> _annotations = it_1.getAnnotations();
          this.builder.<JvmAnnotationReference>operator_add(_annotations, annotation);
        };
        JvmOperation _method = this.builder.toMethod(expression, "doStuff", _typeForName, _function_1);
        this.builder.<JvmOperation>operator_add(_members, _method);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      this.compile(_eResource, clazz);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug380754_2() {
    try {
      final XExpression expression = this.expression("null");
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        JvmTypeReference _typeForName = this.references.getTypeForName("java.lang.Object", expression);
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          this.builder.setBody(it_1, expression);
          JvmTypeReference _typeForName_1 = this.references.getTypeForName(String.class, expression);
          final JvmFormalParameter parameter = this.builder.toParameter(expression, "s", _typeForName_1);
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          this.builder.<JvmFormalParameter>operator_add(_parameters, parameter);
          EList<JvmAnnotationReference> _annotations = parameter.getAnnotations();
          JvmAnnotationReference _annotation = this.builder.toAnnotation(expression, TestAnnotation.class);
          this.builder.<JvmAnnotationReference>operator_add(_annotations, _annotation);
          EList<JvmAnnotationReference> _annotations_1 = parameter.getAnnotations();
          JvmAnnotationReference _annotation_1 = this.builder.toAnnotation(expression, TestAnnotation2.class);
          this.builder.<JvmAnnotationReference>operator_add(_annotations_1, _annotation_1);
        };
        JvmOperation _method = this.builder.toMethod(expression, "doStuff", _typeForName, _function_1);
        this.builder.<JvmOperation>operator_add(_members, _method);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      this.compile(_eResource, clazz);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug419430() {
    try {
      final XExpression expression = this.expression("null");
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        JvmTypeReference _typeForName = this.references.getTypeForName("java.lang.Object", expression);
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          this.builder.setBody(it_1, expression);
          final JvmAnnotationReference annotation = this.builder.toAnnotation(expression, TestAnnotations.class);
          final JvmAnnotationAnnotationValue annotationAnnotationValue = this.typesFactory.createJvmAnnotationAnnotationValue();
          EList<JvmAnnotationReference> _values = annotationAnnotationValue.getValues();
          JvmAnnotationReference _annotation = this.builder.toAnnotation(expression, TestAnnotation.class);
          this.builder.<JvmAnnotationReference>operator_add(_values, _annotation);
          EList<JvmAnnotationReference> _values_1 = annotationAnnotationValue.getValues();
          JvmAnnotationReference _annotation_1 = this.builder.toAnnotation(expression, TestAnnotation.class);
          this.builder.<JvmAnnotationReference>operator_add(_values_1, _annotation_1);
          EList<JvmAnnotationReference> _values_2 = annotationAnnotationValue.getValues();
          JvmAnnotationReference _annotation_2 = this.builder.toAnnotation(expression, TestAnnotation.class);
          this.builder.<JvmAnnotationReference>operator_add(_values_2, _annotation_2);
          EList<JvmAnnotationValue> _explicitValues = annotation.getExplicitValues();
          this.builder.<JvmAnnotationAnnotationValue>operator_add(_explicitValues, annotationAnnotationValue);
          EList<JvmAnnotationReference> _annotations = it_1.getAnnotations();
          this.builder.<JvmAnnotationReference>operator_add(_annotations, annotation);
        };
        JvmOperation _method = this.builder.toMethod(expression, "doStuff", _typeForName, _function_1);
        this.builder.<JvmOperation>operator_add(_members, _method);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      final String code = this.generate(_eResource, clazz);
      boolean _contains = code.contains("@TestAnnotations({ @TestAnnotation, @TestAnnotation, @TestAnnotation })");
      Assert.assertTrue(code, _contains);
      Resource _eResource_1 = expression.eResource();
      final Class<?> compiledClazz = this.compileToClass(_eResource_1, clazz, code);
      final Method method = compiledClazz.getMethod("doStuff");
      final TestAnnotations methodAnnotation = method.<TestAnnotations>getAnnotation(TestAnnotations.class);
      TestAnnotation[] _value = methodAnnotation.value();
      int _size = ((List<TestAnnotation>)Conversions.doWrapArray(_value)).size();
      Assert.assertEquals(3, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug377002() {
    try {
      final XExpression expression = this.expression("null");
      final Procedure1<JvmEnumerationType> _function = (JvmEnumerationType it) -> {
        EList<JvmMember> _members = it.getMembers();
        final Procedure1<JvmEnumerationLiteral> _function_1 = (JvmEnumerationLiteral literal) -> {
          JvmParameterizedTypeReference _createTypeRef = this.references.createTypeRef(it);
          literal.setType(_createTypeRef);
        };
        JvmEnumerationLiteral _enumerationLiteral = this.builder.toEnumerationLiteral(expression, "WARN", _function_1);
        this.builder.<JvmEnumerationLiteral>operator_add(_members, _enumerationLiteral);
        EList<JvmMember> _members_1 = it.getMembers();
        final Procedure1<JvmEnumerationLiteral> _function_2 = (JvmEnumerationLiteral literal) -> {
          JvmParameterizedTypeReference _createTypeRef = this.references.createTypeRef(it);
          literal.setType(_createTypeRef);
        };
        JvmEnumerationLiteral _enumerationLiteral_1 = this.builder.toEnumerationLiteral(expression, "ERROR", _function_2);
        this.builder.<JvmEnumerationLiteral>operator_add(_members_1, _enumerationLiteral_1);
        EList<JvmMember> _members_2 = it.getMembers();
        final Procedure1<JvmEnumerationLiteral> _function_3 = (JvmEnumerationLiteral literal) -> {
          JvmParameterizedTypeReference _createTypeRef = this.references.createTypeRef(it);
          literal.setType(_createTypeRef);
        };
        JvmEnumerationLiteral _enumerationLiteral_2 = this.builder.toEnumerationLiteral(expression, "DEBUG", _function_3);
        this.builder.<JvmEnumerationLiteral>operator_add(_members_2, _enumerationLiteral_2);
        EList<JvmMember> _members_3 = it.getMembers();
        JvmTypeReference _typeForName = this.references.getTypeForName("java.lang.Object", expression);
        final Procedure1<JvmOperation> _function_4 = (JvmOperation it_1) -> {
          this.builder.setBody(it_1, expression);
        };
        JvmOperation _method = this.builder.toMethod(expression, "doStuff", _typeForName, _function_4);
        this.builder.<JvmOperation>operator_add(_members_3, _method);
      };
      final JvmEnumerationType clazz = this.builder.toEnumerationType(expression, "my.test.Level", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiled = this.compile(_eResource, clazz);
      Field _field = compiled.getField("WARN");
      Assert.assertNotNull(_field);
      Field _field_1 = compiled.getField("ERROR");
      Assert.assertNotNull(_field_1);
      Field _field_2 = compiled.getField("DEBUG");
      Assert.assertNotNull(_field_2);
      Method _method = compiled.getMethod("doStuff");
      Assert.assertNotNull(_method);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug426442_EnclosingClassMethodCall() {
    try {
      final XExpression expression = this.expression("enclosingClassMethod", false);
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        JvmTypeReference _typeForName = this.references.getTypeForName(String.class, expression);
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          final Procedure1<ITreeAppendable> _function_2 = (ITreeAppendable it_2) -> {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("return \"enclosingClassMethodResult\";");
            it_2.append(_builder);
          };
          this.builder.setBody(it_1, _function_2);
        };
        JvmOperation _method = this.builder.toMethod(expression, "enclosingClassMethod", _typeForName, _function_1);
        this.builder.<JvmOperation>operator_add(_members, _method);
        EList<JvmMember> _members_1 = it.getMembers();
        String _qualifiedName = it.getQualifiedName();
        String _plus = (_qualifiedName + ".InnerClass");
        final Procedure1<JvmGenericType> _function_2 = (JvmGenericType it_1) -> {
          EList<JvmMember> _members_2 = it_1.getMembers();
          JvmTypeReference _typeForName_1 = this.references.getTypeForName(String.class, expression);
          final Procedure1<JvmOperation> _function_3 = (JvmOperation it_2) -> {
            this.builder.setBody(it_2, expression);
          };
          JvmOperation _method_1 = this.builder.toMethod(expression, "enclosingClassMethodCall", _typeForName_1, _function_3);
          this.builder.<JvmOperation>operator_add(_members_2, _method_1);
        };
        JvmGenericType _class = this.builder.toClass(expression, _plus, _function_2);
        this.builder.<JvmGenericType>operator_add(_members_1, _class);
      };
      final JvmGenericType enclosingClass = this.builder.toClass(expression, "my.test.EnclosingClass", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiledEnclosingClass = this.compile(_eResource, enclosingClass);
      Assert.assertNotNull(compiledEnclosingClass);
      Class<?>[] _declaredClasses = compiledEnclosingClass.getDeclaredClasses();
      final Function1<Class<?>, Boolean> _function_1 = (Class<?> it) -> {
        String _simpleName = it.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, "InnerClass"));
      };
      final Class<?> compiledInnerClass = IterableExtensions.<Class<?>>findFirst(((Iterable<Class<?>>)Conversions.doWrapArray(_declaredClasses)), _function_1);
      Assert.assertNotNull(compiledInnerClass);
      final Object enclosingClassInstance = compiledEnclosingClass.newInstance();
      Assert.assertNotNull(enclosingClassInstance);
      final Constructor<?> innerClassConstructor = compiledInnerClass.getDeclaredConstructor(compiledEnclosingClass);
      Assert.assertNotNull(innerClassConstructor);
      final Object innerClassInstance = innerClassConstructor.newInstance(enclosingClassInstance);
      Assert.assertNotNull(innerClassInstance);
      final Method enclosingClassMethodCallMethod = compiledInnerClass.getMethod("enclosingClassMethodCall");
      Assert.assertNotNull(enclosingClassMethodCallMethod);
      final Object invocationResult = enclosingClassMethodCallMethod.invoke(innerClassInstance);
      Assert.assertNotNull(invocationResult);
      Assert.assertEquals("enclosingClassMethodResult", invocationResult);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug426442_InnerClassLocalMethodCall() {
    try {
      final XExpression expression = this.expression("innerClassMethod", false);
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        String _qualifiedName = it.getQualifiedName();
        String _plus = (_qualifiedName + ".InnerClass");
        final Procedure1<JvmGenericType> _function_1 = (JvmGenericType it_1) -> {
          EList<JvmMember> _members_1 = it_1.getMembers();
          JvmTypeReference _typeForName = this.references.getTypeForName(String.class, expression);
          final Procedure1<JvmOperation> _function_2 = (JvmOperation it_2) -> {
            final Procedure1<ITreeAppendable> _function_3 = (ITreeAppendable it_3) -> {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("return \"innerClassMethodResult\";");
              it_3.append(_builder);
            };
            this.builder.setBody(it_2, _function_3);
          };
          JvmOperation _method = this.builder.toMethod(expression, "innerClassMethod", _typeForName, _function_2);
          this.builder.<JvmOperation>operator_add(_members_1, _method);
          EList<JvmMember> _members_2 = it_1.getMembers();
          JvmTypeReference _typeForName_1 = this.references.getTypeForName(String.class, expression);
          final Procedure1<JvmOperation> _function_3 = (JvmOperation it_2) -> {
            this.builder.setBody(it_2, expression);
          };
          JvmOperation _method_1 = this.builder.toMethod(expression, "innerClassMethodCall", _typeForName_1, _function_3);
          this.builder.<JvmOperation>operator_add(_members_2, _method_1);
        };
        JvmGenericType _class = this.builder.toClass(expression, _plus, _function_1);
        this.builder.<JvmGenericType>operator_add(_members, _class);
      };
      final JvmGenericType enclosingClass = this.builder.toClass(expression, "my.test.EnclosingClass", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiledEnclosingClass = this.compile(_eResource, enclosingClass);
      Assert.assertNotNull(compiledEnclosingClass);
      Class<?>[] _declaredClasses = compiledEnclosingClass.getDeclaredClasses();
      final Function1<Class<?>, Boolean> _function_1 = (Class<?> it) -> {
        String _simpleName = it.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, "InnerClass"));
      };
      final Class<?> compiledInnerClass = IterableExtensions.<Class<?>>findFirst(((Iterable<Class<?>>)Conversions.doWrapArray(_declaredClasses)), _function_1);
      Assert.assertNotNull(compiledInnerClass);
      final Object enclosingClassInstance = compiledEnclosingClass.newInstance();
      Assert.assertNotNull(enclosingClassInstance);
      final Constructor<?> innerClassConstructor = compiledInnerClass.getDeclaredConstructor(compiledEnclosingClass);
      Assert.assertNotNull(innerClassConstructor);
      final Object innerClassInstance = innerClassConstructor.newInstance(enclosingClassInstance);
      Assert.assertNotNull(innerClassInstance);
      final Method enclosingClassMethodCallMethod = compiledInnerClass.getMethod("innerClassMethodCall");
      Assert.assertNotNull(enclosingClassMethodCallMethod);
      final Object invocationResult = enclosingClassMethodCallMethod.invoke(innerClassInstance);
      Assert.assertNotNull(invocationResult);
      Assert.assertEquals("innerClassMethodResult", invocationResult);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug426442_InnerStaticClassLocalMethodCall() {
    try {
      final XExpression expression = this.expression("innerStaticClassMethod", false);
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        String _qualifiedName = it.getQualifiedName();
        String _plus = (_qualifiedName + ".InnerStaticClass");
        final Procedure1<JvmGenericType> _function_1 = (JvmGenericType it_1) -> {
          it_1.setStatic(true);
          EList<JvmMember> _members_1 = it_1.getMembers();
          JvmTypeReference _typeForName = this.references.getTypeForName(String.class, expression);
          final Procedure1<JvmOperation> _function_2 = (JvmOperation it_2) -> {
            final Procedure1<ITreeAppendable> _function_3 = (ITreeAppendable it_3) -> {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("return \"innerStaticClassMethodResult\";");
              it_3.append(_builder);
            };
            this.builder.setBody(it_2, _function_3);
          };
          JvmOperation _method = this.builder.toMethod(expression, "innerStaticClassMethod", _typeForName, _function_2);
          this.builder.<JvmOperation>operator_add(_members_1, _method);
          EList<JvmMember> _members_2 = it_1.getMembers();
          JvmTypeReference _typeForName_1 = this.references.getTypeForName(String.class, expression);
          final Procedure1<JvmOperation> _function_3 = (JvmOperation it_2) -> {
            this.builder.setBody(it_2, expression);
          };
          JvmOperation _method_1 = this.builder.toMethod(expression, "innerStaticClassMethodCall", _typeForName_1, _function_3);
          this.builder.<JvmOperation>operator_add(_members_2, _method_1);
        };
        JvmGenericType _class = this.builder.toClass(expression, _plus, _function_1);
        this.builder.<JvmGenericType>operator_add(_members, _class);
      };
      final JvmGenericType enclosingClass = this.builder.toClass(expression, "my.test.EnclosingClass", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiledEnclosingClass = this.compile(_eResource, enclosingClass);
      Assert.assertNotNull(compiledEnclosingClass);
      Class<?>[] _declaredClasses = compiledEnclosingClass.getDeclaredClasses();
      final Function1<Class<?>, Boolean> _function_1 = (Class<?> it) -> {
        String _simpleName = it.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, "InnerStaticClass"));
      };
      final Class<?> compiledInnerStaticClass = IterableExtensions.<Class<?>>findFirst(((Iterable<Class<?>>)Conversions.doWrapArray(_declaredClasses)), _function_1);
      Assert.assertNotNull(compiledInnerStaticClass);
      final Object innerStaticClassInstance = compiledInnerStaticClass.newInstance();
      Assert.assertNotNull(innerStaticClassInstance);
      final Method enclosingClassMethodCallMethod = compiledInnerStaticClass.getMethod("innerStaticClassMethodCall");
      Assert.assertNotNull(enclosingClassMethodCallMethod);
      final Object invocationResult = enclosingClassMethodCallMethod.invoke(innerStaticClassInstance);
      Assert.assertNotNull(invocationResult);
      Assert.assertEquals("innerStaticClassMethodResult", invocationResult);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNestedAnnotationType() {
    try {
      final XExpression expression = this.expression("42");
      final JvmGenericType outerClass = this.builder.toClass(expression, "my.outer.Clazz");
      EList<JvmMember> _members = outerClass.getMembers();
      final Procedure1<JvmAnnotationType> _function = (JvmAnnotationType it) -> {
        EList<JvmMember> _members_1 = it.getMembers();
        JvmTypeReference _typeForName = this.references.getTypeForName(int.class, expression);
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          this.builder.setBody(it_1, expression);
        };
        JvmOperation _method = this.builder.toMethod(expression, "theTruth", _typeForName, _function_1);
        this.builder.<JvmOperation>operator_add(_members_1, _method);
      };
      JvmAnnotationType _annotationType = this.builder.toAnnotationType(expression, "MyAnnotation", _function);
      this.builder.<JvmAnnotationType>operator_add(_members, _annotationType);
      Resource _eResource = expression.eResource();
      Class<?> _compile = this.compile(_eResource, outerClass);
      Class<?>[] _declaredClasses = _compile.getDeclaredClasses();
      final Class<?> compiled = IterableExtensions.<Class<?>>head(((Iterable<Class<?>>)Conversions.doWrapArray(_declaredClasses)));
      String _canonicalName = compiled.getCanonicalName();
      Assert.assertEquals("my.outer.Clazz.MyAnnotation", _canonicalName);
      Method[] _declaredMethods = compiled.getDeclaredMethods();
      Method _head = IterableExtensions.<Method>head(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods)));
      Object _defaultValue = _head.getDefaultValue();
      Assert.assertEquals(Integer.valueOf(42), _defaultValue);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNestedEnumerationType() {
    try {
      final XExpression expression = this.expression("null");
      final JvmGenericType outerClass = this.builder.toClass(expression, "my.outer.Clazz");
      EList<JvmMember> _members = outerClass.getMembers();
      final Procedure1<JvmEnumerationType> _function = (JvmEnumerationType it) -> {
        EList<JvmMember> _members_1 = it.getMembers();
        final Procedure1<JvmEnumerationLiteral> _function_1 = (JvmEnumerationLiteral literal) -> {
          JvmParameterizedTypeReference _createTypeRef = this.references.createTypeRef(it);
          literal.setType(_createTypeRef);
        };
        JvmEnumerationLiteral _enumerationLiteral = this.builder.toEnumerationLiteral(expression, "WARN", _function_1);
        this.builder.<JvmEnumerationLiteral>operator_add(_members_1, _enumerationLiteral);
        EList<JvmMember> _members_2 = it.getMembers();
        final Procedure1<JvmEnumerationLiteral> _function_2 = (JvmEnumerationLiteral literal) -> {
          JvmParameterizedTypeReference _createTypeRef = this.references.createTypeRef(it);
          literal.setType(_createTypeRef);
        };
        JvmEnumerationLiteral _enumerationLiteral_1 = this.builder.toEnumerationLiteral(expression, "ERROR", _function_2);
        this.builder.<JvmEnumerationLiteral>operator_add(_members_2, _enumerationLiteral_1);
        EList<JvmMember> _members_3 = it.getMembers();
        final Procedure1<JvmEnumerationLiteral> _function_3 = (JvmEnumerationLiteral literal) -> {
          JvmParameterizedTypeReference _createTypeRef = this.references.createTypeRef(it);
          literal.setType(_createTypeRef);
        };
        JvmEnumerationLiteral _enumerationLiteral_2 = this.builder.toEnumerationLiteral(expression, "DEBUG", _function_3);
        this.builder.<JvmEnumerationLiteral>operator_add(_members_3, _enumerationLiteral_2);
        EList<JvmMember> _members_4 = it.getMembers();
        JvmTypeReference _typeForName = this.references.getTypeForName("java.lang.Object", expression);
        final Procedure1<JvmOperation> _function_4 = (JvmOperation it_1) -> {
          this.builder.setBody(it_1, expression);
        };
        JvmOperation _method = this.builder.toMethod(expression, "doStuff", _typeForName, _function_4);
        this.builder.<JvmOperation>operator_add(_members_4, _method);
      };
      JvmEnumerationType _enumerationType = this.builder.toEnumerationType(expression, "Level", _function);
      this.builder.<JvmEnumerationType>operator_add(_members, _enumerationType);
      Resource _eResource = expression.eResource();
      Class<?> _compile = this.compile(_eResource, outerClass);
      Class<?>[] _declaredClasses = _compile.getDeclaredClasses();
      final Class<?> compiled = IterableExtensions.<Class<?>>head(((Iterable<Class<?>>)Conversions.doWrapArray(_declaredClasses)));
      Field _field = compiled.getField("WARN");
      Assert.assertNotNull(_field);
      Field _field_1 = compiled.getField("ERROR");
      Assert.assertNotNull(_field_1);
      Field _field_2 = compiled.getField("DEBUG");
      Assert.assertNotNull(_field_2);
      Method _method = compiled.getMethod("doStuff");
      Assert.assertNotNull(_method);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testClassModifiers() {
    try {
      final XExpression expression = this.expression("null");
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        final Procedure1<JvmGenericType> _function_1 = (JvmGenericType it_1) -> {
          it_1.setAbstract(true);
        };
        JvmGenericType _class = this.builder.toClass(expression, "AbstractClass", _function_1);
        this.builder.<JvmGenericType>operator_add(_members, _class);
        EList<JvmMember> _members_1 = it.getMembers();
        final Procedure1<JvmGenericType> _function_2 = (JvmGenericType it_1) -> {
          it_1.setStatic(true);
        };
        JvmGenericType _class_1 = this.builder.toClass(expression, "StaticClass", _function_2);
        this.builder.<JvmGenericType>operator_add(_members_1, _class_1);
        EList<JvmMember> _members_2 = it.getMembers();
        final Procedure1<JvmGenericType> _function_3 = (JvmGenericType it_1) -> {
          it_1.setFinal(true);
        };
        JvmGenericType _class_2 = this.builder.toClass(expression, "FinalClass", _function_3);
        this.builder.<JvmGenericType>operator_add(_members_2, _class_2);
        EList<JvmMember> _members_3 = it.getMembers();
        final Procedure1<JvmGenericType> _function_4 = (JvmGenericType it_1) -> {
          it_1.setStrictFloatingPoint(true);
        };
        JvmGenericType _class_3 = this.builder.toClass(expression, "StrictFpClass", _function_4);
        this.builder.<JvmGenericType>operator_add(_members_3, _class_3);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiled = this.compile(_eResource, clazz);
      final Class<?>[] classes = compiled.getClasses();
      final Function1<Class<?>, Boolean> _function_1 = (Class<?> it) -> {
        String _name = it.getName();
        return Boolean.valueOf(_name.endsWith("AbstractClass"));
      };
      Class<?> _findFirst = IterableExtensions.<Class<?>>findFirst(((Iterable<Class<?>>)Conversions.doWrapArray(classes)), _function_1);
      int _modifiers = _findFirst.getModifiers();
      boolean _isAbstract = Modifier.isAbstract(_modifiers);
      Assert.assertTrue(_isAbstract);
      final Function1<Class<?>, Boolean> _function_2 = (Class<?> it) -> {
        String _name = it.getName();
        return Boolean.valueOf(_name.endsWith("StaticClass"));
      };
      Class<?> _findFirst_1 = IterableExtensions.<Class<?>>findFirst(((Iterable<Class<?>>)Conversions.doWrapArray(classes)), _function_2);
      int _modifiers_1 = _findFirst_1.getModifiers();
      boolean _isStatic = Modifier.isStatic(_modifiers_1);
      Assert.assertTrue(_isStatic);
      final Function1<Class<?>, Boolean> _function_3 = (Class<?> it) -> {
        String _name = it.getName();
        return Boolean.valueOf(_name.endsWith("FinalClass"));
      };
      Class<?> _findFirst_2 = IterableExtensions.<Class<?>>findFirst(((Iterable<Class<?>>)Conversions.doWrapArray(classes)), _function_3);
      int _modifiers_2 = _findFirst_2.getModifiers();
      boolean _isFinal = Modifier.isFinal(_modifiers_2);
      Assert.assertTrue(_isFinal);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFieldModifiers() {
    try {
      final XExpression expression = this.expression("null");
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        JvmTypeReference _typeRef = this.typeRef(expression, Integer.TYPE);
        final Procedure1<JvmField> _function_1 = (JvmField it_1) -> {
          it_1.setStatic(true);
          it_1.setVisibility(JvmVisibility.PUBLIC);
        };
        JvmField _field = this.builder.toField(expression, "staticField", _typeRef, _function_1);
        this.builder.<JvmField>operator_add(_members, _field);
        EList<JvmMember> _members_1 = it.getMembers();
        JvmTypeReference _typeRef_1 = this.typeRef(expression, Integer.TYPE);
        final Procedure1<JvmField> _function_2 = (JvmField it_1) -> {
          it_1.setFinal(true);
          final Procedure1<ITreeAppendable> _function_3 = (ITreeAppendable it_2) -> {
            it_2.append("0");
          };
          this.builder.setInitializer(it_1, _function_3);
          it_1.setVisibility(JvmVisibility.PUBLIC);
        };
        JvmField _field_1 = this.builder.toField(expression, "finalField", _typeRef_1, _function_2);
        this.builder.<JvmField>operator_add(_members_1, _field_1);
        EList<JvmMember> _members_2 = it.getMembers();
        JvmTypeReference _typeRef_2 = this.typeRef(expression, Integer.TYPE);
        final Procedure1<JvmField> _function_3 = (JvmField it_1) -> {
          it_1.setVolatile(true);
          it_1.setVisibility(JvmVisibility.PUBLIC);
        };
        JvmField _field_2 = this.builder.toField(expression, "volatileField", _typeRef_2, _function_3);
        this.builder.<JvmField>operator_add(_members_2, _field_2);
        EList<JvmMember> _members_3 = it.getMembers();
        JvmTypeReference _typeRef_3 = this.typeRef(expression, Integer.TYPE);
        final Procedure1<JvmField> _function_4 = (JvmField it_1) -> {
          it_1.setTransient(true);
          it_1.setVisibility(JvmVisibility.PUBLIC);
        };
        JvmField _field_3 = this.builder.toField(expression, "transientField", _typeRef_3, _function_4);
        this.builder.<JvmField>operator_add(_members_3, _field_3);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiled = this.compile(_eResource, clazz);
      Field _field = compiled.getField("staticField");
      int _modifiers = _field.getModifiers();
      boolean _isStatic = Modifier.isStatic(_modifiers);
      Assert.assertTrue(_isStatic);
      Field _field_1 = compiled.getField("finalField");
      int _modifiers_1 = _field_1.getModifiers();
      boolean _isFinal = Modifier.isFinal(_modifiers_1);
      Assert.assertTrue(_isFinal);
      Field _field_2 = compiled.getField("volatileField");
      int _modifiers_2 = _field_2.getModifiers();
      boolean _isVolatile = Modifier.isVolatile(_modifiers_2);
      Assert.assertTrue(_isVolatile);
      Field _field_3 = compiled.getField("transientField");
      int _modifiers_3 = _field_3.getModifiers();
      boolean _isTransient = Modifier.isTransient(_modifiers_3);
      Assert.assertTrue(_isTransient);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMethodModifiers() {
    try {
      final XExpression expression = this.expression("null");
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        JvmTypeReference _typeRef = this.typeRef(expression, Void.TYPE);
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          it_1.setStatic(true);
          final Procedure1<ITreeAppendable> _function_2 = (ITreeAppendable it_2) -> {
            it_2.append("");
          };
          this.builder.setBody(it_1, _function_2);
        };
        JvmOperation _method = this.builder.toMethod(expression, "staticMethod", _typeRef, _function_1);
        this.builder.<JvmOperation>operator_add(_members, _method);
        EList<JvmMember> _members_1 = it.getMembers();
        JvmTypeReference _typeRef_1 = this.typeRef(expression, Void.TYPE);
        final Procedure1<JvmOperation> _function_2 = (JvmOperation it_1) -> {
          it_1.setFinal(true);
          final Procedure1<ITreeAppendable> _function_3 = (ITreeAppendable it_2) -> {
            it_2.append("");
          };
          this.builder.setBody(it_1, _function_3);
        };
        JvmOperation _method_1 = this.builder.toMethod(expression, "finalMethod", _typeRef_1, _function_2);
        this.builder.<JvmOperation>operator_add(_members_1, _method_1);
        EList<JvmMember> _members_2 = it.getMembers();
        JvmTypeReference _typeRef_2 = this.typeRef(expression, Void.TYPE);
        final Procedure1<JvmOperation> _function_3 = (JvmOperation it_1) -> {
          it_1.setAbstract(true);
        };
        JvmOperation _method_2 = this.builder.toMethod(expression, "abstractMethod", _typeRef_2, _function_3);
        this.builder.<JvmOperation>operator_add(_members_2, _method_2);
        EList<JvmMember> _members_3 = it.getMembers();
        JvmTypeReference _typeRef_3 = this.typeRef(expression, Void.TYPE);
        final Procedure1<JvmOperation> _function_4 = (JvmOperation it_1) -> {
          it_1.setSynchronized(true);
          final Procedure1<ITreeAppendable> _function_5 = (ITreeAppendable it_2) -> {
            it_2.append("");
          };
          this.builder.setBody(it_1, _function_5);
        };
        JvmOperation _method_3 = this.builder.toMethod(expression, "synchronizedMethod", _typeRef_3, _function_4);
        this.builder.<JvmOperation>operator_add(_members_3, _method_3);
        EList<JvmMember> _members_4 = it.getMembers();
        JvmTypeReference _typeRef_4 = this.typeRef(expression, Void.TYPE);
        final Procedure1<JvmOperation> _function_5 = (JvmOperation it_1) -> {
          it_1.setStrictFloatingPoint(true);
          final Procedure1<ITreeAppendable> _function_6 = (ITreeAppendable it_2) -> {
            it_2.append("");
          };
          this.builder.setBody(it_1, _function_6);
        };
        JvmOperation _method_4 = this.builder.toMethod(expression, "strictFpMethod", _typeRef_4, _function_5);
        this.builder.<JvmOperation>operator_add(_members_4, _method_4);
        EList<JvmMember> _members_5 = it.getMembers();
        JvmTypeReference _typeRef_5 = this.typeRef(expression, Void.TYPE);
        final Procedure1<JvmOperation> _function_6 = (JvmOperation it_1) -> {
          it_1.setNative(true);
        };
        JvmOperation _method_5 = this.builder.toMethod(expression, "nativeMethod", _typeRef_5, _function_6);
        this.builder.<JvmOperation>operator_add(_members_5, _method_5);
        it.setAbstract(true);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiled = this.compile(_eResource, clazz);
      Method _method = compiled.getMethod("staticMethod");
      int _modifiers = _method.getModifiers();
      boolean _isStatic = Modifier.isStatic(_modifiers);
      Assert.assertTrue(_isStatic);
      Method _method_1 = compiled.getMethod("finalMethod");
      int _modifiers_1 = _method_1.getModifiers();
      boolean _isFinal = Modifier.isFinal(_modifiers_1);
      Assert.assertTrue(_isFinal);
      Method _method_2 = compiled.getMethod("abstractMethod");
      int _modifiers_2 = _method_2.getModifiers();
      boolean _isAbstract = Modifier.isAbstract(_modifiers_2);
      Assert.assertTrue(_isAbstract);
      Method _method_3 = compiled.getMethod("synchronizedMethod");
      int _modifiers_3 = _method_3.getModifiers();
      boolean _isSynchronized = Modifier.isSynchronized(_modifiers_3);
      Assert.assertTrue(_isSynchronized);
      Method _method_4 = compiled.getMethod("strictFpMethod");
      int _modifiers_4 = _method_4.getModifiers();
      boolean _isStrict = Modifier.isStrict(_modifiers_4);
      Assert.assertTrue(_isStrict);
      Method _method_5 = compiled.getMethod("nativeMethod");
      int _modifiers_5 = _method_5.getModifiers();
      boolean _isNative = Modifier.isNative(_modifiers_5);
      Assert.assertTrue(_isNative);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public JvmTypeReference typeRef(final EObject ctx, final Class<?> clazz) {
    return this.references.getTypeForName(clazz, ctx);
  }
  
  public JvmTypeReference typeRef(final EObject ctx, final Class<?> clazz, final Class<?> param) {
    JvmTypeReference _typeRef = this.typeRef(ctx, param);
    return this.references.getTypeForName(clazz, ctx, _typeRef);
  }
  
  public Class<?> compile(final Resource res, final JvmDeclaredType type) {
    String _generate = this.generate(res, type);
    return this.compileToClass(res, type, _generate);
  }
  
  public String generate(final Resource res, final JvmDeclaredType type) {
    String _xblockexpression = null;
    {
      res.eSetDeliver(false);
      EList<EObject> _contents = res.getContents();
      this.builder.<JvmDeclaredType>operator_add(_contents, type);
      res.eSetDeliver(true);
      final InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
      this.generator.doGenerate(res, fsa);
      Map<String, CharSequence> _files = fsa.getFiles();
      String _identifier = type.getIdentifier();
      String _replace = _identifier.replace(".", "/");
      String _plus = (IFileSystemAccess.DEFAULT_OUTPUT + _replace);
      String _plus_1 = (_plus + ".java");
      CharSequence _get = _files.get(_plus_1);
      _xblockexpression = _get.toString();
    }
    return _xblockexpression;
  }
  
  public Class<?> compileToClass(final Resource res, final JvmDeclaredType type, final String code) {
    Class<?> _xblockexpression = null;
    {
      String _identifier = type.getIdentifier();
      final Class<?> compiledClass = this.javaCompiler.compileToClass(_identifier, code);
      EList<EObject> _contents = res.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      this.helper.assertNoErrors(_head);
      _xblockexpression = compiledClass;
    }
    return _xblockexpression;
  }
}
