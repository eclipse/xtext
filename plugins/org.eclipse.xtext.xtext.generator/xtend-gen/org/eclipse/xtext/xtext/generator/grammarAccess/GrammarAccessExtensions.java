/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.grammarAccess;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.ibm.icu.text.Transliterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.XtextRuntimeModule;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.service.CompoundModule;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.RuleNames;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;

/**
 * This API can be used by other templates to generate code
 * that has hard references to grammar rules/elements
 * @author Moritz Eysholdt
 */
@SuppressWarnings("all")
public class GrammarAccessExtensions {
  @FinalFieldsConstructor
  protected static class LineSeparatorModule extends XtextRuntimeModule {
    private final ILineSeparatorInformation lineSeparatorInformation;
    
    @Override
    public void configure(final Binder binder) {
      final CompoundModule compound = this.getBindings();
      compound.configure(binder);
    }
    
    public ILineSeparatorInformation bindILineSeparatorInformation() {
      return this.lineSeparatorInformation;
    }
    
    public LineSeparatorModule(final ILineSeparatorInformation lineSeparatorInformation) {
      super();
      this.lineSeparatorInformation = lineSeparatorInformation;
    }
  }
  
  private final Map<String, ISerializer> xtextSerializerByLineDelimiter = Maps.<String, ISerializer>newHashMapWithExpectedSize(2);
  
  private final Transliterator transliterator = Transliterator.getInstance("Any-Name");
  
  @Inject
  private CodeConfig codeConfig;
  
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  /**
   * Returns a reference to the GrammarAccess implementation for a grammar.
   */
  public TypeReference getGrammarAccess(final Grammar grammar) {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(grammar);
    String _plus = (_runtimeBasePackage + ".services.");
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "GrammarAccess");
    return new TypeReference(_plus_2);
  }
  
  /**
   * Returns the invocation of the element accessor method as fully qualified Java statement.
   * Example: return FowlerDslTestLanguageGrammarAccess.INSTANCE.prStatemachine().ele1AssignmentStates()
   */
  public StringConcatenationClient gaFullAccessor(final AbstractElement ele) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        Grammar _grammar = GrammarUtil.getGrammar(ele);
        TypeReference _grammarAccess = GrammarAccessExtensions.this.getGrammarAccess(_grammar);
        _builder.append(_grammarAccess, "");
        _builder.append(".INSTANCE.");
        String _gaRuleElementAccessor = GrammarAccessExtensions.this.gaRuleElementAccessor(ele);
        _builder.append(_gaRuleElementAccessor, "");
      }
    };
    return _client;
  }
  
  /**
   * Converts an arbitary string to a valid Java identifier that is valid in an Antlr grammar action context, too.
   * The string is split up along the the characters that are not valid as java
   * identifier. The first character of each segments is made upper case which
   * leads to a camel-case style.
   * @param text the string
   * @param uppercaseFirst whether the first character of the returned identifier should be uppercase or lowercase
   */
  public String toJavaIdentifier(final String text, final boolean uppercaseFirst) {
    try {
      return this.toJavaIdentifierSegment(text, true, uppercaseFirst);
    } catch (final Throwable _t) {
      if (_t instanceof Throwable) {
        final Throwable t = (Throwable)_t;
        t.printStackTrace();
        return (("%_FAILURE_(" + text) + ")%");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  private String toJavaIdentifier(final List<String> text, final boolean uppercaseFirst) {
    final Iterator<String> i = text.iterator();
    String _next = i.next();
    String _javaIdentifierSegment = this.toJavaIdentifierSegment(_next, true, uppercaseFirst);
    final StringBuilder b = new StringBuilder(_javaIdentifierSegment);
    while (i.hasNext()) {
      String _next_1 = i.next();
      String _javaIdentifierSegment_1 = this.toJavaIdentifierSegment(_next_1, false, true);
      b.append(_javaIdentifierSegment_1);
    }
    return b.toString();
  }
  
  private String toJavaIdentifierSegment(final String text, final boolean isFirst, final boolean uppercaseFirst) {
    final String r = this.toJavaIdentifierSegmentInt(text, isFirst, uppercaseFirst);
    int _length = r.length();
    boolean _greaterThan = (_length > 0);
    if (_greaterThan) {
      return r;
    }
    final StringBuilder builder = new StringBuilder();
    char[] _charArray = text.toCharArray();
    for (final char c : _charArray) {
      {
        final String n = this.getUnicodeName(c);
        boolean _notEquals = (!Objects.equal(n, null));
        if (_notEquals) {
          builder.append((n + " "));
        }
      }
    }
    String _string = builder.toString();
    String _lowerCase = _string.toLowerCase();
    String _trim = _lowerCase.trim();
    return this.toJavaIdentifierSegmentInt(_trim, isFirst, true);
  }
  
  /**
   * Returns the Unicode string name for a character.
   */
  public String getUnicodeName(final char character) {
    String _valueOf = String.valueOf(character);
    final String transliterated = this.transliterator.transliterate(_valueOf);
    int _length = "\\N{".length();
    int _length_1 = transliterated.length();
    int _length_2 = "}".length();
    int _minus = (_length_1 - _length_2);
    return transliterated.substring(_length, _minus);
  }
  
  private String toJavaIdentifierSegmentInt(final String text, final boolean isFirst, final boolean uppercaseFirst) {
    boolean start = isFirst;
    boolean up = true;
    final StringBuilder builder = new StringBuilder();
    char[] _charArray = text.toCharArray();
    for (final char c : _charArray) {
      {
        final boolean valid = this.isValidJavaLatinIdentifier(c, start);
        if (valid) {
          if (start) {
            char _xifexpression = (char) 0;
            if (uppercaseFirst) {
              _xifexpression = Character.toUpperCase(c);
            } else {
              _xifexpression = Character.toLowerCase(c);
            }
            builder.append(_xifexpression);
          } else {
            char _xifexpression_1 = (char) 0;
            if (up) {
              _xifexpression_1 = Character.toUpperCase(c);
            } else {
              _xifexpression_1 = c;
            }
            builder.append(_xifexpression_1);
          }
          up = false;
          start = false;
        } else {
          up = true;
        }
      }
    }
    return builder.toString();
  }
  
  public boolean isValidJavaLatinIdentifier(final char c, final boolean start) {
    boolean valid = ((c >= 'A') && (c <= 'Z'));
    valid = (valid || ((c >= 'a') && (c <= 'z')));
    boolean _or = false;
    boolean _or_1 = false;
    boolean _or_2 = false;
    boolean _or_3 = false;
    boolean _or_4 = false;
    boolean _or_5 = false;
    if (valid) {
      _or_5 = true;
    } else {
      boolean _eq = GrammarAccessExtensions.eq(c, 'ä');
      _or_5 = _eq;
    }
    if (_or_5) {
      _or_4 = true;
    } else {
      boolean _eq_1 = GrammarAccessExtensions.eq(c, 'ö');
      _or_4 = _eq_1;
    }
    if (_or_4) {
      _or_3 = true;
    } else {
      boolean _eq_2 = GrammarAccessExtensions.eq(c, 'ü');
      _or_3 = _eq_2;
    }
    if (_or_3) {
      _or_2 = true;
    } else {
      boolean _eq_3 = GrammarAccessExtensions.eq(c, 'Ä');
      _or_2 = _eq_3;
    }
    if (_or_2) {
      _or_1 = true;
    } else {
      boolean _eq_4 = GrammarAccessExtensions.eq(c, 'Ö');
      _or_1 = _eq_4;
    }
    if (_or_1) {
      _or = true;
    } else {
      boolean _eq_5 = GrammarAccessExtensions.eq(c, 'Ü');
      _or = _eq_5;
    }
    valid = _or;
    boolean _or_6 = false;
    if (valid) {
      _or_6 = true;
    } else {
      boolean _eq_6 = GrammarAccessExtensions.eq(c, '_');
      _or_6 = _eq_6;
    }
    valid = _or_6;
    if ((!start)) {
      valid = (valid || ((c >= '0') && (c <= '9')));
    }
    return valid;
  }
  
  private static boolean eq(final char c1, final char c2) {
    return (c1 == c2);
  }
  
  /**
   * Creates an identifier for a Rule which is a valid Java identifier and unique within
   * the Rule's grammar and its super grammars.
   */
  public String gaRuleIdentifier(final AbstractRule rule) {
    RuleNames _ruleNames = RuleNames.getRuleNames(rule);
    final String plainName = _ruleNames.getUniqueRuleName(rule);
    return this.toJavaIdentifier(plainName, true);
  }
  
  /**
   * Creates an identifier for a Rule which is a valid Java identifier and unique within
   * the grammar that defines the rule.
   */
  public String gaBaseRuleIdentifier(final AbstractRule rule) {
    String _name = rule.getName();
    return this.toJavaIdentifier(_name, true);
  }
  
  /**
   * Creates an identifier for an AbstractElement which is a valid Java identifier and
   * which is unique whithin the element's rule. The identifier tries to be as
   * human-readable as possible.
   */
  public String gaElementIdentifier(final AbstractElement element) {
    try {
      if ((element == null)) {
        return "null";
      }
      final ArrayList<String> result = new ArrayList<String>();
      List<String> _elementDescription = this.getElementDescription(element);
      result.addAll(_elementDescription);
      String _elementTypeDescription = this.getElementTypeDescription(element);
      result.add(_elementTypeDescription);
      String _elementPath = this.getElementPath(element);
      result.add(_elementPath);
      return this.toJavaIdentifier(result, true);
    } catch (final Throwable _t) {
      if (_t instanceof Throwable) {
        final Throwable t = (Throwable)_t;
        t.printStackTrace();
        return "failure";
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  private List<String> getElementDescription(final AbstractElement element) {
    final ArrayList<String> result = new ArrayList<String>();
    AbstractElement container = element;
    while ((container != null)) {
      {
        List<String> _singleElementDescription = this.getSingleElementDescription(container);
        result.addAll(0, _singleElementDescription);
        final EObject eContainer = container.eContainer();
        AbstractElement _xifexpression = null;
        if ((eContainer instanceof AbstractElement)) {
          _xifexpression = ((AbstractElement)eContainer);
        } else {
          _xifexpression = null;
        }
        container = _xifexpression;
      }
    }
    return result;
  }
  
  private List<String> getSingleElementDescription(final AbstractElement ele) {
    final ArrayList<String> r = new ArrayList<String>(2);
    boolean _matched = false;
    if (!_matched) {
      if (ele instanceof Keyword) {
        _matched=true;
        String _value = ((Keyword)ele).getValue();
        r.add(_value);
      }
    }
    if (!_matched) {
      if (ele instanceof Assignment) {
        _matched=true;
        String _feature = ((Assignment)ele).getFeature();
        r.add(_feature);
      }
    }
    if (!_matched) {
      if (ele instanceof RuleCall) {
        _matched=true;
        AbstractRule _rule = ((RuleCall)ele).getRule();
        String _name = _rule.getName();
        r.add(_name);
      }
    }
    if (!_matched) {
      if (ele instanceof Action) {
        _matched=true;
        TypeRef _type = ((Action)ele).getType();
        EClassifier _classifier = null;
        if (_type!=null) {
          _classifier=_type.getClassifier();
        }
        boolean _tripleNotEquals = (_classifier != null);
        if (_tripleNotEquals) {
          TypeRef _type_1 = ((Action)ele).getType();
          EClassifier _classifier_1 = _type_1.getClassifier();
          String _name = _classifier_1.getName();
          r.add(_name);
        }
        String _feature = ((Action)ele).getFeature();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_feature);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          String _feature_1 = ((Action)ele).getFeature();
          r.add(_feature_1);
        }
      }
    }
    if (!_matched) {
      if (ele instanceof CrossReference) {
        _matched=true;
        TypeRef _type = ((CrossReference)ele).getType();
        EClassifier _classifier = null;
        if (_type!=null) {
          _classifier=_type.getClassifier();
        }
        boolean _tripleNotEquals = (_classifier != null);
        if (_tripleNotEquals) {
          TypeRef _type_1 = ((CrossReference)ele).getType();
          EClassifier _classifier_1 = _type_1.getClassifier();
          String _name = _classifier_1.getName();
          r.add(_name);
        }
      }
    }
    if (!_matched) {
      if (ele instanceof EnumLiteralDeclaration) {
        _matched=true;
        EEnumLiteral _enumLiteral = ((EnumLiteralDeclaration)ele).getEnumLiteral();
        String _name = _enumLiteral.getName();
        r.add(_name);
      }
    }
    return r;
  }
  
  private String getElementTypeDescription(final AbstractElement ele) {
    String _xifexpression = null;
    if ((ele instanceof RuleCall)) {
      AbstractRule _rule = ((RuleCall)ele).getRule();
      EClass _eClass = _rule.eClass();
      String _name = _eClass.getName();
      _xifexpression = (_name + "Call");
    } else {
      EClass _eClass_1 = ele.eClass();
      _xifexpression = _eClass_1.getName();
    }
    return _xifexpression;
  }
  
  private String getElementPath(final AbstractElement ele) {
    EObject obj = ele;
    final StringBuilder result = new StringBuilder();
    while (((!(obj.eContainer() instanceof AbstractRule)) && (obj.eContainer() != null))) {
      {
        final EObject eContainer = obj.eContainer();
        EList<EObject> _eContents = eContainer.eContents();
        int _indexOf = _eContents.indexOf(obj);
        result.insert(0, _indexOf);
        result.insert(0, "_");
        obj = eContainer;
      }
    }
    return result.toString();
  }
  
  /**
   * Returns the method name for accessing a rule via a GrammarAccess implementation.
   */
  public String gaRuleAccessMethodName(final AbstractRule rule) {
    String _gaRuleIdentifier = this.gaRuleIdentifier(rule);
    String _plus = ("get" + _gaRuleIdentifier);
    return (_plus + "Rule");
  }
  
  /**
   * Returns the method name for accessing a rule via a GrammarAccess implementation.
   */
  public String gaBaseRuleAccessMethodName(final AbstractRule rule) {
    String _gaBaseRuleIdentifier = this.gaBaseRuleIdentifier(rule);
    String _plus = ("get" + _gaBaseRuleIdentifier);
    return (_plus + "Rule");
  }
  
  /**
   * Returns the method name for accessing a rule's content via a ParserRuleAccess implementation.
   */
  public String gaRuleElementsMethodName(final AbstractRule rule) {
    String _gaRuleIdentifier = this.gaRuleIdentifier(rule);
    String _plus = ("get" + _gaRuleIdentifier);
    return (_plus + "Access");
  }
  
  /**
   * Returns the method name for accessing a rule's content via a ParserRuleAccess implementation.
   */
  public String gaBaseRuleElementsMethodName(final AbstractRule rule) {
    String _gaBaseRuleIdentifier = this.gaBaseRuleIdentifier(rule);
    String _plus = ("get" + _gaBaseRuleIdentifier);
    return (_plus + "Access");
  }
  
  /**
   * Returns the method name for accessing an element via a GrammarAccess implementation.
   */
  public String gaElementAccessMethodName(final AbstractElement element) {
    String _gaElementIdentifier = this.gaElementIdentifier(element);
    return ("get" + _gaElementIdentifier);
  }
  
  /**
   * Returns the simple class name of a rule's facade. A GrammarAccess implementation has
   * a facade for each parser rule, which contains the methods for accessing the rule's elements.
   */
  public String gaRuleAccessorClassName(final AbstractRule rule) {
    String _gaRuleIdentifier = this.gaRuleIdentifier(rule);
    return (_gaRuleIdentifier + "Elements");
  }
  
  /**
   * Returns the simple class name of a rule's facade. A GrammarAccess implementation has
   * a facade for each parser rule, which contains the methods for accessing the rule's elements.
   */
  public String gaBaseRuleAccessorClassName(final AbstractRule rule) {
    String _gaBaseRuleIdentifier = this.gaBaseRuleIdentifier(rule);
    return (_gaBaseRuleIdentifier + "Elements");
  }
  
  /**
   * Returns the invocation of the rule accessor method as Java statement.
   */
  public String gaRuleAccessor(final AbstractRule rule) {
    String _gaRuleAccessMethodName = this.gaRuleAccessMethodName(rule);
    return (_gaRuleAccessMethodName + "()");
  }
  
  /**
   * Returns the invocation of a ParserRule Parameter as Java expression.
   */
  public String gaRuleParameterAccessor(final Parameter parameter) {
    final ParserRule rule = GrammarUtil.containingParserRule(parameter);
    EList<Parameter> _parameters = rule.getParameters();
    final int index = _parameters.indexOf(parameter);
    String _gaRuleAccessor = this.gaRuleAccessor(rule);
    String _plus = (_gaRuleAccessor + ".getParameters().get(");
    String _plus_1 = (_plus + Integer.valueOf(index));
    String _plus_2 = (_plus_1 + "/*");
    String _name = parameter.getName();
    String _plus_3 = (_plus_2 + _name);
    return (_plus_3 + "*/)");
  }
  
  /**
   * Returns the invocation of the rule accessor method as Java statement.
   */
  public String gaBaseRuleAccessor(final AbstractRule rule) {
    String _gaBaseRuleAccessMethodName = this.gaBaseRuleAccessMethodName(rule);
    return (_gaBaseRuleAccessMethodName + "()");
  }
  
  /**
   * Returns the invocation of the rule's content accessor method as Java statement.
   */
  public String gaElementsAccessor(final AbstractRule rule) {
    String _gaRuleElementsMethodName = this.gaRuleElementsMethodName(rule);
    return (_gaRuleElementsMethodName + "()");
  }
  
  /**
   * Returns the invocation of the rule's content accessor method as Java statement.
   */
  public String gaBaseElementsAccessor(final AbstractRule rule) {
    String _gaBaseRuleElementsMethodName = this.gaBaseRuleElementsMethodName(rule);
    return (_gaBaseRuleElementsMethodName + "()");
  }
  
  /**
   * Returns the invocation of the element accessor method as Java statement.
   * The called method is implemented by the rule's facade.
   * Example: ele1AssignmentStates()
   */
  public String gaElementAccessor(final AbstractElement ele) {
    String _gaElementAccessMethodName = this.gaElementAccessMethodName(ele);
    return (_gaElementAccessMethodName + "()");
  }
  
  /**
   * Returns the invocation of the element accessor method for a GrammarAccess
   * as Java statement.
   * Example: prStatemachine().ele1AssignmentStates()
   */
  public String gaRuleElementAccessor(final AbstractElement ele) {
    AbstractRule _containingRule = GrammarUtil.containingRule(ele);
    String _gaElementsAccessor = this.gaElementsAccessor(_containingRule);
    String _plus = (_gaElementsAccessor + ".");
    String _gaElementAccessor = this.gaElementAccessor(ele);
    return (_plus + _gaElementAccessor);
  }
  
  /**
   * Returns the invocation of an element or rule accessor, including the .getType() call.
   * Example1: getFooRule().getType()
   * Example2: getBarRule().getFooAction().getType()
   */
  public String gaTypeAccessor(final TypeRef ele) {
    String _switchResult = null;
    EObject _eContainer = ele.eContainer();
    final EObject cnt = _eContainer;
    boolean _matched = false;
    if (!_matched) {
      if (cnt instanceof AbstractElement) {
        _matched=true;
        String _gaRuleElementAccessor = this.gaRuleElementAccessor(((AbstractElement)cnt));
        _switchResult = (_gaRuleElementAccessor + ".getType()");
      }
    }
    if (!_matched) {
      if (cnt instanceof AbstractRule) {
        _matched=true;
        String _gaRuleAccessor = this.gaRuleAccessor(((AbstractRule)cnt));
        _switchResult = (_gaRuleAccessor + ".getType()");
      }
    }
    if (!_matched) {
      EObject _eContainer_1 = ele.eContainer();
      EClass _eClass = _eContainer_1.eClass();
      String _name = _eClass.getName();
      String _plus = ("<error: unknown type " + _name);
      _switchResult = (_plus + ">");
    }
    return _switchResult;
  }
  
  /**
   * Returns the invocation of an element or rule accessor.
   * Example1: getFooRule()
   * Example2: getBarRule().getFooAction()
   */
  public String gaAccessor(final EObject ele) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (ele instanceof AbstractElement) {
        _matched=true;
        _switchResult = this.gaRuleElementAccessor(((AbstractElement)ele));
      }
    }
    if (!_matched) {
      if (ele instanceof AbstractRule) {
        _matched=true;
        _switchResult = this.gaRuleAccessor(((AbstractRule)ele));
      }
    }
    if (!_matched) {
      if (ele instanceof Parameter) {
        _matched=true;
        _switchResult = this.gaRuleParameterAccessor(((Parameter)ele));
      }
    }
    if (!_matched) {
      EClass _eClass = ele.eClass();
      String _name = _eClass.getName();
      String _plus = ("<error: unknown type " + _name);
      _switchResult = (_plus + ">");
    }
    return _switchResult;
  }
  
  public String grammarFragmentToString(final EObject ele, final String prefix) {
    String s = null;
    try {
      SaveOptions.Builder _newBuilder = SaveOptions.newBuilder();
      SaveOptions.Builder _format = _newBuilder.format();
      final SaveOptions options = _format.getOptions();
      ISerializer _serializer = this.getSerializer();
      String _serialize = _serializer.serialize(ele, options);
      s = _serialize;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        String _string = e.toString();
        s = _string;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    String _trim = s.trim();
    String _replaceAll = _trim.replaceAll("(\\r?\\n)", ("$1" + prefix));
    String _replaceAll_1 = _replaceAll.replaceAll("/\\*", "/ *");
    String _replaceAll_2 = _replaceAll_1.replaceAll("\\*/", "* /");
    String _plus = (prefix + _replaceAll_2);
    s = _plus;
    return s;
  }
  
  protected String _grammarElementIdentifier(final EObject it) {
    String _string = it.toString();
    return ("Unsupported : grammarElementIdentifier for: " + _string);
  }
  
  protected String _grammarElementIdentifier(final AbstractRule it) {
    return this.gaRuleIdentifier(it);
  }
  
  protected String _grammarElementIdentifier(final AbstractElement it) {
    AbstractRule _containingRule = GrammarUtil.containingRule(it);
    String _grammarElementIdentifier = this.grammarElementIdentifier(_containingRule);
    String _plus = (_grammarElementIdentifier + "_");
    String _gaElementIdentifier = this.gaElementIdentifier(it);
    return (_plus + _gaElementIdentifier);
  }
  
  protected String _grammarElementAccess(final EObject it) {
    String _string = it.toString();
    return ("Unsupported : grammarElementAccess for: " + _string);
  }
  
  protected String _grammarElementAccess(final AbstractRule it) {
    return this.gaRuleAccessor(it);
  }
  
  protected String _grammarElementAccess(final AbstractElement it) {
    return this.gaRuleElementAccessor(it);
  }
  
  public List<String> initialHiddenTokens(final Grammar it) {
    List<String> _xblockexpression = null;
    {
      boolean _isDefinesHiddenTokens = it.isDefinesHiddenTokens();
      if (_isDefinesHiddenTokens) {
        EList<AbstractRule> _hiddenTokens = it.getHiddenTokens();
        final Function1<AbstractRule, String> _function = new Function1<AbstractRule, String>() {
          @Override
          public String apply(final AbstractRule it) {
            return GrammarAccessExtensions.this.ruleName(it);
          }
        };
        List<String> _map = ListExtensions.<AbstractRule, String>map(_hiddenTokens, _function);
        return IterableExtensions.<String>toList(_map);
      }
      EList<Grammar> _usedGrammars = it.getUsedGrammars();
      int _size = _usedGrammars.size();
      boolean _equals = (_size == 1);
      if (_equals) {
        EList<Grammar> _usedGrammars_1 = it.getUsedGrammars();
        Grammar _head = IterableExtensions.<Grammar>head(_usedGrammars_1);
        return this.initialHiddenTokens(_head);
      }
      _xblockexpression = CollectionLiterals.<String>emptyList();
    }
    return _xblockexpression;
  }
  
  public String ruleName(final AbstractRule rule) {
    final RuleNames ruleNames = RuleNames.tryGetRuleNames(rule);
    String _elvis = null;
    String _antlrRuleName = null;
    if (ruleNames!=null) {
      _antlrRuleName=ruleNames.getAntlrRuleName(rule);
    }
    if (_antlrRuleName != null) {
      _elvis = _antlrRuleName;
    } else {
      String _ruleName = AntlrGrammarGenUtil.getRuleName(rule);
      _elvis = _ruleName;
    }
    return _elvis;
  }
  
  public String entryRuleName(final ParserRule rule) {
    return AntlrGrammarGenUtil.getEntryRuleName(rule);
  }
  
  public boolean isCalled(final AbstractRule rule, final Grammar grammar) {
    boolean _xblockexpression = false;
    {
      final List<AbstractRule> allRules = GrammarUtil.allRules(grammar);
      boolean _or = false;
      int _indexOf = allRules.indexOf(rule);
      boolean _equals = (_indexOf == 0);
      if (_equals) {
        _or = true;
      } else {
        final Function1<AbstractRule, List<RuleCall>> _function = new Function1<AbstractRule, List<RuleCall>>() {
          @Override
          public List<RuleCall> apply(final AbstractRule it) {
            return GrammarUtil.containedRuleCalls(it);
          }
        };
        List<List<RuleCall>> _map = ListExtensions.<AbstractRule, List<RuleCall>>map(allRules, _function);
        Iterable<RuleCall> _flatten = Iterables.<RuleCall>concat(_map);
        final Function1<RuleCall, Boolean> _function_1 = new Function1<RuleCall, Boolean>() {
          @Override
          public Boolean apply(final RuleCall ruleCall) {
            AbstractRule _rule = ruleCall.getRule();
            return Boolean.valueOf(Objects.equal(_rule, rule));
          }
        };
        boolean _exists = IterableExtensions.<RuleCall>exists(_flatten, _function_1);
        _or = _exists;
      }
      _xblockexpression = _or;
    }
    return _xblockexpression;
  }
  
  public boolean definesUnorderedGroups(final ParserRule it, final AntlrOptions options) {
    boolean _and = false;
    boolean _isBacktrack = options.isBacktrack();
    if (!_isBacktrack) {
      _and = false;
    } else {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(it);
      List<UnorderedGroup> _typeSelect = EcoreUtil2.<UnorderedGroup>typeSelect(_eAllContentsAsList, UnorderedGroup.class);
      boolean _isEmpty = _typeSelect.isEmpty();
      boolean _not = (!_isEmpty);
      _and = _not;
    }
    return _and;
  }
  
  protected boolean _predicated(final AbstractElement it) {
    return it.isPredicated();
  }
  
  protected boolean _predicated(final Assignment it) {
    boolean _or = false;
    boolean _isPredicated = it.isPredicated();
    if (_isPredicated) {
      _or = true;
    } else {
      AbstractElement _terminal = it.getTerminal();
      boolean _predicated = this.predicated(_terminal);
      _or = _predicated;
    }
    return _or;
  }
  
  protected boolean _predicated(final RuleCall it) {
    boolean _or = false;
    boolean _isPredicated = it.isPredicated();
    if (_isPredicated) {
      _or = true;
    } else {
      boolean _xblockexpression = false;
      {
        AbstractRule _rule = it.getRule();
        final AbstractElement group = _rule.getAlternatives();
        boolean _xifexpression = false;
        if ((group instanceof Group)) {
          EList<AbstractElement> _elements = ((Group)group).getElements();
          AbstractElement _head = IterableExtensions.<AbstractElement>head(_elements);
          _xifexpression = this.predicated(_head);
        } else {
          _xifexpression = false;
        }
        _xblockexpression = _xifexpression;
      }
      _or = _xblockexpression;
    }
    return _or;
  }
  
  public AbstractElement predicatedElement(final AbstractElement it) {
    return AntlrGrammarGenUtil.getPredicatedElement(it);
  }
  
  public String localVar(final Assignment it, final AbstractElement terminal) {
    String _feature = it.getFeature();
    String _plus = ("lv_" + _feature);
    String _plus_1 = (_plus + "_");
    ParserRule _containingParserRule = GrammarUtil.containingParserRule(it);
    List<AbstractElement> _contentsAsList = this.contentsAsList(_containingParserRule);
    int _indexOf = _contentsAsList.indexOf(it);
    String _plus_2 = (_plus_1 + Integer.valueOf(_indexOf));
    String _plus_3 = (_plus_2 + "_");
    List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(it);
    int _indexOf_1 = _eAllContentsAsList.indexOf(terminal);
    return (_plus_3 + Integer.valueOf(_indexOf_1));
  }
  
  protected String _localVar(final RuleCall it) {
    AbstractRule _rule = it.getRule();
    AbstractRule _originalElement = AntlrGrammarGenUtil.<AbstractRule>getOriginalElement(_rule);
    String _name = _originalElement.getName();
    String _plus = ("this_" + _name);
    String _plus_1 = (_plus + "_");
    ParserRule _containingParserRule = GrammarUtil.containingParserRule(it);
    List<AbstractElement> _contentsAsList = this.contentsAsList(_containingParserRule);
    int _indexOf = _contentsAsList.indexOf(it);
    return (_plus_1 + Integer.valueOf(_indexOf));
  }
  
  protected String _localVar(final AbstractElement it) {
    String _xblockexpression = null;
    {
      final ParserRule rule = GrammarUtil.containingParserRule(it);
      List<AbstractElement> _contentsAsList = this.contentsAsList(rule);
      final int index = _contentsAsList.indexOf(it);
      _xblockexpression = ("otherlv_" + Integer.valueOf(index));
    }
    return _xblockexpression;
  }
  
  protected String _localVar(final EnumLiteralDeclaration it) {
    EnumRule _containingEnumRule = GrammarUtil.containingEnumRule(it);
    AbstractElement _alternatives = _containingEnumRule.getAlternatives();
    List<AbstractElement> _contentsAsList = this.contentsAsList(_alternatives);
    int _indexOf = _contentsAsList.indexOf(it);
    return ("enumLiteral_" + Integer.valueOf(_indexOf));
  }
  
  protected List<AbstractElement> _contentsAsList(final ParserRule it) {
    AbstractElement _alternatives = it.getAlternatives();
    return this.contentsAsList(_alternatives);
  }
  
  protected List<AbstractElement> _contentsAsList(final AbstractElement it) {
    return CollectionLiterals.<AbstractElement>newArrayList(it);
  }
  
  protected List<AbstractElement> _contentsAsList(final CompoundElement it) {
    EList<AbstractElement> _elements = it.getElements();
    final Function1<AbstractElement, List<AbstractElement>> _function = new Function1<AbstractElement, List<AbstractElement>>() {
      @Override
      public List<AbstractElement> apply(final AbstractElement it) {
        return GrammarAccessExtensions.this.contentsAsList(it);
      }
    };
    List<List<AbstractElement>> _map = ListExtensions.<AbstractElement, List<AbstractElement>>map(_elements, _function);
    Iterable<AbstractElement> _flatten = Iterables.<AbstractElement>concat(_map);
    return IterableExtensions.<AbstractElement>toList(_flatten);
  }
  
  protected List<AbstractElement> _contentsAsList(final UnorderedGroup it) {
    ArrayList<AbstractElement> _xblockexpression = null;
    {
      final ArrayList<AbstractElement> result = CollectionLiterals.<AbstractElement>newArrayList(it);
      EList<AbstractElement> _elements = it.getElements();
      final Function1<AbstractElement, List<AbstractElement>> _function = new Function1<AbstractElement, List<AbstractElement>>() {
        @Override
        public List<AbstractElement> apply(final AbstractElement it) {
          return GrammarAccessExtensions.this.contentsAsList(it);
        }
      };
      List<List<AbstractElement>> _map = ListExtensions.<AbstractElement, List<AbstractElement>>map(_elements, _function);
      Iterable<AbstractElement> _flatten = Iterables.<AbstractElement>concat(_map);
      List<AbstractElement> _list = IterableExtensions.<AbstractElement>toList(_flatten);
      Iterables.<AbstractElement>addAll(result, _list);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public String setOrAdd(final Action it) {
    String _xifexpression = null;
    String _operator = it.getOperator();
    boolean _equals = Objects.equal(_operator, "+=");
    if (_equals) {
      _xifexpression = "add";
    } else {
      _xifexpression = "set";
    }
    return _xifexpression;
  }
  
  public String setOrAdd(final Assignment it) {
    String _xifexpression = null;
    String _operator = it.getOperator();
    boolean _equals = Objects.equal(_operator, "+=");
    if (_equals) {
      _xifexpression = "add";
    } else {
      _xifexpression = "set";
    }
    return _xifexpression;
  }
  
  public CharSequence toStringLiteral(final AbstractElement it) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof RuleCall) {
        AbstractRule _rule = ((RuleCall)it).getRule();
        boolean _notEquals = (!Objects.equal(_rule, null));
        if (_notEquals) {
          _matched=true;
          _switchResult = AntlrGrammarGenUtil.getQualifiedNameAsString(((RuleCall)it));
        }
      }
    }
    if (!_matched) {
      if (it instanceof Keyword) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\"");
        String _value = ((Keyword)it).getValue();
        String _stringInAntlrAction = AntlrGrammarGenUtil.toStringInAntlrAction(_value);
        _builder.append(_stringInAntlrAction, "");
        _builder.append("\"");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      _switchResult = "null";
    }
    return _switchResult;
  }
  
  private ISerializer getSerializer() {
    final String delimiter = this.codeConfig.getLineDelimiter();
    ISerializer result = this.xtextSerializerByLineDelimiter.get(delimiter);
    boolean _notEquals = (!Objects.equal(result, null));
    if (_notEquals) {
      return result;
    }
    final ILineSeparatorInformation _function = new ILineSeparatorInformation() {
      @Override
      public String getLineSeparator() {
        return delimiter;
      }
    };
    GrammarAccessExtensions.LineSeparatorModule _lineSeparatorModule = new GrammarAccessExtensions.LineSeparatorModule(_function);
    final Injector injector = Guice.createInjector(_lineSeparatorModule);
    ISerializer _instance = injector.<ISerializer>getInstance(ISerializer.class);
    result = _instance;
    this.xtextSerializerByLineDelimiter.put(delimiter, result);
    return result;
  }
  
  public String grammarElementIdentifier(final EObject it) {
    if (it instanceof AbstractElement) {
      return _grammarElementIdentifier((AbstractElement)it);
    } else if (it instanceof AbstractRule) {
      return _grammarElementIdentifier((AbstractRule)it);
    } else if (it != null) {
      return _grammarElementIdentifier(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public String grammarElementAccess(final EObject it) {
    if (it instanceof AbstractElement) {
      return _grammarElementAccess((AbstractElement)it);
    } else if (it instanceof AbstractRule) {
      return _grammarElementAccess((AbstractRule)it);
    } else if (it != null) {
      return _grammarElementAccess(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public boolean predicated(final AbstractElement it) {
    if (it instanceof Assignment) {
      return _predicated((Assignment)it);
    } else if (it instanceof RuleCall) {
      return _predicated((RuleCall)it);
    } else if (it != null) {
      return _predicated(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public String localVar(final AbstractElement it) {
    if (it instanceof EnumLiteralDeclaration) {
      return _localVar((EnumLiteralDeclaration)it);
    } else if (it instanceof RuleCall) {
      return _localVar((RuleCall)it);
    } else if (it != null) {
      return _localVar(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public List<AbstractElement> contentsAsList(final EObject it) {
    if (it instanceof UnorderedGroup) {
      return _contentsAsList((UnorderedGroup)it);
    } else if (it instanceof CompoundElement) {
      return _contentsAsList((CompoundElement)it);
    } else if (it instanceof ParserRule) {
      return _contentsAsList((ParserRule)it);
    } else if (it instanceof AbstractElement) {
      return _contentsAsList((AbstractElement)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
