/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others. All rights
 * reserved. This program and the accompanying materials are made available
 * under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/

define(function() {
	
	/**
	 * An editor context mediates between the Xtext services and the Orion
	 * editor framework.
	 */
	function OrionEditorContext(editor) {
		this._editor = editor;
		this._serverState = {};
		this._serverStateListeners = [];
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
			return this._editor.isDirty();
		},
		
		markClean: function(clean) {
			if (clean === undefined || clean) {
				this._editor.markClean();
			} else {
				this._editor.setDirty(true);
			}
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
			var textView = this._editor.getTextView();
			var caretOffset = textView.getCaretOffset();
			if (caretOffset > 0) {
				var model = textView.getModel();
				var line = model.getLineAtOffset(caretOffset)
				var lineStart = model.getLineStart(line);
				var offsetInLine = caretOffset - lineStart;
				model.setText(text, start, end);
				lineStart = model.getLineStart(line);
				var lineEnd = model.getLineEnd(line);
				if (lineStart < 0 || lineEnd < 0)
					textView.setCaretOffset(model.getText().length);
				else if (lineStart + offsetInLine > lineEnd)
					textView.setCaretOffset(lineEnd);
				else
					textView.setCaretOffset(lineStart + offsetInLine);
			} else {
				this._editor.setText(text, start, end);
			}
		}
		
	};
	
	return OrionEditorContext;
});