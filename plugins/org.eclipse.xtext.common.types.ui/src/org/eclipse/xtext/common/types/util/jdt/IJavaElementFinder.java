/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util.jdt;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.xtext.common.types.IdentifyableElement;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(JavaElementFinder.class)
public interface IJavaElementFinder {

	IJavaElement findElementFor(IdentifyableElement element);
	
}
