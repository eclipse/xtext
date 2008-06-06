/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.outline.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;

/**
 * @author Peter Friese - Initial contribution and API
 *
 */
public class XtextModelLabelProvider extends LabelProvider implements ILabelProvider {
    
    @Override
    public String getText(Object element) {
        if (element instanceof EObject) {
            EObject eObject = (EObject) element;
            String className = eObject.eClass().getName();
            if ("Spielplatz".equals(className)) {
                return getSpielplatzText(eObject);
            }
            else if ("Kind".equals(className)) {
                return getKindText(eObject);
            }
            else {
                return getDefaultText(eObject);
            }
        }
        return super.getText(element);
    }
    
    protected String getDefaultText(EObject eObject) {
        String className = eObject.eClass().getName();
        EStructuralFeature nameFeature = eObject.eClass().getEStructuralFeature("name");
        String name = null;
        if (nameFeature != null ) {
            name = (String) eObject.eGet(nameFeature);
        }
        return className + " (" + name + ")";
    }
    
    protected String getSpielplatzText(EObject eObject) {
        return "Spielplatz";
    }
    
    protected String getKindText(EObject eObject) {
        return getDefaultText(eObject);
    }

}
