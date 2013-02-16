/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package bug380058;

import java.util.Set;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class SystemOfUnits {
	public abstract Set<Unit<?>> getUnits();
}
