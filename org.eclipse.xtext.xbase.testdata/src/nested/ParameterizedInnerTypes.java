/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package nested;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParameterizedInnerTypes<T> {
	
	public class Inner {}
	
	public static class Sub<S> extends ParameterizedInnerTypes<S> {
	}

}
