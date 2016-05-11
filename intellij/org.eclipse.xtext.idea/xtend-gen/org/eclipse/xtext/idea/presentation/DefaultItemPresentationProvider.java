/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.presentation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intellij.icons.AllIcons;
import com.intellij.ide.projectView.PresentationData;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import java.util.Arrays;
import javax.swing.Icon;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.xtext.idea.presentation.ItemPresentationProvider;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class DefaultItemPresentationProvider implements ItemPresentationProvider {
  @Inject
  private IPsiModelAssociations psiModelAssociations;
  
  @Override
  public ItemPresentation getItemPresentation(final Object element) {
    PresentationData _presentationData = new PresentationData();
    final Procedure1<PresentationData> _function = new Procedure1<PresentationData>() {
      @Override
      public void apply(final PresentationData it) {
        Icon _image = DefaultItemPresentationProvider.this.image(element);
        it.setIcon(_image);
        String _text = DefaultItemPresentationProvider.this.text(element);
        it.setPresentableText(_text);
      }
    };
    return ObjectExtensions.<PresentationData>operator_doubleArrow(_presentationData, _function);
  }
  
  protected Icon _image(final Void element) {
    return AllIcons.General.SecondaryGroup;
  }
  
  protected Icon _image(final Object element) {
    return AllIcons.General.SecondaryGroup;
  }
  
  protected Icon _image(final EObject element) {
    PsiElement _psiElement = this.psiModelAssociations.getPsiElement(element);
    return this.image(_psiElement);
  }
  
  protected Icon _image(final PsiElement element) {
    return element.getIcon(0);
  }
  
  protected String _text(final Void element) {
    return "<null>";
  }
  
  protected String _text(final Object element) {
    return "<null>";
  }
  
  protected String _text(final EObject element) {
    String _xblockexpression = null;
    {
      EClass _eClass = element.eClass();
      final EAttribute labelFeature = this.getLabelFeature(_eClass);
      String _xifexpression = null;
      boolean _notEquals = (!Objects.equal(labelFeature, null));
      if (_notEquals) {
        Object _eGet = element.eGet(labelFeature);
        String _string = null;
        if (_eGet!=null) {
          _string=_eGet.toString();
        }
        _xifexpression = _string;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected EAttribute getLabelFeature(final EClass eClass) {
    EAttribute result = null;
    EList<EAttribute> _eAllAttributes = eClass.getEAllAttributes();
    for (final EAttribute eAttribute : _eAllAttributes) {
      if (((!eAttribute.isMany()) && (!Objects.equal(eAttribute.getEType().getInstanceClass(), FeatureMap.Entry.class)))) {
        String _name = eAttribute.getName();
        boolean _equalsIgnoreCase = "name".equalsIgnoreCase(_name);
        if (_equalsIgnoreCase) {
          return eAttribute;
        } else {
          boolean _equals = Objects.equal(result, null);
          if (_equals) {
            result = eAttribute;
          } else {
            if ((Objects.equal(eAttribute.getEAttributeType().getInstanceClass(), String.class) && 
              (!Objects.equal(result.getEAttributeType().getInstanceClass(), String.class)))) {
              result = eAttribute;
            }
          }
        }
      }
    }
    return result;
  }
  
  public Icon image(final Object element) {
    if (element instanceof PsiElement) {
      return _image((PsiElement)element);
    } else if (element instanceof EObject) {
      return _image((EObject)element);
    } else if (element == null) {
      return _image((Void)null);
    } else if (element != null) {
      return _image(element);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element).toString());
    }
  }
  
  public String text(final Object element) {
    if (element instanceof EObject) {
      return _text((EObject)element);
    } else if (element == null) {
      return _text((Void)null);
    } else if (element != null) {
      return _text(element);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element).toString());
    }
  }
}
