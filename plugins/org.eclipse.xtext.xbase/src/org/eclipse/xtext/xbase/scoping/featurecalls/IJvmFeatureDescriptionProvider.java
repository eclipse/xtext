/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.util.IAcceptor;

/**
 * The strategy interface passed to instances of {@link IJvmFeatureScopeProvider}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IJvmFeatureDescriptionProvider {
	
	/**
	 * called for each feature in the current context type's type hierarchy.
	 */
	void addFeatureDescriptions(JvmFeature feature, final TypeArgumentContext context, IAcceptor<JvmFeatureDescription> acceptor);

	/**
	 * Used to name scopes created using this provider
	 */
	String getText();
	
}