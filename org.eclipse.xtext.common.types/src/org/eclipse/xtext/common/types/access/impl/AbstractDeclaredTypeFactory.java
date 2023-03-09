/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractDeclaredTypeFactory {

	protected static final String CLASS_CLASS_NAME = "java.lang.Class";
	protected static final String OBJECT_CLASS_NAME = "java.lang.Object";
	protected static final String STRING_CLASS_NAME = "java.lang.String";

	protected static final String[] EMPTY_STRING_ARRAY = Strings.EMPTY_ARRAY;

	/**
	 * An array of proxies for primitives indexed the same way as {@link InternalURIHelperConstants#PRIMITIVE_URIS}, i.e., indexed based on the first character of their signature.
	 */
	protected static final JvmType[] PRIMITIVE_PROXIES = new JvmType[InternalURIHelperConstants.PRIMITIVE_URIS.length];
	
	static {
		// Initialize the primitive proxies at the same indices as in the PRIMITIVE_URIs.
		//
		for (int i = 0; i < InternalURIHelperConstants.PRIMITIVE_URIS.length; ++i) {
			URI uri = InternalURIHelperConstants.PRIMITIVE_URIS[i];
			if (uri != null) {
				JvmType proxy = TypesFactory.eINSTANCE.createJvmVoid();
				((InternalEObject)proxy).eSetProxyURI(uri);
				PRIMITIVE_PROXIES[i] = proxy;
			}
		}
	}
	
	/**
	 * Mappings from qualified type binding name to proxy instance for all the types in {@link InternalURIHelperConstants#COMMON_CLASS_NAMES}.
	 */
	protected static final Map<String, JvmType> COMMON_PROXIES = new HashMap<String, JvmType>();


	static {
		// Initialize the common proxies
		//
		for (String commonClassName : InternalURIHelperConstants.COMMON_CLASS_NAMES) {
			JvmType objectProxy = TypesFactory.eINSTANCE.createJvmVoid();
			URI uri = InternalURIHelperConstants.COMMON_URIS.get(commonClassName);
			((InternalEObject)objectProxy).eSetProxyURI(uri);
			COMMON_PROXIES.put(uri.segment(1), objectProxy);
		}
	}

	/**
	 * The proxy for <code>java.lang.Object</code>.
	 */
	protected static final JvmType OBJECT_CLASS_PROXY = COMMON_PROXIES.get(OBJECT_CLASS_NAME);

	/**
	 * Mappings from qualified annotation type binding name to proxy instance for all the annotations in {@link InternalURIHelperConstants#COMMON_ANNOTATIONS}.
	 */
	protected static final Map<String, JvmAnnotationType> ANNOTATION_PROXIES = new HashMap<String, JvmAnnotationType>();

	/**
	 * Mappings from qualified method name to proxy instance for all the methods in {@link InternalURIHelperConstants#COMMON_ANNOTATIONS}.
	 */
	protected static final Map<String, JvmOperation[]> ANNOTATION_METHOD_PROXIES = new HashMap<String, JvmOperation[]>();

	static {
		// Initialize the common annotation proxies and their corresponding method proxies.
		//
		for (String[] annotations : InternalURIHelperConstants.COMMON_ANNOTATIONS) {
			JvmAnnotationType objectProxy = TypesFactory.eINSTANCE.createJvmAnnotationType();
			URI uri = InternalURIHelperConstants.COMMON_URIS.get(annotations[0]);
			((InternalEObject)objectProxy).eSetProxyURI(uri);
			String key = uri.segment(1);
			ANNOTATION_PROXIES.put(key, objectProxy);
			
			// Initialize any corresponding method proxies.
			//
			URI[] methodURIs = InternalURIHelperConstants.COMMON_METHOD_URIS.get(annotations[0]);
			if (methodURIs != null) {
				JvmOperation[] jvmOperationProxies = new JvmOperation[methodURIs.length];
				for (int i = 0; i < methodURIs.length; ++i) {
					JvmOperation jvmOperation = TypesFactory.eINSTANCE.createJvmOperation();
					((InternalEObject)jvmOperation).eSetProxyURI(methodURIs[i]);
					jvmOperationProxies[i] = jvmOperation;
				}
				ANNOTATION_METHOD_PROXIES.put(key, jvmOperationProxies);
			}
		}
	}
	
}
