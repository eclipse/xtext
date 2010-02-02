/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.ui.editor.outline.ContentOutlineNode;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class ParserRulesOutlineFilter extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if ((parentElement != null) && (parentElement instanceof ContentOutlineNode)) {
			ContentOutlineNode parentNode = (ContentOutlineNode) parentElement;
			EClass clazz = parentNode.getClazz();
			if (clazz != null && clazz.equals(XtextPackage.Literals.PARSER_RULE)) {
				return false;
			}
			
		}
		return true;
	}

}