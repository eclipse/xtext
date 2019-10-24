/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.jvmmodel

import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap
import com.google.inject.Inject
import java.util.Collection
import java.util.function.Consumer
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.xbase.typesystem.^override.OverrideHelper

/**
 * @author Lorenzo Bettini - Initial contribution and API, https://github.com/eclipse/xtext-eclipse/issues/1205
 */
class DomainmodelJvmModelHelper {

	@Inject extension OverrideHelper

	/**
	 * Detects duplicated {@link JvmOperation}s in the passed {@link JvmDeclaredType}
	 * taking into consideration overloading and type erasure; each collection of
	 * duplicates is passed to the consumer.
	 */
	def void handleDuplicateJvmOperations(JvmDeclaredType jvmDeclaredType,
		Consumer<Collection<JvmOperation>> consumer) {
		// takes into consideration overloading and type erasure
		val methods = jvmDeclaredType.getResolvedFeatures.declaredOperations
		val Multimap<String, JvmOperation> signature2Declarations = HashMultimap.create

		methods.forEach [
			signature2Declarations.put(resolvedErasureSignature, declaration)
		]

		signature2Declarations.asMap.values.forEach [ jvmOperations |
			if (jvmOperations.size > 1) {
				consumer.accept(jvmOperations)
			}
		]
	}
}
