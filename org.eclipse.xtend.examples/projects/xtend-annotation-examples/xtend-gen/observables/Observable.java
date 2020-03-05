/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package observables;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import observables.ObservableCompilationParticipant;
import org.eclipse.xtend.lib.macro.Active;

/**
 * Adds a getter and setter method for all fields
 * Adds PropertyChangeSupport to this class and informs all listeners on change.
 */
@Target(ElementType.TYPE)
@Active(ObservableCompilationParticipant.class)
@SuppressWarnings("all")
public @interface Observable {
}
