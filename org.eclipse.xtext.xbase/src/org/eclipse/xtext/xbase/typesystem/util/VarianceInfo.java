/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.List;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO More JavaDoc
 */
public enum VarianceInfo {
	
	/**
	 * <pre>
	 *  public &lt;T&gt; void method(List&lt;T&gt; list) {
	 *    List&lt;String&gt; someList = ..
	 *    method(someList)
	 *  }
	 * </pre>
	 */
	INVARIANT {
		@Override
		protected VarianceInfo doMergeDeclaredWithActuals(List<VarianceInfo> actualVariances) {
			for(VarianceInfo actualVariance: actualVariances) {
				if (actualVariance != this)
					return null;
			}
			return this;
		}
		
		@Override
		protected VarianceInfo doMergeDeclaredWithActual(VarianceInfo actualVariance) {
			return actualVariance;
		}
	},
	
	/**
	 * <pre>
	 *  public &lt;T&gt; void method(List&lt;? super T&gt; list) {
	 *    List&lt;String&gt; someList = ..
	 *    method(someList)
	 *  }
	 * </pre>
	 */
	IN {
		@Override
		protected VarianceInfo doMergeDeclaredWithActuals(List<VarianceInfo> actualVariances) {
			VarianceInfo result = actualVariances.get(0);
			for(int i = 1; i < actualVariances.size() && result != null; i++) {
				VarianceInfo actualVariance = actualVariances.get(i);
				if (result == OUT || actualVariance == OUT) {
					result = null;
				} else {
					result = INVARIANT;
				}
			}
			return result;
		}
		
		@Override
		protected VarianceInfo doMergeDeclaredWithActual(VarianceInfo actualVariance) {
			if (actualVariance == OUT)
				return null;
			return INVARIANT;
		}
		
		@Override
		public VarianceInfo mergeInvariance(VarianceInfo invariantMerge, VarianceInfo myMerge) {
			if (invariantMerge == null || myMerge == null) {
				return null;
			}
			if (invariantMerge == myMerge) {
				return invariantMerge;
			}
			if (invariantMerge == OUT && myMerge == INVARIANT)
				return OUT;
			if (invariantMerge == IN && myMerge == INVARIANT)
				return null;
			return invariantMerge;
		}
	},
	
	/**
	 * <pre>
	 *  public &lt;T&gt; void method(List&lt;? extends T&gt; list) {
	 *    List&lt;String&gt; someList = ..
	 *    method(someList)
	 *  }
	 * </pre>
	 */
	OUT {
		@Override
		protected VarianceInfo doMergeDeclaredWithActuals(List<VarianceInfo> actualVariances) {
			VarianceInfo result = actualVariances.get(0);
			for(int i = 1; i < actualVariances.size() && result != null; i++) {
				VarianceInfo actualVariance = actualVariances.get(i);
				if (result == IN || actualVariance == IN) {
					result = null;
				} else {
					result = INVARIANT;
				}
			}
			return result;
		}
		
		@Override
		protected VarianceInfo doMergeDeclaredWithActual(VarianceInfo actualVariance) {
			if (actualVariance == IN)
				return null;
			return INVARIANT;
		}
	};

	public VarianceInfo mergeDeclaredWithActuals(List<VarianceInfo> actualVariances) {
		if (actualVariances == null || actualVariances.size() == 0)
			return null;
		if (actualVariances.size() == 1) {
			return mergeDeclaredWithActual(actualVariances.get(0));
		}
		return doMergeDeclaredWithActuals(actualVariances);
	}
	
	public VarianceInfo mergeInvariance(VarianceInfo invariantMerge, VarianceInfo myMerge) {
		if (invariantMerge == null || myMerge == null) {
			return null;
		}
		if (invariantMerge == myMerge) {
			return invariantMerge;
		}
		if (invariantMerge == OUT && myMerge == INVARIANT)
			return null;
		if (invariantMerge == IN && myMerge == INVARIANT)
			return invariantMerge;
		return invariantMerge;
	}
	

	public VarianceInfo mergeWithOut(VarianceInfo outVariantMerge, VarianceInfo myMerge, boolean inAndOutConformant) {
		if (outVariantMerge == null || myMerge == null) {
			return null;
		}
		if (outVariantMerge == OUT && myMerge == INVARIANT)
			return null;
		if (outVariantMerge == IN && myMerge == INVARIANT)
			return outVariantMerge;
		if (outVariantMerge == INVARIANT && myMerge == INVARIANT && !inAndOutConformant)
			return null;
		return outVariantMerge;
	}
	
	protected abstract VarianceInfo doMergeDeclaredWithActuals(List<VarianceInfo> actualVariances);

	public VarianceInfo mergeDeclaredWithActual(VarianceInfo actualVariance) {
		if (actualVariance == null)
			return null;
		return doMergeDeclaredWithActual(actualVariance);
	}

	protected abstract VarianceInfo doMergeDeclaredWithActual(VarianceInfo actualVariance);

}