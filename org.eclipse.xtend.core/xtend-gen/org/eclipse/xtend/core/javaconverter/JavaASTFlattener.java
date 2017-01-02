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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
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
    final int childrenCount = node.statements().size();
    if ((childrenCount > 0)) {
      final Procedure2<ASTNode, Integer> _function = (ASTNode child, Integer counter) -> {
        child.accept(this);
        this.appendLineWrapToBuffer();
      };
      IterableExtensions.<ASTNode>forEach(node.statements(), _function);
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
    final Procedure1<IExtendedModifier> _function = (IExtendedModifier p) -> {
      ((ASTNode) p).accept(this);
    };
    final Procedure1<IExtendedModifier> appender = _function;
    final Function1<IExtendedModifier, Boolean> _function_1 = (IExtendedModifier it) -> {
      return Boolean.valueOf((it.isAnnotation() && (!Objects.equal(((Annotation) it).getTypeName().toString(), "Override"))));
    };
    IterableExtensions.<IExtendedModifier>forEach(IterableExtensions.<IExtendedModifier>filter(ext, _function_1), appender);
    if ((callBack != null)) {
      callBack.apply(node);
    }
    final Function1<IExtendedModifier, Boolean> _function_2 = (IExtendedModifier it) -> {
      return Boolean.valueOf((it.isModifier() && (!Objects.equal(((Modifier) it).getKeyword().toString(), "default"))));
    };
    IterableExtensions.<IExtendedModifier>forEach(IterableExtensions.<IExtendedModifier>filter(ext, _function_2), appender);
  }
  
  private StringBuffer appendSpaceToBuffer() {
    return this.appendToBuffer(" ");
  }
  
  private StringBuffer appendLineWrapToBuffer() {
    StringBuffer _xblockexpression = null;
    {
      this.appendToBuffer(this.nl());
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
    _builder.append(string);
    _builder.append(" (start: ");
    int _startPosition = node.getStartPosition();
    _builder.append(_startPosition);
    _builder.append(", length: ");
    int _length = node.getLength();
    _builder.append(_length);
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
        type = this._aSTFlattenerUtils.findDeclaredType(((SimpleName) _array_1));
      }
      this.handleAssignment(node, ((ArrayAccess)leftSide), type);
    } else {
      if ((leftSide instanceof SimpleName)) {
        type = this._aSTFlattenerUtils.findDeclaredType(((SimpleName)leftSide));
      }
      this.handleAssignment(node, leftSide, type);
    }
    return false;
  }
  
  public void handleAssignment(final Assignment node, final ASTNode leftSide, final Type type) {
    leftSide.accept(this);
    this.appendToBuffer(node.getOperator().toString());
    this.handleRightHandSide(node, type);
  }
  
  public void handleAssignment(final Assignment node, final ArrayAccess leftSide, final Type type) {
    final String arrayName = this.computeArrayName(leftSide);
    this.appendToBuffer("{ ");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_wrVal_");
    _builder.append(arrayName);
    final String valName = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("_wrIndx_");
    _builder_1.append(arrayName);
    String idxName = _builder_1.toString();
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("val ");
    _builder_2.append(valName);
    _builder_2.append("=");
    this.appendToBuffer(_builder_2.toString());
    leftSide.getArray().accept(this);
    boolean _isConstantArrayIndex = this._aSTFlattenerUtils.isConstantArrayIndex(leftSide.getIndex());
    boolean _not = (!_isConstantArrayIndex);
    if (_not) {
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append(" ");
      _builder_3.append("val ");
      _builder_3.append(idxName, " ");
      _builder_3.append("=");
      this.appendToBuffer(_builder_3.toString());
      leftSide.getIndex().accept(this);
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
      leftSide.getIndex().accept(this);
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
      boolean _isConstantArrayIndex_1 = this._aSTFlattenerUtils.isConstantArrayIndex(leftSide.getIndex());
      boolean _not_1 = (!_isConstantArrayIndex_1);
      if (_not_1) {
        StringConcatenation _builder_7 = new StringConcatenation();
        _builder_7.append(idxName);
        this.appendToBuffer(_builder_7.toString());
      } else {
        leftSide.getIndex().accept(this);
      }
      this.appendToBuffer(")");
    }
    this.appendToBuffer("}");
  }
  
  public StringBuffer handleRightHandSide(final Assignment a, final Type type) {
    StringBuffer _xifexpression = null;
    if ((this._aSTFlattenerUtils.needPrimitiveCast(type) && (!(a.getRightHandSide() instanceof ArrayCreation)))) {
      StringBuffer _xblockexpression = null;
      {
        this.appendToBuffer("(");
        a.getRightHandSide().accept(this);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(") as ");
        _builder.append(type);
        _xblockexpression = this.appendToBuffer(_builder.toString());
      }
      _xifexpression = _xblockexpression;
    } else {
      a.getRightHandSide().accept(this);
    }
    return _xifexpression;
  }
  
  @Override
  public boolean visit(final MarkerAnnotation node) {
    this.appendToBuffer("@");
    node.getTypeName().accept(this);
    this.appendSpaceToBuffer();
    return false;
  }
  
  @Override
  public boolean visit(final CompilationUnit it) {
    boolean _isDummyType = this._aSTFlattenerUtils.isDummyType(IterableExtensions.<AbstractTypeDeclaration>head(it.types()));
    boolean _not = (!_isDummyType);
    if (_not) {
      PackageDeclaration _package = it.getPackage();
      if (_package!=null) {
        _package.accept(this);
      }
      this.visitAll(it.imports());
    }
    this.visitAll(it.types());
    return false;
  }
  
  @Override
  public boolean visit(final PackageDeclaration it) {
    Javadoc _javadoc = it.getJavadoc();
    boolean _tripleNotEquals = (_javadoc != null);
    if (_tripleNotEquals) {
      it.getJavadoc().accept(this);
    }
    this.visitAll(it.annotations(), " ");
    this.appendToBuffer("package ");
    it.getName().accept(this);
    this.appendLineWrapToBuffer();
    return false;
  }
  
  @Override
  public boolean visit(final ParameterizedType it) {
    it.getType().accept(this);
    this.appendTypeParameters(it.typeArguments());
    return false;
  }
  
  @Override
  public boolean visit(final PrimitiveType it) {
    this.appendToBuffer(it.getPrimitiveTypeCode().toString());
    return false;
  }
  
  @Override
  public boolean visit(final BooleanLiteral it) {
    this.appendToBuffer(String.valueOf(it.booleanValue()));
    return false;
  }
  
  @Override
  public boolean visit(final StringLiteral it) {
    final String handleOctal = it.getEscapedValue().replaceAll("\\\\([01234567])", "\\u000$1");
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
    it.getName().accept(this);
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
    boolean _tripleNotEquals = (_javadoc != null);
    if (_tripleNotEquals) {
      it.getJavadoc().accept(this);
    }
    this.appendModifiers(it, it.modifiers());
    boolean _isStatic = this._aSTFlattenerUtils.isStatic(it.modifiers());
    if (_isStatic) {
      if (((it.getParent() instanceof TypeDeclaration) && IterableExtensions.<FieldDeclaration>forall(IterableExtensions.<FieldDeclaration>filter(((Iterable<FieldDeclaration>)Conversions.doWrapArray(((TypeDeclaration) it.getParent()).getFields())), ((Function1<FieldDeclaration, Boolean>) (FieldDeclaration it_1) -> {
        return Boolean.valueOf((this._aSTFlattenerUtils.isStatic(it_1.modifiers()) && this._aSTFlattenerUtils.isFinal(it_1.modifiers())));
      })), ((Function1<FieldDeclaration, Boolean>) (FieldDeclaration f) -> {
        final Function1<VariableDeclarationFragment, Boolean> _function = (VariableDeclarationFragment fragment) -> {
          Boolean _isAssignedInBody = this._aSTFlattenerUtils.isAssignedInBody(it.getBody(), fragment);
          return Boolean.valueOf((!(_isAssignedInBody).booleanValue()));
        };
        return Boolean.valueOf(IterableExtensions.<VariableDeclarationFragment>forall(f.fragments(), _function));
      })))) {
        this.appendToBuffer(" final Void static_initializer = {");
        this.appendLineWrapToBuffer();
        it.getBody().accept(this);
        this.appendToBuffer("null }");
        this.appendLineWrapToBuffer();
      } else {
        this.addProblem(it, "Static initializer is not fully supported");
        this.appendToBuffer("{/*FIXME ");
        it.getBody().accept(this);
        this.appendToBuffer("*/}");
      }
    } else {
      ASTNode _parent = it.getParent();
      if ((_parent instanceof AnonymousClassDeclaration)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Initializer is not supported in ");
        String _simpleName = ASTNode.nodeClassForType(it.getParent().getNodeType()).getSimpleName();
        _builder.append(_simpleName);
        this.addProblem(it, _builder.toString());
      }
      it.getBody().accept(this);
    }
    return false;
  }
  
  @Override
  public boolean visit(final TypeDeclaration it) {
    boolean _isDummyType = this._aSTFlattenerUtils.isDummyType(it);
    if (_isDummyType) {
      this.visitAll(it.bodyDeclarations(), this.nl());
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
    boolean _tripleNotEquals = (_javadoc != null);
    if (_tripleNotEquals) {
      it.getJavadoc().accept(this);
    }
    this.appendModifiers(it, it.modifiers());
    boolean _isInterface = it.isInterface();
    if (_isInterface) {
      this.appendToBuffer("interface ");
    } else {
      boolean _isPackageVisibility = this._aSTFlattenerUtils.isPackageVisibility(Iterables.<Modifier>filter(it.modifiers(), Modifier.class));
      if (_isPackageVisibility) {
        this.appendToBuffer("package ");
      }
      this.appendToBuffer("class ");
    }
    it.getName().accept(this);
    boolean _isEmpty = it.typeParameters().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.appendTypeParameters(it.typeParameters());
    }
    this.appendSpaceToBuffer();
    Type _superclassType = it.getSuperclassType();
    boolean _tripleNotEquals_1 = (_superclassType != null);
    if (_tripleNotEquals_1) {
      this.appendToBuffer("extends ");
      it.getSuperclassType().accept(this);
      this.appendSpaceToBuffer();
    }
    boolean _isEmpty_1 = it.superInterfaceTypes().isEmpty();
    boolean _not_1 = (!_isEmpty_1);
    if (_not_1) {
      boolean _isInterface_1 = it.isInterface();
      if (_isInterface_1) {
        this.appendToBuffer("extends ");
      } else {
        this.appendToBuffer("implements ");
      }
      this.visitAllSeparatedByComma(it.superInterfaceTypes());
    }
    this.appendToBuffer("{");
    this.increaseIndent();
    BodyDeclaration prev = null;
    List _bodyDeclarations = it.bodyDeclarations();
    for (final BodyDeclaration body : ((Iterable<BodyDeclaration>) _bodyDeclarations)) {
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
      final Consumer<Comment> _function = (Comment it_1) -> {
        it_1.accept(this);
        this.assignedComments.add(it_1);
      };
      this.unAssignedComments(cu).forEach(_function);
    }
    this.decreaseIndent();
    this.appendLineWrapToBuffer();
    this.appendToBuffer("}");
    return false;
  }
  
  private Iterable<Comment> unAssignedComments(final CompilationUnit cu) {
    final Function1<Comment, Boolean> _function = (Comment c) -> {
      return Boolean.valueOf(((!(c.isDocComment() && (c.getParent() != null))) && this.notAssigned(c)));
    };
    return IterableExtensions.<Comment>filter(cu.getCommentList(), _function);
  }
  
  @Override
  public boolean visit(final Javadoc it) {
    this.appendToBuffer("/** ");
    this.visitAll(it.tags());
    this.appendLineWrapToBuffer();
    this.appendToBuffer(" */");
    this.appendLineWrapToBuffer();
    return false;
  }
  
  @Override
  public boolean visit(final SimpleName it) {
    String convertedName = this.converterService.toString(it.getIdentifier(), "ValidID");
    if (("it".equals(convertedName) && this._aSTFlattenerUtils.shouldConvertName(it))) {
      convertedName = ("renamed_" + convertedName);
    }
    this.appendToBuffer(convertedName);
    return false;
  }
  
  @Override
  public boolean visit(final QualifiedName it) {
    it.getQualifier().accept(this);
    if (((this.fallBackStrategy && this._aSTFlattenerUtils.isStaticMemberCall(it)) && 
      (!((it.getParent() instanceof SimpleType) || (it.getParent() instanceof ImportDeclaration))))) {
      this.appendToBuffer("::");
    } else {
      this.appendToBuffer(".");
    }
    it.getName().accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final SimpleType node) {
    return true;
  }
  
  @Override
  public boolean visit(final Modifier it) {
    boolean append = true;
    int _flagValue = it.getKeyword().toFlagValue();
    switch (_flagValue) {
      case Modifier.PUBLIC:
        if (((it.getParent() instanceof TypeDeclaration) || (it.getParent() instanceof MethodDeclaration))) {
          append = false;
        }
        break;
      case Modifier.PRIVATE:
        ASTNode _parent = it.getParent();
        if ((_parent instanceof FieldDeclaration)) {
          append = false;
        }
        break;
      case Modifier.FINAL:
        if (((it.getParent() instanceof VariableDeclarationExpression) || (it.getParent() instanceof VariableDeclarationStatement))) {
          append = false;
        }
        break;
      default:
        append = true;
        break;
    }
    if (append) {
      String valueToAppend = it.getKeyword().toString();
      int _flagValue_1 = it.getKeyword().toFlagValue();
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
    boolean _tripleNotEquals = (_javadoc != null);
    if (_tripleNotEquals) {
      it.getJavadoc().accept(this);
    }
    final Consumer<VariableDeclarationFragment> _function = (VariableDeclarationFragment frag) -> {
      this.appendModifiers(it, it.modifiers());
      boolean _isPackageVisibility = this._aSTFlattenerUtils.isPackageVisibility(Iterables.<Modifier>filter(it.modifiers(), Modifier.class));
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
      it.getType().accept(this);
      this.appendExtraDimensions(frag.getExtraDimensions());
      this.appendSpaceToBuffer();
      frag.accept(this);
    };
    it.fragments().forEach(_function);
    return false;
  }
  
  @Override
  public boolean visit(final VariableDeclarationExpression it) {
    final Procedure2<VariableDeclarationFragment, Integer> _function = (VariableDeclarationFragment frag, Integer counter) -> {
      this.appendModifiers(it, it.modifiers());
      this.appendToBuffer(this._aSTFlattenerUtils.handleVariableDeclaration(it.modifiers()));
      this.appendSpaceToBuffer();
      it.getType().accept(this);
      this.appendSpaceToBuffer();
      frag.accept(this);
      int _size = it.fragments().size();
      int _minus = (_size - 1);
      boolean _lessThan = ((counter).intValue() < _minus);
      if (_lessThan) {
        this.appendToBuffer(",");
        this.appendSpaceToBuffer();
      }
    };
    IterableExtensions.<VariableDeclarationFragment>forEach(it.fragments(), _function);
    return false;
  }
  
  @Override
  public boolean visit(final VariableDeclarationFragment it) {
    it.getName().accept(this);
    Expression _initializer = it.getInitializer();
    boolean _tripleNotEquals = (_initializer != null);
    if (_tripleNotEquals) {
      this.appendToBuffer("=");
      final Type type = this._aSTFlattenerUtils.findDeclaredType(it.getName());
      if ((this._aSTFlattenerUtils.needPrimitiveCast(type) && (!this.hasDimensions(it)))) {
        this.appendToBuffer("(");
        it.getInitializer().accept(this);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(") as ");
        _builder.append(type);
        this.appendToBuffer(_builder.toString());
      } else {
        it.getInitializer().accept(this);
      }
    } else {
      ASTNode _parent = it.getParent();
      if ((_parent instanceof VariableDeclarationStatement)) {
        ASTNode _parent_1 = it.getParent();
        boolean _isFinal = this._aSTFlattenerUtils.isFinal(((VariableDeclarationStatement) _parent_1).modifiers());
        if (_isFinal) {
          this.appendToBuffer("/* FIXME empty initializer for final variable is not supported */");
          this.addProblem(it, "Empty initializer for final variables is not supported.");
        }
      }
    }
    return false;
  }
  
  public boolean hasDimensions(final VariableDeclarationFragment fragment) {
    boolean _java8orHigher = this.java8orHigher();
    if (_java8orHigher) {
      List<ASTNode> dimensions = this._aSTFlattenerUtils.genericChildListProperty(fragment, "extraDimensions2");
      boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(dimensions);
      return (!_isNullOrEmpty);
    } else {
      int _extraDimensions = fragment.getExtraDimensions();
      return (_extraDimensions > 0);
    }
  }
  
  @Override
  public boolean visit(final ConditionalExpression node) {
    this.appendToBuffer("if (");
    node.getExpression().accept(this);
    this.appendToBuffer(") ");
    node.getThenExpression().accept(this);
    this.appendToBuffer(" else ");
    node.getElseExpression().accept(this);
    this.appendSpaceToBuffer();
    return false;
  }
  
  private StringBuffer appendExtraDimensions(final int extraDimensions) {
    String _multiply = this.operator_multiply("[]", extraDimensions);
    return this.appendToBuffer(_multiply);
  }
  
  @Override
  public boolean visit(final VariableDeclarationStatement it) {
    boolean _isEmpty = IterableExtensions.isEmpty(Iterables.<Annotation>filter(it.modifiers(), Annotation.class));
    final boolean hasAnnotations = (!_isEmpty);
    final Consumer<VariableDeclarationFragment> _function = (VariableDeclarationFragment frag) -> {
      if (hasAnnotations) {
        this.appendToBuffer("/*FIXME Cannot add Annotation to Variable declaration. Java code: ");
      }
      final Function1<ASTNode, StringBuffer> _function_1 = (ASTNode it_1) -> {
        StringBuffer _xifexpression = null;
        if (hasAnnotations) {
          StringBuffer _xblockexpression = null;
          {
            this.appendToBuffer("*/");
            _xblockexpression = this.appendLineWrapToBuffer();
          }
          _xifexpression = _xblockexpression;
        }
        return _xifexpression;
      };
      this.appendModifiers(it, it.modifiers(), _function_1);
      this.appendToBuffer(this._aSTFlattenerUtils.handleVariableDeclaration(it.modifiers()));
      this.appendSpaceToBuffer();
      boolean _isMissingType = this.isMissingType(it.getType());
      boolean _not = (!_isMissingType);
      if (_not) {
        it.getType().accept(this);
      }
      this.appendExtraDimensions(frag.getExtraDimensions());
      this.appendSpaceToBuffer();
      frag.accept(this);
      this.appendSpaceToBuffer();
    };
    it.fragments().forEach(_function);
    return false;
  }
  
  public boolean isMissingType(final Type type) {
    if ((type instanceof SimpleType)) {
      boolean _isSimpleName = ((SimpleType)type).getName().isSimpleName();
      if (_isSimpleName) {
        Name _name = ((SimpleType)type).getName();
        return "MISSING".equals(((SimpleName) _name).getIdentifier());
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
    final Procedure2<ASTNode, Integer> _function = (ASTNode node, Integer counter) -> {
      node.accept(this);
      if (((separator != null) && ((counter).intValue() < (IterableExtensions.size(iterable) - 1)))) {
        this.appendToBuffer(separator);
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
    boolean _tripleNotEquals = (_javadoc != null);
    if (_tripleNotEquals) {
      it.getJavadoc().accept(this);
    }
    final Function1<ASTNode, StringBuffer> _function = (ASTNode node) -> {
      StringBuffer _xifexpression = null;
      if ((node instanceof MethodDeclaration)) {
        StringBuffer _xifexpression_1 = null;
        boolean _isConstructor = ((MethodDeclaration)node).isConstructor();
        boolean _not = (!_isConstructor);
        if (_not) {
          StringBuffer _xifexpression_2 = null;
          boolean _isOverrideMethod = this._aSTFlattenerUtils.isOverrideMethod(((MethodDeclaration)node));
          if (_isOverrideMethod) {
            _xifexpression_2 = this.appendToBuffer("override ");
          } else {
            _xifexpression_2 = this.appendToBuffer("def ");
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      return _xifexpression;
    };
    final Function1<ASTNode, StringBuffer> afterAnnotationProcessingCallback = _function;
    this.appendModifiers(it, it.modifiers(), afterAnnotationProcessingCallback);
    boolean _isPackageVisibility = this._aSTFlattenerUtils.isPackageVisibility(Iterables.<Modifier>filter(it.modifiers(), Modifier.class));
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
    boolean _isEmpty = it.typeParameters().isEmpty();
    boolean _not_1 = (!_isEmpty);
    if (_not_1) {
      boolean _isConstructor_1 = it.isConstructor();
      if (_isConstructor_1) {
        this.addProblem(it, "Type parameters for constructors are not supported");
      }
      this.appendTypeParameters(it.typeParameters());
    }
    boolean _isConstructor_2 = it.isConstructor();
    boolean _not_2 = (!_isConstructor_2);
    if (_not_2) {
      Type _returnType2 = it.getReturnType2();
      boolean _tripleNotEquals_1 = (_returnType2 != null);
      if (_tripleNotEquals_1) {
        it.getReturnType2().accept(this);
      } else {
        this.appendToBuffer("void");
      }
      this.appendSpaceToBuffer();
      it.getName().accept(this);
    }
    this.appendToBuffer("(");
    final Consumer<SingleVariableDeclaration> _function_1 = (SingleVariableDeclaration p) -> {
      Boolean _isAssignedInBody = this._aSTFlattenerUtils.isAssignedInBody(it.getBody(), p.getName());
      if ((_isAssignedInBody).booleanValue()) {
        if ((it.isConstructor() && (!it.getBody().statements().isEmpty()))) {
          final Expression firstInBody = IterableExtensions.<Expression>head(this._aSTFlattenerUtils.findAssignmentsInBlock(it.getBody(), p));
          if ((firstInBody != null)) {
            ConstructorInvocation _findParentOfType = this._aSTFlattenerUtils.<ConstructorInvocation>findParentOfType(firstInBody, ConstructorInvocation.class);
            boolean _tripleNotEquals_2 = (_findParentOfType != null);
            if (_tripleNotEquals_2) {
              this.addProblem(p, "Final parameter modified in constructor call");
            } else {
              SuperConstructorInvocation _findParentOfType_1 = this._aSTFlattenerUtils.<SuperConstructorInvocation>findParentOfType(firstInBody, SuperConstructorInvocation.class);
              boolean _tripleNotEquals_3 = (_findParentOfType_1 != null);
              if (_tripleNotEquals_3) {
                this.addProblem(p, "Final parameter modified in super constructor call");
              }
            }
          }
        }
        final VariableDeclarationFragment varFrag = p.getAST().newVariableDeclarationFragment();
        varFrag.setName(p.getAST().newSimpleName(p.getName().toString()));
        AST _aST = p.getAST();
        SimpleName _name = p.getName();
        String _plus = (_name + "_finalParam_");
        p.setName(_aST.newSimpleName(_plus));
        varFrag.setInitializer(p.getAST().newSimpleName(p.getName().toString()));
        final VariableDeclarationStatement varDecl = p.getAST().newVariableDeclarationStatement(varFrag);
        ASTNode _createInstance = p.getAST().createInstance(SimpleType.class);
        final Type typeCopy = ((Type) _createInstance);
        varDecl.setType(typeCopy);
        it.getBody().statements().add(0, varDecl);
      }
    };
    ListExtensions.<SingleVariableDeclaration>reverseView(it.parameters()).forEach(_function_1);
    this.visitAllSeparatedByComma(it.parameters());
    this.appendToBuffer(")");
    this.appendExtraDimensions(it.getExtraDimensions());
    List<? extends ASTNode> throwsTypes = CollectionLiterals.<ASTNode>newArrayList();
    boolean _java8orHigher = this.java8orHigher();
    boolean _not_3 = (!_java8orHigher);
    if (_not_3) {
      throwsTypes = it.thrownExceptions();
    } else {
      throwsTypes = this._aSTFlattenerUtils.genericChildListProperty(it, "thrownExceptionTypes");
    }
    boolean _isEmpty_1 = throwsTypes.isEmpty();
    boolean _not_4 = (!_isEmpty_1);
    if (_not_4) {
      this.appendToBuffer(" throws ");
      this.visitAllSeparatedByComma(throwsTypes);
    }
    this.appendSpaceToBuffer();
    Block _body = it.getBody();
    boolean _tripleNotEquals_2 = (_body != null);
    if (_tripleNotEquals_2) {
      it.getBody().accept(this);
    } else {
      this.appendLineWrapToBuffer();
    }
    return false;
  }
  
  @Override
  public boolean visit(final SingleVariableDeclaration it) {
    if ((((it.getParent() instanceof MethodDeclaration) || (it.getParent() instanceof CatchClause)) || 
      (it.getParent() instanceof EnhancedForStatement))) {
      final Function1<IExtendedModifier, Boolean> _function = (IExtendedModifier it_1) -> {
        return Boolean.valueOf(it_1.isAnnotation());
      };
      this.appendModifiers(it, IterableExtensions.<IExtendedModifier>filter(Iterables.<IExtendedModifier>filter(it.modifiers(), IExtendedModifier.class), _function));
    } else {
      this.appendModifiers(it, it.modifiers());
    }
    it.getType().accept(this);
    this.appendExtraDimensions(it.getExtraDimensions());
    boolean _isVarargs = it.isVarargs();
    if (_isVarargs) {
      this.appendToBuffer("...");
    }
    this.appendSpaceToBuffer();
    it.getName().accept(this);
    Expression _initializer = it.getInitializer();
    boolean _tripleNotEquals = (_initializer != null);
    if (_tripleNotEquals) {
      this.appendToBuffer("=");
      it.getInitializer().accept(this);
    }
    return false;
  }
  
  @Override
  public boolean visit(final ClassInstanceCreation node) {
    Expression _expression = node.getExpression();
    boolean _tripleNotEquals = (_expression != null);
    if (_tripleNotEquals) {
      node.getExpression().accept(this);
      this.appendToBuffer(".");
    }
    boolean _isLambdaCase = this._aSTFlattenerUtils.isLambdaCase(node);
    if (_isLambdaCase) {
      if (this.fallBackStrategy) {
        this.appendToBuffer("(");
      }
      this.appendToBuffer("[");
      Object _get = node.getAnonymousClassDeclaration().bodyDeclarations().get(0);
      final MethodDeclaration method = ((MethodDeclaration) _get);
      boolean _isEmpty = method.parameters().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        this.visitAllSeparatedByComma(method.parameters());
        this.appendToBuffer("|");
      } else {
        if (this.fallBackStrategy) {
          this.appendToBuffer("|");
        }
      }
      this.visitAll(method.getBody().statements());
      this.appendToBuffer("]");
      if (this.fallBackStrategy) {
        this.appendToBuffer(" as ");
        boolean _isEmpty_1 = node.typeArguments().isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          this.appendTypeParameters(node.typeArguments());
        }
        node.getType().accept(this);
        this.appendToBuffer(")");
      }
    } else {
      this.appendToBuffer("new ");
      boolean _isEmpty_2 = node.typeArguments().isEmpty();
      boolean _not_2 = (!_isEmpty_2);
      if (_not_2) {
        this.appendTypeParameters(node.typeArguments());
      }
      node.getType().accept(this);
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
      AnonymousClassDeclaration _anonymousClassDeclaration = node.getAnonymousClassDeclaration();
      boolean _tripleNotEquals_1 = (_anonymousClassDeclaration != null);
      if (_tripleNotEquals_1) {
        node.getAnonymousClassDeclaration().accept(this);
      }
    }
    return false;
  }
  
  @Override
  public boolean visit(final Block node) {
    this.appendToBuffer("{");
    this.increaseIndent();
    boolean _isEmpty = node.statements().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Procedure2<ASTNode, Integer> _function = (ASTNode child, Integer counter) -> {
        this.appendLineWrapToBuffer();
        child.accept(this);
      };
      IterableExtensions.<ASTNode>forEach(node.statements(), _function);
    }
    ASTNode _root = node.getRoot();
    if ((_root instanceof CompilationUnit)) {
      ASTNode _root_1 = node.getRoot();
      final CompilationUnit cu = ((CompilationUnit) _root_1);
      final Function1<Comment, Boolean> _function_1 = (Comment it) -> {
        int _startPosition = it.getStartPosition();
        int _startPosition_1 = node.getStartPosition();
        int _length = node.getLength();
        int _plus = (_startPosition_1 + _length);
        return Boolean.valueOf((_startPosition < _plus));
      };
      final Consumer<Comment> _function_2 = (Comment it) -> {
        if ((!(it instanceof LineComment))) {
          this.appendLineWrapToBuffer();
        }
        it.accept(this);
        this.assignedComments.add(it);
      };
      IterableExtensions.<Comment>filter(this.unAssignedComments(cu), _function_1).forEach(_function_2);
    }
    this.decreaseIndent();
    this.appendLineWrapToBuffer();
    this.appendToBuffer("}");
    return false;
  }
  
  @Override
  public boolean visit(final CastExpression node) {
    ASTNode _parent = node.getParent();
    final boolean parantesis = (!(_parent instanceof Assignment));
    if (parantesis) {
      this.appendToBuffer("(");
    }
    node.getExpression().accept(this);
    this.appendToBuffer(" as ");
    node.getType().accept(this);
    if (parantesis) {
      this.appendToBuffer(")");
    }
    return false;
  }
  
  @Override
  public boolean visit(final ExpressionStatement it) {
    it.getExpression().accept(this);
    this.appendSpaceToBuffer();
    return false;
  }
  
  @Override
  public boolean visit(final MethodInvocation it) {
    Expression _expression = it.getExpression();
    boolean _tripleNotEquals = (_expression != null);
    if (_tripleNotEquals) {
      it.getExpression().accept(this);
      if ((this.fallBackStrategy && this._aSTFlattenerUtils.isStaticMemberCall(it))) {
        this.appendToBuffer("::");
      } else {
        this.appendToBuffer(".");
      }
    }
    boolean _isEmpty = it.typeArguments().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.appendTypeParameters(it.typeArguments());
    }
    it.getName().accept(this);
    this.appendToBuffer("(");
    this.visitAllSeparatedByComma(it.arguments());
    this.appendToBuffer(")");
    return false;
  }
  
  @Override
  public boolean visit(final ForStatement it) {
    this.appendToBuffer("for (");
    this.visitAll(it.initializers());
    this.appendToBuffer("; ");
    Expression _expression = it.getExpression();
    boolean _tripleNotEquals = (_expression != null);
    if (_tripleNotEquals) {
      it.getExpression().accept(this);
    }
    this.appendToBuffer("; ");
    this.visitAll(it.updaters());
    this.appendToBuffer(") ");
    it.getBody().accept(this);
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
    boolean _tripleNotEquals = (_qualifier != null);
    if (_tripleNotEquals) {
      it.getQualifier().accept(this);
      this.appendToBuffer(".");
    }
    this.appendToBuffer("this");
    return false;
  }
  
  @Override
  public boolean visit(final IfStatement node) {
    this.appendToBuffer("if (");
    node.getExpression().accept(this);
    this.appendToBuffer(") ");
    node.getThenStatement().accept(this);
    Statement _elseStatement = node.getElseStatement();
    boolean _tripleNotEquals = (_elseStatement != null);
    if (_tripleNotEquals) {
      this.appendToBuffer(" else ");
      node.getElseStatement().accept(this);
    }
    return false;
  }
  
  @Override
  public boolean visit(final FieldAccess it) {
    it.getExpression().accept(this);
    if ((this.fallBackStrategy && this._aSTFlattenerUtils.isStaticMemberCall(it))) {
      this.appendToBuffer("::");
    } else {
      this.appendToBuffer(".");
    }
    it.getName().accept(this);
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
      this.appendAsRichString(node.getLeftOperand());
      this.appendAsRichString(node.getRightOperand());
      final Function2<Expression, Expression, Expression> _function = (Expression prevExpr, Expression currExpr) -> {
        this.appendAsRichString(currExpr);
        return currExpr;
      };
      IterableExtensions.<Expression, Expression>fold(node.extendedOperands(), node.getRightOperand(), _function);
      if (firstEntrance) {
        this.appendToBuffer("\'\'\'");
        if (this.fallBackStrategy) {
          this.appendToBuffer(".toString");
        }
      }
    } else {
      node.getLeftOperand().accept(this);
      final InfixExpression.Operator operator = node.getOperator();
      this.handleInfixRightSide(node, operator, node.getRightOperand());
      final List extendedOperands = node.extendedOperands();
      int _size = extendedOperands.size();
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        final Consumer<Expression> _function_1 = (Expression e) -> {
          this.handleInfixRightSide(node, operator, e);
        };
        extendedOperands.forEach(_function_1);
      }
    }
    return false;
  }
  
  public StringBuffer handleInfixRightSide(final InfixExpression infixParent, final InfixExpression.Operator operator, final Expression rightSide) {
    StringBuffer _switchResult = null;
    boolean _matched = false;
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
            _builder.append(_xifexpression_2);
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
        this.appendToBuffer(operator.toString());
        this.appendSpaceToBuffer();
        rightSide.accept(this);
      }
    }
    return _switchResult;
  }
  
  public boolean isBooleanInvolved(final InfixExpression it) {
    return (this.isBooleanType(it.getLeftOperand()) || this.isBooleanType(it.getRightOperand()));
  }
  
  public boolean isBooleanType(final Expression expression) {
    if ((expression instanceof BooleanLiteral)) {
      return true;
    }
    if ((expression instanceof SimpleName)) {
      final Type declType = this._aSTFlattenerUtils.findDeclaredType(((SimpleName)expression));
      if ((declType != null)) {
        boolean _matched = false;
        boolean _isPrimitiveType = declType.isPrimitiveType();
        if (_isPrimitiveType) {
          _matched=true;
          PrimitiveType.Code _primitiveTypeCode = ((PrimitiveType) declType).getPrimitiveTypeCode();
          return Objects.equal(_primitiveTypeCode, PrimitiveType.BOOLEAN);
        }
      }
    }
    return false;
  }
  
  public void appendAsRichString(final Expression expression) {
    if ((expression instanceof StringLiteral)) {
      this.appendToBuffer(this.richTextValue(((StringLiteral)expression)));
    } else {
      final boolean stringConcat = ((expression instanceof InfixExpression) && 
        this._aSTFlattenerUtils.canConvertToRichText(((InfixExpression) expression)));
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
      value = value.concat("«»");
    }
    return value;
  }
  
  @Override
  public boolean visit(final InstanceofExpression node) {
    node.getLeftOperand().accept(this);
    this.appendToBuffer(" instanceof ");
    node.getRightOperand().accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final ReturnStatement node) {
    this.appendToBuffer("return");
    Expression _expression = node.getExpression();
    boolean _tripleNotEquals = (_expression != null);
    if (_tripleNotEquals) {
      this.appendSpaceToBuffer();
      node.getExpression().accept(this);
      this.appendSpaceToBuffer();
    } else {
      final ASTNode parent = node.getParent();
      final boolean isIfElse = ((parent instanceof IfStatement) && (((IfStatement) parent).getElseStatement() != null));
      if (((!isIfElse) && (!(parent instanceof SwitchStatement)))) {
        this.appendToBuffer(";");
      }
    }
    return false;
  }
  
  @Override
  public boolean visit(final BlockComment node) {
    if ((this.javaSources != null)) {
      this.appendToBuffer(this.commentContent(node));
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
      if (((charAfterComment == (Character.valueOf('\n')).charValue()) || (charAfterComment == (Character.valueOf('\r')).charValue()))) {
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
    if ((this.javaSources != null)) {
      this.appendToBuffer(this.commentContent(node));
    }
    this.appendLineWrapToBuffer();
    return false;
  }
  
  @Override
  public boolean visit(final ParenthesizedExpression node) {
    this.appendToBuffer("(");
    node.getExpression().accept(this);
    this.appendToBuffer(")");
    return false;
  }
  
  @Override
  public boolean visit(final PostfixExpression node) {
    final AST dummyAST = AST.newAST(node.getAST().apiLevel());
    final PostfixExpression.Operator pfOperator = node.getOperator();
    Expression _operand = node.getOperand();
    if ((_operand instanceof ArrayAccess)) {
      Expression _operand_1 = node.getOperand();
      final ArrayAccess pfOperand = ((ArrayAccess) _operand_1);
      if ((Objects.equal(pfOperator, PostfixExpression.Operator.INCREMENT) || 
        Objects.equal(pfOperator, PostfixExpression.Operator.DECREMENT))) {
        final String arrayName = this.computeArrayName(pfOperand);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("_postIndx_");
        _builder.append(arrayName);
        final String idxName = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("_postVal_");
        _builder_1.append(arrayName);
        final String tempVarName = _builder_1.toString();
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("{ var ");
        _builder_2.append(idxName);
        _builder_2.append("=");
        this.appendToBuffer(_builder_2.toString());
        pfOperand.getIndex().accept(this);
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append(" ");
        _builder_3.append("var  ");
        this.appendToBuffer(_builder_3.toString());
        final VariableDeclarationFragment varDeclaration = dummyAST.newVariableDeclarationFragment();
        varDeclaration.setName(dummyAST.newSimpleName(tempVarName));
        ASTNode _copySubtree = ASTNode.copySubtree(dummyAST, pfOperand);
        final ArrayAccess arrayAccess = ((ArrayAccess) _copySubtree);
        arrayAccess.setIndex(dummyAST.newSimpleName(idxName));
        varDeclaration.setInitializer(arrayAccess);
        varDeclaration.accept(this);
        final InfixExpression infixOp = dummyAST.newInfixExpression();
        infixOp.setLeftOperand(dummyAST.newSimpleName(tempVarName));
        PostfixExpression.Operator _operator = node.getOperator();
        boolean _equals = Objects.equal(_operator, PostfixExpression.Operator.DECREMENT);
        if (_equals) {
          infixOp.setOperator(InfixExpression.Operator.MINUS);
        } else {
          infixOp.setOperator(InfixExpression.Operator.PLUS);
        }
        infixOp.setRightOperand(dummyAST.newNumberLiteral("1"));
        final Assignment assigment = dummyAST.newAssignment();
        ASTNode _copySubtree_1 = ASTNode.copySubtree(dummyAST, pfOperand);
        final ArrayAccess writeArray = ((ArrayAccess) _copySubtree_1);
        writeArray.setIndex(dummyAST.newSimpleName(idxName));
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
        _builder_4.append(_xifexpression);
        _builder_4.append(" }");
        this.appendToBuffer(_builder_4.toString());
        return false;
      }
    }
    node.getOperand().accept(this);
    this.appendToBuffer(pfOperator.toString());
    return false;
  }
  
  @Override
  public boolean visit(final PrefixExpression node) {
    final Expression operand = node.getOperand();
    PrefixExpression.Operator _operator = node.getOperator();
    boolean _matched = false;
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
        _builder.append(arrayName);
        final String idxName = _builder.toString();
        String op = "-";
        PrefixExpression.Operator _operator_1 = node.getOperator();
        boolean _equals = Objects.equal(_operator_1, PrefixExpression.Operator.INCREMENT);
        if (_equals) {
          op = "+";
        }
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("{val ");
        _builder_1.append(idxName);
        _builder_1.append("=");
        this.appendToBuffer(_builder_1.toString());
        ((ArrayAccess)operand).getIndex().accept(this);
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
        final AST dummyAST = AST.newAST(node.getAST().apiLevel());
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
        infixOp.setRightOperand(dummyAST.newNumberLiteral("1"));
        ASTNode _copySubtree_1 = ASTNode.copySubtree(dummyAST, operand);
        final Expression leftSide = ((Expression) _copySubtree_1);
        assigment.setLeftHandSide(leftSide);
        assigment.setRightHandSide(infixOp);
        this.appendToBuffer("{");
        Type type = null;
        if ((operand instanceof SimpleName)) {
          type = this._aSTFlattenerUtils.findDeclaredType(((SimpleName)operand));
        }
        this.handleAssignment(assigment, leftSide, type);
        this.appendToBuffer("}");
        return false;
      }
    }
    if (!_matched) {
      if (Objects.equal(_operator, PrefixExpression.Operator.COMPLEMENT)) {
        _matched=true;
        node.getOperand().accept(this);
        this.appendToBuffer(".bitwiseNot");
      }
    }
    if (!_matched) {
      {
        this.appendToBuffer(node.getOperator().toString());
        node.getOperand().accept(this);
      }
    }
    return false;
  }
  
  @Override
  public boolean visit(final SingleMemberAnnotation node) {
    this.appendToBuffer("@");
    node.getTypeName().accept(this);
    this.appendToBuffer("(");
    node.getValue().accept(this);
    this.appendToBuffer(")");
    return false;
  }
  
  @Override
  public boolean visit(final SuperConstructorInvocation node) {
    Expression _expression = node.getExpression();
    boolean _tripleNotEquals = (_expression != null);
    if (_tripleNotEquals) {
      node.getExpression().accept(this);
      this.appendToBuffer(".");
    }
    boolean _isEmpty = node.typeArguments().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.appendTypeParameters(node.typeArguments());
    }
    this.appendToBuffer("super(");
    this.visitAllSeparatedByComma(node.arguments());
    this.appendToBuffer(")");
    return false;
  }
  
  @Override
  public boolean visit(final SuperFieldAccess node) {
    Name _qualifier = node.getQualifier();
    boolean _tripleNotEquals = (_qualifier != null);
    if (_tripleNotEquals) {
      node.getQualifier().accept(this);
      this.appendToBuffer(".");
    }
    this.appendToBuffer("super.");
    node.getName().accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final SuperMethodInvocation node) {
    Name _qualifier = node.getQualifier();
    boolean _tripleNotEquals = (_qualifier != null);
    if (_tripleNotEquals) {
      node.getQualifier().accept(this);
      this.appendToBuffer(".");
    }
    this.appendToBuffer("super.");
    boolean _isEmpty = node.typeArguments().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.appendTypeParameters(node.typeArguments());
    }
    node.getName().accept(this);
    this.appendToBuffer("(");
    this.visitAllSeparatedByComma(node.arguments());
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
    boolean _tripleNotEquals = (_tagName != null);
    if (_tripleNotEquals) {
      this.appendToBuffer(node.getTagName());
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
    this.appendToBuffer(node.getText());
    return false;
  }
  
  @Override
  public boolean visit(final TypeLiteral node) {
    if (this.fallBackStrategy) {
      this.appendToBuffer("typeof(");
    }
    node.getType().accept(this);
    if (this.fallBackStrategy) {
      this.appendToBuffer(")");
    }
    return false;
  }
  
  @Override
  public boolean visit(final ThrowStatement node) {
    this.appendToBuffer("throw ");
    node.getExpression().accept(this);
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
    node.getBody().accept(this);
    final Consumer<Object> _function = (Object it) -> {
      ((ASTNode) it).accept(this);
    };
    node.catchClauses().forEach(_function);
    Block _finally = node.getFinally();
    boolean _tripleNotEquals = (_finally != null);
    if (_tripleNotEquals) {
      this.appendToBuffer(" finally ");
      node.getFinally().accept(this);
    } else {
      this.appendLineWrapToBuffer();
    }
    return false;
  }
  
  @Override
  public boolean visit(final TypeParameter node) {
    node.getName().accept(this);
    boolean _isEmpty = node.typeBounds().isEmpty();
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
    if ((value.startsWith("0x") || value.startsWith("0X"))) {
      int _length = value.length();
      int _minus = (_length - 1);
      final char lastChar = value.charAt(_minus);
      String _lowerCase = Character.valueOf(lastChar).toString().toLowerCase();
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
          String _string = Float.valueOf(value).toString();
          String _plus_2 = (_string + "f");
          value = _plus_2;
        } else {
          value = Double.valueOf(value).toString();
        }
      }
    }
    this.appendToBuffer(value);
    return false;
  }
  
  @Override
  public boolean visit(final NormalAnnotation node) {
    this.appendToBuffer("@");
    node.getTypeName().accept(this);
    this.appendToBuffer("(");
    this.visitAllSeparatedByComma(node.values());
    this.appendToBuffer(")");
    return false;
  }
  
  @Override
  public boolean visit(final CharacterLiteral node) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Character.valueOf(");
    String _escapedValue = node.getEscapedValue();
    _builder.append(_escapedValue);
    _builder.append(").charValue");
    this.appendToBuffer(_builder.toString());
    return false;
  }
  
  @Override
  public boolean visit(final WildcardType node) {
    this.appendToBuffer("?");
    Type bound = node.getBound();
    if ((bound != null)) {
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
    node.getName().accept(this);
    this.appendToBuffer("=");
    node.getValue().accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final WhileStatement node) {
    this.appendToBuffer("while (");
    node.getExpression().accept(this);
    this.appendToBuffer(") ");
    node.getBody().accept(this);
    return false;
  }
  
  /**
   * Start self Converted part
   */
  @Override
  public boolean visit(final AnnotationTypeDeclaration node) {
    Javadoc _javadoc = node.getJavadoc();
    boolean _tripleNotEquals = (_javadoc != null);
    if (_tripleNotEquals) {
      node.getJavadoc().accept(this);
    }
    this.appendModifiers(node, node.modifiers());
    this.appendToBuffer("annotation ");
    node.getName().accept(this);
    this.appendToBuffer(" {");
    this.appendLineWrapToBuffer();
    this.visitAll(node.bodyDeclarations());
    this.appendToBuffer("}");
    return false;
  }
  
  @Override
  public boolean visit(final AnnotationTypeMemberDeclaration node) {
    Javadoc _javadoc = node.getJavadoc();
    boolean _tripleNotEquals = (_javadoc != null);
    if (_tripleNotEquals) {
      node.getJavadoc().accept(this);
    }
    this.appendModifiers(node, node.modifiers());
    node.getType().accept(this);
    this.appendSpaceToBuffer();
    node.getName().accept(this);
    Expression _default = node.getDefault();
    boolean _tripleNotEquals_1 = (_default != null);
    if (_tripleNotEquals_1) {
      this.appendToBuffer(" = ");
      node.getDefault().accept(this);
    }
    this.appendLineWrapToBuffer();
    return false;
  }
  
  @Override
  public boolean visit(final AnonymousClassDeclaration node) {
    this.appendToBuffer("{");
    this.increaseIndent();
    this.appendLineWrapToBuffer();
    this.visitAll(node.bodyDeclarations());
    this.decreaseIndent();
    this.appendToBuffer("}");
    return false;
  }
  
  @Override
  public boolean visit(final ArrayAccess node) {
    Expression _index = node.getIndex();
    if ((_index instanceof NumberLiteral)) {
      node.getArray().accept(this);
      this.appendToBuffer(".get(");
      node.getIndex().accept(this);
      this.appendToBuffer(")");
    } else {
      final String arrayname = this.computeArrayName(node);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{val _rdIndx_");
      _builder.append(arrayname);
      _builder.append("=");
      this.appendToBuffer(_builder.toString());
      node.getIndex().accept(this);
      this.appendSpaceToBuffer();
      node.getArray().accept(this);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(".get(_rdIndx_");
      _builder_1.append(arrayname);
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
    if (array instanceof SimpleName) {
      _matched=true;
      _switchResult = ((SimpleName)array).getIdentifier();
    }
    if (!_matched) {
      if (array instanceof MethodInvocation) {
        _matched=true;
        _switchResult = ((MethodInvocation)array).getName().getIdentifier();
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
      _builder.append(node);
      _builder.append("*/");
      this.appendToBuffer(_builder.toString());
      this.addProblem(node, "Only one dimension arrays are supported.");
      return false;
    }
    ArrayInitializer _initializer = node.getInitializer();
    boolean _tripleNotEquals = (_initializer != null);
    if (_tripleNotEquals) {
      if (this.fallBackStrategy) {
        this.appendToBuffer("(");
      }
      node.getInitializer().accept(this);
      if (this.fallBackStrategy) {
        this.appendToBuffer(" as ");
        at.accept(this);
        this.appendToBuffer(")");
      }
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("new");
      String _xifexpression = null;
      boolean _isPrimitiveType = node.getType().getElementType().isPrimitiveType();
      if (_isPrimitiveType) {
        Type _elementType = node.getType().getElementType();
        _xifexpression = StringExtensions.toFirstUpper(((PrimitiveType) _elementType).getPrimitiveTypeCode().toString());
      }
      _builder_1.append(_xifexpression);
      _builder_1.append("ArrayOfSize(");
      this.appendToBuffer(_builder_1.toString());
      List _dimensions = node.dimensions();
      ((Expression[])Conversions.unwrapArray(((Iterable<Expression>) _dimensions), Expression.class))[0].accept(this);
      this.appendToBuffer(")");
    }
    return false;
  }
  
  @Override
  public boolean visit(final ArrayInitializer node) {
    this.appendToBuffer("#[");
    this.visitAllSeparatedByComma(node.expressions());
    this.appendToBuffer("]");
    return false;
  }
  
  @Override
  public boolean visit(final ArrayType node) {
    boolean _java8orHigher = this.java8orHigher();
    boolean _not = (!_java8orHigher);
    if (_not) {
      node.getComponentType().accept(this);
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
        final Consumer<ASTNode> _function = (ASTNode dim) -> {
          List<ASTNode> _genericChildListProperty = this._aSTFlattenerUtils.genericChildListProperty(dim, "annotations");
          if (_genericChildListProperty!=null) {
            this.visitAll(_genericChildListProperty);
          }
          this.appendToBuffer("[]");
        };
        dimensions.forEach(_function);
      }
    }
    return false;
  }
  
  @Override
  public boolean visit(final AssertStatement node) {
    this.appendToBuffer("if(!(");
    node.getExpression().accept(this);
    this.appendToBuffer(")) {");
    this.appendToBuffer("throw new AssertionError(");
    Expression _message = node.getMessage();
    boolean _tripleNotEquals = (_message != null);
    if (_tripleNotEquals) {
      node.getMessage().accept(this);
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
    boolean _tripleNotEquals = (_label != null);
    if (_tripleNotEquals) {
      this.appendSpaceToBuffer();
      node.getLabel().accept(this);
    }
    return false;
  }
  
  @Override
  public boolean visit(final CatchClause node) {
    int _nodeType = node.getException().getType().getNodeType();
    boolean _tripleEquals = (_nodeType == 84);
    if (_tripleEquals) {
      List<ASTNode> _genericChildListProperty = this._aSTFlattenerUtils.genericChildListProperty(node.getException().getType(), "types");
      if (_genericChildListProperty!=null) {
        final Procedure2<ASTNode, Integer> _function = (ASTNode child, Integer index) -> {
          this.appendToBuffer(" catch (");
          child.accept(this);
          this.appendSpaceToBuffer();
          this.appendToBuffer(this._aSTFlattenerUtils.toSimpleName(node.getException().getName()));
          this.appendToBuffer(") ");
          node.getBody().accept(this);
        };
        IterableExtensions.<ASTNode>forEach(_genericChildListProperty, _function);
      }
    } else {
      this.appendToBuffer(" catch (");
      node.getException().accept(this);
      this.appendToBuffer(") ");
      node.getBody().accept(this);
    }
    return false;
  }
  
  @Override
  public boolean visit(final ConstructorInvocation node) {
    boolean _isEmpty = node.typeArguments().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.appendTypeParameters(node.typeArguments());
    }
    this.appendToBuffer("this(");
    this.visitAllSeparatedByComma(node.arguments());
    this.appendToBuffer(")");
    return false;
  }
  
  @Override
  public boolean visit(final ContinueStatement node) {
    this.appendToBuffer("/* FIXME Unsupported continue statement */ continue");
    this.addProblem(node, "Continue statement is not supported");
    SimpleName _label = node.getLabel();
    boolean _tripleNotEquals = (_label != null);
    if (_tripleNotEquals) {
      this.appendSpaceToBuffer();
      node.getLabel().accept(this);
    }
    this.appendToBuffer(";");
    this.appendLineWrapToBuffer();
    return false;
  }
  
  @Override
  public boolean visit(final DoStatement node) {
    this.appendToBuffer("do ");
    node.getBody().accept(this);
    this.appendToBuffer(" while (");
    node.getExpression().accept(this);
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
    node.getParameter().accept(this);
    this.appendToBuffer(" : ");
    node.getExpression().accept(this);
    this.appendToBuffer(") ");
    node.getBody().accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final EnumConstantDeclaration node) {
    Javadoc _javadoc = node.getJavadoc();
    boolean _tripleNotEquals = (_javadoc != null);
    if (_tripleNotEquals) {
      node.getJavadoc().accept(this);
    }
    this.appendModifiers(node, node.modifiers());
    node.getName().accept(this);
    boolean _isEmpty = node.arguments().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.addProblem(node, "Enum constant cannot have any arguments");
      this.appendToBuffer("(");
      this.visitAllSeparatedByComma(node.arguments());
      this.appendToBuffer(")");
    }
    AnonymousClassDeclaration _anonymousClassDeclaration = node.getAnonymousClassDeclaration();
    boolean _tripleNotEquals_1 = (_anonymousClassDeclaration != null);
    if (_tripleNotEquals_1) {
      this.addProblem(node, "Enum constant cannot have any anonymous class declarations");
      node.getAnonymousClassDeclaration().accept(this);
    }
    return false;
  }
  
  @Override
  public boolean visit(final EnumDeclaration node) {
    Javadoc _javadoc = node.getJavadoc();
    boolean _tripleNotEquals = (_javadoc != null);
    if (_tripleNotEquals) {
      node.getJavadoc().accept(this);
    }
    this.appendModifiers(node, node.modifiers());
    boolean _isPackageVisibility = this._aSTFlattenerUtils.isPackageVisibility(Iterables.<Modifier>filter(node.modifiers(), Modifier.class));
    if (_isPackageVisibility) {
      this.appendToBuffer("package ");
    }
    this.appendToBuffer("enum ");
    node.getName().accept(this);
    this.appendSpaceToBuffer();
    boolean _isEmpty = node.superInterfaceTypes().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.addProblem(node, "Enum cannot have a supertype");
      this.appendToBuffer("implements ");
      this.visitAllSeparatedByComma(node.superInterfaceTypes());
      this.appendSpaceToBuffer();
    }
    this.appendToBuffer("{");
    this.increaseIndent();
    this.appendLineWrapToBuffer();
    this.visitAllSeparatedByComma(node.enumConstants());
    boolean _isEmpty_1 = node.bodyDeclarations().isEmpty();
    boolean _not_1 = (!_isEmpty_1);
    if (_not_1) {
      this.addProblem(node, "Enum cannot have any body declaration statements");
      this.appendToBuffer(";");
      this.appendLineWrapToBuffer();
      this.visitAll(node.bodyDeclarations());
    }
    this.decreaseIndent();
    this.appendToBuffer("}");
    return false;
  }
  
  @Override
  public boolean visit(final LabeledStatement node) {
    this.addProblem(node, "LabeledStatements are not supported");
    this.appendToBuffer("/*");
    node.getLabel().accept(this);
    this.appendToBuffer(": */");
    node.getBody().accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final MemberRef node) {
    Name _qualifier = node.getQualifier();
    boolean _tripleNotEquals = (_qualifier != null);
    if (_tripleNotEquals) {
      node.getQualifier().accept(this);
    }
    this.appendToBuffer("#");
    node.getName().accept(this);
    return false;
  }
  
  @Override
  public boolean visit(final MethodRef node) {
    Name _qualifier = node.getQualifier();
    boolean _tripleNotEquals = (_qualifier != null);
    if (_tripleNotEquals) {
      node.getQualifier().accept(this);
    }
    this.appendToBuffer("#");
    node.getName().accept(this);
    this.appendToBuffer("(");
    this.visitAllSeparatedByComma(node.parameters());
    this.appendToBuffer(")");
    return false;
  }
  
  @Override
  public boolean visit(final MethodRefParameter node) {
    node.getType().accept(this);
    boolean _isVarargs = node.isVarargs();
    if (_isVarargs) {
      this.appendToBuffer("...");
    }
    SimpleName _name = node.getName();
    boolean _tripleNotEquals = (_name != null);
    if (_tripleNotEquals) {
      this.appendSpaceToBuffer();
      node.getName().accept(this);
    }
    return false;
  }
  
  @Override
  public boolean visit(final QualifiedType node) {
    node.getQualifier().accept(this);
    this.appendToBuffer(".");
    node.getName().accept(this);
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
      node.getExpression().accept(this);
    }
    return false;
  }
  
  @Override
  public boolean visit(final SwitchStatement node) {
    this.appendLineWrapToBuffer();
    this.appendToBuffer("switch (");
    node.getExpression().accept(this);
    this.appendToBuffer(") ");
    this.appendToBuffer("{");
    this.increaseIndent();
    final Function2<Map<SwitchCase, ArrayList<Statement>>, Statement, Map<SwitchCase, ArrayList<Statement>>> _function = (Map<SwitchCase, ArrayList<Statement>> map, Statement currStatement) -> {
      if ((currStatement instanceof SwitchCase)) {
        map.put(((SwitchCase)currStatement), CollectionLiterals.<Statement>newArrayList());
      } else {
        map.get(IterableExtensions.<SwitchCase>last(map.keySet())).add(currStatement);
      }
      return map;
    };
    final Map<SwitchCase, ArrayList<Statement>> foldedCases = IterableExtensions.<Statement, Map<SwitchCase, ArrayList<Statement>>>fold(node.statements(), 
      CollectionLiterals.<SwitchCase, ArrayList<Statement>>newLinkedHashMap(), _function);
    final BiConsumer<SwitchCase, ArrayList<Statement>> _function_1 = (SwitchCase switchCase, ArrayList<Statement> statements) -> {
      switchCase.accept(this);
      final boolean isLastCase = switchCase.equals(IterableExtensions.<SwitchCase>last(foldedCases.keySet()));
      if ((statements.isEmpty() && (!isLastCase))) {
        this.appendToBuffer(",");
      } else {
        this.appendToBuffer(":");
        final boolean probablyReturns = ((IterableExtensions.<Statement>last(statements) instanceof ReturnStatement) || 
          ((IterableExtensions.<Statement>last(statements) instanceof Block) && (IterableExtensions.<Object>last(((Block) IterableExtensions.<Statement>last(statements)).statements()) instanceof ReturnStatement)));
        if (((!isLastCase) && (!probablyReturns))) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("/* FIXME unsupported fall-through */");
          this.appendToBuffer(_builder.toString());
          this.addProblem(node, "Unsupported fall-through case in switch expression");
        }
      }
      final boolean surround = ((isLastCase && statements.isEmpty()) || ((!statements.isEmpty()) && (!(statements.get(0) instanceof Block))));
      if (surround) {
        this.appendToBuffer("{");
        this.increaseIndent();
        this.appendLineWrapToBuffer();
      }
      this.visitAll(statements);
      if (surround) {
        this.decreaseIndent();
        this.appendLineWrapToBuffer();
        this.appendToBuffer("}");
      }
    };
    foldedCases.forEach(_function_1);
    this.decreaseIndent();
    this.appendLineWrapToBuffer();
    this.appendToBuffer("}");
    return false;
  }
  
  @Override
  public boolean visit(final SynchronizedStatement node) {
    this.appendToBuffer("synchronized (");
    node.getExpression().accept(this);
    this.appendToBuffer(") ");
    node.getBody().accept(this);
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
    node.getDeclaration().accept(this);
    return false;
  }
  
  @Override
  public void preVisit(final ASTNode node) {
    if ((((node instanceof Comment) || (node instanceof TagElement)) || (node instanceof TextElement))) {
      return;
    }
    ASTNode _root = node.getRoot();
    if ((_root instanceof CompilationUnit)) {
      ASTNode _root_1 = node.getRoot();
      final CompilationUnit cu = ((CompilationUnit) _root_1);
      final Function1<Comment, Boolean> _function = (Comment it) -> {
        int _startPosition = it.getStartPosition();
        int _startPosition_1 = node.getStartPosition();
        return Boolean.valueOf((_startPosition < _startPosition_1));
      };
      final Consumer<Comment> _function_1 = (Comment it) -> {
        it.accept(this);
        this.assignedComments.add(it);
      };
      IterableExtensions.<Comment>filter(this.unAssignedComments(cu), _function).forEach(_function_1);
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
