/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.serializer;

import java.util.List;
import java.util.Set;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.util.GraphvizDotBuilder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class SyntacticSequencerPDA2ExtendedDot extends GraphvizDotBuilder {
  @Override
  protected GraphvizDotBuilder.Props drawObject(final Object obj) {
    GraphvizDotBuilder.Digraph _xifexpression = null;
    if ((obj instanceof ISyntacticSequencerPDAProvider.ISynState)) {
      _xifexpression = this.drawGrammar(((ISyntacticSequencerPDAProvider.ISynState)obj));
    }
    return _xifexpression;
  }
  
  protected GraphvizDotBuilder.Digraph drawGrammar(final ISyntacticSequencerPDAProvider.ISynState pr) {
    final GraphvizDotBuilder.Digraph d = new GraphvizDotBuilder.Digraph();
    final Set<ISyntacticSequencerPDAProvider.ISynState> visited = CollectionLiterals.<ISyntacticSequencerPDAProvider.ISynState>newHashSet();
    this.drawState(d, pr, visited);
    return d;
  }
  
  protected void drawState(final GraphvizDotBuilder.Digraph d, final ISyntacticSequencerPDAProvider.ISynState state, final Set<ISyntacticSequencerPDAProvider.ISynState> visited) {
    boolean _add = visited.add(state);
    boolean _not = (!_add);
    if (_not) {
      return;
    }
    String _string = state.toString();
    final GraphvizDotBuilder.Node n = new GraphvizDotBuilder.Node(state, _string);
    if ((!(state instanceof ISyntacticSequencerPDAProvider.ISynAbsorberState))) {
      n.setStyle("dotted");
    }
    d.add(n);
    List<ISyntacticSequencerPDAProvider.ISynState> _followers = state.getFollowers();
    for (final ISyntacticSequencerPDAProvider.ISynState trans : _followers) {
      {
        final GraphvizDotBuilder.Edge edge = new GraphvizDotBuilder.Edge(state, trans);
        d.add(edge);
        this.drawState(d, trans, visited);
      }
    }
  }
}
