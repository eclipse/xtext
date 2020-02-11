/*******************************************************************************
 * Copyright (c) 2011, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package test;

import java.util.List;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
interface SuperInterface {

	String string();

	String string(String s);

	Object object();

	Object object(Object o);

	List<String> returnsListString();

	List<? extends Object> returnsListExtendsObject();

	void voidFunction();
}
