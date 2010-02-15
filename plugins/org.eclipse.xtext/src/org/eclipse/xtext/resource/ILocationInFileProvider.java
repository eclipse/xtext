/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.TextLocation;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
@ImplementedBy(DefaultLocationInFileProvider.class)
public interface ILocationInFileProvider {

	TextLocation getLocation(EObject obj);

	TextLocation getLocation(EObject owner, EStructuralFeature feature, int indexInList);
}
