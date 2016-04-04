package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod;
import org.eclipse.xtend.lib.macro.declaration.ResolvedParameter;
import org.eclipse.xtend.lib.macro.declaration.ResolvedTypeParameter;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @since 2.7
 * @noextend
 * @noreference
 */
@Beta
@SuppressWarnings("all")
public class DelegateProcessor implements TransformationParticipant<MutableMemberDeclaration> {
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
    
    protected boolean _isValidDelegate(final FieldDeclaration it) {
      boolean _and = false;
      boolean _and_1 = false;
      boolean _hasValidType = this.hasValidType(it);
      if (!_hasValidType) {
        _and_1 = false;
      } else {
        boolean _hasDelegationConflicts = this.hasDelegationConflicts(it);
        boolean _not = (!_hasDelegationConflicts);
        _and_1 = _not;
      }
      if (!_and_1) {
        _and = false;
      } else {
        boolean _areListedInterfacesValid = this.areListedInterfacesValid(it);
        _and = _areListedInterfacesValid;
      }
      return _and;
    }
    
    protected boolean _isValidDelegate(final MethodDeclaration it) {
      boolean _and = false;
      boolean _and_1 = false;
      boolean _and_2 = false;
      boolean _hasValidType = this.hasValidType(it);
      if (!_hasValidType) {
        _and_2 = false;
      } else {
        boolean _hasValidSignature = this.hasValidSignature(it);
        _and_2 = _hasValidSignature;
      }
      if (!_and_2) {
        _and_1 = false;
      } else {
        boolean _hasDelegationConflicts = this.hasDelegationConflicts(it);
        boolean _not = (!_hasDelegationConflicts);
        _and_1 = _not;
      }
      if (!_and_1) {
        _and = false;
      } else {
        boolean _areListedInterfacesValid = this.areListedInterfacesValid(it);
        _and = _areListedInterfacesValid;
      }
      return _and;
    }
    
    public boolean hasValidType(final MemberDeclaration it) {
      boolean _xifexpression = false;
      boolean _or = false;
      TypeReference _type = this.getType(it);
      boolean _equals = Objects.equal(_type, null);
      if (_equals) {
        _or = true;
      } else {
        TypeReference _type_1 = this.getType(it);
        boolean _isInferred = _type_1.isInferred();
        _or = _isInferred;
      }
      if (_or) {
        boolean _xblockexpression = false;
        {
          this.context.addError(it, "Cannot use inferred types on delegates");
          _xblockexpression = false;
        }
        _xifexpression = _xblockexpression;
      } else {
        _xifexpression = true;
      }
      return _xifexpression;
    }
    
    protected TypeReference _getType(final FieldDeclaration it) {
      return it.getType();
    }
    
    protected TypeReference _getType(final MethodDeclaration it) {
      return it.getReturnType();
    }
    
    public boolean hasValidSignature(final MethodDeclaration it) {
      boolean _switchResult = false;
      Iterable<? extends ParameterDeclaration> _parameters = it.getParameters();
      final Function1<ParameterDeclaration, TypeReference> _function = new Function1<ParameterDeclaration, TypeReference>() {
        @Override
        public TypeReference apply(final ParameterDeclaration it) {
          return it.getType();
        }
      };
      Iterable<TypeReference> _map = IterableExtensions.map(_parameters, _function);
      List<TypeReference> _list = IterableExtensions.<TypeReference>toList(_map);
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(_list, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()))) {
          _matched=true;
        }
        if (!_matched) {
          TypeReference _string = this.context.getString();
          if (Objects.equal(_list, Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList(_string)))) {
            _matched=true;
          }
        }
        if (!_matched) {
          TypeReference _string_1 = this.context.getString();
          TypeReference _newWildcardTypeReference = this.context.newWildcardTypeReference();
          TypeReference _newTypeReference = this.context.newTypeReference(Class.class, _newWildcardTypeReference);
          TypeReference _newArrayTypeReference = this.context.newArrayTypeReference(_newTypeReference);
          TypeReference _object = this.context.getObject();
          TypeReference _newArrayTypeReference_1 = this.context.newArrayTypeReference(_object);
          if (Objects.equal(_list, Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList(_string_1, _newArrayTypeReference, _newArrayTypeReference_1)))) {
            _matched=true;
          }
        }
        if (_matched) {
          _switchResult = true;
        }
      }
      if (!_matched) {
        boolean _xblockexpression = false;
        {
          this.context.addError(it, "Not a valid delegate signature, use () or (String methodName) or (String methodName, Class<?>[] argumentTypes, Object[] arguments)");
          _xblockexpression = false;
        }
        _switchResult = _xblockexpression;
      }
      return _switchResult;
    }
    
    public boolean hasDelegationConflicts(final MemberDeclaration delegate) {
      boolean _xblockexpression = false;
      {
        boolean conflict = false;
        Iterable<? extends MemberDeclaration> _otherDelegates = this.otherDelegates(delegate);
        for (final MemberDeclaration other : _otherDelegates) {
          {
            final Set<TypeReference> otherInterfaces = this.getDelegatedInterfaces(other);
            Set<TypeReference> _delegatedInterfaces = this.getDelegatedInterfaces(delegate);
            for (final TypeReference iface : _delegatedInterfaces) {
              boolean _contains = otherInterfaces.contains(iface);
              if (_contains) {
                conflict = true;
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("The interface ");
                String _simpleName = iface.getSimpleName();
                _builder.append(_simpleName, "");
                _builder.append(" is also implemented by the delegate ");
                String _simpleName_1 = other.getSimpleName();
                _builder.append(_simpleName_1, "");
                this.context.addError(delegate, _builder.toString());
              }
            }
          }
        }
        _xblockexpression = conflict;
      }
      return _xblockexpression;
    }
    
    public Iterable<? extends MemberDeclaration> otherDelegates(final MemberDeclaration delegate) {
      TypeDeclaration _declaringType = delegate.getDeclaringType();
      Iterable<? extends MemberDeclaration> _delegates = this.getDelegates(_declaringType);
      final Function1<MemberDeclaration, Boolean> _function = new Function1<MemberDeclaration, Boolean>() {
        @Override
        public Boolean apply(final MemberDeclaration it) {
          return Boolean.valueOf((!Objects.equal(it, delegate)));
        }
      };
      return IterableExtensions.filter(_delegates, _function);
    }
    
    public boolean areListedInterfacesValid(final MemberDeclaration delegate) {
      boolean _xblockexpression = false;
      {
        TypeDeclaration _declaringType = delegate.getDeclaringType();
        final TypeReference declaringType = this.context.newSelfTypeReference(_declaringType);
        final Set<TypeReference> interfacesOfDeclaringType = this.getImplementedInterfaces(declaringType);
        TypeReference _type = this.getType(delegate);
        final Set<TypeReference> availableInterfaces = this.getImplementedInterfaces(_type);
        final Set<TypeReference> listedInterfaces = this.listedInterfaces(delegate);
        boolean valid = true;
        for (final TypeReference iface : listedInterfaces) {
          {
            final Function1<TypeReference, Boolean> _function = new Function1<TypeReference, Boolean>() {
              @Override
              public Boolean apply(final TypeReference it) {
                Type _type = it.getType();
                Type _type_1 = iface.getType();
                return Boolean.valueOf(Objects.equal(_type, _type_1));
              }
            };
            boolean _exists = IterableExtensions.<TypeReference>exists(availableInterfaces, _function);
            boolean _not = (!_exists);
            if (_not) {
              StringConcatenation _builder = new StringConcatenation();
              TypeReference _type_1 = this.getType(delegate);
              String _simpleName = _type_1.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append(" does not implement ");
              String _simpleName_1 = iface.getSimpleName();
              _builder.append(_simpleName_1, "");
              this.context.addError(delegate, _builder.toString());
              valid = false;
            }
            final Function1<TypeReference, Boolean> _function_1 = new Function1<TypeReference, Boolean>() {
              @Override
              public Boolean apply(final TypeReference it) {
                Type _type = it.getType();
                Type _type_1 = iface.getType();
                return Boolean.valueOf(Objects.equal(_type, _type_1));
              }
            };
            boolean _exists_1 = IterableExtensions.<TypeReference>exists(interfacesOfDeclaringType, _function_1);
            boolean _not_1 = (!_exists_1);
            if (_not_1) {
              StringConcatenation _builder_1 = new StringConcatenation();
              String _simpleName_2 = declaringType.getSimpleName();
              _builder_1.append(_simpleName_2, "");
              _builder_1.append(" does not implement ");
              String _simpleName_3 = iface.getSimpleName();
              _builder_1.append(_simpleName_3, "");
              this.context.addError(delegate, _builder_1.toString());
              valid = false;
            }
          }
        }
        boolean _and = false;
        boolean _isEmpty = listedInterfaces.isEmpty();
        if (!_isEmpty) {
          _and = false;
        } else {
          Sets.SetView<TypeReference> _intersection = Sets.<TypeReference>intersection(interfacesOfDeclaringType, availableInterfaces);
          boolean _isEmpty_1 = _intersection.isEmpty();
          _and = _isEmpty_1;
        }
        if (_and) {
          StringConcatenation _builder = new StringConcatenation();
          TypeReference _type_1 = this.getType(delegate);
          String _simpleName = _type_1.getSimpleName();
          _builder.append(_simpleName, "");
          _builder.append(" and ");
          String _simpleName_1 = declaringType.getSimpleName();
          _builder.append(_simpleName_1, "");
          _builder.append(" have no interfaces in common");
          this.context.addError(delegate, _builder.toString());
          valid = false;
        }
        _xblockexpression = valid;
      }
      return _xblockexpression;
    }
    
    public Iterable<? extends MemberDeclaration> getDelegates(final TypeDeclaration it) {
      Iterable<? extends MemberDeclaration> _declaredMembers = it.getDeclaredMembers();
      final Function1<MemberDeclaration, Boolean> _function = new Function1<MemberDeclaration, Boolean>() {
        @Override
        public Boolean apply(final MemberDeclaration it) {
          Type _findTypeGlobally = Util.this.context.findTypeGlobally(Delegate.class);
          AnnotationReference _findAnnotation = it.findAnnotation(_findTypeGlobally);
          return Boolean.valueOf((_findAnnotation != null));
        }
      };
      return IterableExtensions.filter(_declaredMembers, _function);
    }
    
    public Set<TypeReference> listedInterfaces(final MemberDeclaration it) {
      Type _findTypeGlobally = this.context.findTypeGlobally(Delegate.class);
      AnnotationReference _findAnnotation = it.findAnnotation(_findTypeGlobally);
      TypeReference[] _classArrayValue = _findAnnotation.getClassArrayValue("value");
      return IterableExtensions.<TypeReference>toSet(((Iterable<TypeReference>)Conversions.doWrapArray(_classArrayValue)));
    }
    
    public Set<TypeReference> getImplementedInterfaces(final TypeReference it) {
      Set<TypeReference> _xblockexpression = null;
      {
        final LinkedHashSet<TypeReference> seen = CollectionLiterals.<TypeReference>newLinkedHashSet();
        this.collectAllSuperTypes(it, seen);
        final Function1<TypeReference, Boolean> _function = new Function1<TypeReference, Boolean>() {
          @Override
          public Boolean apply(final TypeReference it) {
            Type _type = it.getType();
            return Boolean.valueOf((_type instanceof InterfaceDeclaration));
          }
        };
        Iterable<TypeReference> _filter = IterableExtensions.<TypeReference>filter(seen, _function);
        _xblockexpression = IterableExtensions.<TypeReference>toSet(_filter);
      }
      return _xblockexpression;
    }
    
    private void collectAllSuperTypes(final TypeReference it, final Set<TypeReference> seen) {
      boolean _add = seen.add(it);
      final boolean cycle = (!_add);
      if (cycle) {
        return;
      }
      Iterable<? extends TypeReference> _declaredSuperTypes = it.getDeclaredSuperTypes();
      for (final TypeReference it_1 : _declaredSuperTypes) {
        this.collectAllSuperTypes(it_1, seen);
      }
    }
    
    public Set<TypeReference> getDelegatedInterfaces(final MemberDeclaration delegate) {
      Set<TypeReference> _xblockexpression = null;
      {
        TypeDeclaration _declaringType = delegate.getDeclaringType();
        TypeReference _newSelfTypeReference = this.context.newSelfTypeReference(_declaringType);
        final Set<TypeReference> interfacesOfDeclaringType = this.getImplementedInterfaces(_newSelfTypeReference);
        final Set<TypeReference> listedInterfaces = this.listedInterfaces(delegate);
        TypeReference _type = this.getType(delegate);
        final Set<TypeReference> availableInterfaces = this.getImplementedInterfaces(_type);
        final Function1<TypeReference, Boolean> _function = new Function1<TypeReference, Boolean>() {
          @Override
          public Boolean apply(final TypeReference iface) {
            boolean _and = false;
            boolean _contains = interfacesOfDeclaringType.contains(iface);
            if (!_contains) {
              _and = false;
            } else {
              boolean _or = false;
              boolean _isEmpty = listedInterfaces.isEmpty();
              if (_isEmpty) {
                _or = true;
              } else {
                final Function1<TypeReference, Boolean> _function = new Function1<TypeReference, Boolean>() {
                  @Override
                  public Boolean apply(final TypeReference it) {
                    return Boolean.valueOf(iface.isAssignableFrom(it));
                  }
                };
                boolean _exists = IterableExtensions.<TypeReference>exists(listedInterfaces, _function);
                _or = _exists;
              }
              _and = _or;
            }
            return Boolean.valueOf(_and);
          }
        };
        Iterable<TypeReference> _filter = IterableExtensions.<TypeReference>filter(availableInterfaces, _function);
        _xblockexpression = IterableExtensions.<TypeReference>toSet(_filter);
      }
      return _xblockexpression;
    }
    
    public Set<ResolvedMethod> getMethodsToImplement(final MemberDeclaration delegate) {
      Set<TypeReference> _delegatedInterfaces = this.getDelegatedInterfaces(delegate);
      final Function1<TypeReference, Iterable<? extends ResolvedMethod>> _function = new Function1<TypeReference, Iterable<? extends ResolvedMethod>>() {
        @Override
        public Iterable<? extends ResolvedMethod> apply(final TypeReference it) {
          return it.getDeclaredResolvedMethods();
        }
      };
      Iterable<Iterable<? extends ResolvedMethod>> _map = IterableExtensions.<TypeReference, Iterable<? extends ResolvedMethod>>map(_delegatedInterfaces, _function);
      Iterable<ResolvedMethod> _flatten = Iterables.<ResolvedMethod>concat(_map);
      final Function1<ResolvedMethod, Boolean> _function_1 = new Function1<ResolvedMethod, Boolean>() {
        @Override
        public Boolean apply(final ResolvedMethod it) {
          TypeDeclaration _declaringType = delegate.getDeclaringType();
          MethodDeclaration _declaration = it.getDeclaration();
          String _simpleName = _declaration.getSimpleName();
          Iterable<? extends ResolvedParameter> _resolvedParameters = it.getResolvedParameters();
          final Function1<ResolvedParameter, TypeReference> _function = new Function1<ResolvedParameter, TypeReference>() {
            @Override
            public TypeReference apply(final ResolvedParameter it) {
              return it.getResolvedType();
            }
          };
          Iterable<TypeReference> _map = IterableExtensions.map(_resolvedParameters, _function);
          MethodDeclaration _findDeclaredMethod = _declaringType.findDeclaredMethod(_simpleName, ((TypeReference[])Conversions.unwrapArray(_map, TypeReference.class)));
          return Boolean.valueOf(Objects.equal(_findDeclaredMethod, null));
        }
      };
      Iterable<ResolvedMethod> _filter = IterableExtensions.<ResolvedMethod>filter(_flatten, _function_1);
      final Function1<ResolvedMethod, Boolean> _function_2 = new Function1<ResolvedMethod, Boolean>() {
        @Override
        public Boolean apply(final ResolvedMethod it) {
          boolean _isObjectMethod = Util.this.isObjectMethod(it);
          return Boolean.valueOf((!_isObjectMethod));
        }
      };
      Iterable<ResolvedMethod> _filter_1 = IterableExtensions.<ResolvedMethod>filter(_filter, _function_2);
      final Function1<ResolvedMethod, String> _function_3 = new Function1<ResolvedMethod, String>() {
        @Override
        public String apply(final ResolvedMethod it) {
          return it.getSimpleSignature();
        }
      };
      Map<String, List<ResolvedMethod>> _groupBy = IterableExtensions.<String, ResolvedMethod>groupBy(_filter_1, _function_3);
      Collection<List<ResolvedMethod>> _values = _groupBy.values();
      final Function1<List<ResolvedMethod>, ResolvedMethod> _function_4 = new Function1<List<ResolvedMethod>, ResolvedMethod>() {
        @Override
        public ResolvedMethod apply(final List<ResolvedMethod> it) {
          return IterableExtensions.<ResolvedMethod>head(it);
        }
      };
      Iterable<ResolvedMethod> _map_1 = IterableExtensions.<List<ResolvedMethod>, ResolvedMethod>map(_values, _function_4);
      return IterableExtensions.<ResolvedMethod>toSet(_map_1);
    }
    
    public boolean isObjectMethod(final ResolvedMethod it) {
      boolean _xblockexpression = false;
      {
        MethodDeclaration _declaration = it.getDeclaration();
        final String name = _declaration.getSimpleName();
        Iterable<? extends ResolvedParameter> _resolvedParameters = it.getResolvedParameters();
        final Function1<ResolvedParameter, TypeReference> _function = new Function1<ResolvedParameter, TypeReference>() {
          @Override
          public TypeReference apply(final ResolvedParameter it) {
            return it.getResolvedType();
          }
        };
        Iterable<TypeReference> _map = IterableExtensions.map(_resolvedParameters, _function);
        final List<TypeReference> parameterTypes = IterableExtensions.<TypeReference>toList(_map);
        boolean _or = false;
        boolean _or_1 = false;
        boolean _or_2 = false;
        boolean _or_3 = false;
        boolean _and = false;
        boolean _equals = Objects.equal(name, "hashCode");
        if (!_equals) {
          _and = false;
        } else {
          boolean _isEmpty = parameterTypes.isEmpty();
          _and = _isEmpty;
        }
        if (_and) {
          _or_3 = true;
        } else {
          boolean _and_1 = false;
          boolean _equals_1 = Objects.equal(name, "toString");
          if (!_equals_1) {
            _and_1 = false;
          } else {
            boolean _isEmpty_1 = parameterTypes.isEmpty();
            _and_1 = _isEmpty_1;
          }
          _or_3 = _and_1;
        }
        if (_or_3) {
          _or_2 = true;
        } else {
          boolean _and_2 = false;
          boolean _equals_2 = Objects.equal(name, "equals");
          if (!_equals_2) {
            _and_2 = false;
          } else {
            TypeReference _object = this.context.getObject();
            boolean _equals_3 = Objects.equal(parameterTypes, Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList(_object)));
            _and_2 = _equals_3;
          }
          _or_2 = _and_2;
        }
        if (_or_2) {
          _or_1 = true;
        } else {
          boolean _and_3 = false;
          boolean _equals_4 = Objects.equal(name, "finalize");
          if (!_equals_4) {
            _and_3 = false;
          } else {
            boolean _isEmpty_2 = parameterTypes.isEmpty();
            _and_3 = _isEmpty_2;
          }
          _or_1 = _and_3;
        }
        if (_or_1) {
          _or = true;
        } else {
          boolean _and_4 = false;
          boolean _equals_5 = Objects.equal(name, "clone");
          if (!_equals_5) {
            _and_4 = false;
          } else {
            boolean _isEmpty_3 = parameterTypes.isEmpty();
            _and_4 = _isEmpty_3;
          }
          _or = _and_4;
        }
        _xblockexpression = _or;
      }
      return _xblockexpression;
    }
    
    public MutableMethodDeclaration implementMethod(final MutableMemberDeclaration delegate, final ResolvedMethod resolvedMethod) {
      MutableMethodDeclaration _xblockexpression = null;
      {
        delegate.markAsRead();
        final MethodDeclaration declaration = resolvedMethod.getDeclaration();
        MutableTypeDeclaration _declaringType = delegate.getDeclaringType();
        String _simpleName = declaration.getSimpleName();
        final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
          @Override
          public void apply(final MutableMethodDeclaration impl) {
            Element _primarySourceElement = Util.this.context.getPrimarySourceElement(delegate);
            Util.this.context.setPrimarySourceElement(impl, _primarySourceElement);
            final HashMap<TypeReference, TypeReference> typeParameterMappings = CollectionLiterals.<TypeReference, TypeReference>newHashMap();
            Iterable<? extends ResolvedTypeParameter> _resolvedTypeParameters = resolvedMethod.getResolvedTypeParameters();
            for (final ResolvedTypeParameter param : _resolvedTypeParameters) {
              {
                TypeParameterDeclaration _declaration = param.getDeclaration();
                String _simpleName = _declaration.getSimpleName();
                Iterable<? extends TypeReference> _resolvedUpperBounds = param.getResolvedUpperBounds();
                final MutableTypeParameterDeclaration copy = impl.addTypeParameter(_simpleName, ((TypeReference[])Conversions.unwrapArray(_resolvedUpperBounds, TypeReference.class)));
                TypeParameterDeclaration _declaration_1 = param.getDeclaration();
                TypeReference _newTypeReference = Util.this.context.newTypeReference(_declaration_1);
                TypeReference _newTypeReference_1 = Util.this.context.newTypeReference(copy);
                typeParameterMappings.put(_newTypeReference, _newTypeReference_1);
                Iterable<? extends TypeReference> _upperBounds = copy.getUpperBounds();
                final Function1<TypeReference, TypeReference> _function = new Function1<TypeReference, TypeReference>() {
                  @Override
                  public TypeReference apply(final TypeReference it) {
                    return Util.this.replace(it, typeParameterMappings);
                  }
                };
                Iterable<TypeReference> _map = IterableExtensions.map(_upperBounds, _function);
                copy.setUpperBounds(_map);
              }
            }
            Iterable<? extends TypeReference> _resolvedExceptionTypes = resolvedMethod.getResolvedExceptionTypes();
            final Function1<TypeReference, TypeReference> _function = new Function1<TypeReference, TypeReference>() {
              @Override
              public TypeReference apply(final TypeReference it) {
                return Util.this.replace(it, typeParameterMappings);
              }
            };
            Iterable<TypeReference> _map = IterableExtensions.map(_resolvedExceptionTypes, _function);
            impl.setExceptions(((TypeReference[])Conversions.unwrapArray(_map, TypeReference.class)));
            boolean _isVarArgs = declaration.isVarArgs();
            impl.setVarArgs(_isVarArgs);
            TypeReference _resolvedReturnType = resolvedMethod.getResolvedReturnType();
            TypeReference _replace = Util.this.replace(_resolvedReturnType, typeParameterMappings);
            impl.setReturnType(_replace);
            Iterable<? extends ResolvedParameter> _resolvedParameters = resolvedMethod.getResolvedParameters();
            for (final ResolvedParameter p : _resolvedParameters) {
              ParameterDeclaration _declaration = p.getDeclaration();
              String _simpleName = _declaration.getSimpleName();
              TypeReference _resolvedType = p.getResolvedType();
              TypeReference _replace_1 = Util.this.replace(_resolvedType, typeParameterMappings);
              impl.addParameter(_simpleName, _replace_1);
            }
            StringConcatenationClient _client = new StringConcatenationClient() {
              @Override
              protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                String _returnIfNeeded = Util.this.returnIfNeeded(resolvedMethod);
                _builder.append(_returnIfNeeded, "");
                CharSequence _delegateAccess = Util.this.delegateAccess(delegate, declaration);
                _builder.append(_delegateAccess, "");
                _builder.append(".");
                String _simpleName = declaration.getSimpleName();
                _builder.append(_simpleName, "");
                _builder.append("(");
                Iterable<? extends ParameterDeclaration> _parameters = declaration.getParameters();
                final Function1<ParameterDeclaration, CharSequence> _function = new Function1<ParameterDeclaration, CharSequence>() {
                  @Override
                  public CharSequence apply(final ParameterDeclaration it) {
                    return it.getSimpleName();
                  }
                };
                String _join = IterableExtensions.join(_parameters, ", ", _function);
                _builder.append(_join, "");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              }
            };
            impl.setBody(_client);
          }
        };
        _xblockexpression = _declaringType.addMethod(_simpleName, _function);
      }
      return _xblockexpression;
    }
    
    public TypeReference replace(final TypeReference target, final Map<? extends TypeReference, ? extends TypeReference> mappings) {
      Set<? extends Map.Entry<? extends TypeReference, ? extends TypeReference>> _entrySet = mappings.entrySet();
      final Function2<TypeReference, Map.Entry<? extends TypeReference, ? extends TypeReference>, TypeReference> _function = new Function2<TypeReference, Map.Entry<? extends TypeReference, ? extends TypeReference>, TypeReference>() {
        @Override
        public TypeReference apply(final TypeReference result, final Map.Entry<? extends TypeReference, ? extends TypeReference> mapping) {
          TypeReference _key = mapping.getKey();
          TypeReference _value = mapping.getValue();
          return Util.this.replace(result, _key, _value);
        }
      };
      return IterableExtensions.fold(_entrySet, target, _function);
    }
    
    public TypeReference replace(final TypeReference target, final TypeReference oldType, final TypeReference newType) {
      boolean _equals = Objects.equal(target, oldType);
      if (_equals) {
        return newType;
      }
      List<TypeReference> _actualTypeArguments = target.getActualTypeArguments();
      boolean _isEmpty = _actualTypeArguments.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        Type _type = target.getType();
        List<TypeReference> _actualTypeArguments_1 = target.getActualTypeArguments();
        final Function1<TypeReference, TypeReference> _function = new Function1<TypeReference, TypeReference>() {
          @Override
          public TypeReference apply(final TypeReference it) {
            return Util.this.replace(it, oldType, newType);
          }
        };
        List<TypeReference> _map = ListExtensions.<TypeReference, TypeReference>map(_actualTypeArguments_1, _function);
        return this.context.newTypeReference(_type, ((TypeReference[])Conversions.unwrapArray(_map, TypeReference.class)));
      }
      boolean _isWildCard = target.isWildCard();
      if (_isWildCard) {
        TypeReference _upperBound = target.getUpperBound();
        TypeReference _object = this.context.getObject();
        boolean _notEquals = (!Objects.equal(_upperBound, _object));
        if (_notEquals) {
          TypeReference _upperBound_1 = target.getUpperBound();
          TypeReference _replace = this.replace(_upperBound_1, oldType, newType);
          return this.context.newWildcardTypeReference(_replace);
        } else {
          TypeReference _lowerBound = target.getLowerBound();
          boolean _isAnyType = _lowerBound.isAnyType();
          boolean _not_1 = (!_isAnyType);
          if (_not_1) {
            TypeReference _lowerBound_1 = target.getLowerBound();
            TypeReference _replace_1 = this.replace(_lowerBound_1, oldType, newType);
            return this.context.newWildcardTypeReferenceWithLowerBound(_replace_1);
          }
        }
      }
      boolean _isArray = target.isArray();
      if (_isArray) {
        TypeReference _arrayComponentType = target.getArrayComponentType();
        TypeReference _replace_2 = this.replace(_arrayComponentType, oldType, newType);
        return this.context.newArrayTypeReference(_replace_2);
      }
      return target;
    }
    
    protected CharSequence _delegateAccess(final FieldDeclaration it, final MethodDeclaration method) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("this.");
      String _simpleName = it.getSimpleName();
      _builder.append(_simpleName, "");
      return _builder;
    }
    
    protected CharSequence _delegateAccess(final MethodDeclaration it, final MethodDeclaration method) {
      CharSequence _switchResult = null;
      Iterable<? extends ParameterDeclaration> _parameters = it.getParameters();
      final Function1<ParameterDeclaration, TypeReference> _function = new Function1<ParameterDeclaration, TypeReference>() {
        @Override
        public TypeReference apply(final ParameterDeclaration it) {
          return it.getType();
        }
      };
      Iterable<TypeReference> _map = IterableExtensions.map(_parameters, _function);
      List<TypeReference> _list = IterableExtensions.<TypeReference>toList(_map);
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(_list, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()))) {
          _matched=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("this.");
          String _simpleName = it.getSimpleName();
          _builder.append(_simpleName, "");
          _builder.append("()");
          _switchResult = _builder;
        }
      }
      if (!_matched) {
        TypeReference _string = this.context.getString();
        if (Objects.equal(_list, Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList(_string)))) {
          _matched=true;
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("this.");
          String _simpleName_1 = it.getSimpleName();
          _builder_1.append(_simpleName_1, "");
          _builder_1.append("(\"");
          String _simpleName_2 = method.getSimpleName();
          _builder_1.append(_simpleName_2, "");
          _builder_1.append("\")");
          _switchResult = _builder_1;
        }
      }
      if (!_matched) {
        TypeReference _string_1 = this.context.getString();
        TypeReference _newWildcardTypeReference = this.context.newWildcardTypeReference();
        TypeReference _newTypeReference = this.context.newTypeReference(Class.class, _newWildcardTypeReference);
        TypeReference _newArrayTypeReference = this.context.newArrayTypeReference(_newTypeReference);
        TypeReference _object = this.context.getObject();
        TypeReference _newArrayTypeReference_1 = this.context.newArrayTypeReference(_object);
        if (Objects.equal(_list, Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList(_string_1, _newArrayTypeReference, _newArrayTypeReference_1)))) {
          _matched=true;
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("this.");
          String _simpleName_3 = it.getSimpleName();
          _builder_2.append(_simpleName_3, "");
          _builder_2.append("(\"");
          String _simpleName_4 = method.getSimpleName();
          _builder_2.append(_simpleName_4, "");
          _builder_2.append("\", new Class[]{");
          Iterable<? extends ParameterDeclaration> _parameters_1 = method.getParameters();
          final Function1<ParameterDeclaration, CharSequence> _function_1 = new Function1<ParameterDeclaration, CharSequence>() {
            @Override
            public CharSequence apply(final ParameterDeclaration it) {
              TypeReference _type = it.getType();
              Type _type_1 = _type.getType();
              String _simpleName = _type_1.getSimpleName();
              return (_simpleName + ".class");
            }
          };
          String _join = IterableExtensions.join(_parameters_1, ", ", _function_1);
          _builder_2.append(_join, "");
          _builder_2.append("}, new Object[]{");
          Iterable<? extends ParameterDeclaration> _parameters_2 = method.getParameters();
          final Function1<ParameterDeclaration, CharSequence> _function_2 = new Function1<ParameterDeclaration, CharSequence>() {
            @Override
            public CharSequence apply(final ParameterDeclaration it) {
              return it.getSimpleName();
            }
          };
          String _join_1 = IterableExtensions.join(_parameters_2, ", ", _function_2);
          _builder_2.append(_join_1, "");
          _builder_2.append("})");
          _switchResult = _builder_2;
        }
      }
      if (!_matched) {
        throw new IllegalArgumentException("delegate signature");
      }
      return _switchResult;
    }
    
    public String returnIfNeeded(final ResolvedMethod it) {
      String _xifexpression = null;
      TypeReference _resolvedReturnType = it.getResolvedReturnType();
      boolean _isVoid = _resolvedReturnType.isVoid();
      if (_isVoid) {
        _xifexpression = "";
      } else {
        _xifexpression = "return ";
      }
      return _xifexpression;
    }
    
    public boolean isValidDelegate(final MemberDeclaration it) {
      if (it instanceof MethodDeclaration) {
        return _isValidDelegate((MethodDeclaration)it);
      } else if (it instanceof FieldDeclaration) {
        return _isValidDelegate((FieldDeclaration)it);
      } else {
        throw new IllegalArgumentException("Unhandled parameter types: " +
          Arrays.<Object>asList(it).toString());
      }
    }
    
    public TypeReference getType(final MemberDeclaration it) {
      if (it instanceof MethodDeclaration) {
        return _getType((MethodDeclaration)it);
      } else if (it instanceof FieldDeclaration) {
        return _getType((FieldDeclaration)it);
      } else {
        throw new IllegalArgumentException("Unhandled parameter types: " +
          Arrays.<Object>asList(it).toString());
      }
    }
    
    public CharSequence delegateAccess(final MemberDeclaration it, final MethodDeclaration method) {
      if (it instanceof MethodDeclaration) {
        return _delegateAccess((MethodDeclaration)it, method);
      } else if (it instanceof FieldDeclaration) {
        return _delegateAccess((FieldDeclaration)it, method);
      } else {
        throw new IllegalArgumentException("Unhandled parameter types: " +
          Arrays.<Object>asList(it, method).toString());
      }
    }
  }
  
  @Override
  public void doTransform(final List<? extends MutableMemberDeclaration> elements, @Extension final TransformationContext context) {
    @Extension
    final DelegateProcessor.Util util = new DelegateProcessor.Util(context);
    for (final MutableMemberDeclaration it : elements) {
      boolean _isValidDelegate = util.isValidDelegate(it);
      if (_isValidDelegate) {
        Set<ResolvedMethod> _methodsToImplement = util.getMethodsToImplement(it);
        for (final ResolvedMethod method : _methodsToImplement) {
          util.implementMethod(it, method);
        }
      }
    }
  }
}
