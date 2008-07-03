/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.service.impl;

import java.util.Arrays;
import java.util.Comparator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
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
        return astRoot != null ? new Object[] { astRoot } : new Object[] {};
    }

    public boolean hasChildren(EObject node) {
        Assert.isNotNull(node);
        return (node.eContents().size() > 0);
    }

    public Object[] getChildren(EObject node) {
        Assert.isNotNull(node);

        EList<EObject> contents = node.eContents();
        EObject[] array = contents.toArray(new EObject[contents.size()]);

        Arrays.sort(array, new Comparator<EObject>() {
            public int compare(EObject o1, EObject o2) {
                NodeAdapter nodeAdapter = (NodeAdapter) o1.eAdapters().get(0);
                CompositeNode parserNode1 = nodeAdapter.getParserNode();
                Integer offset = parserNode1.getOffset();

                NodeAdapter nodeAdapter2 = (NodeAdapter) o2.eAdapters().get(0);
                CompositeNode parserNode2 = nodeAdapter2.getParserNode();
                Integer offset2 = parserNode2.getOffset();
                return offset.compareTo(offset2);
            }
        });
        
        return array;
    }

}
