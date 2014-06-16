package org.eclipse.xtend.lib;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * @since 2.7
 */
@Beta
@SuppressWarnings("all")
public class PropertyProcessor extends AbstractFieldProcessor {
  public void doTransform(final MutableFieldDeclaration it, @Extension final TransformationContext context) {
    boolean _hasGetter = this.hasGetter(it);
    boolean _not = (!_hasGetter);
    if (_not) {
      this.addGetter(it, context);
    }
    boolean _and = false;
    boolean _isFinal = it.isFinal();
    boolean _not_1 = (!_isFinal);
    if (!_not_1) {
      _and = false;
    } else {
      boolean _hasSetter = this.hasSetter(it);
      boolean _not_2 = (!_hasSetter);
      _and = _not_2;
    }
    if (_and) {
      this.addSetter(it, context);
    }
    String _simpleName = it.getSimpleName();
    String _firstLower = StringExtensions.toFirstLower(_simpleName);
    String _plus = ("_" + _firstLower);
    it.setSimpleName(_plus);
  }
  
  public boolean hasGetter(final FieldDeclaration it) {
    TypeDeclaration _declaringType = it.getDeclaringType();
    String _getterName = this.getGetterName(it);
    MethodDeclaration _findDeclaredMethod = _declaringType.findDeclaredMethod(_getterName);
    return (_findDeclaredMethod != null);
  }
  
  public String getGetterName(final FieldDeclaration it) {
    String _xifexpression = null;
    TypeReference _type = it.getType();
    boolean _isBooleanType = this.isBooleanType(_type);
    if (_isBooleanType) {
      _xifexpression = "is";
    } else {
      _xifexpression = "get";
    }
    String _simpleName = it.getSimpleName();
    String _firstUpper = StringExtensions.toFirstUpper(_simpleName);
    return (_xifexpression + _firstUpper);
  }
  
  public void addGetter(final MutableFieldDeclaration field, @Extension final TransformationContext context) {
    field.markAsRead();
    MutableTypeDeclaration _declaringType = field.getDeclaringType();
    String _getterName = this.getGetterName(field);
    final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        AnnotationReference _newAnnotationReference = context.newAnnotationReference(Pure.class);
        it.addAnnotation(_newAnnotationReference);
        TypeReference _type = field.getType();
        it.setReturnType(_type);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("return this.");
            String _simpleName = field.getSimpleName();
            _builder.append(_simpleName, "");
            _builder.append(";");
          }
        };
        it.setBody(_client);
      }
    };
    _declaringType.addMethod(_getterName, _function);
  }
  
  public boolean hasSetter(final FieldDeclaration it) {
    TypeDeclaration _declaringType = it.getDeclaringType();
    String _setterName = this.getSetterName(it);
    TypeReference _type = it.getType();
    MethodDeclaration _findDeclaredMethod = _declaringType.findDeclaredMethod(_setterName, _type);
    return (_findDeclaredMethod != null);
  }
  
  public String getSetterName(final FieldDeclaration it) {
    String _simpleName = it.getSimpleName();
    String _firstUpper = StringExtensions.toFirstUpper(_simpleName);
    return ("set" + _firstUpper);
  }
  
  public void addSetter(final MutableFieldDeclaration field, @Extension final TransformationContext context) {
    boolean _isFinal = field.isFinal();
    if (_isFinal) {
      context.addError(field, "Cannot set a final field");
      return;
    }
    TypeReference _type = field.getType();
    boolean _isInferred = _type.isInferred();
    if (_isInferred) {
      context.addError(field, "Type cannot be inferred.");
      return;
    }
    MutableTypeDeclaration _declaringType = field.getDeclaringType();
    String _setterName = this.getSetterName(field);
    final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        TypeReference _primitiveVoid = context.getPrimitiveVoid();
        it.setReturnType(_primitiveVoid);
        String _simpleName = field.getSimpleName();
        TypeReference _type = field.getType();
        final MutableParameterDeclaration param = it.addParameter(_simpleName, _type);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("this.");
            String _simpleName = field.getSimpleName();
            _builder.append(_simpleName, "");
            _builder.append(" = ");
            String _simpleName_1 = param.getSimpleName();
            _builder.append(_simpleName_1, "");
            _builder.append(";");
          }
        };
        it.setBody(_client);
      }
    };
    _declaringType.addMethod(_setterName, _function);
  }
  
  public boolean isBooleanType(final TypeReference it) {
    boolean _and = false;
    boolean _isInferred = it.isInferred();
    boolean _not = (!_isInferred);
    if (!_not) {
      _and = false;
    } else {
      boolean _or = false;
      String _name = it.getName();
      String _name_1 = Boolean.class.getName();
      boolean _equals = Objects.equal(_name, _name_1);
      if (_equals) {
        _or = true;
      } else {
        String _name_2 = it.getName();
        String _name_3 = Boolean.TYPE.getName();
        boolean _equals_1 = Objects.equal(_name_2, _name_3);
        _or = _equals_1;
      }
      _and = _or;
    }
    return _and;
  }
}
