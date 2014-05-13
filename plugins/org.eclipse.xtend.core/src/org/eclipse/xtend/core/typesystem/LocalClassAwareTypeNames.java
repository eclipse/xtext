/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.typesystem;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.HumanReadableTypeNames;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LocalClassAwareTypeNames extends HumanReadableTypeNames {

	@Override
	protected void doVisitParameterizedTypeReference(ParameterizedTypeReference reference, StringBuilder param) {
		JvmType type = reference.getType();
		if (type instanceof JvmDeclaredType) {
			boolean local = ((JvmDeclaredType) type).isLocal();
			if (local) {
				param.append("new ");
				reference.getSuperTypes().get(0).accept(this, param);
				param.append("(){}");
				return;
			}
		}
		super.doVisitParameterizedTypeReference(reference, param);
	}
	
}
