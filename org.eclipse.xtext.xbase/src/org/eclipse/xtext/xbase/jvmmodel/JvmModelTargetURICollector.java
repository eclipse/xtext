/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.findReferences.TargetURICollector;
import org.eclipse.xtext.findReferences.TargetURIs;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * @since 2.7
 * 
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @noextend This class is not intended to be subclassed by clients.
 * @noreference This class is not intended to be referenced by clients.
 */
@Singleton
public class JvmModelTargetURICollector extends TargetURICollector {

	@Inject
	private IJvmModelAssociations associations;

	@Override
	protected void doAdd(EObject object, TargetURIs targetURIs) {
		super.doAdd(object, targetURIs);
		Set<EObject> jvmElements = associations.getJvmElements(object);
		for(EObject jvmElement: jvmElements) {
			super.doAdd(jvmElement, targetURIs);
		}
	}
	
}
