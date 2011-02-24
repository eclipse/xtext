/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.editor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionProvider;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Xtend2FoldingRegionProvider extends DefaultFoldingRegionProvider {

	@Override
	protected boolean isHandled(EObject object) {
		EClass clazz = object.eClass();
		return clazz == Xtend2Package.Literals.XTEND_CLASS || clazz == Xtend2Package.Literals.XTEND_FUNCTION;
	}
	
	@Override
	protected boolean shouldProcessContent(EObject object) {
		EClass clazz = object.eClass();
		return clazz == Xtend2Package.Literals.XTEND_CLASS || clazz == Xtend2Package.Literals.XTEND_FILE;
	}
	
}
