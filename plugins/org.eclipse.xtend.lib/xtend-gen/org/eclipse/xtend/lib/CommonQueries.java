package org.eclipse.xtend.lib;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * @since 2.7
 */
@Beta
@SuppressWarnings("all")
public class CommonQueries {
  public static boolean hasHashCode(final ClassDeclaration cls) {
    MethodDeclaration _findDeclaredMethod = cls.findDeclaredMethod("hashCode");
    return (_findDeclaredMethod != null);
  }
  
  public static boolean hasEquals(final ClassDeclaration cls) {
    Iterable<? extends MethodDeclaration> _declaredMethods = cls.getDeclaredMethods();
    final Function1<MethodDeclaration, Boolean> _function = new Function1<MethodDeclaration, Boolean>() {
      public Boolean apply(final MethodDeclaration it) {
        boolean _and = false;
        boolean _and_1 = false;
        String _simpleName = it.getSimpleName();
        boolean _equals = Objects.equal(_simpleName, "equals");
        if (!_equals) {
          _and_1 = false;
        } else {
          Iterable<? extends ParameterDeclaration> _parameters = it.getParameters();
          int _size = IterableExtensions.size(_parameters);
          boolean _equals_1 = (_size == 1);
          _and_1 = _equals_1;
        }
        if (!_and_1) {
          _and = false;
        } else {
          Iterable<? extends ParameterDeclaration> _parameters_1 = it.getParameters();
          ParameterDeclaration _head = IterableExtensions.head(_parameters_1);
          TypeReference _type = _head.getType();
          String _simpleName_1 = _type.getSimpleName();
          boolean _equals_2 = Objects.equal(_simpleName_1, "java.lang.Object");
          _and = _equals_2;
        }
        return Boolean.valueOf(_and);
      }
    };
    return IterableExtensions.exists(_declaredMethods, _function);
  }
  
  public static boolean hasToString(final ClassDeclaration cls) {
    MethodDeclaration _findDeclaredMethod = cls.findDeclaredMethod("toString");
    return (_findDeclaredMethod != null);
  }
  
  public static boolean hasGetter(final FieldDeclaration field) {
    TypeDeclaration _declaringType = field.getDeclaringType();
    String _getterName = CommonQueries.getGetterName(field);
    MethodDeclaration _findDeclaredMethod = _declaringType.findDeclaredMethod(_getterName);
    return (_findDeclaredMethod != null);
  }
  
  public static String getGetterName(final FieldDeclaration field) {
    String _xifexpression = null;
    TypeReference _type = field.getType();
    boolean _isBooleanType = CommonQueries.isBooleanType(_type);
    if (_isBooleanType) {
      _xifexpression = "is";
    } else {
      _xifexpression = "get";
    }
    String _simpleName = field.getSimpleName();
    String _firstUpper = StringExtensions.toFirstUpper(_simpleName);
    return (_xifexpression + _firstUpper);
  }
  
  public static boolean hasSetter(final FieldDeclaration field) {
    TypeDeclaration _declaringType = field.getDeclaringType();
    String _setterName = CommonQueries.getSetterName(field);
    TypeReference _type = field.getType();
    MethodDeclaration _findDeclaredMethod = _declaringType.findDeclaredMethod(_setterName, _type);
    return (_findDeclaredMethod != null);
  }
  
  public static String getSetterName(final FieldDeclaration field) {
    String _simpleName = field.getSimpleName();
    String _firstUpper = StringExtensions.toFirstUpper(_simpleName);
    return ("set" + _firstUpper);
  }
  
  public static boolean isBooleanType(final TypeReference type) {
    boolean _and = false;
    boolean _isInferred = type.isInferred();
    boolean _not = (!_isInferred);
    if (!_not) {
      _and = false;
    } else {
      boolean _or = false;
      String _simpleName = type.getSimpleName();
      String _name = Boolean.class.getName();
      boolean _equals = Objects.equal(_simpleName, _name);
      if (_equals) {
        _or = true;
      } else {
        String _simpleName_1 = type.getSimpleName();
        String _name_1 = Boolean.TYPE.getName();
        boolean _equals_1 = Objects.equal(_simpleName_1, _name_1);
        _or = _equals_1;
      }
      _and = _or;
    }
    return _and;
  }
  
  public static Iterable<? extends FieldDeclaration> getInstanceFields(final ClassDeclaration cls) {
    Iterable<? extends FieldDeclaration> _declaredFields = cls.getDeclaredFields();
    final Function1<FieldDeclaration, Boolean> _function = new Function1<FieldDeclaration, Boolean>() {
      public Boolean apply(final FieldDeclaration it) {
        boolean _isStatic = it.isStatic();
        return Boolean.valueOf((!_isStatic));
      }
    };
    return IterableExtensions.filter(_declaredFields, _function);
  }
  
  public static Iterable<? extends MutableFieldDeclaration> getInstanceFields(final MutableClassDeclaration cls) {
    Iterable<? extends MutableFieldDeclaration> _declaredFields = cls.getDeclaredFields();
    final Function1<MutableFieldDeclaration, Boolean> _function = new Function1<MutableFieldDeclaration, Boolean>() {
      public Boolean apply(final MutableFieldDeclaration it) {
        boolean _isStatic = it.isStatic();
        return Boolean.valueOf((!_isStatic));
      }
    };
    return IterableExtensions.filter(_declaredFields, _function);
  }
  
  public static Iterable<? extends FieldDeclaration> getPersistentFields(final ClassDeclaration cls) {
    Iterable<? extends FieldDeclaration> _declaredFields = cls.getDeclaredFields();
    final Function1<FieldDeclaration, Boolean> _function = new Function1<FieldDeclaration, Boolean>() {
      public Boolean apply(final FieldDeclaration it) {
        boolean _and = false;
        boolean _isStatic = it.isStatic();
        boolean _not = (!_isStatic);
        if (!_not) {
          _and = false;
        } else {
          boolean _isTransient = it.isTransient();
          boolean _not_1 = (!_isTransient);
          _and = _not_1;
        }
        return Boolean.valueOf(_and);
      }
    };
    return IterableExtensions.filter(_declaredFields, _function);
  }
  
  public static Iterable<? extends MutableFieldDeclaration> getPersistentFields(final MutableClassDeclaration cls) {
    Iterable<? extends MutableFieldDeclaration> _declaredFields = cls.getDeclaredFields();
    final Function1<MutableFieldDeclaration, Boolean> _function = new Function1<MutableFieldDeclaration, Boolean>() {
      public Boolean apply(final MutableFieldDeclaration it) {
        boolean _and = false;
        boolean _isStatic = it.isStatic();
        boolean _not = (!_isStatic);
        if (!_not) {
          _and = false;
        } else {
          boolean _isTransient = it.isTransient();
          boolean _not_1 = (!_isTransient);
          _and = _not_1;
        }
        return Boolean.valueOf(_and);
      }
    };
    return IterableExtensions.filter(_declaredFields, _function);
  }
}
