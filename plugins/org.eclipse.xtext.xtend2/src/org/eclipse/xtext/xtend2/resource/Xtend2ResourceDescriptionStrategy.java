/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.resource;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xtend2.linking.DispatchUtil;

import com.google.common.collect.ImmutableSortedMap;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2ResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {

	private static final Logger LOG = Logger.getLogger(Xtend2ResourceDescriptionStrategy.class);
	
	@Inject
	private DispatchUtil dispatchUtil;

	@Inject
	private DescriptionFlags descriptionFlags;

	@Override
	public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		if (getQualifiedNameProvider() == null)
			return false;
		try {
			QualifiedName qualifiedName = getQualifiedNameProvider().getFullyQualifiedName(eObject);
			if (qualifiedName != null) {
				acceptor.accept(EObjectDescription.create(qualifiedName, eObject, createUserData(eObject)));
			}
		} catch (Exception exc) {
			LOG.error(exc.getMessage());
		}
		return true;
	}

	protected Map<String, String> createUserData(EObject eObject) {
		if (eObject instanceof JvmOperation) {
			return createUserData((JvmOperation) eObject);
		} else {
			return null;
		}
	}

	protected Map<String, String> createUserData(JvmOperation operation) {
		int flags = 0;
		if (dispatchUtil.isDispatcherFunction(operation))
			flags = descriptionFlags.setDispatcherOperation(flags);
		return flags != 0 ? ImmutableSortedMap.of(DescriptionFlags.KEY, Integer.toString(flags)) : null;
	}
}
