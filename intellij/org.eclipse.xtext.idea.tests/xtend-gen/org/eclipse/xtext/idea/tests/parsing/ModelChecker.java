package org.eclipse.xtext.idea.tests.parsing;

import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public interface ModelChecker {
  public abstract <T extends EObject> T checkModel(final String code, final boolean validate);
}
