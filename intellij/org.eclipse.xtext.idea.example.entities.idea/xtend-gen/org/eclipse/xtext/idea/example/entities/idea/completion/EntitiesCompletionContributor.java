package org.eclipse.xtext.idea.example.entities.idea.completion;

import org.eclipse.xtext.idea.completion.AbstractCompletionContributor;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;

@SuppressWarnings("all")
public class EntitiesCompletionContributor extends AbstractCompletionContributor {
  public EntitiesCompletionContributor() {
    super(EntitiesLanguage.INSTANCE);
  }
}
