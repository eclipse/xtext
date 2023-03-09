/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ecore;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class EcoreResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {

	private static final Logger LOG = Logger.getLogger(EcoreResourceDescriptionStrategy.class);

	public static final String NS_URI_INDEX_ENTRY = "nsURI";

	@Inject
	private NsURIQualifiedNameProvider nsURIQualifiedNameProvider;

	@Override
	public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		boolean isProcessContents = createEObjectDescriptions(getQualifiedNameProvider(), false, eObject, acceptor);
		isProcessContents |= createEObjectDescriptions(nsURIQualifiedNameProvider, true, eObject, acceptor);
		return isProcessContents;
	}

	protected boolean createEObjectDescriptions(IQualifiedNameProvider qualifiedNameProvider, boolean isNsURI,
			EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		try {
			QualifiedName qualifiedName = qualifiedNameProvider.getFullyQualifiedName(eObject);
			if (qualifiedName != null) {
				Map<String, String> userData = Maps.newHashMapWithExpectedSize(1);
				userData.put(NS_URI_INDEX_ENTRY, Boolean.toString(isNsURI));
				IEObjectDescription description = EObjectDescription.create(qualifiedName, eObject, userData);
				acceptor.accept(description);
				return true;
			}
		} catch (Exception exc) {
			LOG.error(exc.getMessage(), exc);
		}
		return false;
	}

}
