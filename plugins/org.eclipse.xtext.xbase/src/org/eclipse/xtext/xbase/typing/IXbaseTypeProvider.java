/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.typing.ITypeProvider;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(IXbaseTypeProvider.Impl.class)
public interface IXbaseTypeProvider extends ITypeProvider<JvmTypeReference> {

	public JvmTypeReference getUnconvertedType(EObject astNode);
	
	static class Impl implements IXbaseTypeProvider {
		
		@Inject
		private ITypeProvider<JvmTypeReference> typeProvider;
		
		@Inject
		private TypeConverter converter;

		public JvmTypeReference getType(EObject astNode) {
			JvmTypeReference unconvertedType = getUnconvertedType(astNode);
			JvmTypeReference converted = converter.convert(unconvertedType, astNode);
			return converted;
		}

		public JvmTypeReference getUnconvertedType(EObject astNode) {
			JvmTypeReference type = typeProvider.getType(astNode);
			return type;
		}
		
	}
}
