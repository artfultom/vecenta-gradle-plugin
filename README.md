# vecenta-gradle-plugin

https://plugins.gradle.org/plugin/io.github.artfultom.vecenta-gradle-plugin

## Install
```
plugins {
  id "io.github.artfultom.vecenta-gradle-plugin" version "0.0.7"
}
```

## Generate

```
generate {
    clientPackage = 'test.client'
    serverPackage = 'test.server'
    exceptionPackage = 'test.exception'
    modelPackage = 'test.model'
    schemaDir = ''
    targetDir = "$projectDir/src/main/java/"
}
```
