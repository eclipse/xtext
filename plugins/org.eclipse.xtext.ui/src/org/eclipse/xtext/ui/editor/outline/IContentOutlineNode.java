/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.util.concurrent.IEObjectHandle;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IContentOutlineNode extends IAdaptable, IEObjectHandle<EObject>  {

	IContentOutlineNode getParent();

	boolean hasChildren();

	IContentOutlineNode[] getChildrenAsArray();

	Image getImage();

	String getLabel();

	StyledString getStyledString();
	
	EClass getClazz();
	
	IRegion getRegion();
	
	int getSelectionOffset();
	
	int getSelectionLength();
	
}
