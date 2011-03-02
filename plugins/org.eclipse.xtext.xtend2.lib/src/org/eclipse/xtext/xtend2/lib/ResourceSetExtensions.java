/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.lib;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ResourceSetExtensions {

	public static Iterable<Notifier> allContentsIterable(final ResourceSet resourceSet) {
		return new Iterable<Notifier>() {
			public Iterator<Notifier> iterator() {
				return resourceSet.getAllContents();
			}
		};
	}
}
