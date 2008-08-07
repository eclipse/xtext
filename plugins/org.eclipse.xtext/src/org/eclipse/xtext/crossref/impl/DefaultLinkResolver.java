/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.crossref.ILinkProvider;
import org.eclipse.xtext.parsetree.LeafNode;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class DefaultLinkResolver implements ILinkProvider {

	public URI[] getLinks(LeafNode text, CrossReference ref, EObject model) {
		// TODO Auto-generated method stub
		return null;
	}

}
