/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Heiko Behrens - Initial contribution and API
 * 
 */
public interface ErrorAcceptor {
	public enum ErrorCode {
		NoSuchTypeAvailable, MoreThanOneTypeChangeInOneRule, CannotLoadMetamodel, CannotCreateTypeInSealedMetamodel, FeatureWithDifferentConfigurationAlreadyExists, NoCompatibleFeatureTypeAvailable, AliasForMetamodelAlreadyExists, NoSuchRuleAvailable
	}

	public void acceptError(ErrorCode errorCode, String message, EObject element);
}
