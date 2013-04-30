/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.4
 */
public class BinaryGrammarResourceFactoryImpl implements Factory {

	public Resource createResource(URI uri) {
		return new BinaryResourceImpl(uri);
	}

}
