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
