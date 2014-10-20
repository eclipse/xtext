package org.eclipse.xtext.idea.example.entities.idea.lang.types.psi;

import com.intellij.openapi.project.Project;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.idea.types.psi.JvmTypesElementFinder;

@SuppressWarnings("all")
public class EntitiesJvmTypesElementFinder extends JvmTypesElementFinder {
  public EntitiesJvmTypesElementFinder(final Project project) {
    super(EntitiesLanguage.INSTANCE, project);
  }
}
