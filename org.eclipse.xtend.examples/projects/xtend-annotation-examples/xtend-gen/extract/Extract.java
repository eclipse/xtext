/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package extract;

import extract.ExtractProcessor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.eclipse.xtend.lib.macro.Active;

/**
 * Extracts an interface for all locally declared public methods.
 */
@Target(ElementType.TYPE)
@Active(ExtractProcessor.class)
public @interface Extract {
}
