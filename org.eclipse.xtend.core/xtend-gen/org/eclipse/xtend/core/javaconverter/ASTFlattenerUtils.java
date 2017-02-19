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
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
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
    final Function1<Annotation, Boolean> _function = (Annotation it) -> {
      String _string = it.getTypeName().toString();
      return Boolean.valueOf(Objects.equal("Override", _string));
    };
    boolean _exists = IterableExtensions.<Annotation>exists(Iterables.<Annotation>filter(declaration.modifiers(), Annotation.class), _function);
    if (_exists) {
      return true;
    }
    final IMethodBinding iMethodBinding = declaration.resolveBinding();
    if ((iMethodBinding != null)) {
      IMethodBinding _findOverride = this.findOverride(iMethodBinding, iMethodBinding.getDeclaringClass());
      return (_findOverride != null);
    }
    return false;
  }
  
  public IMethodBinding findOverride(final IMethodBinding method, final ITypeBinding type) {
    return this.findOverride(method, type, false);
  }
  
  public IMethodBinding findOverride(final IMethodBinding method, final ITypeBinding type, final boolean onlyPrimarylevel) {
    final ITypeBinding superclass = type.getSuperclass();
    IMethodBinding overridden = null;
    if ((superclass != null)) {
      overridden = this.internalFindOverride(method, superclass, onlyPrimarylevel);
    }
    if ((overridden == null)) {
      ITypeBinding[] _interfaces = type.getInterfaces();
      for (final ITypeBinding interfaze : _interfaces) {
        {
          overridden = this.internalFindOverride(method, interfaze, onlyPrimarylevel);
          if ((overridden != null)) {
            return overridden;
          }
        }
      }
    }
    return overridden;
  }
  
  private IMethodBinding internalFindOverride(final IMethodBinding method, final ITypeBinding superType, final boolean onlyPrimarylevel) {
    final Function1<IMethodBinding, Boolean> _function = (IMethodBinding it) -> {
      return Boolean.valueOf(method.overrides(it));
    };
    final Iterable<IMethodBinding> superClassOverride = IterableExtensions.<IMethodBinding>filter(((Iterable<IMethodBinding>)Conversions.doWrapArray(superType.getDeclaredMethods())), _function);
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
    boolean _isFinal = this.isFinal(Iterables.<Modifier>filter(modifier, Modifier.class));
    if (_isFinal) {
      return "val";
    } else {
      return "var";
    }
  }
  
  public boolean isNotSupportedInnerType(final TypeDeclaration it) {
    return (((!it.isInterface()) && ((it.getParent() instanceof TypeDeclaration) || (it.getParent() instanceof Block))) && 
      (!IterableExtensions.<Modifier>exists(Iterables.<Modifier>filter(it.modifiers(), Modifier.class), ((Function1<Modifier, Boolean>) (Modifier it_1) -> {
        return Boolean.valueOf(it_1.isStatic());
      }))));
  }
  
  public boolean isNotSupportedInnerType(final TypeDeclarationStatement it) {
    ASTNode _parent = it.getParent();
    return (_parent instanceof Block);
  }
  
  public boolean isFinal(final Iterable<Modifier> modifiers) {
    final Function1<Modifier, Boolean> _function = (Modifier it) -> {
      return Boolean.valueOf(it.isFinal());
    };
    return IterableExtensions.<Modifier>exists(Iterables.<Modifier>filter(modifiers, Modifier.class), _function);
  }
  
  public boolean isStatic(final Iterable<IExtendedModifier> modifiers) {
    final Function1<Modifier, Boolean> _function = (Modifier it) -> {
      return Boolean.valueOf(it.isStatic());
    };
    return IterableExtensions.<Modifier>exists(Iterables.<Modifier>filter(modifiers, Modifier.class), _function);
  }
  
  public boolean isStaticMemberCall(final MethodInvocation methInv) {
    return this.isStaticBinding(methInv.resolveMethodBinding());
  }
  
  public boolean isStaticMemberCall(final QualifiedName expr) {
    return this.isStaticBinding(expr.resolveBinding());
  }
  
  public boolean isStaticMemberCall(final FieldAccess expr) {
    return this.isStaticBinding(expr.resolveFieldBinding());
  }
  
  private boolean isStaticBinding(final IBinding binding) {
    if ((binding != null)) {
      return Modifier.isStatic(binding.getModifiers());
    }
    return false;
  }
  
  public boolean isPackageVisibility(final Iterable<Modifier> modifier) {
    final Function1<Modifier, Boolean> _function = (Modifier it) -> {
      return Boolean.valueOf(((it.isPublic() || it.isPrivate()) || it.isProtected()));
    };
    return IterableExtensions.isEmpty(IterableExtensions.<Modifier>filter(modifier, _function));
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
    if (((anonymousClazz != null) && (anonymousClazz.bodyDeclarations().size() == 1))) {
      final Object declaredMethod = anonymousClazz.bodyDeclarations().get(0);
      if (((declaredMethod instanceof MethodDeclaration) && (creation.getType().resolveBinding() != null))) {
        final IMethodBinding methodBinding = ((MethodDeclaration) declaredMethod).resolveBinding();
        if ((methodBinding != null)) {
          final IMethodBinding overrides = this.findOverride(methodBinding, methodBinding.getDeclaringClass(), true);
          return ((overrides != null) && Modifier.isAbstract(overrides.getModifiers()));
        }
      }
    }
    return false;
  }
  
  public boolean needsReturnValue(final ASTNode node) {
    return ((node.getParent() != null) && ((!(node.getParent() instanceof Statement)) || (node.getParent() instanceof ReturnStatement)));
  }
  
  public boolean isConstantArrayIndex(final Expression node) {
    return (node instanceof NumberLiteral);
  }
  
  public boolean canConvertToRichText(final InfixExpression node) {
    final FieldDeclaration parentFieldDecl = this.<FieldDeclaration>findParentOfType(node, FieldDeclaration.class);
    if ((parentFieldDecl != null)) {
      final TypeDeclaration typeDeclr = this.<TypeDeclaration>findParentOfType(parentFieldDecl, TypeDeclaration.class);
      if ((typeDeclr.isInterface() || (this.isFinal(parentFieldDecl.modifiers()) && this.isStatic(parentFieldDecl.modifiers())))) {
        return false;
      }
    }
    final SingleMemberAnnotation parentSingleMemberAnnotation = this.<SingleMemberAnnotation>findParentOfType(node, SingleMemberAnnotation.class);
    if ((parentSingleMemberAnnotation != null)) {
      return false;
    }
    final Iterable<StringLiteral> nodes = this.collectCompatibleNodes(node);
    return ((!IterableExtensions.isEmpty(nodes)) && IterableExtensions.<StringLiteral>forall(nodes, ((Function1<StringLiteral, Boolean>) (StringLiteral it) -> {
      return Boolean.valueOf(this.canTranslate(it));
    })));
  }
  
  public <T extends ASTNode> T findParentOfType(final ASTNode someNode, final Class<T> parentType) {
    ASTNode _parent = someNode.getParent();
    boolean _tripleEquals = (_parent == null);
    if (_tripleEquals) {
      return null;
    } else {
      boolean _isInstance = parentType.isInstance(someNode.getParent());
      if (_isInstance) {
        return parentType.cast(someNode.getParent());
      } else {
        return this.<T>findParentOfType(someNode.getParent(), parentType);
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
        Iterables.<StringLiteral>addAll(strings, this.collectCompatibleNodes(((InfixExpression)left)));
      }
    }
    final Expression right = node.getRightOperand();
    if ((right instanceof StringLiteral)) {
      strings.add(((StringLiteral)right));
    } else {
      if ((right instanceof InfixExpression)) {
        Iterables.<StringLiteral>addAll(strings, this.collectCompatibleNodes(((InfixExpression)right)));
      }
    }
    Iterables.<StringLiteral>addAll(strings, Iterables.<StringLiteral>filter(node.extendedOperands(), StringLiteral.class));
    return strings;
  }
  
  private boolean canTranslate(final StringLiteral literal) {
    final String value = literal.getEscapedValue();
    return (!((value.contains("«") || value.contains("»")) || value.contains("\'\'\'")));
  }
  
  public Type findDeclaredType(final SimpleName simpleName) {
    ASTNode scope = this.findDeclarationBlocks(simpleName);
    while ((scope != null)) {
      {
        final Type type = this.findDeclaredType(scope, simpleName);
        if ((type != null)) {
          return type;
        }
        scope = this.findDeclarationBlocks(scope);
      }
    }
    return null;
  }
  
  private ASTNode findDeclarationBlocks(final ASTNode simpleName) {
    ASTNode block = this.<Block>findParentOfType(simpleName, Block.class);
    if ((block == null)) {
      block = this.<MethodDeclaration>findParentOfType(simpleName, MethodDeclaration.class);
    }
    if ((block == null)) {
      block = this.<TypeDeclaration>findParentOfType(simpleName, TypeDeclaration.class);
    }
    return block;
  }
  
  private Type findDeclaredType(final ASTNode scope, final SimpleName simpleName) {
    final ArrayList<Type> matchesFound = CollectionLiterals.<Type>newArrayList();
    scope.accept(new ASTVisitor() {
      @Override
      public boolean visit(final VariableDeclarationFragment node) {
        boolean _equals = node.getName().getIdentifier().equals(simpleName.getIdentifier());
        if (_equals) {
          final ASTNode parentNode = node.getParent();
          boolean _matched = false;
          if (parentNode instanceof VariableDeclarationStatement) {
            _matched=true;
            matchesFound.add(((VariableDeclarationStatement)parentNode).getType());
          }
          if (!_matched) {
            if (parentNode instanceof FieldDeclaration) {
              _matched=true;
              matchesFound.add(((FieldDeclaration)parentNode).getType());
            }
          }
          if (!_matched) {
            if (parentNode instanceof VariableDeclarationExpression) {
              _matched=true;
              matchesFound.add(((VariableDeclarationExpression)parentNode).getType());
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
        boolean _equals = node.getName().getIdentifier().equals(simpleName.getIdentifier());
        if (_equals) {
          matchesFound.add(node.getType());
        }
        return false;
      }
    });
    return IterableExtensions.<Type>head(matchesFound);
  }
  
  public Iterable<Expression> findAssignmentsInBlock(final Block scope, final Function1<? super Expression, ? extends Boolean> constraint) {
    final HashSet<Expression> assigments = CollectionLiterals.<Expression>newHashSet();
    if ((scope != null)) {
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
    boolean _isEmpty = IterableExtensions.isEmpty(this.findAssignmentsInBlock(scope, fieldDeclFragment));
    return Boolean.valueOf((!_isEmpty));
  }
  
  public Iterable<Expression> findAssignmentsInBlock(final Block scope, final VariableDeclaration varDecl) {
    final Function1<Expression, Boolean> _function = (Expression it) -> {
      Expression name = null;
      boolean _matched = false;
      if (it instanceof Assignment) {
        _matched=true;
        name = ((Assignment)it).getLeftHandSide();
      }
      if (!_matched) {
        if (it instanceof PrefixExpression) {
          _matched=true;
          name = ((PrefixExpression)it).getOperand();
        }
      }
      if (!_matched) {
        if (it instanceof PostfixExpression) {
          _matched=true;
          name = ((PostfixExpression)it).getOperand();
        }
      }
      if ((name instanceof Name)) {
        final IBinding binding = ((Name)name).resolveBinding();
        if ((binding instanceof IVariableBinding)) {
          final IVariableBinding declBinding = varDecl.resolveBinding();
          return Boolean.valueOf((varDecl.getName().getIdentifier().equals(this.toSimpleName(((Name)name))) && ((IVariableBinding)binding).equals(declBinding)));
        }
      }
      return Boolean.valueOf(false);
    };
    return this.findAssignmentsInBlock(scope, _function);
  }
  
  public Boolean isAssignedInBody(final Block scope, final SimpleName nameToLookFor) {
    final Function1<Expression, Boolean> _function = (Expression it) -> {
      Expression simpleName = null;
      boolean _matched = false;
      if (it instanceof Assignment) {
        _matched=true;
        simpleName = ((Assignment)it).getLeftHandSide();
      }
      if (!_matched) {
        if (it instanceof PrefixExpression) {
          _matched=true;
          simpleName = ((PrefixExpression)it).getOperand();
        }
      }
      if (!_matched) {
        if (it instanceof PostfixExpression) {
          _matched=true;
          simpleName = ((PostfixExpression)it).getOperand();
        }
      }
      if ((simpleName instanceof SimpleName)) {
        return Boolean.valueOf(((simpleName != null) && nameToLookFor.getIdentifier().equals(((SimpleName)simpleName).getIdentifier())));
      }
      return Boolean.valueOf(false);
    };
    boolean _isEmpty = IterableExtensions.isEmpty(this.findAssignmentsInBlock(scope, _function));
    return Boolean.valueOf((!_isEmpty));
  }
  
  protected String _toSimpleName(final SimpleName name) {
    return name.getIdentifier();
  }
  
  protected String _toSimpleName(final QualifiedName name) {
    return name.getName().getIdentifier();
  }
  
  public List<ASTNode> genericChildListProperty(final ASTNode node, final String propertyName) {
    final Function1<ChildListPropertyDescriptor, Boolean> _function = (ChildListPropertyDescriptor it) -> {
      String _id = it.getId();
      return Boolean.valueOf(Objects.equal(propertyName, _id));
    };
    final ChildListPropertyDescriptor property = IterableExtensions.<ChildListPropertyDescriptor>head(IterableExtensions.<ChildListPropertyDescriptor>filter(Iterables.<ChildListPropertyDescriptor>filter(node.structuralPropertiesForType(), ChildListPropertyDescriptor.class), _function));
    if ((property != null)) {
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
    final Function1<ChildPropertyDescriptor, Boolean> _function = (ChildPropertyDescriptor it) -> {
      String _id = it.getId();
      return Boolean.valueOf(Objects.equal(propertyName, _id));
    };
    final ChildPropertyDescriptor property = IterableExtensions.<ChildPropertyDescriptor>head(IterableExtensions.<ChildPropertyDescriptor>filter(Iterables.<ChildPropertyDescriptor>filter(node.structuralPropertiesForType(), ChildPropertyDescriptor.class), _function));
    if ((property != null)) {
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
