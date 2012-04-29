/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.lib.BigDecimalExtensions;
import org.eclipse.xtext.xbase.lib.BigIntegerExtensions;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.ByteExtensions;
import org.eclipse.xtext.xbase.lib.CharacterExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.FloatExtensions;
import org.eclipse.xtext.xbase.lib.FunctionExtensions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.LongExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.ProcedureExtensions;
import org.eclipse.xtext.xbase.lib.ShortExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString that lists the literal and extension classes
 */
@Singleton
public class ImplicitlyImportedTypes {
	
	@Inject
	private TypeReferences typeReferences;
	
	public List<JvmType> getLiteralClasses(Resource context) {
		List<Class<?>> classes = getLiteralClasses();
		return getTypes(classes, context);
	}

	public List<JvmType> getExtensionClasses(Resource context) {
		List<Class<?>> classes = getExtensionClasses();
		return getTypes(classes, context);
	}
	
	protected List<JvmType> getTypes(List<Class<?>> classes, Resource context) {
		List<JvmType> result = Lists.newArrayListWithCapacity(classes.size());
		for(Class<?> clazz: classes) {
			JvmType type = typeReferences.findDeclaredType(clazz, context);
			if (type != null)
				result.add(type);
		}
		return result;
	}

	protected List<Class<?>> getLiteralClasses() {
		return Lists.<Class<?>> newArrayList(
			CollectionLiterals.class,
			InputOutput.class);
	}

	protected List<Class<?>> getExtensionClasses() {
		return Lists.<Class<?>> newArrayList(
			BigDecimalExtensions.class,
			BigIntegerExtensions.class,
			BooleanExtensions.class,
			ByteExtensions.class,
			CharacterExtensions.class,
			CollectionExtensions.class,
			ComparableExtensions.class,
			DoubleExtensions.class,
			FloatExtensions.class,
			FunctionExtensions.class,
			IntegerExtensions.class,
			IterableExtensions.class,
			IteratorExtensions.class,
			ListExtensions.class,
			LongExtensions.class,
			MapExtensions.class,
			ObjectExtensions.class,
			ProcedureExtensions.class,
			ShortExtensions.class,
			StringExtensions.class);
	}

//	public static void main(String[] args) {
//		List<Class<?>> classes = new ImplicitlyImportedTypes().getExtensionClasses();
//		List<String> strings = Lists.newArrayList();
//		for(Class<?> clazz: classes) {
//			strings.add(clazz.getSimpleName());
//		}
//		Collections.sort(strings);
//		for(String s: strings) System.out.println(s+ ".class,");
//	}
}
