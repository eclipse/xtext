package org.eclipse.xtext.idea.common.types.idea.lang.types;

import com.intellij.openapi.project.Project;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;
import org.eclipse.xtext.idea.types.JvmTypesShortNamesCache;

@SuppressWarnings("all")
public class RefactoringTestLanguageJvmTypesShortNamesCache extends JvmTypesShortNamesCache {
  public RefactoringTestLanguageJvmTypesShortNamesCache(final Project project) {
    super(RefactoringTestLanguageLanguage.INSTANCE, project);
  }
}
