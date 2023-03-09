/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

public enum TransformationErrorCode {
	NoSuchTypeAvailable, 
	MoreThanOneTypeChangeInOneRule, 
	CannotLoadMetamodel, 
	CannotCreateTypeInSealedMetamodel, 
	FeatureWithDifferentConfigurationAlreadyExists, 
	NoCompatibleFeatureTypeAvailable, 
	AliasForMetamodelAlreadyExists, 
	NoSuchRuleAvailable, 
	TypeWithCycleInHierarchy, 
	MoreThanOneFeatureWithSameName,
	UnknownMetaModelAlias, 
	InvalidDatatypeRule, 
	InvalidSupertype, 
	InvalidFeature,
	InvalidFragmentOverride,
	InvalidFragmentCall,
	InvalidRuleOverride;

	public String getFullyQualifiedCode() {
		return getClass().getCanonicalName() + "." + name();
	}
}