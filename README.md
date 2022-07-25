# vecenta-gradle-plugin

## Install
```
plugins {
    id 'vecenta-plugin' version '0.0.4'
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
