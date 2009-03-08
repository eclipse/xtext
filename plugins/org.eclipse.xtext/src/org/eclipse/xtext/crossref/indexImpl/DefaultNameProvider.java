/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.crossref.indexImpl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.crossref.impl.SimpleAttributeResolver;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class DefaultNameProvider extends AbstractNameProvider {
	
	private final SimpleAttributeResolver<String> nameResolver = SimpleAttributeResolver.newResolver(String.class, "name");

	public String getGlobalName(EObject obj) {
		return nameResolver.getValue(obj);
	}
	
}
