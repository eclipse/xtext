/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch

import java.util.List
import org.eclipse.xtend.lib.Data
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint
import java.util.Map
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import java.util.EnumSet
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices

/**
 * A type bucket collects a number of types that originate in the 
 * very same source, e.g. all imported types are contained in the 
 * same bucket where all types that are available via wildcard imports
 * are contained in a different bucket.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
class TypeBucket {
	int id
	List<? extends JvmType> types
	CommonTypeComputationServices commonServices
	def getHints() {
		EnumSet.of(ConformanceHint.CHECKED, ConformanceHint.SUCCESS)
	}
}

/**
 * A type bucket collects a number of types that originate in the 
 * very same source, e.g. all imported types are contained in the 
 * same bucket where all types that are available via wildcard imports
 * are contained in a different bucket.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
class ExpressionBucket {
    int id
    Map<XExpression, LightweightTypeReference> extensionProviders
}

/**
 * A type bucket that was produced from the synonym of a type.
 * It tracks the conformance hints for a synonym, e.g. boxing or unboxing information.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
class SynonymTypeBucket extends TypeBucket {
	EnumSet<ConformanceHint> hints
}

/**
 * A type bucket collects a number of types that originate in the 
 * very same source, e.g. all implicit receiver types are contained
 * in the very same bucket.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
class TypeReferenceBucket {
	int id
	List<JvmTypeReference> types
}