/*******************************************************************************
 * @license
 * Copyright (c) 2015 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html). 
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
/* eslint-env amd */
define([
'orion/objects',
'orion/Deferred'
], function(Objects, Deferred) {
    
    /**
     * @name CompilationUnit
     * @description Creates a new CompilationUint instance. These instances should not be cached as they do
     * not respond to model change events.
     * @constructor 
     * @param {Array.<String>} sourceblocks The blocks of source to combine into one unit
     * @param {Object} metadata The metadata describing the file this unit represents
     * @param {Object} editorContext The original editor context that can be delegated to for setting the text 
     * @returns {CompilationUnit} The new CompiationUnit instance
     * @since 8.0
     */
    function CompilationUnit(sourceblocks, metadata, editorContext) {
        this._blocks = sourceblocks;
        this._metadata = metadata;
        this._ec = editorContext;
    }
    
    Objects.mixin(CompilationUnit.prototype, {
        
        /**
         * @description Builds the backing source for the compilation unit
         * @function
         * @private
         */
        _init: function _init() {
            var _cursor = 0;
            this._source = '';
            for(var i = 0; i < this._blocks.length; i++) {
                var block = this._blocks[i];
                var pad = block.offset - _cursor;
                while(pad > 0) {
                    this._source += ' ';
                    pad--;
                }
                this._source += block.text;
                _cursor = this._source.length;
            }
        },
        
        /**
         * @description Returns the source of this compilation unit
         * @function
         * @returns {String} The source of the compilation unit
         */
        getSource: function getSource() {
            return this._source;
        },
        
        /**
         * @description Returns if the given offset is valid compared to the blocks of code
         * that make up this unit
         * @function
         * @param {Number} offset The offset to check
         * @returns {Boolean} If the given offset is within any of the backing code blocks
         */
        validOffset: function validOffset(offset) {
            if(!this._blocks || this._blocks.length < 1 || offset < 0) {
		        return false;
		    }
		    for(var i = 0; i < this._blocks.length; i++) {
		        var block = this._blocks[i];
		        var idx = block.offset;
		        if(offset >= idx && offset <= idx+block.text.length) {
		            return true;
		        }
		    }
		    return false;
        },    
    
        /**
         * @description Returns an EditorContext-like object tat can resolve promises for <code>getText</code> and <code>getFileMetadata</code>
         * @function
         * @returns {Object} The EditorContext object to use when parsing
         */
        getEditorContext: function getEditorContext() {
            var proxy = Object.create(null);
            var that = this;
            proxy.getText = function() {
                if(!that._source) {
                    that._init();
                }
                return new Deferred().resolve(that._source);
            };
            proxy.getFileMetadata = function() {
                return new Deferred().resolve(that._metadata);
            };
            proxy.setText = function(text, start, end) {
                if(that._ec) {
                    return that._ec.setText(text, start, end);
                } else {
                    return new Deferred().resolve(null);
                }
            };
            return proxy;
        }
    });
    
    return CompilationUnit;
});