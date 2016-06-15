/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.validation;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IssueCodes {

	String PREFIX = "org.eclipse.xtext.example.domainmodel.domainmodel.";
	
	String INVALID_TYPE_NAME = PREFIX + "InvalidTypeName";
	
	String INVALID_FEATURE_NAME = PREFIX + "InvalidFeatureName";

	String MISSING_TYPE = PREFIX + "MissingType";

}
