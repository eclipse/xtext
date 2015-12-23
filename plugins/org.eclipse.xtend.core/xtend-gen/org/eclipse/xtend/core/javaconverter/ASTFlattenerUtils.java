/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.javaconverter;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.ChildListPropertyDescriptor;
import org.eclipse.jdt.core.dom.ChildPropertyDescriptor;
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
import org.eclipse.jdt.core.dom.NumberLiteral;
import org.eclipse.jdt.core.dom.PostfixExpression;
import org.eclipse.jdt.core.dom.PrefixExpression;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclarationStatement;
import org.eclipse.jdt.core.dom.VariableDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
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
  public boolean isDummyType(final AbstractTypeDeclaration it) {
    if ((it instanceof TypeDeclaration)) {
      boolean _and = false;
      boolean _and_1 = false;
      SimpleName _name = ((TypeDeclaration)it).getName();
      String _identifier = _name.getIdentifier();
      boolean _equals = "MISSING".equals(_identifier);
      if (!_equals) {
        _and_1 = false;
      } else {
        boolean _isInterface = ((TypeDeclaration)it).isInterface();
        boolean _not = (!_isInterface);
        _and_1 = _not;
      }
      if (!_and_1) {
        _and = false;
      } else {
        int _modifiers = ((TypeDeclaration)it).getModifiers();
        boolean _equals_1 = (_modifiers == 0);
        _and = _equals_1;
      }
      return _and;
    }
    return false;
  }
  
  public boolean isOverrideMethod(final MethodDeclaration declaration) {
    List _modifiers = declaration.modifiers();
    Iterable<Annotation> _filter = Iterables.<Annotation>filter(_modifiers, Annotation.class);
    final Function1<Annotation, Boolean> _function = new Function1<Annotation, Boolean>() {
      @Override
      public Boolean apply(final Annotation it) {
        Name _typeName = it.getTypeName();
        String _string = _typeName.toString();
        return Boolean.valueOf(Objects.equal("Override", _string));
      }
    };
    boolean _exists = IterableExtensions.<Annotation>exists(_filter, _function);
    if (_exists) {
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
      @Override
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
      boolean _or = false;
      ASTNode _parent = it.getParent();
      if ((_parent instanceof TypeDeclaration)) {
        _or = true;
      } else {
        ASTNode _parent_1 = it.getParent();
        _or = (_parent_1 instanceof Block);
      }
      _and_1 = _or;
    }
    if (!_and_1) {
      _and = false;
    } else {
      List _modifiers = it.modifiers();
      Iterable<Modifier> _filter = Iterables.<Modifier>filter(_modifiers, Modifier.class);
      final Function1<Modifier, Boolean> _function = new Function1<Modifier, Boolean>() {
        @Override
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
      @Override
      public Boolean apply(final Modifier it) {
        return Boolean.valueOf(it.isFinal());
      }
    };
    return IterableExtensions.<Modifier>exists(_filter, _function);
  }
  
  public boolean isStatic(final Iterable<IExtendedModifier> modifiers) {
    Iterable<Modifier> _filter = Iterables.<Modifier>filter(modifiers, Modifier.class);
    final Function1<Modifier, Boolean> _function = new Function1<Modifier, Boolean>() {
      @Override
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
      @Override
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
      boolean _and = false;
      ASTNode _parent_1 = it.getParent();
      if (!(_parent_1 instanceof VariableDeclarationFragment)) {
        _and = false;
      } else {
        ASTNode _parent_2 = it.getParent();
        ASTNode _parent_3 = _parent_2.getParent();
        _and = (_parent_3 instanceof FieldDeclaration);
      }
      _or = _and;
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
      boolean _or = false;
      ASTNode _parent_1 = node.getParent();
      boolean _not = (!(_parent_1 instanceof Statement));
      if (_not) {
        _or = true;
      } else {
        ASTNode _parent_2 = node.getParent();
        _or = (_parent_2 instanceof ReturnStatement);
      }
      _and = _or;
    }
    return _and;
  }
  
  public boolean isConstantArrayIndex(final Expression node) {
    return (node instanceof NumberLiteral);
  }
  
  public boolean canConvertToRichText(final InfixExpression node) {
    final FieldDeclaration parentFieldDecl = this.<FieldDeclaration>findParentOfType(node, FieldDeclaration.class);
    boolean _notEquals = (!Objects.equal(parentFieldDecl, null));
    if (_notEquals) {
      final TypeDeclaration typeDeclr = this.<TypeDeclaration>findParentOfType(parentFieldDecl, TypeDeclaration.class);
      boolean _or = false;
      boolean _isInterface = typeDeclr.isInterface();
      if (_isInterface) {
        _or = true;
      } else {
        boolean _and = false;
        List _modifiers = parentFieldDecl.modifiers();
        boolean _isFinal = this.isFinal(_modifiers);
        if (!_isFinal) {
          _and = false;
        } else {
          List _modifiers_1 = parentFieldDecl.modifiers();
          boolean _isStatic = this.isStatic(_modifiers_1);
          _and = _isStatic;
        }
        _or = _and;
      }
      if (_or) {
        return false;
      }
    }
    final Iterable<StringLiteral> nodes = this.collectCompatibleNodes(node);
    boolean _and_1 = false;
    boolean _isEmpty = IterableExtensions.isEmpty(nodes);
    boolean _not = (!_isEmpty);
    if (!_not) {
      _and_1 = false;
    } else {
      final Function1<StringLiteral, Boolean> _function = new Function1<StringLiteral, Boolean>() {
        @Override
        public Boolean apply(final StringLiteral it) {
          return Boolean.valueOf(ASTFlattenerUtils.this.canTranslate(it));
        }
      };
      boolean _forall = IterableExtensions.<StringLiteral>forall(nodes, _function);
      _and_1 = _forall;
    }
    return _and_1;
  }
  
  public <T extends ASTNode> T findParentOfType(final ASTNode someNode, final Class<T> parentType) {
    ASTNode _parent = someNode.getParent();
    boolean _equals = Objects.equal(_parent, null);
    if (_equals) {
      return null;
    } else {
      ASTNode _parent_1 = someNode.getParent();
      boolean _isInstance = parentType.isInstance(_parent_1);
      if (_isInstance) {
        ASTNode _parent_2 = someNode.getParent();
        return parentType.cast(_parent_2);
      } else {
        ASTNode _parent_3 = someNode.getParent();
        return this.<T>findParentOfType(_parent_3, parentType);
      }
    }
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
  
  public Type findDeclaredType(final SimpleName simpleName) {
    ASTNode scope = this.findDeclarationBlocks(simpleName);
    while ((!Objects.equal(scope, null))) {
      {
        final Type type = this.findDeclaredType(scope, simpleName);
        boolean _notEquals = (!Objects.equal(type, null));
        if (_notEquals) {
          return type;
        }
        ASTNode _findDeclarationBlocks = this.findDeclarationBlocks(scope);
        scope = _findDeclarationBlocks;
      }
    }
    return null;
  }
  
  private ASTNode findDeclarationBlocks(final ASTNode simpleName) {
    ASTNode block = this.<Block>findParentOfType(simpleName, Block.class);
    if ((block == null)) {
      MethodDeclaration _findParentOfType = this.<MethodDeclaration>findParentOfType(simpleName, MethodDeclaration.class);
      block = _findParentOfType;
    }
    if ((block == null)) {
      TypeDeclaration _findParentOfType_1 = this.<TypeDeclaration>findParentOfType(simpleName, TypeDeclaration.class);
      block = _findParentOfType_1;
    }
    return block;
  }
  
  private Type findDeclaredType(final ASTNode scope, final SimpleName simpleName) {
    final ArrayList<Type> matchesFound = CollectionLiterals.<Type>newArrayList();
    scope.accept(new ASTVisitor() {
      @Override
      public boolean visit(final VariableDeclarationFragment node) {
        SimpleName _name = node.getName();
        String _identifier = _name.getIdentifier();
        String _identifier_1 = simpleName.getIdentifier();
        boolean _equals = _identifier.equals(_identifier_1);
        if (_equals) {
          final ASTNode parentNode = node.getParent();
          boolean _matched = false;
          if (!_matched) {
            if (parentNode instanceof VariableDeclarationStatement) {
              _matched=true;
              Type _type = ((VariableDeclarationStatement)parentNode).getType();
              matchesFound.add(_type);
            }
          }
          if (!_matched) {
            if (parentNode instanceof FieldDeclaration) {
              _matched=true;
              Type _type = ((FieldDeclaration)parentNode).getType();
              matchesFound.add(_type);
            }
          }
          if (!_matched) {
            if (parentNode instanceof VariableDeclarationExpression) {
              _matched=true;
              Type _type = ((VariableDeclarationExpression)parentNode).getType();
              matchesFound.add(_type);
            }
          }
        }
        return false;
      }
      
      @Override
      public boolean preVisit2(final ASTNode node) {
        return matchesFound.isEmpty();
      }
      
      @Override
      public boolean visit(final SingleVariableDeclaration node) {
        SimpleName _name = node.getName();
        String _identifier = _name.getIdentifier();
        String _identifier_1 = simpleName.getIdentifier();
        boolean _equals = _identifier.equals(_identifier_1);
        if (_equals) {
          Type _type = node.getType();
          matchesFound.add(_type);
        }
        return false;
      }
    });
    return IterableExtensions.<Type>head(matchesFound);
  }
  
  public Iterable<Expression> findAssignmentsInBlock(final Block scope, final Function1<? super Expression, ? extends Boolean> constraint) {
    final HashSet<Expression> assigments = CollectionLiterals.<Expression>newHashSet();
    boolean _notEquals = (!Objects.equal(scope, null));
    if (_notEquals) {
      scope.accept(new ASTVisitor() {
        @Override
        public boolean visit(final Assignment node) {
          Boolean _apply = constraint.apply(node);
          if ((_apply).booleanValue()) {
            assigments.add(node);
          }
          return true;
        }
        
        @Override
        public boolean visit(final PrefixExpression node) {
          Boolean _apply = constraint.apply(node);
          if ((_apply).booleanValue()) {
            assigments.add(node);
          }
          return true;
        }
        
        @Override
        public boolean visit(final PostfixExpression node) {
          Boolean _apply = constraint.apply(node);
          if ((_apply).booleanValue()) {
            assigments.add(node);
          }
          return true;
        }
      });
    }
    return assigments;
  }
  
  public Boolean isAssignedInBody(final Block scope, final VariableDeclarationFragment fieldDeclFragment) {
    Iterable<Expression> _findAssignmentsInBlock = this.findAssignmentsInBlock(scope, fieldDeclFragment);
    boolean _isEmpty = IterableExtensions.isEmpty(_findAssignmentsInBlock);
    return Boolean.valueOf((!_isEmpty));
  }
  
  public Iterable<Expression> findAssignmentsInBlock(final Block scope, final VariableDeclaration varDecl) {
    final Function1<Expression, Boolean> _function = new Function1<Expression, Boolean>() {
      @Override
      public Boolean apply(final Expression it) {
        Expression name = null;
        boolean _matched = false;
        if (!_matched) {
          if (it instanceof Assignment) {
            _matched=true;
            Expression _leftHandSide = ((Assignment)it).getLeftHandSide();
            name = _leftHandSide;
          }
        }
        if (!_matched) {
          if (it instanceof PrefixExpression) {
            _matched=true;
            Expression _operand = ((PrefixExpression)it).getOperand();
            name = _operand;
          }
        }
        if (!_matched) {
          if (it instanceof PostfixExpression) {
            _matched=true;
            Expression _operand = ((PostfixExpression)it).getOperand();
            name = _operand;
          }
        }
        if ((name instanceof Name)) {
          final IBinding binding = ((Name)name).resolveBinding();
          if ((binding instanceof IVariableBinding)) {
            final IVariableBinding declBinding = varDecl.resolveBinding();
            boolean _and = false;
            SimpleName _name = varDecl.getName();
            String _identifier = _name.getIdentifier();
            String _simpleName = ASTFlattenerUtils.this.toSimpleName(((Name)name));
            boolean _equals = _identifier.equals(_simpleName);
            if (!_equals) {
              _and = false;
            } else {
              boolean _equals_1 = ((IVariableBinding)binding).equals(declBinding);
              _and = _equals_1;
            }
            return Boolean.valueOf(_and);
          }
        }
        return Boolean.valueOf(false);
      }
    };
    return this.findAssignmentsInBlock(scope, _function);
  }
  
  public Boolean isAssignedInBody(final Block scope, final SimpleName nameToLookFor) {
    final Function1<Expression, Boolean> _function = new Function1<Expression, Boolean>() {
      @Override
      public Boolean apply(final Expression it) {
        Expression simpleName = null;
        boolean _matched = false;
        if (!_matched) {
          if (it instanceof Assignment) {
            _matched=true;
            Expression _leftHandSide = ((Assignment)it).getLeftHandSide();
            simpleName = _leftHandSide;
          }
        }
        if (!_matched) {
          if (it instanceof PrefixExpression) {
            _matched=true;
            Expression _operand = ((PrefixExpression)it).getOperand();
            simpleName = _operand;
          }
        }
        if (!_matched) {
          if (it instanceof PostfixExpression) {
            _matched=true;
            Expression _operand = ((PostfixExpression)it).getOperand();
            simpleName = _operand;
          }
        }
        if ((simpleName instanceof SimpleName)) {
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(simpleName, null));
          if (!_notEquals) {
            _and = false;
          } else {
            String _identifier = nameToLookFor.getIdentifier();
            String _identifier_1 = ((SimpleName)simpleName).getIdentifier();
            boolean _equals = _identifier.equals(_identifier_1);
            _and = _equals;
          }
          return Boolean.valueOf(_and);
        }
        return Boolean.valueOf(false);
      }
    };
    Iterable<Expression> _findAssignmentsInBlock = this.findAssignmentsInBlock(scope, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(_findAssignmentsInBlock);
    return Boolean.valueOf((!_isEmpty));
  }
  
  protected String _toSimpleName(final SimpleName name) {
    return name.getIdentifier();
  }
  
  protected String _toSimpleName(final QualifiedName name) {
    SimpleName _name = name.getName();
    return _name.getIdentifier();
  }
  
  public List<ASTNode> genericChildListProperty(final ASTNode node, final String propertyName) {
    List _structuralPropertiesForType = node.structuralPropertiesForType();
    Iterable<ChildListPropertyDescriptor> _filter = Iterables.<ChildListPropertyDescriptor>filter(_structuralPropertiesForType, ChildListPropertyDescriptor.class);
    final Function1<ChildListPropertyDescriptor, Boolean> _function = new Function1<ChildListPropertyDescriptor, Boolean>() {
      @Override
      public Boolean apply(final ChildListPropertyDescriptor it) {
        String _id = it.getId();
        return Boolean.valueOf(Objects.equal(propertyName, _id));
      }
    };
    Iterable<ChildListPropertyDescriptor> _filter_1 = IterableExtensions.<ChildListPropertyDescriptor>filter(_filter, _function);
    final ChildListPropertyDescriptor property = IterableExtensions.<ChildListPropertyDescriptor>head(_filter_1);
    boolean _notEquals = (!Objects.equal(property, null));
    if (_notEquals) {
      Object _structuralProperty = node.getStructuralProperty(property);
      return ((List<ASTNode>) _structuralProperty);
    }
    return null;
  }
  
  public boolean needPrimitiveCast(final Type type) {
    if ((type instanceof PrimitiveType)) {
      boolean _or = false;
      boolean _or_1 = false;
      PrimitiveType.Code _primitiveTypeCode = ((PrimitiveType)type).getPrimitiveTypeCode();
      boolean _equals = Objects.equal(_primitiveTypeCode, PrimitiveType.CHAR);
      if (_equals) {
        _or_1 = true;
      } else {
        PrimitiveType.Code _primitiveTypeCode_1 = ((PrimitiveType)type).getPrimitiveTypeCode();
        boolean _equals_1 = Objects.equal(_primitiveTypeCode_1, PrimitiveType.BYTE);
        _or_1 = _equals_1;
      }
      if (_or_1) {
        _or = true;
      } else {
        PrimitiveType.Code _primitiveTypeCode_2 = ((PrimitiveType)type).getPrimitiveTypeCode();
        boolean _equals_2 = Objects.equal(_primitiveTypeCode_2, PrimitiveType.SHORT);
        _or = _equals_2;
      }
      return _or;
    }
    return false;
  }
  
  public ASTNode genericChildProperty(final ASTNode node, final String propertyName) {
    List _structuralPropertiesForType = node.structuralPropertiesForType();
    Iterable<ChildPropertyDescriptor> _filter = Iterables.<ChildPropertyDescriptor>filter(_structuralPropertiesForType, ChildPropertyDescriptor.class);
    final Function1<ChildPropertyDescriptor, Boolean> _function = new Function1<ChildPropertyDescriptor, Boolean>() {
      @Override
      public Boolean apply(final ChildPropertyDescriptor it) {
        String _id = it.getId();
        return Boolean.valueOf(Objects.equal(propertyName, _id));
      }
    };
    Iterable<ChildPropertyDescriptor> _filter_1 = IterableExtensions.<ChildPropertyDescriptor>filter(_filter, _function);
    final ChildPropertyDescriptor property = IterableExtensions.<ChildPropertyDescriptor>head(_filter_1);
    boolean _notEquals = (!Objects.equal(property, null));
    if (_notEquals) {
      Object _structuralProperty = node.getStructuralProperty(property);
      return ((ASTNode) _structuralProperty);
    }
    return null;
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
