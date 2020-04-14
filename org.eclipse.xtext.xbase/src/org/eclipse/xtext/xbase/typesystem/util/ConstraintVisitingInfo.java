/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API TODO JavaDoc
 */
public class ConstraintVisitingInfo {
	private Set<JvmTypeParameter> visiting;

	private JvmTypeParameterDeclarator declarator;

	private int idx;

	public ConstraintVisitingInfo() {
		this.visiting = new HashSet<>();
	}

	public ConstraintVisitingInfo(JvmTypeParameter initial) {
		this.visiting = Sets.newHashSet(initial);
	}

	public boolean tryVisit(JvmTypeParameter parameter) {
		return visiting.add(parameter);
	}

	public boolean canVisit(JvmTypeParameter parameter) {
		return !visiting.contains(parameter);
	}

	public void didVisit(JvmTypeParameter parameter) {
		this.visiting.remove(parameter);
	}

	public void pushInfo(JvmTypeParameterDeclarator declarator, int idx) {
		if (declarator == null) {
			throw new NullPointerException("declarator may not be null");
		}
		this.declarator = declarator;
		this.idx = idx;
	}

	public JvmTypeParameterDeclarator getCurrentDeclarator() {
		return declarator;
	}

	public int getCurrentIndex() {
		return idx;
	}
}
