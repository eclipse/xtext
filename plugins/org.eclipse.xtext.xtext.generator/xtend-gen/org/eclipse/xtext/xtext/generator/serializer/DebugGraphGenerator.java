/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.serializer;

import com.google.common.base.Throwables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.serializer.analysis.GrammarAlias;
import org.eclipse.xtext.serializer.analysis.IContext;
import org.eclipse.xtext.serializer.analysis.IContextPDAProvider;
import org.eclipse.xtext.serializer.analysis.IContextTypePDAProvider;
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider;
import org.eclipse.xtext.serializer.analysis.ISerState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.serializer.analysis.SerializationContext;
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
import org.eclipse.xtext.xtext.generator.serializer.EqualAmbiguousTransitions;
import org.eclipse.xtext.xtext.generator.serializer.SyntacticSequencerExtensions;
import org.eclipse.xtext.xtext.generator.serializer.SyntacticSequencerPDA2ExtendedDot;

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
    Map<IContext, Pda<ISerState, RuleCall>> _contextPDAs = this.contextPDAProvider.getContextPDAs(this.grammar);
    List<org.eclipse.xtext.util.Pair<List<IContext>, Pda<ISerState, RuleCall>>> _groupByEqualityAndSort = SerializationContext.<Pda<ISerState, RuleCall>>groupByEqualityAndSort(_contextPDAs);
    for (final org.eclipse.xtext.util.Pair<List<IContext>, Pda<ISerState, RuleCall>> e : _groupByEqualityAndSort) {
      List<IContext> _first = e.getFirst();
      String _file = this.file("context", _first);
      List<IContext> _first_1 = e.getFirst();
      Pda<ISerState, RuleCall> _second = e.getSecond();
      String _drawSafe = this.drawSafe(this.pdaToDot, _first_1, _second);
      Pair<String, String> _mappedTo = Pair.<String, String>of(_file, _drawSafe);
      result.add(_mappedTo);
    }
    Map<IContext, Pda<ISerState, RuleCall>> _contextTypePDAs = this.contextTypePDAProvider.getContextTypePDAs(this.grammar);
    List<org.eclipse.xtext.util.Pair<List<IContext>, Pda<ISerState, RuleCall>>> _groupByEqualityAndSort_1 = SerializationContext.<Pda<ISerState, RuleCall>>groupByEqualityAndSort(_contextTypePDAs);
    for (final org.eclipse.xtext.util.Pair<List<IContext>, Pda<ISerState, RuleCall>> e_1 : _groupByEqualityAndSort_1) {
      List<IContext> _first_2 = e_1.getFirst();
      String _file_1 = this.file("context_type", _first_2);
      List<IContext> _first_3 = e_1.getFirst();
      Pda<ISerState, RuleCall> _second_1 = e_1.getSecond();
      String _drawSafe_1 = this.drawSafe(this.pdaToDot, _first_3, _second_1);
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of(_file_1, _drawSafe_1);
      result.add(_mappedTo_1);
    }
    Map<IContext, ISyntacticSequencerPDAProvider.ISynAbsorberState> _syntacticSequencerPDAs = this.syntacticSequencerPDAProvider.getSyntacticSequencerPDAs(this.grammar);
    List<org.eclipse.xtext.util.Pair<List<IContext>, ISyntacticSequencerPDAProvider.ISynAbsorberState>> _groupByEqualityAndSort_2 = SerializationContext.<ISyntacticSequencerPDAProvider.ISynAbsorberState>groupByEqualityAndSort(_syntacticSequencerPDAs);
    for (final org.eclipse.xtext.util.Pair<List<IContext>, ISyntacticSequencerPDAProvider.ISynAbsorberState> e_2 : _groupByEqualityAndSort_2) {
      List<IContext> _first_4 = e_2.getFirst();
      String _file_2 = this.file("syntactic_sequencer", _first_4);
      List<IContext> _first_5 = e_2.getFirst();
      ISyntacticSequencerPDAProvider.ISynAbsorberState _second_2 = e_2.getSecond();
      String _drawSafe_2 = this.drawSafe(this.syntacticSequencerPDA2Dot, _first_5, _second_2);
      Pair<String, String> _mappedTo_2 = Pair.<String, String>of(_file_2, _drawSafe_2);
      result.add(_mappedTo_2);
    }
    Map<IContext, Nfa<ISemanticSequencerNfaProvider.ISemState>> _semanticSequencerNFAs = this.semanticSequencerNFAProvider.getSemanticSequencerNFAs(this.grammar);
    List<org.eclipse.xtext.util.Pair<List<IContext>, Nfa<ISemanticSequencerNfaProvider.ISemState>>> _groupByEqualityAndSort_3 = SerializationContext.<Nfa<ISemanticSequencerNfaProvider.ISemState>>groupByEqualityAndSort(_semanticSequencerNFAs);
    for (final org.eclipse.xtext.util.Pair<List<IContext>, Nfa<ISemanticSequencerNfaProvider.ISemState>> e_3 : _groupByEqualityAndSort_3) {
      List<IContext> _first_6 = e_3.getFirst();
      String _file_3 = this.file("semantic_sequencer", _first_6);
      List<IContext> _first_7 = e_3.getFirst();
      Nfa<ISemanticSequencerNfaProvider.ISemState> _second_3 = e_3.getSecond();
      String _drawSafe_3 = this.drawSafe(this.nfaToDot, _first_7, _second_3);
      Pair<String, String> _mappedTo_3 = Pair.<String, String>of(_file_3, _drawSafe_3);
      result.add(_mappedTo_3);
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
          Nfa<ISyntacticSequencerPDAProvider.ISynState> _ambiguousNfa = transition.getAmbiguousNfa();
          String _draw = this.nfaToDot.draw(_ambiguousNfa);
          Pair<String, String> _mappedTo_4 = Pair.<String, String>of(_plus_1, _draw);
          result.add(_mappedTo_4);
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
        _builder.append(_identifier, "");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("Ambiguous syntax:»:");
        _builder.newLine();
        _builder.append("        ");
        GrammarAlias.AbstractElementAlias _elementAlias = group.getElementAlias();
        String _string = _elementAlias.toString();
        String _replace = _string.replace("\n", "\n        ");
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
            String _ambiguityInsideTransition = group.ambiguityInsideTransition(trans);
            String _replace_1 = _ambiguityInsideTransition.replace("\n", "\n        ");
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
      String _string_1 = ambiguities.toString();
      Pair<String, String> _mappedTo_4 = Pair.<String, String>of(_plus, _string_1);
      result.add(_mappedTo_4);
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
  
  private String drawSafe(final GraphvizDotBuilder builder, final Iterable<IContext> contexts, final Object graph) {
    String _xtrycatchfinallyexpression = null;
    try {
      _xtrycatchfinallyexpression = builder.draw(graph);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        String _join = IterableExtensions.join(contexts, ",");
        String _plus = ("Error rendering " + _join);
        InputOutput.<String>println(_plus);
        e.printStackTrace();
        return Throwables.getStackTraceAsString(e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  private String directory(final String name) {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(this.grammar);
    String _replace = _runtimeBasePackage.replace(".", "/");
    String _plus = (_replace + "/serializer/");
    String _simpleName = GrammarUtil.getSimpleName(this.grammar);
    String _lowerCase = _simpleName.toLowerCase();
    String _plus_1 = (_plus + _lowerCase);
    String _plus_2 = (_plus_1 + 
      "_");
    String _plus_3 = (_plus_2 + name);
    return (_plus_3 + "/");
  }
  
  private String file(final String name, final Iterable<IContext> contexts) {
    String _directory = this.directory(name);
    List<IContext> _sort = IterableExtensions.<IContext>sort(contexts);
    String _join = IterableExtensions.join(_sort, "_");
    String _plus = (_directory + _join);
    return (_plus + ".dot");
  }
}
