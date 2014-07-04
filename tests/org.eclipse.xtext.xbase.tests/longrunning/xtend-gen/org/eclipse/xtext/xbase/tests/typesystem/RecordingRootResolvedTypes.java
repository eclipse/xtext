/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.Map;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.typesystem.computation.IApplicableCandidate;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class RecordingRootResolvedTypes extends RootResolvedTypes {
  @Property
  private Map<XExpression, IApplicableCandidate> _resolvedProxies;
  
  public RecordingRootResolvedTypes(final DefaultReentrantTypeResolver resolver) {
    super(resolver);
  }
  
  public void resolveProxies() {
    Map<XExpression, IApplicableCandidate> _basicGetLinkingMap = this.basicGetLinkingMap();
    this.setResolvedProxies(_basicGetLinkingMap);
    super.resolveProxies();
  }
  
  @Pure
  public Map<XExpression, IApplicableCandidate> getResolvedProxies() {
    return this._resolvedProxies;
  }
  
  public void setResolvedProxies(final Map<XExpression, IApplicableCandidate> resolvedProxies) {
    this._resolvedProxies = resolvedProxies;
  }
}
