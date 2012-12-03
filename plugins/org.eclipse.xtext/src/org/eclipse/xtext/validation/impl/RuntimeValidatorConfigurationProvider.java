/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation.impl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.validation.IValidatorConfiguration;
import org.eclipse.xtext.validation.IValidatorConfigurationProvider;
import org.eclipse.xtext.validation.IssueCode;

import com.google.common.collect.Lists;

/**
 * @author dhuebner - Initial contribution and API
 * @since 2.4
 */
public class RuntimeValidatorConfigurationProvider implements IValidatorConfigurationProvider {

	public IValidatorConfiguration getValidatorConfiguration(Resource resource) {
		return new DefaultValidationConfiguration(Lists.<IssueCode> newArrayList());
	}

}
