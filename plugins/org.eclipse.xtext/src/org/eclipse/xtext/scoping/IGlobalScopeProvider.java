/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping;

/**
 * A marker interface used to identify {@link IScopeProvider} implementations providing
 * scopes for the world, that is things which are not local (i.e. within a resource).
 * 
 * Common scope providers (local ones) use them to delegate lookup for any elements, which are not
 * locally available.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IGlobalScopeProvider extends IScopeProvider {

}
