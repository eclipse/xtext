/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ecore;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.collect.Maps;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class EcoreResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {

	public static final String NS_URI_INDEX_ENTRY = "nsURI";
	public static final String NS_URI_INDEX_ENTRY_NAME = "name";
	
	@Override
	public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		if (eObject instanceof EPackage) {
			EPackage pack = (EPackage) eObject;
			if (pack.getNsURI() != null && pack.getNsURI().length() != 0) {
				QualifiedName qualifiedName = QualifiedName.create(pack.getNsURI());
				Map<String, String> userData = Maps.newHashMapWithExpectedSize(2);
				userData.put(NS_URI_INDEX_ENTRY, "true");
				userData.put(NS_URI_INDEX_ENTRY_NAME, pack.getName());
				IEObjectDescription description = EObjectDescription.create(
						qualifiedName, pack, userData);
				acceptor.accept(description);
			}
		}
		return super.createEObjectDescriptions(eObject, acceptor);
	}
	
}
