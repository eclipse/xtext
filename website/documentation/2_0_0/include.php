<?php

# Set the theme for your project's web pages.
# See the Committer Tools "How Do I" for list of themes
# https://dev.eclipse.org/committers/
# Optional: defaults to system theme 
$theme = "Nova";

# Define your project-wide Nav bars here.
# Format is Link text, link URL (can be http://www.someothersite.com/), target (_self, _blank), level (1, 2 or 3)
# these are optional
# $Nav->setLinkList(array());

$pageKeywords	= "xtext, dsl, modeling, domain specific language, textual";
$pageTitle 		= "Xtext Documentation";

$Menu->setMenuItemList(array());
$Menu->addMenuItem("Home", "/Xtext", "_self");
$Menu->addMenuItem("Download", "/Xtext/download", "_self");
$Menu->addMenuItem("Documentation", "/Xtext/documentation", "_self");
$Menu->addMenuItem("Support", "/Xtext/support", "_self");
$Menu->addMenuItem("Community", "/Xtext/community", "_self");
$Menu->addMenuItem("Developers", "/Xtext/developers", "_self");

$App->AddExtraHtmlHeader('<link rel="stylesheet" type="text/css" href="/Xtext/style.css"/>' . "\n\t");
$App->AddExtraHtmlHeader('<link rel="stylesheet" type="text/css" href="/Xtext/style2.css"/>' . "\n\t");
$App->AddExtraHtmlHeader('<link rel="stylesheet" type="text/css" href="code.css"/>' . "\n\t");
$App->AddExtraHtmlHeader('<link rel="stylesheet" type="text/css" href="book.css"/>' . "\n\t");
$App->AddExtraHtmlHeader('<link rel="stylesheet" type="text/css" href="novaAddon.css"/>' . "\n\t");

$App->Promotion = TRUE;
?>
