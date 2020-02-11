/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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