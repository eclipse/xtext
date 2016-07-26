/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.labeling;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;

/**
 * Provides labels for a IEObjectDescriptions and IResourceDescriptions.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
@SuppressWarnings("all")
public class ArithmeticsDescriptionLabelProvider extends DefaultDescriptionLabelProvider {
  @Inject
  private ILabelProvider labelProvider;
  
  @Override
  public Image getImage(final Object element) {
    Image _xifexpression = null;
    if ((element instanceof IEObjectDescription)) {
      EObject _eObjectOrProxy = ((IEObjectDescription)element).getEObjectOrProxy();
      _xifexpression = this.labelProvider.getImage(_eObjectOrProxy);
    } else {
      _xifexpression = super.getImage(element);
    }
    return _xifexpression;
  }
}
