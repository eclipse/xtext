/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.eclipse.xtext.diagnostics.Severity;

/**
 * 
 * @author dhuebner - Initial contribution and API
 * @since 2.4
 */
public interface IValidatorConfiguration {

	Severity getSeverity(IssueCode code);

	boolean isIgnore(IssueCode code);
}
