/** 
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.imports

import java.util.Set
import org.eclipse.xtend.lib.annotations.AccessorType
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.xbase.XAbstractFeatureCall

import static extension org.eclipse.xtend.lib.annotations.AccessorType.*

/** 
 * @author dhuebner - Initial contribution and API
 */
interface ImportsAcceptor {
	def void acceptTypeImport(JvmType typeImport)

	def void acceptStaticImport(XAbstractFeatureCall staticImport)

	def void acceptStaticExtensionImport(XAbstractFeatureCall staticExtImport)

	@Accessors(AccessorType.PUBLIC_GETTER)
	static class DefaultImportsAcceptor implements ImportsAcceptor {
		Set<String> types = newHashSet()
		Set<String> staticImport = newHashSet()
		Set<String> extensions = newHashSet()

		override void acceptTypeImport(JvmType typeImport) {
			types.add(typeImport.qualifiedNameWithout$)
		}

		override void acceptStaticImport(XAbstractFeatureCall statImport) {
			staticImport.add(statImport.feature.qualifiedNameWithout$)
		}

		override void acceptStaticExtensionImport(XAbstractFeatureCall extImport) {
			extensions.add(extImport.feature.qualifiedNameWithout$)
		}

		def private String qualifiedNameWithout$(JvmIdentifiableElement ele) {
			ele.getQualifiedName('.')
		}
	}
}
