/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.newapi;

import java.util.Collections;
import java.util.Map;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.scoping.newapi.ISelector.SelectByName;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class MapBasedScope extends IterableBasedScope {

	private Map<QualifiedName, IEObjectDescription> map;

	public MapBasedScope(Map<QualifiedName, IEObjectDescription> descriptions, INewScope parent) {
		super(descriptions.values(), parent);
		this.map = descriptions;
	}

	@Override
	protected Iterable<? extends IEObjectDescription> getLocalElements(ISelector selector) {
		if (selector instanceof SelectByName) {
			IEObjectDescription description = map.get(((SelectByName) selector).getName());
			if (description==null)
				return Collections.emptySet();
			return selector.apply(description) ? Collections.singleton(description) : Collections
					.<IEObjectDescription> emptySet();
		}
		return super.getLocalElements(selector);
	}

}
