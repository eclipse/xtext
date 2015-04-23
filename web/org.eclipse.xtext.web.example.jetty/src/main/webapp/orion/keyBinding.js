/*******************************************************************************
 * @license
 * Copyright (c) 2010, 2013 IBM Corporation and others.
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
define("orion/keyBinding", ['orion/util'], function(util) { //$NON-NLS-1$ //$NON-NLS-0$

    /**
	 * @class A KeyBinding is an interface used to define keyboard shortcuts.
	 * @name orion.KeyBinding
	 * 
	 * @property {Function} match The function to match events.
	 * @property {Function} equals The funtion to compare to key bindings.
	 *
	 * @see orion.KeyStroke
	 * @see orion.KeySequence
	 */

	/**
	 * Constructs a new key stroke with the given key code, modifiers and event type.
	 * 
	 * @param {String|Number} keyCode the key code.
	 * @param {Boolean} mod1 the primary modifier (usually Command on Mac and Control on other platforms).
	 * @param {Boolean} mod2 the secondary modifier (usually Shift).
	 * @param {Boolean} mod3 the third modifier (usually Alt).
	 * @param {Boolean} mod4 the fourth modifier (usually Control on the Mac).
	 * @param {String} type the type of event that the keybinding matches; either "keydown" or "keypress".
	 * 
	 * @class A KeyStroke represents of a key code and modifier state that can be triggered by the user using the keyboard.
	 * @name orion.KeyStroke
	 * 
	 * @property {String|Number} keyCode The key code.
	 * @property {Boolean} mod1 The primary modifier (usually Command on Mac and Control on other platforms).
	 * @property {Boolean} mod2 The secondary modifier (usually Shift).
	 * @property {Boolean} mod3 The third modifier (usually Alt).
	 * @property {Boolean} mod4 The fourth modifier (usually Control on the Mac).
	 * @property {String} [type=keydown] The type of event that the keybinding matches; either "keydown" or "keypress"
	 *
	 * @see orion.editor.TextView#setKeyBinding
	 */
	function KeyStroke (keyCode, mod1, mod2, mod3, mod4, type) {
		this.type = type || "keydown"; //$NON-NLS-0$
		if (typeof(keyCode) === "string" && this.type === "keydown") { //$NON-NLS-1$ //$NON-NLS-0$
			this.keyCode = keyCode.toUpperCase().charCodeAt(0);
		} else {
			this.keyCode = keyCode;
		}
		this.mod1 = mod1 !== undefined && mod1 !== null ? mod1 : false;
		this.mod2 = mod2 !== undefined && mod2 !== null ? mod2 : false;
		this.mod3 = mod3 !== undefined && mod3 !== null ? mod3 : false;
		this.mod4 = mod4 !== undefined && mod4 !== null ? mod4 : false;
	}
	KeyStroke.prototype = /** @lends orion.KeyStroke.prototype */ {
		getKeys: function() {
			return [this];
		},
		/**
		 * Determines either this key stroke matches the specifed event.  It can match either a
		 * a whole sequence of key events or a single key event at a specified index.
		 * <p>
		 * <code>KeyStroke</code> only matches single key events. <code>KeySequence</code> handles
		 * matching a sequence of events.
		 * </p>
		 * TODO explain this better
		 * 
		 * @param {DOMEvent|DOMEvent[]} e the key event or list of events to match.
		 * @param index the key event to match.
		 * @returns {Boolean} <code>true</code> whether the key binding matches the key event.
		 *
		 * @see orion.KeySequence#match
		 */
		match: function (e, index) {
			if (index !== undefined) {
				if (index !== 0) {
					return false;
				}
			} else {
				if (e instanceof Array) {
					if (e.length > 1) {
						return false;
					}
					e = e[0];
				}
			}
			if (e.type !== this.type) {
				return false;
			}
			if (this.keyCode === e.keyCode || this.keyCode === String.fromCharCode(util.isOpera ? e.which : (e.charCode !== undefined ? e.charCode : e.keyCode))) {
				var mod1 = util.isMac ? e.metaKey : e.ctrlKey;
				if (this.mod1 !== mod1) { return false; }
				if (this.type === "keydown") { //$NON-NLS-0$
					if (this.mod2 !== e.shiftKey) { return false; }
				}
				if (this.mod3 !== e.altKey) { return false; }
				if (util.isMac && this.mod4 !== e.ctrlKey) { return false; }
				return true;
			}
			return false;
		},
		/**
		 * Returns whether this key stroke is the same as the given parameter.
		 * 
		 * @param {orion.KeyBinding} kb the key binding to compare with.
		 * @returns {Boolean} whether or not the parameter and the receiver describe the same key binding.
		 */
		equals: function(kb) {
			if (!kb) { return false; }
			if (this.keyCode !== kb.keyCode) { return false; }
			if (this.mod1 !== kb.mod1) { return false; }
			if (this.mod2 !== kb.mod2) { return false; }
			if (this.mod3 !== kb.mod3) { return false; }
			if (this.mod4 !== kb.mod4) { return false; }
			if (this.type !== kb.type) { return false; }
			return true;
		} 
	};
	
	/**
	 * Constructs a new key sequence with the given key strokes.
	 * 
	 * @param {orion.KeyStroke[]} keys the key strokes for this sequence.
	 * 
	 * @class A KeySequence represents of a list of key codes and a modifiers state that can be triggered by the user using the keyboard.
	 * @name orion.KeySequence
	 * 
	 * @property {orion.KeyStroke[]} keys the list of key strokes.
	 *
	 * @see orion.editor.TextView#setKeyBinding
	 */
	function KeySequence (keys) {
		this.keys = keys;
	}
	KeySequence.prototype = /** @lends orion.KeySequence.prototype */ {
		getKeys: function() {
			return this.keys.slice(0);
		},
		match: function (e, index) {
			var keys = this.keys;
			if (index !== undefined) {
				if (index > keys.length) {
					return false;
				}
				if (keys[index].match(e)) {
					if (index === keys.length - 1) {
						return true;
					}
					return index + 1;
				}
				return false;
			} else {
				if (!(e instanceof Array)) {
					e = [e];
				}
				if (e.length > keys.length) {
					return false;
				}
				var i;
				for (i = 0; i < e.length; i++) {
					if (!keys[i].match(e[i])) {
						return false;
					}
				}
				if (i === keys.length) {
					return true;
				}
				return i;
			}
		},
		/**
		 * Returns whether this key sequence is the same as the given parameter.
		 * 
		 * @param {orion.KeyBinding|orion.KeySequence} kb the key binding to compare with.
		 * @returns {Boolean} whether or not the parameter and the receiver describe the same key binding.
		 */
		equals: function(kb) {
			if (!kb.keys) { return false; }
			if (kb.keys.length !== this.keys.length) { return false; }
			for (var i=0; i<kb.keys.length; i++) {
				if (!kb.keys[i].equals(this.keys[i])) { return false; }
			}
			return true;
		}	
	};
	
	return {
		KeyBinding: KeyStroke, // for backwards compatibility
		KeyStroke: KeyStroke,
		KeySequence: KeySequence
	};
});
