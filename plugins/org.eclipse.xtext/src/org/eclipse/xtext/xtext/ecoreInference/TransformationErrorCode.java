/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	InvalidRuleOverride;

	public String getFullyQualifiedCode() {
		return getClass().getCanonicalName() + "." + name();
	}
}