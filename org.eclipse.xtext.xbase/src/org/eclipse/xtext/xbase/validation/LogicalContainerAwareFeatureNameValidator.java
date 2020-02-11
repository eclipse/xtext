/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;

/**
 * Logical container aware feature name validation.
 * {@link IFeatureNames#THIS this} and {@link IFeatureNames#SUPER super}
 * are disallowed. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LogicalContainerAwareFeatureNameValidator extends FeatureNameValidator {

	@Override
	public boolean isDisallowedName(QualifiedName name) {
		return SUPER.equals(name) || THIS.equals(name);
	}
	
}
