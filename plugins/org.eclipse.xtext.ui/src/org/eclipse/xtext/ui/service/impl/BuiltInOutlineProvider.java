/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.service.impl;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.model.IEditorModel;
import org.eclipse.xtext.ui.service.IOutlineProvider;

/**
 * @author Peter Friese - Initial contribution and API
 *
 */
public class BuiltInOutlineProvider implements IOutlineProvider {
    
    public Object[] getRootObjects(IEditorModel model) {
        Assert.isNotNull(model);
        Object astRoot = model.getAstRoot();
        return new Object[] { astRoot };
    }
    
    public boolean hasChildren(EObject element) {
        Assert.isNotNull(element);
        return (element.eContents().size() > 0);
    }
    
    public Object[] getChildren(EObject node) {
        Assert.isNotNull(node);
        EList<EObject> contents = node.eContents();
        return contents.toArray();
    }

}
