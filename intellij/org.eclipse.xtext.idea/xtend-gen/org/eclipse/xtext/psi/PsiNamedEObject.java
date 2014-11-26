package org.eclipse.xtext.psi;

import com.intellij.pom.PomRenameableTarget;
import com.intellij.psi.PsiNameIdentifierOwner;
import org.eclipse.xtext.psi.PsiEObject;
import org.eclipse.xtext.psi.PsiEObjectIdentifier;

@SuppressWarnings("all")
public interface PsiNamedEObject extends PsiEObject, PsiNameIdentifierOwner, PomRenameableTarget<PsiNamedEObject> {
  public abstract PsiEObjectIdentifier getNameIdentifier();
}
