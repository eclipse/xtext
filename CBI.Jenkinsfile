pipeline {
  agent {
    kubernetes {
      label 'xtext-build-pod'
      defaultContainer 'jnlp'
      yaml '''
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: jnlp
    image: 'eclipsecbi/jenkins-jnlp-agent'
    args: ['\$(JENKINS_SECRET)', '\$(JENKINS_NAME)']
    volumeMounts:
    - mountPath: /home/jenkins/.ssh
      name: volume-known-hosts
  - name: xtext-buildenv
    image: docker.io/smoht/xtext-buildenv:0.7
    tty: true
    resources:
      limits:
        memory: "2Gi"
        cpu: "1"
      requests:
        memory: "2Gi"
        cpu: "1"
    volumeMounts:
    - name: volume-known-hosts
      mountPath: /home/jenkins/.ssh
  volumes:
  - name: volume-known-hosts
    configMap:
      name: known-hosts
    '''
    }
  }
  
  options {
    buildDiscarder(logRotator(numToKeepStr:'3'))
    disableConcurrentBuilds()
    timeout(time: 30, unit: 'MINUTES')
  }
  
  stages {
    stage ('Checkout') {
      steps {
          sshagent(['29d79994-c415-4a38-9ab4-7463971ba682']) { // 
            sh '''
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
        container('xtext-buildenv') {
        echo 'Building..'
        dir ('git-repo/xtext-website') {
          sh '''
            # generate things in _site
            bundle exec jekyll build
          '''
        }
        dir ('git-repo/xtend-website') {
          sh '''
            # generate things in _site
            bundle exec jekyll build
          '''
        }
        }
      }
    }
    stage('Commit changes') {
      steps {
        dir ('deploy-xtext-git-repo') {
          sh '''
            git config user.name "genie-xtext"
            git config user.email "xtext-bot@eclipse.org"
            cp -r $WORKSPACE/git-repo/xtext-website/_site/* .
            git diff
            git add --all :/ && git commit -m "Generated from commit: https://github.com/eclipse/xtext/commit/$GIT_COMMIT"
            git status
          '''
        }
        dir ('deploy-xtend-git-repo') {
          sh '''
            git config user.name "genie-xtext"
            git config user.email "xtext-bot@eclipse.org"
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