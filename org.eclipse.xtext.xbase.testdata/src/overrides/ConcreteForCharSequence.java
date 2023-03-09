/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package overrides;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConcreteForCharSequence extends AbstractForCharSequence {

	@Override
	public <X extends CharSequence, Y extends X> X method(Class<? extends X> c) {
		return null;
	}

}
