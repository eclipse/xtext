define(["codemirror", "codemirror/addon/mode/simple"], function(CodeMirror, SimpleMode) {
	var keywords = "as|case|catch|default|do|else|entity|extends|extension|false|finally|for|if|import|instanceof|new|null|op|package|return|static|super|switch|synchronized|throw|true|try|typeof|val|var|while";
	CodeMirror.defineSimpleMode("xtext/entities", {
		start: [
			{token: "comment", regex: "\\/\\/.*$"},
			{token: "comment", regex: "\\/\\*", next : "comment"},
			{token: "string", regex: '["](?:(?:\\\\.)|(?:[^"\\\\]))*?["]'},
			{token: "string", regex: "['](?:(?:\\\\.)|(?:[^'\\\\]))*?[']"},
			{token: "constant.numeric", regex: "[+-]?\\d+(?:(?:\\.\\d*)?(?:[eE][+-]?\\d+)?)?\\b"},
			{token: "constant.numeric", regex: "0[xX][0-9a-fA-F]+\\b"},
			{token: "lparen", regex: "[\\[({]"},
			{token: "rparen", regex: "[\\])}]"},
			{token: "keyword", regex: "\\b(?:" + keywords + ")\\b"}
		],
		comment: [
			{token: "comment", regex: ".*?\\*\\/", next : "start"},
			{token: "comment", regex: ".+"}
		],
		meta: {
			dontIndentStates: ["comment"],
			lineComment: "//"
		}
	});
});
