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
      return (("MISSING".equals(((TypeDeclaration)it).getName().getIdentifier()) && (!((TypeDeclaration)it).isInterface())) && (((TypeDeclaration)it).getModifiers() == 0));
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
    return (((!it.isInterface()) && ((it.getParent() instanceof TypeDeclaration) || (it.getParent() instanceof Block))) && 
      (!IterableExtensions.<Modifier>exists(Iterables.<Modifier>filter(it.modifiers(), Modifier.class), new Function1<Modifier, Boolean>() {
        @Override
        public Boolean apply(final Modifier it) {
          return Boolean.valueOf(it.isStatic());
        }
      })));
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
        return Boolean.valueOf(((it.isPublic() || it.isPrivate()) || it.isProtected()));
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
    return ((it.getParent() instanceof FieldAccess) || ((it.getParent() instanceof VariableDeclarationFragment) && (it.getParent().getParent() instanceof FieldDeclaration)));
  }
  
  public boolean isLambdaCase(final ClassInstanceCreation creation) {
    final AnonymousClassDeclaration anonymousClazz = creation.getAnonymousClassDeclaration();
    if (((!Objects.equal(anonymousClazz, null)) && (anonymousClazz.bodyDeclarations().size() == 1))) {
      List _bodyDeclarations = anonymousClazz.bodyDeclarations();
      final Object declaredMethod = _bodyDeclarations.get(0);
      if (((declaredMethod instanceof MethodDeclaration) && (!Objects.equal(creation.getType().resolveBinding(), null)))) {
        final IMethodBinding methodBinding = ((MethodDeclaration) declaredMethod).resolveBinding();
        boolean _notEquals = (!Objects.equal(methodBinding, null));
        if (_notEquals) {
          ITypeBinding _declaringClass = methodBinding.getDeclaringClass();
          final IMethodBinding overrides = this.findOverride(methodBinding, _declaringClass, true);
          return ((!Objects.equal(overrides, null)) && Modifier.isAbstract(overrides.getModifiers()));
        }
      }
    }
    return false;
  }
  
  public boolean needsReturnValue(final ASTNode node) {
    return ((!Objects.equal(node.getParent(), null)) && ((!(node.getParent() instanceof Statement)) || (node.getParent() instanceof ReturnStatement)));
  }
  
  public boolean isConstantArrayIndex(final Expression node) {
    return (node instanceof NumberLiteral);
  }
  
  public boolean canConvertToRichText(final InfixExpression node) {
    final FieldDeclaration parentFieldDecl = this.<FieldDeclaration>findParentOfType(node, FieldDeclaration.class);
    boolean _notEquals = (!Objects.equal(parentFieldDecl, null));
    if (_notEquals) {
      final TypeDeclaration typeDeclr = this.<TypeDeclaration>findParentOfType(parentFieldDecl, TypeDeclaration.class);
      if ((typeDeclr.isInterface() || (this.isFinal(parentFieldDecl.modifiers()) && this.isStatic(parentFieldDecl.modifiers())))) {
        return false;
      }
    }
    final Iterable<StringLiteral> nodes = this.collectCompatibleNodes(node);
    return ((!IterableExtensions.isEmpty(nodes)) && IterableExtensions.<StringLiteral>forall(nodes, new Function1<StringLiteral, Boolean>() {
      @Override
      public Boolean apply(final StringLiteral it) {
        return Boolean.valueOf(ASTFlattenerUtils.this.canTranslate(it));
      }
    }));
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
    return (!((value.contains("«") || value.contains("»")) || value.contains("\'\'\'")));
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
          if (parentNode instanceof VariableDeclarationStatement) {
            _matched=true;
            Type _type = ((VariableDeclarationStatement)parentNode).getType();
            matchesFound.add(_type);
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
        if (it instanceof Assignment) {
          _matched=true;
          Expression _leftHandSide = ((Assignment)it).getLeftHandSide();
          name = _leftHandSide;
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
            return Boolean.valueOf((varDecl.getName().getIdentifier().equals(ASTFlattenerUtils.this.toSimpleName(((Name)name))) && ((IVariableBinding)binding).equals(declBinding)));
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
        if (it instanceof Assignment) {
          _matched=true;
          Expression _leftHandSide = ((Assignment)it).getLeftHandSide();
          simpleName = _leftHandSide;
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
          return Boolean.valueOf(((!Objects.equal(simpleName, null)) && nameToLookFor.getIdentifier().equals(((SimpleName)simpleName).getIdentifier())));
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
      return ((Objects.equal(((PrimitiveType)type).getPrimitiveTypeCode(), PrimitiveType.CHAR) || Objects.equal(((PrimitiveType)type).getPrimitiveTypeCode(), PrimitiveType.BYTE)) || 
        Objects.equal(((PrimitiveType)type).getPrimitiveTypeCode(), PrimitiveType.SHORT));
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
