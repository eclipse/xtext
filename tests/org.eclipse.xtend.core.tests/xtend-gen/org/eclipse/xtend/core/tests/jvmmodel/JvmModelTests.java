package org.eclipse.xtend.core.tests.jvmmodel;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class JvmModelTests extends AbstractXtendTestCase {
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Test
  public void testClassImplicitSuperType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      XtendClass _clazz = this.clazz(_string);
      final JvmGenericType inferred = this._iXtendJvmAssociations.getInferredType(_clazz);
      EList<JvmTypeReference> _superTypes = inferred.getSuperTypes();
      int _size = _superTypes.size();
      Assert.assertEquals(1, _size);
      EList<JvmTypeReference> _superTypes_1 = inferred.getSuperTypes();
      JvmTypeReference _head = IterableExtensions.<JvmTypeReference>head(_superTypes_1);
      String _identifier = _head.getIdentifier();
      Assert.assertEquals("java.lang.Object", _identifier);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInterfaceImplicitSuperType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      XtendInterface _interfaze = this.interfaze(_string);
      final JvmGenericType inferred = this._iXtendJvmAssociations.getInferredType(_interfaze);
      EList<JvmTypeReference> _superTypes = inferred.getSuperTypes();
      int _size = _superTypes.size();
      Assert.assertEquals(1, _size);
      EList<JvmTypeReference> _superTypes_1 = inferred.getSuperTypes();
      JvmTypeReference _head = IterableExtensions.<JvmTypeReference>head(_superTypes_1);
      String _identifier = _head.getIdentifier();
      Assert.assertEquals("java.lang.Object", _identifier);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAnnotationImplicitSuperType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotation Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      XtendAnnotationType _annotationType = this.annotationType(_string);
      final JvmAnnotationType inferred = this._iXtendJvmAssociations.getInferredAnnotationType(_annotationType);
      EList<JvmTypeReference> _superTypes = inferred.getSuperTypes();
      int _size = _superTypes.size();
      Assert.assertEquals(1, _size);
      EList<JvmTypeReference> _superTypes_1 = inferred.getSuperTypes();
      JvmTypeReference _head = IterableExtensions.<JvmTypeReference>head(_superTypes_1);
      String _identifier = _head.getIdentifier();
      Assert.assertEquals("java.lang.annotation.Annotation", _identifier);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEmptyListAsAnnotationValueDefault() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotation Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String[] bar = #[]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      XtendAnnotationType _annotationType = this.annotationType(_string);
      JvmAnnotationType _inferredAnnotationType = this._iXtendJvmAssociations.getInferredAnnotationType(_annotationType);
      EList<JvmMember> _members = _inferredAnnotationType.getMembers();
      JvmMember _head = IterableExtensions.<JvmMember>head(_members);
      final JvmOperation inferred = ((JvmOperation) _head);
      JvmTypeReference _returnType = inferred.getReturnType();
      String _identifier = _returnType.getIdentifier();
      Assert.assertEquals("java.lang.String[]", _identifier);
      JvmAnnotationValue _defaultValue = inferred.getDefaultValue();
      Assert.assertTrue((_defaultValue instanceof JvmCustomAnnotationValue));
      JvmAnnotationValue _defaultValue_1 = inferred.getDefaultValue();
      EList<Object> _values = ((JvmCustomAnnotationValue) _defaultValue_1).getValues();
      Object _head_1 = IterableExtensions.<Object>head(_values);
      Assert.assertTrue((_head_1 instanceof XListLiteral));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnumImplicitSuperType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("enum Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      XtendEnum _enumeration = this.enumeration(_string);
      final JvmEnumerationType inferred = this._iXtendJvmAssociations.getInferredEnumerationType(_enumeration);
      EList<JvmTypeReference> _superTypes = inferred.getSuperTypes();
      int _size = _superTypes.size();
      Assert.assertEquals(1, _size);
      EList<JvmTypeReference> _superTypes_1 = inferred.getSuperTypes();
      JvmTypeReference _head = IterableExtensions.<JvmTypeReference>head(_superTypes_1);
      String _identifier = _head.getIdentifier();
      Assert.assertEquals("java.lang.Enum<Foo>", _identifier);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnumLiteralIsStatic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("enum Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("BAR");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      XtendEnum _enumeration = this.enumeration(_string);
      JvmEnumerationType _inferredEnumerationType = this._iXtendJvmAssociations.getInferredEnumerationType(_enumeration);
      EList<JvmMember> _members = _inferredEnumerationType.getMembers();
      JvmMember _head = IterableExtensions.<JvmMember>head(_members);
      final JvmEnumerationLiteral inferred = ((JvmEnumerationLiteral) _head);
      boolean _isStatic = inferred.isStatic();
      Assert.assertTrue(_isStatic);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnumArtificialMethods() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package bar");
      _builder.newLine();
      _builder.newLine();
      _builder.append("enum Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      XtendEnum _enumeration = this.enumeration(_string);
      JvmEnumerationType _inferredEnumerationType = this._iXtendJvmAssociations.getInferredEnumerationType(_enumeration);
      final EList<JvmMember> inferred = _inferredEnumerationType.getMembers();
      int _size = inferred.size();
      Assert.assertEquals(2, _size);
      JvmMember _get = inferred.get(0);
      final JvmOperation values = ((JvmOperation) _get);
      String _identifier = values.getIdentifier();
      Assert.assertEquals("bar.Foo.values()", _identifier);
      boolean _isStatic = values.isStatic();
      Assert.assertTrue(_isStatic);
      JvmVisibility _visibility = values.getVisibility();
      Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
      JvmMember _get_1 = inferred.get(1);
      final JvmOperation valueOf = ((JvmOperation) _get_1);
      String _identifier_1 = valueOf.getIdentifier();
      Assert.assertEquals("bar.Foo.valueOf(java.lang.String)", _identifier_1);
      boolean _isStatic_1 = valueOf.isStatic();
      Assert.assertTrue(_isStatic_1);
      JvmVisibility _visibility_1 = valueOf.getVisibility();
      Assert.assertEquals(JvmVisibility.PUBLIC, _visibility_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
