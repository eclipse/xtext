/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.contentassist;

import java.util.Comparator;
import java.util.TreeSet;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.11
 */
@SuppressWarnings("all")
public class IdeContentProposalAcceptor implements IIdeContentProposalAcceptor, Comparator<Pair<Integer, ContentAssistEntry>> {
  protected final TreeSet<Pair<Integer, ContentAssistEntry>> entries = new TreeSet<Pair<Integer, ContentAssistEntry>>(this);
  
  @Override
  public void accept(final ContentAssistEntry entry, final int priority) {
    if ((entry != null)) {
      String _proposal = entry.getProposal();
      boolean _tripleEquals = (_proposal == null);
      if (_tripleEquals) {
        throw new IllegalArgumentException("proposal must not be null.");
      }
      Pair<Integer, ContentAssistEntry> _mappedTo = Pair.<Integer, ContentAssistEntry>of(Integer.valueOf(priority), entry);
      this.entries.add(_mappedTo);
    }
  }
  
  @Override
  public boolean canAcceptMoreProposals() {
    int _size = this.entries.size();
    return (_size < 100);
  }
  
  @Override
  public int compare(final Pair<Integer, ContentAssistEntry> p1, final Pair<Integer, ContentAssistEntry> p2) {
    final int prioResult = p2.getKey().compareTo(p1.getKey());
    if ((prioResult != 0)) {
      return prioResult;
    }
    String _elvis = null;
    String _label = p1.getValue().getLabel();
    if (_label != null) {
      _elvis = _label;
    } else {
      String _proposal = p1.getValue().getProposal();
      _elvis = _proposal;
    }
    final String s1 = _elvis;
    String _elvis_1 = null;
    String _label_1 = p2.getValue().getLabel();
    if (_label_1 != null) {
      _elvis_1 = _label_1;
    } else {
      String _proposal_1 = p2.getValue().getProposal();
      _elvis_1 = _proposal_1;
    }
    final String s2 = _elvis_1;
    final int ignoreCase = s1.compareToIgnoreCase(s2);
    if ((ignoreCase == 0)) {
      return s1.compareTo(s2);
    }
    return ignoreCase;
  }
  
  public Iterable<ContentAssistEntry> getEntries() {
    final Function1<Pair<Integer, ContentAssistEntry>, ContentAssistEntry> _function = (Pair<Integer, ContentAssistEntry> it) -> {
      return it.getValue();
    };
    return IterableExtensions.<Pair<Integer, ContentAssistEntry>, ContentAssistEntry>map(this.entries, _function);
  }
}
