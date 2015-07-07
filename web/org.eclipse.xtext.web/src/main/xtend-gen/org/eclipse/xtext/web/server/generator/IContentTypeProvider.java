/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.generator;

/**
 * A content type provider is responsible for assigning content types to documents resulting
 * from an {@link org.eclipse.xtext.generator.IGenerator} implementation.
 */
@SuppressWarnings("all")
public interface IContentTypeProvider {
  public abstract String getContentType(final String fileName);
}
