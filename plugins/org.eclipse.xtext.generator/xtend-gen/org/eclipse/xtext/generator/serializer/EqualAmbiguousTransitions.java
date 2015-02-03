/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.serializer;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.serializer.analysis.GrammarAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.util.formallang.Production;
import org.eclipse.xtext.util.formallang.ProductionFormatter;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Accessors
@FinalFieldsConstructor
@SuppressWarnings("all")
public class EqualAmbiguousTransitions implements Comparable<EqualAmbiguousTransitions> {
  private final String identifyer;
  
  private final List<ISyntacticSequencerPDAProvider.ISynTransition> transitions = CollectionLiterals.<ISyntacticSequencerPDAProvider.ISynTransition>newArrayList();
  
  private final GrammarAlias.AbstractElementAlias elementAlias;
  
  @Override
  public int compareTo(final EqualAmbiguousTransitions o) {
    return this.identifyer.compareTo(o.identifyer);
  }
  
  public String ambiguityInsideTransition(final ISyntacticSequencerPDAProvider.ISynTransition trans) {
    GrammarElementTitleSwitch _grammarElementTitleSwitch = new GrammarElementTitleSwitch();
    GrammarElementTitleSwitch _showAssignments = _grammarElementTitleSwitch.showAssignments();
    GrammarElementTitleSwitch _hideCardinality = _showAssignments.hideCardinality();
    final GrammarElementTitleSwitch tokenToString = _hideCardinality.setValueForNull("");
    final ProductionFormatter<GrammarAlias.AbstractElementAlias, AbstractElement> formatter = new ProductionFormatter<GrammarAlias.AbstractElementAlias, AbstractElement>() {
      @Override
      public String format(final Production<GrammarAlias.AbstractElementAlias, AbstractElement> adapter, final GrammarAlias.AbstractElementAlias grammarElement, final boolean needParenthesis) {
        String _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          boolean _equals = Objects.equal(grammarElement, EqualAmbiguousTransitions.this.elementAlias);
          if (_equals) {
            _matched=true;
            return "(ambiguity)";
          }
        }
        if (!_matched) {
          if (grammarElement instanceof GrammarAlias.TokenAlias) {
            AbstractElement _token = ((GrammarAlias.TokenAlias)grammarElement).getToken();
            boolean _equals_1 = Objects.equal(_token, null);
            if (_equals_1) {
              _matched=true;
              return "";
            }
          }
        }
        if (!_matched) {
          _switchResult = super.format(adapter, grammarElement, needParenthesis);
        }
        return _switchResult;
      }
    }.setTokenToString(tokenToString);
    GrammarAlias.AbstractElementAlias _ambiguousSyntax = trans.getAmbiguousSyntax();
    final GrammarAlias.GrammarAliasAdapter adapter = new GrammarAlias.GrammarAliasAdapter(_ambiguousSyntax);
    GrammarAlias.AbstractElementAlias _root = adapter.getRoot();
    return formatter.format(adapter, _root, false);
  }
  
  public EqualAmbiguousTransitions(final String identifyer, final GrammarAlias.AbstractElementAlias elementAlias) {
    super();
    this.identifyer = identifyer;
    this.elementAlias = elementAlias;
  }
  
  @Pure
  public String getIdentifyer() {
    return this.identifyer;
  }
  
  @Pure
  public List<ISyntacticSequencerPDAProvider.ISynTransition> getTransitions() {
    return this.transitions;
  }
  
  @Pure
  public GrammarAlias.AbstractElementAlias getElementAlias() {
    return this.elementAlias;
  }
}
