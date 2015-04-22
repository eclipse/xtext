/*******************************************************************************
 * @license
 * Copyright (c) 2010, 2012 IBM Corporation and others.
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
define("orion/editor/projectionTextModel", ['orion/editor/textModel', 'orion/editor/eventTarget'], function(mTextModel, mEventTarget) { //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$

	/**
	 * @class This object represents a projection range. A projection specifies a
	 * range of text and the replacement text. The range of text is relative to the
	 * base text model associated to a projection model.
	 * <p>
	 * <b>See:</b><br/>
	 * {@link orion.editor.ProjectionTextModel}<br/>
	 * {@link orion.editor.ProjectionTextModel#addProjection}<br/>
	 * </p>		 
	 * @name orion.editor.Projection
	 * 
	 * @property {Number} start The start offset of the projection range. 
	 * @property {Number} end The end offset of the projection range. This offset is exclusive.
	 * @property {String|orion.editor.TextModel} [text=""] The projection text to be inserted
	 */
	/**
	 * Constructs a new <code>ProjectionTextModel</code> based on the specified <code>TextModel</code>.
	 *
	 * @param {orion.editor.TextModel} baseModel The base text model.
	 *
	 * @name orion.editor.ProjectionTextModel
	 * @class The <code>ProjectionTextModel</code> represents a projection of its base text
	 * model. Projection ranges can be added to the projection text model to hide and/or insert
	 * ranges to the base text model.
	 * <p>
	 * The contents of the projection text model is modified when changes occur in the base model,
	 * projection model or by calls to {@link #addProjection} and {@link #removeProjection}.
	 * </p>
	 * <p>
	 * <b>See:</b><br/>
	 * {@link orion.editor.TextView}<br/>
	 * {@link orion.editor.TextModel}
	 * {@link orion.editor.TextView#setModel}
	 * </p>
	 * @borrows orion.editor.EventTarget#addEventListener as #addEventListener
	 * @borrows orion.editor.EventTarget#removeEventListener as #removeEventListener
	 * @borrows orion.editor.EventTarget#dispatchEvent as #dispatchEvent
	 */
	function ProjectionTextModel(baseModel) {
		this._model = baseModel;
		this._projections = [];
		var self = this;
		this._listener = {
			onChanged: function(e) {
				self._onChanged(e);
			},
			onChanging: function(e) {
				self._onChanging(e);
			}
		};
		baseModel.addEventListener("postChanged", this._listener.onChanged); //$NON-NLS-0$
		baseModel.addEventListener("preChanging", this._listener.onChanging); //$NON-NLS-0$
	}

	ProjectionTextModel.prototype = /** @lends orion.editor.ProjectionTextModel.prototype */ {
		/**
		 * Destroys this projection text model.
		 */
		destroy: function() {
			if (this._model) {
				this._model.removeEventListener("postChanged", this._listener.onChanged); //$NON-NLS-0$
				this._model.removeEventListener("preChanging", this._listener.onChanging); //$NON-NLS-0$
				this._model = null;
			}
		},
		/**
		 * Adds a projection range to the model.
		 * <p>
		 * The model must notify the listeners before and after the the text is
		 * changed by calling {@link #onChanging} and {@link #onChanged} respectively. 
		 * </p>
		 * @param {orion.editor.Projection} projection The projection range to be added.
		 * 
		 * @see orion.editor.ProjectionTextModel#removeProjection
		 */
		addProjection: function(projection) {
			if (!projection) {return;}
			//start and end can't overlap any exist projection
			var model = this._model, projections = this._projections;
			projection._lineIndex = model.getLineAtOffset(projection.start);
			projection._lineCount = model.getLineAtOffset(projection.end) - projection._lineIndex;
			var text = projection.text;
			if (!text) { text = ""; }
			if (typeof text === "string") { //$NON-NLS-0$
				projection._model = new mTextModel.TextModel(text, model.getLineDelimiter());
			} else {
				projection._model = text;
			}
			var eventStart = this.mapOffset(projection.start, true);
			var removedCharCount = projection.end - projection.start;
			var removedLineCount = projection._lineCount;
			var addedCharCount = projection._model.getCharCount();
			var addedLineCount = projection._model.getLineCount() - 1;
			var modelChangingEvent = {
				type: "Changing", //$NON-NLS-0$
				text: projection._model.getText(),
				start: eventStart,
				removedCharCount: removedCharCount,
				addedCharCount: addedCharCount,
				removedLineCount: removedLineCount,
				addedLineCount: addedLineCount
			};
			this.onChanging(modelChangingEvent);
			var index = this._binarySearch(projections, projection.start);
			projections.splice(index, 0, projection);
			var modelChangedEvent = {
				type: "Changed", //$NON-NLS-0$
				start: eventStart,
				removedCharCount: removedCharCount,
				addedCharCount: addedCharCount,
				removedLineCount: removedLineCount,
				addedLineCount: addedLineCount
			};
			this.onChanged(modelChangedEvent);
		},
		/**
		 * Returns all projection ranges of this model.
		 * 
		 * @return {orion.editor.Projection[]} The projection ranges.
		 * 
		 * @see orion.editor.ProjectionTextModel#addProjection
		 */
		getProjections: function() {
			return this._projections.slice(0);
		},
		/**
		 * Gets the base text model.
		 *
		 * @return {orion.editor.TextModel} The base text model.
		 */
		getBaseModel: function() {
			return this._model;
		},
		/**
		 * Maps offsets between the projection model and its base model.
		 *
		 * @param {Number} offset The offset to be mapped.
		 * @param {Boolean} [baseOffset=false] <code>true</code> if <code>offset</code> is in base model and
		 *	should be mapped to the projection model.
		 * @return {Number} The mapped offset
		 */
		mapOffset: function(offset, baseOffset) {
			var projections = this._projections, delta = 0, i, projection;
			if (baseOffset) {
				for (i = 0; i < projections.length; i++) {
					projection = projections[i];
					if (projection.start > offset) { break; }
					if (projection.end > offset) { return -1; }
					delta += projection._model.getCharCount() - (projection.end - projection.start);
				}
				return offset + delta;
			}
			for (i = 0; i < projections.length; i++) {
				projection = projections[i];
				if (projection.start > offset - delta) { break; }
				var charCount = projection._model.getCharCount();
				if (projection.start + charCount > offset - delta) {
					return -1;
				}
				delta += charCount - (projection.end - projection.start);
			}
			return offset - delta;
		},
		/**
		 * Removes a projection range from the model.
		 * <p>
		 * The model must notify the listeners before and after the the text is
		 * changed by calling {@link #onChanging} and {@link #onChanged} respectively. 
		 * </p>
		 * 
		 * @param {orion.editor.Projection} projection The projection range to be removed.
		 * 
		 * @see orion.editor.ProjectionTextModel#addProjection
		 */
		removeProjection: function(projection) {
			this._removeProjection(projection);
		},
		_removeProjection: function(projection, noEvents) {
			var i, delta = 0;
			for (i = 0; i < this._projections.length; i++) {
				var p = this._projections[i];
				if (p === projection) {
					projection = p;
					break;
				}
				delta += p._model.getCharCount() - (p.end - p.start);
			}
			if (i < this._projections.length) {
				var model = this._model;
				var eventStart = projection.start + delta;
				var addedCharCount = projection.end - projection.start;
				var addedLineCount = projection._lineCount;
				var removedCharCount = projection._model.getCharCount();
				var removedLineCount = projection._model.getLineCount() - 1;
				if (!noEvents) {
					var modelChangingEvent = {
						type: "Changing", //$NON-NLS-0$
						text: model.getText(projection.start, projection.end),
						start: eventStart,
						removedCharCount: removedCharCount,
						addedCharCount: addedCharCount,
						removedLineCount: removedLineCount,
						addedLineCount: addedLineCount
					};
					this.onChanging(modelChangingEvent);
				}
				this._projections.splice(i, 1);
				if (!noEvents) {
					var modelChangedEvent = {
						type: "Changed", //$NON-NLS-0$
						start: eventStart,
						removedCharCount: removedCharCount,
						addedCharCount: addedCharCount,
						removedLineCount: removedLineCount,
						addedLineCount: addedLineCount
					};
					this.onChanged(modelChangedEvent);
				}
			}
		},
		/** @ignore */
		_binarySearch: function (array, offset) {
			var high = array.length, low = -1, index;
			while (high - low > 1) {
				index = Math.floor((high + low) / 2);
				if (offset <= array[index].start) {
					high = index;
				} else {
					low = index;
				}
			}
			return high;
		},
		/**
		 * @see orion.editor.TextModel#getCharCount
		 */
		getCharCount: function() {
			var count = this._model.getCharCount(), projections = this._projections;
			for (var i = 0; i < projections.length; i++) {
				var projection = projections[i];
				count += projection._model.getCharCount() - (projection.end - projection.start);
			}
			return count;
		},
		/**
		 * @see orion.editor.TextModel#getLine
		 */
		getLine: function(lineIndex, includeDelimiter) {
			if (lineIndex < 0) { return null; }
			var model = this._model, projections = this._projections;
			var delta = 0, result = [], offset = 0, i, lineCount, projection;
			for (i = 0; i < projections.length; i++) {
				projection = projections[i];
				if (projection._lineIndex >= lineIndex - delta) { break; }
				lineCount = projection._model.getLineCount() - 1;
				if (projection._lineIndex + lineCount >= lineIndex - delta) {
					var projectionLineIndex = lineIndex - (projection._lineIndex + delta);
					if (projectionLineIndex < lineCount) {
						return projection._model.getLine(projectionLineIndex, includeDelimiter);
					} else {
						result.push(projection._model.getLine(lineCount));
					}
				}
				offset = projection.end;
				delta += lineCount - projection._lineCount;
			}
			offset = Math.max(offset, model.getLineStart(lineIndex - delta));
			for (; i < projections.length; i++) {
				projection = projections[i];
				if (projection._lineIndex > lineIndex - delta) { break; }
				result.push(model.getText(offset, projection.start));
				lineCount = projection._model.getLineCount() - 1;
				if (projection._lineIndex + lineCount > lineIndex - delta) {
					result.push(projection._model.getLine(0, includeDelimiter));
					return result.join("");
				}
				result.push(projection._model.getText());
				offset = projection.end;
				delta += lineCount - projection._lineCount;
			}
			var end = model.getLineEnd(lineIndex - delta, includeDelimiter);
			if (offset < end) {
				result.push(model.getText(offset, end));
			}
			return result.join("");
		},
		/**
		 * @see orion.editor.TextModel#getLineAtOffset
		 */
		getLineAtOffset: function(offset) {
			var model = this._model, projections = this._projections;
			var delta = 0, lineDelta = 0;
			for (var i = 0; i < projections.length; i++) {
				var projection = projections[i];
				if (projection.start > offset - delta) { break; }
				var charCount = projection._model.getCharCount();
				if (projection.start + charCount > offset - delta) {
					var projectionOffset = offset - (projection.start + delta);
					lineDelta += projection._model.getLineAtOffset(projectionOffset);
					delta += projectionOffset;
					break;
				}
				lineDelta += projection._model.getLineCount() - 1 - projection._lineCount;
				delta += charCount - (projection.end - projection.start);
			}
			return model.getLineAtOffset(offset - delta) + lineDelta;
		},
		/**
		 * @see orion.editor.TextModel#getLineCount
		 */
		getLineCount: function() {
			var model = this._model, projections = this._projections;
			var count = model.getLineCount();
			for (var i = 0; i < projections.length; i++) {
				var projection = projections[i];
				count += projection._model.getLineCount() - 1 - projection._lineCount;
			}
			return count;
		},
		/**
		 * @see orion.editor.TextModel#getLineDelimiter
		 */
		getLineDelimiter: function() {
			return this._model.getLineDelimiter();
		},
		/**
		 * @see orion.editor.TextModel#getLineEnd
		 */
		getLineEnd: function(lineIndex, includeDelimiter) {
			if (lineIndex < 0) { return -1; }
			var model = this._model, projections = this._projections;
			var delta = 0, offsetDelta = 0;
			for (var i = 0; i < projections.length; i++) {
				var projection = projections[i];
				if (projection._lineIndex > lineIndex - delta) { break; }
				var lineCount = projection._model.getLineCount() - 1;
				if (projection._lineIndex + lineCount > lineIndex - delta) {
					var projectionLineIndex = lineIndex - (projection._lineIndex + delta);
					return projection._model.getLineEnd (projectionLineIndex, includeDelimiter) + projection.start + offsetDelta;
				}
				offsetDelta += projection._model.getCharCount() - (projection.end - projection.start);
				delta += lineCount - projection._lineCount;
			}
			return model.getLineEnd(lineIndex - delta, includeDelimiter) + offsetDelta;
		},
		/**
		 * @see orion.editor.TextModel#getLineStart
		 */
		getLineStart: function(lineIndex) {
			if (lineIndex < 0) { return -1; }
			var model = this._model, projections = this._projections;
			var delta = 0, offsetDelta = 0;
			for (var i = 0; i < projections.length; i++) {
				var projection = projections[i];
				if (projection._lineIndex >= lineIndex - delta) { break; }
				var lineCount = projection._model.getLineCount() - 1;
				if (projection._lineIndex + lineCount >= lineIndex - delta) {
					var projectionLineIndex = lineIndex - (projection._lineIndex + delta);
					return projection._model.getLineStart (projectionLineIndex) + projection.start + offsetDelta;
				}
				offsetDelta += projection._model.getCharCount() - (projection.end - projection.start);
				delta += lineCount - projection._lineCount;
			}
			return model.getLineStart(lineIndex - delta) + offsetDelta;
		},
		/**
		 * @see orion.editor.TextModel#getText
		 */
		getText: function(start, end) {
			if (start === undefined) { start = 0; }
			var model = this._model, projections = this._projections;
			var delta = 0, result = [], i, projection, charCount;
			for (i = 0; i < projections.length; i++) {
				projection = projections[i];
				if (projection.start > start - delta) { break; }
				charCount = projection._model.getCharCount();
				if (projection.start + charCount > start - delta) {
					if (end !== undefined && projection.start + charCount > end - delta) {
						return projection._model.getText(start - (projection.start + delta), end - (projection.start + delta));
					} else {
						result.push(projection._model.getText(start - (projection.start + delta)));
						start = projection.end + delta + charCount - (projection.end - projection.start);
					}
				}
				delta += charCount - (projection.end - projection.start);
			}
			var offset = start - delta;
			if (end !== undefined) {
				for (; i < projections.length; i++) {
					projection = projections[i];
					if (projection.start > end - delta) { break; }
					result.push(model.getText(offset, projection.start));
					charCount = projection._model.getCharCount();
					if (projection.start + charCount > end - delta) {
						result.push(projection._model.getText(0, end - (projection.start + delta)));
						return result.join("");
					}
					result.push(projection._model.getText());
					offset = projection.end;
					delta += charCount - (projection.end - projection.start);
				}
				result.push(model.getText(offset, end - delta));
			} else {
				for (; i < projections.length; i++) {
					projection = projections[i];
					result.push(model.getText(offset, projection.start));
					result.push(projection._model.getText());
					offset = projection.end;
				}
				result.push(model.getText(offset));
			}
			return result.join("");
		},
		/** @ignore */
		_onChanged: function(modelChangedEvent) {
			var change = this._change;
			var start = change.baseStart, end = change.baseEnd, i;
			var projection, projections = this._projections;
			for (i = 0; i < projections.length; i++) {
				projection = projections[i];
				if (projection.end > start) { break; }
			}
			var rangeStart = i;
			for (i = 0; i < projections.length; i++) {
				projection = projections[i];
				if (projection.start >= end) { break; }
			}
			var rangeEnd = i;
			var model = this._model;
			var changeCount = change.baseText.length - (end - start);
			for (i = rangeEnd; i < projections.length; i++) {
				projection = projections[i];
				projection.start += changeCount;
				projection.end += changeCount;
				projection._lineIndex = model.getLineAtOffset(projection.start);
			}
			var removed = projections.splice(rangeStart, rangeEnd - rangeStart);
			for (i = 0; i < removed.length; i++) {
				if (removed[i].annotation) {
					removed[i].annotation._expand();
				}
			}
			var modelChangedEvent1 = {
				type: "Changed", //$NON-NLS-0$
				start: change.start,
				removedCharCount: change.removedCharCount,
				addedCharCount: change.addedCharCount,
				removedLineCount: change.removedLineCount,
				addedLineCount: change.addedLineCount
			};
			this.onChanged(modelChangedEvent1);
			this._change = undefined;
		},
		_onChanging: function(modelChangingEvent) {
			var hasChange = !!this._change;
			var change = this._change || {};
			var start = modelChangingEvent.start, end = start + modelChangingEvent.removedCharCount;
			change.baseStart = start;
			change.baseEnd = end;
			change.baseText = modelChangingEvent.text;
			change.addedLineCount = modelChangingEvent.addedLineCount;
			if (!hasChange) {
				this._change = change;
				change.text = modelChangingEvent.text;
				var projections = this._projections, delta, i, projection;
				function mapOffset(offset) {
					for (i = 0, delta = 0; i < projections.length; i++) {
						projection = projections[i];
						if (projection.start > offset) { break; }
						if (projection.end > offset) { return -1; }
						delta += projection._model.getCharCount() - (projection.end - projection.start);
					}
					return offset + delta;
				}
				change.start = mapOffset(start);
				if (change.start === -1) {
					change.text = this._model.getText(projection.start, start) + change.text;
					change.addedLineCount += this._model.getLineAtOffset(start) - this._model.getLineAtOffset(projection.start);
					change.start = projection.start + delta;
				}
				change.end = mapOffset(end);
				if (change.end === -1) {
					change.text += this._model.getText(end, projection.end);
					change.addedLineCount += this._model.getLineAtOffset(projection.end) - this._model.getLineAtOffset(end);
					change.end = projection.start + delta;
				}
			}
			change.addedCharCount = change.text.length;
			change.removedCharCount = change.end - change.start;
			change.removedLineCount = this.getLineAtOffset(change.end) - this.getLineAtOffset(change.start);
			var modelChangingEvent1 = {
				type: "Changing", //$NON-NLS-0$
				text: change.text,
				start: change.start,
				removedCharCount: change.removedCharCount,
				addedCharCount: change.addedCharCount,
				removedLineCount: change.removedLineCount,
				addedLineCount: change.addedLineCount
			};
			this.onChanging(modelChangingEvent1);
		},
		/**
		 * @see orion.editor.TextModel#onChanging
		 */
		onChanging: function(modelChangingEvent) {
			return this.dispatchEvent(modelChangingEvent);
		},
		/**
		 * @see orion.editor.TextModel#onChanged
		 */
		onChanged: function(modelChangedEvent) {
			return this.dispatchEvent(modelChangedEvent);
		},
		/**
		 * @see orion.editor.TextModel#setLineDelimiter
		 */
		setLineDelimiter: function(lineDelimiter) {
			this._model.setLineDelimiter(lineDelimiter);
		},
		/**
		 * @see orion.editor.TextModel#setText
		 */
		setText: function(text, start, end) {
			this._change = {
				text: text || "",
				start: start || 0,
				end: end === undefined ? this.getCharCount() : end
			};
			var projections = this._projections, delta, i, projection;
			function mapOffset(offset) {
				for (i = 0, delta = 0; i < projections.length; i++) {
					projection = projections[i];
					if (projection.start > offset - delta) { break; }
					var charCount = projection._model.getCharCount();
					if (projection.start + charCount > offset - delta) {
						return -1;
					}
					delta += charCount - (projection.end - projection.start);
				}
				return offset - delta;
			}
			var startProjection, endProjection;
			var mapStart = mapOffset(this._change.start);
			if (mapStart === -1) {
				startProjection = {
					projection: projection,
					start: this._change.start - (projection.start + delta)
				};
				mapStart = projection.end;
			}
			var mapEnd = mapOffset(this._change.end);
			if (mapEnd === -1) {
				endProjection = {
					projection: projection,
					end: this._change.end - (projection.start + delta)
				};
				mapEnd = projection.start;
			}
			if (startProjection && endProjection && startProjection.projection === endProjection.projection) {
				//TODO events - special case - change is completely inside of a projection
				projection._model.setText(this._change.text, startProjection.start, endProjection.end);
			} else {
				this._model.setText(this._change.text, mapStart, mapEnd);
				if (startProjection) {
					projection = startProjection.projection;
					projection._model.setText("", startProjection.start);
				}		
				if (endProjection) {
					projection = endProjection.projection;
					projection._model.setText("", 0, endProjection.end);
					projection.start = projection.end;
					projection._lineCount = 0;
				}
			}
			this._change = undefined;
		}
	};
	mEventTarget.EventTarget.addMixin(ProjectionTextModel.prototype);

	return {ProjectionTextModel: ProjectionTextModel};
});
