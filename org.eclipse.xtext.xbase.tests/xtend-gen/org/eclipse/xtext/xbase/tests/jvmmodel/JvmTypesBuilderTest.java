package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import foo.TestAnnotation3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Level;
import org.eclipse.emf.common.notify.Adapter;
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
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
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
  
  private XtextResourceSet resourceSet;
  
  @Inject
  public JvmTypeReferenceBuilder setJvmTypeReferenceBuilder(final JvmTypeReferenceBuilder.Factory factory, final XtextResourceSet resourceSet) {
    JvmTypeReferenceBuilder _xblockexpression = null;
    {
      this.resourceSet = resourceSet;
      JvmTypeReferenceBuilder _create = factory.create(resourceSet);
      _xblockexpression = this._jvmTypeReferenceBuilder = _create;
    }
    return _xblockexpression;
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
      JvmType _annotationType = anno.getAnnotationType();
      EList<JvmAnnotationReference> _annotations = type.getAnnotations();
      JvmAnnotationReference _head = IterableExtensions.<JvmAnnotationReference>head(_annotations);
      JvmAnnotationType _annotation = _head.getAnnotation();
      Assert.assertEquals(_annotationType, _annotation);
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
      JvmType _annotationType = anno.getAnnotationType();
      EList<JvmAnnotationReference> _annotations = type.getAnnotations();
      JvmAnnotationReference _head = IterableExtensions.<JvmAnnotationReference>head(_annotations);
      JvmAnnotationType _annotation = _head.getAnnotation();
      Assert.assertEquals(_annotationType, _annotation);
      EList<JvmAnnotationReference> _annotations_1 = type.getAnnotations();
      JvmAnnotationReference _head_1 = IterableExtensions.<JvmAnnotationReference>head(_annotations_1);
      EList<JvmAnnotationValue> _values = _head_1.getValues();
      JvmAnnotationValue _head_2 = IterableExtensions.<JvmAnnotationValue>head(_values);
      EList<EObject> _values_1 = ((JvmCustomAnnotationValue) _head_2).getValues();
      EObject _head_3 = IterableExtensions.<EObject>head(_values_1);
      Assert.assertTrue((_head_3 instanceof XStringLiteral));
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
      JvmType _annotationType = anno.getAnnotationType();
      EList<JvmAnnotationReference> _annotations = type.getAnnotations();
      JvmAnnotationReference _head = IterableExtensions.<JvmAnnotationReference>head(_annotations);
      JvmAnnotationType _annotation = _head.getAnnotation();
      Assert.assertEquals(_annotationType, _annotation);
      EList<JvmAnnotationReference> _annotations_1 = type.getAnnotations();
      JvmAnnotationReference _head_1 = IterableExtensions.<JvmAnnotationReference>head(_annotations_1);
      EList<JvmAnnotationValue> _values = _head_1.getValues();
      JvmAnnotationValue _head_2 = IterableExtensions.<JvmAnnotationValue>head(_values);
      EList<EObject> _values_1 = ((JvmCustomAnnotationValue) _head_2).getValues();
      EObject _head_3 = IterableExtensions.<EObject>head(_values_1);
      Assert.assertTrue((_head_3 instanceof XStringLiteral));
      EList<JvmAnnotationReference> _annotations_2 = type.getAnnotations();
      JvmAnnotationReference _head_4 = IterableExtensions.<JvmAnnotationReference>head(_annotations_2);
      EList<JvmAnnotationValue> _values_2 = _head_4.getValues();
      JvmAnnotationValue _head_5 = IterableExtensions.<JvmAnnotationValue>head(_values_2);
      JvmOperation _operation = _head_5.getOperation();
      Assert.assertNull(_operation);
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
      JvmType _annotationType = anno.getAnnotationType();
      EList<JvmAnnotationReference> _annotations = type.getAnnotations();
      JvmAnnotationReference _head = IterableExtensions.<JvmAnnotationReference>head(_annotations);
      JvmAnnotationType _annotation = _head.getAnnotation();
      Assert.assertEquals(_annotationType, _annotation);
      EList<JvmAnnotationReference> _annotations_1 = type.getAnnotations();
      JvmAnnotationReference _head_1 = IterableExtensions.<JvmAnnotationReference>head(_annotations_1);
      EList<JvmAnnotationValue> _explicitValues = _head_1.getExplicitValues();
      boolean _isEmpty = _explicitValues.isEmpty();
      Assert.assertTrue(_isEmpty);
      EList<JvmAnnotationReference> _annotations_2 = type.getAnnotations();
      JvmAnnotationReference _head_2 = IterableExtensions.<JvmAnnotationReference>head(_annotations_2);
      EList<JvmAnnotationValue> _values = _head_2.getValues();
      boolean _isEmpty_1 = _values.isEmpty();
      Assert.assertFalse(_isEmpty_1);
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
      Iterable<JvmOperation> _declaredOperations = annotatiomType.getDeclaredOperations();
      JvmOperation _head = IterableExtensions.<JvmOperation>head(_declaredOperations);
      pair.setElement(_head);
      XExpression _expression = this.expression("10");
      pair.setValue(_expression);
      EList<XAnnotationElementValuePair> _elementValuePairs = anno.getElementValuePairs();
      this._jvmTypesBuilder.<XAnnotationElementValuePair>operator_add(_elementValuePairs, pair);
      final JvmGenericType type = this.typesFactory.createJvmGenericType();
      this._jvmTypesBuilder.addAnnotation(type, anno);
      JvmType _annotationType = anno.getAnnotationType();
      EList<JvmAnnotationReference> _annotations = type.getAnnotations();
      JvmAnnotationReference _head_1 = IterableExtensions.<JvmAnnotationReference>head(_annotations);
      JvmAnnotationType _annotation = _head_1.getAnnotation();
      Assert.assertEquals(_annotationType, _annotation);
      EList<JvmAnnotationReference> _annotations_1 = type.getAnnotations();
      JvmAnnotationReference _head_2 = IterableExtensions.<JvmAnnotationReference>head(_annotations_1);
      EList<JvmAnnotationValue> _values = _head_2.getValues();
      int _size = _values.size();
      Assert.assertEquals(1, _size);
      EList<JvmAnnotationReference> _annotations_2 = type.getAnnotations();
      JvmAnnotationReference _head_3 = IterableExtensions.<JvmAnnotationReference>head(_annotations_2);
      EList<JvmAnnotationValue> _values_1 = _head_3.getValues();
      JvmAnnotationValue _head_4 = IterableExtensions.<JvmAnnotationValue>head(_values_1);
      final JvmCustomAnnotationValue value = ((JvmCustomAnnotationValue) _head_4);
      EList<EObject> _values_2 = value.getValues();
      EObject _head_5 = IterableExtensions.<EObject>head(_values_2);
      Assert.assertTrue((_head_5 instanceof XNumberLiteral));
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
      String _packageName = anno.getPackageName();
      Assert.assertEquals("foo.bar", _packageName);
      String _simpleName = anno.getSimpleName();
      Assert.assertEquals("MyAnnotation", _simpleName);
      String _documentation = this._jvmTypesBuilder.getDocumentation(anno);
      Assert.assertEquals("Foo", _documentation);
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
      boolean _isInterface = anno.isInterface();
      Assert.assertTrue(_isInterface);
      String _packageName = anno.getPackageName();
      Assert.assertEquals("foo.bar", _packageName);
      String _simpleName = anno.getSimpleName();
      Assert.assertEquals("MyAnnotation", _simpleName);
      EList<JvmTypeReference> _superTypes = anno.getSuperTypes();
      int _size = _superTypes.size();
      Assert.assertEquals(1, _size);
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
      String _packageName = myEnum.getPackageName();
      Assert.assertNull(_packageName);
      String _simpleName = myEnum.getSimpleName();
      Assert.assertEquals("MyEnum", _simpleName);
      String _documentation = this._jvmTypesBuilder.getDocumentation(myEnum);
      Assert.assertEquals("Foo", _documentation);
      ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList("LITERAL0", "LITERAL1");
      EList<JvmEnumerationLiteral> _literals = myEnum.getLiterals();
      final Function1<JvmEnumerationLiteral, String> _function_1 = (JvmEnumerationLiteral it) -> {
        return it.getSimpleName();
      };
      List<String> _map = ListExtensions.<JvmEnumerationLiteral, String>map(_literals, _function_1);
      Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(_newArrayList, Object.class)), ((Object[])Conversions.unwrapArray(_map, Object.class)));
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
      String _packageName = myEnum.getPackageName();
      Assert.assertNull(_packageName);
      String _simpleName = myEnum.getSimpleName();
      Assert.assertEquals("MyEnum", _simpleName);
      String _documentation = this._jvmTypesBuilder.getDocumentation(myEnum);
      Assert.assertEquals("Foo", _documentation);
      ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList("LITERAL0", "LITERAL1");
      EList<JvmEnumerationLiteral> _literals = myEnum.getLiterals();
      final Function1<JvmEnumerationLiteral, String> _function_1 = (JvmEnumerationLiteral it) -> {
        return it.getSimpleName();
      };
      List<String> _map = ListExtensions.<JvmEnumerationLiteral, String>map(_literals, _function_1);
      Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(_newArrayList, Object.class)), ((Object[])Conversions.unwrapArray(_map, Object.class)));
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
    EList<Adapter> _eAdapters = op.eAdapters();
    int _size = _eAdapters.size();
    Assert.assertEquals(1, _size);
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
    EList<Adapter> _eAdapters = op.eAdapters();
    int _size = _eAdapters.size();
    Assert.assertEquals(1, _size);
    this._jvmTypesBuilder.setBody(op, expr);
    JvmIdentifiableElement _logicalContainer = this.containerProvider.getLogicalContainer(expr);
    Assert.assertEquals(op, _logicalContainer);
    EList<Adapter> _eAdapters_1 = op.eAdapters();
    int _size_1 = _eAdapters_1.size();
    Assert.assertEquals(0, _size_1);
    final Procedure1<ITreeAppendable> _function_1 = (ITreeAppendable it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("bar");
      it.append(_builder);
    };
    this._jvmTypesBuilder.setBody(op, _function_1);
    EList<Adapter> _eAdapters_2 = op.eAdapters();
    int _size_2 = _eAdapters_2.size();
    Assert.assertEquals(1, _size_2);
    JvmIdentifiableElement _logicalContainer_1 = this.containerProvider.getLogicalContainer(expr);
    Assert.assertNull(_logicalContainer_1);
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
    EList<Adapter> _eAdapters = op.eAdapters();
    int _size = _eAdapters.size();
    Assert.assertEquals(1, _size);
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
    EList<Adapter> _eAdapters = op.eAdapters();
    int _size = _eAdapters.size();
    Assert.assertEquals(1, _size);
    this._jvmTypesBuilder.setBody(op, expr);
    JvmIdentifiableElement _logicalContainer = this.containerProvider.getLogicalContainer(expr);
    Assert.assertEquals(op, _logicalContainer);
    EList<Adapter> _eAdapters_1 = op.eAdapters();
    int _size_1 = _eAdapters_1.size();
    Assert.assertEquals(0, _size_1);
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("bar");
      }
    };
    this._jvmTypesBuilder.setBody(op, _client_1);
    EList<Adapter> _eAdapters_2 = op.eAdapters();
    int _size_2 = _eAdapters_2.size();
    Assert.assertEquals(1, _size_2);
    JvmIdentifiableElement _logicalContainer_1 = this.containerProvider.getLogicalContainer(expr);
    Assert.assertNull(_logicalContainer_1);
  }
  
  @Test
  @Ignore
  public void testAddNull() {
    final BasicEList<String> list = new BasicEList<String>();
    boolean _isEmpty = list.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testAddAllNull() {
    final BasicEList<String> list = new BasicEList<String>();
    final List<String> otherList = CollectionLiterals.<String>newArrayList(null, null, null);
    this._jvmTypesBuilder.<String>operator_add(list, otherList);
    boolean _isEmpty = list.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testAddAllNull_1() {
    final BasicEList<String> list = new BasicEList<String>();
    final List<String> otherList = null;
    this._jvmTypesBuilder.<String>operator_add(list, otherList);
    boolean _isEmpty = list.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testToGetterWithNullTypeRef() {
    try {
      final XExpression e = this.expression("\'\'");
      this._jvmTypesBuilder.toGetter(e, "foo", null);
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
    Boolean _get = initialized.get();
    Assert.assertTrue((_get).booleanValue());
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
