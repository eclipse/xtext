/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package testdata;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractClosableWithList implements AutoCloseable {
	List<String> list;

	public AbstractClosableWithList() {
		this.list = new ArrayList<String>();
		this.list.add("new");
	}

	public void add(String entry) {
		list.add(entry);
	}

	public List<String> getList() {
		return list;
	}

	public String printList() {
		return list.toString();
	}
}
