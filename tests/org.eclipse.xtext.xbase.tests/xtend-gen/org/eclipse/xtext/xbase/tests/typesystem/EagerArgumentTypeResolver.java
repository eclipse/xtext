package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer;

/**
 * @author Sebastian Zarnekow
 */
@Singleton
@SuppressWarnings("all")
public class EagerArgumentTypeResolver extends XbaseTypeComputer {
  protected <Candidate extends ILinkingCandidate<Candidate>> Candidate getBestCandidate(final List<Candidate> candidates) {
    Candidate _bestCandidate = super.<Candidate>getBestCandidate(candidates);
    return _bestCandidate;
  }
}
