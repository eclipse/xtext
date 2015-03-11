/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
