/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.tests.parsing;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class NodeModelPrinter {
  @Accessors
  private boolean ignoreSyntaxErrors = false;
  
  protected String _print(final ICompositeNode it) {
    StringConcatenation _builder = new StringConcatenation();
    String _doPrint = this.doPrint(it);
    _builder.append(_doPrint, "");
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    {
      BidiIterable<INode> _children = it.getChildren();
      boolean _hasElements = false;
      for(final INode child : _children) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n", "\t");
        }
        _builder.append("\t");
        String _print = this.print(child);
        _builder.append(_print, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _print(final INode it) {
    return this.doPrint(it);
  }
  
  protected String doPrint(final INode it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (this.ignoreSyntaxErrors) {
        Class<? extends INode> _class = it.getClass();
        String _name = _class.getName();
        String _replaceFirst = _name.replaceFirst("AndSyntaxError", "");
        String _replaceFirst_1 = _replaceFirst.replaceFirst("WithSyntaxError", "");
        _builder.append(_replaceFirst_1, "");
      } else {
        Class<? extends INode> _class_1 = it.getClass();
        _builder.append(_class_1, "");
      }
    }
    _builder.append(" ");
    ITextRegion _totalTextRegion = it.getTotalTextRegion();
    _builder.append(_totalTextRegion, "");
    _builder.newLineIfNotEmpty();
    _builder.append("grammarElements: ");
    EObject _grammarElement = it.getGrammarElement();
    String _printGrammarElement = this.printGrammarElement(_grammarElement);
    _builder.append(_printGrammarElement, "");
    _builder.newLineIfNotEmpty();
    {
      boolean _hasDirectSemanticElement = it.hasDirectSemanticElement();
      if (_hasDirectSemanticElement) {
        _builder.append("directSemanticElement: ");
        EObject _semanticElement = it.getSemanticElement();
        Class<? extends EObject> _class_2 = _semanticElement.getClass();
        String _name_1 = _class_2.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      if ((it instanceof ICompositeNode)) {
        _builder.append("lookAhead: ");
        int _lookAhead = ((ICompositeNode)it).getLookAhead();
        _builder.append(_lookAhead, "");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      if (((!this.ignoreSyntaxErrors) && (!Objects.equal(it.getSyntaxErrorMessage(), null)))) {
        _builder.append("syntaxErrorMessage: ");
        SyntaxErrorMessage _syntaxErrorMessage = it.getSyntaxErrorMessage();
        _builder.append(_syntaxErrorMessage, "");
      }
    }
    return _builder.toString();
  }
  
  protected String _printGrammarElement(final Void grammarElement) {
    return "null";
  }
  
  protected String _printGrammarElement(final Object grammarElement) {
    return grammarElement.toString();
  }
  
  protected String _printGrammarElement(final AbstractRule rule) {
    StringConcatenation _builder = new StringConcatenation();
    Class<? extends AbstractRule> _class = rule.getClass();
    String _simpleName = _class.getSimpleName();
    _builder.append(_simpleName, "");
    _builder.append(" [");
    String _name = rule.getName();
    _builder.append(_name, "");
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _printGrammarElement(final RuleCall grammarElement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("RuleCall --> ");
    AbstractRule _rule = grammarElement.getRule();
    String _printGrammarElement = this.printGrammarElement(_rule);
    _builder.append(_printGrammarElement, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _printGrammarElement(final Keyword grammarElement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Keyword [");
    String _value = grammarElement.getValue();
    _builder.append(_value, "");
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _printGrammarElement(final Action action) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Action [");
    TypeRef _type = action.getType();
    EClassifier _classifier = _type.getClassifier();
    String _name = _classifier.getName();
    _builder.append(_name, "");
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _printGrammarElement(final CrossReference crossReference) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CrossReference [");
    TypeRef _type = crossReference.getType();
    EClassifier _classifier = _type.getClassifier();
    String _name = _classifier.getName();
    _builder.append(_name, "");
    {
      AbstractElement _terminal = crossReference.getTerminal();
      boolean _notEquals = (!Objects.equal(_terminal, null));
      if (_notEquals) {
        _builder.append(" | ");
        AbstractElement _terminal_1 = crossReference.getTerminal();
        String _printGrammarElement = this.printGrammarElement(_terminal_1);
        _builder.append(_printGrammarElement, "");
        _builder.append(" ");
      }
    }
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _printGrammarElement(final EnumLiteralDeclaration it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("EnumLiteralDeclaration [");
    EEnumLiteral _enumLiteral = it.getEnumLiteral();
    String _literal = _enumLiteral.getLiteral();
    _builder.append(_literal, "");
    {
      Keyword _literal_1 = it.getLiteral();
      boolean _notEquals = (!Objects.equal(_literal_1, null));
      if (_notEquals) {
        _builder.append(" = ");
        Keyword _literal_2 = it.getLiteral();
        String _value = _literal_2.getValue();
        _builder.append(_value, "");
      }
    }
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String print(final INode it) {
    if (it instanceof ICompositeNode) {
      return _print((ICompositeNode)it);
    } else if (it != null) {
      return _print(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  protected String printGrammarElement(final Object action) {
    if (action instanceof Action) {
      return _printGrammarElement((Action)action);
    } else if (action instanceof CrossReference) {
      return _printGrammarElement((CrossReference)action);
    } else if (action instanceof EnumLiteralDeclaration) {
      return _printGrammarElement((EnumLiteralDeclaration)action);
    } else if (action instanceof Keyword) {
      return _printGrammarElement((Keyword)action);
    } else if (action instanceof RuleCall) {
      return _printGrammarElement((RuleCall)action);
    } else if (action instanceof AbstractRule) {
      return _printGrammarElement((AbstractRule)action);
    } else if (action == null) {
      return _printGrammarElement((Void)null);
    } else if (action != null) {
      return _printGrammarElement(action);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(action).toString());
    }
  }
  
  @Pure
  public boolean isIgnoreSyntaxErrors() {
    return this.ignoreSyntaxErrors;
  }
  
  public void setIgnoreSyntaxErrors(final boolean ignoreSyntaxErrors) {
    this.ignoreSyntaxErrors = ignoreSyntaxErrors;
  }
}
