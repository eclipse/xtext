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
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.AnnotationTypeMemberDeclaration;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.ArrayAccess;
import org.eclipse.jdt.core.dom.ArrayCreation;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.ArrayType;
import org.eclipse.jdt.core.dom.AssertStatement;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BlockComment;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.BooleanLiteral;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.CastExpression;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.CharacterLiteral;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.Comment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ConditionalExpression;
import org.eclipse.jdt.core.dom.ConstructorInvocation;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EmptyStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.Initializer;
import org.eclipse.jdt.core.dom.InstanceofExpression;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.LabeledStatement;
import org.eclipse.jdt.core.dom.LineComment;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MemberRef;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.MethodRef;
import org.eclipse.jdt.core.dom.MethodRefParameter;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.NullLiteral;
import org.eclipse.jdt.core.dom.NumberLiteral;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.ParenthesizedExpression;
import org.eclipse.jdt.core.dom.PostfixExpression;
import org.eclipse.jdt.core.dom.PrefixExpression;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.QualifiedType;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.SuperFieldAccess;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.SynchronizedStatement;
import org.eclipse.jdt.core.dom.TagElement;
import org.eclipse.jdt.core.dom.TextElement;
import org.eclipse.jdt.core.dom.ThisExpression;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclarationStatement;
import org.eclipse.jdt.core.dom.TypeLiteral;
import org.eclipse.jdt.core.dom.TypeParameter;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jdt.core.dom.WildcardType;
import org.eclipse.xtend.core.javaconverter.ASTFlattenerUtils;
import org.eclipse.xtend.core.javaconverter.ASTParserFactory;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaASTFlattener extends ASTVisitor {
  @Inject
  private IValueConverterService converterService;
  
  @Inject
  @Extension
  private ASTFlattenerUtils _aSTFlattenerUtils;
  
  private List<String> problems = CollectionLiterals.<String>newArrayList();
  
  private Set<Comment> assignedComments = CollectionLiterals.<Comment>newHashSet();
  
  /**
   * The string buffer into which the serialized representation of the AST is
   * written.
   */
  private StringBuffer fBuffer;
  
  private String javaSources;
  
  private int indentation = 0;
  
  private boolean fallBackStrategy = false;
  
  private String targetApiLevel;
  
  /**
   * Creates a new AST printer.
   */
  public JavaASTFlattener() {
    StringBuffer _stringBuffer = new StringBuffer();
    this.fBuffer = _stringBuffer;
  }
  
  /**
   * Returns the string accumulated in the visit.
   * 
   * @return the serialized
   */
  public String getResult() {
    return this.fBuffer.toString();
  }
  
  /**
   * Returns a list of problems occured during conversion
   */
  public List<String> getProblems() {
    return this.problems;
  }
  
  public void acceptSyntaticBlock(final Block node) {
    List _statements = node.statements();
    final int childrenCount = _statements.size();
    if ((childrenCount > 0)) {
      List _statements_1 = node.statements();
      final Procedure2<ASTNode, Integer> _function = new Procedure2<ASTNode, Integer>() {
        @Override
        public void apply(final ASTNode child, final Integer counter) {
          child.accept(JavaASTFlattener.this);
          JavaASTFlattener.this.appendLineWrapToBuffer();
        }
      };
      IterableExtensions.<ASTNode>forEach(_statements_1, _function);
    }
  }
  
  private int decreaseIndent() {
    int _xifexpression = (int) 0;
    if ((this.indentation > 0)) {
      _xifexpression = this.indentation--;
    }
    return _xifexpression;
  }
  
  private int increaseIndent() {
    return this.indentation++;
  }
  
  private boolean notAssigned(final Comment comment) {
    boolean _contains = this.assignedComments.contains(comment);
    return (!_contains);
  }
  
  public boolean java8orHigher() {
    int _asJLS = ASTParserFactory.asJLS(this.targetApiLevel);
    return (_asJLS >= 8);
  }
  
  public void appendModifiers(final ASTNode node, final Iterable<IExtendedModifier> ext) {
    this.appendModifiers(node, ext, null);
  }
  
  public void appendModifiers(final ASTNode node, final Iterable<IExtendedModifier> ext, final Function1<? super ASTNode, ? extends StringBuffer> callBack) {
    final Procedure1<IExtendedModifier> _function = new Procedure1<IExtendedModifier>() {
      @Override
      public void apply(final IExtendedModifier p) {
        ((ASTNode) p).accept(JavaASTFlattener.this);
      }
    };
    final Procedure1<IExtendedModifier> appender = _function;
    final Function1<IExtendedModifier, Boolean> _function_1 = new Function1<IExtendedModifier, Boolean>() {
      @Override
      public Boolean apply(final IExtendedModifier it) {
        boolean _and = false;
        boolean _isAnnotation = it.isAnnotation();
        if (!_isAnnotation) {
          _and = false;
        } else {
          Name _typeName = ((Annotation) it).getTypeName();
          String _string = _typeName.toString();
          boolean _notEquals = (!Objects.equal(_string, "Override"));
          _and = _notEquals;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<IExtendedModifier> _filter = IterableExtensions.<IExtendedModifier>filter(ext, _function_1);
    IterableExtensions.<IExtendedModifier>forEach(_filter, appender);
    boolean _notEquals = (!Objects.equal(callBack, null));
    if (_notEquals) {
      callBack.apply(node);
    }
    final Function1<IExtendedModifier, Boolean> _function_2 = new Function1<IExtendedModifier, Boolean>() {
      @Override
      public Boolean apply(final IExtendedModifier it) {
        boolean _and = false;
        boolean _isModifier = it.isModifier();
        if (!_isModifier) {
          _and = false;
        } else {
          Modifier.ModifierKeyword _keyword = ((Modifier) it).getKeyword();
          String _string = _keyword.toString();
          boolean _notEquals = (!Objects.equal(_string, "default"));
          _and = _notEquals;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<IExtendedModifier> _filter_1 = IterableExtensions.<IExtendedModifier>filter(ext, _function_2);
    IterableExtensions.<IExtendedModifier>forEach(_filter_1, appender);
  }
  
  private StringBuffer appendSpaceToBuffer() {
    return this.appendToBuffer(" ");
  }
  
  private StringBuffer appendLineWrapToBuffer() {
    StringBuffer _xblockexpression = null;
    {
      String _nl = this.nl();
      this.appendToBuffer(_nl);
      String _multiply = this.operator_multiply("\t", this.indentation);
      _xblockexpression = this.appendToBuffer(_multiply);
    }
    return _xblockexpression;
  }
  
  protected String nl() {
    return StringConcatenation.DEFAULT_LINE_DELIMITER;
  }
  
  public String operator_multiply(final String string, final int i) {
    String _xblockexpression = null;
    {
      String retVal = "";
      int counter = 0;
      while ((counter < i)) {
        {
          counter++;
          retVal = (retVal + string);
        }
      }
      _xblockexpression = retVal;
    }
    return _xblockexpression;
  }
  
  private StringBuffer appendToBuffer(final String string) {
    return this.fBuffer.append(string);
  }
  
  protected boolean addProblem(final ASTNode node, final String string) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(string, "");
    _builder.append(" (start: ");
    int _startPosition = node.getStartPosition();
    _builder.append(_startPosition, "");
    _builder.append(", length: ");
    int _length = node.getLength();
    _builder.append(_length, "");
    _builder.append(")");
    return this.problems.add(_builder.toString());
  }
  
  @Override
  public boolean visit(final Assignment node) {
    final Expression leftSide = node.getLeftHandSide();
    Type type = null;
    if ((leftSide instanceof ArrayAccess)) {
      Expression _array = ((ArrayAccess)leftSide).getArray();
      if ((_array instanceof SimpleName)) {
        Expression _array_1 = ((ArrayAccess)leftSide).getArray();
        Type _findDeclaredType = this._aSTFlattenerUtils.findDeclaredType(((SimpleName) _array_1));
        type = _findDeclaredType;
      }
      this.handleAssignment(node, ((ArrayAccess)leftSide), type);
    } else {
      if ((leftSide instanceof SimpleName)) {
        Type _findDeclaredType_1 = this._aSTFlattenerUtils.findDeclaredType(((SimpleName)leftSide));
        type = _findDeclaredType_1;
      }
      this.handleAssignment(node, leftSide, type);
    }
    return false;
  }
  
  public void handleAssignment(final Assignment node, final ASTNode leftSide, final Type type) {
    leftSide.accept(this);
    Assignment.Operator _operator = node.getOperator();
    String _string = _operator.toString();
    this.appendToBuffer(_string);
    this.handleRightHandSide(node, type);
  }
  
  public void handleAssignment(final Assignment node, final ArrayAccess leftSide, final Type type) {
    final String arrayName = this.computeArrayName(leftSide);
    this.appendToBuffer("{ ");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_wrVal_");
    _builder.append(arrayName, "");
    final String valName = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("_wrIndx_");
    _builder_1.append(arrayName, "");
    String idxName = _builder_1.toString();
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("val ");
    _builder_2.append(valName, "");
    _builder_2.append("=");
    this.appendToBuffer(_builder_2.toString());
    Expression _array = leftSide.getArray();
    _array.accept(this);
    Expression _index = leftSide.getIndex();
    boolean _isConstantArrayIndex = this._aSTFlattenerUtils.isConstantArrayIndex(_index);
    boolean _not = (!_isConstantArrayIndex);
    if (_not) {
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append(" ");
      _builder_3.append("val ");
      _builder_3.append(idxName, " ");
      _builder_3.append("=");
      this.appendToBuffer(_builder_3.toString());
      Expression _index_1 = leftSide.getIndex();
      _index_1.accept(this);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append(" ");
      _builder_4.append(valName, " ");
      _builder_4.append(".set(");
      _builder_4.append(idxName, " ");
      _builder_4.append(",");
      this.appendToBuffer(_builder_4.toString());
    } else {
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append(" ");
      _builder_5.append(valName, " ");
      _builder_5.append(".set(");
      this.appendToBuffer(_builder_5.toString());
      Expression _index_2 = leftSide.getIndex();
      _index_2.accept(this);
      this.appendToBuffer(",");
    }
    this.handleRightHandSide(node, type);
    this.appendToBuffer(")");
    boolean _needsReturnValue = this._aSTFlattenerUtils.needsReturnValue(node);
    if (_needsReturnValue) {
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append(" ");
      _builder_6.append(valName, " ");
      _builder_6.append(".get(");
      this.appendToBuffer(_builder_6.toString());
      Expression _index_3 = leftSide.getIndex();
      boolean _isConstantArrayIndex_1 = this._aSTFlattenerUtils.isConstantArrayIndex(_index_3);
      boolean _not_1 = (!_isConstantArrayIndex_1);
      if (_not_1) {
        StringConcatenation _builder_7 = new StringConcatenation();
        _builder_7.append(idxName, "");
        this.appendToBuffer(_builder_7.toString());
      } else {
        Expression _index_4 = leftSide.getIndex();
        _index_4.accept(this);
      }
      this.appendToBuffer(")");
    }
    this.appendToBuffer("}");
  }
  
  public StringBuffer handleRightHandSide(final Assignment a, final Type type) {
    StringBuffer _xifexpression = null;
    boolean _needPrimitiveCast = this._aSTFlattenerUtils.needPrimitiveCast(type);
    if (_needPrimitiveCast) {
      StringBuffer _xblockexpression = null;
      {
        this.appendToBuffer("(");
        Expression _rightHandSide = a.getRightHandSide();
        _rightHandSide.accept(this);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(") as ");
        _builder.append(type, "");
        _xblockexpression = this.appendToBuffer(_builder.toString());
      }
      _xifexpression = _xblockexpression;
    } else {
      Expression _rightHandSide = a.getRightHandSide();
      _rightHandSide.accept(this);
    }
    return _xifexpression;
  }
  
  @Override
  public boolean visit(final MarkerAnnotation node) {
    this.appendToBuffer("@");
    Name _typeName = node.getTypeName();
    _typeName.accept(this);
    this.appendSpaceToBuffer();
    return false;
  }
  
  @Override
  public boolean visit(final CompilationUnit it) {
    List _types = it.types();
    AbstractTypeDeclaration _head = IterableExtensions.<AbstractTypeDeclaration>head(_types);
    boolean _isDummyType = this._aSTFlattenerUtils.isDummyType(_head);
    boolean _not = (!_isDummyType);
    if (_not) {
      PackageDeclaration _package = it.getPackage();
      if (_package!=null) {
        _package.accept(this);
      }
      List _imports = it.imports();
      this.visitAll(_imports);
    }
    List _types_1 = it.types();
    this.visitAll(_types_1);
    return false;
  }
  
  @Override
  public boolean visit(final PackageDeclaration it) {
    Javadoc _javadoc = it.getJavadoc();
    boolean _notEquals = (!Objects.equal(_javadoc, null));
    if (_notEquals) {
      Javadoc _javadoc_1 = it.getJavadoc();
      _javadoc_1.accept(this);
    }
    List _annotations = it.annotations();
    this.visitAll(_annotations, " ");
    this.appendToBuffer("package ");
    Name _name = it.getName();
    _name.accept(this);
    this.appendLineWrapToBuffer();
    return false;
  }
  
  @Override
  public boolean visit(final ParameterizedType it) {
    Type _type = it.getType();
    _type.accept(this);
    List _typeArguments = it.typeArguments();
    this.appendTypeParameters(_typeArguments);
    return false;
  }
  
  @Override
  public boolean visit(final PrimitiveType it) {
    PrimitiveType.Code _primitiveTypeCode = it.getPrimitiveTypeCode();
    String _string = _primitiveTypeCode.toString();
    this.appendToBuffer(_string);
    return false;
  }
  
  @Override
  public boolean visit(final BooleanLiteral it) {
    boolean _booleanValue = it.booleanValue();
    String _valueOf = String.valueOf(_booleanValue);
    this.appendToBuffer(_valueOf);
    return false;
  }
  
  @Override
  public boolean visit(final StringLiteral it) {
    String _escapedValue = it.getEscapedValue();
    final String handleOctal = _escapedValue.replaceAll("\\\\([01234567])", "\\u000$1");
    this.appendToBuffer(handleOctal);
    return false;
  }
  
  @Override
  public boolean visit(final ImportDeclaration it) {
    this.appendToBuffer("import ");
    boolean _isStatic = it.isStatic();
    if (_isStatic) {
      this.appendToBuffer("static ");
    }
    Name _name = it.getName();
    _name.accept(this);
    boolean _isOnDemand = it.isOnDemand();
    if (_isOnDemand) {
      this.appendToBuffer(".*");
    }
    this.appendLineWrapToBuffer();
    return false;
  }
  
  @Override
  public boolean visit(final Initializer it) {
    Javadoc _javadoc = it.getJavadoc();
    boolean _notEquals = (!Objects.equal(_javadoc, null));
    if (_notEquals) {
      Javadoc _javadoc_1 = it.getJavadoc();
      _javadoc_1.accept(this);
    }
    List _modifiers = it.modifiers();
    this.appendModifiers(it, _modifiers);
    List _modifiers_1 = it.modifiers();
    boolean _isStatic = this._aSTFlattenerUtils.isStatic(_modifiers_1);
    if (_isStatic) {
      boolean _and = false;
      ASTNode _parent = it.getParent();
      if (!(_parent instanceof TypeDeclaration)) {
        _and = false;
      } else {
        ASTNode _parent_1 = it.getParent();
        FieldDeclaration[] _fields = ((TypeDeclaration) _parent_1).getFields();
        final Function1<FieldDeclaration, Boolean> _function = new Function1<FieldDeclaration, Boolean>() {
          @Override
          public Boolean apply(final FieldDeclaration it) {
            boolean _and = false;
            List _modifiers = it.modifiers();
            boolean _isStatic = JavaASTFlattener.this._aSTFlattenerUtils.isStatic(_modifiers);
            if (!_isStatic) {
              _and = false;
            } else {
              List _modifiers_1 = it.modifiers();
              boolean _isFinal = JavaASTFlattener.this._aSTFlattenerUtils.isFinal(_modifiers_1);
              _and = _isFinal;
            }
            return Boolean.valueOf(_and);
          }
        };
        Iterable<FieldDeclaration> _filter = IterableExtensions.<FieldDeclaration>filter(((Iterable<FieldDeclaration>)Conversions.doWrapArray(_fields)), _function);
        final Function1<FieldDeclaration, Boolean> _function_1 = new Function1<FieldDeclaration, Boolean>() {
          @Override
          public Boolean apply(final FieldDeclaration f) {
            List _fragments = f.fragments();
            final Function1<VariableDeclarationFragment, Boolean> _function = new Function1<VariableDeclarationFragment, Boolean>() {
              @Override
              public Boolean apply(final VariableDeclarationFragment fragment) {
                Block _body = it.getBody();
                Boolean _isAssignedInBody = JavaASTFlattener.this._aSTFlattenerUtils.isAssignedInBody(_body, fragment);
                return Boolean.valueOf((!(_isAssignedInBody).booleanValue()));
              }
            };
            return Boolean.valueOf(IterableExtensions.<VariableDeclarationFragment>forall(_fragments, _function));
          }
        };
        boolean _forall = IterableExtensions.<FieldDeclaration>forall(_filter, _function_1);
        _and = _forall;
      }
      if (_and) {
        this.appendToBuffer(" final Void static_initializer = {");
        this.appendLineWrapToBuffer();
        Block _body = it.getBody();
        _body.accept(this);
        this.appendToBuffer("null }");
        this.appendLineWrapToBuffer();
      } else {
        this.addProblem(it, "Static initializer is not fully supported");
        this.appendToBuffer("{/*FIXME ");
        Block _body_1 = it.getBody();
        _body_1.accept(this);
        this.appendToBuffer("*/}");
      }
    } else {
      ASTNode _parent_2 = it.getParent();
      if ((_parent_2 instanceof AnonymousClassDeclaration)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Initializer is not supported in ");
        ASTNode _parent_3 = it.getParent();
        int _nodeType = _parent_3.getNodeType();
        Class _nodeClassForType = ASTNode.nodeClassForType(_nodeType);
        String _simpleName = _nodeClassForType.getSimpleName();
        _builder.append(_simpleName, "");
        this.addProblem(it, _builder.toString());
      }
      Block _body_2 = it.getBody();
      _body_2.accept(this);
    }
    return false;
  }
  
  @Override
  public boolean visit(final TypeDeclaration it) {
    boolean _isDummyType = this._aSTFlattenerUtils.isDummyType(it);
    if (_isDummyType) {
      List _bodyDeclarations = it.bodyDeclarations();
      String _nl = this.nl();
      this.visitAll(_bodyDeclarations, _nl);
      return false;
    }
    boolean _isNotSupportedInnerType = this._aSTFlattenerUtils.isNotSupportedInnerType(it);
    if (_isNotSupportedInnerType) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/* FIXME Non-static inner classes are not supported.*/");
      this.appendToBuffer(_builder.toString());
      this.addProblem(it, "Non-static inner classes are not supported.");
    }
    Javadoc _javadoc = it.getJavadoc();
    boolean _notEquals = (!Objects.equal(_javadoc, null));
    if (_notEquals) {
      Javadoc _javadoc_1 = it.getJavadoc();
      _javadoc_1.accept(this);
    }
    List _modifiers = it.modifiers();
    this.appendModifiers(it, _modifiers);
    boolean _isInterface = it.isInterface();
    if (_isInterface) {
      this.appendToBuffer("interface ");
    } else {
      List _modifiers_1 = it.modifiers();
      Iterable<Modifier> _filter = Iterables.<Modifier>filter(_modifiers_1, Modifier.class);
      boolean _isPackageVisibility = this._aSTFlattenerUtils.isPackageVisibility(_filter);
      if (_isPackageVisibility) {
        this.appendToBuffer("package ");
      }
      this.appendToBuffer("class ");
    }
    SimpleName _name = it.getName();
    _name.accept(this);
    List _typeParameters = it.typeParameters();
    boolean _isEmpty = _typeParameters.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      List _typeParameters_1 = it.typeParameters();
      this.appendTypeParameters(_typeParameters_1);
    }
    this.appendSpaceToBuffer();
    Type _superclassType = it.getSuperclassType();
    boolean _notEquals_1 = (!Objects.equal(_superclassType, null));
    if (_notEquals_1) {
      this.appendToBuffer("extends ");
      Type _superclassType_1 = it.getSuperclassType();
      _superclassType_1.accept(this);
      this.appendSpaceToBuffer();
    }
    List _superInterfaceTypes = it.superInterfaceTypes();
    boolean _isEmpty_1 = _superInterfaceTypes.isEmpty();
    boolean _not_1 = (!_isEmpty_1);
    if (_not_1) {
      boolean _isInterface_1 = it.isInterface();
      if (_isInterface_1) {
        this.appendToBuffer("extends ");
      } else {
        this.appendToBuffer("implements ");
      }
      List _superInterfaceTypes_1 = it.superInterfaceTypes();
      this.visitAllSeparatedByComma(_superInterfaceTypes_1);
    }
    this.appendToBuffer("{");
    this.increaseIndent();
    BodyDeclaration prev = null;
    List _bodyDeclarations_1 = it.bodyDeclarations();
    for (final BodyDeclaration body : ((Iterable<BodyDeclaration>) _bodyDeclarations_1)) {
      {
        if ((prev instanceof EnumConstantDeclaration)) {
          if ((body instanceof EnumConstantDeclaration)) {
            this.appendToBuffer(", ");
          } else {
            this.appendToBuffer("; ");
          }
        }
        this.appendLineWrapToBuffer();
        body.accept(this);
        prev = body;
      }
    }
    ASTNode _root = it.getRoot();
    if ((_root instanceof CompilationUnit)) {
      ASTNode _root_1 = it.getRoot();
      final CompilationUnit cu = ((CompilationUnit) _root_1);
      Iterable<Comment> _unAssignedComments = this.unAssignedComments(cu);
      final Procedure1<Comment> _function = new Procedure1<Comment>() {
        @Override
        public void apply(final Comment it) {
          it.accept(JavaASTFlattener.this);
          JavaASTFlattener.this.assignedComments.add(it);
        }
      };
      IterableExtensions.<Comment>forEach(_unAssignedComments, _function);
    }
    this.decreaseIndent();
    this.appendLineWrapToBuffer();
    this.appendToBuffer("}");
    return false;
  }
  
  private Iterable<Comment> unAssignedComments(final CompilationUnit cu) {
    List _commentList = cu.getCommentList();
    final Function1<Comment, Boolean> _function = new Function1<Comment, Boolean>() {
      @Override
      public Boolean apply(final Comment c) {
        boolean _and = false;
        boolean _and_1 = false;
        boolean _isDocComment = c.isDocComment();
        if (!_isDocComment) {
          _and_1 = false;
        } else {
          ASTNode _parent = c.getParent();
          boolean _notEquals = (!Objects.equal(_parent, null));
          _and_1 = _notEquals;
        }
        boolean _not = (!_and_1);
        if (!_not) {
          _and = false;
        } else {
          boolean _notAssigned = JavaASTFlattener.this.notAssigned(c);
          _and = _notAssigned;
        }
        return Boolean.valueOf(_and);
      }
    };
    return IterableExtensions.<Comment>filter(_commentList, _function);
  }
  
  @Override
  public boolean visit(final Javadoc it) {
    this.appendToBuffer("/** ");
    List _tags = it.tags();
    this.visitAll(_tags);
    this.appendLineWrapToBuffer();
    this.appendToBuffer(" */");
    this.appendLineWrapToBuffer();
    return false;
  }
  
  @Override
  public boolean visit(final SimpleName it) {
    String _identifier = it.getIdentifier();
    String convertedName = this.converterService.toString(_identifier, "ValidID");
    boolean _and = false;
    boolean _equals = "it".equals(convertedName);
    if (!_equals) {
      _and = false;
    } else {
      boolean _shouldConvertName = this._aSTFlattenerUtils.shouldConvertName(it);
      _and = _shouldConvertName;
    }
    if (_and) {
      convertedName = ("renamed_" + convertedName);
    }
    this.appendToBuffer(convertedName);
    return false;
  }
  
  @Override
  public boolean visit(final QualifiedName it) {
    Name _qualifier = it.getQualifier();
    _qualifier.accept(this);
    boolean _and = false;
    boolean _and_1 = false;
    if (!this.fallBackStrategy) {
      _and_1 = false;
    } else {
      boolean _isStaticMemberCall = this._aSTFlattenerUtils.isStaticMemberCall(it);
      _and_1 = _isStaticMemberCall;
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _or = false;
      ASTNode _parent = it.getParent();
      if ((_parent instanceof SimpleType)) {
        _or = true;
      } else {
        ASTNode _parent_1 = it.getParent();
        _or = (_parent_1 instanceof ImportDeclaration);
      }
      boolean _not = (!_or);
      _and = _not;
    }
    if (_and) {
      this.appendToBuffer("::");
    } else {
      this.appendToBuffer(".");
    }
    SimpleName _name = it.getName();
    _name.accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final SimpleType node) {
    return true;
  }
  
  @Override
  public boolean visit(final Modifier it) {
    boolean append = true;
    Modifier.ModifierKeyword _keyword = it.getKeyword();
    int _flagValue = _keyword.toFlagValue();
    switch (_flagValue) {
      case Modifier.PUBLIC:
        boolean _or = false;
        ASTNode _parent = it.getParent();
        if ((_parent instanceof TypeDeclaration)) {
          _or = true;
        } else {
          ASTNode _parent_1 = it.getParent();
          _or = (_parent_1 instanceof MethodDeclaration);
        }
        if (_or) {
          append = false;
        }
        break;
      case Modifier.PRIVATE:
        ASTNode _parent_2 = it.getParent();
        if ((_parent_2 instanceof FieldDeclaration)) {
          append = false;
        }
        break;
      case Modifier.FINAL:
        boolean _or_1 = false;
        ASTNode _parent_3 = it.getParent();
        if ((_parent_3 instanceof VariableDeclarationExpression)) {
          _or_1 = true;
        } else {
          ASTNode _parent_4 = it.getParent();
          _or_1 = (_parent_4 instanceof VariableDeclarationStatement);
        }
        if (_or_1) {
          append = false;
        }
        break;
      default:
        append = true;
        break;
    }
    if (append) {
      Modifier.ModifierKeyword _keyword_1 = it.getKeyword();
      String valueToAppend = _keyword_1.toString();
      Modifier.ModifierKeyword _keyword_2 = it.getKeyword();
      int _flagValue_1 = _keyword_2.toFlagValue();
      boolean _equals = (_flagValue_1 == 0);
      if (_equals) {
        valueToAppend = "package";
      }
      this.appendToBuffer(valueToAppend);
      this.appendSpaceToBuffer();
    }
    return false;
  }
  
  @Override
  public boolean visit(final FieldDeclaration it) {
    Javadoc _javadoc = it.getJavadoc();
    boolean _notEquals = (!Objects.equal(_javadoc, null));
    if (_notEquals) {
      Javadoc _javadoc_1 = it.getJavadoc();
      _javadoc_1.accept(this);
    }
    List _fragments = it.fragments();
    final Procedure1<VariableDeclarationFragment> _function = new Procedure1<VariableDeclarationFragment>() {
      @Override
      public void apply(final VariableDeclarationFragment frag) {
        List _modifiers = it.modifiers();
        JavaASTFlattener.this.appendModifiers(it, _modifiers);
        List _modifiers_1 = it.modifiers();
        Iterable<Modifier> _filter = Iterables.<Modifier>filter(_modifiers_1, Modifier.class);
        boolean _isPackageVisibility = JavaASTFlattener.this._aSTFlattenerUtils.isPackageVisibility(_filter);
        if (_isPackageVisibility) {
          ASTNode _parent = it.getParent();
          if ((_parent instanceof TypeDeclaration)) {
            ASTNode _parent_1 = it.getParent();
            boolean _isInterface = ((TypeDeclaration) _parent_1).isInterface();
            boolean _not = (!_isInterface);
            if (_not) {
              JavaASTFlattener.this.appendToBuffer("package ");
            }
          }
        }
        Type _type = it.getType();
        _type.accept(JavaASTFlattener.this);
        int _extraDimensions = frag.getExtraDimensions();
        JavaASTFlattener.this.appendExtraDimensions(_extraDimensions);
        JavaASTFlattener.this.appendSpaceToBuffer();
        frag.accept(JavaASTFlattener.this);
      }
    };
    IterableExtensions.<VariableDeclarationFragment>forEach(_fragments, _function);
    return false;
  }
  
  @Override
  public boolean visit(final VariableDeclarationExpression it) {
    List _fragments = it.fragments();
    final Procedure2<VariableDeclarationFragment, Integer> _function = new Procedure2<VariableDeclarationFragment, Integer>() {
      @Override
      public void apply(final VariableDeclarationFragment frag, final Integer counter) {
        List _modifiers = it.modifiers();
        JavaASTFlattener.this.appendModifiers(it, _modifiers);
        List _modifiers_1 = it.modifiers();
        String _handleVariableDeclaration = JavaASTFlattener.this._aSTFlattenerUtils.handleVariableDeclaration(_modifiers_1);
        JavaASTFlattener.this.appendToBuffer(_handleVariableDeclaration);
        JavaASTFlattener.this.appendSpaceToBuffer();
        Type _type = it.getType();
        _type.accept(JavaASTFlattener.this);
        JavaASTFlattener.this.appendSpaceToBuffer();
        frag.accept(JavaASTFlattener.this);
        List _fragments = it.fragments();
        int _size = _fragments.size();
        int _minus = (_size - 1);
        boolean _lessThan = ((counter).intValue() < _minus);
        if (_lessThan) {
          JavaASTFlattener.this.appendToBuffer(",");
          JavaASTFlattener.this.appendSpaceToBuffer();
        }
      }
    };
    IterableExtensions.<VariableDeclarationFragment>forEach(_fragments, _function);
    return false;
  }
  
  @Override
  public boolean visit(final VariableDeclarationFragment it) {
    SimpleName _name = it.getName();
    _name.accept(this);
    Expression _initializer = it.getInitializer();
    boolean _notEquals = (!Objects.equal(_initializer, null));
    if (_notEquals) {
      this.appendToBuffer("=");
      SimpleName _name_1 = it.getName();
      final Type type = this._aSTFlattenerUtils.findDeclaredType(_name_1);
      boolean _needPrimitiveCast = this._aSTFlattenerUtils.needPrimitiveCast(type);
      if (_needPrimitiveCast) {
        this.appendToBuffer("(");
        Expression _initializer_1 = it.getInitializer();
        _initializer_1.accept(this);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(") as ");
        _builder.append(type, "");
        this.appendToBuffer(_builder.toString());
      } else {
        Expression _initializer_2 = it.getInitializer();
        _initializer_2.accept(this);
      }
    } else {
      ASTNode _parent = it.getParent();
      if ((_parent instanceof VariableDeclarationStatement)) {
        ASTNode _parent_1 = it.getParent();
        List _modifiers = ((VariableDeclarationStatement) _parent_1).modifiers();
        boolean _isFinal = this._aSTFlattenerUtils.isFinal(_modifiers);
        if (_isFinal) {
          this.appendToBuffer("/* FIXME empty initializer for final variable is not supported */");
          this.addProblem(it, "Empty initializer for final variables is not supported.");
        }
      }
    }
    return false;
  }
  
  @Override
  public boolean visit(final ConditionalExpression node) {
    this.appendToBuffer("if (");
    Expression _expression = node.getExpression();
    _expression.accept(this);
    this.appendToBuffer(") ");
    Expression _thenExpression = node.getThenExpression();
    _thenExpression.accept(this);
    this.appendToBuffer(" else ");
    Expression _elseExpression = node.getElseExpression();
    _elseExpression.accept(this);
    this.appendSpaceToBuffer();
    return false;
  }
  
  private StringBuffer appendExtraDimensions(final int extraDimensions) {
    String _multiply = this.operator_multiply("[]", extraDimensions);
    return this.appendToBuffer(_multiply);
  }
  
  @Override
  public boolean visit(final VariableDeclarationStatement it) {
    List _modifiers = it.modifiers();
    Iterable<Annotation> _filter = Iterables.<Annotation>filter(_modifiers, Annotation.class);
    boolean _isEmpty = IterableExtensions.isEmpty(_filter);
    final boolean hasAnnotations = (!_isEmpty);
    List _fragments = it.fragments();
    final Procedure1<VariableDeclarationFragment> _function = new Procedure1<VariableDeclarationFragment>() {
      @Override
      public void apply(final VariableDeclarationFragment frag) {
        if (hasAnnotations) {
          JavaASTFlattener.this.appendToBuffer("/*FIXME Cannot add Annotation to Variable declaration. Java code: ");
        }
        List _modifiers = it.modifiers();
        final Function1<ASTNode, StringBuffer> _function = new Function1<ASTNode, StringBuffer>() {
          @Override
          public StringBuffer apply(final ASTNode it) {
            StringBuffer _xifexpression = null;
            if (hasAnnotations) {
              StringBuffer _xblockexpression = null;
              {
                JavaASTFlattener.this.appendToBuffer("*/");
                _xblockexpression = JavaASTFlattener.this.appendLineWrapToBuffer();
              }
              _xifexpression = _xblockexpression;
            }
            return _xifexpression;
          }
        };
        JavaASTFlattener.this.appendModifiers(it, _modifiers, _function);
        List _modifiers_1 = it.modifiers();
        String _handleVariableDeclaration = JavaASTFlattener.this._aSTFlattenerUtils.handleVariableDeclaration(_modifiers_1);
        JavaASTFlattener.this.appendToBuffer(_handleVariableDeclaration);
        JavaASTFlattener.this.appendSpaceToBuffer();
        Type _type = it.getType();
        boolean _isMissingType = JavaASTFlattener.this.isMissingType(_type);
        boolean _not = (!_isMissingType);
        if (_not) {
          Type _type_1 = it.getType();
          _type_1.accept(JavaASTFlattener.this);
        }
        int _extraDimensions = frag.getExtraDimensions();
        JavaASTFlattener.this.appendExtraDimensions(_extraDimensions);
        JavaASTFlattener.this.appendSpaceToBuffer();
        frag.accept(JavaASTFlattener.this);
        JavaASTFlattener.this.appendSpaceToBuffer();
      }
    };
    IterableExtensions.<VariableDeclarationFragment>forEach(_fragments, _function);
    return false;
  }
  
  public boolean isMissingType(final Type type) {
    if ((type instanceof SimpleType)) {
      Name _name = ((SimpleType)type).getName();
      boolean _isSimpleName = _name.isSimpleName();
      if (_isSimpleName) {
        Name _name_1 = ((SimpleType)type).getName();
        String _identifier = ((SimpleName) _name_1).getIdentifier();
        return "MISSING".equals(_identifier);
      }
    }
    return false;
  }
  
  public void visitAllSeparatedByComma(final Iterable<? extends ASTNode> iterable) {
    this.visitAll(iterable, ", ");
  }
  
  public void visitAll(final Iterable<? extends ASTNode> iterable) {
    boolean _isEmpty = IterableExtensions.isEmpty(iterable);
    if (_isEmpty) {
      return;
    } else {
      this.visitAll(iterable, null);
    }
  }
  
  public void visitAll(final Iterable<? extends ASTNode> iterable, final String separator) {
    final Procedure2<ASTNode, Integer> _function = new Procedure2<ASTNode, Integer>() {
      @Override
      public void apply(final ASTNode node, final Integer counter) {
        node.accept(JavaASTFlattener.this);
        boolean _and = false;
        boolean _notEquals = (!Objects.equal(separator, null));
        if (!_notEquals) {
          _and = false;
        } else {
          int _size = IterableExtensions.size(iterable);
          int _minus = (_size - 1);
          boolean _lessThan = ((counter).intValue() < _minus);
          _and = _lessThan;
        }
        if (_and) {
          JavaASTFlattener.this.appendToBuffer(separator);
        }
      }
    };
    IterableExtensions.forEach(iterable, _function);
  }
  
  public void appendTypeParameters(final Iterable<TypeParameter> iterable) {
    boolean _isEmpty = IterableExtensions.isEmpty(iterable);
    if (_isEmpty) {
      return;
    }
    this.appendToBuffer("<");
    this.visitAllSeparatedByComma(iterable);
    this.appendToBuffer(">");
  }
  
  @Override
  public boolean visit(final MethodDeclaration it) {
    Javadoc _javadoc = it.getJavadoc();
    boolean _notEquals = (!Objects.equal(_javadoc, null));
    if (_notEquals) {
      Javadoc _javadoc_1 = it.getJavadoc();
      _javadoc_1.accept(this);
    }
    final Function1<ASTNode, StringBuffer> _function = new Function1<ASTNode, StringBuffer>() {
      @Override
      public StringBuffer apply(final ASTNode node) {
        StringBuffer _xifexpression = null;
        if ((node instanceof MethodDeclaration)) {
          StringBuffer _xifexpression_1 = null;
          boolean _isConstructor = ((MethodDeclaration)node).isConstructor();
          boolean _not = (!_isConstructor);
          if (_not) {
            StringBuffer _xifexpression_2 = null;
            boolean _isOverrideMethod = JavaASTFlattener.this._aSTFlattenerUtils.isOverrideMethod(((MethodDeclaration)node));
            if (_isOverrideMethod) {
              _xifexpression_2 = JavaASTFlattener.this.appendToBuffer("override ");
            } else {
              _xifexpression_2 = JavaASTFlattener.this.appendToBuffer("def ");
            }
            _xifexpression_1 = _xifexpression_2;
          }
          _xifexpression = _xifexpression_1;
        }
        return _xifexpression;
      }
    };
    final Function1<ASTNode, StringBuffer> afterAnnotationProcessingCallback = _function;
    List _modifiers = it.modifiers();
    this.appendModifiers(it, _modifiers, afterAnnotationProcessingCallback);
    List _modifiers_1 = it.modifiers();
    Iterable<Modifier> _filter = Iterables.<Modifier>filter(_modifiers_1, Modifier.class);
    boolean _isPackageVisibility = this._aSTFlattenerUtils.isPackageVisibility(_filter);
    if (_isPackageVisibility) {
      ASTNode _parent = it.getParent();
      if ((_parent instanceof TypeDeclaration)) {
        ASTNode _parent_1 = it.getParent();
        boolean _isInterface = ((TypeDeclaration) _parent_1).isInterface();
        boolean _not = (!_isInterface);
        if (_not) {
          this.appendToBuffer("package ");
        }
      }
    }
    boolean _isConstructor = it.isConstructor();
    if (_isConstructor) {
      this.appendToBuffer(" new");
    }
    List _typeParameters = it.typeParameters();
    boolean _isEmpty = _typeParameters.isEmpty();
    boolean _not_1 = (!_isEmpty);
    if (_not_1) {
      boolean _isConstructor_1 = it.isConstructor();
      if (_isConstructor_1) {
        this.addProblem(it, "Type parameters for constructors are not supported");
      }
      List _typeParameters_1 = it.typeParameters();
      this.appendTypeParameters(_typeParameters_1);
    }
    boolean _isConstructor_2 = it.isConstructor();
    boolean _not_2 = (!_isConstructor_2);
    if (_not_2) {
      Type _returnType2 = it.getReturnType2();
      boolean _notEquals_1 = (!Objects.equal(_returnType2, null));
      if (_notEquals_1) {
        Type _returnType2_1 = it.getReturnType2();
        _returnType2_1.accept(this);
      } else {
        this.appendToBuffer("void");
      }
      this.appendSpaceToBuffer();
      SimpleName _name = it.getName();
      _name.accept(this);
    }
    this.appendToBuffer("(");
    List _parameters = it.parameters();
    List<SingleVariableDeclaration> _reverseView = ListExtensions.<SingleVariableDeclaration>reverseView(_parameters);
    final Procedure1<SingleVariableDeclaration> _function_1 = new Procedure1<SingleVariableDeclaration>() {
      @Override
      public void apply(final SingleVariableDeclaration p) {
        Block _body = it.getBody();
        SimpleName _name = p.getName();
        Boolean _isAssignedInBody = JavaASTFlattener.this._aSTFlattenerUtils.isAssignedInBody(_body, _name);
        if ((_isAssignedInBody).booleanValue()) {
          AST _aST = p.getAST();
          final VariableDeclarationFragment varFrag = _aST.newVariableDeclarationFragment();
          AST _aST_1 = p.getAST();
          SimpleName _name_1 = p.getName();
          String _string = _name_1.toString();
          SimpleName _newSimpleName = _aST_1.newSimpleName(_string);
          varFrag.setName(_newSimpleName);
          AST _aST_2 = p.getAST();
          SimpleName _name_2 = p.getName();
          String _plus = (_name_2 + "_finalParam_");
          SimpleName _newSimpleName_1 = _aST_2.newSimpleName(_plus);
          p.setName(_newSimpleName_1);
          AST _aST_3 = p.getAST();
          SimpleName _name_3 = p.getName();
          String _string_1 = _name_3.toString();
          SimpleName _newSimpleName_2 = _aST_3.newSimpleName(_string_1);
          varFrag.setInitializer(_newSimpleName_2);
          AST _aST_4 = p.getAST();
          final VariableDeclarationStatement varDecl = _aST_4.newVariableDeclarationStatement(varFrag);
          AST _aST_5 = p.getAST();
          ASTNode _createInstance = _aST_5.createInstance(SimpleType.class);
          final Type typeCopy = ((Type) _createInstance);
          varDecl.setType(typeCopy);
          Block _body_1 = it.getBody();
          List _statements = _body_1.statements();
          _statements.add(0, varDecl);
        }
      }
    };
    IterableExtensions.<SingleVariableDeclaration>forEach(_reverseView, _function_1);
    List _parameters_1 = it.parameters();
    this.visitAllSeparatedByComma(_parameters_1);
    this.appendToBuffer(")");
    int _extraDimensions = it.getExtraDimensions();
    this.appendExtraDimensions(_extraDimensions);
    List<? extends ASTNode> throwsTypes = CollectionLiterals.<ASTNode>newArrayList();
    boolean _java8orHigher = this.java8orHigher();
    boolean _not_3 = (!_java8orHigher);
    if (_not_3) {
      List _thrownExceptions = it.thrownExceptions();
      throwsTypes = _thrownExceptions;
    } else {
      List<ASTNode> _genericChildListProperty = this._aSTFlattenerUtils.genericChildListProperty(it, "thrownExceptionTypes");
      throwsTypes = _genericChildListProperty;
    }
    boolean _isEmpty_1 = throwsTypes.isEmpty();
    boolean _not_4 = (!_isEmpty_1);
    if (_not_4) {
      this.appendToBuffer(" throws ");
      this.visitAllSeparatedByComma(throwsTypes);
    }
    this.appendSpaceToBuffer();
    Block _body = it.getBody();
    boolean _notEquals_2 = (!Objects.equal(_body, null));
    if (_notEquals_2) {
      Block _body_1 = it.getBody();
      _body_1.accept(this);
    } else {
      this.appendLineWrapToBuffer();
    }
    return false;
  }
  
  @Override
  public boolean visit(final SingleVariableDeclaration it) {
    boolean _or = false;
    boolean _or_1 = false;
    ASTNode _parent = it.getParent();
    if ((_parent instanceof MethodDeclaration)) {
      _or_1 = true;
    } else {
      ASTNode _parent_1 = it.getParent();
      _or_1 = (_parent_1 instanceof CatchClause);
    }
    if (_or_1) {
      _or = true;
    } else {
      ASTNode _parent_2 = it.getParent();
      _or = (_parent_2 instanceof EnhancedForStatement);
    }
    if (_or) {
      List _modifiers = it.modifiers();
      Iterable<IExtendedModifier> _filter = Iterables.<IExtendedModifier>filter(_modifiers, IExtendedModifier.class);
      final Function1<IExtendedModifier, Boolean> _function = new Function1<IExtendedModifier, Boolean>() {
        @Override
        public Boolean apply(final IExtendedModifier it) {
          return Boolean.valueOf(it.isAnnotation());
        }
      };
      Iterable<IExtendedModifier> _filter_1 = IterableExtensions.<IExtendedModifier>filter(_filter, _function);
      this.appendModifiers(it, _filter_1);
    } else {
      List _modifiers_1 = it.modifiers();
      this.appendModifiers(it, _modifiers_1);
    }
    Type _type = it.getType();
    _type.accept(this);
    int _extraDimensions = it.getExtraDimensions();
    this.appendExtraDimensions(_extraDimensions);
    boolean _isVarargs = it.isVarargs();
    if (_isVarargs) {
      this.appendToBuffer("...");
    }
    this.appendSpaceToBuffer();
    SimpleName _name = it.getName();
    _name.accept(this);
    Expression _initializer = it.getInitializer();
    boolean _notEquals = (!Objects.equal(_initializer, null));
    if (_notEquals) {
      this.appendToBuffer("=");
      Expression _initializer_1 = it.getInitializer();
      _initializer_1.accept(this);
    }
    return false;
  }
  
  @Override
  public boolean visit(final ClassInstanceCreation node) {
    Expression _expression = node.getExpression();
    boolean _notEquals = (!Objects.equal(_expression, null));
    if (_notEquals) {
      Expression _expression_1 = node.getExpression();
      _expression_1.accept(this);
      this.appendToBuffer(".");
    }
    boolean _isLambdaCase = this._aSTFlattenerUtils.isLambdaCase(node);
    if (_isLambdaCase) {
      if (this.fallBackStrategy) {
        this.appendToBuffer("(");
      }
      this.appendToBuffer("[");
      AnonymousClassDeclaration _anonymousClassDeclaration = node.getAnonymousClassDeclaration();
      List _bodyDeclarations = _anonymousClassDeclaration.bodyDeclarations();
      Object _get = _bodyDeclarations.get(0);
      final MethodDeclaration method = ((MethodDeclaration) _get);
      List _parameters = method.parameters();
      boolean _isEmpty = _parameters.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        List _parameters_1 = method.parameters();
        this.visitAllSeparatedByComma(_parameters_1);
        this.appendToBuffer("|");
      } else {
        if (this.fallBackStrategy) {
          this.appendToBuffer("|");
        }
      }
      Block _body = method.getBody();
      List _statements = _body.statements();
      this.visitAll(_statements);
      this.appendToBuffer("]");
      if (this.fallBackStrategy) {
        this.appendToBuffer(" as ");
        List _typeArguments = node.typeArguments();
        boolean _isEmpty_1 = _typeArguments.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          List _typeArguments_1 = node.typeArguments();
          this.appendTypeParameters(_typeArguments_1);
        }
        Type _type = node.getType();
        _type.accept(this);
        this.appendToBuffer(")");
      }
    } else {
      this.appendToBuffer("new ");
      List _typeArguments_2 = node.typeArguments();
      boolean _isEmpty_2 = _typeArguments_2.isEmpty();
      boolean _not_2 = (!_isEmpty_2);
      if (_not_2) {
        List _typeArguments_3 = node.typeArguments();
        this.appendTypeParameters(_typeArguments_3);
      }
      Type _type_1 = node.getType();
      _type_1.accept(this);
      this.appendToBuffer("(");
      for (Iterator<Expression> it = node.arguments().iterator(); it.hasNext();) {
        {
          Expression e = it.next();
          e.accept(this);
          boolean _hasNext = it.hasNext();
          if (_hasNext) {
            this.appendToBuffer(",");
          }
        }
      }
      this.appendToBuffer(")");
      AnonymousClassDeclaration _anonymousClassDeclaration_1 = node.getAnonymousClassDeclaration();
      boolean _notEquals_1 = (!Objects.equal(_anonymousClassDeclaration_1, null));
      if (_notEquals_1) {
        AnonymousClassDeclaration _anonymousClassDeclaration_2 = node.getAnonymousClassDeclaration();
        _anonymousClassDeclaration_2.accept(this);
      }
    }
    return false;
  }
  
  @Override
  public boolean visit(final Block node) {
    this.appendToBuffer("{");
    this.increaseIndent();
    List _statements = node.statements();
    boolean _isEmpty = _statements.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      List _statements_1 = node.statements();
      final Procedure2<ASTNode, Integer> _function = new Procedure2<ASTNode, Integer>() {
        @Override
        public void apply(final ASTNode child, final Integer counter) {
          JavaASTFlattener.this.appendLineWrapToBuffer();
          child.accept(JavaASTFlattener.this);
        }
      };
      IterableExtensions.<ASTNode>forEach(_statements_1, _function);
    }
    ASTNode _root = node.getRoot();
    if ((_root instanceof CompilationUnit)) {
      ASTNode _root_1 = node.getRoot();
      final CompilationUnit cu = ((CompilationUnit) _root_1);
      Iterable<Comment> _unAssignedComments = this.unAssignedComments(cu);
      final Function1<Comment, Boolean> _function_1 = new Function1<Comment, Boolean>() {
        @Override
        public Boolean apply(final Comment it) {
          int _startPosition = it.getStartPosition();
          int _startPosition_1 = node.getStartPosition();
          int _length = node.getLength();
          int _plus = (_startPosition_1 + _length);
          return Boolean.valueOf((_startPosition < _plus));
        }
      };
      Iterable<Comment> _filter = IterableExtensions.<Comment>filter(_unAssignedComments, _function_1);
      final Procedure1<Comment> _function_2 = new Procedure1<Comment>() {
        @Override
        public void apply(final Comment it) {
          if ((!(it instanceof LineComment))) {
            JavaASTFlattener.this.appendLineWrapToBuffer();
          }
          it.accept(JavaASTFlattener.this);
          JavaASTFlattener.this.assignedComments.add(it);
        }
      };
      IterableExtensions.<Comment>forEach(_filter, _function_2);
    }
    this.decreaseIndent();
    this.appendLineWrapToBuffer();
    this.appendToBuffer("}");
    return false;
  }
  
  @Override
  public boolean visit(final CastExpression node) {
    Expression _expression = node.getExpression();
    _expression.accept(this);
    this.appendToBuffer(" as ");
    Type _type = node.getType();
    _type.accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final ExpressionStatement it) {
    Expression _expression = it.getExpression();
    _expression.accept(this);
    this.appendSpaceToBuffer();
    return false;
  }
  
  @Override
  public boolean visit(final MethodInvocation it) {
    Expression _expression = it.getExpression();
    boolean _notEquals = (!Objects.equal(_expression, null));
    if (_notEquals) {
      Expression _expression_1 = it.getExpression();
      _expression_1.accept(this);
      boolean _and = false;
      if (!this.fallBackStrategy) {
        _and = false;
      } else {
        boolean _isStaticMemberCall = this._aSTFlattenerUtils.isStaticMemberCall(it);
        _and = _isStaticMemberCall;
      }
      if (_and) {
        this.appendToBuffer("::");
      } else {
        this.appendToBuffer(".");
      }
    }
    List _typeArguments = it.typeArguments();
    boolean _isEmpty = _typeArguments.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      List _typeArguments_1 = it.typeArguments();
      this.appendTypeParameters(_typeArguments_1);
    }
    SimpleName _name = it.getName();
    _name.accept(this);
    this.appendToBuffer("(");
    List _arguments = it.arguments();
    this.visitAllSeparatedByComma(_arguments);
    this.appendToBuffer(")");
    return false;
  }
  
  @Override
  public boolean visit(final ForStatement it) {
    this.appendToBuffer("for (");
    List _initializers = it.initializers();
    this.visitAll(_initializers);
    this.appendToBuffer("; ");
    Expression _expression = it.getExpression();
    boolean _notEquals = (!Objects.equal(_expression, null));
    if (_notEquals) {
      Expression _expression_1 = it.getExpression();
      _expression_1.accept(this);
    }
    this.appendToBuffer("; ");
    List _updaters = it.updaters();
    this.visitAll(_updaters);
    this.appendToBuffer(") ");
    Statement _body = it.getBody();
    _body.accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final NullLiteral it) {
    this.appendToBuffer("null");
    return false;
  }
  
  @Override
  public boolean visit(final ThisExpression it) {
    Name _qualifier = it.getQualifier();
    boolean _notEquals = (!Objects.equal(_qualifier, null));
    if (_notEquals) {
      Name _qualifier_1 = it.getQualifier();
      _qualifier_1.accept(this);
      this.appendToBuffer(".");
    }
    this.appendToBuffer("this");
    return false;
  }
  
  @Override
  public boolean visit(final IfStatement node) {
    this.appendToBuffer("if (");
    Expression _expression = node.getExpression();
    _expression.accept(this);
    this.appendToBuffer(") ");
    Statement _thenStatement = node.getThenStatement();
    _thenStatement.accept(this);
    Statement _elseStatement = node.getElseStatement();
    boolean _notEquals = (!Objects.equal(_elseStatement, null));
    if (_notEquals) {
      this.appendToBuffer(" else ");
      Statement _elseStatement_1 = node.getElseStatement();
      _elseStatement_1.accept(this);
    }
    return false;
  }
  
  @Override
  public boolean visit(final FieldAccess it) {
    Expression _expression = it.getExpression();
    _expression.accept(this);
    boolean _and = false;
    if (!this.fallBackStrategy) {
      _and = false;
    } else {
      boolean _isStaticMemberCall = this._aSTFlattenerUtils.isStaticMemberCall(it);
      _and = _isStaticMemberCall;
    }
    if (_and) {
      this.appendToBuffer("::");
    } else {
      this.appendToBuffer(".");
    }
    SimpleName _name = it.getName();
    _name.accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final InfixExpression node) {
    final boolean useRichString = this._aSTFlattenerUtils.canConvertToRichText(node);
    if (useRichString) {
      ASTNode _parent = node.getParent();
      final boolean firstEntrance = (!(_parent instanceof InfixExpression));
      if (firstEntrance) {
        this.appendToBuffer("\'\'\'");
      }
      Expression _leftOperand = node.getLeftOperand();
      this.appendAsRichString(_leftOperand);
      Expression _rightOperand = node.getRightOperand();
      this.appendAsRichString(_rightOperand);
      List _extendedOperands = node.extendedOperands();
      Expression _rightOperand_1 = node.getRightOperand();
      final Function2<Expression, Expression, Expression> _function = new Function2<Expression, Expression, Expression>() {
        @Override
        public Expression apply(final Expression prevExpr, final Expression currExpr) {
          JavaASTFlattener.this.appendAsRichString(currExpr);
          return currExpr;
        }
      };
      IterableExtensions.<Expression, Expression>fold(_extendedOperands, _rightOperand_1, _function);
      if (firstEntrance) {
        this.appendToBuffer("\'\'\'");
        if (this.fallBackStrategy) {
          this.appendToBuffer(".toString");
        }
      }
    } else {
      Expression _leftOperand_1 = node.getLeftOperand();
      _leftOperand_1.accept(this);
      final InfixExpression.Operator operator = node.getOperator();
      Expression _rightOperand_2 = node.getRightOperand();
      this.handleInfixRightSide(node, operator, _rightOperand_2);
      final List extendedOperands = node.extendedOperands();
      int _size = extendedOperands.size();
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        final Procedure1<Expression> _function_1 = new Procedure1<Expression>() {
          @Override
          public void apply(final Expression e) {
            JavaASTFlattener.this.handleInfixRightSide(node, operator, e);
          }
        };
        IterableExtensions.<Expression>forEach(extendedOperands, _function_1);
      }
    }
    return false;
  }
  
  public StringBuffer handleInfixRightSide(final InfixExpression infixParent, final InfixExpression.Operator operator, final Expression rightSide) {
    StringBuffer _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(operator, InfixExpression.Operator.XOR)) {
        _matched=true;
        StringBuffer _xifexpression = null;
        boolean _isBooleanInvolved = this.isBooleanInvolved(infixParent);
        if (_isBooleanInvolved) {
          StringBuffer _xblockexpression = null;
          {
            this.appendToBuffer(".xor(");
            rightSide.accept(this);
            _xblockexpression = this.appendToBuffer(")");
          }
          _xifexpression = _xblockexpression;
        } else {
          StringBuffer _xblockexpression_1 = null;
          {
            this.appendToBuffer(".bitwiseXor(");
            rightSide.accept(this);
            _xblockexpression_1 = this.appendToBuffer(")");
          }
          _xifexpression = _xblockexpression_1;
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator, InfixExpression.Operator.AND)) {
        _matched=true;
      }
      if (!_matched) {
        if (Objects.equal(operator, InfixExpression.Operator.OR)) {
          _matched=true;
        }
      }
      if (_matched) {
        StringBuffer _xifexpression_1 = null;
        boolean _isBooleanInvolved_1 = this.isBooleanInvolved(infixParent);
        boolean _not = (!_isBooleanInvolved_1);
        if (_not) {
          StringBuffer _xblockexpression_2 = null;
          {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append(".bitwise");
            String _xifexpression_2 = null;
            boolean _equals = Objects.equal(operator, InfixExpression.Operator.AND);
            if (_equals) {
              _xifexpression_2 = "And";
            } else {
              _xifexpression_2 = "Or";
            }
            _builder.append(_xifexpression_2, "");
            _builder.append("(");
            this.appendToBuffer(_builder.toString());
            rightSide.accept(this);
            _xblockexpression_2 = this.appendToBuffer(")");
          }
          _xifexpression_1 = _xblockexpression_2;
        } else {
          this.appendSpaceToBuffer();
          String _string = operator.toString();
          String _multiply = this.operator_multiply(_string, 2);
          this.appendToBuffer(_multiply);
          this.appendSpaceToBuffer();
          rightSide.accept(this);
        }
        _switchResult = _xifexpression_1;
      }
    }
    if (!_matched) {
      if (Objects.equal(operator, InfixExpression.Operator.EQUALS)) {
        _matched=true;
        this.appendToBuffer(" === ");
        rightSide.accept(this);
      }
    }
    if (!_matched) {
      if (Objects.equal(operator, InfixExpression.Operator.NOT_EQUALS)) {
        _matched=true;
        this.appendToBuffer(" !== ");
        rightSide.accept(this);
      }
    }
    if (!_matched) {
      {
        this.appendSpaceToBuffer();
        String _string_1 = operator.toString();
        this.appendToBuffer(_string_1);
        this.appendSpaceToBuffer();
        rightSide.accept(this);
      }
    }
    return _switchResult;
  }
  
  public boolean isBooleanInvolved(final InfixExpression it) {
    boolean _or = false;
    Expression _leftOperand = it.getLeftOperand();
    boolean _isBooleanType = this.isBooleanType(_leftOperand);
    if (_isBooleanType) {
      _or = true;
    } else {
      Expression _rightOperand = it.getRightOperand();
      boolean _isBooleanType_1 = this.isBooleanType(_rightOperand);
      _or = _isBooleanType_1;
    }
    return _or;
  }
  
  public boolean isBooleanType(final Expression expression) {
    if ((expression instanceof BooleanLiteral)) {
      return true;
    }
    if ((expression instanceof SimpleName)) {
      final Type declType = this._aSTFlattenerUtils.findDeclaredType(((SimpleName)expression));
      boolean _notEquals = (!Objects.equal(declType, null));
      if (_notEquals) {
        boolean _matched = false;
        if (!_matched) {
          boolean _isPrimitiveType = declType.isPrimitiveType();
          if (_isPrimitiveType) {
            _matched=true;
            PrimitiveType.Code _primitiveTypeCode = ((PrimitiveType) declType).getPrimitiveTypeCode();
            return Objects.equal(_primitiveTypeCode, PrimitiveType.BOOLEAN);
          }
        }
      }
    }
    return false;
  }
  
  public void appendAsRichString(final Expression expression) {
    if ((expression instanceof StringLiteral)) {
      String _richTextValue = this.richTextValue(((StringLiteral)expression));
      this.appendToBuffer(_richTextValue);
    } else {
      boolean _and = false;
      if (!(expression instanceof InfixExpression)) {
        _and = false;
      } else {
        boolean _canConvertToRichText = this._aSTFlattenerUtils.canConvertToRichText(((InfixExpression) expression));
        _and = _canConvertToRichText;
      }
      final boolean stringConcat = _and;
      if ((!stringConcat)) {
        this.appendToBuffer("«");
      }
      expression.accept(this);
      if ((!stringConcat)) {
        this.appendToBuffer("»");
      }
    }
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
  
  @Override
  public boolean visit(final InstanceofExpression node) {
    Expression _leftOperand = node.getLeftOperand();
    _leftOperand.accept(this);
    this.appendToBuffer(" instanceof ");
    Type _rightOperand = node.getRightOperand();
    _rightOperand.accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final ReturnStatement node) {
    this.appendToBuffer("return");
    Expression _expression = node.getExpression();
    boolean _notEquals = (!Objects.equal(_expression, null));
    if (_notEquals) {
      this.appendSpaceToBuffer();
      Expression _expression_1 = node.getExpression();
      _expression_1.accept(this);
      this.appendSpaceToBuffer();
    } else {
      final ASTNode parent = node.getParent();
      boolean _and = false;
      if (!(parent instanceof IfStatement)) {
        _and = false;
      } else {
        Statement _elseStatement = ((IfStatement) parent).getElseStatement();
        boolean _tripleNotEquals = (_elseStatement != null);
        _and = _tripleNotEquals;
      }
      final boolean isIfElse = _and;
      if (((!isIfElse) && (!(parent instanceof SwitchStatement)))) {
        this.appendToBuffer(";");
      }
    }
    return false;
  }
  
  @Override
  public boolean visit(final BlockComment node) {
    boolean _notEquals = (!Objects.equal(this.javaSources, null));
    if (_notEquals) {
      String _commentContent = this.commentContent(node);
      this.appendToBuffer(_commentContent);
      boolean _shouldWrap = this.shouldWrap(node);
      if (_shouldWrap) {
        this.appendLineWrapToBuffer();
      }
    }
    return false;
  }
  
  private boolean shouldWrap(final BlockComment comment) {
    int _startPosition = comment.getStartPosition();
    int _length = comment.getLength();
    final int index = (_startPosition + _length);
    int _length_1 = this.javaSources.length();
    boolean _lessThan = (index < _length_1);
    if (_lessThan) {
      final char charAfterComment = this.javaSources.charAt(index);
      boolean _or = false;
      Character _valueOf = Character.valueOf('\n');
      boolean _equals = (charAfterComment == (_valueOf).charValue());
      if (_equals) {
        _or = true;
      } else {
        Character _valueOf_1 = Character.valueOf('\r');
        boolean _equals_1 = (charAfterComment == (_valueOf_1).charValue());
        _or = _equals_1;
      }
      if (_or) {
        return true;
      }
    }
    return false;
  }
  
  private String commentContent(final Comment comment) {
    int _startPosition = comment.getStartPosition();
    int _startPosition_1 = comment.getStartPosition();
    int _length = comment.getLength();
    int _plus = (_startPosition_1 + _length);
    return this.javaSources.substring(_startPosition, _plus);
  }
  
  @Override
  public boolean visit(final LineComment node) {
    boolean _notEquals = (!Objects.equal(this.javaSources, null));
    if (_notEquals) {
      String _commentContent = this.commentContent(node);
      this.appendToBuffer(_commentContent);
    }
    this.appendLineWrapToBuffer();
    return false;
  }
  
  @Override
  public boolean visit(final ParenthesizedExpression node) {
    this.appendToBuffer("(");
    Expression _expression = node.getExpression();
    _expression.accept(this);
    this.appendToBuffer(")");
    return false;
  }
  
  @Override
  public boolean visit(final PostfixExpression node) {
    AST _aST = node.getAST();
    int _apiLevel = _aST.apiLevel();
    final AST dummyAST = AST.newAST(_apiLevel);
    final PostfixExpression.Operator pfOperator = node.getOperator();
    Expression _operand = node.getOperand();
    if ((_operand instanceof ArrayAccess)) {
      Expression _operand_1 = node.getOperand();
      final ArrayAccess pfOperand = ((ArrayAccess) _operand_1);
      boolean _or = false;
      boolean _equals = Objects.equal(pfOperator, PostfixExpression.Operator.INCREMENT);
      if (_equals) {
        _or = true;
      } else {
        boolean _equals_1 = Objects.equal(pfOperator, PostfixExpression.Operator.DECREMENT);
        _or = _equals_1;
      }
      if (_or) {
        final String arrayName = this.computeArrayName(pfOperand);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("_postIndx_");
        _builder.append(arrayName, "");
        final String idxName = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("_postVal_");
        _builder_1.append(arrayName, "");
        final String tempVarName = _builder_1.toString();
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("{ var ");
        _builder_2.append(idxName, "");
        _builder_2.append("=");
        this.appendToBuffer(_builder_2.toString());
        Expression _index = pfOperand.getIndex();
        _index.accept(this);
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append(" ");
        _builder_3.append("var  ");
        this.appendToBuffer(_builder_3.toString());
        final VariableDeclarationFragment varDeclaration = dummyAST.newVariableDeclarationFragment();
        SimpleName _newSimpleName = dummyAST.newSimpleName(tempVarName);
        varDeclaration.setName(_newSimpleName);
        ASTNode _copySubtree = ASTNode.copySubtree(dummyAST, pfOperand);
        final ArrayAccess arrayAccess = ((ArrayAccess) _copySubtree);
        SimpleName _newSimpleName_1 = dummyAST.newSimpleName(idxName);
        arrayAccess.setIndex(_newSimpleName_1);
        varDeclaration.setInitializer(arrayAccess);
        varDeclaration.accept(this);
        final InfixExpression infixOp = dummyAST.newInfixExpression();
        SimpleName _newSimpleName_2 = dummyAST.newSimpleName(tempVarName);
        infixOp.setLeftOperand(_newSimpleName_2);
        PostfixExpression.Operator _operator = node.getOperator();
        boolean _equals_2 = Objects.equal(_operator, PostfixExpression.Operator.DECREMENT);
        if (_equals_2) {
          infixOp.setOperator(InfixExpression.Operator.MINUS);
        } else {
          infixOp.setOperator(InfixExpression.Operator.PLUS);
        }
        NumberLiteral _newNumberLiteral = dummyAST.newNumberLiteral("1");
        infixOp.setRightOperand(_newNumberLiteral);
        final Assignment assigment = dummyAST.newAssignment();
        ASTNode _copySubtree_1 = ASTNode.copySubtree(dummyAST, pfOperand);
        final ArrayAccess writeArray = ((ArrayAccess) _copySubtree_1);
        SimpleName _newSimpleName_3 = dummyAST.newSimpleName(idxName);
        writeArray.setIndex(_newSimpleName_3);
        assigment.setLeftHandSide(writeArray);
        ASTNode _copySubtree_2 = ASTNode.copySubtree(dummyAST, infixOp);
        assigment.setRightHandSide(((Expression) _copySubtree_2));
        assigment.accept(this);
        StringConcatenation _builder_4 = new StringConcatenation();
        String _xifexpression = null;
        boolean _needsReturnValue = this._aSTFlattenerUtils.needsReturnValue(node);
        if (_needsReturnValue) {
          _xifexpression = tempVarName;
        }
        _builder_4.append(_xifexpression, "");
        _builder_4.append(" }");
        this.appendToBuffer(_builder_4.toString());
        return false;
      }
    }
    Expression _operand_2 = node.getOperand();
    _operand_2.accept(this);
    String _string = pfOperator.toString();
    this.appendToBuffer(_string);
    return false;
  }
  
  @Override
  public boolean visit(final PrefixExpression node) {
    final Expression operand = node.getOperand();
    PrefixExpression.Operator _operator = node.getOperator();
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_operator, PrefixExpression.Operator.DECREMENT)) {
        _matched=true;
      }
      if (!_matched) {
        if (Objects.equal(_operator, PrefixExpression.Operator.INCREMENT)) {
          _matched=true;
        }
      }
      if (_matched) {
        if ((operand instanceof ArrayAccess)) {
          final String arrayName = this.computeArrayName(((ArrayAccess)operand));
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("_tPreInx_");
          _builder.append(arrayName, "");
          final String idxName = _builder.toString();
          String op = "-";
          PrefixExpression.Operator _operator_1 = node.getOperator();
          boolean _equals = Objects.equal(_operator_1, PrefixExpression.Operator.INCREMENT);
          if (_equals) {
            op = "+";
          }
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("{val ");
          _builder_1.append(idxName, "");
          _builder_1.append("=");
          this.appendToBuffer(_builder_1.toString());
          Expression _index = ((ArrayAccess)operand).getIndex();
          _index.accept(this);
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append(" ");
          _builder_2.append("val ");
          _builder_2.append(idxName, " ");
          _builder_2.append("_res=");
          _builder_2.append(arrayName, " ");
          _builder_2.append(".get(");
          _builder_2.append(idxName, " ");
          _builder_2.append(")");
          _builder_2.append(op, " ");
          _builder_2.append("1");
          this.appendToBuffer(_builder_2.toString());
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append(" ");
          _builder_3.append(arrayName, " ");
          _builder_3.append(".set(");
          _builder_3.append(idxName, " ");
          _builder_3.append(", ");
          _builder_3.append(idxName, " ");
          _builder_3.append("_res)  ");
          _builder_3.append(idxName, " ");
          _builder_3.append("_res}");
          this.appendToBuffer(_builder_3.toString());
          return false;
        } else {
          AST _aST = node.getAST();
          int _apiLevel = _aST.apiLevel();
          final AST dummyAST = AST.newAST(_apiLevel);
          final Assignment assigment = dummyAST.newAssignment();
          final InfixExpression infixOp = dummyAST.newInfixExpression();
          ASTNode _copySubtree = ASTNode.copySubtree(dummyAST, operand);
          infixOp.setLeftOperand(((Expression) _copySubtree));
          PrefixExpression.Operator _operator_2 = node.getOperator();
          boolean _equals_1 = Objects.equal(_operator_2, PrefixExpression.Operator.DECREMENT);
          if (_equals_1) {
            infixOp.setOperator(InfixExpression.Operator.MINUS);
          } else {
            infixOp.setOperator(InfixExpression.Operator.PLUS);
          }
          NumberLiteral _newNumberLiteral = dummyAST.newNumberLiteral("1");
          infixOp.setRightOperand(_newNumberLiteral);
          ASTNode _copySubtree_1 = ASTNode.copySubtree(dummyAST, operand);
          final Expression leftSide = ((Expression) _copySubtree_1);
          assigment.setLeftHandSide(leftSide);
          assigment.setRightHandSide(infixOp);
          this.appendToBuffer("{");
          Type type = null;
          if ((operand instanceof SimpleName)) {
            Type _findDeclaredType = this._aSTFlattenerUtils.findDeclaredType(((SimpleName)operand));
            type = _findDeclaredType;
          }
          this.handleAssignment(assigment, leftSide, type);
          this.appendToBuffer("}");
          return false;
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_operator, PrefixExpression.Operator.COMPLEMENT)) {
        _matched=true;
        Expression _operand = node.getOperand();
        _operand.accept(this);
        this.appendToBuffer(".bitwiseNot");
      }
    }
    if (!_matched) {
      {
        PrefixExpression.Operator _operator_3 = node.getOperator();
        String _string = _operator_3.toString();
        this.appendToBuffer(_string);
        Expression _operand_1 = node.getOperand();
        _operand_1.accept(this);
      }
    }
    return false;
  }
  
  @Override
  public boolean visit(final SingleMemberAnnotation node) {
    this.appendToBuffer("@");
    Name _typeName = node.getTypeName();
    _typeName.accept(this);
    this.appendToBuffer("(");
    Expression _value = node.getValue();
    _value.accept(this);
    this.appendToBuffer(")");
    return false;
  }
  
  @Override
  public boolean visit(final SuperConstructorInvocation node) {
    Expression _expression = node.getExpression();
    boolean _notEquals = (!Objects.equal(_expression, null));
    if (_notEquals) {
      Expression _expression_1 = node.getExpression();
      _expression_1.accept(this);
      this.appendToBuffer(".");
    }
    List _typeArguments = node.typeArguments();
    boolean _isEmpty = _typeArguments.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      List _typeArguments_1 = node.typeArguments();
      this.appendTypeParameters(_typeArguments_1);
    }
    this.appendToBuffer("super(");
    List _arguments = node.arguments();
    this.visitAllSeparatedByComma(_arguments);
    this.appendToBuffer(")");
    return false;
  }
  
  @Override
  public boolean visit(final SuperFieldAccess node) {
    Name _qualifier = node.getQualifier();
    boolean _notEquals = (!Objects.equal(_qualifier, null));
    if (_notEquals) {
      Name _qualifier_1 = node.getQualifier();
      _qualifier_1.accept(this);
      this.appendToBuffer(".");
    }
    this.appendToBuffer("super.");
    SimpleName _name = node.getName();
    _name.accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final SuperMethodInvocation node) {
    Name _qualifier = node.getQualifier();
    boolean _notEquals = (!Objects.equal(_qualifier, null));
    if (_notEquals) {
      Name _qualifier_1 = node.getQualifier();
      _qualifier_1.accept(this);
      this.appendToBuffer(".");
    }
    this.appendToBuffer("super.");
    List _typeArguments = node.typeArguments();
    boolean _isEmpty = _typeArguments.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      List _typeArguments_1 = node.typeArguments();
      this.appendTypeParameters(_typeArguments_1);
    }
    SimpleName _name = node.getName();
    _name.accept(this);
    this.appendToBuffer("(");
    List _arguments = node.arguments();
    this.visitAllSeparatedByComma(_arguments);
    this.appendToBuffer(")");
    return false;
  }
  
  @Override
  public boolean visit(final TagElement node) {
    boolean _isNested = node.isNested();
    if (_isNested) {
      this.appendToBuffer("{");
    } else {
      this.appendLineWrapToBuffer();
      this.appendToBuffer(" * ");
    }
    boolean previousRequiresWhiteSpace = false;
    String _tagName = node.getTagName();
    boolean _notEquals = (!Objects.equal(_tagName, null));
    if (_notEquals) {
      String _tagName_1 = node.getTagName();
      this.appendToBuffer(_tagName_1);
      previousRequiresWhiteSpace = true;
    }
    boolean previousRequiresNewLine = false;
    for (Iterator<? extends ASTNode> it = node.fragments().iterator(); it.hasNext();) {
      {
        ASTNode e = it.next();
        boolean currentIncludesWhiteSpace = (e instanceof TextElement);
        if ((previousRequiresNewLine && currentIncludesWhiteSpace)) {
          this.appendLineWrapToBuffer();
          this.appendToBuffer(" * ");
        }
        previousRequiresNewLine = currentIncludesWhiteSpace;
        if ((previousRequiresWhiteSpace && (!currentIncludesWhiteSpace))) {
          this.appendSpaceToBuffer();
        }
        e.accept(this);
        previousRequiresWhiteSpace = ((!currentIncludesWhiteSpace) && (!(e instanceof TagElement)));
      }
    }
    boolean _isNested_1 = node.isNested();
    if (_isNested_1) {
      this.appendToBuffer("}");
    }
    return false;
  }
  
  @Override
  public boolean visit(final TextElement node) {
    String _text = node.getText();
    this.appendToBuffer(_text);
    return false;
  }
  
  @Override
  public boolean visit(final TypeLiteral node) {
    if (this.fallBackStrategy) {
      this.appendToBuffer("typeof(");
    }
    Type _type = node.getType();
    _type.accept(this);
    if (this.fallBackStrategy) {
      this.appendToBuffer(")");
    }
    return false;
  }
  
  @Override
  public boolean visit(final ThrowStatement node) {
    this.appendToBuffer("throw ");
    Expression _expression = node.getExpression();
    _expression.accept(this);
    ASTNode _parent = node.getParent();
    boolean _not = (!(_parent instanceof Block));
    if (_not) {
      this.appendToBuffer(";");
    }
    return false;
  }
  
  @Override
  public boolean visit(final TryStatement node) {
    this.appendToBuffer("try ");
    final List<ASTNode> resources = this._aSTFlattenerUtils.genericChildListProperty(node, "resources");
    boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(resources);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      this.appendToBuffer("(");
      for (final ASTNode child : resources) {
        child.accept(this);
      }
      this.appendToBuffer(")");
      this.addProblem(node, "Try with resource is not yet supported.");
    }
    Block _body = node.getBody();
    _body.accept(this);
    List _catchClauses = node.catchClauses();
    final Procedure1<Object> _function = new Procedure1<Object>() {
      @Override
      public void apply(final Object it) {
        ((ASTNode) it).accept(JavaASTFlattener.this);
      }
    };
    IterableExtensions.<Object>forEach(_catchClauses, _function);
    Block _finally = node.getFinally();
    boolean _notEquals = (!Objects.equal(_finally, null));
    if (_notEquals) {
      this.appendToBuffer(" finally ");
      Block _finally_1 = node.getFinally();
      _finally_1.accept(this);
    } else {
      this.appendLineWrapToBuffer();
    }
    return false;
  }
  
  @Override
  public boolean visit(final TypeParameter node) {
    SimpleName _name = node.getName();
    _name.accept(this);
    List _typeBounds = node.typeBounds();
    boolean _isEmpty = _typeBounds.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.appendToBuffer(" extends ");
      for (Iterator<Type> _it = node.typeBounds().iterator(); _it.hasNext();) {
        {
          Type t = _it.next();
          t.accept(this);
          boolean _hasNext = _it.hasNext();
          if (_hasNext) {
            this.appendToBuffer(" & ");
          }
        }
      }
    }
    return false;
  }
  
  @Override
  public boolean visit(final NumberLiteral node) {
    String value = node.getToken();
    boolean _or = false;
    boolean _startsWith = value.startsWith("0x");
    if (_startsWith) {
      _or = true;
    } else {
      boolean _startsWith_1 = value.startsWith("0X");
      _or = _startsWith_1;
    }
    if (_or) {
      int _length = value.length();
      int _minus = (_length - 1);
      final char lastChar = value.charAt(_minus);
      String _string = Character.valueOf(lastChar).toString();
      String _lowerCase = _string.toLowerCase();
      boolean _equals = Objects.equal("l", _lowerCase);
      if (_equals) {
        int _length_1 = value.length();
        int _minus_1 = (_length_1 - 1);
        String _substring = value.substring(0, _minus_1);
        String _plus = (_substring + "#");
        String _plus_1 = (_plus + Character.valueOf(lastChar));
        value = _plus_1;
      }
      final int binExponent = value.indexOf("p");
      if ((binExponent >= 2)) {
        boolean _endsWith = value.endsWith("f");
        if (_endsWith) {
          Float _valueOf = Float.valueOf(value);
          String _string_1 = _valueOf.toString();
          String _plus_2 = (_string_1 + "f");
          value = _plus_2;
        } else {
          Double _valueOf_1 = Double.valueOf(value);
          String _string_2 = _valueOf_1.toString();
          value = _string_2;
        }
      }
    }
    this.appendToBuffer(value);
    return false;
  }
  
  @Override
  public boolean visit(final NormalAnnotation node) {
    this.appendToBuffer("@");
    Name _typeName = node.getTypeName();
    _typeName.accept(this);
    this.appendToBuffer("(");
    List _values = node.values();
    this.visitAllSeparatedByComma(_values);
    this.appendToBuffer(")");
    return false;
  }
  
  @Override
  public boolean visit(final CharacterLiteral node) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Character.valueOf(");
    String _escapedValue = node.getEscapedValue();
    _builder.append(_escapedValue, "");
    _builder.append(").charValue");
    this.appendToBuffer(_builder.toString());
    return false;
  }
  
  @Override
  public boolean visit(final WildcardType node) {
    this.appendToBuffer("?");
    Type bound = node.getBound();
    boolean _notEquals = (!Objects.equal(bound, null));
    if (_notEquals) {
      boolean _isUpperBound = node.isUpperBound();
      if (_isUpperBound) {
        this.appendToBuffer(" extends ");
      } else {
        this.appendToBuffer(" super ");
      }
      bound.accept(this);
    }
    return false;
  }
  
  @Override
  public boolean visit(final MemberValuePair node) {
    SimpleName _name = node.getName();
    _name.accept(this);
    this.appendToBuffer("=");
    Expression _value = node.getValue();
    _value.accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final WhileStatement node) {
    this.appendToBuffer("while (");
    Expression _expression = node.getExpression();
    _expression.accept(this);
    this.appendToBuffer(") ");
    Statement _body = node.getBody();
    _body.accept(this);
    return false;
  }
  
  /**
   * Start self Converted part
   */
  @Override
  public boolean visit(final AnnotationTypeDeclaration node) {
    Javadoc _javadoc = node.getJavadoc();
    boolean _notEquals = (!Objects.equal(_javadoc, null));
    if (_notEquals) {
      Javadoc _javadoc_1 = node.getJavadoc();
      _javadoc_1.accept(this);
    }
    List _modifiers = node.modifiers();
    this.appendModifiers(node, _modifiers);
    this.appendToBuffer("annotation ");
    SimpleName _name = node.getName();
    _name.accept(this);
    this.appendToBuffer(" {");
    this.appendLineWrapToBuffer();
    List _bodyDeclarations = node.bodyDeclarations();
    this.visitAll(_bodyDeclarations);
    this.appendToBuffer("}");
    return false;
  }
  
  @Override
  public boolean visit(final AnnotationTypeMemberDeclaration node) {
    Javadoc _javadoc = node.getJavadoc();
    boolean _notEquals = (!Objects.equal(_javadoc, null));
    if (_notEquals) {
      Javadoc _javadoc_1 = node.getJavadoc();
      _javadoc_1.accept(this);
    }
    List _modifiers = node.modifiers();
    this.appendModifiers(node, _modifiers);
    Type _type = node.getType();
    _type.accept(this);
    this.appendSpaceToBuffer();
    SimpleName _name = node.getName();
    _name.accept(this);
    Expression _default = node.getDefault();
    boolean _notEquals_1 = (!Objects.equal(_default, null));
    if (_notEquals_1) {
      this.appendToBuffer(" = ");
      Expression _default_1 = node.getDefault();
      _default_1.accept(this);
    }
    this.appendLineWrapToBuffer();
    return false;
  }
  
  @Override
  public boolean visit(final AnonymousClassDeclaration node) {
    this.appendToBuffer("{");
    this.increaseIndent();
    this.appendLineWrapToBuffer();
    List _bodyDeclarations = node.bodyDeclarations();
    this.visitAll(_bodyDeclarations);
    this.decreaseIndent();
    this.appendToBuffer("}");
    return false;
  }
  
  @Override
  public boolean visit(final ArrayAccess node) {
    Expression _index = node.getIndex();
    if ((_index instanceof NumberLiteral)) {
      Expression _array = node.getArray();
      _array.accept(this);
      this.appendToBuffer(".get(");
      Expression _index_1 = node.getIndex();
      _index_1.accept(this);
      this.appendToBuffer(")");
    } else {
      final String arrayname = this.computeArrayName(node);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{val _rdIndx_");
      _builder.append(arrayname, "");
      _builder.append("=");
      this.appendToBuffer(_builder.toString());
      Expression _index_2 = node.getIndex();
      _index_2.accept(this);
      this.appendSpaceToBuffer();
      Expression _array_1 = node.getArray();
      _array_1.accept(this);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(".get(_rdIndx_");
      _builder_1.append(arrayname, "");
      _builder_1.append(")}");
      this.appendToBuffer(_builder_1.toString());
    }
    return false;
  }
  
  public String computeArrayName(final ArrayAccess node) {
    String _switchResult = null;
    Expression _array = node.getArray();
    final Expression array = _array;
    boolean _matched = false;
    if (!_matched) {
      if (array instanceof SimpleName) {
        _matched=true;
        _switchResult = ((SimpleName)array).getIdentifier();
      }
    }
    if (!_matched) {
      if (array instanceof MethodInvocation) {
        _matched=true;
        SimpleName _name = ((MethodInvocation)array).getName();
        _switchResult = _name.getIdentifier();
      }
    }
    if (!_matched) {
      if (array instanceof ArrayAccess) {
        _matched=true;
        String _computeArrayName = this.computeArrayName(((ArrayAccess)array));
        _switchResult = ("_" + _computeArrayName);
      }
    }
    if (!_matched) {
      _switchResult = "tmpNode";
    }
    return _switchResult;
  }
  
  @Override
  public boolean visit(final ArrayCreation node) {
    ArrayType at = node.getType();
    int dims = at.getDimensions();
    if ((dims > 1)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/* FIXME Only one dimensional arrays are supported. ");
      _builder.append(node, "");
      _builder.append("*/");
      this.appendToBuffer(_builder.toString());
      this.addProblem(node, "Only one dimension arrays are supported.");
      return false;
    }
    ArrayInitializer _initializer = node.getInitializer();
    boolean _notEquals = (!Objects.equal(_initializer, null));
    if (_notEquals) {
      if (this.fallBackStrategy) {
        this.appendToBuffer("(");
      }
      ArrayInitializer _initializer_1 = node.getInitializer();
      _initializer_1.accept(this);
      if (this.fallBackStrategy) {
        this.appendToBuffer(" as ");
        at.accept(this);
        this.appendToBuffer(")");
      }
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("new");
      String _xifexpression = null;
      ArrayType _type = node.getType();
      Type _elementType = _type.getElementType();
      boolean _isPrimitiveType = _elementType.isPrimitiveType();
      if (_isPrimitiveType) {
        ArrayType _type_1 = node.getType();
        Type _elementType_1 = _type_1.getElementType();
        PrimitiveType.Code _primitiveTypeCode = ((PrimitiveType) _elementType_1).getPrimitiveTypeCode();
        String _string = _primitiveTypeCode.toString();
        _xifexpression = StringExtensions.toFirstUpper(_string);
      }
      _builder_1.append(_xifexpression, "");
      _builder_1.append("ArrayOfSize(");
      this.appendToBuffer(_builder_1.toString());
      List _dimensions = node.dimensions();
      Expression _get = ((Expression[])Conversions.unwrapArray(((Iterable<Expression>) _dimensions), Expression.class))[0];
      _get.accept(this);
      this.appendToBuffer(")");
    }
    return false;
  }
  
  @Override
  public boolean visit(final ArrayInitializer node) {
    this.appendToBuffer("#[");
    List _expressions = node.expressions();
    this.visitAllSeparatedByComma(_expressions);
    this.appendToBuffer("]");
    return false;
  }
  
  @Override
  public boolean visit(final ArrayType node) {
    boolean _java8orHigher = this.java8orHigher();
    boolean _not = (!_java8orHigher);
    if (_not) {
      Type _componentType = node.getComponentType();
      _componentType.accept(this);
      this.appendToBuffer("[]");
    } else {
      ASTNode _genericChildProperty = this._aSTFlattenerUtils.genericChildProperty(node, "elementType");
      if (_genericChildProperty!=null) {
        _genericChildProperty.accept(this);
      }
      List<ASTNode> dimensions = this._aSTFlattenerUtils.genericChildListProperty(node, "dimensions");
      boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(dimensions);
      boolean _not_1 = (!_isNullOrEmpty);
      if (_not_1) {
        final Procedure1<ASTNode> _function = new Procedure1<ASTNode>() {
          @Override
          public void apply(final ASTNode dim) {
            List<ASTNode> _genericChildListProperty = JavaASTFlattener.this._aSTFlattenerUtils.genericChildListProperty(dim, "annotations");
            if (_genericChildListProperty!=null) {
              JavaASTFlattener.this.visitAll(_genericChildListProperty);
            }
            JavaASTFlattener.this.appendToBuffer("[]");
          }
        };
        IterableExtensions.<ASTNode>forEach(dimensions, _function);
      }
    }
    return false;
  }
  
  @Override
  public boolean visit(final AssertStatement node) {
    this.appendToBuffer("if(!(");
    Expression _expression = node.getExpression();
    _expression.accept(this);
    this.appendToBuffer(")) {");
    this.appendToBuffer("throw new AssertionError(");
    Expression _message = node.getMessage();
    boolean _notEquals = (!Objects.equal(_message, null));
    if (_notEquals) {
      Expression _message_1 = node.getMessage();
      _message_1.accept(this);
    }
    this.appendToBuffer(")}");
    return false;
  }
  
  @Override
  public boolean visit(final BreakStatement node) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* FIXME Unsupported BreakStatement */ break");
    this.appendToBuffer(_builder.toString());
    this.addProblem(node, "Break statement is not supported");
    SimpleName _label = node.getLabel();
    boolean _notEquals = (!Objects.equal(_label, null));
    if (_notEquals) {
      this.appendSpaceToBuffer();
      SimpleName _label_1 = node.getLabel();
      _label_1.accept(this);
    }
    return false;
  }
  
  @Override
  public boolean visit(final CatchClause node) {
    SingleVariableDeclaration _exception = node.getException();
    Type _type = _exception.getType();
    int _nodeType = _type.getNodeType();
    boolean _tripleEquals = (_nodeType == 84);
    if (_tripleEquals) {
      SingleVariableDeclaration _exception_1 = node.getException();
      Type _type_1 = _exception_1.getType();
      List<ASTNode> _genericChildListProperty = this._aSTFlattenerUtils.genericChildListProperty(_type_1, "types");
      if (_genericChildListProperty!=null) {
        final Procedure2<ASTNode, Integer> _function = new Procedure2<ASTNode, Integer>() {
          @Override
          public void apply(final ASTNode child, final Integer index) {
            JavaASTFlattener.this.appendToBuffer(" catch (");
            child.accept(JavaASTFlattener.this);
            JavaASTFlattener.this.appendSpaceToBuffer();
            SingleVariableDeclaration _exception = node.getException();
            SimpleName _name = _exception.getName();
            String _simpleName = JavaASTFlattener.this._aSTFlattenerUtils.toSimpleName(_name);
            JavaASTFlattener.this.appendToBuffer(_simpleName);
            JavaASTFlattener.this.appendToBuffer(") ");
            Block _body = node.getBody();
            _body.accept(JavaASTFlattener.this);
          }
        };
        IterableExtensions.<ASTNode>forEach(_genericChildListProperty, _function);
      }
    } else {
      this.appendToBuffer(" catch (");
      SingleVariableDeclaration _exception_2 = node.getException();
      _exception_2.accept(this);
      this.appendToBuffer(") ");
      Block _body = node.getBody();
      _body.accept(this);
    }
    return false;
  }
  
  @Override
  public boolean visit(final ConstructorInvocation node) {
    List _typeArguments = node.typeArguments();
    boolean _isEmpty = _typeArguments.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      List _typeArguments_1 = node.typeArguments();
      this.appendTypeParameters(_typeArguments_1);
    }
    this.appendToBuffer("this(");
    List _arguments = node.arguments();
    this.visitAllSeparatedByComma(_arguments);
    this.appendToBuffer(")");
    return false;
  }
  
  @Override
  public boolean visit(final ContinueStatement node) {
    this.appendToBuffer("/* FIXME Unsupported continue statement */ continue");
    this.addProblem(node, "Continue statement is not supported");
    SimpleName _label = node.getLabel();
    boolean _notEquals = (!Objects.equal(_label, null));
    if (_notEquals) {
      this.appendSpaceToBuffer();
      SimpleName _label_1 = node.getLabel();
      _label_1.accept(this);
    }
    this.appendToBuffer(";");
    this.appendLineWrapToBuffer();
    return false;
  }
  
  @Override
  public boolean visit(final DoStatement node) {
    this.appendToBuffer("do ");
    Statement _body = node.getBody();
    _body.accept(this);
    this.appendToBuffer(" while (");
    Expression _expression = node.getExpression();
    _expression.accept(this);
    this.appendToBuffer(")");
    return false;
  }
  
  @Override
  public boolean visit(final EmptyStatement node) {
    this.appendToBuffer(";");
    return false;
  }
  
  @Override
  public boolean visit(final EnhancedForStatement node) {
    this.appendToBuffer("for (");
    SingleVariableDeclaration _parameter = node.getParameter();
    _parameter.accept(this);
    this.appendToBuffer(" : ");
    Expression _expression = node.getExpression();
    _expression.accept(this);
    this.appendToBuffer(") ");
    Statement _body = node.getBody();
    _body.accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final EnumConstantDeclaration node) {
    Javadoc _javadoc = node.getJavadoc();
    boolean _notEquals = (!Objects.equal(_javadoc, null));
    if (_notEquals) {
      Javadoc _javadoc_1 = node.getJavadoc();
      _javadoc_1.accept(this);
    }
    List _modifiers = node.modifiers();
    this.appendModifiers(node, _modifiers);
    SimpleName _name = node.getName();
    _name.accept(this);
    List _arguments = node.arguments();
    boolean _isEmpty = _arguments.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.addProblem(node, "Enum constant cannot have any arguments");
      this.appendToBuffer("(");
      List _arguments_1 = node.arguments();
      this.visitAllSeparatedByComma(_arguments_1);
      this.appendToBuffer(")");
    }
    AnonymousClassDeclaration _anonymousClassDeclaration = node.getAnonymousClassDeclaration();
    boolean _notEquals_1 = (!Objects.equal(_anonymousClassDeclaration, null));
    if (_notEquals_1) {
      this.addProblem(node, "Enum constant cannot have any anonymous class declarations");
      AnonymousClassDeclaration _anonymousClassDeclaration_1 = node.getAnonymousClassDeclaration();
      _anonymousClassDeclaration_1.accept(this);
    }
    return false;
  }
  
  @Override
  public boolean visit(final EnumDeclaration node) {
    Javadoc _javadoc = node.getJavadoc();
    boolean _notEquals = (!Objects.equal(_javadoc, null));
    if (_notEquals) {
      Javadoc _javadoc_1 = node.getJavadoc();
      _javadoc_1.accept(this);
    }
    List _modifiers = node.modifiers();
    this.appendModifiers(node, _modifiers);
    List _modifiers_1 = node.modifiers();
    Iterable<Modifier> _filter = Iterables.<Modifier>filter(_modifiers_1, Modifier.class);
    boolean _isPackageVisibility = this._aSTFlattenerUtils.isPackageVisibility(_filter);
    if (_isPackageVisibility) {
      this.appendToBuffer("package ");
    }
    this.appendToBuffer("enum ");
    SimpleName _name = node.getName();
    _name.accept(this);
    this.appendSpaceToBuffer();
    List _superInterfaceTypes = node.superInterfaceTypes();
    boolean _isEmpty = _superInterfaceTypes.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.addProblem(node, "Enum cannot have a supertype");
      this.appendToBuffer("implements ");
      List _superInterfaceTypes_1 = node.superInterfaceTypes();
      this.visitAllSeparatedByComma(_superInterfaceTypes_1);
      this.appendSpaceToBuffer();
    }
    this.appendToBuffer("{");
    this.increaseIndent();
    this.appendLineWrapToBuffer();
    List _enumConstants = node.enumConstants();
    this.visitAllSeparatedByComma(_enumConstants);
    List _bodyDeclarations = node.bodyDeclarations();
    boolean _isEmpty_1 = _bodyDeclarations.isEmpty();
    boolean _not_1 = (!_isEmpty_1);
    if (_not_1) {
      this.addProblem(node, "Enum cannot have any body declaration statements");
      this.appendToBuffer(";");
      this.appendLineWrapToBuffer();
      List _bodyDeclarations_1 = node.bodyDeclarations();
      this.visitAll(_bodyDeclarations_1);
    }
    this.decreaseIndent();
    this.appendToBuffer("}");
    return false;
  }
  
  @Override
  public boolean visit(final LabeledStatement node) {
    this.addProblem(node, "LabeledStatements are not supported");
    this.appendToBuffer("/*");
    SimpleName _label = node.getLabel();
    _label.accept(this);
    this.appendToBuffer(": */");
    Statement _body = node.getBody();
    _body.accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final MemberRef node) {
    Name _qualifier = node.getQualifier();
    boolean _notEquals = (!Objects.equal(_qualifier, null));
    if (_notEquals) {
      Name _qualifier_1 = node.getQualifier();
      _qualifier_1.accept(this);
    }
    this.appendToBuffer("#");
    SimpleName _name = node.getName();
    _name.accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final MethodRef node) {
    Name _qualifier = node.getQualifier();
    boolean _notEquals = (!Objects.equal(_qualifier, null));
    if (_notEquals) {
      Name _qualifier_1 = node.getQualifier();
      _qualifier_1.accept(this);
    }
    this.appendToBuffer("#");
    SimpleName _name = node.getName();
    _name.accept(this);
    this.appendToBuffer("(");
    List _parameters = node.parameters();
    this.visitAllSeparatedByComma(_parameters);
    this.appendToBuffer(")");
    return false;
  }
  
  @Override
  public boolean visit(final MethodRefParameter node) {
    Type _type = node.getType();
    _type.accept(this);
    boolean _isVarargs = node.isVarargs();
    if (_isVarargs) {
      this.appendToBuffer("...");
    }
    SimpleName _name = node.getName();
    boolean _notEquals = (!Objects.equal(_name, null));
    if (_notEquals) {
      this.appendSpaceToBuffer();
      SimpleName _name_1 = node.getName();
      _name_1.accept(this);
    }
    return false;
  }
  
  @Override
  public boolean visit(final QualifiedType node) {
    Type _qualifier = node.getQualifier();
    _qualifier.accept(this);
    this.appendToBuffer(".");
    SimpleName _name = node.getName();
    _name.accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final SwitchCase node) {
    this.appendLineWrapToBuffer();
    boolean _isDefault = node.isDefault();
    if (_isDefault) {
      this.appendToBuffer("default ");
    } else {
      this.appendToBuffer("case ");
      Expression _expression = node.getExpression();
      _expression.accept(this);
    }
    return false;
  }
  
  @Override
  public boolean visit(final SwitchStatement node) {
    this.appendLineWrapToBuffer();
    this.appendToBuffer("switch (");
    Expression _expression = node.getExpression();
    _expression.accept(this);
    this.appendToBuffer(") ");
    this.appendToBuffer("{");
    this.increaseIndent();
    List _statements = node.statements();
    LinkedHashMap<SwitchCase, ArrayList<Statement>> _newLinkedHashMap = CollectionLiterals.<SwitchCase, ArrayList<Statement>>newLinkedHashMap();
    final Function2<Map<SwitchCase, ArrayList<Statement>>, Statement, Map<SwitchCase, ArrayList<Statement>>> _function = new Function2<Map<SwitchCase, ArrayList<Statement>>, Statement, Map<SwitchCase, ArrayList<Statement>>>() {
      @Override
      public Map<SwitchCase, ArrayList<Statement>> apply(final Map<SwitchCase, ArrayList<Statement>> map, final Statement currStatement) {
        if ((currStatement instanceof SwitchCase)) {
          ArrayList<Statement> _newArrayList = CollectionLiterals.<Statement>newArrayList();
          map.put(((SwitchCase)currStatement), _newArrayList);
        } else {
          Set<SwitchCase> _keySet = map.keySet();
          SwitchCase _last = IterableExtensions.<SwitchCase>last(_keySet);
          ArrayList<Statement> _get = map.get(_last);
          _get.add(currStatement);
        }
        return map;
      }
    };
    final Map<SwitchCase, ArrayList<Statement>> foldedCases = IterableExtensions.<Statement, Map<SwitchCase, ArrayList<Statement>>>fold(_statements, _newLinkedHashMap, _function);
    final Procedure2<SwitchCase, ArrayList<Statement>> _function_1 = new Procedure2<SwitchCase, ArrayList<Statement>>() {
      @Override
      public void apply(final SwitchCase switchCase, final ArrayList<Statement> statements) {
        switchCase.accept(JavaASTFlattener.this);
        Set<SwitchCase> _keySet = foldedCases.keySet();
        SwitchCase _last = IterableExtensions.<SwitchCase>last(_keySet);
        final boolean isLastCase = switchCase.equals(_last);
        boolean _and = false;
        boolean _isEmpty = statements.isEmpty();
        if (!_isEmpty) {
          _and = false;
        } else {
          _and = (!isLastCase);
        }
        if (_and) {
          JavaASTFlattener.this.appendToBuffer(",");
        } else {
          JavaASTFlattener.this.appendToBuffer(":");
          boolean _or = false;
          Statement _last_1 = IterableExtensions.<Statement>last(statements);
          if ((_last_1 instanceof ReturnStatement)) {
            _or = true;
          } else {
            boolean _and_1 = false;
            Statement _last_2 = IterableExtensions.<Statement>last(statements);
            if (!(_last_2 instanceof Block)) {
              _and_1 = false;
            } else {
              Statement _last_3 = IterableExtensions.<Statement>last(statements);
              List _statements = ((Block) _last_3).statements();
              Object _last_4 = IterableExtensions.<Object>last(_statements);
              _and_1 = (_last_4 instanceof ReturnStatement);
            }
            _or = _and_1;
          }
          final boolean probablyReturns = _or;
          if (((!isLastCase) && (!probablyReturns))) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("/* FIXME unsupported fall-through */");
            JavaASTFlattener.this.appendToBuffer(_builder.toString());
            JavaASTFlattener.this.addProblem(node, "Unsupported fall-through case in switch expression");
          }
        }
        boolean _or_1 = false;
        boolean _and_2 = false;
        if (!isLastCase) {
          _and_2 = false;
        } else {
          boolean _isEmpty_1 = statements.isEmpty();
          _and_2 = _isEmpty_1;
        }
        if (_and_2) {
          _or_1 = true;
        } else {
          boolean _and_3 = false;
          boolean _isEmpty_2 = statements.isEmpty();
          boolean _not = (!_isEmpty_2);
          if (!_not) {
            _and_3 = false;
          } else {
            Statement _get = statements.get(0);
            boolean _not_1 = (!(_get instanceof Block));
            _and_3 = _not_1;
          }
          _or_1 = _and_3;
        }
        final boolean surround = _or_1;
        if (surround) {
          JavaASTFlattener.this.appendToBuffer("{");
          JavaASTFlattener.this.increaseIndent();
          JavaASTFlattener.this.appendLineWrapToBuffer();
        }
        JavaASTFlattener.this.visitAll(statements);
        if (surround) {
          JavaASTFlattener.this.decreaseIndent();
          JavaASTFlattener.this.appendLineWrapToBuffer();
          JavaASTFlattener.this.appendToBuffer("}");
        }
      }
    };
    MapExtensions.<SwitchCase, ArrayList<Statement>>forEach(foldedCases, _function_1);
    this.decreaseIndent();
    this.appendLineWrapToBuffer();
    this.appendToBuffer("}");
    return false;
  }
  
  @Override
  public boolean visit(final SynchronizedStatement node) {
    this.appendToBuffer("synchronized (");
    Expression _expression = node.getExpression();
    _expression.accept(this);
    this.appendToBuffer(") ");
    Block _body = node.getBody();
    _body.accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final TypeDeclarationStatement node) {
    boolean _isNotSupportedInnerType = this._aSTFlattenerUtils.isNotSupportedInnerType(node);
    if (_isNotSupportedInnerType) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/*FIXME Non-static inner classes are not supported. */");
      this.appendToBuffer(_builder.toString());
      this.addProblem(node, "Non-static inner classes are not supported.");
    }
    AbstractTypeDeclaration _declaration = node.getDeclaration();
    _declaration.accept(this);
    return false;
  }
  
  @Override
  public void preVisit(final ASTNode node) {
    boolean _or = false;
    if (((node instanceof Comment) || (node instanceof TagElement))) {
      _or = true;
    } else {
      _or = (node instanceof TextElement);
    }
    if (_or) {
      return;
    }
    ASTNode _root = node.getRoot();
    if ((_root instanceof CompilationUnit)) {
      ASTNode _root_1 = node.getRoot();
      final CompilationUnit cu = ((CompilationUnit) _root_1);
      Iterable<Comment> _unAssignedComments = this.unAssignedComments(cu);
      final Function1<Comment, Boolean> _function = new Function1<Comment, Boolean>() {
        @Override
        public Boolean apply(final Comment it) {
          int _startPosition = it.getStartPosition();
          int _startPosition_1 = node.getStartPosition();
          return Boolean.valueOf((_startPosition < _startPosition_1));
        }
      };
      Iterable<Comment> _filter = IterableExtensions.<Comment>filter(_unAssignedComments, _function);
      final Procedure1<Comment> _function_1 = new Procedure1<Comment>() {
        @Override
        public void apply(final Comment it) {
          it.accept(JavaASTFlattener.this);
          JavaASTFlattener.this.assignedComments.add(it);
        }
      };
      IterableExtensions.<Comment>forEach(_filter, _function_1);
    }
  }
  
  @Override
  public boolean preVisit2(final ASTNode node) {
    int _nodeType = node.getNodeType();
    boolean _tripleEquals = (_nodeType == 86);
    if (_tripleEquals) {
      this.preVisit(node);
      this.handleLambdaExpression(node);
      return false;
    }
    return super.preVisit2(node);
  }
  
  public boolean handleLambdaExpression(final ASTNode node) {
    this.appendToBuffer("[");
    final List<ASTNode> params = this._aSTFlattenerUtils.genericChildListProperty(node, "parameters");
    boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(params);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      this.visitAllSeparatedByComma(params);
      this.appendToBuffer(" | ");
    }
    ASTNode _genericChildProperty = this._aSTFlattenerUtils.genericChildProperty(node, "body");
    if (_genericChildProperty!=null) {
      _genericChildProperty.accept(this);
    }
    this.appendToBuffer("]");
    return false;
  }
  
  public String setJavaSources(final String javaSources) {
    return this.javaSources = javaSources;
  }
  
  /**
   * @param fallBackStrategy - if <code>true</code> ASTFlattener uses a strategy which is less error prone,<br>
   *  but in fact may produces more noisy syntax.
   */
  public boolean useFallBackStrategy(final boolean fallBackStrategy) {
    return this.fallBackStrategy = fallBackStrategy;
  }
  
  public String setTargetlevel(final String targetApiLevel) {
    return this.targetApiLevel = targetApiLevel;
  }
}
