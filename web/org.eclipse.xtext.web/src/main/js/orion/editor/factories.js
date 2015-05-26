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
define("orion/editor/factories", [ //$NON-NLS-0$
	'orion/editor/actions', //$NON-NLS-0$
	'orion/editor/undoStack', //$NON-NLS-0$
	'orion/editor/rulers', //$NON-NLS-0$
	'orion/editor/annotations', //$NON-NLS-0$
	'orion/editor/textDND', //$NON-NLS-0$
	'orion/editor/linkedMode', //$NON-NLS-0$
	'orion/util' //$NON-NLS-0$
], function(mActions, mUndoStack, mRulers, mAnnotations, mTextDND, mLinkedMode, util) {

	var exports = {};
	
	function KeyBindingsFactory() {
	}
	KeyBindingsFactory.prototype = {
		createKeyBindings: function(editor, undoStack, contentAssist, searcher) {
			// Create keybindings for generic editing, no dependency on the service model
			var textActions = new mActions.TextActions(editor, undoStack , searcher);
			// Linked Mode
			var linkedMode = new mLinkedMode.LinkedMode(editor, undoStack, contentAssist);
			// create keybindings for source editing
			// TODO this should probably be something that happens more dynamically, when the editor changes input
			var sourceCodeActions = new mActions.SourceCodeActions(editor, undoStack, contentAssist, linkedMode);
			return {
				textActions: textActions,
				linkedMode: linkedMode,
				sourceCodeActions: sourceCodeActions
			};
		}
	};
	exports.KeyBindingsFactory = KeyBindingsFactory;
	
	function UndoFactory() {
	}
	UndoFactory.prototype = {
		createUndoStack: function(editor) {
			var textView = editor.getTextView();
			return new mUndoStack.UndoStack(textView, 200);
		}
	};
	exports.UndoFactory = UndoFactory;

	function LineNumberRulerFactory() {
	}
	LineNumberRulerFactory.prototype = {
		createLineNumberRuler: function(annotationModel) {
			return new mRulers.LineNumberRuler(annotationModel, "left", {styleClass: "ruler lines"}, {styleClass: "rulerLines odd"}, {styleClass: "rulerLines even"}); //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		}
	};
	exports.LineNumberRulerFactory = LineNumberRulerFactory;
	
	function FoldingRulerFactory() {
	}
	FoldingRulerFactory.prototype = {
		createFoldingRuler: function(annotationModel) {
			return new mRulers.FoldingRuler(annotationModel, "left", {styleClass: "ruler folding"}); //$NON-NLS-1$ //$NON-NLS-0$
		}
	};
	exports.FoldingRulerFactory = FoldingRulerFactory;
	
	function ZoomRulerFactory() {
	}
	ZoomRulerFactory.prototype = {
		createZoomRuler: function(annotationModel) {
			return new mRulers.ZoomRuler(util.isIOS || util.isAndroid ? "right" : "innerRight", {styleClass: "ruler zoom"}); //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		}
	};
	exports.ZoomRulerFactory = ZoomRulerFactory;
	
	function AnnotationFactory() {
	}
	AnnotationFactory.prototype = {
		createAnnotationModel: function(model) {
			return new mAnnotations.AnnotationModel(model);
		},
		createAnnotationStyler: function(annotationModel, view) {
			return new mAnnotations.AnnotationStyler(annotationModel, view);
		},
		createAnnotationRulers: function(annotationModel) {
			var annotationRuler = new mRulers.AnnotationRuler(annotationModel, "left", {styleClass: "ruler annotations"}); //$NON-NLS-1$ //$NON-NLS-0$
			var overviewRuler = new mRulers.OverviewRuler(annotationModel, "right", {styleClass: "ruler overview"}); //$NON-NLS-1$ //$NON-NLS-0$
			return {annotationRuler: annotationRuler, overviewRuler: overviewRuler};
		}
	};
	exports.AnnotationFactory = AnnotationFactory;
	
	function TextDNDFactory() {
	}
	TextDNDFactory.prototype = {
		createTextDND: function(editor, undoStack) {
			return new mTextDND.TextDND(editor.getTextView(), undoStack);
		}
	};
	exports.TextDNDFactory = TextDNDFactory;
	
	return exports;
});