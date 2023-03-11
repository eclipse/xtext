/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import com.google.common.base.Preconditions
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.emf.ecore.EObject

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class ConditionUtils {
	
	static def notRemoved(EObject object, String name) {
		Preconditions.checkArgument(object !== null, '''«name» cannot be null''')
		Preconditions.checkArgument(object.eResource !== null, '''«name» cannot be removed''')
	}
	
	static def checkInferredTypeReferences(String typeName, TypeReference ... types) {
		for (type : types) {
			if (type !== null && type.inferred) {
				throw new IllegalArgumentException('''Cannot use inferred type as «typeName».''')
			}
		}
	}

	static def checkIterable(Iterable<?> values, String name) {
		Preconditions.checkArgument(values !== null, '''«name» cannot be null''')
		for (value : values) {
			Preconditions.checkArgument(value !== null, '''«name» cannot contain null''')
		}
	}

	static def checkQualifiedName(String qualifiedName, String name) {
		Preconditions.checkArgument(isValidQualifiedName(qualifiedName), '''«name» has to be a valid qualified name''')
	}

	static def checkJavaIdentifier(String string, String name) {
		Preconditions.checkArgument(isValidJavaIdentifier(string), '''«name» has to be a valid java identifier''')
	}
	
	static def checkTypeName(String typeName, String valueType) {
		Preconditions.checkArgument(typeName == valueType, valueType.isNotApplicableMessage(typeName))
	}
	
	static def String isNotApplicableMessage(String valueType, String typeName) '''«valueType» is not applicable at this location. Expected «typeName»'''

	static def isValidQualifiedName(String string) {
		if (string === null || string.length == 0) {
			return false
		}
		for (identifier : string.split("\\.")) {
			if (!identifier.validJavaIdentifier) {
				return false
			}
		}
		true
	}

	static def isValidJavaIdentifier(String string) {
		if (string === null || string.length == 0) {
			return false
		}
		val charArray = string.toCharArray
		if (!Character.isJavaIdentifierStart(charArray.head)) {
			return false
		}
		for (ch : charArray.tail) {
			if (!Character.isJavaIdentifierPart(ch)) {
				return false
			}
		}
		true
	}

}
