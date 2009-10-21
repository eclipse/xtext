/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.index;

import java.io.IOException;

import org.eclipse.emf.emfindex.query.QueryCommand;
import org.eclipse.emf.emfindex.store.UpdateCommand;
import org.eclipse.emf.emfindex.store.UpdateableIndex;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IndexDelegator implements UpdateableIndex {
	protected UpdateableIndex delegate;

	public IndexDelegator(UpdateableIndex delegate) {
		this.delegate = delegate;
	}

	public <T> T executeUpdateCommand(UpdateCommand<T> updateCommand) {
		return delegate.executeUpdateCommand(updateCommand);
	}

	public void load() throws IOException {
		delegate.load();
	}

	public void save() throws IOException {
		delegate.save();
	}

	public <T> T executeQueryCommand(QueryCommand<T> queryCommand) {
		return delegate.executeQueryCommand(queryCommand);
	}
}
