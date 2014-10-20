/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.conversion;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclarationStatement;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class ASTFlattenerUtils {
  public boolean isDummyType(final TypeDeclaration it) {
    boolean _and = false;
    boolean _and_1 = false;
    SimpleName _name = it.getName();
    String _identifier = _name.getIdentifier();
    boolean _equals = "MISSING".equals(_identifier);
    if (!_equals) {
      _and_1 = false;
    } else {
      boolean _isInterface = it.isInterface();
      boolean _not = (!_isInterface);
      _and_1 = _not;
    }
    if (!_and_1) {
      _and = false;
    } else {
      int _modifiers = it.getModifiers();
      boolean _equals_1 = (_modifiers == 0);
      _and = _equals_1;
    }
    return _and;
  }
  
  public boolean isOverrideMethode(final MethodDeclaration declaration) {
    List _modifiers = declaration.modifiers();
    Iterable<Annotation> _filter = Iterables.<Annotation>filter(_modifiers, Annotation.class);
    final Function1<Annotation, Boolean> _function = new Function1<Annotation, Boolean>() {
      public Boolean apply(final Annotation it) {
        Name _typeName = it.getTypeName();
        String _string = _typeName.toString();
        return Boolean.valueOf(Objects.equal("Override", _string));
      }
    };
    Iterable<Annotation> _filter_1 = IterableExtensions.<Annotation>filter(_filter, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(_filter_1);
    boolean _not = (!_isEmpty);
    if (_not) {
      return true;
    }
    final IMethodBinding iMethodBinding = declaration.resolveBinding();
    boolean _notEquals = (!Objects.equal(iMethodBinding, null));
    if (_notEquals) {
      ITypeBinding _declaringClass = iMethodBinding.getDeclaringClass();
      IMethodBinding _findOverride = this.findOverride(iMethodBinding, _declaringClass);
      return (!Objects.equal(_findOverride, null));
    }
    return false;
  }
  
  public IMethodBinding findOverride(final IMethodBinding method, final ITypeBinding type) {
    return this.findOverride(method, type, false);
  }
  
  public IMethodBinding findOverride(final IMethodBinding method, final ITypeBinding type, final boolean onlyPrimarylevel) {
    final ITypeBinding superclass = type.getSuperclass();
    IMethodBinding overridden = null;
    boolean _notEquals = (!Objects.equal(superclass, null));
    if (_notEquals) {
      IMethodBinding _internalFindOverride = this.internalFindOverride(method, superclass, onlyPrimarylevel);
      overridden = _internalFindOverride;
    }
    boolean _equals = Objects.equal(overridden, null);
    if (_equals) {
      ITypeBinding[] _interfaces = type.getInterfaces();
      for (final ITypeBinding interfaze : _interfaces) {
        {
          IMethodBinding _internalFindOverride_1 = this.internalFindOverride(method, interfaze, onlyPrimarylevel);
          overridden = _internalFindOverride_1;
          boolean _notEquals_1 = (!Objects.equal(overridden, null));
          if (_notEquals_1) {
            return overridden;
          }
        }
      }
    }
    return overridden;
  }
  
  private IMethodBinding internalFindOverride(final IMethodBinding method, final ITypeBinding superType, final boolean onlyPrimarylevel) {
    IMethodBinding[] _declaredMethods = superType.getDeclaredMethods();
    final Function1<IMethodBinding, Boolean> _function = new Function1<IMethodBinding, Boolean>() {
      public Boolean apply(final IMethodBinding it) {
        return Boolean.valueOf(method.overrides(it));
      }
    };
    final Iterable<IMethodBinding> superClassOverride = IterableExtensions.<IMethodBinding>filter(((Iterable<IMethodBinding>)Conversions.doWrapArray(_declaredMethods)), _function);
    int _size = IterableExtensions.size(superClassOverride);
    boolean _equals = (_size == 1);
    if (_equals) {
      return ((IMethodBinding[])Conversions.unwrapArray(superClassOverride, IMethodBinding.class))[0];
    } else {
      if ((!onlyPrimarylevel)) {
        return this.findOverride(method, superType);
      } else {
        return null;
      }
    }
  }
  
  public String handleVariableDeclaration(final Iterable<? extends ASTNode> modifier) {
    Iterable<Modifier> _filter = Iterables.<Modifier>filter(modifier, Modifier.class);
    boolean _isFinal = this.isFinal(_filter);
    if (_isFinal) {
      return "val";
    } else {
      return "var";
    }
  }
  
  public boolean isNotSupportedInnerType(final TypeDeclaration it) {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _isInterface = it.isInterface();
    boolean _not = (!_isInterface);
    if (!_not) {
      _and_1 = false;
    } else {
      _and_1 = ((it.getParent() instanceof TypeDeclaration) || (it.getParent() instanceof Block));
    }
    if (!_and_1) {
      _and = false;
    } else {
      List _modifiers = it.modifiers();
      Iterable<Modifier> _filter = Iterables.<Modifier>filter(_modifiers, Modifier.class);
      final Function1<Modifier, Boolean> _function = new Function1<Modifier, Boolean>() {
        public Boolean apply(final Modifier it) {
          return Boolean.valueOf(it.isStatic());
        }
      };
      boolean _exists = IterableExtensions.<Modifier>exists(_filter, _function);
      boolean _not_1 = (!_exists);
      _and = _not_1;
    }
    return _and;
  }
  
  public boolean isNotSupportedInnerType(final TypeDeclarationStatement it) {
    ASTNode _parent = it.getParent();
    return (_parent instanceof Block);
  }
  
  public boolean isFinal(final Iterable<Modifier> modifiers) {
    Iterable<Modifier> _filter = Iterables.<Modifier>filter(modifiers, Modifier.class);
    final Function1<Modifier, Boolean> _function = new Function1<Modifier, Boolean>() {
      public Boolean apply(final Modifier it) {
        return Boolean.valueOf(it.isFinal());
      }
    };
    return IterableExtensions.<Modifier>exists(_filter, _function);
  }
  
  public boolean isStatic(final Iterable<IExtendedModifier> modifiers) {
    Iterable<Modifier> _filter = Iterables.<Modifier>filter(modifiers, Modifier.class);
    final Function1<Modifier, Boolean> _function = new Function1<Modifier, Boolean>() {
      public Boolean apply(final Modifier it) {
        return Boolean.valueOf(it.isStatic());
      }
    };
    return IterableExtensions.<Modifier>exists(_filter, _function);
  }
  
  public boolean isStaticMemberCall(final MethodInvocation methInv) {
    IMethodBinding _resolveMethodBinding = methInv.resolveMethodBinding();
    return this.isStaticBinding(_resolveMethodBinding);
  }
  
  public boolean isStaticMemberCall(final QualifiedName expr) {
    IBinding _resolveBinding = expr.resolveBinding();
    return this.isStaticBinding(_resolveBinding);
  }
  
  public boolean isStaticMemberCall(final FieldAccess expr) {
    IVariableBinding _resolveFieldBinding = expr.resolveFieldBinding();
    return this.isStaticBinding(_resolveFieldBinding);
  }
  
  private boolean isStaticBinding(final IBinding binding) {
    boolean _notEquals = (!Objects.equal(binding, null));
    if (_notEquals) {
      int _modifiers = binding.getModifiers();
      return Modifier.isStatic(_modifiers);
    }
    return false;
  }
  
  public boolean isPackageVisibility(final Iterable<Modifier> modifier) {
    final Function1<Modifier, Boolean> _function = new Function1<Modifier, Boolean>() {
      public Boolean apply(final Modifier it) {
        boolean _or = false;
        boolean _or_1 = false;
        boolean _isPublic = it.isPublic();
        if (_isPublic) {
          _or_1 = true;
        } else {
          boolean _isPrivate = it.isPrivate();
          _or_1 = _isPrivate;
        }
        if (_or_1) {
          _or = true;
        } else {
          boolean _isProtected = it.isProtected();
          _or = _isProtected;
        }
        return Boolean.valueOf(_or);
      }
    };
    Iterable<Modifier> _filter = IterableExtensions.<Modifier>filter(modifier, _function);
    return IterableExtensions.isEmpty(_filter);
  }
  
  public boolean canHandleAnnotation(final ASTNode node) {
    if ((node instanceof VariableDeclarationStatement)) {
      return false;
    }
    return true;
  }
  
  public boolean shouldConvertName(final SimpleName it) {
    boolean _or = false;
    ASTNode _parent = it.getParent();
    if ((_parent instanceof FieldAccess)) {
      _or = true;
    } else {
      _or = ((it.getParent() instanceof VariableDeclarationFragment) && (it.getParent().getParent() instanceof FieldDeclaration));
    }
    return _or;
  }
  
  public boolean isLambdaCase(final ClassInstanceCreation creation) {
    final AnonymousClassDeclaration anonymousClazz = creation.getAnonymousClassDeclaration();
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(anonymousClazz, null));
    if (!_notEquals) {
      _and = false;
    } else {
      List _bodyDeclarations = anonymousClazz.bodyDeclarations();
      int _size = _bodyDeclarations.size();
      boolean _equals = (_size == 1);
      _and = _equals;
    }
    if (_and) {
      List _bodyDeclarations_1 = anonymousClazz.bodyDeclarations();
      final Object declaredMethod = _bodyDeclarations_1.get(0);
      boolean _and_1 = false;
      if (!(declaredMethod instanceof MethodDeclaration)) {
        _and_1 = false;
      } else {
        Type _type = creation.getType();
        ITypeBinding _resolveBinding = _type.resolveBinding();
        boolean _notEquals_1 = (!Objects.equal(_resolveBinding, null));
        _and_1 = _notEquals_1;
      }
      if (_and_1) {
        final IMethodBinding methodBinding = ((MethodDeclaration) declaredMethod).resolveBinding();
        boolean _notEquals_2 = (!Objects.equal(methodBinding, null));
        if (_notEquals_2) {
          ITypeBinding _declaringClass = methodBinding.getDeclaringClass();
          final IMethodBinding overrides = this.findOverride(methodBinding, _declaringClass, true);
          boolean _and_2 = false;
          boolean _notEquals_3 = (!Objects.equal(overrides, null));
          if (!_notEquals_3) {
            _and_2 = false;
          } else {
            int _modifiers = overrides.getModifiers();
            boolean _isAbstract = Modifier.isAbstract(_modifiers);
            _and_2 = _isAbstract;
          }
          return _and_2;
        }
      }
    }
    return false;
  }
  
  public boolean needsReturnValue(final ASTNode node) {
    boolean _and = false;
    ASTNode _parent = node.getParent();
    boolean _notEquals = (!Objects.equal(_parent, null));
    if (!_notEquals) {
      _and = false;
    } else {
      _and = ((!(node.getParent() instanceof Statement)) || (node.getParent() instanceof ReturnStatement));
    }
    return _and;
  }
  
  public boolean canConvertToRichText(final InfixExpression node) {
    final Iterable<StringLiteral> nodes = this.collectCompatibleNodes(node);
    boolean _and = false;
    boolean _isEmpty = IterableExtensions.isEmpty(nodes);
    boolean _not = (!_isEmpty);
    if (!_not) {
      _and = false;
    } else {
      final Function1<StringLiteral, Boolean> _function = new Function1<StringLiteral, Boolean>() {
        public Boolean apply(final StringLiteral it) {
          return Boolean.valueOf(ASTFlattenerUtils.this.canTranslate(it));
        }
      };
      boolean _forall = IterableExtensions.<StringLiteral>forall(nodes, _function);
      _and = _forall;
    }
    return _and;
  }
  
  private Iterable<StringLiteral> collectCompatibleNodes(final InfixExpression node) {
    final ArrayList<StringLiteral> strings = CollectionLiterals.<StringLiteral>newArrayList();
    InfixExpression.Operator _operator = node.getOperator();
    boolean _notEquals = (!Objects.equal(_operator, InfixExpression.Operator.PLUS));
    if (_notEquals) {
      return strings;
    }
    final Expression left = node.getLeftOperand();
    if ((left instanceof StringLiteral)) {
      strings.add(((StringLiteral)left));
    } else {
      if ((left instanceof InfixExpression)) {
        Iterable<StringLiteral> _collectCompatibleNodes = this.collectCompatibleNodes(((InfixExpression)left));
        Iterables.<StringLiteral>addAll(strings, _collectCompatibleNodes);
      }
    }
    final Expression right = node.getRightOperand();
    if ((right instanceof StringLiteral)) {
      strings.add(((StringLiteral)right));
    } else {
      if ((right instanceof InfixExpression)) {
        Iterable<StringLiteral> _collectCompatibleNodes_1 = this.collectCompatibleNodes(((InfixExpression)right));
        Iterables.<StringLiteral>addAll(strings, _collectCompatibleNodes_1);
      }
    }
    List _extendedOperands = node.extendedOperands();
    Iterable<StringLiteral> _filter = Iterables.<StringLiteral>filter(_extendedOperands, StringLiteral.class);
    Iterables.<StringLiteral>addAll(strings, _filter);
    return strings;
  }
  
  private boolean canTranslate(final StringLiteral literal) {
    final String value = literal.getEscapedValue();
    boolean _or = false;
    boolean _or_1 = false;
    boolean _contains = value.contains("«");
    if (_contains) {
      _or_1 = true;
    } else {
      boolean _contains_1 = value.contains("»");
      _or_1 = _contains_1;
    }
    if (_or_1) {
      _or = true;
    } else {
      boolean _contains_2 = value.contains("\'\'\'");
      _or = _contains_2;
    }
    return (!_or);
  }
  
  public String richTextValue(final StringLiteral literal) {
    String value = literal.getLiteralValue();
    boolean _endsWith = value.endsWith("\'");
    if (_endsWith) {
      String _concat = value.concat("«»");
      value = _concat;
    }
    return value;
  }
  
  public Boolean isAssignedInBody(final Block scope, final Function1<? super Assignment, ? extends Boolean> constraint) {
    boolean _notEquals = (!Objects.equal(scope, null));
    if (_notEquals) {
      final HashSet<Assignment> assigments = CollectionLiterals.<Assignment>newHashSet();
      scope.accept(
        new ASTVisitor() {
          public boolean visit(final Assignment node) {
            Boolean _apply = constraint.apply(node);
            if ((_apply).booleanValue()) {
              assigments.add(node);
            }
            return true;
          }
        });
      boolean _isEmpty = assigments.isEmpty();
      return Boolean.valueOf((!_isEmpty));
    }
    return Boolean.valueOf(false);
  }
  
  public Boolean isAssignedInBody(final Block scope, final VariableDeclarationFragment fieldDeclFragment) {
    final Function1<Assignment, Boolean> _function = new Function1<Assignment, Boolean>() {
      public Boolean apply(final Assignment it) {
        Expression _leftHandSide = it.getLeftHandSide();
        if ((_leftHandSide instanceof Name)) {
          Expression _leftHandSide_1 = it.getLeftHandSide();
          final Name simpleName = ((Name) _leftHandSide_1);
          final IBinding binding = simpleName.resolveBinding();
          if ((binding instanceof IVariableBinding)) {
            boolean _and = false;
            boolean _isField = ((IVariableBinding)binding).isField();
            if (!_isField) {
              _and = false;
            } else {
              SimpleName _name = fieldDeclFragment.getName();
              String _identifier = _name.getIdentifier();
              String _simpleName = ASTFlattenerUtils.this.toSimpleName(simpleName);
              boolean _equals = _identifier.equals(_simpleName);
              _and = _equals;
            }
            return Boolean.valueOf(_and);
          }
        }
        return Boolean.valueOf(false);
      }
    };
    return this.isAssignedInBody(scope, _function);
  }
  
  public Boolean isAssignedInBody(final Block scope, final SimpleName nameToLookFor) {
    final Function1<Assignment, Boolean> _function = new Function1<Assignment, Boolean>() {
      public Boolean apply(final Assignment it) {
        Expression _leftHandSide = it.getLeftHandSide();
        if ((_leftHandSide instanceof SimpleName)) {
          String _identifier = nameToLookFor.getIdentifier();
          Expression _leftHandSide_1 = it.getLeftHandSide();
          String _identifier_1 = ((SimpleName) _leftHandSide_1).getIdentifier();
          return Boolean.valueOf(_identifier.equals(_identifier_1));
        }
        return Boolean.valueOf(false);
      }
    };
    return this.isAssignedInBody(scope, _function);
  }
  
  protected String _toSimpleName(final SimpleName name) {
    return name.getIdentifier();
  }
  
  protected String _toSimpleName(final QualifiedName name) {
    SimpleName _name = name.getName();
    return _name.getIdentifier();
  }
  
  public String toSimpleName(final Name name) {
    if (name instanceof QualifiedName) {
      return _toSimpleName((QualifiedName)name);
    } else if (name instanceof SimpleName) {
      return _toSimpleName((SimpleName)name);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(name).toString());
    }
  }
}
