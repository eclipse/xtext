/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.refactoring;

import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext;

/**
 * Allows a language to execute side-effects when the URI of a resource changes.
 * 
 * Such changes can be move, rename and copy operations, e.g. triggered by the
 * user in a file browser. An example for a language in which such side-effects
 * would make sense is Java, where the package name and the name of the first
 * public top-level class must match the resource's path.
 * 
 * Clients usually call {@link ResourceRelocationContext.addModification()} to
 * register their side effects. This way it is ensured that the resource is
 * properly loaded and watched for changes.
 * 
 * In Eclipse, {@link IResourceRelocationStrategy} are registered to an extension
 * point.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public interface IResourceRelocationStrategy {
  public abstract void applyChange(final ResourceRelocationContext context);
}
