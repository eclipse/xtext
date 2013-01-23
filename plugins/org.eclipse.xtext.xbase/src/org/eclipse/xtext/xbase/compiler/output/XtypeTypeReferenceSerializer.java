/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler.output;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

/**
 * @author Holger Schill - Initial contribution and API
 */
@NonNullByDefault
public class XtypeTypeReferenceSerializer extends TypeReferenceSerializer {

	@Override
	public void serialize(JvmTypeReference type, EObject context, IAppendable appendable, boolean withoutConstraints,
			boolean paramsToWildcard, boolean paramsToObject, boolean allowPrimitives) {
		if (type instanceof XFunctionTypeRef){
			XFunctionTypeRef ref = (XFunctionTypeRef) type;
			appendable.append("(");
			Iterator<JvmTypeReference> iterator = ref.getParamTypes().iterator();
			while(iterator.hasNext()){
				serialize(iterator.next(), context, appendable);
				if(iterator.hasNext())
					appendable.append(", ");
			}
			appendable.append(")");
			appendable.append("=>");
			serialize(ref.getReturnType(),context , appendable);
		} else
			super.serialize(type, context, appendable, withoutConstraints, paramsToWildcard, paramsToObject,
					allowPrimitives);
	}
}
