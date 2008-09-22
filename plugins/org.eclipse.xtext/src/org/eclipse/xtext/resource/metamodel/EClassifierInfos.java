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

import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;

/**
 * A possible extension would be to normalize the type hierarchy and remove
 * redundant supertype references. We currently don't think thats necessary as
 * EMF handles multiple inheritance gracefully.
 * 
 * @author Jan K?hnlein - Initial contribution and API
 * 
 */
public class EClassifierInfos {

	private Map<String, EClassifierInfo> infoMap = new HashMap<String, EClassifierInfo>();

	public boolean addInfo(TypeRef typeRef, EClassifierInfo metatypeInfo) {
		return infoMap.put(GrammarUtil.getQualifiedName(typeRef), metatypeInfo) != metatypeInfo;
	}

	public boolean addInfo(String alias, String name, EClassifierInfo metatypeInfo) {
		return infoMap.put(GrammarUtil.getQualifiedName(alias, name), metatypeInfo) != metatypeInfo;
	}

	public EClassifierInfo getInfo(TypeRef typeRef) {
		return getInfo(GrammarUtil.getQualifiedName(typeRef));
	}

	public EClassifierInfo getInfo(String qualifiedName) {
		return infoMap.get(qualifiedName);
	}

	public void addAll(EClassifierInfos classInfos) {
		infoMap.putAll(classInfos.infoMap);
	}
	
}
