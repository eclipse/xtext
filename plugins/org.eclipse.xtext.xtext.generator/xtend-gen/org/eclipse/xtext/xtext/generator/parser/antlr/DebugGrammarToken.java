/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import com.google.common.base.Objects;

/**
 * Static utility that allows to check if the current thread is producing
 * a debug grammar or not.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noreference
 */
@SuppressWarnings("all")
public class DebugGrammarToken {
  private static ThreadLocal<Boolean> store = new ThreadLocal<Boolean>();
  
  public static DebugGrammarToken aquire() {
    Boolean _get = DebugGrammarToken.store.get();
    boolean _tripleNotEquals = (_get != null);
    if (_tripleNotEquals) {
      Boolean _get_1 = DebugGrammarToken.store.get();
      String _valueOf = String.valueOf(_get_1);
      throw new IllegalStateException(_valueOf);
    }
    return new DebugGrammarToken();
  }
  
  public static boolean isGeneratingDebugGrammar() {
    Boolean _get = DebugGrammarToken.store.get();
    return Objects.equal(_get, Boolean.TRUE);
  }
  
  private DebugGrammarToken() {
    DebugGrammarToken.store.set(Boolean.TRUE);
  }
  
  public void done() {
    DebugGrammarToken.store.set(null);
  }
}
