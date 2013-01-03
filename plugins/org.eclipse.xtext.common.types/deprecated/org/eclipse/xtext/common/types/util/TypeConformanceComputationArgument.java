/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class TypeConformanceComputationArgument {

	protected final boolean rawType;
	protected final boolean asTypeArgument;
	protected final boolean allowPrimitiveConversion;
	
	public TypeConformanceComputationArgument(boolean rawType, boolean asTypeArgument,
			boolean allowPrimitiveConversion) {
		this.rawType = rawType;
		this.asTypeArgument = asTypeArgument;
		this.allowPrimitiveConversion = allowPrimitiveConversion;
	}
	
	public boolean isAllowPrimitiveConversion() {
		return allowPrimitiveConversion;
	}
	
	public boolean isAsTypeArgument() {
		return asTypeArgument;
	}
	
	public boolean isRawType() {
		return rawType;
	}

	@Override
	public String toString() {
		return "TypeConformanceComputationArgument [rawType=" + rawType + ", asTypeArgument=" + asTypeArgument
				+ ", allowPrimitiveConversion=" + allowPrimitiveConversion + "]";
	}

	protected static class Internal<T extends JvmTypeReference> extends TypeConformanceComputationArgument {
		protected final T reference;
		
		protected static <T extends JvmTypeReference> Internal<T> create(T reference, boolean rawType, boolean asTypeArgument, boolean allowPrimitiveConversion) {
			return new Internal<T>(reference, rawType, asTypeArgument, allowPrimitiveConversion);
		}
		
		protected Internal(T reference, boolean rawType, boolean asTypeArgument, boolean allowPrimitiveConversion) {
			super(rawType, asTypeArgument, allowPrimitiveConversion);
			this.reference = reference;
		}

		@Override
		public String toString() {
			return "TypeConformanceComputationArgument.Internal [reference=" + reference + ", rawType=" + rawType + ", asTypeArgument=" + asTypeArgument
					+ ", allowPrimitiveConversion=" + allowPrimitiveConversion + "]";
		}
	}
	
}