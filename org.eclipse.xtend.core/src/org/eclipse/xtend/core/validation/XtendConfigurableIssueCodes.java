/*******************************************************************************
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
		iAcceptor.accept(create(IssueCodes.DISPATCH_FUNCTIONS_DIFFERENT_PRIMITIVE_ARGS, SeverityConverter.SEVERITY_WARNING));
		iAcceptor.accept(create(IssueCodes.INVALID_OPERATOR_SIGNATURE, SeverityConverter.SEVERITY_ERROR));
		iAcceptor.accept(createDelegate(IssueCodes.UNUSED_PRIVATE_MEMBER, JavaCore.COMPILER_PB_UNUSED_PRIVATE_MEMBER));
		iAcceptor.accept(createDelegate(IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC, JavaCore.COMPILER_PB_INVALID_JAVADOC, SeverityConverter.SEVERITY_IGNORE));
		iAcceptor.accept(create(IssueCodes.API_TYPE_INFERENCE, SeverityConverter.SEVERITY_IGNORE));
		iAcceptor.accept(create(IssueCodes.IMPLICIT_RETURN, SeverityConverter.SEVERITY_IGNORE));
		iAcceptor.accept(create(IssueCodes.ORPHAN_ELEMENT, SeverityConverter.SEVERITY_IGNORE));
		iAcceptor.accept(create(IssueCodes.WRONG_FILE, SeverityConverter.SEVERITY_WARNING));
		iAcceptor.accept(create(IssueCodes.UNNECESSARY_MODIFIER, SeverityConverter.SEVERITY_WARNING));
		iAcceptor.accept(create(IssueCodes.MODIFIER_DOES_NOT_MATCH_TYPENAME, SeverityConverter.SEVERITY_WARNING));
		iAcceptor.accept(create(IssueCodes.TERNARY_EXPRESSION_NOT_ALLOWED, SeverityConverter.SEVERITY_IGNORE));		
		// overwrite xbase default
		iAcceptor.accept(create(org.eclipse.xtext.validation.IssueCodes.COPY_JAVA_PROBLEMS, SeverityConverter.SEVERITY_ERROR));
	}
	
	@Override
	protected String getUnqualifiedSuperCallSeverity() {
		return SeverityConverter.SEVERITY_ERROR;
	}
	
	@Override
	protected String getAbstractMethodInvocationSeverity() {
		return SeverityConverter.SEVERITY_ERROR;
	}
}
