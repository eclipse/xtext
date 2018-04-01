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

if [[ "$OSTYPE" == "darwin"* ]]; then
	sed_inplace="sed -i ''"
else
	sed_inplace="sed -i"
fi

./allDirectories | while read -r line
do
	directory=$(toDir $line)
	upstream=$(echo $directory/gradle/upstream-repositories.gradle)
	if [[ -e $upstream ]]
	then
		changeDir $directory
		if isBranch
		then
			echo "Redirecting maven repositories in $upstream to $branchname"
			dropDir
			./allDirectories | while read -r repo
			do
				repository=$(toDir $repo)
				if [[ $directory != $repository ]]
				then
					logicalname=$(name $repo)
					if changeDir $repository
					then
						$sed_inplace "s?'http://services.typefox.io/open-source/jenkins/job/$logicalname/job/[^/]*/lastSuccessfulBuild/artifact/build/maven-repository/'?jenkinsPipelineRepo('$logicalname')?" $upstream
						isMaster ||	( isBranch && $sed_inplace "s?jenkinsPipelineRepo('$logicalname')?'http://services.typefox.io/open-source/jenkins/job/$logicalname/job/$escapedBranch/lastSuccessfulBuild/artifact/build/maven-repository/'?" $upstream )
						dropDir
					fi
				fi
			done
		else
			dropDir
		fi
	fi
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
						$sed_inplace "s?http://services.typefox.io/open-source/jenkins/job/$logicalname/job/[^/]*/lastStableBuild/artifact/build/p2-repository/?http://services.typefox.io/open-source/jenkins/job/$logicalname/job/master/lastStableBuild/artifact/build/p2-repository/?" $targets/*.target
						isMaster ||	( isBranch && $sed_inplace "s?http://services.typefox.io/open-source/jenkins/job/$logicalname/job/master/lastStableBuild/artifact/build/p2-repository/?http://services.typefox.io/open-source/jenkins/job/$logicalname/job/$escapedBranch/lastStableBuild/artifact/build/p2-repository/?" $targets/*.target )
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
			find $directory -name pom.xml -type f -path '*.maven.parent/*' -print | while read -r pom
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
							$sed_inplace "s?http://services.typefox.io/open-source/jenkins/job/$logicalname/job/[^/]*/lastStableBuild/artifact/build/maven-repository/?http://services.typefox.io/open-source/jenkins/job/$logicalname/job/\${branch_url_segment}/lastStableBuild/artifact/build/maven-repository/?" $pom
							isMaster ||	( isBranch && $sed_inplace "s?http://services.typefox.io/open-source/jenkins/job/$logicalname/job/\${branch_url_segment}/lastStableBuild/artifact/build/maven-repository/?http://services.typefox.io/open-source/jenkins/job/$logicalname/job/$escapedBranch/lastStableBuild/artifact/build/maven-repository/?" $pom )
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
