/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.refactoring;

import java.util.Comparator;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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

  @Override
  protected Iterable<IReferenceDescription> getNotImportTypeReferences(final Iterable<IReferenceDescription> referenceDescriptions) {
    List<IReferenceDescription> _xblockexpression = null;
    {
      final List<IReferenceDescription> result = IterableExtensions.<IReferenceDescription>toList(super.getNotImportTypeReferences(referenceDescriptions));
      final String localClassesFragmentPart = "@localClasses.";
      final Comparator<IReferenceDescription> _function = (IReferenceDescription o1, IReferenceDescription o2) -> {
        final String f1 = o1.getSourceEObjectUri().fragment();
        final String f2 = o2.getSourceEObjectUri().fragment();
        if ((f1.contains(localClassesFragmentPart) && f2.contains(localClassesFragmentPart))) {
          return f1.compareTo(f2);
        }
        boolean _contains = f1.contains(localClassesFragmentPart);
        if (_contains) {
          return 1;
        }
        boolean _contains_1 = f2.contains(localClassesFragmentPart);
        if (_contains_1) {
          return (-1);
        }
        return f1.compareTo(f2);
      };
      result.sort(_function);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
}
