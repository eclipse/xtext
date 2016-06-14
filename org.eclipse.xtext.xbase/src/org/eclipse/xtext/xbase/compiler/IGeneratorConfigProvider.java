/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.ImplementedBy;

/**
 * @author Holger Schill - Initial contribution and API
 */
@ImplementedBy(GeneratorConfigProvider.class)
public interface IGeneratorConfigProvider {

	/**
	 * @return {@link GeneratorConfig} never <code>null</code>
	 */
	public /*@NonNull*/ GeneratorConfig get(EObject context);
}
