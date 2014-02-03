/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.validation;


import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.SeverityConverter;
import org.eclipse.xtext.xbase.validation.XbaseConfigurableIssueCodes;

import com.google.inject.Singleton;

/**
 * 
 * @author Dennis Huebner - Initial contribution and API
 */
@Singleton
public class XtendConfigurableIssueCodes extends XbaseConfigurableIssueCodes {


	@Override
	protected void initialize(IAcceptor<PreferenceKey> iAcceptor) {
		super.initialize(iAcceptor);
		iAcceptor.accept(create(IssueCodes.SINGLE_DISPATCH_FUNCTION, SeverityConverter.SEVERITY_WARNING));
		iAcceptor.accept(create(IssueCodes.DISPATCH_PLAIN_FUNCTION_NAME_CLASH, SeverityConverter.SEVERITY_WARNING));
		iAcceptor.accept(create(IssueCodes.INVALID_OPERATOR_SIGNATURE, SeverityConverter.SEVERITY_ERROR));
		iAcceptor.accept(createDelegate(IssueCodes.UNUSED_PRIVATE_MEMBER, JavaCore.COMPILER_PB_UNUSED_PRIVATE_MEMBER));
		iAcceptor.accept(createDelegate(IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC, JavaCore.COMPILER_PB_INVALID_JAVADOC, SeverityConverter.SEVERITY_IGNORE));
	}
}
