package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import foo.TestAnnotation3;
import java.util.ArrayList;
import java.util.List;
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
import org.eclipse.xtext.junit4.logging.LoggingTester;
import org.eclipse.xtext.resource.XtextResource;
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
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function3;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
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
  
  @Test
  public void testEmptyAnnotation() {
    try {
      final XAnnotationsFactory f = XAnnotationsFactory.eINSTANCE;
      final XExpression e = this.expression("\'Foo\'");
      final XAnnotation anno = f.createXAnnotation();
      JvmType _findDeclaredType = this.references.findDeclaredType(Inject.class, e);
      anno.setAnnotationType(((JvmAnnotationType) _findDeclaredType));
      final JvmGenericType type = this.typesFactory.createJvmGenericType();
      ArrayList<XAnnotation> _newArrayList = CollectionLiterals.<XAnnotation>newArrayList(anno);
      this._jvmTypesBuilder.translateAnnotationsTo(_newArrayList, type);
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
      ArrayList<XAnnotation> _newArrayList = CollectionLiterals.<XAnnotation>newArrayList(anno);
      this._jvmTypesBuilder.translateAnnotationsTo(_newArrayList, type);
      JvmType _annotationType = anno.getAnnotationType();
      EList<JvmAnnotationReference> _annotations = type.getAnnotations();
      JvmAnnotationReference _head = IterableExtensions.<JvmAnnotationReference>head(_annotations);
      JvmAnnotationType _annotation = _head.getAnnotation();
      Assert.assertEquals(_annotationType, _annotation);
      EList<JvmAnnotationReference> _annotations_1 = type.getAnnotations();
      JvmAnnotationReference _head_1 = IterableExtensions.<JvmAnnotationReference>head(_annotations_1);
      EList<JvmAnnotationValue> _values = _head_1.getValues();
      JvmAnnotationValue _head_2 = IterableExtensions.<JvmAnnotationValue>head(_values);
      EList<Object> _values_1 = ((JvmCustomAnnotationValue) _head_2).getValues();
      Object _head_3 = IterableExtensions.<Object>head(_values_1);
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
      ArrayList<XAnnotation> _newArrayList = CollectionLiterals.<XAnnotation>newArrayList(anno);
      this._jvmTypesBuilder.translateAnnotationsTo(_newArrayList, type);
      JvmType _annotationType = anno.getAnnotationType();
      EList<JvmAnnotationReference> _annotations = type.getAnnotations();
      JvmAnnotationReference _head = IterableExtensions.<JvmAnnotationReference>head(_annotations);
      JvmAnnotationType _annotation = _head.getAnnotation();
      Assert.assertEquals(_annotationType, _annotation);
      EList<JvmAnnotationReference> _annotations_1 = type.getAnnotations();
      JvmAnnotationReference _head_1 = IterableExtensions.<JvmAnnotationReference>head(_annotations_1);
      EList<JvmAnnotationValue> _values = _head_1.getValues();
      JvmAnnotationValue _head_2 = IterableExtensions.<JvmAnnotationValue>head(_values);
      EList<Object> _values_1 = ((JvmCustomAnnotationValue) _head_2).getValues();
      Object _head_3 = IterableExtensions.<Object>head(_values_1);
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
      ArrayList<XAnnotation> _newArrayList = CollectionLiterals.<XAnnotation>newArrayList(anno);
      this._jvmTypesBuilder.translateAnnotationsTo(_newArrayList, type);
      JvmType _annotationType = anno.getAnnotationType();
      EList<JvmAnnotationReference> _annotations = type.getAnnotations();
      JvmAnnotationReference _head = IterableExtensions.<JvmAnnotationReference>head(_annotations);
      JvmAnnotationType _annotation = _head.getAnnotation();
      Assert.assertEquals(_annotationType, _annotation);
      EList<JvmAnnotationReference> _annotations_1 = type.getAnnotations();
      JvmAnnotationReference _head_1 = IterableExtensions.<JvmAnnotationReference>head(_annotations_1);
      EList<JvmAnnotationValue> _values = _head_1.getValues();
      boolean _isEmpty = _values.isEmpty();
      Assert.assertTrue(_isEmpty);
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
      ArrayList<XAnnotation> _newArrayList = CollectionLiterals.<XAnnotation>newArrayList(anno);
      this._jvmTypesBuilder.translateAnnotationsTo(_newArrayList, type);
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
      EList<Object> _values_2 = value.getValues();
      Object _head_5 = IterableExtensions.<Object>head(_values_2);
      Assert.assertTrue((_head_5 instanceof XNumberLiteral));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAnnotationCreation() {
    try {
      final XExpression e = this.expression("\'foo\'");
      final Procedure1<JvmAnnotationType> _function = new Procedure1<JvmAnnotationType>() {
        public void apply(final JvmAnnotationType it) {
          JvmTypesBuilderTest.this._jvmTypesBuilder.setDocumentation(it, "Foo");
        }
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
      final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          EList<JvmTypeReference> _superTypes = it.getSuperTypes();
          JvmTypeReference _newTypeRef = JvmTypesBuilderTest.this._jvmTypesBuilder.newTypeRef(e, Iterable.class);
          JvmTypesBuilderTest.this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _newTypeRef);
        }
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
      final Procedure1<JvmEnumerationType> _function = new Procedure1<JvmEnumerationType>() {
        public void apply(final JvmEnumerationType it) {
          JvmTypesBuilderTest.this._jvmTypesBuilder.setDocumentation(it, "Foo");
          EList<JvmMember> _members = it.getMembers();
          JvmEnumerationLiteral _enumerationLiteral = JvmTypesBuilderTest.this._jvmTypesBuilder.toEnumerationLiteral(e, "LITERAL0");
          JvmTypesBuilderTest.this._jvmTypesBuilder.<JvmEnumerationLiteral>operator_add(_members, _enumerationLiteral);
          EList<JvmMember> _members_1 = it.getMembers();
          JvmEnumerationLiteral _enumerationLiteral_1 = JvmTypesBuilderTest.this._jvmTypesBuilder.toEnumerationLiteral(e, "LITERAL1");
          JvmTypesBuilderTest.this._jvmTypesBuilder.<JvmEnumerationLiteral>operator_add(_members_1, _enumerationLiteral_1);
        }
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
      final Function1<JvmEnumerationLiteral,String> _function_1 = new Function1<JvmEnumerationLiteral,String>() {
        public String apply(final JvmEnumerationLiteral it) {
          String _simpleName = it.getSimpleName();
          return _simpleName;
        }
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
    final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
      public void apply(final ITreeAppendable it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("foo");
        it.append(_builder);
      }
    };
    this._jvmTypesBuilder.setBody(op, _function);
    final Procedure1<ITreeAppendable> _function_1 = new Procedure1<ITreeAppendable>() {
      public void apply(final ITreeAppendable it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("bar");
        it.append(_builder);
      }
    };
    this._jvmTypesBuilder.setBody(op, _function_1);
    EList<Adapter> _eAdapters = op.eAdapters();
    int _size = _eAdapters.size();
    Assert.assertEquals(1, _size);
  }
  
  @Test
  public void testSetBody_02() {
    final XNullLiteral expr = XbaseFactory.eINSTANCE.createXNullLiteral();
    XtextResource _xtextResource = new XtextResource();
    final XtextResource res = _xtextResource;
    res.setLanguageName("org.eclipse.xtext.xbase.Xbase");
    final JvmOperation op = this.typesFactory.createJvmOperation();
    EList<EObject> _contents = res.getContents();
    this._jvmTypesBuilder.<JvmOperation>operator_add(_contents, op);
    EList<EObject> _contents_1 = res.getContents();
    this._jvmTypesBuilder.<XNullLiteral>operator_add(_contents_1, expr);
    final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
      public void apply(final ITreeAppendable it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("bar");
        it.append(_builder);
      }
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
    final Procedure1<ITreeAppendable> _function_1 = new Procedure1<ITreeAppendable>() {
      public void apply(final ITreeAppendable it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("bar");
        it.append(_builder);
      }
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
    XtextResource _xtextResource = new XtextResource();
    final XtextResource res = _xtextResource;
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
  public void testAddNull() {
    BasicEList<String> _basicEList = new BasicEList<String>();
    final BasicEList<String> list = _basicEList;
    this._jvmTypesBuilder.<String>operator_add(list, null);
    boolean _isEmpty = list.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testAddAllNull() {
    BasicEList<String> _basicEList = new BasicEList<String>();
    final BasicEList<String> list = _basicEList;
    final List<String> otherList = CollectionLiterals.<String>newArrayList(null, null, null);
    this._jvmTypesBuilder.<String>operator_add(list, otherList);
    boolean _isEmpty = list.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testAddAllNull_1() {
    BasicEList<String> _basicEList = new BasicEList<String>();
    final BasicEList<String> list = _basicEList;
    final List<String> otherList = null;
    this._jvmTypesBuilder.<String>operator_add(list, otherList);
    boolean _isEmpty = list.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testInitializeSafely_0() {
    final Procedure1<Object> _function = new Procedure1<Object>() {
      public void apply(final Object it) {
        final Function3<EObject,String,Procedure1<? super JvmGenericType>,JvmGenericType> _function = new Function3<EObject,String,Procedure1<? super JvmGenericType>,JvmGenericType>() {
          public JvmGenericType apply(final EObject expr, final String name, final Procedure1<? super JvmGenericType> init) {
            JvmGenericType _class = JvmTypesBuilderTest.this._jvmTypesBuilder.toClass(expr, name, init);
            return _class;
          }
        };
        JvmTypesBuilderTest.this.<JvmGenericType>genericTestInitializeSafely(_function);
      }
    };
    this.expectErrorLogging(_function);
  }
  
  @Test
  public void testInitializeSafely_1() {
    final Procedure1<Object> _function = new Procedure1<Object>() {
      public void apply(final Object it) {
        final Function3<EObject,String,Procedure1<? super JvmConstructor>,JvmConstructor> _function = new Function3<EObject,String,Procedure1<? super JvmConstructor>,JvmConstructor>() {
          public JvmConstructor apply(final EObject expr, final String name, final Procedure1<? super JvmConstructor> init) {
            JvmConstructor _constructor = JvmTypesBuilderTest.this._jvmTypesBuilder.toConstructor(expr, init);
            return _constructor;
          }
        };
        JvmTypesBuilderTest.this.<JvmConstructor>genericTestInitializeSafely(_function);
      }
    };
    this.expectErrorLogging(_function);
  }
  
  @Test
  public void testInitializeSafely_2() {
    final Procedure1<Object> _function = new Procedure1<Object>() {
      public void apply(final Object it) {
        final Function3<EObject,String,Procedure1<? super JvmField>,JvmField> _function = new Function3<EObject,String,Procedure1<? super JvmField>,JvmField>() {
          public JvmField apply(final EObject expr, final String name, final Procedure1<? super JvmField> init) {
            JvmField _field = JvmTypesBuilderTest.this._jvmTypesBuilder.toField(expr, name, null, init);
            return _field;
          }
        };
        JvmTypesBuilderTest.this.<JvmField>genericTestInitializeSafely(_function);
      }
    };
    this.expectErrorLogging(_function);
  }
  
  @Test
  public void testInitializeSafely_3() {
    final Procedure1<Object> _function = new Procedure1<Object>() {
      public void apply(final Object it) {
        final Function3<EObject,String,Procedure1<? super JvmOperation>,JvmOperation> _function = new Function3<EObject,String,Procedure1<? super JvmOperation>,JvmOperation>() {
          public JvmOperation apply(final EObject expr, final String name, final Procedure1<? super JvmOperation> init) {
            JvmOperation _method = JvmTypesBuilderTest.this._jvmTypesBuilder.toMethod(expr, name, null, init);
            return _method;
          }
        };
        JvmTypesBuilderTest.this.<JvmOperation>genericTestInitializeSafely(_function);
      }
    };
    this.expectErrorLogging(_function);
  }
  
  @Test
  public void testInitializeSafely_4() {
    final Procedure1<Object> _function = new Procedure1<Object>() {
      public void apply(final Object it) {
        final Function3<EObject,String,Procedure1<? super JvmAnnotationType>,JvmAnnotationType> _function = new Function3<EObject,String,Procedure1<? super JvmAnnotationType>,JvmAnnotationType>() {
          public JvmAnnotationType apply(final EObject expr, final String name, final Procedure1<? super JvmAnnotationType> init) {
            JvmAnnotationType _annotationType = JvmTypesBuilderTest.this._jvmTypesBuilder.toAnnotationType(expr, name, init);
            return _annotationType;
          }
        };
        JvmTypesBuilderTest.this.<JvmAnnotationType>genericTestInitializeSafely(_function);
      }
    };
    this.expectErrorLogging(_function);
  }
  
  @Test
  public void testInitializeSafely_5() {
    final Procedure1<Object> _function = new Procedure1<Object>() {
      public void apply(final Object it) {
        final Function3<EObject,String,Procedure1<? super JvmEnumerationType>,JvmEnumerationType> _function = new Function3<EObject,String,Procedure1<? super JvmEnumerationType>,JvmEnumerationType>() {
          public JvmEnumerationType apply(final EObject expr, final String name, final Procedure1<? super JvmEnumerationType> init) {
            JvmEnumerationType _enumerationType = JvmTypesBuilderTest.this._jvmTypesBuilder.toEnumerationType(expr, name, init);
            return _enumerationType;
          }
        };
        JvmTypesBuilderTest.this.<JvmEnumerationType>genericTestInitializeSafely(_function);
      }
    };
    this.expectErrorLogging(_function);
  }
  
  protected <T extends Object> void genericTestInitializeSafely(final Function3<? super EObject,? super String,? super Procedure1<? super T>,? extends EObject> create) {
    final XNullLiteral expr = XbaseFactory.eINSTANCE.createXNullLiteral();
    Wrapper<Boolean> _wrapper = new Wrapper<Boolean>(Boolean.valueOf(false));
    final Wrapper<Boolean> initialized = _wrapper;
    final Procedure1<T> _function = new Procedure1<T>() {
      public void apply(final T it) {
        initialized.set(Boolean.valueOf(true));
        RuntimeException _runtimeException = new RuntimeException();
        throw _runtimeException;
      }
    };
    final EObject element = create.apply(expr, "foo", _function);
    Boolean _get = initialized.get();
    Assert.assertTrue((_get).booleanValue());
    Assert.assertNotNull(element);
  }
  
  protected void expectErrorLogging(final Procedure1<? super Object> block) {
    final Runnable _function = new Runnable() {
      public void run() {
        block.apply(null);
      }
    };
    final int loggings = LoggingTester.countErrorLogging(JvmTypesBuilder.class, _function);
    Assert.assertEquals("Unexpected amount of error logging.", 1, loggings);
  }
}
