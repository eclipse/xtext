/*******************************************************************************
 * @license
 * Copyright (c) 2010, 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html). 
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ******************************************************************************/

/*eslint-env browser, amd*/
define("orion/editor/templates", [], function() { //$NON-NLS-0$

	/** 
	 * Removes prefix from string.
	 * @param {String} prefix
	 * @param {String} string
	 */
	function chop(prefix, string) {
		return string.substring(prefix.length);
	}
	
	var tabVar = "${tab}"; //$NON-NLS-0$
	var delimiterVar = "${delimiter}"; //$NON-NLS-0$
	var cursorVar = "${cursor}"; //$NON-NLS-0$
	
	function Template (prefix, description, template, name) {
		this.prefix = prefix;
		this.description = description;
		this.template = template;
		this.name = name;
		this._parse();
	}
	Template.prototype = /** @lends orion.editor.Template.prototype */ {
		getProposal: function(prefix, offset, context) {
			//any returned positions need to be offset based on current cursor position and length of prefix
			var startOffset = offset-prefix.length;
			var groups = {};
			var escapePosition;
			var delimiter = context.delimiter !== undefined ? context.delimiter : "\n"; //$NON-NLS-0$
			if (context.indentation) {
				delimiter += context.indentation;
			}
			var tab = context.tab !== undefined ? context.tab : "\t"; //$NON-NLS-0$
			var delta = 0;
			var variables = this.variables;
			var segments = this.segments, proposal = [];
			for (var i = 0; i < segments.length; i++) {
				var segment = segments[i];
				var variable = variables[segment];
				if (variable !== undefined) {
					switch (segment) {
						case tabVar:
							segment = tab;
							break;
						case delimiterVar:
							segment = delimiter;
							break;
						case cursorVar:
							segment = "";
							escapePosition = delta;
							break;
						default:
							var g = groups[segment];
							if (!g) {
								g = groups[segment] = {data: variable.data, positions: []};
							}
							segment = variable.substitution;
							if (g.data && g.data.values) { segment = g.data.values[0]; }
							g.positions.push({
								offset: startOffset + delta,
								length: segment.length
							});
					}
				}
				proposal.push(segment);
				delta += segment.length;
			}
			var newGroups = [];
			for (var p in groups) {
				if (groups.hasOwnProperty(p)) {
					newGroups.push(groups[p]);
				}
			}
			proposal = proposal.join("");
			if (escapePosition === undefined) {
				escapePosition = proposal.length;
			}
			return {
				proposal: proposal,
				name: this.name,
				description: this.description,
				groups: newGroups,
				escapePosition: startOffset + escapePosition,
				style: 'noemphasis'
			};
		},
		match: function(prefix) {
			return this.prefix.indexOf(prefix) === 0;
		},
		_parse: function() {
			var template = this.template;
			var segments = [], variables = {}, segment, start = 0;
			template = template.replace(/\n/g, delimiterVar);
			template = template.replace(/\t/g, tabVar);
			template.replace(/\$\{((?:[^\\}]+|\\.))*\}/g, function(group, text1, index) {
				var text = group.substring(2,group.length-1);
				var variable = group, substitution = text, data = null;
				var colon = substitution.indexOf(":"); //$NON-NLS-0$
				if (colon !== -1) {
					substitution = substitution.substring(0, colon);
					variable = "${"+ substitution + "}"; //$NON-NLS-1$ //$NON-NLS-0$
					data = JSON.parse(text.substring(colon + 1).replace("\\}", "}").trim()); //$NON-NLS-1$ //$NON-NLS-0$
				}
				var v = variables[variable];
				if (!v) { v = variables[variable] = {}; }
				v.substitution = substitution;
				if (data) {
					v.data = data;
				}
				segment = template.substring(start, index);
				if (segment) { segments.push(segment); }
				segments.push(variable);
				start = index + group.length;
				return substitution;
			});
			segment = template.substring(start, template.length);
			if (segment) { segments.push(segment); }
			this.segments = segments;
			this.variables = variables;
		}
	};
	
	function TemplateContentAssist (keywords, templates) {
		this._keywords = keywords || [];
		this._templates = [];
		this.addTemplates(templates || []);
	}
	TemplateContentAssist.prototype = /** @lends orion.editor.TemplateContentAssist.prototype */ {
		addTemplates: function(json) {
			var templates = this.getTemplates();
			for (var j = 0; j < json.length; j++) {
				templates.push(new Template(json[j].prefix, json[j].description, json[j].template, json[j].name));
			}
		},
		/**
		 * Called by the content assist engine to initialize this provider before any <tt>computeProposals()</tt> calls.
		 * This implementation does nothing; subclasses may override.
		 */
		initialize: function() {
		},
		computeProposals: function(buffer, offset, context) {
			var prefix = this.getPrefix(buffer, offset, context);
			var proposals = [];
			if (this.isValid(prefix, buffer, offset, context)) {
				proposals = proposals.concat(this.getTemplateProposals(prefix, offset, context));
				proposals = proposals.concat(this.getKeywordProposals(prefix));
			}
			return proposals;
		},
		getKeywords: function() {
			return this._keywords;
		},
		getKeywordProposals: function(prefix) {
			var proposals = [];
			var keywords = this.getKeywords();
			if (keywords) {
				for (var i = 0; i < keywords.length; i++) {
					if (keywords[i].indexOf(prefix) === 0) {
						proposals.push({proposal: chop(prefix, keywords[i]), 
							description: keywords[i], 
							style: 'noemphasis_keyword'//$NON-NLS-0$
						});
					}
				}
				
				if (0 < proposals.length) {
					proposals.splice(0, 0,{
						proposal: '',
						description: 'Keywords', //$NON-NLS-0$
						style: 'noemphasis_title_keywords', //$NON-NLS-0$
						unselectable: true
					});	
				}
			}
			return proposals;
		},
		getPrefix: function(buffer, offset, context) {
			return context.prefix;
		},
		getTemplates: function() {
			return this._templates;
		},
		getTemplateProposals: function(prefix, offset, context) {
			var proposals = [];
			var templates = this.getTemplates();
			for (var t = 0; t < templates.length; t++) {
				var template = templates[t];
				if (template.match(prefix)) {
					var proposal = template.getProposal(prefix, offset, context);
					this.removePrefix(prefix, proposal);
					proposals.push(proposal);
				}
			}
			
			if (0 < proposals.length) {
				//sort the proposals by name
				proposals.sort(function(p1, p2) {
					if (p1.name < p2.name) return -1;
					if (p1.name > p2.name) return 1;
					return 0;
				});
				// if any templates were added to the list of 
				// proposals, add a title as the first element
				proposals.splice(0, 0, {
					proposal: '',
					description: 'Templates', //$NON-NLS-0$
					style: 'noemphasis_title', //$NON-NLS-0$
					unselectable: true
				});
			}
			
			return proposals;
		},
		removePrefix: function(prefix, proposal) {
			var overwrite = proposal.overwrite = proposal.proposal.substring(0, prefix.length) !== prefix;
			if (!overwrite) {
				proposal.proposal = chop(prefix, proposal.proposal);
			}
		},
		isValid: function(prefix, buffer, offset, context) {
			return true;
		}
	};
	
	return {
		Template: Template,
		TemplateContentAssist: TemplateContentAssist
	};
});
