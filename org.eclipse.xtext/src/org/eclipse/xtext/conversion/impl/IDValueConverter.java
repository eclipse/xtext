/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;

import com.google.common.collect.ImmutableSet;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IDValueConverter extends AbstractIDValueConverter {
	
	public IDValueConverter() {
		super();
	}
	
	@Override
	protected Set<String> computeValuesToEscape(Grammar grammar) {
		return ImmutableSet.copyOf(GrammarUtil.getAllKeywords(grammar));
	}

	@Override
	protected boolean mustEscape(String value) {
		return getValuesToEscape().contains(value);
	}
}