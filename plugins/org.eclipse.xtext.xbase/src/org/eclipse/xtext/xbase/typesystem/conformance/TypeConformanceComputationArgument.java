/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
public class TypeConformanceComputationArgument {

	protected final boolean rawType;
	protected final boolean asTypeArgument;
	protected final boolean allowPrimitiveConversion;
	protected final boolean allowPrimitiveWidening;
	protected final boolean unboundComputationAddsHints;
	protected final boolean allowSynonyms;
	
	public TypeConformanceComputationArgument() {
		this(false, false, true, true, false, true);
	}
	
	public TypeConformanceComputationArgument(boolean rawType, boolean asTypeArgument,
			boolean allowPrimitiveConversion, boolean allowPrimitiveWidening, boolean unboundComputationAddsHints,
			boolean allowSynonyms) {
		this.rawType = rawType;
		this.asTypeArgument = asTypeArgument;
		this.allowPrimitiveConversion = allowPrimitiveConversion;
		this.allowPrimitiveWidening = allowPrimitiveWidening;
		this.unboundComputationAddsHints = unboundComputationAddsHints;
		this.allowSynonyms = allowSynonyms;
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
	
	protected String flagsToString() {
		return "rawType=" + String.valueOf(rawType).toUpperCase() + ",\n\t" +
				"asTypeArgument=" + String.valueOf(asTypeArgument).toUpperCase() + ",\n\t" +
				"allowPrimitiveConversion=" + String.valueOf(allowPrimitiveConversion).toUpperCase() + ",\n\t" +
				"allowPrimitiveWidening=" + String.valueOf(allowPrimitiveWidening).toUpperCase() + ",\n\t" +
				"unboundComputationAddsHints=" + String.valueOf(unboundComputationAddsHints).toUpperCase() + ",\n\t" +
				"allowSynonyms=" + String.valueOf(allowSynonyms).toUpperCase();
				
	}

	@Override
	public String toString() {
		return "TypeConformanceComputationArgument [\n\t" +
				flagsToString() + "\n" +
				"]";
	}

	protected static class Internal<T extends LightweightTypeReference> extends TypeConformanceComputationArgument {
		protected final T reference;
		
		protected static <T extends LightweightTypeReference> Internal<T> create(T reference, 
				boolean rawType, boolean asTypeArgument, boolean allowPrimitiveConversion, boolean allowPrimitiveWidening, boolean unboundComputationAddsHints, boolean allowSynonyms) {
			return new Internal<T>(reference, rawType, asTypeArgument, allowPrimitiveConversion, allowPrimitiveWidening, unboundComputationAddsHints, allowSynonyms);
		}
		
		protected Internal(T reference, boolean rawType, boolean asTypeArgument, boolean allowPrimitiveConversion, boolean allowPrimitiveWidening, boolean unboundComputationAddsHints, boolean allowSynonyms) {
			super(rawType, asTypeArgument, allowPrimitiveConversion, allowPrimitiveWidening, unboundComputationAddsHints, allowSynonyms);
			this.reference = reference;
		}

		@Override
		public String toString() {
			return "TypeConformanceComputationArgument.Internal [\n\t" +
					"reference=" + reference + ",\n\t" +
					flagsToString() + "\n" +
					"]";
		}
	}
	
}