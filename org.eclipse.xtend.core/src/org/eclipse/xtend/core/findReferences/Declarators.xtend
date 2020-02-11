/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.findReferences

import org.eclipse.xtext.findReferences.TargetURIs
import org.eclipse.xtext.naming.IQualifiedNameConverter
import com.google.inject.Inject
import org.eclipse.xtext.findReferences.IReferenceFinder
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtend.lib.annotations.Data
import java.util.Set
import org.eclipse.xtext.naming.QualifiedName

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Declarators {
	
	public static final TargetURIs.Key<DeclaratorsData> KEY = TargetURIs.Key.from("Xtend", DeclaratorsData)
	
	@Data
	static class DeclaratorsData {
		Set<QualifiedName> declaratorNames
	}
	
	@Inject
	IQualifiedNameConverter nameConverter
	
	def getDeclaratorData(TargetURIs targetURIs, IReferenceFinder.IResourceAccess resourceAccess) {
		var result = targetURIs.getUserData(KEY)
		if (result !== null) {
			return result
		}
		val declaratorNames = newHashSet()
		targetURIs.targetResourceURIs.forEach [ uri |
			resourceAccess.readOnly(uri) [
				targetURIs.getEObjectURIs(uri).forEach [ objectURI |
					val object = getEObject(objectURI, true)
					if (object !== null) {
						val type = EcoreUtil2.getContainerOfType(object, JvmType)
						if (type !== null) {
							declaratorNames += nameConverter.toQualifiedName(type.identifier).toLowerCase
							declaratorNames += nameConverter.toQualifiedName(type.getQualifiedName('.')).toLowerCase
						}
					}	
				]
				null				
			]
		]
		result = new DeclaratorsData(declaratorNames)
		targetURIs.putUserData(KEY, result)
		return result		
	}
	
}