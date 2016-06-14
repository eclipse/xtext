define([], function() {
	var keywords = "as|case|catch|default|do|else|entity|extends|extension|false|finally|for|if|import|instanceof|new|null|op|package|return|static|super|switch|synchronized|throw|true|try|typeof|val|var|while";
	return {
		id: "xtext.entities",
		contentTypes: ["xtext/entities"],
		patterns: [
			{include: "orion.c-like#comment_singleLine"},
			{include: "orion.c-like#comment_block"},
			{include: "orion.lib#string_doubleQuote"},
			{include: "orion.lib#string_singleQuote"},
			{include: "orion.lib#number_decimal"},
			{include: "orion.lib#number_hex"},
			{include: "orion.lib#brace_open"},
			{include: "orion.lib#brace_close"},
			{include: "orion.lib#bracket_open"},
			{include: "orion.lib#bracket_close"},
			{include: "orion.lib#parenthesis_open"},
			{include: "orion.lib#parenthesis_close"},
			{name: "keyword.entities", match: "\\b(?:" + keywords + ")\\b"}
		]
	};
});
