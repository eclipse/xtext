package org.eclipse.xtext.generator.grammarAccess;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.grammarAccess.GrammarAccessUtil;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class GrammarAccess {
  private final GrammarAccess _this = this;
  @Inject private Naming naming;
  
  public String gaFullAccessor(final AbstractElement ele) {
    final AbstractElement typeConverted_ele = (AbstractElement)ele;
    Grammar _grammar = GrammarUtil.getGrammar(typeConverted_ele);
    String _gaSimpleName = _this.gaSimpleName(_grammar);
    String _operator_plus = StringExtensions.operator_plus(_gaSimpleName, ".INSTANCE.");
    String _gaRuleElementAccessor = _this.gaRuleElementAccessor(ele);
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _gaRuleElementAccessor);
    return _operator_plus_1;
  }
  
  public String toJavaIdentifier(final String text, final boolean uppercaseFirst) {
    final boolean typeConverted_uppercaseFirst = (boolean)uppercaseFirst;
    String _javaIdentifier = GrammarAccessUtil.toJavaIdentifier(text, ((Boolean)typeConverted_uppercaseFirst));
    return _javaIdentifier;
  }
  
  public String gaRuleIdentifyer(final AbstractRule rule) {
    String _name = rule.getName();
    String _javaIdentifier = _this.toJavaIdentifier(_name, true);
    return _javaIdentifier;
  }
  
  public String gaElementIdentifyer(final AbstractElement element) {
    String _uniqueElementName = GrammarAccessUtil.getUniqueElementName(element);
    return _uniqueElementName;
  }
  
  public String gaFQName(final Grammar grammar) {
    String _grammarAccessFQName = GrammarAccessUtil.getGrammarAccessFQName(grammar, _this.naming);
    return _grammarAccessFQName;
  }
  
  public String gaSimpleName(final Grammar grammar) {
    String _gaFQName = _this.gaFQName(grammar);
    String _simpleName = _this.naming.toSimpleName(_gaFQName);
    return _simpleName;
  }
  
  public String gaRuleAccessMethodName(final AbstractRule rule) {
    String _gaRuleIdentifyer = _this.gaRuleIdentifyer(rule);
    String _operator_plus = StringExtensions.operator_plus("get", _gaRuleIdentifyer);
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "Rule");
    return _operator_plus_1;
  }
  
  public String gaRuleElementsMethodName(final AbstractRule rule) {
    String _gaRuleIdentifyer = _this.gaRuleIdentifyer(rule);
    String _operator_plus = StringExtensions.operator_plus("get", _gaRuleIdentifyer);
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "Access");
    return _operator_plus_1;
  }
  
  public String gaElementAccessMethodeName(final AbstractElement element) {
    String _gaElementIdentifyer = _this.gaElementIdentifyer(element);
    String _operator_plus = StringExtensions.operator_plus("get", _gaElementIdentifyer);
    return _operator_plus;
  }
  
  public String gaRuleAccesorClassName(final AbstractRule rule) {
    String _gaRuleIdentifyer = _this.gaRuleIdentifyer(rule);
    String _operator_plus = StringExtensions.operator_plus(_gaRuleIdentifyer, "Elements");
    return _operator_plus;
  }
  
  public String gaRuleAccessor(final AbstractRule rule) {
    String _gaRuleAccessMethodName = _this.gaRuleAccessMethodName(rule);
    String _operator_plus = StringExtensions.operator_plus(_gaRuleAccessMethodName, "()");
    return _operator_plus;
  }
  
  public String gaElementsAccessor(final AbstractRule rule) {
    String _gaRuleElementsMethodName = _this.gaRuleElementsMethodName(rule);
    String _operator_plus = StringExtensions.operator_plus(_gaRuleElementsMethodName, "()");
    return _operator_plus;
  }
  
  public String gaElementAccessor(final AbstractElement ele) {
    String _gaElementAccessMethodeName = _this.gaElementAccessMethodeName(ele);
    String _operator_plus = StringExtensions.operator_plus(_gaElementAccessMethodeName, "()");
    return _operator_plus;
  }
  
  public String gaRuleElementAccessor(final AbstractElement ele) {
    final AbstractElement typeConverted_ele = (AbstractElement)ele;
    AbstractRule _containingRule = GrammarUtil.containingRule(typeConverted_ele);
    String _gaElementsAccessor = _this.gaElementsAccessor(_containingRule);
    String _operator_plus = StringExtensions.operator_plus(_gaElementsAccessor, ".");
    String _gaElementAccessor = _this.gaElementAccessor(ele);
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _gaElementAccessor);
    return _operator_plus_1;
  }
  
  public String gaTypeAccessor(final TypeRef ele) {
    String switchResult = null;
    final TypeRef typeConverted_ele = (TypeRef)ele;
    EObject _eContainer = typeConverted_ele.eContainer();
    final EObject cnt = _eContainer;
    boolean matched = false;
    if (!matched) {
      if (cnt instanceof AbstractElement) {
        final AbstractElement cnt_1 = (AbstractElement) cnt;
        matched=true;
        String _gaRuleElementAccessor = _this.gaRuleElementAccessor(cnt_1);
        String _operator_plus = StringExtensions.operator_plus(_gaRuleElementAccessor, ".getType()");
        switchResult = _operator_plus;
      }
    }
    if (!matched) {
      if (cnt instanceof AbstractRule) {
        final AbstractRule cnt_2 = (AbstractRule) cnt;
        matched=true;
        String _gaRuleAccessor = _this.gaRuleAccessor(cnt_2);
        String _operator_plus_1 = StringExtensions.operator_plus(_gaRuleAccessor, ".getType()");
        switchResult = _operator_plus_1;
      }
    }
    if (!matched) {
      final TypeRef typeConverted_ele_1 = (TypeRef)ele;
      EObject _eContainer_1 = typeConverted_ele_1.eContainer();
      EClass _eClass = _eContainer_1.eClass();
      String _name = _eClass.getName();
      String _operator_plus_2 = StringExtensions.operator_plus("<error: unknown type ", _name);
      String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, ">");
      switchResult = _operator_plus_3;
    }
    return switchResult;
  }
  
  public String gaAccessor(final EObject ele) {
    String switchResult = null;
    final EObject ele_1 = ele;
    boolean matched = false;
    if (!matched) {
      if (ele_1 instanceof AbstractElement) {
        final AbstractElement ele_2 = (AbstractElement) ele_1;
        matched=true;
        String _gaRuleElementAccessor = _this.gaRuleElementAccessor(ele_2);
        switchResult = _gaRuleElementAccessor;
      }
    }
    if (!matched) {
      if (ele_1 instanceof AbstractRule) {
        final AbstractRule ele_3 = (AbstractRule) ele_1;
        matched=true;
        String _gaRuleAccessor = _this.gaRuleAccessor(ele_3);
        switchResult = _gaRuleAccessor;
      }
    }
    if (!matched) {
      EClass _eClass = ele.eClass();
      String _name = _eClass.getName();
      String _operator_plus = StringExtensions.operator_plus("<error: unknown type ", _name);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ">");
      switchResult = _operator_plus_1;
    }
    return switchResult;
  }
  
  public String grammarFragmentToStr(final EObject ele, final String prefix) {
    String _serialize = GrammarAccessUtil.serialize(ele, prefix);
    return _serialize;
  }
}