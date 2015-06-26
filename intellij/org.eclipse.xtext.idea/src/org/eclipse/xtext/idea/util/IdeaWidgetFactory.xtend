/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.util

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.MacroAwareTextBrowseFolderListener
import com.intellij.ui.SeparatorWithText
import java.awt.Color
import java.awt.Component
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import javax.swing.BorderFactory
import javax.swing.JCheckBox
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.border.EmptyBorder

import static org.eclipse.xtext.idea.util.IdeaWidgetFactory.*

/**
 * @author dhuebner - Initial contribution and API
 */
class IdeaWidgetFactory {

	def checkBox(String string) {
		new JCheckBox(string) => [
			if (debug) {
				borderPainted = true
			}
		]
	}

	def twoColumnPanel((TwoColumnPanel)=>TwoColumnPanel additions) {
		val panel = new TwoColumnPanel() => [
			border = emptyBorder(10)
			layout = new GridBagLayout()
		]
		additions.apply(panel)
		return panel
	}

	def emptyBorder(int i) {
		new EmptyBorder(i, i, i, i)
	}

	def label(String text) {
		new JLabel(text)
	}

	def TextFieldWithBrowseButton browseField(Project project) {
		val field = new TextFieldWithBrowseButton()
		val listener = new MacroAwareTextBrowseFolderListener(
			FileChooserDescriptorFactory.createSingleFolderDescriptor(), project)
		field.addBrowseFolderListener(listener)
		return field
	}

	def SeparatorWithText separator(String title) {
		val separator = new SeparatorWithText() => [
			caption = title
			captionCentered = false
		]
		return separator
	}

	static boolean debug = false

	static class TwoColumnPanel extends JPanel {
		int rowsAdded = 0

		def row(TwoColumnPanel host, (GridBagConstraints)=>JComponent col) {
			val gbc = new GridBagConstraints()
			gbc.gridx = 0
			gbc.gridy = rowsAdded
			gbc.anchor = GridBagConstraints.WEST
			gbc.fill = GridBagConstraints.HORIZONTAL
			gbc.gridwidth = 2
			host.add(col.apply(gbc), gbc)
			rowsAdded++
			return host
		}

		def row(TwoColumnPanel host, (GridBagConstraints)=>JComponent col1, (GridBagConstraints)=>JComponent col2) {
			var gbc = new GridBagConstraints()
			gbc.gridx = 0
			gbc.gridy = rowsAdded
			gbc.anchor = GridBagConstraints.EAST
			host.add(col1.apply(gbc), gbc)

			gbc = new GridBagConstraints()
			gbc.gridx = 1
			gbc.gridy = rowsAdded
			gbc.anchor = GridBagConstraints.WEST
			gbc.fill = GridBagConstraints.HORIZONTAL
			host.add(col2.apply(gbc), gbc)
			rowsAdded++
			return host
		}

		def expand(TwoColumnPanel host, int dim) {
			row [
				if (dim === GridBagConstraints.VERTICAL) {
					weighty = 1.0
				} else if (dim == GridBagConstraints.HORIZONTAL) {
					weightx = 1.0
				} else {
					throw new IllegalArgumentException()
				}
				return new JLabel("")
			]
			return host
		}

		override add(Component comp, Object constraints) {
			super.add(comp, constraints)
			if (comp instanceof JComponent) {
				if (debug) {
					comp.border = BorderFactory.createLineBorder(Color.BLACK)
				} else {
					comp.border = BorderFactory.createEmptyBorder(5, 5, 5, 5)
				}
			}
		}

	}
}