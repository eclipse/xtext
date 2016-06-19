/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext;

import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class PredicatedElementTest extends AbstractXtextTests {
  @Override
  public void setUp() throws Exception {
    super.setUp();
    this.with(XtextStandaloneSetup.class);
  }
  
  @Test
  public void testPredicatedElement_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("RootRule: Child;");
    _builder.newLine();
    _builder.append("Child: =>(name=ID ->child=Child?);");
    _builder.newLine();
    final String grammar = _builder.toString();
    this.assertPredicate("ID ID?", grammar);
  }
  
  @Test
  public void testPredicatedElement_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("RootRule: Child;");
    _builder.newLine();
    _builder.append("Child: =>(name=ID ->child=Sub);");
    _builder.newLine();
    _builder.append("Sub: age=INT? name=STRING;");
    _builder.newLine();
    final String grammar = _builder.toString();
    this.assertPredicate("ID (INT | STRING)", grammar);
  }
  
  @Test
  public void testPredicatedElement_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("RootRule: Child;");
    _builder.newLine();
    _builder.append("Child: =>(name=ID =>child=Sub);");
    _builder.newLine();
    _builder.append("Sub: age=INT? name=STRING;");
    _builder.newLine();
    final String grammar = _builder.toString();
    this.assertPredicate("ID Sub", grammar);
  }
  
  @Test
  public void testPredicatedElement_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("RootRule: =>Child;");
    _builder.newLine();
    _builder.append("Child: =>(name=ID =>child=Sub);");
    _builder.newLine();
    _builder.append("Sub: age=INT? name=STRING;");
    _builder.newLine();
    final String grammar = _builder.toString();
    this.assertPredicate("Child", grammar);
  }
  
  @Test
  public void testPredicatedElement_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("RootRule: Child;");
    _builder.newLine();
    _builder.append("Child: =>(name=ID (child=Child? | zonk=ID? ->sub=Sub));");
    _builder.newLine();
    _builder.append("Sub: age=INT? name=STRING;");
    _builder.newLine();
    final String grammar = _builder.toString();
    this.assertPredicate("ID (Child? | ID? (INT | STRING))", grammar);
  }
  
  public void assertPredicate(final String expectation, final String grammar) {
    try {
      EObject _model = this.getModel(grammar);
      final Grammar parsed = ((Grammar) _model);
      EList<AbstractRule> _rules = parsed.getRules();
      AbstractRule _head = IterableExtensions.<AbstractRule>head(_rules);
      final AbstractElement body = _head.getAlternatives();
      final AbstractElement predicate = AntlrGrammarGenUtil.getPredicatedElement(body);
      String _xtext = this.toXtext(predicate);
      Assert.assertEquals(expectation, _xtext);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String _toXtext(final Group group) {
    String _xifexpression = null;
    String _cardinality = group.getCardinality();
    boolean _tripleEquals = (_cardinality == null);
    if (_tripleEquals) {
      EList<AbstractElement> _elements = group.getElements();
      final Function1<AbstractElement, CharSequence> _function = (AbstractElement it) -> {
        return this.toXtext(it);
      };
      _xifexpression = IterableExtensions.<AbstractElement>join(_elements, " ", _function);
    } else {
      EList<AbstractElement> _elements_1 = group.getElements();
      String _cardinality_1 = group.getCardinality();
      String _plus = (")" + _cardinality_1);
      final Function1<AbstractElement, CharSequence> _function_1 = (AbstractElement it) -> {
        return this.toXtext(it);
      };
      _xifexpression = IterableExtensions.<AbstractElement>join(_elements_1, "(", " ", _plus, _function_1);
    }
    return _xifexpression;
  }
  
  protected String _toXtext(final Alternatives alt) {
    EList<AbstractElement> _elements = alt.getElements();
    String _elvis = null;
    String _cardinality = alt.getCardinality();
    if (_cardinality != null) {
      _elvis = _cardinality;
    } else {
      _elvis = "";
    }
    String _plus = (")" + _elvis);
    final Function1<AbstractElement, CharSequence> _function = (AbstractElement it) -> {
      return this.toXtext(it);
    };
    return IterableExtensions.<AbstractElement>join(_elements, "(", " | ", _plus, _function);
  }
  
  protected String _toXtext(final Keyword kw) {
    String _value = kw.getValue();
    String _plus = ("\'" + _value);
    String _plus_1 = (_plus + "\'");
    String _elvis = null;
    String _cardinality = kw.getCardinality();
    if (_cardinality != null) {
      _elvis = _cardinality;
    } else {
      _elvis = "";
    }
    return (_plus_1 + _elvis);
  }
  
  protected String _toXtext(final RuleCall rc) {
    AbstractRule _rule = rc.getRule();
    String _name = _rule.getName();
    String _elvis = null;
    String _cardinality = rc.getCardinality();
    if (_cardinality != null) {
      _elvis = _cardinality;
    } else {
      _elvis = "";
    }
    return (_name + _elvis);
  }
  
  protected String _toXtext(final Assignment ass) {
    AbstractElement _terminal = ass.getTerminal();
    String _xtext = this.toXtext(_terminal);
    String _elvis = null;
    String _cardinality = ass.getCardinality();
    if (_cardinality != null) {
      _elvis = _cardinality;
    } else {
      _elvis = "";
    }
    return (_xtext + _elvis);
  }
  
  protected String _toXtext(final CrossReference cr) {
    AbstractElement _terminal = cr.getTerminal();
    return this.toXtext(_terminal);
  }
  
  public String toXtext(final AbstractElement alt) {
    if (alt instanceof Alternatives) {
      return _toXtext((Alternatives)alt);
    } else if (alt instanceof Group) {
      return _toXtext((Group)alt);
    } else if (alt instanceof Assignment) {
      return _toXtext((Assignment)alt);
    } else if (alt instanceof CrossReference) {
      return _toXtext((CrossReference)alt);
    } else if (alt instanceof Keyword) {
      return _toXtext((Keyword)alt);
    } else if (alt instanceof RuleCall) {
      return _toXtext((RuleCall)alt);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(alt).toString());
    }
  }
}
