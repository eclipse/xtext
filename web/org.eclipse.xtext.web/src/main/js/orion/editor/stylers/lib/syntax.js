/*******************************************************************************
 * @license
 * Copyright (c) 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html). 
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ******************************************************************************/

/*eslint-env browser, amd*/
define("orion/editor/stylers/lib/syntax", [], function() { //$NON-NLS-0$
	return {
		id: "orion.lib", //$NON-NLS-0$
		grammars: [{
			id: "orion.lib", //$NON-NLS-0$
			repository: {
				brace_open: {
					match: "{", //$NON-NLS-0$
					name: "punctuation.section.block.begin" //$NON-NLS-0$
				},
				brace_close: {
					match: "}", //$NON-NLS-0$
					name: "punctuation.section.block.end" //$NON-NLS-0$
				},
				bracket_open: {
					match: "\\[", //$NON-NLS-0$
					name: "punctuation.section.bracket.begin" //$NON-NLS-0$
				},
				bracket_close: {
					match: "\\]", //$NON-NLS-0$
					name: "punctuation.section.bracket.end" //$NON-NLS-0$
				},
				parenthesis_open: {
					match: "\\(", //$NON-NLS-0$
					name: "punctuation.section.parens.begin" //$NON-NLS-0$
				},
				parenthesis_close: {
					match: "\\)", //$NON-NLS-0$
					name: "punctuation.section.parens.end" //$NON-NLS-0$
				},
				operator: {
					match: "(\\+|-|!|=|>|<|&|(\\|\\|))+", //$NON-NLS-0$
					name: "punctuation.operator" //$NON-NLS-0$
				},
				doc_block: {
					begin: {match: "/\\*\\*", literal: "/**"}, //$NON-NLS-1$ //$NON-NLS-0$
					end: {match: "\\*/", literal: "*/"}, //$NON-NLS-1$ //$NON-NLS-0$
					name: "comment.block.documentation", //$NON-NLS-0$
					patterns: [
						{
							match: "@(?:(?!\\*/)\\S)*", //$NON-NLS-0$
							name: "meta.documentation.annotation" //$NON-NLS-0$
						}, {
							match: "<[^\\s>]*>", //$NON-NLS-0$
							name: "meta.documentation.tag" //$NON-NLS-0$
						}, {
							match: "(\\b)(TODO)(\\b)(((?!\\*/).)*)", //$NON-NLS-0$
							name: "meta.annotation.task.todo", //$NON-NLS-0$
							captures: {
								2: {name: "keyword.other.documentation.task"}, //$NON-NLS-0$
								4: {name: "comment.block"} //$NON-NLS-0$
							}
						}
					]
				},
				number_decimal: {
					match: "\\b-?(?:\\.\\d+|\\d+\\.?\\d*)(?:[eE][+-]?\\d+)?\\b", //$NON-NLS-0$
					name: "constant.numeric.number" //$NON-NLS-0$
				},
				number_hex: {
					match: "\\b0[xX][0-9A-Fa-f]+\\b", //$NON-NLS-0$
					name: "constant.numeric.hex" //$NON-NLS-0$
				},
				string_doubleQuote: {
					match: '"(?:\\\\.|[^"])*"?', //$NON-NLS-0$
					name: "string.quoted.double" //$NON-NLS-0$
				},
				string_singleQuote: {
					match: "'(?:\\\\.|[^'])*'?", //$NON-NLS-0$
					name: "string.quoted.single" //$NON-NLS-0$
				},
				todo_comment_singleLine: {
					match: "(\\b)(TODO)(\\b)(.*)", //$NON-NLS-0$
					name: "meta.annotation.task.todo", //$NON-NLS-0$
					captures: {
						2: {name: "keyword.other.documentation.task"}, //$NON-NLS-0$
						4: {name: "comment.line"} //$NON-NLS-0$
					}
				}
			}
		}, {
			id: "orion.c-like", //$NON-NLS-0$
			repository: {
				comment_singleLine: {
					match: {match: "//.*", literal: "//"}, //$NON-NLS-1$ //$NON-NLS-0$
					name: "comment.line.double-slash", //$NON-NLS-0$
					patterns: [
						{
							include: "orion.lib#todo_comment_singleLine" //$NON-NLS-0$
						}
					]
				},
				comment_block: {
					begin: {match: "/\\*", literal: "/*"}, //$NON-NLS-1$ //$NON-NLS-0$
					end: {match: "\\*/", literal: "*/"}, //$NON-NLS-1$ //$NON-NLS-0$ 
					name: "comment.block", //$NON-NLS-0$
					patterns: [
						{
							match: "(\\b)(TODO)(\\b)(((?!\\*/).)*)", //$NON-NLS-0$
							name: "meta.annotation.task.todo", //$NON-NLS-0$
							captures: {
								2: {name: "keyword.other.documentation.task"}, //$NON-NLS-0$
								4: {name: "comment.block"} //$NON-NLS-0$
							}
						}
					]
				}
			}
		}],
		keywords: []
	};
});
