package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import java.util.ArrayList;
import junit.framework.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationValueArray;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsFactory;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

@SuppressWarnings("all")
public class JvmTypesBuilderTest extends AbstractXbaseTestCase {
  @Inject
  private TypeReferences references;
  
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  public void testEmptyAnnotation() throws Exception {
      final XAnnotationsFactory f = XAnnotationsFactory.eINSTANCE;
      final TypesFactory typesFactory = TypesFactory.eINSTANCE;
      XExpression _expression = this.expression("\'Foo\'");
      final XExpression e = _expression;
      XAnnotation _createXAnnotation = f.createXAnnotation();
      final XAnnotation anno = _createXAnnotation;
      JvmType _findDeclaredType = this.references.findDeclaredType(com.google.inject.Inject.class, e);
      anno.setAnnotationType(((JvmAnnotationType) _findDeclaredType));
      JvmGenericType _createJvmGenericType = typesFactory.createJvmGenericType();
      final JvmGenericType type = _createJvmGenericType;
      ArrayList<XAnnotation> _newArrayList = CollectionLiterals.<XAnnotation>newArrayList(anno);
      this._jvmTypesBuilder.translateAnnotationsTo(_newArrayList, type);
      JvmAnnotationType _annotationType = anno.getAnnotationType();
      EList<JvmAnnotationReference> _annotations = type.getAnnotations();
      JvmAnnotationReference _head = IterableExtensions.<JvmAnnotationReference>head(_annotations);
      JvmAnnotationType _annotation = _head.getAnnotation();
      Assert.assertEquals(_annotationType, _annotation);
  }
  
  public void testStringAnnotation() throws Exception {
      final XAnnotationsFactory f = XAnnotationsFactory.eINSTANCE;
      final TypesFactory typesFactory = TypesFactory.eINSTANCE;
      XExpression _expression = this.expression("\'Foo\'");
      final XExpression e = _expression;
      XAnnotation _createXAnnotation = f.createXAnnotation();
      final XAnnotation anno = _createXAnnotation;
      JvmType _findDeclaredType = this.references.findDeclaredType(com.google.inject.Inject.class, e);
      anno.setAnnotationType(((JvmAnnotationType) _findDeclaredType));
      anno.setValue(e);
      JvmGenericType _createJvmGenericType = typesFactory.createJvmGenericType();
      final JvmGenericType type = _createJvmGenericType;
      ArrayList<XAnnotation> _newArrayList = CollectionLiterals.<XAnnotation>newArrayList(anno);
      this._jvmTypesBuilder.translateAnnotationsTo(_newArrayList, type);
      JvmAnnotationType _annotationType = anno.getAnnotationType();
      EList<JvmAnnotationReference> _annotations = type.getAnnotations();
      JvmAnnotationReference _head = IterableExtensions.<JvmAnnotationReference>head(_annotations);
      JvmAnnotationType _annotation = _head.getAnnotation();
      Assert.assertEquals(_annotationType, _annotation);
      EList<JvmAnnotationReference> _annotations_1 = type.getAnnotations();
      JvmAnnotationReference _head_1 = IterableExtensions.<JvmAnnotationReference>head(_annotations_1);
      EList<JvmAnnotationValue> _values = _head_1.getValues();
      JvmAnnotationValue _head_2 = IterableExtensions.<JvmAnnotationValue>head(_values);
      EList<String> _values_1 = ((JvmStringAnnotationValue) _head_2).getValues();
      String _head_3 = IterableExtensions.<String>head(_values_1);
      Assert.assertEquals("Foo", _head_3);
  }
  
  public void testStringAnnotationWithNullExpression() throws Exception {
      final XAnnotationsFactory f = XAnnotationsFactory.eINSTANCE;
      final TypesFactory typesFactory = TypesFactory.eINSTANCE;
      XExpression _expression = this.expression("\'Foo\'");
      final XExpression context = _expression;
      XAnnotation _createXAnnotation = f.createXAnnotation();
      final XAnnotation anno = _createXAnnotation;
      JvmType _findDeclaredType = this.references.findDeclaredType(com.google.inject.Inject.class, context);
      anno.setAnnotationType(((JvmAnnotationType) _findDeclaredType));
      XAnnotationElementValuePair _createXAnnotationElementValuePair = f.createXAnnotationElementValuePair();
      final XAnnotationElementValuePair pair = _createXAnnotationElementValuePair;
      EList<XAnnotationElementValuePair> _elementValuePairs = anno.getElementValuePairs();
      CollectionExtensions.<XAnnotationElementValuePair>operator_add(_elementValuePairs, pair);
      JvmGenericType _createJvmGenericType = typesFactory.createJvmGenericType();
      final JvmGenericType type = _createJvmGenericType;
      ArrayList<XAnnotation> _newArrayList = CollectionLiterals.<XAnnotation>newArrayList(anno);
      this._jvmTypesBuilder.translateAnnotationsTo(_newArrayList, type);
      JvmAnnotationType _annotationType = anno.getAnnotationType();
      EList<JvmAnnotationReference> _annotations = type.getAnnotations();
      JvmAnnotationReference _head = IterableExtensions.<JvmAnnotationReference>head(_annotations);
      JvmAnnotationType _annotation = _head.getAnnotation();
      Assert.assertEquals(_annotationType, _annotation);
      EList<JvmAnnotationReference> _annotations_1 = type.getAnnotations();
      JvmAnnotationReference _head_1 = IterableExtensions.<JvmAnnotationReference>head(_annotations_1);
      EList<JvmAnnotationValue> _values = _head_1.getValues();
      boolean _isEmpty = _values.isEmpty();
      Assert.assertTrue(_isEmpty);
  }
  
  public void testStringArrayAnnotation() throws Exception {
      final XAnnotationsFactory f = XAnnotationsFactory.eINSTANCE;
      final TypesFactory typesFactory = TypesFactory.eINSTANCE;
      XExpression _expression = this.expression("\'Foo\'");
      final XExpression e = _expression;
      XExpression _expression_1 = this.expression("\'Bar\'");
      final XExpression e2 = _expression_1;
      XAnnotation _createXAnnotation = f.createXAnnotation();
      final XAnnotation anno = _createXAnnotation;
      JvmType _findDeclaredType = this.references.findDeclaredType(com.google.inject.Inject.class, e);
      anno.setAnnotationType(((JvmAnnotationType) _findDeclaredType));
      XAnnotationValueArray _createXAnnotationValueArray = f.createXAnnotationValueArray();
      final XAnnotationValueArray array = _createXAnnotationValueArray;
      anno.setValue(array);
      EList<XExpression> _values = array.getValues();
      CollectionExtensions.<XExpression>operator_add(_values, e);
      EList<XExpression> _values_1 = array.getValues();
      CollectionExtensions.<XExpression>operator_add(_values_1, e2);
      JvmGenericType _createJvmGenericType = typesFactory.createJvmGenericType();
      final JvmGenericType type = _createJvmGenericType;
      ArrayList<XAnnotation> _newArrayList = CollectionLiterals.<XAnnotation>newArrayList(anno);
      this._jvmTypesBuilder.translateAnnotationsTo(_newArrayList, type);
      JvmAnnotationType _annotationType = anno.getAnnotationType();
      EList<JvmAnnotationReference> _annotations = type.getAnnotations();
      JvmAnnotationReference _head = IterableExtensions.<JvmAnnotationReference>head(_annotations);
      JvmAnnotationType _annotation = _head.getAnnotation();
      Assert.assertEquals(_annotationType, _annotation);
      EList<JvmAnnotationReference> _annotations_1 = type.getAnnotations();
      JvmAnnotationReference _head_1 = IterableExtensions.<JvmAnnotationReference>head(_annotations_1);
      EList<JvmAnnotationValue> _values_2 = _head_1.getValues();
      JvmAnnotationValue _head_2 = IterableExtensions.<JvmAnnotationValue>head(_values_2);
      EList<String> _values_3 = ((JvmStringAnnotationValue) _head_2).getValues();
      String _head_3 = IterableExtensions.<String>head(_values_3);
      Assert.assertEquals("Foo", _head_3);
      EList<JvmAnnotationReference> _annotations_2 = type.getAnnotations();
      JvmAnnotationReference _head_4 = IterableExtensions.<JvmAnnotationReference>head(_annotations_2);
      EList<JvmAnnotationValue> _values_4 = _head_4.getValues();
      JvmAnnotationValue _head_5 = IterableExtensions.<JvmAnnotationValue>head(_values_4);
      EList<String> _values_5 = ((JvmStringAnnotationValue) _head_5).getValues();
      String _get = _values_5.get(1);
      Assert.assertEquals("Bar", _get);
  }
  
  public void testStringArrayAnnotationWithNullExpression() throws Exception {
      final XAnnotationsFactory f = XAnnotationsFactory.eINSTANCE;
      final TypesFactory typesFactory = TypesFactory.eINSTANCE;
      XExpression _expression = this.expression("\"foo\"");
      final XExpression context = _expression;
      XAnnotation _createXAnnotation = f.createXAnnotation();
      final XAnnotation anno = _createXAnnotation;
      JvmType _findDeclaredType = this.references.findDeclaredType(com.google.inject.Inject.class, context);
      anno.setAnnotationType(((JvmAnnotationType) _findDeclaredType));
      XAnnotationValueArray _createXAnnotationValueArray = f.createXAnnotationValueArray();
      final XAnnotationValueArray array = _createXAnnotationValueArray;
      anno.setValue(array);
      JvmGenericType _createJvmGenericType = typesFactory.createJvmGenericType();
      final JvmGenericType type = _createJvmGenericType;
      ArrayList<XAnnotation> _newArrayList = CollectionLiterals.<XAnnotation>newArrayList(anno);
      this._jvmTypesBuilder.translateAnnotationsTo(_newArrayList, type);
      JvmAnnotationType _annotationType = anno.getAnnotationType();
      EList<JvmAnnotationReference> _annotations = type.getAnnotations();
      JvmAnnotationReference _head = IterableExtensions.<JvmAnnotationReference>head(_annotations);
      JvmAnnotationType _annotation = _head.getAnnotation();
      Assert.assertEquals(_annotationType, _annotation);
      EList<JvmAnnotationReference> _annotations_1 = type.getAnnotations();
      JvmAnnotationReference _head_1 = IterableExtensions.<JvmAnnotationReference>head(_annotations_1);
      EList<JvmAnnotationValue> _values = _head_1.getValues();
      boolean _isEmpty = _values.isEmpty();
      Assert.assertTrue(_isEmpty);
  }
}
