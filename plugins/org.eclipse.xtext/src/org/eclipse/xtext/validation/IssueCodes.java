/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

/**
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.4
 */
public class IssueCodes {

	//TODO should we keep the old prefix? or change it to higher level org.eclipse.xtext.validation.IssueCodes.
	private static final String ISSUE_CODE_PREFIX = "org.eclipse.xtext.xbase.validation.IssueCodes.";

	//public static final String FORBIDDEN_REFERENCE = ISSUE_CODE_PREFIX	+ "forbidden_reference";
	public final IssueCode forbiddenReference = new IssueCode(ISSUE_CODE_PREFIX + "forbidden_reference");

}
