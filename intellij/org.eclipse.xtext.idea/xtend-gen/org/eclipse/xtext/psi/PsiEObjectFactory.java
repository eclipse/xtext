package org.eclipse.xtext.psi;

import com.google.inject.ImplementedBy;
import com.intellij.lang.ASTNode;
import org.eclipse.xtext.psi.impl.PsiEObjectFactoryImpl;

@ImplementedBy(PsiEObjectFactoryImpl.class)
@SuppressWarnings("all")
public interface PsiEObjectFactory {
  public abstract ASTNode createLeafIdentifier(final String name, final ASTNode context);
  
  public abstract ASTNode createCompositeIdentifier(final String name, final String currentName, final ASTNode context);
}
