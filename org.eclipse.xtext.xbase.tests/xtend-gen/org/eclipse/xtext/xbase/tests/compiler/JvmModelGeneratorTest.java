/**
 * Copyright (c) 2012, 2017, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.compiler;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import foo.TestAnnotation;
import foo.TestAnnotation2;
import foo.TestAnnotations;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.AbstractList;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
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
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.JvmAnnotationReferenceBuilder;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelCompleter;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.testing.OnTheFlyJavaCompiler2;
import org.eclipse.xtext.xbase.testing.TemporaryFolder;
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
  
  @Inject
  private JvmAnnotationReferenceBuilder.Factory jvmAnnotationReferenceBuilderFactory;
  
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
        final Procedure1<JvmOperation> _function_1 = (JvmOperation fooMethod) -> {
          EList<JvmFormalParameter> _parameters = fooMethod.getParameters();
          JvmFormalParameter _parameter = this.builder.toParameter(it, "p1", this.references.createTypeRef(innerClass));
          this.builder.<JvmFormalParameter>operator_add(_parameters, _parameter);
          EList<JvmFormalParameter> _parameters_1 = fooMethod.getParameters();
          JvmFormalParameter _parameter_1 = this.builder.toParameter(it, "p2", this.references.createTypeRef(innerClassString));
          this.builder.<JvmFormalParameter>operator_add(_parameters_1, _parameter_1);
          this.builder.setBody(fooMethod, expression);
        };
        JvmOperation _method = this.builder.toMethod(it, "foo", this.references.getTypeForName(String.class, expression), _function_1);
        this.builder.<JvmOperation>operator_add(_members_2, _method);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Outer", _function);
      expression.eResource().eSetDeliver(false);
      EList<EObject> _contents = expression.eResource().getContents();
      this.builder.<JvmGenericType>operator_add(_contents, clazz);
      expression.eResource().eSetDeliver(true);
      final InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
      this.generator.doGenerate(expression.eResource(), fsa);
      Map<String, CharSequence> _textFiles = fsa.getTextFiles();
      String _replace = clazz.getIdentifier().replace(".", "/");
      String _plus = (IFileSystemAccess.DEFAULT_OUTPUT + _replace);
      String _plus_1 = (_plus + ".java");
      final String code = _textFiles.get(_plus_1).toString();
      Assert.assertFalse(code.contains("import"));
      Assert.assertTrue(code, code.contains("java.lang.String foo"));
      final Class<?> compiledClass = this.javaCompiler.compileToClass(clazz.getIdentifier(), code);
      this.helper.assertNoErrors(IterableExtensions.<EObject>head(expression.eResource().getContents()));
      Assert.assertEquals(2, ((List<Class<?>>)Conversions.doWrapArray(compiledClass.getDeclaredClasses())).size());
      Assert.assertNotNull(compiledClass.getMethod("foo", IterableExtensions.<Class<?>>head(((Iterable<Class<?>>)Conversions.doWrapArray(compiledClass.getDeclaredClasses()))), IterableExtensions.<Class<?>>last(((Iterable<Class<?>>)Conversions.doWrapArray(compiledClass.getDeclaredClasses())))));
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
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          JvmFormalParameter _parameter = this.builder.toParameter(expression, "s", this.references.getTypeForName(String.class, expression));
          this.builder.<JvmFormalParameter>operator_add(_parameters, _parameter);
          this.builder.setBody(it_1, expression);
        };
        JvmOperation _method = this.builder.toMethod(expression, "doStuff", this.references.getTypeForName(String.class, expression), _function_1);
        this.builder.<JvmOperation>operator_add(_members, _method);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      final Class<?> compiledClass = this.compile(expression.eResource(), clazz);
      final Object instance = compiledClass.getDeclaredConstructor().newInstance();
      Assert.assertEquals("FOO", compiledClass.getMethod("doStuff", String.class).invoke(instance, "foo"));
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
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          this.builder.setBody(it_1, expression);
        };
        JvmOperation _method = this.builder.toMethod(expression, "theTruth", this.references.getTypeForName(int.class, expression), _function_1);
        this.builder.<JvmOperation>operator_add(_members, _method);
      };
      final JvmAnnotationType clazz = this.builder.toAnnotationType(expression, "my.test.Foo", _function);
      final Class<?> compiledClass = this.compile(expression.eResource(), clazz);
      Assert.assertTrue(compiledClass.isAnnotation());
      final Method method = IterableExtensions.<Method>head(((Iterable<Method>)Conversions.doWrapArray(compiledClass.getMethods())));
      Assert.assertEquals("theTruth", method.getName());
      Assert.assertEquals(Integer.valueOf(42), method.getDefaultValue());
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
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          this.builder.setBody(it_1, expression);
        };
        JvmOperation _method = this.builder.toMethod(expression, "value", this.references.getTypeForName(Class.class, expression, this.references.wildCard()), _function_1);
        this.builder.<JvmOperation>operator_add(_members, _method);
        EList<JvmMember> _members_1 = it.getMembers();
        final Procedure1<JvmOperation> _function_2 = (JvmOperation it_1) -> {
        };
        JvmOperation _method_1 = this.builder.toMethod(expression, "otherValue", this.references.getTypeForName(int.class, expression), _function_2);
        this.builder.<JvmOperation>operator_add(_members_1, _method_1);
      };
      final JvmAnnotationType clazz = this.builder.toAnnotationType(expression, "my.test.Foo", _function);
      final Class<?> compiledClass = this.compile(expression.eResource(), clazz);
      Assert.assertTrue(compiledClass.isAnnotation());
      final Function1<Method, Boolean> _function_1 = (Method it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, "value"));
      };
      Assert.assertEquals(String.class, IterableExtensions.<Method>findFirst(((Iterable<Method>)Conversions.doWrapArray(compiledClass.getMethods())), _function_1).getDefaultValue());
      final Function1<Method, Boolean> _function_2 = (Method it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, "otherValue"));
      };
      Assert.assertNull(IterableExtensions.<Method>findFirst(((Iterable<Method>)Conversions.doWrapArray(compiledClass.getMethods())), _function_2).getDefaultValue());
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
      final Class<?> compiled = this.compile(expression.eResource(), clazz);
      Assert.assertTrue(Iterable.class.isAssignableFrom(compiled));
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
      final Class<?> compiled = this.compile(expression.eResource(), clazz);
      Assert.assertTrue(Iterable.class.isAssignableFrom(compiled));
      Assert.assertTrue(AbstractList.class.isAssignableFrom(compiled));
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
        JvmField _field = this.builder.toField(expression, "x", this.typeRef(expression, String.class));
        this.builder.<JvmField>operator_add(_members, _field);
        EList<JvmMember> _members_1 = it.getMembers();
        JvmOperation _getter = this.builder.toGetter(expression, "x", this.typeRef(expression, String.class));
        this.builder.<JvmOperation>operator_add(_members_1, _getter);
        EList<JvmMember> _members_2 = it.getMembers();
        JvmOperation _setter = this.builder.toSetter(expression, "x", this.typeRef(expression, String.class));
        this.builder.<JvmOperation>operator_add(_members_2, _setter);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      final Class<?> compiled = this.compile(expression.eResource(), clazz);
      final Object inst = compiled.getDeclaredConstructor().newInstance();
      final Method getter = compiled.getMethod("getX");
      final Method setter = compiled.getMethod("setX", String.class);
      setter.invoke(inst, "FOO");
      Assert.assertEquals("FOO", getter.invoke(inst));
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
          literal.setType(this.references.createTypeRef(it));
        };
        JvmEnumerationLiteral _enumerationLiteral = this.builder.toEnumerationLiteral(expression, "BAR", _function_1);
        this.builder.<JvmEnumerationLiteral>operator_add(_members, _enumerationLiteral);
        EList<JvmMember> _members_1 = it.getMembers();
        final Procedure1<JvmEnumerationLiteral> _function_2 = (JvmEnumerationLiteral literal) -> {
          literal.setType(this.references.createTypeRef(it));
        };
        JvmEnumerationLiteral _enumerationLiteral_1 = this.builder.toEnumerationLiteral(expression, "BAZ", _function_2);
        this.builder.<JvmEnumerationLiteral>operator_add(_members_1, _enumerationLiteral_1);
      };
      final JvmEnumerationType enumeration = this.builder.toEnumerationType(expression, "my.test.Foo", _function);
      final Class<?> compiled = this.compile(expression.eResource(), enumeration);
      final Method valuesMethod = compiled.getMethod("values");
      Object _invoke = valuesMethod.invoke(null);
      final Object[] values = ((Object[]) _invoke);
      Assert.assertEquals("BAR", (values[0]).toString());
      Assert.assertEquals("BAZ", (values[1]).toString());
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
          literal.setType(this.references.createTypeRef(it));
        };
        JvmEnumerationLiteral _enumerationLiteral = this.builder.toEnumerationLiteral(expression, "BAR", _function_1);
        this.builder.<JvmEnumerationLiteral>operator_add(_members, _enumerationLiteral);
        EList<JvmMember> _members_1 = it.getMembers();
        final Procedure1<JvmEnumerationLiteral> _function_2 = (JvmEnumerationLiteral literal) -> {
          literal.setType(this.references.createTypeRef(it));
        };
        JvmEnumerationLiteral _enumerationLiteral_1 = this.builder.toEnumerationLiteral(expression, "BAZ", _function_2);
        this.builder.<JvmEnumerationLiteral>operator_add(_members_1, _enumerationLiteral_1);
      };
      final JvmEnumerationType enumeration = ObjectExtensions.<JvmEnumerationType>operator_doubleArrow(_enumerationType, _function);
      final Class<?> compiled = this.compile(expression.eResource(), enumeration);
      final Method valuesMethod = compiled.getMethod("values");
      Object _invoke = valuesMethod.invoke(null);
      final Object[] values = ((Object[]) _invoke);
      Assert.assertEquals("BAR", (values[0]).toString());
      Assert.assertEquals("BAZ", (values[1]).toString());
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
      expression.eResource().getContents().add(enumeration);
      this.completer.complete(enumeration);
      final Class<?> compiled = this.compile(expression.eResource(), enumeration);
      final Method valuesMethod = compiled.getMethod("values");
      Object _invoke = valuesMethod.invoke(null);
      final Object[] values = ((Object[]) _invoke);
      Assert.assertEquals("BAR", (values[0]).toString());
      Assert.assertEquals("BAZ", (values[1]).toString());
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
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          this.builder.setBody(it_1, expression);
        };
        JvmOperation _method = this.builder.toMethod(expression, "doStuff", this.references.getTypeForName("java.lang.Object", expression), _function_1);
        this.builder.<JvmOperation>operator_add(_members, _method);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      this.compile(expression.eResource(), clazz);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug380754() {
    try {
      final XExpression expression = this.expression("null");
      final JvmAnnotationReferenceBuilder jvmAnnotationReferenceBuilder = this.jvmAnnotationReferenceBuilderFactory.create(expression.eResource().getResourceSet());
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          this.builder.setBody(it_1, expression);
          final JvmAnnotationReference annotation = jvmAnnotationReferenceBuilder.annotationRef(TestAnnotations.class);
          final JvmAnnotationAnnotationValue annotationAnnotationValue = this.typesFactory.createJvmAnnotationAnnotationValue();
          EList<JvmAnnotationReference> _values = annotationAnnotationValue.getValues();
          JvmAnnotationReference _annotationRef = jvmAnnotationReferenceBuilder.annotationRef(TestAnnotation.class);
          this.builder.<JvmAnnotationReference>operator_add(_values, _annotationRef);
          EList<JvmAnnotationReference> _values_1 = annotationAnnotationValue.getValues();
          JvmAnnotationReference _annotationRef_1 = jvmAnnotationReferenceBuilder.annotationRef(TestAnnotation.class);
          this.builder.<JvmAnnotationReference>operator_add(_values_1, _annotationRef_1);
          EList<JvmAnnotationReference> _values_2 = annotationAnnotationValue.getValues();
          JvmAnnotationReference _annotationRef_2 = jvmAnnotationReferenceBuilder.annotationRef(TestAnnotation.class);
          this.builder.<JvmAnnotationReference>operator_add(_values_2, _annotationRef_2);
          EList<JvmAnnotationValue> _explicitValues = annotation.getExplicitValues();
          this.builder.<JvmAnnotationAnnotationValue>operator_add(_explicitValues, annotationAnnotationValue);
          EList<JvmAnnotationReference> _annotations = it_1.getAnnotations();
          this.builder.<JvmAnnotationReference>operator_add(_annotations, annotation);
        };
        JvmOperation _method = this.builder.toMethod(expression, "doStuff", this.references.getTypeForName("java.lang.Object", expression), _function_1);
        this.builder.<JvmOperation>operator_add(_members, _method);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      this.compile(expression.eResource(), clazz);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug380754_2() {
    try {
      final XExpression expression = this.expression("null");
      final JvmAnnotationReferenceBuilder jvmAnnotationReferenceBuilder = this.jvmAnnotationReferenceBuilderFactory.create(expression.eResource().getResourceSet());
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          this.builder.setBody(it_1, expression);
          final JvmFormalParameter parameter = this.builder.toParameter(expression, "s", this.references.getTypeForName(String.class, expression));
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          this.builder.<JvmFormalParameter>operator_add(_parameters, parameter);
          EList<JvmAnnotationReference> _annotations = parameter.getAnnotations();
          JvmAnnotationReference _annotationRef = jvmAnnotationReferenceBuilder.annotationRef(TestAnnotation.class);
          this.builder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
          EList<JvmAnnotationReference> _annotations_1 = parameter.getAnnotations();
          JvmAnnotationReference _annotationRef_1 = jvmAnnotationReferenceBuilder.annotationRef(TestAnnotation2.class);
          this.builder.<JvmAnnotationReference>operator_add(_annotations_1, _annotationRef_1);
        };
        JvmOperation _method = this.builder.toMethod(expression, "doStuff", this.references.getTypeForName("java.lang.Object", expression), _function_1);
        this.builder.<JvmOperation>operator_add(_members, _method);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      this.compile(expression.eResource(), clazz);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug419430() {
    try {
      final XExpression expression = this.expression("null");
      final JvmAnnotationReferenceBuilder jvmAnnotationReferenceBuilder = this.jvmAnnotationReferenceBuilderFactory.create(expression.eResource().getResourceSet());
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          this.builder.setBody(it_1, expression);
          final JvmAnnotationReference annotation = jvmAnnotationReferenceBuilder.annotationRef(TestAnnotations.class);
          final JvmAnnotationAnnotationValue annotationAnnotationValue = this.typesFactory.createJvmAnnotationAnnotationValue();
          EList<JvmAnnotationReference> _values = annotationAnnotationValue.getValues();
          JvmAnnotationReference _annotationRef = jvmAnnotationReferenceBuilder.annotationRef(TestAnnotation.class);
          this.builder.<JvmAnnotationReference>operator_add(_values, _annotationRef);
          EList<JvmAnnotationReference> _values_1 = annotationAnnotationValue.getValues();
          JvmAnnotationReference _annotationRef_1 = jvmAnnotationReferenceBuilder.annotationRef(TestAnnotation.class);
          this.builder.<JvmAnnotationReference>operator_add(_values_1, _annotationRef_1);
          EList<JvmAnnotationReference> _values_2 = annotationAnnotationValue.getValues();
          JvmAnnotationReference _annotationRef_2 = jvmAnnotationReferenceBuilder.annotationRef(TestAnnotation.class);
          this.builder.<JvmAnnotationReference>operator_add(_values_2, _annotationRef_2);
          EList<JvmAnnotationValue> _explicitValues = annotation.getExplicitValues();
          this.builder.<JvmAnnotationAnnotationValue>operator_add(_explicitValues, annotationAnnotationValue);
          EList<JvmAnnotationReference> _annotations = it_1.getAnnotations();
          this.builder.<JvmAnnotationReference>operator_add(_annotations, annotation);
        };
        JvmOperation _method = this.builder.toMethod(expression, "doStuff", this.references.getTypeForName("java.lang.Object", expression), _function_1);
        this.builder.<JvmOperation>operator_add(_members, _method);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      final String code = this.generate(expression.eResource(), clazz);
      Assert.assertTrue(code, code.contains("@TestAnnotations({ @TestAnnotation, @TestAnnotation, @TestAnnotation })"));
      final Class<?> compiledClazz = this.compileToClass(expression.eResource(), clazz, code);
      final Method method = compiledClazz.getMethod("doStuff");
      final TestAnnotations methodAnnotation = method.<TestAnnotations>getAnnotation(TestAnnotations.class);
      Assert.assertEquals(3, ((List<TestAnnotation>)Conversions.doWrapArray(methodAnnotation.value())).size());
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
          literal.setType(this.references.createTypeRef(it));
        };
        JvmEnumerationLiteral _enumerationLiteral = this.builder.toEnumerationLiteral(expression, "WARN", _function_1);
        this.builder.<JvmEnumerationLiteral>operator_add(_members, _enumerationLiteral);
        EList<JvmMember> _members_1 = it.getMembers();
        final Procedure1<JvmEnumerationLiteral> _function_2 = (JvmEnumerationLiteral literal) -> {
          literal.setType(this.references.createTypeRef(it));
        };
        JvmEnumerationLiteral _enumerationLiteral_1 = this.builder.toEnumerationLiteral(expression, "ERROR", _function_2);
        this.builder.<JvmEnumerationLiteral>operator_add(_members_1, _enumerationLiteral_1);
        EList<JvmMember> _members_2 = it.getMembers();
        final Procedure1<JvmEnumerationLiteral> _function_3 = (JvmEnumerationLiteral literal) -> {
          literal.setType(this.references.createTypeRef(it));
        };
        JvmEnumerationLiteral _enumerationLiteral_2 = this.builder.toEnumerationLiteral(expression, "DEBUG", _function_3);
        this.builder.<JvmEnumerationLiteral>operator_add(_members_2, _enumerationLiteral_2);
        EList<JvmMember> _members_3 = it.getMembers();
        final Procedure1<JvmOperation> _function_4 = (JvmOperation it_1) -> {
          this.builder.setBody(it_1, expression);
        };
        JvmOperation _method = this.builder.toMethod(expression, "doStuff", this.references.getTypeForName("java.lang.Object", expression), _function_4);
        this.builder.<JvmOperation>operator_add(_members_3, _method);
      };
      final JvmEnumerationType clazz = this.builder.toEnumerationType(expression, "my.test.Level", _function);
      final Class<?> compiled = this.compile(expression.eResource(), clazz);
      Assert.assertNotNull(compiled.getField("WARN"));
      Assert.assertNotNull(compiled.getField("ERROR"));
      Assert.assertNotNull(compiled.getField("DEBUG"));
      Assert.assertNotNull(compiled.getMethod("doStuff"));
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
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          final Procedure1<ITreeAppendable> _function_2 = (ITreeAppendable it_2) -> {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("return \"enclosingClassMethodResult\";");
            it_2.append(_builder);
          };
          this.builder.setBody(it_1, _function_2);
        };
        JvmOperation _method = this.builder.toMethod(expression, "enclosingClassMethod", this.references.getTypeForName(String.class, expression), _function_1);
        this.builder.<JvmOperation>operator_add(_members, _method);
        EList<JvmMember> _members_1 = it.getMembers();
        String _qualifiedName = it.getQualifiedName();
        String _plus = (_qualifiedName + ".InnerClass");
        final Procedure1<JvmGenericType> _function_2 = (JvmGenericType it_1) -> {
          EList<JvmMember> _members_2 = it_1.getMembers();
          final Procedure1<JvmOperation> _function_3 = (JvmOperation it_2) -> {
            this.builder.setBody(it_2, expression);
          };
          JvmOperation _method_1 = this.builder.toMethod(expression, "enclosingClassMethodCall", this.references.getTypeForName(String.class, expression), _function_3);
          this.builder.<JvmOperation>operator_add(_members_2, _method_1);
        };
        JvmGenericType _class = this.builder.toClass(expression, _plus, _function_2);
        this.builder.<JvmGenericType>operator_add(_members_1, _class);
      };
      final JvmGenericType enclosingClass = this.builder.toClass(expression, "my.test.EnclosingClass", _function);
      final Class<?> compiledEnclosingClass = this.compile(expression.eResource(), enclosingClass);
      Assert.assertNotNull(compiledEnclosingClass);
      final Function1<Class<?>, Boolean> _function_1 = (Class<?> it) -> {
        String _simpleName = it.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, "InnerClass"));
      };
      final Class<?> compiledInnerClass = IterableExtensions.<Class<?>>findFirst(((Iterable<Class<?>>)Conversions.doWrapArray(compiledEnclosingClass.getDeclaredClasses())), _function_1);
      Assert.assertNotNull(compiledInnerClass);
      final Object enclosingClassInstance = compiledEnclosingClass.getDeclaredConstructor().newInstance();
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
          final Procedure1<JvmOperation> _function_2 = (JvmOperation it_2) -> {
            final Procedure1<ITreeAppendable> _function_3 = (ITreeAppendable it_3) -> {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("return \"innerClassMethodResult\";");
              it_3.append(_builder);
            };
            this.builder.setBody(it_2, _function_3);
          };
          JvmOperation _method = this.builder.toMethod(expression, "innerClassMethod", this.references.getTypeForName(String.class, expression), _function_2);
          this.builder.<JvmOperation>operator_add(_members_1, _method);
          EList<JvmMember> _members_2 = it_1.getMembers();
          final Procedure1<JvmOperation> _function_3 = (JvmOperation it_2) -> {
            this.builder.setBody(it_2, expression);
          };
          JvmOperation _method_1 = this.builder.toMethod(expression, "innerClassMethodCall", this.references.getTypeForName(String.class, expression), _function_3);
          this.builder.<JvmOperation>operator_add(_members_2, _method_1);
        };
        JvmGenericType _class = this.builder.toClass(expression, _plus, _function_1);
        this.builder.<JvmGenericType>operator_add(_members, _class);
      };
      final JvmGenericType enclosingClass = this.builder.toClass(expression, "my.test.EnclosingClass", _function);
      final Class<?> compiledEnclosingClass = this.compile(expression.eResource(), enclosingClass);
      Assert.assertNotNull(compiledEnclosingClass);
      final Function1<Class<?>, Boolean> _function_1 = (Class<?> it) -> {
        String _simpleName = it.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, "InnerClass"));
      };
      final Class<?> compiledInnerClass = IterableExtensions.<Class<?>>findFirst(((Iterable<Class<?>>)Conversions.doWrapArray(compiledEnclosingClass.getDeclaredClasses())), _function_1);
      Assert.assertNotNull(compiledInnerClass);
      final Object enclosingClassInstance = compiledEnclosingClass.getDeclaredConstructor().newInstance();
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
          final Procedure1<JvmOperation> _function_2 = (JvmOperation it_2) -> {
            final Procedure1<ITreeAppendable> _function_3 = (ITreeAppendable it_3) -> {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("return \"innerStaticClassMethodResult\";");
              it_3.append(_builder);
            };
            this.builder.setBody(it_2, _function_3);
          };
          JvmOperation _method = this.builder.toMethod(expression, "innerStaticClassMethod", this.references.getTypeForName(String.class, expression), _function_2);
          this.builder.<JvmOperation>operator_add(_members_1, _method);
          EList<JvmMember> _members_2 = it_1.getMembers();
          final Procedure1<JvmOperation> _function_3 = (JvmOperation it_2) -> {
            this.builder.setBody(it_2, expression);
          };
          JvmOperation _method_1 = this.builder.toMethod(expression, "innerStaticClassMethodCall", this.references.getTypeForName(String.class, expression), _function_3);
          this.builder.<JvmOperation>operator_add(_members_2, _method_1);
        };
        JvmGenericType _class = this.builder.toClass(expression, _plus, _function_1);
        this.builder.<JvmGenericType>operator_add(_members, _class);
      };
      final JvmGenericType enclosingClass = this.builder.toClass(expression, "my.test.EnclosingClass", _function);
      final Class<?> compiledEnclosingClass = this.compile(expression.eResource(), enclosingClass);
      Assert.assertNotNull(compiledEnclosingClass);
      final Function1<Class<?>, Boolean> _function_1 = (Class<?> it) -> {
        String _simpleName = it.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, "InnerStaticClass"));
      };
      final Class<?> compiledInnerStaticClass = IterableExtensions.<Class<?>>findFirst(((Iterable<Class<?>>)Conversions.doWrapArray(compiledEnclosingClass.getDeclaredClasses())), _function_1);
      Assert.assertNotNull(compiledInnerStaticClass);
      final Object innerStaticClassInstance = compiledInnerStaticClass.getDeclaredConstructor().newInstance();
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
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          this.builder.setBody(it_1, expression);
        };
        JvmOperation _method = this.builder.toMethod(expression, "theTruth", this.references.getTypeForName(int.class, expression), _function_1);
        this.builder.<JvmOperation>operator_add(_members_1, _method);
      };
      JvmAnnotationType _annotationType = this.builder.toAnnotationType(expression, "MyAnnotation", _function);
      this.builder.<JvmAnnotationType>operator_add(_members, _annotationType);
      final Class<?> compiled = IterableExtensions.<Class<?>>head(((Iterable<Class<?>>)Conversions.doWrapArray(this.compile(expression.eResource(), outerClass).getDeclaredClasses())));
      Assert.assertEquals("my.outer.Clazz.MyAnnotation", compiled.getCanonicalName());
      Assert.assertEquals(Integer.valueOf(42), IterableExtensions.<Method>head(((Iterable<Method>)Conversions.doWrapArray(compiled.getDeclaredMethods()))).getDefaultValue());
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
          literal.setType(this.references.createTypeRef(it));
        };
        JvmEnumerationLiteral _enumerationLiteral = this.builder.toEnumerationLiteral(expression, "WARN", _function_1);
        this.builder.<JvmEnumerationLiteral>operator_add(_members_1, _enumerationLiteral);
        EList<JvmMember> _members_2 = it.getMembers();
        final Procedure1<JvmEnumerationLiteral> _function_2 = (JvmEnumerationLiteral literal) -> {
          literal.setType(this.references.createTypeRef(it));
        };
        JvmEnumerationLiteral _enumerationLiteral_1 = this.builder.toEnumerationLiteral(expression, "ERROR", _function_2);
        this.builder.<JvmEnumerationLiteral>operator_add(_members_2, _enumerationLiteral_1);
        EList<JvmMember> _members_3 = it.getMembers();
        final Procedure1<JvmEnumerationLiteral> _function_3 = (JvmEnumerationLiteral literal) -> {
          literal.setType(this.references.createTypeRef(it));
        };
        JvmEnumerationLiteral _enumerationLiteral_2 = this.builder.toEnumerationLiteral(expression, "DEBUG", _function_3);
        this.builder.<JvmEnumerationLiteral>operator_add(_members_3, _enumerationLiteral_2);
        EList<JvmMember> _members_4 = it.getMembers();
        final Procedure1<JvmOperation> _function_4 = (JvmOperation it_1) -> {
          this.builder.setBody(it_1, expression);
        };
        JvmOperation _method = this.builder.toMethod(expression, "doStuff", this.references.getTypeForName("java.lang.Object", expression), _function_4);
        this.builder.<JvmOperation>operator_add(_members_4, _method);
      };
      JvmEnumerationType _enumerationType = this.builder.toEnumerationType(expression, "Level", _function);
      this.builder.<JvmEnumerationType>operator_add(_members, _enumerationType);
      final Class<?> compiled = IterableExtensions.<Class<?>>head(((Iterable<Class<?>>)Conversions.doWrapArray(this.compile(expression.eResource(), outerClass).getDeclaredClasses())));
      Assert.assertNotNull(compiled.getField("WARN"));
      Assert.assertNotNull(compiled.getField("ERROR"));
      Assert.assertNotNull(compiled.getField("DEBUG"));
      Assert.assertNotNull(compiled.getMethod("doStuff"));
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
      final Class<?> compiled = this.compile(expression.eResource(), clazz);
      final Class<?>[] classes = compiled.getClasses();
      final Function1<Class<?>, Boolean> _function_1 = (Class<?> it) -> {
        return Boolean.valueOf(it.getName().endsWith("AbstractClass"));
      };
      Assert.assertTrue(Modifier.isAbstract(IterableExtensions.<Class<?>>findFirst(((Iterable<Class<?>>)Conversions.doWrapArray(classes)), _function_1).getModifiers()));
      final Function1<Class<?>, Boolean> _function_2 = (Class<?> it) -> {
        return Boolean.valueOf(it.getName().endsWith("StaticClass"));
      };
      Assert.assertTrue(Modifier.isStatic(IterableExtensions.<Class<?>>findFirst(((Iterable<Class<?>>)Conversions.doWrapArray(classes)), _function_2).getModifiers()));
      final Function1<Class<?>, Boolean> _function_3 = (Class<?> it) -> {
        return Boolean.valueOf(it.getName().endsWith("FinalClass"));
      };
      Assert.assertTrue(Modifier.isFinal(IterableExtensions.<Class<?>>findFirst(((Iterable<Class<?>>)Conversions.doWrapArray(classes)), _function_3).getModifiers()));
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
        final Procedure1<JvmField> _function_1 = (JvmField it_1) -> {
          it_1.setStatic(true);
          it_1.setVisibility(JvmVisibility.PUBLIC);
        };
        JvmField _field = this.builder.toField(expression, "staticField", this.typeRef(expression, Integer.TYPE), _function_1);
        this.builder.<JvmField>operator_add(_members, _field);
        EList<JvmMember> _members_1 = it.getMembers();
        final Procedure1<JvmField> _function_2 = (JvmField it_1) -> {
          it_1.setFinal(true);
          final Procedure1<ITreeAppendable> _function_3 = (ITreeAppendable it_2) -> {
            it_2.append("0");
          };
          this.builder.setInitializer(it_1, _function_3);
          it_1.setVisibility(JvmVisibility.PUBLIC);
        };
        JvmField _field_1 = this.builder.toField(expression, "finalField", this.typeRef(expression, Integer.TYPE), _function_2);
        this.builder.<JvmField>operator_add(_members_1, _field_1);
        EList<JvmMember> _members_2 = it.getMembers();
        final Procedure1<JvmField> _function_3 = (JvmField it_1) -> {
          it_1.setVolatile(true);
          it_1.setVisibility(JvmVisibility.PUBLIC);
        };
        JvmField _field_2 = this.builder.toField(expression, "volatileField", this.typeRef(expression, Integer.TYPE), _function_3);
        this.builder.<JvmField>operator_add(_members_2, _field_2);
        EList<JvmMember> _members_3 = it.getMembers();
        final Procedure1<JvmField> _function_4 = (JvmField it_1) -> {
          it_1.setTransient(true);
          it_1.setVisibility(JvmVisibility.PUBLIC);
        };
        JvmField _field_3 = this.builder.toField(expression, "transientField", this.typeRef(expression, Integer.TYPE), _function_4);
        this.builder.<JvmField>operator_add(_members_3, _field_3);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      final Class<?> compiled = this.compile(expression.eResource(), clazz);
      Assert.assertTrue(Modifier.isStatic(compiled.getField("staticField").getModifiers()));
      Assert.assertTrue(Modifier.isFinal(compiled.getField("finalField").getModifiers()));
      Assert.assertTrue(Modifier.isVolatile(compiled.getField("volatileField").getModifiers()));
      Assert.assertTrue(Modifier.isTransient(compiled.getField("transientField").getModifiers()));
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
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          it_1.setStatic(true);
          final Procedure1<ITreeAppendable> _function_2 = (ITreeAppendable it_2) -> {
            it_2.append("");
          };
          this.builder.setBody(it_1, _function_2);
        };
        JvmOperation _method = this.builder.toMethod(expression, "staticMethod", this.typeRef(expression, Void.TYPE), _function_1);
        this.builder.<JvmOperation>operator_add(_members, _method);
        EList<JvmMember> _members_1 = it.getMembers();
        final Procedure1<JvmOperation> _function_2 = (JvmOperation it_1) -> {
          it_1.setFinal(true);
          final Procedure1<ITreeAppendable> _function_3 = (ITreeAppendable it_2) -> {
            it_2.append("");
          };
          this.builder.setBody(it_1, _function_3);
        };
        JvmOperation _method_1 = this.builder.toMethod(expression, "finalMethod", this.typeRef(expression, Void.TYPE), _function_2);
        this.builder.<JvmOperation>operator_add(_members_1, _method_1);
        EList<JvmMember> _members_2 = it.getMembers();
        final Procedure1<JvmOperation> _function_3 = (JvmOperation it_1) -> {
          it_1.setAbstract(true);
        };
        JvmOperation _method_2 = this.builder.toMethod(expression, "abstractMethod", this.typeRef(expression, Void.TYPE), _function_3);
        this.builder.<JvmOperation>operator_add(_members_2, _method_2);
        EList<JvmMember> _members_3 = it.getMembers();
        final Procedure1<JvmOperation> _function_4 = (JvmOperation it_1) -> {
          it_1.setSynchronized(true);
          final Procedure1<ITreeAppendable> _function_5 = (ITreeAppendable it_2) -> {
            it_2.append("");
          };
          this.builder.setBody(it_1, _function_5);
        };
        JvmOperation _method_3 = this.builder.toMethod(expression, "synchronizedMethod", this.typeRef(expression, Void.TYPE), _function_4);
        this.builder.<JvmOperation>operator_add(_members_3, _method_3);
        EList<JvmMember> _members_4 = it.getMembers();
        final Procedure1<JvmOperation> _function_5 = (JvmOperation it_1) -> {
          it_1.setStrictFloatingPoint(true);
          final Procedure1<ITreeAppendable> _function_6 = (ITreeAppendable it_2) -> {
            it_2.append("");
          };
          this.builder.setBody(it_1, _function_6);
        };
        JvmOperation _method_4 = this.builder.toMethod(expression, "strictFpMethod", this.typeRef(expression, Void.TYPE), _function_5);
        this.builder.<JvmOperation>operator_add(_members_4, _method_4);
        EList<JvmMember> _members_5 = it.getMembers();
        final Procedure1<JvmOperation> _function_6 = (JvmOperation it_1) -> {
          it_1.setNative(true);
        };
        JvmOperation _method_5 = this.builder.toMethod(expression, "nativeMethod", this.typeRef(expression, Void.TYPE), _function_6);
        this.builder.<JvmOperation>operator_add(_members_5, _method_5);
        it.setAbstract(true);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      final Class<?> compiled = this.compile(expression.eResource(), clazz);
      Assert.assertTrue(Modifier.isStatic(compiled.getMethod("staticMethod").getModifiers()));
      Assert.assertTrue(Modifier.isFinal(compiled.getMethod("finalMethod").getModifiers()));
      Assert.assertTrue(Modifier.isAbstract(compiled.getMethod("abstractMethod").getModifiers()));
      Assert.assertTrue(Modifier.isSynchronized(compiled.getMethod("synchronizedMethod").getModifiers()));
      Assert.assertTrue(Modifier.isStrict(compiled.getMethod("strictFpMethod").getModifiers()));
      Assert.assertTrue(Modifier.isNative(compiled.getMethod("nativeMethod").getModifiers()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug426073() {
    try {
      final XExpression expression = this.expression("org.eclipse.emf.common.util.URI.createURI(\"dummy\")");
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        final Procedure1<JvmField> _function_1 = (JvmField it_1) -> {
          this.builder.setInitializer(it_1, expression);
        };
        JvmField _field = this.builder.toField(expression, "URI", this.typeRef(expression, URI.class), _function_1);
        this.builder.<JvmField>operator_add(_members, _field);
      };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      this.compile(expression.eResource(), clazz);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public JvmTypeReference typeRef(final EObject ctx, final Class<?> clazz) {
    return this.references.getTypeForName(clazz, ctx);
  }
  
  public JvmTypeReference typeRef(final EObject ctx, final Class<?> clazz, final Class<?> param) {
    return this.references.getTypeForName(clazz, ctx, this.typeRef(ctx, param));
  }
  
  public Class<?> compile(final Resource res, final JvmDeclaredType type) {
    return this.compileToClass(res, type, this.generate(res, type));
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
      Map<String, CharSequence> _textFiles = fsa.getTextFiles();
      String _replace = type.getIdentifier().replace(".", "/");
      String _plus = (IFileSystemAccess.DEFAULT_OUTPUT + _replace);
      String _plus_1 = (_plus + ".java");
      _xblockexpression = _textFiles.get(_plus_1).toString();
    }
    return _xblockexpression;
  }
  
  public Class<?> compileToClass(final Resource res, final JvmDeclaredType type, final String code) {
    Class<?> _xblockexpression = null;
    {
      final Class<?> compiledClass = this.javaCompiler.compileToClass(type.getIdentifier(), code);
      this.helper.assertNoErrors(IterableExtensions.<EObject>head(res.getContents()));
      _xblockexpression = compiledClass;
    }
    return _xblockexpression;
  }
}
