package org.eclipse.xtext.idea.refactoring;

import com.google.common.base.Objects;
import com.intellij.lang.refactoring.NamesValidator;
import com.intellij.openapi.project.Project;

@SuppressWarnings("all")
public class NullNamesValidator implements NamesValidator {
  @Override
  public boolean isIdentifier(final String name, final Project project) {
    return (!Objects.equal(name, null));
  }
  
  @Override
  public boolean isKeyword(final String name, final Project project) {
    return false;
  }
}
