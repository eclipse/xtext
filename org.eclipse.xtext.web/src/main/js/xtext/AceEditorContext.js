/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

define([], function() {
	
	/**
	 * An editor context mediates between the Xtext services and the Ace editor framework.
	 */
	function AceEditorContext(editor) {
		this._editor = editor;
		this._serverState = {};
		this._serverStateListeners = [];
		this._dirty = false;
		this._dirtyStateListeners = [];
	};

	AceEditorContext.prototype = {
		
		getServerState: function() {
			return this._serverState;
		},
		
		updateServerState: function(currentText, currentStateId) {
			this._serverState.text = currentText;
			this._serverState.stateId = currentStateId;
			return this._serverStateListeners;
		},
		
		addServerStateListener: function(listener) {
			this._serverStateListeners.push(listener);
		},
		
		getCaretOffset: function() {
			var pos = this._editor.getCursorPosition();
			return this._editor.getSession().getDocument().positionToIndex(pos);
		},
		
		getLineStart: function(lineNumber) {
			var pos = this._editor.getCursorPosition();
			return pos.row;
		},
		
		getSelection: function() {
			var range = this._editor.getSelectionRange();
			var document = this._editor.getSession().getDocument();
        	return {
        		start: document.positionToIndex(range.start),
        		end: document.positionToIndex(range.end)
        	};
		},
		
		getText: function(start, end) {
			var session = this._editor.getSession();
			if (start && end) {
				var document = session.getDocument();
				var startPos = document.indexToPosition(start);
				var endPos = document.indexToPosition(end);
				var mRange = require('ace/range');
				return session.getTextRange(new mRange.Range(startPos.row, startPos.column, endPos.row, endPos.column));
			} else {
				return session.getValue();
			}
		},
		
		isDirty: function() {
			return this._dirty;
		},
		
		setDirty: function(dirty) {
			if (dirty != this._dirty) {
				for (var i = 0; i < this._dirtyStateListeners.length; i++) {
					this._dirtyStateListeners[i](dirty);
				}
			}
			this._dirty = dirty;
		},
		
		addDirtyStateListener: function(listener) {
			this._dirtyStateListeners.push(listener);
		},
		
		clearUndoStack: function() {
			this._editor.getSession().getUndoManager().reset();
		},
		
		setCaretOffset: function(offset) {
			var pos = this._editor.getSession().getDocument().indexToPosition(offset);
			this._editor.moveCursorTo(pos.row, pos.column);
		},
		
		setSelection: function(selection) {
			if (this._editor.selection) {
				var document = this._editor.getSession().getDocument();
				var startPos = document.indexToPosition(selection.start);
				var endPos = document.indexToPosition(selection.end);
				this._editor.selection.setSelectionRange(new mRange.Range(startPos.row, startPos.column, endPos.row, endPos.column));
			}
		},
		
		setText: function(text, start, end) {
			var session = this._editor.getSession();
			var document = session.getDocument();
			if (!start)
				start = 0;
			if (!end)
				end = document.getValue().length;
			var startPos = document.indexToPosition(start);
			var endPos = document.indexToPosition(end);
			var cursorPos = this._editor.getCursorPosition();
			var mRange = require('ace/range');
			session.replace(new mRange.Range(startPos.row, startPos.column, endPos.row, endPos.column), text);
			this._editor.moveCursorToPosition(cursorPos);
			this._editor.clearSelection();
		}
		
	};
	
	return AceEditorContext;
});