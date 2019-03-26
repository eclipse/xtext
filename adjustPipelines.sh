#!/bin/bash

toDir() {
	echo $1 | tr -d '\r'
}

name() {
	git --git-dir "$(echo "$1"  | tr -d '\r' | tr -d '\n')/.git" config --get remote.origin.url | sed 's/^.*\/\(xtext-[^\./]*\).*$/\1/'
}

branchname=${1:-master}

escaped() {
	echo $branchname | sed 's/\//%252F/g'
}

escapedBranch=$(escaped)

isBranch() {
	git show-branch "$branchname" &> /dev/null
}

isMaster() {
	test $branchname = master
}

changeDir() {
	pushd $1 > /dev/null
}

dropDir() {
	popd > /dev/null
}

sed_inplace() {
	if [[ "$OSTYPE" == "darwin"* ]]; then
		sed -i '' "$@"
	else
		sed -i "$@" 
	fi	
}

if [[ -z "${JENKINS_URL}" ]]; then
	JENKINS_URL="https://services.typefox.io/open-source/jenkins"
fi
echo "JENKINS_URL=$JENKINS_URL"

./allDirectories | while read -r line
do
	directory=$(toDir $line)
	targets=$(echo $directory/releng/*.target)
	if [[ -d $targets ]]
	then
		changeDir $directory
		if isBranch
		then
			echo "Redirecting target platforms in $targets to $branchname"
			dropDir
			./allDirectories | while read -r repo
			do
				repository=$(toDir $repo)
				if [[ $directory != $repository ]]
				then
					logicalname=$(name $repo)
					if changeDir $repository
					then
						sed_inplace "s?<repository location=\".*/job/$logicalname/job/[^/]*/?<repository location=\"$JENKINS_URL/job/$logicalname/job/$escapedBranch/?" $targets/*.target
						dropDir
					fi
				fi
			done
		else
			dropDir
		fi
	fi	
	if [[ -d $directory ]]
	then
		changeDir $directory
		if isBranch
		then
			dropDir
			find $directory -name pom.xml -type f -path '*.maven.parent/*' -print -o -name pom.xml -type f -path '*.maven.plugin/src/test/resources/it/generate/pom.xml' -print -o -type f -path '*/releng/pom.xml' -print | while read -r pom
			do
				echo "Redirecting parent pom.xml files in $pom to $branchname"
				./allDirectories | while read -r repo
				do
					repository=$(toDir $repo)
					if [[ $directory != $repository ]]
					then
						logicalname=$(name $repo)
						if changeDir $repository
						then
							sed_inplace "s?<upstreamBranch>.*</upstreamBranch>?<upstreamBranch>$escapedBranch</upstreamBranch>?" $pom
							dropDir
						fi
					fi
				done
			done
		else
			dropDir
		fi
	fi
done 
