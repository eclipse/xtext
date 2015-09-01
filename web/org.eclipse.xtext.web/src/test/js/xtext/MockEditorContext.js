/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(function() {
	
	function MockEditorContext(text, caretOffset) {
		if (text)
			this._text = text;
		else
			this._text = '';
		
		if (caretOffset)
			this._caretOffset = caretOffset;
		else
			this._caretOffset = 0;
		
		this._selection = {
			start: 0,
			end: 0
		};
		this._dirty = false;
		this._dirtyStateListeners = [];
		this._serverState = {
			stateId: '0',
			text: ''
		};
		this._serverStateListeners = [];
		this._modelChangeListeners = [];
	};

	MockEditorContext.prototype = {
			
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
		
		addModelChangeListener: function(listener) {
			this._modelChangeListeners.push(listener);
		},
		
		getModelChangeListeners: function() {
			return this._modelChangeListeners;
		},
		
		getCaretOffset: function() {
			return this._caretOffset;
		},
		
		getLineStart: function(lineNumber) {
			throw new Error('Not supported: getLineStart');
		},
		
		getSelection: function() {
			return this._selection;
		},
		
		getText: function(start, end) {
			if (start && end)
				return this._text.substring(start, end);
			else
				return this._text;
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
		},
		
		setCaretOffset: function(offset) {
			this._caretOffset = offset;
		},
		
		setSelection: function(selection) {
			this._selection = selection;
		},
		
		setText: function(text, start, end) {
			if (start && end)
				this._text = this._text.substring(0, start) + text + this._text.substring(end);
			else
				this._text = text;
		}

	};
	
	return MockEditorContext;
});