/**
 * Copyright (c) 2014, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod;
import org.eclipse.xtend.lib.macro.declaration.ResolvedParameter;
import org.eclipse.xtend.lib.macro.declaration.ResolvedTypeParameter;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
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
      return ((this.hasValidType(it) && (!this.hasDelegationConflicts(it))) && this.areListedInterfacesValid(it));
    }

    protected boolean _isValidDelegate(final MethodDeclaration it) {
      return (((this.hasValidType(it) && this.hasValidSignature(it)) && (!this.hasDelegationConflicts(it))) && this.areListedInterfacesValid(it));
    }

    public boolean hasValidType(final MemberDeclaration it) {
      boolean _xifexpression = false;
      if (((this.getType(it) == null) || this.getType(it).isInferred())) {
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
      final Function1<ParameterDeclaration, TypeReference> _function = (ParameterDeclaration it_1) -> {
        return it_1.getType();
      };
      List<TypeReference> _list = IterableExtensions.<TypeReference>toList(IterableExtensions.map(it.getParameters(), _function));
      boolean _matched = false;
      if (Objects.equals(_list, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()))) {
        _matched=true;
      }
      if (!_matched) {
        TypeReference _string = this.context.getString();
        if (Objects.equals(_list, Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList(_string)))) {
          _matched=true;
        }
      }
      if (!_matched) {
        TypeReference _string_1 = this.context.getString();
        TypeReference _newArrayTypeReference = this.context.newArrayTypeReference(this.context.newTypeReference(Class.class, this.context.newWildcardTypeReference()));
        TypeReference _newArrayTypeReference_1 = this.context.newArrayTypeReference(this.context.getObject());
        if (Objects.equals(_list, Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList(_string_1, _newArrayTypeReference, _newArrayTypeReference_1)))) {
          _matched=true;
        }
      }
      if (_matched) {
        _switchResult = true;
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
                _builder.append(_simpleName);
                _builder.append(" is also implemented by the delegate ");
                String _simpleName_1 = other.getSimpleName();
                _builder.append(_simpleName_1);
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
      final Function1<MemberDeclaration, Boolean> _function = (MemberDeclaration it) -> {
        return Boolean.valueOf((!Objects.equals(it, delegate)));
      };
      return IterableExtensions.filter(this.getDelegates(delegate.getDeclaringType()), _function);
    }

    public boolean areListedInterfacesValid(final MemberDeclaration delegate) {
      boolean _xblockexpression = false;
      {
        final TypeReference declaringType = this.context.newSelfTypeReference(delegate.getDeclaringType());
        final Set<TypeReference> interfacesOfDeclaringType = this.getImplementedInterfaces(declaringType);
        final Set<TypeReference> availableInterfaces = this.getImplementedInterfaces(this.getType(delegate));
        final Set<TypeReference> listedInterfaces = this.listedInterfaces(delegate);
        boolean valid = true;
        for (final TypeReference iface : listedInterfaces) {
          {
            final Function1<TypeReference, Boolean> _function = (TypeReference it) -> {
              Type _type = it.getType();
              Type _type_1 = iface.getType();
              return Boolean.valueOf(Objects.equals(_type, _type_1));
            };
            boolean _exists = IterableExtensions.<TypeReference>exists(availableInterfaces, _function);
            boolean _not = (!_exists);
            if (_not) {
              StringConcatenation _builder = new StringConcatenation();
              String _simpleName = this.getType(delegate).getSimpleName();
              _builder.append(_simpleName);
              _builder.append(" does not implement ");
              String _simpleName_1 = iface.getSimpleName();
              _builder.append(_simpleName_1);
              this.context.addError(delegate, _builder.toString());
              valid = false;
            }
            final Function1<TypeReference, Boolean> _function_1 = (TypeReference it) -> {
              Type _type = it.getType();
              Type _type_1 = iface.getType();
              return Boolean.valueOf(Objects.equals(_type, _type_1));
            };
            boolean _exists_1 = IterableExtensions.<TypeReference>exists(interfacesOfDeclaringType, _function_1);
            boolean _not_1 = (!_exists_1);
            if (_not_1) {
              StringConcatenation _builder_1 = new StringConcatenation();
              String _simpleName_2 = declaringType.getSimpleName();
              _builder_1.append(_simpleName_2);
              _builder_1.append(" does not implement ");
              String _simpleName_3 = iface.getSimpleName();
              _builder_1.append(_simpleName_3);
              this.context.addError(delegate, _builder_1.toString());
              valid = false;
            }
          }
        }
        if ((listedInterfaces.isEmpty() && Sets.<TypeReference>intersection(interfacesOfDeclaringType, availableInterfaces).isEmpty())) {
          StringConcatenation _builder = new StringConcatenation();
          String _simpleName = this.getType(delegate).getSimpleName();
          _builder.append(_simpleName);
          _builder.append(" and ");
          String _simpleName_1 = declaringType.getSimpleName();
          _builder.append(_simpleName_1);
          _builder.append(" have no interfaces in common");
          this.context.addError(delegate, _builder.toString());
          valid = false;
        }
        _xblockexpression = valid;
      }
      return _xblockexpression;
    }

    public Iterable<? extends MemberDeclaration> getDelegates(final TypeDeclaration it) {
      final Function1<MemberDeclaration, Boolean> _function = (MemberDeclaration it_1) -> {
        AnnotationReference _findAnnotation = it_1.findAnnotation(this.context.findTypeGlobally(Delegate.class));
        return Boolean.valueOf((_findAnnotation != null));
      };
      return IterableExtensions.filter(it.getDeclaredMembers(), _function);
    }

    public Set<TypeReference> listedInterfaces(final MemberDeclaration it) {
      return IterableExtensions.<TypeReference>toSet(((Iterable<TypeReference>)Conversions.doWrapArray(it.findAnnotation(this.context.findTypeGlobally(Delegate.class)).getClassArrayValue("value"))));
    }

    public Set<TypeReference> getImplementedInterfaces(final TypeReference it) {
      Set<TypeReference> _xblockexpression = null;
      {
        final LinkedHashSet<TypeReference> seen = CollectionLiterals.<TypeReference>newLinkedHashSet();
        this.collectAllSuperTypes(it, seen);
        final Function1<TypeReference, Boolean> _function = (TypeReference it_1) -> {
          Type _type = it_1.getType();
          return Boolean.valueOf((_type instanceof InterfaceDeclaration));
        };
        _xblockexpression = IterableExtensions.<TypeReference>toSet(IterableExtensions.<TypeReference>filter(seen, _function));
      }
      return _xblockexpression;
    }

    private void collectAllSuperTypes(final TypeReference it, final Set<TypeReference> seen) {
      boolean _add = seen.add(it);
      final boolean cycle = (!_add);
      if (cycle) {
        return;
      }
      final Consumer<TypeReference> _function = (TypeReference it_1) -> {
        this.collectAllSuperTypes(it_1, seen);
      };
      it.getDeclaredSuperTypes().forEach(_function);
    }

    public Set<TypeReference> getDelegatedInterfaces(final MemberDeclaration delegate) {
      Set<TypeReference> _xblockexpression = null;
      {
        final Set<TypeReference> interfacesOfDeclaringType = this.getImplementedInterfaces(this.context.newSelfTypeReference(delegate.getDeclaringType()));
        final Set<TypeReference> listedInterfaces = this.listedInterfaces(delegate);
        final Set<TypeReference> availableInterfaces = this.getImplementedInterfaces(this.getType(delegate));
        final Function1<TypeReference, Boolean> _function = (TypeReference iface) -> {
          return Boolean.valueOf((interfacesOfDeclaringType.contains(iface) && (listedInterfaces.isEmpty() || IterableExtensions.<TypeReference>exists(listedInterfaces, ((Function1<TypeReference, Boolean>) (TypeReference it) -> {
            return Boolean.valueOf(iface.isAssignableFrom(it));
          })))));
        };
        _xblockexpression = IterableExtensions.<TypeReference>toSet(IterableExtensions.<TypeReference>filter(availableInterfaces, _function));
      }
      return _xblockexpression;
    }

    public Set<ResolvedMethod> getMethodsToImplement(final MemberDeclaration delegate) {
      final Function1<TypeReference, Iterable<? extends ResolvedMethod>> _function = (TypeReference it) -> {
        return it.getDeclaredResolvedMethods();
      };
      final Function1<ResolvedMethod, Boolean> _function_1 = (ResolvedMethod it) -> {
        final Function1<ResolvedParameter, TypeReference> _function_2 = (ResolvedParameter it_1) -> {
          return it_1.getResolvedType();
        };
        MethodDeclaration _findDeclaredMethod = delegate.getDeclaringType().findDeclaredMethod(it.getDeclaration().getSimpleName(), ((TypeReference[])Conversions.unwrapArray(IterableExtensions.map(it.getResolvedParameters(), _function_2), TypeReference.class)));
        return Boolean.valueOf((_findDeclaredMethod == null));
      };
      final Function1<ResolvedMethod, Boolean> _function_2 = (ResolvedMethod it) -> {
        boolean _isObjectMethod = this.isObjectMethod(it);
        return Boolean.valueOf((!_isObjectMethod));
      };
      final Function1<ResolvedMethod, Boolean> _function_3 = (ResolvedMethod it) -> {
        boolean _isStatic = this.isStatic(it);
        return Boolean.valueOf((!_isStatic));
      };
      final Function1<ResolvedMethod, String> _function_4 = (ResolvedMethod it) -> {
        return it.getSimpleSignature();
      };
      final Function1<List<ResolvedMethod>, ResolvedMethod> _function_5 = (List<ResolvedMethod> it) -> {
        return IterableExtensions.<ResolvedMethod>head(it);
      };
      final Function1<ResolvedMethod, String> _function_6 = (ResolvedMethod it) -> {
        return it.getSimpleSignature();
      };
      return IterableExtensions.<ResolvedMethod>toSet(IterableExtensions.<ResolvedMethod, String>sortBy(IterableExtensions.<List<ResolvedMethod>, ResolvedMethod>map(IterableExtensions.<String, ResolvedMethod>groupBy(IterableExtensions.<ResolvedMethod>filter(IterableExtensions.<ResolvedMethod>filter(IterableExtensions.<ResolvedMethod>filter(Iterables.<ResolvedMethod>concat(IterableExtensions.<TypeReference, Iterable<? extends ResolvedMethod>>map(this.getDelegatedInterfaces(delegate), _function)), _function_1), _function_2), _function_3), _function_4).values(), _function_5), _function_6));
    }

    public boolean isObjectMethod(final ResolvedMethod it) {
      boolean _xblockexpression = false;
      {
        final String name = it.getDeclaration().getSimpleName();
        final Function1<ResolvedParameter, TypeReference> _function = (ResolvedParameter it_1) -> {
          return it_1.getResolvedType();
        };
        final List<TypeReference> parameterTypes = IterableExtensions.<TypeReference>toList(IterableExtensions.map(it.getResolvedParameters(), _function));
        _xblockexpression = (((((Objects.equals(name, "hashCode") && parameterTypes.isEmpty()) || (Objects.equals(name, "toString") && parameterTypes.isEmpty())) || (Objects.equals(name, "equals") && Objects.equals(parameterTypes, Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList(this.context.getObject()))))) || (Objects.equals(name, "finalize") && parameterTypes.isEmpty())) || (Objects.equals(name, "clone") && parameterTypes.isEmpty()));
      }
      return _xblockexpression;
    }

    public boolean isStatic(final ResolvedMethod it) {
      return it.getDeclaration().isStatic();
    }

    public MutableMethodDeclaration implementMethod(final MutableMemberDeclaration delegate, final ResolvedMethod resolvedMethod) {
      MutableMethodDeclaration _xblockexpression = null;
      {
        delegate.markAsRead();
        final MethodDeclaration declaration = resolvedMethod.getDeclaration();
        final Procedure1<MutableMethodDeclaration> _function = (MutableMethodDeclaration impl) -> {
          this.context.setPrimarySourceElement(impl, this.context.getPrimarySourceElement(delegate));
          final HashMap<TypeReference, TypeReference> typeParameterMappings = CollectionLiterals.<TypeReference, TypeReference>newHashMap();
          final Consumer<ResolvedTypeParameter> _function_1 = (ResolvedTypeParameter param) -> {
            final MutableTypeParameterDeclaration copy = impl.addTypeParameter(param.getDeclaration().getSimpleName(), ((TypeReference[])Conversions.unwrapArray(param.getResolvedUpperBounds(), TypeReference.class)));
            typeParameterMappings.put(this.context.newTypeReference(param.getDeclaration()), this.context.newTypeReference(copy));
            final Function1<TypeReference, TypeReference> _function_2 = (TypeReference it) -> {
              return this.replace(it, typeParameterMappings);
            };
            copy.setUpperBounds(IterableExtensions.map(copy.getUpperBounds(), _function_2));
          };
          resolvedMethod.getResolvedTypeParameters().forEach(_function_1);
          final Function1<TypeReference, TypeReference> _function_2 = (TypeReference it) -> {
            return this.replace(it, typeParameterMappings);
          };
          impl.setExceptions(((TypeReference[])Conversions.unwrapArray(IterableExtensions.map(resolvedMethod.getResolvedExceptionTypes(), _function_2), TypeReference.class)));
          impl.setVarArgs(declaration.isVarArgs());
          impl.setReturnType(this.replace(resolvedMethod.getResolvedReturnType(), typeParameterMappings));
          final Consumer<ResolvedParameter> _function_3 = (ResolvedParameter p) -> {
            impl.addParameter(p.getDeclaration().getSimpleName(), this.replace(p.getResolvedType(), typeParameterMappings));
          };
          resolvedMethod.getResolvedParameters().forEach(_function_3);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              String _returnIfNeeded = Util.this.returnIfNeeded(resolvedMethod);
              _builder.append(_returnIfNeeded);
              CharSequence _delegateAccess = Util.this.delegateAccess(delegate, declaration);
              _builder.append(_delegateAccess);
              _builder.append(".");
              String _simpleName = declaration.getSimpleName();
              _builder.append(_simpleName);
              _builder.append("(");
              final Function1<ParameterDeclaration, CharSequence> _function = (ParameterDeclaration it) -> {
                return it.getSimpleName();
              };
              String _join = IterableExtensions.join(declaration.getParameters(), ", ", _function);
              _builder.append(_join);
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          };
          impl.setBody(_client);
        };
        _xblockexpression = delegate.getDeclaringType().addMethod(declaration.getSimpleName(), _function);
      }
      return _xblockexpression;
    }

    public TypeReference replace(final TypeReference target, final Map<? extends TypeReference, ? extends TypeReference> mappings) {
      final Function2<TypeReference, Map.Entry<? extends TypeReference, ? extends TypeReference>, TypeReference> _function = (TypeReference result, Map.Entry<? extends TypeReference, ? extends TypeReference> mapping) -> {
        return this.replace(result, mapping.getKey(), mapping.getValue());
      };
      return IterableExtensions.fold(mappings.entrySet(), target, _function);
    }

    public TypeReference replace(final TypeReference target, final TypeReference oldType, final TypeReference newType) {
      boolean _equals = Objects.equals(target, oldType);
      if (_equals) {
        return newType;
      }
      boolean _isEmpty = target.getActualTypeArguments().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final Function1<TypeReference, TypeReference> _function = (TypeReference it) -> {
          return this.replace(it, oldType, newType);
        };
        return this.context.newTypeReference(target.getType(), ((TypeReference[])Conversions.unwrapArray(ListExtensions.<TypeReference, TypeReference>map(target.getActualTypeArguments(), _function), TypeReference.class)));
      }
      boolean _isWildCard = target.isWildCard();
      if (_isWildCard) {
        TypeReference _upperBound = target.getUpperBound();
        TypeReference _object = this.context.getObject();
        boolean _notEquals = (!Objects.equals(_upperBound, _object));
        if (_notEquals) {
          return this.context.newWildcardTypeReference(this.replace(target.getUpperBound(), oldType, newType));
        } else {
          boolean _isAnyType = target.getLowerBound().isAnyType();
          boolean _not_1 = (!_isAnyType);
          if (_not_1) {
            return this.context.newWildcardTypeReferenceWithLowerBound(this.replace(target.getLowerBound(), oldType, newType));
          }
        }
      }
      boolean _isArray = target.isArray();
      if (_isArray) {
        return this.context.newArrayTypeReference(this.replace(target.getArrayComponentType(), oldType, newType));
      }
      return target;
    }

    protected CharSequence _delegateAccess(final FieldDeclaration it, final MethodDeclaration method) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("this.");
      String _simpleName = it.getSimpleName();
      _builder.append(_simpleName);
      return _builder;
    }

    protected CharSequence _delegateAccess(final MethodDeclaration it, final MethodDeclaration method) {
      CharSequence _switchResult = null;
      final Function1<ParameterDeclaration, TypeReference> _function = (ParameterDeclaration it_1) -> {
        return it_1.getType();
      };
      List<TypeReference> _list = IterableExtensions.<TypeReference>toList(IterableExtensions.map(it.getParameters(), _function));
      boolean _matched = false;
      if (Objects.equals(_list, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()))) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("this.");
        String _simpleName = it.getSimpleName();
        _builder.append(_simpleName);
        _builder.append("()");
        _switchResult = _builder;
      }
      if (!_matched) {
        TypeReference _string = this.context.getString();
        if (Objects.equals(_list, Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList(_string)))) {
          _matched=true;
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("this.");
          String _simpleName_1 = it.getSimpleName();
          _builder_1.append(_simpleName_1);
          _builder_1.append("(\"");
          String _simpleName_2 = method.getSimpleName();
          _builder_1.append(_simpleName_2);
          _builder_1.append("\")");
          _switchResult = _builder_1;
        }
      }
      if (!_matched) {
        TypeReference _string_1 = this.context.getString();
        TypeReference _newArrayTypeReference = this.context.newArrayTypeReference(this.context.newTypeReference(Class.class, this.context.newWildcardTypeReference()));
        TypeReference _newArrayTypeReference_1 = this.context.newArrayTypeReference(this.context.getObject());
        if (Objects.equals(_list, Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList(_string_1, _newArrayTypeReference, _newArrayTypeReference_1)))) {
          _matched=true;
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("this.");
          String _simpleName_3 = it.getSimpleName();
          _builder_2.append(_simpleName_3);
          _builder_2.append("(\"");
          String _simpleName_4 = method.getSimpleName();
          _builder_2.append(_simpleName_4);
          _builder_2.append("\", new Class[]{");
          final Function1<ParameterDeclaration, CharSequence> _function_1 = (ParameterDeclaration it_1) -> {
            String _simpleName_5 = it_1.getType().getType().getSimpleName();
            return (_simpleName_5 + ".class");
          };
          String _join = IterableExtensions.join(method.getParameters(), ", ", _function_1);
          _builder_2.append(_join);
          _builder_2.append("}, new Object[]{");
          final Function1<ParameterDeclaration, CharSequence> _function_2 = (ParameterDeclaration it_1) -> {
            return it_1.getSimpleName();
          };
          String _join_1 = IterableExtensions.join(method.getParameters(), ", ", _function_2);
          _builder_2.append(_join_1);
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
      boolean _isVoid = it.getResolvedReturnType().isVoid();
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
    final Consumer<MutableMemberDeclaration> _function = (MutableMemberDeclaration it) -> {
      boolean _isValidDelegate = util.isValidDelegate(it);
      if (_isValidDelegate) {
        final Consumer<ResolvedMethod> _function_1 = (ResolvedMethod method) -> {
          util.implementMethod(it, method);
        };
        util.getMethodsToImplement(it).forEach(_function_1);
      }
    };
    elements.forEach(_function);
  }
}
