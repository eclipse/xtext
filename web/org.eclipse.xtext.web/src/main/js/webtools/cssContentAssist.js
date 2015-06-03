/*******************************************************************************
 * @license
 * Copyright (c) 2011, 2015 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html). 
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
/*eslint-env browser, amd*/
define("webtools/cssContentAssist", [ //$NON-NLS-0$
	'orion/editor/templates', //$NON-NLS-0$
	'orion/editor/stylers/text_css/syntax', //$NON-NLS-0$
	'orion/objects',
	'webtools/util',
	'javascript/compilationUnit',
	'csslint'
], function(mTemplates, mCSS, Objects, Util, CU, CSSLint) {

	var overflowValues = {
		type: "link", //$NON-NLS-0$
		values: ["visible", "hidden", "scroll", "auto", "no-display", "no-content"] //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	};
	var fontStyleValues = {
		type: "link", //$NON-NLS-0$
		values: ["italic", "normal", "oblique", "inherit"] //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	};
	var fontWeightValues = {
		type: "link", //$NON-NLS-0$
		values: [
			"bold", "normal", "bolder", "lighter", //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
			"100", "200", "300", "400", "500", "600", //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
			"700", "800", "900", "inherit" //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		]
	};
	var displayValues = {
		type: "link", //$NON-NLS-0$
		values: [
			"none", "block", "box", "flex", "inline", "inline-block", "inline-flex", "inline-table", //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
			"list-item", "table", "table-caption", "table-cell", "table-column", "table-column-group", //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
			"table-footer-group", "table-header-group", "table-row", "table-row-group", "inherit" //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		]
	};
	var visibilityValues = {
		type: "link", //$NON-NLS-0$
		values: ["hidden", "visible", "collapse", "inherit"] //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	};
	var positionValues = {
		type: "link", //$NON-NLS-0$
		values: ["absolute", "fixed", "relative", "static", "inherit"] //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	};
	var whitespaceValues = {
		type: "link", //$NON-NLS-0$
		values: ["pre", "pre-line", "pre-wrap", "nowrap", "normal", "inherit"] //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	};
	var wordwrapValues = {
		type: "link", //$NON-NLS-0$
		values: ["normal", "break-word"] //$NON-NLS-1$ //$NON-NLS-0$
	};
	var floatValues = {
		type: "link", //$NON-NLS-0$
		values: ["left", "right", "none", "inherit"] //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	};
	var borderStyles = {
		type: "link", //$NON-NLS-0$
		values: ["solid", "dashed", "dotted", "double", "groove", "ridge", "inset", "outset"] //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	};
	var widths = {
		type: "link", //$NON-NLS-0$
		values: []
	};
	widths.values.push('0'); //$NON-NLS-0$
	for (var i=1; i<10; i++) {
		widths.values.push(i.toString() + 'px'); //$NON-NLS-0$
	}
	var colorValues = {
		type: "link", //$NON-NLS-0$
		values: Object.keys(CSSLint.Colors)
	};
	var cursorValues = {
		type: "link", //$NON-NLS-0$
		values: [
			"auto", //$NON-NLS-0$
			"crosshair", //$NON-NLS-0$
			"default", //$NON-NLS-0$
			"e-resize", //$NON-NLS-0$
			"help", //$NON-NLS-0$
			"move", //$NON-NLS-0$
			"n-resize", //$NON-NLS-0$
			"ne-resize", //$NON-NLS-0$
			"nw-resize", //$NON-NLS-0$
			"pointer", //$NON-NLS-0$
			"progress", //$NON-NLS-0$
			"s-resize", //$NON-NLS-0$
			"se-resize", //$NON-NLS-0$
			"sw-resize", //$NON-NLS-0$
			"text", //$NON-NLS-0$
			"w-resize", //$NON-NLS-0$
			"wait", //$NON-NLS-0$
			"inherit" //$NON-NLS-0$
		]
	};
	var csslintRules = {
		type: "link", //$NON-NLS-0$
		values: [
			"adjoining-classes", //$NON-NLS-0$
			"box-model", //$NON-NLS-0$
			"box-sizing", //$NON-NLS-0$
			"bulletproof-font-face", //$NON-NLS-0$
			"compatible-vendor-prefixes", //$NON-NLS-0$
			"display-property-grouping", //$NON-NLS-0$
			"duplicate-background-images", //$NON-NLS-0$
			"duplicate-properties", //$NON-NLS-0$
			"empty-rules", //$NON-NLS-0$
			"fallback-colors", //$NON-NLS-0$
			"floats", //$NON-NLS-0$
			"font-faces", //$NON-NLS-0$
			"font-sizes", //$NON-NLS-0$
			"gradients", //$NON-NLS-0$
			"ids", //$NON-NLS-0$
			"import", //$NON-NLS-0$
			"important", //$NON-NLS-0$
			"known-properties", //$NON-NLS-0$
			"outline-none", //$NON-NLS-0$
			"overqualified-elements", //$NON-NLS-0$
			"qualified-headings", //$NON-NLS-0$
			"regex-selectors", //$NON-NLS-0$
			"rules-count", //$NON-NLS-0$
			"selector-max-approaching", //$NON-NLS-0$
			"selector-max", //$NON-NLS-0$
			"shorthand", //$NON-NLS-0$
			"star-property-hack", //$NON-NLS-0$
			"text-indent", //$NON-NLS-0$
			"underscore-property-hack", //$NON-NLS-0$
			"unique-headings", //$NON-NLS-0$
			"universal-selector", //$NON-NLS-0$
			"unqualified-attributes", //$NON-NLS-0$
			"vendor-prefix", //$NON-NLS-0$
			"zero-units" //$NON-NLS-0$
		],
	};
	var severityValues = {
		type: "link", //$NON-NLS-0$
		values: [
			"false", //$NON-NLS-0$
			"true", //$NON-NLS-0$
			"0", //$NON-NLS-0$
			"1", //$NON-NLS-0$
			"2" //$NON-NLS-0$
		]
	};
	
	function fromJSON(o) {
		return JSON.stringify(o).replace("}", "\\}"); //$NON-NLS-1$ //$NON-NLS-0$
	}
	
	var templates = [
		{
			prefix: "rule", //$NON-NLS-0$
			description: "rule - class selector rule",
			template: ".${class} {\n\t${cursor}\n}" //$NON-NLS-0$
		},
		{
			prefix: "rule", //$NON-NLS-0$
			description: "rule - id selector rule",
			template: "#${id} {\n\t${cursor}\n}" //$NON-NLS-0$
		},
		{
			prefix: "outline", //$NON-NLS-0$
			description: "outline - outline style",
			template: "outline: ${color:" + fromJSON(colorValues) + "} ${style:" + fromJSON(borderStyles) + "} ${width:" + fromJSON(widths) + "};" //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		},
		{
			prefix: "background-image", //$NON-NLS-0$
			description: "background-image - image style",
			template: "background-image: url(\"${uri}\");" //$NON-NLS-0$
		},
		{
			prefix: "url", //$NON-NLS-0$
			description: "url - url image",
			template: "url(\"${uri}\");" //$NON-NLS-0$
		},
		{
			prefix: "rgb", //$NON-NLS-0$
			description: "rgb - rgb color",
			template: "rgb(${red},${green},${blue});" //$NON-NLS-0$
		},
		{
			prefix: "@import", //$NON-NLS-0$
			description: "import - import style sheet",
			template: "@import \"${uri}\";" //$NON-NLS-0$
		},
		{
			prefix: "csslint", //$NON-NLS-0$
			description: "csslint - add embedded rule severity", //$NON-NLS-0$
			template: "\/*csslint ${:" + fromJSON(csslintRules) + "}: ${a:" + fromJSON(severityValues) + "} *\/" //$NON-NLS-0$  // Template suggestions use colon location to separate positions making the 'a' necessary
		}
	];
	
	var valuesProperties = [
		{prop: "display", values: displayValues}, //$NON-NLS-0$
		{prop: "overflow", values: overflowValues}, //$NON-NLS-0$
		{prop: "overflow-x", values: overflowValues}, //$NON-NLS-0$
		{prop: "overflow-y", values: overflowValues}, //$NON-NLS-0$
		{prop: "float", values: floatValues}, //$NON-NLS-0$
		{prop: "position", values: positionValues}, //$NON-NLS-0$
		{prop: "cursor", values: cursorValues}, //$NON-NLS-0$
		{prop: "color", values: colorValues}, //$NON-NLS-0$
		{prop: "border-top-color", values: colorValues}, //$NON-NLS-0$
		{prop: "border-bottom-color", values: colorValues}, //$NON-NLS-0$
		{prop: "border-right-color", values: colorValues}, //$NON-NLS-0$
		{prop: "border-left-color", values: colorValues}, //$NON-NLS-0$
		{prop: "background-color", values: colorValues}, //$NON-NLS-0$
		{prop: "font-style", values: fontStyleValues}, //$NON-NLS-0$
		{prop: "font-weight", values: fontWeightValues}, //$NON-NLS-0$
		{prop: "white-space", values: whitespaceValues}, //$NON-NLS-0$
		{prop: "word-wrap", values: wordwrapValues}, //$NON-NLS-0$
		{prop: "visibility", values: visibilityValues} //$NON-NLS-0$
	];
	var prop;
	for (i=0; i<valuesProperties.length; i++) {
		prop = valuesProperties[i];
		templates.push({
			prefix: prop.prop, //$NON-NLS-0$
			description: prop.prop + " - " + prop.prop + " style",
			template: prop.prop + ": ${value:" + fromJSON(prop.values) + "};" //$NON-NLS-1$ //$NON-NLS-0$
		});
	}	
	var pixelProperties = [
		"width", "height", "top", "bottom", "left", "right", //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"min-width", "min-height", "max-width", "max-height", //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"margin", "padding", "padding-left", "padding-right", //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"padding-top", "padding-bottom", "margin-left", "margin-top", //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		"margin-bottom", "margin-right" //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	];
	for (i=0; i<pixelProperties.length; i++) {
		prop = pixelProperties[i];
		templates.push({
			prefix: prop, //$NON-NLS-0$
			description: prop + " - " + prop + " pixel style",
			template: prop  + ": ${value}px;" //$NON-NLS-0$
		});
	}
	var fourWidthsProperties = ["padding", "margin"]; //$NON-NLS-1$ //$NON-NLS-0$
	for (i=0; i<fourWidthsProperties.length; i++) {
		prop = fourWidthsProperties[i];
		templates.push({
			prefix: prop, //$NON-NLS-0$
			description: prop + " - " + prop + " top right bottom left style",
			template: prop  + ": ${top}px ${left}px ${bottom}px ${right}px;" //$NON-NLS-0$
		});
		templates.push({
			prefix: prop, //$NON-NLS-0$
			description: prop + " - " + prop + " top right,left bottom style",
			template: prop  + ": ${top}px ${right_left}px ${bottom}px;" //$NON-NLS-0$
		});
		templates.push({
			prefix: prop, //$NON-NLS-0$
			description: prop + " - " + prop + " top,bottom right,left style",
			template: prop  + ": ${top_bottom}px ${right_left}px" //$NON-NLS-0$
		});
	}
	var borderProperties = ["border", "border-top", "border-bottom", "border-left", "border-right"]; //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
	for (i=0; i<borderProperties.length; i++) {
		prop = borderProperties[i];
		templates.push({
			prefix: prop, //$NON-NLS-0$
			description: prop + " - " + prop + " style",
			template: prop + ": ${width:" + fromJSON(widths) + "} ${style:" + fromJSON(borderStyles) + "} ${color:" + fromJSON(colorValues) + "};" //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
		});
	}

	/**
	 * @name orion.editor.CssContentAssistProvider
	 * @class Provides content assist for CSS keywords.
	 * @param {CssResultManager} resultManager The backing reult manager
	 */
	function CssContentAssistProvider(resultManager) {
	    this._resultManager = resultManager;
	}
	var templateAssist = new mTemplates.TemplateContentAssist(mCSS.keywords, templates);
	
	Objects.mixin(CssContentAssistProvider.prototype, {
	   /**
	    * @callback
	    */
	   getPrefix: function getPrefix(buffer, offset, context) {
	       var index = offset;
    		while (index && /[A-Za-z\-\@]/.test(buffer.charAt(index - 1))) {
    			index--;
    		}
    		return index >= 0 ? buffer.substring(index, offset) : "";
        },
        /**
         * @callback
         * @since 8.0
         */
        computeContentAssist: function computeContentAssist(editorContext, params) {
            var that = this;
            return editorContext.getFileMetadata().then(function(meta) {
               if(meta.contentType.id === 'text/html') {
                  return editorContext.getText().then(function(text) {
                     var blocks = Util.findStyleBlocks(text, params.offset);
                     if(blocks && blocks.length > 0) {
                         var cu = new CU(blocks, meta);
                         return that._computeProposals(cu.getEditorContext(), text, params);
                     }
                  });
               } else {
                   return editorContext.getText().then(function(text) {
                      return that._computeProposals(editorContext, text, params);
                   });
               }
            });
        },
        
        /**
         * @description Computes the proposals from the given offset, also returns all keyword and template proposals
         * @since 8.0
         */
        _computeProposals: function _computeProposals(editorContext, buffer, context) {
            //TODO compute completion context
            return [].concat(templateAssist.computeProposals(buffer, context.offset, context));
        },
        
        /**
         * @description Computes the kind of completion we are attempting. For example 'color: <assist>' would return 'color'
         * @function
         * @private
         * @param {Object} context The completion contest from #computeProposals
         * @returns {String} The completion context or <code>null</code>
         * @since 8.0
         */
        _getCompletionContext: function _getCompletionContext(editorContext, context) {
            if(this._resultManager) {
                return this._resultManager.getResult(editorContext).then(function(results) {
                   if(results) {
                       var tok = Util.findToken(context.offset, results.tokens);
                       if(tok) {
                           switch(tok.type) {
                               case 'EOF': {
                                   if(results.tokens.length > 1) {
                                       //grab the token right before the EOF if there is one
                                       tok = results.tokens[results.tokens.length -2];
                                       if(tok) {
                                           return {prefix: tok.value, value: 'root'};
                                       }
                                   }
                               }
                           }
                       }
                   }
                   return null;
                });
            }
            return null;
        }
	});

	return {
		CssContentAssistProvider: CssContentAssistProvider
	};
});
