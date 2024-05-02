/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.lsp;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.log4j.Logger;

/**
 * @since 2.35
 */
public class ForwardingClassLoader extends ClassLoader {
	
	private static final Logger logger = Logger.getLogger(ForwardingClassLoader.class);

	private URLClassLoader delegate;
	
	public ForwardingClassLoader() {
		super(ClassLoader.getPlatformClassLoader());
	}
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		if (delegate != null) {
			return delegate.loadClass(name);
		}
		return super.loadClass(name);
	}
	
	@Override
	public URL getResource(String name) {
		if (delegate != null) {
			return delegate.getResource(name);
		}
		return super.getResource(name);
	}
	
	@Override
	public InputStream getResourceAsStream(String name) {
		if (delegate != null) {
			return delegate.getResourceAsStream(name);
		}
		return super.getResourceAsStream(name);
	}
	
	public void setDelegate(URLClassLoader delegate) {
		if (this.delegate != null) {
			try {
				this.delegate.close();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
				this.delegate = null;
			}
		}
		this.delegate = delegate;
	}
	
	public ClassLoader getDelegate() {
		if (this.delegate != null) {
			return delegate;
		}
		return getParent();
	}
	
}
