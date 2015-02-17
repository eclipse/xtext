package org.eclipse.xtext.idea.generator.parser.antlr;

import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.idea.generator.parser.antlr.DefaultAntlrGrammarGenerator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class UnorderedGroupsAwareAntlrGrammarGenerator extends DefaultAntlrGrammarGenerator {
  protected CharSequence compileInitUnorderedGroups(final ParserRule it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(");
    _builder.newLine();
    {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(it);
      Iterable<UnorderedGroup> _filter = Iterables.<UnorderedGroup>filter(_eAllContentsAsList, UnorderedGroup.class);
      boolean _hasElements = false;
      for(final UnorderedGroup group : _filter) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        _builder.append("grammarAccess.");
        String _gaRuleElementAccessor = this._grammarAccess.gaRuleElementAccessor(group);
        _builder.append(_gaRuleElementAccessor, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(");");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence compileRestoreUnorderedGroups(final ParserRule it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _definesUnorderedGroups = this._grammarAccessExtensions.definesUnorderedGroups(it, options);
      if (_definesUnorderedGroups) {
        _builder.append("myUnorderedGroupState.restore();");
      }
    }
    return _builder;
  }
  
  @Override
  protected String _dataTypeEbnf2(final UnorderedGroup it, final boolean supportActions) {
    String _xifexpression = null;
    if (supportActions) {
      String _xblockexpression = null;
      {
        EList<AbstractElement> _elements = it.getElements();
        final Function1<AbstractElement, Boolean> _function = new Function1<AbstractElement, Boolean>() {
          @Override
          public Boolean apply(final AbstractElement it) {
            boolean _isOptionalCardinality = GrammarUtil.isOptionalCardinality(it);
            return Boolean.valueOf((!_isOptionalCardinality));
          }
        };
        Iterable<AbstractElement> _filter = IterableExtensions.<AbstractElement>filter(_elements, _function);
        final int mandatoryContent = IterableExtensions.size(_filter);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("{ ");
        _builder.newLine();
        _builder.append("\t  ");
        _builder.append("getUnorderedGroupHelper().enter(grammarAccess.");
        String _gaRuleElementAccessor = this._grammarAccess.gaRuleElementAccessor(it);
        _builder.append(_gaRuleElementAccessor, "\t  ");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("(");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("(");
        _builder.newLine();
        {
          EList<AbstractElement> _elements_1 = it.getElements();
          Iterable<Pair<Integer, AbstractElement>> _indexed = IterableExtensions.<AbstractElement>indexed(_elements_1);
          boolean _hasElements = false;
          for(final Pair<Integer, AbstractElement> element : _indexed) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate("|", "");
            }
            _builder.append("(");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("{getUnorderedGroupHelper().canSelect(grammarAccess.");
            String _gaRuleElementAccessor_1 = this._grammarAccess.gaRuleElementAccessor(it);
            _builder.append(_gaRuleElementAccessor_1, "\t");
            _builder.append(", ");
            Integer _key = element.getKey();
            _builder.append(_key, "\t");
            _builder.append(")}?=>(");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("{");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("getUnorderedGroupHelper().select(grammarAccess.");
            String _gaRuleElementAccessor_2 = this._grammarAccess.gaRuleElementAccessor(it);
            _builder.append(_gaRuleElementAccessor_2, "\t\t\t");
            _builder.append(", ");
            Integer _key_1 = element.getKey();
            _builder.append(_key_1, "\t\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("({true}?=>(");
            AbstractElement _value = element.getValue();
            String _dataTypeEbnf2 = this.dataTypeEbnf2(_value, supportActions);
            _builder.append(_dataTypeEbnf2, "\t\t\t\t\t");
            _builder.append("))");
            {
              AbstractElement _value_1 = element.getValue();
              boolean _isMultipleCardinality = GrammarUtil.isMultipleCardinality(_value_1);
              if (_isMultipleCardinality) {
                _builder.append("+");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("{ ");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("getUnorderedGroupHelper().returnFromSelection(grammarAccess.");
            String _gaRuleElementAccessor_3 = this._grammarAccess.gaRuleElementAccessor(it);
            _builder.append(_gaRuleElementAccessor_3, "\t\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(")");
            _builder.newLine();
            _builder.append(")");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append(")");
        {
          if ((mandatoryContent != 0)) {
            _builder.append("+");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("{getUnorderedGroupHelper().canLeave(grammarAccess.");
            String _gaRuleElementAccessor_4 = this._grammarAccess.gaRuleElementAccessor(it);
            _builder.append(_gaRuleElementAccessor_4, "\t\t");
            _builder.append(")}?");
          } else {
            _builder.append("*");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(")");
        _builder.newLine();
        _builder.append(")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("{ ");
        _builder.newLine();
        _builder.append("\t  ");
        _builder.append("getUnorderedGroupHelper().leave(grammarAccess.");
        String _gaRuleElementAccessor_5 = this._grammarAccess.gaRuleElementAccessor(it);
        _builder.append(_gaRuleElementAccessor_5, "\t  ");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _xblockexpression = _builder.toString();
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = super._dataTypeEbnf2(it, supportActions);
    }
    return _xifexpression;
  }
  
  @Override
  protected String _ebnf2(final UnorderedGroup it, final AntlrOptions options, final boolean supportActions) {
    String _xifexpression = null;
    if (supportActions) {
      String _xblockexpression = null;
      {
        EList<AbstractElement> _elements = it.getElements();
        final Function1<AbstractElement, Boolean> _function = new Function1<AbstractElement, Boolean>() {
          @Override
          public Boolean apply(final AbstractElement it) {
            boolean _isOptionalCardinality = GrammarUtil.isOptionalCardinality(it);
            return Boolean.valueOf((!_isOptionalCardinality));
          }
        };
        Iterable<AbstractElement> _filter = IterableExtensions.<AbstractElement>filter(_elements, _function);
        final int mandatoryContent = IterableExtensions.size(_filter);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("{ ");
        _builder.newLine();
        _builder.append("\t  ");
        _builder.append("getUnorderedGroupHelper().enter(grammarAccess.");
        String _gaRuleElementAccessor = this._grammarAccess.gaRuleElementAccessor(it);
        _builder.append(_gaRuleElementAccessor, "\t  ");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("(");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("(");
        _builder.newLine();
        {
          EList<AbstractElement> _elements_1 = it.getElements();
          Iterable<Pair<Integer, AbstractElement>> _indexed = IterableExtensions.<AbstractElement>indexed(_elements_1);
          boolean _hasElements = false;
          for(final Pair<Integer, AbstractElement> element : _indexed) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate("|", "");
            }
            _builder.append("(");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("{getUnorderedGroupHelper().canSelect(grammarAccess.");
            String _gaRuleElementAccessor_1 = this._grammarAccess.gaRuleElementAccessor(it);
            _builder.append(_gaRuleElementAccessor_1, "\t");
            _builder.append(", ");
            Integer _key = element.getKey();
            _builder.append(_key, "\t");
            _builder.append(")}?=>(");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("{");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("getUnorderedGroupHelper().select(grammarAccess.");
            String _gaRuleElementAccessor_2 = this._grammarAccess.gaRuleElementAccessor(it);
            _builder.append(_gaRuleElementAccessor_2, "\t\t\t");
            _builder.append(", ");
            Integer _key_1 = element.getKey();
            _builder.append(_key_1, "\t\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("({true}?=>(");
            AbstractElement _value = element.getValue();
            String _ebnf2 = this.ebnf2(_value, options, supportActions);
            _builder.append(_ebnf2, "\t\t\t\t\t");
            _builder.append("))");
            {
              AbstractElement _value_1 = element.getValue();
              boolean _isMultipleCardinality = GrammarUtil.isMultipleCardinality(_value_1);
              if (_isMultipleCardinality) {
                _builder.append("+");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("{ ");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("getUnorderedGroupHelper().returnFromSelection(grammarAccess.");
            String _gaRuleElementAccessor_3 = this._grammarAccess.gaRuleElementAccessor(it);
            _builder.append(_gaRuleElementAccessor_3, "\t\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(")");
            _builder.newLine();
            _builder.append(")");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append(")");
        {
          if ((mandatoryContent != 0)) {
            _builder.append("+");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("{getUnorderedGroupHelper().canLeave(grammarAccess.");
            String _gaRuleElementAccessor_4 = this._grammarAccess.gaRuleElementAccessor(it);
            _builder.append(_gaRuleElementAccessor_4, "\t\t");
            _builder.append(")}?");
          } else {
            _builder.append("*");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(")");
        _builder.newLine();
        _builder.append(")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("{ ");
        _builder.newLine();
        _builder.append("\t  ");
        _builder.append("getUnorderedGroupHelper().leave(grammarAccess.");
        String _gaRuleElementAccessor_5 = this._grammarAccess.gaRuleElementAccessor(it);
        _builder.append(_gaRuleElementAccessor_5, "\t  ");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _xblockexpression = _builder.toString();
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = super._ebnf2(it, options, supportActions);
    }
    return _xifexpression;
  }
}
