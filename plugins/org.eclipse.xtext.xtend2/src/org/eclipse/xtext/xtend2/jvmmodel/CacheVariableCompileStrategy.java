/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.jvmmodel;

import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions;

import com.google.inject.Inject;

public class CacheVariableCompileStrategy implements Functions.Function1<ImportManager, CharSequence> {

	@Inject
	private TypeReferences typeReferences;

	@Inject
	private TypeReferenceSerializer typeReferenceSerializer;

	private JvmGenericType container;

	public CharSequence apply(ImportManager p) {
		StringBuilderBasedAppendable builder = new StringBuilderBasedAppendable(p);
		typeReferenceSerializer.serialize(typeReferences.getTypeForName(CollectionLiterals.class, container),
				container, builder);
		builder.append(".newHashMap()");
		return builder.toString();
	}

	public void init(JvmGenericType container) {
		this.container = container;
	}
}