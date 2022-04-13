/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.serializer;

import com.google.common.base.Throwables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.serializer.analysis.IContextPDAProvider;
import org.eclipse.xtext.serializer.analysis.IContextTypePDAProvider;
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider;
import org.eclipse.xtext.serializer.analysis.ISerState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.util.GraphvizDotBuilder;
import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.util.formallang.NfaToDot;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaToDot;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;

@SuppressWarnings("all")
public class DebugGraphGenerator {
  @Inject
  private Grammar grammar;

  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;

  @Inject
  private IContextPDAProvider contextPDAProvider;

  @Inject
  private IContextTypePDAProvider contextTypePDAProvider;

  @Inject
  private ISyntacticSequencerPDAProvider syntacticSequencerPDAProvider;

  @Inject
  private ISemanticSequencerNfaProvider semanticSequencerNFAProvider;

  @Inject
  private SyntacticSequencerPDA2ExtendedDot syntacticSequencerPDA2Dot;

  @Inject
  private SyntacticSequencerExtensions syntacticSequencerUtil;

  @Inject
  private PdaToDot<?, ?> pdaToDot;

  @Inject
  private NfaToDot<?> nfaToDot;

  public Iterable<Pair<String, String>> generateDebugGraphs() {
    final ArrayList<Pair<String, String>> result = CollectionLiterals.<Pair<String, String>>newArrayList();
    @Extension
    final NamedSerializationContextProvider names = new NamedSerializationContextProvider(this.grammar);
    final String dir_context = this.directory("context");
    final String dir_context_type = this.directory("context_type");
    final String dir_syntactic_sequencer = this.directory("syntactic_sequencer");
    final String dir_semantic_sequencer = this.directory("semantic_sequencer");
    List<NamedSerializationContexts<Pda<ISerState, RuleCall>>> _namedContexts = names.<Pda<ISerState, RuleCall>>getNamedContexts(this.contextPDAProvider.getContextPDAs(this.grammar));
    for (final NamedSerializationContexts<Pda<ISerState, RuleCall>> e : _namedContexts) {
      {
        String _name = e.getName();
        String _plus = (dir_context + _name);
        String _plus_1 = (_plus + ".dot");
        String _drawSafe = this.drawSafe(this.pdaToDot, e.getValue());
        Pair<String, String> _mappedTo = Pair.<String, String>of(_plus_1, _drawSafe);
        result.add(_mappedTo);
        String _name_1 = e.getName();
        String _plus_2 = (dir_context + _name_1);
        String _plus_3 = (_plus_2 + ".txt");
        String _join = IterableExtensions.join(e.getContexts(), "\n");
        Pair<String, String> _mappedTo_1 = Pair.<String, String>of(_plus_3, _join);
        result.add(_mappedTo_1);
      }
    }
    List<NamedSerializationContexts<Pda<ISerState, RuleCall>>> _namedContexts_1 = names.<Pda<ISerState, RuleCall>>getNamedContexts(this.contextTypePDAProvider.getContextTypePDAs(this.grammar));
    for (final NamedSerializationContexts<Pda<ISerState, RuleCall>> e_1 : _namedContexts_1) {
      {
        String _name = e_1.getName();
        String _plus = (dir_context_type + _name);
        String _plus_1 = (_plus + ".dot");
        String _drawSafe = this.drawSafe(this.pdaToDot, e_1.getValue());
        Pair<String, String> _mappedTo = Pair.<String, String>of(_plus_1, _drawSafe);
        result.add(_mappedTo);
        String _name_1 = e_1.getName();
        String _plus_2 = (dir_context_type + _name_1);
        String _plus_3 = (_plus_2 + ".txt");
        String _join = IterableExtensions.join(e_1.getContexts(), "\n");
        Pair<String, String> _mappedTo_1 = Pair.<String, String>of(_plus_3, _join);
        result.add(_mappedTo_1);
      }
    }
    List<NamedSerializationContexts<ISyntacticSequencerPDAProvider.ISynAbsorberState>> _namedContexts_2 = names.<ISyntacticSequencerPDAProvider.ISynAbsorberState>getNamedContexts(this.syntacticSequencerPDAProvider.getSyntacticSequencerPDAs(this.grammar));
    for (final NamedSerializationContexts<ISyntacticSequencerPDAProvider.ISynAbsorberState> e_2 : _namedContexts_2) {
      {
        String _name = e_2.getName();
        String _plus = (dir_syntactic_sequencer + _name);
        String _plus_1 = (_plus + ".dot");
        String _drawSafe = this.drawSafe(this.syntacticSequencerPDA2Dot, e_2.getValue());
        Pair<String, String> _mappedTo = Pair.<String, String>of(_plus_1, _drawSafe);
        result.add(_mappedTo);
        String _name_1 = e_2.getName();
        String _plus_2 = (dir_syntactic_sequencer + _name_1);
        String _plus_3 = (_plus_2 + ".txt");
        String _join = IterableExtensions.join(e_2.getContexts(), "\n");
        Pair<String, String> _mappedTo_1 = Pair.<String, String>of(_plus_3, _join);
        result.add(_mappedTo_1);
      }
    }
    List<NamedSerializationContexts<Nfa<ISemanticSequencerNfaProvider.ISemState>>> _namedContexts_3 = names.<Nfa<ISemanticSequencerNfaProvider.ISemState>>getNamedContexts(this.semanticSequencerNFAProvider.getSemanticSequencerNFAs(this.grammar));
    for (final NamedSerializationContexts<Nfa<ISemanticSequencerNfaProvider.ISemState>> e_3 : _namedContexts_3) {
      {
        String _name = e_3.getName();
        String _plus = (dir_semantic_sequencer + _name);
        String _plus_1 = (_plus + ".dot");
        String _drawSafe = this.drawSafe(this.nfaToDot, e_3.getValue());
        Pair<String, String> _mappedTo = Pair.<String, String>of(_plus_1, _drawSafe);
        result.add(_mappedTo);
        String _name_1 = e_3.getName();
        String _plus_2 = (dir_semantic_sequencer + _name_1);
        String _plus_3 = (_plus_2 + ".txt");
        String _join = IterableExtensions.join(e_3.getContexts(), "\n");
        Pair<String, String> _mappedTo_1 = Pair.<String, String>of(_plus_3, _join);
        result.add(_mappedTo_1);
      }
    }
    try {
      int i = 0;
      final HashMap<ISyntacticSequencerPDAProvider.ISynTransition, String> trans2id = CollectionLiterals.<ISyntacticSequencerPDAProvider.ISynTransition, String>newHashMap();
      Set<ISyntacticSequencerPDAProvider.ISynTransition> _allAmbiguousTransitions = this.syntacticSequencerUtil.getAllAmbiguousTransitions();
      for (final ISyntacticSequencerPDAProvider.ISynTransition transition : _allAmbiguousTransitions) {
        {
          final String name = ("ambiguity_" + Integer.valueOf(i));
          String _directory = this.directory("syntactic_sequencer");
          String _plus = (_directory + name);
          String _plus_1 = (_plus + ".dot");
          String _draw = this.nfaToDot.draw(transition.getAmbiguousNfa());
          Pair<String, String> _mappedTo = Pair.<String, String>of(_plus_1, _draw);
          result.add(_mappedTo);
          trans2id.put(transition, name);
          i = (i + 1);
        }
      }
      final StringBuffer ambiguities = new StringBuffer();
      List<EqualAmbiguousTransitions> _allAmbiguousTransitionsBySyntax = this.syntacticSequencerUtil.getAllAmbiguousTransitionsBySyntax();
      for (final EqualAmbiguousTransitions group : _allAmbiguousTransitionsBySyntax) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("id: ");
        String _identifier = group.getIdentifier();
        _builder.append(_identifier);
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("Ambiguous syntax:»:");
        _builder.newLine();
        _builder.append("        ");
        String _replace = group.getElementAlias().toString().replace("\n", "\n        ");
        _builder.append(_replace, "        ");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("This ambiguous syntax occurs at:");
        _builder.newLine();
        {
          List<ISyntacticSequencerPDAProvider.ISynTransition> _transitions = group.getTransitions();
          for(final ISyntacticSequencerPDAProvider.ISynTransition trans : _transitions) {
            _builder.append("\t");
            String _get = trans2id.get(trans);
            _builder.append(_get, "\t");
            _builder.append(":");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("    ");
            String _replace_1 = group.ambiguityInsideTransition(trans).replace("\n", "\n        ");
            _builder.append(_replace_1, "\t    ");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.newLine();
        _builder.newLine();
        ambiguities.append(_builder);
      }
      String _directory = this.directory("syntactic_sequencer");
      String _plus = (_directory + "ambiguities.txt");
      String _string = ambiguities.toString();
      Pair<String, String> _mappedTo = Pair.<String, String>of(_plus, _string);
      result.add(_mappedTo);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e_4 = (Exception)_t;
        e_4.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return result;
  }

  private String drawSafe(final GraphvizDotBuilder builder, final Object graph) {
    String _xtrycatchfinallyexpression = null;
    try {
      _xtrycatchfinallyexpression = builder.draw(graph);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        InputOutput.<String>println("Error rendering");
        e.printStackTrace();
        return Throwables.getStackTraceAsString(e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }

  private String directory(final String name) {
    String _replace = this._xtextGeneratorNaming.getRuntimeBasePackage(this.grammar).replace(".", "/");
    String _plus = (_replace + "/serializer/");
    String _lowerCase = GrammarUtil.getSimpleName(this.grammar).toLowerCase();
    String _plus_1 = (_plus + _lowerCase);
    String _plus_2 = (_plus_1 + 
      "_");
    String _plus_3 = (_plus_2 + name);
    return (_plus_3 + "/");
  }
}
