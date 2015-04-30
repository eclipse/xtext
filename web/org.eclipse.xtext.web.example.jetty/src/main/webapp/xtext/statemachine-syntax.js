define("xtext/statemachine-syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) {
	var keywords = [
		"and", "end", "goto", "if", "input", "output", "set", "signal", "state"
	];

	var grammars = [];
	grammars.push.apply(grammars, mLib.grammars);
	grammars.push({
		id: "xtext.statemachine",
		contentTypes: ["xtext/statemachine"],
		patterns: [
			{include: "orion.lib#string_doubleQuote"},
			{include: "orion.lib#string_singleQuote"},
			{include: "orion.c-like#comment_singleLine"},
			{include: "orion.c-like#comment_block"},
			{include: "orion.lib#number_decimal"},
			{
				match: "\\b(?:" + keywords.join("|") + ")\\b",
				name: "keyword.operator.statemachine"
			}
		]
	});

	return {
		id: "xtext.statemachine",
		grammars: grammars,
		keywords: keywords
	};
});
