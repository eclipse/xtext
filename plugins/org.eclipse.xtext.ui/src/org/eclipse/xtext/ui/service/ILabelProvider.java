/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.service;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.service.ILanguageService;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public interface ILabelProvider extends ILanguageService {
	// TODO probably it needs a dispose method
	public StyledString getLabel(EObject eObject);

	public Image getIcon(EObject eObject);

}
