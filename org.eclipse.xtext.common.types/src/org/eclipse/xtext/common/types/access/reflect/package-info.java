/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

/**
 * Types in this package serve as a simple reference implementation for the
 * {@link org.eclipse.xtext.common.types.access.impl.ITypeFactory} type factories.
 * 
 * It is rather limited, though, since the {@code java.lang.reflect} API does not
 * allow to retrieve some important information accross various Java versions, e.g.
 * the option to retrieve parameter names will only be introduced with Java8 and the
 * deprecation information is not available at runtime, too.
 * 
 * However, performance characteristics and semantics can be used as sort of a benchmark
 * or reference.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
package org.eclipse.xtext.common.types.access.reflect;