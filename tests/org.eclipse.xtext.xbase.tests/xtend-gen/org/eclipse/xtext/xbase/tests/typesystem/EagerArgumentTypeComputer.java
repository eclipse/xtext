/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer;
import org.eclipse.xtext.xbase.typesystem.internal.AbstractPendingLinkingCandidate;

/**
 * @author Sebastian Zarnekow
 */
@Singleton
@SuppressWarnings("all")
public class EagerArgumentTypeComputer extends XbaseTypeComputer {
  protected <Candidate extends ILinkingCandidate> Candidate getBestCandidate(final List<? extends Candidate> candidates) {
    Candidate _xblockexpression = null;
    {
      final Procedure1<Candidate> _function = new Procedure1<Candidate>() {
          public void apply(final Candidate it) {
            if ((it instanceof AbstractPendingLinkingCandidate)) {
              ((AbstractPendingLinkingCandidate) it).computeArgumentTypes();
            }
          }
        };
      IterableExtensions.forEach(candidates, _function);
      Candidate _bestCandidate = super.<Candidate>getBestCandidate(candidates);
      _xblockexpression = (_bestCandidate);
    }
    return _xblockexpression;
  }
}
