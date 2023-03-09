/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil.ContentTreeIterator;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;

import com.google.common.collect.Iterables;
/**
 * @author Holger Schill - Initial contribution and API
 */
public class XbaseUsageCrossReferencer extends UsageCrossReferencer {

	protected XbaseUsageCrossReferencer(EObject eObject) {
		super(eObject);
	}

	public static Collection<EStructuralFeature.Setting> find(EObject eObjectOfInterest, EObject eObject) {
		return new XbaseUsageCrossReferencer(eObject).findUsage(eObjectOfInterest);
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected TreeIterator<Notifier> newContentsIterator() {
		return new ContentTreeIterator<Notifier>(emfObjects) {
			private static final long serialVersionUID = 1L;

			@Override
			protected Iterator<? extends EObject> getEObjectChildren(EObject eObject) {
				if(eObject instanceof XAbstractFeatureCall){
					Iterable<EObject> result = eObject.eContents();
					XAbstractFeatureCall featureCall = (XAbstractFeatureCall) eObject;
					XExpression implicitReceiver = featureCall.getImplicitReceiver();
					if(implicitReceiver != null) 
						result = Iterables.concat(result, Collections.singleton(implicitReceiver));
					XExpression implicitFirstArgument = featureCall.getImplicitFirstArgument();
					if(implicitFirstArgument != null)
						result = Iterables.concat(result, Collections.singleton(implicitFirstArgument));
					return result.iterator();
				} else 
					return super.getEObjectChildren(eObject);
			}
		};
	}

}