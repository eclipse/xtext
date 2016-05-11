package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclarator;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ResolvedConstructor;
import org.eclipse.xtend.lib.macro.declaration.ResolvedParameter;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @since 2.7
 * @noextend
 * @noreference
 */
@Beta
@SuppressWarnings("all")
public class FinalFieldsConstructorProcessor implements TransformationParticipant<MutableTypeParameterDeclarator> {
  /**
   * @since 2.7
   * @noextend
   * @noreference
   */
  @Beta
  public static class Util {
    @Extension
    private TransformationContext context;
    
    public Util(final TransformationContext context) {
      this.context = context;
    }
    
    public Iterable<? extends MutableFieldDeclaration> getFinalFields(final MutableTypeDeclaration it) {
      Iterable<? extends MutableFieldDeclaration> _declaredFields = it.getDeclaredFields();
      final Function1<MutableFieldDeclaration, Boolean> _function = new Function1<MutableFieldDeclaration, Boolean>() {
        @Override
        public Boolean apply(final MutableFieldDeclaration it) {
          return Boolean.valueOf(((((!it.isStatic()) && (it.isFinal() == true)) && Objects.equal(it.getInitializer(), null)) && Util.this.context.isThePrimaryGeneratedJavaElement(it)));
        }
      };
      return IterableExtensions.filter(_declaredFields, _function);
    }
    
    public boolean needsFinalFieldConstructor(final MutableClassDeclaration it) {
      return ((!this.hasFinalFieldsConstructor(it)) && IterableExtensions.isEmpty(((ClassDeclaration) this.context.getPrimarySourceElement(it)).getDeclaredConstructors()));
    }
    
    public boolean hasFinalFieldsConstructor(final MutableTypeDeclaration cls) {
      boolean _xblockexpression = false;
      {
        final ArrayList<TypeReference> expectedTypes = this.getFinalFieldsConstructorArgumentTypes(cls);
        Iterable<? extends MutableConstructorDeclaration> _declaredConstructors = cls.getDeclaredConstructors();
        final Function1<MutableConstructorDeclaration, Boolean> _function = new Function1<MutableConstructorDeclaration, Boolean>() {
          @Override
          public Boolean apply(final MutableConstructorDeclaration it) {
            Iterable<? extends MutableParameterDeclaration> _parameters = it.getParameters();
            final Function1<MutableParameterDeclaration, TypeReference> _function = new Function1<MutableParameterDeclaration, TypeReference>() {
              @Override
              public TypeReference apply(final MutableParameterDeclaration it) {
                return it.getType();
              }
            };
            Iterable<TypeReference> _map = IterableExtensions.map(_parameters, _function);
            List<TypeReference> _list = IterableExtensions.<TypeReference>toList(_map);
            return Boolean.valueOf(Objects.equal(_list, expectedTypes));
          }
        };
        _xblockexpression = IterableExtensions.exists(_declaredConstructors, _function);
      }
      return _xblockexpression;
    }
    
    public ArrayList<TypeReference> getFinalFieldsConstructorArgumentTypes(final MutableTypeDeclaration cls) {
      ArrayList<TypeReference> _xblockexpression = null;
      {
        final ArrayList<TypeReference> types = CollectionLiterals.<TypeReference>newArrayList();
        ResolvedConstructor _superConstructor = this.getSuperConstructor(cls);
        boolean _tripleNotEquals = (_superConstructor != null);
        if (_tripleNotEquals) {
          ResolvedConstructor _superConstructor_1 = this.getSuperConstructor(cls);
          Iterable<? extends ResolvedParameter> _resolvedParameters = _superConstructor_1.getResolvedParameters();
          final Function1<ResolvedParameter, TypeReference> _function = new Function1<ResolvedParameter, TypeReference>() {
            @Override
            public TypeReference apply(final ResolvedParameter it) {
              return it.getResolvedType();
            }
          };
          Iterable<TypeReference> _map = IterableExtensions.map(_resolvedParameters, _function);
          Iterables.<TypeReference>addAll(types, _map);
        }
        Iterable<? extends MutableFieldDeclaration> _finalFields = this.getFinalFields(cls);
        final Function1<MutableFieldDeclaration, TypeReference> _function_1 = new Function1<MutableFieldDeclaration, TypeReference>() {
          @Override
          public TypeReference apply(final MutableFieldDeclaration it) {
            return it.getType();
          }
        };
        Iterable<TypeReference> _map_1 = IterableExtensions.map(_finalFields, _function_1);
        Iterables.<TypeReference>addAll(types, _map_1);
        _xblockexpression = types;
      }
      return _xblockexpression;
    }
    
    public String getConstructorAlreadyExistsMessage(final MutableTypeDeclaration it) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Cannot create FinalFieldsConstructor as a constructor with the signature \"new(");
      ArrayList<TypeReference> _finalFieldsConstructorArgumentTypes = this.getFinalFieldsConstructorArgumentTypes(it);
      String _join = IterableExtensions.join(_finalFieldsConstructorArgumentTypes, ",");
      _builder.append(_join, "");
      _builder.append(")\" already exists.");
      return _builder.toString();
    }
    
    public void addFinalFieldsConstructor(final MutableClassDeclaration it) {
      ArrayList<TypeReference> _finalFieldsConstructorArgumentTypes = this.getFinalFieldsConstructorArgumentTypes(it);
      boolean _isEmpty = _finalFieldsConstructorArgumentTypes.isEmpty();
      if (_isEmpty) {
        Type _findTypeGlobally = this.context.findTypeGlobally(FinalFieldsConstructor.class);
        final AnnotationReference anno = it.findAnnotation(_findTypeGlobally);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("There are no final fields, this annotation has no effect");
        this.context.addWarning(anno, _builder.toString());
        return;
      }
      boolean _hasFinalFieldsConstructor = this.hasFinalFieldsConstructor(it);
      if (_hasFinalFieldsConstructor) {
        String _constructorAlreadyExistsMessage = this.getConstructorAlreadyExistsMessage(it);
        this.context.addError(it, _constructorAlreadyExistsMessage);
        return;
      }
      final Procedure1<MutableConstructorDeclaration> _function = new Procedure1<MutableConstructorDeclaration>() {
        @Override
        public void apply(final MutableConstructorDeclaration it) {
          MutableTypeDeclaration _declaringType = it.getDeclaringType();
          Element _primarySourceElement = Util.this.context.getPrimarySourceElement(_declaringType);
          Util.this.context.setPrimarySourceElement(it, _primarySourceElement);
          Util.this.makeFinalFieldsConstructor(it);
        }
      };
      it.addConstructor(_function);
    }
    
    private final static Pattern EMPTY_BODY = Pattern.compile("(\\{(\\s*\\})?)?");
    
    public void makeFinalFieldsConstructor(final MutableConstructorDeclaration it) {
      MutableTypeDeclaration _declaringType = it.getDeclaringType();
      ArrayList<TypeReference> _finalFieldsConstructorArgumentTypes = this.getFinalFieldsConstructorArgumentTypes(_declaringType);
      boolean _isEmpty = _finalFieldsConstructorArgumentTypes.isEmpty();
      if (_isEmpty) {
        Type _findTypeGlobally = this.context.findTypeGlobally(FinalFieldsConstructor.class);
        final AnnotationReference anno = it.findAnnotation(_findTypeGlobally);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("There are no final fields, this annotation has no effect");
        this.context.addWarning(anno, _builder.toString());
        return;
      }
      MutableTypeDeclaration _declaringType_1 = it.getDeclaringType();
      boolean _hasFinalFieldsConstructor = this.hasFinalFieldsConstructor(_declaringType_1);
      if (_hasFinalFieldsConstructor) {
        MutableTypeDeclaration _declaringType_2 = it.getDeclaringType();
        String _constructorAlreadyExistsMessage = this.getConstructorAlreadyExistsMessage(_declaringType_2);
        this.context.addError(it, _constructorAlreadyExistsMessage);
        return;
      }
      Iterable<? extends MutableParameterDeclaration> _parameters = it.getParameters();
      boolean _isEmpty_1 = IterableExtensions.isEmpty(_parameters);
      boolean _not = (!_isEmpty_1);
      if (_not) {
        this.context.addError(it, "Parameter list must be empty");
      }
      if (((it.getBody() != null) && (!FinalFieldsConstructorProcessor.Util.EMPTY_BODY.matcher(it.getBody().toString()).matches()))) {
        this.context.addError(it, "Body must be empty");
      }
      Iterable<? extends ResolvedParameter> _elvis = null;
      MutableTypeDeclaration _declaringType_3 = it.getDeclaringType();
      ResolvedConstructor _superConstructor = this.getSuperConstructor(_declaringType_3);
      Iterable<? extends ResolvedParameter> _resolvedParameters = null;
      if (_superConstructor!=null) {
        _resolvedParameters=_superConstructor.getResolvedParameters();
      }
      if (_resolvedParameters != null) {
        _elvis = _resolvedParameters;
      } else {
        _elvis = Collections.<ResolvedParameter>unmodifiableList(CollectionLiterals.<ResolvedParameter>newArrayList());
      }
      final Iterable<? extends ResolvedParameter> superParameters = _elvis;
      final Procedure1<ResolvedParameter> _function = new Procedure1<ResolvedParameter>() {
        @Override
        public void apply(final ResolvedParameter p) {
          ParameterDeclaration _declaration = p.getDeclaration();
          String _simpleName = _declaration.getSimpleName();
          TypeReference _resolvedType = p.getResolvedType();
          it.addParameter(_simpleName, _resolvedType);
        }
      };
      IterableExtensions.forEach(superParameters, _function);
      final HashMap<MutableFieldDeclaration, MutableParameterDeclaration> fieldToParameter = CollectionLiterals.<MutableFieldDeclaration, MutableParameterDeclaration>newHashMap();
      MutableTypeDeclaration _declaringType_4 = it.getDeclaringType();
      Iterable<? extends MutableFieldDeclaration> _finalFields = this.getFinalFields(_declaringType_4);
      final Procedure1<MutableFieldDeclaration> _function_1 = new Procedure1<MutableFieldDeclaration>() {
        @Override
        public void apply(final MutableFieldDeclaration p) {
          p.markAsInitializedBy(it);
          String _simpleName = p.getSimpleName();
          TypeReference _type = p.getType();
          TypeReference _orObject = Util.this.orObject(_type);
          final MutableParameterDeclaration param = it.addParameter(_simpleName, _orObject);
          fieldToParameter.put(p, param);
        }
      };
      IterableExtensions.forEach(_finalFields, _function_1);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("super(");
          final Function1<ResolvedParameter, CharSequence> _function = new Function1<ResolvedParameter, CharSequence>() {
            @Override
            public CharSequence apply(final ResolvedParameter it) {
              ParameterDeclaration _declaration = it.getDeclaration();
              return _declaration.getSimpleName();
            }
          };
          String _join = IterableExtensions.join(superParameters, ", ", _function);
          _builder.append(_join, "");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          {
            MutableTypeDeclaration _declaringType = it.getDeclaringType();
            Iterable<? extends MutableFieldDeclaration> _finalFields = Util.this.getFinalFields(_declaringType);
            for(final MutableFieldDeclaration arg : _finalFields) {
              _builder.append("this.");
              String _simpleName = arg.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append(" = ");
              MutableParameterDeclaration _get = fieldToParameter.get(arg);
              String _simpleName_1 = _get.getSimpleName();
              _builder.append(_simpleName_1, "");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      };
      it.setBody(_client);
    }
    
    public ResolvedConstructor getSuperConstructor(final TypeDeclaration it) {
      if ((it instanceof ClassDeclaration)) {
        if ((Objects.equal(((ClassDeclaration)it).getExtendedClass(), this.context.getObject()) || Objects.equal(((ClassDeclaration)it).getExtendedClass(), null))) {
          return null;
        }
        TypeReference _extendedClass = ((ClassDeclaration)it).getExtendedClass();
        Iterable<? extends ResolvedConstructor> _declaredResolvedConstructors = _extendedClass.getDeclaredResolvedConstructors();
        return IterableExtensions.head(_declaredResolvedConstructors);
      } else {
        return null;
      }
    }
    
    private TypeReference orObject(final TypeReference ref) {
      TypeReference _xifexpression = null;
      if ((ref == null)) {
        _xifexpression = this.context.getObject();
      } else {
        _xifexpression = ref;
      }
      return _xifexpression;
    }
  }
  
  @Override
  public void doTransform(final List<? extends MutableTypeParameterDeclarator> elements, @Extension final TransformationContext context) {
    final Procedure1<MutableTypeParameterDeclarator> _function = new Procedure1<MutableTypeParameterDeclarator>() {
      @Override
      public void apply(final MutableTypeParameterDeclarator it) {
        FinalFieldsConstructorProcessor.this.transform(it, context);
      }
    };
    IterableExtensions.forEach(elements, _function);
  }
  
  protected void _transform(final MutableClassDeclaration it, @Extension final TransformationContext context) {
    Type _findTypeGlobally = context.findTypeGlobally(Data.class);
    AnnotationReference _findAnnotation = it.findAnnotation(_findTypeGlobally);
    boolean _tripleNotEquals = (_findAnnotation != null);
    if (_tripleNotEquals) {
      return;
    }
    Type _findTypeGlobally_1 = context.findTypeGlobally(Accessors.class);
    AnnotationReference _findAnnotation_1 = it.findAnnotation(_findTypeGlobally_1);
    boolean _tripleNotEquals_1 = (_findAnnotation_1 != null);
    if (_tripleNotEquals_1) {
      return;
    }
    @Extension
    final FinalFieldsConstructorProcessor.Util util = new FinalFieldsConstructorProcessor.Util(context);
    util.addFinalFieldsConstructor(it);
  }
  
  protected void _transform(final MutableConstructorDeclaration it, @Extension final TransformationContext context) {
    @Extension
    final FinalFieldsConstructorProcessor.Util util = new FinalFieldsConstructorProcessor.Util(context);
    util.makeFinalFieldsConstructor(it);
  }
  
  public void transform(final MutableTypeParameterDeclarator it, final TransformationContext context) {
    if (it instanceof MutableConstructorDeclaration) {
      _transform((MutableConstructorDeclaration)it, context);
      return;
    } else if (it instanceof MutableClassDeclaration) {
      _transform((MutableClassDeclaration)it, context);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, context).toString());
    }
  }
}
