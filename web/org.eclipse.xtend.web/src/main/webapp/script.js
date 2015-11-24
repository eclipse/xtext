
var baseUrl = window.location.pathname;
var fileIndex = baseUrl.indexOf("index.html");
if (fileIndex > 0)
	baseUrl = baseUrl.slice(0, fileIndex);
require.config({
	baseUrl : baseUrl,
	paths : {
		"jquery" : "webjars/jquery/2.1.4/jquery.min",
		"ace/ext/language_tools" : "webjars/ace/1.2.0/src/ext-language_tools",
		"xtext/xtext-ace" : "xtext/2.9.0-SNAPSHOT/xtext-ace"
	}
});
require([ "webjars/ace/1.2.0/src/ace" ], function() {
	require([ "xtext/xtext-ace" ], function(xtext) {
		//xtend editor
		editor = xtext.createEditor({
			baseUrl : baseUrl,
			syntaxDefinition : "xtext-resources/generated/mode-xtend"
		});
		//active annotation editor
		editor2 = xtext.createEditor({
			baseUrl : baseUrl,
			syntaxDefinition : "xtext-resources/generated/mode-xtend",
			parent : 'annotation-editor'
		});
		
		// auto-edit key binding
		HashHandler = require("ace/keyboard/hash_handler").HashHandler
		var parenthesis = new HashHandler([ {
			bindKey : "(",
			exec : function(e) {
				var position = editor.getCursorPosition();
				editor.insert("()");
				editor.moveCursorTo(position.row, position.column + 1);
			}
		} ]);
		var bracket = new HashHandler([ {
			bindKey : "[",
			exec : function(e) {
				var position = editor.getCursorPosition();
				editor.insert("[]");
				editor.moveCursorTo(position.row, position.column + 1);
			}
		} ]);
		// accolade behavior could be improved like Java( after user input 'enter', then add the closing accolade) 
		var accolade = new HashHandler([ {
			bindKey : "{",
			exec : function(e) {
				var position = editor.getCursorPosition();
				editor.insert("{}");
				editor.moveCursorTo(position.row, position.column + 1);
			}
		} ]);
		var quotes = new HashHandler([ {
			bindKey : "\"",
			exec : function(e) {
				var position = editor.getCursorPosition();
				editor.insert("\"\"");
				editor.moveCursorTo(position.row, position.column + 1);
			}
		} ]);
		var single_quotes = new HashHandler([ {
			bindKey : "\'",
			exec : function(e) {
				var position = editor.getCursorPosition();
				editor.insert("\'\'");
				editor.moveCursorTo(position.row, position.column + 1);
			}
		} ]);
		editor.keyBinding.addKeyboardHandler(parenthesis);
		editor.keyBinding.addKeyboardHandler(bracket);
		editor.keyBinding.addKeyboardHandler(accolade);
		editor.keyBinding.addKeyboardHandler(quotes);
		editor.keyBinding.addKeyboardHandler(single_quotes);
		// change colors for the direction buttons 
		editor.on('focus', function() {
			document.getElementById("generate-java").style.color = "#0000FF";
			document.getElementById("generate-xtend").style.color = "#808080";
		});
		// aceEditor-->the java editor in the right side.
		aceEditor = ace.edit("java-editor");
		aceEditor.getSession().setMode("ace/mode/java");
		aceEditor.$blockScrolling = Infinity;
		aceEditor.on('focus', function() {
			document.getElementById("generate-xtend").style.color = "#0000FF";
			document.getElementById("generate-java").style.color = "#808080";
		});
		// perhaps we can call the generation function only when the java code is valid 
		// in this case we may improve the performance, but we need a java validator. 
		aceEditor.getSession().on('change', function(e) {
			if (aceEditor.isFocused()) {
				Java2Xtend();
			}
		});

		editor.xtextServices.successListeners.push(function(serviceType, result) {
			if (serviceType == 'validate'&& result.issues.every(function(issue) {issue.severity != 'error'}) && editor.isFocused()) {
				generateJava();
			}
		});
	});
});

//btn1--> the button for resizing the xtend editor 
function btn1Action(btn){
	var currentEditor = document.getElementById("xtext-editor");
	var changedEditor = document.getElementById("annotation-editor");
	var changedBtn = document.getElementById("btn2");
	if (btn.textContent =="-"){
		btn.textContent = "+";
		//currentEditor.style.display = "none";
		currentEditor.style.height = "8px";
		changedEditor.style.top = "80px";
		changedBtn.style.top = "80px";
		changedBtn.disabled = true;
	}
	else if (btn.textContent =="+"){
		btn.textContent = "-";
		changedEditor.style.top = "60%";
		changedBtn.style.top = "60%";
		//currentEditor.style.display = "block";
		currentEditor.style.height = "45%";
		changedBtn.disabled = false;
	}
}

//btn2--> the button for resizing the active annotation editor
function btn2Action(btn){
	var currentEditor = document.getElementById("annotation-editor");
	var changedEditor = document.getElementById("xtext-editor");
	if (btn.textContent =="-"){
		btn.textContent = "+";
		//currentEditor.style.display = "none";
		currentEditor.style.top = "95%";
		btn.style.top = "95%";
		changedEditor.style.height = "auto";
		changedEditor.style.bottom = "6%";
		document.getElementById("btn1").disabled = true;
	}
	else if (btn.textContent =="+"){
		changedEditor.style.bottom = "auto";
		changedEditor.style.height = "45%";
		btn.textContent = "-";
		//currentEditor.style.display = "block";
		currentEditor.style.top = "60%";
		btn.style.top = "60%";
		document.getElementById("btn1").disabled = false;
	}
}

// When a xtend file contains several classes, it will generate more than one java class. 
// javaFileList --> a map that has generated java class name as key and the corresponding content as value.
// old_java_selectItem --> old select item for the right side combobox 
var javaFileList = {};
var old_java_selectItem;
function generateJava() {
	editor.xtextServices.generate().done(function(generateResult) {
		javaFileList = {};
		var comboBox = document.getElementById("javaFileList");
		while(comboBox.options.length > 0){                
		    comboBox.remove(0);
		}
		// when xtend file contains only one class
		if (generateResult.documents == null){
			var simpleName =document.getElementById("exampleList").value+".java";
			var option = document.createElement("option");
			option.value=simpleName;
			option.innerHTML=simpleName;
			comboBox.appendChild(option);
			aceEditor.getSession().setValue(generateResult);
			return;
		}
		//when xtend file contains more than one class.
		for (var i = 0; i< generateResult.documents.length;i++){
			var doc = generateResult.documents[i];
			var simpleName = doc.name.split("/").pop();
			javaFileList[simpleName] = doc.content;
			var option = document.createElement("option");
			 option.value=simpleName;
			 option.innerHTML=simpleName;
			 comboBox.appendChild(option); 			
		}
		old_java_selectItem = comboBox.value;
		aceEditor.getSession().setValue(javaFileList[comboBox.value]);
	});
}
//when user change the item of the right side comboBox
function changeJavaFile() {
	var comboBox = document.getElementById("javaFileList");
	javaFileList[old_java_selectItem] = aceEditor.getSession().getValue();
	aceEditor.getSession().setValue(javaFileList[comboBox.value]);
	old_java_selectItem = comboBox.value;
}

function Java2Xtend() {
	var sendmsg = 'srcJava=' + encodeURIComponent(aceEditor.getSession().getValue());
	if (sendmsg == 'srcJava=') {
		// alert("Please make sure the java code is not empty");
		return;
	}
	var xmlhttp = new XMLHttpRequest();
	var url = 'http://' + location.host + '/xtext-service/java2xtend?resource=java.xtend';
	xmlhttp.open("POST", url, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var target = JSON.parse(xmlhttp.responseText);
			if (target.stateID == 1) {//the generated code is not null
				editor.getSession().setValue(target.generateText);
			}
		}
	}
	xmlhttp.send(sendmsg);
}

var old_resourceIndex = 0

//Adapting the display when select an example without active annotation.
function oneEditorMode(){
	var currentEditor = document.getElementById("xtext-editor");
	var changedEditor = document.getElementById("annotation-editor");
	var btn = document.getElementById("btn1");
	var changedBtn = document.getElementById("btn2");
	changedEditor.style.display = "none";
	btn.style.display = "none";
	changedBtn.style.display = "none";
	currentEditor.style.display = "block";
	currentEditor.style.height = "auto";
	currentEditor.style.bottom = "0";
}
//Adapting the display when select an example with active annotation
function twoEditorMode(){
	var currentEditor = document.getElementById("xtext-editor");
	var changedEditor = document.getElementById("annotation-editor");
	var btn = document.getElementById("btn1");
	var changedBtn = document.getElementById("btn2");
	changedEditor.style.display = "block";
	changedEditor.style.top = "60%";
	btn.style.display = "block";
	btn.textContent = "-";
	changedBtn.style.display = "block";
	changedBtn.textContent = "-";
	changedBtn.style.top = "60%";
	currentEditor.style.display = "block";
	currentEditor.style.bottom = "auto";
	currentEditor.style.height = "45%";
}
//after changing the xtend example
function changeExample() {
	var resourceId = "helloWorld.xtend";
	var annotationResourceId = "helloWorld.xtend";
	switch (document.getElementById("exampleList").selectedIndex) {
	case 0:
		resourceId = "helloWorld.xtend";
		break;
	case 1:
		resourceId = "BasicExpressions.xtend";
		break;
	case 2:
		resourceId = "BottleSong.xtend";
		break;
	case 3:
		resourceId = "HtmlBuilder.xtend";
		break;
	case 4:
		resourceId = "Movies.xtend";
		break;
	case 5:
		resourceId = "Observable.xtend";
		annotationResourceId = "ObservableExample.xtend";
		break;
	case 6:
		resourceId = "Extract.xtend";
		annotationResourceId = "ExtractExample.xtend";
		break;
	case 7:
		resourceId = "Externalized.xtend";
		annotationResourceId = "ExternalizedExample.xtend";
		break;
	case 8:
		resourceId = "Lazy.xtend";
		annotationResourceId = "LazyExample.xtend";
		break;
	}
	
	if (document.getElementById("exampleList").selectedIndex<5){
		if (old_resourceIndex>4){
			oneEditorMode();
		}
		loadResourceById(editor, resourceId);
	}
	else{
		if (old_resourceIndex<5){
			twoEditorMode();
		}
		loadActiveAnnotationExample(resourceId,annotationResourceId);
	}
	old_resourceIndex = document.getElementById("exampleList").selectedIndex;
}

function loadResourceById(editor,resourceId){
	resetResourceId(resourceId,editor);
	editor.xtextServices.loadResourceService.setState("strated");
	editor.xtextServices.loadResource();
}
function loadActiveAnnotationExample(annotationResourceId,exampleResourceId){
	loadResourceById(editor, exampleResourceId);
	loadResourceById(editor2, annotationResourceId);
}

function resetResourceId(resourceId,editor) {
	editor.xtextServices.options.resourceId = resourceId;
	editor.xtextServices.loadResourceService._encodedResourceId = resourceId;
	editor.xtextServices.saveResourceService._encodedResourceId = resourceId;
	editor.xtextServices.contentAssistService._encodedResourceId = resourceId;
	editor.xtextServices.formattingService._encodedResourceId = resourceId;
	editor.xtextServices.generatorService._encodedResourceId = resourceId;
	editor.xtextServices.occurrencesService._encodedResourceId = resourceId;
	editor.xtextServices.revertResourceService._encodedResourceId = resourceId;
	editor.xtextServices.updateService._encodedResourceId = resourceId;
	editor.xtextServices.validationService._encodedResourceId = resourceId;
}
