/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
      String _valueOf = String.valueOf(DebugGrammarToken.store.get());
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
