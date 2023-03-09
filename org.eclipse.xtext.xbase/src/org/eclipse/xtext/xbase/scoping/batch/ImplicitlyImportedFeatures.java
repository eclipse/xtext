/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.lib.ArrayExtensions;
import org.eclipse.xtext.xbase.lib.ArrayLiterals;
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
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Used to contribute features from Java types as
 * <ul>
 * <li>extension methods (see {@link #getExtensionClasses(Resource)}</li>
 * <li> statically imported methods (see {@link #getStaticImportClasses(Resource)}.</li>
 * </ul>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
@SuppressWarnings("all" /* deprecation */)
@Singleton
public class ImplicitlyImportedFeatures {
	
	@Inject
	private TypeReferences typeReferences;
	
	/**
	 * @return all JvmType containing static methods which are implicitly imported
	 */
	public List<JvmType> getStaticImportClasses(Resource context) {
		List<Class<?>> classes = getStaticImportClasses();
		return getTypes(classes, context);
	}

	/**
	 * @return all JvmTypes who's static methods are put on the scope of their first argument type (i.e. extension methods).
	 */
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

	/*
	 * The list should be sorted since it allows for easier diff and merge
	 */
	protected List<Class<?>> getStaticImportClasses() {
		return Lists.<Class<?>> newArrayList(
			ArrayLiterals.class,
			CollectionLiterals.class,
			InputOutput.class);
	}

	/*
	 * The list should be sorted since it allows for easier diff and merge
	 */
	protected List<Class<?>> getExtensionClasses() {
		return Lists.<Class<?>> newArrayList(
			ArrayExtensions.class,
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

}
