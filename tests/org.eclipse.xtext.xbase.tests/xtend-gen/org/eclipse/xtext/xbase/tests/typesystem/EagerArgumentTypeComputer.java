package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
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
  protected <Candidate extends ILinkingCandidate<Candidate>> Candidate getBestCandidate(final List<Candidate> candidates) {
    Candidate _xblockexpression = null;
    {
      final Procedure1<Candidate> _function = new Procedure1<Candidate>() {
          public void apply(final Candidate it) {
            JvmIdentifiableElement _feature = it.getFeature();
            ((AbstractLinkingCandidate) it).computeArgumentTypes(_feature);
          }
        };
      IterableExtensions.<Candidate>forEach(candidates, _function);
      Candidate _bestCandidate = super.<Candidate>getBestCandidate(candidates);
      _xblockexpression = (_bestCandidate);
    }
    return _xblockexpression;
  }
}
