/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import org.eclipse.xtext.generator.validation.JavaValidatorFragment;
import org.eclipse.xtext.generator.validation.ValidatorFragment;

/**
 * Needed because the Xtend-based {@link ValidatorFragment} looks for a class with this name, 
 * while the {@link JavaValidatorFragment} looks for {@link XbaseJavaValidator}. We have to support
 * both types of workflows.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XbaseValidator extends XbaseJavaValidator {
}
