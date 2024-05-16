/*******************************************************************************
 * Copyright (c) 2024 Lorenzo Bettini and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.java.tests;

import java.util.Collection;
import java.util.List;

/**
 * To avoid breaking our tests with new Java API (e.g., in Java 21,
 * {@link List} extends SequencedCollection instead of Collection.
 * 
 * @author Lorenzo Bettini
 *
 */
public interface MyStubbedList<E> extends Collection<E> {

}
