package org.xpect.tests.text

import org.junit.Assert
import org.xpect.text.Canvas
import org.xpect.text.Table
import org.junit.Test

class TableTest {

	def private Table newTable() {
		new Table
	}

	@Test def void test1by1() {
		val table = newTable
		table.getCell(0, 0).text = "X"
		table === '''
			X
		'''
	}

	@Test def void test2by3() {
		val table = newTable
		table.getCell(0, 0).text = "a"
		table.getCell(0, 1).text = "b"
		table.getCell(0, 2).text = "c"
		table.getCell(1, 0).text = "d"
		table.getCell(1, 1).text = "e"
		table.getCell(1, 2).text = "f"
		table === '''
			a-b-c$
			$
			d-e-f
		'''
	}

	@Test def void test2by3Long() {
		val table = newTable
		table.getCell(0, 0).text = "a1"
		table.getCell(0, 1).text = "b12"
		table.getCell(0, 2).text = "c123"
		table.getCell(1, 0).text = "d1234"
		table.getCell(1, 1).text = "e12345"
		table.getCell(1, 2).text = "f123456"
		table === '''
			a1----b12----c123$
			$
			d1234-e12345-f123456
		'''
	}

	@Test def void test2by3LongTrimmed() {
		val table = newTable
		table.maxCellWidth = 3
		table.getCell(0, 0).text = "a1"
		table.getCell(0, 1).text = "b12"
		table.getCell(0, 2).text = "c123"
		table.getCell(1, 0).text = "d1234"
		table.getCell(1, 1).text = "e12345"
		table.getCell(1, 2).text = "f123456"
		table === '''
			a1--b12-c12$
			$
			d12-e12-f12
		'''
	}

	@Test def void test2by3BorderAndSeparators() {
		val table = newTable

		// content
		table.getCell(0, 0).text = "a1"
		table.getCell(0, 1).text = "b12"
		table.getCell(0, 2).text = "c123"
		table.getCell(1, 0).text = "d1234"
		table.getCell(1, 1).text = "e12345"
		table.getCell(1, 2).text = "f123456"

		// border		
		table.separatorCrossingBackground = "+"
		table.rowSeparatorBackground = "="
		table.columnSeparatorBackground = "|"
		table.border = 1
		table.bottomBorder.height = 3
		table.rightBorder.width = 2

		// header
		table.getRow(0).bottomSeparator.background = "#"
		table.getColumn(0).rightSeparator.background = "@"

		table === '''
			+=====+======+=======++$
			|a1---@b12---|c123---||$
			+#####+######+#######++$
			|d1234@e12345|f123456||$
			+=====+======+=======++$
			+=====+======+=======++$
			+=====+======+=======++
		'''
	}

	def operator_tripleEquals(Table table, Object o2) {
		val canvas = Canvas.create("-", "$\n")
		table.paint(canvas)
		Assert.assertEquals(o2.toString.trim, canvas.toString.trim)
	}
}
