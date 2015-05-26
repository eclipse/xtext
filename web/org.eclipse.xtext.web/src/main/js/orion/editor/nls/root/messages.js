/*******************************************************************************
 * @license
 * Copyright (c) 2010, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html). 
 * 
 * Contributors: 
 *		Felipe Heidrich (IBM Corporation) - initial API and implementation
 *		Silenio Quarti (IBM Corporation) - initial API and implementation
 ******************************************************************************/
/*eslint-env browser, amd*/
define({//Default message bundle
	"multipleAnnotations": "Multiple annotations:", //$NON-NLS-1$ //$NON-NLS-0$
	"line": "Line: ${0}", //$NON-NLS-1$ //$NON-NLS-0$
	"breakpoint": "Breakpoint", //$NON-NLS-1$ //$NON-NLS-0$
	"bookmark": "Bookmark", //$NON-NLS-1$ //$NON-NLS-0$
	"task": "Task", //$NON-NLS-1$ //$NON-NLS-0$
	"error": "Error", //$NON-NLS-1$ //$NON-NLS-0$
	"warning": "Warning", //$NON-NLS-1$ //$NON-NLS-0$
	"matchingSearch": "Matching Search", //$NON-NLS-1$ //$NON-NLS-0$
	"currentSearch": "Current Search", //$NON-NLS-1$ //$NON-NLS-0$
	"currentLine": "Current Line", //$NON-NLS-1$ //$NON-NLS-0$
	"matchingBracket": "Matching Bracket", //$NON-NLS-1$ //$NON-NLS-0$
	"currentBracket": "Current Bracket", //$NON-NLS-1$ //$NON-NLS-0$
	"diffAdded": "Diff Added Lines", //$NON-NLS-1$ //$NON-NLS-0$
	"diffDeleted": "Diff Deleted Lines", //$NON-NLS-1$ //$NON-NLS-0$
	"diffModified": "Diff Modified Lines", //$NON-NLS-1$ //$NON-NLS-0$
	
	"lineUp": "Line Up", //$NON-NLS-1$ //$NON-NLS-0$
	"lineDown": "Line Down", //$NON-NLS-1$ //$NON-NLS-0$
	"lineStart": "Line Start", //$NON-NLS-1$ //$NON-NLS-0$
	"lineEnd": "Line End", //$NON-NLS-1$ //$NON-NLS-0$
	"charPrevious": "Previous Character", //$NON-NLS-1$ //$NON-NLS-0$
	"charNext": "Next Character", //$NON-NLS-1$ //$NON-NLS-0$
	"pageUp": "Page Up", //$NON-NLS-1$ //$NON-NLS-0$
	"pageDown": "Page Down", //$NON-NLS-1$ //$NON-NLS-0$
	"scrollPageUp": "Scroll Page Up", //$NON-NLS-1$ //$NON-NLS-0$
	"scrollPageDown": "Scroll Page Down", //$NON-NLS-1$ //$NON-NLS-0$
	"scrollLineUp": "Scroll Line Up", //$NON-NLS-1$ //$NON-NLS-0$
	"scrollLineDown": "Scroll Line Down", //$NON-NLS-1$ //$NON-NLS-0$
	"wordPrevious": "Previous Word", //$NON-NLS-1$ //$NON-NLS-0$
	"wordNext": "Next Word", //$NON-NLS-1$ //$NON-NLS-0$
	"textStart": "Document Start", //$NON-NLS-1$ //$NON-NLS-0$
	"textEnd": "Document End", //$NON-NLS-1$ //$NON-NLS-0$
	"scrollTextStart": "Scroll Document Start", //$NON-NLS-1$ //$NON-NLS-0$
	"scrollTextEnd": "Scroll Document End", //$NON-NLS-1$ //$NON-NLS-0$
	"centerLine": "Center Line", //$NON-NLS-1$ //$NON-NLS-0$
	
	"selectLineUp": "Select Line Up", //$NON-NLS-1$ //$NON-NLS-0$
	"selectLineDown": "Select Line Down", //$NON-NLS-1$ //$NON-NLS-0$
	"selectWholeLineUp": " Select Whole Line Up", //$NON-NLS-1$ //$NON-NLS-0$
	"selectWholeLineDown": "Select Whole Line Down", //$NON-NLS-1$ //$NON-NLS-0$
	"selectLineStart": "Select Line Start", //$NON-NLS-1$ //$NON-NLS-0$
	"selectLineEnd": "Select Line End", //$NON-NLS-1$ //$NON-NLS-0$
	"selectCharPrevious": "Select Previous Character", //$NON-NLS-1$ //$NON-NLS-0$
	"selectCharNext": "Select Next Character", //$NON-NLS-1$ //$NON-NLS-0$
	"selectPageUp": "Select Page Up", //$NON-NLS-1$ //$NON-NLS-0$
	"selectPageDown": "Select Page Down", //$NON-NLS-1$ //$NON-NLS-0$
	"selectWordPrevious": "Select Previous Word", //$NON-NLS-1$ //$NON-NLS-0$
	"selectWordNext": "Select Next Word", //$NON-NLS-1$ //$NON-NLS-0$
	"selectTextStart": "Select Document Start", //$NON-NLS-1$ //$NON-NLS-0$
	"selectTextEnd": "Select Document End", //$NON-NLS-1$ //$NON-NLS-0$

	"deletePrevious": "Delete Previous Character", //$NON-NLS-1$ //$NON-NLS-0$
	"deleteNext": "Delete Next Character", //$NON-NLS-1$ //$NON-NLS-0$
	"deleteWordPrevious": "Delete Previous Word", //$NON-NLS-1$ //$NON-NLS-0$
	"deleteWordNext": "Delete Next Word", //$NON-NLS-1$ //$NON-NLS-0$
	"deleteLineStart": "Delete Line Start", //$NON-NLS-1$ //$NON-NLS-0$
	"deleteLineEnd": "Delete Line End", //$NON-NLS-1$ //$NON-NLS-0$
	"tab": "Insert Tab", //$NON-NLS-1$ //$NON-NLS-0$
	"enter": "Insert Line Delimiter", //$NON-NLS-1$ //$NON-NLS-0$
	"enterNoCursor": "Insert Line Delimiter", //$NON-NLS-1$ //$NON-NLS-0$
	"escape": "Escape", //$NON-NLS-1$ //$NON-NLS-0$
	"selectAll": "Select All", //$NON-NLS-1$ //$NON-NLS-0$
	"copy": "Copy", //$NON-NLS-1$ //$NON-NLS-0$
	"cut": "Cut", //$NON-NLS-1$ //$NON-NLS-0$
	"paste": "Paste", //$NON-NLS-1$ //$NON-NLS-0$
	
	"uppercase": "To Upper Case", //$NON-NLS-1$ //$NON-NLS-0$
	"lowercase": "To Lower Case", //$NON-NLS-1$ //$NON-NLS-0$
	"capitalize": "Capitalize", //$NON-NLS-1$ //$NON-NLS-0$
	"reversecase" : "Reverse Case", //$NON-NLS-1$ //$NON-NLS-0$
	
	"toggleWrapMode": "Toggle Wrap Mode", //$NON-NLS-1$ //$NON-NLS-0$
	"toggleTabMode": "Toggle Tab Mode", //$NON-NLS-1$ //$NON-NLS-0$
	"toggleOverwriteMode": "Toggle Overwrite Mode", //$NON-NLS-1$ //$NON-NLS-0$
	
	"committerOnTime": "${0} on ${1}", //$NON-NLS-1$ //$NON-NLS-0$
	
	//Emacs
	"emacs": "Emacs", //$NON-NLS-1$ //$NON-NLS-0$
	"exchangeMarkPoint": "Exchange Mark and Point", //$NON-NLS-1$ //$NON-NLS-0$
	"setMarkCommand": "Set Mark", //$NON-NLS-1$ //$NON-NLS-0$
	"clearMark": "Clear Mark", //$NON-NLS-1$ //$NON-NLS-0$
	"digitArgument": "Digit Argument ${0}", //$NON-NLS-1$ //$NON-NLS-0$
	"negativeArgument": "Negative Argument", //$NON-NLS-1$ //$NON-NLS-0$
			
	"Comment": "Comment", //$NON-NLS-1$ //$NON-NLS-0$
	"Flat outline": "Flat outline", //$NON-NLS-1$ //$NON-NLS-0$
	"incrementalFindStr": "Incremental find: ${0}", //$NON-NLS-1$ //$NON-NLS-0$
	"incrementalFindStrNotFound": "Incremental find: ${0} (not found)", //$NON-NLS-1$ //$NON-NLS-0$
	"incrementalFindReverseStr": "Reverse Incremental find: ${0}", //$NON-NLS-1$ //$NON-NLS-0$
	"incrementalFindReverseStrNotFound": "Reverse Incremental find: ${0} (not found)", //$NON-NLS-1$ //$NON-NLS-0$
	"find": "Find...", //$NON-NLS-1$ //$NON-NLS-0$
	"undo": "Undo", //$NON-NLS-1$ //$NON-NLS-0$
	"redo": "Redo", //$NON-NLS-1$ //$NON-NLS-0$
	"cancelMode": "Cancel Current Mode", //$NON-NLS-1$ //$NON-NLS-0$
	"findNext": "Find Next Occurrence", //$NON-NLS-1$ //$NON-NLS-0$
	"findPrevious": "Find Previous Occurrence", //$NON-NLS-1$ //$NON-NLS-0$
	"incrementalFind": "Incremental Find", //$NON-NLS-1$ //$NON-NLS-0$
	"incrementalFindReverse": "Incremental Find Reverse", //$NON-NLS-1$ //$NON-NLS-0$
	"indentLines": "Indent Lines", //$NON-NLS-1$ //$NON-NLS-0$
	"unindentLines": "Unindent Lines", //$NON-NLS-1$ //$NON-NLS-0$
	"moveLinesUp": "Move Lines Up", //$NON-NLS-1$ //$NON-NLS-0$
	"moveLinesDown": "Move Lines Down", //$NON-NLS-1$ //$NON-NLS-0$
	"copyLinesUp": "Copy Lines Up", //$NON-NLS-1$ //$NON-NLS-0$
	"copyLinesDown": "Copy Lines Down", //$NON-NLS-1$ //$NON-NLS-0$
	"deleteLines": "Delete Lines", //$NON-NLS-1$ //$NON-NLS-0$
	"gotoLine": "Goto Line...", //$NON-NLS-1$ //$NON-NLS-0$
	"gotoLinePrompty": "Goto Line:", //$NON-NLS-1$ //$NON-NLS-0$
	"nextAnnotation": "Next Annotation", //$NON-NLS-1$ //$NON-NLS-0$
	"prevAnnotation": "Previous Annotation", //$NON-NLS-1$ //$NON-NLS-0$
	"expand": "Expand", //$NON-NLS-1$ //$NON-NLS-0$
	"collapse": "Collapse", //$NON-NLS-1$ //$NON-NLS-0$
	"expandAll": "Expand All", //$NON-NLS-1$ //$NON-NLS-0$
	"collapseAll": "Collapse All", //$NON-NLS-1$ //$NON-NLS-0$
	"lastEdit": "Last Edit Location", //$NON-NLS-1$ //$NON-NLS-0$
	"trimTrailingWhitespaces": "Trim Trailing Whitespaces", //$NON-NLS-1$ //$NON-NLS-0$
	"toggleLineComment": "Toggle Line Comment", //$NON-NLS-1$ //$NON-NLS-0$
	"addBlockComment": "Add Block Comment", //$NON-NLS-1$ //$NON-NLS-0$
	"removeBlockComment": "Remove Block Comment", //$NON-NLS-1$ //$NON-NLS-0$
	"linkedModeEntered": "Linked Mode entered", //$NON-NLS-1$ //$NON-NLS-0$
	"linkedModeExited": "Linked Mode exited", //$NON-NLS-1$ //$NON-NLS-0$
	"syntaxError": "Syntax Error", //$NON-NLS-1$ //$NON-NLS-0$
	"contentAssist": "Content Assist", //$NON-NLS-1$ //$NON-NLS-0$
	"lineColumn": "Line ${0} : Column ${1}", //$NON-NLS-1$ //$NON-NLS-0$
	"multiSelections": "${0} selection regions", //$NON-NLS-1$ //$NON-NLS-0$
	
	//vi
	"vi": "vi", //$NON-NLS-1$ //$NON-NLS-0$
	"vimove": "(Move)", //$NON-NLS-1$ //$NON-NLS-0$
	"viyank": "(Yank)", //$NON-NLS-1$ //$NON-NLS-0$
	"videlete": "(Delete)", //$NON-NLS-1$ //$NON-NLS-0$
	"vichange": "(Change)", //$NON-NLS-1$ //$NON-NLS-0$
	"viLeft": "${0} Left", //$NON-NLS-1$ //$NON-NLS-0$
	"viRight": "${0} Right", //$NON-NLS-1$ //$NON-NLS-0$
	"viUp": "${0} Up", //$NON-NLS-1$ //$NON-NLS-0$
	"viDown": "${0} Down", //$NON-NLS-1$ //$NON-NLS-0$
	"viw": "${0} Next Word", //$NON-NLS-1$ //$NON-NLS-0$
	"vib": "${0} Beginning of Word", //$NON-NLS-1$ //$NON-NLS-0$
	"viW": "${0} Next Word (ws stop)", //$NON-NLS-1$ //$NON-NLS-0$
	"viB": "${0} Beginning of Word (ws stop)", //$NON-NLS-1$ //$NON-NLS-0$
	"vie": "${0} End of Word", //$NON-NLS-1$ //$NON-NLS-0$
	"viE": "${0} End of Word (ws stop)", //$NON-NLS-1$ //$NON-NLS-0$
	"vi$": "${0} End of the line", //$NON-NLS-1$ //$NON-NLS-0$
	"vi^_": "${0} First non-blank Char Current Line", //$NON-NLS-1$ //$NON-NLS-0$
	"vi+": "${0} First Char Next Line", //$NON-NLS-1$ //$NON-NLS-0$
	"vi-": "${0} First Char Previous Line", //$NON-NLS-1$ //$NON-NLS-0$
	"vi|": "${0} nth Column in Line", //$NON-NLS-1$ //$NON-NLS-0$
	"viH": "${0} Top of Page", //$NON-NLS-1$ //$NON-NLS-0$
	"viM": "${0} Middle of Page", //$NON-NLS-1$ //$NON-NLS-0$
	"viL": "${0} Bottom of Page", //$NON-NLS-1$ //$NON-NLS-0$
	"vi/": "${0} Search Forward", //$NON-NLS-1$ //$NON-NLS-0$
	"vi?": "${0} Search Backward", //$NON-NLS-1$ //$NON-NLS-0$
	"vin": "${0} Next Search", //$NON-NLS-1$ //$NON-NLS-0$
	"viN": "${0} Previous Search", //$NON-NLS-1$ //$NON-NLS-0$
	"vif": "${0} Search Char Fwd", //$NON-NLS-1$ //$NON-NLS-0$
	"viF": "${0} Search Char Bckwd", //$NON-NLS-1$ //$NON-NLS-0$
	"vit": "${0} Search Before Char Fwd", //$NON-NLS-1$ //$NON-NLS-0$
	"viT": "${0} Search Before Char Bckwd", //$NON-NLS-1$ //$NON-NLS-0$
	"vi,": "${0} Repeat Reverse Char Search", //$NON-NLS-1$ //$NON-NLS-0$
	"vi;": "${0} Repeat Char Search", //$NON-NLS-1$ //$NON-NLS-0$
	"viG": "${0} Go to Line", //$NON-NLS-1$ //$NON-NLS-0$
	"viycd": "${0} Current Line", //$NON-NLS-1$ //$NON-NLS-0$
	"via": "Append After Cursor", //$NON-NLS-1$ //$NON-NLS-0$
	"viA": "Append to End of Line", //$NON-NLS-1$ //$NON-NLS-0$
	"vii": "Insert Before Cursor", //$NON-NLS-1$ //$NON-NLS-0$
	"viI": "Insert at Beginning of Line", //$NON-NLS-1$ //$NON-NLS-0$
	"viO": "Insert Line Above", //$NON-NLS-1$ //$NON-NLS-0$
	"vio": "Insert Line Below", //$NON-NLS-1$ //$NON-NLS-0$
	"viR": "Begin Overwriting Text", //$NON-NLS-1$ //$NON-NLS-0$
	"vis": "Substitute a Character", //$NON-NLS-1$ //$NON-NLS-0$
	"viS": "Substitute Entire Line", //$NON-NLS-1$ //$NON-NLS-0$
	"viC": "Change Text Until Line End", //$NON-NLS-1$ //$NON-NLS-0$
	"vip": "Paste After Char or Line", //$NON-NLS-1$ //$NON-NLS-0$
	"viP": "Paste Before Char or Line", //$NON-NLS-1$ //$NON-NLS-0$
	"viStar": "Search Word Under Cursor", //$NON-NLS-1$ //$NON-NLS-0$
	
	"next": "Next", //$NON-NLS-1$ //$NON-NLS-0$
	"previous": "Previous", //$NON-NLS-1$ //$NON-NLS-0$
	"replace": "Replace", //$NON-NLS-1$ //$NON-NLS-0$
	"replaceAll": "Replace All", //$NON-NLS-1$ //$NON-NLS-0$
	"findWith": "Find With", //$NON-NLS-1$ //$NON-NLS-0$
	"replaceWith": "Replace With", //$NON-NLS-1$ //$NON-NLS-0$
	"caseInsensitive": "Aa", //$NON-NLS-1$ //$NON-NLS-0$
	"regex": "/.*/", //$NON-NLS-1$ //$NON-NLS-0$
	"wholeWord": "\\b", //$NON-NLS-1$ //$NON-NLS-0$
	"caseInsensitiveTooltip": "Toggle Case Insensitive", //$NON-NLS-1$ //$NON-NLS-0$
	"regexTooltip": "Toggle Regex", //$NON-NLS-1$ //$NON-NLS-0$
	"wholeWordTooltip": "Toggle Whole Word", //$NON-NLS-1$ //$NON-NLS-0$
	"closeTooltip": "Close", //$NON-NLS-1$ //$NON-NLS-0$

	"replacingAll": "Replacing all...", //$NON-NLS-1$ //$NON-NLS-0$
	"replacedMatches": "Replaced ${0} matches", //$NON-NLS-1$ //$NON-NLS-0$
	"nothingReplaced": "Nothing replaced", //$NON-NLS-1$ //$NON-NLS-0$
	"notFound": "Not found" //$NON-NLS-1$ //$NON-NLS-0$
});
