/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.jvmmodel;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;

/**
 * @author Lorenzo Bettini - Initial contribution and API, https://github.com/eclipse/xtext-eclipse/issues/1205
 */
public class DomainmodelJvmModelHelper {

	@Inject
	private OverrideHelper overrideHelper;

	/**
	 * Detects duplicated {@link JvmOperation}s in the passed {@link JvmDeclaredType} taking into consideration overloading and type
	 * erasure; each collection of duplicates is passed to the consumer.
	 */
	public void handleDuplicateJvmOperations(JvmDeclaredType jvmDeclaredType, Consumer<Collection<JvmOperation>> consumer) {
		// takes into consideration overloading and type erasure
		List<IResolvedOperation> methods = overrideHelper.getResolvedFeatures(jvmDeclaredType).getDeclaredOperations();
		Multimap<String, JvmOperation> signature2Declarations = HashMultimap.create();

		methods.forEach(method -> signature2Declarations.put(method.getResolvedErasureSignature(), method.getDeclaration()));

		signature2Declarations.asMap().values().forEach(jvmOperations -> {
			if (jvmOperations.size() > 1) {
				consumer.accept(jvmOperations);
			}
		});
	}
}
