/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
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
  protected ILinkingCandidate getBestCandidate(final List<? extends ILinkingCandidate> candidates) {
    ILinkingCandidate _xblockexpression = null;
    {
      final Procedure1<ILinkingCandidate> _function = new Procedure1<ILinkingCandidate>() {
        public void apply(final ILinkingCandidate it) {
          if ((it instanceof AbstractPendingLinkingCandidate<?>)) {
            ((AbstractPendingLinkingCandidate<?>)it).computeArgumentTypes();
          }
        }
      };
      IterableExtensions.forEach(candidates, _function);
      _xblockexpression = super.getBestCandidate(candidates);
    }
    return _xblockexpression;
  }
}
