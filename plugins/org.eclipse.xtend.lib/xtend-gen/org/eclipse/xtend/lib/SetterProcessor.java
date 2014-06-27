package org.eclipse.xtend.lib;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtend.lib.Setter;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod;
import org.eclipse.xtend.lib.macro.declaration.ResolvedParameter;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.Synthetic;

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
@SuppressWarnings("all")
public class SetterProcessor implements TransformationParticipant<MutableMemberDeclaration> {
  /**
   * @since 2.7
   */
  @Beta
  @GwtCompatible
  public static class Util {
    @Extension
    private TransformationContext context;
    
    public Util(final TransformationContext context) {
      this.context = context;
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
    
    public boolean canAddSetter(final MutableFieldDeclaration field) {
      boolean _isFinal = field.isFinal();
      if (_isFinal) {
        this.context.addError(field, "Cannot set a final field");
        return false;
      }
      TypeReference _type = field.getType();
      boolean _isInferred = _type.isInferred();
      if (_isInferred) {
        this.context.addError(field, "Type cannot be inferred.");
        return false;
      }
      MutableTypeDeclaration _declaringType = field.getDeclaringType();
      TypeReference _newSelfTypeReference = this.context.newSelfTypeReference(_declaringType);
      Iterable<? extends ResolvedMethod> _allResolvedMethods = _newSelfTypeReference.getAllResolvedMethods();
      final Function1<ResolvedMethod, Boolean> _function = new Function1<ResolvedMethod, Boolean>() {
        public Boolean apply(final ResolvedMethod it) {
          boolean _and = false;
          boolean _and_1 = false;
          MethodDeclaration _declaration = it.getDeclaration();
          String _simpleName = _declaration.getSimpleName();
          String _setterName = Util.this.getSetterName(field);
          boolean _equals = Objects.equal(_simpleName, _setterName);
          if (!_equals) {
            _and_1 = false;
          } else {
            Iterable<? extends ResolvedParameter> _resolvedParameters = it.getResolvedParameters();
            int _size = IterableExtensions.size(_resolvedParameters);
            boolean _equals_1 = (_size == 1);
            _and_1 = _equals_1;
          }
          if (!_and_1) {
            _and = false;
          } else {
            TypeReference _type = field.getType();
            Iterable<? extends ResolvedParameter> _resolvedParameters_1 = it.getResolvedParameters();
            ResolvedParameter _head = IterableExtensions.head(_resolvedParameters_1);
            TypeReference _resolvedType = _head.getResolvedType();
            boolean _isAssignableFrom = _type.isAssignableFrom(_resolvedType);
            _and = _isAssignableFrom;
          }
          return Boolean.valueOf(_and);
        }
      };
      final ResolvedMethod overriddenSetter = IterableExtensions.findFirst(_allResolvedMethods, _function);
      boolean _equals = Objects.equal(overriddenSetter, null);
      if (_equals) {
        return true;
      }
      final MethodDeclaration overriddenDeclaration = overriddenSetter.getDeclaration();
      boolean _isFinal_1 = overriddenDeclaration.isFinal();
      if (_isFinal_1) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Cannot override the final method ");
        String _simpleSignature = overriddenSetter.getSimpleSignature();
        _builder.append(_simpleSignature, "");
        _builder.append(" in ");
        TypeDeclaration _declaringType_1 = overriddenDeclaration.getDeclaringType();
        String _simpleName = _declaringType_1.getSimpleName();
        _builder.append(_simpleName, "");
        this.context.addError(field, _builder.toString());
        return false;
      }
      TypeReference _resolvedReturnType = overriddenSetter.getResolvedReturnType();
      boolean _isVoid = _resolvedReturnType.isVoid();
      boolean _not = (!_isVoid);
      if (_not) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Cannot override the method ");
        String _simpleSignature_1 = overriddenSetter.getSimpleSignature();
        _builder_1.append(_simpleSignature_1, "");
        _builder_1.append(" in ");
        TypeDeclaration _declaringType_2 = overriddenDeclaration.getDeclaringType();
        String _simpleName_1 = _declaringType_2.getSimpleName();
        _builder_1.append(_simpleName_1, "");
        _builder_1.append(", because its return type is not void»");
        _builder_1.newLineIfNotEmpty();
        this.context.addError(field, _builder_1.toString());
        return false;
      }
      return true;
    }
    
    public void addSetter(final MutableFieldDeclaration field) {
      MutableTypeDeclaration _declaringType = field.getDeclaringType();
      String _setterName = this.getSetterName(field);
      final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
        public void apply(final MutableMethodDeclaration it) {
          TypeReference _primitiveVoid = Util.this.context.getPrimitiveVoid();
          it.setReturnType(_primitiveVoid);
          String _simpleName = field.getSimpleName();
          TypeReference _type = field.getType();
          final MutableParameterDeclaration param = it.addParameter(_simpleName, _type);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              Object _fieldOwner = Util.this.fieldOwner(field);
              _builder.append(_fieldOwner, "");
              _builder.append(".");
              String _simpleName = field.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append(" = ");
              String _simpleName_1 = param.getSimpleName();
              _builder.append(_simpleName_1, "");
              _builder.append(";");
            }
          };
          it.setBody(_client);
          boolean _isStatic = field.isStatic();
          it.setStatic(_isStatic);
        }
      };
      _declaringType.addMethod(_setterName, _function);
    }
    
    private Object fieldOwner(final MutableFieldDeclaration it) {
      Object _xifexpression = null;
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        MutableTypeDeclaration _declaringType = it.getDeclaringType();
        _xifexpression = this.context.newTypeReference(_declaringType);
      } else {
        _xifexpression = "this";
      }
      return _xifexpression;
    }
  }
  
  public void doTransform(final List<? extends MutableMemberDeclaration> elements, @Extension final TransformationContext context) {
    final Procedure1<MutableMemberDeclaration> _function = new Procedure1<MutableMemberDeclaration>() {
      public void apply(final MutableMemberDeclaration it) {
        SetterProcessor.this.transform(it, context);
      }
    };
    IterableExtensions.forEach(elements, _function);
  }
  
  protected void _transform(final MutableFieldDeclaration it, @Extension final TransformationContext context) {
    @Extension
    final SetterProcessor.Util util = new SetterProcessor.Util(context);
    boolean _hasSetter = util.hasSetter(it);
    if (_hasSetter) {
      Type _findTypeGlobally = context.findTypeGlobally(Setter.class);
      final AnnotationReference annotation = it.findAnnotation(_findTypeGlobally);
      context.addWarning(annotation, "A setter is already defined, this annotation has no effect");
    } else {
      boolean _canAddSetter = util.canAddSetter(it);
      if (_canAddSetter) {
        util.addSetter(it);
      }
    }
  }
  
  protected void _transform(final MutableClassDeclaration it, @Extension final TransformationContext context) {
    @Extension
    final SetterProcessor.Util util = new SetterProcessor.Util(context);
    Iterable<? extends MutableFieldDeclaration> _declaredFields = it.getDeclaredFields();
    final Function1<MutableFieldDeclaration, Boolean> _function = new Function1<MutableFieldDeclaration, Boolean>() {
      public Boolean apply(final MutableFieldDeclaration it) {
        boolean _and = false;
        boolean _isStatic = it.isStatic();
        boolean _not = (!_isStatic);
        if (!_not) {
          _and = false;
        } else {
          boolean _isThePrimaryGeneratedJavaElement = context.isThePrimaryGeneratedJavaElement(it);
          _and = _isThePrimaryGeneratedJavaElement;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<? extends MutableFieldDeclaration> _filter = IterableExtensions.filter(_declaredFields, _function);
    final Procedure1<MutableFieldDeclaration> _function_1 = new Procedure1<MutableFieldDeclaration>() {
      public void apply(final MutableFieldDeclaration it) {
        boolean _and = false;
        boolean _hasSetter = util.hasSetter(it);
        boolean _not = (!_hasSetter);
        if (!_not) {
          _and = false;
        } else {
          boolean _canAddSetter = util.canAddSetter(it);
          _and = _canAddSetter;
        }
        if (_and) {
          util.addSetter(it);
        }
      }
    };
    IterableExtensions.forEach(_filter, _function_1);
  }
  
  @Synthetic
  protected void transform(final MutableMemberDeclaration it, final TransformationContext context) {
    if (it instanceof MutableClassDeclaration) {
      _transform((MutableClassDeclaration)it, context);
      return;
    } else if (it instanceof MutableFieldDeclaration) {
      _transform((MutableFieldDeclaration)it, context);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, context).toString());
    }
  }
}
