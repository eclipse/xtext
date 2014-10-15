package org.eclipse.xtext.idea.example.entities.idea.lang.types;

import com.intellij.openapi.project.Project;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.idea.types.JvmTypesShortNamesCache;

@SuppressWarnings("all")
public class EntitiesJvmTypesShortNamesCache extends JvmTypesShortNamesCache {
  public EntitiesJvmTypesShortNamesCache(final Project project) {
    super(EntitiesLanguage.INSTANCE, project);
  }
}
