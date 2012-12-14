/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static com.google.common.collect.Maps.*;

import java.util.Map;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseConfigurableIssueCodes extends ConfigurableIssueCodesProvider {

	public static final PreferenceKey FORBIDDEN_REFERENCE = new PreferenceKey(IssueCodes.FORBIDDEN_REFERENCE, JavaCore.COMPILER_PB_FORBIDDEN_REFERENCE);
	public static final PreferenceKey DISCOURAGED_REFERENCE = new PreferenceKey(IssueCodes.DISCOURAGED_REFERENCE, JavaCore.COMPILER_PB_DISCOURAGED_REFERENCE);
	
	private static final Map<String, PreferenceKey> allConfigurableCodes = newLinkedHashMap();
	
	static {
		allConfigurableCodes.put(FORBIDDEN_REFERENCE.getId(), FORBIDDEN_REFERENCE);
		allConfigurableCodes.put(DISCOURAGED_REFERENCE.getId(), DISCOURAGED_REFERENCE);
	}
	
	@Override
	public Map<String, PreferenceKey> getConfigurableIssueCodes() {
		return allConfigurableCodes;
	}
}
