/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState.impl;

import org.eclipse.core.resources.IStorage;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(StorageUtilImpl.class)
public interface IStorageUtil {

	public String toExternalString(IStorage storage);

	public IStorage getStorage(String externalString);
	
	static class Access {
		static IStorageUtil storageUtil;

		public static void setStorageUtil(IStorageUtil instance) {
			if (storageUtil!=null)
				throw new IllegalStateException("storageUril already set!");
			storageUtil = instance;
		}
	}

}
