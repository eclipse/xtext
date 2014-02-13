/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.serializer;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.serializer.SyntacticSequencerPDA2ExtendedDot;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.serializer.analysis.IContextPDAProvider;
import org.eclipse.xtext.serializer.analysis.IContextProvider;
import org.eclipse.xtext.serializer.analysis.IContextTypePDAProvider;
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider;
import org.eclipse.xtext.serializer.analysis.ISerState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.util.formallang.NfaToDot;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaToDot;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class DebugGraphGenerator {
  @Inject
  @Extension
  private IContextProvider contextProvider;
  
  @Inject
  private Grammar grammar;
  
  @Inject
  @Extension
  private Naming naming;
  
  @Inject
  @Extension
  private Context2NameFunction nameFunction;
  
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
  private PdaToDot pdaToDot;
  
  @Inject
  private NfaToDot nfaToDot;
  
  public Iterable<Pair<String,String>> generateDebugGraphs() {
    ArrayList<Pair<String,String>> _xblockexpression = null;
    {
      final ArrayList<Pair<String,String>> result = CollectionLiterals.<Pair<String,String>>newArrayList();
      List<EObject> _allContexts = this.contextProvider.getAllContexts(this.grammar);
      for (final EObject context : _allContexts) {
        try {
          String _file = this.file("context", context);
          Pda<ISerState,RuleCall> _contextPDA = this.contextPDAProvider.getContextPDA(context);
          String _draw = this.pdaToDot.draw(_contextPDA);
          Pair<String,String> _mappedTo = Pair.<String, String>of(_file, _draw);
          result.add(_mappedTo);
          Set<EClass> _typesForContext = this.contextProvider.getTypesForContext(context);
          for (final EClass type : _typesForContext) {
            try {
              String _file_1 = this.file("context_type", context, type);
              Pda<ISerState,RuleCall> _contextTypePDA = this.contextTypePDAProvider.getContextTypePDA(context, type);
              String _draw_1 = this.pdaToDot.draw(_contextTypePDA);
              Pair<String,String> _mappedTo_1 = Pair.<String, String>of(_file_1, _draw_1);
              result.add(_mappedTo_1);
              String _file_2 = this.file("syntactic_sequencer", context, type);
              ISyntacticSequencerPDAProvider.ISynAbsorberState _pDA = this.syntacticSequencerPDAProvider.getPDA(context, type);
              String _draw_2 = this.syntacticSequencerPDA2Dot.draw(_pDA);
              Pair<String,String> _mappedTo_2 = Pair.<String, String>of(_file_2, _draw_2);
              result.add(_mappedTo_2);
              String _file_3 = this.file("semantic_sequencer", context, type);
              Nfa<ISemanticSequencerNfaProvider.ISemState> _nFA = this.semanticSequencerNFAProvider.getNFA(context, type);
              String _draw_3 = this.nfaToDot.draw(_nFA);
              Pair<String,String> _mappedTo_3 = Pair.<String, String>of(_file_3, _draw_3);
              result.add(_mappedTo_3);
            } catch (final Throwable _t) {
              if (_t instanceof Throwable) {
                final Throwable t = (Throwable)_t;
                String _contextName = this.nameFunction.getContextName(context);
                String _plus = ("Context: " + _contextName);
                String _plus_1 = (_plus + " Type:");
                String _name = null;
                if (type!=null) {
                  _name=type.getName();
                }
                String _plus_2 = (_plus_1 + _name);
                System.out.println(_plus_2);
                t.printStackTrace();
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          }
        } catch (final Throwable _t_1) {
          if (_t_1 instanceof Throwable) {
            final Throwable t_1 = (Throwable)_t_1;
            String _contextName_1 = this.nameFunction.getContextName(context);
            String _plus_3 = ("Context: " + _contextName_1);
            System.out.println(_plus_3);
            t_1.printStackTrace();
          } else {
            throw Exceptions.sneakyThrow(_t_1);
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public String directory(final String name) {
    String _basePackageRuntime = this.naming.basePackageRuntime(this.grammar);
    String _asPath = this.naming.asPath(_basePackageRuntime);
    String _plus = (_asPath + "/serializer/");
    String _name = this.grammar.getName();
    String _simpleName = this.naming.toSimpleName(_name);
    String _lowerCase = _simpleName.toLowerCase();
    String _plus_1 = (_plus + _lowerCase);
    String _plus_2 = (_plus_1 + "_");
    String _plus_3 = (_plus_2 + name);
    return (_plus_3 + "/");
  }
  
  public String file(final String name, final EObject ctx, final EClass type) {
    String _directory = this.directory(name);
    String _contextName = this.nameFunction.getContextName(ctx);
    String _plus = (_directory + _contextName);
    String _plus_1 = (_plus + "_");
    String _name = null;
    if (type!=null) {
      _name=type.getName();
    }
    String _plus_2 = (_plus_1 + _name);
    return (_plus_2 + ".dot");
  }
  
  public String file(final String name, final EObject ctx) {
    String _directory = this.directory(name);
    String _contextName = this.nameFunction.getContextName(ctx);
    String _plus = (_directory + _contextName);
    return (_plus + ".dot");
  }
}
