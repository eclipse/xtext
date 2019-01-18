pipeline {
  agent any

  stages {
    stage ('Checkout') {
      steps {
          sshagent(['29d79994-c415-4a38-9ab4-7463971ba682']) { // 
            sh '''
              git config user.name "genie-xtext"
              git config user.email "xtext-bot@eclipse.org"
              rm -rf deploy-xtext-git-repo
              rm -rf deploy-xtend-git-repo
              git clone -b master ssh://genie.xtext@git.eclipse.org:29418/www.eclipse.org/Xtext deploy-xtext-git-repo
              git clone -b master ssh://genie.xtext@git.eclipse.org:29418/www.eclipse.org/xtend deploy-xtend-git-repo
            '''
          }
      }
    }
    stage('Generate site') {
      steps {
        echo 'Building..'
        dir ('git-repo/xtext-website') {
          sh '''
            # generate things in _site
            ~/.rvm/gems/ruby-2.2.0/wrappers/jekyll build
          '''
        }
        dir ('git-repo/xtend-website') {
          sh '''
            # generate things in _site
            ~/.rvm/gems/ruby-2.2.0/wrappers/jekyll build
          '''
        }
      }
    }
    stage('Commit changes') {
      steps {
        dir ('deploy-xtext-git-repo') {
          sh '''
            cp -r $WORKSPACE/git-repo/xtext-website/_site/* .
            git diff
            git add --all :/ && git commit -m "Generated from commit: https://github.com/eclipse/xtext/commit/$GIT_COMMIT"
            git status
          '''
        }
        dir ('deploy-xtend-git-repo') {
          sh '''
            cp -r $WORKSPACE/git-repo/xtend-website/_site/* .
            git diff
            git add --all :/ && git commit -m "Generated from commit: https://github.com/eclipse/xtext/commit/$GIT_COMMIT"
            git status
          '''
        }
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deploying....'
        dir ('deploy-xtext-git-repo') {
          sshagent(['29d79994-c415-4a38-9ab4-7463971ba682']) { // 
            sh '''
              git push origin master
            '''
          }
        }
        dir ('deploy-xtend-git-repo') {
          sshagent(['29d79994-c415-4a38-9ab4-7463971ba682']) { // 
            sh '''
              git push origin master
            '''
          }
        }
      }
    }
  }
}