/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
import org.eclipse.xtext.validation.SeverityConverter;

import com.google.inject.Singleton;

/**
 * This class holds all the configurable issue codes for the Xbase language.<br>
 * Use {@link #getConfigurableIssueCodes()} to get all registered codes.<br>
 * 
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Dennis Huebner
 * @author Stéphane Galland - Add the "deprecation" warning. 
 */
@Singleton
public class XbaseConfigurableIssueCodes extends ConfigurableIssueCodesProvider {
	public static final String JDT_CORE_PLUGIN_ID = "org.eclipse.jdt.core"; //$NON-NLS-1$
	/* Constants are copied from org.eclipse.jdt.core.JavaCore to solve the dependency to jdt.core*/
	public static final String COMPILER_PB_DISCOURAGED_REFERENCE = JDT_CORE_PLUGIN_ID + ".compiler.problem.discouragedReference"; //$NON-NLS-1$
	public static final String COMPILER_PB_FORBIDDEN_REFERENCE = JDT_CORE_PLUGIN_ID + ".compiler.problem.forbiddenReference"; //$NON-NLS-1$
	public static final String COMPILER_PB_UNNECESSARY_TYPE_CHECK = JDT_CORE_PLUGIN_ID + ".compiler.problem.unnecessaryTypeCheck"; //$NON-NLS-1$
	public static final String COMPILER_PB_UNUSED_IMPORT = JDT_CORE_PLUGIN_ID + ".compiler.problem.unusedImport"; //$NON-NLS-1$
	public static final String COMPILER_PB_UNUSED_LOCAL = JDT_CORE_PLUGIN_ID + ".compiler.problem.unusedLocal"; //$NON-NLS-1$
	public static final String COMPILER_PB_DEPRECATION = JDT_CORE_PLUGIN_ID + ".compiler.problem.deprecation"; //$NON-NLS-1$
	public static final String COMPILER_PB_STATIC_ACCESS_RECEIVER = JDT_CORE_PLUGIN_ID + ".compiler.problem.staticAccessReceiver"; //$NON-NLS-1$

	@Override
	protected void initialize(IAcceptor<PreferenceKey> iAcceptor) {
		iAcceptor.accept(create(IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE, SeverityConverter.SEVERITY_WARNING));
		iAcceptor.accept(createDelegate(IssueCodes.INSTANCE_ACCESS_TO_STATIC_MEMBER, COMPILER_PB_STATIC_ACCESS_RECEIVER));
		iAcceptor.accept(create(IssueCodes.UNHANDLED_EXCEPTION, SeverityConverter.SEVERITY_IGNORE));
		iAcceptor.accept(create(IssueCodes.EQUALS_WITH_NULL, SeverityConverter.SEVERITY_WARNING));

		iAcceptor.accept(createDelegate(IssueCodes.FORBIDDEN_REFERENCE, COMPILER_PB_FORBIDDEN_REFERENCE));
		iAcceptor.accept(createDelegate(IssueCodes.DISCOURAGED_REFERENCE, COMPILER_PB_DISCOURAGED_REFERENCE));
		iAcceptor.accept(create(IssueCodes.IMPORT_WILDCARD_DEPRECATED, SeverityConverter.SEVERITY_WARNING));

		iAcceptor.accept(createDelegate(IssueCodes.OBSOLETE_INSTANCEOF, COMPILER_PB_UNNECESSARY_TYPE_CHECK));
		iAcceptor.accept(createDelegate(IssueCodes.OBSOLETE_CAST, COMPILER_PB_UNNECESSARY_TYPE_CHECK));
		iAcceptor.accept(createDelegate(IssueCodes.IMPORT_UNUSED, COMPILER_PB_UNUSED_IMPORT));
		iAcceptor.accept(createDelegate(IssueCodes.UNUSED_LOCAL_VARIABLE, COMPILER_PB_UNUSED_LOCAL));
		iAcceptor.accept(create(IssueCodes.IMPORT_DUPLICATE, SeverityConverter.SEVERITY_WARNING));
		iAcceptor.accept(create(IssueCodes.VARIABLE_NAME_DISCOURAGED, SeverityConverter.SEVERITY_WARNING));
		iAcceptor.accept(create(IssueCodes.IMPORT_UNRESOLVED, SeverityConverter.SEVERITY_ERROR));
		
		iAcceptor.accept(create(IssueCodes.JAVA_STYLE_TYPE_CAST, SeverityConverter.SEVERITY_ERROR));
		
		iAcceptor.accept(create(IssueCodes.SUSPICIOUSLY_OVERLOADED_FEATURE, SeverityConverter.SEVERITY_WARNING));
		
		iAcceptor.accept(create(IssueCodes.CONSTANT_BOOLEAN_CONDITION, SeverityConverter.SEVERITY_WARNING));
		iAcceptor.accept(create(IssueCodes.UNREACHABLE_CASE, SeverityConverter.SEVERITY_ERROR));
		iAcceptor.accept(create(IssueCodes.UNREACHABLE_IF_BLOCK, SeverityConverter.SEVERITY_ERROR));
		iAcceptor.accept(create(IssueCodes.INCOMPLETE_CASES_ON_ENUM, SeverityConverter.SEVERITY_WARNING));
		iAcceptor.accept(create(IssueCodes.OPERATION_WITHOUT_PARENTHESES, SeverityConverter.SEVERITY_IGNORE));
		iAcceptor.accept(create(IssueCodes.COPY_JAVA_PROBLEMS, SeverityConverter.SEVERITY_IGNORE));
		iAcceptor.accept(createDelegate(IssueCodes.DEPRECATED_MEMBER_REFERENCE, COMPILER_PB_DEPRECATION));
		
		iAcceptor.accept(create(IssueCodes.DUPLICATE_TYPE, SeverityConverter.SEVERITY_ERROR));
		
		iAcceptor.accept(create(IssueCodes.UNQUALIFIED_SUPER_CALL, getUnqualifiedSuperCallSeverity()));
		iAcceptor.accept(create(IssueCodes.ABSTRACT_METHOD_INVOCATION, getAbstractMethodInvocationSeverity()));
	}

	protected String getUnqualifiedSuperCallSeverity() {
		return SeverityConverter.SEVERITY_IGNORE;
	}
	
	protected String getAbstractMethodInvocationSeverity() {
		return SeverityConverter.SEVERITY_IGNORE;
	}

	protected PreferenceKey createDelegate(String id, String delegationKey) {
		return createDelegate(id, delegationKey, SeverityConverter.SEVERITY_WARNING);
	}

	protected PreferenceKey createDelegate(String id, String delegationKey, String defaultSeverity) {
		String encodedDelegation = XbaseSeverityConverter.encodeDefaultSeverity(delegationKey, defaultSeverity);
		return create(id, encodedDelegation);
	}

}
