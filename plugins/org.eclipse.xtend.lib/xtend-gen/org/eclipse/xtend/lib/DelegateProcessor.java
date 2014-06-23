package org.eclipse.xtend.lib;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend.lib.Delegate;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Synthetic;

/**
 * @since 2.7
 */
@SuppressWarnings("all")
public class DelegateProcessor implements TransformationParticipant<MutableMemberDeclaration> {
  /**
   * @since 2.7
   */
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
      TypeReference _type = this.getType(it);
      boolean _isInferred = _type.isInferred();
      if (_isInferred) {
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
        public TypeReference apply(final ParameterDeclaration it) {
          return it.getType();
        }
      };
      Iterable<TypeReference> _map = IterableExtensions.map(_parameters, _function);
      List<TypeReference> _list = IterableExtensions.<TypeReference>toList(_map);
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(_list, Collections.<Object>unmodifiableList(Lists.<Object>newArrayList()))) {
          _matched=true;
        }
        if (!_matched) {
          TypeReference _string = this.context.getString();
          if (Objects.equal(_list, Collections.<TypeReference>unmodifiableList(Lists.<TypeReference>newArrayList(_string)))) {
            _matched=true;
          }
        }
        if (!_matched) {
          TypeReference _string_1 = this.context.getString();
          TypeReference _object = this.context.getObject();
          TypeReference _newArrayTypeReference = this.context.newArrayTypeReference(_object);
          if (Objects.equal(_list, Collections.<TypeReference>unmodifiableList(Lists.<TypeReference>newArrayList(_string_1, _newArrayTypeReference)))) {
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
          this.context.addError(it, "Not a valid delegate signature, use (), (String) or (String, Object[])");
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
            final Set<? extends InterfaceDeclaration> otherInterfaces = this.getDelegatedInterfaces(other);
            Set<? extends InterfaceDeclaration> _delegatedInterfaces = this.getDelegatedInterfaces(delegate);
            for (final InterfaceDeclaration iface : _delegatedInterfaces) {
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
      TypeDeclaration _originalDeclaringType = this.originalDeclaringType(delegate);
      Iterable<? extends MemberDeclaration> _delegates = this.getDelegates(_originalDeclaringType);
      final Function1<MemberDeclaration, Boolean> _function = new Function1<MemberDeclaration, Boolean>() {
        public Boolean apply(final MemberDeclaration it) {
          NamedElement _primarySourceElement = Util.this.context.getPrimarySourceElement(delegate);
          return Boolean.valueOf((!Objects.equal(it, _primarySourceElement)));
        }
      };
      return IterableExtensions.filter(_delegates, _function);
    }
    
    public TypeDeclaration originalDeclaringType(final MemberDeclaration it) {
      TypeDeclaration _xifexpression = null;
      boolean _isSource = this.context.isSource(it);
      if (_isSource) {
        _xifexpression = it.getDeclaringType();
      } else {
        NamedElement _primarySourceElement = this.context.getPrimarySourceElement(it);
        _xifexpression = ((MemberDeclaration) _primarySourceElement).getDeclaringType();
      }
      return _xifexpression;
    }
    
    public boolean areListedInterfacesValid(final MemberDeclaration delegate) {
      boolean _xblockexpression = false;
      {
        final TypeDeclaration declaringType = this.originalDeclaringType(delegate);
        Set<? extends InterfaceDeclaration> _implementedInterfaces = this.getImplementedInterfaces(declaringType);
        final Function1<InterfaceDeclaration, TypeReference> _function = new Function1<InterfaceDeclaration, TypeReference>() {
          public TypeReference apply(final InterfaceDeclaration it) {
            return Util.this.context.newTypeReference(it);
          }
        };
        Iterable<TypeReference> _map = IterableExtensions.map(_implementedInterfaces, _function);
        final Set<TypeReference> interfacesOfDeclaringType = IterableExtensions.<TypeReference>toSet(_map);
        TypeReference _type = this.getType(delegate);
        Type _type_1 = _type.getType();
        Set<? extends InterfaceDeclaration> _implementedInterfaces_1 = this.getImplementedInterfaces(_type_1);
        final Function1<InterfaceDeclaration, TypeReference> _function_1 = new Function1<InterfaceDeclaration, TypeReference>() {
          public TypeReference apply(final InterfaceDeclaration it) {
            return Util.this.context.newTypeReference(it);
          }
        };
        Iterable<TypeReference> _map_1 = IterableExtensions.map(_implementedInterfaces_1, _function_1);
        final Set<TypeReference> availableInterfaces = IterableExtensions.<TypeReference>toSet(_map_1);
        final Set<TypeReference> listedInterfaces = this.listedInterfaces(delegate);
        boolean valid = true;
        for (final TypeReference iface : listedInterfaces) {
          {
            boolean _contains = availableInterfaces.contains(iface);
            boolean _not = (!_contains);
            if (_not) {
              StringConcatenation _builder = new StringConcatenation();
              TypeReference _type_2 = this.getType(delegate);
              String _simpleName = _type_2.getSimpleName();
              _builder.append(_simpleName, "");
              _builder.append(" does not implement ");
              String _simpleName_1 = iface.getSimpleName();
              _builder.append(_simpleName_1, "");
              this.context.addError(delegate, _builder.toString());
              valid = false;
            }
            boolean _contains_1 = interfacesOfDeclaringType.contains(iface);
            boolean _not_1 = (!_contains_1);
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
          TypeReference _type_2 = this.getType(delegate);
          String _simpleName = _type_2.getSimpleName();
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
    
    protected Set<? extends InterfaceDeclaration> _getImplementedInterfaces(final Type it) {
      return Collections.<InterfaceDeclaration>unmodifiableSet(Sets.<InterfaceDeclaration>newHashSet());
    }
    
    protected Set<? extends InterfaceDeclaration> _getImplementedInterfaces(final InterfaceDeclaration it) {
      Iterable<? extends TypeReference> _extendedInterfaces = it.getExtendedInterfaces();
      final Function1<TypeReference, Set<? extends InterfaceDeclaration>> _function = new Function1<TypeReference, Set<? extends InterfaceDeclaration>>() {
        public Set<? extends InterfaceDeclaration> apply(final TypeReference it) {
          Type _type = it.getType();
          return Util.this.getImplementedInterfaces(_type);
        }
      };
      Iterable<Set<? extends InterfaceDeclaration>> _map = IterableExtensions.map(_extendedInterfaces, _function);
      Iterable<InterfaceDeclaration> _flatten = Iterables.<InterfaceDeclaration>concat(_map);
      Iterable<InterfaceDeclaration> _plus = Iterables.<InterfaceDeclaration>concat(Collections.<InterfaceDeclaration>unmodifiableList(Lists.<InterfaceDeclaration>newArrayList(it)), _flatten);
      return IterableExtensions.<InterfaceDeclaration>toSet(_plus);
    }
    
    protected Set<? extends InterfaceDeclaration> _getImplementedInterfaces(final ClassDeclaration it) {
      Iterable<? extends TypeReference> _implementedInterfaces = it.getImplementedInterfaces();
      final Function1<TypeReference, Set<? extends InterfaceDeclaration>> _function = new Function1<TypeReference, Set<? extends InterfaceDeclaration>>() {
        public Set<? extends InterfaceDeclaration> apply(final TypeReference it) {
          Type _type = it.getType();
          return Util.this.getImplementedInterfaces(_type);
        }
      };
      Iterable<Set<? extends InterfaceDeclaration>> _map = IterableExtensions.map(_implementedInterfaces, _function);
      Iterable<InterfaceDeclaration> _flatten = Iterables.<InterfaceDeclaration>concat(_map);
      return IterableExtensions.<InterfaceDeclaration>toSet(_flatten);
    }
    
    public Set<? extends InterfaceDeclaration> getDelegatedInterfaces(final MemberDeclaration delegate) {
      Set<? extends InterfaceDeclaration> _xblockexpression = null;
      {
        TypeDeclaration _originalDeclaringType = this.originalDeclaringType(delegate);
        final Set<? extends InterfaceDeclaration> interfacesOfDeclaringType = this.getImplementedInterfaces(_originalDeclaringType);
        final Set<TypeReference> listedInterfaces = this.listedInterfaces(delegate);
        TypeReference _type = this.getType(delegate);
        Type _type_1 = _type.getType();
        final Set<? extends InterfaceDeclaration> availableInterfaces = this.getImplementedInterfaces(_type_1);
        final Function1<InterfaceDeclaration, Boolean> _function = new Function1<InterfaceDeclaration, Boolean>() {
          public Boolean apply(final InterfaceDeclaration iface) {
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
                  public Boolean apply(final TypeReference it) {
                    TypeReference _newTypeReference = Util.this.context.newTypeReference(iface);
                    return Boolean.valueOf(_newTypeReference.isAssignableFrom(it));
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
        Iterable<? extends InterfaceDeclaration> _filter = IterableExtensions.filter(availableInterfaces, _function);
        _xblockexpression = IterableExtensions.toSet(_filter);
      }
      return _xblockexpression;
    }
    
    public Set<MethodDeclaration> getMethodsToImplement(final MemberDeclaration delegate) {
      Set<? extends InterfaceDeclaration> _delegatedInterfaces = this.getDelegatedInterfaces(delegate);
      final Function1<InterfaceDeclaration, Iterable<? extends MethodDeclaration>> _function = new Function1<InterfaceDeclaration, Iterable<? extends MethodDeclaration>>() {
        public Iterable<? extends MethodDeclaration> apply(final InterfaceDeclaration it) {
          return it.getDeclaredMethods();
        }
      };
      Iterable<Iterable<? extends MethodDeclaration>> _map = IterableExtensions.map(_delegatedInterfaces, _function);
      Iterable<MethodDeclaration> _flatten = Iterables.<MethodDeclaration>concat(_map);
      final Function1<MethodDeclaration, Boolean> _function_1 = new Function1<MethodDeclaration, Boolean>() {
        public Boolean apply(final MethodDeclaration it) {
          TypeDeclaration _originalDeclaringType = Util.this.originalDeclaringType(delegate);
          String _simpleName = it.getSimpleName();
          Iterable<? extends ParameterDeclaration> _parameters = it.getParameters();
          final Function1<ParameterDeclaration, TypeReference> _function = new Function1<ParameterDeclaration, TypeReference>() {
            public TypeReference apply(final ParameterDeclaration it) {
              return it.getType();
            }
          };
          Iterable<TypeReference> _map = IterableExtensions.map(_parameters, _function);
          MethodDeclaration _findDeclaredMethod = _originalDeclaringType.findDeclaredMethod(_simpleName, ((TypeReference[])Conversions.unwrapArray(_map, TypeReference.class)));
          return Boolean.valueOf(Objects.equal(_findDeclaredMethod, null));
        }
      };
      Iterable<MethodDeclaration> _filter = IterableExtensions.<MethodDeclaration>filter(_flatten, _function_1);
      final Function1<MethodDeclaration, Boolean> _function_2 = new Function1<MethodDeclaration, Boolean>() {
        public Boolean apply(final MethodDeclaration it) {
          boolean _isObjectMethod = Util.this.isObjectMethod(it);
          return Boolean.valueOf((!_isObjectMethod));
        }
      };
      Iterable<MethodDeclaration> _filter_1 = IterableExtensions.<MethodDeclaration>filter(_filter, _function_2);
      return IterableExtensions.<MethodDeclaration>toSet(_filter_1);
    }
    
    public boolean isObjectMethod(final MethodDeclaration it) {
      boolean _or = false;
      boolean _or_1 = false;
      boolean _or_2 = false;
      boolean _or_3 = false;
      boolean _and = false;
      String _simpleName = it.getSimpleName();
      boolean _equals = Objects.equal(_simpleName, "hashCode");
      if (!_equals) {
        _and = false;
      } else {
        Iterable<? extends ParameterDeclaration> _parameters = it.getParameters();
        boolean _isEmpty = IterableExtensions.isEmpty(_parameters);
        _and = _isEmpty;
      }
      if (_and) {
        _or_3 = true;
      } else {
        boolean _and_1 = false;
        String _simpleName_1 = it.getSimpleName();
        boolean _equals_1 = Objects.equal(_simpleName_1, "toString");
        if (!_equals_1) {
          _and_1 = false;
        } else {
          Iterable<? extends ParameterDeclaration> _parameters_1 = it.getParameters();
          boolean _isEmpty_1 = IterableExtensions.isEmpty(_parameters_1);
          _and_1 = _isEmpty_1;
        }
        _or_3 = _and_1;
      }
      if (_or_3) {
        _or_2 = true;
      } else {
        boolean _and_2 = false;
        String _simpleName_2 = it.getSimpleName();
        boolean _equals_2 = Objects.equal(_simpleName_2, "equals");
        if (!_equals_2) {
          _and_2 = false;
        } else {
          Iterable<? extends ParameterDeclaration> _parameters_2 = it.getParameters();
          final Function1<ParameterDeclaration, TypeReference> _function = new Function1<ParameterDeclaration, TypeReference>() {
            public TypeReference apply(final ParameterDeclaration it) {
              return it.getType();
            }
          };
          Iterable<TypeReference> _map = IterableExtensions.map(_parameters_2, _function);
          List<TypeReference> _list = IterableExtensions.<TypeReference>toList(_map);
          TypeReference _object = this.context.getObject();
          boolean _equals_3 = Objects.equal(_list, Collections.<TypeReference>unmodifiableList(Lists.<TypeReference>newArrayList(_object)));
          _and_2 = _equals_3;
        }
        _or_2 = _and_2;
      }
      if (_or_2) {
        _or_1 = true;
      } else {
        boolean _and_3 = false;
        String _simpleName_3 = it.getSimpleName();
        boolean _equals_4 = Objects.equal(_simpleName_3, "finalize");
        if (!_equals_4) {
          _and_3 = false;
        } else {
          Iterable<? extends ParameterDeclaration> _parameters_3 = it.getParameters();
          boolean _isEmpty_2 = IterableExtensions.isEmpty(_parameters_3);
          _and_3 = _isEmpty_2;
        }
        _or_1 = _and_3;
      }
      if (_or_1) {
        _or = true;
      } else {
        boolean _and_4 = false;
        String _simpleName_4 = it.getSimpleName();
        boolean _equals_5 = Objects.equal(_simpleName_4, "clone");
        if (!_equals_5) {
          _and_4 = false;
        } else {
          Iterable<? extends ParameterDeclaration> _parameters_4 = it.getParameters();
          boolean _isEmpty_3 = IterableExtensions.isEmpty(_parameters_4);
          _and_4 = _isEmpty_3;
        }
        _or = _and_4;
      }
      return _or;
    }
    
    public MutableMethodDeclaration implementMethod(final MutableMemberDeclaration delegate, final MethodDeclaration method) {
      MutableMethodDeclaration _xblockexpression = null;
      {
        delegate.markAsRead();
        MutableTypeDeclaration _declaringType = delegate.getDeclaringType();
        String _simpleName = method.getSimpleName();
        final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
          public void apply(final MutableMethodDeclaration impl) {
            Iterable<? extends TypeReference> _exceptions = method.getExceptions();
            impl.setExceptions(((TypeReference[])Conversions.unwrapArray(_exceptions, TypeReference.class)));
            boolean _isVarArgs = method.isVarArgs();
            impl.setVarArgs(_isVarArgs);
            TypeReference _returnType = method.getReturnType();
            impl.setReturnType(_returnType);
            Iterable<? extends ParameterDeclaration> _parameters = method.getParameters();
            final Procedure1<ParameterDeclaration> _function = new Procedure1<ParameterDeclaration>() {
              public void apply(final ParameterDeclaration it) {
                String _simpleName = it.getSimpleName();
                TypeReference _type = it.getType();
                impl.addParameter(_simpleName, _type);
              }
            };
            IterableExtensions.forEach(_parameters, _function);
            StringConcatenationClient _client = new StringConcatenationClient() {
              @Override
              protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                String _returnIfNeeded = Util.this.returnIfNeeded(method);
                _builder.append(_returnIfNeeded, "");
                _builder.append(" ");
                CharSequence _delegateAccess = Util.this.delegateAccess(delegate, method);
                _builder.append(_delegateAccess, "");
                _builder.append(".");
                String _simpleName = method.getSimpleName();
                _builder.append(_simpleName, "");
                _builder.append("(");
                Iterable<? extends ParameterDeclaration> _parameters = method.getParameters();
                final Function1<ParameterDeclaration, String> _function = new Function1<ParameterDeclaration, String>() {
                  public String apply(final ParameterDeclaration it) {
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
        public TypeReference apply(final ParameterDeclaration it) {
          return it.getType();
        }
      };
      Iterable<TypeReference> _map = IterableExtensions.map(_parameters, _function);
      List<TypeReference> _list = IterableExtensions.<TypeReference>toList(_map);
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(_list, Collections.<Object>unmodifiableList(Lists.<Object>newArrayList()))) {
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
        if (Objects.equal(_list, Collections.<TypeReference>unmodifiableList(Lists.<TypeReference>newArrayList(_string)))) {
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
        TypeReference _object = this.context.getObject();
        TypeReference _newArrayTypeReference = this.context.newArrayTypeReference(_object);
        if (Objects.equal(_list, Collections.<TypeReference>unmodifiableList(Lists.<TypeReference>newArrayList(_string_1, _newArrayTypeReference)))) {
          _matched=true;
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("this.");
          String _simpleName_3 = it.getSimpleName();
          _builder_2.append(_simpleName_3, "");
          _builder_2.append("(\"");
          String _simpleName_4 = method.getSimpleName();
          _builder_2.append(_simpleName_4, "");
          _builder_2.append("\", new Object[]{");
          Iterable<? extends ParameterDeclaration> _parameters_1 = method.getParameters();
          final Function1<ParameterDeclaration, String> _function_1 = new Function1<ParameterDeclaration, String>() {
            public String apply(final ParameterDeclaration it) {
              return it.getSimpleName();
            }
          };
          String _join = IterableExtensions.join(_parameters_1, ", ", _function_1);
          _builder_2.append(_join, "");
          _builder_2.append("})");
          _switchResult = _builder_2;
        }
      }
      if (!_matched) {
        throw new IllegalArgumentException("delegate signature");
      }
      return _switchResult;
    }
    
    public String returnIfNeeded(final MethodDeclaration it) {
      String _xifexpression = null;
      TypeReference _returnType = it.getReturnType();
      boolean _isVoid = _returnType.isVoid();
      if (_isVoid) {
        _xifexpression = "";
      } else {
        _xifexpression = "return";
      }
      return _xifexpression;
    }
    
    @Synthetic
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
    
    @Synthetic
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
    
    @Synthetic
    public Set<? extends InterfaceDeclaration> getImplementedInterfaces(final Type it) {
      if (it instanceof ClassDeclaration) {
        return _getImplementedInterfaces((ClassDeclaration)it);
      } else if (it instanceof InterfaceDeclaration) {
        return _getImplementedInterfaces((InterfaceDeclaration)it);
      } else if (it != null) {
        return _getImplementedInterfaces(it);
      } else {
        throw new IllegalArgumentException("Unhandled parameter types: " +
          Arrays.<Object>asList(it).toString());
      }
    }
    
    @Synthetic
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
  
  public void doTransform(final List<? extends MutableMemberDeclaration> elements, @Extension final TransformationContext context) {
    @Extension
    final DelegateProcessor.Util util = new DelegateProcessor.Util(context);
    final Procedure1<MutableMemberDeclaration> _function = new Procedure1<MutableMemberDeclaration>() {
      public void apply(final MutableMemberDeclaration it) {
        boolean _isValidDelegate = util.isValidDelegate(it);
        if (_isValidDelegate) {
          Set<MethodDeclaration> _methodsToImplement = util.getMethodsToImplement(it);
          final Procedure1<MethodDeclaration> _function = new Procedure1<MethodDeclaration>() {
            public void apply(final MethodDeclaration method) {
              util.implementMethod(it, method);
            }
          };
          IterableExtensions.<MethodDeclaration>forEach(_methodsToImplement, _function);
        }
      }
    };
    IterableExtensions.forEach(elements, _function);
  }
}
