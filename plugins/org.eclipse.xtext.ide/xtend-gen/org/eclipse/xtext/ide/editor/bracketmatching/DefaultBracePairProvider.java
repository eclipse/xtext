/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.bracketmatching;

import java.util.Collection;
import java.util.Collections;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.editor.bracketmatching.BracePair;
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@Accessors
@FinalFieldsConstructor
@SuppressWarnings("all")
public class DefaultBracePairProvider implements IBracePairProvider {
  private final Collection<BracePair> pairs;
  
  public DefaultBracePairProvider() {
    this(
      Collections.<BracePair>unmodifiableList(CollectionLiterals.<BracePair>newArrayList(new BracePair("(", ")", false), new BracePair("{", "}", true), new BracePair("[", "]", false))));
  }
  
  public DefaultBracePairProvider(final Collection<BracePair> pairs) {
    super();
    this.pairs = pairs;
  }
  
  @Pure
  public Collection<BracePair> getPairs() {
    return this.pairs;
  }
}
