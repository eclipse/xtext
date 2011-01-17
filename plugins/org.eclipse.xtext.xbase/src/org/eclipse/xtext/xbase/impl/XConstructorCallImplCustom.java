/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
