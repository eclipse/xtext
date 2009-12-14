/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.impl;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @deprecated use {@link org.eclipse.xtext.util.SimpleAttributeResolver} instead.
 */
@Deprecated
public class SimpleAttributeResolver<K extends EObject, T> extends org.eclipse.xtext.util.SimpleAttributeResolver<K, T> {

	static {
		Logger.getLogger(SimpleAttributeResolver.class).warn("The SimpleAttributeResolver is deprecated. Please change the usages to org.eclipse.xtext.util.SimpleAttributeResolver");
	}
	
	protected SimpleAttributeResolver(final Class<T> type, final String attributeName) {
		super(type, attributeName);
	}
	
}
