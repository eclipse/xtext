/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.bracketmatching;

import com.google.inject.Singleton;
import java.util.Collections;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.editor.bracketmatching.BracePair;
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@Accessors
@FinalFieldsConstructor
@SuppressWarnings("all")
public class DefaultBracePairProvider implements IBracePairProvider {
  private final Set<BracePair> pairs;
  
  public DefaultBracePairProvider() {
    this(
      Collections.<BracePair>unmodifiableSet(CollectionLiterals.<BracePair>newHashSet(new BracePair("(", ")", true), new BracePair("{", "}", true), new BracePair("[", "]", true))));
  }
  
  public DefaultBracePairProvider(final Set<BracePair> pairs) {
    super();
    this.pairs = pairs;
  }
  
  @Pure
  public Set<BracePair> getPairs() {
    return this.pairs;
  }
}
