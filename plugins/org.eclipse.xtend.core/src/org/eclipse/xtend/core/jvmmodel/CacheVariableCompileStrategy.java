/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.jvmmodel;

import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Procedures;

import com.google.inject.Inject;

public class CacheVariableCompileStrategy implements Procedures.Procedure1<ITreeAppendable> {

	@Inject
	private TypeReferences typeReferences;

	private XtendFunction context;

	@Override
	public void apply(ITreeAppendable builder) {
		builder.append(typeReferences.findDeclaredType(CollectionLiterals.class, context));
		builder.append(".newHashMap()");
	}

	public void init(XtendFunction context) {
		this.context = context;
	}
}