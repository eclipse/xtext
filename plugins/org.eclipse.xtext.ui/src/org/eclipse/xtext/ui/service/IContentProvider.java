/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.service;

import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.ILanguageService;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public interface IContentProvider extends ILanguageService {
    public String getLabel(LeafNode node);

    public Image getIcon(LeafNode node);

    public Object getParent(LeafNode node);

    public List<?> getChildren(LeafNode node);
}
