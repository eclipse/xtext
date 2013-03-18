/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package observables;

import observables.ObservableCompilationParticipant;
import org.eclipse.xtend.lib.macro.Active;

/**
 * Adds a getter and setter method for all fields
 * Adds PropertyChangeSupport to this class and informs all listeners on change.
 */
@Active(ObservableCompilationParticipant.class)
public @interface Observable {
}
