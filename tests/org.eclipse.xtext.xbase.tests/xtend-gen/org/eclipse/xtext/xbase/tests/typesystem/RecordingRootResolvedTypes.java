package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.Map;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class RecordingRootResolvedTypes extends RootResolvedTypes {
  private Map<XExpression,ILinkingCandidate> _resolvedProxies;
  
  public Map<XExpression,ILinkingCandidate> getResolvedProxies() {
    return this._resolvedProxies;
  }
  
  public void setResolvedProxies(final Map<XExpression,ILinkingCandidate> resolvedProxies) {
    this._resolvedProxies = resolvedProxies;
  }
  
  public RecordingRootResolvedTypes(final DefaultReentrantTypeResolver resolver) {
    super(resolver);
  }
  
  public void resolveProxies() {
    Map<XExpression,ILinkingCandidate> _basicGetLinkingCandidates = this.basicGetLinkingCandidates();
    this.setResolvedProxies(_basicGetLinkingCandidates);
    super.resolveProxies();
  }
}
