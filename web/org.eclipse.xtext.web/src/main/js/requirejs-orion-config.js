({
	baseUrl: ".",
	name: "xtext/xtext-orion",
	paths: {
		"jquery": "empty:",
		"text": "../../../build/tmp/js/requirejs-plugins/text",
		"i18n": "../../../build/tmp/js/requirejs-plugins/i18n",
		"webtools/cssContentAssist": "orion/webtools/cssContentAssist",
		"webtools/htmlContentAssist": "orion/webtools/htmlContentAssist",
		"webtools/util": "orion/webtools/util",
		"javascript/compilationUnit": "orion/javascript/compilationUnit",
		"csslint": "orion/csslint"
	},
	include: [ "orion/editor/stylers/lib/syntax" ],
	exclude: [ "jquery", "text" ]
})