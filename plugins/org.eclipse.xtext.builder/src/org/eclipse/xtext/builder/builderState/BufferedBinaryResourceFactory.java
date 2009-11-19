/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * @author koehnlein - Initial contribution and API
 */
public class BufferedBinaryResourceFactory extends ResourceFactoryImpl {
	@Override
	public Resource createResource(URI uri) {
		return new BinaryResourceImpl(uri) {
			@Override
			protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
				BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 8192 * 2 * 2 * 2);
				try {
					super.doSave(bufferedOutputStream, options);
				}
				finally {
					bufferedOutputStream.close();
				}
			}

			@Override
			protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
				InputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192 * 2 * 2 * 2);
				try {
					super.doLoad(bufferedInputStream, options);
				}
				finally {
					bufferedInputStream.close();
				}
			}
		};
	}
}