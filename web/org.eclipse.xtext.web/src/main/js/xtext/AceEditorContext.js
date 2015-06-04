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
		this._problemMarkerIds = [];
	};

	AceEditorContext.prototype = {
		
		getEditor : function() {
			return this._editor
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
			throw "getCaretOffset not supported";
		},
		
		getLineStart : function(lineNumber) {
			throw "getLineStart not supported";
		},
		
		getSelection : function() {
			throw "getSelection not supported";
		},
		
		getText : function(start, end) {
			return this._editor.getSession().getValue();
		},
		
		isDirty : function() {
			throw "isDirty not supported";
		},
		
		markClean : function(clean) {
			throw "markClean not supported";
		},
		
		setCaretOffset : function(offset, show) {
			throw "setCaretOffset not supported";
		},
		
		setSelection : function(selection) {
			throw "setSelection not supported";
		},
		
		setText : function(text, start, end) {
			throw "setText not supported";
		},
		
		showMarkers : function(entries) {
			var session = this._editor.getSession();
			for (var i = 0; i < this._problemMarkerIds.length; i++) {
				session.removeMarker(this._problemMarkerIds[i]);
			}
			this._problemMarkerIds = [];
			var document = session.getDocument();
			for (var i = 0; i < entries.length; i++) {
				var e = entries[i];
				var start = document.indexToPosition(e.startOffset);
				var end = document.indexToPosition(e.endOffset);
				var range = new mRange.Range(start.row, start.column, end.row, end.column);
				this._problemMarkerIds.push(session.addMarker(range, "xtext-marker_" + e.severity, "text"));
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