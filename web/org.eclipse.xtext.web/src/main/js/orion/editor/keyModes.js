/*******************************************************************************
 * @license
 * Copyright (c) 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html). 
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
 
/*eslint-env browser, amd*/
define("orion/editor/keyModes", [ //$NON-NLS-0$
		"orion/keyBinding", //$NON-NLS-0$
		"orion/util" //$NON-NLS-0$
], function(mKeyBinding, util) {

	function KeyMode(view) {
		if (!view) {
			return;
		}
		this._view = view;
		this._keyBindings = this.createKeyBindings();
		this._keyBindingIndex = 0;
	}
	KeyMode.prototype = /** @lends orion.editor.KeyMode.prototype */ {
		createKeyBindings: function () {
			return [];
		},
		/**
		 * Returns all the key bindings associated to the given action ID.
		 *
		 * @param {String} actionID the action ID.
		 * @returns {orion.KeyBinding[]} the array of key bindings associated to the given action ID.
		 *
		 * @see orion.editor.KeyModesetKeyBinding
		 * @see orion.editor.KeyModesetAction
		 */
		getKeyBindings: function (actionID) {
			var result = [];
			var keyBindings = this._keyBindings;
			for (var i = 0; i < keyBindings.length; i++) {
				if (keyBindings[i].actionID === actionID) {
					result.push(keyBindings[i].keyBinding);
				}
			}
			return result;
		},
		getView: function() {
			return this._view;
		},
		isActive: function () {
			return this._view.getKeyModes().indexOf(this) !== -1;
		},
		match: function(e) {
			if (e.type === "keydown") { //$NON-NLS-0$
				switch (e.keyCode) {
					case 16: /* Shift */
					case 17: /* Control */
					case 18: /* Alt */
					case 91: /* Command */
						return undefined;
				}
			}
			var keyBindingIndex = this._keyBindingIndex;
			var keyBindings = this._matchingKeyBindings || this._keyBindings;
			var matchingKeyBindings = [];
			for (var i = 0; i < keyBindings.length; i++) {
				var kb = keyBindings[i];
				var keyBinding = kb.keyBinding;
				var match = keyBinding.match(e, keyBindingIndex);
				if (match === true) {
					this._keyBindingIndex = 0;
					this._matchingKeyBindings = null;
					return kb.actionID;
				} else if (typeof match === "number") { //$NON-NLS-0$
					matchingKeyBindings.push(kb);
				}
			}
			if (matchingKeyBindings.length === 0) {
				this._keyBindingIndex = 0;
				this._matchingKeyBindings = null;
			} else {
				this._keyBindingIndex++;
				this._matchingKeyBindings = matchingKeyBindings;
				return "noop"; //$NON-NLS-0$
			}
			return undefined;
		},
		/**
		 * Associates a key binding with the given action ID. Any previous
		 * association with the specified key binding is overwriten. If the
		 * action ID is <code>null</code>, the association is removed.
		 * 
		 * @param {orion.KeyBinding} keyBinding the key binding
		 * @param {String} actionID the action ID
		 */
		setKeyBinding: function(keyBinding, actionID) {
			var keyBindings = this._keyBindings;
			for (var i = 0; i < keyBindings.length; i++) {
				var kb = keyBindings[i]; 
				if (kb.keyBinding.equals(keyBinding)) {
					if (actionID) {
						kb.actionID = actionID;
					} else {
						if (kb.predefined) {
							kb.actionID = "noop"; //$NON-NLS-0$
						} else {
							keyBindings.splice(i, 1);
						}
					}
					return;
				}
			}
			if (actionID) {
				keyBindings.push({keyBinding: keyBinding, actionID: actionID});
			}
		},
		setView: function(view) {
			this._view = view;
		}
	};
	
	function DefaultKeyMode(view) {
		KeyMode.call(this, view);
	}
	DefaultKeyMode.prototype = new KeyMode();
	DefaultKeyMode.prototype.createKeyBindings = function () {
		var KeyBinding = mKeyBinding.KeyBinding;
		//no duplicate keybindings
		var bindings = [];

		// Cursor Navigation
		bindings.push({actionID: "lineUp",		keyBinding: new KeyBinding(38), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "lineDown",	keyBinding: new KeyBinding(40), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "charPrevious",	keyBinding: new KeyBinding(37), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "charNext",	keyBinding: new KeyBinding(39), predefined: true}); //$NON-NLS-0$
		if (util.isMac) {
			bindings.push({actionID: "scrollPageUp",		keyBinding: new KeyBinding(33), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "scrollPageDown",	keyBinding: new KeyBinding(34), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "pageUp",		keyBinding: new KeyBinding(33, null, null, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "pageDown",	keyBinding: new KeyBinding(34, null, null, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "lineStart",	keyBinding: new KeyBinding(37, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "lineEnd",		keyBinding: new KeyBinding(39, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "wordPrevious",	keyBinding: new KeyBinding(37, null, null, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "wordNext",	keyBinding: new KeyBinding(39, null, null, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "scrollTextStart",	keyBinding: new KeyBinding(36), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "scrollTextEnd",		keyBinding: new KeyBinding(35), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "textStart",	keyBinding: new KeyBinding(38, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "textEnd",		keyBinding: new KeyBinding(40, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "scrollPageUp",	keyBinding: new KeyBinding(38, null, null, null, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "scrollPageDown",		keyBinding: new KeyBinding(40, null, null, null, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "lineStart",	keyBinding: new KeyBinding(37, null, null, null, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "lineEnd",		keyBinding: new KeyBinding(39, null, null, null, true), predefined: true}); //$NON-NLS-0$
			//TODO These two actions should be changed to paragraph start and paragraph end  when word wrap is implemented
			bindings.push({actionID: "lineStart",	keyBinding: new KeyBinding(38, null, null, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "lineEnd",		keyBinding: new KeyBinding(40, null, null, true), predefined: true}); //$NON-NLS-0$
		} else {
			bindings.push({actionID: "pageUp",		keyBinding: new KeyBinding(33), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "pageDown",	keyBinding: new KeyBinding(34), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "lineStart",	keyBinding: new KeyBinding(36), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "lineEnd",		keyBinding: new KeyBinding(35), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "wordPrevious",	keyBinding: new KeyBinding(37, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "wordNext",	keyBinding: new KeyBinding(39, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "textStart",	keyBinding: new KeyBinding(36, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "textEnd",		keyBinding: new KeyBinding(35, true), predefined: true}); //$NON-NLS-0$
		}
		if (util.isFirefox && util.isLinux) {
			bindings.push({actionID: "lineUp",		keyBinding: new KeyBinding(38, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "lineDown",	keyBinding: new KeyBinding(40, true), predefined: true}); //$NON-NLS-0$
		}
		if (util.isWindows) {
			bindings.push({actionID: "scrollLineUp",	keyBinding: new KeyBinding(38, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "scrollLineDown",	keyBinding: new KeyBinding(40, true), predefined: true}); //$NON-NLS-0$
		}

		// Select Cursor Navigation
		bindings.push({actionID: "selectLineUp",		keyBinding: new KeyBinding(38, null, true), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "selectLineDown",		keyBinding: new KeyBinding(40, null, true), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "selectCharPrevious",	keyBinding: new KeyBinding(37, null, true), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "selectCharNext",		keyBinding: new KeyBinding(39, null, true), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "selectPageUp",		keyBinding: new KeyBinding(33, null, true), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "selectPageDown",		keyBinding: new KeyBinding(34, null, true), predefined: true}); //$NON-NLS-0$
		if (util.isMac) {
			bindings.push({actionID: "selectLineStart",	keyBinding: new KeyBinding(37, true, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "selectLineEnd",		keyBinding: new KeyBinding(39, true, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "selectWordPrevious",	keyBinding: new KeyBinding(37, null, true, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "selectWordNext",	keyBinding: new KeyBinding(39, null, true, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "selectTextStart",	keyBinding: new KeyBinding(36, null, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "selectTextEnd",		keyBinding: new KeyBinding(35, null, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "selectTextStart",	keyBinding: new KeyBinding(38, true, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "selectTextEnd",		keyBinding: new KeyBinding(40, true, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "selectLineStart",	keyBinding: new KeyBinding(37, null, true, null, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "selectLineEnd",		keyBinding: new KeyBinding(39, null, true, null, true), predefined: true}); //$NON-NLS-0$
			//TODO These two actions should be changed to select paragraph start and select paragraph end  when word wrap is implemented
			bindings.push({actionID: "selectLineStart",	keyBinding: new KeyBinding(38, null, true, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "selectLineEnd",		keyBinding: new KeyBinding(40, null, true, true), predefined: true}); //$NON-NLS-0$
		} else {
			if (util.isLinux) {
				bindings.push({actionID: "selectWholeLineUp",		keyBinding: new KeyBinding(38, true, true), predefined: true}); //$NON-NLS-0$
				bindings.push({actionID: "selectWholeLineDown",		keyBinding: new KeyBinding(40, true, true), predefined: true}); //$NON-NLS-0$
			}
			bindings.push({actionID: "selectLineStart",		keyBinding: new KeyBinding(36, null, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "selectLineEnd",		keyBinding: new KeyBinding(35, null, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "selectWordPrevious",	keyBinding: new KeyBinding(37, true, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "selectWordNext",		keyBinding: new KeyBinding(39, true, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "selectTextStart",		keyBinding: new KeyBinding(36, true, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "selectTextEnd",		keyBinding: new KeyBinding(35, true, true), predefined: true}); //$NON-NLS-0$
		}
		
		//Undo stack
		bindings.push({actionID: "undo", keyBinding: new mKeyBinding.KeyBinding('z', true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
		if (util.isMac) {
			bindings.push({actionID: "redo", keyBinding: new mKeyBinding.KeyBinding('z', true, true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
		} else {
			bindings.push({actionID: "redo", keyBinding: new mKeyBinding.KeyBinding('y', true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
		}

		//Misc
		bindings.push({actionID: "deletePrevious",		keyBinding: new KeyBinding(8), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "deletePrevious",		keyBinding: new KeyBinding(8, null, true), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "deleteNext",		keyBinding: new KeyBinding(46), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "deleteWordPrevious",	keyBinding: new KeyBinding(8, true), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "deleteWordPrevious",	keyBinding: new KeyBinding(8, true, true), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "deleteWordNext",		keyBinding: new KeyBinding(46, true), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "tab",			keyBinding: new KeyBinding(9), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "shiftTab",			keyBinding: new KeyBinding(9, null, true), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "enter",			keyBinding: new KeyBinding(13), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "enter",			keyBinding: new KeyBinding(13, null, true), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "escape",			keyBinding: new KeyBinding(27), predefined: true}); //$NON-NLS-0$
		bindings.push({actionID: "selectAll",		keyBinding: new KeyBinding('a', true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
		bindings.push({actionID: "toggleTabMode",	keyBinding: new KeyBinding('m', true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
		if (util.isMac) {
			bindings.push({actionID: "deleteNext",		keyBinding: new KeyBinding(46, null, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "deleteWordPrevious",	keyBinding: new KeyBinding(8, null, null, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "deleteWordNext",		keyBinding: new KeyBinding(46, null, null, true), predefined: true}); //$NON-NLS-0$
		}
		
		bindings.push({actionID: "toggleWrapMode",		keyBinding: new mKeyBinding.KeyBinding('w', true, false, true)}); //$NON-NLS-1$ //$NON-NLS-0$
		bindings.push({actionID: "toggleOverwriteMode",		keyBinding: new mKeyBinding.KeyBinding(45)}); //$NON-NLS-0$
		
		/*
		* Feature in IE/Chrome: prevent ctrl+'u', ctrl+'i', and ctrl+'b' from applying styles to the text.
		*
		* Note that Chrome applies the styles on the Mac with Ctrl instead of Cmd.
		*/
		if (!util.isFirefox) {
			var isMacChrome = util.isMac && util.isChrome;
			bindings.push({actionID: "noop", keyBinding: new KeyBinding('u', !isMacChrome, false, false, isMacChrome), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
			bindings.push({actionID: "noop", keyBinding: new KeyBinding('i', !isMacChrome, false, false, isMacChrome), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
			bindings.push({actionID: "noop", keyBinding: new KeyBinding('b', !isMacChrome, false, false, isMacChrome), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
		}

		if (util.isFirefox) {
			bindings.push({actionID: "copy", keyBinding: new KeyBinding(45, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "paste", keyBinding: new KeyBinding(45, null, true), predefined: true}); //$NON-NLS-0$
			bindings.push({actionID: "cut", keyBinding: new KeyBinding(46, null, true), predefined: true}); //$NON-NLS-0$
		}

		// Add the emacs Control+ ... key bindings.
		if (util.isMac) {
			bindings.push({actionID: "lineStart", keyBinding: new KeyBinding("a", false, false, false, true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
			bindings.push({actionID: "lineEnd", keyBinding: new KeyBinding("e", false, false, false, true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
			bindings.push({actionID: "lineUp", keyBinding: new KeyBinding("p", false, false, false, true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
			bindings.push({actionID: "lineDown", keyBinding: new KeyBinding("n", false, false, false, true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
			bindings.push({actionID: "charPrevious", keyBinding: new KeyBinding("b", false, false, false, true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
			bindings.push({actionID: "charNext", keyBinding: new KeyBinding("f", false, false, false, true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
			bindings.push({actionID: "deletePrevious", keyBinding: new KeyBinding("h", false, false, false, true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
			bindings.push({actionID: "deleteNext", keyBinding: new KeyBinding("d", false, false, false, true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
			bindings.push({actionID: "deleteLineEnd", keyBinding: new KeyBinding("k", false, false, false, true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
			if (util.isFirefox) {
				bindings.push({actionID: "scrollPageDown", keyBinding: new KeyBinding("v", false, false, false, true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
				bindings.push({actionID: "deleteLineStart", keyBinding: new KeyBinding("u", false, false, false, true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
				bindings.push({actionID: "deleteWordPrevious", keyBinding: new KeyBinding("w", false, false, false, true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
			} else {
				bindings.push({actionID: "pageDown", keyBinding: new KeyBinding("v", false, false, false, true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
				bindings.push({actionID: "centerLine", keyBinding: new KeyBinding("l", false, false, false, true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
				bindings.push({actionID: "enterNoCursor", keyBinding: new KeyBinding("o", false, false, false, true), predefined: true}); //$NON-NLS-1$ //$NON-NLS-0$
				//TODO implement: y (yank), t (transpose)
			}
		}
		return bindings;
	};
	
	return {
		KeyMode: KeyMode,
		DefaultKeyMode: DefaultKeyMode
	};
});