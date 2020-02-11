/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Singleton;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer;
import org.eclipse.xtext.xbase.typesystem.internal.AbstractPendingLinkingCandidate;

/**
 * @author Sebastian Zarnekow
 */
@Singleton
@SuppressWarnings("all")
public class EagerArgumentTypeComputer extends XbaseTypeComputer {
  @Override
  protected ILinkingCandidate getBestCandidate(final List<? extends ILinkingCandidate> candidates) {
    ILinkingCandidate _xblockexpression = null;
    {
      final Consumer<ILinkingCandidate> _function = (ILinkingCandidate it) -> {
        if ((it instanceof AbstractPendingLinkingCandidate<?>)) {
          ((AbstractPendingLinkingCandidate<?>)it).computeArgumentTypes();
        }
      };
      candidates.forEach(_function);
      _xblockexpression = super.getBestCandidate(candidates);
    }
    return _xblockexpression;
  }
}
