package org.eclipse.xtext.xtext.generator.xbase;

import com.google.common.base.Objects;
import java.util.Set;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.UsedRulesFinder;
import org.eclipse.xtext.xtext.generator.util.GrammarUtil2;

@SuppressWarnings("all")
public class XbaseUsageDetector {
  public boolean inheritsXtype(final Grammar grammar) {
    return GrammarUtil2.inherits(grammar, "org.eclipse.xtext.xbase.Xtype");
  }
  
  public boolean inheritsXbase(final Grammar grammar) {
    return GrammarUtil2.inherits(grammar, "org.eclipse.xtext.xbase.Xbase");
  }
  
  public boolean inheritsXbaseWithAnnotations(final Grammar grammar) {
    return GrammarUtil2.inherits(grammar, "org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations");
  }
  
  public boolean usesXImportSection(final Grammar grammar) {
    final Set<AbstractRule> usedRules = CollectionLiterals.<AbstractRule>newHashSet();
    UsedRulesFinder _usedRulesFinder = new UsedRulesFinder(usedRules);
    _usedRulesFinder.compute(grammar);
    final Function1<AbstractRule, Boolean> _function = new Function1<AbstractRule, Boolean>() {
      @Override
      public Boolean apply(final AbstractRule it) {
        boolean _and = false;
        String _name = it.getName();
        boolean _equals = Objects.equal(_name, "XImportSection");
        if (!_equals) {
          _and = false;
        } else {
          Grammar _grammar = GrammarUtil.getGrammar(it);
          String _name_1 = _grammar.getName();
          boolean _equals_1 = Objects.equal(_name_1, "org.eclipse.xtext.xbase.Xtype");
          _and = _equals_1;
        }
        return Boolean.valueOf(_and);
      }
    };
    return IterableExtensions.<AbstractRule>exists(usedRules, _function);
  }
}
