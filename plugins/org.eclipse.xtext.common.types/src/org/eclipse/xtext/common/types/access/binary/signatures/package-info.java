/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 * Small utility classes that allow to traverse binary char arrays with
 * some higher level APIs. Instead of fiddling with indizes on the client
 * side, it's possible to obtain a richer view on the chars and use that one
 * e.g. to convert the binary signatures to {@link org.eclipse.emf.common.util.URI}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
package org.eclipse.xtext.common.types.access.binary.signatures;