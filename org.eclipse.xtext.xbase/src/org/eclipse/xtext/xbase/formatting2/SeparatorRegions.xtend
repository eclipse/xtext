/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.formatting2.regionaccess.internal.TextSegment

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

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@Accessors abstract class Entry<T, R extends ITextSegment> {
	protected Entry<T, R> next
	protected Entry<T, R> previous

	def abstract ObjectEntry<T, R> getLeadingObject()

	def abstract ObjectEntry<T, R> getTrailingObject()

	def abstract SeparatorEntry<T, R> getLeadingSeparator()

	def abstract SeparatorEntry<T, R> getTrailingSeparator()
}

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@FinalFieldsConstructor @Accessors class ObjectEntry<T, R extends ITextSegment> extends Entry<T, R> {
	val SeparatorRegions<T, R> list
	T object

	def ITextSegment getRegion() {
		val prev = leadingSeparator
		val trail = trailingSeparator
		val offset = if(prev !== null) prev.separator.endOffset else list.root.offset
		val endOffset = if(trail !== null) trail.separator.offset else list.root.endOffset
		return new TextSegment(list.root.textRegionAccess, offset, endOffset - offset)
	}

	override getLeadingObject() {
		previous?.previous as ObjectEntry<T, R>
	}

	override getTrailingObject() {
		next?.next as ObjectEntry<T, R>
	}

	override getLeadingSeparator() {
		previous as SeparatorEntry<T, R>
	}

	override getTrailingSeparator() {
		next as SeparatorEntry<T, R>
	}

	override toString() {
		val reg = region
		'''"«reg.text»" at offset=«reg.offset» lenght=«reg.length» («object.class.simpleName»)'''
	}

}

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@Accessors class SeparatorEntry<T, R extends ITextSegment> extends Entry<T, R> {
	R separator

	override getLeadingObject() {
		previous as ObjectEntry<T, R>
	}

	override getTrailingObject() {
		next as ObjectEntry<T, R>
	}

	override getLeadingSeparator() {
		previous?.previous as SeparatorEntry<T, R>
	}

	override getTrailingSeparator() {
		next?.next as SeparatorEntry<T, R>
	}

	override toString() {
		'''"«separator.text»" at offset=«separator.offset» lenght=«separator.length»'''
	}

}
