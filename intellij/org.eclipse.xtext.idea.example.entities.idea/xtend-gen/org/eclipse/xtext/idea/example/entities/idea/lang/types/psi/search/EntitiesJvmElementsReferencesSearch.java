package org.eclipse.xtext.idea.example.entities.idea.lang.types.psi.search;

import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.idea.types.psi.search.JvmElementsReferencesSearch;

@SuppressWarnings("all")
public class EntitiesJvmElementsReferencesSearch extends JvmElementsReferencesSearch {
  public EntitiesJvmElementsReferencesSearch() {
    super(EntitiesLanguage.INSTANCE);
  }
}
