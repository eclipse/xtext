/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.completion;

import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElement;

@SuppressWarnings("all")
public class CompletionExtensions {
  public void operator_add(final CompletionResultSet result, final LookupElement element) {
    result.addElement(element);
  }
  
  public void operator_add(final CompletionResultSet result, final Iterable<? extends LookupElement> elements) {
    result.addAllElements(elements);
  }
}
