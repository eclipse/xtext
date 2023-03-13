/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests

import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException
import org.eclipse.swtbot.swt.finder.finders.ContextMenuHelper
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences
import org.eclipse.swtbot.swt.finder.utils.SWTUtils
import org.eclipse.swtbot.swt.finder.widgets.AbstractSWTBot
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem
import org.eclipse.xtext.xbase.lib.Pair

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class SwtBotProjectHelper {
	
	static val defaultProject = 'test' 

	static def newXtendProject(SWTWorkbenchBot it) {
		newXtendProject(defaultProject)
	}
	
	static def newXtendProject(SWTWorkbenchBot it, String projectName) {
		val shell = activeShell
		views.findFirst[title == "Welcome"]?.close
		perspectiveByLabel('Java').activate
		fileNew('Project...')
		shell('New Project').activate
		tree.expandNode('Java').select('Java Project')
		button('Next >').click
		textWithLabel('Project name:').text = projectName
		button('Next >').click
		tabItem('Libraries').activate
		button('Add Library...').click
		shell('Add Library').activate
		list.select('Xtend Library')
		button('Next >').click
		button('Finish').click
		button('Finish').click
		shell.activate
	}
	
	static def newJavaEditor(SWTWorkbenchBot it, String typeName) {
		newJavaEditor(typeName, '', defaultProject + '/src')
	}
	
	static def newJavaEditor(SWTWorkbenchBot it, String typeName, CharSequence content) {
		newJavaEditor(typeName, '', defaultProject + '/src') => [
			it.content = content
		]
	}
	
	static def newJavaEditor(SWTWorkbenchBot it, String typeName, String packageName, CharSequence content) {
		newJavaEditor(typeName, packageName, defaultProject + '/src') => [
			it.content = content
		]
	}
	
	static def newJavaEditor(SWTWorkbenchBot it, String typeName, String packageName, String sourceFolderPath) {
		fileNew('Class')
		shell('New Java Class').activate
		textWithLabel('Source folder:').text = sourceFolderPath
		textWithLabel('Package:').text = packageName
		textWithLabel('Name:').text = typeName
		button('Finish').click
		editorByTitle(typeName + '.java').toTextEditor
	}
	
	static def newXtendEditor(SWTWorkbenchBot it, String typeName, CharSequence content) {
		newXtendEditor(typeName, '', defaultProject + '/src') => [
			it.content = content
		]
	}
	
	static def newXtendEditor(SWTWorkbenchBot it, String typeName, String packageName, CharSequence content) {
		newXtendEditor(typeName, packageName, defaultProject + '/src') => [
			it.content = content
		]
	}
	
	static def newXtendEditor(SWTWorkbenchBot it, String typeName, String packageName, String sourceFolderPath) {
		try {
			fileNew('Xtend Class')
		} catch (WidgetNotFoundException e) {
			it.shells.forEach[println('''Shell: '«text»', active: «active»''')]
			SWTUtils.captureScreenshot('''«SWTBotPreferences.SCREENSHOTS_DIR»/MenuFileNotFound«System.currentTimeMillis».«SWTBotPreferences.SCREENSHOT_FORMAT»''',
				it.shells.filter[active].head.widget)
			throw e
		}
		shell('Xtend Class').activate
		textWithLabel('Source folder:').text = sourceFolderPath
		textWithLabel('Package:').text = packageName
		textWithLabel('Name:').text = typeName
		button('Finish').click
		editorByTitle(typeName + '.xtend').toTextEditor
	}
	
	protected def static void fileNew(SWTWorkbenchBot it, String newWhat) {
		// sometimes, both in Eclipse and in Maven, SWTBot fails to find the
		// File menu, saying widget is disposed.
		// We try again a few times after sleeping some time
		var retries = 3
		for (i : 0..<retries) {
			try {
				menu('File').menu('New').menu(newWhat).click
				return;
			} catch (WidgetNotFoundException e) {
				if (i == retries-1)
					throw e
				println("failed: " + e.message)
				println("retrying...")
				sleep(1000)
			}
		}
	}
	
	static def closeAllEditors(SWTWorkbenchBot it) {
		editors.forEach[close]
	}
	
	static def setContent(SWTBotEclipseEditor it, CharSequence content) {
		val contentString = content.toString
		text = contentString.replace('?', '')
		val offset = contentString.indexOf('?')
		if(offset != -1) {
			val lineAndColumn = contentString.getLineAndColumn(offset)
			selectRange(lineAndColumn.key, lineAndColumn.value, contentString.lastIndexOf('?') - offset - 1)
		}
	}
	
	static def clickableContextMenu(SWTBotEclipseEditor editor, String... text) {
		new SWTBotMenu(ContextMenuHelper.contextMenu(editor.styledText, text))
	}
	
	protected static def Pair<Integer, Integer> getLineAndColumn(String content, int offset) {
		var line = 0
		var column = 0
		var String ignoreNext = null   
		for(i: 0..<offset) {
			switch content.substring(i, i+1) {
				case ignoreNext: 
					ignoreNext = null
				case '\n': {
					column = 0
					line = line + 1  		
					ignoreNext = '\r'
				}
				case '\r': {
					column = 0
					line = line + 1  		
					ignoreNext = '\n'
				}
				default: {
					ignoreNext = null
					column = column + 1
				}
			}
		}
		line -> column
	}
	
	static def clearSourceFolderContents(SWTWorkbenchBot it) {
		clearSourceFolderContents(defaultProject)
	}
	
	static def clearSourceFolderContents(SWTWorkbenchBot it, String project) {
		try {
			var packageExplorerTree = tree
			if(!tree.hasItems) {
				packageExplorerTree = viewByTitle("Package Explorer").bot.tree
			}
			val srcNode = packageExplorerTree.expandNode(project).expandNode('src')
			for(source: srcNode.items) {
				if(!source.widget.disposed) {
					println(text)
					srcNode.select(source.text)
					source.contextMenu('Delete').click
					shell('Delete').activate
					button('OK').click
				}
			}
		} catch(WidgetNotFoundException exc) {
			ResourcesPlugin.workspace.root.getProject(project).getFolder('src').members.forEach[delete(true,null)]
		}
	}
	
	static def SWTBotTreeItem expandNode(AbstractSWTBot<?> bot, String node) {
		var SWTBotTreeItem item = null
		if (bot instanceof SWTBotTree) {
			item = bot.getTreeItem(node)
		} else if (bot instanceof SWTBotTreeItem) {
			item = bot.getNode(node)
		}
		if (!item.expanded) {
			item.expand
		}
		return item
	}
}

