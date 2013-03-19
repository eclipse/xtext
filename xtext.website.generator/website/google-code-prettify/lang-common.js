// Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html


/**
 * @fileoverview
 * Registers a language handler for a language.
 *
 * @author Holger Schill
 */

function registerLanguage(keywords, langName) {
	var shortCut = commonLangShortCut();
	var simple = commonLangSimple(keywords);
	PR['registerLangHandler'](
		    PR['createSimpleLexer'](shortCut, simple), [langName]);
		    	 
}

function commonLangShortCut(){
	return [
     // Whitespace
    [PR['PR_PLAIN'],       /^[\t\n\r \xA0]+/, null, '\t\n\r \xA0'],
    [PR['PR_PUNCTUATION'], /^[!#%&()*+,\-:;<=>?@\[\\\]^{|}~]+/, null, '!#%&()*+,-:;<=>?@[\\]^{|}~']
   ];
}
function commonLangSimple(keywords){
   return [
    // A double or single quoted, possibly multi-line, string. ''' excluded for template expressions
    [PR['PR_STRING'],        /^(?:"(?:[^\"\\]|\\.)*"|'(?!\'\')(?:[^\'\\]|\\.)*')/],
    // A symbol literal is a single quote followed by an identifier with no
    // single quote following
    // A character literal has single quotes on either side
    [PR['PR_STRING'],      /^'(?:[^\r\n\\']|\\(?:'|[^\r\n']+))'/],
    [PR['PR_LITERAL'],     /^'[a-zA-Z_$][\w$]*(?!['$\w])/],
    // Include all keywords
    [PR['PR_KEYWORD'],     new RegExp('^(?:' + keywords + ')\\b')],
    [PR['PR_LITERAL'],     /^(?:true|false|null|this|it)\b/],
    [PR['PR_LITERAL'],     /^(?:(?:0(?:[0-7]+|X[0-9A-F]+))L?|(?:(?:0|[1-9][0-9]*)(?:(?:\.[0-9]+)?(?:E[+\-]?[0-9]+)?F?|L?))|\\.[0-9]+(?:E[+\-]?[0-9]+)?F?)/i],
    // Treat upper camel case identifiers as types.
    [PR['PR_TYPE'],        /^[$_]*[A-Z][_$A-Z0-9]*[a-z][\w$]*/],
    [PR['PR_PLAIN'],       /^[$a-zA-Z_][\w$]*/],
    [PR['PR_COMMENT'],     /^\/(?:\/.*|\*(?:\/|\**[^*/])*(?:\*+\/?)?)/],
    [PR['PR_PUNCTUATION'], /^(?:\.+|\/)/],
    // Template expressions
    [PR['PR_STRING'], /^((\'\'\'|\u00BB)([\s\S]*?)(\'\'\'|\u00AB))/]
   ];
}
