/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.core.parsetree;

import org.eclipse.xtext.core.parsetree.AbstractParseTreeConstructor.InstanceDescription;


/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public abstract class Predicate {

	protected InstanceDescription obj;

	public Predicate(InstanceDescription obj) {
		this.obj = obj.newLookaheadDescription();
	}

	public abstract boolean check();

}
