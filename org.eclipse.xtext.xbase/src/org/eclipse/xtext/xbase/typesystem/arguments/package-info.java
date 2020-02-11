/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
/**
 * Encapsulated handling of feature call arguments.
 * 
 * The main purpose of this encapsulation is to allow easier testing and
 * to be able to reorder to-be-computed argument types according to the
 * probability that they can be computed successfully, e.g. lambda 
 * expression should be computed last.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
package org.eclipse.xtext.xbase.typesystem.arguments;