/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.jvmmodel;

import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Procedures;

public class CacheVariableCompileStrategy implements Procedures.Procedure1<ITreeAppendable> {

	@Override
	public void apply(ITreeAppendable builder) {
		builder.append(CollectionLiterals.class).append(".newHashMap()");
	}

}