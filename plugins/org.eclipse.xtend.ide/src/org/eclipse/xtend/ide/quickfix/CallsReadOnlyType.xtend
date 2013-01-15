/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.quickfix

import org.eclipse.xtext.common.types.JvmType
import com.google.inject.Inject
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder
import org.eclipse.xtext.xbase.XMemberFeatureCall

class CallsReadOnlyType {

	extension IJavaElementFinder elementFinder
	extension FeatureCallTargetTypeProvider targetTypeProvider

	@Inject
	new(IJavaElementFinder elementFinder, FeatureCallTargetTypeProvider targetTypeProvider) {
		this.elementFinder = elementFinder
		this.targetTypeProvider = targetTypeProvider
	}

	def receiverIsReadOnly(XMemberFeatureCall featureCall) {
		return featureCall.targetType?.targetJavaElement?.isReadOnly
	}

	def protected targetJavaElement(JvmType type) {
		findElementFor(type)
	}

}
