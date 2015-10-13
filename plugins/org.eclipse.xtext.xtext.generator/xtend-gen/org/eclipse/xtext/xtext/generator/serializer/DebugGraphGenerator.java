/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.serializer;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.serializer.analysis.IContextPDAProvider;
import org.eclipse.xtext.serializer.analysis.IContextTypePDAProvider;
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.util.formallang.NfaToDot;
import org.eclipse.xtext.util.formallang.PdaToDot;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
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
  @Extension
  private Context2NameFunction _context2NameFunction;
  
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getAllContexts(Grammar) is undefined for the type IContextPDAProvider"
      + "\nThe method getContextPDA(Grammar, Object) is undefined for the type IContextPDAProvider"
      + "\nThe method getTypesForContext(Grammar, Object) is undefined for the type IContextTypePDAProvider"
      + "\nThe method getContextTypePDA(Grammar, Object, Object) is undefined for the type IContextTypePDAProvider"
      + "\nThe method getPDA(Object, Object) is undefined for the type ISyntacticSequencerPDAProvider"
      + "\nThe method getNFA(Object, Object) is undefined for the type ISemanticSequencerNfaProvider"
      + "\nname cannot be resolved");
  }
  
  private String directory(final String name) {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(this.grammar);
    String _replace = _runtimeBasePackage.replace(".", "/");
    String _plus = (_replace + "/serializer/");
    String _simpleName = GrammarUtil.getSimpleName(this.grammar);
    String _lowerCase = _simpleName.toLowerCase();
    String _plus_1 = (_plus + _lowerCase);
    String _plus_2 = (_plus_1 + "_");
    String _plus_3 = (_plus_2 + name);
    return (_plus_3 + "/");
  }
  
  private String file(final String name, final EObject ctx, final EClass type) {
    String _directory = this.directory(name);
    String _contextName = this._context2NameFunction.getContextName(this.grammar, ctx);
    String _plus = (_directory + _contextName);
    String _plus_1 = (_plus + "_");
    String _name = null;
    if (type!=null) {
      _name=type.getName();
    }
    String _plus_2 = (_plus_1 + _name);
    return (_plus_2 + ".dot");
  }
  
  private String file(final String name, final EObject ctx) {
    String _directory = this.directory(name);
    String _contextName = this._context2NameFunction.getContextName(this.grammar, ctx);
    String _plus = (_directory + _contextName);
    return (_plus + ".dot");
  }
}
