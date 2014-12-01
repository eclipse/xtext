package org.eclipse.xtext.idea.tests.parsing;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.util.ITextRegion;

@SuppressWarnings("all")
public class NodeModelPrinter {
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
    Class<? extends INode> _class = it.getClass();
    _builder.append(_class, "");
    _builder.append(" ");
    ITextRegion _textRegion = it.getTextRegion();
    _builder.append(_textRegion, "");
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
        Class<? extends EObject> _class_1 = _semanticElement.getClass();
        String _name = _class_1.getName();
        _builder.append(_name, "");
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
      SyntaxErrorMessage _syntaxErrorMessage = it.getSyntaxErrorMessage();
      boolean _notEquals = (!Objects.equal(_syntaxErrorMessage, null));
      if (_notEquals) {
        _builder.append("syntaxErrorMessage: ");
        SyntaxErrorMessage _syntaxErrorMessage_1 = it.getSyntaxErrorMessage();
        _builder.append(_syntaxErrorMessage_1, "");
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
  
  protected String printGrammarElement(final Object grammarElement) {
    if (grammarElement instanceof Keyword) {
      return _printGrammarElement((Keyword)grammarElement);
    } else if (grammarElement instanceof RuleCall) {
      return _printGrammarElement((RuleCall)grammarElement);
    } else if (grammarElement instanceof AbstractRule) {
      return _printGrammarElement((AbstractRule)grammarElement);
    } else if (grammarElement == null) {
      return _printGrammarElement((Void)null);
    } else if (grammarElement != null) {
      return _printGrammarElement(grammarElement);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(grammarElement).toString());
    }
  }
}
