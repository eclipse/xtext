/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.validation;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.validation.IValidatorConfiguration;
import org.eclipse.xtext.validation.IValidatorConfigurationProvider;
import org.eclipse.xtext.validation.impl.DefaultValidationConfiguration;
import org.eclipse.xtext.xbase.validation.IssueCodes;

import com.google.common.collect.Lists;

/**
 * @author dhuebner - Initial contribution and API
 */
public class XtendValidatorConfigurationProvider implements IValidatorConfigurationProvider {

	public IValidatorConfiguration getValidatorConfiguration(Resource resource) {
		return new DefaultValidationConfiguration(Lists.newArrayList(IssueCodes.IC_DISCOURAGED_REFERENCE,
				IssueCodes.IC_FORBIDDEN_REFERENCE));
	}

}
