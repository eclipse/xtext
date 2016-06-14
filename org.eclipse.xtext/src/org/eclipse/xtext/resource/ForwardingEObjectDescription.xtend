/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource

import com.google.common.collect.ForwardingObject
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * An abstract implementation of {@link IEObjectDescription} that delegates all
 * method invocations to another instance. Suitable to override and specialize 
 * behavior.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
@FinalFieldsConstructor
abstract class ForwardingEObjectDescription extends ForwardingObject implements IEObjectDescription {

	@Delegate
	val IEObjectDescription delegate;
	
	override protected delegate() {
		return this.delegate
	}
	
	override toString() {
		return 'ForwardingEObjectDescription[' + delegate + ']' 
	}
	
}