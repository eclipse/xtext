/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package bug380058;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Amount<Q extends Quantity> implements Field<Amount<?>>, Measurable<Q> {

	public static <Q extends Quantity> Amount<Q> valueOf(int i, Unit<Q> unit) { return null; }
	
	public Amount<Q> plus(Amount<Q> other) { return null; }
	public Amount<Q> times(int i) { return null; }
	
}
