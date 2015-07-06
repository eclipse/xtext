/*******************************************************************************
 * @license
 * Copyright (c) 2010, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html). 
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ******************************************************************************/

/*eslint-env browser, amd*/
define("orion/editor/undoStack", [], function() { //$NON-NLS-0$

	/** 
	 * Constructs a new Change object.
	 * 
	 * @class 
	 * @name orion.editor.Change
	 * @private
	 */
	function Change(model, offset, text, previousText, type) {
		this.model = model;
		this.offset = offset;
		this.text = text;
		this.previousText = previousText;
		this.type = type;
	}
	Change.prototype = {
		/** @ignore */
		getRedoChanges: function() {
			return [{start: this.offset, end: this.offset + this.previousText.length, text: this.text}];
		},
		/** @ignore */
		getUndoChanges: function() {
			return [{start: this.offset, end: this.offset + this.text.length, text: this.previousText}];
		},
		/** @ignore */
		undo: function (view, select) {
			this._doUndoRedo(this.offset, this.previousText, this.text, view, select);
			return true;
		},
		/** @ignore */
		redo: function (view, select) {
			this._doUndoRedo(this.offset, this.text, this.previousText, view, select);
			return true;
		},
		merge: function(start, text, previousText, type, end) {
			if (type === this.type) {
				if (type === 1 && start === this.offset + this.text.length) {
					this.text += text;
					return true;
				} else if (type === -1 && end === this.offset) {
					this.offset = start;
					this.previousText = previousText + this.previousText;
					return true;
				} else if (type === -1 && start === this.offset) {
					this.previousText = this.previousText + previousText;
					return true;
				}
			}
			return false;
		},
		_doUndoRedo: function(offset, text, previousText, view, select) {
			this.model.setText(text, offset, offset + previousText.length);
			if (select && view) {
				var model = view.getModel();
				if (model !== this.model) {
					offset = model.mapOffset(offset, true);
				}
				view.setSelection(offset, offset + text.length);
			}
		}
	};

	/** 
	 * Constructs a new CompoundChange object.
	 * 
	 * @param owner the owner of the compound change
	 *
	 * @class 
	 * @name orion.editor.CompoundChange
	 * @private
	 */
	function CompoundChange (owner) {
		this.owner = owner;
		this.changes = [];
	}
	CompoundChange.prototype = {
		/** @ignore */
		getRedoChanges: function() {
			var changes = [];
			for (var i=0; i<this.changes.length; i++) {
				changes = changes.concat(this.changes[i].getRedoChanges());
			}
			return changes;
		},
		/** @ignore */
		getUndoChanges: function() {
			var changes = [];
			for (var i=this.changes.length - 1; i >= 0; i--) {
				changes = changes.concat(this.changes[i].getUndoChanges());
			}
			return changes;
		},
		/** @ignore */
		add: function (change) {
			this.changes.push(change);
		},
		/** @ignore */
		end: function (view) {
			if (view) {
				this.endSelection = view.getSelections();
			}
			var owner = this.owner;
			if (owner && owner.end) {
				owner.end();
			}
		},
		/** @ignore */
		undo: function (view, select) {
			if (this.changes.length > 1 && view) {
				view.setRedraw(false);
			}
			for (var i=this.changes.length - 1; i >= 0; i--) {
				this.changes[i].undo(view, false);
			}
			if (select && view) {
				view.setSelections(this.startSelection);
			}
			if (this.changes.length > 1 && view) {
				view.setRedraw(true);
			}
			var owner = this.owner;
			if (owner && owner.undo) {
				owner.undo();
			}
			return this.changes.length > 0;
		},
		/** @ignore */
		redo: function (view, select) {
			if (this.changes.length > 1 && view) {
				view.setRedraw(false);
			}
			for (var i = 0; i < this.changes.length; i++) {
				this.changes[i].redo(view, false);
			}
			if (select && view) {
				view.setSelections(this.endSelection);
			}
			if (this.changes.length > 1, view) {
				view.setRedraw(true);
			}
			var owner = this.owner;
			if (owner && owner.redo) {
				owner.redo();
			}
			return this.changes.length > 0;
		},
		merge: function(start, text, previousText, type, end, compoundChange) {
			var length = this.changes.length;
			if (length > 0 && this === compoundChange) {
				return this.changes[length - 1].merge(start, text, previousText, type, end);
			}
			return false;
		},
		/** @ignore */
		start: function (view) {
			if (view) {
				this.startSelection = view.getSelections();
			}
			var owner = this.owner;
			if (owner && owner.start) {
				owner.start();
			}
		}
	};

	/**
	 * Constructs a new UndoStack on a text view.
	 *
	 * @param {orion.editor.TextView} view the text view for the undo stack.
	 * @param {Number} [size=100] the size for the undo stack.
	 *
	 * @name orion.editor.UndoStack
	 * @class The UndoStack is used to record the history of a text model associated to an view. Every
	 * change to the model is added to stack, allowing the application to undo and redo these changes.
	 *
	 * <p>
	 * <b>See:</b><br/>
	 * {@link orion.editor.TextView}<br/>
	 * </p>
	 */
	function UndoStack (view, size) {
		this.size = size !== undefined ? size : 100;
		this.reset();
		var self = this;
		this._listener = {
			onChanging: function(e) {
				self._onChanging(e);
			},
			onDestroy: function(e) {
				self._onDestroy(e);
			}
		};
		if (view.getModel) {
			var model = view.getModel();
			if (model.getBaseModel) {
				model = model.getBaseModel();
			}
			this.model = model;
			this.setView(view);
		} else {
			this.shared = true;
			this.model = view;
		}
		this.model.addEventListener("Changing", this._listener.onChanging); //$NON-NLS-0$
	}
	UndoStack.prototype = /** @lends orion.editor.UndoStack.prototype */ {
		/**
		 * Destroy the undo stack.
		 */
		destroy: function() {
			this._onDestroy();
		},
		/**
		 * Adds a change to the stack.
		 * 
		 * @param change the change to add.
		 */
		add: function (change) {
			if (this.compoundChange) {
				this.compoundChange.add(change);
			} else {
				var length = this.stack.length;
				this.stack.splice(this.index, length-this.index, change);
				this.index++;
				if (this.stack.length > this.size) {
					this.stack.shift();
					this.index--;
				}
			}
		},
		/** 
		 * Marks the current state of the stack as clean.
		 *
		 * <p>
		 * This function is typically called when the content of view associated with the stack is saved.
		 * </p>
		 *
		 * @see orion.editor.UndoStack#isClean
		 */
		markClean: function() {
			this._commitUndo();
			this.cleanChange = this.stack[this.index - 1];
			if (this.cleanChange) {
				this.cleanChange.type = 2;
			}
		},
		/**
		 * Returns true if current state of stack is the same
		 * as the state when markClean() was called.
		 *
		 * <p>
		 * For example, the application calls markClean(), then calls undo() four times and redo() four times.
		 * At this point isClean() returns true.  
		 * </p>
		 * <p>
		 * This function is typically called to determine if the content of the view associated with the stack
		 * has changed since the last time it was saved.
		 * </p>
		 *
		 * @return {Boolean} returns if the state is the same as the state when markClean() was called.
		 *
		 * @see orion.editor.UndoStack#markClean
		 */
		isClean: function() {
			return this.cleanChange === this.stack[this.index - 1];
		},
		/**
		 * Returns true if there is at least one change to undo.
		 *
		 * @return {Boolean} returns true if there is at least one change to undo.
		 *
		 * @see orion.editor.UndoStack#canRedo
		 * @see orion.editor.UndoStack#undo
		 */
		canUndo: function() {
			return this.index > 0;
		},
		/**
		 * Returns true if there is at least one change to redo.
		 *
		 * @return {Boolean} returns true if there is at least one change to redo.
		 *
		 * @see orion.editor.UndoStack#canUndo
		 * @see orion.editor.UndoStack#redo
		 */
		canRedo: function() {
			return (this.stack.length - this.index) > 0;
		},
		/**
		 * Finishes a compound change.
		 *
		 * @see orion.editor.UndoStack#startCompoundChange
		 */
		endCompoundChange: function() {
			if (this.compoundChange) {
				this.compoundChange.end(this.view);
			}
			this.compoundChange = undefined;
		},
		/**
		 * Returns the sizes of the stack.
		 *
		 * @return {object} a object where object.undo is the number of changes that can be un-done, 
		 *  and object.redo is the number of changes that can be re-done.
		 *
		 * @see orion.editor.UndoStack#canUndo
		 * @see orion.editor.UndoStack#canRedo
		 */
		getSize: function() {
			return {
				undo: this.index,
				redo: this.stack.length - this.index
			};
		},
		/**
		 * @class This object represents a text change.
		 * <p>
		 * <b>See:</b><br/>
		 * {@link orion.editor.UndoStack}<br/>
		 * {@link orion.editor.UndoStack#getUndoChanges}<br/>
		 * {@link orion.editor.UndoStack#getRedoChanges}<br/>
		 * </p>
		 * @name orion.editor.TextChange
		 * 
		 * @property {Number} start The start offset in the model of the range to be replaced.
		 * @property {Number} end The end offset in the model of the range to be replaced
		 * @property {String} text the text to be inserted
		 */
		/**
		 * Returns the redo changes.
		 *
		 * @return {orion.editor.TextChange[]} an array of TextChanges that are returned in the order
		 * that they occurred (most recent change last).
		 *
		 * @see orion.editor.UndoStack#getUndoChanges
		 */
		getRedoChanges: function() {
			this._commitUndo();
			var changes = [];
			for (var i=this.index; i<this.stack.length; i++) {
				changes = changes.concat(this.stack[i].getRedoChanges());
			}
			return changes;
		},
		/**
		 * Returns the undo changes.
		 *
		 * @return {orion.editor.TextChange[]} an array of TextChanges that are returned in the reverse order
		 * that they occurred (most recent change first).
		 *
		 * @see orion.editor.UndoStack#getRedoChanges
		 */
		getUndoChanges: function() {
			this._commitUndo();
			var changes = [];
			for (var i=this.index; i >= 0; i--) {
				changes = changes.concat(this.stack[i].getUndoChanges());
			}
			return changes;
		},
		/**
		 * Undo the last change in the stack.
		 *
		 * @return {Boolean} returns true if a change was un-done.
		 *
		 * @see orion.editor.UndoStack#redo
		 * @see orion.editor.UndoStack#canUndo
		 */
		undo: function() {
			this._commitUndo();
			var change, result = false;
			this._ignoreUndo = true;
			do {
				if (this.index <= 0) {
					break;
				}
				change = this.stack[--this.index];
			} while (!(result = change.undo(this.view, true)));
			this._ignoreUndo = false;
			return result;
		},
		/**
		 * Redo the last change in the stack.
		 *
		 * @return {Boolean} returns true if a change was re-done.
		 *
		 * @see orion.editor.UndoStack#undo
		 * @see orion.editor.UndoStack#canRedo
		 */
		redo: function() {
			this._commitUndo();
			var change, result = false;
			this._ignoreUndo = true;
			do {
				if (this.index >= this.stack.length) {
					break;
				}
				change = this.stack[this.index++];
			} while (!(result = change.redo(this.view, true)));
			this._ignoreUndo = false;
			return result;
		},
		/**
		 * Reset the stack to its original state. All changes in the stack are thrown away.
		 */
		reset: function() {
			this.index = 0;
			this.cleanChange = undefined;
			this.stack = [];
			this._ignoreUndo = false;
			this._compoundChange = undefined;
		},
		setView: function(view) {
			if (this.view === view) { return; }
			if (this.view) {
				view.removeEventListener("Destroy", this._listener.onDestroy); //$NON-NLS-0$
			}
			this.view = view;
			if (this.view) {
				view.addEventListener("Destroy", this._listener.onDestroy); //$NON-NLS-0$
			}
		},
		/**
		 * Starts a compound change. 
		 * <p>
		 * All changes added to stack from the time startCompoundChange() is called
		 * to the time that endCompoundChange() is called are compound on one change that can be un-done or re-done
		 * with one single call to undo() or redo().
		 * </p>
		 *
		 * @param owner the owner of the compound change which is called for start, end, undo and redo.
		 *		 
		 * @return the compound change
		 *
		 * @see orion.editor.UndoStack#endCompoundChange
		 */
		startCompoundChange: function(owner) {
			this._commitUndo();
			var change = new CompoundChange(owner);
			this.add(change);
			this.compoundChange = change;
			this.compoundChange.start(this.view);
			return this.compoundChange;
		},
		_commitUndo: function () {
			this.endCompoundChange();
		},
		_onDestroy: function(evt) {
			if (!evt /* undo stack destroyed */ || !this.shared) {
				this.model.removeEventListener("Changing", this._listener.onChanging); //$NON-NLS-0$
			}
			if (this.view) {
				this.view.removeEventListener("Destroy", this._listener.onDestroy); //$NON-NLS-0$
				this.view = null;
			}
		},
		_trackUnsavedChanges: function(e) {
			if (!this._unsavedChanges) return;
			var length = this._unsavedChanges.length;
			var addedCharCount = e.addedCharCount;
			var removedCharCount = e.removedCharCount;
			var start = e.start;
			var end = e.start + removedCharCount;
			var type = 0;
			if (addedCharCount === 0) {
				type = -1;
			} else if (removedCharCount === 0) {
				type = 1;
			}
			if (length > 0) {
				if (type === this._previousChangeType) {
					var previousChange = this._unsavedChanges[length-1];
					if (removedCharCount === 0 && start === previousChange.end + previousChange.text.length) {
						previousChange.text += e.text;
						return;
					}
					if (e.addedCharCount === 0 && end === previousChange.start) {
						previousChange.start = start;
						return;
					}
				}
			}
			this._previousChangeType = type;
			this._unsavedChanges.push({start:start, end:end, text:e.text});
		},
		_onChanging: function(e) {
			this._trackUnsavedChanges(e);
			if (this._ignoreUndo) {
				return;
			}
			var text = e.text;
			var start = e.start;
			var addedCharCount = e.addedCharCount;
			var removedCharCount = e.removedCharCount;
			var end = start + removedCharCount;
			var type = 0;
			if (addedCharCount === 0 && removedCharCount === 1) {
				type = -1;
			} else if (addedCharCount === 1 && removedCharCount === 0) {
				type = 1;
			}
			var length = this.stack.length;
			var previousText = this.model.getText(start, end);
			if (length > 0 && this.index === length) {
				var change = this.stack[length - 1];
				if (change.merge(start, text, previousText, type, end, this.compoundChange)) {
					return;
				}
			}
			this.add(new Change(this.model, start, text, previousText, type));
		}
	};
	
	return {
		UndoStack: UndoStack
	};
});
