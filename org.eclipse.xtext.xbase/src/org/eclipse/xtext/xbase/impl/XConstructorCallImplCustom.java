/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.impl;

import org.eclipse.xtext.util.Strings;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XConstructorCallImplCustom extends XConstructorCallImpl {
	
	@Override
	public boolean isValidFeature() {
		return Strings.isEmpty(getInvalidFeatureIssueCode());
	}
	
	@Override
	public String getInvalidFeatureIssueCode() {
		// call getFeature(), because the implicitReceiver is set as a side effect of a resolution of the feature.
		// see {@link org.eclipse.xtext.xbase.linking.BestMatchingJvmFeatureScope#setImplicitReceiver(IEObjectDescription)}
		getConstructor();
		return super.getInvalidFeatureIssueCode();
	}
	
	
}
