package org.eclipse.xtend.core.tests.jvmmodel;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class JvmModelTests extends AbstractXtendTestCase {
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  @Extension
  private IBatchTypeResolver typeResolver;
  
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
  
  @Test
  public void testAnonymousClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new Runnable() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("int field");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("override run() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      XtendFunction _function = this.function(_string);
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(_function);
      Resource _eResource = operation.eResource();
      this.typeResolver.resolveTypes(_eResource);
      EList<JvmGenericType> _localClasses = operation.getLocalClasses();
      int _size = _localClasses.size();
      Assert.assertEquals(1, _size);
      EList<JvmGenericType> _localClasses_1 = operation.getLocalClasses();
      final JvmGenericType anonymous = IterableExtensions.<JvmGenericType>head(_localClasses_1);
      boolean _isFinal = anonymous.isFinal();
      Assert.assertTrue(_isFinal);
      boolean _isStatic = anonymous.isStatic();
      Assert.assertFalse(_isStatic);
      boolean _isLocal = anonymous.isLocal();
      Assert.assertTrue(_isLocal);
      boolean _isAnonymous = anonymous.isAnonymous();
      Assert.assertFalse(_isAnonymous);
      JvmVisibility _visibility = anonymous.getVisibility();
      Assert.assertEquals(JvmVisibility.DEFAULT, _visibility);
      EList<JvmTypeReference> _superTypes = anonymous.getSuperTypes();
      int _size_1 = _superTypes.size();
      Assert.assertEquals(1, _size_1);
      EList<JvmTypeReference> _superTypes_1 = anonymous.getSuperTypes();
      JvmTypeReference _head = IterableExtensions.<JvmTypeReference>head(_superTypes_1);
      String _qualifiedName = _head.getQualifiedName();
      Assert.assertEquals("java.lang.Runnable", _qualifiedName);
      EList<JvmMember> _members = anonymous.getMembers();
      int _size_2 = _members.size();
      Assert.assertEquals(3, _size_2);
      EList<JvmMember> _members_1 = anonymous.getMembers();
      final JvmMember constructor = IterableExtensions.<JvmMember>head(_members_1);
      Assert.assertTrue((constructor instanceof JvmConstructor));
      EList<JvmFormalParameter> _parameters = ((JvmConstructor) constructor).getParameters();
      int _size_3 = _parameters.size();
      Assert.assertEquals(0, _size_3);
      EList<JvmMember> _members_2 = anonymous.getMembers();
      JvmMember _get = _members_2.get(1);
      Assert.assertTrue((_get instanceof JvmField));
      EList<JvmMember> _members_3 = anonymous.getMembers();
      final JvmMember overriding = IterableExtensions.<JvmMember>last(_members_3);
      Assert.assertTrue((overriding instanceof JvmOperation));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAnonymousClass_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new Runnable() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("override run() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      XtendFunction _function = this.function(_string);
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(_function);
      Resource _eResource = operation.eResource();
      this.typeResolver.resolveTypes(_eResource);
      EList<JvmGenericType> _localClasses = operation.getLocalClasses();
      int _size = _localClasses.size();
      Assert.assertEquals(1, _size);
      EList<JvmGenericType> _localClasses_1 = operation.getLocalClasses();
      final JvmGenericType anonymous = IterableExtensions.<JvmGenericType>head(_localClasses_1);
      boolean _isFinal = anonymous.isFinal();
      Assert.assertTrue(_isFinal);
      boolean _isStatic = anonymous.isStatic();
      Assert.assertFalse(_isStatic);
      boolean _isLocal = anonymous.isLocal();
      Assert.assertTrue(_isLocal);
      boolean _isAnonymous = anonymous.isAnonymous();
      Assert.assertTrue(_isAnonymous);
      JvmVisibility _visibility = anonymous.getVisibility();
      Assert.assertEquals(JvmVisibility.DEFAULT, _visibility);
      EList<JvmTypeReference> _superTypes = anonymous.getSuperTypes();
      int _size_1 = _superTypes.size();
      Assert.assertEquals(1, _size_1);
      EList<JvmTypeReference> _superTypes_1 = anonymous.getSuperTypes();
      JvmTypeReference _head = IterableExtensions.<JvmTypeReference>head(_superTypes_1);
      String _qualifiedName = _head.getQualifiedName();
      Assert.assertEquals("java.lang.Runnable", _qualifiedName);
      EList<JvmMember> _members = anonymous.getMembers();
      int _size_2 = _members.size();
      Assert.assertEquals(2, _size_2);
      EList<JvmMember> _members_1 = anonymous.getMembers();
      final JvmMember constructor = IterableExtensions.<JvmMember>head(_members_1);
      Assert.assertTrue((constructor instanceof JvmConstructor));
      EList<JvmFormalParameter> _parameters = ((JvmConstructor) constructor).getParameters();
      int _size_3 = _parameters.size();
      Assert.assertEquals(0, _size_3);
      EList<JvmMember> _members_2 = anonymous.getMembers();
      final JvmMember overriding = IterableExtensions.<JvmMember>last(_members_2);
      Assert.assertTrue((overriding instanceof JvmOperation));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAnonymousClass_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def <T> foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new Iterable<T>() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("override iterator() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      XtendFunction _function = this.function(_string);
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(_function);
      Resource _eResource = operation.eResource();
      this.typeResolver.resolveTypes(_eResource);
      EList<JvmGenericType> _localClasses = operation.getLocalClasses();
      int _size = _localClasses.size();
      Assert.assertEquals(1, _size);
      EList<JvmGenericType> _localClasses_1 = operation.getLocalClasses();
      final JvmGenericType anonymous = IterableExtensions.<JvmGenericType>head(_localClasses_1);
      boolean _isFinal = anonymous.isFinal();
      Assert.assertTrue(_isFinal);
      boolean _isStatic = anonymous.isStatic();
      Assert.assertFalse(_isStatic);
      boolean _isLocal = anonymous.isLocal();
      Assert.assertTrue(_isLocal);
      boolean _isAnonymous = anonymous.isAnonymous();
      Assert.assertTrue(_isAnonymous);
      EList<JvmTypeParameter> _typeParameters = anonymous.getTypeParameters();
      int _size_1 = _typeParameters.size();
      Assert.assertEquals(0, _size_1);
      JvmVisibility _visibility = anonymous.getVisibility();
      Assert.assertEquals(JvmVisibility.DEFAULT, _visibility);
      EList<JvmTypeReference> _superTypes = anonymous.getSuperTypes();
      int _size_2 = _superTypes.size();
      Assert.assertEquals(1, _size_2);
      EList<JvmTypeReference> _superTypes_1 = anonymous.getSuperTypes();
      JvmTypeReference _head = IterableExtensions.<JvmTypeReference>head(_superTypes_1);
      String _qualifiedName = _head.getQualifiedName();
      Assert.assertEquals("java.lang.Iterable<T>", _qualifiedName);
      EList<JvmMember> _members = anonymous.getMembers();
      int _size_3 = _members.size();
      Assert.assertEquals(2, _size_3);
      EList<JvmMember> _members_1 = anonymous.getMembers();
      final JvmMember constructor = IterableExtensions.<JvmMember>head(_members_1);
      Assert.assertTrue((constructor instanceof JvmConstructor));
      EList<JvmTypeParameter> _typeParameters_1 = ((JvmConstructor) constructor).getTypeParameters();
      int _size_4 = _typeParameters_1.size();
      Assert.assertEquals(0, _size_4);
      EList<JvmMember> _members_2 = anonymous.getMembers();
      final JvmMember overriding = IterableExtensions.<JvmMember>last(_members_2);
      Assert.assertTrue((overriding instanceof JvmOperation));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNestedClass_0() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static class Nested0 {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("interface Nested1 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("annotation Nested2 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("enum Nested3 {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      XtendClass _clazz = this.clazz(_string);
      final JvmGenericType clazz = this._iXtendJvmAssociations.getInferredType(_clazz);
      EList<JvmMember> _members = clazz.getMembers();
      int _size = _members.size();
      Assert.assertEquals(2, _size);
      EList<JvmMember> _members_1 = clazz.getMembers();
      JvmMember _head = IterableExtensions.<JvmMember>head(_members_1);
      Assert.assertTrue((_head instanceof JvmGenericType));
      EList<JvmMember> _members_2 = clazz.getMembers();
      JvmMember _head_1 = IterableExtensions.<JvmMember>head(_members_2);
      final JvmGenericType nested0 = ((JvmGenericType) _head_1);
      String _simpleName = nested0.getSimpleName();
      Assert.assertEquals("Nested0", _simpleName);
      boolean _isStatic = nested0.isStatic();
      Assert.assertTrue(_isStatic);
      EList<JvmMember> _members_3 = nested0.getMembers();
      int _size_1 = _members_3.size();
      Assert.assertEquals(2, _size_1);
      EList<JvmMember> _members_4 = nested0.getMembers();
      JvmMember _head_2 = IterableExtensions.<JvmMember>head(_members_4);
      Assert.assertTrue((_head_2 instanceof JvmGenericType));
      EList<JvmMember> _members_5 = nested0.getMembers();
      JvmMember _head_3 = IterableExtensions.<JvmMember>head(_members_5);
      final JvmGenericType nested1 = ((JvmGenericType) _head_3);
      String _simpleName_1 = nested1.getSimpleName();
      Assert.assertEquals("Nested1", _simpleName_1);
      boolean _isStatic_1 = nested1.isStatic();
      Assert.assertTrue(_isStatic_1);
      EList<JvmMember> _members_6 = nested1.getMembers();
      int _size_2 = _members_6.size();
      Assert.assertEquals(2, _size_2);
      EList<JvmMember> _members_7 = nested1.getMembers();
      JvmMember _head_4 = IterableExtensions.<JvmMember>head(_members_7);
      Assert.assertTrue((_head_4 instanceof JvmAnnotationType));
      EList<JvmMember> _members_8 = nested1.getMembers();
      JvmMember _head_5 = IterableExtensions.<JvmMember>head(_members_8);
      final JvmAnnotationType nested2 = ((JvmAnnotationType) _head_5);
      String _simpleName_2 = nested2.getSimpleName();
      Assert.assertEquals("Nested2", _simpleName_2);
      boolean _isStatic_2 = nested2.isStatic();
      Assert.assertTrue(_isStatic_2);
      EList<JvmMember> _members_9 = nested1.getMembers();
      int _size_3 = _members_9.size();
      Assert.assertEquals(2, _size_3);
      EList<JvmMember> _members_10 = nested1.getMembers();
      JvmMember _last = IterableExtensions.<JvmMember>last(_members_10);
      Assert.assertTrue((_last instanceof JvmEnumerationType));
      EList<JvmMember> _members_11 = nested1.getMembers();
      JvmMember _last_1 = IterableExtensions.<JvmMember>last(_members_11);
      final JvmEnumerationType nested3 = ((JvmEnumerationType) _last_1);
      String _simpleName_3 = nested3.getSimpleName();
      Assert.assertEquals("Nested3", _simpleName_3);
      boolean _isStatic_3 = nested3.isStatic();
      Assert.assertTrue(_isStatic_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
