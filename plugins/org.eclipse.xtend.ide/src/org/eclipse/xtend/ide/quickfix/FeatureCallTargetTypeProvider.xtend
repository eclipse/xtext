/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.quickfix

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.typing.ITypeProvider

/**
 * @author Sebastian Benz - Initial contribution and API
 */
class FeatureCallTargetTypeProvider {

	@Inject extension ITypeProvider

	def targetType(XMemberFeatureCall featureCall) {
		featureCall.targetFeature?.typeForIdentifiable?.type
	}

	def protected JvmIdentifiableElement targetFeature(XMemberFeatureCall featureCall) {
		val memberCallTarget = featureCall.memberCallTarget
		if (memberCallTarget instanceof XConstructorCall) {
			return (memberCallTarget as XConstructorCall).constructor?.declaringType
		}
		if (!(memberCallTarget instanceof XAbstractFeatureCall)) {
			return null
		}
		(memberCallTarget as XAbstractFeatureCall).feature
	}

}
