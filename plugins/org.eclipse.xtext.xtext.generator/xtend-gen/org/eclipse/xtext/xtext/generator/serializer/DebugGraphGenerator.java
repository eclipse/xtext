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
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.analysis.GrammarAlias;
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
    Map<ISerializationContext, Pda<ISerState, RuleCall>> _contextPDAs = this.contextPDAProvider.getContextPDAs(this.grammar);
    Set<Map.Entry<ISerializationContext, Pda<ISerState, RuleCall>>> _entrySet = _contextPDAs.entrySet();
    for (final Map.Entry<ISerializationContext, Pda<ISerState, RuleCall>> e : _entrySet) {
      ISerializationContext _key = e.getKey();
      String _file = this.file("context", _key);
      ISerializationContext _key_1 = e.getKey();
      Pda<ISerState, RuleCall> _value = e.getValue();
      String _drawSafe = this.drawSafe(this.pdaToDot, _key_1, _value);
      Pair<String, String> _mappedTo = Pair.<String, String>of(_file, _drawSafe);
      result.add(_mappedTo);
    }
    Map<ISerializationContext, Pda<ISerState, RuleCall>> _contextTypePDAs = this.contextTypePDAProvider.getContextTypePDAs(this.grammar);
    Set<Map.Entry<ISerializationContext, Pda<ISerState, RuleCall>>> _entrySet_1 = _contextTypePDAs.entrySet();
    for (final Map.Entry<ISerializationContext, Pda<ISerState, RuleCall>> e_1 : _entrySet_1) {
      ISerializationContext _key_2 = e_1.getKey();
      String _file_1 = this.file("context_type", _key_2);
      ISerializationContext _key_3 = e_1.getKey();
      Pda<ISerState, RuleCall> _value_1 = e_1.getValue();
      String _drawSafe_1 = this.drawSafe(this.pdaToDot, _key_3, _value_1);
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of(_file_1, _drawSafe_1);
      result.add(_mappedTo_1);
    }
    Map<ISerializationContext, ISyntacticSequencerPDAProvider.ISynAbsorberState> _syntacticSequencerPDAs = this.syntacticSequencerPDAProvider.getSyntacticSequencerPDAs(this.grammar);
    Set<Map.Entry<ISerializationContext, ISyntacticSequencerPDAProvider.ISynAbsorberState>> _entrySet_2 = _syntacticSequencerPDAs.entrySet();
    for (final Map.Entry<ISerializationContext, ISyntacticSequencerPDAProvider.ISynAbsorberState> e_2 : _entrySet_2) {
      ISerializationContext _key_4 = e_2.getKey();
      String _file_2 = this.file("syntactic_sequencer", _key_4);
      ISerializationContext _key_5 = e_2.getKey();
      ISyntacticSequencerPDAProvider.ISynAbsorberState _value_2 = e_2.getValue();
      String _drawSafe_2 = this.drawSafe(this.syntacticSequencerPDA2Dot, _key_5, _value_2);
      Pair<String, String> _mappedTo_2 = Pair.<String, String>of(_file_2, _drawSafe_2);
      result.add(_mappedTo_2);
    }
    Map<ISerializationContext, Nfa<ISemanticSequencerNfaProvider.ISemState>> _semanticSequencerNFAs = this.semanticSequencerNFAProvider.getSemanticSequencerNFAs(this.grammar);
    Set<Map.Entry<ISerializationContext, Nfa<ISemanticSequencerNfaProvider.ISemState>>> _entrySet_3 = _semanticSequencerNFAs.entrySet();
    for (final Map.Entry<ISerializationContext, Nfa<ISemanticSequencerNfaProvider.ISemState>> e_3 : _entrySet_3) {
      ISerializationContext _key_6 = e_3.getKey();
      String _file_3 = this.file("semantic_sequencer", _key_6);
      ISerializationContext _key_7 = e_3.getKey();
      Nfa<ISemanticSequencerNfaProvider.ISemState> _value_3 = e_3.getValue();
      String _drawSafe_3 = this.drawSafe(this.nfaToDot, _key_7, _value_3);
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
  
  private String drawSafe(final GraphvizDotBuilder builder, final ISerializationContext context, final Object graph) {
    String _xtrycatchfinallyexpression = null;
    try {
      _xtrycatchfinallyexpression = builder.draw(graph);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        InputOutput.<String>println(("Error rendering " + context));
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
  
  private String file(final String name, final ISerializationContext contexts) {
    String _directory = this.directory(name);
    String _plus = (_directory + contexts);
    return (_plus + ".dot");
  }
}
