package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer;
import org.eclipse.xtext.xbase.typesystem.internal.AbstractLinkingCandidate;

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
            try {
              if ((it instanceof AbstractLinkingCandidate)) {
                ((AbstractLinkingCandidate) it).computeArgumentTypes();
              }
            } catch (final Throwable _t) {
              if (_t instanceof UnsupportedOperationException) {
                final UnsupportedOperationException e = (UnsupportedOperationException)_t;
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
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
