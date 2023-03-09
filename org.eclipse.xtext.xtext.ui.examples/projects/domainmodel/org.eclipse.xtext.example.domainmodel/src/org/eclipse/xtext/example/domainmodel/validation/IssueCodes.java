/*******************************************************************************
 * Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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

	String DUPLICATE_PROPERTY = PREFIX + "DuplicateProperty";

	String DUPLICATE_OPERATION = PREFIX + "DuplicateOperation";

}
