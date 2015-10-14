/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.serializer;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.serializer.GeneratedFile;
import org.eclipse.xtext.generator.serializer.SemanticSequencerUtil;
import org.eclipse.xtext.generator.serializer.SerializerGenFileNames;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class GrammarConstraints extends GeneratedFile {
  @Inject
  private Grammar grammar;
  
  @Inject
  @Extension
  private SemanticSequencerUtil sequencerUtil;
  
  @Override
  public CharSequence getFileContents(final SerializerGenFileNames.GenFileName filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar ");
    String _name = this.grammar.getName();
    _builder.append(_name, "");
    {
      EList<Grammar> _usedGrammars = this.grammar.getUsedGrammars();
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
    String _name_2 = this.grammar.getName();
    _builder.append(_name_2, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    _builder.append("// ******** constraint contexts ********");
    _builder.newLine();
    {
      List<IGrammarConstraintProvider.IConstraintContext> _grammarConstraintContexts = this.sequencerUtil.getGrammarConstraintContexts(this.grammar);
      boolean _hasElements_1 = false;
      for(final IGrammarConstraintProvider.IConstraintContext gcc : _grammarConstraintContexts) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        String _name_3 = gcc.getName();
        _builder.append(_name_3, "");
        {
          String _safeType = this.getSafeType(gcc);
          boolean _tripleNotEquals = (_safeType != null);
          if (_tripleNotEquals) {
            _builder.append(" returns ");
            String _safeType_1 = this.getSafeType(gcc);
            _builder.append(_safeType_1, "");
          }
        }
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          List<IGrammarConstraintProvider.IConstraint> _constraints = gcc.getConstraints();
          boolean _hasElements_2 = false;
          for(final IGrammarConstraintProvider.IConstraint constraint : _constraints) {
            if (!_hasElements_2) {
              _hasElements_2 = true;
            } else {
              _builder.appendImmediate(" | ", "\t");
            }
            String _name_4 = constraint.getName();
            _builder.append(_name_4, "\t");
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
      Collection<IGrammarConstraintProvider.IConstraint> _grammarConstraints = this.sequencerUtil.getGrammarConstraints(this.grammar);
      boolean _hasElements_3 = false;
      for(final IGrammarConstraintProvider.IConstraint constraint_1 : _grammarConstraints) {
        if (!_hasElements_3) {
          _hasElements_3 = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        String _name_5 = constraint_1.getName();
        _builder.append(_name_5, "");
        {
          EClass _type = constraint_1.getType();
          boolean _tripleNotEquals_1 = (_type != null);
          if (_tripleNotEquals_1) {
            _builder.append(" returns ");
            EClass _type_1 = constraint_1.getType();
            String _name_6 = _type_1.getName();
            _builder.append(_name_6, "");
          }
        }
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        {
          IGrammarConstraintProvider.IConstraintElement _body = constraint_1.getBody();
          boolean _equals = Objects.equal(_body, null);
          if (_equals) {
            _builder.append("\t");
            _builder.append("{");
            EClass _type_2 = constraint_1.getType();
            String _name_7 = null;
            if (_type_2!=null) {
              _name_7=_type_2.getName();
            }
            _builder.append(_name_7, "\t");
            _builder.append("};");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            IGrammarConstraintProvider.IConstraintElement _body_1 = constraint_1.getBody();
            _builder.append(_body_1, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  private String getSafeType(final IGrammarConstraintProvider.IConstraintContext context) {
    String _xtrycatchfinallyexpression = null;
    try {
      EClass _commonType = context.getCommonType();
      String _name = null;
      if (_commonType!=null) {
        _name=_commonType.getName();
      }
      _xtrycatchfinallyexpression = _name;
    } catch (final Throwable _t) {
      if (_t instanceof UnsupportedOperationException) {
        final UnsupportedOperationException e = (UnsupportedOperationException)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
}
