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
define("orion/editor/linkedMode", [ //$NON-NLS-0$
	'i18n!orion/editor/nls/messages', //$NON-NLS-0$
	'orion/keyBinding', //$NON-NLS-0$
	'orion/editor/keyModes', //$NON-NLS-0$
	'orion/editor/annotations', //$NON-NLS-0$
	'orion/editor/templates', //$NON-NLS-0$
	'orion/objects', //$NON-NLS-0$
	'orion/util' //$NON-NLS-0$
], function(messages, mKeyBinding, mKeyModes, mAnnotations, mTemplates, objects) {

	var exports = {};

	function LinkedMode(editor, undoStack, contentAssist) {
		var textView = editor.getTextView();
		mKeyModes.KeyMode.call(this, textView);
		this.editor = editor;
		this.undoStack = undoStack;
		this.contentAssist = contentAssist;
		
		this.linkedModeModel = null;
		
		textView.setAction("linkedModeEnter", function() { //$NON-NLS-0$
			this.exitLinkedMode(true);
			return true;
		}.bind(this));
		textView.setAction("linkedModeCancel", function() { //$NON-NLS-0$
			this.exitLinkedMode(false);
			return true;
		}.bind(this));
		textView.setAction("linkedModeNextGroup", function() { //$NON-NLS-0$
			var model = this.linkedModeModel;
			this.selectLinkedGroup((model.selectedGroupIndex + 1) % model.groups.length);
			return true;
		}.bind(this));
		textView.setAction("linkedModePreviousGroup", function() { //$NON-NLS-0$
			var model = this.linkedModeModel;
			this.selectLinkedGroup(model.selectedGroupIndex > 0 ? model.selectedGroupIndex-1 : model.groups.length-1);
			return true;
		}.bind(this));
		
		/**
		 * Listener called when Linked Mode is active. Updates position's offsets and length
		 * on user change. Also escapes the Linked Mode if the text buffer was modified outside of the Linked Mode positions.
		 */
		this.linkedModeListener = {
		
			onActivating: function(event) {
				if (this._groupContentAssistProvider) {
					this.contentAssist.setProviders([this._groupContentAssistProvider]);
					this.contentAssist.setProgress(null);
				}
			}.bind(this),
			
			onModelChanged: function(event) {
				if (this.ignoreVerify) { return; }

				// Get the position being modified
				var start = this.editor.mapOffset(event.start);
				var model = this.linkedModeModel, positionChanged, changed;
				while (model) {
					positionChanged = this._getPositionChanged(model, start, start + event.removedCharCount);
					changed = positionChanged.position;
					if (changed === undefined || changed.model !== model) {
						// The change has been done outside of the positions, exit the Linked Mode
						this.exitLinkedMode(false);
						model = this.linkedModeModel;
					} else {
						break;
					}
				}
				if (!model) { return; }

				// Update position offsets for this change. Group changes are done in #onVerify
				var deltaCount = 0;
				var changeCount = event.addedCharCount - event.removedCharCount;
				var sortedPositions = positionChanged.positions, position, pos;
				for (var i = 0; i < sortedPositions.length; ++i) {
					pos = sortedPositions[i];
					position = pos.position;
					var inside = position.offset <= start && start <= position.offset + position.length;
					if (inside && !pos.ansestor) {
						position.offset += deltaCount;
						position.length += changeCount;
						deltaCount += changeCount;
					} else {
						position.offset += deltaCount;
						if (pos.ansestor && inside) {
							position.length += changeCount;
						}
					}
					if (pos.escape) {
						pos.model.escapePosition = position.offset;
					}
				}
				this._updateAnnotations(sortedPositions);
			}.bind(this),

			onVerify: function(event) {
				if (this.ignoreVerify) { return; }

				// Get the position being modified
				var editor = this.editor;
				var start = editor.mapOffset(event.start);
				var end = this.editor.mapOffset(event.end);
				var model = this.linkedModeModel, positionChanged, changed;
				while (model) {
					positionChanged = this._getPositionChanged(model, start, end);
					changed = positionChanged.position;
					if (changed === undefined || changed.model !== model) {
						// The change has been done outside of the positions, exit the Linked Mode
						this.exitLinkedMode(false);
						model = this.linkedModeModel;
					} else {
						break;
					}
				}
				if (!model) { return; }
				
				// Make sure changes in a same group are compound
				var undo = this._compoundChange;
				if (undo) {
					if (!(undo.owner.model === model && undo.owner.group === changed.group)) {
						this.endUndo();
						this.startUndo();
					}
				} else {
					this.startUndo();
				}

				model.selectedGroupIndex = changed.group;
				
				// Update position offsets taking into account all positions in the same changing group
				var deltaCount = 0;
				var changeCount = event.text.length - (end - start);
				var sortedPositions = positionChanged.positions, position, pos;
				var deltaStart = start - changed.position.offset, deltaEnd = end - changed.position.offset;
				for (var i = 0; i < sortedPositions.length; ++i) {
					pos = sortedPositions[i];
					position = pos.position;
					pos.oldOffset = position.offset;
					if (pos.model === model && pos.group === changed.group) {
						position.offset += deltaCount;
						position.length += changeCount;
						deltaCount += changeCount;
					} else {
						position.offset += deltaCount;
						if (pos.ansestor) {
							position.length += changed.count * changeCount;
						}
					}
					if (pos.escape) {
						pos.model.escapePosition = position.offset;
					}
				}
				
				// Cancel this modification and apply same modification to all positions in changing group
				this.ignoreVerify = true;
				for (i = sortedPositions.length - 1; i >= 0; i--) {
					pos = sortedPositions[i];
					if (pos.model === model && pos.group === changed.group) {
						editor.setText(event.text, pos.oldOffset + deltaStart , pos.oldOffset + deltaEnd);
					}
				}
				this.ignoreVerify = false;
				event.text = null;
				this._updateAnnotations(sortedPositions);
			}.bind(this)
		};
	}
	LinkedMode.prototype = new mKeyModes.KeyMode();
	objects.mixin(LinkedMode.prototype, {
		createKeyBindings: function() {
			var KeyBinding = mKeyBinding.KeyBinding;
			var bindings = [];
			bindings.push({actionID: "linkedModeEnter", keyBinding: new KeyBinding(13)}); //$NON-NLS-0$
			bindings.push({actionID: "linkedModeCancel", keyBinding: new KeyBinding(27)}); //$NON-NLS-0$
			bindings.push({actionID: "linkedModeNextGroup", keyBinding: new KeyBinding(9)}); //$NON-NLS-0$
			bindings.push({actionID: "linkedModePreviousGroup", keyBinding: new KeyBinding(9, false, true)}); //$NON-NLS-0$
			return bindings;
		},
		/**
		 * Starts Linked Mode, selects the first position and registers the listeners.
		 * @param {Object} linkedModeModel An object describing the model to be used by linked mode.
		 * Contains one or more position groups. If a position in a group is edited, the other positions in
		 * the same group are edited the same way. The model structure is as follows:
		 * <pre>{
		 *		groups: [{
		 *			data: {},
		 *			positions: [{
		 *				offset: 10, // Relative to the text buffer
		 *				length: 3
		 *			}]
		 *		}],
		 *		escapePosition: 19, // Relative to the text buffer
		 * }</pre>
		 *
		 * Each group in the model has an optional <code>data</code> property which can be
		 * used to provide additional content assist for the group.  The <code>type</code> in
		 * data determines what kind of content assist is provided. These are the support
		 * structures for the <code>data</code> property.
		 * <pre>{
		 *		type: "link"
		 *		values: ["proposal0", "proposal1", ...]
		 * }</pre>
		 *
		 * The "link" data struture provides static content assist proposals stored in the
		 * <code>values</code> property.
		 *
		 * <p>
		 * <b>See:</b><br/>
		 * {@link orion.editor.Template}<br/>
		 * {@link orion.editor.TemplateContentAssist}<br/>
		 * </p>
		 */
		enterLinkedMode: function(linkedModeModel) {
			if (!this.linkedModeModel) {
				var textView = this.editor.getTextView();
				textView.addKeyMode(this);
				textView.addEventListener("Verify", this.linkedModeListener.onVerify); //$NON-NLS-0$
				textView.addEventListener("ModelChanged", this.linkedModeListener.onModelChanged); //$NON-NLS-0$
				var contentAssist = this.contentAssist;
				contentAssist.addEventListener("Activating", this.linkedModeListener.onActivating); //$NON-NLS-0$
				this.editor.reportStatus(messages.linkedModeEntered, null, true);
			}
			this._sortedPositions = null;
			if (this.linkedModeModel) {
				linkedModeModel.previousModel = this.linkedModeModel;
				linkedModeModel.parentGroup = this.linkedModeModel.selectedGroupIndex;
				this.linkedModeModel.nextModel = linkedModeModel;
			}
			this.linkedModeModel = linkedModeModel;
			this.selectLinkedGroup(0);
		},
		/** 
		 * Exits Linked Mode. Optionally places the caret at linkedMode escapePosition. 
		 * @param {Boolean} [escapePosition=false] if true, place the caret at the  escape position.
		 */
		exitLinkedMode: function(escapePosition) {
			if (!this.isActive()) {
				return;
			}
			if (this._compoundChange) {
				this.endUndo();
				this._compoundChange = null;
			}
			this._sortedPositions = null;
			var model = this.linkedModeModel;
			this.linkedModeModel = model.previousModel;
			model.parentGroup = model.previousModel = undefined;
			if (this.linkedModeModel) {
				this.linkedModeModel.nextModel = undefined;
			}
			if (!this.linkedModeModel) {
				var editor = this.editor;
				var textView = editor.getTextView();
				textView.removeKeyMode(this);
				textView.removeEventListener("Verify", this.linkedModeListener.onVerify); //$NON-NLS-0$
				textView.removeEventListener("ModelChanged", this.linkedModeListener.onModelChanged); //$NON-NLS-0$
				var contentAssist = this.contentAssist;
				contentAssist.removeEventListener("Activating", this.linkedModeListener.onActivating); //$NON-NLS-0$
				contentAssist.offset = undefined;
				this.editor.reportStatus(messages.linkedModeExited, null, true);
				if (escapePosition && typeof model.escapePosition === "number") { //$NON-NLS-0$
					editor.setCaretOffset(model.escapePosition, false);
				}
			}
			this.selectLinkedGroup(0);
		},
		startUndo: function() {
			if (this.undoStack) {
				var self = this;
				var model = this.linkedModeModel;
				this._compoundChange = this.undoStack.startCompoundChange({
					model: model,
					group: model.selectedGroupIndex,
					end: function() {
						self._compoundChange = null;
					}
				});
			}
		}, 
		endUndo: function() {
			if (this.undoStack) {
				this.undoStack.endCompoundChange();
			}
		},
		isActive: function() {
			return !!this.linkedModeModel;
		},
		isStatusActive: function() {
			return !!this.linkedModeModel;
		},
		selectLinkedGroup: function(index) {
			var model = this.linkedModeModel;
			if (model) {
				model.selectedGroupIndex = index;
				var group = model.groups[index];
				var position = group.positions[0];
				var editor = this.editor;
				editor.setSelection(position.offset, position.offset + position.length);
				var contentAssist = this.contentAssist;
				if (contentAssist) {
					contentAssist.offset = undefined;
					if (group.data && group.data.type === "link" && group.data.values) { //$NON-NLS-0$
						var provider = this._groupContentAssistProvider = new mTemplates.TemplateContentAssist(group.data.values);
						provider.getPrefix = function() {
							var selection = editor.getSelection();
							if (selection.start === selection.end) {
								var caretOffset = editor.getCaretOffset();
								if (position.offset <= caretOffset && caretOffset <= position.offset + position.length) {
									return editor.getText(position.offset, caretOffset);
								}
							}
							return "";
						};
						contentAssist.offset = position.offset;
						contentAssist.deactivate();
						contentAssist.activate();
					} else if (this._groupContentAssistProvider) {
						this._groupContentAssistProvider = null;
						contentAssist.deactivate();
					}
				}
			}
			this._updateAnnotations();
		},
		_getModelPositions: function(all, model, delta) {
			var groups = model.groups;
			for (var i = 0; i < groups.length; i++) {
				var positions = groups[i].positions;
				for (var j = 0; j < positions.length; j++) {
					var position = positions[j];
					if (delta) {
						position = {offset: position.offset + delta, length: position.length};
					}
					var pos = {
						index: j,
						group: i,
						count: positions.length,
						model: model,
						position: position
					};
					all.push(pos);
					if (model.nextModel && model.nextModel.parentGroup === i) {
						pos.ansestor = true;
						this._getModelPositions(all, model.nextModel, (delta || 0) + positions[j].offset - positions[0].offset);
					}
				}
			}
		},
		_getSortedPositions: function(model) {
			var all = this._sortedPositions;
			if (!all) {
				all = [];
				// Get the root linked model
				while (model.previousModel) {
					model = model.previousModel;
				}
				// Get all positions under model expanding group positions of stacked linked modes
				this._getModelPositions(all, model);
				// Add escape position for all models
				while (model) {
					if (typeof model.escapePosition === "number") { //$NON-NLS-0$
						all.push({
							escape: true,
							model: model,
							position: {offset: model.escapePosition, length: 0}
						});
					}
					model = model.nextModel;
				}
				all.sort(function(a, b) {
					return a.position.offset - b.position.offset;
				});
				this._sortedPositions = all;
			}
			return all;
		},
		_getPositionChanged: function(model, start, end) {
			var changed;
			var sortedPositions = this._getSortedPositions(model);
			for (var i = sortedPositions.length - 1; i >= 0; i--) {
				var position = sortedPositions[i].position;
				if (position.offset <= start && end <= position.offset + position.length) {
					changed = sortedPositions[i];
					break;
				}
			}
			return {position: changed, positions: sortedPositions};
		},
		_updateAnnotations: function(positions) {
			var annotationModel = this.editor.getAnnotationModel();
			if (!annotationModel) { return; }
			var remove = [], add = [];
			var annotations = annotationModel.getAnnotations(), annotation;
			while (annotations.hasNext()) {
				annotation = annotations.next();
				switch (annotation.type) {
					case mAnnotations.AnnotationType.ANNOTATION_LINKED_GROUP:
					case mAnnotations.AnnotationType.ANNOTATION_CURRENT_LINKED_GROUP:
					case mAnnotations.AnnotationType.ANNOTATION_SELECTED_LINKED_GROUP:
						remove.push(annotation);
				}
			}
			var model = this.linkedModeModel;
			if (model) {
				positions = positions || this._getSortedPositions(model);
				for (var i = 0; i < positions.length; i++) {
					var position = positions[i];
					if (position.model !== model) { continue; }
					if (position.escape) { continue; }
					var type = mAnnotations.AnnotationType.ANNOTATION_LINKED_GROUP;
					if (position.group === model.selectedGroupIndex) {
						if (position.index === 0) {
							type = mAnnotations.AnnotationType.ANNOTATION_SELECTED_LINKED_GROUP;
						} else {
							type = mAnnotations.AnnotationType.ANNOTATION_CURRENT_LINKED_GROUP;
						}
					}
					position = position.position;
					annotation = mAnnotations.AnnotationType.createAnnotation(type, position.offset, position.offset + position.length, "");
					add.push(annotation);
				}
			}
			annotationModel.replaceAnnotations(remove, add);
		}
	});
	exports.LinkedMode = LinkedMode;

	return exports;
});
