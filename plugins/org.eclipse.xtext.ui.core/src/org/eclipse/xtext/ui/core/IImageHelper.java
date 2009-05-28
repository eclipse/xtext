/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core;

import org.eclipse.swt.graphics.Image;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow
 */
@ImplementedBy(IImageHelper.NullImageHelper.class)
public interface IImageHelper {

	Image getImage(String name);
	
	class NullImageHelper implements IImageHelper {

		public Image getImage(String name) {
			return null;
		}
		
	}
}
