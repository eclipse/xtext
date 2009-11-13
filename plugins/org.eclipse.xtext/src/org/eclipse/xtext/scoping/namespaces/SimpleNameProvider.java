/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.namespaces;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.linking.impl.SimpleAttributeResolver;
import org.eclipse.xtext.resource.IQualifiedNameProvider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SimpleNameProvider extends IQualifiedNameProvider.AbstractImpl{
	public String getQualifiedName(EObject obj) {
		return SimpleAttributeResolver.NAME_RESOLVER.apply(obj);
	}
}
