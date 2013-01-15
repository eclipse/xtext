/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.quickfix

import org.eclipse.xtext.xbase.XMemberFeatureCall
import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.xbase.typing.ITypeProvider
import org.eclipse.emf.ecore.EObject

/**
 * @author Sebastian Benz - Initial contribution and API
 */
class IsUndefinedMethod {

	@Inject extension FeatureCallTargetTypeProvider
	@Inject extension ITypeProvider

	def callsUndefinedMethod(XMemberFeatureCall featureCall) {
		if (featureCall.targetType.isUnknown) {
			return false
		}
		val method = featureCall.feature
		if (method == null) {
			return false
		}
		if (method.eIsProxy) {
			return true
		}
		if (!(method instanceof JvmOperation)) {
			return false
		}
		return featureCall.calls(method as JvmOperation)
	}

	def protected calls(XMemberFeatureCall featureCall, JvmOperation operation) {
		val left = operation.parameters
		val right = featureCall.memberCallArguments
		if (left.size != right.size) {
			return true
		}
		var i = 0

		while (i < operation.parameters.size) {
			if (left.get(i).parameterType != right.get(i).type) {
				return true
			}
			i = i + 1
		}
		return false
	}

	def protected isUnknown(EObject obj) {
		obj == null || obj.eIsProxy
	}

}
