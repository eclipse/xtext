package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclarator;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ResolvedConstructor;
import org.eclipse.xtend.lib.macro.declaration.ResolvedParameter;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @since 2.7
 */
@GwtCompatible
@Beta
@SuppressWarnings("all")
public class FinalFieldsConstructorProcessor implements TransformationParticipant<MutableTypeParameterDeclarator> {
  /**
   * @since 2.7
   */
  @GwtCompatible
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
        public Boolean apply(final MutableFieldDeclaration it) {
          boolean _and = false;
          boolean _and_1 = false;
          boolean _and_2 = false;
          boolean _isStatic = it.isStatic();
          boolean _not = (!_isStatic);
          if (!_not) {
            _and_2 = false;
          } else {
            boolean _isFinal = it.isFinal();
            boolean _equals = (_isFinal == true);
            _and_2 = _equals;
          }
          if (!_and_2) {
            _and_1 = false;
          } else {
            Expression _initializer = it.getInitializer();
            boolean _equals_1 = Objects.equal(_initializer, null);
            _and_1 = _equals_1;
          }
          if (!_and_1) {
            _and = false;
          } else {
            boolean _isThePrimaryGeneratedJavaElement = Util.this.context.isThePrimaryGeneratedJavaElement(it);
            _and = _isThePrimaryGeneratedJavaElement;
          }
          return Boolean.valueOf(_and);
        }
      };
      return IterableExtensions.filter(_declaredFields, _function);
    }
    
    public boolean hasUserDefinedConstructor(final MutableClassDeclaration it) {
      NamedElement _primarySourceElement = this.context.getPrimarySourceElement(it);
      Iterable<? extends ConstructorDeclaration> _declaredConstructors = ((ClassDeclaration) _primarySourceElement).getDeclaredConstructors();
      boolean _isEmpty = IterableExtensions.isEmpty(_declaredConstructors);
      return (!_isEmpty);
    }
    
    public boolean hasFinalFieldsConstructor(final MutableTypeDeclaration cls) {
      Iterable<? extends MutableConstructorDeclaration> _declaredConstructors = cls.getDeclaredConstructors();
      final Function1<MutableConstructorDeclaration, Boolean> _function = new Function1<MutableConstructorDeclaration, Boolean>() {
        public Boolean apply(final MutableConstructorDeclaration it) {
          boolean _xblockexpression = false;
          {
            final ArrayList<TypeReference> expectedTypes = CollectionLiterals.<TypeReference>newArrayList();
            ResolvedConstructor _superConstructor = Util.this.getSuperConstructor(cls);
            boolean _tripleNotEquals = (_superConstructor != null);
            if (_tripleNotEquals) {
              ResolvedConstructor _superConstructor_1 = Util.this.getSuperConstructor(cls);
              Iterable<? extends ResolvedParameter> _resolvedParameters = _superConstructor_1.getResolvedParameters();
              final Function1<ResolvedParameter, TypeReference> _function = new Function1<ResolvedParameter, TypeReference>() {
                public TypeReference apply(final ResolvedParameter it) {
                  return it.getResolvedType();
                }
              };
              Iterable<TypeReference> _map = IterableExtensions.map(_resolvedParameters, _function);
              Iterables.<TypeReference>addAll(expectedTypes, _map);
            }
            Iterable<? extends MutableFieldDeclaration> _finalFields = Util.this.getFinalFields(cls);
            final Function1<MutableFieldDeclaration, TypeReference> _function_1 = new Function1<MutableFieldDeclaration, TypeReference>() {
              public TypeReference apply(final MutableFieldDeclaration it) {
                return it.getType();
              }
            };
            Iterable<TypeReference> _map_1 = IterableExtensions.map(_finalFields, _function_1);
            Iterables.<TypeReference>addAll(expectedTypes, _map_1);
            Iterable<? extends MutableParameterDeclaration> _parameters = it.getParameters();
            final Function1<MutableParameterDeclaration, TypeReference> _function_2 = new Function1<MutableParameterDeclaration, TypeReference>() {
              public TypeReference apply(final MutableParameterDeclaration it) {
                return it.getType();
              }
            };
            Iterable<TypeReference> _map_2 = IterableExtensions.map(_parameters, _function_2);
            List<TypeReference> _list = IterableExtensions.<TypeReference>toList(_map_2);
            _xblockexpression = Objects.equal(_list, expectedTypes);
          }
          return Boolean.valueOf(_xblockexpression);
        }
      };
      return IterableExtensions.exists(_declaredConstructors, _function);
    }
    
    public MutableConstructorDeclaration addFinalFieldsConstructor(final MutableClassDeclaration cls) {
      final Procedure1<MutableConstructorDeclaration> _function = new Procedure1<MutableConstructorDeclaration>() {
        public void apply(final MutableConstructorDeclaration it) {
          NamedElement _primarySourceElement = Util.this.context.getPrimarySourceElement(cls);
          Util.this.context.setPrimarySourceElement(it, _primarySourceElement);
          Util.this.makeFinalFieldsConstructor(it);
        }
      };
      return cls.addConstructor(_function);
    }
    
    public MutableConstructorDeclaration makeFinalFieldsConstructor(final MutableConstructorDeclaration ctor) {
      final Procedure1<MutableConstructorDeclaration> _function = new Procedure1<MutableConstructorDeclaration>() {
        public void apply(final MutableConstructorDeclaration it) {
          Iterable<? extends ResolvedParameter> _elvis = null;
          MutableTypeDeclaration _declaringType = ctor.getDeclaringType();
          ResolvedConstructor _superConstructor = Util.this.getSuperConstructor(_declaringType);
          Iterable<? extends ResolvedParameter> _resolvedParameters = null;
          if (_superConstructor!=null) {
            _resolvedParameters=_superConstructor.getResolvedParameters();
          }
          if (_resolvedParameters != null) {
            _elvis = _resolvedParameters;
          } else {
            _elvis = Collections.<ResolvedParameter>unmodifiableList(Lists.<ResolvedParameter>newArrayList());
          }
          final Iterable<? extends ResolvedParameter> superParameters = _elvis;
          final Procedure1<ResolvedParameter> _function = new Procedure1<ResolvedParameter>() {
            public void apply(final ResolvedParameter p) {
              ParameterDeclaration _declaration = p.getDeclaration();
              String _simpleName = _declaration.getSimpleName();
              TypeReference _resolvedType = p.getResolvedType();
              it.addParameter(_simpleName, _resolvedType);
            }
          };
          IterableExtensions.forEach(superParameters, _function);
          final HashMap<MutableFieldDeclaration, MutableParameterDeclaration> fieldToParameter = CollectionLiterals.<MutableFieldDeclaration, MutableParameterDeclaration>newHashMap();
          MutableTypeDeclaration _declaringType_1 = it.getDeclaringType();
          Iterable<? extends MutableFieldDeclaration> _finalFields = Util.this.getFinalFields(_declaringType_1);
          final Procedure1<MutableFieldDeclaration> _function_1 = new Procedure1<MutableFieldDeclaration>() {
            public void apply(final MutableFieldDeclaration p) {
              p.markAsInitializedBy(ctor);
              String _simpleName = p.getSimpleName();
              TypeReference _type = p.getType();
              final MutableParameterDeclaration param = it.addParameter(_simpleName, _type);
              fieldToParameter.put(p, param);
            }
          };
          IterableExtensions.forEach(_finalFields, _function_1);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("super(");
              final Function1<ResolvedParameter, String> _function = new Function1<ResolvedParameter, String>() {
                public String apply(final ResolvedParameter it) {
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
      };
      return ObjectExtensions.<MutableConstructorDeclaration>operator_doubleArrow(ctor, _function);
    }
    
    public ResolvedConstructor getSuperConstructor(final TypeDeclaration it) {
      if ((it instanceof ClassDeclaration)) {
        TypeReference _extendedClass = ((ClassDeclaration)it).getExtendedClass();
        TypeReference _object = this.context.getObject();
        boolean _equals = Objects.equal(_extendedClass, _object);
        if (_equals) {
          return null;
        }
        TypeReference _extendedClass_1 = ((ClassDeclaration)it).getExtendedClass();
        Iterable<? extends ResolvedConstructor> _declaredResolvedConstructors = _extendedClass_1.getDeclaredResolvedConstructors();
        return IterableExtensions.head(_declaredResolvedConstructors);
      } else {
        return null;
      }
    }
  }
  
  public void doTransform(final List<? extends MutableTypeParameterDeclarator> elements, @Extension final TransformationContext context) {
    final Procedure1<MutableTypeParameterDeclarator> _function = new Procedure1<MutableTypeParameterDeclarator>() {
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
    boolean _hasFinalFieldsConstructor = util.hasFinalFieldsConstructor(it);
    if (_hasFinalFieldsConstructor) {
      context.addError(it, "A RequiredArgsConstructor is already defined");
    }
    util.addFinalFieldsConstructor(it);
  }
  
  private final static Pattern EMPTY_BODY = Pattern.compile("\\{\\s*\\}");
  
  protected void _transform(final MutableConstructorDeclaration it, @Extension final TransformationContext context) {
    @Extension
    final FinalFieldsConstructorProcessor.Util util = new FinalFieldsConstructorProcessor.Util(context);
    Iterable<? extends MutableParameterDeclaration> _parameters = it.getParameters();
    boolean _isEmpty = IterableExtensions.isEmpty(_parameters);
    boolean _not = (!_isEmpty);
    if (_not) {
      context.addError(it, "Parameter list must be empty");
    }
    Expression _body = it.getBody();
    String _string = _body.toString();
    Matcher _matcher = FinalFieldsConstructorProcessor.EMPTY_BODY.matcher(_string);
    boolean _matches = _matcher.matches();
    boolean _not_1 = (!_matches);
    if (_not_1) {
      context.addError(it, "Body must be empty");
    }
    MutableTypeDeclaration _declaringType = it.getDeclaringType();
    boolean _hasFinalFieldsConstructor = util.hasFinalFieldsConstructor(_declaringType);
    if (_hasFinalFieldsConstructor) {
      context.addError(it, "A FinalFieldsConstructor is already defined");
    }
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
