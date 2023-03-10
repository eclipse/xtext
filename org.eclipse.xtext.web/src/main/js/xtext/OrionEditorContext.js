/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/

define(function() {
	
	/**
	 * An editor context mediates between the Xtext services and the Orion
	 * editor framework.
	 */
	function OrionEditorContext(editorViewer, contentType) {
		this._editorViewer = editorViewer;
		this._editor = editorViewer.editor;
		this._contentType = contentType;
		this._serverState = {};
		this._serverStateListeners = [];
		this._dirty = false;
		this._dirtyStateListeners = [];
	};

	OrionEditorContext.prototype = {
		
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
			return this._editor.getTextView().getCaretOffset();
		},
		
		getLineStart: function(lineNumber) {
			var view = this._editor.getTextView();
			return view.getLineStart(view.getLineAtOffset(view.getCaretOffset()));
		},
		
		getSelection: function() {
			return this._editor.getTextView().getSelection();
		},
		
		getText: function(start, end) {
			return this._editor.getText(start, end);
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
			this._editor.getUndoStack().reset();
		},
		
		setCaretOffset: function(offset, show) {
			this._editor.getTextView().setCaretOffset(offset, show);
		},
		
		setSelection: function(selection) {
			this._editor.getTextView().setSelection(selection.start, selection.end);
		},
		
		setText: function(text, start, end) {
			if (start === undefined || end === undefined) {
				this._editorViewer.setContents(text, this._contentType);
			} else {
				var fullText = this._editor.getText();
				var newText = fullText.substring(0, start) + text + fullText.substring(end);
				this._editorViewer.setContents(newText, this._contentType);
			}
		}
		
	};
	
	return OrionEditorContext;
});