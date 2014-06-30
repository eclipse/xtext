package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Getter;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
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
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.Synthetic;

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
@SuppressWarnings("all")
public class GetterProcessor implements TransformationParticipant<MutableMemberDeclaration> {
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
    
    public boolean hasGetter(final FieldDeclaration it) {
      TypeDeclaration _declaringType = it.getDeclaringType();
      String _getterName = this.getGetterName(it);
      MethodDeclaration _findDeclaredMethod = _declaringType.findDeclaredMethod(_getterName);
      return (_findDeclaredMethod != null);
    }
    
    public boolean canAddGetter(final MutableFieldDeclaration field) {
      MutableTypeDeclaration _declaringType = field.getDeclaringType();
      TypeReference _newSelfTypeReference = this.context.newSelfTypeReference(_declaringType);
      Iterable<? extends ResolvedMethod> _allResolvedMethods = _newSelfTypeReference.getAllResolvedMethods();
      final Function1<ResolvedMethod, Boolean> _function = new Function1<ResolvedMethod, Boolean>() {
        public Boolean apply(final ResolvedMethod it) {
          boolean _and = false;
          MethodDeclaration _declaration = it.getDeclaration();
          String _simpleName = _declaration.getSimpleName();
          String _getterName = Util.this.getGetterName(field);
          boolean _equals = Objects.equal(_simpleName, _getterName);
          if (!_equals) {
            _and = false;
          } else {
            Iterable<? extends ResolvedParameter> _resolvedParameters = it.getResolvedParameters();
            boolean _isEmpty = IterableExtensions.isEmpty(_resolvedParameters);
            _and = _isEmpty;
          }
          return Boolean.valueOf(_and);
        }
      };
      final ResolvedMethod overriddenGetter = IterableExtensions.findFirst(_allResolvedMethods, _function);
      boolean _equals = Objects.equal(overriddenGetter, null);
      if (_equals) {
        return true;
      }
      final MethodDeclaration overriddenDeclaration = overriddenGetter.getDeclaration();
      boolean _isFinal = overriddenDeclaration.isFinal();
      if (_isFinal) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Cannot override the final method ");
        String _simpleSignature = overriddenGetter.getSimpleSignature();
        _builder.append(_simpleSignature, "");
        _builder.append(" in ");
        TypeDeclaration _declaringType_1 = overriddenDeclaration.getDeclaringType();
        String _simpleName = _declaringType_1.getSimpleName();
        _builder.append(_simpleName, "");
        this.context.addError(field, _builder.toString());
        return false;
      }
      TypeReference _resolvedReturnType = overriddenGetter.getResolvedReturnType();
      TypeReference _type = field.getType();
      boolean _isAssignableFrom = _resolvedReturnType.isAssignableFrom(_type);
      boolean _not = (!_isAssignableFrom);
      if (_not) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Cannot override the method ");
        String _simpleSignature_1 = overriddenGetter.getSimpleSignature();
        _builder_1.append(_simpleSignature_1, "");
        _builder_1.append(" in ");
        TypeDeclaration _declaringType_2 = overriddenDeclaration.getDeclaringType();
        String _simpleName_1 = _declaringType_2.getSimpleName();
        _builder_1.append(_simpleName_1, "");
        _builder_1.append(", ");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("because its return type is incompatible with ");
        TypeReference _type_1 = field.getType();
        String _simpleName_2 = _type_1.getSimpleName();
        _builder_1.append(_simpleName_2, "");
        _builder_1.newLineIfNotEmpty();
        this.context.addError(field, _builder_1.toString());
        return false;
      }
      return true;
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
    
    public void addGetter(final MutableFieldDeclaration field) {
      field.markAsRead();
      MutableTypeDeclaration _declaringType = field.getDeclaringType();
      String _getterName = this.getGetterName(field);
      final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
        public void apply(final MutableMethodDeclaration it) {
          AnnotationReference _newAnnotationReference = Util.this.context.newAnnotationReference(Pure.class);
          it.addAnnotation(_newAnnotationReference);
          TypeReference _type = field.getType();
          it.setReturnType(_type);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("return ");
              Object _fieldOwner = Util.this.fieldOwner(field);
              _builder.append(_fieldOwner, "");
              _builder.append(".");
              String _simpleName = field.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append(";");
            }
          };
          it.setBody(_client);
          boolean _isStatic = field.isStatic();
          it.setStatic(_isStatic);
        }
      };
      _declaringType.addMethod(_getterName, _function);
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
  
  public void doTransform(final List<? extends MutableMemberDeclaration> elements, @Extension final TransformationContext context) {
    final Procedure1<MutableMemberDeclaration> _function = new Procedure1<MutableMemberDeclaration>() {
      public void apply(final MutableMemberDeclaration it) {
        GetterProcessor.this.transform(it, context);
      }
    };
    IterableExtensions.forEach(elements, _function);
  }
  
  protected void _transform(final MutableFieldDeclaration it, @Extension final TransformationContext context) {
    @Extension
    final GetterProcessor.Util util = new GetterProcessor.Util(context);
    boolean _hasGetter = util.hasGetter(it);
    if (_hasGetter) {
      Type _findTypeGlobally = context.findTypeGlobally(Getter.class);
      AnnotationReference _findAnnotation = it.findAnnotation(_findTypeGlobally);
      context.addWarning(_findAnnotation, "A getter is already defined, this annotation has no effect");
    } else {
      boolean _canAddGetter = util.canAddGetter(it);
      if (_canAddGetter) {
        util.addGetter(it);
      }
    }
  }
  
  protected void _transform(final MutableClassDeclaration it, @Extension final TransformationContext context) {
    @Extension
    final GetterProcessor.Util util = new GetterProcessor.Util(context);
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
        boolean _hasGetter = util.hasGetter(it);
        boolean _not = (!_hasGetter);
        if (!_not) {
          _and = false;
        } else {
          boolean _canAddGetter = util.canAddGetter(it);
          _and = _canAddGetter;
        }
        if (_and) {
          util.addGetter(it);
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
