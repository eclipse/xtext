/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.refactoring;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.ui.refactoring.XbaseReferenceUpdater;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * 
 * @since 2.12
 */
@SuppressWarnings("all")
public class XtendReferenceUpdater extends XbaseReferenceUpdater {
  @Override
  protected void createReferenceUpdate(final EObject referringElement, final URI referringResourceURI, final EReference reference, final int indexInList, final EObject newTargetElement, final IRefactoringUpdateAcceptor updateAcceptor) {
    if ((((referringElement instanceof XConstructorCall) && (referringElement.eContainer() instanceof AnonymousClass)) && (newTargetElement instanceof JvmType))) {
      return;
    }
    super.createReferenceUpdate(referringElement, referringResourceURI, reference, indexInList, newTargetElement, updateAcceptor);
  }
}
