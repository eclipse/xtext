/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(["ace/range"], function(mRange) {
	
	function AceEditorContext(editor) {
		this._editor = editor;
		this._serverState = {};
		this._serverStateListeners = [];
		this._clientServiceState = {};
		this._problemMarkers = [];
		this._clean = true;
		this._dirtyStateListeners = [];
	};

	AceEditorContext.prototype = {
		
		getEditor : function() {
			return this._editor;
		},
		
		getServerState : function() {
			return this._serverState;
		},
		
		updateServerState : function(currentText, currentStateId) {
			this._serverState.text = currentText;
			this._serverState.stateId = currentStateId;
			return this._serverStateListeners;
		},
		
		addServerStateListener : function(listener) {
			this._serverStateListeners.push(listener);
		},
		
		getClientServiceState : function() {
			return this._clientServiceState;
		},
		
		clearClientServiceState : function() {
			this._clientServiceState = {};
		},
		
		getCaretOffset : function() {
			var pos = this._editor.getCursorPosition();
			return this._editor.getSession().getDocument().positionToIndex(pos);
		},
		
		getLineStart : function(lineNumber) {
			var pos = this._editor.getCursorPosition();
			return pos.row;
		},
		
		getSelection : function() {
			var range = editor.getSelectionRange();
			var document = this._editor.getSession().getDocument();
        	return {
        		start: document.positionToIndex(range.start),
        		end: document.positionToIndex(range.end)
        	};
		},
		
		getText : function(start, end) {
			var session = this._editor.getSession();
			if (start && end) {
				var document = session.getDocument();
				var startPos = document.indexToPosition(start);
				var endPos = document.indexToPosition(end);
				return session.getTextRange(new mRange.Range(startPos.row, startPos.column, endPos.row, endPos.column));
			} else {
				return session.getValue();
			}
		},
		
		isDirty : function() {
			return !this._clean;
		},
		
		markClean : function(clean) {
			if (clean != this._clean) {
				for (i in this._dirtyStateListeners) {
					this._dirtyStateListeners[i](clean);
				}
			}
			this._clean = clean;
		},
		
		addDirtyStateListener : function(listener) {
			this._dirtyStateListeners.push(listener);
		},
		
		clearUndoStack : function() {
			this._editor.getSession().getUndoManager().reset();
		},
		
		setCaretOffset : function(offset) {
			var pos = this._editor.getSession().getDocument().indexToPosition(offset);
			this._editor.moveCursorTo(pos.row, pos.column);
		},
		
		setSelection : function(selection) {
			if (this._editor.selection) {
				var document = this._editor.getSession().getDocument();
				var startPos = document.indexToPosition(selection.start);
				var endPos = document.indexToPosition(selection.end);
				this._editor.selection.setSelectionRange(new mRange.Range(startPos.row, startPos.column, endPos.row, endPos.column));
			}
		},
		
		setText : function(text) {
			this._editor.getSession().setValue(text);
		},
		
		showMarkers : function(entries) {
			var session = this._editor.getSession();
			for (var i = 0; i < this._problemMarkers.length; i++) {
				var marker = this._problemMarkers[i];
				session.removeMarker(marker.id);
				session.removeGutterDecoration(marker.row, "xtext-annotation_" + marker.severity);
			}
			this._problemMarkers = [];
			var document = session.getDocument();
			for (var i = 0; i < entries.length; i++) {
				var entry = entries[i];
				var start = document.indexToPosition(entry.startOffset);
				var end = document.indexToPosition(entry.endOffset);
				var range = new mRange.Range(start.row, start.column, end.row, end.column);
				var markerId = session.addMarker(range, "xtext-marker_" + entry.severity, "text");
				session.addGutterDecoration(start.row, "xtext-annotation_" + entry.severity);
				this._problemMarkers.push({
					id: markerId,
					row: start.row,
					severity: entry.severity
				});
			}
		},
		
		translateCompletionProposals : function(entries) {
			return entries.map(function(entry) {
    			return {
    				value: entry.proposal,
    				caption: (entry.name ? entry.name : entry.proposal),
    				meta: entry.description,
    				className: entry.style
    			};
			});
		}
	};
	
	return AceEditorContext;
});