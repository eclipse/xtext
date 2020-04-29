/*******************************************************************************
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting2

import com.google.common.collect.AbstractIterator
import java.util.Iterator
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@FinalFieldsConstructor class SeparatorRegions<T, R extends ITextSegment> implements Iterable<ObjectEntry<T, R>> {
	@Accessors val ITextSegment root

	ObjectEntry<T, R> first

	def void prepend(T object) {
		val newObject = new ObjectEntry<T, R>(this)
		newObject.object = object
		if (first === null) {
			first = newObject
		} else {
			newObject.next = first.leadingSeparator
			first.leadingSeparator.next = newObject
			first = newObject
		}
	}

	def void prependWithLeadingSeparator(T object, R separator) {
		val newObject = new ObjectEntry<T, R>(this)
		val newSeparator = new SeparatorEntry<T, R>
		newObject.object = object
		newSeparator.separator = separator
		newObject.previous = newSeparator
		newSeparator.next = newObject
		if (first === null) {
			first = newObject
		} else {
			newObject.next = first.leadingSeparator
			first.leadingSeparator.previous = newObject
			first = newObject
		}
	}

	def void appendWithTrailingSeparator(T object, R separator) {
		val newObject = new ObjectEntry<T, R>(this)
		newObject.object = object
		if (separator !== null) {
			val newSeparator = new SeparatorEntry<T, R>
			newSeparator.separator = separator
			newObject.next = newSeparator
			newSeparator.previous = newObject
		}
		if (first === null) {
			first = newObject
		} else {
			val last = separators.last
			newObject.previous = last
			last.next = newObject
		}
	}

	override Iterator<ObjectEntry<T, R>> iterator() {
		new AbstractIterator<ObjectEntry<T, R>>() {
			ObjectEntry<T, R> next = SeparatorRegions.this.first

			override protected computeNext() {
				if (next === null)
					return endOfData()
				val current = next
				next = next.trailingObject
				current
			}
		}
	}

	def Iterable<SeparatorEntry<T, R>> separators() {
		new Iterable<SeparatorEntry<T, R>>() {
			override iterator() {
				new AbstractIterator<SeparatorEntry<T, R>>() {
					SeparatorEntry<T, R> next = SeparatorRegions.this.first.trailingSeparator

					override protected computeNext() {
						if (next === null)
							return endOfData()
						val current = next
						next = next.trailingSeparator
						current
					}
				}
			}
		}
	}

	override toString() {
		if (first !== null) {
			val list = newArrayList()
			var Entry<T, R> current = first.leadingSeparator
			while (current !== null) {
				list += current.toString
				current = current.next
			}
			list.join("\n")
		} else {
			"empty"
		}
	}

}
