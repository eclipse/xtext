/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.grammarAccess;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.inject.Binder;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EClassifier;
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
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.service.CompoundModule;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
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
 * @author Karsten Thoms - bug#406914
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

  private static Map<String, String> SPECIAL_CHARS = Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(Pair.<String, String>of("\b", "backspace"), Pair.<String, String>of("\f", "formFeed"), Pair.<String, String>of("\n", "lineFeed"), Pair.<String, String>of("\r", "carriageReturn"), Pair.<String, String>of("\t", "tab"), Pair.<String, String>of("\\", "backslash")));

  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;

  @Inject
  private CodeConfig codeConfig;

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
        TypeReference _grammarAccess = GrammarAccessExtensions.this.getGrammarAccess(GrammarUtil.getGrammar(ele));
        _builder.append(_grammarAccess);
        _builder.append(".INSTANCE.");
        String _gaRuleElementAccessor = GrammarAccessExtensions.this.gaRuleElementAccessor(ele);
        _builder.append(_gaRuleElementAccessor);
      }
    };
    return _client;
  }

  /**
   * Converts an arbitary string to a valid Java identifier that is valid in an Antlr grammar action context, too.
   * The string is split up along the characters that are not valid as java
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
    String _javaIdentifierSegment = this.toJavaIdentifierSegment(i.next(), true, uppercaseFirst);
    final StringBuilder b = new StringBuilder(_javaIdentifierSegment);
    while (i.hasNext()) {
      b.append(this.toJavaIdentifierSegment(i.next(), false, true));
    }
    return b.toString();
  }

  private String toJavaIdentifierSegment(final String text, final boolean isFirst, final boolean uppercaseFirst) {
    final String special = GrammarAccessExtensions.SPECIAL_CHARS.get(text);
    if ((special != null)) {
      String _xifexpression = null;
      if (uppercaseFirst) {
        _xifexpression = StringExtensions.toFirstUpper(special);
      } else {
        _xifexpression = special;
      }
      return _xifexpression;
    }
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
        if ((n != null)) {
          builder.append((n + " "));
        }
      }
    }
    return this.toJavaIdentifierSegmentInt(builder.toString().toLowerCase().trim(), isFirst, true);
  }

  /**
   * Returns the Unicode string name for a character.
   */
  public String getUnicodeName(final char character) {
    return Character.getName(character);
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
    valid = ((((((valid || GrammarAccessExtensions.eq(c, 'ä')) || GrammarAccessExtensions.eq(c, 'ö')) || GrammarAccessExtensions.eq(c, 'ü')) || GrammarAccessExtensions.eq(c, 'Ä')) || GrammarAccessExtensions.eq(c, 'Ö')) || GrammarAccessExtensions.eq(c, 'Ü'));
    valid = (valid || GrammarAccessExtensions.eq(c, '_'));
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
    final String plainName = RuleNames.getRuleNames(rule).getUniqueRuleName(rule);
    return this.toJavaIdentifier(plainName, true);
  }

  /**
   * Creates an identifier for a Rule which is a valid Java identifier and unique within
   * the grammar that defines the rule.
   */
  public String gaBaseRuleIdentifier(final AbstractRule rule) {
    return this.toJavaIdentifier(rule.getName(), true);
  }

  /**
   * Creates an identifier for an AbstractElement which is a valid Java identifier and
   * which is unique within the element's rule. The identifier tries to be as
   * human-readable as possible.
   */
  public String gaElementIdentifier(final AbstractElement element) {
    try {
      if ((element == null)) {
        return "null";
      }
      final ArrayList<String> result = new ArrayList<String>();
      result.addAll(this.getElementDescription(element));
      result.add(this.getElementTypeDescription(element));
      result.add(this.getElementPath(element));
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
        result.addAll(0, this.getSingleElementDescription(container));
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
    if (ele instanceof Keyword) {
      _matched=true;
      String _value = ((Keyword)ele).getValue();
      r.add(_value);
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
        String _name = ((RuleCall)ele).getRule().getName();
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
          String _name = ((Action)ele).getType().getClassifier().getName();
          r.add(_name);
        }
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(((Action)ele).getFeature());
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          String _feature = ((Action)ele).getFeature();
          r.add(_feature);
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
          String _name = ((CrossReference)ele).getType().getClassifier().getName();
          r.add(_name);
        }
      }
    }
    if (!_matched) {
      if (ele instanceof EnumLiteralDeclaration) {
        _matched=true;
        String _name = ((EnumLiteralDeclaration)ele).getEnumLiteral().getName();
        r.add(_name);
      }
    }
    return r;
  }

  private String getElementTypeDescription(final AbstractElement ele) {
    String _xifexpression = null;
    if ((ele instanceof RuleCall)) {
      String _name = ((RuleCall)ele).getRule().eClass().getName();
      _xifexpression = (_name + "Call");
    } else {
      _xifexpression = ele.eClass().getName();
    }
    return _xifexpression;
  }

  private String getElementPath(final AbstractElement ele) {
    EObject obj = ele;
    final StringBuilder result = new StringBuilder();
    while (((!(obj.eContainer() instanceof AbstractRule)) && (obj.eContainer() != null))) {
      {
        final EObject eContainer = obj.eContainer();
        result.insert(0, eContainer.eContents().indexOf(obj));
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
    final int index = rule.getParameters().indexOf(parameter);
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
    String _gaElementsAccessor = this.gaElementsAccessor(GrammarUtil.containingRule(ele));
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
    if (cnt instanceof AbstractElement) {
      _matched=true;
      String _gaRuleElementAccessor = this.gaRuleElementAccessor(((AbstractElement)cnt));
      _switchResult = (_gaRuleElementAccessor + ".getType()");
    }
    if (!_matched) {
      if (cnt instanceof AbstractRule) {
        _matched=true;
        String _gaRuleAccessor = this.gaRuleAccessor(((AbstractRule)cnt));
        _switchResult = (_gaRuleAccessor + ".getType()");
      }
    }
    if (!_matched) {
      String _name = ele.eContainer().eClass().getName();
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
    if (ele instanceof AbstractElement) {
      _matched=true;
      _switchResult = this.gaRuleElementAccessor(((AbstractElement)ele));
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
      String _name = ele.eClass().getName();
      String _plus = ("<error: unknown type " + _name);
      _switchResult = (_plus + ">");
    }
    return _switchResult;
  }

  public String grammarFragmentToString(final EObject object, final String prefix) {
    final ICompositeNode node = NodeModelUtils.findActualNodeFor(object);
    if ((node == null)) {
      if ((object instanceof RuleCall)) {
        AbstractRule _rule = null;
        if (((RuleCall)object)!=null) {
          _rule=((RuleCall)object).getRule();
        }
        String _name = null;
        if (_rule!=null) {
          _name=_rule.getName();
        }
        boolean _tripleNotEquals = (_name != null);
        if (_tripleNotEquals) {
          return this.process(((RuleCall)object).getRule().getName(), prefix);
        }
      }
      return "";
    } else {
      return this.process(node.getText(), prefix);
    }
  }

  private String process(final String input, final String prefix) {
    String[] lines = input.split("\\s*(\\r?\\n)");
    int first = 0;
    while (this.isBlank(lines[first])) {
      first++;
    }
    int _length = lines.length;
    int last = (_length - 1);
    while (this.isBlank(lines[last])) {
      last--;
    }
    final String[] _converted_lines = (String[])lines;
    lines = ((String[])Conversions.unwrapArray(((List<String>)Conversions.doWrapArray(_converted_lines)).subList(first, (last + 1)), String.class));
    final String[] _converted_lines_1 = (String[])lines;
    int _size = ((List<String>)Conversions.doWrapArray(_converted_lines_1)).size();
    boolean _equals = (_size == 1);
    if (_equals) {
      String _trim = (lines[0]).trim();
      return (prefix + _trim);
    }
    final String[] _converted_lines_2 = (String[])lines;
    final String commonWhitespace = this.commonLeadingWhitespace(((List<String>)Conversions.doWrapArray(_converted_lines_2)));
    for (int n = 0; (n < lines.length); n++) {
      String _substring = (lines[n]).replaceAll("\t", "    ").substring(commonWhitespace.length());
      String _plus = (prefix + _substring);
      lines[n] = _plus;
    }
    final String[] _converted_lines_3 = (String[])lines;
    return IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_converted_lines_3)), this.codeConfig.getLineDelimiter());
  }

  private boolean isBlank(final String line) {
    return line.trim().isEmpty();
  }

  private String commonLeadingWhitespace(final List<String> lines) {
    int _size = lines.size();
    boolean _lessThan = (_size < 2);
    if (_lessThan) {
      return "";
    }
    String current = Strings.repeat(" ", lines.get(0).replaceAll("\t", "    ").length());
    for (int i = 0; (i < ((Object[])Conversions.unwrapArray(lines, Object.class)).length); i++) {
      {
        final String next = lines.get(i).replaceAll("\t", "    ");
        boolean _isBlank = this.isBlank(next);
        boolean _not = (!_isBlank);
        if (_not) {
          current = Strings.commonPrefix(current, next);
        }
      }
    }
    for (int i = 0; (i < ((Object[])Conversions.unwrapArray(lines, Object.class)).length); i++) {
      {
        final String next = lines.get(i).replaceAll("\t", "    ");
        boolean _isBlank = this.isBlank(next);
        if (_isBlank) {
          lines.set(i, current);
        }
      }
    }
    return current;
  }

  /**
   * @noreference
   */
  public static String grammarFragmentToString(final ISerializer serializer, final EObject object, final String prefix) {
    String s = null;
    try {
      final SaveOptions options = SaveOptions.newBuilder().format().getOptions();
      s = serializer.serialize(object, options);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        s = e.toString();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    String _replace = s.trim().replaceAll("(\\r?\\n)", ("$1" + prefix)).replace("\\u", "\\\\u");
    String _plus = (prefix + _replace);
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
    String _grammarElementIdentifier = this.grammarElementIdentifier(GrammarUtil.containingRule(it));
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
        final Function1<AbstractRule, String> _function = (AbstractRule it_1) -> {
          return this.ruleName(it_1);
        };
        return IterableExtensions.<String>toList(ListExtensions.<AbstractRule, String>map(it.getHiddenTokens(), _function));
      }
      int _size = it.getUsedGrammars().size();
      boolean _equals = (_size == 1);
      if (_equals) {
        return this.initialHiddenTokens(IterableExtensions.<Grammar>head(it.getUsedGrammars()));
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
      _xblockexpression = ((allRules.indexOf(rule) == 0) || IterableExtensions.<RuleCall>exists(Iterables.<RuleCall>concat(ListExtensions.<AbstractRule, List<RuleCall>>map(allRules, ((Function1<AbstractRule, List<RuleCall>>) (AbstractRule it) -> {
        return GrammarUtil.containedRuleCalls(it);
      }))), ((Function1<RuleCall, Boolean>) (RuleCall ruleCall) -> {
        AbstractRule _rule = ruleCall.getRule();
        return Boolean.valueOf(Objects.equal(_rule, rule));
      })));
    }
    return _xblockexpression;
  }

  public boolean definesUnorderedGroups(final ParserRule it, final AntlrOptions options) {
    return (options.isBacktrack() && (!EcoreUtil2.<UnorderedGroup>typeSelect(EcoreUtil2.eAllContentsAsList(it), UnorderedGroup.class).isEmpty()));
  }

  protected boolean _predicated(final AbstractElement it) {
    return it.isPredicated();
  }

  protected boolean _predicated(final Assignment it) {
    return (it.isPredicated() || this.predicated(it.getTerminal()));
  }

  protected boolean _predicated(final RuleCall it) {
    boolean _or = false;
    boolean _isPredicated = it.isPredicated();
    if (_isPredicated) {
      _or = true;
    } else {
      boolean _xblockexpression = false;
      {
        final AbstractElement group = it.getRule().getAlternatives();
        boolean _xifexpression = false;
        if ((group instanceof Group)) {
          _xifexpression = this.predicated(IterableExtensions.<AbstractElement>head(((Group)group).getElements()));
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
    int _indexOf = this.contentsAsList(GrammarUtil.containingParserRule(it)).indexOf(it);
    String _plus_2 = (_plus_1 + Integer.valueOf(_indexOf));
    String _plus_3 = (_plus_2 + "_");
    int _indexOf_1 = EcoreUtil2.eAllContentsAsList(it).indexOf(terminal);
    return (_plus_3 + Integer.valueOf(_indexOf_1));
  }

  protected String _localVar(final RuleCall it) {
    String _name = AntlrGrammarGenUtil.<AbstractRule>getOriginalElement(it.getRule()).getName();
    String _plus = ("this_" + _name);
    String _plus_1 = (_plus + "_");
    int _indexOf = this.contentsAsList(GrammarUtil.containingParserRule(it)).indexOf(it);
    return (_plus_1 + Integer.valueOf(_indexOf));
  }

  protected String _localVar(final AbstractElement it) {
    String _xblockexpression = null;
    {
      final ParserRule rule = GrammarUtil.containingParserRule(it);
      final int index = this.contentsAsList(rule).indexOf(it);
      _xblockexpression = ("otherlv_" + Integer.valueOf(index));
    }
    return _xblockexpression;
  }

  protected String _localVar(final EnumLiteralDeclaration it) {
    int _indexOf = this.contentsAsList(GrammarUtil.containingEnumRule(it).getAlternatives()).indexOf(it);
    return ("enumLiteral_" + Integer.valueOf(_indexOf));
  }

  protected List<AbstractElement> _contentsAsList(final ParserRule it) {
    return this.contentsAsList(it.getAlternatives());
  }

  protected List<AbstractElement> _contentsAsList(final AbstractElement it) {
    return CollectionLiterals.<AbstractElement>newArrayList(it);
  }

  protected List<AbstractElement> _contentsAsList(final CompoundElement it) {
    final Function1<AbstractElement, List<AbstractElement>> _function = (AbstractElement it_1) -> {
      return this.contentsAsList(it_1);
    };
    return IterableExtensions.<AbstractElement>toList(Iterables.<AbstractElement>concat(ListExtensions.<AbstractElement, List<AbstractElement>>map(it.getElements(), _function)));
  }

  protected List<AbstractElement> _contentsAsList(final UnorderedGroup it) {
    ArrayList<AbstractElement> _xblockexpression = null;
    {
      final ArrayList<AbstractElement> result = CollectionLiterals.<AbstractElement>newArrayList(it);
      final Function1<AbstractElement, List<AbstractElement>> _function = (AbstractElement it_1) -> {
        return this.contentsAsList(it_1);
      };
      List<AbstractElement> _list = IterableExtensions.<AbstractElement>toList(Iterables.<AbstractElement>concat(ListExtensions.<AbstractElement, List<AbstractElement>>map(it.getElements(), _function)));
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
    if (it instanceof RuleCall) {
      AbstractRule _rule = ((RuleCall)it).getRule();
      boolean _tripleNotEquals = (_rule != null);
      if (_tripleNotEquals) {
        _matched=true;
        _switchResult = AntlrGrammarGenUtil.getQualifiedNameAsString(((RuleCall)it));
      }
    }
    if (!_matched) {
      if (it instanceof Keyword) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\"");
        String _stringInAntlrAction = AntlrGrammarGenUtil.toStringInAntlrAction(((Keyword)it).getValue());
        _builder.append(_stringInAntlrAction);
        _builder.append("\"");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      _switchResult = "null";
    }
    return _switchResult;
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
