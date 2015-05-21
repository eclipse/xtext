({
	baseUrl: ".",
	name: "xtext/xtext",
	paths: {
		"jquery": "empty:",
		"text": "../../../build/tmp/js/requirejs-plugins/text",
		"i18n": "../../../build/tmp/js/requirejs-plugins/i18n"
	},
	include: [ "orion/editor/stylers/lib/syntax" ],
	exclude: [ "jquery", "text" ]
})