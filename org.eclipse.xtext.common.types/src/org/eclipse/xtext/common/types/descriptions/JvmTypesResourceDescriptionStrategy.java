/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.descriptions;

import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
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
 * @author Sven Efftinge - extracted from XbaseResourcedescritpionsStrategy
 */
public class JvmTypesResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {
	
	private static final Logger LOG = Logger.getLogger(JvmTypesResourceDescriptionStrategy.class);

	public static final String IS_NESTED_TYPE = "nestedType";
	public static final String IS_INTERFACE = "interface";
	public static final String TYPE_PARAMETERS = "typeParameters";
	public static final String SIGNATURE_HASH_KEY = "sig";
	
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
			LOG.error(exc.getMessage(), exc);
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
			if (eObject.eContainer() != null) {
				userData.put(IS_NESTED_TYPE, Boolean.TRUE.toString());
			}
		}
		if (eObject instanceof JvmGenericType) {
			JvmGenericType genericType = (JvmGenericType) eObject;
			if (genericType.isInterface())
				userData.put(IS_INTERFACE, Boolean.TRUE.toString());
			if (!genericType.getTypeParameters().isEmpty()) {
				String result = "<";
				for (Iterator<JvmTypeParameter> iterator = genericType.getTypeParameters().iterator(); iterator.hasNext();) {
					JvmTypeParameter type = iterator.next();
					result += type.getSimpleName();
					if (iterator.hasNext()) {
						result += ",";
					}
				}
				result +=">";
				userData.put(TYPE_PARAMETERS, result);
			}
		}
	}
}
