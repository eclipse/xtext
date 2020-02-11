/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.serializer;

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
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Accessors
@FinalFieldsConstructor
@SuppressWarnings("all")
public class EqualAmbiguousTransitions implements Comparable<EqualAmbiguousTransitions> {
  private final String identifier;
  
  private final List<ISyntacticSequencerPDAProvider.ISynTransition> transitions = CollectionLiterals.<ISyntacticSequencerPDAProvider.ISynTransition>newArrayList();
  
  private final GrammarAlias.AbstractElementAlias elementAlias;
  
  @Override
  public int compareTo(final EqualAmbiguousTransitions o) {
    return this.identifier.compareTo(o.identifier);
  }
  
  public String ambiguityInsideTransition(final ISyntacticSequencerPDAProvider.ISynTransition trans) {
    try {
      final GrammarElementTitleSwitch tokenToString = new GrammarElementTitleSwitch().showAssignments().hideCardinality().setValueForNull("");
      final ProductionFormatter<GrammarAlias.AbstractElementAlias, AbstractElement> formatter = new ProductionFormatter<GrammarAlias.AbstractElementAlias, AbstractElement>() {
        @Override
        public String format(final Production<GrammarAlias.AbstractElementAlias, AbstractElement> adapter, final GrammarAlias.AbstractElementAlias grammarElement, final boolean needParenthesis) {
          String _switchResult = null;
          boolean _matched = false;
          boolean _equals = Objects.equal(grammarElement, EqualAmbiguousTransitions.this.elementAlias);
          if (_equals) {
            _matched=true;
            return "(ambiguity)";
          }
          if (!_matched) {
            if (grammarElement instanceof GrammarAlias.TokenAlias) {
              boolean _isStart = EqualAmbiguousTransitions.this.isStart(((GrammarAlias.TokenAlias)grammarElement));
              if (_isStart) {
                _matched=true;
                return "(rule start)";
              }
            }
          }
          if (!_matched) {
            if (grammarElement instanceof GrammarAlias.TokenAlias) {
              boolean _isStop = EqualAmbiguousTransitions.this.isStop(((GrammarAlias.TokenAlias)grammarElement));
              if (_isStop) {
                _matched=true;
                return "(rule end)";
              }
            }
          }
          if (!_matched) {
            _switchResult = super.format(adapter, grammarElement, needParenthesis);
          }
          return _switchResult;
        }
      }.setTokenToString(tokenToString).setAutoWrapChars(200).setAutoWrapChildren(20);
      GrammarAlias.AbstractElementAlias _ambiguousSyntax = trans.getAmbiguousSyntax();
      final GrammarAlias.GrammarAliasAdapter adapter = new GrammarAlias.GrammarAliasAdapter(_ambiguousSyntax);
      return formatter.format(adapter, adapter.getRoot(), false);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        e.printStackTrace();
        return "";
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  private boolean isStart(final GrammarAlias.TokenAlias it) {
    return (((it.getToken() == null) && (it.getParent() instanceof GrammarAlias.GroupAlias)) && Objects.equal(it, IterableExtensions.<GrammarAlias.AbstractElementAlias>head(((GrammarAlias.GroupAlias) it.getParent()).getChildren())));
  }
  
  private boolean isStop(final GrammarAlias.TokenAlias it) {
    return (((it.getToken() == null) && (it.getParent() instanceof GrammarAlias.GroupAlias)) && Objects.equal(it, IterableExtensions.<GrammarAlias.AbstractElementAlias>last(((GrammarAlias.GroupAlias) it.getParent()).getChildren())));
  }
  
  public EqualAmbiguousTransitions(final String identifier, final GrammarAlias.AbstractElementAlias elementAlias) {
    super();
    this.identifier = identifier;
    this.elementAlias = elementAlias;
  }
  
  @Pure
  public String getIdentifier() {
    return this.identifier;
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
