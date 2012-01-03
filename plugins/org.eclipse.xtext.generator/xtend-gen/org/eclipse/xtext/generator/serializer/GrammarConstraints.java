package org.eclipse.xtext.generator.serializer;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.serializer.GeneratedFile;
import org.eclipse.xtext.generator.serializer.SemanticSequencerUtil;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraintContext;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraintElement;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class GrammarConstraints extends GeneratedFile {
  @Inject
  private Grammar grammar;
  
  @Inject
  private SemanticSequencerUtil sequencerUtil;
  
  public String getFileExtension() {
    return "xtext";
  }
  
  public String getQualifiedName(final Grammar grammar) {
    String _name = this.getName(grammar, "", "GrammarConstraints");
    return _name;
  }
  
  public CharSequence getFileContents() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar ");
    Grammar _grammar = this.grammar;
    String _name = _grammar.getName();
    _builder.append(_name, "");
    {
      Grammar _grammar_1 = this.grammar;
      EList<Grammar> _usedGrammars = _grammar_1.getUsedGrammars();
      boolean _hasElements = false;
      for(final Grammar ug : _usedGrammars) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append(" with ", "");
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _name_1 = ug.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("generate model \"http://");
    Grammar _grammar_2 = this.grammar;
    String _name_2 = _grammar_2.getName();
    _builder.append(_name_2, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    _builder.append("// ******** constraint contexts ********");
    _builder.newLine();
    {
      Grammar _grammar_3 = this.grammar;
      List<IConstraintContext> _grammarConstraintContexts = this.sequencerUtil.getGrammarConstraintContexts(_grammar_3);
      boolean _hasElements_1 = false;
      for(final IConstraintContext gcc : _grammarConstraintContexts) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        String _name_3 = gcc.getName();
        _builder.append(_name_3, "");
        _builder.append(" returns ");
        EClass _commonType = gcc.getCommonType();
        String _name_4 = _commonType.getName();
        _builder.append(_name_4, "");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          List<IConstraint> _constraints = gcc.getConstraints();
          boolean _hasElements_2 = false;
          for(final IConstraint constraint : _constraints) {
            if (!_hasElements_2) {
              _hasElements_2 = true;
            } else {
              _builder.appendImmediate(" | ", "	");
            }
            String _name_5 = constraint.getName();
            _builder.append(_name_5, "	");
          }
        }
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("// ******** constraints ********");
    _builder.newLine();
    {
      Grammar _grammar_4 = this.grammar;
      Collection<IConstraint> _grammarConstraints = this.sequencerUtil.getGrammarConstraints(_grammar_4);
      boolean _hasElements_3 = false;
      for(final IConstraint constraint_1 : _grammarConstraints) {
        if (!_hasElements_3) {
          _hasElements_3 = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        String _name_6 = constraint_1.getName();
        _builder.append(_name_6, "");
        _builder.append(" returns ");
        EClass _type = constraint_1.getType();
        String _name_7 = _type.getName();
        _builder.append(_name_7, "");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        {
          IConstraintElement _body = constraint_1.getBody();
          boolean _operator_equals = ObjectExtensions.operator_equals(_body, null);
          if (_operator_equals) {
            _builder.append("\t");
            _builder.append("{");
            EClass _type_1 = constraint_1.getType();
            String _name_8 = _type_1.getName();
            _builder.append(_name_8, "	");
            _builder.append("};");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            IConstraintElement _body_1 = constraint_1.getBody();
            _builder.append(_body_1, "	");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
}
