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
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclarator;
import org.eclipse.xtend.lib.macro.declaration.ResolvedConstructor;
import org.eclipse.xtend.lib.macro.declaration.ResolvedParameter;
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
      final Function1<MutableFieldDeclaration, Boolean> _function = new Function1<MutableFieldDeclaration, Boolean>() {
        @Override
        public Boolean apply(final MutableFieldDeclaration it) {
          return Boolean.valueOf(((((!it.isStatic()) && (it.isFinal() == true)) && (it.getInitializer() == null)) && Util.this.context.isThePrimaryGeneratedJavaElement(it)));
        }
      };
      return IterableExtensions.filter(it.getDeclaredFields(), _function);
    }
    
    public boolean needsFinalFieldConstructor(final MutableClassDeclaration it) {
      return ((!this.hasFinalFieldsConstructor(it)) && IterableExtensions.isEmpty(((ClassDeclaration) this.context.getPrimarySourceElement(it)).getDeclaredConstructors()));
    }
    
    public boolean hasFinalFieldsConstructor(final MutableTypeDeclaration cls) {
      boolean _xblockexpression = false;
      {
        final ArrayList<TypeReference> expectedTypes = this.getFinalFieldsConstructorArgumentTypes(cls);
        final Function1<MutableConstructorDeclaration, Boolean> _function = new Function1<MutableConstructorDeclaration, Boolean>() {
          @Override
          public Boolean apply(final MutableConstructorDeclaration it) {
            final Function1<MutableParameterDeclaration, TypeReference> _function = new Function1<MutableParameterDeclaration, TypeReference>() {
              @Override
              public TypeReference apply(final MutableParameterDeclaration it) {
                return it.getType();
              }
            };
            List<TypeReference> _list = IterableExtensions.<TypeReference>toList(IterableExtensions.map(it.getParameters(), _function));
            return Boolean.valueOf(Objects.equal(_list, expectedTypes));
          }
        };
        _xblockexpression = IterableExtensions.exists(cls.getDeclaredConstructors(), _function);
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
          final Function1<ResolvedParameter, TypeReference> _function = new Function1<ResolvedParameter, TypeReference>() {
            @Override
            public TypeReference apply(final ResolvedParameter it) {
              return it.getResolvedType();
            }
          };
          Iterable<TypeReference> _map = IterableExtensions.map(this.getSuperConstructor(cls).getResolvedParameters(), _function);
          Iterables.<TypeReference>addAll(types, _map);
        }
        final Function1<MutableFieldDeclaration, TypeReference> _function_1 = new Function1<MutableFieldDeclaration, TypeReference>() {
          @Override
          public TypeReference apply(final MutableFieldDeclaration it) {
            return it.getType();
          }
        };
        Iterable<TypeReference> _map_1 = IterableExtensions.map(this.getFinalFields(cls), _function_1);
        Iterables.<TypeReference>addAll(types, _map_1);
        _xblockexpression = types;
      }
      return _xblockexpression;
    }
    
    public String getConstructorAlreadyExistsMessage(final MutableTypeDeclaration it) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Cannot create FinalFieldsConstructor as a constructor with the signature \"new(");
      String _join = IterableExtensions.join(this.getFinalFieldsConstructorArgumentTypes(it), ",");
      _builder.append(_join);
      _builder.append(")\" already exists.");
      return _builder.toString();
    }
    
    public void addFinalFieldsConstructor(final MutableClassDeclaration it) {
      boolean _isEmpty = this.getFinalFieldsConstructorArgumentTypes(it).isEmpty();
      if (_isEmpty) {
        final AnnotationReference anno = it.findAnnotation(this.context.findTypeGlobally(FinalFieldsConstructor.class));
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("There are no final fields, this annotation has no effect");
        this.context.addWarning(anno, _builder.toString());
        return;
      }
      boolean _hasFinalFieldsConstructor = this.hasFinalFieldsConstructor(it);
      if (_hasFinalFieldsConstructor) {
        this.context.addError(it, this.getConstructorAlreadyExistsMessage(it));
        return;
      }
      final Procedure1<MutableConstructorDeclaration> _function = new Procedure1<MutableConstructorDeclaration>() {
        @Override
        public void apply(final MutableConstructorDeclaration it) {
          Util.this.context.setPrimarySourceElement(it, Util.this.context.getPrimarySourceElement(it.getDeclaringType()));
          Util.this.makeFinalFieldsConstructor(it);
        }
      };
      it.addConstructor(_function);
    }
    
    private final static Pattern EMPTY_BODY = Pattern.compile("(\\{(\\s*\\})?)?");
    
    public void makeFinalFieldsConstructor(final MutableConstructorDeclaration it) {
      boolean _isEmpty = this.getFinalFieldsConstructorArgumentTypes(it.getDeclaringType()).isEmpty();
      if (_isEmpty) {
        final AnnotationReference anno = it.findAnnotation(this.context.findTypeGlobally(FinalFieldsConstructor.class));
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("There are no final fields, this annotation has no effect");
        this.context.addWarning(anno, _builder.toString());
        return;
      }
      boolean _hasFinalFieldsConstructor = this.hasFinalFieldsConstructor(it.getDeclaringType());
      if (_hasFinalFieldsConstructor) {
        this.context.addError(it, this.getConstructorAlreadyExistsMessage(it.getDeclaringType()));
        return;
      }
      boolean _isEmpty_1 = IterableExtensions.isEmpty(it.getParameters());
      boolean _not = (!_isEmpty_1);
      if (_not) {
        this.context.addError(it, "Parameter list must be empty");
      }
      if (((it.getBody() != null) && (!FinalFieldsConstructorProcessor.Util.EMPTY_BODY.matcher(it.getBody().toString()).matches()))) {
        this.context.addError(it, "Body must be empty");
      }
      Iterable<? extends ResolvedParameter> _elvis = null;
      ResolvedConstructor _superConstructor = this.getSuperConstructor(it.getDeclaringType());
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
          it.addParameter(p.getDeclaration().getSimpleName(), p.getResolvedType());
        }
      };
      IterableExtensions.forEach(superParameters, _function);
      final HashMap<MutableFieldDeclaration, MutableParameterDeclaration> fieldToParameter = CollectionLiterals.<MutableFieldDeclaration, MutableParameterDeclaration>newHashMap();
      final Procedure1<MutableFieldDeclaration> _function_1 = new Procedure1<MutableFieldDeclaration>() {
        @Override
        public void apply(final MutableFieldDeclaration p) {
          p.markAsInitializedBy(it);
          final MutableParameterDeclaration param = it.addParameter(p.getSimpleName(), Util.this.orObject(p.getType()));
          fieldToParameter.put(p, param);
        }
      };
      IterableExtensions.forEach(this.getFinalFields(it.getDeclaringType()), _function_1);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("super(");
          final Function1<ResolvedParameter, CharSequence> _function = new Function1<ResolvedParameter, CharSequence>() {
            @Override
            public CharSequence apply(final ResolvedParameter it) {
              return it.getDeclaration().getSimpleName();
            }
          };
          String _join = IterableExtensions.join(superParameters, ", ", _function);
          _builder.append(_join);
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          {
            Iterable<? extends MutableFieldDeclaration> _finalFields = Util.this.getFinalFields(it.getDeclaringType());
            for(final MutableFieldDeclaration arg : _finalFields) {
              _builder.append("this.");
              String _simpleName = arg.getSimpleName();
              _builder.append(_simpleName);
              _builder.append(" = ");
              String _simpleName_1 = fieldToParameter.get(arg).getSimpleName();
              _builder.append(_simpleName_1);
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
        if ((Objects.equal(((ClassDeclaration)it).getExtendedClass(), this.context.getObject()) || (((ClassDeclaration)it).getExtendedClass() == null))) {
          return null;
        }
        return IterableExtensions.head(((ClassDeclaration)it).getExtendedClass().getDeclaredResolvedConstructors());
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
    AnnotationReference _findAnnotation = it.findAnnotation(context.findTypeGlobally(Data.class));
    boolean _tripleNotEquals = (_findAnnotation != null);
    if (_tripleNotEquals) {
      return;
    }
    AnnotationReference _findAnnotation_1 = it.findAnnotation(context.findTypeGlobally(Accessors.class));
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
