package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import foo.TestAnnotation3;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Level;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.logging.LoggingTester;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsFactory;
import org.eclipse.xtext.xbase.compiler.CompilationStrategyAdapter;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function3;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class JvmTypesBuilderTest extends AbstractXbaseTestCase {
  @Inject
  private TypesFactory typesFactory;
  
  @Inject
  private TypeReferences references;
  
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  private ILogicalContainerProvider containerProvider;
  
  @Extension
  private JvmTypeReferenceBuilder _jvmTypeReferenceBuilder;
  
  @Inject
  public JvmTypeReferenceBuilder setJvmTypeReferenceBuilder(final JvmTypeReferenceBuilder.Factory factory, final XtextResourceSet resourceSet) {
    return this._jvmTypeReferenceBuilder = factory.create(resourceSet);
  }
  
  @Test
  public void testEmptyAnnotation() {
    try {
      final XAnnotationsFactory f = XAnnotationsFactory.eINSTANCE;
      final XExpression e = this.expression("\'Foo\'");
      final XAnnotation anno = f.createXAnnotation();
      JvmType _findDeclaredType = this.references.findDeclaredType(Inject.class, e);
      anno.setAnnotationType(((JvmAnnotationType) _findDeclaredType));
      final JvmGenericType type = this.typesFactory.createJvmGenericType();
      this._jvmTypesBuilder.addAnnotations(type, Collections.<XAnnotation>unmodifiableList(CollectionLiterals.<XAnnotation>newArrayList(anno)));
      Assert.assertEquals(anno.getAnnotationType(), IterableExtensions.<JvmAnnotationReference>head(type.getAnnotations()).getAnnotation());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStringAnnotation() {
    try {
      final XAnnotationsFactory f = XAnnotationsFactory.eINSTANCE;
      final XExpression e = this.expression("\'Foo\'");
      final XAnnotation anno = f.createXAnnotation();
      JvmType _findDeclaredType = this.references.findDeclaredType(Inject.class, e);
      anno.setAnnotationType(((JvmAnnotationType) _findDeclaredType));
      anno.setValue(e);
      final JvmGenericType type = this.typesFactory.createJvmGenericType();
      this._jvmTypesBuilder.addAnnotation(type, anno);
      Assert.assertEquals(anno.getAnnotationType(), IterableExtensions.<JvmAnnotationReference>head(type.getAnnotations()).getAnnotation());
      JvmAnnotationValue _head = IterableExtensions.<JvmAnnotationValue>head(IterableExtensions.<JvmAnnotationReference>head(type.getAnnotations()).getValues());
      EObject _head_1 = IterableExtensions.<EObject>head(((JvmCustomAnnotationValue) _head).getValues());
      Assert.assertTrue((_head_1 instanceof XStringLiteral));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAnnotationDefaultValue() {
    try {
      final XAnnotationsFactory f = XAnnotationsFactory.eINSTANCE;
      final XExpression e = this.expression("\'Foo\'");
      final XAnnotation anno = f.createXAnnotation();
      JvmType _findDeclaredType = this.references.findDeclaredType(Named.class, e);
      anno.setAnnotationType(((JvmAnnotationType) _findDeclaredType));
      anno.setValue(e);
      final JvmGenericType type = this.typesFactory.createJvmGenericType();
      this._jvmTypesBuilder.addAnnotation(type, anno);
      Assert.assertEquals(anno.getAnnotationType(), IterableExtensions.<JvmAnnotationReference>head(type.getAnnotations()).getAnnotation());
      JvmAnnotationValue _head = IterableExtensions.<JvmAnnotationValue>head(IterableExtensions.<JvmAnnotationReference>head(type.getAnnotations()).getValues());
      EObject _head_1 = IterableExtensions.<EObject>head(((JvmCustomAnnotationValue) _head).getValues());
      Assert.assertTrue((_head_1 instanceof XStringLiteral));
      Assert.assertNull(IterableExtensions.<JvmAnnotationValue>head(IterableExtensions.<JvmAnnotationReference>head(type.getAnnotations()).getValues()).getOperation());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStringAnnotationWithNullExpression() {
    try {
      final XAnnotationsFactory f = XAnnotationsFactory.eINSTANCE;
      final XExpression context = this.expression("\'Foo\'");
      final XAnnotation anno = f.createXAnnotation();
      JvmType _findDeclaredType = this.references.findDeclaredType(Inject.class, context);
      anno.setAnnotationType(((JvmAnnotationType) _findDeclaredType));
      final XAnnotationElementValuePair pair = f.createXAnnotationElementValuePair();
      EList<XAnnotationElementValuePair> _elementValuePairs = anno.getElementValuePairs();
      this._jvmTypesBuilder.<XAnnotationElementValuePair>operator_add(_elementValuePairs, pair);
      final JvmGenericType type = this.typesFactory.createJvmGenericType();
      this._jvmTypesBuilder.addAnnotation(type, anno);
      Assert.assertEquals(anno.getAnnotationType(), IterableExtensions.<JvmAnnotationReference>head(type.getAnnotations()).getAnnotation());
      Assert.assertTrue(IterableExtensions.<JvmAnnotationReference>head(type.getAnnotations()).getExplicitValues().isEmpty());
      Assert.assertFalse(IterableExtensions.<JvmAnnotationReference>head(type.getAnnotations()).getValues().isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIntegerAnnotation() {
    try {
      final XAnnotationsFactory f = XAnnotationsFactory.eINSTANCE;
      final XExpression e = this.expression("\'Foo\'");
      final XAnnotation anno = f.createXAnnotation();
      JvmType _findDeclaredType = this.references.findDeclaredType(TestAnnotation3.class, e);
      final JvmAnnotationType annotatiomType = ((JvmAnnotationType) _findDeclaredType);
      anno.setAnnotationType(annotatiomType);
      final XAnnotationElementValuePair pair = f.createXAnnotationElementValuePair();
      pair.setElement(IterableExtensions.<JvmOperation>head(annotatiomType.getDeclaredOperations()));
      pair.setValue(this.expression("10"));
      EList<XAnnotationElementValuePair> _elementValuePairs = anno.getElementValuePairs();
      this._jvmTypesBuilder.<XAnnotationElementValuePair>operator_add(_elementValuePairs, pair);
      final JvmGenericType type = this.typesFactory.createJvmGenericType();
      this._jvmTypesBuilder.addAnnotation(type, anno);
      Assert.assertEquals(anno.getAnnotationType(), IterableExtensions.<JvmAnnotationReference>head(type.getAnnotations()).getAnnotation());
      Assert.assertEquals(1, IterableExtensions.<JvmAnnotationReference>head(type.getAnnotations()).getValues().size());
      JvmAnnotationValue _head = IterableExtensions.<JvmAnnotationValue>head(IterableExtensions.<JvmAnnotationReference>head(type.getAnnotations()).getValues());
      final JvmCustomAnnotationValue value = ((JvmCustomAnnotationValue) _head);
      EObject _head_1 = IterableExtensions.<EObject>head(value.getValues());
      Assert.assertTrue((_head_1 instanceof XNumberLiteral));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAnnotationCreation() {
    try {
      final XExpression e = this.expression("\'foo\'");
      final Procedure1<JvmAnnotationType> _function = (JvmAnnotationType it) -> {
        this._jvmTypesBuilder.setDocumentation(it, "Foo");
      };
      final JvmAnnotationType anno = this._jvmTypesBuilder.toAnnotationType(e, "foo.bar.MyAnnotation", _function);
      Assert.assertEquals("foo.bar", anno.getPackageName());
      Assert.assertEquals("MyAnnotation", anno.getSimpleName());
      Assert.assertEquals("Foo", this._jvmTypesBuilder.getDocumentation(anno));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInterfaceCreation() {
    try {
      final XExpression e = this.expression("\'foo\'");
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmTypeReference> _superTypes = it.getSuperTypes();
        JvmTypeReference _typeRef = this._jvmTypeReferenceBuilder.typeRef(Iterable.class);
        this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _typeRef);
      };
      final JvmGenericType anno = this._jvmTypesBuilder.toInterface(e, "foo.bar.MyAnnotation", _function);
      Assert.assertTrue(anno.isInterface());
      Assert.assertEquals("foo.bar", anno.getPackageName());
      Assert.assertEquals("MyAnnotation", anno.getSimpleName());
      Assert.assertEquals(1, anno.getSuperTypes().size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnumCreation() {
    try {
      final XExpression e = this.expression("\'foo\'");
      final Procedure1<JvmEnumerationType> _function = (JvmEnumerationType it) -> {
        this._jvmTypesBuilder.setDocumentation(it, "Foo");
        EList<JvmMember> _members = it.getMembers();
        JvmEnumerationLiteral _enumerationLiteral = this._jvmTypesBuilder.toEnumerationLiteral(e, "LITERAL0");
        this._jvmTypesBuilder.<JvmEnumerationLiteral>operator_add(_members, _enumerationLiteral);
        EList<JvmMember> _members_1 = it.getMembers();
        JvmEnumerationLiteral _enumerationLiteral_1 = this._jvmTypesBuilder.toEnumerationLiteral(e, "LITERAL1");
        this._jvmTypesBuilder.<JvmEnumerationLiteral>operator_add(_members_1, _enumerationLiteral_1);
      };
      final JvmEnumerationType myEnum = this._jvmTypesBuilder.toEnumerationType(e, "MyEnum", _function);
      Assert.assertNull(myEnum.getPackageName());
      Assert.assertEquals("MyEnum", myEnum.getSimpleName());
      Assert.assertEquals("Foo", this._jvmTypesBuilder.getDocumentation(myEnum));
      final Function1<JvmEnumerationLiteral, String> _function_1 = (JvmEnumerationLiteral it) -> {
        return it.getSimpleName();
      };
      Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(CollectionLiterals.<Object>newArrayList("LITERAL0", "LITERAL1"), Object.class)), ((Object[])Conversions.unwrapArray(ListExtensions.<JvmEnumerationLiteral, String>map(myEnum.getLiterals(), _function_1), Object.class)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnumCreation2() {
    try {
      final XExpression e = this.expression("\'foo\'");
      JvmEnumerationType _enumerationType = this._jvmTypesBuilder.toEnumerationType(e, "MyEnum");
      final Procedure1<JvmEnumerationType> _function = (JvmEnumerationType it) -> {
        this._jvmTypesBuilder.setDocumentation(it, "Foo");
        EList<JvmMember> _members = it.getMembers();
        JvmEnumerationLiteral _enumerationLiteral = this._jvmTypesBuilder.toEnumerationLiteral(e, "LITERAL0");
        this._jvmTypesBuilder.<JvmEnumerationLiteral>operator_add(_members, _enumerationLiteral);
        EList<JvmMember> _members_1 = it.getMembers();
        JvmEnumerationLiteral _enumerationLiteral_1 = this._jvmTypesBuilder.toEnumerationLiteral(e, "LITERAL1");
        this._jvmTypesBuilder.<JvmEnumerationLiteral>operator_add(_members_1, _enumerationLiteral_1);
      };
      final JvmEnumerationType myEnum = ObjectExtensions.<JvmEnumerationType>operator_doubleArrow(_enumerationType, _function);
      Assert.assertNull(myEnum.getPackageName());
      Assert.assertEquals("MyEnum", myEnum.getSimpleName());
      Assert.assertEquals("Foo", this._jvmTypesBuilder.getDocumentation(myEnum));
      final Function1<JvmEnumerationLiteral, String> _function_1 = (JvmEnumerationLiteral it) -> {
        return it.getSimpleName();
      };
      Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(CollectionLiterals.<Object>newArrayList("LITERAL0", "LITERAL1"), Object.class)), ((Object[])Conversions.unwrapArray(ListExtensions.<JvmEnumerationLiteral, String>map(myEnum.getLiterals(), _function_1), Object.class)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSetBody() {
    final JvmOperation op = this.typesFactory.createJvmOperation();
    final Procedure1<ITreeAppendable> _function = (ITreeAppendable it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("foo");
      it.append(_builder);
    };
    this._jvmTypesBuilder.setBody(op, _function);
    final Procedure1<ITreeAppendable> _function_1 = (ITreeAppendable it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("bar");
      it.append(_builder);
    };
    this._jvmTypesBuilder.setBody(op, _function_1);
    Assert.assertEquals(1, op.eAdapters().size());
  }
  
  @Test
  public void testSetBody_02() {
    final XNullLiteral expr = XbaseFactory.eINSTANCE.createXNullLiteral();
    final XtextResource res = new XtextResource();
    res.setLanguageName("org.eclipse.xtext.xbase.Xbase");
    final JvmOperation op = this.typesFactory.createJvmOperation();
    EList<EObject> _contents = res.getContents();
    this._jvmTypesBuilder.<JvmOperation>operator_add(_contents, op);
    EList<EObject> _contents_1 = res.getContents();
    this._jvmTypesBuilder.<XNullLiteral>operator_add(_contents_1, expr);
    final Procedure1<ITreeAppendable> _function = (ITreeAppendable it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("bar");
      it.append(_builder);
    };
    this._jvmTypesBuilder.setBody(op, _function);
    Assert.assertEquals(1, op.eAdapters().size());
    this._jvmTypesBuilder.setBody(op, expr);
    Assert.assertEquals(op, this.containerProvider.getLogicalContainer(expr));
    Assert.assertEquals(0, op.eAdapters().size());
    final Procedure1<ITreeAppendable> _function_1 = (ITreeAppendable it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("bar");
      it.append(_builder);
    };
    this._jvmTypesBuilder.setBody(op, _function_1);
    Assert.assertEquals(1, op.eAdapters().size());
    Assert.assertNull(this.containerProvider.getLogicalContainer(expr));
  }
  
  @Test
  public void testSetBody_03() {
    final JvmOperation op = this.typesFactory.createJvmOperation();
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("foo");
      }
    };
    this._jvmTypesBuilder.setBody(op, _client);
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("bar");
      }
    };
    this._jvmTypesBuilder.setBody(op, _client_1);
    Assert.assertEquals(1, op.eAdapters().size());
  }
  
  @Test
  public void testSetBody_04() {
    final XNullLiteral expr = XbaseFactory.eINSTANCE.createXNullLiteral();
    final XtextResource res = new XtextResource();
    res.setLanguageName("org.eclipse.xtext.xbase.Xbase");
    final JvmOperation op = this.typesFactory.createJvmOperation();
    EList<EObject> _contents = res.getContents();
    this._jvmTypesBuilder.<JvmOperation>operator_add(_contents, op);
    EList<EObject> _contents_1 = res.getContents();
    this._jvmTypesBuilder.<XNullLiteral>operator_add(_contents_1, expr);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("bar");
      }
    };
    this._jvmTypesBuilder.setBody(op, _client);
    Assert.assertEquals(1, op.eAdapters().size());
    this._jvmTypesBuilder.setBody(op, expr);
    Assert.assertEquals(op, this.containerProvider.getLogicalContainer(expr));
    Assert.assertEquals(0, op.eAdapters().size());
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("bar");
      }
    };
    this._jvmTypesBuilder.setBody(op, _client_1);
    Assert.assertEquals(1, op.eAdapters().size());
    Assert.assertNull(this.containerProvider.getLogicalContainer(expr));
  }
  
  @Test
  @Ignore
  public void testAddNull() {
    final BasicEList<String> list = new BasicEList<String>();
    Assert.assertTrue(list.isEmpty());
  }
  
  @Test
  public void testAddAllNull() {
    final BasicEList<String> list = new BasicEList<String>();
    final List<String> otherList = CollectionLiterals.<String>newArrayList(null, null, null);
    this._jvmTypesBuilder.<String>operator_add(list, otherList);
    Assert.assertTrue(list.isEmpty());
  }
  
  @Test
  public void testAddAllNull_1() {
    final BasicEList<String> list = new BasicEList<String>();
    final List<String> otherList = null;
    this._jvmTypesBuilder.<String>operator_add(list, otherList);
    Assert.assertTrue(list.isEmpty());
  }
  
  /**
   * Invokes an executable's compilation strategy and check against the expected string
   */
  protected void expectBody(final JvmExecutable executable, final CharSequence expectedBody) {
    final CompilationStrategyAdapter adapter = IterableExtensions.<CompilationStrategyAdapter>head(Iterables.<CompilationStrategyAdapter>filter(executable.eAdapters(), CompilationStrategyAdapter.class));
    final FakeTreeAppendable appendable = new FakeTreeAppendable();
    adapter.getCompilationStrategy().apply(appendable);
    Assert.assertEquals(expectedBody.toString(), appendable.toString());
  }
  
  @Test
  public void testToGetterWithNullTypeRef() {
    try {
      final XExpression e = this.expression("\'\'");
      final JvmOperation getter = this._jvmTypesBuilder.toGetter(e, "foo", null);
      this.expectBody(getter, "return this.foo;");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testToFieldWithKeywordCollision() {
    try {
      final XExpression e = this.expression("\'\'");
      final JvmField field = this._jvmTypesBuilder.toField(e, "package", this._jvmTypeReferenceBuilder.typeRef(String.class));
      Assert.assertEquals("package", field.getSimpleName());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testToGetterWithKeywordCollision() {
    try {
      final XExpression e = this.expression("\'\'");
      final JvmOperation getter = this._jvmTypesBuilder.toGetter(e, "package", this._jvmTypeReferenceBuilder.typeRef(String.class));
      this.expectBody(getter, "return this.package_;");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testToSetterWithKeywordCollision() {
    try {
      final XExpression e = this.expression("\'\'");
      final JvmOperation setter = this._jvmTypesBuilder.toSetter(e, "package", this._jvmTypeReferenceBuilder.typeRef(String.class));
      Assert.assertEquals("package", IterableExtensions.<JvmFormalParameter>head(setter.getParameters()).getSimpleName());
      this.expectBody(setter, "this.package_ = package_;");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInitializeSafely_0() {
    final Runnable _function = () -> {
      final Function3<EObject, String, Procedure1<? super JvmGenericType>, EObject> _function_1 = (EObject expr, String name, Procedure1<? super JvmGenericType> init) -> {
        return this._jvmTypesBuilder.toClass(expr, name, init);
      };
      this.<JvmGenericType>genericTestInitializeSafely(_function_1);
    };
    this.expectErrorLogging(2, _function);
  }
  
  @Test
  public void testInitializeSafely_1() {
    final Runnable _function = () -> {
      final Function3<EObject, String, Procedure1<? super JvmConstructor>, EObject> _function_1 = (EObject expr, String name, Procedure1<? super JvmConstructor> init) -> {
        return this._jvmTypesBuilder.toConstructor(expr, init);
      };
      this.<JvmConstructor>genericTestInitializeSafely(_function_1);
    };
    this.expectErrorLogging(2, _function);
  }
  
  @Test
  public void testInitializeSafely_2() {
    final Runnable _function = () -> {
      final Function3<EObject, String, Procedure1<? super JvmField>, EObject> _function_1 = (EObject expr, String name, Procedure1<? super JvmField> init) -> {
        return this._jvmTypesBuilder.toField(expr, name, null, init);
      };
      this.<JvmField>genericTestInitializeSafely(_function_1);
    };
    this.expectErrorLogging(2, _function);
  }
  
  @Test
  public void testInitializeSafely_3() {
    final Runnable _function = () -> {
      final Function3<EObject, String, Procedure1<? super JvmOperation>, EObject> _function_1 = (EObject expr, String name, Procedure1<? super JvmOperation> init) -> {
        return this._jvmTypesBuilder.toMethod(expr, name, null, init);
      };
      this.<JvmOperation>genericTestInitializeSafely(_function_1);
    };
    this.expectErrorLogging(2, _function);
  }
  
  @Test
  public void testInitializeSafely_4() {
    final Runnable _function = () -> {
      final Function3<EObject, String, Procedure1<? super JvmAnnotationType>, EObject> _function_1 = (EObject expr, String name, Procedure1<? super JvmAnnotationType> init) -> {
        return this._jvmTypesBuilder.toAnnotationType(expr, name, init);
      };
      this.<JvmAnnotationType>genericTestInitializeSafely(_function_1);
    };
    this.expectErrorLogging(2, _function);
  }
  
  @Test
  public void testInitializeSafely_5() {
    final Runnable _function = () -> {
      final Function3<EObject, String, Procedure1<? super JvmEnumerationType>, EObject> _function_1 = (EObject expr, String name, Procedure1<? super JvmEnumerationType> init) -> {
        return this._jvmTypesBuilder.toEnumerationType(expr, name, init);
      };
      this.<JvmEnumerationType>genericTestInitializeSafely(_function_1);
    };
    this.expectErrorLogging(2, _function);
  }
  
  protected <T extends Object> void genericTestInitializeSafely(final Function3<? super EObject, ? super String, ? super Procedure1<? super T>, ? extends EObject> create) {
    final XNullLiteral expr = XbaseFactory.eINSTANCE.createXNullLiteral();
    final Wrapper<Boolean> initialized = new Wrapper<Boolean>(Boolean.valueOf(false));
    final Procedure1<T> _function = (T it) -> {
      initialized.set(Boolean.valueOf(true));
      throw new RuntimeException();
    };
    final EObject element = create.apply(expr, "foo", _function);
    Assert.assertTrue((initialized.get()).booleanValue());
    Assert.assertNotNull(element);
  }
  
  protected void expectErrorLogging(final Runnable block) {
    this.expectErrorLogging(1, block);
  }
  
  protected void expectErrorLogging(final int numberOfloggings, final Runnable block) {
    final LoggingTester.LogCapture loggings = LoggingTester.captureLogging(Level.ERROR, JvmTypesBuilder.class, block);
    loggings.assertNumberOfLogEntries(numberOfloggings);
  }
  
  @Test
  public void testErrorLogging_01() throws Exception {
    final Runnable _function = () -> {
      final JvmGenericType source = this.typesFactory.createJvmGenericType();
      this._jvmTypesBuilder.toClass(source, "foo.bar");
    };
    this.expectErrorLogging(_function);
  }
  
  @Test
  public void testErrorLogging_02() throws Exception {
    final Runnable _function = () -> {
      final JvmGenericType source = this.typesFactory.createJvmGenericType();
      this._jvmTypesBuilder.toClass(source, "foo.bar");
    };
    this.expectErrorLogging(_function);
  }
}
