/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XbaseResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {
	
	private static final Logger LOG = Logger.getLogger(XbaseResourceDescriptionStrategy.class);

	public static final String SIGNATURE_HASH_KEY = "sig";
	public static final String IS_INTERFACE = "interface";
	
	@Inject
	private JvmDeclaredTypeSignatureHashProvider hashProvider;
	
	@Override
	public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		if (getQualifiedNameProvider() == null)
			return false;
		try {
			QualifiedName qualifiedName = getQualifiedNameProvider().getFullyQualifiedName(eObject);
			if (qualifiedName != null) {
				acceptor.accept(EObjectDescription.create(qualifiedName, eObject, createLazyUserData(eObject)));
			}
		} catch (Exception exc) {
			LOG.error(exc.getMessage());
		}
		return true;
	}
	
	protected Map<String, String> createLazyUserData(final EObject eObject) { 
		return new ForwardingMap<String, String>() {
			private Map<String,String> delegate; 
			
			@Override
			protected Map<String, String> delegate() {
				if(delegate == null) {
					Builder<String, String> userData = ImmutableMap.builder();
					createUserData(eObject, userData);
					delegate = userData.build();
				} 
				return delegate;
			}
		};
	}

	protected void createUserData(EObject eObject, ImmutableMap.Builder<String, String> userData) {
		if (eObject instanceof JvmDeclaredType) {
			userData.put(SIGNATURE_HASH_KEY, hashProvider.getHash((JvmDeclaredType) eObject));
		}
		if (eObject instanceof JvmGenericType) {
			JvmGenericType genericType = (JvmGenericType) eObject;
			if (genericType.isInterface())
				userData.put(IS_INTERFACE, Boolean.TRUE.toString());
		}
	}
}
