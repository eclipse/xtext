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
import java.util.List;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.BooleanLiteral;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.Initializer;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.NullLiteral;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.TagElement;
import org.eclipse.jdt.core.dom.ThisExpression;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeParameter;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendASTFlattener extends ASTVisitor {
  /**
   * The string buffer into which the serialized representation of the AST is
   * written.
   */
  protected StringBuffer fBuffer;
  
  /**
   * Creates a new AST printer.
   */
  public XtendASTFlattener() {
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
   * Resets this printer so that it can be used again.
   */
  public void reset() {
    this.fBuffer.setLength(0);
  }
  
  public boolean visit(final CompilationUnit node) {
    PackageDeclaration _package = node.getPackage();
    boolean _notEquals = (!Objects.equal(_package, null));
    if (_notEquals) {
      PackageDeclaration _package_1 = node.getPackage();
      _package_1.accept(this);
    }
    List _imports = node.imports();
    final Procedure1<ImportDeclaration> _function = new Procedure1<ImportDeclaration>() {
      public void apply(final ImportDeclaration id) {
        id.accept(XtendASTFlattener.this);
      }
    };
    IterableExtensions.<ImportDeclaration>forEach(_imports, _function);
    List _types = node.types();
    final Procedure1<AbstractTypeDeclaration> _function_1 = new Procedure1<AbstractTypeDeclaration>() {
      public void apply(final AbstractTypeDeclaration td) {
        td.accept(XtendASTFlattener.this);
      }
    };
    IterableExtensions.<AbstractTypeDeclaration>forEach(_types, _function_1);
    return false;
  }
  
  public boolean visit(final PackageDeclaration node) {
    boolean _xblockexpression = false;
    {
      Javadoc _javadoc = node.getJavadoc();
      boolean _notEquals = (!Objects.equal(_javadoc, null));
      if (_notEquals) {
        Javadoc _javadoc_1 = node.getJavadoc();
        _javadoc_1.accept(this);
      }
      List _annotations = node.annotations();
      final Procedure1<Annotation> _function = new Procedure1<Annotation>() {
        public void apply(final Annotation it) {
          it.accept(XtendASTFlattener.this);
          XtendASTFlattener.this.appendSpaceToBuffer();
        }
      };
      IterableExtensions.<Annotation>forEach(_annotations, _function);
      this.appendToBuffer("package ");
      Name _name = node.getName();
      _name.accept(this);
      this.appendLineWrapToBuffer();
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean visit(final ParameterizedType node) {
    Type _type = node.getType();
    _type.accept(this);
    this.appendToBuffer("<");
    List _typeArguments = node.typeArguments();
    final Procedure2<Type, Integer> _function = new Procedure2<Type, Integer>() {
      public void apply(final Type it, final Integer counter) {
        it.accept(XtendASTFlattener.this);
        List _typeArguments = node.typeArguments();
        int _size = _typeArguments.size();
        int _minus = (_size - 1);
        boolean _lessThan = ((counter).intValue() < _minus);
        if (_lessThan) {
          XtendASTFlattener.this.appendToBuffer(", ");
        }
      }
    };
    IterableExtensions.<Type>forEach(_typeArguments, _function);
    this.appendToBuffer(">");
    return false;
  }
  
  public boolean visit(final PrimitiveType node) {
    boolean _xblockexpression = false;
    {
      PrimitiveType.Code _primitiveTypeCode = node.getPrimitiveTypeCode();
      String _string = _primitiveTypeCode.toString();
      this.appendToBuffer(_string);
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean visit(final BooleanLiteral node) {
    boolean _xblockexpression = false;
    {
      boolean _booleanValue = node.booleanValue();
      String _valueOf = String.valueOf(_booleanValue);
      this.appendToBuffer(_valueOf);
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean visit(final ImportDeclaration node) {
    boolean _xblockexpression = false;
    {
      this.appendToBuffer("import ");
      boolean _isStatic = node.isStatic();
      if (_isStatic) {
        this.appendToBuffer("static ");
      }
      Name _name = node.getName();
      _name.accept(this);
      boolean _isOnDemand = node.isOnDemand();
      if (_isOnDemand) {
        this.appendToBuffer(".*");
      }
      this.appendLineWrapToBuffer();
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean visit(final Initializer node) {
    boolean _xblockexpression = false;
    {
      Javadoc _javadoc = node.getJavadoc();
      boolean _notEquals = (!Objects.equal(_javadoc, null));
      if (_notEquals) {
        Javadoc _javadoc_1 = node.getJavadoc();
        _javadoc_1.accept(this);
      }
      List _modifiers = node.modifiers();
      this.printModifiers(_modifiers);
      Block _body = node.getBody();
      _body.accept(this);
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean visit(final TypeDeclaration node) {
    boolean _xblockexpression = false;
    {
      Javadoc _javadoc = node.getJavadoc();
      boolean _notEquals = (!Objects.equal(_javadoc, null));
      if (_notEquals) {
        Javadoc _javadoc_1 = node.getJavadoc();
        _javadoc_1.accept(this);
      }
      List _modifiers = node.modifiers();
      this.printModifiers(_modifiers);
      boolean _isInterface = node.isInterface();
      if (_isInterface) {
        this.appendToBuffer("interface ");
      } else {
        this.appendToBuffer("class ");
      }
      SimpleName _name = node.getName();
      _name.accept(this);
      List _typeParameters = node.typeParameters();
      boolean _isEmpty = _typeParameters.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        this.appendToBuffer("<");
        List _typeParameters_1 = node.typeParameters();
        final Procedure2<TypeParameter, Integer> _function = new Procedure2<TypeParameter, Integer>() {
          public void apply(final TypeParameter tp, final Integer counter) {
            tp.accept(XtendASTFlattener.this);
            List _typeParameters = node.typeParameters();
            int _size = _typeParameters.size();
            int _minus = (_size - 1);
            boolean _lessThan = ((counter).intValue() < _minus);
            if (_lessThan) {
              XtendASTFlattener.this.appendToBuffer(",");
            }
          }
        };
        IterableExtensions.<TypeParameter>forEach(_typeParameters_1, _function);
        this.appendToBuffer(">");
      }
      this.appendSpaceToBuffer();
      Type _superclassType = node.getSuperclassType();
      boolean _notEquals_1 = (!Objects.equal(_superclassType, null));
      if (_notEquals_1) {
        this.appendToBuffer("extends ");
        Type _superclassType_1 = node.getSuperclassType();
        _superclassType_1.accept(this);
        this.appendToBuffer(" ");
      }
      List _superInterfaceTypes = node.superInterfaceTypes();
      boolean _isEmpty_1 = _superInterfaceTypes.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        boolean _isInterface_1 = node.isInterface();
        if (_isInterface_1) {
          this.appendToBuffer("extends ");
        } else {
          this.appendToBuffer("implements ");
        }
        List _superInterfaceTypes_1 = node.superInterfaceTypes();
        final Procedure2<Type, Integer> _function_1 = new Procedure2<Type, Integer>() {
          public void apply(final Type it, final Integer counter) {
            it.accept(XtendASTFlattener.this);
            List _typeParameters = node.typeParameters();
            int _size = _typeParameters.size();
            int _minus = (_size - 1);
            boolean _lessThan = ((counter).intValue() < _minus);
            if (_lessThan) {
              XtendASTFlattener.this.appendToBuffer(", ");
            }
          }
        };
        IterableExtensions.<Type>forEach(_superInterfaceTypes_1, _function_1);
      }
      this.appendToBuffer("{");
      this.appendLineWrapToBuffer();
      BodyDeclaration prev = null;
      List _bodyDeclarations = node.bodyDeclarations();
      for (final BodyDeclaration body : ((List<BodyDeclaration>) _bodyDeclarations)) {
        {
          if ((prev instanceof EnumConstantDeclaration)) {
            if ((body instanceof EnumConstantDeclaration)) {
              this.appendToBuffer(", ");
            } else {
              this.appendToBuffer("; ");
            }
          }
          body.accept(this);
          prev = body;
        }
      }
      this.appendLineWrapToBuffer();
      this.appendToBuffer("}");
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean visit(final Javadoc node) {
    boolean _xblockexpression = false;
    {
      this.appendToBuffer("/** ");
      List _tags = node.tags();
      final Procedure1<TagElement> _function = new Procedure1<TagElement>() {
        public void apply(final TagElement it) {
          it.accept(XtendASTFlattener.this);
        }
      };
      IterableExtensions.<TagElement>forEach(_tags, _function);
      this.appendToBuffer("\n */");
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean visit(final SimpleName node) {
    boolean _xblockexpression = false;
    {
      boolean _isKeyword = this.isKeyword(node);
      if (_isKeyword) {
        this.appendToBuffer("_");
      }
      String _identifier = node.getIdentifier();
      this.appendToBuffer(_identifier);
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean isKeyword(final SimpleName name) {
    String _identifier = name.getIdentifier();
    return Objects.equal("it", _identifier);
  }
  
  public boolean visit(final QualifiedName node) {
    Name _qualifier = node.getQualifier();
    _qualifier.accept(this);
    this.appendToBuffer(".");
    SimpleName _name = node.getName();
    _name.accept(this);
    return false;
  }
  
  public boolean visit(final Modifier node) {
    boolean _xblockexpression = false;
    {
      boolean append = true;
      Modifier.ModifierKeyword _keyword = node.getKeyword();
      int _flagValue = _keyword.toFlagValue();
      switch (_flagValue) {
        case Modifier.PUBLIC:
          boolean _or = false;
          ASTNode _parent = node.getParent();
          if ((_parent instanceof TypeDeclaration)) {
            _or = true;
          } else {
            ASTNode _parent_1 = node.getParent();
            _or = (_parent_1 instanceof MethodDeclaration);
          }
          if (_or) {
            append = false;
          }
          break;
        case Modifier.PRIVATE:
          ASTNode _parent_2 = node.getParent();
          if ((_parent_2 instanceof FieldDeclaration)) {
            append = false;
          }
          break;
        default:
          append = true;
          break;
      }
      if (append) {
        Modifier.ModifierKeyword _keyword_1 = node.getKeyword();
        String _string = _keyword_1.toString();
        this.appendToBuffer(_string);
        this.appendSpaceToBuffer();
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean visit(final FieldDeclaration node) {
    boolean _xblockexpression = false;
    {
      Javadoc _javadoc = node.getJavadoc();
      boolean _notEquals = (!Objects.equal(_javadoc, null));
      if (_notEquals) {
        Javadoc _javadoc_1 = node.getJavadoc();
        _javadoc_1.accept(this);
      }
      List _modifiers = node.modifiers();
      this.printModifiers(_modifiers);
      Type _type = node.getType();
      _type.accept(this);
      this.appendSpaceToBuffer();
      List _fragments = node.fragments();
      final Procedure2<VariableDeclarationFragment, Integer> _function = new Procedure2<VariableDeclarationFragment, Integer>() {
        public void apply(final VariableDeclarationFragment it, final Integer counter) {
          it.accept(XtendASTFlattener.this);
          List _fragments = node.fragments();
          int _size = _fragments.size();
          int _minus = (_size - 1);
          boolean _lessThan = ((counter).intValue() < _minus);
          if (_lessThan) {
            XtendASTFlattener.this.appendToBuffer(", ");
          }
        }
      };
      IterableExtensions.<VariableDeclarationFragment>forEach(_fragments, _function);
      this.appendLineWrapToBuffer();
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean visit(final VariableDeclarationExpression node) {
    boolean _xblockexpression = false;
    {
      List _modifiers = node.modifiers();
      this.printModifiers(_modifiers);
      this.appendToBuffer("var ");
      Type _type = node.getType();
      _type.accept(this);
      this.appendToBuffer(" ");
      List _fragments = node.fragments();
      final Procedure2<VariableDeclarationFragment, Integer> _function = new Procedure2<VariableDeclarationFragment, Integer>() {
        public void apply(final VariableDeclarationFragment it, final Integer counter) {
          it.accept(XtendASTFlattener.this);
          List _fragments = node.fragments();
          int _size = _fragments.size();
          int _minus = (_size - 1);
          boolean _lessThan = ((counter).intValue() < _minus);
          if (_lessThan) {
            XtendASTFlattener.this.appendToBuffer(", ");
          }
        }
      };
      IterableExtensions.<VariableDeclarationFragment>forEach(_fragments, _function);
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean visit(final VariableDeclarationFragment node) {
    SimpleName _name = node.getName();
    _name.accept(this);
    int _extraDimensions = node.getExtraDimensions();
    this.appendExtraDimensions(_extraDimensions);
    Expression _initializer = node.getInitializer();
    boolean _notEquals = (!Objects.equal(_initializer, null));
    if (_notEquals) {
      this.appendToBuffer("=");
      Expression _initializer_1 = node.getInitializer();
      _initializer_1.accept(this);
    }
    return false;
  }
  
  private void appendExtraDimensions(final int extraDimensions) {
    for (int i = 0; (i < extraDimensions); i++) {
      this.appendToBuffer("[]");
    }
  }
  
  public boolean visit(final VariableDeclarationStatement node) {
    List _modifiers = node.modifiers();
    this.printModifiers(_modifiers);
    this.appendToBuffer("var ");
    Type _type = node.getType();
    _type.accept(this);
    this.appendToBuffer(" ");
    List _fragments = node.fragments();
    final Procedure2<VariableDeclarationFragment, Integer> _function = new Procedure2<VariableDeclarationFragment, Integer>() {
      public void apply(final VariableDeclarationFragment it, final Integer counter) {
        it.accept(XtendASTFlattener.this);
        List _fragments = node.fragments();
        int _size = _fragments.size();
        int _minus = (_size - 1);
        boolean _lessThan = ((counter).intValue() < _minus);
        if (_lessThan) {
          XtendASTFlattener.this.appendToBuffer(", ");
        }
      }
    };
    IterableExtensions.<VariableDeclarationFragment>forEach(_fragments, _function);
    this.appendToBuffer(";");
    return false;
  }
  
  public boolean visit(final MethodDeclaration node) {
    Javadoc _javadoc = node.getJavadoc();
    boolean _notEquals = (!Objects.equal(_javadoc, null));
    if (_notEquals) {
      Javadoc _javadoc_1 = node.getJavadoc();
      _javadoc_1.accept(this);
    }
    List _modifiers = node.modifiers();
    final Function1<IExtendedModifier, Boolean> _function = new Function1<IExtendedModifier, Boolean>() {
      public Boolean apply(final IExtendedModifier it) {
        return Boolean.valueOf(it.isAnnotation());
      }
    };
    Iterable<IExtendedModifier> _filter = IterableExtensions.<IExtendedModifier>filter(_modifiers, _function);
    this.printModifiers(_filter);
    boolean _isOverrideMethode = this.isOverrideMethode(node);
    if (_isOverrideMethode) {
      this.appendToBuffer("override ");
    } else {
      this.appendToBuffer("def ");
    }
    List _modifiers_1 = node.modifiers();
    final Function1<IExtendedModifier, Boolean> _function_1 = new Function1<IExtendedModifier, Boolean>() {
      public Boolean apply(final IExtendedModifier it) {
        return Boolean.valueOf(it.isModifier());
      }
    };
    Iterable<IExtendedModifier> _filter_1 = IterableExtensions.<IExtendedModifier>filter(_modifiers_1, _function_1);
    this.printModifiers(_filter_1);
    List _typeParameters = node.typeParameters();
    boolean _isEmpty = _typeParameters.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.appendToBuffer("<");
      List _typeParameters_1 = node.typeParameters();
      final Procedure2<TypeParameter, Integer> _function_2 = new Procedure2<TypeParameter, Integer>() {
        public void apply(final TypeParameter it, final Integer counter) {
          it.accept(XtendASTFlattener.this);
          List _typeParameters = node.typeParameters();
          int _size = _typeParameters.size();
          int _minus = (_size - 1);
          boolean _lessThan = ((counter).intValue() < _minus);
          if (_lessThan) {
            XtendASTFlattener.this.appendToBuffer(", ");
          }
        }
      };
      IterableExtensions.<TypeParameter>forEach(_typeParameters_1, _function_2);
      this.appendToBuffer("> ");
    }
    boolean _isConstructor = node.isConstructor();
    boolean _not_1 = (!_isConstructor);
    if (_not_1) {
      Type _returnType2 = node.getReturnType2();
      boolean _notEquals_1 = (!Objects.equal(_returnType2, null));
      if (_notEquals_1) {
        Type _returnType2_1 = node.getReturnType2();
        _returnType2_1.accept(this);
      } else {
        this.appendToBuffer("void");
      }
      this.appendToBuffer(" ");
    }
    SimpleName _name = node.getName();
    _name.accept(this);
    this.appendToBuffer("(");
    List _parameters = node.parameters();
    final Procedure2<SingleVariableDeclaration, Integer> _function_3 = new Procedure2<SingleVariableDeclaration, Integer>() {
      public void apply(final SingleVariableDeclaration it, final Integer counter) {
        it.accept(XtendASTFlattener.this);
        List _parameters = node.parameters();
        int _size = _parameters.size();
        int _minus = (_size - 1);
        boolean _lessThan = ((counter).intValue() < _minus);
        if (_lessThan) {
          XtendASTFlattener.this.appendToBuffer(", ");
        }
      }
    };
    IterableExtensions.<SingleVariableDeclaration>forEach(_parameters, _function_3);
    this.appendToBuffer(")");
    int _extraDimensions = node.getExtraDimensions();
    this.appendExtraDimensions(_extraDimensions);
    List _thrownExceptions = node.thrownExceptions();
    boolean _isEmpty_1 = _thrownExceptions.isEmpty();
    boolean _not_2 = (!_isEmpty_1);
    if (_not_2) {
      this.appendToBuffer(" throws ");
      List _thrownExceptions_1 = node.thrownExceptions();
      final Procedure2<Name, Integer> _function_4 = new Procedure2<Name, Integer>() {
        public void apply(final Name it, final Integer counter) {
          it.accept(XtendASTFlattener.this);
          List _thrownExceptions = node.thrownExceptions();
          int _size = _thrownExceptions.size();
          int _minus = (_size - 1);
          boolean _lessThan = ((counter).intValue() < _minus);
          if (_lessThan) {
            XtendASTFlattener.this.appendToBuffer(", ");
          }
        }
      };
      IterableExtensions.<Name>forEach(_thrownExceptions_1, _function_4);
      this.appendToBuffer(" ");
    }
    Block _body = node.getBody();
    boolean _equals = Objects.equal(_body, null);
    if (_equals) {
      this.appendToBuffer(";");
    } else {
      Block _body_1 = node.getBody();
      _body_1.accept(this);
    }
    return false;
  }
  
  public boolean visit(final SingleVariableDeclaration node) {
    List _modifiers = node.modifiers();
    this.printModifiers(_modifiers);
    Type _type = node.getType();
    _type.accept(this);
    boolean _isVarargs = node.isVarargs();
    if (_isVarargs) {
      this.appendToBuffer("...");
    }
    this.appendToBuffer(" ");
    SimpleName _name = node.getName();
    _name.accept(this);
    int _extraDimensions = node.getExtraDimensions();
    this.appendExtraDimensions(_extraDimensions);
    Expression _initializer = node.getInitializer();
    boolean _notEquals = (!Objects.equal(_initializer, null));
    if (_notEquals) {
      this.appendToBuffer("=");
      Expression _initializer_1 = node.getInitializer();
      _initializer_1.accept(this);
    }
    return false;
  }
  
  public boolean visit(final Block node) {
    boolean _xblockexpression = false;
    {
      this.appendToBuffer("{");
      this.appendLineWrapToBuffer();
      List _statements = node.statements();
      final Procedure1<Statement> _function = new Procedure1<Statement>() {
        public void apply(final Statement it) {
          it.accept(XtendASTFlattener.this);
        }
      };
      IterableExtensions.<Statement>forEach(_statements, _function);
      this.appendLineWrapToBuffer();
      this.appendToBuffer("}");
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean visit(final ExpressionStatement node) {
    boolean _xblockexpression = false;
    {
      Expression _expression = node.getExpression();
      _expression.accept(this);
      this.appendSpaceToBuffer();
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean visit(final MethodInvocation node) {
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
      this.appendToBuffer("<");
      List _typeArguments_1 = node.typeArguments();
      final Procedure2<Type, Integer> _function = new Procedure2<Type, Integer>() {
        public void apply(final Type it, final Integer counter) {
          it.accept(XtendASTFlattener.this);
          List _typeArguments = node.typeArguments();
          int _size = _typeArguments.size();
          int _minus = (_size - 1);
          boolean _lessThan = ((counter).intValue() < _minus);
          if (_lessThan) {
            XtendASTFlattener.this.appendToBuffer(", ");
          }
        }
      };
      IterableExtensions.<Type>forEach(_typeArguments_1, _function);
      this.appendToBuffer(">");
    }
    SimpleName _name = node.getName();
    _name.accept(this);
    this.appendToBuffer("(");
    List _arguments = node.arguments();
    final Procedure2<Expression, Integer> _function_1 = new Procedure2<Expression, Integer>() {
      public void apply(final Expression it, final Integer counter) {
        it.accept(XtendASTFlattener.this);
        List _arguments = node.arguments();
        int _size = _arguments.size();
        int _minus = (_size - 1);
        boolean _lessThan = ((counter).intValue() < _minus);
        if (_lessThan) {
          XtendASTFlattener.this.appendToBuffer(", ");
        }
      }
    };
    IterableExtensions.<Expression>forEach(_arguments, _function_1);
    this.appendToBuffer(")");
    return false;
  }
  
  public boolean visit(final ForStatement node) {
    this.appendToBuffer("for (");
    List _initializers = node.initializers();
    final Procedure1<Expression> _function = new Procedure1<Expression>() {
      public void apply(final Expression it) {
        it.accept(XtendASTFlattener.this);
      }
    };
    IterableExtensions.<Expression>forEach(_initializers, _function);
    this.appendToBuffer("; ");
    Expression _expression = node.getExpression();
    boolean _notEquals = (!Objects.equal(_expression, null));
    if (_notEquals) {
      Expression _expression_1 = node.getExpression();
      _expression_1.accept(this);
    }
    this.appendToBuffer("; ");
    List _updaters = node.updaters();
    final Procedure1<Expression> _function_1 = new Procedure1<Expression>() {
      public void apply(final Expression it) {
        it.accept(XtendASTFlattener.this);
      }
    };
    IterableExtensions.<Expression>forEach(_updaters, _function_1);
    this.appendToBuffer(") ");
    Statement _body = node.getBody();
    _body.accept(this);
    return false;
  }
  
  public boolean visit(final NullLiteral node) {
    boolean _xblockexpression = false;
    {
      this.appendToBuffer("null");
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean visit(final ThisExpression node) {
    boolean _xblockexpression = false;
    {
      Name _qualifier = node.getQualifier();
      boolean _notEquals = (!Objects.equal(_qualifier, null));
      if (_notEquals) {
        Name _qualifier_1 = node.getQualifier();
        _qualifier_1.accept(this);
        this.appendToBuffer(".");
      }
      this.appendToBuffer("this");
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean visit(final FieldAccess node) {
    Expression _expression = node.getExpression();
    _expression.accept(this);
    this.appendToBuffer(".");
    SimpleName _name = node.getName();
    _name.accept(this);
    return false;
  }
  
  public boolean visit(final MarkerAnnotation node) {
    return false;
  }
  
  private boolean isOverrideMethode(final MethodDeclaration declaration) {
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
    return (!_isEmpty);
  }
  
  public boolean visit(final StringLiteral node) {
    boolean _xblockexpression = false;
    {
      this.appendToBuffer("\'");
      String _literalValue = node.getLiteralValue();
      this.appendToBuffer(_literalValue);
      this.appendToBuffer("\'");
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public void printModifiers(final Iterable<IExtendedModifier> ext) {
    final Procedure1<IExtendedModifier> _function = new Procedure1<IExtendedModifier>() {
      public void apply(final IExtendedModifier p) {
        ((ASTNode) p).accept(XtendASTFlattener.this);
      }
    };
    IterableExtensions.<IExtendedModifier>forEach(ext, _function);
  }
  
  private StringBuffer appendSpaceToBuffer() {
    return this.appendToBuffer(" ");
  }
  
  private StringBuffer appendLineWrapToBuffer() {
    return this.appendToBuffer("\n");
  }
  
  private StringBuffer appendToBuffer(final String string) {
    return this.fBuffer.append(string);
  }
}
