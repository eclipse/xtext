/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Author - Sven Efftinge
 *******************************************************************************/
package example5

import java.math.BigDecimal
import org.eclipse.xtend.lib.annotations.Data

@Data class Speed {
	BigDecimal mmPerMsec

	def static /(Distance d, Time t) {
		new Speed(d.mm / t.msec)
	}
}