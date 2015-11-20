define([], function() {
	var keywords = "and|end|goto|if|input|output|set|signal|state";
	return {
		id: "xtext.statemachine",
		contentTypes: ["xtext/statemachine"],
		patterns: [
			{include: "orion.c-like#comment_singleLine"},
			{include: "orion.c-like#comment_block"},
			{include: "orion.lib#string_doubleQuote"},
			{include: "orion.lib#string_singleQuote"},
			{include: "orion.lib#number_decimal"},
			{name: "keyword.statemachine", match: "\\b(?:" + keywords + ")\\b"}
		]
	};
});
