/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;

/**
 * A possible extension would be to normalize the type hierarchy and remove
 * redundant supertype references. We currently don't think thats necessary as
 * EMF handles multiple inheritance gracefully.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class EClassInfos {

	class Key extends Pair<String, String> {
		public Key(String firstElement, String secondElement) {
			super(firstElement, secondElement);
		}
	}

	private Map<Key, EClassInfo> infoMap = new HashMap<Key, EClassInfo>();

	public boolean addInfo(TypeRef typeRef, EClassInfo metatypeInfo) {
		return infoMap.put(key(typeRef), metatypeInfo) != metatypeInfo;
	}

	public boolean addInfo(String alias, String name, EClassInfo metatypeInfo) {
		return infoMap.put(new Key(alias, name), metatypeInfo) != metatypeInfo;
	}

	public EClassInfo getInfo(TypeRef typeRef) {
		return infoMap.get(key(typeRef));
	}

	private Key key(TypeRef typeRef) {
		return new Key(Strings.emptyIfNull(typeRef.getAlias()), typeRef.getName());
	}

}
