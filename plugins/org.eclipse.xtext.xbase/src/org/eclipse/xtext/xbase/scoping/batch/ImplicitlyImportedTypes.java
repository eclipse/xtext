/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Singleton;

/**
 * Used to contribute features from Java types as
 * <ul>
 * <li>extension methods (see {@link #getExtensionClasses(Resource)}</li>
 * <l) statically imported methods (see {@link #getStaticImportClasses(Resource)}.</li>
 * <ul>
 * 
 * @deprecated use {@link ImplicitlyImportedFeatures} directly.
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
@Singleton
@Deprecated
public class ImplicitlyImportedTypes extends ImplicitlyImportedFeatures {
}
